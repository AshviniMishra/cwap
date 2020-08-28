package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.cdac.model.Course;
import com.cdac.model.Profile;

@Repository
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	JdbcTemplate jdbctemplate;

	// Method to get details of the enrolled course
	@Override
	public List<Course> getMyCourses(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		Profile profile = (Profile) session.getAttribute("profile");
		String query = "SELECT * FROM course WHERE course_id IN ( (SELECT course_id FROM enrollment WHERE username = '"
				+ profile.getUsername() + "'))";
		List<Course> myCourses = new LinkedList<Course>();
		try {
			myCourses = this.jdbctemplate.query(query, new RowMapper<Course>() {
				public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
					Course courses = new Course();
					courses.setCourse_id(rs.getInt("course_id"));
					courses.setCourse_name(rs.getString("course_name"));
					courses.setSubjectId(rs.getInt("subject"));
					courses.setTagline(rs.getString("tagline"));
					courses.setDescription(rs.getString("description"));
					courses.setStart_date(LocalDate.parse(rs.getString("start_date")));
					courses.setEnd_date(LocalDate.parse(rs.getString("end_date")));
					courses.setReg_start_date(LocalDate.parse(rs.getString("reg_start_date")));
					courses.setReg_end_date(LocalDate.parse(rs.getString("reg_end_date")));
					courses.setBanner_path(rs.getString("banner_path"));
					courses.setCreator(rs.getString("creator"));
					return courses;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();

		}

		return myCourses;
	}

	// Method to archive selected course
	@Override
	public boolean archiveCourse(int courseId) {

		/*
		 * try { jdbctemplate.
		 * update("UPDATE course SET is_archived = 'true' WHERE course_id = ?",
		 * courseId); } catch (Exception e) { System.out.println(e +
		 * "Execption occured while archiving course"); e.printStackTrace(); }
		 */
		return false;
	}
}
