package cn.xwb.test;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
  public static void main(String args[]) throws Exception {
    // Ҫ���ӵķ����IP��ַ�Ͷ˿�
    String host = "127.0.0.1"; 
    int port = 55533;
    // �����˽�������
    Socket socket = new Socket(host, port);
    // �������Ӻ��������
    OutputStream outputStream = socket.getOutputStream();
    String message="���  yiwangzhibujian";
    socket.getOutputStream().write(message.getBytes("UTF-8"));
    outputStream.close();
    socket.close();
  }
}