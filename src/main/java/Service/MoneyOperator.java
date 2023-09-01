package Service;
import java.util.*;

import Database.DbOperator;
public class MoneyOperator {

	private Scanner s;
	private int amount;
	private int accno;
	private DbOperator dbo;
	
	public void deposit()
	{
		s=new Scanner(System.in);
		System.out.println("Enter the account number");
		accno=s.nextInt();
		System.out.println("Enter the amount");
		amount=s.nextInt();
		dbo=new DbOperator();
		dbo.addAmount(accno, amount);
	}
	public void withDraw()
	{
		s=new Scanner(System.in);
		System.out.println("Enter the account number");
		accno=s.nextInt();
		System.out.println("Enter the amount");
		amount=s.nextInt();
		dbo=new DbOperator();
		dbo.getAmount(accno, amount);
	}
	public void check()
	{
		s=new Scanner(System.in);
		System.out.println("Enter the account number");
		accno=s.nextInt();
		dbo=new DbOperator();
		dbo.getInfo(accno);
	}
}
