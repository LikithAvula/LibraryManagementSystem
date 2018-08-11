package com.lms.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.LmsRepository;
import com.lms.models.Book;

@Service
public class LmsService {
	
	@Autowired
	private LmsRepository lmsrepositoy; 
	
	public Collection<Book> findAllBooks(){		
		List<Book> books = new ArrayList<Book>();
		for( Book book : lmsrepositoy.findAll()) {
			books.add(book);
		}		
		return books;			
	}	
	
	public void delete(long id) {
		lmsrepositoy.deleteById(id);
	}
	
	public Book findOne(long id) {
		return lmsrepositoy.findById(id).orElse(null);	
		
	}
	
	public void save(Book book) {
		lmsrepositoy.save(book);
	}
}
