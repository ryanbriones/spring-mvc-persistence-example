package com.ryanbriones.foo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@Table(name = "words")
@NamedQuery(name = "Word.findAll", query = "SELECT w FROM Word w")
public class Word implements Serializable {
  private static final long serialVersionUID = 1L;

  public Word() {}

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  public int getId() { return id; }

  private String value;
  public String getValue() { return value; }
  public void setValue(String newValue) { this.value = newValue; }

  private int count;
  public int getCount() { return count; }
  public void setCount(int newCount) { this.count = newCount; }

  private String classification;
  public String getClassification() { return classification; }
  public void setClassification(String newClassification) { this.classification = newClassification; }

  @Override
  public boolean equals(final Object otherObj) {
    if(this == otherObj) {
      return true;
    }

    if ((otherObj == null) || !(otherObj instanceof Word)) {
        return false;
    }

    final Word other = (Word) otherObj;

    return id == other.getId();
  }

  @Override
  public int hashCode() {
    return new Integer(id).hashCode();
  }

  public String toString() {
    return String.format("(Word) {id: %d, value: '%s', count: %d, classification: '%s'}",
      id, value, count, classification);
  }
}