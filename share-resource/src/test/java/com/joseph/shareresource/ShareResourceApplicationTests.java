package com.joseph.shareresource;

import com.joseph.shareresource.factory.TicketSystemFactory;
import com.joseph.shareresource.inter.TicketSystem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShareResourceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testTicketSystem(){
        int ticketNum = 100;
        String systemType = "Synchronized";
        TicketSystem ticketSystem = TicketSystemFactory.newInstance(systemType, ticketNum);

        new Thread(ticketSystem::sellTicket,"线程1").start();
        new Thread(ticketSystem::sellTicket,"线程2").start();
    }

}
