package org.itstep.entity;

import java.io.Serializable;

public class MySimpleObject implements Serializable{
	
	private String textField;
	private Integer intField;
	private boolean boolField;
	
	public String getTextField() {
		return textField;
	}
	public void setTextField(String textField) {
		this.textField = textField;
	}
	public Integer getIntField() {
		return intField;
	}
	public void setIntField(Integer intField) {
		this.intField = intField;
	}
	public boolean isBoolField() {
		return boolField;
	}
	public void setBoolField(boolean boolField) {
		this.boolField = boolField;
	}
	public MySimpleObject(String textField, Integer intField, boolean boolField) {
		this.textField = textField;
		this.intField = intField;
		this.boolField = boolField;
	}
	
	public MySimpleObject() {

	}
	
	@Override
	public String toString() {
		return textField + " " + String.valueOf(intField) + " " + String.valueOf(boolField);
	}

}
