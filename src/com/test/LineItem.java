package com.test;

public class LineItem implements Comparable<LineItem>{
	
	private String itemNumber;
	private String lowerShipDates;
	private String upperShipDates;
	private String lowerDeliveryDates;
	private String upperDeliveryDates;
	private String customerSelectedShipMethod;
	private String availableShipMethod;
	private int deliveryGroupNumber;
	private String[] shippingConditionsSP;
	
	public LineItem(String itemNumber,String lowerShipDates,String upperShipDates,String lowerDeliveryDates,String upperDeliveryDates,String customerSelectedShipMethod,String availableShipMethod) {
		this.itemNumber = itemNumber;
		this.lowerDeliveryDates=lowerDeliveryDates;
		this.upperShipDates=upperShipDates;
		this.lowerShipDates=lowerShipDates;
		this.customerSelectedShipMethod=customerSelectedShipMethod;
		this.availableShipMethod=availableShipMethod;
		this.upperDeliveryDates = upperDeliveryDates;
	}
	public int compareTo(LineItem compareItem) {
		 
		String compareSelectedShipMethod = ((LineItem) compareItem).getCustomerSelectedShipMethod();
		int result=-1;
		if (this.customerSelectedShipMethod.equals(compareSelectedShipMethod)){
			result=0;
		}
		//ascending order
		return result;
 
		//descending order
		//return compareQuantity - this.quantity;
 
	}
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getLowerShipDates() {
		return lowerShipDates;
	}
	public void setLowerShipDates(String lowerShipDates) {
		this.lowerShipDates = lowerShipDates;
	}
	public String getUpperShipDates() {
		return upperShipDates;
	}
	public void setUpperShipDates(String upperShipDates) {
		this.upperShipDates = upperShipDates;
	}
	public String getLowerDeliveryDates() {
		return lowerDeliveryDates;
	}
	public void setLowerDeliveryDates(String lowerDeliveryDates) {
		this.lowerDeliveryDates = lowerDeliveryDates;
	}
	public String getUpperDeliveryDates() {
		return upperDeliveryDates;
	}
	public void setUpperDeliveryDates(String upperDeliveryDates) {
		this.upperDeliveryDates = upperDeliveryDates;
	}
	public String getCustomerSelectedShipMethod() {
		return customerSelectedShipMethod;
	}
	public void setCustomerSelectedShipMethod(String customerSelectedShipMethod) {
		this.customerSelectedShipMethod = customerSelectedShipMethod;
	}
	public String getAvailableShipMethod() {
		return availableShipMethod;
	}
	public int getDeliveryGroupNumber() {
		return deliveryGroupNumber;
	}
	public void setDeliveryGroupNumber(int deliveryGroupNumber) {
		this.deliveryGroupNumber = deliveryGroupNumber;
	}
	public void setAvailableShipMethod(String availableShipMethod) {
		this.availableShipMethod = availableShipMethod;
	}
	
	/*public boolean hasShipMethod(ShippingCondAttr[] shipArray,String searchShipMethod){
		//Assume shipArray and searchShipMethod is not null
		for (String string : shipArray) {
			if (string.equals(searchShipMethod)){
				return true;
			}
		}
		return false;
	} */
	public boolean shipEqual(LineItem target){
		//Check if the customer selected ship method is available in list from checkout call
		
		if (this.lowerShipDates.equals(target.getLowerShipDates()) && this.upperShipDates.equals(target.getUpperShipDates())){
			return true;
		}
		return false;
	}
	
	public boolean deliveryAndShipEqual(LineItem target){
		if (this.lowerShipDates.equals(target.getLowerShipDates()) && this.upperShipDates.equals(target.getUpperShipDates()) && this.lowerDeliveryDates.equals(target.getLowerDeliveryDates()) && this.upperDeliveryDates.equals(target.getUpperDeliveryDates())){
			return true;
		}
		return false;
	}
	public String[] getShippingConditionsSP() {
		return shippingConditionsSP;
	}
	public void setShippingConditionsSP(String[] shippingConditionsSP) {
		this.shippingConditionsSP = shippingConditionsSP;
	}
	
	/**
	public boolean equals(Object obj){
		LineItem s = (LineItem)obj;
		if (this.lowerShipDates.hashCode()+this.upperShipDates.hashCode()==s.getLowerShipDates().hashCode()+s.getUpperShipDates().hashCode()){
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode(){
		return this.lowerShipDates.hashCode()+this.upperShipDates.hashCode();
	}**/
}
