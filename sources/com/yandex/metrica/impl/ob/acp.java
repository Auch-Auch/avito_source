package com.yandex.metrica.impl.ob;

import java.util.concurrent.Executor;
public class acp implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
