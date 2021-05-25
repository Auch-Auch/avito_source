package com.yandex.runtime.logging.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.logging.LogListener;
import com.yandex.runtime.logging.Logging;
import com.yandex.runtime.subscription.Subscription;
public class LoggingBinding implements Logging {
    private Subscription<LogListener> logListenerSubscription = new Subscription<LogListener>() { // from class: com.yandex.runtime.logging.internal.LoggingBinding.1
        public NativeObject createNativeListener(LogListener logListener) {
            return LoggingBinding.createLogListener(logListener);
        }
    };
    private final NativeObject nativeObject;

    public LoggingBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createLogListener(LogListener logListener);

    @Override // com.yandex.runtime.logging.Logging
    public native boolean isValid();

    @Override // com.yandex.runtime.logging.Logging
    public native void subscribe(@NonNull LogListener logListener);

    @Override // com.yandex.runtime.logging.Logging
    public native void unsubscribe(@NonNull LogListener logListener);
}
