package com.avito.android.calls.voximplant.rx.core;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/ConnectionState;", "", "<init>", "()V", "Closed", "Established", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "InternalError", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$Established;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$Closed;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$Failed;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$InternalError;", "calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class ConnectionState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$Closed;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Closed extends ConnectionState {
        @NotNull
        public static final Closed INSTANCE = new Closed();

        public Closed() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$Established;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Established extends ConnectionState {
        @NotNull
        public static final Established INSTANCE = new Established();

        public Established() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$Failed;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failed extends ConnectionState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "reason");
            this.a = str;
        }

        @NotNull
        public final String getReason() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/ConnectionState$InternalError;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class InternalError extends ConnectionState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InternalError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "reason");
            this.a = str;
        }

        @NotNull
        public final String getReason() {
            return this.a;
        }
    }

    public ConnectionState() {
    }

    public ConnectionState(j jVar) {
    }
}
