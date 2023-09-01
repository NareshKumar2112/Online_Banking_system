package Service;

import java.util.*;

import Database.DbOperator;
public class DataCollector {

	private Scanner s;
	private int accno;
	private String name;
	private int amount;
	private String phoneNo;
	private DbOperator dbop;
	
	public void addData()
	{
		int max=123402,min=20000;
		accno=(int)(Math.random()*((max-min+1)+min));
		s=new Scanner(System.in);
		System.out.println("Enter the name");
		name=s.nextLine();
		amount=0;
		System.out.println("Enter the phoneNo");
		phoneNo=s.nextLine();
		
		 dbop=new DbOperator();
		 dbop.addUser(accno, name, amount, phoneNo);
	}
	
}
