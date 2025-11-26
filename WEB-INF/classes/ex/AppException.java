package ex;

import jakarta.servlet.ServletException;

public class AppException extends Exception{
    public AppException(String mess,Throwable e){
        super(mess,e);
    }
}