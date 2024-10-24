/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package byteclassv2;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.URI;

/**
 *
 * @author putra mahardika
 */
public class CoursePage extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */
    public CoursePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataClass = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMateri = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to ByteClass");

        dataClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataClassMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataClass);

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Nama Course");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Materi Course");

        btnCari.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\putra mahardika\\Downloads\\ByteClass.png")); // NOI18N
        jLabel8.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(btnReset))
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMateri, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton1)))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2))
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMateri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataClassMouseClicked
        // TODO add your handling code here:
        String[] columnNames = {"Course Name", "Course Material", "Link"};

        // DefaultTableModel untuk menyimpan data
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Membuat JTable dengan model yang sudah disiapkan
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Menampilkan JTable di dalam JFrame (ini hanya dipanggil sekali)
        JFrame tableFrame = new JFrame("Daftar Course");
        tableFrame.add(scrollPane);
        tableFrame.setSize(600, 300);
        tableFrame.setLocationRelativeTo(null);
        tableFrame.setVisible(true);

        // Mengambil data dari database dan mengisi JTable
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT course_name, course_material, link FROM courses";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String courseName = rs.getString("course_name");
                String courseMaterial = rs.getString("course_material");
                String link = rs.getString("link");
                model.addRow(new Object[]{courseName, courseMaterial, link});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Simpan JTable sebagai komponen yang dapat digunakan di event handler
        this.dataClass = table;
    }//GEN-LAST:event_dataClassMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String name = txtNama.getText().trim(); // Input dari txtName
        String materi = txtMateri.getText().trim(); // Input dari txtMateri

        // Menyiapkan query SQL
        String query = "SELECT course_name, course_material, link FROM courses WHERE 1=1";

        // Menambahkan kondisi berdasarkan input dari txtName dan txtMateri
        if (!name.isEmpty()) {
            query += " AND course_name LIKE '%" + name + "%'";
        }
        if (!materi.isEmpty()) {
            query += " AND course_material LIKE '%" + materi + "%'";
        }

        // Menyiapkan model untuk JTable
        DefaultTableModel model = (DefaultTableModel) dataClass.getModel();
        model.setRowCount(0); // Membersihkan tabel sebelum menampilkan hasil pencarian

        // Melakukan koneksi ke database dan menjalankan query
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Memasukkan hasil query ke dalam tabel
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                String courseMaterial = rs.getString("course_material");
                String link = rs.getString("link");
                model.addRow(new Object[]{courseName, courseMaterial, link});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtNama.setText("");
        txtMateri.setText("");

        // Menyiapkan query untuk menampilkan semua data
        String query = "SELECT course_name, course_material, link FROM courses";

        // Menyiapkan model untuk JTable
        DefaultTableModel model = (DefaultTableModel) dataClass.getModel();
        model.setRowCount(0); // Membersihkan tabel sebelum menampilkan data

        // Melakukan koneksi ke database dan menjalankan query
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Memasukkan semua data ke dalam tabel
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                String courseMaterial = rs.getString("course_material");
                String link = rs.getString("link");
                model.addRow(new Object[]{courseName, courseMaterial, link});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UserDashboard user = new UserDashboard();
        user.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoursePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoursePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnReset;
    private javax.swing.JTable dataClass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMateri;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
