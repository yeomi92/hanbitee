package domain;

import java.io.Serializable;

import constants.Bank;

public class AccountBean implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String id,accountType,createDate,money,accoutNo;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getAccoutNo() {
		return accoutNo;
	}
	public void setAccoutNo(String accoutNo) {
		this.accoutNo = accoutNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "["+Bank.BANK_NAME+"]\n계좌번호: "+accoutNo+"\n예금종류: "+accountType+"\nID: "+id+"\n가입일: "+createDate+"\n잔액: "+money+"원";
	}
}
