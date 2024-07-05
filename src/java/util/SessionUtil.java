/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Nguyen Quang Hau
 */
public class SessionUtil {
	private static SessionUtil sessionUtil;
        
        // init session
	public static SessionUtil getInstance() {
		if (sessionUtil == null)
			sessionUtil = new SessionUtil();
		return sessionUtil;
	}
	
        //set value
	public void putValue(HttpServletRequest request, String name, Object value) {
		request.getSession().setAttribute(name, value);
	}
	
        //get value
	public Object getValue(HttpServletRequest request, String name) {
		return request.getSession().getAttribute(name);
	}
	
        // remove Session
	public void removeValue(HttpServletRequest request, String name) {
		request.getSession().removeAttribute(name);
	}
}
