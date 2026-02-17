package jdbc;

//import java.util.List;
import java.util.ArrayList;

public class EmpQueryTest {
    public static void main(String... args){
        ArrayList empList = (ArrayList)EmpQuery.getEmpList();

        for(int i=0; i<empList.size(); i++){
            ArrayList<String> empRecord = (ArrayList)empList.get(i);
            for(int j=0; j<empRecord.size(); j++){
                System.out.print(empRecord.get(j)+"\t");
            }
            System.out.println();
        }
    }
}
