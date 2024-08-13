package com.joseph.shareresource.factory;

import com.joseph.shareresource.impl.TicketSystemByReentrantLock;
import com.joseph.shareresource.impl.TicketSystemBySemaphore;
import com.joseph.shareresource.impl.TicketSystemBySynchronized;
import com.joseph.shareresource.inter.TicketSystem;

/**
 * @author joseph
 * @create 2024-07-24
 */
public class TicketSystemFactory {

    public static TicketSystem newInstance(String type,int ticketNum){
        switch (type){
            case "Synchronized" :
                return new TicketSystemBySynchronized(ticketNum);
            case "ReentrantLock" :
                return new TicketSystemByReentrantLock(ticketNum);
            case "Semaphore" :
            default:
                return new TicketSystemBySemaphore(ticketNum);
        }
    }
}
