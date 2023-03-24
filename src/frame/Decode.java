/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Decode {
    public static String dateFormat(Date date){
    if(date==null)return "";
    SimpleDateFormat d=new SimpleDateFormat("dd-MMM-yyyy");
    String str=d.format(date);
    return str;
    
    }//method
    
    }
    
    
    
    
