package com.yandex.runtime.recording.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.recording.EventListener;
import com.yandex.runtime.recording.EventLogging;
import com.yandex.runtime.recording.LoggingLevel;
import com.yandex.runtime.subscription.Subscription;
public class EventLoggingBinding implements EventLogging {
    private Subscription<EventListener> eventListenerSubscription = new Subscription<EventListener>() { // from class: com.yandex.runtime.recording.internal.EventLoggingBinding.1
        public NativeObject createNativeListener(EventListener eventListener) {
            return EventLoggingBinding.createEventListener(eventListener);
        }
    };
    private final NativeObject nativeObject;

    public EventLoggingBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createEventListener(EventListener eventListener);

    @Override // com.yandex.runtime.recording.EventLogging
    public native boolean isValid();

    @Override // com.yandex.runtime.recording.EventLogging
    public native void subscribe(@NonNull EventListener eventListener);

    @Override // com.yandex.runtime.recording.EventLogging
    public native void subscribe(@NonNull EventListener eventListener, @NonNull LoggingLevel loggingLevel);

    @Override // com.yandex.runtime.recording.EventLogging
    public native void unsubscribe(@NonNull EventListener eventListener);
}
