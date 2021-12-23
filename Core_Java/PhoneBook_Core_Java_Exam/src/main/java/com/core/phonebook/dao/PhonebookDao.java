package com.core.phonebook.dao;

import java.sql.SQLException;
import java.util.List;

import com.core.phonebook.model.Phonebook;



public interface PhonebookDao {
	
	public int addContactEntry(Phonebook pb) throws SQLException;
	
	public Phonebook searchById(int id) throws SQLException;
	public Phonebook searchByPhone(String phone) throws SQLException;
	public Phonebook searchByName(String name) throws SQLException;
	
	public int updatePhone(String newp, String old) throws SQLException;
	public int updateName(Phonebook pb) throws SQLException;
	
	public int deleteEntry(Phonebook pb) throws SQLException;

	public List<Phonebook> listAllEntries() throws SQLException;
	
	public int quit() throws SQLException;
	
	
	
	
}
