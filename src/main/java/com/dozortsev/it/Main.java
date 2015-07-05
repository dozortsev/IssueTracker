package com.dozortsev.it;

import com.dozortsev.it.com.dozortsev.it.service.IssueService;
import com.dozortsev.it.domain.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

import static java.lang.System.nanoTime;

@SpringBootApplication
@EnableAsync
public class Main implements CommandLineRunner {

    @Autowired
    IssueService issueService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        final long start = nanoTime();

        Future<Integer> page1 = issueService.findPage(10);
        Future<Integer> page2 = issueService.findPage(2);
        Future<Integer> page3 = issueService.findPage(1);

        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            System.out.println("check");
            Thread.sleep(1000);
        }

        System.out.printf("Time elapsed: %s", nanoTime() - start);
        System.out.printf("Page 1: %s", page1.get());
    }
}
