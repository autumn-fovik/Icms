package com.wangpy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class IcmsStartUpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(IcmsStartUpApplication.class, args);
        Environment env = applicationContext.getEnvironment();
        String ip;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String port = env.getProperty("server.port");
        String appName = env.getProperty("spring.application.name");
        String path = env.getProperty("server.servlet.context-path");

        String msg = "\n---------------------------------------------------------------------------"
                + "\n\tApplication " + appName + " is running! Access URLs:"
                + "\n\tLocal: \t\thttp://localhost:" + port
                + "\n\tExternal: \thttp://" + ip + ":" + port
                + "\n---------------------------------------------------------------------------";

        log.info(msg);
    }

}
