package com.dictionary.dao;

import com.dictionary.model.RussianWord;

import java.util.Set;

public interface RussianDao {
    Set<RussianWord> findByName(int com, String word);

}
