package kh.com.a.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kh.com.a.model.MemberDto;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = false;
		String webRoot = request.getContextPath();

		try {
			MemberDto current_user = (MemberDto) request.getSession().getAttribute("login");
			if (current_user == null || current_user.getEmail().equals("")) {
				if (isAjaxRequest(request)) {
					response.sendError(400);
					return false;
				} else {
					response.sendRedirect(webRoot + "/login.do");
					result = false;
				}
			} else {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		return result;
	}

	private boolean isAjaxRequest(HttpServletRequest req) {
        String header = req.getHeader("AJAX");
        if ("true".equals(header)){
         return true;
        }else{
         return false;
        }
    }
}
