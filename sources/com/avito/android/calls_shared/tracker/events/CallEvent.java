package com.avito.android.calls_shared.tracker.events;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dR\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u0001\u000f\u001e\u001f !\"#$%&'()*+,¨\u0006-"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "", "Lcom/avito/android/calls_shared/CallId;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Lcom/avito/android/calls_shared/CallSide;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/CallSide;", "getSide", "()Lcom/avito/android/calls_shared/CallSide;", "side", "CallProcessStarted", "Connected", "ConnectedToVoximplant", "Dialing", "Disconnected", "GreenButtonClicked", "IncomingCallReceived", "MicPermissionResult", "PermissionChecked", "PushReceived", "Reconnecting", "RedButtonClicked", "Registered", "Ringing", "ScreenOpened", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$ScreenOpened;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$MicPermissionResult;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$PermissionChecked;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$Registered;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$CallProcessStarted;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$ConnectedToVoximplant;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$Dialing;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$Connected;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$Reconnecting;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$Disconnected;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$PushReceived;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$IncomingCallReceived;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$Ringing;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$GreenButtonClicked;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent$RedButtonClicked;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public abstract class CallEvent {
    @NotNull
    public final String a;
    @NotNull
    public final CallSide b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$CallProcessStarted;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallProcessStarted extends CallEvent {
        @NotNull
        public final AppCallInfo c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CallProcessStarted(@NotNull AppCallInfo appCallInfo) {
            super(appCallInfo.getCallId(), CallSide.Companion.fromBoolean(appCallInfo.isIncoming()), null);
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            this.c = appCallInfo;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$Connected;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "d", "Z", "isReconnect", "()Z", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Connected extends CallEvent {
        @NotNull
        public final AppCallInfo c;
        public final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Connected(@NotNull AppCallInfo appCallInfo, boolean z) {
            super(appCallInfo.getCallId(), CallSide.Companion.fromBoolean(appCallInfo.isIncoming()), null);
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            this.c = appCallInfo;
            this.d = z;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }

        public final boolean isReconnect() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$ConnectedToVoximplant;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "Lcom/avito/android/calls_shared/CallId;", "id", "Lcom/avito/android/calls_shared/CallSide;", "side", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallSide;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class ConnectedToVoximplant extends CallEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConnectedToVoximplant(@NotNull String str, @NotNull CallSide callSide) {
            super(str, callSide, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(callSide, "side");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$Dialing;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dialing extends CallEvent {
        @NotNull
        public final AppCallInfo c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Dialing(@NotNull AppCallInfo appCallInfo) {
            super(appCallInfo.getCallId(), CallSide.OUTGOING, null);
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            this.c = appCallInfo;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$Disconnected;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "Lcom/avito/android/calls_shared/AppCallResult;", "d", "Lcom/avito/android/calls_shared/AppCallResult;", "getResult", "()Lcom/avito/android/calls_shared/AppCallResult;", "result", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Disconnected extends CallEvent {
        @NotNull
        public final AppCallInfo c;
        @NotNull
        public final AppCallResult d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Disconnected(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult) {
            super(appCallInfo.getCallId(), CallSide.Companion.fromBoolean(appCallInfo.isIncoming()), null);
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            Intrinsics.checkNotNullParameter(appCallResult, "result");
            this.c = appCallInfo;
            this.d = appCallResult;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }

        @NotNull
        public final AppCallResult getResult() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$GreenButtonClicked;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "c", "Z", "getFromAppUi", "()Z", "fromAppUi", "", "Lcom/avito/android/calls_shared/CallId;", "id", "<init>", "(ZLjava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class GreenButtonClicked extends CallEvent {
        public final boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GreenButtonClicked(boolean z, @NotNull String str) {
            super(str, CallSide.INCOMING, null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.c = z;
        }

        public final boolean getFromAppUi() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$IncomingCallReceived;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "Lcom/avito/android/calls_shared/CallId;", "id", "<init>", "(Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncomingCallReceived extends CallEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingCallReceived(@NotNull String str) {
            super(str, CallSide.INCOMING, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$MicPermissionResult;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallInfo;", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "", "c", "Z", "getWasGranted", "()Z", "wasGranted", "", "Lcom/avito/android/calls_shared/CallId;", "callId", "Lcom/avito/android/calls_shared/CallSide;", "callSide", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallSide;ZLcom/avito/android/calls_shared/AppCallInfo;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class MicPermissionResult extends CallEvent {
        public final boolean c;
        @Nullable
        public final AppCallInfo d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MicPermissionResult(@NotNull String str, @NotNull CallSide callSide, boolean z, @Nullable AppCallInfo appCallInfo) {
            super(str, callSide, null);
            Intrinsics.checkNotNullParameter(str, "callId");
            Intrinsics.checkNotNullParameter(callSide, "callSide");
            this.c = z;
            this.d = appCallInfo;
        }

        @Nullable
        public final AppCallInfo getInfo() {
            return this.d;
        }

        public final boolean getWasGranted() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$PermissionChecked;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "Lcom/avito/android/calls_shared/CallId;", "id", "Lcom/avito/android/calls_shared/CallSide;", "side", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallSide;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class PermissionChecked extends CallEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PermissionChecked(@NotNull String str, @NotNull CallSide callSide) {
            super(str, callSide, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(callSide, "side");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\"\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001b\u0010%\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018¨\u0006("}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$PushReceived;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "d", "I", "getTtl", "()I", Constants.FirelogAnalytics.PARAM_TTL, "", "h", "Z", "getNotificationsEnabled", "()Z", "notificationsEnabled", "", g.a, "J", "getSentTimestamp", "()J", "sentTimestamp", "", "e", "Ljava/lang/String;", "getSentPriority", "()Ljava/lang/String;", "sentPriority", "f", "getReceivedPriority", "receivedPriority", "j", "getVoxUserId", "voxUserId", "c", "getPushId", "pushId", "i", "getVoxCallId", "voxCallId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class PushReceived extends CallEvent {
        @NotNull
        public final String c;
        public final int d;
        @NotNull
        public final String e;
        @NotNull
        public final String f;
        public final long g;
        public final boolean h;
        @Nullable
        public final String i;
        @Nullable
        public final String j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PushReceived(@NotNull String str, int i2, @NotNull String str2, @NotNull String str3, long j2, boolean z, @Nullable String str4, @Nullable String str5) {
            super("", CallSide.INCOMING, null);
            a.Z0(str, "pushId", str2, "sentPriority", str3, "receivedPriority");
            this.c = str;
            this.d = i2;
            this.e = str2;
            this.f = str3;
            this.g = j2;
            this.h = z;
            this.i = str4;
            this.j = str5;
        }

        public final boolean getNotificationsEnabled() {
            return this.h;
        }

        @NotNull
        public final String getPushId() {
            return this.c;
        }

        @NotNull
        public final String getReceivedPriority() {
            return this.f;
        }

        @NotNull
        public final String getSentPriority() {
            return this.e;
        }

        public final long getSentTimestamp() {
            return this.g;
        }

        public final int getTtl() {
            return this.d;
        }

        @Nullable
        public final String getVoxCallId() {
            return this.i;
        }

        @Nullable
        public final String getVoxUserId() {
            return this.j;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$Reconnecting;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Reconnecting extends CallEvent {
        @NotNull
        public final AppCallInfo c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Reconnecting(@NotNull AppCallInfo appCallInfo) {
            super(appCallInfo.getCallId(), CallSide.Companion.fromBoolean(appCallInfo.isIncoming()), null);
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            this.c = appCallInfo;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$RedButtonClicked;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "d", "Z", "getFromAppUi", "()Z", "fromAppUi", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class RedButtonClicked extends CallEvent {
        @Nullable
        public final AppCallInfo c;
        public final boolean d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RedButtonClicked(@org.jetbrains.annotations.Nullable com.avito.android.calls_shared.AppCallInfo r5, boolean r6) {
            /*
                r4 = this;
                r0 = 0
                if (r5 == 0) goto L_0x0008
                java.lang.String r1 = r5.getCallId()
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 == 0) goto L_0x000c
                goto L_0x000e
            L_0x000c:
                java.lang.String r1 = ""
            L_0x000e:
                com.avito.android.calls_shared.CallSide$Companion r2 = com.avito.android.calls_shared.CallSide.Companion
                if (r5 == 0) goto L_0x0017
                boolean r3 = r5.isIncoming()
                goto L_0x0018
            L_0x0017:
                r3 = 0
            L_0x0018:
                com.avito.android.calls_shared.CallSide r2 = r2.fromBoolean(r3)
                r4.<init>(r1, r2, r0)
                r4.c = r5
                r4.d = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls_shared.tracker.events.CallEvent.RedButtonClicked.<init>(com.avito.android.calls_shared.AppCallInfo, boolean):void");
        }

        public final boolean getFromAppUi() {
            return this.d;
        }

        @Nullable
        public final AppCallInfo getInfo() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$Registered;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "", "Lcom/avito/android/calls_shared/CallId;", "id", "<init>", "(Ljava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Registered extends CallEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Registered(@NotNull String str) {
            super(str, CallSide.OUTGOING, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$Ringing;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallInfo;", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "", "d", "Z", "getAreNotificationsAllowed", "()Z", "areNotificationsAllowed", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ringing extends CallEvent {
        @NotNull
        public final AppCallInfo c;
        public final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ringing(@NotNull AppCallInfo appCallInfo, boolean z) {
            super(appCallInfo.getCallId(), CallSide.INCOMING, null);
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            this.c = appCallInfo;
            this.d = z;
        }

        public final boolean getAreNotificationsAllowed() {
            return this.d;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEvent$ScreenOpened;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "Lcom/avito/android/calls_shared/AppCallScenario;", "c", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "()Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "", "Lcom/avito/android/calls_shared/CallId;", "id", "Lcom/avito/android/calls_shared/CallSide;", "side", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallSide;Lcom/avito/android/calls_shared/AppCallScenario;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class ScreenOpened extends CallEvent {
        @NotNull
        public final AppCallScenario c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreenOpened(@NotNull String str, @NotNull CallSide callSide, @NotNull AppCallScenario appCallScenario) {
            super(str, callSide, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(callSide, "side");
            Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
            this.c = appCallScenario;
        }

        @NotNull
        public final AppCallScenario getScenario() {
            return this.c;
        }
    }

    public CallEvent(String str, CallSide callSide, j jVar) {
        this.a = str;
        this.b = callSide;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final CallSide getSide() {
        return this.b;
    }
}
