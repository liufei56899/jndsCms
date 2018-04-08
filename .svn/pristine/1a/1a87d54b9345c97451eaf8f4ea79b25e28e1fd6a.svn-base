package com.dqjy.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.expression.spel.support.ReflectionHelper.ArgsMatchKind;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
public class Office2PDF {
	 private static final int wdFormatPDF = 17;
	 private static final int xlTypePDF = 0;
	 private static final int ppSaveAsPDF = 32;
	 private static final int msoTrue = -1;
	 private static final int msofalse = 0;
     private static final int environment = 1;// 环境 1：windows 2:linux
     private String fileString;// (只涉及pdf2swf路径问题)
     private String outputPath = "";// 输入路径 ，如果不设置就输出在默认的位置
     private String fileName;
     private File pdfFile;
     private File swfFile;
     private File docFile;
     private boolean flag =false  ;  //控制是否为pdf
     /**
 	 * 环境变量下面的url.properties的绝对路径
 	 */
 	private static final String RUL_PATH = Thread.currentThread()
 			.getContextClassLoader().getResource("").getPath()
 			.replace("%20", " ")
 			+ "url.properties";
     public Office2PDF(String fileString) {
          ini(fileString);
     }
     /**
     * 重新设置file
     *
     * @param fileString
     */
     public void setFile(String fileString) {
          ini(fileString);
     }

     /**
     * 初始化
     *
     * @param fileString
     */
     private void ini(String fileString) {
          this.fileString = fileString;
          fileName = fileString.substring(0, fileString.lastIndexOf("."));
          if(fileString.contains(".pdf")){
        	  flag =true;
          }
          
          docFile = new File(fileString);
          pdfFile = new File(fileName + ".pdf");
          swfFile = new File(fileName + ".swf");
         
     }
    
     /**
     * 转为PDF
     *
     * @param file
     */
     private void doc2pdf() throws Exception {
    	 System.err.println("start----------------------------------1");
          if (docFile.exists()) {
        	  System.err.println("start----------------------------------2");
               if (!pdfFile.exists()) {
            	   System.err.println("start----------------------------------3");
            	     OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
                    try {
                         connection.connect();
                         DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
                         converter.convert(docFile, pdfFile);
                         // close the connection
                         connection.disconnect();
                         System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath()+ "****");
                    } catch (java.net.ConnectException e) {
                         e.printStackTrace();
                         System.out.println("****swf转换器异常，openoffice服务未启动！****");
                         throw e;
                    } catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
                         e.printStackTrace();
                         System.out.println("****swf转换器异常，读取转换文件失败****");
                         throw e;
                    } catch (Exception e) {
                         e.printStackTrace();
                         throw e;
                    }
                    
               } else {
                    System.out.println("****已经转换为pdf，不需要再进行转化****");
               }
          } else {
               System.out.println("****swf转换器异常，需要转换的文档不存在，无法转换****");
          }
     }
    
     /**
     * 转换成 swf
     */
     @SuppressWarnings("unused")
     private void pdf2swf() throws Exception {
          Runtime r = Runtime.getRuntime();
          if (!swfFile.exists()) {
               if (pdfFile.exists()) {
                    if (environment == 1) {// windows环境处理
                         try {
                        	 Properties prop = new Properties();
     						FileInputStream fis = null;
     						fis = new FileInputStream(RUL_PATH);// 属性文件输入流
     						prop.load(fis);// 将属性文件流装载到Properties对象中
     						fis.close();// 关闭流
     						String SWF_HOME = prop.getProperty("OpenSWF_HOME");
     						// 如果从文件中读取的URL地址最后一个字符不是 '\'，则添加'\'
     						if (SWF_HOME.charAt(SWF_HOME.length() - 1) != '\\') {
     							SWF_HOME += "\\";
     						}
     						  Process p = r.exec(SWF_HOME + "pdf2swf.exe " +  pdfFile.getPath() + " -o "+ swfFile.getPath() + " -T 9");
                              System.out.print(loadStream(p.getInputStream()));
                              System.err.print(loadStream(p.getErrorStream()));
                              System.out.print(loadStream(p.getInputStream()));
                              System.err.println("****swf转换成功，文件输出："
                                        + swfFile.getPath() + "****");
                            	if (pdfFile.exists()) {
                                      pdfFile.delete();
                                 }
                            	  
                              
                             

                         } catch (IOException e) {
                              e.printStackTrace();
                              throw e;
                         }
                    } else if (environment == 2) {// linux环境处理
                         try {
                              Process p = r.exec("pdf2swf " + pdfFile.getPath()
                                        + " -o " + swfFile.getPath() + " -T 9");
                              System.out.print(loadStream(p.getInputStream()));
                              System.err.print(loadStream(p.getErrorStream()));
                              System.err.println("****swf转换成功，文件输出："
                                        + swfFile.getPath() + "****");
                            
                              
                              if (pdfFile.exists()) {
                                   pdfFile.delete();
                              }
                         } catch (Exception e) {
                              e.printStackTrace();
                              throw e;
                         }
                    }
               } else {
                    System.out.println("****pdf不存在,无法转换****");
               }
          } else {
               System.out.println("****swf已经存在不需要转换****");
          }
     }

     static String loadStream(InputStream in) throws IOException {

          int ptr = 0;
          in = new BufferedInputStream(in);
          StringBuffer buffer = new StringBuffer();

          while ((ptr = in.read()) != -1) {
               buffer.append((char) ptr);
          }

          return buffer.toString();
     }
     /**
     * 转换主方法
     */
     @SuppressWarnings("unused")
     public boolean conver() {

          if (swfFile.exists()) {
               System.out.println("****swf转换器开始工作，该文件已经转换为swf****");
               return true;
          }

          if (environment == 1) {
               System.out.println("****swf转换器开始工作，当前设置运行环境windows****");
          } else {
               System.out.println("****swf转换器开始工作，当前设置运行环境linux****");
          }
          try {
        	  String str = getFileHZM();
        	  if(str.equals("doc") || str.equals("docx")){
        		 word2PDF(docFile.getPath(),pdfFile.getPath()); 
        	  }else if(str.equals("xlsx") || str.equals("xls")){
        			  excel2PDF(docFile.getPath(),pdfFile.getPath());  
        		  
        	  }else if(str.equals("pptx") || str.equals("ppt")){
        		  ppt2PDF(docFile.getPath(),pdfFile.getPath());
        	  }
              // doc2pdf();
               pdf2swf();
          } catch (Exception e) {
               e.printStackTrace();
               return false;
          }

          if (swfFile.exists()) {
               return true;
          } else {
               return false;
          }
     }

     /**
     * 返回文件路径
     *
     * @param s
     */
     public String getswfPath() {
          if (swfFile.exists()) {
               String tempString = swfFile.getPath();
               tempString = tempString.replaceAll("\\\\", "/");
               return tempString;
          } else {
               return "";
          }

     }
     /**
     * 设置输出路径
     */
     public void setOutputPath(String outputPath) {
    	 this.outputPath = outputPath;
         if (!outputPath.equals("")) {
              String realName = fileName.substring(fileName.lastIndexOf("/"),
                        fileName.lastIndexOf("."));
              if (outputPath.charAt(outputPath.length()) == '/') {
                   swfFile = new File(outputPath + realName + ".swf");
              } else {
                   swfFile = new File(outputPath + realName + ".swf");
              }

          }
     }
     
     public boolean word2PDF(String inputFile,String pdfFile){
         try{
         //打开word应用程序
         ActiveXComponent app = new ActiveXComponent("Word.Application");
         //设置word不可见
         //app.setProperty("Visible", false);
         //获得word中所有打开的文档,返回Documents对象
         Dispatch docs = app.getProperty("Documents").toDispatch();
         //调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
         Dispatch doc = Dispatch.call(docs,
                                     "Open",
                                     inputFile,
                                     false,
                                     true
                                     ).toDispatch();
         //调用Document对象的SaveAs方法，将文档保存为pdf格式
         /*
         Dispatch.call(doc,
                     "SaveAs",
                     pdfFile,
                     wdFormatPDF     //word保存为pdf格式宏，值为17
                     );
                     */
         Dispatch.call(doc,
                 "ExportAsFixedFormat",
                 pdfFile,
                 wdFormatPDF     //word保存为pdf格式宏，值为17
                 );
         //关闭文档
         Dispatch.call(doc, "Close",false);
         //关闭word应用程序
         app.invoke("Quit",new Variant[] {} );
         return true;
     }catch(Exception e){
    	 e.printStackTrace();
         return false;
     }
     }
     
     
     public boolean excel2PDF(String inputFile,String pdfFile){
         try{
             ActiveXComponent app = new ActiveXComponent("Excel.Application");
         app.setProperty("Visible", false);
         Dispatch excels = app.getProperty("Workbooks").toDispatch();
         Dispatch excel = Dispatch.call(excels,
                                     "Open",
                                     inputFile,
                                     false,
                                     true
                                     ).toDispatch();
         Dispatch.call(excel,
                     "ExportAsFixedFormat",
                     xlTypePDF,      
                     pdfFile
                     );
         Dispatch.call(excel, "Close",false);
         app.invoke("Quit");
         return true;
     }catch(Exception e){
         return false;
     }
          
     }
     
     public boolean ppt2PDF(String inputFile,String pdfFile){
         try{
         ActiveXComponent app = new ActiveXComponent("PowerPoint.Application");
         //app.setProperty("Visible", msofalse);
         Dispatch ppts = app.getProperty("Presentations").toDispatch();
          
         Dispatch ppt = Dispatch.call(ppts,
                                     "Open",
                                     inputFile,
                                     true,//ReadOnly
                                     true,//Untitled指定文件是否有标题
                                     false//WithWindow指定文件是否可见
                                     ).toDispatch();
          
         Dispatch.call(ppt,
                     "SaveAs",
                     pdfFile,
                     ppSaveAsPDF 
                     );
                  
         Dispatch.call(ppt, "Close");
          
         app.invoke("Quit");
         return true;
         }catch(Exception e){
             return false;
         }
     }
     
     
     /**
     * Des:获取文件后缀名
     * 2015-8-5
     * @author wm 
     * @return
     * String
     */
    public String getFileHZM(){
    	 String fileName=docFile.getName();
         String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
         return prefix;
     }
  public static void main(String[] args){
    		System.out.println( Thread.currentThread()
 			.getContextClassLoader().getResource("").getPath()
 			.replace("%20", "  ")
 			+ "url.properties");
    		
    		
    		Thread t = new Thread(){
    			public void run(){
				Office2PDF pffo=new Office2PDF("C://培训资料//pptx测试信息.pptx");	
			
				pffo.setOutputPath("C://培训资料//pptx测试信息.pptx");
				pffo.conver();
				System.out.println("fsdf:"+pffo.getswfPath());
				
    			}};
			t.start();
    	
    }
}