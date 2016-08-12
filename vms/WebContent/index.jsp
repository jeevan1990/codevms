<%
	StringBuffer urlString = new StringBuffer();
	urlString.append(request.getScheme());
	urlString.append("://");
	urlString.append(request.getServerName());
	
	//for local, append the port as well
	if(request.getScheme() != null && request.getScheme().equals("http")){
		urlString.append(":");
		urlString.append(request.getServerPort());
		
	}
	
	urlString.append(request.getContextPath());
	urlString.append("/vms/authenticateview.htm");
	response.sendRedirect(urlString.toString());
%>