package com.book.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.dao.BookDao;

import com.book.model.BookEntity;


@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	
	public BookEntity create(BookEntity book) throws Exception {
		BookEntity b = null;
		 try {
			b= bookDao.create(book);
		} catch (Exception e) {
			
//			 TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return b;
	}
	public List<BookEntity> getAllBook(@RequestParam(defaultValue="0")Integer pageNo,@RequestParam(defaultValue="10")Integer pageSize,@RequestParam(defaultValue="id")String sortBy)
	{
		return  bookDao.getAllBook(pageNo,pageSize,sortBy);
	}
}
