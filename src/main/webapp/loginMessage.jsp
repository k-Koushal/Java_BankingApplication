
<%
 String message=(String)session.getAttribute("loginMessage");

if(message!=null){
%>
	
<div class="alert alert-danger alert-dismissible fade show w-100 mb-0" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%
session.removeAttribute("message");
}
%>
