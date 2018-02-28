package InitContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WebInitListener implements ServletContextListener {
    private List<String> web_url_intercept = new ArrayList<String>();
    private List<String> web_url_through = new ArrayList<String>();

    public WebInitListener() {}

    public List<String> getWeb_url_intercept() {
        return web_url_intercept;
    }

    public void setWeb_url_intercept(List<String> web_url_intercept) {
        this.web_url_intercept = web_url_intercept;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ResourceBundle url = ResourceBundle.getBundle("url");
        int length = Integer.parseInt(url.getString("length1"));
        for(int i=1;i<=length;i++){
            web_url_intercept.add(url.getString("url1_"+i));
        }
        int length2 = Integer.parseInt(url.getString("length2"));
        for(int i=1;i<=length2;i++){
            web_url_through.add(url.getString("url2_"+i));
        }
        servletContextEvent.getServletContext().setAttribute("url_action_intercept",web_url_intercept);
        servletContextEvent.getServletContext().setAttribute("url_action_through",web_url_through);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
