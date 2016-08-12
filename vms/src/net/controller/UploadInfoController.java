
package net.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.BiometricMatch.ClientMultipartFormPost;
import net.BiometricMatch.RegisterClientFingerprint;
import net.dto.ResponseDTO;
import net.service.AddEntryService;
import net.vo.PersonDetailsVO;

import org.apache.commons.dbcp.BasicDataSource;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadInfoController {
	
	@Autowired
	BasicDataSource springDataSource;
	
	@Autowired
	AddEntryService addEntryService;
	
	
	@RequestMapping(value="/bulkuploadFile.htm", method=RequestMethod.POST)
	@ResponseBody
	//public String createbulk(@RequestParam("profilephoto") MultipartFile[] file,@RequestParam("addressproof") MultipartFile[] file2,@RequestParam("fingerprint") MultipartFile[] file3,HttpServletRequest request , HttpServletResponse response){
		
		public String createbulk(@RequestParam("profilephoto") MultipartFile[] file,@RequestParam("addressproof") MultipartFile[] file2,HttpServletRequest request , HttpServletResponse response){

		
		//System.out.println("here in post ");
		
		int prsId=10001;
	
		String filename= file[0].getOriginalFilename();
		byte[] fileByte = null;
		try {
			fileByte= file[0].getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("file name"+filename);
		String str="";
		try {
			 str = new String(fileByte, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(str);
		
		
		
		//String file2name= file2[0].getOriginalFilename();
		byte[] file2Byte = null;
		try {
			file2Byte= file2[0].getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("file2 name"+file2name);
		String str2="";
		try {
			 str2 = new String(fileByte, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(str2);
		
		
		
		String file3name= file2[0].getOriginalFilename();
		byte[] file3Byte = null;
		try {
			file3Byte= file2[0].getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("file name"+file3name);
		String str3="";
		try {
			 str3 = new String(fileByte, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(str3);
		
		
		
		
		PersonDetailsVO personDetailsVO = new PersonDetailsVO();
		personDetailsVO.setFirstName(request.getParameter("firstName"));
		personDetailsVO.setLastName(request.getParameter("lastName"));
		personDetailsVO.setMiddleName(request.getParameter("middleName"));
		personDetailsVO.setDateOfBirth(request.getParameter("dateOfBirth"));
		personDetailsVO.setAddress(request.getParameter("address"));
		personDetailsVO.setVehicleNumber(request.getParameter("vehicleNumber"));
		personDetailsVO.setVisitorType(request.getParameter("visitorType"));
		personDetailsVO.setAddressProofType(request.getParameter("addressProofType"));
		personDetailsVO.setRank(request.getParameter("rank"));
		personDetailsVO.setOfficerId(request.getParameter("officerId"));
		personDetailsVO.setDependentId(request.getParameter("dependentId"));
		personDetailsVO.setDependentOfficerId(request.getParameter("dependentOfficerId"));
		personDetailsVO.setPersonToMeet(request.getParameter("personToMeet"));
		personDetailsVO.setRelation(request.getParameter("relation"));
		personDetailsVO.setVendorId(request.getParameter("vendorId"));
		personDetailsVO.setVendorName(request.getParameter("vendorName"));
		personDetailsVO.setVendorAddress(request.getParameter("vendorAddress"));
		personDetailsVO.setContractorId(request.getParameter("contractorId"));
		personDetailsVO.setContractorName(request.getParameter("contractorName"));
		personDetailsVO.setContractorAddress(request.getParameter("contractorAddress"));
		
		try {
			new ClientMultipartFormPost().submitForm(fileByte, "10007", "4");
			//new RegisterClientFingerprint().submitForm(fileByte, "10002", "4");
		} catch (Exception e) {
			System.out.println("exception in web service call--");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("birth"+personDetailsVO.getDateOfBirth());
		Map result=addEntryService.addNewEntry(springDataSource,prsId, personDetailsVO,fileByte,file2Byte,file3Byte);
		ResponseDTO responseDTO=new ResponseDTO();
		if((int)result.get("v_statcode")==0)
		{
			responseDTO.setStatCode(0);
			responseDTO.setMessage((String)result.get("v_success_msg"));
		}
		else
		{
			responseDTO.setStatCode(100);
			responseDTO.setMessage((String)result.get("v_error_msg"));
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
	
	
	@RequestMapping(value="/uploadFingerprint.htm", method=RequestMethod.POST)
	@ResponseBody
		public String addfingerprint(@RequestParam("fingerprint") MultipartFile[] file,HttpServletRequest request , HttpServletResponse response){
		
		System.out.println("here in fingerprint post ");
		System.out.println("personId "+request.getParameter("personId"));
		System.out.println("fingerindex"+request.getParameter("fingerindex"));
		
		int prsId=10001;
		int fingerindex;
		int personId=Integer.parseInt(request.getParameter("personId"));
		if(request.getParameter("fingerindex") !=null)
		{
			fingerindex=Integer.parseInt(request.getParameter("fingerindex"));
		}
		else
		{
			fingerindex=4;
		}
	
		String filename= file[0].getOriginalFilename();
		System.out.println(" in filename  "+filename);
		byte[] fileByteFingerPrint = null;
		try {
			fileByteFingerPrint= file[0].getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("file name"+filename);
		String str="";
		try {
			 str = new String(fileByteFingerPrint, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
		
		
		
		Map result=addEntryService.addFingerprint(springDataSource, prsId, personId, fingerindex, fileByteFingerPrint);
		
		if((int)result.get("v_statcode")==0)
		{
			
			return (String)result.get("v_success_msg");
		}
		else
		{
			return (String)result.get("v_error_msg");
		}
		
	}
	
		
}
