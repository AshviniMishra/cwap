package com.cdac.controller;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.Course;
import com.cdac.service.AttendeeService;
import com.cdac.service.CourseService;
import com.cdac.service.OrganizerService;

@Controller
public class CourseController {

	private static final String UPLOAD_LOCATION = "/home/ashvini/eclipse-workspace/workshop/WebContent/resources/images";

	@Autowired
	@Qualifier("cs")
	CourseService cs;

	@Autowired
	@Qualifier("os")
	OrganizerService os;

	@Autowired
	@Qualifier("as")
	AttendeeService as;

	@Autowired
	JdbcTemplate jdbctemplate;

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String courses(HttpServletRequest req, HttpServletResponse res) {
		as.getCourses(req, res);
		HttpSession session = req.getSession();
		session.setAttribute("display_archived", false);
		return "courses";
	}

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ModelAndView course(@RequestParam("selectedCourse") Integer selectedCourse, HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession();
		if( as == null )
			System.out.println("AS is null");
		else if( selectedCourse == null )
			System.out.println("SelectedCourse is null");
		String description[] = as.splitDescription(selectedCourse, req, res);
		ModelAndView mv = new ModelAndView();

		mv.addObject("description", description);

		session.setAttribute("alreadyEnrolled", as.isAlreadyEnrolled(req, res, selectedCourse));

		as.getCourses(req, res);

		mv.setViewName("course");

		return mv;
	}

	// Method to get the details of the clicked course
	/*
	 * @RequestMapping(value = "/getCourseDetails", method = RequestMethod.GET)
	 * public ModelAndView getCourseDetails( HttpServletRequest req,
	 * HttpServletResponse res int courseId) { ModelAndView mv = new
	 * ModelAndView(); String selectQuery =
	 * "SELECT * FROM course where course_id = '" + courseId + "'"; try {
	 * List<Course> courseDetails = this.jdbctemplate.query(selectQuery, new
	 * RowMapper<Course>() { public Course mapRow(ResultSet rs, int rowNum)
	 * throws SQLException { Course courses = new Course();
	 * courses.setCourse_id(rs.getInt("course_id"));
	 * courses.setCourse_name(rs.getString("course_name"));
	 * courses.setSubjectId(rs.getInt("subject"));
	 * courses.setTagline(rs.getString("tagline"));
	 * courses.setDescription(rs.getString("description"));
	 * courses.setStart_date(rs.getString("start_date"));
	 * courses.setEnd_date(rs.getString("end_date"));
	 * courses.setReg_start_date(rs.getString("reg_start_date"));
	 * courses.setReg_end_date(rs.getString("reg_end_date"));
	 * courses.setBanner_path(rs.getString("banner_path"));
	 * System.out.println("Sys path" + rs.getString("banner_path"));
	 * courses.setCreator(rs.getString("creator")); return courses; } });
	 * mv.addObject("courseDetails", courseDetails);
	 * mv.setViewName("courseDetails"); } catch (Exception e) {
	 * e.printStackTrace();
	 * 
	 * } return mv; }
	 */

	@RequestMapping(value = "/myCourses", method = RequestMethod.GET)
	public ModelAndView getMyCourses(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		List<Course> myCourses = cs.getMyCourses(req, res);

		HttpSession session = req.getSession();
		session.setAttribute("myCourses", myCourses);
		mv.setViewName("myCourses");

		return mv;
	}

	// Method for creating course by admin
	@RequestMapping(value = "/createCourse", method = RequestMethod.GET)
	public String createCourse(HttpServletRequest req, HttpServletResponse res, Model model) {
		os.getSubjects(req, res);
		os.getCategories(req, res);
		model.addAttribute("course", new Course());
		return "createCourse";
	}

	// Method saves the course details
	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute("course") Course course, BindingResult result,
			@RequestParam("image") MultipartFile file, HttpSession session,
			@RequestParam Map<String, String> categoryFees, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_LOCATION + "/" + file.getOriginalFilename()));
		course.setBanner_path(file.getOriginalFilename());
		System.out.println("path==>>" + UPLOAD_LOCATION + "/" + file.getOriginalFilename());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createCourse");

		if (os.saveCourse(course, categoryFees, req, res)) {
			mv.addObject("successMsg", "Course is successfully created.");
		} else {
			mv.addObject("errorMsg", "Course could not be created");
		}

		return mv;
	}

	// Method for rendering Update Course page
	@RequestMapping(value = "/updateCourse", method = RequestMethod.GET)
	public String updateCourse(HttpServletRequest req, HttpServletResponse res) {
		as.getCourses(req, res);
		os.getSubjects(req, res);
		os.getCategories(req, res);
		return "updateCourse";
	}

	@RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
	public ModelAndView updateCoursePost(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		mv.addObject("errorMsg", "Course could not be updated");
		return mv;
	}

	// Method for archiving a course
	@RequestMapping(value = "/archive", method = RequestMethod.GET)
	public ModelAndView archiveCourse(@RequestParam("courseId") int courseId, HttpServletRequest req,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		cs.archiveCourse(courseId);
		mv.setViewName("courses");
		mv.addObject("successMsg", "Course Archived");
		return mv;
	}

	// Method to get archived course
	@RequestMapping(value = "/archivedCourse", method = RequestMethod.GET)
	public ModelAndView getArchivedCourses(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		as.getCourses(req, res);
		HttpSession session = req.getSession();
		session.setAttribute("display_archived", true);
		mv.setViewName("courses");
		return mv;
	}

}
