package controllers;

import listener.Listener;
import models.Eat;
import models.Graminivorous;
import models.Grass;
import models.Predator;
import thread.ClientThread;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static com.company.Valid.valid;

/**
 * Created by c-0k on 01.12.2016.
 */
public class GeneralController {

    private static Socket s;
    private static String name;

    public GeneralController(String host, String portS, String name) throws IOException {
        int port = Integer.parseInt(portS);
        s = new Socket(host, port);
        GeneralController.name = name;
    }

    public static void disconectServ(){

    }

    public static void connectServ(/*String host, String portS, String name, */int a) throws IOException, ClassNotFoundException {

        /*int port = Integer.parseInt(portS);
        Socket s = new Socket(host, port);*/
        //System.out.println("Клиент подключился к " + host +":"+ port);

//        ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
//        outputStream.writeInt(1);

        ClientThread mt = new ClientThread(s, name, a);

        Thread t = new Thread(mt);
        if (a==1){
            t.setPriority(Thread.MAX_PRIORITY);
        }
        else {
            t.setPriority(Thread.MIN_PRIORITY);
        }
        t.start();
    }

    public static void insert(Eat entity){

            Listener.getMyForm().getDetalsTextArea().setText(Listener.getMyForm().getDetalsTextArea().getText()
                    + entity.getName() + "\t"
                    + entity.getWeight() + "\t"
                    + entity.getGenus()
                    +  "\n" );
            Listener.getMyForm().getAnimalRunComboBox().addItem(entity); // отображается не в пригодном для чтения виде,
                                                                        // но удобно брать сущность для передачи выбора на сервер

//            Listener.getMyForm().getComboBox().addItem(entity.getName());

    }

    public static void insertCombo(Eat entity){
        /*Listener.getMyForm().getDetalsTextArea().setText(Listener.getMyForm().getDetalsTextArea().getText()
                + entity.getName() + "\t"
                + entity.getWeight() + "\t"
                + entity.getGenus()
                +  "\n" );*/
        Listener.getMyForm().getComboBox().addItem(entity); // отображается не в пригодном для чтения виде,
        // но удобно брать сущность для передачи выбора на сервер

//            Listener.getMyForm().getComboBox().addItem(entity.getName());

    }


    public static void clear() {
        Listener.getMyForm().getDetalsTextArea().setText("");
    }
    public static Eat selectComboBox() {
        return (Eat)Listener.getMyForm().getAnimalRunComboBox().getSelectedItem();

    }

    public static Eat creatEat() {
        String name = Listener.getMyForm().getNameAnimalTextField().getText();
        String w = Listener.getMyForm().getWeightAnimalTextField().getText();
        Eat eat = null;
        if (valid(w)) {
            if (Listener.getMyForm().getPredatorButton().isSelected()) {
                eat = new Predator(Integer.parseInt(w), name);
            } else {
                eat = new Graminivorous(Integer.parseInt(w), name);
            }
        }
        return eat;

    }
}
