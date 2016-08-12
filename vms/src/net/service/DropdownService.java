package net.service;

import java.util.Map;

import net.DAOImpl.DropdownDAOImpl;

import org.apache.commons.dbcp.BasicDataSource;

public class DropdownService {
	
	
	public Map getDropdowns(BasicDataSource springDataSource){
		
		DropdownDAOImpl dropdownDAOImpl = new DropdownDAOImpl();
		
		Map result =dropdownDAOImpl.getDropdowns(springDataSource);
		
		return result;
	}
	

}
