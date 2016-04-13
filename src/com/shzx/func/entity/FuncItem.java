package com.shzx.func.entity;

public class FuncItem {

	private String id;
	private String funcName;
	private String funcSort;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFuncName() {
		return funcName;
	}
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	public String getFuncSort() {
		return funcSort;
	}
	public void setFuncSort(String funcSort) {
		this.funcSort = funcSort;
	}
	@Override
	public String toString() {
		return "FuncItem [id=" + id + ", funcName=" + funcName + ", funcSort="
				+ funcSort + "]";
	}
	
	
	
}
