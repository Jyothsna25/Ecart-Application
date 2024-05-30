package com.sathya.servlet;

public class Product {
	 private String pid;
	 private  String proname;
	 private double proprice;
	 private String probrand;
	 private String promadein;
	 private Date promnfdate;
	 private Date proexpdate;
	 private byte[]proImage;
	 private byte[]proaudio;
	 private byte[]provideo;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public double getProprice() {
		return proprice;
	}
	public void setProprice(double proprice) {
		this.proprice = proprice;
	}
	public String getProbrand() {
		return probrand;
	}
	public void setProbrand(String probrand) {
		this.probrand = probrand;
	}
	public String getPromadein() {
		return promadein;
	}
	public void setPromadein(String promadein) {
		this.promadein = promadein;
	}
	public Date getPromnfdate() {
		return promnfdate;
	}
	public void setPromnfdate(Date promnfdate) {
		this.promnfdate = promnfdate;
	}
	public Date getProexpdate() {
		return proexpdate;
	}
	public void setProexpdate(Date proexpdate) {
		this.proexpdate = proexpdate;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	public byte[] getProaudio() {
		return proaudio;
	}
	public void setProaudio(byte[] proaudio) {
		this.proaudio = proaudio;
	}
	public byte[] getProvideo() {
		return provideo;
	}
	public void setProvideo(byte[] provideo) {
		this.provideo = provideo;
	}
	 
	 
	
}
