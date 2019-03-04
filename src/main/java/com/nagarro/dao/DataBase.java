package com.nagarro.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DataBase {
	
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		try {
			if(sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metaDataSources = new MetadataSources(standardServiceRegistry);
				Metadata metadata = metaDataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		} catch(Exception exception) {
			exception.printStackTrace();
			if(standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
