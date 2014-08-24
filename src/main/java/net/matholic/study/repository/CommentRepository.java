package net.matholic.study.repository;

import java.util.List;

import net.matholic.study.domain.Comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends CrudRepository<Comment, Long>, PagingAndSortingRepository<Comment, Long> {
	List<Comment> findById(Long id);
}
