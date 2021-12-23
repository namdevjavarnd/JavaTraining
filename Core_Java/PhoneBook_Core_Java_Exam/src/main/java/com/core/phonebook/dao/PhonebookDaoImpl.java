package com.core.phonebook.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.core.phonebook.db.DataBaseConnection;
import com.core.phonebook.model.Phonebook;

public class PhonebookDaoImpl implements PhonebookDao {
	DataBaseConnection dbcon = new DataBaseConnection();
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public int addContactEntry(Phonebook pb) throws SQLException {
		String query = "insert into Phonebook(name, phone) values(?,?)";
		pst = dbcon.createPst(query);
		pst.setString(1, pb.getName());
		pst.setString(2, pb.getphone());

		dbcon.update(pst);
		return 0;
	}

	@Override
	public Phonebook searchById(int id) throws SQLException {
		String query = "select * from phonebook where id = ?";
		pst = dbcon.createPst(query);
		pst.setInt(1, id);
		rs = dbcon.query(pst);
		if (rs.next()) {
			Phonebook p = new Phonebook();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setphone(rs.getString("phone"));

			return p;
		}
		return null;
	}

	@Override
	public Phonebook searchByPhone(String phone) throws SQLException {
		String query = "select * from phonebook where phone = ?";
		pst = dbcon.createPst(query);
		pst.setString(1, phone);
		rs = dbcon.query(pst);
		if (rs.next()) {
			Phonebook p = new Phonebook();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setphone(rs.getString("phone"));

			return p;

		}
		return null;
	}

	@Override
	public Phonebook searchByName(String name) throws SQLException {

		String query = "select * from phonebook where name = ?";
		pst = dbcon.createPst(query);
		pst.setString(1, name);
		rs = dbcon.query(pst);
		if (rs.next()) {
			Phonebook p = new Phonebook();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setphone(rs.getString("phone"));

			return p;
		}

		return null;
	}

	@Override
	public int updatePhone(String newp, String old) throws SQLException {
		String query = "update phonebook set phone = ? where phone = ?";
		pst = dbcon.createPst(query);
		pst.setString(1, newp);
		pst.setString(2, old);
		return dbcon.update(pst);
	}

	@Override
	public int updateName(Phonebook pb) throws SQLException {
		String query = "update phonebook set name = ? where phone = ?";
		pst = dbcon.createPst(query);
		pst.setString(1, pb.getName());
		pst.setString(2, pb.getphone());

		return dbcon.update(pst);
	}

	@Override
	public int deleteEntry(Phonebook pb) throws SQLException {
		String query = "delete from phonebook where phone = ?";
		pst = dbcon.createPst(query);
		pst.setString(1, pb.getphone());
		return dbcon.update(pst);
	}

	@Override
	public List<Phonebook> listAllEntries() throws SQLException {
		List<Phonebook> list = new ArrayList<>();
		String query = "select * from phonebook";
		pst = dbcon.createPst(query);
		rs = dbcon.query(pst);
		while (rs.next()) {
			Phonebook p = new Phonebook();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setphone(rs.getString("phone"));

			list.add(p);
		}
		return list;
	}

	@Override
	public int quit() throws SQLException {
		dbcon.closeCon();
		return 0;
	}

}
