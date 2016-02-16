package it.marcoberri.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "sysdata")
@JsonInclude(Include.NON_NULL)
public class SystemData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed
	private Date ts;

	@Field(value = "BATR")
	private Integer batR;
	
	@Field(value = "BATU")
	private Integer batU;
	
	@Field(value = "BATW")
	private Integer batW;
	
	@Field(value = "BAT5")
	private Integer bat5;
	
	@Field(value = "BAT4")
	private Integer bat4;
	
	@Field(value = "BAT3")
	private Integer bat3;
	
	@Field(value = "BAT2")
	private Integer bat2;
	
	@Field(value = "BAT1")
	private Integer bat1;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public Integer getBatR() {
		return batR;
	}

	public void setBatR(Integer batR) {
		this.batR = batR;
	}

	public Integer getBatU() {
		return batU;
	}

	public void setBatU(Integer batU) {
		this.batU = batU;
	}

	public Integer getBatW() {
		return batW;
	}

	public void setBatW(Integer batW) {
		this.batW = batW;
	}

	public Integer getBat5() {
		return bat5;
	}

	public void setBat5(Integer bat5) {
		this.bat5 = bat5;
	}

	public Integer getBat4() {
		return bat4;
	}

	public void setBat4(Integer bat4) {
		this.bat4 = bat4;
	}

	public Integer getBat3() {
		return bat3;
	}

	public void setBat3(Integer bat3) {
		this.bat3 = bat3;
	}

	public Integer getBat2() {
		return bat2;
	}

	public void setBat2(Integer bat2) {
		this.bat2 = bat2;
	}

	public Integer getBat1() {
		return bat1;
	}

	public void setBat1(Integer bat1) {
		this.bat1 = bat1;
	}

	@Override
	public String toString() {
		return "SystemData [id=" + id + ", batR=" + batR + ", batU=" + batU + ", batW=" + batW + ", bat5=" + bat5
				+ ", bat4=" + bat4 + ", bat3=" + bat3 + ", bat2=" + bat2 + ", bat1=" + bat1 + "]";
	}
	

}
