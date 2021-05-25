package com.avito.android.in_app_calls;

import a2.b.a.a.a;
import com.avito.android.calls.CallVideoStream;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.push.Push;
import com.avito.android.push.PushToken;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ImagesContract;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006234567J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\tJ#\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0010H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H&¢\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u0005H&¢\u0006\u0004\b$\u0010\tJ\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0003H&¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0010H&¢\u0006\u0004\b\u001c\u0010(J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*2\b\b\u0002\u0010)\u001a\u00020\u0010H&¢\u0006\u0004\b+\u0010,R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00068"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/in_app_calls/CallManager$State;", "", ChannelContext.Item.USER_ID, "", "register", "(Ljava/lang/String;)V", "unregister", "()V", "Lcom/avito/android/push/PushToken;", "pushToken", "updatePushToken", "(Lcom/avito/android/push/PushToken;)V", "Lcom/avito/android/push/Push;", "push", "", "startFromPush", "(Lcom/avito/android/push/Push;)Z", "startForReconnect", "disconnectWhenIdle", "Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "callAs", "makeCall", "(Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;)V", "onIncomingCall", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "enableMic", "onReconnectCall", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "update", "updateCallInfo", "(Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;)V", "answerCall", "declineCall", "reason", "hangupCall", "enable", "(Z)V", "enableVideo", "", "getMissingPermissions", "(Z)Ljava/util/List;", "Lio/reactivex/Observable;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallData;", "getMissedCallsStream", "()Lio/reactivex/Observable;", "missedCallsStream", "CallInfoUpdate", "CallSipInfo", "MissedCallData", "MissedCallReason", "State", "VideoStreams", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallManager extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/CallerInfo;", "component2", "()Lcom/avito/android/calls_shared/CallerInfo;", "component3", "Lcom/avito/android/calls_shared/ItemInfo;", "component4", "()Lcom/avito/android/calls_shared/ItemInfo;", "callUuid", "caller", "recipient", "item", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;)Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/CallerInfo;", "getCaller", "c", "getRecipient", "d", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallUuid", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallInfoUpdate {
        @NotNull
        public final String a;
        @NotNull
        public final CallerInfo b;
        @NotNull
        public final CallerInfo c;
        @Nullable
        public final ItemInfo d;

        public CallInfoUpdate(@NotNull String str, @NotNull CallerInfo callerInfo, @NotNull CallerInfo callerInfo2, @Nullable ItemInfo itemInfo) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(callerInfo, "caller");
            Intrinsics.checkNotNullParameter(callerInfo2, "recipient");
            this.a = str;
            this.b = callerInfo;
            this.c = callerInfo2;
            this.d = itemInfo;
        }

        public static /* synthetic */ CallInfoUpdate copy$default(CallInfoUpdate callInfoUpdate, String str, CallerInfo callerInfo, CallerInfo callerInfo2, ItemInfo itemInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = callInfoUpdate.a;
            }
            if ((i & 2) != 0) {
                callerInfo = callInfoUpdate.b;
            }
            if ((i & 4) != 0) {
                callerInfo2 = callInfoUpdate.c;
            }
            if ((i & 8) != 0) {
                itemInfo = callInfoUpdate.d;
            }
            return callInfoUpdate.copy(str, callerInfo, callerInfo2, itemInfo);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final CallerInfo component2() {
            return this.b;
        }

        @NotNull
        public final CallerInfo component3() {
            return this.c;
        }

        @Nullable
        public final ItemInfo component4() {
            return this.d;
        }

        @NotNull
        public final CallInfoUpdate copy(@NotNull String str, @NotNull CallerInfo callerInfo, @NotNull CallerInfo callerInfo2, @Nullable ItemInfo itemInfo) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(callerInfo, "caller");
            Intrinsics.checkNotNullParameter(callerInfo2, "recipient");
            return new CallInfoUpdate(str, callerInfo, callerInfo2, itemInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CallInfoUpdate)) {
                return false;
            }
            CallInfoUpdate callInfoUpdate = (CallInfoUpdate) obj;
            return Intrinsics.areEqual(this.a, callInfoUpdate.a) && Intrinsics.areEqual(this.b, callInfoUpdate.b) && Intrinsics.areEqual(this.c, callInfoUpdate.c) && Intrinsics.areEqual(this.d, callInfoUpdate.d);
        }

        @NotNull
        public final String getCallUuid() {
            return this.a;
        }

        @NotNull
        public final CallerInfo getCaller() {
            return this.b;
        }

        @Nullable
        public final ItemInfo getItem() {
            return this.d;
        }

        @NotNull
        public final CallerInfo getRecipient() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            CallerInfo callerInfo = this.b;
            int hashCode2 = (hashCode + (callerInfo != null ? callerInfo.hashCode() : 0)) * 31;
            CallerInfo callerInfo2 = this.c;
            int hashCode3 = (hashCode2 + (callerInfo2 != null ? callerInfo2.hashCode() : 0)) * 31;
            ItemInfo itemInfo = this.d;
            if (itemInfo != null) {
                i = itemInfo.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CallInfoUpdate(callUuid=");
            L.append(this.a);
            L.append(", caller=");
            L.append(this.b);
            L.append(", recipient=");
            L.append(this.c);
            L.append(", item=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "type", "content", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContent", AuthSource.SEND_ABUSE, "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallSipInfo {
        @Nullable
        public final String a;
        @Nullable
        public final String b;

        public CallSipInfo(@Nullable String str, @Nullable String str2) {
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ CallSipInfo copy$default(CallSipInfo callSipInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = callSipInfo.a;
            }
            if ((i & 2) != 0) {
                str2 = callSipInfo.b;
            }
            return callSipInfo.copy(str, str2);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final CallSipInfo copy(@Nullable String str, @Nullable String str2) {
            return new CallSipInfo(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CallSipInfo)) {
                return false;
            }
            CallSipInfo callSipInfo = (CallSipInfo) obj;
            return Intrinsics.areEqual(this.a, callSipInfo.a) && Intrinsics.areEqual(this.b, callSipInfo.b);
        }

        @Nullable
        public final String getContent() {
            return this.b;
        }

        @Nullable
        public final String getType() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CallSipInfo(type=");
            L.append(this.a);
            L.append(", content=");
            return a.t(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ List getMissingPermissions$default(CallManager callManager, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return callManager.getMissingPermissions(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMissingPermissions");
        }

        public static /* synthetic */ void makeCall$default(CallManager callManager, AppCallInfo appCallInfo, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                callManager.makeCall(appCallInfo, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makeCall");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$MissedCallData;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "component2", "()Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component3", "()Lcom/avito/android/calls_shared/AppCallInfo;", "callUuid", "reason", "info", "copy", "(Ljava/lang/String;Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;Lcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/CallManager$MissedCallData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallUuid", AuthSource.BOOKING_ORDER, "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "getReason", "<init>", "(Ljava/lang/String;Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;Lcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class MissedCallData {
        @NotNull
        public final String a;
        @NotNull
        public final MissedCallReason b;
        @NotNull
        public final AppCallInfo c;

        public MissedCallData(@NotNull String str, @NotNull MissedCallReason missedCallReason, @NotNull AppCallInfo appCallInfo) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(missedCallReason, "reason");
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            this.a = str;
            this.b = missedCallReason;
            this.c = appCallInfo;
        }

        public static /* synthetic */ MissedCallData copy$default(MissedCallData missedCallData, String str, MissedCallReason missedCallReason, AppCallInfo appCallInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missedCallData.a;
            }
            if ((i & 2) != 0) {
                missedCallReason = missedCallData.b;
            }
            if ((i & 4) != 0) {
                appCallInfo = missedCallData.c;
            }
            return missedCallData.copy(str, missedCallReason, appCallInfo);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final MissedCallReason component2() {
            return this.b;
        }

        @NotNull
        public final AppCallInfo component3() {
            return this.c;
        }

        @NotNull
        public final MissedCallData copy(@NotNull String str, @NotNull MissedCallReason missedCallReason, @NotNull AppCallInfo appCallInfo) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(missedCallReason, "reason");
            Intrinsics.checkNotNullParameter(appCallInfo, "info");
            return new MissedCallData(str, missedCallReason, appCallInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MissedCallData)) {
                return false;
            }
            MissedCallData missedCallData = (MissedCallData) obj;
            return Intrinsics.areEqual(this.a, missedCallData.a) && Intrinsics.areEqual(this.b, missedCallData.b) && Intrinsics.areEqual(this.c, missedCallData.c);
        }

        @NotNull
        public final String getCallUuid() {
            return this.a;
        }

        @NotNull
        public final AppCallInfo getInfo() {
            return this.c;
        }

        @NotNull
        public final MissedCallReason getReason() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            MissedCallReason missedCallReason = this.b;
            int hashCode2 = (hashCode + (missedCallReason != null ? missedCallReason.hashCode() : 0)) * 31;
            AppCallInfo appCallInfo = this.c;
            if (appCallInfo != null) {
                i = appCallInfo.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("MissedCallData(callUuid=");
            L.append(this.a);
            L.append(", reason=");
            L.append(this.b);
            L.append(", info=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "", "<init>", "()V", "AnsweredElsewhere", "Busy", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Missed", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$Missed;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$Busy;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$AnsweredElsewhere;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$Failed;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class MissedCallReason {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$AnsweredElsewhere;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class AnsweredElsewhere extends MissedCallReason {
            @NotNull
            public static final AnsweredElsewhere INSTANCE = new AnsweredElsewhere();

            public AnsweredElsewhere() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$Busy;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Busy extends MissedCallReason {
            @NotNull
            public static final Busy INSTANCE = new Busy();

            public Busy() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$Failed;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends MissedCallReason {
            @NotNull
            public static final Failed INSTANCE = new Failed();

            public Failed() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$MissedCallReason$Missed;", "Lcom/avito/android/in_app_calls/CallManager$MissedCallReason;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Missed extends MissedCallReason {
            @NotNull
            public static final Missed INSTANCE = new Missed();

            public Missed() {
                super(null);
            }
        }

        public MissedCallReason() {
        }

        public MissedCallReason(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State;", "", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "", "getSendAudio", "()Z", "sendAudio", "getConnected", "connected", "<init>", "()V", "Idle", "InCall", "Lcom/avito/android/in_app_calls/CallManager$State$Idle;", "Lcom/avito/android/in_app_calls/CallManager$State$InCall;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$Idle;", "Lcom/avito/android/in_app_calls/CallManager$State;", "<init>", "()V", "Finished", "None", "Lcom/avito/android/in_app_calls/CallManager$State$Idle$None;", "Lcom/avito/android/in_app_calls/CallManager$State$Idle$Finished;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Idle extends State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$Idle$Finished;", "Lcom/avito/android/in_app_calls/CallManager$State$Idle;", "", "component1", "()Z", "Lcom/avito/android/calls_shared/AppCallInfo;", "component2", "()Lcom/avito/android/calls_shared/AppCallInfo;", "Lcom/avito/android/calls_shared/AppCallResult;", "component3", "()Lcom/avito/android/calls_shared/AppCallResult;", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "component4", "()Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "component5", "connected", "info", "result", "sipInfo", "sendAudio", "copy", "(ZLcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;Z)Lcom/avito/android/in_app_calls/CallManager$State$Idle$Finished;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "getSipInfo", "c", "Lcom/avito/android/calls_shared/AppCallResult;", "getResult", "e", "Z", "getSendAudio", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", AuthSource.SEND_ABUSE, "getConnected", "<init>", "(ZLcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class Finished extends Idle {
                public final boolean a;
                @NotNull
                public final AppCallInfo b;
                @NotNull
                public final AppCallResult c;
                @Nullable
                public final CallSipInfo d;
                public final boolean e;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Finished(boolean z, AppCallInfo appCallInfo, AppCallResult appCallResult, CallSipInfo callSipInfo, boolean z2, int i, j jVar) {
                    this(z, appCallInfo, appCallResult, callSipInfo, (i & 16) != 0 ? true : z2);
                }

                public static /* synthetic */ Finished copy$default(Finished finished, boolean z, AppCallInfo appCallInfo, AppCallResult appCallResult, CallSipInfo callSipInfo, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z = finished.getConnected();
                    }
                    if ((i & 2) != 0) {
                        appCallInfo = finished.getInfo();
                    }
                    if ((i & 4) != 0) {
                        appCallResult = finished.c;
                    }
                    if ((i & 8) != 0) {
                        callSipInfo = finished.d;
                    }
                    if ((i & 16) != 0) {
                        z2 = finished.getSendAudio();
                    }
                    return finished.copy(z, appCallInfo, appCallResult, callSipInfo, z2);
                }

                public final boolean component1() {
                    return getConnected();
                }

                @NotNull
                public final AppCallInfo component2() {
                    return getInfo();
                }

                @NotNull
                public final AppCallResult component3() {
                    return this.c;
                }

                @Nullable
                public final CallSipInfo component4() {
                    return this.d;
                }

                public final boolean component5() {
                    return getSendAudio();
                }

                @NotNull
                public final Finished copy(boolean z, @NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult, @Nullable CallSipInfo callSipInfo, boolean z2) {
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(appCallResult, "result");
                    return new Finished(z, appCallInfo, appCallResult, callSipInfo, z2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Finished)) {
                        return false;
                    }
                    Finished finished = (Finished) obj;
                    return getConnected() == finished.getConnected() && Intrinsics.areEqual(getInfo(), finished.getInfo()) && Intrinsics.areEqual(this.c, finished.c) && Intrinsics.areEqual(this.d, finished.d) && getSendAudio() == finished.getSendAudio();
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getConnected() {
                    return this.a;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                @NotNull
                public AppCallInfo getInfo() {
                    return this.b;
                }

                @NotNull
                public final AppCallResult getResult() {
                    return this.c;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getSendAudio() {
                    return this.e;
                }

                @Nullable
                public final CallSipInfo getSipInfo() {
                    return this.d;
                }

                public int hashCode() {
                    boolean connected = getConnected();
                    int i = 1;
                    if (connected) {
                        connected = true;
                    }
                    int i2 = connected ? 1 : 0;
                    int i3 = connected ? 1 : 0;
                    int i4 = connected ? 1 : 0;
                    int i5 = i2 * 31;
                    AppCallInfo info = getInfo();
                    int i6 = 0;
                    int hashCode = (i5 + (info != null ? info.hashCode() : 0)) * 31;
                    AppCallResult appCallResult = this.c;
                    int hashCode2 = (hashCode + (appCallResult != null ? appCallResult.hashCode() : 0)) * 31;
                    CallSipInfo callSipInfo = this.d;
                    if (callSipInfo != null) {
                        i6 = callSipInfo.hashCode();
                    }
                    int i7 = (hashCode2 + i6) * 31;
                    boolean sendAudio = getSendAudio();
                    if (!sendAudio) {
                        i = sendAudio;
                    }
                    return i7 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Finished(connected=");
                    L.append(getConnected());
                    L.append(", info=");
                    L.append(getInfo());
                    L.append(", result=");
                    L.append(this.c);
                    L.append(", sipInfo=");
                    L.append(this.d);
                    L.append(", sendAudio=");
                    L.append(getSendAudio());
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Finished(boolean z, @NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult, @Nullable CallSipInfo callSipInfo, boolean z2) {
                    super(null);
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(appCallResult, "result");
                    this.a = z;
                    this.b = appCallInfo;
                    this.c = appCallResult;
                    this.d = callSipInfo;
                    this.e = z2;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$Idle$None;", "Lcom/avito/android/in_app_calls/CallManager$State$Idle;", "", "component1", "()Z", "component2", "Lcom/avito/android/calls_shared/AppCallInfo;", "component3", "()Lcom/avito/android/calls_shared/AppCallInfo;", "connected", "sendAudio", "callRequest", "copy", "(ZZLcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/CallManager$State$Idle$None;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCallRequest", "getInfo", "info", AuthSource.SEND_ABUSE, "Z", "getConnected", AuthSource.BOOKING_ORDER, "getSendAudio", "<init>", "(ZZLcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class None extends Idle {
                public final boolean a;
                public final boolean b;
                @Nullable
                public final AppCallInfo c;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ None(boolean z, boolean z2, AppCallInfo appCallInfo, int i, j jVar) {
                    this(z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? null : appCallInfo);
                }

                public static /* synthetic */ None copy$default(None none, boolean z, boolean z2, AppCallInfo appCallInfo, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z = none.getConnected();
                    }
                    if ((i & 2) != 0) {
                        z2 = none.getSendAudio();
                    }
                    if ((i & 4) != 0) {
                        appCallInfo = none.c;
                    }
                    return none.copy(z, z2, appCallInfo);
                }

                public final boolean component1() {
                    return getConnected();
                }

                public final boolean component2() {
                    return getSendAudio();
                }

                @Nullable
                public final AppCallInfo component3() {
                    return this.c;
                }

                @NotNull
                public final None copy(boolean z, boolean z2, @Nullable AppCallInfo appCallInfo) {
                    return new None(z, z2, appCallInfo);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof None)) {
                        return false;
                    }
                    None none = (None) obj;
                    return getConnected() == none.getConnected() && getSendAudio() == none.getSendAudio() && Intrinsics.areEqual(this.c, none.c);
                }

                @Nullable
                public final AppCallInfo getCallRequest() {
                    return this.c;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getConnected() {
                    return this.a;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                @Nullable
                public AppCallInfo getInfo() {
                    return this.c;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getSendAudio() {
                    return this.b;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v0 */
                /* JADX WARN: Type inference failed for: r1v1 */
                /* JADX WARN: Type inference failed for: r1v6 */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public int hashCode() {
                    /*
                        r3 = this;
                        boolean r0 = r3.getConnected()
                        r1 = 1
                        if (r0 == 0) goto L_0x0008
                        r0 = 1
                    L_0x0008:
                        int r0 = r0 * 31
                        boolean r2 = r3.getSendAudio()
                        if (r2 == 0) goto L_0x0011
                        goto L_0x0012
                    L_0x0011:
                        r1 = r2
                    L_0x0012:
                        int r0 = r0 + r1
                        int r0 = r0 * 31
                        com.avito.android.calls_shared.AppCallInfo r1 = r3.c
                        if (r1 == 0) goto L_0x001e
                        int r1 = r1.hashCode()
                        goto L_0x001f
                    L_0x001e:
                        r1 = 0
                    L_0x001f:
                        int r0 = r0 + r1
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.in_app_calls.CallManager.State.Idle.None.hashCode():int");
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("None(connected=");
                    L.append(getConnected());
                    L.append(", sendAudio=");
                    L.append(getSendAudio());
                    L.append(", callRequest=");
                    L.append(this.c);
                    L.append(")");
                    return L.toString();
                }

                public None(boolean z, boolean z2, @Nullable AppCallInfo appCallInfo) {
                    super(null);
                    this.a = z;
                    this.b = z2;
                    this.c = appCallInfo;
                }
            }

            public Idle() {
                super(null);
            }

            public Idle(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0001\u0003\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$InCall;", "Lcom/avito/android/in_app_calls/CallManager$State;", "", "getWasHangupByUser", "()Z", "wasHangupByUser", "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "info", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "getSipInfo", "()Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "sipInfo", AuthSource.SEND_ABUSE, "Z", "getConnected", "connected", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "getVideoStreams", "()Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "videoStreams", "<init>", "()V", "Connected", "Dialing", "Ringing", "Lcom/avito/android/in_app_calls/CallManager$State$InCall$Dialing;", "Lcom/avito/android/in_app_calls/CallManager$State$InCall$Ringing;", "Lcom/avito/android/in_app_calls/CallManager$State$InCall$Connected;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class InCall extends State {
            public final boolean a = true;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007JD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u0007¨\u00060"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$InCall$Connected;", "Lcom/avito/android/in_app_calls/CallManager$State$InCall;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Z", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "component3", "()Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "component4", "()Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "component5", "info", "sendAudio", "sipInfo", "videoStreams", "wasHangupByUser", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;ZLcom/avito/android/in_app_calls/CallManager$CallSipInfo;Lcom/avito/android/in_app_calls/CallManager$VideoStreams;Z)Lcom/avito/android/in_app_calls/CallManager$State$InCall$Connected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "getVideoStreams", "d", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "getSipInfo", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "c", "Z", "getSendAudio", "f", "getWasHangupByUser", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;ZLcom/avito/android/in_app_calls/CallManager$CallSipInfo;Lcom/avito/android/in_app_calls/CallManager$VideoStreams;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class Connected extends InCall {
                @NotNull
                public final AppCallInfo b;
                public final boolean c;
                @Nullable
                public final CallSipInfo d;
                @NotNull
                public final VideoStreams e;
                public final boolean f;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Connected(AppCallInfo appCallInfo, boolean z, CallSipInfo callSipInfo, VideoStreams videoStreams, boolean z2, int i, j jVar) {
                    this(appCallInfo, z, callSipInfo, videoStreams, (i & 16) != 0 ? false : z2);
                }

                public static /* synthetic */ Connected copy$default(Connected connected, AppCallInfo appCallInfo, boolean z, CallSipInfo callSipInfo, VideoStreams videoStreams, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        appCallInfo = connected.getInfo();
                    }
                    if ((i & 2) != 0) {
                        z = connected.getSendAudio();
                    }
                    if ((i & 4) != 0) {
                        callSipInfo = connected.getSipInfo();
                    }
                    if ((i & 8) != 0) {
                        videoStreams = connected.getVideoStreams();
                    }
                    if ((i & 16) != 0) {
                        z2 = connected.getWasHangupByUser();
                    }
                    return connected.copy(appCallInfo, z, callSipInfo, videoStreams, z2);
                }

                @NotNull
                public final AppCallInfo component1() {
                    return getInfo();
                }

                public final boolean component2() {
                    return getSendAudio();
                }

                @Nullable
                public final CallSipInfo component3() {
                    return getSipInfo();
                }

                @NotNull
                public final VideoStreams component4() {
                    return getVideoStreams();
                }

                public final boolean component5() {
                    return getWasHangupByUser();
                }

                @NotNull
                public final Connected copy(@NotNull AppCallInfo appCallInfo, boolean z, @Nullable CallSipInfo callSipInfo, @NotNull VideoStreams videoStreams, boolean z2) {
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(videoStreams, "videoStreams");
                    return new Connected(appCallInfo, z, callSipInfo, videoStreams, z2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Connected)) {
                        return false;
                    }
                    Connected connected = (Connected) obj;
                    return Intrinsics.areEqual(getInfo(), connected.getInfo()) && getSendAudio() == connected.getSendAudio() && Intrinsics.areEqual(getSipInfo(), connected.getSipInfo()) && Intrinsics.areEqual(getVideoStreams(), connected.getVideoStreams()) && getWasHangupByUser() == connected.getWasHangupByUser();
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall, com.avito.android.in_app_calls.CallManager.State
                @NotNull
                public AppCallInfo getInfo() {
                    return this.b;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getSendAudio() {
                    return this.c;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                @Nullable
                public CallSipInfo getSipInfo() {
                    return this.d;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                @NotNull
                public VideoStreams getVideoStreams() {
                    return this.e;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                public boolean getWasHangupByUser() {
                    return this.f;
                }

                public int hashCode() {
                    AppCallInfo info = getInfo();
                    int i = 0;
                    int hashCode = (info != null ? info.hashCode() : 0) * 31;
                    boolean sendAudio = getSendAudio();
                    int i2 = 1;
                    if (sendAudio) {
                        sendAudio = true;
                    }
                    int i3 = sendAudio ? 1 : 0;
                    int i4 = sendAudio ? 1 : 0;
                    int i5 = sendAudio ? 1 : 0;
                    int i6 = (hashCode + i3) * 31;
                    CallSipInfo sipInfo = getSipInfo();
                    int hashCode2 = (i6 + (sipInfo != null ? sipInfo.hashCode() : 0)) * 31;
                    VideoStreams videoStreams = getVideoStreams();
                    if (videoStreams != null) {
                        i = videoStreams.hashCode();
                    }
                    int i7 = (hashCode2 + i) * 31;
                    boolean wasHangupByUser = getWasHangupByUser();
                    if (!wasHangupByUser) {
                        i2 = wasHangupByUser;
                    }
                    return i7 + i2;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Connected(info=");
                    L.append(getInfo());
                    L.append(", sendAudio=");
                    L.append(getSendAudio());
                    L.append(", sipInfo=");
                    L.append(getSipInfo());
                    L.append(", videoStreams=");
                    L.append(getVideoStreams());
                    L.append(", wasHangupByUser=");
                    L.append(getWasHangupByUser());
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Connected(@NotNull AppCallInfo appCallInfo, boolean z, @Nullable CallSipInfo callSipInfo, @NotNull VideoStreams videoStreams, boolean z2) {
                    super(null);
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(videoStreams, "videoStreams");
                    this.b = appCallInfo;
                    this.c = z;
                    this.d = callSipInfo;
                    this.e = videoStreams;
                    this.f = z2;
                }
            }

            public InCall() {
                super(null);
            }

            @Override // com.avito.android.in_app_calls.CallManager.State
            public boolean getConnected() {
                return this.a;
            }

            @Override // com.avito.android.in_app_calls.CallManager.State
            @NotNull
            public abstract AppCallInfo getInfo();

            @Nullable
            public abstract CallSipInfo getSipInfo();

            @NotNull
            public abstract VideoStreams getVideoStreams();

            public abstract boolean getWasHangupByUser();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007JD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u001c\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\rR\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u0007¨\u00060"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$InCall$Dialing;", "Lcom/avito/android/in_app_calls/CallManager$State$InCall;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Z", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "component3", "()Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "component4", "()Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "component5", "info", "sendAudio", "sipInfo", "videoStreams", "wasHangupByUser", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;ZLcom/avito/android/in_app_calls/CallManager$CallSipInfo;Lcom/avito/android/in_app_calls/CallManager$VideoStreams;Z)Lcom/avito/android/in_app_calls/CallManager$State$InCall$Dialing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "d", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "getSipInfo", "e", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "getVideoStreams", "c", "Z", "getSendAudio", "f", "getWasHangupByUser", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;ZLcom/avito/android/in_app_calls/CallManager$CallSipInfo;Lcom/avito/android/in_app_calls/CallManager$VideoStreams;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class Dialing extends InCall {
                @NotNull
                public final AppCallInfo b;
                public final boolean c;
                @Nullable
                public final CallSipInfo d;
                @NotNull
                public final VideoStreams e;
                public final boolean f;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Dialing(AppCallInfo appCallInfo, boolean z, CallSipInfo callSipInfo, VideoStreams videoStreams, boolean z2, int i, j jVar) {
                    this(appCallInfo, z, (i & 4) != 0 ? null : callSipInfo, (i & 8) != 0 ? new VideoStreams(null, null, 3, null) : videoStreams, (i & 16) != 0 ? false : z2);
                }

                public static /* synthetic */ Dialing copy$default(Dialing dialing, AppCallInfo appCallInfo, boolean z, CallSipInfo callSipInfo, VideoStreams videoStreams, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        appCallInfo = dialing.getInfo();
                    }
                    if ((i & 2) != 0) {
                        z = dialing.getSendAudio();
                    }
                    if ((i & 4) != 0) {
                        callSipInfo = dialing.getSipInfo();
                    }
                    if ((i & 8) != 0) {
                        videoStreams = dialing.getVideoStreams();
                    }
                    if ((i & 16) != 0) {
                        z2 = dialing.getWasHangupByUser();
                    }
                    return dialing.copy(appCallInfo, z, callSipInfo, videoStreams, z2);
                }

                @NotNull
                public final AppCallInfo component1() {
                    return getInfo();
                }

                public final boolean component2() {
                    return getSendAudio();
                }

                @Nullable
                public final CallSipInfo component3() {
                    return getSipInfo();
                }

                @NotNull
                public final VideoStreams component4() {
                    return getVideoStreams();
                }

                public final boolean component5() {
                    return getWasHangupByUser();
                }

                @NotNull
                public final Dialing copy(@NotNull AppCallInfo appCallInfo, boolean z, @Nullable CallSipInfo callSipInfo, @NotNull VideoStreams videoStreams, boolean z2) {
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(videoStreams, "videoStreams");
                    return new Dialing(appCallInfo, z, callSipInfo, videoStreams, z2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Dialing)) {
                        return false;
                    }
                    Dialing dialing = (Dialing) obj;
                    return Intrinsics.areEqual(getInfo(), dialing.getInfo()) && getSendAudio() == dialing.getSendAudio() && Intrinsics.areEqual(getSipInfo(), dialing.getSipInfo()) && Intrinsics.areEqual(getVideoStreams(), dialing.getVideoStreams()) && getWasHangupByUser() == dialing.getWasHangupByUser();
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall, com.avito.android.in_app_calls.CallManager.State
                @NotNull
                public AppCallInfo getInfo() {
                    return this.b;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getSendAudio() {
                    return this.c;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                @Nullable
                public CallSipInfo getSipInfo() {
                    return this.d;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                @NotNull
                public VideoStreams getVideoStreams() {
                    return this.e;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                public boolean getWasHangupByUser() {
                    return this.f;
                }

                public int hashCode() {
                    AppCallInfo info = getInfo();
                    int i = 0;
                    int hashCode = (info != null ? info.hashCode() : 0) * 31;
                    boolean sendAudio = getSendAudio();
                    int i2 = 1;
                    if (sendAudio) {
                        sendAudio = true;
                    }
                    int i3 = sendAudio ? 1 : 0;
                    int i4 = sendAudio ? 1 : 0;
                    int i5 = sendAudio ? 1 : 0;
                    int i6 = (hashCode + i3) * 31;
                    CallSipInfo sipInfo = getSipInfo();
                    int hashCode2 = (i6 + (sipInfo != null ? sipInfo.hashCode() : 0)) * 31;
                    VideoStreams videoStreams = getVideoStreams();
                    if (videoStreams != null) {
                        i = videoStreams.hashCode();
                    }
                    int i7 = (hashCode2 + i) * 31;
                    boolean wasHangupByUser = getWasHangupByUser();
                    if (!wasHangupByUser) {
                        i2 = wasHangupByUser;
                    }
                    return i7 + i2;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Dialing(info=");
                    L.append(getInfo());
                    L.append(", sendAudio=");
                    L.append(getSendAudio());
                    L.append(", sipInfo=");
                    L.append(getSipInfo());
                    L.append(", videoStreams=");
                    L.append(getVideoStreams());
                    L.append(", wasHangupByUser=");
                    L.append(getWasHangupByUser());
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Dialing(@NotNull AppCallInfo appCallInfo, boolean z, @Nullable CallSipInfo callSipInfo, @NotNull VideoStreams videoStreams, boolean z2) {
                    super(null);
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(videoStreams, "videoStreams");
                    this.b = appCallInfo;
                    this.c = z;
                    this.d = callSipInfo;
                    this.e = videoStreams;
                    this.f = z2;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\rR\u0016\u0010+\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\r¨\u0006."}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$State$InCall$Ringing;", "Lcom/avito/android/in_app_calls/CallManager$State$InCall;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "component2", "()Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "component3", "()Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "", "component4", "()Z", "info", "sipInfo", "videoStreams", "wasHangupByUser", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;Lcom/avito/android/in_app_calls/CallManager$VideoStreams;Z)Lcom/avito/android/in_app_calls/CallManager$State$InCall$Ringing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;", "getSipInfo", "d", "Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "getVideoStreams", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/AppCallInfo;", "getInfo", "e", "Z", "getWasHangupByUser", "getSendAudio", "sendAudio", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/in_app_calls/CallManager$CallSipInfo;Lcom/avito/android/in_app_calls/CallManager$VideoStreams;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
            public static final class Ringing extends InCall {
                @NotNull
                public final AppCallInfo b;
                @Nullable
                public final CallSipInfo c;
                @NotNull
                public final VideoStreams d;
                public final boolean e;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Ringing(AppCallInfo appCallInfo, CallSipInfo callSipInfo, VideoStreams videoStreams, boolean z, int i, j jVar) {
                    this(appCallInfo, (i & 2) != 0 ? null : callSipInfo, (i & 4) != 0 ? new VideoStreams(null, null, 3, null) : videoStreams, (i & 8) != 0 ? false : z);
                }

                public static /* synthetic */ Ringing copy$default(Ringing ringing, AppCallInfo appCallInfo, CallSipInfo callSipInfo, VideoStreams videoStreams, boolean z, int i, Object obj) {
                    if ((i & 1) != 0) {
                        appCallInfo = ringing.getInfo();
                    }
                    if ((i & 2) != 0) {
                        callSipInfo = ringing.getSipInfo();
                    }
                    if ((i & 4) != 0) {
                        videoStreams = ringing.getVideoStreams();
                    }
                    if ((i & 8) != 0) {
                        z = ringing.getWasHangupByUser();
                    }
                    return ringing.copy(appCallInfo, callSipInfo, videoStreams, z);
                }

                @NotNull
                public final AppCallInfo component1() {
                    return getInfo();
                }

                @Nullable
                public final CallSipInfo component2() {
                    return getSipInfo();
                }

                @NotNull
                public final VideoStreams component3() {
                    return getVideoStreams();
                }

                public final boolean component4() {
                    return getWasHangupByUser();
                }

                @NotNull
                public final Ringing copy(@NotNull AppCallInfo appCallInfo, @Nullable CallSipInfo callSipInfo, @NotNull VideoStreams videoStreams, boolean z) {
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(videoStreams, "videoStreams");
                    return new Ringing(appCallInfo, callSipInfo, videoStreams, z);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Ringing)) {
                        return false;
                    }
                    Ringing ringing = (Ringing) obj;
                    return Intrinsics.areEqual(getInfo(), ringing.getInfo()) && Intrinsics.areEqual(getSipInfo(), ringing.getSipInfo()) && Intrinsics.areEqual(getVideoStreams(), ringing.getVideoStreams()) && getWasHangupByUser() == ringing.getWasHangupByUser();
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall, com.avito.android.in_app_calls.CallManager.State
                @NotNull
                public AppCallInfo getInfo() {
                    return this.b;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State
                public boolean getSendAudio() {
                    return true;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                @Nullable
                public CallSipInfo getSipInfo() {
                    return this.c;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                @NotNull
                public VideoStreams getVideoStreams() {
                    return this.d;
                }

                @Override // com.avito.android.in_app_calls.CallManager.State.InCall
                public boolean getWasHangupByUser() {
                    return this.e;
                }

                public int hashCode() {
                    AppCallInfo info = getInfo();
                    int i = 0;
                    int hashCode = (info != null ? info.hashCode() : 0) * 31;
                    CallSipInfo sipInfo = getSipInfo();
                    int hashCode2 = (hashCode + (sipInfo != null ? sipInfo.hashCode() : 0)) * 31;
                    VideoStreams videoStreams = getVideoStreams();
                    if (videoStreams != null) {
                        i = videoStreams.hashCode();
                    }
                    int i2 = (hashCode2 + i) * 31;
                    boolean wasHangupByUser = getWasHangupByUser();
                    if (wasHangupByUser) {
                        wasHangupByUser = true;
                    }
                    int i3 = wasHangupByUser ? 1 : 0;
                    int i4 = wasHangupByUser ? 1 : 0;
                    int i5 = wasHangupByUser ? 1 : 0;
                    return i2 + i3;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Ringing(info=");
                    L.append(getInfo());
                    L.append(", sipInfo=");
                    L.append(getSipInfo());
                    L.append(", videoStreams=");
                    L.append(getVideoStreams());
                    L.append(", wasHangupByUser=");
                    L.append(getWasHangupByUser());
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Ringing(@NotNull AppCallInfo appCallInfo, @Nullable CallSipInfo callSipInfo, @NotNull VideoStreams videoStreams, boolean z) {
                    super(null);
                    Intrinsics.checkNotNullParameter(appCallInfo, "info");
                    Intrinsics.checkNotNullParameter(videoStreams, "videoStreams");
                    this.b = appCallInfo;
                    this.c = callSipInfo;
                    this.d = videoStreams;
                    this.e = z;
                }
            }

            public InCall(j jVar) {
                super(null);
            }
        }

        public State() {
        }

        public abstract boolean getConnected();

        @Nullable
        public abstract AppCallInfo getInfo();

        public abstract boolean getSendAudio();

        public State(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B3\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J<\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006R%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "", "", "", "Lcom/avito/android/calls/CallVideoStream;", "component1", "()Ljava/util/Map;", "component2", ImagesContract.LOCAL, "remote", "copy", "(Ljava/util/Map;Ljava/util/Map;)Lcom/avito/android/in_app_calls/CallManager$VideoStreams;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getLocal", AuthSource.BOOKING_ORDER, "getRemote", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class VideoStreams {
        @NotNull
        public final Map<String, CallVideoStream> a;
        @NotNull
        public final Map<String, CallVideoStream> b;

        public VideoStreams() {
            this(null, null, 3, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends com.avito.android.calls.CallVideoStream> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends com.avito.android.calls.CallVideoStream> */
        /* JADX WARN: Multi-variable type inference failed */
        public VideoStreams(@NotNull Map<String, ? extends CallVideoStream> map, @NotNull Map<String, ? extends CallVideoStream> map2) {
            Intrinsics.checkNotNullParameter(map, ImagesContract.LOCAL);
            Intrinsics.checkNotNullParameter(map2, "remote");
            this.a = map;
            this.b = map2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.in_app_calls.CallManager$VideoStreams */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoStreams copy$default(VideoStreams videoStreams, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = videoStreams.a;
            }
            if ((i & 2) != 0) {
                map2 = videoStreams.b;
            }
            return videoStreams.copy(map, map2);
        }

        @NotNull
        public final Map<String, CallVideoStream> component1() {
            return this.a;
        }

        @NotNull
        public final Map<String, CallVideoStream> component2() {
            return this.b;
        }

        @NotNull
        public final VideoStreams copy(@NotNull Map<String, ? extends CallVideoStream> map, @NotNull Map<String, ? extends CallVideoStream> map2) {
            Intrinsics.checkNotNullParameter(map, ImagesContract.LOCAL);
            Intrinsics.checkNotNullParameter(map2, "remote");
            return new VideoStreams(map, map2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VideoStreams)) {
                return false;
            }
            VideoStreams videoStreams = (VideoStreams) obj;
            return Intrinsics.areEqual(this.a, videoStreams.a) && Intrinsics.areEqual(this.b, videoStreams.b);
        }

        @NotNull
        public final Map<String, CallVideoStream> getLocal() {
            return this.a;
        }

        @NotNull
        public final Map<String, CallVideoStream> getRemote() {
            return this.b;
        }

        public int hashCode() {
            Map<String, CallVideoStream> map = this.a;
            int i = 0;
            int hashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<String, CallVideoStream> map2 = this.b;
            if (map2 != null) {
                i = map2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("VideoStreams(local=");
            L.append(this.a);
            L.append(", remote=");
            return a.x(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VideoStreams(Map map, Map map2, int i, j jVar) {
            this((i & 1) != 0 ? r.emptyMap() : map, (i & 2) != 0 ? r.emptyMap() : map2);
        }
    }

    void answerCall();

    void declineCall();

    void disconnectWhenIdle();

    void enableMic(boolean z);

    @NotNull
    Observable<MissedCallData> getMissedCallsStream();

    @NotNull
    List<String> getMissingPermissions(boolean z);

    void hangupCall(@NotNull String str);

    void makeCall(@NotNull AppCallInfo appCallInfo, @Nullable String str);

    void onIncomingCall(@NotNull AppCallInfo appCallInfo);

    void onReconnectCall(@NotNull AppCallInfo appCallInfo, boolean z);

    void register(@NotNull String str);

    void startForReconnect();

    boolean startFromPush(@NotNull Push push);

    void unregister();

    void updateCallInfo(@NotNull CallInfoUpdate callInfoUpdate);

    void updatePushToken(@NotNull PushToken pushToken);
}
