package Arc;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

@SuppressWarnings("restriction")
public class CopyPaste {

	public void CopyAndPaste(ArrayList<String> listintoprocess_source, ArrayList<String> listintoprocess_dest) {
		
		ReadExcel sourcep = new ReadExcel();
		listintoprocess_source= sourcep.getSourcePaths(null);
		ReadExcel destp = new ReadExcel();
		listintoprocess_dest= destp.getDestinationPaths(null);
		
		if((listintoprocess_source.get(0)!="") & (listintoprocess_dest.get(0)!="")) {
			     int arrayListSize=listintoprocess_source.size();
			     	
			         for(int index = 0; index < arrayListSize; index++) {
						 File srcDir = new File(listintoprocess_source.get(index));
						 File destDir = new File(listintoprocess_dest.get(index));
						 try {
					        FileUtils.copyDirectory(srcDir,destDir);
							//Files.copy(srcDir.toPath(), destDir.toPath());
					     } catch (IOException exp) {
					         exp.printStackTrace();
					     } 
			         }
		}
		else {JOptionPane.showMessageDialog(null, "Please make sure that paths are populated correctly in the Excel paths source file");	
		}
	
		
	}
	
}
