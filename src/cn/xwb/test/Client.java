package cn.xwb.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.text.*;

public class Client {

    private JButton btnJoin;                // "加入"按钮
    private JButton btnQuit;                // "退出"按钮
    private JButton btnSendImg;             // "发送图片"按钮
    private JButton btnSendMsg;             // "发送消息"按钮
    private JFrame frame;                   // 整体框架
    private JPanel northPanel;              // 顶部画板
    private JPanel southPanel;              // 底部画板
    private JScrollPane centerPanel;        // 中部画板
    private JPanel  sendPanel;              // 发送区
    private JTextPane textContent;          // 会话区
    private JTextField textMessage;         // 消息区
    private JTextField textPort;            // "房间号"文本框
    private JTextField textName;            // "用户名"文本框

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private MessageThread messageThread;    // 客户端负责接收消息的线程

    private Socket fileSocket;
    private DataOutputStream sender;
    private DataInputStream getter;
    private FileThread fileThread;          //客户端负责接收文件的线程

    private boolean isFirst = true;
    private boolean isConnected = false;    // 客户端当前状态

    private Document docs;
    private SimpleAttributeSet normal;      // 常规属性
    private SimpleAttributeSet unnormal;    // 非常规属性

    private String ip = "192.168.43.220";

    public ArrayList<String> roomPort = new ArrayList<>();    // 聊天室集合

    // 构造方法
    public Client() {
        // 初始化多行文本框
        textContent = new JTextPane();
        textContent.setEditable(false);
        textContent.setForeground(Color.blue);
        // 初始化常规属性与非常规属性
        normal = new SimpleAttributeSet();
        unnormal = new SimpleAttributeSet();
        StyleConstants.setFontSize(normal,18);     // 常规属性字体大小
        StyleConstants.setFontSize(unnormal,18);   // 非常规属性字体大小
        StyleConstants.setForeground(unnormal, Color.red);
        docs = textContent.getDocument();             // 获取文本框内信息
        // 初始化单行文本框
        textMessage = new JTextField();
        textPort = new JTextField("6666");            // "房间号"文本框
        textName = new JTextField("刘晨");            // "用户名"文本框
        textPort.setHorizontalAlignment(JTextField.CENTER);
        textName.setHorizontalAlignment(JTextField.CENTER);
        // 初始化相关按钮
        btnJoin = new JButton("加入");           // "加入"按钮
        btnQuit = new JButton("退出");           // "退出"按钮
        btnSendMsg = new JButton("发消息");      // "发消息"按钮
        btnSendImg = new JButton("发图片");      // "发图片"按钮
        btnQuit.setEnabled(false);
        // 初始化顶部画板
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 8));
        // 顶部画板从左到右依次为:
        JLabel labelPort = new JLabel("房间号");
        labelPort.setHorizontalAlignment(JTextField.CENTER);
        northPanel.add(labelPort);                  // "房间号"标签
        northPanel.add(textPort);                   // "房间号"文本框
        JLabel labelID = new JLabel("用户名");
        labelID.setHorizontalAlignment(JTextField.CENTER);
        northPanel.add(labelID);                    // "用户名"标签
        northPanel.add(textName);                   // "用户名"文本框
        northPanel.add(btnJoin);                    // "加入"按钮
        northPanel.add(btnQuit);                    // "退出"按钮
        // 初始化中部画板
        centerPanel = new JScrollPane(textContent);
        // 初始化发送区
        sendPanel = new JPanel(new GridLayout(1, 2));
        // 发送区从左到右依次为:
        sendPanel.add(btnSendImg);                  // "发图片"按钮
        sendPanel.add(btnSendMsg);                  // "发消息"按钮
        // 初始化底部画板
        southPanel = new JPanel(new BorderLayout());
        // 底部画板从左到右依次为:
        southPanel.add(new JLabel(" 写消息 "),"West");    // "写信息"标签
        southPanel.add(textMessage, "Center");                // 消息区
        southPanel.add(sendPanel, "East");                    // 发送区
        // 初始化整体框架
        frame = new JFrame("客户端");
        frame.setLayout(new BorderLayout());
        frame.add(northPanel, "North");
        frame.add(centerPanel,"Center");
        frame.add(southPanel, "South");
        frame.setSize(500, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        /**********************************************************************/
        try {
            socket = new Socket(ip, 1234);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), "/@");
            int size = Integer.parseInt(stringTokenizer.nextToken());
            String temp, room = stringTokenizer.nextToken() + "\n" + stringTokenizer.nextToken() + "\n";
            for(int i = 0; i < size; i++) {
                temp = stringTokenizer.nextToken();
                roomPort.add(new StringTokenizer(temp, "\t").nextToken());
                room = room + temp + "\n";
            }
            append(room, normal);
        } catch (Exception e) {
            e.printStackTrace();
            append("系统提示:获取聊天室信息失败,请检查主界面是否开启!\r\n", unnormal);
        }
        /**********************************************************************/
        // "连接"按钮事件
        // unnormal为系统提示字体格式
        btnJoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*********************************************************/
                // 判断是否为首次连接
                if(isFirst) {    // 若为首次连接,则需要断开客户端与主界面之间的连接
                    try {
                        // 向主界面发送断开命令
                        writer.println("CLOSE");
                        writer.flush();
                        // 释放相应资源
                        if (reader != null) {
                            reader.close();
                        }
                        if (writer != null) {
                            writer.close();
                        }
                        if (socket != null) {
                            socket.close();
                        }
                        // 修改首次连接状态
                        isFirst = false;
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                /*********************************************************/
                // 获取房间号并检验其合法性
                int port;
                try {
                    port = Integer.parseInt(textPort.getText().trim());   //获取房间号
                } catch (NumberFormatException e1) {
                    append("系统提示:客户端连接失败,房间号应为整数!\r\n", unnormal);
                    return;
                } catch (Exception e1){
                    append("系统提示:客户端连接失败,请检查房间号是否输入有误!\n", unnormal);
                    return;
                }
                // 检验是否存在想要连接的房间号
                if(roomPort.contains(String.valueOf(port)) == false) {
                    append("系统提示:输入的房间号不存在,请重新输入!\n", unnormal);
                    return;
                }
                // 获取客户端ID并检验其合法性
                String id = textName.getText().trim();                      // 获取客户端ID
                if (id.equals("")) {
                    append("系统提示:客户端连接失败,客户端ID不能为空!\r\n", unnormal);
                    return;
                }
                // 调用connectServer()函数,建立客户端与服务器之间的连接
                boolean flag = connectServer(port, ip, id);
                if (flag == false) {
                    append("系统提示:客户端连接失败!\r\n", unnormal);
                    return;
                }
                // 改变界面相关组件的状态以保证服务器正常运行
                append("系统提示:您已进入聊天室!\r\n", unnormal);
                btnJoin.setEnabled(false);            // 连接按钮不可点
                btnQuit.setEnabled(true);             // 断开按钮可点
                frame.setTitle(id);                   // 更改窗口标题
            }
        });
        // "断开"按钮事件
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 调用closeConnection()函数,断开客户端与服务器之间的连接
                if(closeConnection() == false) {
                    append("系统提示:客户端断开连接失败!\r\n", unnormal);
                    return;
                }
                // 改变界面相关组件的状态以保证服务器正常运行
                btnJoin.setEnabled(true);             // 连接按钮可点
                btnQuit.setEnabled(false);            // 断开按钮不可点
                append("系统提示:客户端连接已断开!\r\n", unnormal);
            }
        });
        // "发图片"按钮事件
        btnSendImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 检验客户端是否与服务器建立连接
                if (!isConnected) {
                    append("系统提示:尚未连接聊天室,无法发送消息!\r\n", unnormal);
                    return;
                }
                JFileChooser fileChooser = new JFileChooser();                 // 查找文件
                fileChooser.showOpenDialog(null);                       // 打开选择对话框
                File image = fileChooser.getSelectedFile();      // 获取图片
                sendFile(image);
                append("您已发送图片:\r\n",normal);
                try {
                    insertImg(image.getPath());
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
                writer.println( "SENDIMG@" + frame.getTitle() + "@" + image.getName());
                writer.flush();
            }
        });
        // "发消息"按钮事件
        btnSendMsg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 检验客户端是否与服务器建立连接
                if (!isConnected) {
                    append("系统提示:尚未连接聊天室,无法发送消息!\r\n", unnormal);
                    return;
                }
                // 获取消息区中输入的内容并检验其有效性
                String message = textMessage.getText().trim();
                if (message == null || message.equals("")) {
                    append("系统提示:消息不能为空!\r\n", unnormal);
                    return;
                }
                // 判断消息发送的类型
                if(message.equals("USERLIST")) {
                    writer.println("USERLIST");
                    writer.flush();
                }
                else if(message.charAt(0) == '@') {   // 私聊
                    writer.println(frame.getTitle() + message);
                    writer.flush();
                }
                else {                                // 群发
                    writer.println(frame.getTitle() + "@" + "ALL" + "@" + message);
                    writer.flush();
                }
                textMessage.setText(null);            // 清空消息区
            }
        });
        // 消息区回车事件
        textMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 检验客户端是否与服务器建立连接
                if (!isConnected) {
                    append("系统提示:尚未连接聊天室,无法发送消息!\r\n", unnormal);
                    return;
                }
                // 获取消息区中输入的内容并检验其有效性
                String message = textMessage.getText().trim();
                if (message == null || message.equals("")) {
                    append("系统提示:消息不能为空!\r\n", unnormal);
                    return;
                }
                // 判断消息发送的类型
                if(message.equals("USERLIST")) {
                    writer.println("USERLIST");
                    writer.flush();
                }
                else if(message.charAt(0) == '@') {   // 私聊
                    writer.println(frame.getTitle() + message);
                    writer.flush();
                }
                else {                                // 群发
                    writer.println(frame.getTitle() + "@" + "ALL" + "@" + message);
                    writer.flush();
                }
                textMessage.setText(null);            // 清空消息区
            }
        });
        // 关闭窗口事件
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 检验客户端是否与服务器建立连接
                if (isConnected) {    // 已连接
                    try {
                        closeConnection();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                System.exit(0);
            }
        });
    }

    // 显示函数
    public void append(String message, AttributeSet attribute) {
        try {
            docs.insertString(docs.getLength(), message, attribute);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    // 显示图片
    private void insertImg(String address) throws BadLocationException {
        textContent.setCaretPosition(docs.getLength());    // 设置插入位置
        textContent.insertIcon(new ImageIcon(address));    // 插入图片
        docs.insertString(docs.getLength(), "\n", normal);
    }

    //发送文件/图片
    public void sendFile(File file) {
        try {
            String filename = file.getName();
            FileInputStream fis = new FileInputStream(file);
            sender.writeUTF(filename);
            sender.writeLong(file.length());
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = fis.read(buff, 0, buff.length)) > 0) {
                sender.write(buff, 0, length);
                sender.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建文件函数
    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if(file.exists()) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return false;
        }
        //判断目标文件所在的目录是否存在
        if(!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if(!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                return false;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                System.out.println("创建单个文件" + destFileName + "成功！");
                return true;
            } else {
                System.out.println("创建单个文件" + destFileName + "失败！");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
            return false;
        }
    }

    // 连接服务器
    public boolean connectServer(int port, String ip, String id) {
        try {
            // 根据服务器IP和端口号建立客户端与服务器之间连接
            socket = new Socket(ip, port);
            fileSocket = new Socket(ip,port + 1);
            // 初始化输入流及输出流
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sender = new DataOutputStream(fileSocket.getOutputStream());
            getter = new DataInputStream(fileSocket.getInputStream());

            // 向服务器发送客户端的基本信息(ID及IP地址)
            writer.println(id + "@" + socket.getLocalAddress().toString());    // 基本信息格式:ID@IP
            writer.flush();

            //向文件服务器发送客户端的基本信息(ID及IP地址)
            sender.writeUTF(id + "@" + fileSocket.getLocalAddress().toString());    // 基本信息格式:ID@IP
            sender.flush();

            // 开启接收消息的线程
            messageThread = new MessageThread(reader, textContent);
            messageThread.start();

            //开启发送文件的线程
            fileThread = new FileThread(sender,getter);
            fileThread.start();

            // 修改客户端连接状态
            isConnected = true;   // 连接成功
            return true;
        } catch (Exception e) {
            isConnected = false;  //连接失败
            return false;
        }
    }

    // 主动断开连接
    @SuppressWarnings("deprecation")        //屏蔽使用的过时废弃的类和方法的警告
    public synchronized boolean closeConnection() {
        try {
            // 向服务器发送断开命令
            writer.println("CLOSE");
            writer.flush();

            sender.writeUTF("CLOSE");
            sender.flush();
            // 停止接受消息的线程
            messageThread.stop();
            fileThread.stop();
            // 释放相应资源
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                socket.close();
            }

            if (sender != null) {
                sender.close();
            }
            if (getter != null) {
                getter.close();
            }
            if (fileSocket != null) {
                fileSocket.close();
            }
            // 修改客户端连接状态
            isConnected = false;
            return true;
        } catch (Exception e) {
            isConnected = true;
            return false;
        }
    }
    //接受文件线程
    class FileThread extends Thread{
        DataOutputStream sender;
        DataInputStream getter;

        public FileThread(DataOutputStream sender,DataInputStream getter){
            this.getter = getter;
            this.sender = sender;
        }

        public synchronized void closeConnection() throws Exception {
            // 释放相应资源
            if (sender != null) {
                sender.close();
            }
            if (getter != null) {
                getter.close();
            }
            if (fileSocket != null) {
                fileSocket.close();
            }
        }

        @Override
        public void run() {
            while (true){
                try {
                    String info = getter.readUTF();
                    if (info.equals("CLOSE")){
                        this.closeConnection();
                        return;
                    }else {
                        long filelength = getter.readLong();
                        String file = "file/"+frame.getTitle()+"/"+info;
                        createFile(file);
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] buff = new byte[1024];
                        int length = 0, total = 0;
                        while (total < filelength) {
                            length = getter.read(buff);
                            total += length;
                            fos.write(buff, 0, length);
                            fos.flush();
                        }
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 接收消息线程
    class MessageThread extends Thread {
        private BufferedReader reader;
        private JTextPane textContent;
        // 构造方法
        public MessageThread(BufferedReader reader, JTextPane textContent) {
            this.reader = reader;
            this.textContent = textContent;
        }
        // 被动断开连接
        public synchronized void closeConnection() throws Exception {
            // 释放相应资源
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                socket.close();
            }
            // 修改客户端连接状态
            isConnected = false;
            btnJoin.setEnabled(true);                 // 连接按钮可点
            btnQuit.setEnabled(false);                // 断开按钮不可点
        }
        //
        public void run() {
            String message;
            while (true) {
                try {
                    // 分割字符串获得服务器信息
                    message = reader.readLine();
                    StringTokenizer stringTokenizer = new StringTokenizer(message, "/@");
                    String command = stringTokenizer.nextToken();
                    if (command.equals("SENDIMG")){                       // 若为发图片指令
                        String userID = stringTokenizer.nextToken();      // 发送方信息
                        String name = stringTokenizer.nextToken();     // 图片地址
                        append(userID + "发图片:\r\n", normal);
                        String address = System.getProperty("user.dir")+"/file/"+frame.getTitle()+"/"+name;
                        insertImg(address);                               // 显示图片
                    }
                    else if (command.equals("ADD")) {                     // 若为添加用户指令
                        String userID = stringTokenizer.nextToken();
                        append("系统提示:欢迎\'" + userID + "\'加入聊天室!\r\n", unnormal);
                    }
                    else if (command.equals("DELETE")) {                  // 若为删除用户指令
                        String userID = stringTokenizer.nextToken();
                        append("系统提示:\'" + userID + "\'退出聊天室!\r\n", unnormal);
                    }
                    else if(command.equals("USERLIST")) {                 // 若为显示在线用户指令
                        String userId;
                        int size = Integer.parseInt(stringTokenizer.nextToken());
                        append("当前在线用户有:\r\n\"\"\"\r\n", normal);
                        for (int i = 0; i < size; i++) {
                            userId = stringTokenizer.nextToken();
                            append(userId + "\r\n", normal);
                        }
                        append(frame.getTitle() + "\r\n\"\"\"\r\n", normal);
                    }
                    else if (command.equals("CLOSE"))                     // 若为服务器已关闭命令
                    {
                        append("系统提示:聊天室已关闭!\r\n", unnormal);
                        this.closeConnection();                           // 被动关闭连接
                        return;                                           // 结束线程
                    }
                    else {                                                // 发消息指令
                        append(message + "\r\n", normal);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 主程序
    public static void main(String[] args) {
        new Client();
    }

}