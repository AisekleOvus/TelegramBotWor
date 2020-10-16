package com.ovus.aisekle.telegrambotwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.Connection;

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
    	String wholeURL = String.format(URL, token, method + "?chat_id=" + chat_id + params); // must be pair of '&key=value'
    	Connection telegramBotConnection = Jsoup.connect(wholeURL).ignoreContentType(true);
    	try {
    		result = telegramBotConnection.execute().body();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
	    
    public String sendPhoto(Map<String, String> params) {
    	StringBuilder stringParams = new StringBuilder();
    	for(Map.Entry entry : params.entrySet())
    		stringParams.append("&" + entry.getKey() + "=" + entry.getValue());
    	return sendPhoto(stringParams.toString());
    }
}

