package com.ryanbriones.foo.repository;

import com.ryanbriones.foo.domain.Word;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
  public List<Word> findAll();
}