package com.example.sba.chat;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class APIExamTTS {
	private static APIExamTTS instance = new APIExamTTS();
	
	public static APIExamTTS getInstance() {
		if(instance == null) {
			instance = new APIExamTTS();
		}
		
		return instance;
	}
	
    public String getWelcomeVoice(String id) {
        String clientId = "q3z25evper";
        String clientSecret = "NhKAZPZqUkgxamp67wVsufsOMEAgjHVl7qxzxbL0";
        String fileName = null;
        try {
        	String text = URLEncoder.encode(id+ "님 만나서 반갑습니다. 채팅을 시작합니다.", "UTF-8"); 
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "speaker=nara&volume=0&speed=0&pitch=0&emotion=0&format=mp3&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) {
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                fileName = Long.valueOf(new Date().getTime()).toString() + ".mp3";
                File f = new File("src/main/resources/static/audio/" + fileName);
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
             } else {  
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return fileName;
    }
}