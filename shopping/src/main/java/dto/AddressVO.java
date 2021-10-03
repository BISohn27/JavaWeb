package dto;

public class AddressVO {
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String ri;
	private String bldg;
	private String bunji;
	
	public String getZipcode() {
		return zipcode;
	}
	public AddressVO setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}
	public String getSido() {
		return sido;
	}
	public AddressVO setSido(String sido) {
		this.sido = sido;
		return this;
	}
	public String getGugun() {
		return gugun;
	}
	public AddressVO setGugun(String gugun) {
		this.gugun = gugun;
		return this;
	}
	public String getDong() {
		return dong;
	}
	public AddressVO setDong(String dong) {
		this.dong = dong;
		return this;
	}
	public String getRi() {
		return ri;
	}
	public AddressVO setRi(String ri) {
		this.ri = ri;
		return this;
	}
	public String getBldg() {
		return bldg;
	}
	public AddressVO setBldg(String bldg) {
		this.bldg = bldg;
		return this;
	}
	public String getBunji() {
		return bunji;
	}
	public AddressVO setBunji(String bunji) {
		this.bunji = bunji;
		return this;
	}
}
