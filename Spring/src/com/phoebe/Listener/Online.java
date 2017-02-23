package com.phoebe.Listener; /**
 * Created by phoebegl on 2016/12/20.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

@WebListener()
public class Online implements ServletContextListener, ServletContextAttributeListener {

    // Public constructor is required by servlet spec
    public Online() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext= sce.getServletContext();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/phoebegl/J2EEwork/Spring/count.txt"));
            String counter = reader.readLine();
            servletContext.setAttribute("counter", Integer.parseInt(counter));
            servletContext.setAttribute("onlineCounter", 0);
            servletContext.setAttribute("visitor",0);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext= sce.getServletContext();
        int counter = (Integer) servletContext.getAttribute("counter");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/phoebegl/J2EEwork/Spring/count.txt"));
            writer.write(Integer.toString(counter));
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        System.out.println("ServletContextattribute added");
    }

    /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("ServletContextattribute replaced");
    }

    /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        System.out.println("ServletContextattribute removed");
    }
}