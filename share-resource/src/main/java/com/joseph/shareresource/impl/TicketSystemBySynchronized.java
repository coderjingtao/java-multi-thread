package com.joseph.shareresource.impl;

import com.joseph.shareresource.inter.TicketSystem;

/**
 * @author joseph
 * @create 2024-07-24
 */
public class TicketSystemBySynchronized implements TicketSystem {

    private int ticketNum;

    public TicketSystemBySynchronized(int ticketNum){
        this.ticketNum = ticketNum;
    }

    @Override
    public void sellTicket() {
        while(ticketNum > 0){
            synchronized (this){
                if(ticketNum > 0){
                    ticketNum--;
                    System.out.println(Thread.currentThread().getName() + " sell a ticket, " + ticketNum + " left.");
                    try {
                        Thread.sleep(200);//模拟售票的过程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
