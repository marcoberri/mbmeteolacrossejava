package it.marcoberri.model;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import it.marcoberri.helper.CustomObjectIdDeserializer;
import it.marcoberri.helper.CustomObjectIdSerializer;

@Document(collection = "rawdata")
@JsonInclude(Include.NON_NULL)
public class Raw implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonSerialize( using=CustomObjectIdSerializer.class)
	@JsonDeserialize(using= CustomObjectIdDeserializer.class)
	private ObjectId id;
	
	@Field(value = "T0")
	private Float t0;
	@Field(value = "H0")
	private Float h0;
	@Field(value = "T1")
	private Float t1;
	@Field(value = "H1")
	private Float h1;
	@Field(value = "PRESS")
	private Float press;
	@Field(value = "FC")
	private Float fc;
	@Field(value = "STORM")
	private Float storm;
	@Field(value = "WD")
	private Float wd;
	@Field(value = "WS")
	private Float ws;
	@Field(value = "WG")
	private Float wg;
	@Field(value = "WC")
	private Float wc;
	@Field(value = "RC")
	private Float rc;

	@Field(value = "ts")
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Indexed
	private Date ts;

	
	@Indexed
	private Long tsMillis;


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public Float getT0() {
		return t0;
	}


	public void setT0(Float t0) {
		this.t0 = t0;
	}


	public Float getH0() {
		return h0;
	}


	public void setH0(Float h0) {
		this.h0 = h0;
	}


	public Float getT1() {
		return t1;
	}


	public void setT1(Float t1) {
		this.t1 = t1;
	}


	public Float getH1() {
		return h1;
	}


	public void setH1(Float h1) {
		this.h1 = h1;
	}


	public Float getPress() {
		return press;
	}


	public void setPress(Float press) {
		this.press = press;
	}


	public Float getFc() {
		return fc;
	}


	public void setFc(Float fc) {
		this.fc = fc;
	}


	public Float getStorm() {
		return storm;
	}


	public void setStorm(Float storm) {
		this.storm = storm;
	}


	public Float getWd() {
		return wd;
	}


	public void setWd(Float wd) {
		this.wd = wd;
	}


	public Float getWs() {
		return ws;
	}


	public void setWs(Float ws) {
		this.ws = ws;
	}


	public Float getWg() {
		return wg;
	}


	public void setWg(Float wg) {
		this.wg = wg;
	}


	public Float getWc() {
		return wc;
	}


	public void setWc(Float wc) {
		this.wc = wc;
	}


	public Float getRc() {
		return rc;
	}


	public void setRc(Float rc) {
		this.rc = rc;
	}


	public Date getTs() {
		return ts;
	}


	public void setTs(Date ts) {
		this.ts = ts;
	}




	public Long getTsMillis() {
		return tsMillis;
	}


	public void setTsMillis(Long tsMillis) {
		this.tsMillis = tsMillis;
	}


	@Override
	public String toString() {
		return "Raw [id=" + id + ", t0=" + t0 + ", h0=" + h0 + ", t1=" + t1 + ", h1=" + h1 + ", press=" + press
				+ ", fc=" + fc + ", storm=" + storm + ", wd=" + wd + ", ws=" + ws + ", wg=" + wg + ", wc=" + wc
				+ ", rc=" + rc + ", ts=" + ts + ", tsMillis=" + tsMillis + "]";
	}



}
