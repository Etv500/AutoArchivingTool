package Arc;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends Application {
	
	String sethourstring;
	String log="";
	
	public void clpath() {
        URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }
	
public void start(Stage stage) {
		
		Platform.setImplicitExit(false);	
	
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		/*stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());*/
	
		Label LabelActivateAuto= new Label();    //will have to change it to a textbox stile Deck log
		LabelActivateAuto.setTextFill(Color.GREEN);         
		LabelActivateAuto.setFont(Font.font("Arial", 20));
		
	//intro
		Label LabelIntro= new Label();    
		LabelIntro.setTextFill(Color.BLUE);         
		LabelIntro.setFont(Font.font("Arial", 40));
		LabelIntro.setText("Welcome to the AutoArc EV - V1 Sept 2019");
		
	//exit
		Button Btn_Exit= new Button(); 
		Btn_Exit.setText("Exit");
		Btn_Exit.setOnAction(e -> {System.exit(0);});
		
		
		
		
	//immediate custom archiving action
	CopyPaste A = new CopyPaste();
	Button Btn_CustomArc= new Button();     
	
	Btn_CustomArc.setText("Run Custom Archiving Now");
	Btn_CustomArc.setOnAction(e -> {
		A.CopyAndPaste(null,null);	
		log=log + "\r\n" + "Custom Archiving Has Been Run";
		LabelActivateAuto.setText(log);
		
	});
	
	//activate the automated archiving
	Label LabelActivateAutoDesc= new Label();         
	LabelActivateAutoDesc.setTextFill(Color.BLUE);         
	LabelActivateAutoDesc.setFont(Font.font("Arial", 20));
	LabelActivateAutoDesc.setText("Input Automated Archiving time as an integer (0 to 23): ");
		
	TextField TextFieldActivateAuto = new TextField();         
	TextFieldActivateAuto.setMaxWidth(250);
	
	ActivateAutoArc Auto = new ActivateAutoArc();
	Button Btn_ActivateAuto = new Button();         
	Btn_ActivateAuto.setText("Set time for archiving");
	Btn_ActivateAuto.setOnAction(e -> {
		boolean check=isNumeric(TextFieldActivateAuto.getText());
		if (check==true) {
			//System.out.println("run");
			log=log + "\r\n" + "Do not turn off your PC. Archiving will run at: " + TextFieldActivateAuto.getText();
			LabelActivateAuto.setText(log);
			Auto.Activate(TextFieldActivateAuto.getText());
			Btn_ActivateAuto.setText("Automated Archiving Has Been Run");
		}
		else
		{
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"Please input an integer from 0 to 23 in the textbox");  
		}
	});
	
	
	//kill the pending autoarc
	ActivateAutoArc Kill = new ActivateAutoArc();
	Button Btn_KillActivateAuto = new Button(); 
	Btn_KillActivateAuto.setText("Kill the scheduled Archiving");
	Btn_KillActivateAuto.setOnAction(e -> {
		Auto.CancelActivate();
		log=log + "\r\n" + "Scheduled Archiving has been killed";
		LabelActivateAuto.setText(log);
	});
	

	
	
		
	//size check
	Button Btn_SizeCheck = new Button(); 
	Btn_SizeCheck.setText("Check for differences in size");
	SizeCheck c = new SizeCheck();
	Btn_SizeCheck.setOnAction(e -> {
		c.checkingSize(null,null);
		log=log + "\r\n" + "Folders have been checked, please see the output in the txt file";
		LabelActivateAuto.setText(log);
	});
	
	

	
	
	VBox root = new VBox();         
	root.setSpacing(20);         
	root.setAlignment(Pos.CENTER);
	
	/*String imgback = getjavafolderpath() + "\\test1.jpg";
	System.out.println(imgback);

	root.setStyle("-fx-background-image: url('" + "file:///" + imgback + "'); " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;");
	System.out.println("-fx-background-image: url('" + "file://" + imgback + "'); ");*/
	
	root.setStyle("-fx-background-color:#f7e571");
	
	root.getChildren().addAll(LabelIntro, Btn_CustomArc, LabelActivateAutoDesc, TextFieldActivateAuto, Btn_ActivateAuto, Btn_KillActivateAuto, Btn_SizeCheck, Btn_Exit, LabelActivateAuto); 
	
	
	
	
	// create a new scene         
	Scene scene = new Scene(root, 800, 500);  
	
	//add the scene to the stage, then configure the stage and make it visible        
	stage.setScene(scene);         
	stage.setTitle("EV AutoArc V1");         
	stage.show();     
	
	stage.setOnCloseRequest(event -> {


		if (!SystemTray.isSupported()) {
	        System.out.println("SystemTray is not supported");
	        return;
	    }
	    final PopupMenu popup = new PopupMenu();
	    //URL url = GUI.class.getResource("test.jpeg");
	    
	    String urll = getjavafolderpath() + "\\test.jpg";
	
	    //System.out.println(System.class.getResource("test.jpeg"));
	    //System.out.println(urll);
	    Image image = Toolkit.getDefaultToolkit().getImage(urll);
	    final TrayIcon trayIcon = new TrayIcon(image);

	    final SystemTray tray = SystemTray.getSystemTray();

	    MenuItem openItem = new MenuItem("Open");
	    MenuItem exitItem = new MenuItem("Exit");

	    popup.add(openItem);
	    popup.add(exitItem);

	    trayIcon.setPopupMenu(popup);

	    try {
	        tray.add(trayIcon);
	        trayIcon.setImageAutoSize(true);
	    } catch (AWTException e) {
	        System.out.println("TrayIcon could not be added.");
	    }
		  
		  
	    ActionListener openup = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Platform.runLater(() -> stage.show());
	        	SystemTray.getSystemTray().remove(trayIcon);
	        }
	      };
	    openItem.addActionListener(openup);
	    
	    ActionListener closedown = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	System.exit(0);
	        }
	      };
	    exitItem.addActionListener(closedown);    
		
	});	
	
	
	}


		public String getjavafolderpath () {
			ReadJavaFolderPath P = new ReadJavaFolderPath();
			String urlstring = P.readjavapath();
			return urlstring;
		}

	public static boolean isNumeric(String strNum) {
	    try {
	        int i = Integer.parseInt(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	

}
