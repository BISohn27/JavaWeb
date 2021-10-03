package dto;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String zipcode;
	private String address;
	private String phone;
	private String useyn;
	private String indate;
	
	public String getId() {
		return id;
	}
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public MemberVO setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberVO setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getZipcode() {
		return zipcode;
	}
	public MemberVO setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public MemberVO setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public MemberVO setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public MemberVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public String getIndate() {
		return indate;
	}
	public MemberVO setIndate(String indate) {
		this.indate = indate;
		return this;
	}
}
