package com.mljr.destiny.aop;

import com.mljr.destiny.annotations.IntfLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 接口记录拦截器
 *
 * @author
 * @create 2018-07-28 下午4:59
 **/

@Aspect
@Component
@Slf4j
public class IntfLogAspect {

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.mljr.destiny.annotations.IntfLog)")
    public void aspect() {

    }

//    @Pointcut("@annotation(com.mljr.destiny.annotations.IntfLogs)")
//    public void aspect2() {
//
//    }

//    @Around(" (aspect()&&@annotation(logPoint)) || (aspect2()&& @annotation(intfLogs))")
    @Around("aspect()&&@annotation(logPoint)")
    public Object around(ProceedingJoinPoint joinPoint, IntfLog logPoint) {

        List params = null;

        try {
            String methodName = joinPoint.getSignature().getName();
            params = getParams(joinPoint.getArgs());

            log.info("methodName={}",methodName);
            log.info("params=");
            params.stream().forEach(p-> log.info(p+","));

            if(logPoint !=null){
                saveLog(logPoint);
            }

//            if(intfLogs!=null){
//                IntfLog[] logs = intfLogs.value();
//                for(IntfLog log : logs){
//                    saveLog(log);
//                }
//            }

        }catch (Exception e){
            log.error("error=",e);
        }

        return null;
    }

    /**
     * 保存日志
     * @param logPoint
     */
    private void saveLog(IntfLog logPoint) {
        String url = logPoint.url();
        String desc = logPoint.desc();
        Class clazz = logPoint.callbackClass();

        log.info("save intf log: url={},desc={},class={}",url,desc,clazz.getName());
    }

    private List<Object> getParams(Object[] arr) {
        ArrayList list = new ArrayList();
        if (arr != null && arr.length > 0) {
            Object[] var2 = arr;
            int var3 = arr.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Object obj = var2[var4];
                if (!(obj instanceof ServletContext)) {
                    HashMap info;
                    if (obj instanceof MultipartFile && obj != null) {
                        MultipartFile file = (MultipartFile) obj;
                        info = new HashMap();
                        info.put("name", file.getName());
                        info.put("originalFilename", file.getOriginalFilename());
                        info.put("size", Long.valueOf(file.getSize()));
                        obj = "MultipartFile=" + info;
                    }

                    if (obj instanceof File && obj != null) {
                        File var8 = (File) obj;
                        info = new HashMap();
                        info.put("name", var8.getName());
                        info.put("path", var8.getAbsolutePath());
                        info.put("size", Long.valueOf(var8.length()));
                        obj = "File=" + info;
                    }

                    list.add(obj);
                }
            }
        }
        return list;
    }

}
