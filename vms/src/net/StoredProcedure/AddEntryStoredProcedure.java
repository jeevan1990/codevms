package net.StoredProcedure;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.constant.VisitorManagementConstants;
import net.vo.PersonDetailsVO;
import oracle.sql.BLOB;

import org.springframework.data.jdbc.support.oracle.SqlReturnSqlData;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.object.StoredProcedure;

public class AddEntryStoredProcedure extends StoredProcedure {
	
	  private static final String ADD_ENTRY_PROC_NAME = VisitorManagementConstants.ADD_PERSON_STORED_PROC;

	public AddEntryStoredProcedure(DataSource ds) {
		super(ds, ADD_ENTRY_PROC_NAME);
		// TODO Auto-generated constructor stub
		
		 declareParameter(new SqlParameter("v_attachmet_photo", Types.BLOB));
		 declareParameter(new SqlParameter("v_attachmet_proof", Types.BLOB));
		 declareParameter(new SqlParameter("v_attachmet_fingerprint", Types.BLOB));
		 declareParameter(new SqlParameter("v_person_details", Types.STRUCT,VisitorManagementConstants.PERSON_OBJECT));
		 declareParameter(new SqlParameter("v_prsId", Types.INTEGER));
		 declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		 declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		 declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
		 compile();
	}
	  
	 
	public Map executeproc(final PersonDetailsVO personDetailsVO,int prsId,final byte[] fileBytePhoto,final byte[] fileByteProof,final byte[] fileByteFingerPrint) {
		
	      Map map = new HashMap();
	      map.put("v_prsId",prsId );
	      map.put("v_person_details",personDetailsVO );
	      map.put("v_attachmet_photo", new SqlTypeValue (){

			@Override
			public void setTypeValue(PreparedStatement cs, int index,
					int sqlType, String typeName) throws SQLException {
				// TODO Auto-generated method stub
				Connection con = cs.getConnection();
				Connection con1=((org.apache.commons.dbcp.DelegatingConnection)con).getInnermostDelegate();
				Blob blob=BLOB.createTemporary(con1, true, BLOB.DURATION_SESSION);
				blob.setBytes(1, fileBytePhoto);
				cs.setBlob(1, blob);
			}
	    	  
	      });
	      map.put("v_attachmet_proof", new SqlTypeValue (){

				@Override
				public void setTypeValue(PreparedStatement cs, int index,
						int sqlType, String typeName) throws SQLException {
					// TODO Auto-generated method stub
					Connection con = cs.getConnection();
					Connection con1=((org.apache.commons.dbcp.DelegatingConnection)con).getInnermostDelegate();
					Blob blob=BLOB.createTemporary(con1, true, BLOB.DURATION_SESSION);
					blob.setBytes(2, fileByteProof);
					cs.setBlob(2, blob);
				}
		    	  
		      });
	      map.put("v_attachmet_fingerprint", new SqlTypeValue (){

				@Override
				public void setTypeValue(PreparedStatement cs, int index,
						int sqlType, String typeName) throws SQLException {
					// TODO Auto-generated method stub
					Connection con = cs.getConnection();
					Connection con1=((org.apache.commons.dbcp.DelegatingConnection)con).getInnermostDelegate();
					Blob blob=BLOB.createTemporary(con1, true, BLOB.DURATION_SESSION);
					blob.setBytes(3, fileByteFingerPrint);
					cs.setBlob(3, blob);
				}
		    	  
		      });
	      Map out= execute(map);
	      System.out.println("msg got"+out);
	      return out;
	      
	  }
	  

}
