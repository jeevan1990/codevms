package net.StoredProcedure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.constant.VisitorManagementConstants;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.jdbc.core.SqlTypeValue;




public class ListManipulationStoredProcedure extends StoredProcedure{
	
	  private static final String GET_DROPDOWN_VALUES_PROC_NAME = VisitorManagementConstants.GET_DROPDOWN_VALUES_PROC_NAME;

	
	public ListManipulationStoredProcedure(DataSource ds)
	{
		
		super(ds, GET_DROPDOWN_VALUES_PROC_NAME);
		
		 declareParameter(new SqlParameter("v_dropdown_list",Types.ARRAY,
				 VisitorManagementConstants.DROPDOWN_LIST));
		 declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		 declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		 declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
		 compile();
		
		
	}
	
	public Map executeProc(final Object[] dropdownVO)
	{
		Map inParams = new HashMap();
		inParams.put("v_dropdown_list", new SqlTypeValue(){
			public void setTypeValue(PreparedStatement cs,int index,
					int sqlType, String typeNmae) throws SQLException {
				Connection con = cs.getConnection();
				Connection con1=((org.apache.commons.dbcp.DelegatingConnection)con).getInnermostDelegate();
				ArrayDescriptor des = ArrayDescriptor.createDescriptor(VisitorManagementConstants.DROPDOWN_LIST, con1);
				ARRAY a= new ARRAY(des,con1,dropdownVO);
				cs.setObject(1, (Object) a);
				
			}
		});
		
		Map map=execute(inParams);
		return map;
	}

}
