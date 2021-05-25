package com.avito.android.calls_shared;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/calls_shared/CallSide;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "OUTGOING", "INCOMING", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public enum CallSide {
    OUTGOING,
    INCOMING;
    
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/calls_shared/CallSide$Companion;", "", "", "isIncoming", "Lcom/avito/android/calls_shared/CallSide;", "fromBoolean", "(Z)Lcom/avito/android/calls_shared/CallSide;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CallSide fromBoolean(boolean z) {
            if (z) {
                return CallSide.INCOMING;
            }
            return CallSide.OUTGOING;
        }

        public Companion(j jVar) {
        }
    }
}
