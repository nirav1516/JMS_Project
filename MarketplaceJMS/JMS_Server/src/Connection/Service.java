package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelclasses.*;

import javax.jws.WebService;

@WebService
public class Service {
	DatabaseConnection db = new DatabaseConnection();
	
	public User login(String username,String pwd) throws SQLException {
		System.out.println("Inside login Service");
		String result;
		ResultSet rset ;
		User u = new User();
		
		rset = db.checkLogInData(username, pwd);
		if (rset != null){
			while(rset.next()){
				u.setUserid(rset.getString("userid"));
				u.setUsername(rset.getString("firstname"));
				System.out.println(rset.getDate("Lastlogin"));
				u.setLastlogin(rset.getString("Lastlogin"));
			}
		}
		System.out.println("Going to return to client");
		return u;
	}

	public String insertcatalog(String catname) {
		System.out.println("Inside Service : insertcatalog");
		String result;
		
		result = db.insertcatQuery(catname);
		return result;
	}
	
	public String addproducttocart(String uid,String proid) throws SQLException{
		System.out.println("Inside Service : addproducttocart");
		String result;
		
		result = db.addProductsToCart(uid, proid);
		return result;
	}
	
	public String deleteproduct(String proid) throws SQLException{
		System.out.println("Inside Service : deleteproduct");
		String result;
		
		result = db.deleteproduct(proid);
		return result;
	}
	
	
	public String insertproduct(String uid,String catId,String proname,String prodesc,String proprice,String proqty) {
		System.out.println("Inside Service : insertproduct");
		String result;
		
		result = db.insertproductQuery(uid,catId, proname, prodesc, proprice, proqty);
		return result;
	}	
	
	public String register(String fname,String lname,String email,String pwd) {
		System.out.println("Inside Service");
		String result;
		
		result = db.insertAndQuery(fname, lname, email, pwd);
		return result;
	}
	
	public Catalog[] fetchcatlogs() throws SQLException{
		System.out.println("Inside fetchlog");
		int rowcount = 0;
		ResultSet rset;
		rset = db.fetchcatalog();
		if(rset != null){
			System.out.println("Inside if statement fetchlog");
			try {
				rset.beforeFirst();
				rset.last();
				rowcount = rset.getRow();
				System.out.println("rows: "+ rowcount);
				rset.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Inside else - no data - statement fetchlog");
		}
		
		
		Catalog[] catalogs = new Catalog[rowcount];
		
		int i =0;
		while(rset.next()){
			Catalog c = new Catalog();
			
			System.out.println(rset.getString("id"));
			System.out.println(rset.getString("name"));
			c.setCatid(rset.getString("id"));
			c.setCatname(rset.getString("name"));
			catalogs[i] = c;
			i++;
		}
		
		return catalogs;
	}
	
	public Product[] fetchproducts(String procatid,String uid) throws SQLException{
		System.out.println("Inside fetchProduct");
		int rowcount = 0;
		ResultSet rset;
		rset = db.fetchproduct(procatid,uid);
		if(rset != null){
			System.out.println("Inside if statement fetchlog");
			try {
				rset.beforeFirst();
				rset.last();
				rowcount = rset.getRow();
				System.out.println("rows: "+ rowcount);
				rset.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Inside else - no data - statement fetchlog");
		}
		
		
		Product[] products = new Product[rowcount];
		
		int i =0;
		while(rset.next()){
			Product p = new Product();
			
			/*System.out.println(rset.getString("id"));
			System.out.println(rset.getString("name"));*/
			
			p.setProid(rset.getString("proid"));
			p.setProname(rset.getString("proname"));
			p.setProdesc(rset.getString("prodesc"));
			p.setProprice(rset.getString("productprice"));
			p.setProqty(rset.getString("totqty"));
			p.setProcatid(rset.getString("catname"));
			p.setSellerinfo(rset.getString("sellerinfo"));
			products[i] = p;
			i++;
		}
		
		return products;
	}
	
	public Product[] fetchMyproducts(String uid) throws SQLException{
		System.out.println("Inside fetchProduct");
		int rowcount = 0;
		ResultSet rset;
		rset = db.fetchMyproduct(uid);
		if(rset != null){
			System.out.println("Inside if statement fetchlog");
			try {
				rset.beforeFirst();
				rset.last();
				rowcount = rset.getRow();
				System.out.println("rows: "+ rowcount);
				rset.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Inside else - no data - statement fetchlog");
		}
		
		
		Product[] products = new Product[rowcount];
		
		int i =0;
		while(rset.next()){
			Product p = new Product();
			
			/*System.out.println(rset.getString("id"));
			System.out.println(rset.getString("name"));*/
			
			p.setProid(rset.getString("proid"));
			p.setProname(rset.getString("proname"));
			p.setProdesc(rset.getString("prodesc"));
			p.setProprice(rset.getString("productprice"));
			p.setProqty(rset.getString("totqty"));
			p.setProcatid(rset.getString("catname"));
			p.setSellerinfo(rset.getString("sellerinfo"));
			products[i] = p;
			i++;
		}
		
		return products;
	}
	
	
	public Cart[] fetchcartdata(String uid) throws SQLException{
		
		System.out.println("Inside fetchcartdata");
		int rowcount = 0;
		ResultSet rset;
		rset = db.fetchcartdata(uid);
		if(rset != null){
			System.out.println("Inside if statement fetchcartdata");
			try {
				rset.beforeFirst();
				rset.last();
				rowcount = rset.getRow();
				System.out.println("rows: "+ rowcount);
				rset.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Inside else - no data - statement fetchlog");
		}
		
		
		Cart[] carts = new Cart[rowcount];
		
		int i =0;
		while(rset.next()){
			Cart c = new Cart();
			
			/*System.out.println(rset.getString("id"));
			System.out.println(rset.getString("name"));*/
			
			c.setCartid(rset.getString("cartId"));
			c.setCartuserid(rset.getString("userId"));
			c.setProductid(rset.getString("productId"));
			c.setCartqty(rset.getString("cartqty"));
			c.setProprice(rset.getString("productprice"));
			c.setCarttotal(rset.getString("carttotalcharge"));
			c.setProname(rset.getString("name"));
			carts[i] = c;
			i++;
		}
		
		return carts;
	}
	
	public double gettotalcart(String uid) throws SQLException{
		System.out.println("Inside gettotalcart");
		double tot = 0;
		ResultSet rset;
		rset = db.fetchcarttotal(uid);
		while(rset.next()){
			tot= rset.getDouble("total");
		}
		return tot;
	}
	public Order[] fetchorderdata(String uid) throws SQLException{
		
		System.out.println("Inside fetchcartdata");
		int rowcount = 0;
		ResultSet rset;
		rset = db.fetchorderdatA(uid);
		if(rset != null){
			System.out.println("Inside if statement fetchcartdata");
			try {
				rset.beforeFirst();
				rset.last();
				rowcount = rset.getRow();
				System.out.println("rows: "+ rowcount);
				rset.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Inside else - no data - statement fetchlog");
		}
		
		
		Order[] orders = new Order[rowcount];
		
		int i =0;
		while(rset.next()){
			Order o = new Order();
			
			/*System.out.println(rset.getString("id"));
			System.out.println(rset.getString("name"));*/
			
			o.setOrderid(rset.getString("orderId"));
			o.setOrderuserid(rset.getString("userId"));
			o.setOrdproductid(rset.getString("productId"));
			o.setOrqty(rset.getString("orqty"));
			o.setOrproprice(rset.getString("productprice"));
			o.setOrtotal(rset.getString("totalcharge"));
			o.setOrproname(rset.getString("name"));
			orders[i] = o;
			i++;
		}
		
		return orders;
	}
	
public Sellinghistory[] fetchSellingHistory(String uid) throws SQLException{
		
		System.out.println("Inside fetchSellingHistory");
		int rowcount = 0;
		ResultSet rset;
		rset = db.fetchSellingHistorydatA(uid);
		if(rset != null){
			System.out.println("Inside if statement fetchSellingHistory");
			try {
				rset.beforeFirst();
				rset.last();
				rowcount = rset.getRow();
				System.out.println("rows: "+ rowcount);
				rset.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Inside else - no data - statement fetchSellingHistory");
		}
		
		
		Sellinghistory[] Sales = new Sellinghistory[rowcount];
		
		int i =0;
		while(rset.next()){
			Sellinghistory s = new Sellinghistory();
			
			/*System.out.println(rset.getString("id"));
			System.out.println(rset.getString("name"));*/
			
			s.setSellproname(rset.getString("name"));
			s.setSellproprice(rset.getDouble("productprice"));
			s.setSellproqty(rset.getInt("orqty"));
			s.setBuyer(rset.getString("buyer"));
			
			Sales[i] = s;
			i++;
		}
		
		return Sales;
	}
	
	public double gettotalorder(String uid) throws SQLException{
		System.out.println("Inside gettotalcart");
		double tot = 0;
		ResultSet rset;
		rset = db.fetchordertotal(uid);
		while(rset.next()){
			tot= rset.getDouble("total");
		}
		return tot;
	}
	
	public String generateOrder(String uid) throws SQLException{
		System.out.println("Inside generateOrder");
		String result;
		
		result = db.insertOrderQuery(uid);
		return result;
	}
}
