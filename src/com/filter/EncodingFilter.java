package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
    public EncodingFilter() {
        System.out.println("Filter built!");
    }
    public void init(FilterConfig arg) throws ServletException {
        System.out.println("Filter init!");
    }
    public void destroy() {
        System.out.println("Filter destroied!");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
