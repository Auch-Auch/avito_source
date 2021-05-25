package com.adjust.sdk.scheduler;

import a2.b.a.a.a;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.Constants;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
public class ThreadFactoryWrapper implements ThreadFactory {
    private String source;

    public ThreadFactoryWrapper(String str) {
        this.source = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
        newThread.setPriority(9);
        StringBuilder L = a.L(Constants.THREAD_PREFIX);
        L.append(newThread.getName());
        L.append("-");
        L.append(this.source);
        newThread.setName(L.toString());
        newThread.setDaemon(true);
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.adjust.sdk.scheduler.ThreadFactoryWrapper.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                AdjustFactory.getLogger().error("Thread [%s] with error [%s]", thread.getName(), th.getMessage());
            }
        });
        return newThread;
    }
}
