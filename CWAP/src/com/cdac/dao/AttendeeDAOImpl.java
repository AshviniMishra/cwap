package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.cdac.model.Course;
import com.cdac.model.GeneralObject;

@Repository
public class AttendeeDAOImpl implements AttendeeDAO {
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public void getCourses(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			List<Course> courses = this.jdbctemplate.query("select * from course", new RowMapper<Course>() {
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
					System.out.println("Sys path" + rs.getString("banner_path"));
					courses.setCreator(rs.getString("creator"));
					/* courses.setIs_archived(rs.getBoolean("is_archived")); */
					return courses;
				}
			});
			HttpSession session = req.getSession();
			session.setAttribute("courses", courses);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public LinkedHashMap<Integer, Integer> getCourseCategories(HttpServletRequest req, HttpServletResponse res) {

		HttpSession session = req.getSession();
		String query = "select * from course_category_fees where course_id = ?";

		Course course = (Course) session.getAttribute("course");

		LinkedHashMap<Integer, Integer> courseCategories = new LinkedHashMap<Integer, Integer>();

		try {
			SqlRowSet rs = jdbctemplate.queryForRowSet(query, new Object[] { course.getCourse_id() });

			while (rs.next()) {
				courseCategories.put(rs.getInt("category_id"), rs.getInt("fees"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return courseCategories;
	}

	@Override
	public boolean getCourseList(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String query = "SELECT course_name FROM course";
		List<String> courseNameList = null;

		try {
			List<Map<String, Object>> courseName = jdbctemplate.queryForList(query);
			courseNameList = new ArrayList<String>();
			for (Map<String, Object> courseNameMap : courseName) {
				courseNameList.add(String.valueOf(courseNameMap.get("course_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		session.setAttribute("courseNameList", courseNameList);
		return true;
	}

	@Override
	public boolean saveEnrollment(int selectedCategory, boolean laptop, HttpServletRequest req,
			HttpServletResponse res) {
		try {
			String query;
			int rowCount, enrollment_id;
			GeneralObject rn = new GeneralObject();
			do {
				enrollment_id = rn.randomNumber(1000, 9999);
				rowCount = jdbctemplate.queryForObject("select count(*) from enrollment where enrollment_id= ?",
						new Object[] { enrollment_id }, Integer.class);
			} while (rowCount != 0);

			HttpSession session = req.getSession();
			Course course = (Course) session.getAttribute("course");
			if (course == null)
				System.out.println("Session course is null");
			query = "INSERT INTO enrollment VALUES (?,?,?,?,?,?)";
			jdbctemplate.update(query, new Object[] { enrollment_id, session.getAttribute("username").toString(),
					course.getCourse_id(), selectedCategory, laptop, "failed" });

			session.setAttribute("alreadyEnrolled", true);
			return true;
		} catch (DataAccessException e) {
			System.out.println("Exception occurred while saving enrollment");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean isAlreadyEnrolled(HttpServletRequest req, HttpServletResponse res, int selectedCourse) {

		HttpSession session = req.getSession();

		String query = "";
		String userName = (String) session.getAttribute("username");
		try {
			query = "SELECT * FROM enrollment WHERE username = '" + userName + "' AND course_id = '" + selectedCourse
					+ "'";
			SqlRowSet rs = jdbctemplate.queryForRowSet(query);
			if (rs.next())
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	// Following method is for getting course_category_fees;
	@Override
	public int getFee(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		Course course = (Course) session.getAttribute("course");
		// System.out.printf("Course id is - %d", course.getCourse_id());
		int fee = 0;
		return fee;
	}
}
