package com.shitu.cloud.service.util.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

@WebServlet(urlPatterns = "/aysncRunningServlet", asyncSupported = true)
public class AsyncRunningServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("AsyncRunningServlet Start | Name = " + Thread.currentThread().getName() + "| ID = " + Thread.currentThread().getId());

        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

        // 动态设置模拟后续业务逻辑处理的时间， 便于测试对比异步上下文时间超时与不超时的代码反应
        String time = req.getParameter("time");
        int processTime = Integer.valueOf(time);
        // 最大社之5s
        if (processTime > 5000) {
            processTime = 5000;
        }

        AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new DefaultAsyncListener());
        asyncContext.setTimeout(4000);

        // 获取业务线程池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) req.getServletContext().getAttribute("executor");

        executor.execute(new AsyncRequestProcessor(asyncContext, processTime));

        long endTime = System.currentTimeMillis();
        System.out.println("AsyncRunningServlet End | Name = " +Thread.currentThread().getName() +
                " | ID = " + Thread.currentThread().getId() +
                " | Time Cost = " + (endTime - startTime) + " ms.");
    }
}
