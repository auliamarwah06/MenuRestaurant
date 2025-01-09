/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tubesss;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;





/**
 *
 * @author LENOVO
 */


public class MenuRestaurant extends javax.swing.JInternalFrame {
    // Variabel deklarasi lainnya...
    private final DefaultTableModel model;

    public MenuRestaurant() {
        initComponents();
        model = (DefaultTableModel) tabel.getModel();
        loadData();
    }

    /**
     * Creates new form OptionMenu
     */

    private void loadData() {
    try {
        // Kosongkan tabel sebelum menambahkan data baru
        model.setRowCount(0);  // Hapus semua baris sebelumnya
        try ( // Koneksi ke database MySQL
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
            String query = "SELECT * FROM menu";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            
            while (rs.next()) {
                Object[] row = {
                    rs.getString("id"),
                    rs.getString("nama_menu"),
                    rs.getDouble("harga"),
                    rs.getString("kategori")
                };
                model.addRow(row);  // Tambahkan baris ke tabel GUI
            }
        }
    } catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nama_menu = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nama_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kategori = new javax.swing.JComboBox<>();

        setTitle("MENU RESTAURANT");

        jLabel1.setText("Nama Menu");

        jLabel2.setText("Harga");

        nama_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_menuActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Harga", "kategori"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        nama_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_idActionPerformed(evt);
            }
        });

        jLabel4.setText("Kategori");

        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih", "makanan", "minuman" }));
        kategori.setToolTipText("");
        kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btntambah)
                        .addGap(43, 43, 43)
                        .addComponent(btnedit)
                        .addGap(37, 37, 37)
                        .addComponent(btnhapus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(nama_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(nama_id)
                            .addComponent(kategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nama_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnedit)
                    .addComponent(btnhapus))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nama_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_menuActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
    int row = tabel.getSelectedRow();
    if (row != -1) {
        String id = (String) tabel.getValueAt(row, 0);  // Ambil ID dari baris yang dipilih
        
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
                String query = "DELETE FROM menu WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, id);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Data berhasil dihapus!");
                    loadData();  // Load data setelah hapus
                    model.removeRow(row);
                } else {
                    System.out.println("Gagal menghapus data!");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    } else {
        System.out.println("Pilih baris yang ingin dihapus!");
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
       String id = nama_id.getText();
    String nama = nama_menu.getText();
    String hargaText = harga.getText();
    String kategoriText = (String) kategori.getSelectedItem();

    if (!id.isEmpty() && !nama.isEmpty() && !hargaText.isEmpty() && !kategoriText.equals("pilih")) {
        try {
            double hargaValue = Double.parseDouble(hargaText);

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
                String query = "INSERT INTO menu (id, nama_menu, harga, kategori) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, id);
                pst.setString(2, nama);
                pst.setDouble(3, hargaValue);
                pst.setString(4, kategoriText);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Data berhasil disimpan!");
                    loadData();  // Load data setelah menyimpan
                    nama_id.setText("");
                    nama_menu.setText("");
                    harga.setText("");
                    kategori.setSelectedIndex(0);
                } else {
                    System.out.println("Gagal menyimpan data!");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format harga salah!");
        }
    } else {
        System.out.println("Harap isi semua field dengan benar!");
    }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        int row = tabel.getSelectedRow();
    if (row != -1) {
        String id = (String) tabel.getValueAt(row, 0);  // Ambil ID dari baris yang dipilih
        String nama = nama_menu.getText();
        String hargaText = harga.getText();
        String kategoriText = (String) kategori.getSelectedItem();

        if (!nama.isEmpty() && !hargaText.isEmpty() && !kategoriText.equals("pilih")) {
            try {
                double hargaValue = Double.parseDouble(hargaText);

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
                    String query = "UPDATE menu SET nama_menu = ?, harga = ?, kategori = ? WHERE id = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, nama);
                    pst.setDouble(2, hargaValue);
                    pst.setString(3, kategoriText);
                    pst.setString(4, id);
                    
                    int rowsAffected = pst.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        System.out.println("Data berhasil diedit!");
                        loadData();  // Load data setelah edit
                        model.setValueAt(nama, row, 1);
                        model.setValueAt(hargaValue, row, 2);
                        model.setValueAt(kategoriText, row, 3);
                        
                        nama_id.setText("");
                        nama_menu.setText("");
                        harga.setText("");
                        kategori.setSelectedIndex(0);
                    } else {
                        System.out.println("Gagal mengedit data!");
                    }
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Format harga salah!");
            }
        } else {
            System.out.println("Harap isi semua field dengan benar!");
        }
    } else {
        System.out.println("Pilih baris yang ingin diedit!");
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategoriActionPerformed

    private void nama_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_idActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTextField nama_id;
    private javax.swing.JTextField nama_menu;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}