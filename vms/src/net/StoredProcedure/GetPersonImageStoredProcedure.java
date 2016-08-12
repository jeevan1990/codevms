package net.StoredProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.constant.VisitorManagementConstants;
import net.vo.PersonDetailsVO;

import org.springframework.data.jdbc.support.oracle.SqlReturnSqlData;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class GetPersonImageStoredProcedure extends StoredProcedure {
	
	 private static final String GET_PERSON_IMAGE_PROC_NAME = VisitorManagementConstants.GET_PERSON_IMAGE_PROC_NAME;
	
	public GetPersonImageStoredProcedure(DataSource ds)
	{
		super(ds, GET_PERSON_IMAGE_PROC_NAME);
		
		declareParameter(new SqlParameter("personId", Types.INTEGER));
		 declareParameter(new SqlOutParameter("v_person_image", Types.BLOB));
		 declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		 declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		 declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
		 compile();
	}
	
	public Map executeproc(String personId)
	  {
		  Map map = new HashMap();
		  
		  System.out.println("personid "+personId);
	      map.put("personId",Integer.parseInt(personId));
	      
	      Map out= execute(map);
	      System.out.println("msg got"+out);
	      return out;
	  }

}
