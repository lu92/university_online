package com.universityonline.services;

import com.universityonline.webservices.Account;

/**
 * The Interface AccountService.
 */
public interface AccountService
{
	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	public Account getAccountDetails(String accountNumber);
}
