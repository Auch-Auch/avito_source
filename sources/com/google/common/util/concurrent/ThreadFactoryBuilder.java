package com.google.common.util.concurrent;

import a2.j.d.l.a.e0;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
@CanIgnoreReturnValue
@GwtIncompatible
public final class ThreadFactoryBuilder {
    public String a = null;
    public Boolean b = null;
    public Integer c = null;
    public Thread.UncaughtExceptionHandler d = null;
    public ThreadFactory e = null;

    @CheckReturnValue
    public ThreadFactory build() {
        String str = this.a;
        Boolean bool = this.b;
        Integer num = this.c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        ThreadFactory threadFactory = this.e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new e0(threadFactory, str, str != null ? new AtomicLong(0) : null, bool, num, uncaughtExceptionHandler);
    }

    public ThreadFactoryBuilder setDaemon(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public ThreadFactoryBuilder setNameFormat(String str) {
        String.format(Locale.ROOT, str, 0);
        this.a = str;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int i) {
        boolean z = false;
        Preconditions.checkArgument(i >= 1, "Thread priority (%s) must be >= %s", i, 1);
        if (i <= 10) {
            z = true;
        }
        Preconditions.checkArgument(z, "Thread priority (%s) must be <= %s", i, 10);
        this.c = Integer.valueOf(i);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.e = (ThreadFactory) Preconditions.checkNotNull(threadFactory);
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.d = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }
}
