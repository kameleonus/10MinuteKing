package com.company;

import java.util.concurrent.TimeUnit;

public class end {
    void end() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.exit(1);
    }
}
