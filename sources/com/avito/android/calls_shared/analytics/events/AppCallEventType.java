package com.avito.android.calls_shared.analytics.events;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "", "", AuthSource.SEND_ABUSE, "I", "getId", "()I", "id", "Connected", "Disconnected", "Reconnecting", "Start", "Waiting", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Start;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Waiting;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Connected;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Reconnecting;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public abstract class AppCallEventType {
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Connected;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Connected extends AppCallEventType {
        @NotNull
        public static final Connected INSTANCE = new Connected();

        public Connected() {
            super(3, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u000b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getResult", "()Ljava/lang/String;", "result", "BusyApp", "BusySystem", "Declined", "Error", "HangupCaller", "HangupCallerEarly", "HangupReceiver", "HangupWhileReconnecting", "NonUserHangup", "NotAvailable", "Timeout", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$BusySystem;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$BusyApp;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$NonUserHangup;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupCallerEarly;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupCaller;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupReceiver;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupWhileReconnecting;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Declined;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$NotAvailable;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Timeout;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Error;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Disconnected extends AppCallEventType {
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$BusyApp;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class BusyApp extends Disconnected {
            @NotNull
            public static final BusyApp INSTANCE = new BusyApp();

            public BusyApp() {
                super("BusyApp", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$BusySystem;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class BusySystem extends Disconnected {
            @NotNull
            public static final BusySystem INSTANCE = new BusySystem();

            public BusySystem() {
                super("BusySystem", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Declined;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class Declined extends Disconnected {
            @NotNull
            public static final Declined INSTANCE = new Declined();

            public Declined() {
                super("Declined", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Error;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "", "component1", "()Ljava/lang/String;", "reason", "copy", "(Ljava/lang/String;)Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getReason", "<init>", "(Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Disconnected {
            @Nullable
            public final String c;

            public Error() {
                this(null, 1, null);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Error(@org.jetbrains.annotations.Nullable java.lang.String r3) {
                /*
                    r2 = this;
                    if (r3 == 0) goto L_0x000b
                    java.lang.String r0 = "Error_"
                    java.lang.String r0 = a2.b.a.a.a.c3(r0, r3)
                    if (r0 == 0) goto L_0x000b
                    goto L_0x000d
                L_0x000b:
                    java.lang.String r0 = "Error"
                L_0x000d:
                    r1 = 0
                    r2.<init>(r0, r1)
                    r2.c = r3
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls_shared.analytics.events.AppCallEventType.Disconnected.Error.<init>(java.lang.String):void");
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.c;
                }
                return error.copy(str);
            }

            @Nullable
            public final String component1() {
                return this.c;
            }

            @NotNull
            public final Error copy(@Nullable String str) {
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.c, ((Error) obj).c);
                }
                return true;
            }

            @Nullable
            public final String getReason() {
                return this.c;
            }

            public int hashCode() {
                String str = this.c;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Error(reason="), this.c, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Error(String str, int i, j jVar) {
                this((i & 1) != 0 ? null : str);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupCaller;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupCaller extends Disconnected {
            @NotNull
            public static final HangupCaller INSTANCE = new HangupCaller();

            public HangupCaller() {
                super("Hangup_Caller", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupCallerEarly;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupCallerEarly extends Disconnected {
            @NotNull
            public static final HangupCallerEarly INSTANCE = new HangupCallerEarly();

            public HangupCallerEarly() {
                super("Hangup_Caller_Early", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupReceiver;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupReceiver extends Disconnected {
            @NotNull
            public static final HangupReceiver INSTANCE = new HangupReceiver();

            public HangupReceiver() {
                super("Hangup_Receiver", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$HangupWhileReconnecting;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupWhileReconnecting extends Disconnected {
            @NotNull
            public static final HangupWhileReconnecting INSTANCE = new HangupWhileReconnecting();

            public HangupWhileReconnecting() {
                super("Hangup_While_Reconnecting", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$NonUserHangup;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class NonUserHangup extends Disconnected {
            @NotNull
            public static final NonUserHangup INSTANCE = new NonUserHangup();

            public NonUserHangup() {
                super("Hangup_Non_User", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$NotAvailable;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class NotAvailable extends Disconnected {
            @NotNull
            public static final NotAvailable INSTANCE = new NotAvailable();

            public NotAvailable() {
                super("NotAvailable", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected$Timeout;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Disconnected;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class Timeout extends Disconnected {
            @NotNull
            public static final Timeout INSTANCE = new Timeout();

            public Timeout() {
                super("Timeout", null);
            }
        }

        public Disconnected(String str, j jVar) {
            super(5, null);
            this.b = str;
        }

        @NotNull
        public final String getResult() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Reconnecting;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Reconnecting extends AppCallEventType {
        @NotNull
        public static final Reconnecting INSTANCE = new Reconnecting();

        public Reconnecting() {
            super(4, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Start;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Start extends AppCallEventType {
        @NotNull
        public static final Start INSTANCE = new Start();

        public Start() {
            super(1, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/events/AppCallEventType$Waiting;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Waiting extends AppCallEventType {
        @NotNull
        public static final Waiting INSTANCE = new Waiting();

        public Waiting() {
            super(2, null);
        }
    }

    public AppCallEventType(int i, j jVar) {
        this.a = i;
    }

    public final int getId() {
        return this.a;
    }
}
