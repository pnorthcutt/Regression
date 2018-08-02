package com.suprtek.regressiontracker;

import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by pnorthcutt on 7/27/2018.
 */
@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>{

    @Override
    public void customize(ConfigurableServletWebServerFactory container) {
        container.setPort(8081);
    }
}
