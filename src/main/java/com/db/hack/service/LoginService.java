package com.db.hack.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.hack.beans.Login;
import com.db.hack.databse.DatabaseConnectionFactory;

public class LoginService {

	private DatabaseConnectionFactory dataBaseConnectionFactory;

	public LoginService(DatabaseConnectionFactory daataBaseConnectionFactory) {
		this.dataBaseConnectionFactory = daataBaseConnectionFactory;
	}

	public Boolean authenticate(Login login) {




			try(Connection conn = dataBaseConnectionFactory.getConnection();
				Statement select = conn.createStatement();
				ResultSet result = select.executeQuery("Select count(*) from dbo.users where userid = '"+login.getLoginID()+"' AND passwd='"+login.getPasswd()+"'")){

				return result.next();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
	}

}
