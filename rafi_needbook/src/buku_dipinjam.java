/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.*;
import javax.swing.table.*;;

/**
 *
 * @author Lenovo
 */
public class buku_dipinjam extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    ResultSet RsSiswa = null;
    /**
     * Creates new form buku_dipinjam
     */
    public buku_dipinjam() {
        initComponents();
        tampilData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_buku = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        table_buku.setBackground(new java.awt.Color(255, 102, 102));
        table_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAMA SISWA", "JUDUL_BUKU"
            }
        ));
        table_buku.setGridColor(new java.awt.Color(255, 255, 255));
        table_buku.setSelectionBackground(new java.awt.Color(255, 102, 102));
        table_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_buku);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bukuMouseClicked
        
    }//GEN-LAST:event_table_bukuMouseClicked

    private void tampilData() {
        try{
            Object[] judul_kolom = {"ID", "NAMA_SISWA", "JUDUL_BUKU"};
            tableModel = new DefaultTableModel(null, judul_kolom);
            table_buku.setModel(tableModel);

            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            tableModel.getDataVector().removeAllElements();

            RsSiswa = stt.executeQuery("SELECT p.id AS id, s.username AS siswa, b.judul AS buku FROM peminjaman p JOIN siswa s ON p.siswa_id = s.id JOIN buku b ON p.book_id = b.id;");
            while(RsSiswa.next()){
                Object[] data = {
                    RsSiswa.getString("id"),
                    RsSiswa.getString("siswa"),
                    RsSiswa.getString("buku")
                };
                tableModel.addRow(data);
            }

            // Mengambil objek TableColumnModel dari tabel
            TableColumnModel columnModel = table_buku.getColumnModel();
            // Mengambil kolom pertama (indeks 0), yang merupakan kolom ID
            TableColumn kodeBukuColumn = columnModel.getColumn(0);
            // Mengatur lebar kolom ID menjadi 0 sehingga tidak terlihat di tabel
            kodeBukuColumn.setMinWidth(0);
            kodeBukuColumn.setMaxWidth(0);
            kodeBukuColumn.setPreferredWidth(0);

        }catch(Exception ex){
            System.err.println("error" + ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(buku_dipinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buku_dipinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buku_dipinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buku_dipinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buku_dipinjam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_buku;
    // End of variables declaration//GEN-END:variables
}
