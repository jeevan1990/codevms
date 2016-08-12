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
import oracle.sql.BLOB;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.object.StoredProcedure;

public class AddFingerprintStoredProcedure extends StoredProcedure{
	
	  private static final String ADD_FINGERPRINT_PROC_NAME = VisitorManagementConstants.ADD_FINGERPRINT_STORED_PROC;

	public AddFingerprintStoredProcedure(DataSource ds)
	{
		super(ds, ADD_FINGERPRINT_PROC_NAME);
		
		declareParameter(new SqlParameter("v_attachmet_fingerprint", Types.BLOB));
		declareParameter(new SqlParameter("v_prsId", Types.INTEGER));
		declareParameter(new SqlParameter("v_personId", Types.INTEGER));
		declareParameter(new SqlParameter("v_fingerindex", Types.INTEGER));
		declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
		compile();
	}
	
	public Map executeproc(int prsId,int personId,int fingerindex, final byte[] fileByteFingerPrint){
		
		Map map = new HashMap();
	      map.put("v_prsId",prsId );
	      map.put("v_personId",personId);
	      map.put("v_fingerindex",fingerindex);
	      
	      
	      map.put("v_attachmet_fingerprint", new SqlTypeValue (){

				@Override
				public void setTypeValue(PreparedStatement cs, int index,
						int sqlType, String typeName) throws SQLException {
					// TODO Auto-generated method stub
					Connection con = cs.getConnection();
					Connection con1=((org.apache.commons.dbcp.DelegatingConnection)con).getInnermostDelegate();
					Blob blob=BLOB.createTemporary(con1, true, BLOB.DURATION_SESSION);
					blob.setBytes(1, fileByteFingerPrint);
					cs.setBlob(1, blob);
				}
		    	  
		      });
	      Map out= execute(map);
	      System.out.println("msg got"+out);
	      return out;
		
	}

}
