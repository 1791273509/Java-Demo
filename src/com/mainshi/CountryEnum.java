package com.mainshi;

public enum CountryEnum {

	ONE(1,"Æë"),TWO(2,"º«");
	
	
	private Integer retcode;
	
	private String retMessage;

	public Integer getRetcode() {
		return retcode;
	}

	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}

	private CountryEnum(Integer retcode, String retMessage) {
		this.retcode = retcode;
		this.retMessage = retMessage;
	}
	
	public static String foreach(int index){
		CountryEnum[] my = CountryEnum.values();
		for (CountryEnum countryEnum : my) {
			if(countryEnum.getRetcode() == index){
				return countryEnum.getRetMessage();
			}
		}
		
		
		
		return null;
		
		
	}
	
	
	
	
	
}
