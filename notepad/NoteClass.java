package notepad;

import java.io.FileInputStream;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NoteClass extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Application.launch(args);
	}
	public void Open(Stage stage, TextArea txt) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open new file");
		//only open .txt files
	    chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
	    chooser.setInitialDirectory(new File(System.getProperty("user.home")));
	   File file = chooser.showOpenDialog(stage);
	    if (file !=null) {
	    	try {
	    		FileInputStream in = new FileInputStream(file);
	            int size = in.available();
	    		 byte[] bs = new byte[size];
	                in.read(bs);
	                txt.setText(new String(bs));
	                in.close();
	    	} catch (Exception e){
	    		System.out.println("invalid file");
	    	}
	    }
	    
		
	}
	
	public void saveFile(Stage stage, TextArea txt) {
		FileChooser chooser=new FileChooser();
		chooser.setTitle("Save file");
	    chooser.setInitialDirectory(new File(System.getProperty("user.home")));
	    File file=chooser.showSaveDialog(stage);
	    if(file!=null) {
	    	try {
	    		FileWriter fw= new FileWriter(file);
	    		fw.write(txt.getText());
	    		fw.close();
	    	} catch(Exception e ) {
	    		System.out.println("not saved");
	    	}
	    }
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root ;
	     MenuBar  menuBar = new MenuBar();
	        //file
	        Menu fileMenu = new Menu("File");
	        MenuItem newItem = new MenuItem("New");
	        MenuItem openItem = new MenuItem("Open");
	        MenuItem saveItem = new MenuItem("Save");
	        MenuItem exitItem = new MenuItem("Exit");
	        //edit
	        Menu editMenu = new Menu("Edit");
	        MenuItem cutItem = new MenuItem("Cut");
	        MenuItem copyItem = new MenuItem("Copy");
	        MenuItem pasteItem = new MenuItem("Paste");
	        MenuItem deleteItem = new MenuItem("Delete");
	        MenuItem selectAllItem = new MenuItem("Select All");
	        //help
	        Menu helpMenu = new Menu("Help");
	        MenuItem aboutItem = new MenuItem("About");
	        //text
	         TextArea textArea = new TextArea();
	         
	        menuBar.getMenus().addAll(fileMenu, editMenu,helpMenu); //adding menus to main bar menu
	        
	         fileMenu.setMnemonicParsing(false);
	         //New
	         newItem.setMnemonicParsing(false);
	         newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
	         newItem.setOnAction((ActionEvent e) -> {
	        	 saveFile(primaryStage, textArea); 
	        	 textArea.setText(" ");
	         });
	         //OPEN
	         openItem.setMnemonicParsing(false);
	         openItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
	         openItem.setOnAction((ActionEvent e) -> {
	        	 saveFile(primaryStage, textArea);
	        	 Open(primaryStage, textArea);
	         });
	         //SAVE
	         saveItem.setMnemonicParsing(false);
	         saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
	         saveItem.setOnAction((ActionEvent e) -> {
	        	saveFile(primaryStage, textArea); 
	         });
	         //Exit
	         exitItem.setMnemonicParsing(false);
	         exitItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
	         exitItem.setOnAction((ActionEvent e)->{
	        	 saveFile(primaryStage, textArea);
	        	 primaryStage.close();
	         });
	         
	         editMenu.setMnemonicParsing(false);
	         //CUT
	         
	         cutItem.setMnemonicParsing(false);
	         //cut selected text using U+ctrl instead of X+ctrl to test functionality 
	         cutItem.setAccelerator(new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN));
	         cutItem.setOnAction((ActionEvent e)->{
	        	 textArea.cut();
	         });
	         //COPY
	         copyItem.setMnemonicParsing(false);
	        //copy selected text using O+ctrl instead of C+ctrl to test functionality
	         copyItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
	         copyItem.setOnAction((ActionEvent e)->{
	        	 textArea.copy();
	         });
	         //PASTE
	         pasteItem.setMnemonicParsing(false);
	         // paste selected text using L+ctrl instead of V+ctrl to test functionality
	         pasteItem.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
	         pasteItem.setOnAction((ActionEvent e)->{
	        	 textArea.paste();
	         });
	         //DELETE
	         deleteItem.setMnemonicParsing(false);
	         deleteItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
	         deleteItem.setOnAction((ActionEvent e)->{
	        	 textArea.deleteText(textArea.getSelection());
	         });
	         //SELECT ALL
	         selectAllItem.setMnemonicParsing(false);
	         selectAllItem.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
	         selectAllItem.setOnAction((ActionEvent e)->{
	        	 textArea.selectAll();
	         });
	         helpMenu.setMnemonicParsing(false);
	         //ABOUT
	         aboutItem.setMnemonicParsing(false);
	         aboutItem.setOnAction((ActionEvent e)->{
	        	 Alert abt = new Alert(AlertType.INFORMATION, "notepad task have the following functionallities "
	        	 		+ "\n create new file\nsave file \n open existing file \n And Cut,\t Copy,\t Paste,\t Delete and Select all\n ");
	        	 abt.show();
	         });
	         
	         
	         //adding items to each menu
	         fileMenu.getItems().addAll(newItem,openItem,saveItem,exitItem);
	         editMenu.getItems().addAll(cutItem, copyItem,pasteItem,deleteItem,selectAllItem);
	         helpMenu.getItems().add(aboutItem);
	         
	         root = new BorderPane();
	         
	         BorderPane.setAlignment(menuBar, Pos.CENTER);
	         root.setTop(menuBar);
	        
	         BorderPane.setAlignment(textArea, Pos.CENTER);
	        textArea.setPrefHeight(primaryStage.getHeight());
	         textArea.setPrefWidth(primaryStage.getWidth());
	         root.setCenter(textArea); // set the text area at center
			Scene scene = new Scene(root,1200,800);
			primaryStage.setTitle("NOO" );
		    primaryStage.setScene(scene);
		    primaryStage.show();

	}

}
