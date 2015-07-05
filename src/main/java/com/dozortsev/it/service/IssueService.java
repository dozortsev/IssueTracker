package com.dozortsev.it.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

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
