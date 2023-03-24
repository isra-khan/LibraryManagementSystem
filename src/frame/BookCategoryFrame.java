package frame;

import Bean.BookCategoryBean;
import Bean.DatabaseManager;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isra Khan
 */
public class BookCategoryFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookCategoryFrame
     */
    public BookCategoryFrame() {
        initComponents();
         java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        BookCategoryIdTextField.setEditable(false);
        
        
        getBookCategory();
    }
    
    private void getBookCategory(){
        try{
            java.util.Vector v=DatabaseManager.getBookCategory();
                BookCategoriesList.setListData(v);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Error:"+e.getMessage());
                }//catch
                    
        
        }
    
    private void clear(){
    
       BookCategoryIdTextField.setText("");
      BookCategoryTextField.setText("");
      RemarksTextArea.setText("");
    
    
    }
    
    
    private void addBookCategory(){
            
            String BookCategory=BookCategoryTextField.getText();
            String Remarks=RemarksTextArea.getText();
            try{
            int rows=DatabaseManager.addBookCategory(BookCategory,Remarks);
          
                if(rows>=1){
                        getBookCategory();
                        clear();
                        JOptionPane.showMessageDialog(this," Records Saved");
                              
           
                
                }//if
                }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
               
    }//method addbook
    
           private void deleteBookCategory(){
   
       BookCategoryBean bean=(BookCategoryBean) BookCategoriesList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteBookCategory(bean.getBookCategoryId());
                if(rows>=1){
                getBookCategory();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
            
        }//bookcatgory delete
          
          private void updateBookCategory(){
               BookCategoryBean bean=(BookCategoryBean) BookCategoriesList.getSelectedValue();
           
         
                if(bean==null) return;
            String bookCategoryName=BookCategoryTextField.getText();
            String Remarks=RemarksTextArea.getText();
            try{
            
            int rows=DatabaseManager.updateBookCategory(bean.getBookCategoryId(),bookCategoryName,Remarks);
            if(rows>=1){
                getBookCategory();
                clear();
                JOptionPane.showMessageDialog(this,rows+"Records Updated");
            }
            } catch(Exception e){
               JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage()); 
                
            }
          }//class
          
          
          
          
              

    
 
        
    
    
    
    
    
    
    
    
    
    
 


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BooksCategoryLabel = new javax.swing.JLabel();
        BookCategoryTextField = new javax.swing.JTextField();
        BookCategoryIdLabel = new javax.swing.JLabel();
        BookCategoryIdTextField = new javax.swing.JTextField();
        BookCategoryLabel = new javax.swing.JLabel();
        RemarksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookCategoriesList = new javax.swing.JList();
        BookCategoriesLabel = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BooksCategoryLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BooksCategoryLabel.setText("Books Category");
        getContentPane().add(BooksCategoryLabel);
        BooksCategoryLabel.setBounds(216, 0, 159, 45);

        BookCategoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookCategoryTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(BookCategoryTextField);
        BookCategoryTextField.setBounds(226, 131, 283, 31);

        BookCategoryIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookCategoryIdLabel.setText("Book Category Id");
        getContentPane().add(BookCategoryIdLabel);
        BookCategoryIdLabel.setBounds(74, 69, 124, 17);
        getContentPane().add(BookCategoryIdTextField);
        BookCategoryIdTextField.setBounds(226, 69, 118, 32);

        BookCategoryLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookCategoryLabel.setText("Book Category");
        getContentPane().add(BookCategoryLabel);
        BookCategoryLabel.setBounds(94, 136, 104, 17);

        RemarksLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemarksLabel.setText("Remarks");
        getContentPane().add(RemarksLabel);
        RemarksLabel.setBounds(226, 206, 60, 17);

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane1.setViewportView(RemarksTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(226, 241, 283, 96);

        BookCategoriesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        BookCategoriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                BookCategoriesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(BookCategoriesList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(515, 69, 120, 268);

        BookCategoriesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookCategoriesLabel.setText("Book Categories");
        getContentPane().add(BookCategoriesLabel);
        BookCategoriesLabel.setBounds(511, 39, 114, 17);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(515, 343, 120, 29);

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(440, 343, 69, 29);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton);
        UpdateButton.setBounds(369, 343, 67, 29);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(300, 343, 63, 29);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(226, 343, 68, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookCategoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookCategoryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookCategoryTextFieldActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clear();
               
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void BookCategoriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_BookCategoriesListValueChanged
      BookCategoryBean bean= (BookCategoryBean)BookCategoriesList.getSelectedValue();
        if(bean==null) return;
            BookCategoryIdTextField.setText(""+bean.getBookCategoryId());
            BookCategoryTextField.setText(bean.getBookCategory());
            RemarksTextArea.setText(bean.getRemarks());
                   
       
    }//GEN-LAST:event_BookCategoriesListValueChanged

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
       hide();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        addBookCategory();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
    deleteBookCategory();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
  updateBookCategory();
    }//GEN-LAST:event_UpdateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BookCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookCategoryFrame().setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BookCategoriesLabel;
    private javax.swing.JList BookCategoriesList;
    private javax.swing.JLabel BookCategoryIdLabel;
    private javax.swing.JTextField BookCategoryIdTextField;
    private javax.swing.JLabel BookCategoryLabel;
    private javax.swing.JTextField BookCategoryTextField;
    private javax.swing.JLabel BooksCategoryLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
