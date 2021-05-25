package com.avito.android.user_stats;

import a2.a.a.l3.b;
import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.avito.android.analytics.Analytics;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.SafeViewPager;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui_components.R;
import com.avito.android.user_stats.tab.UserStatsPagerAdapter;
import com.avito.android.user_stats.tab.UserStatsTabItem;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010D\u001a\u00020C\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030=\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\bE\u0010FJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014RD\u0010\u001a\u001a0\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00050\u0005 \u0016*\u0017\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u00170\u0015¢\u0006\u0002\b\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105RD\u00108\u001a0\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00110\u0011 \u0016*\u0017\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00170\u0015¢\u0006\u0002\b\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0019R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006G"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewImpl;", "Lcom/avito/android/user_stats/UserStatsView;", "", "Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "tabs", "", "setTabs", "(Ljava/util/List;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "showLoading", "()V", "showContent", "error", "showError", "", "tabPosition", "selectTab", "(I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "backClickRelay", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/google/android/material/tabs/TabLayout;", AuthSource.SEND_ABUSE, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/avito/android/ui/SafeViewPager;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/SafeViewPager;", "viewPager", "Lio/reactivex/rxjava3/core/Observable;", g.a, "Lio/reactivex/rxjava3/core/Observable;", "getBackClicks", "()Lio/reactivex/rxjava3/core/Observable;", "backClicks", "i", "getTabClicks", "tabClicks", "h", "getRetryClicks", "retryClicks", "Landroidx/fragment/app/Fragment;", "k", "Landroidx/fragment/app/Fragment;", "fragment", "f", "tabClickRelay", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "j", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroidx/fragment/app/Fragment;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsViewImpl implements UserStatsView {
    public final TabLayout a;
    public final SafeViewPager b;
    public final Toolbar c;
    public final ProgressOverlay d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Integer> f;
    @NotNull
    public final Observable<Unit> g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Integer> i;
    public final TabsDataProvider<UserStatsTabItem> j;
    public final Fragment k;

    public UserStatsViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull TabsDataProvider<UserStatsTabItem> tabsDataProvider, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.j = tabsDataProvider;
        this.k = fragment;
        View findViewById = view.findViewById(R.id.stats_tabs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.stats_tabs)");
        TabLayout tabLayout = (TabLayout) findViewById;
        this.a = tabLayout;
        int i2 = R.id.stats_view_pager;
        View findViewById2 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.stats_view_pager)");
        SafeViewPager safeViewPager = (SafeViewPager) findViewById2;
        this.b = safeViewPager;
        View findViewById3 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.c = toolbar;
        View findViewById4 = view.findViewById(R.id.stats_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.stats_content)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById4, i2, analytics, false, 0, 24, null);
        this.d = progressOverlay;
        PublishRelay<Unit> create = PublishRelay.create();
        this.e = create;
        PublishRelay<Integer> create2 = PublishRelay.create();
        this.f = create2;
        toolbar.setNavigationIcon(R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new b(this));
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        TabLayoutsKt.setAdapter(tabLayout, new TabLayoutAdapter(tabsDataProvider, requireContext, R.layout.tab_shortcut));
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        safeViewPager.setAdapter(new UserStatsPagerAdapter(childFragmentManager, tabsDataProvider));
        safeViewPager.setPagingEnabled(false);
        tabLayout.setupWithViewPager(safeViewPager);
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new SimpleOnTabSelectedListener() { // from class: com.avito.android.user_stats.UserStatsViewImpl$setupViewPager$1
            @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                super.onTabSelected(tab);
                if (tab.getPosition() != -1) {
                    UserStatsViewImpl.this.f.accept(Integer.valueOf(tab.getPosition()));
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "backClickRelay");
        this.g = create;
        this.h = InteropKt.toV3(progressOverlay.refreshes());
        Intrinsics.checkNotNullExpressionValue(create2, "tabClickRelay");
        this.i = create2;
    }

    @Override // com.avito.android.user_stats.UserStatsView
    @NotNull
    public Observable<Unit> getBackClicks() {
        return this.g;
    }

    @Override // com.avito.android.user_stats.UserStatsView
    @NotNull
    public Observable<Unit> getRetryClicks() {
        return this.h;
    }

    @Override // com.avito.android.user_stats.UserStatsView
    @NotNull
    public Observable<Integer> getTabClicks() {
        return this.i;
    }

    @Override // com.avito.android.user_stats.UserStatsView
    public void selectTab(int i2) {
        if (this.a.getSelectedTabPosition() != i2 && this.b.getChildCount() > i2) {
            this.b.setCurrentItem(i2, false);
        }
    }

    @Override // com.avito.android.user_stats.UserStatsView
    public void setTabs(@NotNull List<UserStatsTabItem> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        if (this.j.getCount() != list.size()) {
            this.j.updateItems(list);
            PagerAdapter adapter = this.b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            TabAdapter<?, ?> adapter2 = TabLayoutsKt.getAdapter(this.a);
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
            }
        }
    }

    @Override // com.avito.android.user_stats.UserStatsView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.c.setTitle(str);
    }

    @Override // com.avito.android.user_stats.UserStatsView
    public void showContent() {
        if (!this.d.isContentVisible()) {
            this.d.showContent();
        }
    }

    @Override // com.avito.android.user_stats.UserStatsView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.d.showLoadingProblem(str);
    }

    @Override // com.avito.android.user_stats.UserStatsView
    public void showLoading() {
        this.d.showLoading();
    }
}
