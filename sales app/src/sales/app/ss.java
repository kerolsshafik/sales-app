
package sales.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ss {
    
    Connection conect=null;
    Statement sta=null;
    PreparedStatement  per=null;
    ResultSet rs=null;
 
    //////////////////////////////////////////// 
    public void thequa(String qu) throws SQLException{
   try {
        conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","01289882588");
        sta=conect.createStatement();  
     if (conect!=null) System.out.println("connect");
       sta.executeUpdate(qu );
       // rs=sta.executeQuery(qu);
        //rs.close() ;   
        sta.close(); conect.close();
    }catch (SQLException ex) {
        System.err.println("error in data base");
          sta.close(); conect.close();
    }
    }
    
    public  void add(String name , String pass,String gand,String date)  {
    try {
           System.out.println("added is done");
           // add
   thequa("insert into userr(uname,pass,gend,birthday) values('"+name+"','"+pass+"','"+gand+"','"+date+"')" );
    }
         catch (SQLException ex) {
        System.err.println("error in added");
    }
         }
     
    public  boolean check(String name ,String pass ) throws SQLException{
        try { 
            conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","01289882588");
        sta=conect.createStatement();  
       rs=sta.executeQuery("select uname,pass from userr where uname='"+name+"' and pass='"+pass+"'" );
       if(rs.next()){
          rs.close();
           sta.close();
           conect.close();  
           
          return true;
      }else{
            rs.close();
           sta.close();
           conect.close();  
           
          return false;
      }
          
   }
         catch (SQLException    ex) {
        System.out.println("error in check");
    } 
   
return false;     
}
        
    public Boolean dele(String pass)
    {           
         try {
         //("DELETE FROM user WHERE pass ='"+pass+"'");
               conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","01289882588");
        sta=conect.createStatement();  
     if (conect!=null) System.out.println("connect");
       sta.executeUpdate("DELETE FROM userr WHERE pass ='"+pass+"'" );
       // rs=sta.executeQuery(qu);
        //rs.close();   
        sta.close(); conect.close();
        return true;
         } catch (SQLException ex) {
             System.out.println("error in delete");
            
         }
   return false ;}

public Boolean  forget (String name , String date,String pp){
  try {
             thequa( "update userr set pass= "+pp+" where  uname='"+name+"' and birthday='"+date+"'");
      return true;
  } catch (SQLException ex) {
             System.out.println("error in forget your password");
       return false;  }
   }


public void  update (String name , String gend,String date,String pass){

  try {
             thequa( "update userr set uname = "+name+ ",gend ="+gend+", birthday="+date+" where pass ="+pass);
         } catch (SQLException ex) {
             System.out.println("error in forget your password");
         }
}

//   public  String view_timetable(){
//    String all="";
//    // read
//     try {  conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","01289882588");
//        sta=conect.createStatement();  
//       result=sta.executeQuery("select * from userr" );
//      
//           System.out.println("view is done");
//
//           // add
//           // thequa("select * from userr");
//     
//         while(result.next()){
//     
//     String id= result.getString("id");     
//     String name= result.getString("nn");
//         all=all+name+"   "+id+"\n";
//         }
//            result.close();
//     sta.close();
//conect.close();
//         }catch (SQLException ex) {
//        System.err.println("error in vvvv");
//    }
//  
//     return all;
//    }

}
