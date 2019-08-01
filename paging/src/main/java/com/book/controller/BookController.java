package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.book.model.BookEntity;
import com.book.sevice.BookService;

@RestController
@RequestMapping("/library")
public class BookController {

	@Autowired
    BookService service;

	
	@PostMapping
	public BookEntity create (@RequestBody BookEntity book) throws Exception 
	{
		BookEntity v =null;
	   try {
			 v= service.create(book);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}	
		 
		 return v;
	}
	
	
	@GetMapping
	public List<BookEntity> getAllBook(@RequestParam(defaultValue="0")Integer pageNo,@RequestParam(defaultValue="10")Integer pageSize,@RequestParam(defaultValue="id")String sortBy)
	{
		return  service.getAllBook(pageNo,pageSize,sortBy);
	}


}
