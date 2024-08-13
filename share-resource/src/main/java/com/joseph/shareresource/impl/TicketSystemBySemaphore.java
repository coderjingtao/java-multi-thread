package com.joseph.shareresource.impl;

import com.joseph.shareresource.inter.TicketSystem;

import java.util.concurrent.Semaphore;

/**
 * @author joseph
 * @create 2024-07-24
 */
public class TicketSystemBySemaphore implements TicketSystem {

    private final Semaphore semaphore;

    public TicketSystemBySemaphore(int ticketNum){
        this.semaphore = new Semaphore(ticketNum);
    }

    @Override
    public void sellTicket() {
        //返回此信号量中当前的可用许可证数量，即可用票数
        int ticketNum = semaphore.availablePermits();

        while(ticketNum > 0){
            try{
                Thread.sleep(200);//模拟售票的过程
                semaphore.acquire();//获取许可证:线程将阻塞等待，直到获取一个可用的许可证
                System.out.println(Thread.currentThread().getName() + " sell a ticket, " + --ticketNum + " left.");
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }finally {
                semaphore.release();
            }
        }
    }
}
