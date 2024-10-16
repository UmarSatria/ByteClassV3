/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package byteclassv2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author putra mahardika
 */
public class Koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/byteclass";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn;

    public static void connect() {
        try {
            if (conn == null || conn.isClosed()) {  // Memastikan koneksi belum terbuka
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection success");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Method untuk mengembalikan koneksi, memastikan koneksi terbuka
    public static Connection getConn() {
        connect();  // Memastikan koneksi terbuka sebelum mengembalikan objek Connection
        return conn;
    }

    // Method untuk menutup koneksi jika dibutuhkan
    public static void closeConn() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
