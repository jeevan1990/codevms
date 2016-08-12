package net.dataset;


import org.apache.commons.dbcp.BasicDataSource;


public class OracleDatasource {
	
	
	 private static String driverClassName="oracle.jdbc.driver.OracleDriver" ;
	 private static String userName="SCOTT";
	 
	 private static String password="TIGER";
	 
	// private static int MAX_ACTIVE= 10;
	 
	 private static String url="jdbc:oracle:thin:@localhost:1522:orc";
	 
	
	 private static BasicDataSource ds = null;
	 
	 private OracleDatasource(){
		 
	 }
	 
	 
	 public static BasicDataSource getDatasource()
	 {
		 if(ds==null)
		 {	 
			ds = new BasicDataSource();
			ds.setDriverClassName(driverClassName);
			ds.setPassword(password);
			ds.setUsername(userName);
			ds.setUrl(url);
			// ds.setMaxActive(MAX_ACTIVE);
			// check connections
		 }
		 
		 return ds;
	  
	 }
	 
	

}
