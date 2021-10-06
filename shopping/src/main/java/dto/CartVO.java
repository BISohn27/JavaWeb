package dto;

public class CartVO {
	private int cseq;
	private int pseq;
	private String id;
	private String mname;
	private String pname;
	private int quantity;
	private String indate;
	private int price2;
	
	public String getPname() {
		return pname;
	}
	public CartVO setPname(String pname) {
		this.pname = pname;
		return this;
	}
	private int result;
	
	public int getCseq() {
		return cseq;
	}
	public CartVO setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public CartVO setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public CartVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public CartVO setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public CartVO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getIndate() {
		return indate;
	}
	public CartVO setIndate(String indate) {
		this.indate = indate;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public CartVO setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getResult() {
		return result;
	}
	public CartVO setResult(int result) {
		this.result = result;
		return this;
	}
	
	
}
