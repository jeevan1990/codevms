package net.StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;


import net.constant.VisitorManagementConstants;
import net.vo.DropdownVO;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.jdbc.object.StoredProcedure;

public class DropdownServiceStoredProcedure extends StoredProcedure{
	
	  private static final String GET_DROPDOWN_VALUES_PROC_NAME = VisitorManagementConstants.GET_DROPDOWN_VALUES_PROC_NAME;

	  
	public DropdownServiceStoredProcedure(DataSource ds)
	{
		
		super(ds, GET_DROPDOWN_VALUES_PROC_NAME);
		
		 declareParameter(new SqlOutParameter("v_dropdown_list",OracleTypes.ARRAY,
				 VisitorManagementConstants.DROPDOWN_LIST,
				 new SqlReturnType(){
			 public Object getTypeValue(CallableStatement cs,
					 
					 int paramIndex, int sqlType, String typeName)
			 throws SQLException{
				 Connection con = cs.getConnection();
				 Map<String, Class<?>> typeMap=con.getTypeMap();
				 typeMap.put(VisitorManagementConstants.DROPDOWN_OBJECT, 
						 DropdownVO.class);
				 Array arrset= cs.getArray(paramIndex);
				 ArrayList<DropdownVO> lstFolderRecord = null;
				 if(arrset != null) {
					 Object array = arrset.getArray(typeMap);
					 Object[] objArray = (Object[]) array;
					 if(objArray != null) {
						 lstFolderRecord = new ArrayList<DropdownVO>();
						 
						 for(int i=0 ;i < objArray.length ;i++)
						 {
							 DropdownVO dropdownVO =(DropdownVO) objArray[i];
							 lstFolderRecord.add(dropdownVO);
						 }
					 }
				 }
				 
				 return lstFolderRecord;
			 }
		 }));
		
		 declareParameter(new SqlOutParameter("v_statcode", Types.INTEGER));
		 declareParameter(new SqlOutParameter("v_success_msg", Types.VARCHAR));
		 declareParameter(new SqlOutParameter("v_error_msg", Types.VARCHAR));
		 compile();
		
	}
	
	
	public Map executeproc()
	  {
	      Map out= execute();
	      System.out.println("msg got"+out);
	      return out;
	  }
       
}
