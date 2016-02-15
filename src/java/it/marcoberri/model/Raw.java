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

@Document(collection = "rawdata")
public class Raw implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId id;
	
	@Field(value = "T0")
	private float t0 = 0;
	@Field(value = "H0")
	private float h0 = 0;
	@Field(value = "T1")
	private float t1 = 0;
	@Field(value = "H1")
	private float h1 = 0;
	@Field(value = "PRESS")
	private float press = 0;
	@Field(value = "FC")
	private float fc = 0;
	@Field(value = "STORM")
	private float storm = 0;
	@Field(value = "WD")
	private float wd = 0;
	@Field(value = "WS")
	private float ws = 0;
	@Field(value = "WG")
	private float wg = 0;
	@Field(value = "WC")
	private float wc = 0;
	@Field(value = "RC")
	private float rc = 0;

	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date ts;

	
	@Indexed
	private long tsMillis = 0;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public float getT0() {
		return t0;
	}

	public void setT0(float t0) {
		this.t0 = t0;
	}

	public float getH0() {
		return h0;
	}

	public void setH0(float h0) {
		this.h0 = h0;
	}

	public float getT1() {
		return t1;
	}

	public void setT1(float t1) {
		this.t1 = t1;
	}

	public float getH1() {
		return h1;
	}

	public void setH1(float h1) {
		this.h1 = h1;
	}

	public float getPress() {
		return press;
	}

	public void setPress(float press) {
		this.press = press;
	}

	public float getFc() {
		return fc;
	}

	public void setFc(float fc) {
		this.fc = fc;
	}

	public float getStorm() {
		return storm;
	}

	public void setStorm(float storm) {
		this.storm = storm;
	}

	public float getWd() {
		return wd;
	}

	public void setWd(float wd) {
		this.wd = wd;
	}

	public float getWs() {
		return ws;
	}

	public void setWs(float ws) {
		this.ws = ws;
	}

	public float getWg() {
		return wg;
	}

	public void setWg(float wg) {
		this.wg = wg;
	}

	public float getWc() {
		return wc;
	}

	public void setWc(float wc) {
		this.wc = wc;
	}

	public float getRc() {
		return rc;
	}

	public void setRc(float rc) {
		this.rc = rc;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public long getTsMillis() {
		return tsMillis;
	}

	public void setTsMillis(long tsMillis) {
		this.tsMillis = tsMillis;
	}

	@Override
	public String toString() {
		return "Raw [id=" + id + ", t0=" + t0 + ", h0=" + h0 + ", t1=" + t1 + ", h1=" + h1 + ", press=" + press
				+ ", fc=" + fc + ", storm=" + storm + ", wd=" + wd + ", ws=" + ws + ", wg=" + wg + ", wc=" + wc
				+ ", rc=" + rc + ", ts=" + ts + ", tsMillis=" + tsMillis + "]";
	}

}
