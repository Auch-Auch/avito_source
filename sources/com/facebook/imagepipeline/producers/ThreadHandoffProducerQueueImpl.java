package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
public class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    public boolean a = false;
    public final Deque<Runnable> b;
    public final Executor c;

    public ThreadHandoffProducerQueueImpl(Executor executor) {
        this.c = (Executor) Preconditions.checkNotNull(executor);
        this.b = new ArrayDeque();
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized void addToQueueOrExecute(Runnable runnable) {
        if (this.a) {
            this.b.add(runnable);
        } else {
            this.c.execute(runnable);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized boolean isQueueing() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized void remove(Runnable runnable) {
        this.b.remove(runnable);
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized void startQueueing() {
        this.a = true;
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized void stopQueuing() {
        this.a = false;
        while (!this.b.isEmpty()) {
            this.c.execute(this.b.pop());
        }
        this.b.clear();
    }
}
