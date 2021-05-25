package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    @Nullable
    public static UiThreadImmediateExecutorService b;

    public UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService getInstance() {
        if (b == null) {
            b = new UiThreadImmediateExecutorService();
        }
        return b;
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (isHandlerThread()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
