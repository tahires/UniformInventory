/**
 * Class Name : RenderSelect
 * Author : Jeff Sanghan Kim
 * Date : 2019.04.02
 * 
 * Description:
 * This class is to render Cart part.
 *  
 * @author Jeff
 */
package assign.groupPrj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RenderSelect extends VBox {
	
	private Label lblSelect, lblType, lblColor, lblSize, lblCount, lblErr;
	public Button btnMinus, btnPlus, btnClear, btnAdd;
	public ComboBox cboType, cboColor, cboSize;
	private TextField txtCount;
	private String[] arrStrType, arrStrColor, arrStrSize;
	
	/**
	 * default constructor
	 */
	public RenderSelect() {
		super(2);
		renderInit();
	}
	
	/**
	 * initial rendering
	 */
	private void renderInit(){
		lblSelect = new Label("Select");
                lblSelect.getStyleClass().add("bordered-titled-first");
                this.getStyleClass().add("bordered-titled-border");

		makeComponent();
		// grid start
		GridPane grid = new GridPane();
		
		grid.add(lblType, 0, 0);
		grid.add(cboType, 1, 0);
	    GridPane.setColumnSpan(cboType, 3);
	    
	    grid.add(lblColor, 0, 1);
		grid.add(cboColor, 1, 1);
	    GridPane.setColumnSpan(cboColor, 3);
	    
	    grid.add(lblSize, 0, 2);
		grid.add(cboSize, 1, 2);
	    GridPane.setColumnSpan(cboSize, 3);
	    
	    grid.add(lblCount, 0, 3);
		grid.add(btnMinus, 1, 3);
		grid.add(txtCount, 2, 3);
		grid.add(btnPlus, 3, 3);
	    // grid end
		
		HBox btnGroup = new HBox(10);
		btnClear = new Button("_Clear");
		btnAdd = new Button("_Add");
		btnClear.setMnemonicParsing(true);
		btnAdd.setMnemonicParsing(true);
		btnClear.setOnAction(e -> getActions(e));
		btnAdd.setOnAction(e -> getActions(e));
		btnGroup.getChildren().addAll(btnClear, btnAdd);
		
		lblErr = new Label();
                
		grid.setHgap(5);
                grid.setVgap(20);
		this.getChildren().addAll(lblSelect, grid, btnGroup, lblErr);
		
	}
	
	/**
     * get event and gathering information for each menu
     * @param e 
     */
    private void getActions(ActionEvent e) {
    	
    	if(e.getSource().equals(btnClear)){
    		renderClear();
    	}
    	
    	String strCount = txtCount.getText();
    	String errComment = "";
    	if(e.getSource().equals(btnAdd)){
    		int idxType = cboType.getSelectionModel().getSelectedIndex();
    		int idxColor = cboColor.getSelectionModel().getSelectedIndex();
    		int idxSize = cboSize.getSelectionModel().getSelectedIndex();
    		
    		errComment = chkInput(idxType, idxColor, idxSize, strCount);
    		lblErr.setText(errComment);
    		if(!errComment.equals(""))
    			return;
    		
    		//if input is valid make a instance
    		Cart newItem = new Cart(Cart.ARR_TYPE[idxType], 
    				Cart.ARR_COLOR[idxColor], Cart.ARR_SIZE[idxSize], 
    				Integer.valueOf(strCount));
    		
    		//add to arraylist
    		Store.cartList.writeRecord(newItem);
    	}
    	
    	try {
    		//using try catch finally because of changing String to int
    		//and block to go invalid values
    		int count = Integer.valueOf(strCount);
    		
    		if(e.getSource().equals(btnMinus)){
    			if(--count < 1){
    				throw new Exception();
    			}
    		}
    		
    		if(e.getSource().equals(btnPlus)){
    			++count;
    		}
    		txtCount.setText(String.valueOf(count));
 		} catch (Exception e2) {
			errComment = "enter more than one integer value";
		} finally {
			lblErr.setText(errComment);
		}
    	
    }
    
    /**
     * make component for rendering
     */
    private void makeComponent(){
    	lblType = new Label("Type");
		lblColor = new Label("Color");
		lblSize = new Label("Size");
		lblCount = new Label("Count");
		btnMinus = new Button("-");
		btnPlus = new Button("+");
		btnMinus.setOnAction(e -> getActions(e));
		btnPlus.setOnAction(e -> getActions(e));
		txtCount = new TextField();
		txtCount.setText("0");
		
		cboType = new ComboBox();
		arrStrType = new String[Cart.ARR_TYPE.length];
		arrStrType[0] = "Select";
		for(int i=1; i<Cart.ARR_TYPE.length; i++){
			arrStrType[i] = Cart.ARR_TYPE[i].getTypeName();
		}
		
		cboColor = new ComboBox();
		arrStrColor = new String[Cart.ARR_COLOR.length];
		arrStrColor[0] = "Select";
		for(int i=1; i<Cart.ARR_COLOR.length; i++){
			arrStrColor[i] = Cart.ARR_COLOR[i];
		}
		
		cboSize = new ComboBox();
		arrStrSize = new String[Cart.ARR_SIZE.length];
		arrStrSize[0] = "Select";
		for(int i=1; i<Cart.ARR_SIZE.length; i++){
			arrStrSize[i] = Cart.ARR_SIZE[i];
		}
		
		ObservableList<String> types = 
                FXCollections.observableArrayList(arrStrType);
		cboType.getItems().addAll(types);
		cboType.setValue(arrStrType[0]);
		
		ObservableList<String> colors = 
                FXCollections.observableArrayList(arrStrColor);
		cboColor.getItems().addAll(colors);
		cboColor.setValue(arrStrColor[0]);
		
		ObservableList<String> sizes = 
                FXCollections.observableArrayList(arrStrSize);
		cboSize.getItems().addAll(sizes);
		cboSize.setValue(arrStrSize[0]);
    }
    
    /**
     * check input is valid or not
     * @param idxType
     * @param idxColor
     * @param idxSize
     * @param strCount
     * @return
     */
    private String chkInput(int idxType, int idxColor, int idxSize, String strCount){
    	String result="";
		if(idxType == 0){
			result = "You should select a Type";
			return result;
		}
		
		if(idxColor == 0){
			result = "You should select a Color";
			return result;
		}
		
		if(idxSize == 0){
			result = "You should select a Size";
			return result;
		}
		
		try{
			int count = Integer.valueOf(strCount);
			if(count < 1){
				throw new Exception();
			}
		}catch (Exception e) {
			result = "enter more than one integer value";
		}
    	
    	return result;
    }
	
    /**
     * reset
     */
	public void renderClear(){
		cboType.setValue(arrStrType[0]);
		cboColor.setValue(arrStrColor[0]);
		cboSize.setValue(arrStrSize[0]);
		txtCount.setText("");
	}
	
}
