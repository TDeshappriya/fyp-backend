package com.example.demo.storedProcedure;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.ParameterMode;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.persistence.StoredProcedureQuery;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.example.demo.model.Data;


@Repository
public class storedProcedure {
	

	    @Autowired
	    private EntityManager em;

	    @SuppressWarnings("unchecked")
		public List<Data> getDataDB(){
	    	return em.createNamedStoredProcedureQuery("getData").getResultList();
	    }
	    
	    @SuppressWarnings("unchecked")
		public String getDataFiltered(List<Data> data){
	    	StoredProcedureQuery query = em.createNamedStoredProcedureQuery("insertData");
//	    	query.setParameter("id","100");
	    	query.setParameter("accelerometer",data.get(0).getAccelerometer());
	    	query.setParameter("roadName",data.get(0).getRoadName());
	    	query.setParameter("userId",data.get(0).getUserId());
	    	query.setParameter("iriValue",data.get(0).getIriValue());
	    	query.setParameter("distanceInMeters",data.get(0).getDistanceInMeters());
	    	query.setParameter("vehicleType",data.get(0).getVehicleType());
//	    	query.setParameter("roadId",data.get(0).getRoadId());
	    	
	    	
	    	query.execute();
	    	return (String) query.getOutputParameterValue("result");
	    }
	   
	}
