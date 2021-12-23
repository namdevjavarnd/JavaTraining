package com.core.phonebook.test;

import com.core.phonebook.db.DataBaseConnection;

public class DBtestConnection {
	
	public static void main(String[] args) {
		DataBaseConnection dcon= new DataBaseConnection();
		System.out.println(dcon.testCon());
	}

}
