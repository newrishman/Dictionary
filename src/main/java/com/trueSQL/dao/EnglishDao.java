package com.trueSQL.dao;

import com.trueSQL.model.EnglishWord;

import java.sql.Connection;
import java.util.Set;

public interface EnglishDao {
    Set<?> findByName(String word);

}
