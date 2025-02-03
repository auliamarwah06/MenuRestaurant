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
import javax.swing.JOptionPane;





/**
 *
 * @author Aulia Marwah K
 */


public class MenuRestaurant extends javax.swing.JInternalFrame {
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
        // Mengatur ulang jumlah baris tabel menjadi 0 sebelum memuat data baru
        model.setRowCount(0); 
        
        // Membuka koneksi ke database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
            String query = "SELECT * FROM menu";  // Query untuk mengambil data dari tabel 'menu'
            PreparedStatement pst = conn.prepareStatement(query);  // Menyiapkan statement
            ResultSet rs = pst.executeQuery();  // Menjalankan query dan mendapatkan hasilnya

            // Melalui hasil query (ResultSet) dan mengisi data ke model tabel
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"), // ID dari hasil query
                    rs.getString("nama_menu"), // Nama menu
                    rs.getDouble("harga"), // Harga
                    rs.getString("kategori") // Kategori
                };
                model.addRow(row); // Menambahkan baris data ke model tabel
            }
        }
    } catch (SQLException e) {
        // Menampilkan pesan error jika terjadi SQL Exception
        JOptionPane.showMessageDialog(null, "SQL Exception: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(nama_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(kategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
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
int row = tabel.getSelectedRow();
    if (row != -1) {
        int id = (int) tabel.getValueAt(row, 0); // Ambil ID dari tabel yang dipilih

        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
                String query = "DELETE FROM menu WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, id);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    loadData();  // Memuat data setelah hapus
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Exception: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
String nama = nama_menu.getText();
    String hargaText = harga.getText();
    String kategoriText = (String) kategori.getSelectedItem();

    if (!nama.isEmpty() && !hargaText.isEmpty() && !kategoriText.equals("pilih")) {
        try {
            double hargaValue = Double.parseDouble(hargaText);

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
                String query = "INSERT INTO menu (nama_menu, harga, kategori) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, nama);
                pst.setDouble(2, hargaValue);
                pst.setString(3, kategoriText);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    loadData(); 
                    nama_menu.setText("");
                    harga.setText("");
                    kategori.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ISI DENGAN BENAR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format harga salah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Harap isi dengan benar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
int row = tabel.getSelectedRow();
    if (row != -1) {
        // Ambil ID dari tabel yang dipilih
        int id = (int) tabel.getValueAt(row, 0);
        // Ambil data dari tabel yang dipilih untuk dimasukkan ke dalam input fields
        String nama = (String) tabel.getValueAt(row, 1);
        String hargaText = String.valueOf(tabel.getValueAt(row, 2));
        String kategoriText = (String) tabel.getValueAt(row, 3);

        // Set data yang dipilih ke dalam input fields (text fields dan combo box)
        nama_menu.setText(nama);
        harga.setText(hargaText);
        kategori.setSelectedItem(kategoriText);

        // Jika data sudah diperbarui di input, lakukan pengeditan di database
        if (!nama.isEmpty() && !hargaText.isEmpty() && !kategoriText.equals("pilih")) {
            try {
                double hargaValue = Double.parseDouble(hargaText);

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "root")) {
                    String query = "UPDATE menu SET nama_menu = ?, harga = ?, kategori = ? WHERE id = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, nama);
                    pst.setDouble(2, hargaValue);
                    pst.setString(3, kategoriText);
                    pst.setInt(4, id);

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        loadData();  // Memuat data setelah edit
                        JOptionPane.showMessageDialog(null, "Data berhasil diedit!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal mengedit data!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ISI DENGAN BENAR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Format harga salah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Harap isi dengan benar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategoriActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTextField nama_menu;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}