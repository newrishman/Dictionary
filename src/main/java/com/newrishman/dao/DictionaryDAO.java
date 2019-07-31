package com.newrishman.dao;

import java.sql.Connection;
import java.util.Set;

public interface DictionaryDAO {

    Connection getConnection();

    Set<String> select();

    void closeConnection();

}
