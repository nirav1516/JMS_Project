package Connection;

import java.sql.*;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class DatabaseConnection {
	Connection con= null;
	static ResultSet rs;
	Statement stmt,upstmt;
	
	DatabaseConnection(){
		try{
			System.out.println("Inside data connection.");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "1202");
			if(con == null)
			{
				System.out.println("Null con.");
			}
			System.out.println("got connection.");
			stmt = con.createStatement();
			upstmt = con.createStatement();
		}
		catch (SQLException e) {
			// TODO: handle exception
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String signup(String username,String pwd)
	{
		String result = "";
		int rowcount;
		System.out.println("Inside signup Dataconnection.");
		try
		{
			String query = "Insert into Customer (username,password) values ('"+ username +"','"+ pwd +"') ";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0)
			{
				result = "true";
				System.out.println("Insert successful");
			}
			else {
				result = "false : could not be inserted";
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public String insertproductQuery(String uid,String catId,String proname,String prodesc,String proprice,String proqty)
	{
		int rowcount;
		String result = "";
		System.out.println("Inside insertproductQuery");
		System.out.println("Catalogname: " + catId + ", product : "+ proname +", description "+ prodesc + ", price: "  + proprice+", quantity: "+ proqty);
	 	
		
		String sql = "INSERT INTO products (name,productdescription,productprice,totqty,catalogId,Seller) VALUES ('"+ proname + "','"+ prodesc +"','"+ proprice +"','"+proqty+"','"+ catId +"','"+ uid +"');";
		
		try {
			rowcount =  stmt.executeUpdate(sql);
			if (rowcount > 0) {
				
	            result = "true:data inserted successfully";
	            System.out.println("Product Insert successful");
	        }
	        else
	        {
	        	System.out.println("Product Insert failed");
	        	result = "false:Insertion failed";        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Product Insert failed");
			result = "false : could not be inserted";
			return result;
		}
		
			 
		return result;
				 
		
}

	
	public String insertcatQuery(String catname){
		System.out.println("Inside insertcatQuery Databaseconnection");
		System.out.println("Catalogname: " + catname);
		String result ="";
		int rowcount;

	String sql = "INSERT INTO catalogs (catName) VALUES ('"+ catname + "');";
	System.out.println(sql);
		try {
			rowcount =  stmt.executeUpdate(sql);
			if (rowcount > 0) {
				
	            result = "true:datainserted successfully";
	            System.out.println("Catalog Insert successful");
	        }
	        else
	        {
	        	System.out.println("Catalog Insert failed");
	        	result = "false:Insertionfailed";        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Catalog Insert failed");
			result = "false : could not be inserted";
			return result;
		}
		
			 
		return result;
}

	
	public String insertAndQuery(String firstname,String lname,String email,String password){
		
		String result="";
		int rowcount;
		System.out.println("Inside insertAndQuery");
		try{
			String sql = "INSERT INTO userdetail (firstname,lastname,emailid,password) VALUES ('"+ firstname + "','" + lname + "','" + email + "','" + password + "')";
			rowcount = stmt.executeUpdate(sql);
			if (rowcount > 0)
			{
				result = "true";
				System.out.println("Insert successful");
			}
			else {
				result = "false : could not be inserted";
			}
		}catch (SQLException e) {
			// TODO: handle exception
			result = "false : could not be inserted";
			return result;
			//e.printStackTrace();
		}
		
		return result;
		
	}
	
	public ResultSet checkLogInData(String userName,String password){
		String result = "";
		ResultSet rset = null;
		System.out.println("Inside checkLogInData");
		try{
			String sql = "SELECT * FROM userdetail where emailid= '" + userName + "' and password = '" + password + "'";
			rset = stmt.executeQuery(sql);
			
			if (!rset.isBeforeFirst() ) {    
				 System.out.println("No data in checklogindata"); 
				 result =  "nodata";
			}
			else{
				System.out.println("Data checklogindata");
				String sqltimeupdate = "update userdetail set Lastlogin = Now() where 	emailid= '" + userName + "' ;";
				int cupdate = upstmt.executeUpdate(sqltimeupdate);
				if(cupdate > 0){
					System.out.println("Time updated successfully");
				}else{
					System.out.println("Time not updated successfully");
				}
				result = "data";
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rset;
	}

	public ResultSet fetchcatalog(){
		System.out.println("Inside fetchcatalog.");
		ResultSet rset = null;
		try{
			String sql = "select catId as id,catName as name from catalogs;";
			rset = stmt.executeQuery(sql);
			if(!rset.isBeforeFirst())
			{
				System.out.println("NO DATA: Result set NOT fetched for fetchcatalog.");
			}
			else{
				System.out.println("Result set fetched for fetchcatalog.");
				
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return rset;
		
	}

	public ResultSet fetchproduct(String procatid,String uid){
		System.out.println("Inside fetchcatalog.");
		ResultSet rset = null;
		String result = "";
		try{

			String sql = "select idproducts as proid,name as proname,productdescription as prodesc,productprice,totqty,"
			+ "CatalogId as catname,ifnull(u.firstname,'cart') as sellerinfo from products pd LEFT JOIN userdetail u ON pd.Seller = u.userid where CatalogId = '"+ procatid +"' && pd.Seller != '"+ uid +"' and totqty > 0;";
			rset = stmt.executeQuery(sql);
			
			if (!rset.isBeforeFirst() ) {    
				 System.out.println("No data in checklogindata"); 
				 result =  "nodata";
			}
			else{
				System.out.println("Data checklogindata");
				result = "data";
			}


			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rset;
	}
	
	public ResultSet fetchMyproduct(String uid){
		System.out.println("Inside fetchcatalog.");
		ResultSet rset = null;
		String result = "";
		try{

			String sql = "select idproducts as proid,name as proname,productdescription as prodesc,productprice,totqty,"
			+ "CatalogId as catname,ifnull(u.firstname,'cart') as sellerinfo from products pd LEFT JOIN userdetail u ON pd.Seller = u.userid where pd.Seller = '"+ uid +"' and pd.totqty>0 ;";
			rset = stmt.executeQuery(sql);
			
			if (!rset.isBeforeFirst() ) {    
				 System.out.println("No data in checklogindata"); 
				 result =  "nodata";
			}
			else{
				System.out.println("Data checklogindata");
				result = "data";
			}


			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rset;
	}
	
	
	public String addProductsToCart(String uId,String proId) throws SQLException{
		
		System.out.println("userID: " + uId + "prductid: " + proId );
		ResultSet preproductrset,precatrset;
		String result = "";
		String sql = "select idproducts as proid,productprice,totqty  from products where idproducts = '"+ proId +"' and totqty > 0;";

		
		preproductrset = stmt.executeQuery(sql);
		
			if (!preproductrset.isBeforeFirst()) {
				
	            System.out.println("ERROR: addproducttocart : select pre product" );
	            
	        }
	        else{
	        	double proprice = 0;
	        	int proavailable = 0;
	        	while(preproductrset.next()){
	        		 proprice = preproductrset.getDouble("productprice");
		        	 proavailable = preproductrset.getInt("totqty");
	        	}
	        	

	        	String sqlcat = "select cartId,cartqty,carttotalcharge from cartdetails where productId = '"+ proId +"' and userId = '" + uId +"' ;" ;
	        	precatrset = stmt.executeQuery(sqlcat);
	        	
				proavailable = proavailable -1;
				String sqlupdateproduct = "update products set totqty = '"+ proavailable +"' where idproducts= '"+ proId +"';"; 
								

								if(precatrset.isBeforeFirst()){
									
									double catcharge ;
	        						int cartquantity = 0 ;
	        						int cartupId = 0 ;
	        						
	        						if(precatrset.next()){
	        							cartquantity = precatrset.getInt("cartqty");
	        							cartupId = precatrset.getInt("cartId");
	        						}

	        						cartquantity = cartquantity + 1;        					
	        						catcharge = proprice * cartquantity;

	        						String sqlupdatecart = "update cartdetails set cartqty = '"+ cartquantity +"' , carttotalcharge = '"+ catcharge +"' where cartId = '"+ cartupId +"';";
	        						System.out.println(sqlupdatecart);
	        						int rowcount = stmt.executeUpdate(sqlupdatecart);
										if (rowcount <= 0) {
											
											System.out.println("error in up cat :" );
										}
										else
										{
												int rowuppro = stmt.executeUpdate(sqlupdateproduct);
												if (rowuppro<= 0) {
													
													System.out.println("error in pro1 :" );
													result =  "false";
												}
												else
												{
													result =  "true : update successful";
													
												}
											
										}
									
								}
								else{
									double catcharge = proprice;
	        						int cartquantity = 1;
	        						

	        						String sqlupdatecart = "insert into cartdetails (userId,productId,cartqty,carttotalcharge) "
	        						+"values ('"+ uId +"','"+ proId +"','"+ cartquantity +"','"+ catcharge +"')  ;";

	        						int rowcount = stmt.executeUpdate(sqlupdatecart);
										if (rowcount <= 0 ) {
											//callback(err,catalogdata,rowsprodust);
											System.out.println("error in ins cat :");
										}
										else
										{
												int rowcountpro = stmt.executeUpdate(sqlupdateproduct);
											
												if (rowcountpro <= 0) {
													
													result = "false";
												}
												else
												{
													
													result = "true";
												}
											
										}
									
	        						
								}


							}
			return result;
				
	        }

	
public String deleteproduct(String proId) throws SQLException{
		
		System.out.println("prductid: " + proId );
		
		String result = "";
		String sql = "update products set totqty=0 where idproducts = '"+ proId +"' ;";
		System.out.println("delete query : "+sql);
		
		int rowcountpro = stmt.executeUpdate(sql);
											
		if (rowcountpro <= 0) {
													
			result = "false";
		}
		else
		{
		
			result = "true";
		}
									
	        					
			return result;
				
}

	public String insertOrderQuery(String userid) throws SQLException{
		String result = "";
		String sqlorder = "";
		ResultSet rsetcart;
		String sqlgetcat = "select * from cartdetails where userId = '"+ userid +"';";
		System.out.println(sqlgetcat);	
		rsetcart = stmt.executeQuery(sqlgetcat);

		if (!rsetcart.isBeforeFirst()) {
						
			System.out.println("error in getting cart insertOrderQuery :" );
		}
		else{
						
			if(rsetcart.next()){				 
				sqlorder = "insert into orderdetails (userId,productId,orqty,totalcharge) values" +
						" ('"+ rsetcart.getString("userId") +"','"+ rsetcart.getString("productId") +"','"+ rsetcart.getString("cartqty") +"','"+ rsetcart.getString("carttotalcharge") +"') ;";
				System.out.println(sqlorder);				
				if(stmt.executeUpdate(sqlorder)<=0){
						System.out.println("Error in insert order:");
						result = "false";
				}
								

		}

			String sqldltcart = "delete from cartdetails where userId ='"+  userid+"';";
							 
			if(stmt.executeUpdate(sqldltcart)<=0){
				System.out.println("Error in update cart:");
				result = "false";
			}
			else{
										
				System.out.println("Success in update cart and order:");
				result = "true";
			}
								
		}		
			return result;
				
	}
	
	public ResultSet fetchcartdata(String catuId) throws SQLException{
			ResultSet cartrset = null;
			
			String sql = "select cd.*,pd.name,pd.productprice from cartdetails cd LEFT JOIN products pd ON pd.idproducts = cd.productId where cd.userId = '"+ catuId +"';";
			cartrset = stmt.executeQuery(sql);
			
			
			if (!cartrset.isBeforeFirst()) {
				
				System.out.println("error in getting cart fetchcartdata:" );
			}
			else{
				
				System.out.println("Got data fetchcartdata");
						
			}
			
			return cartrset;
	}
	
	public ResultSet fetchcarttotal(String catuId) throws SQLException{
		ResultSet totcartrset = null;
		
		String sql = "select sum(cd.carttotalcharge) as total from cartdetails cd LEFT JOIN products pd ON pd.idproducts = cd.productId where cd.userId = '"+ catuId+"';";
		totcartrset = stmt.executeQuery(sql);
		
		
		if (!totcartrset.isBeforeFirst()) {
			
			System.out.println("error in getting cart total fetchcarttotal:" );
		}
		else{
			//var sqlcat = 'select sum(cd.carttotalcharge) as total from cartdetails cd LEFT JOIN products pd ON pd.idproducts = cd.productId where cd.userId = '+ catuId+';';
			System.out.println("Got total fetchcarttotal");
					
		}
		
		return totcartrset;
	}
	
	public ResultSet fetchorderdatA(String catuId) throws SQLException{
		ResultSet rsetorder = null;
		
		String sql = "select cd.*,pd.name,pd.productprice from orderdetails cd LEFT JOIN products pd ON pd.idproducts = cd.productId where cd.userId = '"+ catuId +"';";
		rsetorder = stmt.executeQuery(sql);
		
		
		if (!rsetorder.isBeforeFirst()) {
			
			System.out.println("error in getting order fetchorderDATA:" );
		}
		else{
			
			System.out.println("Got data fetchorderdata");
					
		}
		
		return rsetorder;
	}
	
	public ResultSet fetchSellingHistorydatA(String catuId) throws SQLException{
		ResultSet rsetorder = null;
		
		String sql = "select cd.*,ub.firstname as buyer,pd.name,pd.productprice from orderdetails cd " +
							" LEFT JOIN products pd ON pd.idproducts = cd.productId "+ 
							" LEFT JOIN userdetail u ON pd.Seller = u.userid " +
							" LEFT JOIN userdetail ub ON cd.userID = ub.userid  "+
							"where pd.Seller = '"+ catuId +"';";
		rsetorder = stmt.executeQuery(sql);
		
		
		if (!rsetorder.isBeforeFirst()) {
			
			System.out.println("error in getting Selling history fetchSellingHistorydatA:" );
		}
		else{
			
			System.out.println("Got data Selling history fetchSellingHistorydatA");
					
		}
		
		return rsetorder;
	}
	
	
	public ResultSet fetchordertotal(String catuId) throws SQLException{
		ResultSet rsettotorder = null;
		
		String sql = "select sum(cd.totalcharge) as total from orderdetails cd LEFT JOIN products pd ON pd.idproducts = cd.productId where cd.userId = '"+ catuId+"';";
		rsettotorder = stmt.executeQuery(sql);
		
		
		if (!rsettotorder.isBeforeFirst()) {
			
			System.out.println("error in getting cart total fetchordertotal:" );
		}
		else{
			//var sqlcat = 'select sum(cd.carttotalcharge) as total from cartdetails cd LEFT JOIN products pd ON pd.idproducts = cd.productId where cd.userId = '+ catuId+';';
			System.out.println("Got total fetchordertotal");
					
		}
		
		return rsettotorder;
	}
	
	
}


