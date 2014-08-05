package org.phstudy.sample.repository;

import java.util.List;

import org.phstudy.sample.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchCrudRepository<Book, Long> {
	List<Book> findByNameAndPrice(String name, Integer price);

	List<Book> findByNameOrPrice(String name, Integer price);

	Page<Book> findByName(String name, Pageable page);

	Page<Book> findByNameNot(String name, Pageable page);

	Page<Book> findByPriceBetween(int price, Pageable page);

	Page<Book> findByNameLike(String name, Pageable page);

	@Query("{\"bool\" : {\"must\" : {\"term\" : {\"message\" : \"?0\"}}}}")
	Page<Book> findByMessage(String message, Pageable pageable);
}