package br.com.viccari.dev.middlewares;

import javax.enterprise.event.Observes;

import io.quarkus.vertx.http.runtime.filters.Filters;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogURIMiddleware {

    public void filters(@Observes Filters filters) {
        filters.register(
            rc -> {
                log.info(String.format("URI->%s METHOD->%s", rc.request().absoluteURI(), rc.request().method().name()));
                rc.next();
            }, 
            10
        );   
    }
}
