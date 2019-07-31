package com.newrishman;

import com.newrishman.dao.DictionaryDAO;
import com.newrishman.dao.JDBCDictionaryDAO;

public class Main {
    public static void main(String[] args) {

        DictionaryDAO dDAO = new JDBCDictionaryDAO();
        dDAO.getConnection();
        dDAO.select();
        dDAO.closeConnection();
    }
}
