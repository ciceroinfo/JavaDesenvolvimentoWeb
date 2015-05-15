package com.ciceroinfo.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	public abstract void executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
