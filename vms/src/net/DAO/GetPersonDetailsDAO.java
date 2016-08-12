package net.DAO;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;

public interface GetPersonDetailsDAO {

	public Map getPersonDetails(BasicDataSource springDataSource,String personId);
	public Map getPersonImage(BasicDataSource springDataSource,String personId);
	public Map findPerson(BasicDataSource springDataSource,String personId);
	
}
