package com.core.phonebook.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.core.phonebook.exception.DuplicateNameException;
import com.core.phonebook.exception.DuplicateNumberException;
import com.core.phonebook.model.Phonebook;
import com.core.phonebook.service.PhonebookService;
import com.core.phonebook.service.PhonebookServiceImpl;

public class PhonebookMgmt {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		PhonebookService ps = new PhonebookServiceImpl();

		boolean st = true;
		while (st) {
			
			System.out.println("===== PhoneBookMgmt =====\n");
			
			System.out.println("Enter 1 for Adding New Contact");
			System.out.println("Enter 2 for Searching by Id");
			System.out.println("Enter 3 for Searching by Phone Number");
			System.out.println("Enter 4 for Searching by Name");
			System.out.println("Enter 5 for Update Phone Number");
			System.out.println("Enter 6 for Update Name");
			System.out.println("Enter 7 for Deleting Contact");
			System.out.println("Enter 8 for Showing all Contacts");
			System.out.println("Enter 9 for Closing Application\n");
			System.out.println("===== Enter Your Choice =====\n");
			
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				Phonebook pb = new Phonebook();

				try {
					System.out.println("Enter Name\n");
					String nm = sc.next();
					if (ps.searchByName(nm) != null) {

						throw new DuplicateNameException(nm);
					}
					System.out.println("Enter Phone Number\n");
					String sp = sc.next();
					if (ps.searchByPhone(sp) != null) {

						throw new DuplicateNumberException(sp);
					}
					pb.setName(nm);
					pb.setphone(sp);
					ps.addContactEntry(pb);
					if (pb != null)
						System.out.println(pb.getName() + " \n added to your Phonebook....\n");
					else
						System.out.println("\n contact not inserted in Phonebook...\n");

				} catch (DuplicateNumberException | DuplicateNameException e) {
					System.out.println(e);
				}
				break;

			case 2:
				System.out.println("Enter Id to Search Contact:\n");
				int id = sc.nextInt();
				Phonebook pb1 = ps.searchById(id);
				if (pb1 != null)
					System.out.println("\n Record Found:\n" + pb1);
				else
					System.out.println("\n Record Not Found....");
				break;

			case 3:
				System.out.println("Enter Phone Number to Search Contact:\n");
				String p = sc.next();
				Phonebook pb2 = ps.searchByPhone(p);
				if (pb2 != null)
					System.out.println("\n Record Found:" + pb2);
				else
					System.out.println("\n Record Not Found....");
				break;

			case 4:
				System.out.println("Enter Name to Search Contact:\n");
				String n = sc.next();
				Phonebook pb3 = ps.searchByName(n);
				if (pb3 != null)
					System.out.println("\n Record Found:\n" + pb3);
				else
					System.out.println("\n Record Not Found....");
				break;
			case 5:
				System.out.println("Enter Old Phone Number:\n");
				String old = sc.next();
				System.out.println("Enter new Phone number:\n");
				String newp = sc.next();
				if (ps.updatePhone(newp, old)  != 0) {
					System.out.println("\n Phone Number Updated....\n");
				} else
					System.out.println("\n Not Updated....");

				break;
			case 6:
				System.out.println("Enter Phone Number you want to Update the Name:\n");
				String ph = sc.next();
				System.out.println("Enter Name:\n");
				String name = sc.next();
				Phonebook pb4 = new Phonebook();
				pb4.setName(name);
				pb4.setphone(ph);
				if (ps.updateName(pb4) != 0) {
					System.out.println("\n Name Updated....\n");
				} else
					System.out.println("\n Not Updated....");

				break;
			case 7:
				Phonebook pb5 = new Phonebook();
				System.out.println("Enter Phone Number you want to Delete:\n");
				pb5.setphone(sc.next());
				if (ps.deleteEntry(pb5) != 0) {
					System.out.println("\n Record Deleted....\n");
				} else
					System.out.println("\n Not deleted....");
				break;
			case 8:
				System.out.println("\n Your Phonebook contact list...\n");
				List<Phonebook> list = ps.listAllEntries();

				for (Phonebook p9 : list) {
					System.out.println(p9);
				}
				break;
			case 9:
				System.out.println("\n Application Terminated");
				ps.quit();
				st = false;
				System.exit(0);
				break;
			default:
				System.out.println("\n wrong choice  Try Again!!");
			}

		}
	}

}
