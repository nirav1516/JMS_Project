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

$(document).on('click', '#add_to_cart', function(e) {
   alert("Hi");
   var data = {'id' : 1};
   $.ajax({
      type:'POST',
      data : JSON.stringify(data),
      contentType:'application/json',
      url:'/addToCart'
   }).done(function(res){
      alert("Success");
      alert(res);
   });
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
   <header>
      <div class="container">
          <h1><a href="main.jsp">Shopping !S fun</a></h1> 
         <nav>
            <ul>
               
            </ul>
         </nav>
         <form action="" id="search-form">
            <fieldset>
            <div class="rowElem">
               <!-- <input type="text"> 
               <a href="/login" onClick="document.getElementById('search-form').submit()">Search</a>-->
               <!--  -->
              
                  <a href="SignUp.jsp" >LogIn</a>
                  <a href="Register.jsp" >Register</a></div>
               
               
            </fieldset>
         </form>
      </div>
   </header>
   <div class="container">
      <!-- aside -->
      <aside>

         <h3></h3>
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
            <h2>Sign in to enjoy shopping..! <span></span></h2>
            <ul class="list">

               
               
               
            </ul>
            

            <!-- <h2>Move Forward <span>With Your Education</span></h2>
            <p><span class="txt1">Studentâ€™s Site</span> is a free web template created by TemplateMonster.com team. This website template is optimized for 1024X768 screen resolution. </p>
            <div class="img-box"><img src="images/1page-img.jpg">This website template can be delivered in two packages - with PSD source files included and without them. If you need PSD source files, please go to the template download page at TemplateMonster to leave the e-mail address that you want the template ZIP package to be delivered to.</div>
            <p class="p0">This website template has several pages: <a href="index.html">Home</a>, <a href="about-us.html">About us</a>, <a href="articles.html">Articles</a> (with Article page), <a href="contact-us.html">Contact us</a> (note that contact us form â€“ doesnâ€™t work), <a href="sitemap.html">Site Map</a>.</p> -->
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
