package com.ovus.aisekle.telegrambotwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.Connection;

/*
 *  Author - Aisekle Ovus
 *  Version 1.8
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
	
//                                                sendPhoto methods set	
	
	public String sendPhoto(String photoUrl, String caption, String parse_mode, boolean disable_notification, int reply_to_message_id) {
		
		return sendPhotoParamsInLine("&photo="+photoUrl+"&caption="+caption+"&parse_mode="+parse_mode+"&disable_notification="+disable_notification+"&reply_to_message_id="+reply_to_message_id);
	}
	public String sendPhoto(String photoUrl, String caption, String parse_mode, boolean disable_notification) {
		
		return sendPhotoParamsInLine("&photo="+photoUrl+"&caption="+caption+"&parse_mode="+parse_mode+"&disable_notification="+disable_notification);
	}	
	public String sendPhoto(String photoUrl, String caption, String parse_mode) {
		
		return sendPhotoParamsInLine("&photo="+photoUrl+"&caption="+caption+"&parse_mode="+parse_mode);
	}
	public String sendPhoto(String photoUrl, String caption) {
		
		return sendPhotoParamsInLine("&photo="+photoUrl+"&caption="+caption);
	}
	public String sendPhoto(String photoUrl) {
		
		return sendPhotoParamsInLine("&photo="+photoUrl);
	}
	public String sendPhotoParamsInLine(String params) { // params must be pair of '&key=value'
    	String[] paramarray = params.split("&"); // this array not empty values start with 1 index
    	HashMap<String, String> paramsHM = new HashMap<>();
    	for(int i = 1; i < paramarray.length; i++) {
    		String[] paramEntry = paramarray[i].split("=");
    	    paramsHM.put(paramEntry[0], paramEntry[1]);
    	}
    	
    	return sendPhoto(paramsHM);
    }
	    
    public String sendPhoto(Map<String, String> params) {
    	StringBuilder stringParams = new StringBuilder();
    	String result ="empty";
    	String method = "sendPhoto";
    	
    	if(params.containsKey("caption"))
    		params.computeIfPresent("caption", (k, v) -> percenting(v));
    	for(Map.Entry entry : params.entrySet())
    		stringParams.append("&" + entry.getKey() + "=" + entry.getValue());
    	
    	String wholeURL = String.format(URL, token, method + "?chat_id=" + chat_id + stringParams.toString());
    	Connection telegramBotConnection = Jsoup.connect(wholeURL).ignoreContentType(true);
    	try {
    		result = telegramBotConnection.execute().body();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return wholeURL + System.lineSeparator() + result;
    	
    }
    private String percenting(String str) {
    	return str.replace("#", "%23").replace(" ", "%20").replace("_", "%5F")
			      .replace("*","%2A").replace("[","%5B").replace("]","%5D")
			      .replace("(","%28").replace(")","%29").replace("~","%7E")
			      .replace("`","%60").replace(">","%3E").replace("<","%3C")
			      .replace("=","%3D").replace("|","%7C").replace("{","%7B")
			      .replace("}","%7D").replace("}","%7D").replace("!","%21")
			      .replace("+","%2B").replace("-","%2B");
    }
}

