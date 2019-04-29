package org.stu.score;

import java.io.Serializable;

import org.stu.stuinfo.ColumnName;
/**
 * ·â×°³É¼¨Àà
 */
public class Score implements Serializable{
	private static final long serialVersionUID = 1991651058100165058L;
	@ColumnName("stucode")
	private Integer stucode;
	@ColumnName("C")
	private Integer C;
	@ColumnName("Java")
	private Integer Java;
	@ColumnName("Oracle")
	private Integer Oracle;
	@ColumnName("PS")
	private Integer PS;
	@ColumnName("Html")
	private Integer Html;
	
	@Override
		public String toString() {
			return ""+stucode+"  "+C+"  "+Java
					+"  "+Oracle+"  "+PS+"  "+Html;
		}
	
	
	public Integer getPS() {
		return PS;
	}
	public void setPS(Integer pS) {
		PS = pS;
	}
	public Integer getHtml() {
		return Html;
	}
	public void setHtml(Integer html) {
		Html = html;
	}
	public Integer getStucode() {
		return stucode;
	}
	public void setStucode(Integer stucode) {
		this.stucode = stucode;
	}
	public Integer getC() {
		return C;
	}
	public void setC(Integer c) {
		C = c;
	}
	public Integer getJava() {
		return Java;
	}
	public void setJava(Integer java) {
		Java = java;
	}
	public Integer getOracle() {
		return Oracle;
	}
	public void setOracle(Integer oracle) {
		Oracle = oracle;
	}
	
}
