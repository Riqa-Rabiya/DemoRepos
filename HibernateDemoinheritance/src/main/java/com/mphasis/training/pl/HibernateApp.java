package com.mphasis.training.pl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.mphasis.training.entities1.Account;
import com.mphasis.training.entities1.CurrentAcc;
import com.mphasis.training.entities1.SavingsAcc;
import com.mphasis.training.util.HibernateUtil;

public class HibernateApp {

	public static void main(String[] args) {
//		Configuration con=new Configuration().configure().addAnnotatedClass(Account.class).
//				addAnnotatedClass(SavingsAcc.class).addAnnotatedClass(CurrentAcc.class);
//		StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder()
//				.applySettings(con.getProperties());
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		
		//retrieval using createcriteria
		Session sn=sessionfactory.openSession();
		List<Account> acc= sn.createCriteria(Account.class).list();
		for(Account a:acc) {
			System.out.println(a.getAccholdername()+" "+a.getAccno()+" "+a.getBalance());
		}
		sn.close();
		
		//retrieval using hql
		Session sn1=sessionfactory.openSession();
		Query query=sn1.createQuery("FROM Account");
		query.list().forEach(System.out::println);
		
		//retrieving particular row using hql
		Query qd=sn1.createQuery("SELECT a.accno from Account a");
		qd.list().forEach(System.out::println);
		
		//deleting using hql
		Query query1=sn1.createQuery("DELETE FROM Account where accnum= :acc");
		query1.setParameter("acc", 1);
		query1.executeUpdate();
		sn1.getTransaction().commit();
		System.out.println("deleted");
		
		sn1.close();
		
		//retrieval using sql
		Session sn2= sessionfactory.openSession();
		SQLQuery sqlquery= sn2.createSQLQuery("select accholdername accno from Account");
		List<Object[]> objects =sqlquery.list();
		for(Object[] row:objects) {
			Account a=new Account();
			a.setAccholdername(row[0].toString());
			a.setAccno(Integer.parseInt(row[1].toString()));
			System.out.println(a.getAccholdername()+ " "+a.getAccno());
		}
		sn2.close();
		
//		Account a= new Account();
//		a.setAccno(121);
//		a.setAccholdername("swa");
//		a.setBalance(234500);
//		
//		SavingsAcc sa=new SavingsAcc();
//		sa.setAccno(122);
//		sa.setAccholdername("soum");
//		sa.setBalance(12340);
//		sa.setAdharnum(3456);
//		
//		CurrentAcc ca=new CurrentAcc();
//		ca.setAccno(123);
//		ca.setAccholdername("supr");
//		ca.setBalance(55678);
//		ca.setGstin("35636");
		
//		Student st=new Student();
//		st.setName("riqa");
//		st.getEmail().add("riqa@gmail.com");
//		st.getEmail().add("riqa@mph.com");
//		st.getLp().setLpcode("LP123");
//		st.getLp().setBrand("hp");
//		st.getLp().setHddsize(1);
//		st.getLp().setRamsize(20);
//		st.getLp().setProcessor("Mediateck");
//		
		
		//to add data into table
//		Session sn=sessionfactory.openSession();
//		sn.beginTransaction();
//		sn.save(a);
//		sn.save(sa);
//		sn.save(ca);
//		sn.getTransaction().commit();
//		sn.close();
//		System.out.println("done");

	}

}
