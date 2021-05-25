package com.avito.android.user_stats.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.di.DaggerUserStatsTabComponent;
import com.avito.android.user_stats.di.UserStatsTabComponent;
import com.avito.android.user_stats.di.UserStatsTabDependencies;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter;
import com.avito.android.user_stats.tracker.UserStatsTabTracker;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bI\u0010\u0010J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR5\u0010\u001f\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d¢\u0006\u0002\b\u001e0\u001c8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00101\u001a\u0002008\u0000@\u0000X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010<\u001a\u00020;8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onDestroyView", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;", "viewModel", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;", "getViewModel$user_stats_release", "()Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;", "setViewModel$user_stats_release", "(Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresentersSet", "Ljava/util/Set;", "getItemPresentersSet$user_stats_release", "()Ljava/util/Set;", "setItemPresentersSet$user_stats_release", "(Ljava/util/Set;)V", "Lcom/avito/android/user_stats/tracker/UserStatsTabTracker;", "userStatsTabTracker", "Lcom/avito/android/user_stats/tracker/UserStatsTabTracker;", "getUserStatsTabTracker$user_stats_release", "()Lcom/avito/android/user_stats/tracker/UserStatsTabTracker;", "setUserStatsTabTracker$user_stats_release", "(Lcom/avito/android/user_stats/tracker/UserStatsTabTracker;)V", "Lcom/avito/android/user_stats/tab/UserStatsTabView;", "c", "Lcom/avito/android/user_stats/tab/UserStatsTabView;", "userStatsTabView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter$user_stats_release", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter$user_stats_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter$user_stats_release", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter$user_stats_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$user_stats_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$user_stats_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabFragment extends BaseFragment {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    public UserStatsTabView c;
    public final CompositeDisposable d = new CompositeDisposable();
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresentersSet;
    @Inject
    public UserStatsTabTracker userStatsTabTracker;
    @Inject
    public UserStatsTabViewModel viewModel;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ UserStatsTabFragment a;

        public a(UserStatsTabFragment userStatsTabFragment) {
            this.a = userStatsTabFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.getViewModel$user_stats_release().onClickEmptyScreenAction();
        }
    }

    public static final class b<T> implements Consumer<ChartItem.BarItem> {
        public final /* synthetic */ UserStatsTabFragment a;

        public b(UserStatsTabFragment userStatsTabFragment) {
            this.a = userStatsTabFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ChartItem.BarItem barItem) {
            this.a.getViewModel$user_stats_release().onSelectColumn(barItem.getIndex());
        }
    }

    public static final class c<T> implements Consumer<DescriptionItemPresenter.DescriptionClickDetails> {
        public final /* synthetic */ UserStatsTabFragment a;

        public c(UserStatsTabFragment userStatsTabFragment) {
            this.a = userStatsTabFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DescriptionItemPresenter.DescriptionClickDetails descriptionClickDetails) {
            DescriptionItemPresenter.DescriptionClickDetails descriptionClickDetails2 = descriptionClickDetails;
            UserStatsTabViewModel viewModel$user_stats_release = this.a.getViewModel$user_stats_release();
            Intrinsics.checkNotNullExpressionValue(descriptionClickDetails2, "clickDetails");
            viewModel$user_stats_release.onClickDescriptionDetails(descriptionClickDetails2);
        }
    }

    public static final /* synthetic */ UserStatsTabView access$getUserStatsTabView$p(UserStatsTabFragment userStatsTabFragment) {
        UserStatsTabView userStatsTabView = userStatsTabFragment.c;
        if (userStatsTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTabView");
        }
        return userStatsTabView;
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter$user_stats_release() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter$user_stats_release() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$user_stats_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresentersSet$user_stats_release() {
        Set<ItemPresenter<?, ?>> set = this.itemPresentersSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresentersSet");
        }
        return set;
    }

    @NotNull
    public final UserStatsTabTracker getUserStatsTabTracker$user_stats_release() {
        UserStatsTabTracker userStatsTabTracker2 = this.userStatsTabTracker;
        if (userStatsTabTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTabTracker");
        }
        return userStatsTabTracker2;
    }

    @NotNull
    public final UserStatsTabViewModel getViewModel$user_stats_release() {
        UserStatsTabViewModel userStatsTabViewModel = this.viewModel;
        if (userStatsTabViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return userStatsTabViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserStatsTabTracker userStatsTabTracker2 = this.userStatsTabTracker;
        if (userStatsTabTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTabTracker");
        }
        userStatsTabTracker2.startInit();
        View inflate = layoutInflater.inflate(R.layout.user_stats_tab, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ts_tab, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.d.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserStatsTabViewModel userStatsTabViewModel = this.viewModel;
        if (userStatsTabViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userStatsTabViewModel.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        UserStatsTabViewImpl userStatsTabViewImpl = new UserStatsTabViewImpl(view);
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = userStatsTabViewImpl.getEmptyScreenActionButtonClicks().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "this.emptyScreenActionBu…lickEmptyScreenAction() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.c = userStatsTabViewImpl;
        UserStatsTabViewModel userStatsTabViewModel = this.viewModel;
        if (userStatsTabViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userStatsTabViewModel.getTabState().observe(getViewLifecycleOwner(), new a2.a.a.l3.c.a(this));
        userStatsTabViewModel.getRouterEvents().observe(getViewLifecycleOwner(), new a2.a.a.l3.c.b(this));
        Set<ItemPresenter<?, ?>> set = this.itemPresentersSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresentersSet");
        }
        for (T t : set) {
            if (t instanceof ChartItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.d;
                Disposable subscribe2 = t.getClicksObservable().subscribe(new b(this));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "it.clicksObservable.subs….index)\n                }");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (t instanceof DescriptionItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.d;
                Disposable subscribe3 = t.getLinkClicksObservable().subscribe(new c(this));
                Intrinsics.checkNotNullExpressionValue(subscribe3, "it.linkClicksObservable.…etails)\n                }");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            }
        }
        UserStatsTabTracker userStatsTabTracker2 = this.userStatsTabTracker;
        if (userStatsTabTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTabTracker");
        }
        userStatsTabTracker2.trackInit();
    }

    public final void setAdapter$user_stats_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAdapterPresenter$user_stats_release(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeepLinkIntentFactory$user_stats_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemPresentersSet$user_stats_release(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresentersSet = set;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Timer B1 = a2.b.a.a.a.B1();
        UserStatsTabComponent.Factory factory = DaggerUserStatsTabComponent.factory();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("tab_id") : null;
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY_TAB_ID)!!");
        factory.create(this, string, (UserStatsTabDependencies) ComponentDependenciesKt.getDependencies(UserStatsTabDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        UserStatsTabTracker userStatsTabTracker2 = this.userStatsTabTracker;
        if (userStatsTabTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTabTracker");
        }
        userStatsTabTracker2.trackDiInject(B1.elapsed());
        return true;
    }

    public final void setUserStatsTabTracker$user_stats_release(@NotNull UserStatsTabTracker userStatsTabTracker2) {
        Intrinsics.checkNotNullParameter(userStatsTabTracker2, "<set-?>");
        this.userStatsTabTracker = userStatsTabTracker2;
    }

    public final void setViewModel$user_stats_release(@NotNull UserStatsTabViewModel userStatsTabViewModel) {
        Intrinsics.checkNotNullParameter(userStatsTabViewModel, "<set-?>");
        this.viewModel = userStatsTabViewModel;
    }
}
