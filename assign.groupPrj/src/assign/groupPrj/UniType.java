package assign.groupPrj;

public enum UniType {
	
	//Initiate Enum constatnts using the private constructor
	A (1, "A", 10),
	B (2, "B", 9),
	C (3, "C", 11),
	D (4, "D", 12);
	
    //tha data members for this Enum
    private int id;
	private String typeName; 
    private double cost;

    /**
     * the constructor of the Enum has to be private
     * @param sizeName
     * @param costCoeficient
     */
    private UniType(int id, String typeName, double cost) {
        this.id = id;
    	this.typeName = typeName;
        this.cost = cost;
    }

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


}
