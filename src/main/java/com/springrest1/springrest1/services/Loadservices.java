package com.springrest1.springrest1.services;
import java.util.List;

import com.springrest1.springrest1.entities.load;


public interface Loadservices {
	public List<load> getloads();
	public load getloads(long shipperId);
	public load addload(load Load);
	public load updateload(load Load);
	public void deleteLoad(long  parseLong);
	
	
	}
