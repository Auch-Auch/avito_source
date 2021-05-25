package com.avito.android.in_app_calls;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.ab_tests.groups.CallsEarlyBeepsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.calls.AvitoCallClient;
import com.avito.android.calls.Call;
import com.avito.android.calls.CallExtras;
import com.avito.android.calls.CallVideoStream;
import com.avito.android.calls.ConnectionListener;
import com.avito.android.calls.IncomingCall;
import com.avito.android.calls.OutgoingCall;
import com.avito.android.calls.quality.CallQualityIssueListener;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.analytics.mapping.CallTypesToEventParamMapperKt;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.analytics.CallPushHandlingTracker;
import com.avito.android.in_app_calls.errors.ErrorMappingKt;
import com.avito.android.in_app_calls.service.SystemCallStateProvider;
import com.avito.android.in_app_calls.util.NotificationsKt;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.push.Push;
import com.avito.android.push.PushToken;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.facebook.internal.AnalyticsEvents;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:,\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001 \u0001¡\u0001¢\u0001Bp\b\u0007\u0012\u0006\u0010|\u001a\u00020y\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010S\u001a\u00020P\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010n\u001a\u00020k\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010j\u001a\u00020g\u0012\u0007\u0010\u0001\u001a\u00020}\u0012\f\u0010s\u001a\b\u0012\u0004\u0012\u00020p0o\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\fJ\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\nJ\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u000fH\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)2\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000fH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\fJ\u0017\u00102\u001a\u00020\b2\u0006\u0010#\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b8\u00107J'\u0010;\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000fH\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u0010#\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b@\u00107JC\u0010E\u001a\u00020\b2\u0006\u00105\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010\u00062\b\u0010B\u001a\u0004\u0018\u00010\u00062\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010I\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bK\u0010JJ'\u0010M\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u0010L\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bM\u0010NJ'\u0010O\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u0010L\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bO\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00060X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010[R\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00020p0o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\"\u0010x\u001a\b\u0012\u0004\u0012\u00020t0X8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bu\u0010[\u001a\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006£\u0001"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl;", "Lcom/avito/android/in_app_calls/CallManager;", "Lcom/avito/android/calls/Call$Listener;", "Lcom/avito/android/calls/ConnectionListener;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/in_app_calls/CallManager$State;", "", ChannelContext.Item.USER_ID, "", "register", "(Ljava/lang/String;)V", "unregister", "()V", "Lcom/avito/android/push/Push;", "push", "", "startFromPush", "(Lcom/avito/android/push/Push;)Z", "startForReconnect", "disconnectWhenIdle", "Lcom/avito/android/push/PushToken;", "pushToken", "updatePushToken", "(Lcom/avito/android/push/PushToken;)V", "Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "callAs", "makeCall", "(Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;)V", "Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "update", "updateCallInfo", "(Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;)V", "answerCall", "declineCall", "reason", "hangupCall", "enable", "enableMic", "(Z)V", "enableVideo", "", "getMissingPermissions", "(Z)Ljava/util/List;", "onIncomingCall", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "onReconnectCall", "(Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "onClientConnected", "Lcom/avito/android/calls/ConnectionListener$DisconnectReason;", "onClientDisconnected", "(Lcom/avito/android/calls/ConnectionListener$DisconnectReason;)V", "Lcom/avito/android/calls/Call;", "call", "onCallRinging", "(Lcom/avito/android/calls/Call;)V", "onCallConnected", "answeredElsewhere", "userInitiated", "onCallDisconnected", "(Lcom/avito/android/calls/Call;ZZ)V", "Lcom/avito/android/calls/Call$Failure;", "onCallFailed", "(Lcom/avito/android/calls/Call;Lcom/avito/android/calls/Call$Failure;)V", "onCallAudioStarted", "type", "content", "", "headers", "onSipInfoReceived", "(Lcom/avito/android/calls/Call;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/avito/android/calls/CallVideoStream;", "stream", "onLocalVideoStreamAdded", "(Lcom/avito/android/calls/Call;Lcom/avito/android/calls/CallVideoStream;)V", "onLocalVideoStreamRemoved", "endpointId", "onRemoteVideoStreamAdded", "(Lcom/avito/android/calls/Call;Ljava/lang/String;Lcom/avito/android/calls/CallVideoStream;)V", "onRemoteVideoStreamRemoved", "Lcom/avito/android/calls/AvitoCallClient;", VKApiConst.VERSION, "Lcom/avito/android/calls/AvitoCallClient;", "callClient", "Lio/reactivex/disposables/CompositeDisposable;", VKApiConst.Q, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/jakewharton/rxrelay2/Relay;", "", "s", "Lcom/jakewharton/rxrelay2/Relay;", "disconnectWhenIdleRequests", "Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;", "z", "Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;", "pushHandlingTracker", "r", "pushTrackingStream", "Lcom/avito/android/server_time/TimeSource;", "x", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "systemCallStateProvider", "Lcom/avito/android/calls/quality/CallQualityIssueListener;", "y", "Lcom/avito/android/calls/quality/CallQualityIssueListener;", "qualityIssueTracker", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/CallsEarlyBeepsTestGroup;", "C", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "callsEarlyBeepsTestGroup", "Lcom/avito/android/in_app_calls/CallManager$MissedCallData;", "p", "getMissedCallsStream", "()Lcom/jakewharton/rxrelay2/Relay;", "missedCallsStream", "Landroid/content/Context;", "t", "Landroid/content/Context;", "context", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "B", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "Lcom/avito/android/in_app_calls/CallRegistry;", "w", "Lcom/avito/android/in_app_calls/CallRegistry;", "callRegistry", "Lcom/avito/android/in_app_calls/IncomingCallHandler;", "u", "Lcom/avito/android/in_app_calls/IncomingCallHandler;", "incomingCallHandler", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Landroid/content/Context;Lcom/avito/android/in_app_calls/IncomingCallHandler;Lcom/avito/android/calls/AvitoCallClient;Lcom/avito/android/in_app_calls/CallRegistry;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/calls/quality/CallQualityIssueListener;Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/util/SchedulersFactory;)V", "AnswerCallMutator", "CallEvent", "DeclineCallMutator", "EnableMicMutator", "HangupCallMutator", "MakeCallMutator", "OnCallEventMutator", "OnCallSipInfoReceived", "OnClientConnectedMutator", "OnClientDisconnectedMutator", "OnIncomingCallMutator", "OnLocalVideoStreamAddedMutator", "OnLocalVideoStreamRemovedMutator", "OnReconnectCallMutator", "OnRemoteVideoStreamAddedMutator", "OnRemoteVideoStreamRemovedMutator", "OnSystemCallStateChangedAction", "RegisterAction", "StartForIncomingCallAction", "UnregisterMutator", "UpdateCallInfoMutator", "UpdatePushTokenAction", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallManagerImpl extends BaseMviEntityWithReducerQueue<CallManager.State> implements CallManager, Call.Listener, ConnectionListener {
    public final SystemCallStateProvider A;
    public final CallEventTracker B;
    public final SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> C;
    @NotNull
    public final Relay<CallManager.MissedCallData> p;
    public final CompositeDisposable q;
    public final Relay<String> r;
    public final Relay<Long> s;
    public final Context t;
    public final IncomingCallHandler u;
    public final AvitoCallClient v;
    public final CallRegistry w;
    public final TimeSource x;
    public final CallQualityIssueListener y;
    public final CallPushHandlingTracker z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$AnswerCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class AnswerCallMutator extends Mutator<CallManager.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AnswerCallMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallManager.State.InCall.Ringing) {
                Call access$getCall$p = CallManagerImpl.access$getCall$p(CallManagerImpl.this, state);
                Objects.requireNonNull(access$getCall$p, "null cannot be cast to non-null type com.avito.android.calls.IncomingCall");
                try {
                    IncomingCall.DefaultImpls.answer$default((IncomingCall) access$getCall$p, false, 1, null);
                } catch (Exception e) {
                    Logs.error(CallManagerImpl.this.getTAG(), "Failed to answer incoming call", e);
                }
            }
            return state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "", "<init>", "()V", "Connected", "Disconnected", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Ringing", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Ringing;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Connected;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Failed;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Disconnected;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class CallEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Connected;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Connected extends CallEvent {
            public Connected() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Disconnected;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "", AuthSource.BOOKING_ORDER, "Z", "getUserInititated", "()Z", "userInititated", AuthSource.SEND_ABUSE, "getAnsweredElsewhere", "answeredElsewhere", "<init>", "(ZZ)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Disconnected extends CallEvent {
            public final boolean a;
            public final boolean b;

            public Disconnected(boolean z, boolean z2) {
                super(null);
                this.a = z;
                this.b = z2;
            }

            public final boolean getAnsweredElsewhere() {
                return this.a;
            }

            public final boolean getUserInititated() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Failed;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "Lcom/avito/android/calls/Call$Failure;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/Call$Failure;", "getReason", "()Lcom/avito/android/calls/Call$Failure;", "reason", "<init>", "(Lcom/avito/android/calls/Call$Failure;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends CallEvent {
            @NotNull
            public final Call.Failure a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(@NotNull Call.Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "reason");
                this.a = failure;
            }

            @NotNull
            public final Call.Failure getReason() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent$Ringing;", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Ringing extends CallEvent {
            public Ringing() {
                super(null);
            }
        }

        public CallEvent() {
        }

        public CallEvent(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$DeclineCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class DeclineCallMutator extends Mutator<CallManager.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DeclineCallMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof CallManager.State.InCall.Ringing)) {
                return state;
            }
            Call access$getCall$p = CallManagerImpl.access$getCall$p(CallManagerImpl.this, state);
            Objects.requireNonNull(access$getCall$p, "null cannot be cast to non-null type com.avito.android.calls.IncomingCall");
            IncomingCall incomingCall = (IncomingCall) access$getCall$p;
            try {
                incomingCall.decline();
            } catch (Exception e) {
                Logs.error(CallManagerImpl.this.getTAG(), "Failed to decline incoming call", e);
                incomingCall.hangup();
            }
            return CallManager.State.InCall.Ringing.copy$default((CallManager.State.InCall.Ringing) state, null, null, null, true, 7, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$EnableMicMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "", "d", "Z", "getEnable", "()Z", "enable", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class EnableMicMutator extends Mutator<CallManager.State> {
        public final boolean d;

        public EnableMicMutator(boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        public final boolean getEnable() {
            return this.d;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Call access$getCall$p = CallManagerImpl.access$getCall$p(CallManagerImpl.this, state);
            if (access$getCall$p != null) {
                access$getCall$p.sendAudio(this.d);
            }
            if (state instanceof CallManager.State.Idle.None) {
                return CallManager.State.Idle.None.copy$default((CallManager.State.Idle.None) state, false, this.d, null, 5, null);
            }
            if (state instanceof CallManager.State.Idle.Finished) {
                return CallManager.State.Idle.Finished.copy$default((CallManager.State.Idle.Finished) state, false, null, null, null, this.d, 15, null);
            }
            if (state instanceof CallManager.State.InCall.Dialing) {
                return CallManager.State.InCall.Dialing.copy$default((CallManager.State.InCall.Dialing) state, null, this.d, null, null, false, 29, null);
            }
            return state instanceof CallManager.State.InCall.Connected ? CallManager.State.InCall.Connected.copy$default((CallManager.State.InCall.Connected) state, null, this.d, null, null, false, 29, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$HangupCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class HangupCallMutator extends Mutator<CallManager.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public HangupCallMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallManager.State.Idle.None) {
                if (((CallManager.State.Idle.None) state).getCallRequest() != null) {
                    return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(((CallManager.State.Idle.None) state).getCallRequest(), null, false, null, 0, null, null, Long.valueOf(CallManagerImpl.this.x.now()), null, 191, null), AppCallResult.Hangup.HangupCallerEarly.INSTANCE, null, false, 16, null);
                }
                return (CallManager.State.Idle) state;
            } else if (state instanceof CallManager.State.Idle.Finished) {
                return state;
            } else {
                if (state instanceof CallManager.State.InCall) {
                    Call access$getCall$p = CallManagerImpl.access$getCall$p(CallManagerImpl.this, state);
                    if (access$getCall$p != null) {
                        access$getCall$p.hangup();
                        if (state instanceof CallManager.State.InCall.Dialing) {
                            return CallManager.State.InCall.Dialing.copy$default((CallManager.State.InCall.Dialing) state, null, false, null, null, true, 15, null);
                        }
                        if (state instanceof CallManager.State.InCall.Ringing) {
                            return CallManager.State.InCall.Ringing.copy$default((CallManager.State.InCall.Ringing) state, null, null, null, true, 7, null);
                        }
                        if (state instanceof CallManager.State.InCall.Connected) {
                            return CallManager.State.InCall.Connected.copy$default((CallManager.State.InCall.Connected) state, null, false, null, null, true, 15, null);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    CallManager.State.InCall inCall = (CallManager.State.InCall) state;
                    return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(inCall.getInfo(), null, false, null, 0, null, null, Long.valueOf(CallManagerImpl.this.x.now()), null, 191, null), AppCallResult.Hangup.HangupCallerEarly.INSTANCE, inCall.getSipInfo(), false, 16, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$MakeCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls_shared/AppCallInfo;", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "", "e", "Ljava/lang/String;", "callAs", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class MakeCallMutator extends Mutator<CallManager.State> {
        public final AppCallInfo d;
        public final String e;
        public final /* synthetic */ CallManagerImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MakeCallMutator(@NotNull CallManagerImpl callManagerImpl, @Nullable AppCallInfo appCallInfo, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(appCallInfo, "callInfo");
            this.f = callManagerImpl;
            this.d = appCallInfo;
            this.e = str;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!this.f.A.isIdle()) {
                return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(this.d, null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), AppCallResult.Busy.System.INSTANCE, null, false, 16, null);
            } else if (state instanceof CallManager.State.Idle) {
                if (state.getConnected()) {
                    this.f.B.track(new CallEvent.ConnectedToVoximplant(this.d.getCallId(), CallSide.OUTGOING));
                    ItemInfo item = this.d.getItem();
                    CallExtras callExtras = new CallExtras(item != null ? item.getItemId() : null, CallTypesToEventParamMapperKt.getEventValue(this.d.getScenario()));
                    this.f.C.exposeIfNeeded();
                    OutgoingCall makeCall = this.f.v.makeCall(this.d.getCallId(), this.d.getCaller().getContact(), false, ((CallsEarlyBeepsTestGroup) this.f.C.getTestGroup()).isTest(), callExtras);
                    if (makeCall == null) {
                        return new CallManager.State.Idle.Finished(true, AppCallInfo.copy$default(this.d, null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), AppCallResult.Error.InternalError.INSTANCE, null, false, 16, null);
                    }
                    try {
                        this.f.w.addCall(this.d.getCallId(), makeCall);
                        makeCall.setQualityIssueListener(this.f.y);
                        makeCall.addListener(this.f);
                        makeCall.start();
                        makeCall.sendAudio(state.getSendAudio());
                        this.f.B.track(new CallEvent.Dialing(this.d));
                        return new CallManager.State.InCall.Dialing(this.d, state.getSendAudio(), null, null, false, 24, null);
                    } catch (Exception e2) {
                        makeCall.setQualityIssueListener(null);
                        makeCall.removeListener(this.f);
                        Logs.warning(this.f.getTAG(), "Failed to start call", e2);
                        return new CallManager.State.Idle.Finished(true, AppCallInfo.copy$default(this.d, null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), AppCallResult.Error.CantMakeCall.INSTANCE, null, false, 16, null);
                    }
                } else {
                    this.f.v.connectForOutgoingCall(this.e);
                    return new CallManager.State.Idle.None(false, false, this.d, 2, null);
                }
            } else if (state instanceof CallManager.State.InCall) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MakeCallMutator(CallManagerImpl callManagerImpl, AppCallInfo appCallInfo, String str, int i, j jVar) {
            this(callManagerImpl, appCallInfo, (i & 2) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnCallEventMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls/Call;", "d", "Lcom/avito/android/calls/Call;", "call", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "e", "Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;", "event", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/Call;Lcom/avito/android/in_app_calls/CallManagerImpl$CallEvent;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnCallEventMutator extends Mutator<CallManager.State> {
        public final Call d;
        public final CallEvent e;
        public final /* synthetic */ CallManagerImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnCallEventMutator(@NotNull CallManagerImpl callManagerImpl, @NotNull Call call, CallEvent callEvent) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(callEvent, "event");
            this.f = callManagerImpl;
            this.d = call;
            this.e = callEvent;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            AppCallResult appCallResult;
            AppCallResult appCallResult2;
            CallManager.MissedCallReason missedCallReason;
            AppCallResult appCallResult3;
            CallManager.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            if (state2 instanceof CallManager.State.Idle) {
                Call call = this.d;
                if (!(call instanceof IncomingCall) || !(this.e instanceof CallEvent.Ringing)) {
                    call.removeListener(this.f);
                    this.d.setQualityIssueListener(null);
                    this.d.hangup();
                } else {
                    state2 = new CallManager.State.InCall.Ringing(new AppCallInfo(this.d.getUuid(), ((IncomingCall) this.d).getCallerId(), true, this.f.x.now(), AppCallScenario.INCOMING_CALL), null, null, false, 12, null);
                }
            } else if (state2 instanceof CallManager.State.InCall.Dialing) {
                CallManager.State.InCall.Dialing dialing = (CallManager.State.InCall.Dialing) state2;
                if (!Intrinsics.areEqual(this.d.getUuid(), dialing.getInfo().getCallId())) {
                    this.f.w.removeCall(this.d.getUuid());
                    this.d.removeListener(this.f);
                    this.d.setQualityIssueListener(null);
                    this.d.hangup();
                    return state2;
                }
                CallEvent callEvent = this.e;
                if (!(callEvent instanceof CallEvent.Ringing)) {
                    if (callEvent instanceof CallEvent.Connected) {
                        return new CallManager.State.InCall.Connected(AppCallInfo.copy$default(dialing.getInfo(), null, false, null, 0, null, Long.valueOf(this.f.x.now()), null, null, 223, null), state.getSendAudio(), dialing.getSipInfo(), ((CallManager.State.InCall.Dialing) state2).getVideoStreams(), false, 16, null);
                    } else if (callEvent instanceof CallEvent.Failed) {
                        this.d.removeListener(this.f);
                        this.d.setQualityIssueListener(null);
                        this.f.w.removeCall(this.d.getUuid());
                        CallManager.State.InCall.Dialing dialing2 = (CallManager.State.InCall.Dialing) state2;
                        return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(dialing2.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), CallManagerImpl.access$toDisconnectReason(this.f, ((CallEvent.Failed) this.e).getReason()), dialing2.getSipInfo(), false, 16, null);
                    } else if (callEvent instanceof CallEvent.Disconnected) {
                        this.d.removeListener(this.f);
                        this.d.setQualityIssueListener(null);
                        this.f.w.removeCall(this.d.getUuid());
                        if (dialing.getWasHangupByUser()) {
                            appCallResult3 = AppCallResult.Hangup.HangupCallerEarly.INSTANCE;
                        } else {
                            appCallResult3 = AppCallResult.Hangup.NonUserHangup.INSTANCE;
                        }
                        CallManager.State.InCall.Dialing dialing3 = (CallManager.State.InCall.Dialing) state2;
                        return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(dialing3.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), appCallResult3, dialing3.getSipInfo(), false, 16, null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (state2 instanceof CallManager.State.InCall.Ringing) {
                CallEvent callEvent2 = this.e;
                if (!(callEvent2 instanceof CallEvent.Ringing)) {
                    if (callEvent2 instanceof CallEvent.Connected) {
                        CallManager.State.InCall.Ringing ringing = (CallManager.State.InCall.Ringing) state2;
                        return new CallManager.State.InCall.Connected(AppCallInfo.copy$default(ringing.getInfo(), null, false, null, 0, null, Long.valueOf(this.f.x.now()), null, null, 223, null), state.getSendAudio(), ringing.getSipInfo(), ((CallManager.State.InCall.Ringing) state2).getVideoStreams(), false, 16, null);
                    } else if (callEvent2 instanceof CallEvent.Failed) {
                        this.d.removeListener(this.f);
                        this.d.setQualityIssueListener(null);
                        this.f.w.removeCall(this.d.getUuid());
                        this.f.getMissedCallsStream().accept(new CallManager.MissedCallData(this.d.getUuid(), CallManager.MissedCallReason.Failed.INSTANCE, AppCallInfo.copy$default(((CallManager.State.InCall.Ringing) state2).getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null)));
                        CallManager.State.InCall.Ringing ringing2 = (CallManager.State.InCall.Ringing) state2;
                        return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(ringing2.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), CallManagerImpl.access$toDisconnectReason(this.f, ((CallEvent.Failed) this.e).getReason()), ringing2.getSipInfo(), false, 16, null);
                    } else if (callEvent2 instanceof CallEvent.Disconnected) {
                        this.d.removeListener(this.f);
                        this.d.setQualityIssueListener(null);
                        CallManager.State.InCall.Ringing ringing3 = (CallManager.State.InCall.Ringing) state2;
                        if (!ringing3.getWasHangupByUser()) {
                            if (((CallEvent.Disconnected) this.e).getAnsweredElsewhere()) {
                                missedCallReason = CallManager.MissedCallReason.AnsweredElsewhere.INSTANCE;
                            } else {
                                missedCallReason = CallManager.MissedCallReason.Missed.INSTANCE;
                            }
                            this.f.getMissedCallsStream().accept(new CallManager.MissedCallData(this.d.getUuid(), missedCallReason, AppCallInfo.copy$default(ringing3.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null)));
                        }
                        boolean connected = state.getConnected();
                        CallManager.State.InCall.Ringing ringing4 = (CallManager.State.InCall.Ringing) state2;
                        AppCallInfo copy$default = AppCallInfo.copy$default(ringing4.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null);
                        if (ringing4.getWasHangupByUser()) {
                            appCallResult2 = AppCallResult.Declined.INSTANCE;
                        } else {
                            appCallResult2 = AppCallResult.Hangup.HangupCaller.INSTANCE;
                        }
                        return new CallManager.State.Idle.Finished(connected, copy$default, appCallResult2, ringing4.getSipInfo(), false, 16, null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (state2 instanceof CallManager.State.InCall.Connected) {
                CallEvent callEvent3 = this.e;
                if (!(callEvent3 instanceof CallEvent.Ringing) && !(callEvent3 instanceof CallEvent.Connected)) {
                    if (callEvent3 instanceof CallEvent.Failed) {
                        this.d.removeListener(this.f);
                        this.d.setQualityIssueListener(null);
                        CallManager.State.InCall.Connected connected2 = (CallManager.State.InCall.Connected) state2;
                        return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(connected2.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), CallManagerImpl.access$toDisconnectReason(this.f, ((CallEvent.Failed) this.e).getReason()), connected2.getSipInfo(), false, 16, null);
                    } else if (callEvent3 instanceof CallEvent.Disconnected) {
                        this.d.removeListener(this.f);
                        this.d.setQualityIssueListener(null);
                        this.f.w.removeCall(this.d.getUuid());
                        CallManager.State.InCall.Connected connected3 = (CallManager.State.InCall.Connected) state2;
                        boolean isIncoming = connected3.getInfo().isIncoming();
                        if (!((CallEvent.Disconnected) this.e).getUserInititated()) {
                            appCallResult = AppCallResult.Error.UnknownError.INSTANCE;
                        } else if (connected3.getWasHangupByUser()) {
                            if (isIncoming) {
                                appCallResult = AppCallResult.Hangup.HangupReceiver.INSTANCE;
                            } else {
                                appCallResult = AppCallResult.Hangup.HangupCaller.INSTANCE;
                            }
                        } else if (isIncoming) {
                            appCallResult = AppCallResult.Hangup.HangupCaller.INSTANCE;
                        } else {
                            appCallResult = AppCallResult.Hangup.HangupReceiver.INSTANCE;
                        }
                        CallManager.State.InCall.Connected connected4 = (CallManager.State.InCall.Connected) state2;
                        return new CallManager.State.Idle.Finished(state.getConnected(), AppCallInfo.copy$default(connected4.getInfo(), null, false, null, 0, null, null, Long.valueOf(this.f.x.now()), null, 191, null), appCallResult, connected4.getSipInfo(), false, 16, null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return state2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnCallSipInfoReceived;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "", "e", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "Lcom/avito/android/calls/Call;", "d", "Lcom/avito/android/calls/Call;", "getCall", "()Lcom/avito/android/calls/Call;", "call", "f", "getContent", "content", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/Call;Ljava/lang/String;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnCallSipInfoReceived extends Mutator<CallManager.State> {
        @NotNull
        public final Call d;
        @Nullable
        public final String e;
        @Nullable
        public final String f;
        public final /* synthetic */ CallManagerImpl g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnCallSipInfoReceived(@NotNull CallManagerImpl callManagerImpl, @Nullable Call call, @Nullable String str, String str2) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(call, "call");
            this.g = callManagerImpl;
            this.d = call;
            this.e = str;
            this.f = str2;
        }

        @NotNull
        public final Call getCall() {
            return this.d;
        }

        @Nullable
        public final String getContent() {
            return this.f;
        }

        @Nullable
        public final String getType() {
            return this.e;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String id = this.d.getId();
            Call access$getCall$p = CallManagerImpl.access$getCall$p(this.g, state);
            if (!Intrinsics.areEqual(id, access$getCall$p != null ? access$getCall$p.getId() : null) || (state instanceof CallManager.State.Idle)) {
                return state;
            }
            if (state instanceof CallManager.State.InCall.Dialing) {
                return CallManager.State.InCall.Dialing.copy$default((CallManager.State.InCall.Dialing) state, null, false, new CallManager.CallSipInfo(this.e, this.f), null, false, 27, null);
            }
            if (state instanceof CallManager.State.InCall.Ringing) {
                return CallManager.State.InCall.Ringing.copy$default((CallManager.State.InCall.Ringing) state, null, new CallManager.CallSipInfo(this.e, this.f), null, false, 13, null);
            }
            if (state instanceof CallManager.State.InCall.Connected) {
                return CallManager.State.InCall.Connected.copy$default((CallManager.State.InCall.Connected) state, null, false, new CallManager.CallSipInfo(this.e, this.f), null, false, 27, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnClientConnectedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnClientConnectedMutator extends Mutator<CallManager.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public OnClientConnectedMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallManager.State.Idle.None) {
                CallManager.State.Idle.None none = (CallManager.State.Idle.None) state;
                if (none.getCallRequest() != null) {
                    CallManagerImpl.this.getReducerQueue().plusAssign(new MakeCallMutator(CallManagerImpl.this, none.getCallRequest(), null, 2, null));
                }
                return CallManager.State.Idle.None.copy$default(none, true, false, null, 6, null);
            } else if (state instanceof CallManager.State.Idle.Finished) {
                return CallManager.State.Idle.Finished.copy$default((CallManager.State.Idle.Finished) state, true, null, null, null, false, 30, null);
            } else {
                if (state instanceof CallManager.State.InCall) {
                    return state;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnClientDisconnectedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls/ConnectionListener$DisconnectReason;", "d", "Lcom/avito/android/calls/ConnectionListener$DisconnectReason;", "reason", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/ConnectionListener$DisconnectReason;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnClientDisconnectedMutator extends Mutator<CallManager.State> {
        public final ConnectionListener.DisconnectReason d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnClientDisconnectedMutator(@NotNull CallManagerImpl callManagerImpl, ConnectionListener.DisconnectReason disconnectReason) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(disconnectReason, "reason");
            this.d = disconnectReason;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallManager.State.Idle.None) {
                CallManager.State.Idle.None none = (CallManager.State.Idle.None) state;
                if (none.getCallRequest() != null) {
                    return new CallManager.State.Idle.Finished(false, none.getCallRequest(), ErrorMappingKt.toAppCallResult(this.d), null, false, 16, null);
                }
                return new CallManager.State.Idle.None(false, false, null, 6, null);
            } else if (state instanceof CallManager.State.Idle.Finished) {
                return CallManager.State.Idle.Finished.copy$default((CallManager.State.Idle.Finished) state, false, null, null, null, false, 30, null);
            } else {
                if (state instanceof CallManager.State.InCall) {
                    CallManager.State.InCall inCall = (CallManager.State.InCall) state;
                    return new CallManager.State.Idle.Finished(false, inCall.getInfo(), ErrorMappingKt.toAppCallResult(this.d), inCall.getSipInfo(), false, 16, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnIncomingCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls_shared/AppCallInfo;", "Lcom/avito/android/calls/Call;", "call", "", "timestamp", AuthSource.SEND_ABUSE, "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls/Call;J)Lcom/avito/android/calls_shared/AppCallInfo;", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnIncomingCallMutator extends Mutator<CallManager.State> {
        public final AppCallInfo d;
        public final /* synthetic */ CallManagerImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnIncomingCallMutator(@NotNull CallManagerImpl callManagerImpl, AppCallInfo appCallInfo) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(appCallInfo, "callInfo");
            this.e = callManagerImpl;
            this.d = appCallInfo;
        }

        public final AppCallInfo a(AppCallInfo appCallInfo, Call call, long j) {
            CallManager.MissedCallData missedCallData;
            Relay<CallManager.MissedCallData> relay;
            AppCallInfo copy$default = AppCallInfo.copy$default(this.d, null, false, null, j, null, null, Long.valueOf(j), null, 183, null);
            if (call instanceof IncomingCall) {
                try {
                    ((IncomingCall) call).busy();
                    this.e.w.removeCall(appCallInfo.getCallId());
                    relay = this.e.getMissedCallsStream();
                    missedCallData = new CallManager.MissedCallData(appCallInfo.getCallId(), CallManager.MissedCallReason.Busy.INSTANCE, copy$default);
                } catch (Exception e2) {
                    CallManagerImpl.access$logDebug(this.e, "Failed to reject incoming call", e2);
                    call.hangup();
                    this.e.w.removeCall(appCallInfo.getCallId());
                    relay = this.e.getMissedCallsStream();
                    missedCallData = new CallManager.MissedCallData(appCallInfo.getCallId(), CallManager.MissedCallReason.Busy.INSTANCE, copy$default);
                } catch (Throwable th) {
                    this.e.w.removeCall(appCallInfo.getCallId());
                    this.e.getMissedCallsStream().accept(new CallManager.MissedCallData(appCallInfo.getCallId(), CallManager.MissedCallReason.Busy.INSTANCE, copy$default));
                    throw th;
                }
                relay.accept(missedCallData);
            } else {
                CallManagerImpl callManagerImpl = this.e;
                StringBuilder L = a2.b.a.a.a.L("Not IncomingCall ignored: callId = ");
                L.append(appCallInfo.getCallId());
                L.append(", call = ");
                L.append(call);
                CallManagerImpl.c(callManagerImpl, L.toString(), null, 2);
            }
            return copy$default;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Call call = this.e.w.getCall(this.d.getCallId());
            long now = this.e.x.now();
            boolean z = false;
            if ((state instanceof CallManager.State.InCall) || ((state instanceof CallManager.State.Idle.None) && ((CallManager.State.Idle.None) state).getCallRequest() != null)) {
                String callId = this.d.getCallId();
                AppCallInfo info = state.getInfo();
                if (!Intrinsics.areEqual(callId, info != null ? info.getCallId() : null)) {
                    z = true;
                }
            }
            boolean z2 = !this.e.A.isIdle();
            if (z) {
                a(this.d, call, now);
                return state;
            } else if (z2) {
                return new CallManager.State.Idle.Finished(state.getConnected(), a(this.d, call, now), AppCallResult.Busy.System.INSTANCE, null, false, 16, null);
            } else if (!(state instanceof CallManager.State.Idle)) {
                return state;
            } else {
                if (call instanceof IncomingCall) {
                    call.setQualityIssueListener(this.e.y);
                    call.addListener(this.e);
                    CallEventTracker callEventTracker = this.e.B;
                    AppCallInfo appCallInfo = this.d;
                    Context applicationContext = this.e.t.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    callEventTracker.track(new CallEvent.Ringing(appCallInfo, NotificationsKt.areIncomingCallNotificationsAllowed(applicationContext)));
                    return new CallManager.State.InCall.Ringing(AppCallInfo.copy$default(this.d, null, false, null, now, null, null, null, null, 247, null), null, null, false, 12, null);
                }
                CallManagerImpl callManagerImpl = this.e;
                StringBuilder L = a2.b.a.a.a.L("Not IncomingCall ignored: callId = ");
                L.append(this.d.getCallId());
                L.append(", call = ");
                L.append(call);
                CallManagerImpl.c(callManagerImpl, L.toString(), null, 2);
                return state;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnLocalVideoStreamAddedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls/CallVideoStream;", "e", "Lcom/avito/android/calls/CallVideoStream;", "stream", "Lcom/avito/android/calls/Call;", "d", "Lcom/avito/android/calls/Call;", "call", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/Call;Lcom/avito/android/calls/CallVideoStream;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnLocalVideoStreamAddedMutator extends Mutator<CallManager.State> {
        public final Call d;
        public final CallVideoStream e;
        public final /* synthetic */ CallManagerImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnLocalVideoStreamAddedMutator(@NotNull CallManagerImpl callManagerImpl, @NotNull Call call, CallVideoStream callVideoStream) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(callVideoStream, "stream");
            this.f = callManagerImpl;
            this.d = call;
            this.e = callVideoStream;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String uuid = this.d.getUuid();
            Call access$getCall$p = CallManagerImpl.access$getCall$p(this.f, state);
            if (!Intrinsics.areEqual(uuid, access$getCall$p != null ? access$getCall$p.getUuid() : null)) {
                return state;
            }
            if (state instanceof CallManager.State.InCall.Dialing) {
                CallManager.State.InCall.Dialing dialing = (CallManager.State.InCall.Dialing) state;
                return CallManager.State.InCall.Dialing.copy$default(dialing, null, false, null, CallManager.VideoStreams.copy$default(dialing.getVideoStreams(), r.plus(dialing.getVideoStreams().getLocal(), TuplesKt.to(this.e.getStreamId(), this.e)), null, 2, null), false, 23, null);
            } else if (state instanceof CallManager.State.InCall.Ringing) {
                CallManager.State.InCall.Ringing ringing = (CallManager.State.InCall.Ringing) state;
                return CallManager.State.InCall.Ringing.copy$default(ringing, null, null, CallManager.VideoStreams.copy$default(ringing.getVideoStreams(), r.plus(ringing.getVideoStreams().getLocal(), TuplesKt.to(this.e.getStreamId(), this.e)), null, 2, null), false, 11, null);
            } else if (!(state instanceof CallManager.State.InCall.Connected)) {
                return state;
            } else {
                CallManager.State.InCall.Connected connected = (CallManager.State.InCall.Connected) state;
                return CallManager.State.InCall.Connected.copy$default(connected, null, false, null, CallManager.VideoStreams.copy$default(connected.getVideoStreams(), r.plus(connected.getVideoStreams().getLocal(), TuplesKt.to(this.e.getStreamId(), this.e)), null, 2, null), false, 23, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnLocalVideoStreamRemovedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls/Call;", "d", "Lcom/avito/android/calls/Call;", "call", "Lcom/avito/android/calls/CallVideoStream;", "e", "Lcom/avito/android/calls/CallVideoStream;", "stream", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/Call;Lcom/avito/android/calls/CallVideoStream;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnLocalVideoStreamRemovedMutator extends Mutator<CallManager.State> {
        public final Call d;
        public final CallVideoStream e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnLocalVideoStreamRemovedMutator(@NotNull CallManagerImpl callManagerImpl, @NotNull Call call, CallVideoStream callVideoStream) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(callVideoStream, "stream");
            this.d = call;
            this.e = callVideoStream;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallManager.State.InCall.Dialing) {
                CallManager.State.InCall.Dialing dialing = (CallManager.State.InCall.Dialing) state;
                return CallManager.State.InCall.Dialing.copy$default(dialing, null, false, null, CallManager.VideoStreams.copy$default(dialing.getVideoStreams(), r.minus(dialing.getVideoStreams().getLocal(), this.e.getStreamId()), null, 2, null), false, 23, null);
            } else if (state instanceof CallManager.State.InCall.Ringing) {
                CallManager.State.InCall.Ringing ringing = (CallManager.State.InCall.Ringing) state;
                return CallManager.State.InCall.Ringing.copy$default(ringing, null, null, CallManager.VideoStreams.copy$default(ringing.getVideoStreams(), r.minus(ringing.getVideoStreams().getLocal(), this.e.getStreamId()), null, 2, null), false, 11, null);
            } else if (!(state instanceof CallManager.State.InCall.Connected)) {
                return state;
            } else {
                CallManager.State.InCall.Connected connected = (CallManager.State.InCall.Connected) state;
                return CallManager.State.InCall.Connected.copy$default(connected, null, false, null, CallManager.VideoStreams.copy$default(connected.getVideoStreams(), r.minus(connected.getVideoStreams().getLocal(), this.e.getStreamId()), null, 2, null), false, 23, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnReconnectCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls_shared/AppCallInfo;", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCallInfo", "()Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "", "e", "Z", "getEnableMic", "()Z", "enableMic", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls_shared/AppCallInfo;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnReconnectCallMutator extends Mutator<CallManager.State> {
        @NotNull
        public final AppCallInfo d;
        public final boolean e;
        public final /* synthetic */ CallManagerImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnReconnectCallMutator(@NotNull CallManagerImpl callManagerImpl, AppCallInfo appCallInfo, boolean z) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(appCallInfo, "callInfo");
            this.f = callManagerImpl;
            this.d = appCallInfo;
            this.e = z;
        }

        @NotNull
        public final AppCallInfo getCallInfo() {
            return this.d;
        }

        public final boolean getEnableMic() {
            return this.e;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Call call = this.f.w.getCall(this.d.getCallId());
            Objects.requireNonNull(call, "null cannot be cast to non-null type com.avito.android.calls.IncomingCall");
            IncomingCall incomingCall = (IncomingCall) call;
            boolean isIdle = this.f.A.isIdle();
            if (!(state instanceof CallManager.State.Idle) || !isIdle) {
                try {
                    incomingCall.busy();
                    return state;
                } catch (Exception unused) {
                    incomingCall.hangup();
                    return state;
                }
            } else {
                incomingCall.setQualityIssueListener(this.f.y);
                incomingCall.addListener(this.f);
                try {
                    incomingCall.sendAudio(this.e);
                    IncomingCall.DefaultImpls.answer$default(incomingCall, false, 1, null);
                    return new CallManager.State.InCall.Connected(AppCallInfo.copy$default(this.d, null, false, null, 0, null, null, null, null, 191, null), this.e, null, new CallManager.VideoStreams(null, null, 3, null), false, 16, null);
                } catch (Exception unused2) {
                    incomingCall.setQualityIssueListener(null);
                    incomingCall.removeListener(this.f);
                    incomingCall.hangup();
                    return state;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnRemoteVideoStreamAddedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls/CallVideoStream;", "e", "Lcom/avito/android/calls/CallVideoStream;", "stream", "Lcom/avito/android/calls/Call;", "d", "Lcom/avito/android/calls/Call;", "call", "", "endpointId", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/Call;Ljava/lang/String;Lcom/avito/android/calls/CallVideoStream;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnRemoteVideoStreamAddedMutator extends Mutator<CallManager.State> {
        public final Call d;
        public final CallVideoStream e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnRemoteVideoStreamAddedMutator(@NotNull CallManagerImpl callManagerImpl, @NotNull Call call, @NotNull String str, CallVideoStream callVideoStream) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(str, "endpointId");
            Intrinsics.checkNotNullParameter(callVideoStream, "stream");
            this.d = call;
            this.e = callVideoStream;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallManager.State.InCall.Dialing) {
                CallManager.State.InCall.Dialing dialing = (CallManager.State.InCall.Dialing) state;
                return CallManager.State.InCall.Dialing.copy$default(dialing, null, false, null, CallManager.VideoStreams.copy$default(dialing.getVideoStreams(), null, r.plus(dialing.getVideoStreams().getRemote(), TuplesKt.to(this.e.getStreamId(), this.e)), 1, null), false, 23, null);
            } else if (state instanceof CallManager.State.InCall.Ringing) {
                CallManager.State.InCall.Ringing ringing = (CallManager.State.InCall.Ringing) state;
                return CallManager.State.InCall.Ringing.copy$default(ringing, null, null, CallManager.VideoStreams.copy$default(ringing.getVideoStreams(), null, r.plus(ringing.getVideoStreams().getRemote(), TuplesKt.to(this.e.getStreamId(), this.e)), 1, null), false, 11, null);
            } else if (!(state instanceof CallManager.State.InCall.Connected)) {
                return state;
            } else {
                CallManager.State.InCall.Connected connected = (CallManager.State.InCall.Connected) state;
                return CallManager.State.InCall.Connected.copy$default(connected, null, false, null, CallManager.VideoStreams.copy$default(connected.getVideoStreams(), null, r.plus(connected.getVideoStreams().getRemote(), TuplesKt.to(this.e.getStreamId(), this.e)), 1, null), false, 23, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnRemoteVideoStreamRemovedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/calls/CallVideoStream;", "e", "Lcom/avito/android/calls/CallVideoStream;", "stream", "Lcom/avito/android/calls/Call;", "d", "Lcom/avito/android/calls/Call;", "call", "", "endpointId", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/calls/Call;Ljava/lang/String;Lcom/avito/android/calls/CallVideoStream;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnRemoteVideoStreamRemovedMutator extends Mutator<CallManager.State> {
        public final Call d;
        public final CallVideoStream e;
        public final /* synthetic */ CallManagerImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnRemoteVideoStreamRemovedMutator(@NotNull CallManagerImpl callManagerImpl, @NotNull Call call, @NotNull String str, CallVideoStream callVideoStream) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(str, "endpointId");
            Intrinsics.checkNotNullParameter(callVideoStream, "stream");
            this.f = callManagerImpl;
            this.d = call;
            this.e = callVideoStream;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String uuid = this.d.getUuid();
            Call access$getCall$p = CallManagerImpl.access$getCall$p(this.f, state);
            if (!Intrinsics.areEqual(uuid, access$getCall$p != null ? access$getCall$p.getUuid() : null)) {
                return state;
            }
            if (state instanceof CallManager.State.InCall.Dialing) {
                CallManager.State.InCall.Dialing dialing = (CallManager.State.InCall.Dialing) state;
                return CallManager.State.InCall.Dialing.copy$default(dialing, null, false, null, CallManager.VideoStreams.copy$default(dialing.getVideoStreams(), null, r.minus(dialing.getVideoStreams().getRemote(), this.e.getStreamId()), 1, null), false, 23, null);
            } else if (state instanceof CallManager.State.InCall.Ringing) {
                CallManager.State.InCall.Ringing ringing = (CallManager.State.InCall.Ringing) state;
                return CallManager.State.InCall.Ringing.copy$default(ringing, null, null, CallManager.VideoStreams.copy$default(ringing.getVideoStreams(), null, r.minus(ringing.getVideoStreams().getRemote(), this.e.getStreamId()), 1, null), false, 11, null);
            } else if (!(state instanceof CallManager.State.InCall.Connected)) {
                return state;
            } else {
                CallManager.State.InCall.Connected connected = (CallManager.State.InCall.Connected) state;
                return CallManager.State.InCall.Connected.copy$default(connected, null, false, null, CallManager.VideoStreams.copy$default(connected.getVideoStreams(), null, r.minus(connected.getVideoStreams().getRemote(), this.e.getStreamId()), 1, null), false, 23, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$OnSystemCallStateChangedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/CallManager$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)V", "", "d", "Z", "isOffHook", "()Z", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnSystemCallStateChangedAction extends Action<CallManager.State> {
        public final boolean d;

        public OnSystemCallStateChangedAction(boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        public final boolean isOffHook() {
            return this.d;
        }

        public void invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (((state instanceof CallManager.State.InCall) || ((state instanceof CallManager.State.Idle.None) && ((CallManager.State.Idle.None) state).getCallRequest() != null)) && this.d) {
                CallManagerImpl.this.getReducerQueue().plusAssign(new HangupCallMutator());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$RegisterAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/CallManager$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)V", "", "d", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class RegisterAction extends Action<CallManager.State> {
        @NotNull
        public final String d;
        public final /* synthetic */ CallManagerImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RegisterAction(@NotNull CallManagerImpl callManagerImpl, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            this.e = callManagerImpl;
            this.d = str;
        }

        @NotNull
        public final String getUserId() {
            return this.d;
        }

        public void invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            this.e.v.setIncomingCallListener(this.e.u);
            this.e.v.register(this.d);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$StartForIncomingCallAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/CallManager$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)V", "Lcom/avito/android/push/Push;", "d", "Lcom/avito/android/push/Push;", "getPush", "()Lcom/avito/android/push/Push;", "push", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/push/Push;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class StartForIncomingCallAction extends Action<CallManager.State> {
        @Nullable
        public final Push d;

        public StartForIncomingCallAction(@Nullable Push push) {
            super(null, null, 3, null);
            this.d = push;
        }

        @Nullable
        public final Push getPush() {
            return this.d;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ StartForIncomingCallAction(CallManagerImpl callManagerImpl, Push push, int i, j jVar) {
            this((i & 1) != 0 ? null : push);
        }

        public void invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            AvitoCallClient avitoCallClient = CallManagerImpl.this.v;
            Push push = this.d;
            avitoCallClient.connectForIncomingCall(push != null ? push.getData() : null);
            CallManagerImpl.this.s.accept(20L);
            if (this.d != null) {
                String trackNewPush = CallManagerImpl.this.z.trackNewPush(this.d);
                if (!((state instanceof CallManager.State.InCall) || ((state instanceof CallManager.State.Idle.None) && ((CallManager.State.Idle.None) state).getCallRequest() != null)) && CallManagerImpl.this.A.isIdle()) {
                    CallManagerImpl.this.r.accept(trackNewPush);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$UnregisterMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class UnregisterMutator extends Mutator<CallManager.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public UnregisterMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            try {
                Call access$getCall$p = CallManagerImpl.access$getCall$p(CallManagerImpl.this, state);
                if (access$getCall$p != null) {
                    access$getCall$p.removeListener(CallManagerImpl.this);
                }
                Call access$getCall$p2 = CallManagerImpl.access$getCall$p(CallManagerImpl.this, state);
                if (access$getCall$p2 != null) {
                    access$getCall$p2.hangup();
                }
            } catch (Exception unused) {
                CallManagerImpl.c(CallManagerImpl.this, "Failed to hangup active call", null, 2);
            }
            CallManagerImpl.this.v.unregister();
            CallManagerImpl.this.v.setIncomingCallListener(null);
            return new CallManager.State.Idle.None(false, false, null, 6, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$UpdateCallInfoMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/CallManager$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)Lcom/avito/android/in_app_calls/CallManager$State;", "Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "d", "Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "getUpdate", "()Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;", "update", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/in_app_calls/CallManager$CallInfoUpdate;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class UpdateCallInfoMutator extends Mutator<CallManager.State> {
        @NotNull
        public final CallManager.CallInfoUpdate d;
        public final /* synthetic */ CallManagerImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateCallInfoMutator(@NotNull CallManagerImpl callManagerImpl, CallManager.CallInfoUpdate callInfoUpdate) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(callInfoUpdate, "update");
            this.e = callManagerImpl;
            this.d = callInfoUpdate;
        }

        @NotNull
        public final CallManager.CallInfoUpdate getUpdate() {
            return this.d;
        }

        @NotNull
        public CallManager.State invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            AppCallInfo info = state.getInfo();
            if ((!Intrinsics.areEqual(info != null ? info.getCallId() : null, this.d.getCallUuid())) || (state instanceof CallManager.State.Idle.None)) {
                return state;
            }
            if (state instanceof CallManager.State.Idle.Finished) {
                CallManager.State.Idle.Finished finished = (CallManager.State.Idle.Finished) state;
                return CallManager.State.Idle.Finished.copy$default(finished, false, CallManagerImpl.access$applyUpdate(this.e, finished.getInfo(), this.d), null, null, false, 29, null);
            } else if (state instanceof CallManager.State.InCall.Dialing) {
                CallManager.State.InCall.Dialing dialing = (CallManager.State.InCall.Dialing) state;
                return CallManager.State.InCall.Dialing.copy$default(dialing, CallManagerImpl.access$applyUpdate(this.e, dialing.getInfo(), this.d), false, null, null, false, 30, null);
            } else if (state instanceof CallManager.State.InCall.Ringing) {
                CallManager.State.InCall.Ringing ringing = (CallManager.State.InCall.Ringing) state;
                return CallManager.State.InCall.Ringing.copy$default(ringing, CallManagerImpl.access$applyUpdate(this.e, ringing.getInfo(), this.d), null, null, false, 14, null);
            } else if (state instanceof CallManager.State.InCall.Connected) {
                CallManager.State.InCall.Connected connected = (CallManager.State.InCall.Connected) state;
                return CallManager.State.InCall.Connected.copy$default(connected, CallManagerImpl.access$applyUpdate(this.e, connected.getInfo(), this.d), false, null, null, false, 30, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/CallManagerImpl$UpdatePushTokenAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/CallManager$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/CallManager$State;)V", "Lcom/avito/android/push/PushToken;", "d", "Lcom/avito/android/push/PushToken;", "getPushToken", "()Lcom/avito/android/push/PushToken;", "pushToken", "<init>", "(Lcom/avito/android/in_app_calls/CallManagerImpl;Lcom/avito/android/push/PushToken;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class UpdatePushTokenAction extends Action<CallManager.State> {
        @NotNull
        public final PushToken d;
        public final /* synthetic */ CallManagerImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdatePushTokenAction(@NotNull CallManagerImpl callManagerImpl, PushToken pushToken) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(pushToken, "pushToken");
            this.e = callManagerImpl;
            this.d = pushToken;
        }

        @NotNull
        public final PushToken getPushToken() {
            return this.d;
        }

        public void invoke(@NotNull CallManager.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (this.d instanceof PushToken.GcmToken) {
                this.e.v.updatePushToken(this.d.getToken());
            }
        }
    }

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ CallManagerImpl a;

        public a(CallManagerImpl callManagerImpl) {
            this.a = callManagerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            CallManagerImpl callManagerImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "isOffHook");
            reducerQueue.plusAssign(new OnSystemCallStateChangedAction(bool2.booleanValue()));
        }
    }

    public static final class b<T, R> implements Function<Long, ObservableSource<? extends CallManager.State>> {
        public final /* synthetic */ CallManagerImpl a;
        public final /* synthetic */ SchedulersFactory b;

        public b(CallManagerImpl callManagerImpl, SchedulersFactory schedulersFactory) {
            this.a = callManagerImpl;
            this.b = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends CallManager.State> apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "timeout");
            return Observable.timer(l2.longValue(), TimeUnit.SECONDS, this.b.computation()).flatMapSingle(new a2.a.a.f1.a(this)).filter(n.b).takeUntil(this.a.getStateObservable().filter(n.c));
        }
    }

    public static final class c<T> implements Consumer<CallManager.State> {
        public final /* synthetic */ CallManagerImpl a;

        public c(CallManagerImpl callManagerImpl) {
            this.a = callManagerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CallManager.State state) {
            CallManagerImpl.c(this.a, "Disconnecting due to idle", null, 2);
            this.a.v.disconnect();
        }
    }

    public static final class d<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ CallManagerImpl a;
        public final /* synthetic */ SchedulersFactory b;

        public d(CallManagerImpl callManagerImpl, SchedulersFactory schedulersFactory) {
            this.a = callManagerImpl;
            this.b = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "pushId");
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            return this.a.getStateObservable().observeOn(this.b.computation()).takeUntil(a2.a.a.f1.b.a).ignoreElements().doOnComplete(new a2.a.a.f1.c(atomicBoolean)).timeout(20, TimeUnit.SECONDS, this.b.computation()).onErrorComplete().doFinally(new a2.a.a.f1.d(this, atomicBoolean, str2));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CallManagerImpl(@NotNull Context context, @NotNull IncomingCallHandler incomingCallHandler, @NotNull AvitoCallClient avitoCallClient, @NotNull CallRegistry callRegistry, @NotNull TimeSource timeSource, @NotNull CallQualityIssueListener callQualityIssueListener, @NotNull CallPushHandlingTracker callPushHandlingTracker, @NotNull SystemCallStateProvider systemCallStateProvider, @NotNull CallEventTracker callEventTracker, @NotNull SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> singleManuallyExposedAbTestGroup, @NotNull SchedulersFactory schedulersFactory) {
        super(LogTagsKt.TAG_CALL_MANAGER, new CallManager.State.Idle.None(false, false, null, 6, null), schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(incomingCallHandler, "incomingCallHandler");
        Intrinsics.checkNotNullParameter(avitoCallClient, "callClient");
        Intrinsics.checkNotNullParameter(callRegistry, "callRegistry");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(callQualityIssueListener, "qualityIssueTracker");
        Intrinsics.checkNotNullParameter(callPushHandlingTracker, "pushHandlingTracker");
        Intrinsics.checkNotNullParameter(systemCallStateProvider, "systemCallStateProvider");
        Intrinsics.checkNotNullParameter(callEventTracker, "callEventTracker");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "callsEarlyBeepsTestGroup");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.t = context;
        this.u = incomingCallHandler;
        this.v = avitoCallClient;
        this.w = callRegistry;
        this.x = timeSource;
        this.y = callQualityIssueListener;
        this.z = callPushHandlingTracker;
        this.A = systemCallStateProvider;
        this.B = callEventTracker;
        this.C = singleManuallyExposedAbTestGroup;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.p = create;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.q = compositeDisposable;
        Relay<String> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.r = J1;
        Relay<Long> J12 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.s = J12;
        avitoCallClient.setConnectionListener(this);
        Disposable subscribe = systemCallStateProvider.offHookStateChanges().subscribeOn(schedulersFactory.mainThread()).observeOn(getSchedulerForReducibles()).distinctUntilChanged().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "systemCallStateProvider.…(isOffHook)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = J12.observeOn(schedulersFactory.computation()).switchMap(new b(this, schedulersFactory)).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "disconnectWhenIdleReques…isconnect()\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        Disposable subscribe3 = J1.observeOn(schedulersFactory.computation()).switchMapCompletable(new d(this, schedulersFactory)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe3, "pushTrackingStream\n     …\n            .subscribe()");
        DisposableKt.plusAssign(compositeDisposable, subscribe3);
    }

    public static final AppCallInfo access$applyUpdate(CallManagerImpl callManagerImpl, AppCallInfo appCallInfo, CallManager.CallInfoUpdate callInfoUpdate) {
        CallerInfo callerInfo;
        Objects.requireNonNull(callManagerImpl);
        if (appCallInfo.isIncoming()) {
            callerInfo = callInfoUpdate.getCaller();
        } else {
            callerInfo = callInfoUpdate.getRecipient();
        }
        return AppCallInfo.copy$default(appCallInfo, null, false, callerInfo, 0, null, null, null, callInfoUpdate.getItem(), 123, null);
    }

    public static final Call access$getCall$p(CallManagerImpl callManagerImpl, CallManager.State state) {
        String callId;
        Objects.requireNonNull(callManagerImpl);
        AppCallInfo info = state.getInfo();
        if (info == null || (callId = info.getCallId()) == null) {
            return null;
        }
        return callManagerImpl.w.getCall(callId);
    }

    public static final /* synthetic */ CallManager.State access$getDefaultState$p(CallManagerImpl callManagerImpl) {
        return (CallManager.State) callManagerImpl.getDefaultState();
    }

    public static final void access$logDebug(CallManagerImpl callManagerImpl, String str, Throwable th) {
        Logs.debug(callManagerImpl.getTAG(), str, th);
    }

    public static final AppCallResult access$toDisconnectReason(CallManagerImpl callManagerImpl, Call.Failure failure) {
        Objects.requireNonNull(callManagerImpl);
        if (Intrinsics.areEqual(failure, Call.Failure.Busy.INSTANCE)) {
            return AppCallResult.Busy.App.INSTANCE;
        }
        if (Intrinsics.areEqual(failure, Call.Failure.Terminated.INSTANCE)) {
            return AppCallResult.Error.Terminated.INSTANCE;
        }
        if (Intrinsics.areEqual(failure, Call.Failure.Unavailable.INSTANCE)) {
            return AppCallResult.NotAvailable.INSTANCE;
        }
        if (Intrinsics.areEqual(failure, Call.Failure.Timeout.INSTANCE)) {
            return AppCallResult.Timeout.INSTANCE;
        }
        if (Intrinsics.areEqual(failure, Call.Failure.Rejected.INSTANCE)) {
            return AppCallResult.Declined.INSTANCE;
        }
        if (failure instanceof Call.Failure.Other) {
            Call.Failure.Other other = (Call.Failure.Other) failure;
            return new AppCallResult.Other(other.getCode(), other.getMessage());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static void c(CallManagerImpl callManagerImpl, String str, Throwable th, int i) {
        int i2 = i & 2;
        Logs.debug(callManagerImpl.getTAG(), str, null);
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void answerCall() {
        Logs.debug(getTAG(), "answer call", null);
        getReducerQueue().plusAssign(new AnswerCallMutator());
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void declineCall() {
        Logs.debug(getTAG(), "decline call", null);
        getReducerQueue().plusAssign(new DeclineCallMutator());
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void disconnectWhenIdle() {
        Logs.debug(getTAG(), "disconnectWhenIdle", null);
        this.s.accept(10L);
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void enableMic(boolean z2) {
        Logs.debug(getTAG(), "toggle mic: [" + z2 + ']', null);
        getReducerQueue().plusAssign(new EnableMicMutator(z2));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    @NotNull
    public List<String> getMissingPermissions(boolean z2) {
        List<String> missingPermissions = this.v.getMissingPermissions(z2);
        Logs.debug(getTAG(), "missing permissions [" + missingPermissions + ']', null);
        return missingPermissions;
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void hangupCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Logs.debug(getTAG(), "hangup call, reason=[" + str + ']', null);
        getReducerQueue().plusAssign(new HangupCallMutator());
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void makeCall(@NotNull AppCallInfo appCallInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(appCallInfo, "callInfo");
        Logs.debug(getTAG(), "Make call: " + appCallInfo + ", callAs = " + str, null);
        getReducerQueue().plusAssign(new MakeCallMutator(this, appCallInfo, str));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onCallAudioStarted(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logs.debug(getTAG(), "onCallAudioStarted: " + call, null);
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onCallConnected(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logs.debug(getTAG(), "onCallConnected: " + call, null);
        getReducerQueue().plusAssign(new OnCallEventMutator(this, call, new CallEvent.Connected()));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onCallDisconnected(@NotNull Call call, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logs.debug(getTAG(), "onCallDisconnected: " + call, null);
        getReducerQueue().plusAssign(new OnCallEventMutator(this, call, new CallEvent.Disconnected(z2, z3)));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onCallFailed(@NotNull Call call, @NotNull Call.Failure failure) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(failure, "reason");
        Logs.debug(getTAG(), "onCallFailed: " + call, null);
        getReducerQueue().plusAssign(new OnCallEventMutator(this, call, new CallEvent.Failed(failure)));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onCallRinging(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logs.debug(getTAG(), "onCallRinging: " + call, null);
        getReducerQueue().plusAssign(new OnCallEventMutator(this, call, new CallEvent.Ringing()));
    }

    @Override // com.avito.android.calls.ConnectionListener
    public void onClientConnected() {
        getReducerQueue().plusAssign(new OnClientConnectedMutator());
    }

    @Override // com.avito.android.calls.ConnectionListener
    public void onClientDisconnected(@NotNull ConnectionListener.DisconnectReason disconnectReason) {
        Intrinsics.checkNotNullParameter(disconnectReason, "reason");
        getReducerQueue().plusAssign(new OnClientDisconnectedMutator(this, disconnectReason));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void onIncomingCall(@NotNull AppCallInfo appCallInfo) {
        Intrinsics.checkNotNullParameter(appCallInfo, "callInfo");
        Logs.debug(getTAG(), "Received incoming call: " + appCallInfo, null);
        getReducerQueue().plusAssign(new OnIncomingCallMutator(this, appCallInfo));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onLocalVideoStreamAdded(@NotNull Call call, @NotNull CallVideoStream callVideoStream) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callVideoStream, "stream");
        getReducerQueue().plusAssign(new OnLocalVideoStreamAddedMutator(this, call, callVideoStream));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onLocalVideoStreamRemoved(@NotNull Call call, @NotNull CallVideoStream callVideoStream) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callVideoStream, "stream");
        getReducerQueue().plusAssign(new OnLocalVideoStreamRemovedMutator(this, call, callVideoStream));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void onReconnectCall(@NotNull AppCallInfo appCallInfo, boolean z2) {
        Intrinsics.checkNotNullParameter(appCallInfo, "callInfo");
        Logs.debug(getTAG(), "Reconnecting call: " + appCallInfo, null);
        getReducerQueue().plusAssign(new OnReconnectCallMutator(this, appCallInfo, z2));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onRemoteVideoStreamAdded(@NotNull Call call, @NotNull String str, @NotNull CallVideoStream callVideoStream) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(str, "endpointId");
        Intrinsics.checkNotNullParameter(callVideoStream, "stream");
        getReducerQueue().plusAssign(new OnRemoteVideoStreamAddedMutator(this, call, str, callVideoStream));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onRemoteVideoStreamRemoved(@NotNull Call call, @NotNull String str, @NotNull CallVideoStream callVideoStream) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(str, "endpointId");
        Intrinsics.checkNotNullParameter(callVideoStream, "stream");
        getReducerQueue().plusAssign(new OnRemoteVideoStreamRemovedMutator(this, call, str, callVideoStream));
    }

    @Override // com.avito.android.calls.Call.Listener
    public void onSipInfoReceived(@NotNull Call call, @Nullable String str, @Nullable String str2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(call, "call");
        getReducerQueue().plusAssign(new OnCallSipInfoReceived(this, call, str, str2));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void register(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Logs.debug(getTAG(), "register userId=[" + str + ']', null);
        getReducerQueue().plusAssign(new RegisterAction(this, str));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void startForReconnect() {
        Logs.debug(getTAG(), "start for reconnect", null);
        getReducerQueue().plusAssign(new StartForIncomingCallAction(this, null, 1, null));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public boolean startFromPush(@NotNull Push push) {
        Intrinsics.checkNotNullParameter(push, "push");
        Map<String, String> data = push.getData();
        if (data == null || !this.v.shouldStartFromPush(data)) {
            return false;
        }
        getReducerQueue().plusAssign(new StartForIncomingCallAction(push));
        return true;
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void unregister() {
        Logs.debug(getTAG(), "unregister", null);
        getReducerQueue().plusAssign(new UnregisterMutator());
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void updateCallInfo(@NotNull CallManager.CallInfoUpdate callInfoUpdate) {
        Intrinsics.checkNotNullParameter(callInfoUpdate, "update");
        Logs.debug(getTAG(), "updateCallInfo, update: [" + callInfoUpdate + ']', null);
        getReducerQueue().plusAssign(new UpdateCallInfoMutator(this, callInfoUpdate));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    public void updatePushToken(@NotNull PushToken pushToken) {
        Intrinsics.checkNotNullParameter(pushToken, "pushToken");
        Logs.debug(getTAG(), "update pushToken=[" + pushToken + ']', null);
        getReducerQueue().plusAssign(new UpdatePushTokenAction(this, pushToken));
    }

    @Override // com.avito.android.in_app_calls.CallManager
    @NotNull
    public Relay<CallManager.MissedCallData> getMissedCallsStream() {
        return this.p;
    }
}
