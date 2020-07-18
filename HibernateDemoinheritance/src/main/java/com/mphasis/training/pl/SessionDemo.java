package com.mphasis.training.pl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.entities1.Account;
import com.mphasis.training.util.HibernateUtil;

public class SessionDemo {

	public static void main(String[] args) {
		SessionFactory sf= HibernateUtil.getSessionFactory();
		
		Session session= sf.openSession();
		
		Account a1= (Account) session.get(Account.class, 1);
		
		//Account a2=(Account) session.get(Account.class, 1);
       session.close();
       
       Session sn=sf.openSession();
       
       Account a11=(Account) sn.get(Account.class, 1);
       sn.close();
	}

}
