package com.hull.destiny.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户权限过滤器
 *
 * @author
 * @create 2018-07-22 下午7:47
 **/
@Component
@Slf4j
public class AccessFilter extends ZuulFilter{

    private static List<String> ignoredUriList = new ArrayList<>();

    static {
        ignoredUriList.add("/lyqcfws/payment/withholdCallBack");
        ignoredUriList.add("/lyqcfws/payment/shortcutCallBack");
        ignoredUriList.add("/lyqcfws/user/synCredit");
        ignoredUriList.add("/lyqcfws/app/version/check");
        ignoredUriList.add("/lyqcfws/user/login");
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String url = request.getRequestURI();
        log.info("请求访问的url:{},method:{}", request.getRequestURI(),request.getMethod());

        Object accessToken = request.getParameter("accessToken");
        if(!ignoredUriList.contains(url) && accessToken==null){
            log.warn("accessToken is null ");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        log.warn("accessToken is {} ",accessToken);
        return null;
    }
}
