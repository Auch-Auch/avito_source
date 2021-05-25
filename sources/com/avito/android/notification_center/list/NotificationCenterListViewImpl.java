package com.avito.android.notification_center.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.R;
import com.avito.android.notification_center.list.NotificationCenterListView;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.adapter.RecyclerViewSeparateLoadingAppendingAdapter;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010%\u001a\u00020\u0014\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n \u0010*\u0004\u0018\u00010!0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/avito/android/notification_center/list/NotificationCenterListViewImpl;", "Lcom/avito/android/notification_center/list/NotificationCenterListView;", "", "showEmpty", "()V", "hideEmpty", "showProgress", "showContent", "showRefreshProgress", "hideRefreshProgress", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "emptyView", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "e", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "view", "Lcom/avito/android/notification_center/list/NotificationCenterListView$Callback;", "callback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/notification_center/list/NotificationCenterListView$Callback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/ui/adapter/AppendingListener;Lcom/avito/android/analytics/Analytics;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterListViewImpl implements NotificationCenterListView {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> a;
    public final View b;
    public final ProgressOverlay c;
    public final RecyclerView d;
    public final SwipeRefreshLayout e;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterListView.Callback a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NotificationCenterListView.Callback callback) {
            super(0);
            this.a = callback;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onRetry();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ NotificationCenterListView.Callback a;

        public b(NotificationCenterListView.Callback callback) {
            this.a = callback;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.onRefresh();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NotificationCenterListView.Callback a;

        public c(NotificationCenterListView.Callback callback) {
            this.a = callback;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onUpPressed();
        }
    }

    public NotificationCenterListViewImpl(@NotNull View view, @NotNull NotificationCenterListView.Callback callback, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull AppendingListener appendingListener, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = view.findViewById(R.id.empty);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.d = recyclerView;
        int i = R.id.swipe_refresh_layout;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(i);
        this.e = swipeRefreshLayout;
        RecyclerViewSeparateLoadingAppendingAdapter recyclerViewSeparateLoadingAppendingAdapter = new RecyclerViewSeparateLoadingAppendingAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder), appendingListener, false);
        this.a = recyclerViewSeparateLoadingAppendingAdapter;
        recyclerViewSeparateLoadingAppendingAdapter.setHasStableIds(true);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentHolder");
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(callback));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(recyclerViewSeparateLoadingAppendingAdapter);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new VerticalListItemDecoration.Builder(view.getContext().getDrawable(com.avito.android.ui_components.R.drawable.recycler_view_divider)).build());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        swipeRefreshLayout.setOnRefreshListener(new b(callback));
        Toolbar toolbar = (Toolbar) view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        toolbar.setTitle(com.avito.android.app.core.R.string.notification_center);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        toolbar.setNavigationOnClickListener(new c(callback));
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void hideEmpty() {
        Views.hide(this.b);
        Views.show(this.d);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void hideRefreshProgress() {
        SwipeRefreshLayout swipeRefreshLayout = this.e;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void notifyDataChanged() {
        this.a.notifyDataSetChanged();
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void showContent() {
        this.c.showContent();
        Views.enable(this.e);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void showEmpty() {
        Views.show(this.b);
        Views.hide(this.d);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.c.showLoadingProblem(str);
        Views.disable(this.e);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void showProgress() {
        this.c.showLoading();
        Views.disable(this.e);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListView
    public void showRefreshProgress() {
        SwipeRefreshLayout swipeRefreshLayout = this.e;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(true);
    }
}
