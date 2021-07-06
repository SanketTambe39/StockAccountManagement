package com.bridgelabz.stockaccountmanagement;

public interface StockService {
	
	public  void addStock(Stock stock );
	public void getDetails();
	public void getDetailsByName(String stockName);
	public void calculateValueOfEachItem();
	public void getTotalValue();
}
