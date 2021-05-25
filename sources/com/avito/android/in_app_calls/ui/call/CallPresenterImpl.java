package com.avito.android.in_app_calls.ui.call;

import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.analytics.events.InAppCallContacted;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.calls_shared.tracker.errors.CallIllegalMviStateException;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.analytics.AppCallRating;
import com.avito.android.in_app_calls.analytics.InAppCallFeedbackEvent;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.data.InAppCallPendingAction;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.binder.CallManagerServiceApi;
import com.avito.android.in_app_calls.service.binder.CallState;
import com.avito.android.in_app_calls.service.binder.CallStateListener;
import com.avito.android.in_app_calls.ui.CallInteractor;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.permissions.PermissionState;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0010rstuvwxyz{|}~\u0001Bq\b\u0007\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010i\u001a\u00020f\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010m\u001a\u00020j\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010o\u001a\u00020n¢\u0006\u0004\bp\u0010qJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u000bR\"\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00190\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010'R.\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000205040\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010c\u001a\b\u0012\u0004\u0012\u00020`0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\ba\u0010%\u001a\u0004\bb\u0010'R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006\u0001"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "Lcom/avito/android/in_app_calls/service/binder/CallStateListener;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "", "handleStartRequest", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "answer", "()V", "decline", "hangup", "toggleMic", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "callRating", "rateCall", "(Lcom/avito/android/in_app_calls/analytics/AppCallRating;)V", "Lcom/avito/android/permissions/PermissionState;", "state", "onPermissionGranted", "(Lcom/avito/android/permissions/PermissionState;)V", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "callState", "", "sendAudio", "onStateChanged", "(Lcom/avito/android/in_app_calls/service/binder/CallState;Z)V", "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", NotificationCompat.CATEGORY_SERVICE, "attachService", "(Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;)V", "detachService", "Landroidx/lifecycle/MutableLiveData;", "", "s", "Landroidx/lifecycle/MutableLiveData;", "getToastStream", "()Landroidx/lifecycle/MutableLiveData;", "toastStream", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "p", "getPermissionRequestStream", "permissionRequestStream", "Lcom/avito/android/Features;", "C", "Lcom/avito/android/Features;", "features", VKApiConst.Q, "getFinishWithDelayStream", "finishWithDelayStream", "Lkotlin/Pair;", "", "t", "getOpenDeclineReasonStream", "openDeclineReasonStream", "u", "getOpenCancelReasonStream", "openCancelReasonStream", "Lcom/avito/android/server_time/TimeSource;", "D", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/account/AccountStateProvider;", "G", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/permissions/PermissionChecker;", "H", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Landroid/content/res/Resources;", "x", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "callPermissionsManager", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "z", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "callAnalyticsTracker", "Lcom/avito/android/in_app_calls/ui/CallInteractor;", "w", "Lcom/avito/android/in_app_calls/ui/CallInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", "y", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "r", "getStartServiceStream", "startServiceStream", VKApiConst.VERSION, "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", "Lcom/avito/android/calls_shared/storage/CallStorage;", "B", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "F", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/in_app_calls/ui/CallInteractor;Landroid/content/res/Resources;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/calls/analytics/CallAnalyticsTracker;Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;Lcom/avito/android/calls_shared/storage/CallStorage;Lcom/avito/android/Features;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;Lcom/avito/android/communications_common/analytics/ErrorTracker;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/util/SchedulersFactory;)V", "AnswerAction", "AnswerClickedAction", "AttachService", "CancelAction", "DeclineClickedAction", "DetachService", "FinishAction", "HandleRequestMutator", "HangupAction", "OnCallStateChangedMutator", "OnPermissionsGrantedAction", "PerformDialMutator", "ProcessPendingAction", "RateCallAction", "StartCallMutator", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallPresenterImpl extends BaseMviEntityWithReducerQueue<CallPresenter.State> implements CallPresenter, CallStateListener {
    public final CallPermissionsManager A;
    public final CallStorage B;
    public final Features C;
    public final TimeSource D;
    public final CallEventTracker E;
    public final ErrorTracker F;
    public final AccountStateProvider G;
    public final PermissionChecker H;
    @NotNull
    public final MutableLiveData<CallPermissionsManager.PermissionRequest> p = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<Boolean> q = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<CallManagerService.StartRequest> r = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<String> s = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<Pair<String, Integer>> t = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<String> u = new SingleLiveEvent();
    public volatile CallManagerServiceApi v;
    public final CallInteractor w;
    public final Resources x;
    public final Analytics y;
    public final CallAnalyticsTracker z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$AnswerAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "", "d", "Z", "requestPermission", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class AnswerAction extends Action<CallPresenter.State> {
        public final boolean d;

        public AnswerAction(boolean z) {
            super(null, "requestPermission = " + z, 1, null);
            this.d = z;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallManagerServiceApi callManagerServiceApi = CallPresenterImpl.this.v;
            if (callManagerServiceApi != null) {
                List<String> missingPermissions = callManagerServiceApi.getMissingPermissions();
                if ((!missingPermissions.isEmpty()) && this.d) {
                    CallPresenterImpl.access$requestPermissions(CallPresenterImpl.this, missingPermissions, state.getCall());
                } else if (!missingPermissions.isEmpty()) {
                    callManagerServiceApi.cancel("missing permissions");
                } else {
                    CallEventTracker callEventTracker = CallPresenterImpl.this.E;
                    AppCallInfo call = state.getCall();
                    String callId = call != null ? call.getCallId() : null;
                    if (callId == null) {
                        callId = "";
                    }
                    callEventTracker.track(new CallEvent.PermissionChecked(callId, CallSide.INCOMING));
                    callManagerServiceApi.answer();
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$AnswerClickedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "", "d", "Z", "fromAppUi", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class AnswerClickedAction extends Action<CallPresenter.State> {
        public final boolean d;

        public AnswerClickedAction(boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallEventTracker callEventTracker = CallPresenterImpl.this.E;
            boolean z = this.d;
            AppCallInfo call = state.getCall();
            String callId = call != null ? call.getCallId() : null;
            if (callId == null) {
                callId = "";
            }
            callEventTracker.track(new CallEvent.GreenButtonClicked(z, callId));
            CallPresenterImpl.this.getReducerQueue().plusAssign(new AnswerAction(true));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$AttachService;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", "d", "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class AttachService extends Action<CallPresenter.State> {
        public final CallManagerServiceApi d;
        public final /* synthetic */ CallPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AttachService(@NotNull CallPresenterImpl callPresenterImpl, CallManagerServiceApi callManagerServiceApi) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(callManagerServiceApi, NotificationCompat.CATEGORY_SERVICE);
            this.e = callPresenterImpl;
            this.d = callManagerServiceApi;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            this.e.v = this.d;
            this.d.setCallStateListener(this.e);
            if (state instanceof CallPresenter.State.Idle) {
                CallPresenter.State.Idle idle = (CallPresenter.State.Idle) state;
                if (idle.getPendingRequest() != null) {
                    CallActivityRequest pendingRequest = idle.getPendingRequest();
                    if (pendingRequest instanceof CallActivityRequest.Dial) {
                        this.e.getReducerQueue().plusAssign(new PerformDialMutator(this.e, (CallActivityRequest.Dial) idle.getPendingRequest(), true));
                        Unit unit = Unit.INSTANCE;
                    } else if (pendingRequest instanceof CallActivityRequest.Receive.PendingAction) {
                        this.e.getReducerQueue().plusAssign(new ProcessPendingAction(this.e, ((CallActivityRequest.Receive.PendingAction) idle.getPendingRequest()).getPendingAction()));
                        Unit unit2 = Unit.INSTANCE;
                    } else if (!(pendingRequest instanceof CallActivityRequest.Receive.ReceiveCall) && !(pendingRequest instanceof CallActivityRequest.Open)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$CancelAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "", "d", "Ljava/lang/String;", "reason", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class CancelAction extends Action<CallPresenter.State> {
        public final String d;
        public final /* synthetic */ CallPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelAction(@NotNull CallPresenterImpl callPresenterImpl, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, "reason");
            this.e = callPresenterImpl;
            this.d = str;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallManagerServiceApi callManagerServiceApi = this.e.v;
            if (callManagerServiceApi != null) {
                callManagerServiceApi.cancel(this.d);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$DeclineClickedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "", "d", "Z", "fromAppUi", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class DeclineClickedAction extends Action<CallPresenter.State> {
        public final boolean d;

        public DeclineClickedAction(boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallPresenterImpl.this.E.track(new CallEvent.RedButtonClicked(state.getCall(), this.d));
            if (CallPresenterImpl.this.C.getMessengerAskDeclineReason().invoke().booleanValue()) {
                CallStorage callStorage = CallPresenterImpl.this.B;
                callStorage.setDeclinedCalls(callStorage.getDeclinedCalls() + 1);
            }
            CallManagerServiceApi callManagerServiceApi = CallPresenterImpl.this.v;
            if (callManagerServiceApi != null) {
                callManagerServiceApi.decline();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$DetachService;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class DetachService extends Action<CallPresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DetachService() {
            super(null, null, 3, null);
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallManagerServiceApi callManagerServiceApi = CallPresenterImpl.this.v;
            if (callManagerServiceApi != null) {
                callManagerServiceApi.setCallStateListener(CallPresenterImpl.this);
            }
            CallPresenterImpl.this.v = null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$FinishAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "", "d", "Z", "delayed", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class FinishAction extends Action<CallPresenter.State> {
        public final boolean d;

        public FinishAction(boolean z) {
            super(null, "delayed = " + z, 1, null);
            this.d = z;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallPresenterImpl.this.getFinishWithDelayStream().postValue(Boolean.valueOf(this.d));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$HandleRequestMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "d", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class HandleRequestMutator extends MutatorSingle<CallPresenter.State> {
        public final CallActivityRequest d;
        public final /* synthetic */ CallPresenterImpl e;

        public static final class a implements io.reactivex.functions.Action {
            public final /* synthetic */ HandleRequestMutator a;

            public a(HandleRequestMutator handleRequestMutator) {
                this.a = handleRequestMutator;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                if (this.a.d instanceof CallActivityRequest.Dial.ByPreviousCall) {
                    Analytics analytics = this.a.e.y;
                    ItemInfo item = this.a.d.getItem();
                    String itemId = item != null ? item.getItemId() : null;
                    if (itemId == null) {
                        itemId = "";
                    }
                    analytics.track(new InAppCallContacted(itemId, this.a.d.getCallUuid(), this.a.d.getScenario(), this.a.e.H.checkPermission("android.permission.RECORD_AUDIO"), this.a.e.G.getCurrentUserId(), null, 32, null));
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HandleRequestMutator(@NotNull CallPresenterImpl callPresenterImpl, CallActivityRequest callActivityRequest) {
            super(null, "request = " + callActivityRequest, 1, null);
            Intrinsics.checkNotNullParameter(callActivityRequest, "request");
            this.e = callPresenterImpl;
            this.d = callActivityRequest;
        }

        @NotNull
        public Single<CallPresenter.State> invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Completable fromAction = Completable.fromAction(new a(this));
            Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…          }\n            }");
            Single<CallPresenter.State> flatMap = fromAction.toSingleDefault(Unit.INSTANCE).flatMap(new CallPresenterImpl$HandleRequestMutator$invoke$$inlined$flatMapSingle$1(this, state));
            Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
            return flatMap;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$HangupAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class HangupAction extends Action<CallPresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public HangupAction() {
            super(null, null, 3, null);
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            CallPresenterImpl.this.E.track(new CallEvent.RedButtonClicked(state.getCall(), true));
            CallManagerServiceApi callManagerServiceApi = CallPresenterImpl.this.v;
            if (callManagerServiceApi != null) {
                callManagerServiceApi.hangup();
            }
            if (CallPresenterImpl.this.C.getCallsAskCancelReason().invoke().booleanValue() && (state instanceof CallPresenter.State.Dialing)) {
                CallStorage callStorage = CallPresenterImpl.this.B;
                callStorage.setCanceledCalls(callStorage.getCanceledCalls() + 1);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$OnCallStateChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "", "e", "Z", "sendAudio", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "d", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "callState", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/service/binder/CallState;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnCallStateChangedMutator extends Mutator<CallPresenter.State> {
        public final CallState d;
        public final boolean e;
        public final /* synthetic */ CallPresenterImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnCallStateChangedMutator(@NotNull CallPresenterImpl callPresenterImpl, CallState callState, boolean z) {
            super(null, "callState = " + callState + ", sendAudio = " + z, 1, null);
            Intrinsics.checkNotNullParameter(callState, "callState");
            this.f = callPresenterImpl;
            this.d = callState;
            this.e = z;
        }

        @NotNull
        public CallPresenter.State invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            CallState callState = this.d;
            String str = null;
            boolean z = false;
            if (callState instanceof CallState.Idle.None) {
                if (!(state instanceof CallPresenter.State.Idle) || ((CallPresenter.State.Idle) state).getPendingRequest() != null) {
                    return state;
                }
                this.f.getReducerQueue().plusAssign(new FinishAction(false));
                return new CallPresenter.State.Idle(null, this.e, 1, null);
            } else if (callState instanceof CallState.Idle.Finished) {
                AppCallInfo call = ((CallState.Idle.Finished) callState).getCall();
                if (state instanceof CallPresenter.State.Idle) {
                    CallActivityRequest pendingRequest = ((CallPresenter.State.Idle) state).getPendingRequest();
                    boolean z2 = pendingRequest instanceof CallActivityRequest.Dial.ByPreviousCall;
                    if (pendingRequest != null) {
                        str = pendingRequest.getCallUuid();
                    }
                    if (!Intrinsics.areEqual(str, call.getCallId()) || z2) {
                        return state;
                    }
                    this.f.getReducerQueue().plusAssign(new FinishAction(true));
                    return new CallPresenter.State.Finished.Completely(call, this.e, ((CallState.Idle.Finished) this.d).getResult());
                }
                CallState.Idle.Finished finished = (CallState.Idle.Finished) this.d;
                if ((finished.getResult() instanceof AppCallResult.Hangup.HangupCallerEarly) && CollectionsKt__CollectionsKt.listOf(new Integer[]{1, 3, 7}).contains(Integer.valueOf(this.f.B.getCanceledCalls())) && this.f.C.getCallsAskCancelReason().invoke().booleanValue() && this.f.D.now() - finished.getCall().getStartTimestamp() <= CallPresenterKt.MIN_CALL_DURATION_FOR_CANCEL_REASON_MS) {
                    this.f.getOpenCancelReasonStream().postValue(call.getCallId());
                    return state;
                }
                CallState.Idle.Finished finished2 = (CallState.Idle.Finished) this.d;
                if ((finished2.getResult() instanceof AppCallResult.Declined) && this.f.C.getMessengerAskDeclineReason().invoke().booleanValue() && CollectionsKt__CollectionsKt.listOf(new Integer[]{1, 3, 7}).contains(Integer.valueOf(this.f.B.getDeclinedCalls())) && finished2.getCall().isIncoming()) {
                    this.f.getOpenDeclineReasonStream().postValue(new Pair<>(call.getCallId(), Integer.valueOf(this.f.B.getDeclinedCalls())));
                    return state;
                }
                CallState.Idle.Finished finished3 = (CallState.Idle.Finished) this.d;
                if (!(!(finished3.getResult() instanceof AppCallResult.Hangup) || finished3.getCall().getEndTimestamp() == null || finished3.getCall().getConnectTimestamp() == null)) {
                    Long endTimestamp = finished3.getCall().getEndTimestamp();
                    Intrinsics.checkNotNull(endTimestamp);
                    long longValue = endTimestamp.longValue();
                    Long connectTimestamp = finished3.getCall().getConnectTimestamp();
                    Intrinsics.checkNotNull(connectTimestamp);
                    if (longValue - connectTimestamp.longValue() >= 1000) {
                        z = true;
                    }
                }
                if (z) {
                    return new CallPresenter.State.Finished.WaitingForRating(call, ((CallState.Idle.Finished) this.d).getResult());
                }
                this.f.getReducerQueue().plusAssign(new FinishAction(true));
                return new CallPresenter.State.Finished.Completely(call, this.e, ((CallState.Idle.Finished) this.d).getResult());
            } else if (callState instanceof CallState.Ringing) {
                return new CallPresenter.State.Ringing(((CallState.Ringing) callState).getCall());
            } else {
                if (callState instanceof CallState.Dialing) {
                    return new CallPresenter.State.Dialing(((CallState.Dialing) callState).getCall(), this.e);
                }
                if (callState instanceof CallState.Connected) {
                    return new CallPresenter.State.Connected(((CallState.Connected) callState).getCall(), this.e, ((CallState.Connected) this.d).isReconnecting());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$OnPermissionsGrantedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "Lcom/avito/android/permissions/PermissionState;", "d", "Lcom/avito/android/permissions/PermissionState;", "permissionState", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/permissions/PermissionState;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class OnPermissionsGrantedAction extends Action<CallPresenter.State> {
        public final PermissionState d;
        public final /* synthetic */ CallPresenterImpl e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                PermissionState.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 3;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnPermissionsGrantedAction(@NotNull CallPresenterImpl callPresenterImpl, PermissionState permissionState) {
            super(null, "permissionState = " + permissionState, 1, null);
            Intrinsics.checkNotNullParameter(permissionState, "permissionState");
            this.e = callPresenterImpl;
            this.d = permissionState;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (this.e.C.getCallsCanCallv4().invoke().booleanValue() && this.d != PermissionState.GRANTED) {
                this.e.A.updatePermissionState("android.permission.RECORD_AUDIO", this.d);
            }
            CallEventTracker callEventTracker = this.e.E;
            boolean z = this.d == PermissionState.GRANTED;
            String callId = state.getCallId();
            if (callId == null) {
                callId = "";
            }
            CallSide callSide = state.getCallSide();
            if (callSide == null) {
                callSide = CallSide.OUTGOING;
            }
            callEventTracker.track(new CallEvent.MicPermissionResult(callId, callSide, z, state.getCall()));
            int ordinal = this.d.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2) {
                    if (state instanceof CallPresenter.State.Ringing) {
                        this.e.getToastStream().postValue(this.e.x.getString(R.string.calls_mic_permission_to_answer_required));
                    } else if ((state instanceof CallPresenter.State.Idle) && ((CallPresenter.State.Idle) state).getPendingRequest() != null) {
                        this.e.getToastStream().postValue(this.e.x.getString(R.string.calls_mic_permission_to_make_call_required));
                    }
                    this.e.getReducerQueue().plusAssign(new CancelAction(this.e, "permission denied"));
                    this.e.getReducerQueue().plusAssign(new FinishAction(false));
                }
            } else if (state instanceof CallPresenter.State.Idle) {
                CallActivityRequest pendingRequest = ((CallPresenter.State.Idle) state).getPendingRequest();
                if (!(pendingRequest instanceof CallActivityRequest.Dial)) {
                    pendingRequest = null;
                }
                CallActivityRequest.Dial dial = (CallActivityRequest.Dial) pendingRequest;
                if (dial != null) {
                    this.e.getReducerQueue().plusAssign(new PerformDialMutator(this.e, dial, false));
                } else {
                    ErrorTracker.DefaultImpls.track$default(this.e.F, new CallIllegalMviStateException("Can't start call, request is null"), null, null, 6, null);
                }
            } else {
                AppCallInfo call = state.getCall();
                if (call == null) {
                    ErrorTracker.DefaultImpls.track$default(this.e.F, new CallIllegalMviStateException("Can't answer, call is null"), null, null, 6, null);
                    this.e.getReducerQueue().plusAssign(new CancelAction(this.e, "invalid state"));
                    this.e.getFinishWithDelayStream().postValue(Boolean.FALSE);
                } else if (call.isIncoming()) {
                    this.e.getReducerQueue().plusAssign(new AnswerAction(false));
                }
            }
            this.e.z.trackPermissionState(this.d.toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$PerformDialMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "d", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "dialRequest", "", "e", "Z", "requestPermissions", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class PerformDialMutator extends Mutator<CallPresenter.State> {
        public final CallActivityRequest.Dial d;
        public final boolean e;
        public final /* synthetic */ CallPresenterImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PerformDialMutator(@NotNull CallPresenterImpl callPresenterImpl, CallActivityRequest.Dial dial, boolean z) {
            super(null, "dialRequest = " + dial + ", requestPermissions = " + z, 1, null);
            Intrinsics.checkNotNullParameter(dial, "dialRequest");
            this.f = callPresenterImpl;
            this.d = dial;
            this.e = z;
        }

        @NotNull
        public CallPresenter.State invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            CallManagerServiceApi callManagerServiceApi = this.f.v;
            if (callManagerServiceApi != null) {
                if (!(state instanceof CallPresenter.State.Idle) && !(state instanceof CallPresenter.State.Finished)) {
                    ErrorTracker.DefaultImpls.track$default(this.f.F, new CallIllegalMviStateException("Can't start call"), null, null, 6, null);
                } else {
                    List<String> missingPermissions = callManagerServiceApi.getMissingPermissions();
                    if ((!missingPermissions.isEmpty()) && this.e) {
                        CallPresenterImpl.access$requestPermissions(this.f, missingPermissions, state.getCall());
                        return state;
                    } else if (!missingPermissions.isEmpty()) {
                        this.f.getReducerQueue().plusAssign(new FinishAction(false));
                        return state;
                    } else {
                        this.f.E.track(new CallEvent.PermissionChecked(this.d.getCallUuid(), CallSide.OUTGOING));
                        this.f.getReducerQueue().plusAssign(new StartCallMutator(this.f, this.d));
                        return new CallPresenter.State.Idle(this.d, state.getSendAudio());
                    }
                }
            }
            return state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$ProcessPendingAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "d", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "pendingAction", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class ProcessPendingAction extends Action<CallPresenter.State> {
        public final InAppCallPendingAction d;
        public final /* synthetic */ CallPresenterImpl e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                InAppCallPendingAction.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[0] = 1;
                iArr[1] = 2;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProcessPendingAction(@NotNull CallPresenterImpl callPresenterImpl, InAppCallPendingAction inAppCallPendingAction) {
            super(null, "action = " + inAppCallPendingAction, 1, null);
            Intrinsics.checkNotNullParameter(inAppCallPendingAction, "pendingAction");
            this.e = callPresenterImpl;
            this.d = inAppCallPendingAction;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            int ordinal = this.d.ordinal();
            if (ordinal == 0) {
                this.e.getReducerQueue().plusAssign(new AnswerClickedAction(false));
                Unit unit = Unit.INSTANCE;
            } else if (ordinal == 1) {
                this.e.getReducerQueue().plusAssign(new DeclineClickedAction(false));
                Unit unit2 = Unit.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$RateCallAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "d", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "callRating", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/analytics/AppCallRating;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class RateCallAction extends Action<CallPresenter.State> {
        public final AppCallRating d;
        public final /* synthetic */ CallPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RateCallAction(@NotNull CallPresenterImpl callPresenterImpl, AppCallRating appCallRating) {
            super(null, "callRating = " + appCallRating, 1, null);
            Intrinsics.checkNotNullParameter(appCallRating, "callRating");
            this.e = callPresenterImpl;
            this.d = appCallRating;
        }

        public void invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state instanceof CallPresenter.State.Finished.WaitingForRating) {
                AppCallInfo call = ((CallPresenter.State.Finished.WaitingForRating) state).getCall();
                if (call != null) {
                    Analytics analytics = this.e.y;
                    String callId = call.getCallId();
                    boolean isIncoming = call.isIncoming();
                    AppCallRating appCallRating = this.d;
                    ItemInfo item = call.getItem();
                    analytics.track(new InAppCallFeedbackEvent(callId, isIncoming, appCallRating, item != null ? item.getItemId() : null));
                    this.e.getReducerQueue().plusAssign(new FinishAction(false));
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl$StartCallMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "d", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "dialRequest", "<init>", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class StartCallMutator extends MutatorSingle<CallPresenter.State> {
        public final CallActivityRequest.Dial d;
        public final /* synthetic */ CallPresenterImpl e;

        public static final class a<T, R> implements Function<Option<? extends CallManagerService.StartRequest.Dial>, CallPresenter.State> {
            public final /* synthetic */ StartCallMutator a;
            public final /* synthetic */ CallPresenter.State b;

            public a(StartCallMutator startCallMutator, CallPresenter.State state) {
                this.a = startCallMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public CallPresenter.State apply(Option<? extends CallManagerService.StartRequest.Dial> option) {
                Option<? extends CallManagerService.StartRequest.Dial> option2 = option;
                Intrinsics.checkNotNullParameter(option2, "startRequestOption");
                boolean z = false;
                if (option2 instanceof None) {
                    this.a.e.getReducerQueue().plusAssign(new FinishAction(true));
                    CallAnalyticsTracker callAnalyticsTracker = this.a.e.z;
                    AppCallInfo asCallInfo = CallPresenterKt.asCallInfo(this.a.d);
                    if (asCallInfo != null) {
                        z = asCallInfo.isIncoming();
                    }
                    callAnalyticsTracker.trackCallEnded(z, "CantPrepareCall");
                    return new CallPresenter.State.Finished.Completely(CallPresenterKt.asCallInfo(this.a.d), this.b.getSendAudio(), AppCallResult.Error.CantPrepareCall.INSTANCE);
                } else if (option2 instanceof Some) {
                    CallManagerService.StartRequest.Dial dial = (CallManagerService.StartRequest.Dial) ((Some) option2).getT();
                    this.a.e.E.track(new CallEvent.Registered(this.a.d.getCallUuid()));
                    this.a.e.getStartServiceStream().postValue(dial);
                    return CallPresenter.State.Idle.copy$default((CallPresenter.State.Idle) this.b, new CallActivityRequest.Dial.NewCall(dial.getCallUuid(), dial.getRecipient(), dial.getItem(), dial.getScenario(), dial.getCallAs()), false, 2, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartCallMutator(@NotNull CallPresenterImpl callPresenterImpl, CallActivityRequest.Dial dial) {
            super(null, "dialRequest = " + dial, 1, null);
            Intrinsics.checkNotNullParameter(dial, "dialRequest");
            this.e = callPresenterImpl;
            this.d = dial;
        }

        @NotNull
        public Single<CallPresenter.State> invoke(@NotNull CallPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof CallPresenter.State.Idle) {
                Single<CallPresenter.State> map = InteropKt.toV2(this.e.w.startCallByRequest(this.d)).map(new a(this, state));
                Intrinsics.checkNotNullExpressionValue(map, "interactor.startCallByRe…                        }");
                return map;
            }
            Single<CallPresenter.State> just = Single.just(state);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(oldState)");
            return just;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CallPresenterImpl(@NotNull CallInteractor callInteractor, @NotNull Resources resources, @NotNull Analytics analytics, @NotNull CallAnalyticsTracker callAnalyticsTracker, @NotNull CallPermissionsManager callPermissionsManager, @NotNull CallStorage callStorage, @NotNull Features features, @NotNull TimeSource timeSource, @NotNull CallEventTracker callEventTracker, @NotNull ErrorTracker errorTracker, @NotNull AccountStateProvider accountStateProvider, @NotNull PermissionChecker permissionChecker, @NotNull SchedulersFactory schedulersFactory) {
        super(LogTagsKt.TAG_CALL_PRESENTER, new CallPresenter.State.Idle(null, true, 1, null), schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(callInteractor, "interactor");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(callAnalyticsTracker, "callAnalyticsTracker");
        Intrinsics.checkNotNullParameter(callPermissionsManager, "callPermissionsManager");
        Intrinsics.checkNotNullParameter(callStorage, "callStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(callEventTracker, "callEventTracker");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.w = callInteractor;
        this.x = resources;
        this.y = analytics;
        this.z = callAnalyticsTracker;
        this.A = callPermissionsManager;
        this.B = callStorage;
        this.C = features;
        this.D = timeSource;
        this.E = callEventTracker;
        this.F = errorTracker;
        this.G = accountStateProvider;
        this.H = permissionChecker;
    }

    public static final void access$requestPermissions(CallPresenterImpl callPresenterImpl, List list, AppCallInfo appCallInfo) {
        callPresenterImpl.getPermissionRequestStream().postValue(callPresenterImpl.A.createPermissionsRequest(list, appCallInfo));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void answer() {
        getReducerQueue().plusAssign(new AnswerClickedAction(true));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void attachService(@NotNull CallManagerServiceApi callManagerServiceApi) {
        Intrinsics.checkNotNullParameter(callManagerServiceApi, NotificationCompat.CATEGORY_SERVICE);
        getReducerQueue().plusAssign(new AttachService(this, callManagerServiceApi));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void decline() {
        getReducerQueue().plusAssign(new DeclineClickedAction(true));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void detachService() {
        getReducerQueue().plusAssign(new DetachService());
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void handleStartRequest(@NotNull CallActivityRequest callActivityRequest) {
        Intrinsics.checkNotNullParameter(callActivityRequest, "request");
        getReducerQueue().plusAssign(new HandleRequestMutator(this, callActivityRequest));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void hangup() {
        getReducerQueue().plusAssign(new HangupAction());
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void onPermissionGranted(@NotNull PermissionState permissionState) {
        Intrinsics.checkNotNullParameter(permissionState, "state");
        getReducerQueue().plusAssign(new OnPermissionsGrantedAction(this, permissionState));
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallStateListener
    public void onStateChanged(@NotNull CallState callState, boolean z2) {
        Intrinsics.checkNotNullParameter(callState, "callState");
        getReducerQueue().plusAssign(new OnCallStateChangedMutator(this, callState, z2));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void rateCall(@NotNull AppCallRating appCallRating) {
        Intrinsics.checkNotNullParameter(appCallRating, "callRating");
        getReducerQueue().plusAssign(new RateCallAction(this, appCallRating));
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    public void toggleMic() {
        CallManagerServiceApi callManagerServiceApi = this.v;
        if (callManagerServiceApi != null) {
            callManagerServiceApi.toggleMic();
        }
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    @NotNull
    public MutableLiveData<Boolean> getFinishWithDelayStream() {
        return this.q;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    @NotNull
    public MutableLiveData<String> getOpenCancelReasonStream() {
        return this.u;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    @NotNull
    public MutableLiveData<Pair<String, Integer>> getOpenDeclineReasonStream() {
        return this.t;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    @NotNull
    public MutableLiveData<CallPermissionsManager.PermissionRequest> getPermissionRequestStream() {
        return this.p;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    @NotNull
    public MutableLiveData<CallManagerService.StartRequest> getStartServiceStream() {
        return this.r;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallPresenter
    @NotNull
    public MutableLiveData<String> getToastStream() {
        return this.s;
    }
}
