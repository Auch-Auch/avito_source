package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;
public final class NewThreadScheduler extends Scheduler {
    public static final RxThreadFactory c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));
    public final ThreadFactory b;

    public NewThreadScheduler() {
        this(c);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.b);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }
}
