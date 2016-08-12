package net.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dto.ResponseDTO;
import net.service.GetPersonDetailsService;
import net.vo.PersonDetailsVO;

import org.apache.commons.dbcp.BasicDataSource;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetPersonDetailsController {

	
	@Autowired
	BasicDataSource springDataSource;

	@Autowired
	GetPersonDetailsService getPersonDetailsService;
	
	@ResponseBody
	 @RequestMapping(value="/personDetails.htm" ,method = RequestMethod.GET)
	 public String getPersonDetails(HttpServletRequest request, HttpServletResponse response )
	 {
		ObjectMapper mapper=new ObjectMapper();
		String personId = request.getParameter("personId");
		Map result=getPersonDetailsService.getPersonDetails(springDataSource, personId);
		PersonDetailsVO personDetails=(PersonDetailsVO)result.get("v_person_details"); 
		System.out.println(personDetails.getAddress());
		try {
			String responsesent=mapper.writeValueAsString(personDetails);
			System.out.println("responsesent"+responsesent);
			return responsesent;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "hello "+request.getParameter("firstName")+" "+request.getParameter("lastName");
		
		System.out.println(personDetails.getAddress());
		return null;
	 }
	
	@ResponseBody
	 @RequestMapping(value="/findPerson.htm" ,method = RequestMethod.POST)
	 public String searchPerson(HttpServletRequest request, HttpServletResponse response )
	 {
		ResponseDTO responseDTO=new ResponseDTO();
		String personId = request.getParameter("personId");
		Map result=getPersonDetailsService.findPerson(springDataSource, personId);
		System.out.println((String)result.get("v_found"));
		if(((String)result.get("v_found")).equals("YES"))
		{
			responseDTO.setStatCode(0);
			responseDTO.setMessage(personId);
		}
		else
		{
			responseDTO.setStatCode(100);
		}
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			String responsesent=mapper.writeValueAsString(responseDTO);
			System.out.println("responsesent"+responsesent);
			return responsesent;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	 }
	
} 
