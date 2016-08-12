package net.service;

import java.util.Map;

import net.DAOImpl.AddEntryDAOImpl;
import net.vo.PersonDetailsVO;

import org.apache.commons.dbcp.BasicDataSource;

public class AddEntryService {
	
	public Map addNewEntry(BasicDataSource springDataSource,int prsId,PersonDetailsVO personDetailsVO,byte[] fileBytePhoto,byte[] fileByteProof,byte[] fileByteFingerPrint)
	{
		AddEntryDAOImpl addEntryDAOImpl = new AddEntryDAOImpl();
		Map result=addEntryDAOImpl.addNewEntry(springDataSource,prsId,personDetailsVO,fileBytePhoto,fileByteProof,fileByteFingerPrint);
		
		return result;
	}
	
	
	public Map addFingerprint(BasicDataSource springDataSource,int prsId,int personId,int fingerindex,byte[] fileByteFingerPrint)
	{
		AddEntryDAOImpl addEntryDAOImpl = new AddEntryDAOImpl();
		Map result=addEntryDAOImpl.addFingerprint(springDataSource, prsId, personId, fingerindex, fileByteFingerPrint);
		
		return result;
	}

}
