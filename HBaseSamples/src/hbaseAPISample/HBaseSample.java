package hbaseAPISample;

import java.io.IOException;
import java.util.NavigableMap;

import org.apache.hadoop.conf.*;

import org.apache.hadoop.hbase.*;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseSample {
<<<<<<< HEAD

	public static void main(String[] args) throws IOException {
		try {
			String server = args[0];

=======
	public static void main(String[] args) throws IOException {
		try {
			String server = args[0];
 
>>>>>>> parent of 9e6c44b... Mongo Soda
			Configuration config = HBaseConfiguration.create();
			config.set("hbase.zookeeper.quorum", server);
			config.set("hbase.zookeeper.property.clientport", "2181");
			HBaseAdmin.checkHBaseAvailable(config);
			Connection connection = ConnectionFactory.createConnection(config);
<<<<<<< HEAD

			System.out.println("Connected");

			Table myTable = connection.getTable(TableName.valueOf("ourfriends"));

			byte[] myRowKey = Bytes.toBytes("guy");
			byte[] myColFamily = Bytes.toBytes("info");
			byte[] myColName = Bytes.toBytes("email");

=======
			
			System.out.println("Connected");

			Table myTable = connection.getTable(TableName.valueOf("friends"));
 
			byte[] myRowKey = Bytes.toBytes("guy");
			byte[] myColFamily=Bytes.toBytes("info");
			byte[] myColName=Bytes.toBytes("email"); 
			
>>>>>>> parent of 9e6c44b... Mongo Soda
			Get myGet = new Get(myRowKey);
			Result myResult = myTable.get(myGet);
			byte[] myBytes = myResult.getValue(myColFamily, myColName);
			String email = Bytes.toString(myBytes);
<<<<<<< HEAD
			System.out.println("Email address=" + email);

			iterateCF(myTable, myRowKey);

			//
			// Insert a new value
			//

			myColFamily = Bytes.toBytes("friends");
			byte[] myNewColName = Bytes.toBytes("paul");
			byte[] myNewColValue = Bytes.toBytes("paul@fmail.com");
			Put myPut = new Put(myRowKey);
			myPut.addColumn(myColFamily, myNewColName, myNewColValue);
			myTable.put(myPut);

=======
			System.out.println("Email address="+email);

			iterateCF(myTable, myRowKey);
			
			//
			// Insert a new value 
			//
			
			myColFamily=Bytes.toBytes("friends");
			byte [] myNewColName=Bytes.toBytes("paul"); 
			byte [] myNewColValue=Bytes.toBytes("paul@fmail.com"); 
			Put myPut=new Put(myRowKey);
			myPut.addColumn(myColFamily,myNewColName,myNewColValue); 
			myTable.put(myPut);
			
>>>>>>> parent of 9e6c44b... Mongo Soda
			iterateCF(myTable, myRowKey);

			myTable.close();
			connection.close();
			System.out.println("Done");

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	private static void iterateCF(Table myTable, byte[] myRowKey) throws IOException {
<<<<<<< HEAD

		System.out.println("Iterating....");
		// Iterate through columns in a column families
		byte[] myColFamily = Bytes.toBytes("friends");
		Get myGet = new Get(myRowKey);
		Result myResult = myTable.get(myGet);
		NavigableMap<byte[], byte[]> myFamilyMap = myResult.getFamilyMap(myColFamily);

		for (byte[] colNameBytes : myFamilyMap.keySet()) {
			// Get the name of the column in the column family
			String colName = Bytes.toString(colNameBytes);
			byte[] colValueBytes = myResult.getValue(myColFamily, colNameBytes);
			System.out.println("Column " + colName + "=" + Bytes.toString(colValueBytes));
=======
 
		// Iterate through columns in a column families
		byte [] myColFamily=Bytes.toBytes("friends");
		Get myGet = new Get(myRowKey);
		Result myResult = myTable.get(myGet);
		NavigableMap<byte[], byte[]> myFamilyMap = myResult.getFamilyMap(myColFamily);
		
		for (byte[] colNameBytes : myFamilyMap.keySet()) {
			// Get the name of the column in the column family
			String colName= Bytes.toString(colNameBytes);				
			byte[] colValueBytes = myResult.getValue(myColFamily, colNameBytes);
			System.out.println("Column "+colName+"="+Bytes.toString(colValueBytes)); 
>>>>>>> parent of 9e6c44b... Mongo Soda
		}

		System.out.println("got");
	}
}
