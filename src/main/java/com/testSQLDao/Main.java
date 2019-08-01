package com.testSQLDao;

import com.testSQLDao.dao.DictionaryDAO;
import com.testSQLDao.dao.JDBCDictionaryDAO;

public class Main {
    public static void main(String[] args) {

        DictionaryDAO dDAO = new JDBCDictionaryDAO();
        dDAO.getConnection();
        dDAO.select();
        dDAO.closeConnection();
    }
}
