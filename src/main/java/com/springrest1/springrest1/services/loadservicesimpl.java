package com.springrest1.springrest1.services;


import java.util.*;

import org.springframework.stereotype.Service;

import com.springrest1.springrest1.entities.load;

@Service
public class loadservicesimpl implements Loadservices{
	List<load> list;
	public loadservicesimpl() {
		list=new ArrayList<>();
		list.add(new load("delhi","jaipur","chemicals","canter",1,100.0,"nothing",1998,"12-10-2023"));
		list.add(new load("india","jaipur","icals","canter",1,100.0,"nothing",2208,"12-10-2023"));
	}

	@Override
	public List<load> getloads() {
		// TODO Auto-generated method stub
		return list;
	}
	
	
	@Override
	public load getloads(long shipperId) {
		// TODO Auto-generated method stub
		//String shipperIdStr = String.valueOf(shipperId);
		load l=null;
		for(load Load:list)
		{
			if(Load.getShipperId()==shipperId) {
				l=Load;
				break;
			}
			
		}
		return l ;

	
	}

	@Override
	public load addload(load Load) {
		// TODO Auto-generated method stub
		list.add(Load);
		return Load;
	}

	@Override
	public load updateload(load Load) {
	  list.forEach(e -> {
	    if (e.getShipperId() == Load.getShipperId()) {
	      e.setLoadingPoint(Load.getLoadingPoint());
	      e.setUnloadingPoint(Load.getUnloadingPoint());
	      e.setProductType(Load.getProductType());
	      e.setTruckType(Load.getTruckType());
	      e.setNoOfTrucks(Load.getNoOfTrucks());
	      e.setWeight(Load.getWeight());
	      
	      // No need to update shipperId as it's used for matching
	      e.setDate(Load.getDate());
	    }
	  });
	  return Load;
	}
	

	@Override
	public void deleteLoad(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getShipperId()!=parseLong).collect(null);
		
	}

}
