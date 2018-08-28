# BVCOE_Assignment
MY PROJECT Named As BVCOE_Assignment in which there is::
Two Entity Class:: 1.Data Class for Owner Information 2.Node Class For Node Information
One Encryption Class to Encrypt the owner data (not Able to Integrate in Main Code)
One Decryption Class to Decrypt the owner data (not Able to Integrate in Main Code)
One Main Class Which Is a NodeCreation Class in which Data of Owner is set , genesisNode is Creted, Child Node Is Created and Also have a HashCode(for Data Object) & HashValue(For Node Object) generation Method etc
only needed libraries are used inside the Program
MonogoDB(NO SQL) DataBase Is Used For Data Storage or Backend Process so for That external Java driver is used in it to connect to it.
There is also a Json Jar File is embeded because to Covert java object into json string using the Gson library then insert it in Mongodb. collection


Steps For Execution::
1st::Install the MonogoDB DataBase into The System
2nd::create a new Project into Eclipse and Copy all the Java File into src Folder
3rd::download Nescessary Jar Files (mongodb Driver and json driver) from Web.
4th::import jar into the project
5th::open project and Compile it.
6th::run the project from NodeCreation Class.
