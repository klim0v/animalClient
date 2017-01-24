package form;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class MyForm extends JFrame {

//    private NumberFormat format = NumberFormat.getNumberInstance();
//    private NumberFormatter formatter = new NumberFormatter(format);

    private JLabel welcomeLabel = new JLabel("<html><u>Добро пожаловать в <i>ЗООПАРК</i> Климова Сергея!!!</html>");
    private JLabel newAnimalLabel = new JLabel("Новое животное");
    private JButton newAnimalButton = new JButton("Запустить животное");
    private JLabel genusAnimalLabel = new JLabel("Вид животного:");

    private JLabel nameAnimalLabel = new JLabel("Имя животного:");
    private JTextField nameAnimalTextField = new JTextField();
    private JLabel weightAnimalLabel = new JLabel("Вес животного:");
    private JTextField weightAnimalTextField = new JFormattedTextField(); //
    private JRadioButton predatorButton = new JRadioButton("Хищник", false);
    private JRadioButton herbivorousButton = new JRadioButton("Травоядное", true);
    private ButtonGroup genusGroup = new ButtonGroup();
    ;
    private JTextArea detalsTextArea = new JTextArea();
    /*private String[] itemsAnimal = {
            "Лев",
            "Заяц",
            "Волк",
            "Кролик"
    };*/
    private JComboBox animalRunComboBox = new JComboBox(/*itemsAnimal*/);
    private JLabel eatLabel = new JLabel("Выполнить действие:");
    //private JLabel killLabel = new JLabel("Выполнить действие:");
    private String[] itemsRun = {
            "Съел",
            "Убил"
    };
    private JComboBox runComboBox = new JComboBox(itemsRun);
    /*private String[] items = {
        "Кролик",
                "Заяц",
                "Трава"
    };*/
    private JComboBox comboBox = new JComboBox(/*items*/);
    private JButton runAnimalButton = new JButton("Выполнить");

    private JLabel connectLabel = new JLabel("Введите IP адресс и номер порта:");
    private JTextField ipTextArea = new JTextField();
    private JTextField portTextArea = new JTextField();//formatter
    private JButton connectButton = new JButton("Подключиться");

    private JLabel usernameLabel = new JLabel("<html>Введите ваш логин <br>для идентификации:</html>");
    private JTextField usernameTextArea = new JTextField();

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JTextField getUsernameTextArea() {
        return usernameTextArea;
    }

    public void setUsernameTextArea(JTextField usernameTextArea) {
        this.usernameTextArea = usernameTextArea;
    }

    public MyForm() {



        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);

        welcomeLabel.setBounds(50, 10, 400, 15);
        add(welcomeLabel);

        newAnimalLabel.setBounds(5, 30, 130, 15);
        add(newAnimalLabel);

        genusAnimalLabel.setBounds(20, 50, 130, 15);
        add(genusAnimalLabel);


        genusGroup.add(predatorButton);
        predatorButton.setBounds(30, 70, 130, 15);
        predatorButton.setSelected(true);
        add(predatorButton);

        genusGroup.add(herbivorousButton);
        herbivorousButton.setBounds(30, 90, 130, 15);
        add(herbivorousButton);


        newAnimalButton.setEnabled(false);
        runAnimalButton.setEnabled(false);

        nameAnimalLabel.setBounds(20, 110, 130, 15);
        add(nameAnimalLabel);
        nameAnimalTextField.setBounds(30, 130, 130, 20);
        add(nameAnimalTextField);

        nameAnimalTextField.setEditable(false);

        weightAnimalLabel.setBounds(20, 150, 130, 15);
        add(weightAnimalLabel);
        weightAnimalTextField.setBounds(30, 170, 130, 20);
        add(weightAnimalTextField);

        weightAnimalTextField.setEditable(false);

        newAnimalButton.setBounds(5, 200, 160, 30);
        add(newAnimalButton);

        eatLabel.setBounds(5, 240, 130, 15);
        add(eatLabel);

        animalRunComboBox.setBounds(30, 260, 130, 20);
        add(animalRunComboBox);
        runComboBox.setBounds(30, 290, 130, 20);
        add(runComboBox);
        comboBox.setBounds(30, 320, 130, 20);
        add(comboBox);

        runAnimalButton.setBounds(5, 350, 160, 30);
        add(runAnimalButton);

        detalsTextArea.setBounds(170, 30, 300, 350);
        detalsTextArea.setEditable(false);
        add(detalsTextArea);

        connectLabel.setBounds(170, 380, 300, 15);
        add(connectLabel);

        ipTextArea.setText("127.0.0.1");
        ipTextArea.setBounds(170, 400, 100, 20);
        add(ipTextArea);
        portTextArea.setText("444");
        portTextArea.setBounds(280, 400, 50, 20);
        add(portTextArea);

        connectButton.setBounds(170, 425, 130, 30);
        add(connectButton);

        usernameLabel.setBounds(15, 390, 300, 30);
        add(usernameLabel);

        usernameTextArea.setText("User");
        usernameTextArea.setBounds(15, 425, 100, 20);
        add(usernameTextArea);

        animalRunComboBox.addItem("...");

        setLayout(null);
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(JLabel welcomeLabel) {
        this.welcomeLabel = welcomeLabel;
    }

    public JLabel getNewAnimalLabel() {
        return newAnimalLabel;
    }

    public void setNewAnimalLabel(JLabel newAnimalLabel) {
        this.newAnimalLabel = newAnimalLabel;
    }

    public JButton getNewAnimalButton() {
        return newAnimalButton;
    }

    public void setNewAnimalButton(JButton newAnimalButton) {
        this.newAnimalButton = newAnimalButton;
    }

    public JLabel getGenusAnimalLabel() {
        return genusAnimalLabel;
    }

    public void setGenusAnimalLabel(JLabel genusAnimalLabel) {
        this.genusAnimalLabel = genusAnimalLabel;
    }

    public JLabel getNameAnimalLabel() {
        return nameAnimalLabel;
    }

    public void setNameAnimalLabel(JLabel nameAnimalLabel) {
        this.nameAnimalLabel = nameAnimalLabel;
    }

    public JTextField getNameAnimalTextField() {
        return nameAnimalTextField;
    }

    public void setNameAnimalTextField(JTextField nameAnimalTextField) {
        this.nameAnimalTextField = nameAnimalTextField;
    }

    public JLabel getWeightAnimalLabel() {
        return weightAnimalLabel;
    }

    public void setWeightAnimalLabel(JLabel weightAnimalLabel) {
        this.weightAnimalLabel = weightAnimalLabel;
    }

    public JTextField getWeightAnimalTextField() {
        return weightAnimalTextField;
    }

    public void setWeightAnimalTextField(JTextField weightAnimalTextField) {
        this.weightAnimalTextField = weightAnimalTextField;
    }

    public JRadioButton getPredatorButton() {
        return predatorButton;
    }

    public void setPredatorButton(JRadioButton predatorButton) {
        this.predatorButton = predatorButton;
    }

    public JRadioButton getHerbivorousButton() {
        return herbivorousButton;
    }

    public void setHerbivorousButton(JRadioButton herbivorousButton) {
        this.herbivorousButton = herbivorousButton;
    }

    public ButtonGroup getGenusGroup() {
        return genusGroup;
    }

    public void setGenusGroup(ButtonGroup genusGroup) {
        this.genusGroup = genusGroup;
    }

    public JTextArea getDetalsTextArea() {
        return detalsTextArea;
    }

    public void setDetalsTextArea(JTextArea detalsTextArea) {
        this.detalsTextArea = detalsTextArea;
    }

    /*public String[] getItemsAnimal() {
        return itemsAnimal;
    }

    public void setItemsAnimal(String[] itemsAnimal) {
        this.itemsAnimal = itemsAnimal;
    }*/

    public JComboBox getAnimalRunComboBox() {
        return animalRunComboBox;
    }

    public void setAnimalRunComboBox(JComboBox animalRunComboBox) {
        this.animalRunComboBox = animalRunComboBox;
    }

    public JLabel getEatLabel() {
        return eatLabel;
    }

    public void setEatLabel(JLabel eatLabel) {
        this.eatLabel = eatLabel;
    }

    public String[] getItemsRun() {
        return itemsRun;
    }

    public void setItemsRun(String[] itemsRun) {
        this.itemsRun = itemsRun;
    }

    public JComboBox getRunComboBox() {
        return runComboBox;
    }

    public void setRunComboBox(JComboBox runComboBox) {
        this.runComboBox = runComboBox;
    }

    /*public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }*/

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getRunAnimalButton() {
        return runAnimalButton;
    }

    public void setRunAnimalButton(JButton runAnimalButton) {
        this.runAnimalButton = runAnimalButton;
    }

    public JLabel getConnectLabel() {
        return connectLabel;
    }

    public void setConnectLabel(JLabel connectLabel) {
        this.connectLabel = connectLabel;
    }

    public JTextField getIpTextArea() {
        return ipTextArea;
    }

    public void setIpTextArea(JTextField ipTextArea) {
        this.ipTextArea = ipTextArea;
    }

    public JTextField getPortTextArea() {
        return portTextArea;
    }

    public void setPortTextArea(JTextField portTextArea) {
        this.portTextArea = portTextArea;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public void setConnectButton(JButton connectButton) {
        this.connectButton = connectButton;
    }
}
