package it.marcoberri.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "maxMinData")
public class MaxMinData  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Indexed
	private String ts;

	@Field(value = "T1MinDay")
	private float t1MinDay = 0;

	@Field(value = "T1MaxDay")
	private float t1MaxDay = 0;

	@Field(value = "H1MinDay")
	private float h1MinDay = 0;

	@Field(value = "H1MaxDay")
	private float h1MaxDay = 0;

	@Field(value = "PRESSMinDay")
	private float pressMinDay = 0;

	@Field(value = "PRESSMaxDay")
	private float pressMaxDay = 0;

	@Field(value = "WCMinDay")
	private float wcMinDay = 0;

	@Field(value = "WCMaxDay")
	private float wcMaxDay = 0;

	@Field(value = "WSMinDay")
	private float wsMinDay = 0;

	@Field(value = "WSMaxDay")
	private float wsMaxDay = 0;

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

	public float getT1MinDay() {
		return t1MinDay;
	}

	public void setT1MinDay(float t1MinDay) {
		this.t1MinDay = t1MinDay;
	}

	public float getT1MaxDay() {
		return t1MaxDay;
	}

	public void setT1MaxDay(float t1MaxDay) {
		this.t1MaxDay = t1MaxDay;
	}

	public float getH1MinDay() {
		return h1MinDay;
	}

	public void setH1MinDay(float h1MinDay) {
		this.h1MinDay = h1MinDay;
	}

	public float getH1MaxDay() {
		return h1MaxDay;
	}

	public void setH1MaxDay(float h1MaxDay) {
		this.h1MaxDay = h1MaxDay;
	}

	public float getPressMinDay() {
		return pressMinDay;
	}

	public void setPressMinDay(float pressMinDay) {
		this.pressMinDay = pressMinDay;
	}

	public float getPressMaxDay() {
		return pressMaxDay;
	}

	public void setPressMaxDay(float pressMaxDay) {
		this.pressMaxDay = pressMaxDay;
	}

	public float getWcMinDay() {
		return wcMinDay;
	}

	public void setWcMinDay(float wcMinDay) {
		this.wcMinDay = wcMinDay;
	}

	public float getWcMaxDay() {
		return wcMaxDay;
	}

	public void setWcMaxDay(float wcMaxDay) {
		this.wcMaxDay = wcMaxDay;
	}

	public float getWsMinDay() {
		return wsMinDay;
	}

	public void setWsMinDay(float wsMinDay) {
		this.wsMinDay = wsMinDay;
	}

	public float getWsMaxDay() {
		return wsMaxDay;
	}

	public void setWsMaxDay(float wsMaxDay) {
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
