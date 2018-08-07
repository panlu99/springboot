/**
 * FileName: asynchronousImpl
 * Author: panlu02
 * Date: 2018/8/7 下午3:32
 * Description: asynchronousImpl
 **/
package com.example.springboot.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Slf4j
@Component
public class AsynchronousImpl {
    public static Random random = new Random();

    //@Async("taskExecutor")
    @Async
    public Future<String> doRaskOne() throws InterruptedException {
        log.info("start task 1");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("task1: consuming " + (end - start) + "ms");
        return new AsyncResult<>("task 1 success");
    }

    //@Async("taskExecutor")
    @Async
    public Future<String> doRaskTwo() throws InterruptedException {
        log.info("start task 2");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("task2: consuming " + (end - start) + "ms");
        return new AsyncResult<>("task 2 success");
    }

    //@Async("taskExecutor")
    @Async
    public Future<String> doRaskThree() throws InterruptedException {
        log.info("start task 3");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("task3: consuming " + (end - start) + "ms");
        return new AsyncResult<>("task 3 success");
    }
}
