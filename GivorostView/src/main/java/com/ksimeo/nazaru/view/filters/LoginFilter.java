package com.ksimeo.nazaru.view.filters;

import com.ksimeo.nazaru.core.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by @Ksimeo on 02.06.14
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

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
        if (!isLoggedIn && (uri.contains("/secure/"))) {

            resp.sendRedirect("/login.jsp");

        } else {

            if (sessionUserAttr != null) {

                if (uri.endsWith("/logout")) {

                    filterChain.doFilter(servletRequest, servletResponse);

                } else if (sessionUserAttr.isAdmin() &&
                        !(uri.contains("/adminspage") ||
                                uri.contains("/adminspage.jsp") ||
                                uri.contains("delorder") ||
                                uri.endsWith("/changepassword") ||
                                uri.endsWith("/changepassw.jsp") ||
                                uri.endsWith("/savepassw") ||
                                uri.endsWith("/userslist") ||
                                uri.endsWith("/userslist.jsp") ||
                                uri.endsWith("/deluser") ||
                                uri.endsWith("/adduser") ||
                                uri.endsWith("/createnewusr") ||
                                uri.endsWith("/productslist") ||
                                uri.endsWith("/productslist.jsp") ||
                                uri.endsWith("/corrprod.jsp") ||
                                uri.contains("/changeproduct") ||
                                uri.endsWith("/saveproduct") ||
                                uri.endsWith("/addproduct") ||
                                uri.endsWith("/createnewprod.jsp") ||
                                uri.endsWith("/delproduct") ||
                                uri.endsWith("/login") ||
                                uri.endsWith("/logout") ||
                                uri.contains("/script") ||
                                uri.contains("/img") ||
                                uri.contains("/content") ||
                                uri.endsWith("createnewusr.jsp") ||
                                uri.endsWith("/givorost.ico") ||
                                uri.endsWith("/404.htm") ||
                                uri.endsWith("/500.htm")
                        )) {

                    resp.sendRedirect("/404.htm");

                } else if (!sessionUserAttr.isAdmin() &&
                        !(uri.contains("/userspage") ||
                                uri.contains("/userspage.jsp") ||
                                uri.endsWith("/changepassword") ||
                                uri.endsWith("/changepassw.jsp") ||
                                uri.endsWith("/savepassw") ||
                                uri.endsWith("/login") ||
                                uri.endsWith("/logout") ||
                                uri.contains("/script") ||
                                uri.contains("/img") ||
                                uri.contains("/content") ||
                                uri.endsWith("createnewusr.jsp") ||
                                uri.endsWith("/givorost.ico") ||
                                uri.contains("/secure/") ||
                                uri.endsWith("/404.htm") ||
                                uri.endsWith("/500.htm"))) {

                    resp.sendRedirect("/404.htm");

                } else {

                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {

                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}