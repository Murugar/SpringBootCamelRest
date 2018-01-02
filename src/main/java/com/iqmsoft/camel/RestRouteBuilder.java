package com.iqmsoft.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration()   
                .bindingMode(RestBindingMode.json);
        rest("/sayhello")
                .get("/").to("bean:helloBean?method=greetingWorld(${header.msg})"); //.log("${body}");

    }
}
