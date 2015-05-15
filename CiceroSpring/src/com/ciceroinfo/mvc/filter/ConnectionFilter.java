package com.ciceroinfo.mvc.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ciceroinfo.db.ConnectionFactory;

public class ConnectionFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		request.setAttribute("connection", connection);
		
		chain.doFilter(request, response);
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
