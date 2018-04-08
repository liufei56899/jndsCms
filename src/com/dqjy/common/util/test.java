package com.dqjy.common.util;

public class test {

	/**
	 * Des:
	 * 2015-6-9
	 * @author wm
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread t = new Thread(){public void run(){
//			Office2PDF pffo=new Office2PDF("E:/apache-tomcat-7.0.54-jpkc/webapps/ROOT/u/cms/www/201506/10111815d1j7.pdf");	
//			pffo.conver();
//		}};
//		t.start();
//		System.out.println("============");
		String str="u/cms/www/201506/1011245770ec.pdf";
		str=str.substring(0, str.lastIndexOf("."))+".swf";
		//str=str.replace(".***", ".swf");
		System.out.println(str);
	}

}
