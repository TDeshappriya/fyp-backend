package com.example.demo.controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class HttpDataHandling {

	
	public void sendDataToMlModel(String roadid, double irivalue) 
			  throws ClientProtocolException, IOException, JSONException {
			    HttpClient client = HttpClients.createDefault();
			    HttpPost httpPost = new HttpPost("http://localhost:9000/predict/");
			 
			    String json = "[" + roadid +", "+irivalue+"]";
			    StringEntity entity = new StringEntity(json);
			    httpPost.setEntity(entity);
//			    httpPost.setHeader("Accept", "application/json");
			    httpPost.setHeader("Content-Type", "application/json");
			 
			    ResponseHandler<String> handler = new BasicResponseHandler();
			    JSONArray jarray = new JSONArray(client.execute(httpPost, handler));
			   
			    String response = jarray.getString(0);
//			    ResponseEntity<String> dsd = client.execute(httpPost);
			    System.out.println(httpPost);
			    System.out.println(response);
//			    client.close();
			}
}
