package dto;

public class OrderVO {
	private int odseq;
	private int oseq;
	private String id;
	private String indate;
	private int pseq;
	private int quantity;
	private String name;
	private String zipcode;
	private String address;
	private String phone;
	private String pname;
	private int price2;
	
	public int getOdseq() {
		return odseq;
	}
	public OrderVO setOdseq(int odseq) {
		this.odseq = odseq;
		return this;
	}
	public int getOseq() {
		return oseq;
	}
	public OrderVO setOseq(int oseq) {
		this.oseq = oseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public OrderVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getIndate() {
		return indate;
	}
	public OrderVO setIndate(String indate) {
		this.indate = indate;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public OrderVO setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public OrderVO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getName() {
		return name;
	}
	public OrderVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getZipcode() {
		return zipcode;
	}
	public OrderVO setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public OrderVO setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public OrderVO setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public OrderVO setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public OrderVO setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	
	
}
