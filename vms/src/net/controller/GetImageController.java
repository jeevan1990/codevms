package net.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.service.GetPersonDetailsService;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GetImageController {
	
	
	@Autowired
	BasicDataSource springDataSource;

	@Autowired
	GetPersonDetailsService getPersonDetailsService;
	
	 static Logger log = Logger.getLogger(GetImageController.class.getName());
	
	 @ResponseBody
	 @RequestMapping(value="/picture.htm" ,method = RequestMethod.GET)
	 public void getImageDetails(HttpServletRequest request, HttpServletResponse response )
	 {
		 String personId = request.getParameter("personId");
		 
		 log.debug("personId to fetch image"+personId);
		 System.out.println("personId received "+personId);
		Map result=getPersonDetailsService.getPersonImage(springDataSource, personId);
		
		Blob blob1 = (Blob) result.get("v_person_image");
	      int blobLength;
	     
	      try {
	    	  
	    	    ServletOutputStream out=response.getOutputStream();
				blobLength = (int) blob1.length();
				byte[] blobAsBytes = blob1.getBytes(1, blobLength);
				
				out.write(blobAsBytes);
				
				out.flush();
			    out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	      
	      
	      
	   /*   String homepath="D:\\joy\\Image13.jpg";
		 try {
			InputStream in = new FileInputStream(new File(homepath));
			ServletOutputStream out=response.getOutputStream();
			 byte[] buf = new byte[1024];
		      int len;
		      while ((len = in.read(buf)) > 0) {
		         out.write(buf, 0, len);
		      }
		      out.flush();
		      in.close();
		      out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	 }
	
	 @ResponseBody
	 @RequestMapping(value="/fingerprint.htm" ,method = RequestMethod.GET)
	 public void getFingerprintDetails(HttpServletRequest request, HttpServletResponse response )
	 {
		 String personId = request.getParameter("personId");
		 String fingerindex = request.getParameter("fingerindex");
		 
		 Map result=getPersonDetailsService.getPersonFingerprint(springDataSource, personId, fingerindex);
		 Blob blob1 = (Blob) result.get("v_person_fingerprint");
	      int blobLength;
	     
	      try {
	    	  
	    	    ServletOutputStream out=response.getOutputStream();
				blobLength = (int) blob1.length();
				byte[] blobAsBytes = blob1.getBytes(1, blobLength);
				
				out.write(blobAsBytes);
				
				out.flush();
			    out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 
	 }

}
