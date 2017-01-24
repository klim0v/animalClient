package com.company;

import form.*;
import listener.*;
import models.*;


public class Main {

    public static void main(String[] args) {

        MyForm clientForm = new MyForm();
        Listener clientFormListener = new Listener(clientForm);
        clientForm.setVisible(true);

    }
}
