package Posist;

public class Data 
{
int ownerid;
String ownername;
float value;
int hashcode;

public Data() 
{
	
}

public Data(int ownerid,String ownername,float value,int hashcode)
{
	this.ownerid=ownerid;
	this.ownername=ownername;
	this.value=value;
	this.hashcode=hashcode;
}

public void setOwnerid(int ownerid)
{
	this.ownerid=ownerid;
}

public int getOwnerid()
{
	return this.ownerid;
}

public void setOwnername(String ownername)
{
	this.ownername=ownername;
}

public String getOwnername()
{
	return this.ownername;
}

public void setValue(float value)
{
	this.value=value;
}

public float getValue()
{
	return this.value;
}

public void setHashcode(int hashcode)
{
	this.hashcode=hashcode;
}

public int getHashcode()
{
	return this.hashcode;
}
}
