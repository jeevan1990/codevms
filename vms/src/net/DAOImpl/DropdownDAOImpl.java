package net.DAOImpl;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;

import net.DAO.DropdownDAO;
import net.StoredProcedure.DropdownServiceStoredProcedure;

public class DropdownDAOImpl implements DropdownDAO{

	@Override
	public Map getDropdowns(BasicDataSource springDataSource) {
		// TODO Auto-generated method stub
		
		DropdownServiceStoredProcedure dropdownServiceStoredProcedure= new DropdownServiceStoredProcedure(springDataSource);
		Map result=dropdownServiceStoredProcedure.executeproc();
		return result;
	}
	

}
