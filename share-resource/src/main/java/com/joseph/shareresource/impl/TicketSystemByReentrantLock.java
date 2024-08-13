package com.joseph.shareresource.impl;

import com.joseph.shareresource.inter.TicketSystem;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author joseph
 * @create 2024-07-24
 */
public class TicketSystemByReentrantLock implements TicketSystem {

    private int ticketNum;
    //定义锁
    private final ReentrantLock lock = new ReentrantLock();

    public TicketSystemByReentrantLock(int ticketNum){
        this.ticketNum = ticketNum;
    }

    @Override
    public void sellTicket() {
           while(ticketNum > 0){
               lock.lock();//上锁
               try {
                   Thread.sleep(200);//模拟售票的过程
                   if(ticketNum > 0){
                       System.out.println(Thread.currentThread().getName() + " sell a ticket, " + --ticketNum + " left.");
                   }
               }catch (InterruptedException e){
                   e.printStackTrace();
               }finally {
                   lock.unlock();//解锁
               }
           }
    }
}
