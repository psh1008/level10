package _17쓰레드;

import java.util.Random;

class CustomerRun implements Runnable{

	String name;
	ATM atmToUse;
	int needMoney;
	
	CustomerRun(String name, ATM atmToUse, int needMoney) {
		super();
		this.name = name;
		this.atmToUse = atmToUse;
		this.needMoney = needMoney;
	}

	@Override
	public void run() {
		while(atmToUse.getBalance() >= needMoney) {
			atmToUse.withdraw(name, needMoney);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ATM{
	private int balance = 0;
	public void addMoney(int amount) {
		balance += amount;
	}
	public int getBalance() {
		return balance;
	}
	public void withdraw(String name, int amount) {
		if(balance < amount)return;
		System.out.printf("%s 인출 요청 (현재 잔액 %d) \n",name,balance);
		try {
			Thread.sleep(new Random().nextInt(301)+700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		balance -= amount;
		System.out.printf("%s 인출 완료 (현재 잔액 %d) \n",name,balance);
	}
}

public class _06쓰레드이론05 {

	public static void main(String[] args) {

		ATM atm = new ATM();
		
		atm.addMoney(5000);
		
		Thread thr1 = new Thread(new CustomerRun("철수",atm,500));
		Thread thr2 = new Thread(new CustomerRun("영희",atm,200));
		Thread thr3 = new Thread(new CustomerRun("개똥이",atm,300));
		thr1.start();
		thr2.start();
		thr3.start();
		
		
	}

}
