package com.bridgelabz.stockaccountmanagement;

import java.util.LinkedList;

public class StockServiceImpl implements StockService {

	LinkedList <Stock> stockslist = new LinkedList<Stock>();

	@Override
	public void addStock(Stock stock)
	{
		if (ItemAlreadyPresent(stock))
		{
			System.out.println("Item already exsists you can try update option to chenge the value");
		}
		else
		{

			stockslist.add(stock);
			System.out.println(stock.getStockName() +" Added sucessfully");
		}
	}
	private boolean ItemAlreadyPresent(Stock stock)
	{
		boolean check = false ; 
		for (Stock stocks : stockslist)
		{
			if (stocks.getStockName().equals(stock.getStockName()))
			{			
				check = true;
				break;
			}
		}
		return check;
	}

	@Override
	public void getDetails() 
	{
		System.out.println("Stocks in the Inventory are ");
		int i = 1;
		for (Stock stocks : stockslist) 
		{
			System.out.println((i++)+") "+stocks);
		}

	}

	@Override
	public void getDetailsByName(String stockName) 
	{
		boolean found = false;
		for (Stock stocks : stockslist)
		{
			if (stocks.getStockName().equals(stockName))
			{			
				System.out.println("Stock found : "+stocks);
				found = true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("Stock not found");			
		}

	}

	@Override
	public void calculateValueOfEachItem()
	{
		for (Stock stocks : stockslist) 
		{
			System.out.println("value of "+stocks.getStockName()+" is "+( stocks.getNumberofShare()*stocks.getSharePrice() ) );
		}

	}

	@Override
	public void getTotalValue() 
	{
		double totalValue = 0;

		for (Stock stocks : stockslist) 
		{
			totalValue += stocks.getNumberofShare()*stocks.getSharePrice();
		}
		System.out.println("Total values of all stocks are "+totalValue);

	}
	
}
