package com.cdac.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	/*
	 * public boolean preHandle(HttpServletRequest request, HttpServletResponse
	 * response, Object handler) throws Exception {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * if (session != null) { if (session.getAttribute("username") != null &&
	 * session.getAttribute("isLoggedIn") != null) { if
	 * (request.getRequestURI().endsWith("/login") ||
	 * request.getRequestURI().endsWith("/register") ||
	 * request.getRequestURI().endsWith("/doregister")) {
	 * response.sendRedirect(request.getContextPath() + "/profile"); return
	 * false; } else return true; } } return true;
	 * 
	 * 
	 * if(session.getAttribute("username")!=null &&
	 * session.getAttribute("isLoggedIn")!=null ){ //user has already logged in
	 * . so therefore can access
	 * 
	 * any resource //System.out.println("Logged In"); if
	 * (request.getRequestURI().endsWith("/login")){
	 * response.sendRedirect(request.getContextPath()+"/profile"); return false;
	 * } if (request.getRequestURI().endsWith("/register")){
	 * response.sendRedirect(request.getContextPath()+"/profile"); return false;
	 * } return true; }
	 * 
	 * // if code reaches here means that user is not logged in if
	 * (request.getRequestURI().endsWith("/"))
	 * 
	 * {
	 * 
	 * return true; }if(request.getRequestURI().endsWith("/home")) {
	 * 
	 * return true; }if(request.getRequestURI().endsWith("/courses")) {
	 * 
	 * return true; }if(request.getRequestURI().endsWith("/course")) {
	 * 
	 * return true; }if(request.getRequestURI().contains("/resources")) {
	 * 
	 * return true; }
	 * 
	 * // allow login http request. if
	 * (request.getRequestURI().endsWith("/login")) { //user is not logged in
	 * but is trying to login. so allow only login requests return true;
	 * }if(request.getRequestURI().endsWith("/dologin")) {
	 * 
	 * return true; }if(request.getRequestURI().endsWith("/register")) {
	 * 
	 * return true; }if(request.getRequestURI().endsWith("/doregister")) {
	 * 
	 * return true; }else { //user is not logged in and is trying to access a
	 * resource. so redirect him to login page
	 * response.sendRedirect(request.getContextPath()+"/login");
	 * //System.out.println("Not logged in"); return false; }
	 * 
	 * }
	 */

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

	}
}
