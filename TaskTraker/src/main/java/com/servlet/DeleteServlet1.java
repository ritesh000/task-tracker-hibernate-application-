package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.tasktraker.Note;
import com.helper.FactoryProvider;

public class DeleteServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet1() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			int noteId =Integer.parseInt(request.getParameter("note_id").trim());
			Session s=FactoryProvider.getFactory().openSession();
			
			Transaction tx=s.beginTransaction();
			Note note=s.get(Note.class,noteId);
			s.delete(note);			
			tx.commit();
			s.close();
			response.sendRedirect("All_notes.jsp");
			
		} catch (Exception e) {
			
		}
		
		
		
		
	}

}
