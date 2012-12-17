package com.ryanbriones.foo.web;

import com.ryanbriones.foo.domain.Word;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Controller
@RequestMapping(value = "/")
public class FooController {
  @PersistenceContext
  private EntityManager entityManager;

  public FooController() {}

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView index() {
    ModelAndView index = new ModelAndView();
    index.setViewName("foo/index");

    Collection<Word> allWords = (Collection<Word>) entityManager.createNamedQuery("Word.findAll").getResultList();
    index.addObject("words", allWords);
    return index;
  }
}