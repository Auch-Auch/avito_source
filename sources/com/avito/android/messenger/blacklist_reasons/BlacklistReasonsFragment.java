package com.avito.android.messenger.blacklist_reasons;

import a2.g.r.g;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.R;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView;
import com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponentDependencies;
import com.avito.android.messenger.blacklist_reasons.di.DaggerBlacklistReasonsComponent;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010+\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010\"R\"\u0010-\u001a\u00020,8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onDestroyView", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView;", "c", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView;", "contentView", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "presenter", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "getPresenter$messenger_release", "()Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "setPresenter$messenger_release", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;)V", "", "e", "Ljava/lang/String;", "channelId", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "viewSubscriptions", "f", "itemId", "d", ChannelContext.Item.USER_ID, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers$messenger_release", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers$messenger_release", "(Lcom/avito/android/util/SchedulersFactory;)V", "<init>", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistReasonsFragment extends BaseFragment {
    public BlacklistReasonsView c;
    public String d;
    public String e;
    public String f;
    public final CompositeDisposable g = new CompositeDisposable();
    @Inject
    public BlacklistReasonsPresenter presenter;
    @Inject
    public SchedulersFactory schedulers;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                FragmentActivity activity = ((BlacklistReasonsFragment) this.b).getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else if (i == 1) {
                ((BlacklistReasonsFragment) this.b).getPresenter$messenger_release().retry();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<BlacklistReasonsView.State> {
        public final /* synthetic */ BlacklistReasonsFragment a;

        public b(BlacklistReasonsFragment blacklistReasonsFragment) {
            this.a = blacklistReasonsFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BlacklistReasonsView.State state) {
            BlacklistReasonsView.State state2 = state;
            BlacklistReasonsView access$getContentView$p = BlacklistReasonsFragment.access$getContentView$p(this.a);
            Intrinsics.checkNotNullExpressionValue(state2, "state");
            access$getContentView$p.render(state2);
        }
    }

    public static final class c<T> implements Consumer<Long> {
        public final /* synthetic */ BlacklistReasonsFragment a;

        public c(BlacklistReasonsFragment blacklistReasonsFragment) {
            this.a = blacklistReasonsFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            Long l2 = l;
            BlacklistReasonsPresenter presenter$messenger_release = this.a.getPresenter$messenger_release();
            String access$getUserId$p = BlacklistReasonsFragment.access$getUserId$p(this.a);
            String access$getChannelId$p = BlacklistReasonsFragment.access$getChannelId$p(this.a);
            String str = this.a.f;
            Intrinsics.checkNotNullExpressionValue(l2, "reasonId");
            presenter$messenger_release.blockUserWithReason(access$getUserId$p, access$getChannelId$p, str, l2.longValue());
        }
    }

    public static final /* synthetic */ String access$getChannelId$p(BlacklistReasonsFragment blacklistReasonsFragment) {
        String str = blacklistReasonsFragment.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public static final /* synthetic */ BlacklistReasonsView access$getContentView$p(BlacklistReasonsFragment blacklistReasonsFragment) {
        BlacklistReasonsView blacklistReasonsView = blacklistReasonsFragment.c;
        if (blacklistReasonsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        return blacklistReasonsView;
    }

    public static final /* synthetic */ String access$getUserId$p(BlacklistReasonsFragment blacklistReasonsFragment) {
        String str = blacklistReasonsFragment.d;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ChannelContext.Item.USER_ID);
        }
        return str;
    }

    @NotNull
    public final BlacklistReasonsPresenter getPresenter$messenger_release() {
        BlacklistReasonsPresenter blacklistReasonsPresenter = this.presenter;
        if (blacklistReasonsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return blacklistReasonsPresenter;
    }

    @NotNull
    public final SchedulersFactory getSchedulers$messenger_release() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        String string2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("user_id")) == null) {
            throw new IllegalArgumentException("User id is required");
        }
        this.d = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("channel_id")) == null) {
            throw new IllegalArgumentException("Channel id is required");
        }
        this.e = string2;
        Bundle arguments3 = getArguments();
        this.f = arguments3 != null ? arguments3.getString("item_id") : null;
        DaggerBlacklistReasonsComponent.builder().dependencies((BlacklistReasonsComponentDependencies) ComponentDependenciesKt.getDependencies(BlacklistReasonsComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).fragment(this).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.messenger_blacklist_reasons_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BlacklistReasonsView blacklistReasonsView = this.c;
        if (blacklistReasonsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        blacklistReasonsView.destroyView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.g.clear();
        BlacklistReasonsPresenter blacklistReasonsPresenter = this.presenter;
        if (blacklistReasonsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        blacklistReasonsPresenter.getUserBlockedStream().removeObservers(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BlacklistReasonsPresenter blacklistReasonsPresenter = this.presenter;
        if (blacklistReasonsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        blacklistReasonsPresenter.getUserBlockedStream().observe(getViewLifecycleOwner(), new Observer<T>(this) { // from class: com.avito.android.messenger.blacklist_reasons.BlacklistReasonsFragment$onResume$$inlined$observeNotNull$1
            public final /* synthetic */ BlacklistReasonsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    FragmentActivity activity = this.a.getActivity();
                    if (activity != null) {
                        activity.setResult(-1);
                    }
                    FragmentActivity activity2 = this.a.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
            }
        });
        BlacklistReasonsPresenter blacklistReasonsPresenter2 = this.presenter;
        if (blacklistReasonsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Observable distinctUntilChanged = blacklistReasonsPresenter2.getStateObservable().distinctUntilChanged();
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe = distinctUntilChanged.observeOn(schedulersFactory.mainThread()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "presenter.stateObservabl…ntentView.render(state) }");
        DisposableKt.addTo(subscribe, this.g);
        BlacklistReasonsView blacklistReasonsView = this.c;
        if (blacklistReasonsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        Disposable subscribe2 = blacklistReasonsView.getBackNavigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "contentView.backNavigati…be { activity?.finish() }");
        DisposableKt.addTo(subscribe2, this.g);
        BlacklistReasonsView blacklistReasonsView2 = this.c;
        if (blacklistReasonsView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        Observable<Long> reasonSelections = blacklistReasonsView2.getReasonSelections();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        SchedulersFactory schedulersFactory2 = this.schedulers;
        if (schedulersFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe3 = reasonSelections.throttleFirst(200, timeUnit, schedulersFactory2.computation()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "contentView.reasonSelect…          )\n            }");
        DisposableKt.addTo(subscribe3, this.g);
        BlacklistReasonsView blacklistReasonsView3 = this.c;
        if (blacklistReasonsView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        Observable<Unit> retryClicks = blacklistReasonsView3.getRetryClicks();
        SchedulersFactory schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe4 = retryClicks.throttleFirst(200, timeUnit, schedulersFactory3.computation()).subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "contentView.retryClicks\n…ibe { presenter.retry() }");
        DisposableKt.addTo(subscribe4, this.g);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = new BlacklistReasonsViewImpl((ViewGroup) view);
        if (bundle == null) {
            BlacklistReasonsPresenter blacklistReasonsPresenter = this.presenter;
            if (blacklistReasonsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            blacklistReasonsPresenter.loadBlacklistReasons();
        }
    }

    public final void setPresenter$messenger_release(@NotNull BlacklistReasonsPresenter blacklistReasonsPresenter) {
        Intrinsics.checkNotNullParameter(blacklistReasonsPresenter, "<set-?>");
        this.presenter = blacklistReasonsPresenter;
    }

    public final void setSchedulers$messenger_release(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }
}
