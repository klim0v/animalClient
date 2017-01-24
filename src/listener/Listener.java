package listener;

import form.MyForm;
import controllers.*;
import models.Eat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static com.company.Valid.valid;

public class Listener implements ActionListener {

    private static MyForm myForm;

    public static MyForm getMyForm() {
        return myForm;
    }

    public void setMyForm(MyForm myForm) {
        Listener.myForm = myForm;
    }

    public Listener(MyForm clientForm) {
        myForm = clientForm;
        myForm.getNewAnimalButton().addActionListener(this);
        myForm.getConnectButton().addActionListener(this);
        myForm.getAnimalRunComboBox().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getNewAnimalButton())) {

            try {
                GeneralController.connectServ(4);
                //GeneralController.connectServ(1);
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            /*myForm.getDetalsTextArea().setText(
                    myForm.getDetalsTextArea().getText()
                    + myForm.getNameAnimalTextField().getText() + "\t"
                            + myForm.getWeightAnimalTextField().getText() + "\t"
                            + ((myForm.getPredatorButton().isSelected())? "Хищник":"Травоядное") +  "\n"
            );*/
        }

        if (e.getSource().equals(myForm.getConnectButton())){
            if (e.getSource().equals(myForm.getConnectButton())) {
                if (myForm.getConnectButton().getText().equals("Подключиться")) {
                    myForm.getConnectButton().setText("Отключиться");
                    myForm.getWeightAnimalTextField().setEditable(true);
                    myForm.getNameAnimalTextField().setEditable(true);
                    myForm.getIpTextArea().setEditable(false);
                    myForm.getPortTextArea().setEditable(false);
                    myForm.getUsernameTextArea().setEditable(false);
                    myForm.getNewAnimalButton().setEnabled(true);
                    myForm.getRunAnimalButton().setEnabled(true);
                    //myForm.getAnimalRunComboBox().addItem(" ... ");
                    /*myForm.getAnimalRunComboBox().addItem("Волк");*/
                    String port = myForm.getPortTextArea().getText();
                    String ip = myForm.getIpTextArea().getText();
                    String name = myForm.getUsernameTextArea().getText();
                    if (valid(port)   ){//&& (!valid(ip))) {
                        try {
                            new GeneralController(ip, port, name);
                            GeneralController.connectServ(1);
                        } catch (Exception e1) {
                            myForm.getDetalsTextArea().setText("Сервер временно не доступен!");
                            return;
                        }
                    } else {
                        myForm.getDetalsTextArea().setText("Не корректно введен порт");
                        return;
                    }

                }
                else {
                    try {
                        GeneralController.connectServ(3);
                    } catch (IOException | ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }

                    myForm.getConnectButton().setText("Подключиться");
                    myForm.getWeightAnimalTextField().setText("");
                    myForm.getWeightAnimalTextField().setEditable(false);
                    myForm.getNameAnimalTextField().setText("");
                    myForm.getNameAnimalTextField().setEditable(false);
                    myForm.getIpTextArea().setEditable(true);
                    myForm.getPortTextArea().setEditable(true);
                    myForm.getUsernameTextArea().setEditable(true);
                    myForm.getNewAnimalButton().setEnabled(false);
                    myForm.getRunAnimalButton().setEnabled(false);
                    myForm.getAnimalRunComboBox().removeAll();
                    myForm.getAnimalRunComboBox().addItem("...");
                    myForm.getComboBox().removeAll();
                    myForm.getComboBox().addItem("...");
                    myForm.getDetalsTextArea().setText("");

                }
            }
        }
        if (e.getSource().equals(myForm.getAnimalRunComboBox())){
            System.out.println(Listener.getMyForm().getAnimalRunComboBox().getSelectedItem().toString());
            if (Listener.getMyForm().getAnimalRunComboBox().getSelectedItem().toString().equals("...")){
                System.out.println("...");
                return;
            }
            //myForm.getDetalsTextArea().setText("get ");
            try {
                GeneralController.connectServ(2);
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }

        }
    }

}
