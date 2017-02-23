package com.phoebe.Action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by phoebegl on 2017/2/23.
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

    public HttpServletRequest request;
    public HttpServletResponse response;
    @SuppressWarnings("unchecked")
    public Map<String, Object> session;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
