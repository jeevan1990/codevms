package net.filter;

import java.io.IOException;

import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import java.net.URI;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.StoredProcedure.AuthenticateUserStoredProcedure;
import net.dataset.OracleDatasource;

import org.apache.commons.dbcp.BasicDataSource;


public class AuthenticationFilter implements Filter{
	
	
	BasicDataSource springDataSource;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	     
		System.out.println("in authentication filter");
		
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;
		
		HttpSession session = request.getSession();
		
		String url = request.getRequestURL().toString();
		
		if(url.contains("logout.htm"))
		{
			 session.invalidate();
			 System.out.println("session destroyed");
			 request.getRequestDispatcher("/Logout.jsp").forward(request, response);
			//response.sendRedirect(urlString.toString());
		}
		//response.sendRedirect("http://localhost:8080/vms/Login.jsp");
		else
		{	
			if(session != null && session.getAttribute("prsId") !=null)
			{
				chain.doFilter(request, response);//sends request to next resource 
			}
			else
			{
				StringBuffer urlString = new StringBuffer();
				urlString.append(request.getScheme());
				urlString.append("://");
				urlString.append(request.getServerName());

				// for local, append the port as well
				if (request.getScheme() != null
						&& request.getScheme().equals("http")) {
					urlString.append(":");
					urlString.append(request.getServerPort());

				}

				urlString.append(request.getContextPath());
				
				
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				if(username != null && password !=null)
					
				{	
					springDataSource = OracleDatasource.getDatasource();
					AuthenticateUserStoredProcedure authenticateUserStoredProcedure = new AuthenticateUserStoredProcedure(springDataSource);
					Map out=authenticateUserStoredProcedure.executeproc(username, password);
					if(out != null && ((int)out.get("v_statcode")==0) )
					{
						session.setAttribute("prsId", String.valueOf((int)out.get("prsId")));
						session.setAttribute("username",username );
						urlString.append("/authenticateview.htm");
						response.sendRedirect(urlString.toString());
					}
					
					else
					{
						//request.getRequestDispatcher("/Login.jsp").forward(request, response);
						//urlString.append("/Login.jsp?response="+(String)out.get("v_error_msg"));
						urlString.append("/Login.jsp");
						response.sendRedirect(urlString.toString()+"?response="+((String)out.get("v_error_msg")).replace(" ", "+"));
					}
				}
				else
				{
					//request.getRequestDispatcher("/Login.jsp").forward(request, response);
					urlString.append("/Login.jsp");
					response.sendRedirect(urlString.toString());
				}
			}
		}
	   /*String password=request.getParameter("password");  
	    if(password.equals("admin")){  
	    chain.doFilter(request, response);//sends request to next resource  
	    }  
	    
	    else{  
	    out.print("username or password error!");  
	    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	    rd.include(request, response);  
	    }  */
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
