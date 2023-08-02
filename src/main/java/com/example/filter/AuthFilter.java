package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/user/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}