package co.edu.platzi.dao;

import co.edu.platzi.connection.ConnectionDB;
import co.edu.platzi.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MessageDAO {

    static ConnectionDB connectionDB = new ConnectionDB();

    public static void createMessage(Message message) {
        try (Connection db = connectionDB.getConnection()) {
            PreparedStatement statement = null;
            String query = "insert into mensajes(mensaje,autor_mensaje,fecha_mensaje) values (?,?,CURRENT_TIMESTAMP)";
            statement = db.prepareStatement(query);
            statement.setString(1, message.getMessage());
            statement.setString(2, message.getAuthor());
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getMessages() {

    }

    public static void deleteMessage(int id) {

    }

    public static void updateMessage(Message message) {

    }
}
