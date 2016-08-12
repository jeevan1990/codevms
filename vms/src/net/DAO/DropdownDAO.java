package net.DAO;


import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;

public interface DropdownDAO {
	
	public Map getDropdowns(BasicDataSource springDataSource);

}
