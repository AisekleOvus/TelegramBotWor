package com.ovus.aisekle.telegrambotwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.Connection;

/*
 *  Author - Aisekle Ovus
 *  Version 1.2
 *  
 */

public class TBWork {
	private String token;
	private static final String URL = "https://api.telegram.org/bot%s/%s";
	private String chat_id;

		
	public TBWork(String token, String chat_id) {
		this.token = token;
		this.chat_id = chat_id;
	}
	
    public String sendPhoto(String params) {
        String method = "sendPhoto";
    	String result = "empty";
   	
    	params = params.replace("#", "%23").replace(" ", "%20").replace("_", "%5F")
    			       .replace("*","%2A").replace("[","%5B").replace("]","%5D")
    			       .replace("(","%28").replace(")","%29").replace("~","%7E")
    			       .replace("`","%60").replace(">","%3E").replace("<","%3C")
    			       .replace("=","%3D").replace("|","%7C").replace("{","%7B")
    			       .replace("}","%7D").replace("}","%7D").replace("!","%21")
    			       .replace("+","%2B").replace("-","%2B");
    	String wholeURL = String.format(URL, token, method + "?chat_id=" + chat_id + params); // must be pair of '&key=value'
    	Connection telegramBotConnection = Jsoup.connect(wholeURL).ignoreContentType(true);
    	try {
    		result = telegramBotConnection.execute().body();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return wholeURL + System.lineSeparator() + result;
    }
	    
    public String sendPhoto(Map<String, String> params) {
    	StringBuilder stringParams = new StringBuilder();
    	for(Map.Entry entry : params.entrySet())
    		stringParams.append("&" + entry.getKey() + "=" + entry.getValue());
    	return sendPhoto(stringParams.toString());
    }
}

