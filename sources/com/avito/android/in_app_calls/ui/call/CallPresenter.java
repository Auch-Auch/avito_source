package com.avito.android.in_app_calls.ui.call;

import a2.b.a.a.a;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.in_app_calls.analytics.AppCallRating;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.binder.CallManagerServiceApi;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.permissions.PermissionState;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H'¢\u0006\u0004\b\u0019\u0010\tR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001dR(\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020%0$0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001dR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001dR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001d¨\u0006/"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "", "handleStartRequest", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "answer", "()V", "decline", "hangup", "toggleMic", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "callRating", "rateCall", "(Lcom/avito/android/in_app_calls/analytics/AppCallRating;)V", "Lcom/avito/android/permissions/PermissionState;", "state", "onPermissionGranted", "(Lcom/avito/android/permissions/PermissionState;)V", "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", NotificationCompat.CATEGORY_SERVICE, "attachService", "(Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;)V", "detachService", "Landroidx/lifecycle/LiveData;", "", "getToastStream", "()Landroidx/lifecycle/LiveData;", "toastStream", "getOpenCancelReasonStream", "openCancelReasonStream", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "getPermissionRequestStream", "permissionRequestStream", "Lkotlin/Pair;", "", "getOpenDeclineReasonStream", "openDeclineReasonStream", "", "getFinishWithDelayStream", "finishWithDelayStream", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "getStartServiceStream", "startServiceStream", "State", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0015\u0016\u0017\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0001\u0005\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "", "Lcom/avito/android/calls_shared/CallSide;", "getCallSide", "()Lcom/avito/android/calls_shared/CallSide;", "callSide", "", "getSendAudio", "()Z", "sendAudio", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "", "Lcom/avito/android/calls_shared/CallId;", "getCallId", "()Ljava/lang/String;", "callId", "<init>", "()V", "Connected", "Dialing", "Finished", "Idle", "Ringing", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Idle;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Ringing;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Dialing;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Connected;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Connected;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Z", "component3", "call", "sendAudio", "isReconnecting", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;ZZ)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Connected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getSendAudio", "c", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;ZZ)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Connected extends State {
            @NotNull
            public final AppCallInfo a;
            public final boolean b;
            public final boolean c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Connected(@NotNull AppCallInfo appCallInfo, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                this.a = appCallInfo;
                this.b = z;
                this.c = z2;
            }

            public static /* synthetic */ Connected copy$default(Connected connected, AppCallInfo appCallInfo, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    appCallInfo = connected.getCall();
                }
                if ((i & 2) != 0) {
                    z = connected.getSendAudio();
                }
                if ((i & 4) != 0) {
                    z2 = connected.c;
                }
                return connected.copy(appCallInfo, z, z2);
            }

            @NotNull
            public final AppCallInfo component1() {
                return getCall();
            }

            public final boolean component2() {
                return getSendAudio();
            }

            public final boolean component3() {
                return this.c;
            }

            @NotNull
            public final Connected copy(@NotNull AppCallInfo appCallInfo, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                return new Connected(appCallInfo, z, z2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Connected)) {
                    return false;
                }
                Connected connected = (Connected) obj;
                return Intrinsics.areEqual(getCall(), connected.getCall()) && getSendAudio() == connected.getSendAudio() && this.c == connected.c;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            @NotNull
            public AppCallInfo getCall() {
                return this.a;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            public boolean getSendAudio() {
                return this.b;
            }

            public int hashCode() {
                AppCallInfo call = getCall();
                int hashCode = (call != null ? call.hashCode() : 0) * 31;
                boolean sendAudio = getSendAudio();
                int i = 1;
                if (sendAudio) {
                    sendAudio = true;
                }
                int i2 = sendAudio ? 1 : 0;
                int i3 = sendAudio ? 1 : 0;
                int i4 = sendAudio ? 1 : 0;
                int i5 = (hashCode + i2) * 31;
                boolean z = this.c;
                if (!z) {
                    i = z ? 1 : 0;
                }
                return i5 + i;
            }

            public final boolean isReconnecting() {
                return this.c;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Connected(call=");
                L.append(getCall());
                L.append(", sendAudio=");
                L.append(getSendAudio());
                L.append(", isReconnecting=");
                return a.B(L, this.c, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Dialing;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Z", "call", "sendAudio", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Dialing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", AuthSource.BOOKING_ORDER, "Z", "getSendAudio", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Dialing extends State {
            @NotNull
            public final AppCallInfo a;
            public final boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Dialing(@NotNull AppCallInfo appCallInfo, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                this.a = appCallInfo;
                this.b = z;
            }

            public static /* synthetic */ Dialing copy$default(Dialing dialing, AppCallInfo appCallInfo, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    appCallInfo = dialing.getCall();
                }
                if ((i & 2) != 0) {
                    z = dialing.getSendAudio();
                }
                return dialing.copy(appCallInfo, z);
            }

            @NotNull
            public final AppCallInfo component1() {
                return getCall();
            }

            public final boolean component2() {
                return getSendAudio();
            }

            @NotNull
            public final Dialing copy(@NotNull AppCallInfo appCallInfo, boolean z) {
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                return new Dialing(appCallInfo, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Dialing)) {
                    return false;
                }
                Dialing dialing = (Dialing) obj;
                return Intrinsics.areEqual(getCall(), dialing.getCall()) && getSendAudio() == dialing.getSendAudio();
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            @NotNull
            public AppCallInfo getCall() {
                return this.a;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            public boolean getSendAudio() {
                return this.b;
            }

            public int hashCode() {
                AppCallInfo call = getCall();
                int hashCode = (call != null ? call.hashCode() : 0) * 31;
                boolean sendAudio = getSendAudio();
                if (sendAudio) {
                    sendAudio = true;
                }
                int i = sendAudio ? 1 : 0;
                int i2 = sendAudio ? 1 : 0;
                int i3 = sendAudio ? 1 : 0;
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Dialing(call=");
                L.append(getCall());
                L.append(", sendAudio=");
                L.append(getSendAudio());
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0014\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "", AuthSource.BOOKING_ORDER, "Z", "getSendAudio", "()Z", "sendAudio", "Lcom/avito/android/calls_shared/AppCallResult;", "c", "Lcom/avito/android/calls_shared/AppCallResult;", "getResult", "()Lcom/avito/android/calls_shared/AppCallResult;", "result", "Lcom/avito/android/calls_shared/AppCallInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "Completely", "WaitingForRating", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished$WaitingForRating;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished$Completely;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Finished extends State {
            @Nullable
            public final AppCallInfo a;
            public final boolean b;
            @NotNull
            public final AppCallResult c;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished$Completely;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Z", "Lcom/avito/android/calls_shared/AppCallResult;", "component3", "()Lcom/avito/android/calls_shared/AppCallResult;", "call", "sendAudio", "result", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;ZLcom/avito/android/calls_shared/AppCallResult;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished$Completely;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "f", "Lcom/avito/android/calls_shared/AppCallResult;", "getResult", "e", "Z", "getSendAudio", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;ZLcom/avito/android/calls_shared/AppCallResult;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class Completely extends Finished {
                @Nullable
                public final AppCallInfo d;
                public final boolean e;
                @NotNull
                public final AppCallResult f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Completely(@Nullable AppCallInfo appCallInfo, boolean z, @NotNull AppCallResult appCallResult) {
                    super(appCallInfo, z, appCallResult, null);
                    Intrinsics.checkNotNullParameter(appCallResult, "result");
                    this.d = appCallInfo;
                    this.e = z;
                    this.f = appCallResult;
                }

                public static /* synthetic */ Completely copy$default(Completely completely, AppCallInfo appCallInfo, boolean z, AppCallResult appCallResult, int i, Object obj) {
                    if ((i & 1) != 0) {
                        appCallInfo = completely.getCall();
                    }
                    if ((i & 2) != 0) {
                        z = completely.getSendAudio();
                    }
                    if ((i & 4) != 0) {
                        appCallResult = completely.getResult();
                    }
                    return completely.copy(appCallInfo, z, appCallResult);
                }

                @Nullable
                public final AppCallInfo component1() {
                    return getCall();
                }

                public final boolean component2() {
                    return getSendAudio();
                }

                @NotNull
                public final AppCallResult component3() {
                    return getResult();
                }

                @NotNull
                public final Completely copy(@Nullable AppCallInfo appCallInfo, boolean z, @NotNull AppCallResult appCallResult) {
                    Intrinsics.checkNotNullParameter(appCallResult, "result");
                    return new Completely(appCallInfo, z, appCallResult);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Completely)) {
                        return false;
                    }
                    Completely completely = (Completely) obj;
                    return Intrinsics.areEqual(getCall(), completely.getCall()) && getSendAudio() == completely.getSendAudio() && Intrinsics.areEqual(getResult(), completely.getResult());
                }

                @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State.Finished, com.avito.android.in_app_calls.ui.call.CallPresenter.State
                @Nullable
                public AppCallInfo getCall() {
                    return this.d;
                }

                @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State.Finished
                @NotNull
                public AppCallResult getResult() {
                    return this.f;
                }

                @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State.Finished, com.avito.android.in_app_calls.ui.call.CallPresenter.State
                public boolean getSendAudio() {
                    return this.e;
                }

                public int hashCode() {
                    AppCallInfo call = getCall();
                    int i = 0;
                    int hashCode = (call != null ? call.hashCode() : 0) * 31;
                    boolean sendAudio = getSendAudio();
                    if (sendAudio) {
                        sendAudio = true;
                    }
                    int i2 = sendAudio ? 1 : 0;
                    int i3 = sendAudio ? 1 : 0;
                    int i4 = sendAudio ? 1 : 0;
                    int i5 = (hashCode + i2) * 31;
                    AppCallResult result = getResult();
                    if (result != null) {
                        i = result.hashCode();
                    }
                    return i5 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Completely(call=");
                    L.append(getCall());
                    L.append(", sendAudio=");
                    L.append(getSendAudio());
                    L.append(", result=");
                    L.append(getResult());
                    L.append(")");
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished$WaitingForRating;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "Lcom/avito/android/calls_shared/AppCallResult;", "component2", "()Lcom/avito/android/calls_shared/AppCallResult;", "call", "result", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Finished$WaitingForRating;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "e", "Lcom/avito/android/calls_shared/AppCallResult;", "getResult", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class WaitingForRating extends Finished {
                @NotNull
                public final AppCallInfo d;
                @NotNull
                public final AppCallResult e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public WaitingForRating(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult) {
                    super(appCallInfo, false, appCallResult, null);
                    Intrinsics.checkNotNullParameter(appCallInfo, "call");
                    Intrinsics.checkNotNullParameter(appCallResult, "result");
                    this.d = appCallInfo;
                    this.e = appCallResult;
                }

                public static /* synthetic */ WaitingForRating copy$default(WaitingForRating waitingForRating, AppCallInfo appCallInfo, AppCallResult appCallResult, int i, Object obj) {
                    if ((i & 1) != 0) {
                        appCallInfo = waitingForRating.getCall();
                    }
                    if ((i & 2) != 0) {
                        appCallResult = waitingForRating.getResult();
                    }
                    return waitingForRating.copy(appCallInfo, appCallResult);
                }

                @NotNull
                public final AppCallInfo component1() {
                    return getCall();
                }

                @NotNull
                public final AppCallResult component2() {
                    return getResult();
                }

                @NotNull
                public final WaitingForRating copy(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult) {
                    Intrinsics.checkNotNullParameter(appCallInfo, "call");
                    Intrinsics.checkNotNullParameter(appCallResult, "result");
                    return new WaitingForRating(appCallInfo, appCallResult);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof WaitingForRating)) {
                        return false;
                    }
                    WaitingForRating waitingForRating = (WaitingForRating) obj;
                    return Intrinsics.areEqual(getCall(), waitingForRating.getCall()) && Intrinsics.areEqual(getResult(), waitingForRating.getResult());
                }

                @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State.Finished, com.avito.android.in_app_calls.ui.call.CallPresenter.State
                @NotNull
                public AppCallInfo getCall() {
                    return this.d;
                }

                @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State.Finished
                @NotNull
                public AppCallResult getResult() {
                    return this.e;
                }

                public int hashCode() {
                    AppCallInfo call = getCall();
                    int i = 0;
                    int hashCode = (call != null ? call.hashCode() : 0) * 31;
                    AppCallResult result = getResult();
                    if (result != null) {
                        i = result.hashCode();
                    }
                    return hashCode + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("WaitingForRating(call=");
                    L.append(getCall());
                    L.append(", result=");
                    L.append(getResult());
                    L.append(")");
                    return L.toString();
                }
            }

            public Finished(AppCallInfo appCallInfo, boolean z, AppCallResult appCallResult, j jVar) {
                super(null);
                this.a = appCallInfo;
                this.b = z;
                this.c = appCallResult;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            @Nullable
            public AppCallInfo getCall() {
                return this.a;
            }

            @NotNull
            public AppCallResult getResult() {
                return this.c;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            public boolean getSendAudio() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Idle;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "component1", "()Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "", "component2", "()Z", "pendingRequest", "sendAudio", "copy", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;Z)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Idle;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getSendAudio", AuthSource.SEND_ABUSE, "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "getPendingRequest", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "<init>", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Idle extends State {
            @Nullable
            public final CallActivityRequest a;
            public final boolean b;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Idle(CallActivityRequest callActivityRequest, boolean z, int i, j jVar) {
                this((i & 1) != 0 ? null : callActivityRequest, z);
            }

            public static /* synthetic */ Idle copy$default(Idle idle, CallActivityRequest callActivityRequest, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    callActivityRequest = idle.a;
                }
                if ((i & 2) != 0) {
                    z = idle.getSendAudio();
                }
                return idle.copy(callActivityRequest, z);
            }

            @Nullable
            public final CallActivityRequest component1() {
                return this.a;
            }

            public final boolean component2() {
                return getSendAudio();
            }

            @NotNull
            public final Idle copy(@Nullable CallActivityRequest callActivityRequest, boolean z) {
                return new Idle(callActivityRequest, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Idle)) {
                    return false;
                }
                Idle idle = (Idle) obj;
                return Intrinsics.areEqual(this.a, idle.a) && getSendAudio() == idle.getSendAudio();
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            @Nullable
            public AppCallInfo getCall() {
                CallActivityRequest callActivityRequest = this.a;
                if (!(callActivityRequest instanceof CallActivityRequest.Dial)) {
                    callActivityRequest = null;
                }
                CallActivityRequest.Dial dial = (CallActivityRequest.Dial) callActivityRequest;
                if (dial != null) {
                    return CallPresenterKt.asCallInfo(dial);
                }
                return null;
            }

            @Nullable
            public final CallActivityRequest getPendingRequest() {
                return this.a;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            public boolean getSendAudio() {
                return this.b;
            }

            public int hashCode() {
                CallActivityRequest callActivityRequest = this.a;
                int hashCode = (callActivityRequest != null ? callActivityRequest.hashCode() : 0) * 31;
                boolean sendAudio = getSendAudio();
                if (sendAudio) {
                    sendAudio = true;
                }
                int i = sendAudio ? 1 : 0;
                int i2 = sendAudio ? 1 : 0;
                int i3 = sendAudio ? 1 : 0;
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Idle(pendingRequest=");
                L.append(this.a);
                L.append(", sendAudio=");
                L.append(getSendAudio());
                L.append(")");
                return L.toString();
            }

            public Idle(@Nullable CallActivityRequest callActivityRequest, boolean z) {
                super(null);
                this.a = callActivityRequest;
                this.b = z;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Ringing;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State$Ringing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "getSendAudio", "()Z", "sendAudio", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Ringing extends State {
            public final boolean a = true;
            @NotNull
            public final AppCallInfo b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ringing(@NotNull AppCallInfo appCallInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                this.b = appCallInfo;
            }

            public static /* synthetic */ Ringing copy$default(Ringing ringing, AppCallInfo appCallInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    appCallInfo = ringing.getCall();
                }
                return ringing.copy(appCallInfo);
            }

            @NotNull
            public final AppCallInfo component1() {
                return getCall();
            }

            @NotNull
            public final Ringing copy(@NotNull AppCallInfo appCallInfo) {
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                return new Ringing(appCallInfo);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Ringing) && Intrinsics.areEqual(getCall(), ((Ringing) obj).getCall());
                }
                return true;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            @NotNull
            public AppCallInfo getCall() {
                return this.b;
            }

            @Override // com.avito.android.in_app_calls.ui.call.CallPresenter.State
            public boolean getSendAudio() {
                return this.a;
            }

            public int hashCode() {
                AppCallInfo call = getCall();
                if (call != null) {
                    return call.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Ringing(call=");
                L.append(getCall());
                L.append(")");
                return L.toString();
            }
        }

        public State() {
        }

        @Nullable
        public abstract AppCallInfo getCall();

        @Nullable
        public final String getCallId() {
            if (this instanceof Idle) {
                CallActivityRequest pendingRequest = ((Idle) this).getPendingRequest();
                if (pendingRequest != null) {
                    return pendingRequest.getCallUuid();
                }
                return null;
            }
            AppCallInfo call = getCall();
            if (call != null) {
                return call.getCallId();
            }
            return null;
        }

        @Nullable
        public final CallSide getCallSide() {
            if (this instanceof Idle) {
                CallActivityRequest pendingRequest = ((Idle) this).getPendingRequest();
                if (pendingRequest != null) {
                    return pendingRequest.getCallSide();
                }
                return null;
            }
            AppCallInfo call = getCall();
            if (call == null) {
                return null;
            }
            return CallSide.Companion.fromBoolean(call.isIncoming());
        }

        public abstract boolean getSendAudio();

        public State(j jVar) {
        }
    }

    void answer();

    @MainThread
    void attachService(@NotNull CallManagerServiceApi callManagerServiceApi);

    void decline();

    @MainThread
    void detachService();

    @NotNull
    LiveData<Boolean> getFinishWithDelayStream();

    @NotNull
    LiveData<String> getOpenCancelReasonStream();

    @NotNull
    LiveData<Pair<String, Integer>> getOpenDeclineReasonStream();

    @NotNull
    LiveData<CallPermissionsManager.PermissionRequest> getPermissionRequestStream();

    @NotNull
    LiveData<CallManagerService.StartRequest> getStartServiceStream();

    @NotNull
    LiveData<String> getToastStream();

    void handleStartRequest(@NotNull CallActivityRequest callActivityRequest);

    void hangup();

    void onPermissionGranted(@NotNull PermissionState permissionState);

    void rateCall(@NotNull AppCallRating appCallRating);

    void toggleMic();
}
