package com.yandex.mapkit.experiments.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.experiments.UiExperimentsListener;
import com.yandex.mapkit.experiments.UiExperimentsManager;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
import java.util.Map;
public class UiExperimentsManagerBinding implements UiExperimentsManager {
    private final NativeObject nativeObject;
    private Subscription<UiExperimentsListener> uiExperimentsListenerSubscription = new Subscription<UiExperimentsListener>() { // from class: com.yandex.mapkit.experiments.internal.UiExperimentsManagerBinding.1
        public NativeObject createNativeListener(UiExperimentsListener uiExperimentsListener) {
            return UiExperimentsManagerBinding.createUiExperimentsListener(uiExperimentsListener);
        }
    };

    public UiExperimentsManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createUiExperimentsListener(UiExperimentsListener uiExperimentsListener);

    @Override // com.yandex.mapkit.experiments.UiExperimentsManager
    @Nullable
    public native Map<String, String> getParameters();

    @Override // com.yandex.mapkit.experiments.UiExperimentsManager
    @Nullable
    public native String getValue(@NonNull String str);

    @Override // com.yandex.mapkit.experiments.UiExperimentsManager
    public native boolean isValid();

    @Override // com.yandex.mapkit.experiments.UiExperimentsManager
    public native void setValue(@NonNull String str, @NonNull String str2, @Nullable String str3);

    @Override // com.yandex.mapkit.experiments.UiExperimentsManager
    public native void subscribe(@NonNull UiExperimentsListener uiExperimentsListener);

    @Override // com.yandex.mapkit.experiments.UiExperimentsManager
    public native void unsubscribe(@NonNull UiExperimentsListener uiExperimentsListener);
}
