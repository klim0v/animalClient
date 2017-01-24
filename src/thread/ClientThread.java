package thread;

import models.Eat;

import models.Grass;
import models.Predator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static controllers.GeneralController.*;


/**
 * Created by c-0k on 05.12.2016.
 */
public class ClientThread implements Runnable {

    private Socket s;
    private String name;
    private int a;

    public ClientThread(Socket s, String name, int a) {
        this.s=s;
        this.name = name;
        this.a = a;
    }



    @Override
    public void run() {
        try {
            final ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            final ObjectInputStream inputStream = new ObjectInputStream(s.getInputStream());
            outputStream.writeInt(a);
            //inputStream.readInt();
            System.out.println("отправлен case");
            outputStream.writeObject(this.name);
            //inputStream.readInt();
            System.out.println("отправлен name");
            switch (a) { //получение всех
                case 1: {
                    int count = inputStream.readInt();
                    clear();
                    for (int i = 0; i < count; i++) {

                        Eat entity = (Eat) inputStream.readObject();
//                System.out.println("Получена сущность:  " + entity.getName()
//                        + '\t' + entity.getWeight() + '\t' + entity.getId());
                        insert(entity);
                    }
                    break;
                }
                case 2: { //получение возможной еды для сущности
                    System.out.println("case 2");
                    Eat sel = selectComboBox();
                    System.out.println(sel);
                    outputStream.writeObject(sel);
                    System.out.println("Отправлен запрос на получение сущностей");
                    int count = inputStream.readInt();
                    for (int i = 0; i < count; i++) {

                        Eat entity = (Eat) inputStream.readObject();

                        System.out.println("Получена сущность:  " + entity.getName()
                                + '\t' + entity.getWeight() + '\t' + entity.getId());

                        insertCombo(entity);
                    }
                    break;
                }
                case 3:{
                    System.out.println("case 3");
                    //откл клиента
                    break;
                }
                case 4:{ // созд сущности
                    System.out.println("case 4");
                    outputStream.writeObject(creatEat());
                    connectServ(1);
                    break;
                }
                case 5:{// съесть

                    break;
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}