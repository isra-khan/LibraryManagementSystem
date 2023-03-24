/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Isra Khan
 */
import java.sql.*;
import java.util.*;
public class DatabaseManager {
    
    private static Connection con;
    static{ try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection("jdbc:odbc:LibraryManagement");
    }catch(Exception e){
             e.printStackTrace();
         }//catch
        
    }//static
   public static Vector getFaculty()throws Exception {
       String query="Select Fac_id,Fac_name,remarks from Faculty" ;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    FacultyBean bean=new FacultyBean();
                    bean.setFacId(result.getInt("Fac_id"));
                    bean.setFacName(result.getString("Fac_name"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
   
  
     public static Vector getDepartment(int facId)throws Exception {
       String query="Select * from Department where Fac_id="+facId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    DepartmentBean bean=new DepartmentBean();
                    bean.setDeptId(result.getInt("Dept_id"));
                    bean.setFacId(result.getInt("Fac_id"));
                    bean.setDeptName(result.getString("Dept_name"));
                    bean.setRemarks(result.getString("remarks"));
                     v.addElement(bean);
            }//while
            
           
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
     }//end of method
     
     
      public static Vector getDepartment()throws Exception {
       String query="Select * from Department ";
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                   DepartmentBean bean= new DepartmentBean();
                     bean.setDeptId(result.getInt("Dept_id"));
                    bean.setFacId(result.getInt("Fac_id"));
                    bean.setDeptName(result.getString("Dept_name"));
                    bean.setRemarks(result.getString("remarks"));
                     v.addElement(bean);
                   
                        
         
                                                     
                
                
              
            }//while
            
           
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
     }//end of method
     
     
        
        
     
     
     
     
       public static Vector getProgram(int deptId)throws Exception {
       String query="Select * from Program where Dept_id="+deptId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    ProgramBean bean=new ProgramBean();
                    bean.setProgId(result.getInt("Prog_id"));
                    bean.setDeptId(result.getInt("Dept_id"));
                    bean.setProgName(result.getString("Prog_name"));
                    bean.setDurationInSem(result.getInt("Duration_in_sem"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
                    
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
   
     public static Vector getBatch(int progId)throws Exception {
       String query="Select * from Batch where Prog_id="+progId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    BatchBean bean=new BatchBean();
                    bean.setBatchId(result.getInt("Batch_id"));
                    bean.setProgId(result.getInt("Prog_id"));
                    bean.setBatchYear(result.getInt("Batch_year"));
                    bean.setShift(result.getString("shift"));
                    bean.setGroupDesc(result.getString("Group_desc"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
     
     
     
     
     

     
     
     
     
     
     
     
     
     
     
     
     
       public static Vector getStudent(int batchId)throws Exception {
       String query="Select * from Students where Batch_id="+batchId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    StudentsBean bean=new StudentsBean();
                        bean.setStdId(result.getInt("Std_id"));
                        
                          bean.setBatchId(result.getInt("Batch_id"));
                          bean.setStdName(result.getString("Std_name"));
                          bean.setFName(result.getString("fname"));
                          bean.setSurname(result.getString("surname"));
                          
                           bean.setRollNo(result.getString("rollno"));
                           bean.setShift(result.getString("shift"));
                           bean.setBatchYear(result.getInt("Batch_year"));
                           bean.setGroupDesc(result.getString("Group_desc"));                         
                          bean.setRemarks(result.getString("remarks"));
             
                    v.addElement(bean);
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
       
       public static Vector getBookCategory() throws Exception{
           String query="Select Cat_id,Cat_name,Remarks from  Book_Category";
            System.out.println(query);
                Statement st=null;
                ResultSet result =null;
                    try{
                        st=con.createStatement();   
                         result=st.executeQuery(query);
                         Vector v=new Vector();
                         while(result.next()){
                             BookCategoryBean bean=new BookCategoryBean();
                                    bean.setBookCategoryId(result.getInt("Cat_id"));
                                    bean.setBookCategory(result.getString("Cat_name"));
                                     bean.setRemarks(result.getString("remarks"));
                                     v.addElement(bean);
                                     
                         }//while loop
                         return v;
                    }//try
                    finally{
                            if(result!=null)result.close();
                            if(st!=null) st.close();
                        
                        
                    }
       }
       public static Vector getBooks(int catId,int deptId) throws Exception{
            
                
               String query="Select * from  Books where Cat_id= "+catId+"AND Dept_id="+deptId;
             
               
            System.out.println(query);
                Statement st=null;
                ResultSet result =null;
                    try{
                        st=con.createStatement();   
                         result=st.executeQuery(query);
                         Vector v=new Vector();
                         while(result.next()){
                             BooksBean bean=new BooksBean();
                                   bean.setBookId(result.getInt("Book_id"));
                                    bean.setCatId(result.getInt("Cat_id"));
                                    bean.setDeptId(result.getInt("Dept_id"));
                                    bean.setBookTitle(result.getString("Book_title"));
                                    bean.setAuthor(result.getString("author"));
                                    bean.setEdition(result.getString("edition"));
                                    bean.setPublishingYear(result.getInt("Publishing_Year"));
                                    
                                    bean.setPlaceOfPublish(result.getString("place_of_publish"));
                                    bean.setPrice(result.getString("price"));
                                    bean.setPurchaseFrom(result.getString("Purchase_from"));
                                    bean.setIsbn(result.getInt("ISBN"));
                                    bean.setAccessNo(result.getInt("Access_no"));
                                    bean.setQuantity(result.getInt("quantity"));
                                    bean.setPages(result.getInt("pages"));
                                    bean.setPurchaseDate(result.getString("Purchase_date"));
                                    bean.setRemarks(result.getString("remarks"));
                                    
                                     v.addElement(bean);
                                     
                         }//while loop
                         return v;
                    }//try
                    finally{
                            if(result!=null)result.close();
                            if(st!=null) st.close();
                    
         
                        
                        
                    }
                    
                    
       }
       
       
       
       
       
       
       
       
         public static Vector getBookIssueDate(int bookId,int stdId) throws Exception{
           String query="Select * from  Book_Issue where  Book_id="+bookId+" And  Std_id="+stdId;
            System.out.println(query);
                Statement st=null;
                ResultSet result =null;
                    try{
                        st=con.createStatement();   
                         result=st.executeQuery(query);
                         Vector v=new Vector();
                         while(result.next()){
                             BookIssueBean bean=new BookIssueBean();
                                    bean.setIssueId(result.getInt("Issue_id"));
                                    bean.setBookId(result.getInt("Book_id"));
                                   bean.setStdId(result.getInt("Std_id"));
                                   bean.setDateOfIssue(result.getDate("Date_of_issue"));
                                   bean.setdateOfReturn(result.getDate("Date_of_return"));
                                   bean.setFineAmount(result.getInt("Fine_Amount"));
                                   bean.setRemarks(result.getString("remarks"));
                                     v.addElement(bean);
                                     
                         }//while loop
                         return v;
                    }//try
                    finally{
                            if(result!=null)result.close();
                            if(st!=null) st.close();
       
       
                    }}
       
       
       
       
       
       
       
       
       
       
       
       
     public static Vector getBooks(int deptId) throws Exception{
            
                
               String query="Select * from  Books where Dept_id="+deptId;
             
               
            System.out.println(query);
                Statement st=null;
                ResultSet result =null;
                    try{
                        st=con.createStatement();   
                         result=st.executeQuery(query);
                         Vector v=new Vector();
                         while(result.next()){
                             BooksBean bean=new BooksBean();
                                   bean.setBookId(result.getInt("Book_id"));
                                    bean.setCatId(result.getInt("Cat_id"));
                                    bean.setDeptId(result.getInt("Dept_id"));
                                    bean.setBookTitle(result.getString("Book_title"));
                                    bean.setAuthor(result.getString("author"));
                                    bean.setEdition(result.getString("edition"));
                                    bean.setPublishingYear(result.getInt("Publishing_Year"));
                                    
                                    bean.setPlaceOfPublish(result.getString("place_of_publish"));
                                    bean.setPrice(result.getString("price"));
                                    bean.setPurchaseFrom(result.getString("Purchase_from"));
                                    bean.setIsbn(result.getInt("ISBN"));
                                    bean.setAccessNo(result.getInt("Access_no"));
                                    bean.setQuantity(result.getInt("quantity"));
                                    bean.setPages(result.getInt("pages"));
                                    bean.setPurchaseDate(result.getString("Purchase_date"));
                                    bean.setRemarks(result.getString("remarks"));
                                    
                                     v.addElement(bean);
                                     
                         }//while loop
                         return v;
                    }//try
                    finally{
                            if(result!=null)result.close();
                            if(st!=null) st.close();
                        
                        
                    }
       }
    
    
    
    

       
       
       
       
       public static int deletefaculty(int facId) throws Exception{
           String query="Delete from faculty where Fac_id="+facId;
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
       
       
           public static int deleteDepartment(int deptId) throws Exception{
           String query="Delete from Department where Dept_id="+deptId;
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
       
       
           
            public static int deleteProgram(int progId ) throws Exception{
           String query="Delete from Program where Prog_id="+progId;
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
            
        
          public static int deleteStudent (int stdId ) throws Exception{
           String query="Delete from Students where Std_id="+stdId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
    public static int deleteBatch (int batchId ) throws Exception{
           String query="Delete from Batch where Batch_id="+batchId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
    
      public static int deleteBookCategory ( int catId) throws Exception{
           String query="Delete from Book_Category where Cat_id="+catId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
      
      
     
          public static int deletebookId (int BookId ) throws Exception{
           String query="Delete from Books where  Book_id="+BookId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
  
            
           
    
         public static int deleteBookIssueDate (int IssueId ) throws Exception{
           String query="Delete from Book_Issue where  Issue_id="+IssueId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
    
    public static int addFaculty(String facName,String remarks) throws Exception{

        String query="Insert into Faculty(Fac_name,remarks)Values('"+facName+"','"+remarks+"')";
                    System.out.println(query);
                        
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
    
    
      public static int addDepartment(int facId,String deptName,String remarks) throws Exception{
        
            String query="Insert into Department(Fac_id,Dept_name,remarks)Values('"+facId+" ','"+deptName+"','"+remarks+"')";
                    
                    
                    System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
      }
           
             public static int addProgram(int deptId,String progName,String durationInSem,String remarks) throws Exception{
        
            String query="Insert into Program(Dept_id,Prog_name,Duration_in_sem,remarks)Values('"+deptId+"','"+progName+"','"+durationInSem+"','"+remarks+"')";
                    System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
    
    
      
      public static int addBatch(int progId, int batchYear,String remarks) throws Exception{
        
            String query="Insert into Batch(Prog_id,Batch_year,remarks)values('" +progId+"','"+batchYear+"','"+remarks+"')";
                    System.out.println(query);
                    
                       Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
           
            public static int addStudent(int batchId,String stdName, String fName,String surname,String rollNo,String remarks) throws Exception{
                    
            String query="Insert into Students(Batch_id,Std_name,fname,surname,rollno,remarks) Values('"+batchId+"','"+stdName+"','"+fName+"','"+surname+"','"+rollNo+"','"+remarks+"')";
             System.out.println(query);
                    
                        Statement st=null;
                        try{
           
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
            
                  public static int addIssueBook(int stdId,int bookId,String dateOfIssue,String dateOfReturn,String fine,String remarks) throws Exception{
                    
                      if(dateOfIssue.equals(""))dateOfIssue=null;
                      else
                          dateOfIssue="#"+dateOfIssue+"#";
                      
                          
                      if(dateOfReturn.equals(""))dateOfReturn=null;
                      else
                          dateOfReturn="#"+dateOfReturn+"#";
                      
                      
                      if(fine.equals(""))fine="0";
                      
            String query="Insert into Book_Issue(Book_id,Std_id,Date_of_issue,Date_of_return,Fine_Amount,remarks) Values("+bookId+","+stdId+","+dateOfIssue+","+dateOfReturn+","+fine+",'"+remarks+"')";
             System.out.println(query);
                    
                        Statement st=null;
                        try{
           
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
     
            
            
            
     
            public static int addBookCategory(String BookCategory,String remarks)throws Exception{
            String query="Insert into Book_Category(Cat_name,Remarks)Values('"+BookCategory+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
                try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                
                
                }
                finally{
                if(st!=null) st.close();
                }
            
            }
            
            public static int addBooks(int bookCategoryId,int deptId,String bookTitle, String author,String edition, int publishingYear,String placeOfPublish,String price,String purchaseFrom,int isbn, int accessNumber, int quantity,int pages,String purchaseDate,String remarks)throws Exception{
            String query="Insert into Books(Cat_id,Dept_id,Book_title,author,edition,Publishing_year,Place_of_publish,price,Purchase_from,ISBN,Access_no,quantity,pages,Purchase_date,remarks) Values('"+bookCategoryId+"','"+deptId+"','"+bookTitle+"','"+author+"','"+edition+"','"+publishingYear+"','"+placeOfPublish+"','"+price+"','"+purchaseFrom+"','"+isbn+"','"+accessNumber+"','"+quantity+"','"+pages+"','"+purchaseDate+"','"+remarks+"')";
            
            
            
                    
                
                  System.out.println(query);
            Statement st=null;
                try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                
                
                }
                finally{
                if(st!=null) st.close();
                }
            
            
            }
            
      
      public static int updateFaculty(int facId,String facName,String remarks) throws Exception{
          String query="update Faculty Set Fac_name='"+facName+"',remarks='"+remarks+"'where Fac_id="+facId;
      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
       
      
      public static int updateDepartment(int facId,int deptId,String deptName,String remarks) throws Exception{
                  String query="update Department Set Fac_id='"+facId +"',Dept_name='"+deptName+"',remarks='"+remarks+"' where Dept_id="+deptId;
      
           
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
         
                    
      public static int updateProgram(int deptId,int progId,String progName,int progDur,String remarks) throws Exception{
             String query="update Program Set Dept_id='"+deptId +"',Prog_name='"+progName+"',Duration_in_sem='"+progDur+"',remarks='"+remarks+"' where Prog_id="+progId;
      
      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
      
            public static int updateBatch(int progId,int batchId, int batchYear,String remarks) throws Exception{
                    String query="update Batch Set Prog_id='"+progId +"',Batch_year="+batchYear+",remarks='"+remarks+"' where batch_id="+batchId;

      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
        
      
                 public static int updateStudent(int batchId,int stdId,String stdName,String shift,String group,String surname ,String rollNo ,String fName,String remarks) throws Exception{
          String query = "update Student Set Batch_id='"+batchId+"',Std_name='"+stdName+"',shift='"+shift+"',group='"+group+"',surname='"+surname+"',rollno='"+rollNo+",fname="+fName+",'remarks="+remarks+"'where Std_id="+stdId;
                  
          

      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
                 
                 
        public static int updateBookCategory(int bookCategoryId,String catName,String remarks) throws Exception{
          String query="update Book_Category Set Cat_name='"+catName+"',remarks='"+remarks+"'where Cat_id="+bookCategoryId;
      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
        
           public static int updateBooks(int bookId,int bookCategoryId,int deptId,String bookTitle, String author,String edition, int publishingYear,String placeOfPublish,String price,String purchaseFrom,int isbn, int accessNumber, int quantity,int pages,String purchaseDate,String remarks) throws Exception{
          String query="update Books Set Cat_id="+bookCategoryId+",Dept_id="+deptId+",Book_title='"+bookTitle+"',author='"+author+"',edition='"+edition+"',Publishing_year="+publishingYear+",Place_of_publish='"+publishingYear+"',price='"+price+"',Purchase_from='"+purchaseFrom+"',ISBN="+isbn+",Access_no="+accessNumber+",quantity="+quantity+",pages="+pages+",Purchase_date='"+purchaseDate+"',remarks='"+remarks+"' where Book_id="+bookId;
          
      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
         public static int updateIssueBook(int bookIssueId,int stdId,int bookId,String dateOfIssue,String dateOfReturn,String fine, String remarks)throws Exception{
          
                  
                      if(dateOfIssue.equals(""))dateOfIssue=null;
                      else
                          dateOfIssue="#"+dateOfIssue+"#";
                      
                          
                      if(dateOfReturn.equals(""))dateOfReturn=null;
                      else
                          dateOfReturn="#"+dateOfReturn+"#";
                      
                      
                      
          if(fine.equals(""))fine="0";
                      
      String query="update Book_Issue Set Book_id="+bookId+",Std_id="+stdId+",Date_of_issue="+dateOfIssue+",Date_of_return="+dateOfReturn+",Fine_Amount="+fine+",remarks='"+remarks+"' where Issue_id="+bookIssueId;
              
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }      
        
                 

   
        
        
      
    

}//class
