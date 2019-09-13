package assign.groupPrj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Store extends Application {
    
	
	private MenuBar menuBar;
	private Menu fileMenu;
    private MenuItem exitItem;
    public static RenderCart renderCart;
    public static CartList cartList = new CartList();
    private Label lblTitle;
    private GridPane grid;
    //private LoginPage page;
    private Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
//            this.logInScene();
            
            this.stage = primaryStage;
            
		
		//initializing arraylist to sync from file 
		cartList.readFile();
                grid  = new GridPane(); 
                lblTitle = new Label("Uniform Whole Sale");
		lblTitle.getStyleClass().add("bordered-titled-title");
                
                
		BorderPane root = new BorderPane();
		
		// top menu start
		menuBar = new MenuBar();
        fileMenu = new Menu("_File");
        exitItem = new MenuItem("_Exit");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.E,
            KeyCombination.SHORTCUT_DOWN));
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);
        exitItem.setOnAction(e -> getActions(e));
        root.setTop(menuBar);
        //root.setTop(lblTitle);
        // top menu end
		
        // main part start
        HBox hbox = new HBox(10);
        
		RenderSelect renderSelect = new RenderSelect();
		renderCart = new RenderCart();
               
		hbox.getChildren().addAll(renderSelect, renderCart);
		root.setCenter(hbox);
		// main part end
		
		Scene scene = new Scene(root);
                //root.setBottom(hbox);
	    root.getStylesheets().add("styles.css");
	    primaryStage.setTitle("Uniform Whole Sale");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	    launch(args);
	}
        
	
	/**
     * get event and gathering information for each menu
     * @param e 
     */
    private Stage getActions(ActionEvent e) {
    	if(e.getSource().equals(exitItem)){
    		System.exit(0);
    	}
//        if(e.getSource()==this.page.btnLogin){
////            this.stage.setScene(start(primaryStage));
//            return this.stage;
//        }
            return null;
    }
//     private Scene logInScene(){
//        this.page=new LoginPage();
//        this.page.btnLogin.setOnAction(e -> getActions(e));
//        this.page.btnRegister.setOnAction(e -> getActions(e));
//        PositionPane pnlLogin=new PositionPane("Welcome",this.page);
//        Scene scene=new Scene(pnlLogin,1000.0,500.0);
//        scene.getStylesheets().add("styles.css");
//        return scene;
//    }

}