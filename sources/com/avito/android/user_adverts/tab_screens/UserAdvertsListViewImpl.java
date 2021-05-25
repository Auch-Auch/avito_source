package com.avito.android.user_adverts.tab_screens;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.Px;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.common.ConstantsKt;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.floating_views.ScrollHandler;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListView;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BW\u0012\u0006\u00107\u001a\u000206\u0012\b\b\u0001\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006?"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListViewImpl;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "", "showProgress", "()V", "showAdverts", "showError", "", "", "spaceIndices", "updateSpaceDecoration", "(Ljava/util/List;)V", "scrollToTop", "onDataChanged", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "e", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "scrollListener", g.a, "I", "rootId", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "i", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "j", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/user_adverts/tab_screens/SpaceDecoration;", "f", "Lcom/avito/android/user_adverts/tab_screens/SpaceDecoration;", "spaceDecoration", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView$Router;", "h", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView$Router;", "router", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", AuthSource.BOOKING_ORDER, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/floating_views/ScrollHandler$Listener;", "scrollHandlerListener", ConstantsKt.KEY_LIST_BOTTOM_PADDING, "<init>", "(Landroid/view/View;ILcom/avito/android/user_adverts/tab_screens/UserAdvertsListView$Router;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/floating_views/ScrollHandler$Listener;Ljava/lang/Integer;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsListViewImpl implements UserAdvertsListView {
    public final RecyclerView a;
    public final SwipeRefreshLayout b;
    public ProgressOverlay c;
    public final LinearLayoutManager d;
    public final RecyclerViewScrollHandler e;
    public SpaceDecoration f;
    public final int g;
    public final UserAdvertsListView.Router h;
    public final ResponsiveAdapterPresenter i;
    public final ViewHolderBuilder<BaseViewHolder> j;

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ UserAdvertsListViewImpl a;

        public a(UserAdvertsListViewImpl userAdvertsListViewImpl) {
            this.a = userAdvertsListViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.h.onRefresh();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UserAdvertsListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UserAdvertsListViewImpl userAdvertsListViewImpl) {
            super(0);
            this.a = userAdvertsListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.h.onRetryClick();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SwipeRefreshLayout a;

        public c(SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setRefreshing(false);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ SwipeRefreshLayout a;

        public d(SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setRefreshing(false);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ SwipeRefreshLayout a;

        public e(SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setRefreshing(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public UserAdvertsListViewImpl(@NotNull View view, @IdRes int i2, @NotNull UserAdvertsListView.Router router, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull Analytics analytics, @Nullable ScrollHandler.Listener listener, @Px @Nullable Integer num) {
        ScrollHandler.Listener listener2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.g = i2;
        this.h = router;
        this.i = responsiveAdapterPresenter;
        this.j = viewHolderBuilder;
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById2;
        this.b = swipeRefreshLayout;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 1, false);
        this.d = linearLayoutManager;
        if (listener != null) {
            listener2 = listener;
        } else {
            listener2 = new ScrollHandler.Listener() { // from class: com.avito.android.user_adverts.tab_screens.UserAdvertsListViewImpl$scrollListener$1
                @Override // com.avito.android.floating_views.ScrollHandler.Listener
                public void onVisibleItemChanged(int i3, int i4, int i5, int i6) {
                }
            };
        }
        RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(listener2, linearLayoutManager);
        this.e = recyclerViewScrollHandler;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(recyclerViewScrollHandler);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0);
        }
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        recyclerView.addItemDecoration(new BannerDecoration(resources));
        if (num != null) {
            Views.changePadding$default(recyclerView, 0, 0, 0, num.intValue(), 7, null);
            recyclerView.setClipToPadding(false);
        }
        Context context = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        swipeRefreshLayout.setProgressViewOffset(false, recyclerView.getPaddingTop() + swipeRefreshLayout.getProgressViewStartOffset(), recyclerView.getPaddingTop() + swipeRefreshLayout.getProgressViewEndOffset());
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setOnRefreshListener(new a(this));
        View findViewById3 = view.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById3, 0, analytics, false, 0, 26, null);
        this.c = progressOverlay;
        if (progressOverlay != null) {
            progressOverlay.setBottomPadding(com.avito.android.bottom_navigation.R.dimen.bottom_nav_height);
        }
        ProgressOverlay progressOverlay2 = this.c;
        if (progressOverlay2 != null) {
            progressOverlay2.setOnRefreshListener(new b(this));
        }
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView
    public void onDataChanged() {
        if (this.a.getAdapter() == null) {
            ResponsiveRecyclerAdapter responsiveRecyclerAdapter = new ResponsiveRecyclerAdapter(this.i, this.j);
            responsiveRecyclerAdapter.setHasStableIds(true);
            this.a.setAdapter(responsiveRecyclerAdapter);
            return;
        }
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView
    public void scrollToTop() {
        RecyclerView recyclerView = this.a;
        recyclerView.scrollBy(0, -recyclerView.computeVerticalScrollOffset());
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView
    public void showAdverts() {
        ProgressOverlay progressOverlay = this.c;
        if (progressOverlay != null) {
            progressOverlay.showContent();
        }
        Views.show(this.a);
        SwipeRefreshLayout swipeRefreshLayout = this.b;
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.post(new c(swipeRefreshLayout));
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView
    public void showError() {
        ProgressOverlay progressOverlay = this.c;
        if (progressOverlay != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay, null, 1, null);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.b;
        swipeRefreshLayout.setEnabled(false);
        swipeRefreshLayout.post(new d(swipeRefreshLayout));
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView
    public void showProgress() {
        if (!this.b.isRefreshing()) {
            ProgressOverlay progressOverlay = this.c;
            if (progressOverlay != null) {
                progressOverlay.showContent();
            }
            Views.hide(this.a);
            SwipeRefreshLayout swipeRefreshLayout = this.b;
            swipeRefreshLayout.setEnabled(false);
            swipeRefreshLayout.post(new e(swipeRefreshLayout));
        }
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView
    public void updateSpaceDecoration(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "spaceIndices");
        SpaceDecoration spaceDecoration = this.f;
        if (spaceDecoration != null) {
            this.a.removeItemDecoration(spaceDecoration);
        }
        if (!list.isEmpty()) {
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "recycler.resources");
            SpaceDecoration spaceDecoration2 = new SpaceDecoration(resources, list);
            this.a.addItemDecoration(spaceDecoration2);
            this.f = spaceDecoration2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserAdvertsListViewImpl(View view, int i2, UserAdvertsListView.Router router, ResponsiveAdapterPresenter responsiveAdapterPresenter, ViewHolderBuilder viewHolderBuilder, Analytics analytics, ScrollHandler.Listener listener, Integer num, int i3, j jVar) {
        this(view, i2, router, responsiveAdapterPresenter, viewHolderBuilder, analytics, (i3 & 64) != 0 ? null : listener, (i3 & 128) != 0 ? null : num);
    }
}
