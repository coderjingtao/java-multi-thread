package com.joseph.shareresource;

import com.joseph.shareresource.factory.TicketSystemFactory;
import com.joseph.shareresource.inter.TicketSystem;

/**
 * @author joseph
 * @create 2024-07-24
 */
public class MultiThreadSellTicket {
    public static void main(String[] args) {
        int ticketNum = 100;
        String systemType = "Synchronized";
        TicketSystem ticketSystem = TicketSystemFactory.newInstance(systemType, ticketNum);

        new Thread(ticketSystem::sellTicket,"线程1").start();
        new Thread(ticketSystem::sellTicket,"线程2").start();
        //new Thread(ticketSystem::sellTicket,"线程3").start();

    }
}
