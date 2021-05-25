package com.avito.android.in_app_calls.ui.callReview;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReviewAnalyticEventProvider;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003#$%B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "type", "", "onTypeChanged", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;)V", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "callReviewAnswer", "onAnswerSelected", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;)V", "Lcom/avito/android/analytics/Analytics;", VKApiConst.Q, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "r", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "callReview", "Landroidx/lifecycle/MutableLiveData;", "p", "Landroidx/lifecycle/MutableLiveData;", "getFinishStream", "()Landroidx/lifecycle/MutableLiveData;", "finishStream", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProvider;", "s", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProvider;", "analyticEventProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProvider;Lcom/avito/android/util/SchedulersFactory;)V", "AnswerSelectedAction", "ChangeTypeMutator", "InitializeMutator", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewPresenterImpl extends BaseMviEntityWithReducerQueue<CallReviewPresenter.State> implements CallReviewPresenter {
    @NotNull
    public final MutableLiveData<Unit> p = new SingleLiveEvent();
    public final Analytics q;
    public final CallReview r;
    public final CallReviewAnalyticEventProvider s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl$AnswerSelectedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;)V", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "d", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;", "answer", "<init>", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl;Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswer;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class AnswerSelectedAction extends Action<CallReviewPresenter.State> {
        public final CallReviewAnswer d;
        public final /* synthetic */ CallReviewPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnswerSelectedAction(@NotNull CallReviewPresenterImpl callReviewPresenterImpl, CallReviewAnswer callReviewAnswer) {
            super(null, "answerSelected = " + callReviewAnswer, 1, null);
            Intrinsics.checkNotNullParameter(callReviewAnswer, "answer");
            this.e = callReviewPresenterImpl;
            this.d = callReviewAnswer;
        }

        public void invoke(@NotNull CallReviewPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            Event provide = this.e.s.provide(this.e.r, this.d);
            if (provide != null) {
                this.e.q.track(provide);
            }
            this.e.getFinishStream().postValue(Unit.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl$ChangeTypeMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "d", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;", "type", "<init>", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl;Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$CallReviewAnswerType;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class ChangeTypeMutator extends Mutator<CallReviewPresenter.State> {
        public final CallReviewPresenter.CallReviewAnswerType d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChangeTypeMutator(@NotNull CallReviewPresenterImpl callReviewPresenterImpl, CallReviewPresenter.CallReviewAnswerType callReviewAnswerType) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(callReviewAnswerType, "type");
            this.d = callReviewAnswerType;
        }

        @NotNull
        public CallReviewPresenter.State invoke(@NotNull CallReviewPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return CallReviewPresenter.State.copy$default(state, this.d, 0, null, 6, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl$InitializeMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter$State;", "<init>", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public final class InitializeMutator extends Mutator<CallReviewPresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public InitializeMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public CallReviewPresenter.State invoke(@NotNull CallReviewPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            int title = CallReviewPresenterImpl.this.r.getTitle();
            List<CallReviewAnswer> answers = CallReviewPresenterImpl.this.r.getAnswers();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(answers, 10));
            for (T t : answers) {
                arrayList.add(new CallReviewItem(t.getVariant().getStrResource(), t));
            }
            return CallReviewPresenter.State.copy$default(state, null, title, arrayList, 1, null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CallReviewPresenterImpl(@NotNull Analytics analytics, @NotNull CallReview callReview, @NotNull CallReviewAnalyticEventProvider callReviewAnalyticEventProvider, @NotNull SchedulersFactory schedulersFactory) {
        super("CallReviewPresenter", CallReviewPresenter.State.Companion.getDEFAULT(), schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(callReview, "callReview");
        Intrinsics.checkNotNullParameter(callReviewAnalyticEventProvider, "analyticEventProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.q = analytics;
        this.r = callReview;
        this.s = callReviewAnalyticEventProvider;
        getReducerQueue().plusAssign(new InitializeMutator());
    }

    @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter
    public void onAnswerSelected(@NotNull CallReviewAnswer callReviewAnswer) {
        Intrinsics.checkNotNullParameter(callReviewAnswer, "callReviewAnswer");
        getReducerQueue().plusAssign(new AnswerSelectedAction(this, callReviewAnswer));
    }

    @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter
    public void onTypeChanged(@NotNull CallReviewPresenter.CallReviewAnswerType callReviewAnswerType) {
        Intrinsics.checkNotNullParameter(callReviewAnswerType, "type");
        getReducerQueue().plusAssign(new ChangeTypeMutator(this, callReviewAnswerType));
    }

    @Override // com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter
    @NotNull
    public MutableLiveData<Unit> getFinishStream() {
        return this.p;
    }
}
