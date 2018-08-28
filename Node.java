package Posist;



public class Node
{
	long timestamp;
    Data data;
    int nodeNum;
    String nodeID;
    String refNodeID;
    String childNodeID;
    String genesisRefNodeID;
    int hashvalue;
    
    public Node() 
    {
    	
    }
    
    public Node(long timestamp,Data data,int nodeNum,String nodeID,String refNodeID,String childNodeID,String genesisRefNodeID,int hashvalue)
    {
    	this.timestamp=timestamp;
    	this.data=data;
    	this.nodeNum=nodeNum;
    	this.nodeID=nodeID;
    	this.refNodeID=refNodeID;
    	this.childNodeID=childNodeID;
    	this.genesisRefNodeID=genesisRefNodeID;
    	this.hashvalue=hashvalue;
    }

	public long getTimestamp() 
	{
		return timestamp;
	}

	public void setTimestamp(long l) 
	{
		this.timestamp = l;
	}

	public Data getData() 
	{
		return data;
	}

	public void setData(Data data2)
	{
		this.data = data2;
	}

	public int getNodeNum() 
	{
		return nodeNum;
	}

	public void setNodeNum(int nodeNum)
	{
		this.nodeNum = nodeNum;
	}

	public String getNodeID() 
	{
		return nodeID;
	}

	public void setNodeID(String nodeID)
	{
		this.nodeID = nodeID;
	}

	public String getRefNodeID() 
	{
		return refNodeID;
	}

	public void setRefNodeID(String refNodeID)
	{
		this.refNodeID = refNodeID;
	}

	public String getChildNodeID() 
	{
		return childNodeID;
	}

	public void setChildNodeID(String childNodeID)
	{
		this.childNodeID = childNodeID;
	}

	public String getGenesisRefNodeID() 
	{
		return genesisRefNodeID;
	}

	public void setGenesisRefNodeID(String genesisRefNodeID)
	{
		this.genesisRefNodeID = genesisRefNodeID;
	}

	public int getHashvalue() 
	{
		return hashvalue;
	}

	public void setHashvalue(int hashvalue)
	{
		this.hashvalue = hashvalue;
	}
}
