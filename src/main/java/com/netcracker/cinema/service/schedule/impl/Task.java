package com.netcracker.cinema.service.schedule.impl;

import com.netcracker.cinema.service.ApplicationContextHandler;
import com.netcracker.cinema.service.TicketService;
import com.vaadin.spring.annotation.SpringComponent;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringComponent
public class Task implements Job {

    private TicketService ticketService;

    @Autowired
    public Task(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        ApplicationContext ctx = ApplicationContextHandler.getApplicationContext();
//        TicketService ticketService = (TicketService) ctx.getBean("ticketService");
        long seanceId = (long)jobExecutionContext.getMergedJobDataMap().get("id");
        ticketService.deleteBlockForOneHour(seanceId);
    }
}

