package com.avito.android.verification.verifications_list;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.verification.R;
import com.avito.android.verification.verifications_list.list.TopMarginItemDecoration;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding4.swiperefreshlayout.RxSwipeRefreshLayout;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.CollapsingTitleAppBarLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*RD\u00100\u001a0\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00040\u0004 \u001a*\u0017\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00040\u0004\u0018\u00010,¢\u0006\u0002\b-0,¢\u0006\u0002\b-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010$\u001a\u0004\b2\u0010&R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u0010$\u001a\u0004\b9\u0010&¨\u0006C"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewImpl;", "Lcom/avito/android/verification/verifications_list/VerificationsListView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "showLoading", "()V", "showContent", "error", "showError", "", "Lcom/avito/conveyor_item/Item;", "items", "updateItems", "(Ljava/util/List;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "c", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "appBar", "Lio/reactivex/rxjava3/core/Observable;", g.a, "Lio/reactivex/rxjava3/core/Observable;", "getBackClicks", "()Lio/reactivex/rxjava3/core/Observable;", "backClicks", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "e", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "backClickRelay", "i", "getRefreshes", "refreshes", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "h", "getRetryClicks", "retryClicks", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationsListViewImpl implements VerificationsListView {
    public final Context a;
    public final PublishRelay<Unit> b;
    public final CollapsingTitleAppBarLayout c;
    public final RecyclerView d;
    public final SwipeRefreshLayout e;
    public final ProgressOverlay f;
    @NotNull
    public final Observable<Unit> g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Unit> i;
    public final AdapterPresenter j;

    public VerificationsListViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.j = adapterPresenter;
        Context context = view.getContext();
        this.a = context;
        PublishRelay<Unit> create = PublishRelay.create();
        this.b = create;
        View findViewById = view.findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.app_bar)");
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = (CollapsingTitleAppBarLayout) findViewById;
        this.c = collapsingTitleAppBarLayout;
        View findViewById2 = view.findViewById(R.id.verifications_list);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.verifications_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.d = recyclerView;
        int i2 = R.id.swipe_refresh;
        View findViewById3 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.swipe_refresh)");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById3;
        this.e = swipeRefreshLayout;
        View findViewById4 = view.findViewById(R.id.verifications_list_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.v…fications_list_container)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById4, i2, analytics, false, 0, 24, null);
        this.f = progressOverlay;
        collapsingTitleAppBarLayout.setClickListener(new AppbarClickListener() { // from class: com.avito.android.verification.verifications_list.VerificationsListViewImpl$setupAppBar$1
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                VerificationsListViewImpl.this.b.accept(Unit.INSTANCE);
            }
        });
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.addItemDecoration(new TopMarginItemDecoration(ViewSizeKt.getDp(14)));
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(context, "context");
        swipeRefreshLayout.setColorSchemeColors(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue), Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.violet), Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.green), Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
        Intrinsics.checkNotNullExpressionValue(context, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
        Intrinsics.checkNotNullExpressionValue(create, "backClickRelay");
        this.g = create;
        this.h = InteropKt.toV3(progressOverlay.refreshes());
        this.i = RxSwipeRefreshLayout.refreshes(swipeRefreshLayout);
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    @NotNull
    public Observable<Unit> getBackClicks() {
        return this.g;
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    @NotNull
    public Observable<Unit> getRefreshes() {
        return this.i;
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    @NotNull
    public Observable<Unit> getRetryClicks() {
        return this.h;
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.c.setTitle(str);
        this.c.setShortTitle(str);
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    public void showContent() {
        if (this.e.isRefreshing()) {
            this.e.setRefreshing(false);
        }
        if (!this.f.isContentVisible()) {
            this.f.showContent();
            this.c.setExpanded(true, false);
        }
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        if (this.e.isRefreshing()) {
            this.e.setRefreshing(false);
        }
        if (this.c.getShortTitle() == null) {
            this.c.setExpanded(false, false);
        }
        this.f.showLoadingProblem(str);
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    public void showLoading() {
        this.f.showLoading();
    }

    @Override // com.avito.android.verification.verifications_list.VerificationsListView
    public void updateItems(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        a.s1(list, this.j);
        RecyclerView.Adapter adapter = this.d.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
