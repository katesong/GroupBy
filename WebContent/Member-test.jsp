<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<sql:query var="rs" dataSource="jdbc/TestDB">
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.DataSource"%>
	<%@ page import="javax.naming.*"%>
	<%@ page import="GroupBy.GroupBy.bean.Member"%>
	<%@ page import="GroupBy.GroupBy.dao.MemberJNDIDao"%>
	<%@ page import="GroupBy.GroupBy.controller.*"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.*"%>
	<%@ page import="java.text.SimpleDateFormat"%>
	<%@ page import="java.sql.Date"%>
	<%
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/GroupBy");
		Connection conn = ds.getConnection();
		MemberJNDIDao test = new MemberJNDIDao();
		Member bean = new Member();		
		List <Member>members = new ArrayList<Member>();
		java.sql.Date d2 = java.sql.Date.valueOf("2012-05-01");

		bean.setFirstName("test");
		bean.setLastName("ttes");
		bean.setBirthDate(d2);
		bean.setSex("male");
		bean.setPhone(4566);
		bean.setEmail("4545@hh.com");
		bean.setUserName("4545");
		bean.setPassword("455");
		bean.setId(1L);
		System.out.println(bean);
		members = test.findAll();
		System.out.println(members);
		int rs = test.delete(3L);

	
		conn.close();
	%>
	<form action="" method="post">
		<input type="text" name="name">
	</form>
	<%
		
	%>
</body>
</html>