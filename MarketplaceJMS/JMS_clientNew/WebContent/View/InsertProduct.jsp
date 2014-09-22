<%@page import="setupClasses.JMSSetup"%>
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
   $(".inspro").click(function () 
              {            
               $(".messageLabel").empty();         
               
               var fn = $("#productnm").val();
               var ln = $("#productdesc").val();
              var pw = $("#productprc").val();
              var qty = $("#productqty").val();
              var cat = $("#product_catlog").val();
              

              if(fn == null || fn == "" )
               {
                  alert('Product Name cannot be blank');
                  return false;
               }

               else if(ln == null || ln == "")
               {
                alert('Product Description cannot be blank');
                return false;
               }
               
               else if(pw == null || pw == "")
               {
                alert('Product Price cannot be blank.');
                return false;
               }
               else if(isNaN(pw))
               {
                alert('Product Price should be a number only.');
                return false;
               }
               else if(qty == null || qty == "")
               {
                alert('Product Quantity cannot be blank');
                return false;
               }
               else if(isNaN(qty))
               {
                alert('Product Quantity should be a number only.');
                return false;
               }

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

         

    <h3>Insert a Product</h3>
         <!-- <ul class="categories">
            <li><span>Catelog Name : <span></span><input type="text" name="catname" id="Email"></input></span></li>
            <li><span><input type="submit" name="submit" value="Insert"/></span></li>
            
         </ul> -->
         <form action=InsertProducts method="post" style="width: 138%;">
      
      <table width="100%">
         

         

         <tr>
            <td>
               Select Catalog:
            </td>
            <td style="padding-left: 2px;">
               <select id="product_catlog" name="productCatlog" style="width:160px;" tabindex="1" autofocus>
                     <option value="" disabled="disabled" selected="selected">-- Please select --</option>
                         <%@page import="setupClasses.*" %>
                         <%@page import="modelclasses.*" %>
                         <% JMSSetup proxy = new JMSSetup();
                         Catalog[] catalogs;
                         catalogs = proxy.fetchcatlogs();
     					if(catalogs != null) {%>
                            <% for(int i = 0; i < catalogs.length; i++) { %>
                                 <option value="<%= catalogs[i].getCatid() %>"><%= catalogs[i].getCatname() %></option>
                           <% } %>
                        <% } %>
                                                                                       
               </select>
            </td>
         </tr>      
         <tr>
            <td>
               Product Name:
            </td>
            <td>
               <input type="text" name="proname" id="productnm" class="tb" ></input>
            </td>
         </tr>
         <tr>
            <td>
               Product Description:
            </td>
            <td style="padding-left: 2px;">
               <!-- <input type="text" name="prodesc" id="productdesc" class="tb" ></input> -->
               <textarea rows="4" cols="50" name="prodesc" id="productdesc" style="width:154px;"></textarea>
            </td>
         </tr>
         <tr>
            <td>
               Price:
            </td>
            <td>
               <input type="text" name="proprice" id="productprc" class="tb" ></input>
            </td>
         </tr>
         <tr>
            <td>
               Quatity:
            </td>
            <td>
               <input type="text" name="proqty" id="productqty" class="tb" ></input>
            </td>
         </tr>
         
         <tr>
            <td>
               <input class="inspro" type="submit" name="submit" value="Insert"/>
            </td>
            <td>
               
            </td>
         </tr>

      </table>
      </form>  </aside>
      <!-- content -->
  

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
