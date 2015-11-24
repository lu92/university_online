package com.universityonline.endpoints;

import com.universityonline.services.AccountService;
import com.universityonline.webservices.Account;
import com.universityonline.webservices.accountservice.AccountDetailsRequest;
import com.universityonline.webservices.accountservice.AccountDetailsResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The Class AccountService.
 */
@Endpoint
public class AccountServiceEndpoint
{
	private final Logger logger = Logger.getLogger("AccountServiceEndpoint");
	private static final String TARGET_NAMESPACE = "http://com/universityonline/webservices/accountservice";

	@Autowired
	private AccountService accountService_i;

	@PayloadRoot(localPart = "AccountDetailsRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AccountDetailsResponse getAccountDetails(@RequestPayload AccountDetailsRequest request)
	{

		AccountDetailsResponse response = new AccountDetailsResponse();

		/* call Spring injected service implementation to retrieve account data */
		Account account = accountService_i.getAccountDetails(request.getAccountNumber());
		response.setAccountDetails(account);
		logger.warn("ENDPOINT CALLED");
		return response;
	}

	public void setAccountService(AccountService accountService_p)
	{
		this.accountService_i = accountService_p;
	}
}
