package com.lucifer.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zhangchuanqiang on 2017/3/15.
 */
@WebFilter(filterName = "FilterOne")
public class FilterOne implements Filter {
    private String charEncoding=null;


    public void init(FilterConfig config) throws ServletException {
        System.out.println("====初始化Filter====");
        charEncoding=config.getInitParameter("encoding");
        if (charEncoding==null){
            throw new ServletException("Filter编码设置为空");
        }
        System.out.println("param== "+charEncoding);
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (!charEncoding.equals(req.getCharacterEncoding())){
            req.setCharacterEncoding(charEncoding);
        }
        resp.setCharacterEncoding(charEncoding);
//        System.out.println("====开始执行doFilter====");
        chain.doFilter(req, resp);
//        System.out.println("====结束执行doFilter====");
    }
    public void destroy() {
        System.out.println("====销毁过滤器====");
    }

}
