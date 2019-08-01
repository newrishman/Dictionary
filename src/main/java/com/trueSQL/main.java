package com.trueSQL;

import com.trueSQL.dao.EnglishDao;
import com.trueSQL.dao.EnglishDaoJdbc;
import com.trueSQL.dao.RussianDao;
import com.trueSQL.dao.RussianDaoJdbc;

public class main {
    public static void main(String[] args) {
        RussianDao rusDao = new RussianDaoJdbc();
        EnglishDao engDao = new EnglishDaoJdbc();

        engDao.getConnection();
        rusDao.getConnection();

        System.out.println(engDao.findByName("hello"));
        System.out.println(rusDao.findByName("привет"));

        engDao.closeConnection();
        rusDao.closeConnection();
    }


}
