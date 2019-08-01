package com.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="book")
public class BookEntity {
	
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long bookid;
		
		private String bookname;
		private String authorname;
		private double price;
		
		
		
		public Long getBookid() 
		{
			return bookid;
		}
		public void setBookid(Long bookid)
		{
			this.bookid = bookid;
		}
		public String getBookname() 
		{
			return bookname;
		}
		public void setBookname(String bookname) 
		{
			this.bookname = bookname;
		}
		public String getAuthorname() 
		{
			return authorname;
		}
		public void setAuthorname(String authorname) 
		{
			this.authorname = authorname;
		}
		public double getPrice() 
		{
			return price;
		}
		public void setPrice(double price) 
		{
			this.price = price;
		}
		
		
		@Override
		public String toString() {
			return "Book [bookid=" + bookid + ", bookname=" + bookname + ", authorname=" + authorname + ", price=" + price
					+ "]";
		}
		

}
