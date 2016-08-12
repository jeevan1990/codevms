package net.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.service.DropdownService;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.vo.DropdownVO;

@Controller
public class DropdownController {
	
	
	@Autowired
	BasicDataSource springDataSource;

	
	 @ResponseBody
	 @RequestMapping(value="/getDropdowns.htm" ,method = RequestMethod.GET)
	public String getPersonDetails(HttpServletRequest request, HttpServletResponse response )
	 {
		DropdownService dropdownService = new DropdownService();
		
		Map result=dropdownService.getDropdowns(springDataSource);
		ArrayList<DropdownVO>  list = new ArrayList<DropdownVO>();
		list=(ArrayList<DropdownVO>)result.get("v_dropdown_list");
		for(DropdownVO v: list)
		{
			System.out.println(v.getDescription()+"  "+v.getDisabled());
		}
		return null;
	 }
}
