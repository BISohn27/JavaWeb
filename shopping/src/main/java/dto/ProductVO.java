package dto;

public class ProductVO {
	private int pseq;
	private String name;
	private String kind;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private char useyn;
	private char bestyn;
	private String date;
	
	public int getPseq() {
		return pseq;
	}
	public ProductVO setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getName() {
		return name;
	}
	public ProductVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public ProductVO setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public int getPrice1() {
		return price1;
	}
	public ProductVO setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public ProductVO setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getPrice3() {
		return price3;
	}
	public ProductVO setPrice3(int price3) {
		this.price3 = price3;
		return this;
	}
	public String getContent() {
		return content;
	}
	public ProductVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getImage() {
		return image;
	}
	public ProductVO setImage(String image) {
		this.image = image;
		return this;
	}
	public char getUseyn() {
		return useyn;
	}
	public ProductVO setUseyn(char useyn) {
		this.useyn = useyn;
		return this;
	}
	public char getBestyn() {
		return bestyn;
	}
	public ProductVO setBestyn(char bestyn) {
		this.bestyn = bestyn;
		return this;
	}
	public String getDate() {
		return date;
	}
	public ProductVO setDate(String date) {
		this.date = date;
		return this;
	}
}
