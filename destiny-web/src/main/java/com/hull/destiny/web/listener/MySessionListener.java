package com.hull.destiny.web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 *
 * @author
 * @create 2018-09-19 下午10:15
 **/

@WebListener
@Slf4j
public class MySessionListener implements HttpSessionListener {

    public static Integer peopleOnline = 0;
    public static Integer peopleVisit = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("sessionCreated :"+se.getSession().toString());
        peopleOnline ++ ;
        peopleVisit ++ ;
        se.getSession().setAttribute("peopleOnLine",peopleOnline);
        se.getSession().setAttribute("peopleVisit",peopleVisit);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("sessionDestroyed :"+se.getSession().toString());
        peopleOnline -- ;
        se.getSession().setAttribute("peopleOnLine",peopleOnline);
    }
}
