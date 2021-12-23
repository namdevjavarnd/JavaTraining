package com.core.phonebook.service;

import java.sql.SQLException;
import java.util.List;

import com.core.phonebook.dao.PhonebookDao;
import com.core.phonebook.dao.PhonebookDaoImpl;
import com.core.phonebook.model.Phonebook;

public class PhonebookServiceImpl implements PhonebookService {

	PhonebookDao pbdao = new PhonebookDaoImpl();

	@Override
	public int addContactEntry(Phonebook pb) throws SQLException {

		return pbdao.addContactEntry(pb);
	}

	@Override
	public Phonebook searchById(int id) throws SQLException {

		return pbdao.searchById(id);
	}

	@Override
	public Phonebook searchByPhone(String phone) throws SQLException {
		return pbdao.searchByPhone(phone);
	}

	@Override
	public Phonebook searchByName(String name) throws SQLException {
		return pbdao.searchByName(name);
	}

	@Override
	public int updatePhone(String newp, String old) throws SQLException {
		return pbdao.updatePhone(newp, old);
	}

	@Override
	public int updateName(Phonebook pb) throws SQLException {
		return pbdao.updateName(pb);
	}

	@Override
	public int deleteEntry(Phonebook pb) throws SQLException {
		return pbdao.deleteEntry(pb);
	}

	@Override
	public List<Phonebook> listAllEntries() throws SQLException {
		return pbdao.listAllEntries();
	}

	public int quit() throws SQLException {
		
		return pbdao.quit();
	}
}
