



<!DOCTYPE html>
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
   $(".LogIn").click(function () 
              {            
               $(".messageLabel").empty();         
               
               
              var pw = $("#pass").val();
              var email = $("#user").val();
               if(email == null || email == "" || email == default_value )
               {
                  alert('EmailId is blank or invalid');
                  return false;
               }

               else if(pw == null || pw == "")
               {
                alert('Possword cannot be blank');
                return false;
               }
              
            });
          
              var Input = $('#user');
              var default_value = Input.val();

              Input.focus(function() {
                  if(Input.val() == default_value) Input.val("");
              }).blur(function(){
              if(Input.val().length == 0) Input.val(default_value);
              });          
              $("#user").val()="";
              
            

});



</script>


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
               <a href="/login" onClick="document.getElementById('search-form').submit()">Search</a>
               <a href="/login" >LogIn</a>
               <a href="/register" >Register</a></div>-->
                <a href="main.jsp" >Back</a>
            </fieldset>
         </form>
      </div>
   </header>

   <div class="container">
      <!-- aside -->
      <aside>

         

 <h3>user login</h3>
         
         <form action="SignUp" method="post" style="width: 138%;">
      
      <table width="100%">
      	<tr>
				<td>
					EmailId
				</td>
				<td>
					<input type="text" name="user" id="user" value="Email Id" class="tb" tabindex="1"></input>
				</td>
			</tr>
			<tr>
				<td>
					Password
				</td>
				<td>
					<input type="password" name="pass" id="pass" class="tb" tabindex="2"></input>
				</td>
			</tr>
			<tr>
				<td>
					<input class="LogIn" type="submit" name="submit" value="LogIn"/>
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

