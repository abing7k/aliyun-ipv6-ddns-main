package com.dadavivi.aliyunipv6ddns;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class AliyunIpv6DdnsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public String getCurrentHostIP() {
		// 这里使用jsonip.com第三方接口获取本地IP
		String jsonip = "http://6.ipw.cn/";
		// 接口返回结果
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;
		try {
			// 使用HttpURLConnection网络请求第三方接口
			URL url = new URL(jsonip);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			in = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 使用finally块来关闭输入流
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return result.toString();
	}

	@Test
	public void test01(){
		System.out.println(getCurrentHostIP());
	}

}
