package filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import wrapper.GetHttpServletRequestWrapper;

public class ContentTypeFilter implements Filter {

	private String charset = "UTF-8";
	private FilterConfig config;
	
	public void destroy() {
		charset = null;
		config = null;
        System.out.println(config.getFilterName()+"执行销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		   //设置请求响应字符编码   
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		  //新增加的代码     
        HttpServletRequest req = (HttpServletRequest)request;
		
        if(req.getMethod().equalsIgnoreCase("get"))
        {
        	System.out.println("in the get method");
        	req = new GetHttpServletRequestWrapper(req,charset);
        }
		
        System.out.println("----请求被"+config.getFilterName()+"过滤");   
        //传递给目标servlet或jsp的实际上时包装器对象的引用，而不是原始的HttpServletRequest对象 
		
		chain.doFilter(req, response);
		
		   System.out.println("----响应被"+config.getFilterName()+"过滤");   

	}

	public void init(FilterConfig config) throws ServletException {
		    this.config = config;
            String charset = config.getServletContext().getInitParameter("charset");  
            System.out.println("get charset----->"+charset);
            if( charset != null && charset.trim().length() != 0)
            {
            	this.charset = charset;
            }
            System.out.println("get charset<-----"+charset);
	}

}
