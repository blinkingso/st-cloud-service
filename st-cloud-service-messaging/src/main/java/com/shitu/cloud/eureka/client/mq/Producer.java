package com.shitu.cloud.eureka.client.mq;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

/**
 * java 11 的语法新特性 var
 * @author andrew
 * @date 2019/07/23
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        var chant = "  asfasf ";

        String repeat = chant.repeat(3);
        System.out.println(repeat);

        Consumer<BigDecimal> consumer = (@Deprecated var money) -> System.out.println("get this money: " + money);

        consumer.accept(new BigDecimal("10.011"));

        HttpClient build = HttpClient.newBuilder().build();
        HttpRequest build1 = HttpRequest.newBuilder().GET().uri(URI.create("http://www.google.com")).build();
        HttpResponse<String> send = build.send(build1, HttpResponse.BodyHandlers.ofString());
        System.out.println(send.body());

        // JavascriptEngine
        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        nashorn.eval("print('help me ');");

        // intermediate terminal
    }

}
