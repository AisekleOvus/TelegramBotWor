package com.ovus.aisekle.telegrambotwork;

import java.util.HashMap;
import java.util.Map;

public class TelegramBotWork {
	private static final String TOKEN = "1163692560:AAE3MtmyMzsaJRPFKbXJdJhnqcBlC5k_1GQ";
	private static final String URL = "https://api.telegram.org/bot%s/%s";
	private static final String chat_id = "@Toro_dOro";
	private static String method;
	private static String params;
    public static void main( String[] args ) {
    	work w = new work(TOKEN, chat_id, "sendPhoto");
    	Map<String, String> params = new HashMap<>();
    	params.put("photo", "https://miro.medium.com/max/1024/1*PKxxUfUZDdrMtevTgAde9w.jpeg");
    	params.put("caption", "Деньги к деньгам");
    	w.sendPhoto(params);
    }
}

