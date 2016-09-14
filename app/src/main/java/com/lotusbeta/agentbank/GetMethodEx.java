package com.lotusbeta.agentbank;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class GetMethodEx {

	public String getInternetData() throws Exception{

		BufferedReader in = null;
		String data = null;
		try{

			HttpClient client = new DefaultHttpClient();
			URI website = new URI("http://agentbankportal.azurewebsites.net/api/DailyWorksWeb/2025");
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String l = "";
			String nl = System.getProperty("line.separator");
			while ((l= in.readLine())!=null){

				sb.append(l+nl);
			}
			in.close();
			data=sb.toString();
			return data;
		}finally{
			if(in !=null){
				try{
					in.close();
					return data;
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}