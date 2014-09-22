package modelclasses;

import java.io.Serializable;

public class Sellinghistory implements Serializable{
	public String sellproname;
	public double sellproprice;
	public int sellproqty;
	public String buyer;
	
	public String getSellproname() {
		return sellproname;
	}
	public void setSellproname(String sellproname) {
		this.sellproname = sellproname;
	}
	public double getSellproprice() {
		return sellproprice;
	}
	public void setSellproprice(double sellproprice) {
		this.sellproprice = sellproprice;
	}
	public int getSellproqty() {
		return sellproqty;
	}
	public void setSellproqty(int sellproqty) {
		this.sellproqty = sellproqty;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
}
