package com.avito.android.in_app_calls.ui.callReview;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.ui.callReview.CallReviewFragmentComponent;
import com.avito.android.in_app_calls.ui.callReview.CallReviewPresenter;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Views;
import com.facebook.internal.AnalyticsEvents;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b(\u0010\u0013J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewCustomAnswerView;", "d", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewCustomAnswerView;", "callReviewCustomAnswer", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswersView;", "c", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewAnswersView;", "callReviewAnswers", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "presenter", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "getPresenter", "()Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "setPresenter", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;)V", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "<init>", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallReviewFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public CallReviewAnswersView c;
    public CallReviewCustomAnswerView d;
    public final CompositeDisposable e = new CompositeDisposable();
    @Inject
    public CallReviewPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment$Companion;", "", "", "callId", "", "declinedCalls", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment;", "declineReasonReviewInstance", "(Ljava/lang/String;I)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment;", "cancelReasonReviewInstance", "(Ljava/lang/String;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragment;", "Landroid/os/Bundle;", "arg", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "parseArgument", "(Landroid/os/Bundle;)Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReview;", "KEY_CALL_ID", "Ljava/lang/String;", "KEY_DECLINED_CALLS", "KEY_REVIEW_TYPE", "TYPE_CANCEL_REASON", "TYPE_DECLINE_REASON", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CallReviewFragment cancelReasonReviewInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "callId");
            CallReviewFragment callReviewFragment = new CallReviewFragment();
            callReviewFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(AnalyticsEvents.PARAMETER_CALL_ID, str), TuplesKt.to("review_type", "cancelReason")));
            return callReviewFragment;
        }

        @NotNull
        public final CallReviewFragment declineReasonReviewInstance(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "callId");
            CallReviewFragment callReviewFragment = new CallReviewFragment();
            callReviewFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(AnalyticsEvents.PARAMETER_CALL_ID, str), TuplesKt.to("declined_calls", Integer.valueOf(i)), TuplesKt.to("review_type", "declineReason")));
            return callReviewFragment;
        }

        @NotNull
        public final CallReview parseArgument(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "arg");
            String string = bundle.getString(AnalyticsEvents.PARAMETER_CALL_ID);
            if (string != null) {
                String string2 = bundle.getString("review_type");
                if (string2 != null) {
                    int hashCode = string2.hashCode();
                    if (hashCode != -1862112930) {
                        if (hashCode == -1157345062 && string2.equals("declineReason")) {
                            return new CallReview.DeclineReasonReview(string, bundle.getInt("declined_calls"));
                        }
                    } else if (string2.equals("cancelReason")) {
                        return new CallReview.CancelReasonReview(string);
                    }
                    throw new IllegalArgumentException(a2.b.a.a.a.c3("Unknown type: ", string2));
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CallReviewPresenter.CallReviewAnswerType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a<T> implements Consumer<CallReviewPresenter.State> {
        public final /* synthetic */ CallReviewFragment a;

        public a(CallReviewFragment callReviewFragment) {
            this.a = callReviewFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CallReviewPresenter.State state) {
            CallReviewPresenter.State state2 = state;
            CallReviewFragment callReviewFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(state2, "state");
            CallReviewFragment.access$render(callReviewFragment, state2);
        }
    }

    public static final void access$render(CallReviewFragment callReviewFragment, CallReviewPresenter.State state) {
        Objects.requireNonNull(callReviewFragment);
        int ordinal = state.getType().ordinal();
        if (ordinal == 0) {
            CallReviewAnswersView callReviewAnswersView = callReviewFragment.c;
            if (callReviewAnswersView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewAnswers");
            }
            callReviewAnswersView.bind(state.getTitle(), state.getAnswers());
            CallReviewAnswersView callReviewAnswersView2 = callReviewFragment.c;
            if (callReviewAnswersView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewAnswers");
            }
            callReviewAnswersView2.setAnswerSelectedListener(new s4(0, callReviewFragment));
            CallReviewAnswersView callReviewAnswersView3 = callReviewFragment.c;
            if (callReviewAnswersView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewAnswers");
            }
            Views.show(callReviewAnswersView3);
        } else if (ordinal == 1) {
            CallReviewAnswersView callReviewAnswersView4 = callReviewFragment.c;
            if (callReviewAnswersView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewAnswers");
            }
            Views.conceal(callReviewAnswersView4);
            CallReviewCustomAnswerView callReviewCustomAnswerView = callReviewFragment.d;
            if (callReviewCustomAnswerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewCustomAnswer");
            }
            Views.show(callReviewCustomAnswerView);
            CallReviewCustomAnswerView callReviewCustomAnswerView2 = callReviewFragment.d;
            if (callReviewCustomAnswerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewCustomAnswer");
            }
            callReviewCustomAnswerView2.activate();
            CallReviewCustomAnswerView callReviewCustomAnswerView3 = callReviewFragment.d;
            if (callReviewCustomAnswerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callReviewCustomAnswer");
            }
            callReviewCustomAnswerView3.setSendClickListener(new s4(1, callReviewFragment));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final CallReviewPresenter getPresenter() {
        CallReviewPresenter callReviewPresenter = this.presenter;
        if (callReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return callReviewPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_call_review, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        CallReviewPresenter callReviewPresenter = this.presenter;
        if (callReviewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        callReviewPresenter.getFinishStream().observe(getViewLifecycleOwner(), new Observer<T>(this) { // from class: com.avito.android.in_app_calls.ui.callReview.CallReviewFragment$onStart$$inlined$observeNotNull$1
            public final /* synthetic */ CallReviewFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                FragmentActivity activity;
                if (t != null && (activity = this.a.getActivity()) != null) {
                    activity.finish();
                }
            }
        });
        CallReviewPresenter callReviewPresenter2 = this.presenter;
        if (callReviewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Disposable subscribe = callReviewPresenter2.getStateObservable().distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "presenter.stateObservabl…nder(state)\n            }");
        DisposableKt.addTo(subscribe, this.e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.e.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.call_review_answers);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.call_review_answers)");
        this.c = (CallReviewAnswersView) findViewById;
        View findViewById2 = view.findViewById(R.id.call_review_custom_answer);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.call_review_custom_answer)");
        this.d = (CallReviewCustomAnswerView) findViewById2;
    }

    public final void setPresenter(@NotNull CallReviewPresenter callReviewPresenter) {
        Intrinsics.checkNotNullParameter(callReviewPresenter, "<set-?>");
        this.presenter = callReviewPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Companion companion = Companion;
        Bundle arguments = getArguments();
        if (arguments != null) {
            CallReview parseArgument = companion.parseArgument(arguments);
            CallReviewFragmentComponent.Builder fragment = DaggerCallReviewFragmentComponent.builder().dependencies((CallReviewComponentDependencies) ComponentDependenciesKt.getDependencies(CallReviewComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).fragment(this);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            fragment.resources(resources).params(parseArgument).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
