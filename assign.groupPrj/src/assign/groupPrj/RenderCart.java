/**
 * Class Name : RenderCart
 * Author : Jeff Sanghan Kim
 * Date : 2019.04.02
 * 
 * Description:
 * This class is to render Cart part.
 *  
 * @author Jeff
 */
package assign.groupPrj;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class RenderCart extends VBox {
	
	CheckBox chkAll, chkTA, chkTB, chkTC, chkTD;
	private Label lblCart, lblType, lblColor, lblSize, lblCount, lblSubTot, lblFilter;
	private Button btnDelete;
//	private Button btnDelete, btnSave;
	public ArrayList<CheckBox> arrChk;
	GridPane grid;
	HBox filterGroup, btnGroup;
	
	/**
	 * default constructor
	 */
	public RenderCart() {
		super(5);
		renderInit();
	}
	
	/**
	 * initial rendering
	 */
	private void renderInit(){
		
		lblCart = new Label("Cart");
                lblCart.getStyleClass().add("bordered-titled-title");
                this.getStyleClass().add("bordered-titled-border");
		
		grid = new GridPane();
                
		setFilterGroup();
		setHead();
		
		loadGrid();
		
		lblFilter = new Label("Filter");
		
		setBtnGroup();
		
		this.getChildren().addAll(lblCart, grid, lblFilter, filterGroup, btnGroup);
		
	}
	
	/**
	 * render each line
	 * @param cart
	 * @param i
	 */
	public void addOneLine(Cart cart, int i){
		if(arrChk.size() < i){
			arrChk.add(new CheckBox());
			grid.add(arrChk.get(i-1), 0, i);
		}
		grid.add(new Label(cart.getType().getTypeName()), 1, i);
		grid.add(new Label(cart.getColor()), 2, i);
		grid.add(new Label(cart.getSize()), 3, i);
		grid.add(new Label(String.valueOf(cart.getCount())), 4, i);
		grid.add(new Label("$"+String.valueOf(cart.getSubTotal())), 5, i);
	}
	
	/**
	 * render grid
	 * data is referred from arraylist
	 * data is filtered by check boxes
	 */
	private void loadGrid(){
		arrChk = new ArrayList<>();
		int idx=0;
		for(int i=0; i<Store.cartList.size(); i++){
			Cart cart = Store.cartList.get(i);
			if(chkAll.isSelected()){
				addOneLine(cart, ++idx);
			}else{
				if(chkTA.isSelected() ){
					if(Cart.ARR_TYPE[1].equals(cart.getType())){
						addOneLine(cart, ++idx);
					}
				}
				if(chkTB.isSelected() ){
					if(Cart.ARR_TYPE[2].equals(cart.getType())){
						addOneLine(cart, ++idx);
					}
				}
				if(chkTC.isSelected() ){
					if(Cart.ARR_TYPE[3].equals(cart.getType())){
						addOneLine(cart, ++idx);
					}
				}
				if(chkTD.isSelected() ){
					if(Cart.ARR_TYPE[4].equals(cart.getType())){
						addOneLine(cart, ++idx);
					}
				}
			}
		}
		grid.autosize();
	}
	
	/**
	 * render head of grid
	 */
	private void setHead(){
		(lblType = new Label("Type")).getStyleClass().add("bordered-titled-Header");
		(lblColor = new Label("Color")).getStyleClass().add("bordered-titled-Header");
		(lblSize = new Label("Size")).getStyleClass().add("bordered-titled-Header");
		(lblCount = new Label("Count")).getStyleClass().add("bordered-titled-Header");
		(lblSubTot = new Label("SubTotal")).getStyleClass().add("bordered-titled-Header");
		
		grid.add(lblType, 1, 0);
		grid.add(lblColor, 2, 0);
		grid.add(lblSize, 3, 0);
		grid.add(lblCount, 4, 0);
		grid.add(lblSubTot, 5, 0);
                grid.getStyleClass().add("bordered-titled-content");
                grid.setHgap(15);
                grid.setVgap(5);
                
	}
	
	public void reRenderGrid(){
		this.getChildren().clear();
		grid = new GridPane();
		setHead();
		loadGrid();
		this.getChildren().addAll(lblCart, grid, lblFilter, filterGroup, btnGroup);
	}
	
	/**
	 * set filter group with check boxes
	 */
	private void setFilterGroup(){
		filterGroup = new HBox(20);
		
		chkAll = new CheckBox("All");
		chkTA = new CheckBox("Type A");
		chkTB = new CheckBox("Type B");
		chkTC = new CheckBox("Type C");
		chkTD = new CheckBox("Type D");
		setAllFilterGroup(true);
		chkAll.setOnAction(e -> getActions(e));
		chkTA.setOnAction(e -> getActions(e));
		chkTB.setOnAction(e -> getActions(e));
		chkTC.setOnAction(e -> getActions(e));
		chkTD.setOnAction(e -> getActions(e));
		
		
		filterGroup.getChildren().addAll(chkAll, chkTA, chkTB, chkTC, chkTD);
	}
	
	private void setAllFilterGroup(boolean isSelected){
		chkAll.setSelected(isSelected);
		chkTA.setSelected(isSelected);
		chkTB.setSelected(isSelected);
		chkTC.setSelected(isSelected);
		chkTD.setSelected(isSelected);
	}
	
	/**
	 * set button group
	 */
	private void setBtnGroup(){
		btnGroup = new HBox(20);
		
		btnDelete = new Button("_Delete");
		btnDelete.setMnemonicParsing(true);
		btnDelete.setOnAction(e -> getActions(e));
//		btnSave = new Button("_Save");
//		btnSave.setMnemonicParsing(true);
		
		btnGroup.getChildren().addAll(btnDelete);
	}
	
	/**
     * get event and gathering information for each menu
     * @param e 
     */
    private void getActions(ActionEvent e) {
    	
    	if(e.getSource().equals(chkAll)){
    		if(chkAll.isSelected()){
    			setAllFilterGroup(true);
    		}else{
    			setAllFilterGroup(false);
    		}
    	}
    	
    	if(e.getSource().equals(chkTA) || e.getSource().equals(chkTB)
    			||e.getSource().equals(chkTC) || e.getSource().equals(chkTD)){
    		if(chkAll.isSelected()){
    			chkAll.setSelected(false);
    		}
    	}
    	
    	if(e.getSource().equals(btnDelete)){
    		
    		//if for loop start at index 0, it could not delete second checked item.
    		for(int i=arrChk.size()-1; i>0; i--){
    			if(arrChk.get(i).isSelected()){
    				Store.cartList.remove(i);
    				arrChk.remove(i);
    			}
    		}
    		
    		Store.cartList.reWriteFile();
    	}
    	
    	reRenderGrid();
    }

}

