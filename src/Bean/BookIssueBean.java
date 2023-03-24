/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import frame.Decode;

/**
 *
 * @author Isra Khan
 */
public class BookIssueBean {
    private int issueId;
    private int bookId;
    private int stdId;
    private java.util.Date dateOfIssue;
    private java.util.Date dateOfReturn;
    private int fineAmount;
    private String remarks;

    
    
    
    public void setIssueId(int issueId){
        this.issueId=issueId;
    
    }
    public int getIssueId(){
        return issueId;
    
    }
    public void setBookId(int bookId){
            
    
        this.bookId=bookId;
    }
    
    public int getBookId(){
            return bookId;
    
    }
        public void setStdId(int stdId){
            
    
        this.stdId=stdId;
    }
    
    public int getStdId(){
            return stdId;
    
    }
    
    
    
        public void setDateOfIssue(java.util.Date dateOfIssue){
        this.dateOfIssue=dateOfIssue;
    
    }
    public java.util.Date getDateOfIssue(){
        return dateOfIssue;
    
    }
    public void setdateOfReturn(java.util.Date dateOfReturn){
            
    
        this.dateOfReturn=dateOfReturn;
    }
    
    public java.util.Date getDataOfReturn(){
            return dateOfReturn;
    
    }
    
    
    
        public void setFineAmount(int fineAmount){
            
    
        this.fineAmount=fineAmount;
    }
    
    public int getFineAmount(){
            return fineAmount;
    
    }
   
    public void setRemarks(String remarks){
        this.remarks=remarks;
    
    }
    public String getRemarks(){
        return remarks;
    
    }
   public String toString(){
       if(dateOfIssue==null)return "-";
       
       
       return Decode.dateFormat(dateOfIssue);
 
       
    
   }
    
    
    
    
}
