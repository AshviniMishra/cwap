package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.model.Course;
import com.cdac.model.GeneralObject;

@Repository
public class OrganizerDAOImpl implements OrganizerDAO {
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public boolean saveSubject(GeneralObject subject) {

		try {
			String query;
			int rowCount;
			do {
				subject.setId(subject.randomNumber(1000, 9999));
				rowCount = jdbctemplate.queryForObject("select count(*) from subject where id= ?",
						new Object[] { subject.getId() }, Integer.class);
			} while (rowCount != 0);

			query = "INSERT INTO subject VALUES (?, ?, ?)";
			jdbctemplate.update(query, new Object[] { subject.getId(), subject.getName(), subject.getDescription() });
			return true;

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveQualification(GeneralObject qualification) {
		try {
			String query;
			int rowCount;
			do {
				qualification.setId(qualification.randomNumber(1000, 9999));
				rowCount = jdbctemplate.queryForObject("select count(*) from qualification where id= ?",
						new Object[] { qualification.getId() }, Integer.class);
			} while (rowCount != 0);

			query = "INSERT INTO qualification VALUES (?, ?, ?)";
			jdbctemplate.update(query,
					new Object[] { qualification.getId(), qualification.getName(), qualification.getDescription() });
			return true;

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveCategory(GeneralObject category) {
		try {
			String query;
			int rowCount;
			do {
				category.setId(category.randomNumber(1000, 9999));
				rowCount = jdbctemplate.queryForObject("select count(*) from enrollment_category where category_id= ?",
						new Object[] { category.getId() }, Integer.class);
			} while (rowCount != 0);

			query = "INSERT INTO enrollment_category VALUES (?, ?, ?)";
			jdbctemplate.update(query,
					new Object[] { category.getId(), category.getName(), category.getDescription() });
			return true;

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void getSubjects(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			List<GeneralObject> subjects = this.jdbctemplate.query("select * from subject",
					new RowMapper<GeneralObject>() {
						public GeneralObject mapRow(ResultSet rs, int rowNum) throws SQLException {
							GeneralObject subjects = new GeneralObject();
							subjects.setId(rs.getInt("id"));
							subjects.setName(rs.getString("name"));
							subjects.setDescription("description");
							return subjects;
						}
					});
			HttpSession session = req.getSession();
			session.setAttribute("subjects", subjects);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public boolean saveCourse(Course course, Map<String, String> categoryFees, HttpServletRequest req,
			HttpServletResponse res) {
		try {
			String query;
			int rowCount;
			GeneralObject rn = new GeneralObject();
			do {
				course.setCourse_id(rn.randomNumber(1000, 9999));
				rowCount = jdbctemplate.queryForObject("select count(*) from course where course_id= ?",
						new Object[] { course.getCourse_id() }, Integer.class);
			} while (rowCount != 0);

			HttpSession session = req.getSession();
			course.setCreator(session.getAttribute("username").toString());
			query = "INSERT INTO course VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			jdbctemplate.update(query,
					new Object[] { course.getCourse_id(), course.getCourse_name(), course.getSubjectId(),
							course.getTagline(), course.getDescription(), course.getStart_date(), course.getEnd_date(),
							course.getReg_start_date(), course.getReg_end_date(), course.getBanner_path(),
							course.getCreator() });

			query = "INSERT INTO course_category_fees VALUES (?,?,?)";
			for (int i = 1; i <= Integer.parseInt(categoryFees.get("CategoryNumber")); i++) {
				jdbctemplate.update(query, new Object[] { Integer.parseInt(categoryFees.get("category_" + i)),
						course.getCourse_id(), Integer.parseInt(categoryFees.get("fees_" + i).trim()) });
			}
			return true;

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void getCategories(HttpServletRequest req, HttpServletResponse res) {
		try {
			List<GeneralObject> categories = this.jdbctemplate.query("select * from enrollment_category",
					new RowMapper<GeneralObject>() {
						public GeneralObject mapRow(ResultSet rs, int rowNum) throws SQLException {
							GeneralObject categories = new GeneralObject();
							categories.setId(rs.getInt("category_id"));
							categories.setName(rs.getString("category_name"));
							categories.setDescription("category_description");
							return categories;
						}
					});

			HttpSession session = req.getSession();
			session.setAttribute("categories", categories);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
