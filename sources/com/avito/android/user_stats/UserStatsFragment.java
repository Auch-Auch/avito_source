package com.avito.android.user_stats;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CompositeComponentDependenciesProvider;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.user_stats.di.DaggerUserStatsComponent;
import com.avito.android.user_stats.di.UserStatsComponent;
import com.avito.android.user_stats.di.UserStatsDependencies;
import com.avito.android.user_stats.di.UserStatsTabDependencies;
import com.avito.android.user_stats.tab.UserStatsTabItem;
import com.avito.android.user_stats.tracker.UserStatsTracker;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bA\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0000@\u0000X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010@\u001a\u00020;8V@\u0016X\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/avito/android/user_stats/UserStatsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/di/HasComponentDependencies;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onViewStateRestored", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$user_stats_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$user_stats_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "l", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "k", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Lcom/avito/android/user_stats/di/UserStatsTabDependencies;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/user_stats/di/UserStatsTabDependencies;", "dependenciesComponent", "Lcom/avito/android/user_stats/UserStatsViewModel;", "viewModel", "Lcom/avito/android/user_stats/UserStatsViewModel;", "getViewModel$user_stats_release", "()Lcom/avito/android/user_stats/UserStatsViewModel;", "setViewModel$user_stats_release", "(Lcom/avito/android/user_stats/UserStatsViewModel;)V", "Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "userStatsTracker", "Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "getUserStatsTracker$user_stats_release", "()Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "setUserStatsTracker$user_stats_release", "(Lcom/avito/android/user_stats/tracker/UserStatsTracker;)V", "Lcom/avito/android/user_stats/UserStatsView;", "j", "Lcom/avito/android/user_stats/UserStatsView;", "userStatsView", "Lcom/avito/android/di/CompositeComponentDependenciesProvider;", "n", "Lkotlin/Lazy;", "getDependencies", "()Lcom/avito/android/di/CompositeComponentDependenciesProvider;", "dependencies", "<init>", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsFragment extends TabBaseFragment implements HasComponentDependencies {
    @Inject
    public Analytics analytics;
    public UserStatsView j;
    public final TabsDataProvider<UserStatsTabItem> k = new TabsDataProvider<>();
    public final CompositeDisposable l = new CompositeDisposable();
    public UserStatsTabDependencies m;
    @NotNull
    public final Lazy n = t6.c.lazy(new b(this));
    @Inject
    public UserStatsTracker userStatsTracker;
    @Inject
    public UserStatsViewModel viewModel;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((UserStatsFragment) this.b).requireActivity().onBackPressed();
            } else if (i == 1) {
                ((UserStatsFragment) this.b).getViewModel$user_stats_release().loadUserStats();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<CompositeComponentDependenciesProvider> {
        public final /* synthetic */ UserStatsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UserStatsFragment userStatsFragment) {
            super(0);
            this.a = userStatsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public CompositeComponentDependenciesProvider invoke() {
            FragmentActivity requireActivity = this.a.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return new CompositeComponentDependenciesProvider(ComponentDependenciesKt.findComponentDependenciesProvider((Activity) requireActivity), q.mapOf(TuplesKt.to(UserStatsTabDependencies.class, UserStatsFragment.access$getDependenciesComponent$p(this.a))));
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ UserStatsFragment a;

        public c(UserStatsFragment userStatsFragment) {
            this.a = userStatsFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            UserStatsViewModel viewModel$user_stats_release = this.a.getViewModel$user_stats_release();
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            viewModel$user_stats_release.onSelectTab(num2.intValue());
        }
    }

    public static final /* synthetic */ UserStatsTabDependencies access$getDependenciesComponent$p(UserStatsFragment userStatsFragment) {
        UserStatsTabDependencies userStatsTabDependencies = userStatsFragment.m;
        if (userStatsTabDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dependenciesComponent");
        }
        return userStatsTabDependencies;
    }

    public static final /* synthetic */ UserStatsView access$getUserStatsView$p(UserStatsFragment userStatsFragment) {
        UserStatsView userStatsView = userStatsFragment.j;
        if (userStatsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsView");
        }
        return userStatsView;
    }

    @NotNull
    public final Analytics getAnalytics$user_stats_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.di.HasComponentDependencies
    @NotNull
    public CompositeComponentDependenciesProvider getDependencies() {
        return (CompositeComponentDependenciesProvider) this.n.getValue();
    }

    @NotNull
    public final UserStatsTracker getUserStatsTracker$user_stats_release() {
        UserStatsTracker userStatsTracker2 = this.userStatsTracker;
        if (userStatsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTracker");
        }
        return userStatsTracker2;
    }

    @NotNull
    public final UserStatsViewModel getViewModel$user_stats_release() {
        UserStatsViewModel userStatsViewModel = this.viewModel;
        if (userStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return userStatsViewModel;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Timer B1 = a2.b.a.a.a.B1();
        UserStatsComponent.Factory factory = DaggerUserStatsComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        UserStatsComponent create = factory.create(this, resources, (UserStatsDependencies) ComponentDependenciesKt.getDependencies(UserStatsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        this.m = create;
        create.inject(this);
        UserStatsTracker userStatsTracker2 = this.userStatsTracker;
        if (userStatsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTracker");
        }
        userStatsTracker2.trackDiInject(B1.elapsed());
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserStatsTracker userStatsTracker2 = this.userStatsTracker;
        if (userStatsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTracker");
        }
        userStatsTracker2.startInit();
        View inflate = layoutInflater.inflate(R.layout.user_stats, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_stats, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.l.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        UserStatsViewImpl userStatsViewImpl = new UserStatsViewImpl(view, analytics2, this.k, this);
        CompositeDisposable compositeDisposable = this.l;
        Disposable subscribe = userStatsViewImpl.getBackClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "backClicks.subscribe { r…ivity().onBackPressed() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.l;
        Disposable subscribe2 = userStatsViewImpl.getRetryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "retryClicks.subscribe { …ewModel.loadUserStats() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.l;
        Disposable subscribe3 = userStatsViewImpl.getTabClicks().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "tabClicks.subscribe { viewModel.onSelectTab(it) }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        this.j = userStatsViewImpl;
        UserStatsViewModel userStatsViewModel = this.viewModel;
        if (userStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userStatsViewModel.getScreenState().observe(getViewLifecycleOwner(), new a2.a.a.l3.a(this));
        UserStatsTracker userStatsTracker2 = this.userStatsTracker;
        if (userStatsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userStatsTracker");
        }
        userStatsTracker2.trackInit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            beginTransaction.remove(it.next());
        }
        beginTransaction.commitNow();
    }

    public final void setAnalytics$user_stats_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setUserStatsTracker$user_stats_release(@NotNull UserStatsTracker userStatsTracker2) {
        Intrinsics.checkNotNullParameter(userStatsTracker2, "<set-?>");
        this.userStatsTracker = userStatsTracker2;
    }

    public final void setViewModel$user_stats_release(@NotNull UserStatsViewModel userStatsViewModel) {
        Intrinsics.checkNotNullParameter(userStatsViewModel, "<set-?>");
        this.viewModel = userStatsViewModel;
    }
}
