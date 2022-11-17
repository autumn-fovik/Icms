package com.wangpy;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Log4j2
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
