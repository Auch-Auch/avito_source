package com.avito.android.messenger.channels.mvi.view;

import a2.a.a.o1.b.b.e.h;
import a2.a.a.o1.b.b.e.i;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.channels.mvi.view.ChannelsListView;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.recyclerview.RxRecyclerView;
import com.jakewharton.rxbinding3.swiperefreshlayout.RxSwipeRefreshLayout;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010a\u001a\u00020H\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010e\u001a\u00020b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\bq\u0010rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0005J+\u0010\u000b\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R9\u0010:\u001a\u0004\u0018\u00010\b*\b\u0012\u0004\u0012\u00020\b0\u00072\b\u00103\u001a\u0004\u0018\u00010\b8V@VX\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R \u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030@0?8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR#\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030-8V@\u0016X\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u00101R\u001d\u0010X\u001a\u00020T8B@\u0002X\u0002¢\u0006\f\n\u0004\bU\u0010Q\u001a\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R#\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00030-8V@\u0016X\u0002¢\u0006\f\n\u0004\b]\u0010Q\u001a\u0004\b^\u00101R\u0016\u0010a\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010JR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010\u001eR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\"\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bl\u0010\u001e\u001a\u0004\bm\u0010 ¨\u0006s"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListViewImpl;", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListView;", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "", "onResume", "()V", "onPause", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)V", "scrollToUp", "onDestroyView", "", VKApiConst.POSITION, "", "onItemClick", "(I)Z", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "u", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "s", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "perfTracker", "Lcom/jakewharton/rxrelay2/PublishRelay;", "p", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getSnackbarRefreshClicks", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "snackbarRefreshClicks", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", VKApiConst.VERSION, "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "emptyView", "j", "Z", "paginationListenerIsEnabled", "Lio/reactivex/Observable;", "o", "Lio/reactivex/Observable;", "getSwipeRefreshes", "()Lio/reactivex/Observable;", "swipeRefreshes", "<set-?>", VKApiConst.Q, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)V", "lastRenderedState", "Lcom/avito/android/progress_overlay/ProgressOverlay;", g.a, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "d", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/View;", "h", "Landroid/view/View;", "bottomGuideline", "Lcom/avito/android/lib/design/snackbar/Snackbar;", "i", "Lcom/avito/android/lib/design/snackbar/Snackbar;", "snackbar", AuthSource.OPEN_CHANNEL_LIST, "Lkotlin/Lazy;", "getScrollEvents", "scrollEvents", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "getResources", "()Landroid/content/res/Resources;", "resources", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "e", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefresh", "l", "getPaginationStream", "paginationStream", "r", "rootView", "Lcom/avito/android/Features;", "t", "Lcom/avito/android/Features;", "features", "k", "manualPaginationTrigger", "Landroidx/recyclerview/widget/LinearLayoutManager;", "c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "n", "getOverlayRefreshClicks", "overlayRefreshClicks", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListViewImpl implements ChannelsListView, FlexibleAdapter.OnItemClickListener {
    public static final /* synthetic */ KProperty[] w = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(ChannelsListViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", 0))};
    public final Lazy a;
    public final RecyclerView b;
    public final LinearLayoutManager c;
    public FlexibleAdapter<AbstractListItem<?>> d;
    public final SwipeRefreshLayout e;
    public final TextView f;
    public final ProgressOverlay g;
    public final View h;
    public Snackbar i;
    public boolean j;
    public final PublishRelay<Unit> k;
    @NotNull
    public final Lazy l;
    @NotNull
    public final Lazy m;
    @NotNull
    public final PublishRelay<Unit> n;
    @NotNull
    public final Observable<Unit> o;
    @NotNull
    public final PublishRelay<Unit> p;
    @Nullable
    public final ReadWriteProperty q = new BackingField(null);
    public final View r;
    public final ChannelsTracker s;
    public final Features t;
    public final FpsStateSupplier u;
    public final ItemVisibilityTracker v;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChannelsListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChannelsListViewImpl channelsListViewImpl) {
            super(0);
            this.a = channelsListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay<Unit> overlayRefreshClicks = this.a.getOverlayRefreshClicks();
            Unit unit = Unit.INSTANCE;
            overlayRefreshClicks.accept(unit);
            return unit;
        }
    }

    public static final class b extends Lambda implements Function0<Observable<Unit>> {
        public final /* synthetic */ ChannelsListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ChannelsListViewImpl channelsListViewImpl) {
            super(0);
            this.a = channelsListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<Unit> invoke() {
            return RxRecyclerView.scrollEvents(this.a.b).map(a2.a.a.o1.b.b.e.g.a).mergeWith(this.a.k).observeOn(AndroidSchedulers.mainThread()).filter(new h(this)).throttleLatest(500L, TimeUnit.MILLISECONDS, true).observeOn(AndroidSchedulers.mainThread());
        }
    }

    public static final class c extends Lambda implements Function0<Resources> {
        public final /* synthetic */ ChannelsListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ChannelsListViewImpl channelsListViewImpl) {
            super(0);
            this.a = channelsListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Resources invoke() {
            return this.a.r.getResources();
        }
    }

    public static final class d extends Lambda implements Function0<Observable<Unit>> {
        public final /* synthetic */ ChannelsListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ChannelsListViewImpl channelsListViewImpl) {
            super(0);
            this.a = channelsListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<Unit> invoke() {
            return RxRecyclerView.scrollEvents(this.a.b).throttleLast(500, TimeUnit.MILLISECONDS).map(i.a).observeOn(AndroidSchedulers.mainThread());
        }
    }

    public ChannelsListViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull ChannelsTracker channelsTracker, @NotNull Features features, @NotNull FpsStateSupplier fpsStateSupplier, @NotNull ItemVisibilityTracker itemVisibilityTracker) {
        char c2;
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(channelsTracker, "perfTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(fpsStateSupplier, "supplier");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        this.r = view;
        this.s = channelsTracker;
        this.t = features;
        this.u = fpsStateSupplier;
        this.v = itemVisibilityTracker;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Lazy lazy = t6.c.lazy(lazyThreadSafetyMode, (Function0) new c(this));
        this.a = lazy;
        View findViewById = view.findViewById(16908298);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 1, false);
        this.c = linearLayoutManager;
        View findViewById2 = view.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById2;
        this.e = swipeRefreshLayout;
        View findViewById3 = view.findViewById(16908292);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.bottom_guideline);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById4;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.k = create;
        this.l = t6.c.lazy(lazyThreadSafetyMode, (Function0) new b(this));
        this.m = t6.c.lazy(lazyThreadSafetyMode, (Function0) new d(this));
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.n = create2;
        this.o = RxSwipeRefreshLayout.refreshes(swipeRefreshLayout);
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.p = create3;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);
        Context context = view.getContext();
        recyclerView.addItemDecoration(new ChannelsListItemDecoration());
        recyclerView.addOnScrollListener(fpsStateSupplier);
        if (features.getCartFloatingActionButton().invoke().booleanValue()) {
            c2 = 0;
            Views.changePadding$default(recyclerView, 0, 0, 0, ((Resources) lazy.getValue()).getDimensionPixelSize(com.avito.android.cart_fab.R.dimen.cart_bottom_space_for_list), 7, null);
            recyclerView.setClipToPadding(false);
        } else {
            c2 = 0;
        }
        int[] iArr = new int[4];
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iArr[c2] = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        iArr[1] = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.violet);
        iArr[2] = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.green);
        iArr[3] = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red);
        swipeRefreshLayout.setColorSchemeColors(iArr);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
        View findViewById5 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById5, R.id.content, analytics, false, 0, 24, null);
        progressOverlay.setOnRefreshListener(new a(this));
        this.g = progressOverlay;
    }

    public static final /* synthetic */ FlexibleAdapter access$getAdapter$p(ChannelsListViewImpl channelsListViewImpl) {
        FlexibleAdapter<AbstractListItem<?>> flexibleAdapter = channelsListViewImpl.d;
        if (flexibleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return flexibleAdapter;
    }

    public static final Resources access$getResources$p(ChannelsListViewImpl channelsListViewImpl) {
        return (Resources) channelsListViewImpl.a.getValue();
    }

    public static final void access$hideSnackbar(ChannelsListViewImpl channelsListViewImpl) {
        Objects.requireNonNull(channelsListViewImpl);
        Snackbar snackbar = channelsListViewImpl.i;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        channelsListViewImpl.i = null;
    }

    public static final void access$showSnackbar(ChannelsListViewImpl channelsListViewImpl, String str, String str2) {
        Objects.requireNonNull(channelsListViewImpl);
        channelsListViewImpl.r.post(new ChannelsListViewImpl$showSnackbar$1(channelsListViewImpl, str, str2));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        Snackbar snackbar = this.i;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.u.onPause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        this.u.onResume();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public ChannelsListState getLastRenderedState(@NotNull Renderer<ChannelsListState> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (ChannelsListState) this.q.getValue(renderer, w[0]);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.ChannelsListView
    @NotNull
    public Observable<Unit> getPaginationStream() {
        return (Observable) this.l.getValue();
    }

    @Override // com.avito.android.messenger.channels.mvi.view.ChannelsListView
    @NotNull
    public Observable<Unit> getScrollEvents() {
        return (Observable) this.m.getValue();
    }

    @Override // com.avito.android.messenger.channels.mvi.view.ChannelsListView
    @NotNull
    public Observable<Unit> getSwipeRefreshes() {
        return this.o;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.ChannelsListView
    public void onDestroyView() {
        Snackbar snackbar = this.i;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.b.removeOnScrollListener(this.u);
    }

    @Override // eu.davidea.flexibleadapter.FlexibleAdapter.OnItemClickListener
    public boolean onItemClick(int i2) {
        return false;
    }

    public void render(@NotNull ChannelsListState channelsListState) {
        Intrinsics.checkNotNullParameter(channelsListState, "state");
        ChannelsListView.DefaultImpls.render(this, channelsListState);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        this.b.scrollToPosition(0);
    }

    public void setLastRenderedState(@NotNull Renderer<ChannelsListState> renderer, @Nullable ChannelsListState channelsListState) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.q.setValue(renderer, w[0], channelsListState);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRender(@org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer<com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState> r6, @org.jetbrains.annotations.Nullable com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState r7, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState r8) {
        /*
        // Method dump skipped, instructions count: 409
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.view.ChannelsListViewImpl.doRender(com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer, com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState):void");
    }

    @Override // com.avito.android.messenger.channels.mvi.view.ChannelsListView
    @NotNull
    public PublishRelay<Unit> getOverlayRefreshClicks() {
        return this.n;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.ChannelsListView
    @NotNull
    public PublishRelay<Unit> getSnackbarRefreshClicks() {
        return this.p;
    }
}
