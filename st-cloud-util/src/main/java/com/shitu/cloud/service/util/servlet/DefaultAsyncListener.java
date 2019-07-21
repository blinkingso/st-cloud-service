package com.shitu.cloud.service.util.servlet;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DefaultAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("complete");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("timeout");
        ServletResponse response = asyncEvent.getAsyncContext().getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("Timeout 请求处理超时");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("error");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("start async");
    }
}
