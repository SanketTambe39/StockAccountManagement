package com.bridgelabz.stockaccountmanagement;

import java.util.Scanner;

public class StockMain {

	public static final int addItem = 1;
	public static final int getAllDetails = 2;
	public static final int getDetailsOfAShare = 3;
	public static final int calculateValueOfEachShare = 4;
	public static final int calculateTotalValueOfShares = 5;
	public static final int exit = 6;
	
	public static void main(String[] args) {
	
		StockService newStocks = new StockServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Stock Account Management");
		while (true)
		{
			System.out.println("what you want to do ");
			System.out.println("1) Add Stocks \n2) Get details"
					+ " \n3) Get details of particular Stock \n4) Calculate value of each Stock"
					+ " \n5) Calculate total value \n6) Quit");
			System.out.println("Enter Your Choice ");

			int userChoice = scanner.nextInt();
			switch (userChoice)
			{
			//case to add item in inventory
			case addItem:
			{
				System.out.println("Enter the number of stocks you want to add");
				int numberOfStocks = scanner.nextInt();
				for ( int Quantity = 0; Quantity < numberOfStocks; Quantity++) 
				{
					Stock stock = new Stock();
					System.out.println("Enter the name of the stock");
					stock.setStockName(scanner.next().toUpperCase());
					System.out.println("Enter the number of shares ");
					stock.setNumberofShare(scanner.nextInt());
					System.out.println("Enter the price of the stock");
					stock.setSharePrice(scanner.nextDouble());
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
			case getDetailsOfAShare :
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
