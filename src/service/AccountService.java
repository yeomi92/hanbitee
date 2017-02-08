package service;

import domain.AccountBean;

public interface AccountService {
	//create
	public AccountBean createAccount(String uid,String accountType,int money);
	//read - one
	public AccountBean findByAccountNo(String accountNo);
	//read - some
	public AccountBean[] findByName(String name);
	public int countByName(String name);
	//read - all
	public AccountBean[] list();
	public int sount();
	//read - special
	public boolean checkmoney(int money);
	//update
	public String deposit(int money);
	public String withdraw(int money);
	//delete
	public void drop(String accountNo);
}