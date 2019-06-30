package com.hull.busflow.web.filters;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * 日志过滤器 （打印出入参数,请求时长）
 *
 * @author
 * @create 2018-09-16 上午10:31
 **/

@Component
@Slf4j
@WebFilter(urlPatterns = "/",filterName = "logFilter")
public class LogFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("============== logFilter init ==============");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Long beginTime = System.currentTimeMillis();
        log.info("=================logFilter======================");
        String headerStr = resolveHeaders(httpRequest);
        log.info("request url={},headerStr={{}}",httpRequest.getRequestURI(),headerStr);
        String paramStr = resolveParams(httpRequest.getParameterMap());
        log.info("request url={},param={{}}",httpRequest.getRequestURI(),paramStr);
        String attributeStr = resolveAttributes(httpRequest);
        log.info("request url={},attributeStr={{}}",httpRequest.getRequestURI(),attributeStr);
        chain.doFilter(httpRequest,httpResponse);

        Long endTime = System.currentTimeMillis();
        log.info("response url={},status={},cost={}s",
                httpRequest.getRequestURI(),httpResponse.getStatus(),(endTime-beginTime)/1000);
    }

    /**
     * 解析 header
     * @param httpRequest
     * @return
     */
    private String resolveHeaders(HttpServletRequest httpRequest) {
        StringBuffer buffer = new StringBuffer();
        Enumeration<String> enumeration = httpRequest.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String element = enumeration.nextElement();
            buffer.append("'"+element+"':"+httpRequest.getAttribute(element)+",");
        }
        String resultStr = buffer.toString();
        if(resultStr.length()>1){
            resultStr = resultStr.substring(0,resultStr.length()-1);
        }
        return resultStr;    }

    /**
     * 解析 attribute
     * @param httpRequest
     * @return
     */
    private String resolveAttributes(HttpServletRequest httpRequest) {
        StringBuffer buffer = new StringBuffer();
        Enumeration<String> enumeration = httpRequest.getAttributeNames();
        while (enumeration.hasMoreElements()){
            String element = enumeration.nextElement();
            buffer.append("'"+element+"':"+httpRequest.getAttribute(element)+",");
        }
        String resultStr = buffer.toString();
        if(resultStr.length()>1){
            resultStr = resultStr.substring(0,resultStr.length()-1);
        }
        return resultStr;
    }

    /**
     * 解析 params
     * @param parameterMap
     * @return
     */
    private String resolveParams(Map<String, String[]> parameterMap) {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> iterator = parameterMap.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            buffer.append("'"+key+"':");
            String[] value = parameterMap.get(key);
            if(Objects.isNull(value) || value.length==0){
                buffer.append("null,");
            }else {
                StringBuffer innerBuffer = new StringBuffer();
                for(String val :value ){
                    innerBuffer.append(val+",");
                }
                String valStr = innerBuffer.toString().substring(0,innerBuffer.toString().length()-1);
                buffer.append(valStr+",");
            }

        }
        String resultStr = buffer.toString();
        if(resultStr.length()>1){
            resultStr = resultStr.substring(0,resultStr.length()-1);
        }
        return resultStr;
    }

    @Override
    public void destroy() {
        log.info("============== logFilter destroy ==============");
    }
}
