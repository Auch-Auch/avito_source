package com.avito.android.calls_shared.analytics.mapping;

import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.analytics.events.AppCallEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "mapForEvent", "(Lcom/avito/android/calls_shared/AppCallResult;)Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "calls-shared_release"}, k = 2, mv = {1, 4, 2})
public final class AppCallResultMappersKt {
    @NotNull
    public static final AppCallEventType.Disconnected mapForEvent(@NotNull AppCallResult appCallResult) {
        AppCallEventType.Disconnected.Error error;
        Intrinsics.checkNotNullParameter(appCallResult, "$this$mapForEvent");
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Busy.System.INSTANCE)) {
            return AppCallEventType.Disconnected.BusySystem.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Busy.App.INSTANCE)) {
            return AppCallEventType.Disconnected.BusyApp.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Hangup.NonUserHangup.INSTANCE)) {
            return AppCallEventType.Disconnected.NonUserHangup.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Hangup.HangupReceiver.INSTANCE)) {
            return AppCallEventType.Disconnected.HangupReceiver.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Hangup.HangupCallerEarly.INSTANCE)) {
            return AppCallEventType.Disconnected.HangupCallerEarly.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Hangup.HangupCaller.INSTANCE)) {
            return AppCallEventType.Disconnected.HangupCaller.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Hangup.HangupWhileReconnecting.INSTANCE)) {
            return AppCallEventType.Disconnected.HangupWhileReconnecting.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Declined.INSTANCE)) {
            return AppCallEventType.Disconnected.Declined.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.NotAvailable.INSTANCE)) {
            return AppCallEventType.Disconnected.NotAvailable.INSTANCE;
        }
        if (Intrinsics.areEqual(appCallResult, AppCallResult.Timeout.INSTANCE)) {
            return AppCallEventType.Disconnected.Timeout.INSTANCE;
        }
        if (appCallResult instanceof AppCallResult.Other) {
            error = new AppCallEventType.Disconnected.Error(String.valueOf(((AppCallResult.Other) appCallResult).getCode()));
        } else if (appCallResult instanceof AppCallResult.Error) {
            error = new AppCallEventType.Disconnected.Error(((AppCallResult.Error) appCallResult).getClass().getSimpleName());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return error;
    }
}
