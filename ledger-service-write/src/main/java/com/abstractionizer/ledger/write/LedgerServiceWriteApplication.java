package com.abstractionizer.ledger.write;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class LedgerServiceWriteApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableEnvironment env = SpringApplication.run(LedgerServiceWriteApplication.class).getEnvironment();

        String protocol = "http";
        if(env.getProperty("server.ssl.key-store") != null){
            protocol = "https";
        }
        log.info("\n------------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n" +
                        "------------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol, InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"),
                env.getActiveProfiles());
    }

}
