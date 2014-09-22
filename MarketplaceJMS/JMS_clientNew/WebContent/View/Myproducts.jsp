<%@page import="modelclasses.Product"%>
<%@page import="modelclasses.Catalog"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Home - Home Page | Shopping !s fun - Free Website Template from Templates.com</title>
<meta charset="utf-8">
<meta name="description" content="Place your description here">
<meta name="keywords" content="put, your, keyword, here">
<meta name="author" content="Templates.com - website templates provider">
<link rel="stylesheet" href="../public/css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="../public/css/style.css" type="text/css" media="all">
<script type="text/javascript" src="../public/js/jquery-1.4.2.min.js" ></script>
<script type="text/javascript" src="../public/js/cufon-yui.js"></script>
<script type="text/javascript" src="../public/js/cufon-replace.js"></script>
<script type="text/javascript" src="../public/js/Myriad_Pro_300.font.js"></script>
<script type="text/javascript" src="../public/js/Myriad_Pro_400.font.js"></script>
<script type="text/javascript" src="../public/js/script.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">


$(document).ready(function()
{
	
	//alert("I M READY");
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	var catid = getParameterByName('catid');
		
   $(".delete").click(function () 
              {            
               $(".messageLabel").empty();         
               
               
               	  //var data = {};
               	var pId = $(this).attr("id");
               	var datastring = "productId=" + pId;
                  
                  //alert(pId) ;       
                  var ajax_url = "DeleteProduct";      
                  //alert(data.input_no_of_products);
            
                  $.ajax({
                     type: "POST",
                     url:ajax_url,
                     data: datastring,
                    // contentType: 'application/json',
                     
                     success: function(output_string) 
                     {                    
                        //$(".messageLabel").append("Successfully Added"); 
                        alert('Product successfully deleted');
                        location.reload();
                     },
                     error: function (error) {
                           alert('Error');
                     }
                  }); 
            });

});



</script>
</head>
<body id="page1">
<div class="wrap">
   <!-- header -->
<%@include file="menu.jsp" %>
   <div class="container">
      <!-- aside -->
      <aside>
      	<%-- <%@ page import = "javax.servlet.RequestDispatcher" %>
		<%if(request.getParameter("catid")!=null){
		request.setAttribute("catid", "1234"); %>
			<h3><%= request.getParameter("catid") %></h3>
			
			<jsp:forward page="/View/GetProducts"  />
			
		<%}else{%>
			<h3>Categories</h3>
		<%}%> --%>
         
         <ul class="categories">
         	
         	
         	         
         </ul>
      </aside>
      <!-- content -->
      <section id="content">
         <div id="banner">
           <!--  <h2>Professional <span>Online Education <span>Since 1992</span></span></h2> -->
         </div>
         <div class="ic">More Website Templates at TemplateMonster.com!</div>
         <div class="inside">
            <h2> <span>My Products</span></h2>
            <ul class="list">
				<%  
			// retrieve your list from the request, with casting 
				if(request.getAttribute("productlist") != null){
					Product[] prolist =  (Product[]) request.getAttribute("productlist");
					// print the information about every category of the list
					for(int i =0;i<prolist.length;i++) {%>
						
					    <li class="table" ><span></span>
                                       <h4><%= prolist[i].getProname() %></h4>
                                       <table>
                                       	  
                                          <tr>
                                             <td style="height: 50px;">
                                                <%= prolist[i].getProdesc() %>
                                             </td>
                                          </tr>
                                          <tr>
                                             <td>
                                                Price : $ <%= prolist[i].getProprice() %>
                                             </td>
                                          </tr>
                                          <tr>
                                             <td>
                                                Quantity : <%= prolist[i].getProqty() %>
                                             </td>
                                          </tr>
                                          
                                          <tr>
                                             <td>
                                                <button class="delete" id="<%= prolist[i].getProid()%>">Delete</button>
                                                
                                             </td>
                                          </tr>
                                       </table>
                                     
                                    </li>
					<%}
				    
				}%>
				
            </ul>
            

            
         </div>
      </section>
   </div>
</div>
<!-- footer -->
<footer>
   <div class="container">
      <div class="inside">
         <div class="wrapper">
            <div class="fleft">24/7 Customer Service <span>4089871206</div>
            
         </div>
      </div>
   </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
