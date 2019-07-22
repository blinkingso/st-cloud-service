package com.shitu.cloud.service.util.servlet;

import javax.servlet.AsyncContext;

public class AsyncRequestProcessor implements Runnable {

    private AsyncContext asyncContext;
    private int timeout;

    public AsyncRequestProcessor(AsyncContext asyncContext, int timeout) {
        this.asyncContext = asyncContext;
        this.timeout = timeout;
    }

    @Override
    public void run() {

    }
}
