import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ip.UserProfile;

public class RegistDB {

     public static void main(String[] args) {
        selectTest();
    
    }

    public static void insert(UserProfile up){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection cn = 
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");

            cn.setAutoCommit(false);

            System.out.println("接続完了");

//            String sql = "insert into loginlist(id,password) values("+up.getUserName()+","+up.getPassWord()+")";
            String sql = "insert into loginlist(id,password) values('"+up.getUserName()+"','"+up.getPassWord()+"')";

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

    public static ArrayList<UserProfile> selectTest(){
        ArrayList<UserProfile> userlist = new ArrayList<UserProfile>();
        try{

            //Javaアプリケーションで特定のJDBCドライバをロードするための処理
            //java.sql.Driverの実装クラス。これだけは完全限定名で指定しなければいけない
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //具体的な接続処理が実行される
            //接続が成功すると、その接続セッションを表現するConnectionオブジェクトが返され
            //変数cnに格納される
            //Oracleに接続する
            Connection cn =
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
            
            System.out.println("接続完了");

            //select文
            String sql = "SELECT id,password FROM loginlist";

            //DBに対してSQL文を実行するための準備
            //データベース接続(Connection cn)を使い、SQLをデータベースに送るための入れ物を作成
            //cnのメソッドcreateStatement()を呼び出し、Statementオブジェクトを生成
            //作成されたStatementオブジェクトが変数stに格納される
            //Statementインターフェースを実装するクラスをインスタンス化
            Statement st = cn.createStatement();

            //データベースから実際にデータを取得する処理
            //Statementオブジェクトを使って指定したSQL文を実行
            //ResultSetインターフェースを実装したクラスのインスタンスが返る
            ResultSet rs = st.executeQuery(sql);

            //ResultSetオブジェクトは、取得した全データを保持し、データを1行ずつ読み出すための
            //カーソルの概念を持っている

            //カーソルを一行だけスクロールし、データをフェッチ(取得)する
            while(rs.next()){
            
                String username = rs.getString(1);//1列目のデータを取得
                String password = rs.getString(2);//2列目のデータを取得

                UserProfile up = new UserProfile();
                up.setUserName(username);
                up.setPassWord(password);
                System.out.println(up.getUserName()+" "+up.getPassWord());
            
                userlist.add(up);
            }


            //Oracleから切断する
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
        return userlist;
    }
}
    

