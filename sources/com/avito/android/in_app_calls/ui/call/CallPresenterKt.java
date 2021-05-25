package com.avito.android.in_app_calls.ui.call;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "Lcom/avito/android/calls_shared/AppCallInfo;", "asCallInfo", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;)Lcom/avito/android/calls_shared/AppCallInfo;", "", "MIN_CALL_DURATION_FOR_CANCEL_REASON_MS", "J", "MIN_RATABLE_CALL_DURATION_MS", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallPresenterKt {
    public static final long MIN_CALL_DURATION_FOR_CANCEL_REASON_MS = 3500;
    public static final long MIN_RATABLE_CALL_DURATION_MS = 1000;

    @Nullable
    public static final AppCallInfo asCallInfo(@NotNull CallActivityRequest.Dial dial) {
        Intrinsics.checkNotNullParameter(dial, "$this$asCallInfo");
        if (dial instanceof CallActivityRequest.Dial.NewCall) {
            CallActivityRequest.Dial.NewCall newCall = (CallActivityRequest.Dial.NewCall) dial;
            return new AppCallInfo(dial.getCallUuid(), false, newCall.getRecipient(), 0, dial.getScenario(), null, null, newCall.getItem(), 96, null);
        } else if (dial instanceof CallActivityRequest.Dial.ByPreviousCall) {
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
