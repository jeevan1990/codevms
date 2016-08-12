package net.DAOImpl;

import java.util.Map;

import net.DAO.AddEntryDAO;
import net.StoredProcedure.AddEntryStoredProcedure;
import net.StoredProcedure.AddFingerprintStoredProcedure;
import net.vo.PersonDetailsVO;

import org.apache.commons.dbcp.BasicDataSource;

public class AddEntryDAOImpl implements AddEntryDAO{
	
	public Map addNewEntry(BasicDataSource springDataSource,int prsId,PersonDetailsVO personDetailsVO,byte[] fileBytePhoto,byte[] fileByteProof,byte[] fileByteFingerPrint)
	{
		
		AddEntryStoredProcedure addEntryStoredProcedure = new AddEntryStoredProcedure(springDataSource);
		
		Map result=addEntryStoredProcedure.executeproc(personDetailsVO,prsId,fileBytePhoto,fileByteProof,fileByteFingerPrint);
		return result;
	}
	
	public Map addFingerprint(BasicDataSource springDataSource,int prsId,int personId,int fingerindex,byte[] fileByteFingerPrint)
	{
		AddFingerprintStoredProcedure addFingerprintStoredProcedure= new AddFingerprintStoredProcedure(springDataSource);
		
		Map result= addFingerprintStoredProcedure.executeproc(prsId, personId, fingerindex, fileByteFingerPrint);
		
		return result;
	}

}
