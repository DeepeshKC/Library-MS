/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cp.lms.views;

import edu.cp.lms.controller.BookController;
import edu.cp.lms.modules.Book;
import edu.cp.lms.modules.Booking;
import edu.cp.lms.modules.User;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Deepesh
 */
public class Issuebook extends javax.swing.JPanel {

    /**
     * Creates new form Issuebook
     */
    public Issuebook() {
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

        jLabel2 = new javax.swing.JLabel();
        txtbookid = new javax.swing.JTextField();
        btnissue = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtreturndate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtissueddate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtborrowerid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtnoofcopies = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Issue Book"));

        jLabel2.setText("Book ID:");

        btnissue.setText("Issue");
        btnissue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnissueActionPerformed(evt);
            }
        });

        jLabel4.setText("Return Date(yyyy-mm-dd):");

        txtreturndate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreturndateActionPerformed(evt);
            }
        });

        jLabel5.setText("Issued Date(yyyy-mm-dd):");

        jLabel6.setText("Borrower ID:");

        jLabel7.setText("Number of copies:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbookid, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtreturndate)
                            .addComponent(txtissueddate)
                            .addComponent(txtborrowerid)
                            .addComponent(txtnoofcopies)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnissue)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtborrowerid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbookid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnoofcopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtissueddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtreturndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnissue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtreturndateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreturndateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreturndateActionPerformed

    private void btnissueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnissueActionPerformed
        try {
            // TODO add your handling code here:

            int bookid = Integer.parseInt(txtbookid.getText());
            String returndate = txtreturndate.getText();
            String issueddate = txtissueddate.getText();
            int borrowerid = Integer.parseInt(txtborrowerid.getText());
            int noofcopy = Integer.parseInt(txtnoofcopies.getText());

            Booking bk = new Booking();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            Date returnd = format.parse(returndate);
            Date issue = format.parse(issueddate);
            User u=new User();
            Book b=new Book();
            b.setId(bookid);
            u.setId(borrowerid);
            bk.setBookid(b);
            bk.setNoofcopies(noofcopy);
            bk.setActualreturneddate(null);
            bk.setPrice(null);
            bk.setStatus(null);

            bk.setReturndate(returnd);
            bk.setBorroweddate(issue);
            bk.setUserid(u);
           
            BookController bc = new BookController();
            int rs = bc.IssueBook(bk);

            int noofcopies = bc.getNoofcopies(b);
            int totalno = noofcopies - noofcopy;

            int done = bc.Addcopies(b);
            if (done != 0) {
                JOptionPane.showMessageDialog(null, "Sucessfully updated");
            } else {
                JOptionPane.showMessageDialog(null, "Not updated");
            }

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(Issuebook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnissueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnissue;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtborrowerid;
    private javax.swing.JTextField txtissueddate;
    private javax.swing.JTextField txtnoofcopies;
    private javax.swing.JTextField txtreturndate;
    // End of variables declaration//GEN-END:variables
}
