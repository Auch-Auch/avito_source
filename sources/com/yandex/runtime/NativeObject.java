package com.yandex.runtime;

import android.os.Handler;
import android.os.Looper;
public final class NativeObject {
    private long nativeObject;

    public static final class Cleaner implements Runnable {
        private final long nativeObject;

        public Cleaner(long j) {
            this.nativeObject = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeObject.deleteNative(this.nativeObject);
        }
    }

    public NativeObject(long j) {
        this.nativeObject = j;
    }

    /* access modifiers changed from: private */
    public static native void deleteNative(long j);

    public void finalize() throws Throwable {
        if (!isEmpty()) {
            new Handler(Looper.getMainLooper()).post(new Cleaner(this.nativeObject));
            this.nativeObject = 0;
        }
    }

    public boolean isEmpty() {
        return this.nativeObject == 0;
    }

    public long release() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            long j = this.nativeObject;
            this.nativeObject = 0;
            return j;
        }
        throw new IllegalStateException("Cannot release native object outside the UI thread");
    }

    public void reset() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            deleteNative(this.nativeObject);
            this.nativeObject = 0;
            return;
        }
        throw new IllegalStateException("Cannot reset native object outside the UI thread");
    }
}
