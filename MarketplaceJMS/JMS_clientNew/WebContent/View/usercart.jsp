<%@page import="modelclasses.Cart"%>
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
   $(".checkout").click(function () 
              {            
               $(".messageLabel").empty();         
               
               var num = $("#cardno").val();
                if(isNaN(num)){
                  alert('Please enter only numbers in card number.'+ num);
                  return false;
                }
                else if(num.length <16 || num.length>16){
                  alert('card number must be a 16 digit number.');
                  return false;
                }
                else
                {
                    return true;
                }
              
            });
          
              var Input = $('#cardno');
              var default_value = Input.val();

              Input.focus(function() {
                  if(Input.val() == default_value) Input.val("");
              }).blur(function(){
              if(Input.val().length == 0) Input.val(default_value);
              });          
              $("#cardno").val()="";
              
            

});



</script>
<!--[if lt IE 7]>
     <link rel="stylesheet" href="css/ie/ie6.css" type="text/css" media="screen">
     <script type="text/javascript" src="js/ie_png.js"></script>
     <script type="text/javascript">
        ie_png.fix('.png, footer, header nav ul li a, .nav-bg, .list li img');
     </script>
<![endif]-->
<!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5.js"></script>
  <![endif]-->
</head>
<body id="page1">
<div class="wrap">
   <!-- header -->
  <%@include file="menu.jsp" %>
   <div class="container">
      <!-- aside -->
      <aside>

         <h3></h3>

         <ul class="categories">
          <% if(request.getAttribute("usercart") != null){
             if(request.getAttribute("carttotal")  != null && request.getAttribute("carttotal") != "" ) {%>
                      <li><span> <h4>Grand Total: $ <%= request.getAttribute("carttotal") %></h4></span></li>
                       <form action="procedetoorder" method="post" >
                         <li><span><input type="text" name="cardno" id="cardno" class="tb" value="Card Number" tabindex="2" ></input></span></li>
                         <li><span><button class="checkout" tabindex="3"  >checkout</button></span></li>
                      </form>
                    <!-- <a href="/register" >Register</a></div> -->
                 <%} %>
            <%} %>
         </ul>

     </aside>
      <!-- content -->
      <section id="content">
         <div id="banner">
           <!--  <h2>Professional <span>Online Education <span>Since 1992</span></span></h2> -->
         </div>
         <div class="ic">More Website Templates at TemplateMonster.com!</div>
         <div class="inside">
            <h2> <span> Cart Details</span></h2>
            <ul class="list">

               <% if(request.getAttribute("usercart") != null){
					Cart[] cartdata =  (Cart[]) request.getAttribute("usercart");
					// print the information about every category of the list
					for(int i =0;i<cartdata.length;i++) {%>
                            
                                    <li class="table"><span></span>
                                       <h4><%= cartdata[i].getProname() %></h4>

                                       <table>
                                          
                                          <tr>
                                             <td>
                                                Price : $ <%= cartdata[i].getProprice() %>
                                             </td>
                                          </tr>
                                          <tr>
                                             <td>
                                                Quantity : <%= cartdata[i].getCartqty() %>
                                             </td>
                                          </tr>
                                          <tr>
                                             <td>
                                                Total : <%= cartdata[i].getCarttotal() %>
                                             </td>
                                          </tr>
                                       </table>
                                    
                                    </li>
                                    
                             
                            
                                
                     <% } %>
               <% } else { %>
                  <h2> <span><h4>No products in cart</h4></span></h2>
                <% } %>
               
               
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
            <!-- <div class="aligncenter"><a rel="nofollow" href="http://www.templatemonster.com" class="new_window">Website template</a> designed by TemplateMonster.com<br>
               <a href="http://www.templates.com/product/3d-models/" class="new_window">3D Models</a> provided by Templates.com</div> -->
         </div>
      </div>
   </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
