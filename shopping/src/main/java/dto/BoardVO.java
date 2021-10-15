package dto;

import java.sql.Date;

public class BoardVO {
	private int qseq;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String req;
	private Date indate;
	
	public int getQseq() {
		return qseq;
	}
	public BoardVO setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public BoardVO setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public BoardVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getReply() {
		return reply;
	}
	public BoardVO setReply(String reply) {
		this.reply = reply;
		return this;
	}
	public String getId() {
		return id;
	}
	public BoardVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getReq() {
		return req;
	}
	public BoardVO setReq(String req) {
		this.req = req;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public BoardVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
}
