package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

//Whatever class we use to do input and output on the console, should primarily and only be doing
//that input and output. Keep unrelated business logic in other classes that are more appropriate
public class LockBankATM {

	private static final String MAIN_MENU_OPTION_CHECKING = "Open A Checking Account ";
	private static final String MAIN_MENU_OPTION_SAVINGS = "Open A Savings Account ";
	private static final String MAIN_MENU_OPTION_DEPOSIT = "Make A Deposit";
	private static final String MAIN_MENU_OPTION_WITHDRAW = "Make A Withdraw";
	private static final String MAIN_MENU_OPTION_BALANCE = "Check Balance";
	private static final String EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_CHECKING, MAIN_MENU_OPTION_SAVINGS, MAIN_MENU_OPTION_DEPOSIT, MAIN_MENU_OPTION_WITHDRAW, MAIN_MENU_OPTION_BALANCE, EXIT };

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
					createCustomer();
				}

				createAccount(true);

			} else if (choice.equals(MAIN_MENU_OPTION_SAVINGS)) {
				// open savings, prompting user for name of account and initial deposit
				if(this.customer == null) {
					createCustomer();
				}

				createAccount(false);

			} else if (choice.equals(MAIN_MENU_OPTION_DEPOSIT)) {
				// make deposit, ask user how much then show balance
				if(customer != null) {

					BankAccount selectedAccount = promptUserForBankAccount();

					//keep in mind it will be good to validate they didn't enter something negative
					// or non numeric
					System.out.println("How much would you like to deposit?");
					String amountStr = userInput.nextLine();
					BigDecimal amount = new BigDecimal(amountStr);
					selectedAccount.deposit(amount);

					System.out.println("Your new balance is " + selectedAccount.getBalance());
				} else {
					System.out.println("Please open an account first");
				}

			} else if (choice.equals(MAIN_MENU_OPTION_WITHDRAW)) {
				// make withdraw ask user how much then show balance
				if(customer != null) {
					BankAccount selectedAccount = promptUserForBankAccount();
					//keep in mind it will be good to validate they didn't enter something negative
					// or non numeric
					System.out.println("How much would you like to withdraw?");
					String amountStr = userInput.nextLine();
					BigDecimal amount = new BigDecimal(amountStr);
					selectedAccount.withdraw(amount);
					System.out.println("Your new balance is " + selectedAccount.getBalance());
				} else {
					System.out.println("Please open an account first");
				}

			} else if (choice.equals(MAIN_MENU_OPTION_BALANCE)) {
				// show balance
				if(customer != null) {
					BankAccount selectedAccount = promptUserForBankAccount();
					System.out.println("Your balance is " + selectedAccount.getBalance());
				} else {
					System.out.println("Please open an account first");
				}
			} else if (choice.equals(EXIT)){
				break;
			}
		}
	}

	public BankAccount promptUserForBankAccount() {
		System.out.println("Please enter the number corresponding to the account");

		//foreach loop
		//declare an individual variable that will represent each unique element
		//    one at a time as it loops through the list
		// ":" means "in"
		// and then we put our list
		int index = 0;
		for(BankAccount account : customer.getBankAccounts()){
			System.out.println(index + ") " + account.getName());
			index++;
		}

		String selected = userInput.nextLine();
		int selectedIndex = Integer.parseInt(selected);
		BankAccount selectedAccount = customer.getBankAccounts().get(selectedIndex);
		return selectedAccount;
	}

	public void createAccount(boolean isChecking){
		System.out.println("What do you want to name the account?");
		String name = userInput.nextLine();

		System.out.println("How much are initially depositing?");
		String initial = userInput.nextLine();
		BigDecimal deposit = new BigDecimal(initial);
		if(deposit.compareTo(BankAccount.MIN_OPENING_DEPOSIT) >= 0) {

			if(isChecking) {
				//open the checking
				CheckingAccount checking = new CheckingAccount(name, deposit);

				//if we are using a list
				this.customer.addBankAccount(checking);
			} else {
				BigDecimal promoInterestRate = new BigDecimal(".04");
				SavingsAccount savings = new SavingsAccount(name, deposit, promoInterestRate);
				this.customer.addBankAccount(savings);
			}

			//if we are using a map
			//this.inventory.addBankAccountToMap(checking);

		} else {
			System.out.println("We're sorry - you need to deposit at least " + BankAccount.MIN_OPENING_DEPOSIT);
		}
	}

	public void createCustomer(){
		//create a new customer

		System.out.println("What is your name?");
		String name = userInput.nextLine();

		System.out.println("What is your ssn or tax payer id?");
		String ssn = userInput.nextLine();

		this.customer = new Customer(name, ssn);

		//it would be 100% more appropriate to ask for birth date
		//but to save on time, we'll just cut to the chase
		System.out.println("What is your age - for real?");
		String ageStr =userInput.nextLine();
		int age = Integer.parseInt(ageStr);
		//boolean over18 = age >= 18;
		boolean over18 = false;
		if(age >= 18){
			over18 = true;
		}
		this.customer.setOlderThan18OrGuardian(over18);
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		LockBankATM cli = new LockBankATM(menu);
		cli.run();
	}
}
