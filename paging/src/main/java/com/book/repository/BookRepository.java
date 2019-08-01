package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.book.model.BookEntity;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity,Long>,JpaRepository<BookEntity,Long>
{

}
