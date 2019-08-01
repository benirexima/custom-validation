package com.book.dao;



import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


import com.book.model.BookEntity;
import com.book.repository.BookRepository;



@Component
public class BookDao {
	
	@Autowired
	BookRepository repository;
	
	public static void validPrice(double price) throws Exception {

		if (price >= 150 && price<= 500)
			
			System.out.println("book is added");
		
		else
			throw new Exception("price is not between 150 and 500");
					
	}
	public static void findAuthorName (String authorName) throws NameNotFoundException{ 
		
		
		if ("aravinth".equals(authorName)) 
			
			System.out.println("author name is correct");
		
		else
			
            throw new NameNotFoundException("Name is not match!");
        
	}
	
	public BookEntity create(BookEntity book) throws Exception {
		 BookEntity value=null;
		try 
		{
		validPrice(book.getPrice());
		findAuthorName(book.getAuthorname());
		value=repository.save(book); 
		}
		catch(Exception e)
		{
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());	
			
			throw e;
			
		}
	return value;	
		
	}
	
	public List<BookEntity>  getAllBook(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize,String sortBy) 
	{
		
		Pageable paging=PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		 Page<BookEntity> pagedResult = repository.findAll(paging);
         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } 
	        else {
	            return new ArrayList<BookEntity>();
	        }
	    }
		
}
		
				
		
	


