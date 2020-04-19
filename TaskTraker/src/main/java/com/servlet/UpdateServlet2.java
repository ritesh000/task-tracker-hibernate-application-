package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.tasktraker.*;
import com.helper.FactoryProvider;


public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			

			String title=request.getParameter("title");
			String Content=request.getParameter("content");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			
			
			Note note=s.get(Note.class, noteId);
			note.setTitle(title);
			note.setContent(Content);
			note.setAddedDtae(new Date());
			tx.commit();
			s.close();
			
			
       	response.sendRedirect("All_notes.jsp");
 			
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
		
	}

}
