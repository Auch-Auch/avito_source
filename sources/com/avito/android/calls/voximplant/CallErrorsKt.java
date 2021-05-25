package com.avito.android.calls.voximplant;

import com.avito.android.calls.AvitoCallError;
import com.avito.android.calls.Call;
import com.voximplant.sdk.call.CallError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/voximplant/sdk/call/CallError;", "Lcom/avito/android/calls/AvitoCallError;", "convert", "(Lcom/voximplant/sdk/call/CallError;)Lcom/avito/android/calls/AvitoCallError;", "", "code", "", "message", "Lcom/avito/android/calls/Call$Failure;", "convertCallFailure", "(ILjava/lang/String;)Lcom/avito/android/calls/Call$Failure;", "calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallErrorsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CallError.values();
            int[] iArr = new int[8];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[3] = 2;
            iArr[5] = 3;
            iArr[6] = 4;
            iArr[7] = 5;
            iArr[4] = 6;
            iArr[0] = 7;
            iArr[1] = 8;
        }
    }

    @NotNull
    public static final AvitoCallError convert(@NotNull CallError callError) {
        Intrinsics.checkNotNullParameter(callError, "$this$convert");
        switch (callError.ordinal()) {
            case 0:
            case 1:
            case 4:
                return AvitoCallError.OTHER;
            case 2:
                return AvitoCallError.INCORRECT_OPERATION;
            case 3:
                return AvitoCallError.INTERNAL_ERROR;
            case 5:
                return AvitoCallError.MISSING_PERMISSION;
            case 6:
                return AvitoCallError.REJECTED;
            case 7:
                return AvitoCallError.TIMEOUT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final Call.Failure convertCallFailure(int i, @Nullable String str) {
        if (i == 408) {
            return Call.Failure.Timeout.INSTANCE;
        }
        if (i == 480) {
            return Call.Failure.Unavailable.INSTANCE;
        }
        if (i == 603) {
            return Call.Failure.Rejected.INSTANCE;
        }
        if (i == 486) {
            return Call.Failure.Busy.INSTANCE;
        }
        if (i != 487) {
            return new Call.Failure.Other(i, str);
        }
        return Call.Failure.Terminated.INSTANCE;
    }
}
