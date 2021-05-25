package com.avito.android.orders.feature.host;

import a2.a.a.r1.a.a.a;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.analytics.Analytics;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.orders.R;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010=\u001a\u00020:\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010RD\u0010\u0017\u001a0\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00020\u0002 \u0013*\u0017\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0012¢\u0006\u0002\b\u00140\u0012¢\u0006\u0002\b\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewImpl;", "Lcom/avito/android/orders/feature/host/OrdersView;", "", "showLoading", "()V", "showContent", "", "errorMessage", "showFullScreenError", "(Ljava/lang/String;)V", "showPartScreenError", "", "activeTab", "setActiveTab", "(I)V", "getTabIndex", "()I", "tabIndex", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "backClickRelay", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/google/android/material/tabs/TabLayout;", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroidx/viewpager/widget/ViewPager;", "c", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "j", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "tabsAdapter", "Landroid/view/View;", "h", "Landroid/view/View;", "view", "Lio/reactivex/rxjava3/core/Observable;", "f", "Lio/reactivex/rxjava3/core/Observable;", "getBackClicks", "()Lio/reactivex/rxjava3/core/Observable;", "backClicks", g.a, "getRetryClicks", "retryClicks", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/viewpager/widget/PagerAdapter;", "i", "Landroidx/viewpager/widget/PagerAdapter;", "pagerAdapter", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Landroidx/viewpager/widget/PagerAdapter;Lcom/avito/android/design/widget/tab/TabLayoutAdapter;Lcom/avito/android/analytics/Analytics;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersViewImpl implements OrdersView {
    public final ProgressOverlay a;
    public final TabLayout b;
    public final ViewPager c;
    public final Toolbar d;
    public final PublishRelay<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    @NotNull
    public final Observable<Unit> g;
    public final View h;
    public final PagerAdapter i;
    public final TabLayoutAdapter<OrdersTabItem> j;

    @Inject
    public OrdersViewImpl(@NotNull View view, @NotNull PagerAdapter pagerAdapter, @NotNull TabLayoutAdapter<OrdersTabItem> tabLayoutAdapter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pagerAdapter, "pagerAdapter");
        Intrinsics.checkNotNullParameter(tabLayoutAdapter, "tabsAdapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = view;
        this.i = pagerAdapter;
        this.j = tabLayoutAdapter;
        View findViewById = view.findViewById(R.id.orders_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        int i2 = R.id.orders_view_pager;
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById, i2, analytics, false, 0, 24, null);
        this.a = progressOverlay;
        View findViewById2 = view.findViewById(R.id.orders_tabs);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById2;
        this.b = tabLayout;
        View findViewById3 = view.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = (ViewPager) findViewById3;
        this.c = viewPager;
        View findViewById4 = view.findViewById(R.id.orders_toolbar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById4;
        this.d = toolbar;
        PublishRelay<Unit> create = PublishRelay.create();
        this.e = create;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setTitle(R.string.orders_title);
        toolbar.setNavigationOnClickListener(new a(this));
        TabLayoutsKt.setAdapter(tabLayout, tabLayoutAdapter);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        Observable<Unit> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "backClickRelay.hide()");
        this.f = hide;
        this.g = InteropKt.toV3(progressOverlay.refreshes());
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    @NotNull
    public Observable<Unit> getBackClicks() {
        return this.f;
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    @NotNull
    public Observable<Unit> getRetryClicks() {
        return this.g;
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    public int getTabIndex() {
        return this.b.getSelectedTabPosition();
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    public void setActiveTab(int i2) {
        if (this.b.getSelectedTabPosition() != i2 && this.c.getChildCount() > i2) {
            this.c.setCurrentItem(i2, false);
        }
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    public void showContent() {
        this.a.showContent();
        this.i.notifyDataSetChanged();
        this.j.notifyDataSetChanged();
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    public void showFullScreenError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.a.showLoadingProblem(str);
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    public void showLoading() {
        this.a.showLoading();
    }

    @Override // com.avito.android.orders.feature.host.OrdersView
    public void showPartScreenError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Views.showSnackBar$default(this.h, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
