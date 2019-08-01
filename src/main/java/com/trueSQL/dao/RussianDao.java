package com.trueSQL.dao;

import com.trueSQL.model.RussianWord;

import java.sql.Connection;
import java.util.Set;

public interface RussianDao {
    Set<RussianWord> findByName(String word);

}
