package calistir;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import bean.TestEJBRemote;

public class Calistir {
	public static void main(String[] args) throws NamingException {
		String host = "localhost";// if you run your client and server sample on same machine
		String port = "3700";// default

		Properties prop = new Properties();
		prop.put("org.omg.CORBA.ORBInitialHost", host);
		prop.put("org.omg.CORBA.ORBInitialPort", port);
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");

		InitialContext context = new InitialContext(prop);
		TestEJBRemote o = (TestEJBRemote) context.lookup("bean.TestEJBRemote");
		context.close();
		int sonuc = o.topla(2, 3);
		System.out.println(sonuc);
	}
}
