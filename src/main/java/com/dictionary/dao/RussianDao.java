package com.dictionary.dao;

import com.dictionary.model.RussianWord;

import java.util.Set;

public interface RussianDao {
    Set<RussianWord> findByName(String command, String word);

}
