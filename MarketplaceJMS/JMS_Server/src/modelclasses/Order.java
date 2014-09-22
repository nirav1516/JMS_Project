package modelclasses;

import java.io.Serializable;

public class Order implements Serializable{
	public String orderid;
	public String orderuserid;
	public String ordproductid;
	public String orqty;
	public String ortotal;
	public String orproname;
	public String orproprice;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderuserid() {
		return orderuserid;
	}
	public void setOrderuserid(String orderuserid) {
		this.orderuserid = orderuserid;
	}
	public String getOrdproductid() {
		return ordproductid;
	}
	public void setOrdproductid(String ordproductid) {
		this.ordproductid = ordproductid;
	}
	public String getOrqty() {
		return orqty;
	}
	public void setOrqty(String orqty) {
		this.orqty = orqty;
	}
	public String getOrtotal() {
		return ortotal;
	}
	public void setOrtotal(String ortotal) {
		this.ortotal = ortotal;
	}
	public String getOrproname() {
		return orproname;
	}
	public void setOrproname(String orproname) {
		this.orproname = orproname;
	}
	public String getOrproprice() {
		return orproprice;
	}
	public void setOrproprice(String orproprice) {
		this.orproprice = orproprice;
	}
}
