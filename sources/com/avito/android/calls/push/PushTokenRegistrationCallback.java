package com.avito.android.calls.push;

import io.reactivex.rxjava3.core.Completable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "", "Lio/reactivex/rxjava3/core/Completable;", "onPushTokenRegistered", "()Lio/reactivex/rxjava3/core/Completable;", "onPushTokenUnregistered", "Dummy", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface PushTokenRegistrationCallback {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/calls/push/PushTokenRegistrationCallback$Dummy;", "Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "Lio/reactivex/rxjava3/core/Completable;", "onPushTokenRegistered", "()Lio/reactivex/rxjava3/core/Completable;", "onPushTokenUnregistered", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dummy implements PushTokenRegistrationCallback {
        @Override // com.avito.android.calls.push.PushTokenRegistrationCallback
        @NotNull
        public Completable onPushTokenRegistered() {
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        }

        @Override // com.avito.android.calls.push.PushTokenRegistrationCallback
        @NotNull
        public Completable onPushTokenUnregistered() {
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        }
    }

    @NotNull
    Completable onPushTokenRegistered();

    @NotNull
    Completable onPushTokenUnregistered();
}
