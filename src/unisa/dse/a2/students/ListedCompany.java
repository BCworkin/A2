package unisa.dse.a2.students;

public class ListedCompany {

	/**
	 * The full name of the company
	 */
	private String name;
	
	public String getName() {
		
		return name;
		
	}

	/**
	 * The listing code of the company
	 */
	private String code;
	
	public String getCode() {
		
		return code;
		
	}

	/**
	 * Current price of the company after last trade
	 */
	private int currentPrice;
	
	public int getCurrentPrice() {  
		
		return currentPrice;
	}
	
	public ListedCompany(String code, String name, int currentPrice)
	{
		this.code = code;
		this.name = name;
		this.currentPrice = currentPrice;
	}
	
	/**
	 * Processing a trade should increase the current price of the company by 
	 *    quantity / 100
	 * A company's price CANNOT go below 1
	 * 
	 * @param quantity
	 * @return the price after adjustment
	 */
	public float processTrade(int quantity)                          
	{
		float percentageIncrease = quantity / 100;
		this.currentPrice += percentageIncrease;
		if (this.currentPrice < 1) {
			this.currentPrice = 1;
		} 
		return this.currentPrice;
	}
}
