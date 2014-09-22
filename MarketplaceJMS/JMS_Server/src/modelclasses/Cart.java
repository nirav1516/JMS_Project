package modelclasses;

import java.io.Serializable;

public class Cart implements Serializable{
	public String cartid;
	public String cartuserid;
	public String productid;
	public String cartqty;
	public String carttotal;
	public String proname;
	public String proprice;
	
	
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getCartuserid() {
		return cartuserid;
	}
	public void setCartuserid(String cartuserid) {
		this.cartuserid = cartuserid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getCartqty() {
		return cartqty;
	}
	public void setCartqty(String cartqty) {
		this.cartqty = cartqty;
	}
	public String getCarttotal() {
		return carttotal;
	}
	public void setCarttotal(String carttotal) {
		this.carttotal = carttotal;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProprice() {
		return proprice;
	}
	public void setProprice(String proprice) {
		this.proprice = proprice;
	}
}
