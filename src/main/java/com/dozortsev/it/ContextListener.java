package com.dozortsev.it;

import com.dozortsev.it.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class ContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    IssueService issueService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.printf("%nContextListener#onApplicationEvent%n");

        // run asynchronous task under Spring application initialization
        Future<Integer> page1 = issueService.findPage(10);
        Future<Integer> page2 = issueService.findPage(2);
        Future<Integer> page3 = issueService.findPage(1);

        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            System.out.println("check");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
