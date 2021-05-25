package com.avito.android.in_app_calls.service;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.calls.audio.AudioDevice;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.tracker.errors.CallIllegalMviStateException;
import com.avito.android.calls_shared.tracker.errors.CallIllegalStateException;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.di.PerService;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.binder.CallManagerServiceApi;
import com.avito.android.in_app_calls.service.binder.CallState;
import com.avito.android.in_app_calls.service.binder.CallStateListener;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.remote.CallInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\nUVWXYZ[,\\(BY\b\u0007\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010TJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0006J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0006J\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0006R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR:\u0010P\u001a&\u0012\f\u0012\n M*\u0004\u0018\u00010L0L M*\u0012\u0012\f\u0012\n M*\u0004\u0018\u00010L0L\u0018\u00010K0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006]"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;", "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate$State;", "", "destroy", "()V", "onCleared", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "request", Tracker.Events.CREATIVE_START, "(Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;)V", "", "", "getMissingPermissions", "()Ljava/util/List;", "answer", "decline", "hangup", "reason", "cancel", "(Ljava/lang/String;)V", "toggleMic", "Lcom/avito/android/in_app_calls/service/binder/CallStateListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCallStateListener", "(Lcom/avito/android/in_app_calls/service/binder/CallStateListener;)V", "onBind", "onUnbind", "r", "Lcom/avito/android/in_app_calls/service/binder/CallStateListener;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "z", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "Lcom/avito/android/Features;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/Features;", "features", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", VKApiConst.Q, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions3", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/server_time/TimeSource;", "u", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/in_app_calls/service/CallReconnectHandler;", VKApiConst.VERSION, "Lcom/avito/android/in_app_calls/service/CallReconnectHandler;", "reconnectHandler", "Lcom/avito/android/in_app_calls/service/CallInfoLoader;", "x", "Lcom/avito/android/in_app_calls/service/CallInfoLoader;", "callInfoLoader", "Lcom/avito/android/in_app_calls/CallManager;", "t", "Lcom/avito/android/in_app_calls/CallManager;", "callManager", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "B", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/calls/audio/CallAudioManager;", "y", "Lcom/avito/android/calls/audio/CallAudioManager;", "callAudioManager", "Lcom/avito/android/in_app_calls/service/CallInfoSender;", "w", "Lcom/avito/android/in_app_calls/service/CallInfoSender;", "callInfoSender", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "kotlin.jvm.PlatformType", "s", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "callWatchdogState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/in_app_calls/CallManager;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/in_app_calls/service/CallReconnectHandler;Lcom/avito/android/in_app_calls/service/CallInfoSender;Lcom/avito/android/in_app_calls/service/CallInfoLoader;Lcom/avito/android/calls/audio/CallAudioManager;Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;Lcom/avito/android/Features;Lcom/avito/android/communications_common/analytics/ErrorTracker;Lcom/avito/android/util/SchedulersFactory;)V", "i", "j", "k", "l", AuthSource.OPEN_CHANNEL_LIST, "n", "o", "State", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@PerService
public final class CallManagerServiceDelegate extends BaseMviEntityWithReducerQueue<State> implements CallManagerServiceApi {
    public final Features A;
    public final ErrorTracker B;
    public final CompositeDisposable p;
    public final io.reactivex.rxjava3.disposables.CompositeDisposable q;
    public volatile CallStateListener r;
    public final BehaviorRelay<Boolean> s = BehaviorRelay.create();
    public final CallManager t;
    public final TimeSource u;
    public final CallReconnectHandler v;
    public final CallInfoSender w;
    public final CallInfoLoader x;
    public final CallAudioManager y;
    public final CallEventTracker z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\u000f\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate$State;", "", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "component1", "()Lcom/avito/android/in_app_calls/service/binder/CallState;", "", "component2", "()Z", "Lcom/avito/android/calls/audio/AudioDevice;", "component3", "()Lcom/avito/android/calls/audio/AudioDevice;", "component4", "callState", "sendAudio", "audioDevice", "isUiBound", "copy", "(Lcom/avito/android/in_app_calls/service/binder/CallState;ZLcom/avito/android/calls/audio/AudioDevice;Z)Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/calls/audio/AudioDevice;", "getAudioDevice", AuthSource.BOOKING_ORDER, "Z", "getSendAudio", "d", AuthSource.SEND_ABUSE, "Lcom/avito/android/in_app_calls/service/binder/CallState;", "getCallState", "<init>", "(Lcom/avito/android/in_app_calls/service/binder/CallState;ZLcom/avito/android/calls/audio/AudioDevice;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final CallState a;
        public final boolean b;
        @NotNull
        public final AudioDevice c;
        public final boolean d;

        public State(@NotNull CallState callState, boolean z, @NotNull AudioDevice audioDevice, boolean z2) {
            Intrinsics.checkNotNullParameter(callState, "callState");
            Intrinsics.checkNotNullParameter(audioDevice, "audioDevice");
            this.a = callState;
            this.b = z;
            this.c = audioDevice;
            this.d = z2;
        }

        public static /* synthetic */ State copy$default(State state, CallState callState, boolean z, AudioDevice audioDevice, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                callState = state.a;
            }
            if ((i & 2) != 0) {
                z = state.b;
            }
            if ((i & 4) != 0) {
                audioDevice = state.c;
            }
            if ((i & 8) != 0) {
                z2 = state.d;
            }
            return state.copy(callState, z, audioDevice, z2);
        }

        @NotNull
        public final CallState component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final AudioDevice component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final State copy(@NotNull CallState callState, boolean z, @NotNull AudioDevice audioDevice, boolean z2) {
            Intrinsics.checkNotNullParameter(callState, "callState");
            Intrinsics.checkNotNullParameter(audioDevice, "audioDevice");
            return new State(callState, z, audioDevice, z2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && this.b == state.b && Intrinsics.areEqual(this.c, state.c) && this.d == state.d;
        }

        @NotNull
        public final AudioDevice getAudioDevice() {
            return this.c;
        }

        @NotNull
        public final CallState getCallState() {
            return this.a;
        }

        public final boolean getSendAudio() {
            return this.b;
        }

        public int hashCode() {
            CallState callState = this.a;
            int i = 0;
            int hashCode = (callState != null ? callState.hashCode() : 0) * 31;
            boolean z = this.b;
            int i2 = 1;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode + i3) * 31;
            AudioDevice audioDevice = this.c;
            if (audioDevice != null) {
                i = audioDevice.hashCode();
            }
            int i7 = (i6 + i) * 31;
            boolean z2 = this.d;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i7 + i2;
        }

        public final boolean isUiBound() {
            return this.d;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(callState=");
            L.append(this.a);
            L.append(", sendAudio=");
            L.append(this.b);
            L.append(", audioDevice=");
            L.append(this.c);
            L.append(", isUiBound=");
            return a2.b.a.a.a.B(L, this.d, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(CallState callState, boolean z, AudioDevice audioDevice, boolean z2, int i, t6.r.a.j jVar) {
            this(callState, (i & 2) != 0 ? true : z, (i & 4) != 0 ? AudioDevice.None.INSTANCE : audioDevice, (i & 8) != 0 ? false : z2);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<State, CallState> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final CallState apply(State state) {
            int i = this.a;
            if (i == 0) {
                State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "state");
                return state2.getCallState();
            } else if (i == 1) {
                State state3 = state;
                Intrinsics.checkNotNullParameter(state3, "state");
                return state3.getCallState();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Predicate<CallManager.State> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(CallManager.State state) {
            CallManager.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return state2.getInfo() == null;
        }
    }

    public static final class c<T> implements Consumer<CallManager.State> {
        public final /* synthetic */ CallManagerServiceDelegate a;

        public c(CallManagerServiceDelegate callManagerServiceDelegate) {
            this.a = callManagerServiceDelegate;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CallManager.State state) {
            CallManager.State state2 = state;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            CallManagerServiceDelegate callManagerServiceDelegate = this.a;
            Intrinsics.checkNotNullExpressionValue(state2, "state");
            reducerQueue.plusAssign(new n(callManagerServiceDelegate, state2));
        }
    }

    public static final class d<T> implements Consumer<State> {
        public final /* synthetic */ CallManagerServiceDelegate a;

        public d(CallManagerServiceDelegate callManagerServiceDelegate) {
            this.a = callManagerServiceDelegate;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(State state) {
            State state2 = state;
            if (state2.getCallState() instanceof CallState.Idle) {
                this.a.t.disconnectWhenIdle();
            }
            CallStateListener callStateListener = this.a.r;
            if (callStateListener != null) {
                callStateListener.onStateChanged(state2.getCallState(), state2.getSendAudio());
            }
        }
    }

    public static final class e<T> implements Consumer<String> {
        public final /* synthetic */ CallManagerServiceDelegate a;

        public e(CallManagerServiceDelegate callManagerServiceDelegate) {
            this.a = callManagerServiceDelegate;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            CallManagerServiceDelegate callManagerServiceDelegate = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "callId");
            reducerQueue.plusAssign(new o(callManagerServiceDelegate, str2));
        }
    }

    public static final class f<T> implements Consumer<CallInfo> {
        public final /* synthetic */ CallManagerServiceDelegate a;

        public f(CallManagerServiceDelegate callManagerServiceDelegate) {
            this.a = callManagerServiceDelegate;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CallInfo callInfo) {
            CallInfo callInfo2 = callInfo;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            CallManagerServiceDelegate callManagerServiceDelegate = this.a;
            Intrinsics.checkNotNullExpressionValue(callInfo2, "result");
            reducerQueue.plusAssign(new m(callManagerServiceDelegate, callInfo2));
        }
    }

    public static final class g<T> implements Consumer<AudioDevice> {
        public final /* synthetic */ CallManagerServiceDelegate a;

        public g(CallManagerServiceDelegate callManagerServiceDelegate) {
            this.a = callManagerServiceDelegate;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AudioDevice audioDevice) {
            AudioDevice audioDevice2 = audioDevice;
            ReducerQueue reducerQueue = this.a.getReducerQueue();
            CallManagerServiceDelegate callManagerServiceDelegate = this.a;
            Intrinsics.checkNotNullExpressionValue(audioDevice2, "audioDevice");
            reducerQueue.plusAssign(new k(callManagerServiceDelegate, audioDevice2));
        }
    }

    public static final class h<T, R> implements Function<State, CompletableSource> {
        public final /* synthetic */ CallManagerServiceDelegate a;
        public final /* synthetic */ SchedulersFactory b;

        public h(CallManagerServiceDelegate callManagerServiceDelegate, SchedulersFactory schedulersFactory) {
            this.a = callManagerServiceDelegate;
            this.b = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            if (!(state2.getCallState() instanceof CallState.Idle)) {
                return this.a.s.distinctUntilChanged().switchMapCompletable(new a2.a.a.f1.f.i(this));
            }
            this.a.s.accept(Boolean.FALSE);
            return Completable.complete();
        }
    }

    public final class i extends Mutator<State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public i(CallManagerServiceDelegate callManagerServiceDelegate) {
            super(null, null, 3, null);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            CallState callState;
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            StringBuilder sb = new StringBuilder();
            sb.append("Force stop call with callId=[");
            AppCallInfo call = state2.getCallState().getCall();
            Logs.debug$default(a2.b.a.a.a.s(sb, call != null ? call.getCallId() : null, ']'), null, 2, null);
            AppCallInfo call2 = state2.getCallState().getCall();
            if (call2 != null) {
                callState = new CallState.Idle.Finished(call2, AppCallResult.Error.ForceStopped.INSTANCE, null);
            } else {
                callState = CallState.Idle.None.INSTANCE;
            }
            return State.copy$default(state2, callState, false, null, false, 14, null);
        }
    }

    public final class k extends Mutator<State> {
        @NotNull
        public final AudioDevice d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(@NotNull CallManagerServiceDelegate callManagerServiceDelegate, AudioDevice audioDevice) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(audioDevice, "device");
            this.d = audioDevice;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            return State.copy$default(state2, null, false, this.d, false, 11, null);
        }
    }

    public final class l extends Mutator<State> {
        public final boolean d;

        public l(CallManagerServiceDelegate callManagerServiceDelegate, boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            boolean isUiBound = state2.isUiBound();
            boolean z = this.d;
            return isUiBound != z ? State.copy$default(state2, null, false, null, z, 7, null) : state2;
        }
    }

    public final class m extends Action<State> {
        @NotNull
        public final CallInfo d;
        public final /* synthetic */ CallManagerServiceDelegate e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(@NotNull CallManagerServiceDelegate callManagerServiceDelegate, CallInfo callInfo) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(callInfo, "info");
            this.e = callManagerServiceDelegate;
            this.d = callInfo;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Action
        public void invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "curState");
            AppCallInfo call = state2.getCallState().getCall();
            if (Intrinsics.areEqual(call != null ? call.getCallId() : null, this.d.getCallId())) {
                this.e.t.updateCallInfo(new CallManager.CallInfoUpdate(this.d.getCallId(), new CallerInfo(this.d.getCaller().getContact(), this.d.getCaller().getDisplayName(), this.d.getCaller().getImage()), new CallerInfo(this.d.getRecipient().getContact(), this.d.getRecipient().getDisplayName(), this.d.getRecipient().getImage()), new ItemInfo(this.d.getItem().getId(), this.d.getItem().getTitle(), this.d.getItem().getPrice(), this.d.getItem().getImage())));
            } else {
                ErrorTracker.DefaultImpls.track$default(this.e.B, new CallIllegalStateException("Info loaded, but not for that call"), null, null, 6, null);
            }
        }
    }

    public final class n extends Mutator<State> {
        public final CallManager.State d;
        public final /* synthetic */ CallManagerServiceDelegate e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(@NotNull CallManagerServiceDelegate callManagerServiceDelegate, CallManager.State state) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(state, "newState");
            this.e = callManagerServiceDelegate;
            this.d = state;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            CallState access$toCallState = CallManagerServiceDelegate.access$toCallState(this.e, this.d);
            if (Intrinsics.areEqual(state2.getCallState(), access$toCallState)) {
                return state2;
            }
            if (access$toCallState instanceof CallState.Ringing) {
                return State.copy$default(state2, access$toCallState, false, null, false, 14, null);
            }
            if (access$toCallState instanceof CallState.Dialing) {
                return State.copy$default(state2, access$toCallState, false, null, false, 14, null);
            }
            if (access$toCallState instanceof CallState.Connected) {
                if (!(state2.getCallState() instanceof CallState.Connected)) {
                    this.e.z.track(new CallEvent.Connected(((CallState.Connected) access$toCallState).getCall(), false));
                } else if (((CallState.Connected) state2.getCallState()).isReconnecting()) {
                    CallState.Connected connected = (CallState.Connected) access$toCallState;
                    if (!connected.isReconnecting()) {
                        this.e.z.track(new CallEvent.Connected(connected.getCall(), true));
                    }
                }
                return State.copy$default(state2, access$toCallState, false, null, false, 14, null);
            } else if (access$toCallState instanceof CallState.Idle.Finished) {
                CallState.Idle.Finished finished = (CallState.Idle.Finished) access$toCallState;
                AppCallInfo call = finished.getCall();
                if (!(state2.getCallState() instanceof CallState.Connected)) {
                    if (!(state2.getCallState() instanceof CallState.Idle)) {
                        this.e.z.track(new CallEvent.Disconnected(call, finished.getResult()));
                    }
                    return State.copy$default(state2, access$toCallState, false, null, false, 14, null);
                } else if (((CallState.Connected) state2.getCallState()).isReconnecting()) {
                    return state2;
                } else {
                    if (this.e.v.requestReconnect(call, finished.getResult(), finished.getReconnectUrl())) {
                        this.e.z.track(new CallEvent.Reconnecting(finished.getCall()));
                        return State.copy$default(state2, CallState.Connected.copy$default((CallState.Connected) state2.getCallState(), finished.getCall(), null, true, 2, null), false, null, false, 14, null);
                    }
                    if (!(state2.getCallState() instanceof CallState.Idle)) {
                        this.e.z.track(new CallEvent.Disconnected(call, finished.getResult()));
                    }
                    return State.copy$default(state2, access$toCallState, false, null, false, 14, null);
                }
            } else if (access$toCallState instanceof CallState.Idle.None) {
                AppCallInfo call2 = state2.getCallState().getCall();
                if (call2 != null && !(state2.getCallState() instanceof CallState.Idle)) {
                    this.e.z.track(new CallEvent.Disconnected(call2, AppCallResult.Error.InternalStateError.INSTANCE));
                }
                return State.copy$default(state2, access$toCallState, false, null, false, 14, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final class o extends Mutator<State> {
        @NotNull
        public final String d;
        public final /* synthetic */ CallManagerServiceDelegate e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(@NotNull CallManagerServiceDelegate callManagerServiceDelegate, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, "callId");
            this.e = callManagerServiceDelegate;
            this.d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            AppCallInfo call = state2.getCallState().getCall();
            if (!Intrinsics.areEqual(call != null ? call.getCallId() : null, this.d)) {
                ErrorTracker.DefaultImpls.track$default(this.e.B, new CallIllegalStateException("Invalid callId"), null, null, 6, null);
                return state2;
            }
            CallState callState = state2.getCallState();
            if (!(callState instanceof CallState.Connected)) {
                callState = null;
            }
            CallState.Connected connected = (CallState.Connected) callState;
            if (connected == null || !connected.isReconnecting()) {
                ErrorTracker.DefaultImpls.track$default(this.e.B, new CallIllegalMviStateException("Reconnect failed"), null, null, 6, null);
                return state2;
            }
            AppCallResult.Error.ReconnectFailed reconnectFailed = AppCallResult.Error.ReconnectFailed.INSTANCE;
            this.e.z.track(new CallEvent.Disconnected(connected.getCall(), reconnectFailed));
            return State.copy$default(state2, new CallState.Idle.Finished(connected.getCall(), reconnectFailed, null), false, null, false, 14, null);
        }
    }

    public final class p extends MutatorSingle<State> {
        public final CallManagerService.StartRequest d;
        public final /* synthetic */ CallManagerServiceDelegate e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(@NotNull CallManagerServiceDelegate callManagerServiceDelegate, CallManagerService.StartRequest startRequest) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(startRequest, "request");
            this.e = callManagerServiceDelegate;
            this.d = startRequest;
        }

        /* Return type fixed from 'io.reactivex.Single' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle
        public Single<State> invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            boolean z = state2.getCallState() instanceof CallState.Idle;
            CallManagerService.StartRequest startRequest = this.d;
            if (startRequest instanceof CallManagerService.StartRequest.Dial) {
                Single<State> fromCallable = Single.fromCallable(new u1(0, this, state2, z));
                Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …  }\n                    }");
                return fromCallable;
            } else if (startRequest instanceof CallManagerService.StartRequest.Receive) {
                Single<State> fromCallable2 = Single.fromCallable(new u1(1, this, state2, z));
                Intrinsics.checkNotNullExpressionValue(fromCallable2, "Single.fromCallable {\n  …  }\n                    }");
                return fromCallable2;
            } else if (startRequest instanceof CallManagerService.StartRequest.Reconnect) {
                Single<State> fromCallable3 = Single.fromCallable(new i1(0, this, state2));
                Intrinsics.checkNotNullExpressionValue(fromCallable3, "Single.fromCallable {\n  …  }\n                    }");
                return fromCallable3;
            } else if (startRequest instanceof CallManagerService.StartRequest.PendingAction) {
                Single<State> fromCallable4 = Single.fromCallable(new i1(1, this, state2));
                Intrinsics.checkNotNullExpressionValue(fromCallable4, "Single.fromCallable {\n  …ate\n                    }");
                return fromCallable4;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final class q extends Mutator<State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public q() {
            super(null, null, 3, null);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            boolean z = !state2.getSendAudio();
            CallManagerServiceDelegate.this.t.enableMic(z);
            return State.copy$default(state2, null, z, null, false, 13, null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CallManagerServiceDelegate(@NotNull CallManager callManager, @NotNull TimeSource timeSource, @NotNull CallReconnectHandler callReconnectHandler, @NotNull CallInfoSender callInfoSender, @NotNull CallInfoLoader callInfoLoader, @NotNull CallAudioManager callAudioManager, @NotNull CallEventTracker callEventTracker, @NotNull Features features, @NotNull ErrorTracker errorTracker, @NotNull SchedulersFactory schedulersFactory) {
        super(LogTagsKt.TAG_CALL_MANAGER_SERVICE, new State(CallState.Idle.None.INSTANCE, false, null, false, 14, null), schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(callManager, "callManager");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(callReconnectHandler, "reconnectHandler");
        Intrinsics.checkNotNullParameter(callInfoSender, "callInfoSender");
        Intrinsics.checkNotNullParameter(callInfoLoader, "callInfoLoader");
        Intrinsics.checkNotNullParameter(callAudioManager, "callAudioManager");
        Intrinsics.checkNotNullParameter(callEventTracker, "callEventTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.t = callManager;
        this.u = timeSource;
        this.v = callReconnectHandler;
        this.w = callInfoSender;
        this.x = callInfoLoader;
        this.y = callAudioManager;
        this.z = callEventTracker;
        this.A = features;
        this.B = errorTracker;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.p = compositeDisposable;
        io.reactivex.rxjava3.disposables.CompositeDisposable compositeDisposable2 = new io.reactivex.rxjava3.disposables.CompositeDisposable();
        this.q = compositeDisposable2;
        Disposable subscribe = callManager.getStateObservable().skipWhile(b.a).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "callManager.stateObserva…ator(state)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = getStateObservable().observeOn(getSchedulerForReducibles()).distinctUntilChanged().subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "stateObservable\n        ….sendAudio)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        Disposable subscribe3 = callReconnectHandler.getReconnectFailures().observeOn(getSchedulerForReducibles()).subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "reconnectHandler.reconne…ReconnectFailed(callId) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe3);
        Observable<Boolean> distinctUntilChanged = callManager.getStateObservable().observeOn(getSchedulers().computation()).map(a2.a.a.f1.f.j.a).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "callManager.stateObserva…  .distinctUntilChanged()");
        Observable<CallState> map = getStateObservable().map(a.b);
        Intrinsics.checkNotNullExpressionValue(map, "stateObservable.map { state -> state.callState }");
        DisposableKt.plusAssign(compositeDisposable, callReconnectHandler.processReconnectRequests(distinctUntilChanged, map));
        Disposable subscribe4 = InteropKt.toV2(callInfoLoader.getResultStream()).observeOn(getSchedulerForReducibles()).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "callInfoLoader.resultStr…nCallInfoLoaded(result) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe4);
        Observable map2 = getStateObservable().map(a.c);
        Intrinsics.checkNotNullExpressionValue(map2, "stateObservable.map { state -> state.callState }");
        Disposables.plusAssign(compositeDisposable2, callInfoLoader.processRequests(InteropKt.toV3(map2)));
        Disposable subscribe5 = callAudioManager.currentAudioDeviceChanges().observeOn(getSchedulerForReducibles()).startWith((Observable<AudioDevice>) callAudioManager.currentAudioDevice()).distinctUntilChanged().subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "callAudioManager.current…udioDevice)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe5);
        Disposable subscribe6 = getStateObservable().distinctUntilChanged().switchMapCompletable(new h(this, schedulersFactory)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe6, "stateObservable.distinct…            }.subscribe()");
        DisposableKt.plusAssign(compositeDisposable, subscribe6);
    }

    public static final CallState access$toCallState(CallManagerServiceDelegate callManagerServiceDelegate, CallManager.State state) {
        Objects.requireNonNull(callManagerServiceDelegate);
        if (state instanceof CallManager.State.Idle.None) {
            CallManager.State.Idle.None none = (CallManager.State.Idle.None) state;
            if (none.getCallRequest() != null) {
                return new CallState.Dialing(none.getCallRequest());
            }
            return CallState.Idle.None.INSTANCE;
        }
        String str = null;
        if (state instanceof CallManager.State.Idle.Finished) {
            CallManager.State.Idle.Finished finished = (CallManager.State.Idle.Finished) state;
            AppCallInfo info = finished.getInfo();
            AppCallResult result = finished.getResult();
            CallManager.CallSipInfo sipInfo = finished.getSipInfo();
            if (sipInfo != null) {
                str = sipInfo.getContent();
            }
            return new CallState.Idle.Finished(info, result, str);
        } else if (!(state instanceof CallManager.State.InCall)) {
            throw new NoWhenBranchMatchedException();
        } else if (state instanceof CallManager.State.InCall.Dialing) {
            return new CallState.Dialing(((CallManager.State.InCall) state).getInfo());
        } else {
            if (state instanceof CallManager.State.InCall.Ringing) {
                return new CallState.Ringing(((CallManager.State.InCall) state).getInfo());
            }
            if (state instanceof CallManager.State.InCall.Connected) {
                CallManager.State.InCall inCall = (CallManager.State.InCall) state;
                AppCallInfo info2 = inCall.getInfo();
                CallManager.CallSipInfo sipInfo2 = inCall.getSipInfo();
                if (sipInfo2 != null) {
                    str = sipInfo2.getContent();
                }
                return new CallState.Connected(info2, str, false, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void answer() {
        this.t.answerCall();
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void cancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        getReducerQueue().plusAssign(new j(this, str));
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void decline() {
        this.t.declineCall();
        this.s.accept(Boolean.TRUE);
    }

    public final void destroy() {
        this.t.disconnectWhenIdle();
        onCleared();
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    @NotNull
    public List<String> getMissingPermissions() {
        return CallManager.DefaultImpls.getMissingPermissions$default(this.t, false, 1, null);
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void hangup() {
        getReducerQueue().plusAssign(new j(this, null, 1));
    }

    public final void onBind() {
        getReducerQueue().plusAssign(new l(this, true));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        this.q.clear();
        super.onCleared();
    }

    public final void onUnbind() {
        getReducerQueue().plusAssign(new l(this, false));
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void setCallStateListener(@Nullable CallStateListener callStateListener) {
        if (callStateListener != null) {
            State state = (State) getStateBlocking();
            callStateListener.onStateChanged(state.getCallState(), state.getSendAudio());
            Unit unit = Unit.INSTANCE;
        } else {
            callStateListener = null;
        }
        this.r = callStateListener;
    }

    public final void start(@NotNull CallManagerService.StartRequest startRequest) {
        Intrinsics.checkNotNullParameter(startRequest, "request");
        getReducerQueue().plusAssign(new p(this, startRequest));
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void toggleMic() {
        getReducerQueue().plusAssign(new q());
    }

    public final class j extends Mutator<State> {
        public final String d;
        public final /* synthetic */ CallManagerServiceDelegate e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(CallManagerServiceDelegate callManagerServiceDelegate, String str, int i) {
            super(null, null, 3, null);
            String str2 = (i & 1) != 0 ? "" : null;
            Intrinsics.checkNotNullParameter(str2, "reason");
            this.e = callManagerServiceDelegate;
            this.d = str2;
        }

        public final void a() {
            this.e.t.hangupCall(this.d);
            this.e.s.accept(Boolean.TRUE);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.Mutator
        public State invoke(State state) {
            State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "oldState");
            CallState callState = state2.getCallState();
            if (callState instanceof CallState.Connected) {
                CallState.Connected connected = (CallState.Connected) callState;
                if (connected.isReconnecting()) {
                    return State.copy$default(state2, new CallState.Idle.Finished(connected.getCall(), AppCallResult.Hangup.HangupWhileReconnecting.INSTANCE, null), false, null, false, 14, null);
                }
                a();
                return state2;
            } else if (!(callState instanceof CallState.Idle) && !(callState instanceof CallState.Ringing) && !(callState instanceof CallState.Dialing)) {
                throw new NoWhenBranchMatchedException();
            } else {
                a();
                return state2;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(@NotNull CallManagerServiceDelegate callManagerServiceDelegate, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, "reason");
            this.e = callManagerServiceDelegate;
            this.d = str;
        }
    }
}
