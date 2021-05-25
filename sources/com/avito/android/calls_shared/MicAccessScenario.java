package com.avito.android.calls_shared;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/calls_shared/MicAccessScenario;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "ITEM_PUBLISHING", "INCOMING_CALL", "OUTGOING_CALL", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public enum MicAccessScenario {
    ITEM_PUBLISHING,
    INCOMING_CALL,
    OUTGOING_CALL;
    
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/calls_shared/MicAccessScenario$Companion;", "", "Lcom/avito/android/calls_shared/CallSide;", "callSide", "Lcom/avito/android/calls_shared/MicAccessScenario;", "fromCallSide", "(Lcom/avito/android/calls_shared/CallSide;)Lcom/avito/android/calls_shared/MicAccessScenario;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                CallSide.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                CallSide callSide = CallSide.OUTGOING;
                iArr[0] = 1;
                CallSide callSide2 = CallSide.INCOMING;
                iArr[1] = 2;
            }
        }

        public Companion() {
        }

        @NotNull
        public final MicAccessScenario fromCallSide(@NotNull CallSide callSide) {
            Intrinsics.checkNotNullParameter(callSide, "callSide");
            int ordinal = callSide.ordinal();
            if (ordinal == 0) {
                return MicAccessScenario.OUTGOING_CALL;
            }
            if (ordinal == 1) {
                return MicAccessScenario.INCOMING_CALL;
            }
            throw new NoWhenBranchMatchedException();
        }

        public Companion(j jVar) {
        }
    }
}
