package modelclasses;

import java.io.Serializable;

public class Product implements Serializable{
	public String proid;
	public String proname;
	public String prodesc;
	public String proprice;
	public String proqty;
	public String procatid;
	public String sellerinfo;
	
	public String getSellerinfo() {
		return sellerinfo;
	}
	public void setSellerinfo(String sellerinfo) {
		this.sellerinfo = sellerinfo;
	}
	public String getProid() {
		return proid;
	}
	public void setProid(String proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProdesc() {
		return prodesc;
	}
	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}
	public String getProprice() {
		return proprice;
	}
	public void setProprice(String proprice) {
		this.proprice = proprice;
	}
	public String getProqty() {
		return proqty;
	}
	public void setProqty(String proqty) {
		this.proqty = proqty;
	}
	public String getProcatid() {
		return procatid;
	}
	public void setProcatid(String procatid) {
		this.procatid = procatid;
	}
}
