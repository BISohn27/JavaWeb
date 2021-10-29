package com.example.sba.chat;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIExamSTT {
	private static APIExamSTT instance = new APIExamSTT();
	
	public static APIExamSTT getInstance() {
		if(instance == null) {
			instance = new APIExamSTT();
		}
		return instance;
	}

    public String voice(String fileName) {
    	String clientId = "1y7oxdyu70";
        String clientSecret = "6WjCAcMYXVOe9Ic8PXOKjd0n5Iq1iaUpBmLijI9Y";
        String msg = null;
        try {
            File voiceFile = new File(fileName);

            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println((msg = response.toString()));
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return msg;
    }
}