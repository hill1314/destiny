package com.hull.destiny.web.filters;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆过滤器
 *
 * @author
 * @create 2018-09-19 下午10:52
 **/

@Component
@Slf4j
@WebFilter(urlPatterns = "/",filterName = "urlEncodeFilter",
        initParams = {
            @WebInitParam(name="dispatchUrl", value="/home/login"),
            @WebInitParam(name="excludeUrl", value="/home/login")
        })
public class loginFilter implements Filter {

    private String dispatchUrl = "";
    private String excludeUrl = "";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        dispatchUrl = filterConfig.getInitParameter("dispatchUrl");
        excludeUrl = filterConfig.getInitParameter("excludeUrl");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String servletPath = httpRequest.getServletPath();

        HttpSession session = httpRequest.getSession();
        String sessionKey = (String) session.getAttribute("sessionId");

        log.info("servletPath={},sessionKey={}",servletPath,sessionKey);

		/*就是登陆界面不进行过滤*/
        if(servletPath.equals(dispatchUrl) || servletPath.equals(excludeUrl)){
            chain.doFilter(request, response);
        }else{
            if(!StringUtils.isEmpty(sessionKey)){
                chain.doFilter(request, response);
            }else{
                request.getRequestDispatcher(dispatchUrl).forward(request, response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
