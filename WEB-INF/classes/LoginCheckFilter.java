import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//Filterインターフェースを実装するクラス
public class LoginCheckFilter implements Filter{

    //フィルタの初期化処理を行う準備
    //init()はサーブレットコンテナがフィルタを生成したあと一度だけ実行される
    //オーバーライド
    public void init(FilterConfig config) throws ServletException{}

    //フィルタの終了処理を担う
    //init()で確保したリソースを安全に解放
    //最後に一度だけ実行される
    //オーバーライド
    public void destroy(){}

    //オーバーライド
    //フィルタが行う処理をここに書く
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException,ServletException{

        //フォームから送信されたパラメータの取得
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        //パラメータがnullでなかったら、正しいかチェック
        if(name != null && pass != null){

            if(name.equals("god") && pass.equals("isaka")){

                //session(保存箱)をなければ新しく作る、既にあれば取りだす処理
                //ServletRequestは汎用的なので、session(Web特有)を扱うにはHttpServletRequest型である必要がある
                HttpSession session = ((HttpServletRequest)req).getSession();
                
                //sessionにOKというtokenを保存 → ログインに成功したということをサーバーが記憶
                //tokenが保存されればサーバーは中身をみてログインに成功したユーザーだと認識できる
                session.setAttribute("token","OK");
            }
        }

        //次の工程へ進める処理
        chain.doFilter(req,res);
    }
}
