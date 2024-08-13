package com.joseph.shareresource;

import com.joseph.shareresource.factory.TicketSystemFactory;
import com.joseph.shareresource.inter.TicketSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShareResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareResourceApplication.class, args);
    }

}
