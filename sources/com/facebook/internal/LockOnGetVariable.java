package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
public class LockOnGetVariable<T> {
    public T a;
    public CountDownLatch b;

    public class a implements Callable<Void> {
        public final /* synthetic */ Callable a;

        public a(Callable callable) {
            this.a = callable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            try {
                LockOnGetVariable.this.a = (T) this.a.call();
                LockOnGetVariable.this.b.countDown();
                return null;
            } catch (Throwable th) {
                LockOnGetVariable.this.b.countDown();
                throw th;
            }
        }
    }

    public LockOnGetVariable(T t) {
        this.a = t;
    }

    public T getValue() {
        CountDownLatch countDownLatch = this.b;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        return this.a;
    }

    public LockOnGetVariable(Callable<T> callable) {
        this.b = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new a(callable)));
    }
}
