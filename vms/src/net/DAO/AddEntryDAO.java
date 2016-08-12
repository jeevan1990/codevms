package net.DAO;

import java.util.Map;

import net.vo.PersonDetailsVO;

import org.apache.commons.dbcp.BasicDataSource;

public interface AddEntryDAO {
	
	public Map addNewEntry(BasicDataSource springDataSource,int prsId,PersonDetailsVO personDetailsVO,byte[] fileBytePhoto,byte[] fileByteProof,byte[] fileByteFingerPrint);
	
	public Map addFingerprint(BasicDataSource springDataSource,int prsId,int personId,int fingerindex,byte[] fileByteFingerPrint);
	

}
