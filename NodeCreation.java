package Posist;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


public class NodeCreation 
{
	static int count;
	static Scanner scan;
	
	//Basic Initilization
	static void init()
	{
		count=1;
		scan=new Scanner(System.in);
	}
	
	//method to Calculate HashCode For Data
	public static int hashCode(int id,String name,float value) 
	{
	    return (int) id * name.hashCode()*(int)value;
	}
	
	//method to Calculate HashValue For Node
	public static int hashValue(long timestamp,Data data,int nodeNum,String nodeID,String refNodeID,String childNodeID,String genesisRefNodeID) 
	{
	    return (int) timestamp * data.hashCode()*nodeNum* nodeID.hashCode()*refNodeID.hashCode()*childNodeID.hashCode()*genesisRefNodeID.hashCode();
	}
	
	
	//getting the Data From The User Of The Node
	public static Data setDatas()
    {
		System.out.println("Enter the ID of owner : ");
        int id=scan.nextInt();
        System.out.println("Enter the name of owner : ");
        String name=scan.next();
        System.out.println("Enter the value : ");
        float value=scan.nextFloat();
        int hashcode=hashCode(id,name,value);
        Data data=new Data(id,name,value,hashcode);
        return data;
    }
	
	//creation of Genesis Node
	public static Node setGenesisNode()
	{
		//Call SetData To set the data into the Nodes
		Data data=setDatas();
		int nodenum=1;
        String nodeid;
        String refnodeid=null;
		String childnodeid;
		String genesisRefNodeID=null;
        System.out.println("Enter the unique id of node : ");
        nodeid=scan.next();
        System.out.println("Enter the unique id of child node : ");
        childnodeid=scan.next();
        Node node=new Node();
        Date date=new Date();
        node.setTimestamp(date.getTime());
        node.setData(data);
        node.setNodeNum(nodenum);
        node.setNodeID(nodeid);
        node.setRefNodeID(refnodeid);
        node.setChildNodeID(childnodeid);
        node.setGenesisRefNodeID(genesisRefNodeID);
        node.setHashvalue(hashValue(date.getTime(),data,nodenum,nodeid,refnodeid,childnodeid,genesisRefNodeID));
        return node;
	}
	
	//creation of Further SubNodes
	public static Node setNode()
	{
		//Call SetData To set the data into the Nodes
		Data data=setDatas();
		int nodenum=count+1;
		count++;
		String nodeid;
		String refnodeid;
		String childnodeid;
		String genesisRefNodeID;
        System.out.println("Enter the unique id of node : ");
        nodeid=scan.next();
        System.out.println("Enter the RefNode id of node : ");
        refnodeid=scan.next();
        System.out.println("Enter the unique id of child node : ");
        childnodeid=scan.next();
        System.out.println("Enter the child RefNode id of node : ");
        genesisRefNodeID=scan.next();
        Node node=new Node();
        Date date=new Date();
        node.setTimestamp(date.getTime());
        node.setData(data);
        node.setNodeNum(nodenum);
        node.setNodeID(nodeid);
        node.setRefNodeID(refnodeid);
        node.setChildNodeID(childnodeid);
        node.setGenesisRefNodeID(genesisRefNodeID);
        node.setHashvalue(hashValue(date.getTime(),data,nodenum,nodeid,refnodeid,childnodeid,genesisRefNodeID));
        return node;
	}
	
	
	public static void main(String[] args) throws UnknownHostException
	{
		//Mogodb Connection Creation
		MongoClient mclient=new MongoClient("localhost",27017);
		
		//Mogodb database Creation
		DB db=mclient.getDB("Posist");
		
		//Mogodb Collection Creation
		DBCollection coll=db.getCollection("NodeData");
		
		//Calling of init() Method
		init();
		

	    DBCursor cursor = coll.find();
	    try 
	    {
	    	while(cursor.hasNext())
	    	{
	    		BasicDBObject obj=(BasicDBObject) cursor.next();
	    		Node node = (new Gson()).fromJson(obj.toString(), Node.class);
	    		BasicDBObject obj1;
	    		//check that there is already a Null RefNodeId
	    		//if yes then create Node having RefNodeId is not Null
	    		if(node.getRefNodeID().equals("null"))
	    		{
	    			//Covert java object into json string using the Gson library 
	    			//and then insert it in Mongodb collection.
	    			Gson gson = new Gson();
	    			obj1 = (BasicDBObject)JSON.parse(gson.toJson(setNode()));
	    			coll.insert(obj);
	    		}
	    		//else create first node
	    		else
	    		{
	    			//Covert java object into json string using the Gson library 
	    			//and then insert it in Mongodb collection.
	    			Gson gson = new Gson();
	    			obj1 = (BasicDBObject)JSON.parse(gson.toJson(setGenesisNode()));
	    			coll.insert(obj1);
	    		}
	    	}
	    }
	    finally
	    {
	    	cursor.close();
	    }
	}

}
