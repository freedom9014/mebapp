package ex;

public class AppException extends Exception{
    public AppException(String mess,Throwable e){
        super(mess,e);
    }
}