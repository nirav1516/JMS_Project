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

</head>
<body id="page1">
<div class="wrap">
   <!-- header -->
   <%@include file="menu.jsp" %>

   <div class="container">
      <!-- aside -->
      <aside>

         
    <h3>Insert a catalog</h3>
         <!-- <ul class="categories">
            <li><span>Catelog Name : <span></span><input type="text" name="catname" id="Email"></input></span></li>
            <li><span><input type="submit" name="submit" value="Insert"/></span></li>
            
         </ul> -->
         <form action="InsertCatalog" method="post" style="width: 120%;">
      
      <table width="100%">
      
      
         <tr>
            <td>
               Catalog Name:
            </td>
            <td>
               <input type="text" name="catname" id="catalog" class="tb" autofocus></input>
            </td>
         </tr>
         
         <tr>
            <td>
               <input type="submit" name="submit" tabindex="2" value="Insert"/>
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
