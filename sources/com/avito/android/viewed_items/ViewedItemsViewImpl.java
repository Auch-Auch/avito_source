package com.avito.android.viewed_items;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.favorites.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.Views;
import com.avito.android.viewed_items.ViewedItemsView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsViewImpl;", "Lcom/avito/android/viewed_items/ViewedItemsView;", "Lcom/avito/android/viewed_items/ViewedItemsView$ScreenState;", "screenState", "", "setScreenState", "(Lcom/avito/android/viewed_items/ViewedItemsView$ScreenState;)V", "notifyDatasetChanged", "()V", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "e", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "emptyView", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "d", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "presenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/viewed_items/ViewedItemsPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsViewImpl implements ViewedItemsView {
    public final TextView a;
    public final RecyclerView b;
    public final ProgressOverlay c;
    public final SwipeRefreshLayout d;
    public final SimpleRecyclerAdapter e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ViewedItemsView.ScreenState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ ViewedItemsPresenter a;

        public a(ViewedItemsPresenter viewedItemsPresenter) {
            this.a = viewedItemsPresenter;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.onSwipeToRefresh();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ViewedItemsPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ViewedItemsPresenter viewedItemsPresenter) {
            super(0);
            this.a = viewedItemsPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onErrorStateRefreshButtonClicked();
            return Unit.INSTANCE;
        }
    }

    public ViewedItemsViewImpl(@NotNull ViewGroup viewGroup, @NotNull final ViewedItemsPresenter viewedItemsPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(viewedItemsPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        View findViewById = viewGroup.findViewById(R.id.empty_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.viewed_items_recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, R.id.content_view, null, false, 0, 28, null);
        this.c = progressOverlay;
        View findViewById3 = viewGroup.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById3;
        this.d = swipeRefreshLayout;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.e = simpleRecyclerAdapter;
        progressOverlay.setOnRefreshListener(new b(viewedItemsPresenter));
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.viewed_items.ViewedItemsViewImpl.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i, i2);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null) {
                    viewedItemsPresenter.onScrolled(linearLayoutManager.getChildCount(), linearLayoutManager.getItemCount(), linearLayoutManager.findFirstVisibleItemPosition());
                }
            }
        });
        Context context = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setOnRefreshListener(new a(viewedItemsPresenter));
    }

    @Override // com.avito.android.viewed_items.ViewedItemsView
    public void notifyDatasetChanged() {
        this.e.notifyDataSetChanged();
    }

    @Override // com.avito.android.viewed_items.ViewedItemsView
    public void notifyItemAtPositionChanged(int i) {
        this.e.notifyItemChanged(i);
    }

    @Override // com.avito.android.viewed_items.ViewedItemsView
    public void setScreenState(@NotNull ViewedItemsView.ScreenState screenState) {
        Intrinsics.checkNotNullParameter(screenState, "screenState");
        this.d.setRefreshing(false);
        int ordinal = screenState.ordinal();
        if (ordinal == 0) {
            this.c.showContent();
            Views.hide(this.a);
            Views.show(this.b);
        } else if (ordinal == 1) {
            this.c.showLoading();
        } else if (ordinal == 2) {
            this.c.showContent();
            Views.show(this.a);
            Views.hide(this.b);
        } else if (ordinal == 3) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
        }
    }
}
