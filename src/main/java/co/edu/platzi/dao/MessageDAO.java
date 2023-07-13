package co.edu.platzi.dao;

import co.edu.platzi.connection.ConnectionDB;
import co.edu.platzi.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MessageDAO {

    static ConnectionDB connectionDB = new ConnectionDB();

    public static void createMessage(Message message) {
        try (Connection db = connectionDB.getConnection()) {
            String query = "insert into mensajes(mensaje,autor_mensaje,fecha_mensaje) values (?,?,CURRENT_TIMESTAMP)";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, message.getMessage());
            statement.setString(2, message.getAuthor());
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("¡ERROR! " + e);
        }
    }

    public static void getMessages() {
        try (Connection db = connectionDB.getConnection()) {
            //String query = "select m.id_mensaje,m.mensaje,m.fecha,u.nombre_completo from mensajes m join usuarios u on m.id_usuario=u.id_usuario";
            String query = "select * from mensajes";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.print("[Id: " + resultSet.getInt("id_mensaje")
                        + " | mensaje: " + resultSet.getString("mensaje")
                        + " | autor: " + resultSet.getString("autor_mensaje")
                        + " | fecha: " + resultSet.getString("fecha_mensaje") + "]\n");
            }

        } catch (Exception e) {
            System.out.println("¡ERROR! " + e);
        }
    }

    public static void deleteMessage(int messageId) {
        try (Connection db = connectionDB.getConnection()) {
            String query = "delete from mensajes where id_mensaje = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, messageId);
            statement.executeUpdate();
            System.out.println("¡Se ha eliminado el mensaje con exito!");

        } catch (Exception e) {
            System.out.println("¡ERROR! " + e);
        }
    }

    public static void updateMessage(Message message) {
        try (Connection db = connectionDB.getConnection()) {
            String query = "update mensajes set mensaje = ?, autor_mensaje = ? where id_mensaje = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, message.getMessage());
            statement.setString(2, message.getAuthor());
            statement.setInt(3, message.getId());
            statement.executeUpdate();
            System.out.println("¡Se ha actualizado el mensaje con exito!");

        } catch (Exception e) {
            System.out.println("¡ERROR! " + e);
        }
    }
}
