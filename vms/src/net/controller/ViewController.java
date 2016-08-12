package net.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// This controller delegates the views for screens
@Controller
public class ViewController {

	@RequestMapping(value="/authenticateview" ,method = RequestMethod.GET)
    public String getAuthenticateView() {
        return "AuthenticationScreen";
    }
	
	@RequestMapping(value="/addnewperson" ,method = RequestMethod.GET)
    public String getAddPersonView() {
        return "AddPerson";
    }
	
	@RequestMapping(value="/viewperson" ,method = RequestMethod.GET)
    public String getPersonDetailsView(HttpServletRequest request, HttpServletResponse response) {
		String personId = request.getParameter("personId");
		request.setAttribute("personId", personId);
        return "ViewPerson";
    }
	
	@RequestMapping(value="/fingerprintview" ,method = RequestMethod.GET)
    public String getFingerprintTest() {
        return "Fileupload";
    }
	
	@RequestMapping(value="/login" ,method = RequestMethod.GET)
    public String getLoginPage() {
		System.out.println("In Login Screen");
        return "Login";
    }
}
