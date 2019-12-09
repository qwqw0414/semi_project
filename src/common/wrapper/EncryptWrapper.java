package common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import common.util.Utils;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		String value = "";
		
		if("password".equals(key) || "password_new".equals(key)) {
			System.out.println(super.getParameter("password"));
			value = Utils.getSha512(super.getParameter(key));
			System.out.println(value);
		}
		else {
			value = super.getParameter(key);
		}
		
		return value;
	}

}






