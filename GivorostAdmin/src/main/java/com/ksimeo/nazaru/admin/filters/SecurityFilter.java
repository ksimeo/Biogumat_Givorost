package com.ksimeo.nazaru.admin.filters;

import com.ksimeo.nazaru.core.models.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Ksimeo on 02.06.14
 * @version 2.6
 * @since 1.0
 */
//@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        Cookie[] cookies = req.getCookies();
        boolean isLoggedIn = false;
        User sessionUserAttr = null;

        if (session != null && cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    sessionUserAttr = (User) session.getAttribute("user");
                    if (null == sessionUserAttr)
                        break;
                    isLoggedIn = cookie.getValue().equalsIgnoreCase(sessionUserAttr.getLogin());
                    break;
                }
            }
        }

        if (sessionUserAttr == null && (
                uri.endsWith("/main.do") ||
                        uri.endsWith("/users.ado") ||
                        uri.endsWith("/consider.do") ||
                        uri.endsWith("/deluser.ado") ||
                        uri.endsWith("/products.ado") ||
                        uri.endsWith("/corrprod.ado") ||
                        uri.endsWith("/delprod.ado") ||
                        uri.endsWith("/changepassw.do") ||
                        uri.endsWith("/logout.do"))) {

            resp.sendRedirect("/index.jsp");
        } else if (sessionUserAttr != null) {
            if (!sessionUserAttr.isAdmin() &&
                    uri.endsWith("/users.ado") ||
                    uri.endsWith("/deluser.ado") ||
                    uri.endsWith("/products.ado") ||
                    uri.endsWith("/corrprod.ado") ||
                    uri.endsWith("/delprod.ado")) {

                resp.sendRedirect("/404.htm");
            } else {

                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() { }
}