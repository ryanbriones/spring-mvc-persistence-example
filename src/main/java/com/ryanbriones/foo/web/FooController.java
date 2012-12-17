package com.ryanbriones.foo.web;

import com.ryanbriones.foo.domain.Word;
import com.ryanbriones.foo.repository.WordRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class FooController {
  @Autowired
  WordRepository wordRepository;

  public FooController() {}

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView index() {
    ModelAndView index = new ModelAndView();
    index.setViewName("foo/index");

    List<Word> allWords = wordRepository.findAll();
    index.addObject("words", allWords);
    return index;
  }
}