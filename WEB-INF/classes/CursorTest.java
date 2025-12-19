import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CursorTest {
    public static void main(String[] args){
        //nullで初期化
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");

            cn.setAutoCommit(false);

            DatabaseMetaData dbMeta = cn.getMetaData();

            String dbName = dbMeta.getDatabaseProductName();

            String[] types = {"TABLE"};

            ResultSet dbInfo = dbMeta.getTables(null,)

            /*String sql = "SELECT empno,ename FROM emp";

            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            rs = st.executeQuery(sql);

            ResultSetMetaData rsMeta = rs.getMetaData();

            
            int columnCount = rsMeta.getColumnCount();*/

            while(rs.next()){
                for(int i = 1; i <= columnCount; i++){
                    String data = rs.getString(i);

                    System.out.println(i + "列 : "+data);
                }
            }

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();

            if(cn != null && st != null){
                try{
                    cn.rollback();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }finally{
            try{
                if(st != null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                try{
                    if(cn != null){
                        cn.close();
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
    }    

}
