package com.dictionary.dao;

import java.util.Set;

public interface EnglishDao {
    Set<?> findByName(int com, String word);

}
