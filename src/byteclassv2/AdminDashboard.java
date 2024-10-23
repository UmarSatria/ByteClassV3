/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package byteclassv2;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author putra mahardika
 */
public class AdminDashboard extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        Koneksi c = new Koneksi();
        initializeTableModel(); // Inisialisasi model tabel
        loadCourses();
        loadCategoryData();
    }

    private void loadCategoryData() {
        Koneksi c = new Koneksi();  // Membuat koneksi
        try (Connection conn = c.getConn()) {
            String query = "SELECT nama_kategori FROM category";  // Mengambil nama_kategori dari table category
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            jComboBox2.removeAllItems();  // Menghapus item yang sudah ada di combo box sebelum mengisi ulang
            while (rs.next()) {
                String namaKategori = rs.getString("nama_kategori");
                jComboBox2.addItem(namaKategori);  // Menambahkan setiap nama kategori ke jComboBox
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data kategori!");
        }
    }

    private void initializeTableModel() {
        // Inisialisasi model tabel dan set ke tblCourse
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Category ID");
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Course Material");
        tableModel.addColumn("Link");
        tblCourse.setModel(tableModel);
    }

    public void loadCourses() {
        // Kosongkan tabel sebelum mengisi data baru
        tableModel.setRowCount(0);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", ""); PreparedStatement pst = conn.prepareStatement("SELECT * FROM courses"); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Object[] data = {
                    rs.getInt("id"),
                    rs.getString("id_category"),
                    rs.getString("course_name"),
                    rs.getString("course_material"),
                    rs.getString("link") // Link yang akan ditampilkan
                };
                tableModel.addRow(data);
            }

            // Menambahkan renderer khusus untuk kolom link
            TableColumn linkColumn = tblCourse.getColumnModel().getColumn(4); // Kolom ke-5 untuk link
            linkColumn.setCellRenderer(new LinkCellRenderer());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void clearFields() {
        throw new UnsupportedOperationException("Not support yet");
    }

// Custom Renderer untuk membuat link dapat diklik
        class LinkCellRenderer extends DefaultTableCellRenderer {

            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel();
                label.setText("<html><a href=''>" + value.toString() + "</a></html>");  // Membuat teks link

                // Menambahkan MouseListener untuk mendeteksi klik pada link
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        try {
                            // Membuka URL di browser default
                            Desktop desktop = Desktop.getDesktop();
                            desktop.browse(new URI(value.toString())); // Membuka link di browser
                        } catch (Exception ex) {
                            java.util.logging.Logger.getLogger(LinkCellRenderer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });

                return label;
            }
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMat = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DASHBOARD");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ADD COURSE");

        tblCourse.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCourse);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Course Title");

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("About Materials");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Course Link");

        txtLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLinkActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setText("ADD COURSE");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editBtn.setText("EDIT COURSE");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE COURSE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        txtMat.setColumns(20);
        txtMat.setRows(5);
        jScrollPane2.setViewportView(txtMat);

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH CATEGORY --", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Category Course");

        jButton2.setText("CATEGORY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jButton2))
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2)
                    .addComponent(txtTitle)
                    .addComponent(jComboBox2, 0, 276, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(txtLink))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(editBtn)
                        .addGap(72, 72, 72)
                        .addComponent(deleteBtn)))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLink, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn)
                            .addComponent(editBtn)
                            .addComponent(deleteBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLinkActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        String courseName = txtTitle.getText();  // Mengambil nama course dari text field
        String courseMaterial = txtMat.getText();  // Mengambil materi course dari text field
        String link = txtLink.getText();  // Mengambil link dari text field
        String selectedCategory = (String) jComboBox2.getSelectedItem();  // Mengambil nama kategori yang dipilih dari combo box

        if (courseName.isEmpty() || courseMaterial.isEmpty() || link.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        Koneksi c = new Koneksi();
        try (Connection conn = c.getConn()) {
            // Mengambil id_category berdasarkan nama_kategori yang dipilih
            String queryGetCategoryId = "SELECT id FROM category WHERE nama_kategori = ?";
            PreparedStatement psCategory = conn.prepareStatement(queryGetCategoryId);
            psCategory.setString(1, selectedCategory);
            ResultSet rs = psCategory.executeQuery();

            if (rs.next()) {
                int idCategory = rs.getInt("id");  // Mendapatkan id_category
                // Menambahkan data ke tabel course
                String queryInsertCourse = "INSERT INTO courses (id_category, course_material, course_name, link) VALUES (?, ?, ?, ?)";
                PreparedStatement psCourse = conn.prepareStatement(queryInsertCourse);
                psCourse.setInt(1, idCategory);  // Memasukkan id_category
                psCourse.setString(2, courseMaterial);  // Memasukkan nama course
                psCourse.setString(3, courseName);  // Memasukkan materi course
                psCourse.setString(4, link);  // Memasukkan link
                psCourse.executeUpdate();
                clearFields();

                JOptionPane.showMessageDialog(null, "Course berhasil ditambahkan!");
            } else {
                JOptionPane.showMessageDialog(null, "Kategori tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menambahkan course!");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void tblCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCourseMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblCourse.getSelectedRow();

        // Memeriksa apakah ada baris yang dipilih
        if (selectedRow != -1) {
            // Mengambil data dari tabel
            String categoryId = tblCourse.getValueAt(selectedRow, 1).toString(); // Kolom kedua
            String courseMaterial = tblCourse.getValueAt(selectedRow, 3).toString(); // Kolom ketiga
            String courseName = tblCourse.getValueAt(selectedRow, 2).toString(); // Kolom kedua
            String link = tblCourse.getValueAt(selectedRow, 4).toString(); // Kolom keempat

            // Mengisi data ke dalam field input
            jComboBox2.setSelectedItem(categoryId);
            txtMat.setText(courseMaterial);
            txtTitle.setText(courseName);
            txtLink.setText(link);
        }
    }//GEN-LAST:event_tblCourseMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCourse.getSelectedRow(); // Ambil baris yang dipilih

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a course to edit!");
            return;
        }

// Ambil ID dari kursus yang dipilih
        int courseId = (int) tableModel.getValueAt(selectedRow, 0); // ID kursus
        String courseName = txtTitle.getText(); // Ambil nama kursus dari field input
        String courseMaterial = txtMat.getText(); // Ambil materi kursus dari field input
        String courseLink = txtLink.getText(); // Ambil link dari field input
        String selectedCategory = (String) jComboBox2.getSelectedItem(); // Ambil kategori yang dipilih

// Konfirmasi pembaruan
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this course?", "Confirm Update", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Mengambil id_category berdasarkan nama_kategori yang dipilih
            int idCategory = -1; // Inisialisasi ID kategori

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", ""); PreparedStatement psCategory = conn.prepareStatement("SELECT id FROM category WHERE nama_kategori = ?")) {

                psCategory.setString(1, selectedCategory);
                ResultSet rsCategory = psCategory.executeQuery();

                if (rsCategory.next()) {
                    idCategory = rsCategory.getInt("id"); // Mendapatkan id_category
                } else {
                    JOptionPane.showMessageDialog(this, "Selected category not found!");
                    return; // Hentikan eksekusi jika kategori tidak ditemukan
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error retrieving category ID: " + e.getMessage());
                return; // Hentikan eksekusi jika terjadi kesalahan
            }

            // Melakukan pembaruan ke database
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", ""); PreparedStatement pst = conn.prepareStatement("UPDATE courses SET course_name = ?, course_material = ?, link = ?, id_category = ? WHERE id = ?")) {

                // Set parameter untuk query update
                pst.setString(1, courseName);
                pst.setString(2, courseMaterial);
                pst.setString(3, courseLink);
                pst.setInt(4, idCategory); // Set ID kategori untuk menentukan baris yang akan diperbarui
                pst.setInt(5, courseId); // Set ID untuk menentukan baris yang akan diperbarui

                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Course updated successfully!");
                    loadCourses(); // Memuat ulang data kursus
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update course.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCourse.getSelectedRow(); // Ambil baris yang dipilih

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a course to delete!");
            return;
        }

        // Ambil ID dari kursus yang dipilih
        int courseId = (int) tableModel.getValueAt(selectedRow, 0); // ID kursus

        // Konfirmasi penghapusan
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this course?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Melakukan penghapusan dari database
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/byteclass", "root", ""); PreparedStatement pst = conn.prepareStatement("DELETE FROM courses WHERE id = ?")) {

                pst.setInt(1, courseId); // Set ID untuk melakukan penghapusan

                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Course deleted successfully!");
                    loadCourses(); // Memuat ulang data kursus
                    clearFields(); // Mengosongkan field input
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete course.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin ingln ogout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            LoginForm formlogin = new LoginForm();
            formlogin.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CategoryPage category = new CategoryPage();
        category.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
//     // TODO add your handling code here:
//         Koneksi c = new Koneksi();  // Membuat koneksi
//    try (Connection conn = c.getConn()) {
//        String query = "SELECT nama_kategori FROM category";  // Mengambil nama_kategori dari table category
//        PreparedStatement ps = conn.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//
//        jComboBox2.removeAllItems();  // Menghapus item yang sudah ada di combo box sebelum mengisi ulang
//        while (rs.next()) {
//            String namaKategori = rs.getString("nama_kategori");
//            jComboBox2.addItem(namaKategori);  // Menambahkan setiap nama kategori ke jComboBox
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data kategori!");
//    }
    }//GEN-LAST:event_jComboBox2ActionPerformed
//

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCourse;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextArea txtMat;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
