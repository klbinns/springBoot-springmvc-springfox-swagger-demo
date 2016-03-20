package com.binns.data;

public class StringData {

	private String input = "";
	private String output = "";
	
	public StringData(){}
	
	public StringData(final String input, final String output){
		this.input = input;
		this.output = output;
	}

	public String getInput() {
		return input;
	}

	public String getOutput() {
		return output;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
}
