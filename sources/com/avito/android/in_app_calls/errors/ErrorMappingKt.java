package com.avito.android.in_app_calls.errors;

import com.avito.android.calls.ConnectionListener;
import com.avito.android.calls_shared.AppCallResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/ConnectionListener$DisconnectReason;", "Lcom/avito/android/calls_shared/AppCallResult;", "toAppCallResult", "(Lcom/avito/android/calls/ConnectionListener$DisconnectReason;)Lcom/avito/android/calls_shared/AppCallResult;", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class ErrorMappingKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ConnectionListener.DisconnectReason.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    @NotNull
    public static final AppCallResult toAppCallResult(@NotNull ConnectionListener.DisconnectReason disconnectReason) {
        Intrinsics.checkNotNullParameter(disconnectReason, "$this$toAppCallResult");
        int ordinal = disconnectReason.ordinal();
        if (ordinal == 0) {
            return AppCallResult.Error.ConnectionClosed.INSTANCE;
        }
        if (ordinal == 1) {
            return AppCallResult.Error.ConnectionFailed.INSTANCE;
        }
        if (ordinal == 2) {
            return AppCallResult.Error.LoginFailed.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
