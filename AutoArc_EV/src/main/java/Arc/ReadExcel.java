package Arc;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.lang.Object;
import org.apache.poi.ss.usermodel.CellType;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReadExcel {
	
	String file="";
	
	public String getjavafolderpath () {
		ReadJavaFolderPath P = new ReadJavaFolderPath();
		String file = P.readjavapath();
		return file;
	}
	
	
	public ArrayList<String> pathsListmethod() {
		ArrayList<String> list=new ArrayList<String>();  
	    		return list;
	}
	public ArrayList<String> pathsListmethodtwo() {
		ArrayList<String> listtwo=new ArrayList<String>();  
	    		return listtwo;
	}
	
	
	
	
	
	////////////////kill Excel/////////////////////
	public void killExcel () {
	
		/*try{    
			Process k = Runtime.getRuntime().exec(getjavafolderpath () + "\\KillExcel.bat");
			k.waitFor();
		}catch( IOException ex ){
		//Validate the case the file can't be accessed 
		
		}catch( InterruptedException ex ){
		//Validate the case the process is being stopped by some external situation     
		
		}	*/	
	}
		
	
	public void deletetempexcel () {
		try  
		{         
		File f= new File(getjavafolderpath()+ "\\AutoArchivingPaths.xlsx");           //file to be delete  
		if(f.delete())                      //returns Boolean value  
		{  
		System.out.println(f.getName() + " deleted");   //getting and printing the file name  
		}  
		else  
		{  
		System.out.println("failed");  
		}  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
				
	}

	////////////////update formula values in Excel file/////////////////////
	public void updateFormulas () {
		
		deletetempexcel ();
		

		try{   
			
		    Process p = Runtime.getRuntime().exec(getjavafolderpath () + "\\RunUpdate.bat");
		    p.waitFor();
		    TimeUnit.SECONDS.sleep(10);
		    
		}catch( IOException ex ){
		    //Validate the case the file can't be accessed 

		}catch( InterruptedException ex ){
		    //Validate the case the process is being stopped by some external situation     

		}	
	}
	
	
	////////////retrieve source paths//////////////
	public ArrayList<String> getSourcePaths(ArrayList<String> sourcePathslist) {
			
		
		updateFormulas ();	
		
		sourcePathslist = pathsListmethod();
		
		try {
			//TimeUnit.SECONDS.sleep(15);
				
			file=getjavafolderpath()+ "\\AutoArchivingPaths.xlsx";
			//System.out.println(file);
			
			InputStream ExcelFileToRead = new FileInputStream(file);
			XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
			//XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
			wb.setForceFormulaRecalculation(true);
		    XSSFSheet sheet = wb.getSheetAt(0);
		    XSSFRow row;
		    XSSFCell cell;
		    int rows; 
		    rows = sheet.getPhysicalNumberOfRows();
		    int cols = 1; 
		    XSSFRichTextString path;
		    String stpath;
		    
		    
		     /* try {
		        if(!Desktop.isDesktopSupported()){
		            System.out.println("Error: Desktop is not supported");
		        }
		        Desktop desktop = Desktop.getDesktop();
		        if(filee.exists()) desktop.open(filee);
		        FileOutputStream out = new FileOutputStream(file);  
		        wb.write(out);   
		        out.close();
	            }
				catch(Exception ioe) {
				    ioe.printStackTrace();
				}*/
    
			    for(int r = 0; r < rows; r++) {
			        row = sheet.getRow(r);
			        if(row != null) {
			            for(int c = 0; c < cols; c++) {
			                cell = row.getCell((short)c);
			                	if(cell != null) {                  
			                    path=cell.getRichStringCellValue();
			                    stpath=path.toString();
			                    sourcePathslist.add(stpath);  
			                }
			            }
			        }
			    }  
			    ExcelFileToRead.close();
		} 
		catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		System.out.println(sourcePathslist);
		
	return sourcePathslist; 
	}
	
	
	////////////retrieve destination paths//////////////
	public ArrayList<String> getDestinationPaths(ArrayList<String> destPathslist) {

		destPathslist = pathsListmethodtwo();
		
		try {
			file=getjavafolderpath()+ "\\AutoArchivingPaths.xlsx";
			InputStream ExcelFileToRead = new FileInputStream(file);
			XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);    
		    XSSFSheet sheet = wb.getSheetAt(0);
		    XSSFRow row;
		    XSSFCell cell;
		    int rows; 
		    rows = sheet.getPhysicalNumberOfRows(); 
		    int cols = 3; 
		    
		    XSSFRichTextString path;
		    String stpath;
			    for(int r = 0; r < rows; r++) {
			        row = sheet.getRow(r);
			        if(row != null) {
			            for(int c = 2; c < cols; c++) {
			                cell = row.getCell((short)c);
			                	if(cell != null) {                  
			                    path=cell.getRichStringCellValue();
			                    stpath=path.toString();
			                    destPathslist.add(stpath);  
			                   
			                }
			            }
			        }
			    }  
			    ExcelFileToRead.close();
		} 
		catch(Exception ioe) {
		    ioe.printStackTrace();
		}
	System.out.println(destPathslist);
	return destPathslist; 
	}
	
	
	
	
}
