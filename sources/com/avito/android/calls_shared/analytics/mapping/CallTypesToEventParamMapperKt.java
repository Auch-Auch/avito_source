package com.avito.android.calls_shared.analytics.mapping;

import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.MicAccessScenario;
import com.avito.android.messenger.analytics.OpenUserProfileEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u001a\u0010\u0004\u001a\u00020\b*\u00020\u00078@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/calls_shared/MicAccessScenario;", "", "getEventValue", "(Lcom/avito/android/calls_shared/MicAccessScenario;)Ljava/lang/String;", "eventValue", "Lcom/avito/android/calls_shared/AppCallScenario;", "(Lcom/avito/android/calls_shared/AppCallScenario;)Ljava/lang/String;", "Lcom/avito/android/calls_shared/CallSide;", "", "(Lcom/avito/android/calls_shared/CallSide;)I", "calls-shared_release"}, k = 2, mv = {1, 4, 2})
public final class CallTypesToEventParamMapperKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            CallSide.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            CallSide callSide = CallSide.OUTGOING;
            iArr[0] = 1;
            CallSide callSide2 = CallSide.INCOMING;
            iArr[1] = 2;
            AppCallScenario.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
            iArr2[3] = 4;
            iArr2[4] = 5;
            iArr2[5] = 6;
            iArr2[6] = 7;
            MicAccessScenario.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            MicAccessScenario micAccessScenario = MicAccessScenario.ITEM_PUBLISHING;
            iArr3[0] = 1;
            MicAccessScenario micAccessScenario2 = MicAccessScenario.INCOMING_CALL;
            iArr3[1] = 2;
            MicAccessScenario micAccessScenario3 = MicAccessScenario.OUTGOING_CALL;
            iArr3[2] = 3;
        }
    }

    public static final int getEventValue(@NotNull CallSide callSide) {
        Intrinsics.checkNotNullParameter(callSide, "$this$eventValue");
        int ordinal = callSide.ordinal();
        if (ordinal == 0) {
            return 1;
        }
        if (ordinal == 1) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final String getEventValue(@NotNull AppCallScenario appCallScenario) {
        Intrinsics.checkNotNullParameter(appCallScenario, "$this$eventValue");
        switch (appCallScenario.ordinal()) {
            case 0:
                return OpenUserProfileEvent.SOURCE_MESSENGER_MENU;
            case 1:
                return "messenger_chat_long_answer";
            case 2:
                return "item";
            case 3:
                return "item_gallery";
            case 4:
                return "deeplink_call_back";
            case 5:
                return "notification_call_back";
            case 6:
                return "incoming_call";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final String getEventValue(@NotNull MicAccessScenario micAccessScenario) {
        Intrinsics.checkNotNullParameter(micAccessScenario, "$this$eventValue");
        int ordinal = micAccessScenario.ordinal();
        if (ordinal == 0) {
            return "item_publishing";
        }
        if (ordinal == 1) {
            return "incoming_call";
        }
        if (ordinal == 2) {
            return "outgoing_call";
        }
        throw new NoWhenBranchMatchedException();
    }
}
