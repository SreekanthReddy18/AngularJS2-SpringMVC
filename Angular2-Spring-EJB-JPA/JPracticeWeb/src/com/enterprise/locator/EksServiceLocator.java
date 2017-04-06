package com.enterprise.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EksServiceLocator<E> {

	private static Map<String, Object> localsMap = null;
	private static Context ctx = null;
	private String tmpJNDIName;
	private final String GLOBAL = "java:global";
	private final String EAR_NAME="JPracticeEAR";
	private final String EJB ="JPracticeEJB";
	public static final String FILE_SEPARATOR="/";
	static {
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		localsMap = new HashMap<String, Object>();
	}

	@SuppressWarnings("unchecked")
	public E getEksService(String jndiName) throws NamingException {
		tmpJNDIName = GLOBAL +FILE_SEPARATOR  +EAR_NAME + FILE_SEPARATOR + EJB +FILE_SEPARATOR+jndiName;
		System.out.println("----------------------------------");
		System.out.println(tmpJNDIName);
		System.out.println("----------------------------------");
		Object obj = localsMap.get(tmpJNDIName);
		if (obj == null) {
			obj = ctx.lookup(tmpJNDIName);
			localsMap.put(tmpJNDIName, obj);
		}
		return (E) obj;
	}

}
