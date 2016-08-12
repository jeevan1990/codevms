package net.StoredProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.constant.VisitorManagementConstants;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class FindPersonStoredProcedure extends StoredProcedure {
	
	  private static final String FIND_PERSON_PROC_NAME = VisitorManagementConstants.FIND_PERSON_PROC_NAME;

	  public  FindPersonStoredProcedure(DataSource ds){
		  
		  super(ds, FIND_PERSON_PROC_NAME);
		  
		  declareParameter(new SqlParameter("personId", Types.INTEGER));
		  declareParameter(new SqlOutParameter("v_found", Types.VARCHAR));
		  declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		  declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		  declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
			 compile();
	  }
   
	  public Map executeproc(String personId)
	  {
		  Map map = new HashMap();
	      map.put("personId",Integer.parseInt(personId));
	      
	      Map out= execute(map);
	      System.out.println("msg got"+out);
	      return out;
	  }
}
