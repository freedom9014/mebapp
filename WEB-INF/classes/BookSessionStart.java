import java.io.IOException;

import Book.CartBean;
import Book.BookBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BookSessionStart extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{

        //HttpServletインターフェイスの実装クラスのインスタンスを取得
        //まだセッションが開始されていない場合は同時にこれがセッションの開始になる
        //セッションが開始されていれば既存のセッションが取得される
        HttpSession session = req.getSession();

        //セッションの中にcartという属性があれば取ってくる
        //なかったらnull。1回目はないので28行目でcartを生成
        //2回目からは既存のcartを返す
        CartBean cart = (CartBean)session.getAttribute("cart");

        //セッションが開始されたばかりの場合
        if(cart == null){
            //カートをインスタンス化
            cart = new CartBean();
        }

        //BookBeanをインスタンス化
        BookBean b1 = new BookBean();
        b1.setId("1");
        b1.setTitle("Java入門");
        b1.setPrice("2500");

        //カートに追加
        cart.addBook(b1);
        
        //カートを登録
        session.setAttribute("cart",cart);

        RequestDispatcher dispatcher = req.getRequestDispatcher("bookshow");

        dispatcher.forward(req,res);
    }
}
