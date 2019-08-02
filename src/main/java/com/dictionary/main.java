package com.dictionary;

import com.dictionary.controller.Controller;
import com.dictionary.service.Service;

public class main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        Service service = new Service();
        controller.input();
        service.closeConnection();

    }
}
