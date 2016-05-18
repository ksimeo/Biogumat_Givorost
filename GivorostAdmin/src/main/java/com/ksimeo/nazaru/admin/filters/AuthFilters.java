package com.ksimeo.nazaru.admin.filters;

import com.ksimeo.nazaru.core.models.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author  Created by Avega on 02.06.14.
 * @version 1.0
 */
//@WebFilter(urlPatterns = "/*")
public class AuthFilters implements Filter {

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
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("user")) {
                    sessionUserAttr = (User)session.getAttribute("user");
                    if (sessionUserAttr == null) break;
                    isLoggedIn = cookie.getValue().equalsIgnoreCase(sessionUserAttr.getLogin());
                    break;
                }
            }
        }

        filterChain.doFilter(req, resp);

      /*  if (uri.endsWith("index.jsp") ||
                uri.contains("/login") ||
                uri.contains("/script") ||
                uri.endsWith("/content/css/style.css") ||
                uri.endsWith("/givorost.ico") ||
                uri.contains("/img") ||
                uri.contains("/content")) {

            filterChain.doFilter(req, resp);
        }*/











        /*if(!isLoggedIn &&
           !(uri.endsWith("index.jsp") ||
             uri.contains("/login") ||
             uri.contains("/script") ||
             uri.endsWith("/content/css/style.css") ||
             uri.endsWith("/givorost.ico") ||
             uri.contains("/img") ||
             uri.contains("/content"))) {

            resp.sendRedirect("/index.jsp");
        } else {
            if (uri.endsWith("/index.jsp") ||
                uri.contains("/login") ||
                uri.contains("/script") ||
                uri.endsWith("/content/css/style.css") ||
                uri.endsWith("/givorost.ico") ||
                uri.contains("/img") ||
                uri.contains("/content")) {

                filterChain.doFilter(req, resp);
            } else if(sessionUserAttr != null) {

                filterChain.doFilter(req, resp);*/
//                if (!sessionUserAttr.isAdmin()) {
//
//
//                    uri.endsWith("")
//                }
            }


//            &&
//                !(uri.contains("/script") ||
//                  uri.contains("/img") ||
//                  uri.endsWith("/main.do") ||
//                  uri.endsWith("/main.jsp") ||
//                  uri.contains("/content") ||
//                uri.contains("/WEB-INF")
//                ))
//                  uri.contains("*.do") ||
//                  uri.contains("*.ado")))
       /*     {


//                )) {

                if (uri.endsWith("/logout.do")) {

                    filterChain.doFilter(servletRequest, servletResponse);
                } else
                if(!(sessionUserAttr.isAdmin()) && uri.contains(".ado")) {

                    resp.sendRedirect("/404.htm");
                } else if (sessionUserAttr.isAdmin())

                    filterChain.doFilter(servletRequest, servletResponse);
            } else {

                filterChain.doFilter(servletRequest, servletResponse);
            }*/
//        }
//    }

    @Override
    public void destroy() { }
}