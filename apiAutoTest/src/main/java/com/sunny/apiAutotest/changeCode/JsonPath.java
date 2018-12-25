package com.sunny.apiAutotest.changeCode;

import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.jayway.jsonpath.Configuration;

public class JsonPath {
	public static List<String> id (String json) {
		
		List<String> idlist = com.jayway.jsonpath.JsonPath.read(json, "$..id");
		System.out.println(idlist);
		return idlist;
		
	}
	public static void main(String[] args) {
		id("{\"result\":200,\"msg\":\"请求成功\",\"errcode\":0,\"data\":[{\"id\":266,\"createDate\":null,\"updateDate\":null,\"userId\":1007323,\"guessNumber\":\"epntest1100@qq.com\",\"guessOrderNum\":\"201812211701363644\",\"buyType\":0,\"guessPeriods\":111,\"guessMultiple\":1,\"guessMoney\":10.0,\"guessSumMoney\":10.0,\"winningAmount\":80.0,\"lossPerCent\":8.0,\"betDate\":1545382897000,\"type\":2},{\"id\":267,\"createDate\":null,\"updateDate\":null,\"userId\":1007323,\"guessNumber\":\"epntest1100@qq.com\",\"guessOrderNum\":\"201812211701417947\",\"buyType\":0,\"guessPeriods\":6,\"guessMultiple\":1,\"guessMoney\":10.0,\"guessSumMoney\":10.0,\"winningAmount\":80.0,\"lossPerCent\":8.0,\"betDate\":1545382902000,\"type\":2}],\"msgEn\":\"Successful\"}");
	}
}
