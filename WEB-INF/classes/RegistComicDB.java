import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comic.ComicProperty;

public class RegistComicDB {
    public static void main(String[] args){
        selectComicList();
    }

    public static void insert(ComicProperty cproperty){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection cn =
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");

            System.out.println("接続完了");

            cn.setAutoCommit(false);

            String sql =
            "INSERT INTO comiclist(publisher,comictitle,comicauthor) VALUES('"+cproperty.getComicPublisher()+"','"+cproperty.getComicTitle()+"','"+cproperty.getComicAuthor()+"')";

            Statement st = cn.createStatement();

            int count = st.executeUpdate(sql);
            System.out.println(count+"件処理完了");

            cn.commit();
            st.close();
            cn.close();

            System.out.println("切断完了");  
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("クラスがないみたい");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("SQL関連の例外みたい");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    public static List<ComicProperty> selectComicList(){
        List<ComicProperty> comiclist = new ArrayList<ComicProperty>();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection cn =
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");

            System.out.println("接続完了");

            String sql = "SELECT publisher,comictitle,comicauthor FROM comiclist";

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                String publisher = rs.getString(1);
                String comictitle = rs.getString(2);
                String comicauthor = rs.getString(3);

                ComicProperty cproperty = new ComicProperty();
                cproperty.setComicPublisher(publisher);
                cproperty.setComicTitle(comictitle);
                cproperty.setComicAuthor(comicauthor);

                System.out.println(cproperty.getComicPublisher()+"　"+cproperty.getComicTitle()+"　"+cproperty.getComicAuthor());

                comiclist.add(cproperty);
            }

            rs.close();
            st.close();
            cn.close();

            System.out.println("切断完了");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("クラスがないみたい。");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("SQL関連の例外みたい");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        }
        return comiclist;
    }
}
