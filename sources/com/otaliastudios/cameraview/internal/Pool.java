package com.otaliastudios.cameraview.internal;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.CameraLogger;
import java.util.concurrent.LinkedBlockingQueue;
public class Pool<T> {
    public static final CameraLogger f = CameraLogger.create(Pool.class.getSimpleName());
    public int a;
    public int b;
    public LinkedBlockingQueue<T> c;
    public Factory<T> d;
    public final Object e = new Object();

    public interface Factory<T> {
        T create();
    }

    public Pool(int i, @NonNull Factory<T> factory) {
        this.a = i;
        this.c = new LinkedBlockingQueue<>(i);
        this.d = factory;
    }

    public final int activeCount() {
        int i;
        synchronized (this.e) {
            i = this.b;
        }
        return i;
    }

    @CallSuper
    public void clear() {
        synchronized (this.e) {
            this.c.clear();
        }
    }

    public final int count() {
        int activeCount;
        synchronized (this.e) {
            activeCount = activeCount() + recycledCount();
        }
        return activeCount;
    }

    @Nullable
    public T get() {
        synchronized (this.e) {
            T poll = this.c.poll();
            if (poll != null) {
                this.b++;
                f.v("GET - Reusing recycled item.", this);
                return poll;
            } else if (isEmpty()) {
                f.v("GET - Returning null. Too much items requested.", this);
                return null;
            } else {
                this.b++;
                f.v("GET - Creating a new item.", this);
                return this.d.create();
            }
        }
    }

    public boolean isEmpty() {
        boolean z;
        synchronized (this.e) {
            z = count() >= this.a;
        }
        return z;
    }

    public void recycle(@NonNull T t) {
        synchronized (this.e) {
            f.v("RECYCLE - Recycling item.", this);
            int i = this.b - 1;
            this.b = i;
            if (i < 0) {
                throw new IllegalStateException("Trying to recycle an item which makes activeCount < 0. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. " + this);
            } else if (!this.c.offer(t)) {
                throw new IllegalStateException("Trying to recycle an item while the queue is full. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. " + this);
            }
        }
    }

    public final int recycledCount() {
        int size;
        synchronized (this.e) {
            size = this.c.size();
        }
        return size;
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + " - count:" + count() + ", active:" + activeCount() + ", recycled:" + recycledCount();
    }
}
