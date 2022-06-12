package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Call_API {
	final private String API_URL = "http://Libraryserver-env.eba-yf973i6v.ap-northeast-2.elasticbeanstalk.com";
	
	
	public JSONObject GET(String parameter) throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder(API_URL+parameter);
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn =(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
		//JSON 파싱 시작
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        
        try {
        	obj = (JSONObject)parser.parse(sb.toString());
        }
        catch (ParseException e) {
            System.out.println("JSON객체로 변환에 실패");
            e.printStackTrace();
       }
       return obj;
       
	}
	
	public JSONObject POST(String parameter,HashMap<String, String> option ) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(API_URL+parameter);
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn =(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
		// 쓰기객체 얻기
		OutputStream out = conn.getOutputStream();
		String str = "";
		for(int i=0; i<option.size();i++){
			Object[] key = option.keySet().toArray();
		
			if(i !=0) {
				str = str + "&"+ key[i] + "=" +option.get(key[i]);				
			}
			else {
				str = key[i]+ "=" + option.get(key[i]);
			}
		}
		
		out.write(str.getBytes("utf-8"));
		out.close();
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
		//JSON 파싱 시작
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        
        try {
        	obj = (JSONObject)parser.parse(sb.toString());
        }
        catch (ParseException e) {
            System.out.println("JSON객체로 변환에 실패");
            e.printStackTrace();
       }
       return obj;
       
	}
	
	
}
