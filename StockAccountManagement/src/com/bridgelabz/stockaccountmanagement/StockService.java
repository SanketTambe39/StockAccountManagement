package com.bridgelabz.stockaccountmanagement;

public interface StockService {
	
	public  void addStock(Stock stock );
	public void getDetails();
	public void getDetailsByName(String stockName);
	public void calculateValueOfEachItem();
	public void getTotalValue();
	public void buyStocks(int amount , String symbol);
	public void sellStocks(String sellStocks,int amount);
	public void getTrasaction();
	public void getTimestamp();
}
