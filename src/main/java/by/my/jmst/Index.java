package by.my.jmst;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/producer")
public class Index extends HttpServlet {

    @EJB
    private Producer producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        if (name == null) {
            name = "Guest";
        }
        producer.send(name);
    }
}
