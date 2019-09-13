/**
 * Class Name : Cartlist
 * Author : Jeff Sanghan Kim
 * Date : 2019.04.02
 * 
 * Description:
 * This class is an arraylist of the Cart 
 *  
 * @author Jeff
 */
package assign.groupPrj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class CartList extends ArrayList<Cart> {
	
	private File file = new File("cartlist.txt");
	private Scanner input;
	private Cart cart;
	PrintWriter write;
	
	
	public CartList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * read file when the application starts
	 * purpose : sync arraylist with the file.
	 */
	public void readFile(){
		try{
			input = new Scanner(file);
			input.useDelimiter("\\|\\s*");
			while(input.hasNext()){
				int idx = input.nextInt();
				UniType type = Cart.ARR_TYPE[idx];
				String color = input.next();
				String size = input.next();
				int count = input.nextInt();
				Cart loadedCart = new Cart(type, color, size, count);
				this.add(loadedCart);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * write new input data to the arraylist and the file
	 * @param newItem
	 */
	public void writeRecord(Cart newItem){
		int idx = searchCart(newItem);
		if(idx == -1){
			//new item
			this.add(newItem);
			writeFile(newItem, true);
			assign.groupPrj.Store.renderCart.addOneLine(newItem, this.size());
		}else{
			//exist item
			this.set(idx, newItem);
			writeFile(newItem, false);
			assign.groupPrj.Store.renderCart.reRenderGrid();
		}
	}
	
	/**
	 * search index of arraylist for new item
	 * if it is not exist, it will return -1, or its index
	 * @param newItem
	 * @return
	 */
	private int searchCart(Cart newItem){
		int idx = -1;
		for(int i=0; i<this.size(); i++){
			Cart existCart = this.get(i);
			if(existCart.getType().equals(newItem.getType())
					&& existCart.getColor().equals(newItem.getColor())
					&& existCart.getSize().equals(newItem.getSize())){
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	
	/**
	 * reset arraylist and file
	 * it is called when 'reset' btn is clicked
	 */
	public void reset(){
		try {
			this.clear();
			write = new PrintWriter(new FileWriter(file));
			write.print("");
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * write file
	 * @param newItem
	 * @param isAppend
	 */
	public void writeFile(Cart newItem, boolean isAppend){
		try {
			if(isAppend){
				write = new PrintWriter(new FileWriter(file, true));
			}else{
				write = new PrintWriter(new FileWriter(file));
			}
			write.print(newItem.getType().getId() +"|");
			write.print(newItem.getColor());
			write.print("|");
			write.print(newItem.getSize());
			write.print("|");
			write.print(newItem.getCount());
			write.print("|");
			write.println();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * rewrite file from Arraylist
	 */
	public void reWriteFile(){
		try{
			write = new PrintWriter(new FileWriter(file));
			write.print("");
			write.close();
			for(Cart cart : this){
				writeFile(cart, true);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * toString
	 * @return information about this
	 */
//	@Override
//	public String toString() {
//		String result="";
//		for(int i=0; i<this.size(); i++){
//			result += this.get(i).toString();
//		}
//		return result;
//	}

}
