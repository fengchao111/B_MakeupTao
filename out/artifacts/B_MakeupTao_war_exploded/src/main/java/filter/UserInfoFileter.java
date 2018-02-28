package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UserInfoFileter implements Filter {

    private ServletContext sc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sc = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<String> url_action_intercept = (List<String>)sc.getAttribute("url_action_intercept");
        List<String> url_action_through = (List<String>)sc.getAttribute("url_action_through");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //拿到一个用户登录的标志
        String user_id = (String)session.getAttribute("user_id");
//        System.out.println("user_id:"+user_id);
        //拿到请求的uri
        String requestURI = request.getRequestURI();

        //通过标志判断是否是登录是本人
        String url_user_id = request.getParameter("user_id");
//        System.out.println("url_user_id:"+url_user_id);
//        System.out.println("requestURL:"+requestURI);
        Iterator<String> iterator = url_action_intercept.iterator();
        Iterator<String> iterator1 = url_action_through.iterator();

        boolean flag=false;
        while(iterator1.hasNext()){
            if(iterator1.next().equals(requestURI)){
                flag=true;
                break;
            }
        }
        while (false==false && iterator.hasNext()){
            if(iterator.next().equals(requestURI) && user_id!=null && url_user_id!=null && user_id.equals(url_user_id)){
                flag=true;
                break;
            }
        }
//        根据flag标志判断是否可以放行
        if(flag){
            filterChain.doFilter(request,response);
        }
//        System.out.println();
    }

    @Override
    public void destroy() {

    }
}
