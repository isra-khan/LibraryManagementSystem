/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import Bean.BookCategoryBean;
import Bean.BooksBean;
import Bean.DatabaseManager;
import Bean.DepartmentBean;
import javax.swing.JOptionPane;

/**
 *
 * @author Isra Khan
 */
public class BooksFrame extends javax.swing.JFrame {

  
    public BooksFrame() {
        initComponents();
        
         java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        
        getBookCategory();
        getDepartment();
       
        
    }
    
    private void getBookCategory(){
        BookCategoryComboBox.removeAllItems();
            try{
            java.util.Vector v=DatabaseManager.getBookCategory();
        for(int i=0; i<v.size(); i++){
                BookCategoryComboBox.addItem(v.elementAt(i));
        
        }//for loop
        
            }//try
            catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
            }
    }//method
    
    
    
    private void getDepartment(){
        try{
            java.util.Vector v=DatabaseManager.getDepartment();
            DepartmentComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
               DepartmentComboBox.addItem(v.elementAt(i));
                
                }
            
        }//try
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error:"+e.getMessage());
        }
    
    }
    
    
    
          private void getBooks(){
    
             BookCategoryBean bean= (BookCategoryBean)BookCategoryComboBox.getSelectedItem() ;
             if(bean==null)return;
            
             DepartmentBean bean1= (DepartmentBean)DepartmentComboBox.getSelectedItem() ;
             if(bean1==null)return;
             
             
                try{
                    java.util.Vector v=DatabaseManager.getBooks(bean.getBookCategoryId(),bean1.getDeptId());
                    BookList.setListData(v); 
                } catch(Exception e){
                    e.printStackTrace();
                }
 
 }  
          
          private void clear(){
                   BookIdTextField.setText("");
                   BookTitleTextField.setText("");
                   AuthorTextField.setText("");
                   EditionTextField.setText("");
                   PublishingYearTextField.setText("");
                   PlaceOfPublishTextField.setText("");
                   PriceTextField.setText("");
                   PurchaseFromTextField.setText("");
                   ISBNTextField.setText("");
                   AccessNumberTextField.setText("");
                   QuantityTextField.setText("");
                   PagesTextField.setText("");
                   PurchaseDateTextField.setText("");
                   RemarksTextArea.setText("");
           
          }//clear
          
         
              
              
             private void deleteBooks(){
   
       BooksBean bean=(BooksBean) BookList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteDepartment(bean.getBookId());
                if(rows>=1){
                getBooks();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
            
        }//Department delete
             
             
             private void updateBooks(){
                 
                 
                  BooksBean beans=(BooksBean) BookList.getSelectedValue();
                 BookCategoryBean bean= (BookCategoryBean)BookCategoryComboBox.getSelectedItem() ;
                DepartmentBean bean1= (DepartmentBean)DepartmentComboBox.getSelectedItem() ;
             
                int bookId=Integer.parseInt(BookIdTextField.getText());
                String bookTitle= BookTitleTextField.getText();
                String Author=AuthorTextField.getText();
                String Edition= EditionTextField.getText();
                int PublishingYear=Integer.parseInt(PublishingYearTextField.getText());
                String PlaceOfPublish=PlaceOfPublishTextField.getText();
                String Price=PriceTextField.getText();
                String PurchaseFrom=PurchaseFromTextField.getText();
                int Isbn=Integer.parseInt(ISBNTextField.getText());
                int AccessNumber=Integer.parseInt(AccessNumberTextField.getText());
                int Quantity= Integer.parseInt(QuantityTextField.getText());
                int Pages=Integer.parseInt(PagesTextField.getText());
                String purchaseDate= PurchaseDateTextField.getText();
                String remarks= RemarksTextArea.getText();
                      
                      
           
         
                if(bean==null) return;
         
            try{
            
            int rows=DatabaseManager.updateBooks(beans.getBookId(),bean.getBookCategoryId(),bean1.getDeptId(), bookTitle, Author,Edition, PublishingYear,PlaceOfPublish, Price, PurchaseFrom, Isbn,AccessNumber,  Quantity, Pages,purchaseDate,remarks);
            if(rows>=1){
                getBooks();
                clear();
                JOptionPane.showMessageDialog(this,rows+"Records Updated");
            }
            } catch(Exception e){
               JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage()); 
                
            }
            
                  
             
             
             
             
             
             
             }
             
          
          
          
          
          

                  
                  
     
          
       
          
    
    
   
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BookLabel = new javax.swing.JLabel();
        BookCategoryLabel = new javax.swing.JLabel();
        BookCategoryComboBox = new javax.swing.JComboBox();
        BooksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookList = new javax.swing.JList();
        DepartmentLabel = new javax.swing.JLabel();
        DepartmentComboBox = new javax.swing.JComboBox();
        BookIdLabel = new javax.swing.JLabel();
        BookIdTextField = new javax.swing.JTextField();
        BookTitleLabel = new javax.swing.JLabel();
        BookTitleTextField = new javax.swing.JTextField();
        AuthorLabel = new javax.swing.JLabel();
        AuthorTextField = new javax.swing.JTextField();
        EditionLabel = new javax.swing.JLabel();
        EditionTextField = new javax.swing.JTextField();
        PublishingYearLabel = new javax.swing.JLabel();
        PublishingYearTextField = new javax.swing.JTextField();
        PlaceOfPublishLabel = new javax.swing.JLabel();
        PlaceOfPublishTextField = new javax.swing.JTextField();
        PriceLabel = new javax.swing.JLabel();
        PriceTextField = new javax.swing.JTextField();
        PurchaseFromLabel = new javax.swing.JLabel();
        PurchaseFromTextField = new javax.swing.JTextField();
        ISBNLabel = new javax.swing.JLabel();
        ISBNTextField = new javax.swing.JTextField();
        AccessNumberLabel = new javax.swing.JLabel();
        AccessNumberTextField = new javax.swing.JTextField();
        QuantityLabel = new javax.swing.JLabel();
        QuantityTextField = new javax.swing.JTextField();
        PagesLabel = new javax.swing.JLabel();
        PagesTextField = new javax.swing.JTextField();
        PurchaseDateLabel = new javax.swing.JLabel();
        PurchaseDateTextField = new javax.swing.JTextField();
        BackButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BookLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookLabel.setText("Books");

        BookCategoryLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookCategoryLabel.setText("Book Category");

        BookCategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookCategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookCategoryComboBoxActionPerformed(evt);
            }
        });

        BooksLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BooksLabel.setText("Books");

        BookList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                BookListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(BookList);

        DepartmentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DepartmentLabel.setText("Department");

        DepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DepartmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentComboBoxActionPerformed(evt);
            }
        });

        BookIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookIdLabel.setText("Book Id");

        BookTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookTitleLabel.setText("Book Title");

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuthorLabel.setText("Author");

        EditionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EditionLabel.setText("Edition");

        PublishingYearLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PublishingYearLabel.setText("Publishing Year");

        PlaceOfPublishLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PlaceOfPublishLabel.setText("Place of publish");

        PriceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PriceLabel.setText("Price");

        PurchaseFromLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PurchaseFromLabel.setText("Purchase From");

        ISBNLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ISBNLabel.setText("ISBN");

        AccessNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AccessNumberLabel.setText("Access Number");

        QuantityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        QuantityLabel.setText("Quantity");

        PagesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PagesLabel.setText("Pages");

        PurchaseDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PurchaseDateLabel.setText("Purchase Date");

        PurchaseDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseDateTextFieldActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Remarks");

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane2.setViewportView(RemarksTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(BookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(525, 525, 525)
                .addComponent(BooksLabel))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(BookCategoryLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(DepartmentLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(BookIdLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(BookTitleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(AuthorLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(EditionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(PublishingYearLabel))
                    .addComponent(PlaceOfPublishLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(PriceLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(PurchaseFromLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(ISBNLabel))
                    .addComponent(AccessNumberLabel))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublishingYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlaceOfPublishTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PurchaseFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccessNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AuthorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(QuantityLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(PagesLabel))
                    .addComponent(PurchaseDateLabel))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PurchaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BooksLabel)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BookCategoryLabel)
                        .addGap(33, 33, 33)
                        .addComponent(DepartmentLabel)
                        .addGap(33, 33, 33)
                        .addComponent(BookIdLabel)
                        .addGap(23, 23, 23)
                        .addComponent(BookTitleLabel)
                        .addGap(44, 44, 44)
                        .addComponent(AuthorLabel)
                        .addGap(27, 27, 27)
                        .addComponent(EditionLabel)
                        .addGap(26, 26, 26)
                        .addComponent(PublishingYearLabel)
                        .addGap(24, 24, 24)
                        .addComponent(PlaceOfPublishLabel)
                        .addGap(19, 19, 19)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(PurchaseFromLabel)
                        .addGap(19, 19, 19)
                        .addComponent(ISBNLabel)
                        .addGap(19, 19, 19)
                        .addComponent(AccessNumberLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BookCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(DepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(BookIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(BookTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(AuthorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(EditionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(PublishingYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(PlaceOfPublishTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(PurchaseFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(ISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(AccessNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(QuantityLabel)
                        .addGap(43, 43, 43)
                        .addComponent(PagesLabel)
                        .addGap(43, 43, 43)
                        .addComponent(PurchaseDateLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PurchaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
       clear();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DepartmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentComboBoxActionPerformed
        getBooks();
    }//GEN-LAST:event_DepartmentComboBoxActionPerformed

    private void BookCategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookCategoryComboBoxActionPerformed
    
    }//GEN-LAST:event_BookCategoryComboBoxActionPerformed

    private void BookListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_BookListValueChanged
            BooksBean bean=(BooksBean)BookList.getSelectedValue();
                    if(bean==null)return;
                    BookIdTextField.setText(""+bean.getBookId());
                    BookTitleTextField.setText(bean.getBookTitle());
                   AuthorTextField.setText(bean.getAuthor());
                   EditionTextField.setText(bean.getEdition());
                   PublishingYearTextField.setText(""+bean.getPublishingYear());
                   PlaceOfPublishTextField.setText(bean.getPlaceOfPublish());
                   PriceTextField.setText(bean.getPrice());
                   PurchaseFromTextField.setText(bean.getPurchaseFrom());
                   ISBNTextField.setText(""+bean.getIsbn());
                   AccessNumberTextField.setText(""+bean.getAccessNo());
                   QuantityTextField.setText(""+bean.getQuantity());
                   PagesTextField.setText(""+bean.getPages());
                   PurchaseDateTextField.setText(""+bean.getPurchaseDate());
                   RemarksTextArea.setText(bean.getRemarks());
                     
    }//GEN-LAST:event_BookListValueChanged

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
                hide();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void PurchaseDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PurchaseDateTextFieldActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
      addBooks();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
      deleteBooks();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
            updateBooks();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    
    private void addBooks(){
              
                BookCategoryBean bean= (BookCategoryBean)BookCategoryComboBox.getSelectedItem() ;
                DepartmentBean bean1= (DepartmentBean)DepartmentComboBox.getSelectedItem() ;
             
        
                String bookTitle= BookTitleTextField.getText();
                String Author=AuthorTextField.getText();
                String Edition= EditionTextField.getText();
                int PublishingYear=Integer.parseInt(PublishingYearTextField.getText());
                String PlaceOfPublish=PlaceOfPublishTextField.getText();
                String Price=PriceTextField.getText();
                String PurchaseFrom=PurchaseFromTextField.getText();
                int Isbn=Integer.parseInt(ISBNTextField.getText());
                int AccessNumber=Integer.parseInt(AccessNumberTextField.getText());
                int Quantity= Integer.parseInt(QuantityTextField.getText());
                int Pages=Integer.parseInt(PagesTextField.getText());
                String purchaseDate= PurchaseDateTextField.getText();
                String remarks= RemarksTextArea.getText();
                
                    
                     
                  try{
                  int rows=DatabaseManager.addBooks(bean.getBookCategoryId(),bean1.getDeptId(),bookTitle,Author,Edition,PublishingYear,PlaceOfPublish,Price,PurchaseFrom,Isbn,AccessNumber,Quantity,Pages,purchaseDate,remarks);
               
                  if(rows>=1){
                  getBooks();
                   clear();
                  JOptionPane.showMessageDialog(this,"Record Added");
                  
                  
                  }//rows
                    }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"ERROR:"+e.getMessage());
                    
                    }
}//method     
          
    
    
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
            java.util.logging.Logger.getLogger(BooksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccessNumberLabel;
    private javax.swing.JTextField AccessNumberTextField;
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JTextField AuthorTextField;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox BookCategoryComboBox;
    private javax.swing.JLabel BookCategoryLabel;
    private javax.swing.JLabel BookIdLabel;
    private javax.swing.JTextField BookIdTextField;
    private javax.swing.JLabel BookLabel;
    private javax.swing.JList BookList;
    private javax.swing.JLabel BookTitleLabel;
    private javax.swing.JTextField BookTitleTextField;
    private javax.swing.JLabel BooksLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox DepartmentComboBox;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JLabel EditionLabel;
    private javax.swing.JTextField EditionTextField;
    private javax.swing.JLabel ISBNLabel;
    private javax.swing.JTextField ISBNTextField;
    private javax.swing.JLabel PagesLabel;
    private javax.swing.JTextField PagesTextField;
    private javax.swing.JLabel PlaceOfPublishLabel;
    private javax.swing.JTextField PlaceOfPublishTextField;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JLabel PublishingYearLabel;
    private javax.swing.JTextField PublishingYearTextField;
    private javax.swing.JLabel PurchaseDateLabel;
    private javax.swing.JTextField PurchaseDateTextField;
    private javax.swing.JLabel PurchaseFromLabel;
    private javax.swing.JTextField PurchaseFromTextField;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField QuantityTextField;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
