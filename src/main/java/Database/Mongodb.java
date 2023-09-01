package Database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Mongodb {

	private MongoClient mocl;
	private MongoDatabase modb;
	private MongoCollection<Document> moco;
	
	public void Connection()
	{
		mocl=new MongoClient("localhost",27017);
		modb=mocl.getDatabase("Bank");
		moco=modb.getCollection("User");
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
	}

	public MongoClient getMocl() {
		return mocl;
	}

	public void setMocl(MongoClient mocl) {
		this.mocl = mocl;
	}

	public MongoDatabase getModb() {
		return modb;
	}

	public void setModb(MongoDatabase modb) {
		this.modb = modb;
	}

	public MongoCollection getMoco() {
		return moco;
	}

	public void setMoco(MongoCollection moco) {
		this.moco = moco;
	}
	
}
