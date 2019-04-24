package by.my.jmst;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/p")
public class Index extends HttpServlet {

    @Inject
    private Producer producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        producer.send();
    }
}
