package com.techelevator;

import com.techelevator.view.Menu;

public class LockBankATM {

	private static final String MAIN_MENU_OPTION_CHECKING = "Open A Checking Account ";
	private static final String MAIN_MENU_OPTION_SAVINGS = "Open A Savings Account ";
	private static final String MAIN_MENU_OPTION_DEPOSIT = "Make A Deposit";
	private static final String MAIN_MENU_OPTION_WITHDRAW = "Make A Withdraw";
	private static final String MAIN_MENU_OPTION_BALANCE = "Check Balance";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_CHECKING, MAIN_MENU_OPTION_SAVINGS, MAIN_MENU_OPTION_DEPOSIT, MAIN_MENU_OPTION_WITHDRAW, MAIN_MENU_OPTION_BALANCE };

	private Menu menu;

	public LockBankATM(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_CHECKING)) {
				// open checking, prompting user for name of account and initial deposit
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
