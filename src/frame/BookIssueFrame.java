package frame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.BatchBean;
import Bean.BookIssueBean;
import Bean.BooksBean;
import Bean.DatabaseManager;
import Bean.DepartmentBean;
import Bean.ProgramBean;
import Bean.StudentsBean;
import javax.swing.JOptionPane;

/**
 *
 * @author Isra Khan
 */
public class BookIssueFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookIssueFrame
     */
    public BookIssueFrame() {
          java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
   
        
        initComponents();
        getDepartments();
        getDepartment();
      
 
     
        
        
    }
    
    
    private void getDepartments(){
        try{
      java.util.Vector v= DatabaseManager.getDepartment();
      
            DepartmentComboBox.removeAllItems();
      
        for(int i=0; i<v.size(); i++){
            DepartmentComboBox.addItem(v.elementAt(i));
        
        
        }
        }catch(Exception e){ e.printStackTrace();}
    
    }
    
    private void getPrograms(){
          
        DepartmentBean bean=(DepartmentBean)DepartmentComboBox.getSelectedItem();
        if(bean==null) return;
      
           try{
        java.util.Vector v =DatabaseManager.getProgram(bean.getDeptId());
            ProgramComboBox.removeAllItems();
           for(int i=0; i<v.size(); i++ ){
                ProgramComboBox.addItem(v.elementAt(i));
                    
        }
       
            
       }catch(Exception e){
                e.printStackTrace();
            }
    }//method
            
    
    private void getBatch(){
        ProgramBean bean=(ProgramBean) ProgramComboBox.getSelectedItem();  
        if(bean==null)return;
        try{
     java.util.Vector v=DatabaseManager.getBatch(bean.getProgId());         

      BatchYearComboBox.removeAllItems();      
     for(int i=0; i<v.size(); i++){
         BatchYearComboBox.addItem(v.elementAt(i));
     
     }
        }catch(Exception e){e.printStackTrace();}
  
    }
    
      private void getShiftAndGroup(){
      
           BatchBean bean=(BatchBean)BatchYearComboBox.getSelectedItem();
          if(bean==null)return;
     
        try{
  
            ShiftTextField.setText(bean.getShift());
            GroupDescTextField.setText(bean.getGroupDesc());
    
      
        }catch(Exception e){e.printStackTrace();}
  
    }
      
      private void getStudents(){
          BatchBean bean=(BatchBean) BatchYearComboBox.getSelectedItem();
          if(bean==null)return;
         RollNoComboBox.removeAllItems();
         try{
             java.util.Vector v=DatabaseManager.getStudent(bean.getBatchId());
         
         for(int i=0; i<v.size(); i++){
             RollNoComboBox.addItem(v.elementAt(i));
         
         }
      }catch(Exception e){e.printStackTrace();}
      
      
      
      }
      
      
      
      private void StdInformation(){
         
      StudentsBean bean= (StudentsBean) RollNoComboBox.getSelectedItem();
      if(bean==null)return;
      
      try{
     StdIdTextField.setText(""+bean.getStdId());
     NameTextField.setText(bean.getStdName());
     FatherNameTextField.setText(bean.getFName());
     SurnameTextField.setText(bean.getSurname());
      }catch(Exception e){e.printStackTrace();}
    
      
      
      }
    
    
    
      private void getBooks(){
    
        
             DepartmentBean bean1= (DepartmentBean)DeptComboBox.getSelectedItem() ;
            if(bean1==null)return;
          
             
             
                try{
                    java.util.Vector v=DatabaseManager.getBooks(bean1.getDeptId());
                        BooksComboBox.removeAllItems();
                    for(int i=0; i<v.size(); i++){
                    BooksComboBox.addItem(v.elementAt(i)); 
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
    
      }
      
      
    
    
    
    
    private void getDepartment(){
        try{
      java.util.Vector v= DatabaseManager.getDepartment();
      
           
          DeptComboBox.removeAllItems();
        for(int i=0; i<v.size(); i++){
           
           DeptComboBox.addItem(v.elementAt(i));
        
        
        }
        }catch(Exception e){ e.printStackTrace();}
    
    }
    
    private void BookAuthor(){
    
           BooksBean bean=(BooksBean)BooksComboBox.getSelectedItem();
          if(bean==null)return;
     
        try{
  
          AuthorTextField.setText(bean.getAuthor());
    
      
        }catch(Exception e){e.printStackTrace();}
    
    
    
    
    }
            
           
    
    
    
     
 private void getIssueDate(){
 
      StudentsBean bean1=(StudentsBean)RollNoComboBox.getSelectedItem();
            if(bean1==null) return;
     
    BooksBean bean=(BooksBean) BooksComboBox.getSelectedItem();
         if(bean==null)return;



 try{
 java.util.Vector v=DatabaseManager.getBookIssueDate(bean.getBookId(),bean1.getStdId());
this.IssueDateList.setListData(v); 
 } catch(Exception e){e.printStackTrace();}
 
 }
 
 private void clear(){
 
   
     BookIssueIdTextField.setText("");
   
     DateOfIssueTextField.setText("");
   
     FineTextField.setText("");
   
     DateOfReturnTextField.setText("");
   
     RemarksTextArea.setText("");
     
 }
 
 

 
 
     private void deleteBooksIssue(){
   
       BookIssueBean bean=(BookIssueBean) IssueDateList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteBookIssueDate(bean.getIssueId());
                if(rows>=1){
                getIssueDate();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
            
        }//book delete
     
     public void addIssueBook(){
         
        StudentsBean bean1=(StudentsBean)RollNoComboBox.getSelectedItem();
            if(bean1==null) return;
     
    BooksBean bean=(BooksBean) BooksComboBox.getSelectedItem();
         if(bean==null)return;
            
               
               
        
             String dateOfReturn=DateOfReturnTextField.getText();
             String dateOfIssue=DateOfIssueTextField.getText();
             String fine=FineTextField.getText();
            String Remarks=RemarksTextArea.getText();
            
            try{
            int rows=DatabaseManager.addIssueBook(bean1.getStdId(),bean.getBookId(),dateOfIssue,dateOfReturn,fine,Remarks);
          
                if(rows>=1){
                        getIssueDate();
                        clear();
                        JOptionPane.showMessageDialog(this," Records Saved");
                              
           
                
                }//if
                }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
               
    }//method addbook
      public void updateIssueBook(){
         
        StudentsBean bean1=(StudentsBean)RollNoComboBox.getSelectedItem();
            if(bean1==null) return;
     
    BooksBean bean=(BooksBean) BooksComboBox.getSelectedItem();
         if(bean==null)return;
            
               
               
             int bookIssueId=Integer.parseInt(BookIssueIdTextField.getText());
             String dateOfReturn=DateOfReturnTextField.getText();
             String dateOfIssue=DateOfIssueTextField.getText();
             String fine=FineTextField.getText();
            String remarks=RemarksTextArea.getText();
            
            try{
            int rows=DatabaseManager.updateIssueBook(bean.getBookId(),bean1.getStdId(),bookIssueId,dateOfIssue,dateOfReturn,fine,remarks);
          
                if(rows>=1){
                        getIssueDate();
                        clear();
                        JOptionPane.showMessageDialog(this," Records Updated");
                              
           
                
                }//if
                }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
               
    }//method updatebook
     
     
         
         
         
         
     
     
     
     
     
             
             
           
             
             

       

             
             
             
 
 
 
 
 
 
 
 
 
 
 
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BookIssueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        StdIdLabel = new javax.swing.JLabel();
        RollNoLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        FatherNameLabel = new javax.swing.JLabel();
        SurnameLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        DepartmentComboBox = new javax.swing.JComboBox();
        ProgramComboBox = new javax.swing.JComboBox();
        BatchYearComboBox = new javax.swing.JComboBox();
        ShiftTextField = new javax.swing.JTextField();
        GroupDescTextField = new javax.swing.JTextField();
        BookIssueIdTextField = new javax.swing.JTextField();
        FineLabel = new javax.swing.JLabel();
        RollNoComboBox = new javax.swing.JComboBox();
        NameTextField = new javax.swing.JTextField();
        FatherNameTextField = new javax.swing.JTextField();
        SurnameTextField = new javax.swing.JTextField();
        DeptComboBox = new javax.swing.JComboBox();
        BooksComboBox = new javax.swing.JComboBox();
        BookIssueIdLabel = new javax.swing.JLabel();
        AuthorTextField = new javax.swing.JTextField();
        StdIdTextField = new javax.swing.JTextField();
        DateOfIssueLabel = new javax.swing.JLabel();
        DateOfIssueTextField = new javax.swing.JTextField();
        FineTextField = new javax.swing.JTextField();
        DateOfReturnLabel = new javax.swing.JLabel();
        DateOfReturnTextField = new javax.swing.JTextField();
        RemarksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();
        IssueDateLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IssueDateList = new javax.swing.JList();
        BackButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BookIssueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookIssueLabel.setText("Book Issue");
        getContentPane().add(BookIssueLabel);
        BookIssueLabel.setBounds(226, 4, 191, 31);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Department");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(31, 71, 83, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Program");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(54, 100, 60, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Batch");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(74, 161, 40, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(294, 132, 0, 0);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Shift");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(281, 138, 32, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Group");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(368, 132, 43, 17);

        StdIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        StdIdLabel.setText("Student Id");
        getContentPane().add(StdIdLabel);
        StdIdLabel.setBounds(38, 230, 76, 17);

        RollNoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RollNoLabel.setText("Roll Number");
        getContentPane().add(RollNoLabel);
        RollNoLabel.setBounds(234, 202, 85, 17);

        NameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NameLabel.setText("Name");
        getContentPane().add(NameLabel);
        NameLabel.setBounds(74, 269, 40, 17);

        FatherNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FatherNameLabel.setText("Father Name");
        getContentPane().add(FatherNameLabel);
        FatherNameLabel.setBounds(25, 316, 89, 17);

        SurnameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SurnameLabel.setText("Surname");
        getContentPane().add(SurnameLabel);
        SurnameLabel.setBounds(52, 365, 62, 17);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Department");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(31, 401, 83, 17);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Books");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(71, 444, 43, 17);

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuthorLabel.setText("Author");
        getContentPane().add(AuthorLabel);
        AuthorLabel.setBounds(65, 481, 49, 17);

        DepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DepartmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DepartmentComboBox);
        DepartmentComboBox.setBounds(171, 53, 257, 30);

        ProgramComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProgramComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgramComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ProgramComboBox);
        ProgramComboBox.setBounds(171, 94, 257, 32);

        BatchYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BatchYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(BatchYearComboBox);
        BatchYearComboBox.setBounds(171, 161, 77, 30);
        getContentPane().add(ShiftTextField);
        ShiftTextField.setBounds(254, 160, 80, 30);
        getContentPane().add(GroupDescTextField);
        GroupDescTextField.setBounds(340, 160, 88, 30);
        getContentPane().add(BookIssueIdTextField);
        BookIssueIdTextField.setBounds(148, 517, 65, 30);

        FineLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FineLabel.setText("Fine");
        getContentPane().add(FineLabel);
        FineLabel.setBounds(470, 100, 55, 17);

        RollNoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        RollNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollNoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(RollNoComboBox);
        RollNoComboBox.setBounds(234, 230, 152, 30);
        getContentPane().add(NameTextField);
        NameTextField.setBounds(148, 265, 300, 28);
        getContentPane().add(FatherNameTextField);
        FatherNameTextField.setBounds(148, 311, 300, 31);
        getContentPane().add(SurnameTextField);
        SurnameTextField.setBounds(148, 360, 300, 30);

        DeptComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DeptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DeptComboBox);
        DeptComboBox.setBounds(148, 396, 300, 31);

        BooksComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BooksComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BooksComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(BooksComboBox);
        BooksComboBox.setBounds(148, 438, 300, 32);

        BookIssueIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BookIssueIdLabel.setText("Book Issue Id");
        getContentPane().add(BookIssueIdLabel);
        BookIssueIdLabel.setBounds(16, 517, 98, 17);
        getContentPane().add(AuthorTextField);
        AuthorTextField.setBounds(148, 476, 300, 30);
        getContentPane().add(StdIdTextField);
        StdIdTextField.setBounds(148, 230, 68, 30);

        DateOfIssueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DateOfIssueLabel.setText("Date of Issue");
        getContentPane().add(DateOfIssueLabel);
        DateOfIssueLabel.setBounds(440, 60, 92, 17);
        getContentPane().add(DateOfIssueTextField);
        DateOfIssueTextField.setBounds(580, 60, 150, 30);

        FineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FineTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FineTextField);
        FineTextField.setBounds(582, 100, 150, 30);

        DateOfReturnLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DateOfReturnLabel.setText("Date of return");
        getContentPane().add(DateOfReturnLabel);
        DateOfReturnLabel.setBounds(20, 560, 98, 17);
        getContentPane().add(DateOfReturnTextField);
        DateOfReturnTextField.setBounds(150, 560, 278, 29);

        RemarksLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemarksLabel.setText("Remarks");
        getContentPane().add(RemarksLabel);
        RemarksLabel.setBounds(140, 600, 60, 17);

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane1.setViewportView(RemarksTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 620, 278, 96);

        IssueDateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IssueDateLabel.setText("Issue Date");
        getContentPane().add(IssueDateLabel);
        IssueDateLabel.setBounds(780, 20, 98, 22);

        IssueDateList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                IssueDateListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(IssueDateList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(770, 50, 136, 680);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(780, 740, 136, 37);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(140, 720, 63, 23);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(210, 720, 63, 23);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton);
        UpdateButton.setBounds(280, 720, 67, 23);

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(350, 720, 67, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DepartmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentComboBoxActionPerformed
            getPrograms();
    }//GEN-LAST:event_DepartmentComboBoxActionPerformed

    private void ProgramComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramComboBoxActionPerformed
  getBatch();
    }//GEN-LAST:event_ProgramComboBoxActionPerformed

    private void BatchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchYearComboBoxActionPerformed
          getShiftAndGroup();
          getStudents();
    }//GEN-LAST:event_BatchYearComboBoxActionPerformed

    private void RollNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RollNoComboBoxActionPerformed
     StdInformation();
    }//GEN-LAST:event_RollNoComboBoxActionPerformed

    private void DeptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptComboBoxActionPerformed
    getBooks();
    }//GEN-LAST:event_DeptComboBoxActionPerformed

    private void BooksComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BooksComboBoxActionPerformed
       getIssueDate();
        
        BookAuthor();
       
     
     
    }//GEN-LAST:event_BooksComboBoxActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
     clear();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        hide();
               
    }//GEN-LAST:event_BackButtonActionPerformed

    private void FineTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FineTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FineTextFieldActionPerformed

    private void IssueDateListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_IssueDateListValueChanged
             BookIssueBean bean=(BookIssueBean)IssueDateList.getSelectedValue();
            if(bean==null)return;
            
              BookIssueIdTextField.setText(""+bean.getIssueId());
               DateOfReturnTextField.setText(Decode.dateFormat(bean.getDataOfReturn()));
               DateOfIssueTextField.setText(Decode.dateFormat(bean.getDateOfIssue()));
               FineTextField.setText(""+bean.getFineAmount());
               RemarksTextArea.setText(bean.getRemarks());
            
    }//GEN-LAST:event_IssueDateListValueChanged

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
   deleteBooksIssue();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        addIssueBook();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
            updateIssueBook();
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
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookIssueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookIssueFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JTextField AuthorTextField;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox BatchYearComboBox;
    private javax.swing.JLabel BookIssueIdLabel;
    private javax.swing.JTextField BookIssueIdTextField;
    private javax.swing.JLabel BookIssueLabel;
    private javax.swing.JComboBox BooksComboBox;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel DateOfIssueLabel;
    private javax.swing.JTextField DateOfIssueTextField;
    private javax.swing.JLabel DateOfReturnLabel;
    private javax.swing.JTextField DateOfReturnTextField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox DepartmentComboBox;
    private javax.swing.JComboBox DeptComboBox;
    private javax.swing.JLabel FatherNameLabel;
    private javax.swing.JTextField FatherNameTextField;
    private javax.swing.JLabel FineLabel;
    private javax.swing.JTextField FineTextField;
    private javax.swing.JTextField GroupDescTextField;
    private javax.swing.JLabel IssueDateLabel;
    private javax.swing.JList IssueDateList;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JComboBox ProgramComboBox;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JComboBox RollNoComboBox;
    private javax.swing.JLabel RollNoLabel;
    private javax.swing.JTextField ShiftTextField;
    private javax.swing.JLabel StdIdLabel;
    private javax.swing.JTextField StdIdTextField;
    private javax.swing.JLabel SurnameLabel;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
