package com.company;

import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        try {
            Broker broker = new Broker();

            ThreadPool threadPool = new ThreadPool(3);

            threadPool.execute(new Consumer("1", broker));
            threadPool.execute(new Consumer("2", broker));
            Future producerStatus = threadPool.submit(new Producer(broker));

            producerStatus.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
