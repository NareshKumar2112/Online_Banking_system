package Database;

import java.awt.List;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class DbOperator {

	private Mongodb mongo;
	private MongoCollection moco;
	private int accno;
	private String name;
	private int amount;
	private String phoneNo;
	private int av_balance;
	private int amount1;
	private int amt1;
	
	public void addUser(int accno,String name,int amount,String phoneNo)
	{
		this.accno=accno;
		this.name=name;
		this.amount=amount;
		this.phoneNo=phoneNo;
		
		mongo=new Mongodb();
		mongo.Connection();
		moco=mongo.getMoco();
		
		moco.insertOne(new Document().append("accno",accno).append("name",name).append("amount",amount).append("phoneNo",phoneNo));
		System.out.println("Data is added successfully");
		
	}
	
	
	public void addAmount(int accno,int balance)
	{
		this.accno=accno;
		mongo=new Mongodb();
		mongo.Connection();
		moco=mongo.getMoco();
		BasicDBObject bdo=new BasicDBObject();
		bdo.put("accno", accno);
		
		MongoCursor<Document> mci=moco.find(bdo).iterator();
		while(mci.hasNext())
		{
			Document doc=mci.next();
			av_balance=doc.getInteger("amount");
		}
		moco.updateOne(Filters.eq("accno",accno),Updates.set("amount",balance+av_balance));
		System.out.println("the current amount is "+balance+av_balance);
	}
	
	
	public void getAmount(int accno,int amount1)
	{
		this.amount1=amount1;
		mongo=new Mongodb();
		mongo.Connection();
		moco=mongo.getMoco();
		BasicDBObject bdo=new BasicDBObject();
		bdo.put("accno",accno);
		MongoCursor<Document> mci=moco.find(bdo).iterator();
		while(mci.hasNext())
		{
			Document doc=mci.next();
			amt1=doc.getInteger("amount");
		}
		if(amt1>amount1)
		{
			moco.updateOne(Filters.eq("accno",accno), Updates.set("amount",amt1-amount1));
			System.out.println("the available amount is "+(amt1-amount1));
		}
		else
		{
			System.out.println("Amount requested is higher than the available amount - "+amt1);
		}
	}
	
	public void getInfo(int accno)
	{
		this.accno=accno;
		mongo=new Mongodb();
		mongo.Connection();
		moco=mongo.getMoco();
		BasicDBObject bdo=new BasicDBObject();
		bdo.put("accno",accno);
		MongoCursor<Document> mc1=moco.find(bdo).iterator();
		while(mc1.hasNext())
		{
			Document doc=mc1.next();
			System.out.println("Name- "+doc.getString("name"));
			System.out.println("Available amount- "+doc.getInteger("amount"));
		}
	}
	
}
