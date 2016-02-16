package it.marcoberri.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "maxmindata")
@JsonInclude(Include.NON_NULL)
public class MaxMinData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed
	private String ts;

	@Field(value = "T1MinDay")
	private Float t1MinDay;

	@Field(value = "T1MaxDay")
	private Float t1MaxDay;

	@Field(value = "H1MinDay")
	private Float h1MinDay;

	@Field(value = "H1MaxDay")
	private Float h1MaxDay;

	@Field(value = "PRESSMinDay")
	private Float pressMinDay;

	@Field(value = "PRESSMaxDay")
	private Float pressMaxDay;

	@Field(value = "WCMinDay")
	private Float wcMinDay;

	@Field(value = "WCMaxDay")
	private Float wcMaxDay;

	@Field(value = "WSMinDay")
	private Float wsMinDay;

	@Field(value = "WSMaxDay")
	private Float wsMaxDay;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public Float getT1MinDay() {
		return t1MinDay;
	}

	public void setT1MinDay(Float t1MinDay) {
		this.t1MinDay = t1MinDay;
	}

	public Float getT1MaxDay() {
		return t1MaxDay;
	}

	public void setT1MaxDay(Float t1MaxDay) {
		this.t1MaxDay = t1MaxDay;
	}

	public Float getH1MinDay() {
		return h1MinDay;
	}

	public void setH1MinDay(Float h1MinDay) {
		this.h1MinDay = h1MinDay;
	}

	public Float getH1MaxDay() {
		return h1MaxDay;
	}

	public void setH1MaxDay(Float h1MaxDay) {
		this.h1MaxDay = h1MaxDay;
	}

	public Float getPressMinDay() {
		return pressMinDay;
	}

	public void setPressMinDay(Float pressMinDay) {
		this.pressMinDay = pressMinDay;
	}

	public Float getPressMaxDay() {
		return pressMaxDay;
	}

	public void setPressMaxDay(Float pressMaxDay) {
		this.pressMaxDay = pressMaxDay;
	}

	public Float getWcMinDay() {
		return wcMinDay;
	}

	public void setWcMinDay(Float wcMinDay) {
		this.wcMinDay = wcMinDay;
	}

	public Float getWcMaxDay() {
		return wcMaxDay;
	}

	public void setWcMaxDay(Float wcMaxDay) {
		this.wcMaxDay = wcMaxDay;
	}

	public Float getWsMinDay() {
		return wsMinDay;
	}

	public void setWsMinDay(Float wsMinDay) {
		this.wsMinDay = wsMinDay;
	}

	public Float getWsMaxDay() {
		return wsMaxDay;
	}

	public void setWsMaxDay(Float wsMaxDay) {
		this.wsMaxDay = wsMaxDay;
	}

	@Override
	public String toString() {
		return "MaxMinData [id=" + id + ", ts=" + ts + ", t1MinDay=" + t1MinDay + ", t1MaxDay=" + t1MaxDay
				+ ", h1MinDay=" + h1MinDay + ", h1MaxDay=" + h1MaxDay + ", pressMinDay=" + pressMinDay
				+ ", pressMaxDay=" + pressMaxDay + ", wcMinDay=" + wcMinDay + ", wcMaxDay=" + wcMaxDay + ", wsMinDay="
				+ wsMinDay + ", wsMaxDay=" + wsMaxDay + "]";
	}


}
