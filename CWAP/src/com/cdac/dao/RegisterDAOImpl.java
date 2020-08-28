package com.cdac.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.User;

@SuppressWarnings("unused")
@Repository
public class RegisterDAOImpl implements RegisterDAO {

	private static final Logger logger = LoggerFactory.getLogger(RegisterDAOImpl.class);

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub

		try {
			String query = "INSERT INTO users (email_id, name, password, type_of_user, mobile_no,isvalid)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			jdbctemplate.update(query,
					new Object[] { user.getEmail_id(), user.getName(), user.getPassword(), user.getType_of_user(),
							user.getMobile_no(), user.getType_of_user().equalsIgnoreCase("attendee") ? true : false });
			return true;

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean userExist(User user) {
		// TODO Auto-generated method stub
		User dbUser = null;

		try {
			String query = "select * from users where email_id = ?";
			dbUser = jdbctemplate.queryForObject(query, new Object[] { user.getEmail_id() }, new RowMapper<User>() {
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User dbUser = new User();
					user.setName(rs.getString("name"));
					user.setEmail_id(rs.getString("email_id"));
					user.setPassword(rs.getString("password"));
					user.setType_of_user(rs.getString("type_of_user"));
					user.setIsvalid(rs.getBoolean("isvalid"));
					return dbUser;
				}
			});

			if (dbUser != null) {
				System.out.println("dbuser not null");

				return true;

			}
		} catch (EmptyResultDataAccessException ex) {
			logger.info("EmptyResultDataAccessException while retrieving record :: No record found in DB");
			ex.printStackTrace();
		} catch (Exception ex) {
			logger.info("Exception occured while retrieving record from DB");
			ex.printStackTrace();
		}
		return false;
	}

	// Method to find if the mobile number already exists in the database
	@Override
	public boolean mobileNumberExists(User user) {
		User dbUser = null;
		try {
			String query = "Select * from users where mobile_no = ?";

			dbUser = jdbctemplate.queryForObject(query, new Object[] { user.getMobile_no() }, new RowMapper<User>() {
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User dbUser = new User();
					user.setName(rs.getString("name"));
					user.setEmail_id(rs.getString("email_id"));
					user.setPassword(rs.getString("password"));
					user.setType_of_user(rs.getString("type_of_user"));
					user.setMobile_no(Long.parseLong(rs.getString("mobile_no")));
					user.setIsvalid(rs.getBoolean("isvalid"));
					return dbUser;
				}
			});

			if (dbUser != null) {
				System.out.println("dbuser not null");

				return true;

			}
		} catch (EmptyResultDataAccessException e) {
			logger.info("EmptyResultDataAccessException while retrieving record :: No record found in DB");
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Exception occured while retrieving data from DataBase");
			e.printStackTrace();
		}
		return false;
	}
}
