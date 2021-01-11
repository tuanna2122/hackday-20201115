package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BaeldungSynchronizedMethodsUnitTest {

    @Test
    public void givenMultiThread_whenNonSyncMethod() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);
        BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();

        IntStream.range(0, 1000).forEach(value -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(1000, summation.getSum());
    }
}