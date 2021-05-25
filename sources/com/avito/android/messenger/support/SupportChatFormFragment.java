package com.avito.android.messenger.support;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.SupportChatFormOpenedEvent;
import com.avito.android.messenger.analytics.SupportChatFormSendClickedEvent;
import com.avito.android.messenger.support.SupportChatFormPresenter;
import com.avito.android.messenger.support.di.DaggerSupportChatFormComponent;
import com.avito.android.messenger.support.di.SupportChatFormComponent;
import com.avito.android.messenger.support.di.SupportChatFormDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b6\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "presenter", "Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "getPresenter", "()Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "setPresenter", "(Lcom/avito/android/messenger/support/SupportChatFormPresenter;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "", "c", "I", "problemId", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/messenger/support/SupportChatFormView;", "d", "Lcom/avito/android/messenger/support/SupportChatFormView;", "formView", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SupportChatFormFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "SupportChatFormFragment";
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public int c;
    public SupportChatFormView d;
    public final CompositeDisposable e = new CompositeDisposable();
    @Inject
    public SupportChatFormPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormFragment$Companion;", "", "", "problemId", "Lcom/avito/android/messenger/support/SupportChatFormFragment;", "create", "(I)Lcom/avito/android/messenger/support/SupportChatFormFragment;", "", "KEY_PROBLEM_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ int a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i) {
                super(1);
                this.a = i;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putInt("problemId", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final SupportChatFormFragment create(int i) {
            return (SupportChatFormFragment) FragmentsKt.arguments(new SupportChatFormFragment(), 1, new a(i));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<SupportChatFormPresenter.State> {
        public final /* synthetic */ SupportChatFormFragment a;

        public a(SupportChatFormFragment supportChatFormFragment) {
            this.a = supportChatFormFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SupportChatFormPresenter.State state) {
            String channelId;
            SupportChatFormPresenter.State state2 = state;
            SupportChatFormPresenter.SendingState sendingState = state2.getSendingState();
            if (!(sendingState instanceof SupportChatFormPresenter.SendingState.Success)) {
                sendingState = null;
            }
            SupportChatFormPresenter.SendingState.Success success = (SupportChatFormPresenter.SendingState.Success) sendingState;
            if (!(success == null || (channelId = success.getChannelId()) == null)) {
                Intent addFlags = MessengerIntentFactory.DefaultImpls.channelsIntent$default(this.a.getActivityIntentFactory(), null, 1, null).addFlags(603979776);
                Intrinsics.checkNotNullExpressionValue(addFlags, "activityIntentFactory\n  …FLAG_ACTIVITY_SINGLE_TOP)");
                Intent putExtra = MessengerIntentFactory.DefaultImpls.channelIntent$default(this.a.getActivityIntentFactory(), channelId, null, null, null, true, 14, null).putExtra(Constants.UP_INTENT, addFlags);
                if (putExtra != null) {
                    SupportChatFormFragment supportChatFormFragment = this.a;
                    Intrinsics.checkNotNullExpressionValue(putExtra, "intent");
                    FragmentsKt.startActivitySafely(supportChatFormFragment, putExtra);
                }
            }
            SupportChatFormView access$getFormView$p = SupportChatFormFragment.access$getFormView$p(this.a);
            Intrinsics.checkNotNullExpressionValue(state2, "state");
            access$getFormView$p.render(state2);
        }
    }

    public static final class b<T> implements Consumer<CharSequence> {
        public final /* synthetic */ SupportChatFormFragment a;

        public b(SupportChatFormFragment supportChatFormFragment) {
            this.a = supportChatFormFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            this.a.getAnalytics().track(SupportChatFormSendClickedEvent.INSTANCE);
            SupportChatFormPresenter presenter = this.a.getPresenter();
            Intrinsics.checkNotNullExpressionValue(charSequence2, "text");
            presenter.sendClicked(charSequence2);
        }
    }

    public static final /* synthetic */ SupportChatFormView access$getFormView$p(SupportChatFormFragment supportChatFormFragment) {
        SupportChatFormView supportChatFormView = supportChatFormFragment.d;
        if (supportChatFormView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formView");
        }
        return supportChatFormView;
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final SupportChatFormPresenter getPresenter() {
        SupportChatFormPresenter supportChatFormPresenter = this.presenter;
        if (supportChatFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return supportChatFormPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.messenger_support_chat_form, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SupportChatFormPresenter supportChatFormPresenter = this.presenter;
        if (supportChatFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        supportChatFormPresenter.getErrorStream().observe(getViewLifecycleOwner(), new Observer<T>(this) { // from class: com.avito.android.messenger.support.SupportChatFormFragment$onStart$$inlined$observeNotNull$1
            public final /* synthetic */ SupportChatFormFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    Context context = this.a.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t2, 0);
                    }
                }
            }
        });
        SupportChatFormPresenter supportChatFormPresenter2 = this.presenter;
        if (supportChatFormPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Disposable subscribe = InteropKt.toV3(supportChatFormPresenter2.getStateObservable()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "presenter.stateObservabl…nder(state)\n            }");
        DisposableKt.addTo(subscribe, this.e);
        SupportChatFormView supportChatFormView = this.d;
        if (supportChatFormView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formView");
        }
        Disposable subscribe2 = supportChatFormView.getSendStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "formView.sendStream\n    …icked(text)\n            }");
        DisposableKt.addTo(subscribe2, this.e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SupportChatFormPresenter supportChatFormPresenter = this.presenter;
        if (supportChatFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        supportChatFormPresenter.getErrorStream().removeObservers(this);
        this.e.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(SupportChatFormOpenedEvent.INSTANCE);
        }
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById);
        ActionBarUtils.INSTANCE.setActionBarTitle(FragmentsKt.getSupportActionBar(this), "");
        FragmentsKt.getSupportActionBar(this).setHomeAsUpIndicator(com.avito.android.ui_components.R.drawable.ic_close_24);
        this.d = new SupportChatFormViewImpl(view);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull SupportChatFormPresenter supportChatFormPresenter) {
        Intrinsics.checkNotNullParameter(supportChatFormPresenter, "<set-?>");
        this.presenter = supportChatFormPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        this.c = arguments != null ? arguments.getInt("problemId") : 0;
        SupportChatFormComponent.Builder problemId = DaggerSupportChatFormComponent.builder().problemId(this.c);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        problemId.resources(resources).fragment(this).dependencies((SupportChatFormDependencies) ComponentDependenciesKt.getDependencies(SupportChatFormDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return super.setUpFragmentComponent(bundle);
    }
}
