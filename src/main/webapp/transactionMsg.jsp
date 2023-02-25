
<%
 String message=(String)session.getAttribute("message");

if(message!=null){
%>
	
<div class="alert alert-info alert-dismissible fade show w-100 mb-0" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%
session.removeAttribute("message");
}
%>
