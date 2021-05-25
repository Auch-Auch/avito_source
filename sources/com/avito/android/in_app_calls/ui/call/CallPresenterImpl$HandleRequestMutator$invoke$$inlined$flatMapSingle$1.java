package com.avito.android.in_app_calls.ui.call;

import com.avito.android.calls_shared.tracker.errors.CallIllegalMviStateException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import com.avito.android.in_app_calls.ui.call.CallPresenterImpl;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.util.Singles;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "", "it", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Unit;)Lio/reactivex/SingleSource;", "com/avito/android/util/Completables$flatMapSingle$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CallPresenterImpl$HandleRequestMutator$invoke$$inlined$flatMapSingle$1<T, R> implements Function<Unit, SingleSource<? extends T>> {
    public final /* synthetic */ CallPresenterImpl.HandleRequestMutator a;
    public final /* synthetic */ CallPresenter.State b;

    public CallPresenterImpl$HandleRequestMutator$invoke$$inlined$flatMapSingle$1(CallPresenterImpl.HandleRequestMutator handleRequestMutator, CallPresenter.State state) {
        this.a = handleRequestMutator;
        this.b = state;
    }

    public final SingleSource<? extends T> apply(@NotNull Unit unit) {
        Object obj;
        Intrinsics.checkNotNullParameter(unit, "it");
        CallPresenter.State state = this.b;
        if (!(state instanceof CallPresenter.State.Idle) && !(state instanceof CallPresenter.State.Finished)) {
            ErrorTracker.DefaultImpls.track$default(this.a.e.F, new CallIllegalMviStateException("Unhandled call request"), null, null, 6, null);
            obj = this.b;
        } else if (this.a.e.v != null) {
            CallActivityRequest callActivityRequest = this.a.d;
            if (callActivityRequest instanceof CallActivityRequest.Dial) {
                ReducerQueue reducerQueue = this.a.e.getReducerQueue();
                CallPresenterImpl.HandleRequestMutator handleRequestMutator = this.a;
                reducerQueue.plusAssign(new CallPresenterImpl.PerformDialMutator(handleRequestMutator.e, (CallActivityRequest.Dial) handleRequestMutator.d, true));
                obj = new CallPresenter.State.Idle(this.a.d, true);
            } else if (callActivityRequest instanceof CallActivityRequest.Receive.PendingAction) {
                ReducerQueue reducerQueue2 = this.a.e.getReducerQueue();
                CallPresenterImpl.HandleRequestMutator handleRequestMutator2 = this.a;
                reducerQueue2.plusAssign(new CallPresenterImpl.ProcessPendingAction(handleRequestMutator2.e, ((CallActivityRequest.Receive.PendingAction) handleRequestMutator2.d).getPendingAction()));
                obj = new CallPresenter.State.Idle(this.a.d, true);
            } else if (!(callActivityRequest instanceof CallActivityRequest.Open) && !(callActivityRequest instanceof CallActivityRequest.Receive.ReceiveCall)) {
                throw new NoWhenBranchMatchedException();
            } else {
                obj = new CallPresenter.State.Idle(this.a.d, true);
            }
        } else {
            obj = new CallPresenter.State.Idle(this.a.d, true);
        }
        return Singles.toSingle(obj);
    }
}
