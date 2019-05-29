package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Data;
import com.example.demo.superController.superController;
import com.example.demo.storedProcedure.storedProcedure;
import com.example.demo.controller.HttpDataHandling;

@RestController
@RequestMapping("/data")
public class Controller {

	@Autowired
	superController sc;
	
	@Autowired
	storedProcedure sp;
	
	@Autowired
	HttpDataHandling hdh;
	
	@PostMapping("/add")
	public String addData(@RequestBody List<Data> data ) {
//		
//		sp.checkUsernameAndPassword(id , data.iri_value);
//		for (int i = 0; i<data.size();i++){
//		    System.out.println(data.get(i).getIriValue());
//		    System.out.println(data.get(i).getId());
//		    
//		    sp.sendDataToDB("200" , 20.0);
//		}
		sc.saveAll(data);
		return "data" + data.size();
	}
	
	@GetMapping("/get")
	public List<Data> getAllData(){
		return (List<Data>) sc.findAll();
	}
	
	@GetMapping("/getAllData")
	public List<Data> getData(){
		return sp.getDataDB();
	}
	
	@GetMapping("/getDataToListView")
	public ArrayList<Data> getDataToListView(){
		return sp.getDataToListView();
	}
	
	@GetMapping("/getDataToMap")
	public ArrayList<Data> getDataToMap(){
		return sp.getDataToMap();
	}
	
//	@PostMapping("/getDataToMap")
//	public String updateVtype(@RequestBody List<List> list){
//		String response = data.get(0).
//		return sp.updateVtype(response, id);(data);
//	}
	
//	@PostMapping("/deleteRecord")
	@RequestMapping("/deleteRecord/{id}")
//	@RequestMapping(value = "/deleteRecord/{id}", method = RequestMethod.POST, 
//			  produces = "application/json")
	@ResponseBody
	public void deleteRecord(@PathVariable int id){
		sp.deleteRecord(id);
	}
	
	@RequestMapping("/updateVtype/{id}/{vType}")
	@ResponseBody
	public void updateVtype(@PathVariable int id, @PathVariable String vType){
		sp.updateVtype(id, vType);
	}
	
	@PostMapping("/insertData")
	public void insertData(@RequestBody List<Data> data){
		String test = sp.getDataFiltered(data);
		
//		System.out.println(test);
		
		if (test.equals("1") ){
		try {
			hdh.sendDataToMlModel(sp.roadId, data.get(0).getIriValue(), sp.id);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
//		 
//		 return sp.getDataFiltered(data);
	}
	
	
	
	@Scheduled(cron="0 30 2 * * ?")
    public void trainModel(){
        try {
			hdh.trainMlModel();
			System.out.println("trained");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Scheduled(cron="0 30 2 * * ?")
    public void update_roads(){
		sp.update_roads();
	}
	
	
	
}
