package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;


//Whatever class we use to do input and output on the console, should primarily and only be doing
//that input and output. Keep unrelated business logic in other classes that are more appropriate.
public class LockBankATM {

	private static final String MAIN_MENU_OPTION_CHECKING = "Open A Checking Account ";
	private static final String MAIN_MENU_OPTION_SAVINGS = "Open A Savings Account ";
	private static final String MAIN_MENU_OPTION_DEPOSIT = "Make A Deposit";
	private static final String MAIN_MENU_OPTION_WITHDRAW = "Make A Withdraw";
	private static final String MAIN_MENU_OPTION_BALANCE = "Check Balance";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_CHECKING, MAIN_MENU_OPTION_SAVINGS, MAIN_MENU_OPTION_DEPOSIT, MAIN_MENU_OPTION_WITHDRAW, MAIN_MENU_OPTION_BALANCE };

	private Menu menu;
	private Customer customer = null;
	private Scanner userInput = new Scanner(System.in);

	public LockBankATM(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_CHECKING)) {
				// open checking, prompting user for name of account and initial deposit

				if(customer == null) {
					//create a new customer
					createCustomer();

				}



					System.out.println("What is your name?");
					String name = userInput.nextLine();

					System.out.println("What is your SSN or Tax Payer ID?");
					String ssn = userInput.nextLine();

					this.customer = new Customer(name, ssn);

					System.out.println("Please enter your age: ");
					String ageStr = userInput.next();
					int age = Integer.parseInt(ageStr);
					//boolean over18 = age >= 18;
					boolean over18 = false;
					if(age >= 18){
						over18 = true;
					}

					this.customer.setOlderThan18OrGuardian(over18);
				}

			public void createAccount(boolean isChecking) {
				System.out.println("What do you want to name the account?");
				String name = userInput.nextLine();

				System.out.println("How much are you initially depositing?");
				String initial = userInput.nextLine();
				BigDecimal deposit = new BigDecimal(initial);
				if(deposit.compareTo(BankAccount.MIN_OPENING_DEPOSIT) >= 0) {

					if(isChecking) {
						//open the checking account
						CheckingAccount checking = new CheckingAccount(name, deposit);

						//if we are using a list
						this.customer.addBankAccount(checking);
					} else {
						BigDecimal promoInterestRate = new BigDecimal(".04");
						SavingsAccount savings = new SavingsAccount(name, deposit, promoInterestRate);
					}

					//if we are using a map
					//this.customer.addBankAccountToMap(checking);

				} else {
					System.out.println("We're sorry - you need to deposit at least " + BankAccount.MIN_OPENING_DEPOSIT);
				}


			} else if (choice.equals(MAIN_MENU_OPTION_SAVINGS)) {
				// open savings, prompting user for name of account and initial deposit
			} else if (choice.equals(MAIN_MENU_OPTION_DEPOSIT)) {
				// make deposit, ask user how much then show balance
			} else if (choice.equals(MAIN_MENU_OPTION_WITHDRAW)) {
				// make withdraw ask user how much then show balance
			} else if (choice.equals(MAIN_MENU_OPTION_BALANCE)) {
				// show balance
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		LockBankATM cli = new LockBankATM(menu);
		cli.run();
	}
}
