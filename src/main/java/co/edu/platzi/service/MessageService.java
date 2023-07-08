package co.edu.platzi.service;

import co.edu.platzi.dao.MessageDAO;
import co.edu.platzi.model.Message;

import java.util.Scanner;

public class MessageService {

    static Message message = new Message();
    static Scanner scanner = new Scanner(System.in);

    public static void createMessage() {
        System.out.print("Ingrese el mensaje\n -> ");
        String text = scanner.next();
        System.out.print("Ingrese el autor\n -> ");
        String author = scanner.next();
        message.setMessage(text);
        message.setAuthor(author);
        MessageDAO.createMessage(message);
    }

    public static void getAllMessages() {

    }

    public static void deleteMessage() {

    }

    public static void updateMessage() {

    }
}
