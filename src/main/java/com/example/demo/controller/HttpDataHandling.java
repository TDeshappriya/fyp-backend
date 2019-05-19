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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.storedProcedure.storedProcedure;

@Service
public class HttpDataHandling {
	
	@Autowired
	storedProcedure sp;

	
	public void sendDataToMlModel(int roadid, double irivalue, int id) 
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
//			    System.out.println(httpPost);
			    System.out.println(response);

			    System.out.println(id);
			    
			    sp.updateVtype(response, id);
//			    client.close();
			}
}
