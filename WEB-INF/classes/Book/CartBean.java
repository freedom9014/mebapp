package Book;

import java.io.Serializable;
import java.util.ArrayList;

public class CartBean implements Serializable{
    private ArrayList books = new ArrayList();

    public void addBook(BookBean book){
        books.add(book);
    }

    public void setBooks(ArrayList books){
        this.books = books;
    }

    public ArrayList getBooks(){
        return books;
    }
}
