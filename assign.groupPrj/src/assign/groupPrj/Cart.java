/**
 * Class Name : Cart
 * Author : Jeff Sanghan Kim
 * Date : 2019.04.02
 * 
 * Description:
 * This class is a data set of the item
 *  
 * @author Jeff
 */
package assign.groupPrj;

public class Cart {

	private UniType type;
	private String color, size;
	private int count;
	private double subTotal;
	
	// 0 address is null because it is easy to code other side.
	public static final String[] ARR_COLOR = {null, "BLACK", "RED", "WHITE" };
	public static final String[] ARR_SIZE = {null, "S", "M", "L", "XL" };
	public static final UniType[] ARR_TYPE 
		= {null, UniType.A, UniType.B, UniType.C, UniType.D};

	/**
	 * default constructor
	 * @param type
	 * @param color
	 * @param size
	 * @param count
	 */
	Cart(UniType type, String color, String size, int count) {
		this.type = type;
		this.color = color;
		this.size = size;
		this.count = count;
	}

	/**
	 * @return the type
	 */
	public UniType getType() {
		return type;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return getCount() * type.getCost();
	}
	
	/**
	 * toString
	 */
//	@Override
//	public String toString() {
//		return String.format("%2s%6s%3s%3d $%-5f", 
//				type.getTypeName(), color, size, count, getSubTotal());
//	}

}
