package com.avito.android.messenger.blacklist.mvi;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.R;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.blacklist.mvi.BlacklistViewImpl;
import com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponent;
import com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies;
import com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentModule;
import com.avito.android.messenger.blacklist.mvi.di.DaggerBlacklistFragmentComponent;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Differ;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererWithDiff;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bI\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0017R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDetach", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistView;", "c", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistView;", "blacklistView", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "blacklistPresenter", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "getBlacklistPresenter", "()Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "setBlacklistPresenter", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;)V", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistRouter;", "d", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistRouter;", "router", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    @BlacklistFragmentModule.Blacklist
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public BlacklistPresenter blacklistPresenter;
    public BlacklistView c;
    public BlacklistRouter d;
    public final CompositeDisposable e = new CompositeDisposable();
    @Inject
    @BlacklistFragmentModule.Blacklist
    public ItemBinder itemBinder;
    @Inject
    public SchedulersFactory schedulers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistFragment$Companion;", "", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistFragment;", "newInstance", "()Lcom/avito/android/messenger/blacklist/mvi/BlacklistFragment;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final BlacklistFragment newInstance() {
            return new BlacklistFragment();
        }

        public Companion(j jVar) {
        }
    }

    public static final /* synthetic */ BlacklistView access$getBlacklistView$p(BlacklistFragment blacklistFragment) {
        BlacklistView blacklistView = blacklistFragment.c;
        if (blacklistView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistView");
        }
        return blacklistView;
    }

    @JvmStatic
    @NotNull
    public static final BlacklistFragment newInstance() {
        return Companion.newInstance();
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
    public final BlacklistPresenter getBlacklistPresenter() {
        BlacklistPresenter blacklistPresenter2 = this.blacklistPresenter;
        if (blacklistPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistPresenter");
        }
        return blacklistPresenter2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof BlacklistRouter)) {
            context = null;
        }
        this.d = (BlacklistRouter) context;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.messenger_blacklist_new, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById);
        ActionBarUtils.INSTANCE.setActionBarTitle(FragmentsKt.getSupportActionBar(this), getString(R.string.messenger_blacklist));
        FragmentsKt.getSupportActionBar(this).setHomeAsUpIndicator(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        return inflate;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.d = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Observable stateObservable = getBlacklistPresenter().getStateObservable();
        BlacklistView access$getBlacklistView$p = access$getBlacklistView$p(this);
        BlacklistViewImpl.ListDiffer listDiffer = BlacklistViewImpl.ListDiffer.INSTANCE;
        BehaviorRelay createDefault = BehaviorRelay.createDefault(Unit.INSTANCE);
        Observable observeOn = stateObservable.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(AndroidSchedulers.mainThread())");
        Intrinsics.checkNotNullExpressionValue(createDefault, "nextStateTrigger");
        Observable zipWith = observeOn.zipWith(createDefault, new BiFunction<BlacklistPresenter.State, Unit, R>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$$inlined$render$1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(BlacklistPresenter.State state, Unit unit) {
                RendererWithDiff rendererWithDiff = RendererWithDiff.this;
                return (R) TuplesKt.to(rendererWithDiff.getLastRenderedState(rendererWithDiff), state);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        Disposable subscribe = zipWith.observeOn(Schedulers.computation()).map(new Function<Pair<? extends BlacklistPresenter.State, ? extends BlacklistPresenter.State>, Pair<? extends BlacklistPresenter.State, ? extends DiffUtil.DiffResult>>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$$inlined$render$2
            public final Pair<BlacklistPresenter.State, DiffUtil.DiffResult> apply(@NotNull Pair<? extends BlacklistPresenter.State, ? extends BlacklistPresenter.State> pair) {
                Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                Object component1 = pair.component1();
                Object component2 = pair.component2();
                return TuplesKt.to(component2, Differ.calculateDiff$default(Differ.this, component1, component2, false, 4, null));
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Pair<? extends BlacklistPresenter.State, ? extends DiffUtil.DiffResult>>("BlacklistFragment", createDefault) { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$$inlined$render$3
            public final /* synthetic */ String b;
            public final /* synthetic */ BehaviorRelay c;

            {
                this.b = r2;
                this.c = r3;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(Pair<? extends BlacklistPresenter.State, ? extends DiffUtil.DiffResult> pair) {
                Object component1 = pair.component1();
                RendererWithDiff rendererWithDiff = RendererWithDiff.this;
                rendererWithDiff.getLastRenderedState(rendererWithDiff);
                RendererWithDiff.this.render(component1, (DiffUtil.DiffResult) pair.component2());
                String str = this.b;
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(" Rendered ");
                sb.append(component1);
                Logs.info$default(str, sb.toString(), null, 4, null);
                this.c.accept(Unit.INSTANCE);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(AndroidSchedul…Trigger += Unit\n        }");
        DisposableKt.addTo(subscribe, this.e);
        getBlacklistPresenter().getShowLoginScreenStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                BlacklistRouter blacklistRouter;
                if (t != null && (blacklistRouter = BlacklistFragment.this.d) != null) {
                    blacklistRouter.showLoginScreen();
                }
            }
        });
        getBlacklistPresenter().getShowErrorStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    Context context = BlacklistFragment.this.getContext();
                    if (context != null) {
                        ToastsKt.showToast(context, t2, 0);
                    }
                }
            }
        });
        Disposable subscribe2 = access$getBlacklistView$p(this).getRetryClickedStream().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$3
            public final void accept(Unit unit) {
                BlacklistFragment.this.getBlacklistPresenter().initialDataRequest();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "blacklistView.retryClick…taRequest()\n            }");
        DisposableKt.addTo(subscribe2, this.e);
        Disposable subscribe3 = access$getBlacklistView$p(this).getPulledToRefreshStream().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$4
            public final void accept(Unit unit) {
                BlacklistFragment.this.getBlacklistPresenter().refresh();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "blacklistView.pulledToRe…r.refresh()\n            }");
        DisposableKt.addTo(subscribe3, this.e);
        Disposable subscribe4 = access$getBlacklistView$p(this).getStartPaginationStream().observeOn(getSchedulers().mainThread()).subscribe(new Consumer<Unit>() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistFragment$bindBlacklistView$5
            public final void accept(Unit unit) {
                BlacklistFragment.this.getBlacklistPresenter().requestNextPage();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe4, "blacklistView.startPagin…tNextPage()\n            }");
        DisposableKt.addTo(subscribe4, this.e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        BlacklistPresenter blacklistPresenter2 = this.blacklistPresenter;
        if (blacklistPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistPresenter");
        }
        blacklistPresenter2.getShowLoginScreenStream().removeObservers(getViewLifecycleOwner());
        BlacklistPresenter blacklistPresenter3 = this.blacklistPresenter;
        if (blacklistPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistPresenter");
        }
        blacklistPresenter3.getShowErrorStream().removeObservers(getViewLifecycleOwner());
        this.e.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        this.c = new BlacklistViewImpl(view, analytics2, adapterPresenter2, itemBinder2);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBlacklistPresenter(@NotNull BlacklistPresenter blacklistPresenter2) {
        Intrinsics.checkNotNullParameter(blacklistPresenter2, "<set-?>");
        this.blacklistPresenter = blacklistPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        BlacklistFragmentComponent.Builder fragment = DaggerBlacklistFragmentComponent.builder().dependencies((BlacklistFragmentComponentDependencies) ComponentDependenciesKt.getDependencies(BlacklistFragmentComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).fragment(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        fragment.resources(resources).build().inject(this);
        return true;
    }
}
