package net.matholic.study.repository;

import java.util.List;

import net.matholic.study.domain.Board;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardRepository extends CrudRepository<Board, Long>, PagingAndSortingRepository<Board, Long> {
	List<Board> findById(Long id);
}
