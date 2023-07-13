package co.edu.platzi;

import co.edu.platzi.service.MessageService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response = 0;

        do {
            System.out.print("\n==> Messaging Application <==\n 1. Crear mensaje\n 2. Listar mensajes\n "
                    + "3. Editar mensaje\n 4. Eliminar mensaje\n 5. Salir\n -> ");
            response = sc.nextInt();

            switch (response) {
                case 1 -> MessageService.createMessage();
                case 2 -> MessageService.getAllMessages();
                case 3 -> MessageService.updateMessage();
                case 4 -> MessageService.deleteMessage();
            }
        } while (response != 5);
    }
}