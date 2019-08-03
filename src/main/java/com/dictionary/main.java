package com.dictionary;

import com.dictionary.controller.Controller;
import com.dictionary.service.Service;

public class main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.dictionary();

        Service service = new Service();
        service.closeConnection();

    }
}
