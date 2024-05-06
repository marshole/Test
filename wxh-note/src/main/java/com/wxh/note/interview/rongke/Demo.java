package com.wxh.note.interview.rongke;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. 并发 4 线程,每个线程生成 10 万组随机数，一组随机数里面有三个数
 * 2. 将这四个线程里面每组都是奇数的总组数，以(count1,count2,count3,count4)形式
 * 输出到文件 test.txt
 *
 * @author weixuhui Date: 2023/10/28 Time: 21:37
 */
public class Demo {
    public static void main(String[] args) {

        RandomNumberGenerator generator1 = new RandomNumberGenerator();
        RandomNumberGenerator generator2 = new RandomNumberGenerator();
        RandomNumberGenerator generator3 = new RandomNumberGenerator();
        RandomNumberGenerator generator4 = new RandomNumberGenerator();

        Thread t1 = new Thread(generator1);
        Thread t2 = new Thread(generator2);
        Thread t3 = new Thread(generator3);
        Thread t4 = new Thread(generator4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("("
                    + generator1.getUnevenNumberCount() + ","
                    + generator2.getUnevenNumberCount() + ","
                    + generator3.getUnevenNumberCount() + ","
                    + generator4.getUnevenNumberCount()
                    + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class RandomNumberGenerator implements Runnable {

    private AtomicInteger unevenNumberCount = new AtomicInteger(0);

    public AtomicInteger getUnevenNumberCount() {
        return unevenNumberCount;
    }

    @Override
    public void run() {
        Random random = new Random();
        int countOfOdd = 0;
        for (int i = 0; i < 100000; i++) {
            int randomNum1 = random.nextInt(100) + 1;
            int randomNum2 = random.nextInt(100) + 1;
            int randomNum3 = random.nextInt(100) + 1;

            if (randomNum1 % 2 != 0 && randomNum2 % 2 != 0 && randomNum3 % 2 != 0) {
                countOfOdd++;
            }
        }
        unevenNumberCount.set(countOfOdd);
    }
}
