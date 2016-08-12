package net.StoredProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import net.constant.VisitorManagementConstants;

public class AuthenticateUserStoredProcedure extends StoredProcedure{
	
	  private static final String STORED_PROC_NAME = VisitorManagementConstants.AUTHENTICATE_USER_PROC_NAME;

	  public AuthenticateUserStoredProcedure(DataSource ds){
		  
		  super(ds, STORED_PROC_NAME);
		  
		  declareParameter(new SqlParameter("username", Types.VARCHAR));
		  declareParameter(new SqlParameter("password", Types.VARCHAR));
		  declareParameter(new SqlOutParameter("prsId", Types.INTEGER));
		  declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		  declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		  declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
			 compile();
	  }
	  
	  public Map executeproc(String username, String password)
	  {
		  Map map = new HashMap();
	      map.put("username",username);
	      map.put("password",password);
	      
	      Map out= execute(map);
	      System.out.println("msg got"+out);
	      return out;
	  }
}



