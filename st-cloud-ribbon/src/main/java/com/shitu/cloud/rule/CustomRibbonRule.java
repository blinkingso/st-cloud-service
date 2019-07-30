package com.shitu.cloud.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义负载均衡
 *
 * @author andrew
 * @date 2019/07/25
 */
public class CustomRibbonRule implements IRule {

    private ILoadBalancer lb;

    @Override
    public Server choose(Object o) {
        List<Server> allServers = lb.getAllServers();
        AtomicReference<Server> server = new AtomicReference<>();
        allServers.forEach(s -> {
            System.out.println(s.getHost() + ":" + s.getPort());
            if (s.getPort() == 8083) {
                server.set(s);
            }
        });
        return server.get();
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.lb;
    }
}
