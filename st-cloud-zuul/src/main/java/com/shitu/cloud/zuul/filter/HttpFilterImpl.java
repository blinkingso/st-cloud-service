package com.shitu.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author andrew
 * @date 2019/04/29
 */
@Component
public class HttpFilterImpl extends ZuulFilter {

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
    public Object run() throws ZuulException {
        final RequestContext currentContext = RequestContext.getCurrentContext();
        final HttpServletRequest request = currentContext.getRequest();
        final String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            try {
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(401);
                currentContext.getResponse().getWriter().write("token is empty");
            } catch (IOException ignored) {
            }

            return null;
        }

        return null;
    }
}
