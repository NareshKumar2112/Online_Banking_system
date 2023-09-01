package Main1;

import java.util.*;

import Service.DataCollector;
import Service.MoneyOperator;
public class Main {

	public static void main(String[] args) 
	{
		System.out.println("---Welcome to Digital One Bank---");
		System.out.println("For new user press 1");
		System.out.println("For existing user press 2");
		Scanner s=new Scanner(System.in);
		int ch=s.nextInt();
		
		if(ch==1)
		{
			DataCollector dc=new DataCollector();
			dc.addData();
		}
		else if(ch==2)
		{
			System.out.println("Enter 1 to deposit the amount");
			System.out.println("Enter 2 to withdraw the amount");
			System.out.println("Enter 3 to chech th details");
			MoneyOperator mo=new MoneyOperator();
			int ch1=s.nextInt();
			if(ch1==1)
			{
				mo.deposit();
			}
			else if(ch1==2)
			{
				mo.withDraw();
			}
			else if(ch1==3)
			{
				mo.check();
			}
			else
			{
				System.out.println("Enter the valid number");
			}
		}
		else
		{
			System.out.println("Enter the valid option");
		}
	}

}
