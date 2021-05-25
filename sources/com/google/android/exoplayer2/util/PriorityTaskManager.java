package com.google.android.exoplayer2.util;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
public final class PriorityTaskManager {
    public final Object a = new Object();
    public final PriorityQueue<Integer> b = new PriorityQueue<>(10, Collections.reverseOrder());
    public int c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super(a.S2("Priority too low [priority=", i, ", highest=", i2, "]"));
        }
    }

    public void add(int i) {
        synchronized (this.a) {
            this.b.add(Integer.valueOf(i));
            this.c = Math.max(this.c, i);
        }
    }

    public void proceed(int i) throws InterruptedException {
        synchronized (this.a) {
            while (this.c != i) {
                this.a.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int i) {
        boolean z;
        synchronized (this.a) {
            z = this.c == i;
        }
        return z;
    }

    public void proceedOrThrow(int i) throws PriorityTooLowException {
        synchronized (this.a) {
            if (this.c != i) {
                throw new PriorityTooLowException(i, this.c);
            }
        }
    }

    public void remove(int i) {
        synchronized (this.a) {
            this.b.remove(Integer.valueOf(i));
            this.c = this.b.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.castNonNull(this.b.peek())).intValue();
            this.a.notifyAll();
        }
    }
}
