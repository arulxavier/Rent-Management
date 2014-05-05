package com.fixent.rm.server.service;

import java.util.List;

import com.fixent.rm.server.model.Rent;
import com.fixent.rm.server.model.info.RentInfo;

public interface RentService {
	
	public Boolean createRent(Rent rent);
	
	public Boolean modifyRent(Rent rent);
	
	public Boolean deleteRent(Rent rent);
	
	public Rent getRent(RentInfo rentInfo);
	
	public List<Rent> getRents(RentInfo rentInfo);

}
