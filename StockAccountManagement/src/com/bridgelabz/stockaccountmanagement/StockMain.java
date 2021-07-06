package com.bridgelabz.stockaccountmanagement;

import java.util.Scanner;

public class StockMain {

	public static final int addStock = 1;
	public static final int getAllDetails = 2;
	public static final int getDetailsOfAStock = 3;
	public static final int calculateValueOfEachShare = 4;
	public static final int calculateTotalValueOfShares = 5;
	public static final int BUY_STOCKS = 6;
	public static final int SELL_STOCKS = 7;
	public static final int CHECK_PAST_TRASACTIONS = 8;	
	public static final int exit = 9;
	
	public static void main(String[] args) {
	
		StockService newStocks = new StockServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Stock Account Management");
		while (true)
		{
			System.out.println("what you want to do ");
			System.out.println("1) Add Stocks \n2) Get details"
					+ " \n3) Get details of particular Stock \n4) Calculate value of each Stock"
					+ " \n5) Calculate total value \n6) Buy Stocks "
					+ "\n7) Sell Stocks \n8) Check Past Transaction"
					+ "\n9)Quit");
			System.out.println("Enter Your Choice ");

			int userChoice = scanner.nextInt();
			switch (userChoice)
			{
			//case to add item in inventory
			case addStock:
			{
				System.out.println("Enter the number of stocks you want to add");
				int numberOfStocks = scanner.nextInt();
				for ( int Quantity = 0; Quantity < numberOfStocks; Quantity++) 
				{
					Stock stock = new Stock();
					System.out.println("Enter the name of the stock");
					stock.setStockName(scanner.next().toUpperCase());
					System.out.println("Enter the symbol of stock ");
					stock.setStockSymbol(scanner.next().toUpperCase());
					System.out.println("Enter the number of shares ");
					stock.setNumberofShare(scanner.nextInt());
					System.out.println("Enter the price of the each shares");
					stock.setPricePerShare(scanner.nextDouble());
					newStocks.addStock(stock);		
				}
				break;

			}
			//case to get all details in inventory
			case getAllDetails :
			{
				newStocks.getDetails();
				break;
			}

			//case to get details of particular item
			case getDetailsOfAStock :
			{
				System.out.println("Enter the name of the stock which you want to fetch");
				newStocks.getDetailsByName(scanner.next().toUpperCase());
				break;
			}

			//case to calculate value of each item
			case calculateValueOfEachShare:
			{
				newStocks.calculateValueOfEachItem();
				break;
			}

			//case to calculate value of all the items
			case calculateTotalValueOfShares:
			{
				newStocks.getTotalValue();
				break;
			}
			
			case SELL_STOCKS:
			{				
				System.out.println("Enter the symbol of the stock which you want to sell");
				String symbol  = scanner.next().toUpperCase();
				System.out.println("Enter the number of the stocks which you want to sell");
				int amount  = scanner.nextInt();
				newStocks.sellStocks(symbol, amount);
				break;
			}

			//case to purchase stocks
			case BUY_STOCKS:
			{
				System.out.println("Enter the symbol of the stock which you want to purchase");
				String symbol  = scanner.next().toUpperCase();
				System.out.println("Enter the number of shares you want to purchase");
				int amount  = scanner.nextInt();
				newStocks.buyStocks(amount , symbol);
				break;
			}
			
			case CHECK_PAST_TRASACTIONS :
			{
				newStocks.getTrasaction();
				break;
			}

			//case to exit program
			case exit:
			{
				System.out.println("Thanks for using us");
				scanner.close();
				System.exit(0);
				break;
			}

			default:
				System.out.println("Enter Corret option");

			}
		}
	}
}
