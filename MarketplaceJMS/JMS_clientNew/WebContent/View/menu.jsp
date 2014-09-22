            
<header>
      <div class="container">
         <label for="task1" class="messageLabel" style="font-weight: bold;color: green;"></label>
          <h1><a href="/home">Shopping !S fun</a></h1> 
         <nav>
			<ul>
               <li ><a href="index.jsp" class="m1">Home Page</a></li>  
               <li ><a href="InsertProduct.jsp" class="m5">New Product</a></li>
               <li><a href="/JMS_clientNew/View/Myproducts" class="m3">My Products</a></li>
               <li><a href="/JMS_clientNew/View/usercart" class="m3">Cart</a></li>
               <li><a href="/JMS_clientNew/View/orderdetails" class="m3">Purchase</a></li>
               <li><a href="/JMS_clientNew/View/MySales" class="m3">Sales</a></li>
               <li class="last"><a href="main.jsp" class="m2">LogOut</a></li>
            </ul>
            
         </nav>
         <form action="" id="search-form">
            <fieldset>
            <div class="rowElem">
               <!-- <input type="text"> 
               <a href="/login" onClick="document.getElementById('search-form').submit()">Search</a>-->
               <!--  -->

               <% if(session.getAttribute("username")!= null ) {%>
                     <h4>Welcome <%= session.getAttribute("username") %></h4>
                     <% if (session.getAttribute("lastlogin")!= null  && session.getAttribute("lastlogin")!= "" ) {%>
                     <h5>Last Login : <%= session.getAttribute("lastlogin") %></h5>
                     <%} %>
                                    
               <%} %>
               
            </fieldset>
         </form>
      </div>
   </header>