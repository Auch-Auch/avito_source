package com.avito.android.messenger.blacklist.mvi;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.PaginationScrollListener;
import com.avito.android.messenger.R;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.blacklist.mvi.BlacklistView;
import com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Differ;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererWithDiff;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxbinding3.swiperefreshlayout.RxSwipeRefreshLayout;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001VB'\u0012\u0006\u0010Q\u001a\u00020\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010;\u001a\u000208¢\u0006\u0004\bT\u0010UJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\f\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#R9\u00103\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00078V@VX\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR%\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020E0D8B@\u0002X\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030K8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006W"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistViewImpl;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistView;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "destroy", "()V", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "prevState", "curState", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroid/view/View;", "kotlin.jvm.PlatformType", "h", "Landroid/view/View;", "emptyListPlaceholder", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", g.a, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefresh", "Lcom/jakewharton/rxrelay2/Relay;", "j", "Lcom/jakewharton/rxrelay2/Relay;", "getRetryClickedStream", "()Lcom/jakewharton/rxrelay2/Relay;", "retryClickedStream", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "l", "getStartPaginationStream", "startPaginationStream", "<set-?>", "i", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;)V", "lastRenderedState", "Lcom/avito/android/messenger/PaginationScrollListener;", "f", "Lcom/avito/android/messenger/PaginationScrollListener;", "paginationListener", "Lcom/avito/konveyor/ItemBinder;", "n", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "contentHolder", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "e", "Lkotlin/Lazy;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lio/reactivex/Observable;", "k", "Lio/reactivex/Observable;", "getPulledToRefreshStream", "()Lio/reactivex/Observable;", "pulledToRefreshStream", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "ListDiffer", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistViewImpl extends RecyclerView.OnScrollListener implements BlacklistView {
    public static final /* synthetic */ KProperty[] o = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(BlacklistViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", 0))};
    public final ViewGroup a;
    public final ProgressOverlay b;
    public final RecyclerView c;
    public final LinearLayoutManager d;
    public final Lazy e = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new b(this));
    public final PaginationScrollListener f;
    public final SwipeRefreshLayout g;
    public final View h;
    @Nullable
    public final ReadWriteProperty i;
    @NotNull
    public final Relay<Unit> j;
    @NotNull
    public final Observable<Unit> k;
    @NotNull
    public final Relay<Unit> l;
    public final AdapterPresenter m;
    public final ItemBinder n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistViewImpl$ListDiffer;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Differ;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;", "state", "", "getItems", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;)Ljava/util/List;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;)Z", "areContentsTheSame", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ListDiffer extends Differ<BlacklistPresenter.State, BlacklistItem> {
        @NotNull
        public static final ListDiffer INSTANCE = new ListDiffer();

        public boolean areContentsTheSame(@NotNull BlacklistItem blacklistItem, @NotNull BlacklistItem blacklistItem2) {
            Intrinsics.checkNotNullParameter(blacklistItem, "oldItem");
            Intrinsics.checkNotNullParameter(blacklistItem2, "newItem");
            return Intrinsics.areEqual(blacklistItem, blacklistItem2);
        }

        public boolean areItemsTheSame(@NotNull BlacklistItem blacklistItem, @NotNull BlacklistItem blacklistItem2) {
            Intrinsics.checkNotNullParameter(blacklistItem, "oldItem");
            Intrinsics.checkNotNullParameter(blacklistItem2, "newItem");
            return Intrinsics.areEqual(blacklistItem.getStringId(), blacklistItem2.getStringId());
        }

        @Nullable
        public List<BlacklistItem> getItems(@Nullable BlacklistPresenter.State state) {
            if (state != null) {
                return state.getListItems();
            }
            return null;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                Relay<Unit> retryClickedStream = ((BlacklistViewImpl) this.b).getRetryClickedStream();
                Unit unit = Unit.INSTANCE;
                retryClickedStream.accept(unit);
                return unit;
            } else if (i == 1) {
                Relay<Unit> startPaginationStream = ((BlacklistViewImpl) this.b).getStartPaginationStream();
                Unit unit2 = Unit.INSTANCE;
                startPaginationStream.accept(unit2);
                return unit2;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<SimpleRecyclerAdapter> {
        public final /* synthetic */ BlacklistViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BlacklistViewImpl blacklistViewImpl) {
            super(0);
            this.a = blacklistViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleRecyclerAdapter invoke() {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.a.m, this.a.n);
            this.a.c.setAdapter(simpleRecyclerAdapter);
            return simpleRecyclerAdapter;
        }
    }

    public BlacklistViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.m = adapterPresenter;
        this.n = itemBinder;
        View findViewById = view.findViewById(R.id.blacklist_content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.blacklist_content_holder)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.a = viewGroup;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, R.id.content, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        View findViewById2 = view.findViewById(R.id.blacklist_list);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.blacklist_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 1, false);
        this.d = linearLayoutManager;
        PaginationScrollListener paginationScrollListener = new PaginationScrollListener(linearLayoutManager, 3, new a(1, this));
        this.f = paginationScrollListener;
        View findViewById3 = view.findViewById(R.id.blacklist_swipe_refresh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.blacklist_swipe_refresh)");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById3;
        this.g = swipeRefreshLayout;
        this.h = view.findViewById(R.id.blacklist_empty_placeholder);
        this.i = new BackingField(null);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
        this.k = RxSwipeRefreshLayout.refreshes(swipeRefreshLayout);
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.l = create2;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(paginationScrollListener);
        recyclerView.setItemAnimator(null);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        Context context4 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "view.context");
        swipeRefreshLayout.setColorSchemeColors(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue), Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.violet), Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.green), Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.red));
        Context context5 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "view.context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.white));
        progressOverlay.setOnRefreshListener(new a(0, this));
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistView
    public void destroy() {
        this.c.removeOnScrollListener(this.f);
        this.b.setOnRefreshListener((OnRefreshListener) null);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererWithDiff
    @Nullable
    public BlacklistPresenter.State getLastRenderedState(@NotNull RendererWithDiff<BlacklistPresenter.State> rendererWithDiff) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        return (BlacklistPresenter.State) this.i.getValue(rendererWithDiff, o[0]);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistView
    @NotNull
    public Observable<Unit> getPulledToRefreshStream() {
        return this.k;
    }

    public void render(@NotNull BlacklistPresenter.State state, @Nullable DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(state, "state");
        BlacklistView.DefaultImpls.render(this, state, diffResult);
    }

    public void setLastRenderedState(@NotNull RendererWithDiff<BlacklistPresenter.State> rendererWithDiff, @Nullable BlacklistPresenter.State state) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        this.i.setValue(rendererWithDiff, o[0], state);
    }

    public void doRender(@NotNull RendererWithDiff<BlacklistPresenter.State> rendererWithDiff, @Nullable BlacklistPresenter.State state, @NotNull BlacklistPresenter.State state2, @Nullable DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        BlacklistPresenter.State.ProgressOverlayState progressOverlayState = state2.getProgressOverlayState();
        if (Intrinsics.areEqual(progressOverlayState, BlacklistPresenter.State.ProgressOverlayState.Hidden.INSTANCE)) {
            this.b.showContent();
        } else if (Intrinsics.areEqual(progressOverlayState, BlacklistPresenter.State.ProgressOverlayState.Loading.INSTANCE)) {
            this.b.showLoading();
        } else if (Intrinsics.areEqual(progressOverlayState, BlacklistPresenter.State.ProgressOverlayState.Error.INSTANCE)) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.b, null, 1, null);
        }
        if (state2.getListItems().isEmpty()) {
            Views.show(this.h);
        } else {
            Views.hide(this.h);
        }
        this.m.onDataSourceChanged(new ListDataSource(state2.getListItems()));
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo((RecyclerView.Adapter) this.e.getValue());
        } else {
            ((RecyclerView.Adapter) this.e.getValue()).notifyDataSetChanged();
        }
        boolean swipeToRefreshIsShown = state2.getSwipeToRefreshIsShown();
        SwipeRefreshLayout swipeRefreshLayout = this.g;
        if (swipeRefreshLayout.isRefreshing() != swipeToRefreshIsShown) {
            swipeRefreshLayout.setRefreshing(swipeToRefreshIsShown);
        }
        this.f.setPaginationEnabled(state2.getPaginationIsEnabled());
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistView
    @NotNull
    public Relay<Unit> getRetryClickedStream() {
        return this.j;
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistView
    @NotNull
    public Relay<Unit> getStartPaginationStream() {
        return this.l;
    }
}
