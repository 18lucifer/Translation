package com.TranslationApi.Translation.ServiceImpl;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.TranslationApi.Translation.Services.TranslatorService;

@Service
public class TranslatorServiceImpl implements TranslatorService{
	private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
	private static final String CLIENT_SECRET = "PUBLIC_SECRET";
	private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

	public Map translate(String fromLang, String toLang, String text) throws Exception {
		Map res=new HashMap();
		String jsonPayload = new StringBuilder().append("{").append("\"fromLang\":\"").append(fromLang).append("\",")
				.append("\"toLang\":\"").append(toLang).append("\",").append("\"text\":\"").append(text).append("\"")
				.append("}").toString();

		URL url = new URL(ENDPOINT);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
		conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
		conn.setRequestProperty("Content-Type", "application/json");

		OutputStream os = conn.getOutputStream();
		os.write(jsonPayload.getBytes());
		os.flush();
		os.close();

		int statusCode = conn.getResponseCode();
		System.out.println("Status Code: " + statusCode);
		BufferedReader br = new BufferedReader(
				new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
		String output;
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			res.put("translation", output);
		}
		conn.disconnect();
		return res;
	}

}
