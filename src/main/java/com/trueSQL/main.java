package com.trueSQL;

import com.trueSQL.controller.Controller;
import com.trueSQL.dao.Service;

public class main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        Service service = new Service();
        controller.input();
        service.closeConnection();
    }


}
