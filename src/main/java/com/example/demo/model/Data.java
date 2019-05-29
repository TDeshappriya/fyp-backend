package com.example.demo.model;



import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "data")
//@NamedStoredProcedureQueries({
//	   @NamedStoredProcedureQuery(
//	   name = "p_insertData", 
//	   procedureName = "p_insertData", 
//	   resultClasses = {  },    
//	   parameters = { 
//	      @StoredProcedureParameter( name = " id",  type = String.class,  mode = ParameterMode.IN),
//	      @StoredProcedureParameter( name = "iri_value",  type = String.class,  mode = ParameterMode.IN)
////	      @StoredProcedureParameter( name = "out_code",  type = Integer.class,  mode = ParameterMode.OUT), 
////	      @StoredProcedureParameter( name = "out_message",  type = String.class,  mode = ParameterMode.OUT)
//
//	      query.setParameter(1, username);
//	        query.setParameter(2, password);
//
//	        //Execute query
//	        query.execute();
//	     }),
//
//	 })
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "updateVtype",procedureName= "p_updateVtype", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "vehicleType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = int.class)
	}),
//	@NamedStoredProcedureQuery(name = "getDataToListView",procedureName= "p_getDataToListView", parameters = {
//			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "id", type = int.class),
//			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "userid", type = String.class),
//			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "roadName", type = String.class)
//	}),
	@NamedStoredProcedureQuery(name = "getDataToListView",procedureName= "p_getDataToListView", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "data", type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "deleteRecord",procedureName= "p_deleteRecord", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = int.class)
	}),
	@NamedStoredProcedureQuery(name = "update_roads",procedureName= "p_update_roads"
			),
	@NamedStoredProcedureQuery(name = "getDataToMap",procedureName= "p_getDataToLoadMap", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "accelerometer", type = String.class)
	}),
	@NamedStoredProcedureQuery (name = "insertData", procedureName = "p_insertData", parameters = {
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "accelerometer", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "latlng", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "roadName", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "iriValue", type = double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "distanceInMeters", type = double.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "vehicleType", type = String.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "roadId", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "id", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "roadId", type = int.class)
	})})


public class Data {
	
	@Id
    @GeneratedValue
    private int id;
	private String accelerometer;
	private String latlng;
	private String roadName;
	private String userId;
	private double iriValue;
	private double distanceInMeters;
	private String vehicleType;
	private String roadId;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccelerometer() {
		return accelerometer;
	}
	public void setAccelerometer(String accelerometer) {
		this.accelerometer = accelerometer;
	}
	public String getLatlng() {
		return latlng;
	}
	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getIriValue() {
		return iriValue;
	}
	public void setIriValue(double iriValue) {
		this.iriValue = iriValue;
	}
	public double getDistanceInMeters() {
		return distanceInMeters;
	}
	public void setDistanceInMeters(double distanceInMeters) {
		this.distanceInMeters = distanceInMeters;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	

	
}
