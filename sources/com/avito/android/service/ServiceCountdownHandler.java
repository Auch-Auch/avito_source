package com.avito.android.service;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/service/ServiceCountdownHandler;", "", "", "startId", "", "onStartAction", "(I)V", "onActionDone", "()V", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "getListener", "()Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "setListener", "(Lcom/avito/android/service/ServiceCountdownHandler$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Listener", "android_release"}, k = 1, mv = {1, 4, 2})
public interface ServiceCountdownHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "", "", "onStart", "()V", "", "lastStartId", "onStop", "(I)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void onStart(@NotNull Listener listener) {
            }
        }

        void onStart();

        void onStop(int i);
    }

    @Nullable
    Listener getListener();

    void onActionDone();

    void onStartAction(int i);

    void setListener(@Nullable Listener listener);
}
