package com.avito.android.in_app_calls;

import com.avito.android.in_app_calls.CallManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0018\u0010\u0002\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State;", "", "isBusy", "(Lcom/avito/android/in_app_calls/CallManager$State;)Z", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallManagerKt {
    public static final boolean isBusy(@NotNull CallManager.State state) {
        Intrinsics.checkNotNullParameter(state, "$this$isBusy");
        return (state instanceof CallManager.State.InCall) || ((state instanceof CallManager.State.Idle.None) && ((CallManager.State.Idle.None) state).getCallRequest() != null);
    }
}
