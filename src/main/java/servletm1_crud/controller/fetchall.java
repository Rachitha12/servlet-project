package servletm1_crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletm1_crud.dao.StudentDao;
import servletm1_crud.dto.StudentDto;


@WebServlet("/fetchall")
public class fetchall extends HttpServlet
{ @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	
   StudentDao dao=new StudentDao();
//   dao.fetchall();
//   System.out.println(dao.fetchall());
   List<StudentDto> list =dao.fetchall();
   resp.getWriter().print(list);
}
}