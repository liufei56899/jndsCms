package com.dqjy.common.util;

public class PagingUtile {
	private String pageNow;
	private String pageSize="7";
	private String pageCount="0";
	private String pageStr="1";
	public String getPageNow() {
		return pageNow;
	}
	public String getPageSize() {
		return pageSize;
	}
	public String getPageStr() {
		return pageStr;
	}
	
	public void setpageCount(String pageCount) {
		this.pageCount=pageCount;
	}
	public void setPageNow(String pageNow) {
		int Str=1;
		try{
			Str=Integer.parseInt(pageNow);
			if(Str>Integer.parseInt(pageCount)){
				Str=Integer.parseInt(pageCount);
			}
			else if(Str<Integer.parseInt(pageCount)){
				Str=1;
			}
		}catch(Exception e){
			e.printStackTrace();
			Str=1;
		}
		this.pageNow = String.valueOf(Str);
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public void setPageStr(String pageStr) {
		
		int Str=1;
		try{
			if(pageStr==null){
				Str=1;
			}else{
			Str=Integer.parseInt(pageStr);
			if(Str>Integer.parseInt(pageCount)){
				Str=Integer.parseInt(pageCount);
			}
			else if(Str<1){
				Str=1;
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			Str=1;
		}
		this.pageStr = String.valueOf(Str);
	}
	public String getPageCount(){
		return pageCount;
		
	}
	public String getPageCounta(int Count){
		this.pageNow =String.valueOf(Count);
		int	pageSize=Integer.parseInt(getPageSize());
		if(Count % pageSize==0){
			pageCount=String.valueOf(Count/pageSize);
		}else{
			pageCount=String.valueOf(Count/pageSize+1);
		}
		return pageCount;
	}

}
