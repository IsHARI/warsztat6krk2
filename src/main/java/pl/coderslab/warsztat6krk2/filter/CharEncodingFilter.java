package pl.coderslab.warsztat6krk2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharEncodingFilter implements Filter {
    private final String charsetEncoding = "utf-8";
    private final String contentType = "text/html";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(charsetEncoding);
        resp.setContentType(contentType);
        resp.setCharacterEncoding(charsetEncoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) {

    }

}
