package com.avito.android.messenger.conversation.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies;
import com.avito.android.messenger.conversation.create.di.DaggerCreateChannelFragmentComponent;
import com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivity;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bH\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J)\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\fR\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStart", "onStop", "onDestroyView", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createChannelParams", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "viewSubscriptions", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "presenter", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "getPresenter", "()Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "setPresenter", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;)V", "Lcom/avito/android/messenger/conversation/create/CreateChannelView;", "d", "Lcom/avito/android/messenger/conversation/create/CreateChannelView;", "createChannelView", "Lcom/avito/android/messenger/conversation/create/CreateChannelRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/create/CreateChannelRouter;", "router", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CreateChannelFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public ChannelActivityArguments.Create a;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public CreateChannelRouter b;
    public final CompositeDisposable c = new CompositeDisposable();
    public CreateChannelView d;
    @Inject
    public CreateChannelPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelFragment$Companion;", "", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "args", "Lcom/avito/android/messenger/conversation/create/CreateChannelFragment;", "createInstance", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)Lcom/avito/android/messenger/conversation/create/CreateChannelFragment;", "", "CREATE_CHANNEL_PARAMS", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CreateChannelFragment createInstance(@NotNull ChannelActivityArguments.Create create) {
            Intrinsics.checkNotNullParameter(create, "args");
            CreateChannelFragment createChannelFragment = new CreateChannelFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("create_channel_params", create);
            Unit unit = Unit.INSTANCE;
            createChannelFragment.setArguments(bundle);
            return createChannelFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ CreateChannelFragment a;

        public a(CreateChannelFragment createChannelFragment) {
            this.a = createChannelFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getPresenter().retry(CreateChannelFragment.access$getCreateChannelParams$p(this.a));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CreateChannelFragment a;

        public c(CreateChannelFragment createChannelFragment) {
            this.a = createChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CreateChannelRouter createChannelRouter = this.a.b;
            if (createChannelRouter != null) {
                createChannelRouter.close(0);
            }
        }
    }

    public static final /* synthetic */ ChannelActivityArguments.Create access$getCreateChannelParams$p(CreateChannelFragment createChannelFragment) {
        ChannelActivityArguments.Create create = createChannelFragment.a;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelParams");
        }
        return create;
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
    public final CreateChannelPresenter getPresenter() {
        CreateChannelPresenter createChannelPresenter = this.presenter;
        if (createChannelPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return createChannelPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = false;
        if (i == 1) {
            if (i2 == -1) {
                z = true;
            }
            CreateChannelPresenter createChannelPresenter = this.presenter;
            if (createChannelPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            createChannelPresenter.onAuthResult(z);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(1);
            }
        } else if (i == 2) {
            CreateChannelPresenter createChannelPresenter2 = this.presenter;
            if (createChannelPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            if (i2 == -1) {
                z = true;
            }
            createChannelPresenter2.onPhoneVerificationResult(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.avito.android.messenger.conversation.create.CreateChannelRouter");
        this.b = (CreateChannelRouter) parentFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        ChannelActivityArguments.Create create = arguments != null ? (ChannelActivityArguments.Create) arguments.getParcelable("create_channel_params") : null;
        if (create != null) {
            this.a = create;
            return;
        }
        throw new IllegalStateException(a2.b.a.a.a.E2(ChannelActivityArguments.Create.class, new StringBuilder(), " must be passed"));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.messenger_fragment_create_channel, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        CreateChannelView createChannelView = this.d;
        if (createChannelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelView");
        }
        createChannelView.destroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.b = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isChangingConfigurations()) {
            CreateChannelPresenter createChannelPresenter = this.presenter;
            if (createChannelPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            bundle.putParcelable("presenter", (Parcelable) createChannelPresenter.getStateBlocking());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        CreateChannelPresenter createChannelPresenter = this.presenter;
        if (createChannelPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        createChannelPresenter.getStartLoginScreenLiveData().observe(getViewLifecycleOwner(), new Observer<T>(this) { // from class: com.avito.android.messenger.conversation.create.CreateChannelFragment$onStart$$inlined$observe$1
            public final /* synthetic */ CreateChannelFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                CreateChannelFragment createChannelFragment = this.a;
                createChannelFragment.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(createChannelFragment.getActivityIntentFactory(), null, AuthSource.OPEN_CHANNEL, null, 5, null), 1);
            }
        });
        CreateChannelPresenter createChannelPresenter2 = this.presenter;
        if (createChannelPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        createChannelPresenter2.getStartPhoneVerificationLiveData().observe(getViewLifecycleOwner(), new Observer<T>(this) { // from class: com.avito.android.messenger.conversation.create.CreateChannelFragment$onStart$$inlined$observe$2
            public final /* synthetic */ CreateChannelFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                Context context = this.a.getContext();
                if (context != null) {
                    this.a.startActivityForResult(new Intent(context, MessengerPhoneVerificationActivity.class), 2);
                }
            }
        });
        CreateChannelView createChannelView = this.d;
        if (createChannelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelView");
        }
        Disposable subscribe = createChannelView.getRetryClicks().throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "createChannelView.retryC…ry(createChannelParams) }");
        DisposableKt.addTo(subscribe, this.c);
        CreateChannelPresenter createChannelPresenter3 = this.presenter;
        if (createChannelPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Observable observeOn = createChannelPresenter3.getStateObservable().observeOn(AndroidSchedulers.mainThread());
        CreateChannelView createChannelView2 = this.d;
        if (createChannelView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelView");
        }
        Disposable subscribe2 = observeOn.subscribe(new a2.a.a.o1.d.z.a(new Function1<CreateChannelPresenter.State, Unit>(createChannelView2) { // from class: com.avito.android.messenger.conversation.create.CreateChannelFragment.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CreateChannelPresenter.State state) {
                CreateChannelPresenter.State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "p1");
                ((CreateChannelView) this.receiver).render(state2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "presenter.stateObservabl…reateChannelView::render)");
        DisposableKt.addTo(subscribe2, this.c);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.c.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        CreateChannelPresenter.State state;
        Intrinsics.checkNotNullParameter(view, "view");
        if (bundle == null || (state = (CreateChannelPresenter.State) bundle.getParcelable("presenter")) == null) {
            state = CreateChannelPresenter.State.Empty.INSTANCE;
        }
        Intrinsics.checkNotNullExpressionValue(state, "savedInstanceState\n     …           ?: State.Empty");
        DaggerCreateChannelFragmentComponent.builder().createChannelFragmentDependencies((CreateChannelFragmentDependencies) ComponentDependenciesKt.getDependencies(CreateChannelFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).presenterState(state).fragment(this).build().inject(this);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new c(this));
        CreateChannelRouter createChannelRouter = this.b;
        Intrinsics.checkNotNull(createChannelRouter);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.d = new CreateChannelView(createChannelRouter, view, analytics2);
        if ((state instanceof CreateChannelPresenter.State.Empty) || (state instanceof CreateChannelPresenter.State.Waiting.CreateChannel)) {
            CreateChannelPresenter createChannelPresenter = this.presenter;
            if (createChannelPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            ChannelActivityArguments.Create create = this.a;
            if (create == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createChannelParams");
            }
            createChannelPresenter.createChannel(create);
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull CreateChannelPresenter createChannelPresenter) {
        Intrinsics.checkNotNullParameter(createChannelPresenter, "<set-?>");
        this.presenter = createChannelPresenter;
    }
}
