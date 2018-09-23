package com.hull.destiny.web.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author
 * @create 2018-09-19 下午10:29
 **/

@Component
@Slf4j
@WebFilter(urlPatterns = "/",filterName = "urlEncodeFilter",
        initParams = { @WebInitParam(name="urlEncode", value="UTF-8")})
public class UrlEncodeFilter implements Filter {

    Map<String,Object> paramMap = new HashMap<String,Object>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urlEncode = filterConfig.getInitParameter("urlEncode");
        paramMap.put("urlEncode",urlEncode);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("urlEncodeFilter urlEncode ："+paramMap.get("urlEncode"));
//        request.setCharacterEncoding(paramMap.get("urlEncode")==null?"":paramMap.get("urlEncode").toString());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
