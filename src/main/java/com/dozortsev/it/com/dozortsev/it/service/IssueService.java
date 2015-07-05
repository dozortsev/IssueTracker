package com.dozortsev.it.com.dozortsev.it.service;

import com.dozortsev.it.domain.Issue;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class IssueService {

    @Async
    public Future<Integer> findPage(int index) throws InterruptedException {
        Thread.sleep(1000 * index);
        System.out.printf("Task with index: %s successfully finished%n", index);
        return new AsyncResult<>(index);
    }
}
