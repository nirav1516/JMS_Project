package modelclasses;

import java.io.Serializable;

public class Catalog implements Serializable{
	
	public String catid;
	public String catname;
	
	public String getCatid() {
		return catid;
	}
	public void setCatid(String catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	

}
