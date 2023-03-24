/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Isra Khan
 */
public class BookCategoryBean {
    private int bookCategoryId;
    private String bookCategory;
    private String remarks;
    
   public  void setBookCategoryId(int bookCategoryId){
            this.bookCategoryId=bookCategoryId;
   
    }
     
     public int getBookCategoryId(){
         return bookCategoryId;
     
     }
     
     public void setBookCategory(String bookCategory){
            this.bookCategory=bookCategory;
     
     }
     public String getBookCategory(){
            return bookCategory;
     
     
     }
     
     public void setRemarks(String remarks){
     this.remarks=remarks;
     }
        public String getRemarks(){
        return remarks;
        
        }
        
        public String toString(){
        return bookCategory;
        
        }
    
    
    
}
