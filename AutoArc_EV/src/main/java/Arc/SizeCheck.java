package Arc;

import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class SizeCheck {
	
public void checkingSize(ArrayList<String> listintoprocess_source, ArrayList<String> listintoprocess_dest) {
		
		ReadExcel sourcep = new ReadExcel();
		listintoprocess_source= sourcep.getSourcePaths(null);
		ReadExcel destp = new ReadExcel();
		listintoprocess_dest= destp.getDestinationPaths(null);
		long byteSize_srcDir;
		long byteSize_destDir;
		ArrayList<String> sizechecklog = new ArrayList<String>();
	
	
		
		if((listintoprocess_source.get(0)!="") & (listintoprocess_dest.get(0)!="")) {
			     int arrayListSize=listintoprocess_source.size();
			     	
			         for(int index = 0; index < arrayListSize; index++) {
						 File srcDir = new File(listintoprocess_source.get(index));
						 File destDir = new File(listintoprocess_dest.get(index));
					
						 byteSize_srcDir=0;
						 byteSize_destDir=0;
						 if ((srcDir.exists() && destDir.exists())) {
							 byteSize_srcDir = folderSize(srcDir);
							 byteSize_destDir = folderSize(destDir);
							 System.out.println(byteSize_srcDir);
							 System.out.println(byteSize_destDir);
						 } 
							 if (byteSize_srcDir!= byteSize_destDir) {
								 sizechecklog.add("Size check failed for: " + srcDir + "\r\n" ); 
							 }
							 
							 if (!srcDir.exists()) {
								 sizechecklog.add("This path cannot be found: " + srcDir + "\r\n" ); 
							 }
							 
							 if (!destDir.exists()) {
								 sizechecklog.add("This path cannot be found: " + destDir + "\r\n" ); 
							 }
							 
			         }
			         
			        try {
			        	
			        	sizechecklog.add("\r\n");    
					    sizechecklog.add("Size check done");    
			 			File outputFile = new File("SizeCheckOutput.txt");
			 			FileUtils.writeLines(outputFile, sizechecklog);
			 			
			         } catch (IOException e) {
			 			e.printStackTrace();
			 		}
			        
			          
			         
			         
		}
	    
		else {JOptionPane.showMessageDialog(null, "Please make sure that paths are populated correctly in the Excel paths source file");	
		}
		
		destp.killExcel ();
	}


public static long folderSize(File directory) {
    long length = 0;
    for (File file : directory.listFiles()) {
        if (file.isFile())
            length += file.length();
        else
            length += folderSize(file);
    }
    return length;
}




}
