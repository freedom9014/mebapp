package diary;

import java.io.FileWriter;

import ex.*;

public class DiaryItem {
   
    public void createItem(String input) throws LogicException{
        if(input == null || input.length() == 0){
            throw new NoContentException("入力内容がありません", null);
        }else{
            saveItem(input);
        }
    }
    public void saveItem(String input){
        try{
            FileWriter writer = new FileWriter("C:\\webapps\\mebapp\\WEB-INF\\classes\\diary\\michikodiary.txt",true);
            writer.write(input);
            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
