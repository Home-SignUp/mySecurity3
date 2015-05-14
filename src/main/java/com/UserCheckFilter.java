package com;

/**
 * Created by alexandr on 13.05.15.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class UserCheckFilter
 */
public class UserCheckFilter implements Filter {
    private String LOGIN_ACTION_URI;

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        LOGIN_ACTION_URI = fConfig.getInitParameter("loginActionURI");
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)response;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession    session = req.getSession();
        User              user = (User) session.getAttribute("user");

        if (user == null && !LOGIN_ACTION_URI.equals(req.getRequestURI())){
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(request, res); //rd.forward(request, response);
            return;
        }

        chain.doFilter(request, res); //chain.doFilter(request, response);
    }
}