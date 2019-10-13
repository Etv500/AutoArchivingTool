package Arc;


public class ReadJavaFolderPath {
	String AutoArc_EV_Path;
	public String readjavapath() {
		 AutoArc_EV_Path = System.getProperty("user.dir");
		 return AutoArc_EV_Path;
	}
	

}
