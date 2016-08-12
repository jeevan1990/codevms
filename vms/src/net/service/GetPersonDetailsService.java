package net.service;

import java.util.Map;

import net.DAOImpl.GetPersonDetailsDAOImpl;

import org.apache.commons.dbcp.BasicDataSource;

public class GetPersonDetailsService {
	
	GetPersonDetailsDAOImpl getPersonDetailsDAOImpl=new GetPersonDetailsDAOImpl();
	
	public Map getPersonDetails(BasicDataSource springDataSource,String personId)
	{
		
		Map result=getPersonDetailsDAOImpl.getPersonDetails(springDataSource, personId);
		
		return result;
	}
	
	
	public Map getPersonImage(BasicDataSource springDataSource,String personId)
	{
		Map result=getPersonDetailsDAOImpl.getPersonImage(springDataSource, personId);
		
		return result;
	}
	
	public Map getPersonFingerprint(BasicDataSource springDataSource,String personId,String fingerindex)
	{
		Map result=getPersonDetailsDAOImpl.getPersonFingerprint(springDataSource, personId, fingerindex);
		
		return result;
	}
	
	
	public Map findPerson(BasicDataSource springDataSource,String personId)
	{
		Map result=getPersonDetailsDAOImpl.findPerson(springDataSource, personId);
		
		return result;
	}

}
