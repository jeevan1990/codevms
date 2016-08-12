package net.DAOImpl;

import java.util.Map;

import net.DAO.GetPersonDetailsDAO;
import net.StoredProcedure.FindPersonStoredProcedure;
import net.StoredProcedure.GetPersonDetailsStoredProcedure;
import net.StoredProcedure.GetPersonFingerprintStoredProcedure;
import net.StoredProcedure.GetPersonImageStoredProcedure;

import org.apache.commons.dbcp.BasicDataSource;

public class GetPersonDetailsDAOImpl implements GetPersonDetailsDAO {

	public Map getPersonDetails(BasicDataSource springDataSource,String personId)
	{
		GetPersonDetailsStoredProcedure getPersonDetailsStoredProcedure = new GetPersonDetailsStoredProcedure(springDataSource);
		Map result=getPersonDetailsStoredProcedure.executeproc(personId);
		
		return result;
	}
	
	public Map getPersonImage(BasicDataSource springDataSource,String personId)
	{
		GetPersonImageStoredProcedure getPersonImageStoredProcedure = new GetPersonImageStoredProcedure(springDataSource);
		Map result=getPersonImageStoredProcedure.executeproc(personId);
		
		return result;
	}
	
	public Map getPersonFingerprint(BasicDataSource springDataSource,String personId,String fingerindex)
	{
		GetPersonFingerprintStoredProcedure getPersonFingerprintStoredProcedure = new GetPersonFingerprintStoredProcedure(springDataSource);
		Map result=getPersonFingerprintStoredProcedure.executeproc(personId,fingerindex);
		
		return result;
	}
	
	public Map findPerson(BasicDataSource springDataSource,String personId)
	{
		FindPersonStoredProcedure findPersonStoredProcedure = new FindPersonStoredProcedure(springDataSource);
		Map result=findPersonStoredProcedure.executeproc(personId);
		
		return result;
	}
}
