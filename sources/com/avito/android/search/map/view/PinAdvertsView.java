package com.avito.android.search.map.view;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.LoadState;
import com.avito.android.search.map.R;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import com.avito.android.search.map.view.AdvertsSheetClipper;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.search.map.view.adapter.GridAppendingRetryAdapter;
import com.avito.android.search.map.view.adapter.GridAppendingRetryHandler;
import com.avito.android.serp.adapter.SellerPinItemDecorator;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetItemDecorator;
import com.avito.android.ui.adapter.GridPositionProvider;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u000e\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0E\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0016R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010<R\u0018\u0010\u0003\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006V"}, d2 = {"Lcom/avito/android/search/map/view/PinAdvertsView;", "Lcom/avito/android/search/map/view/AdvertsListView;", "Lcom/avito/android/search/map/SearchMapState;", "state", "", "render", "(Lcom/avito/android/search/map/SearchMapState;)V", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "", "error", "showError", "(Ljava/lang/String;)V", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "animate", AuthSource.SEND_ABUSE, "(ZZ)V", "Landroid/view/View;", "j", "Landroid/view/View;", "view", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapViewAction;", "i", "Lio/reactivex/rxjava3/core/Observable;", "getActions", "()Lio/reactivex/rxjava3/core/Observable;", "actions", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "o", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourcesProvider", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "d", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "l", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "gridPositionProvider", "e", "backToMapButton", AuthSource.BOOKING_ORDER, "sheet", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "n", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "Landroidx/recyclerview/widget/GridLayoutManager;", "c", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/avito/android/search/map/view/ScrollChangesObservable;", "f", "Lcom/avito/android/search/map/view/ScrollChangesObservable;", "scrollChangesObservable", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", g.a, "Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", "Lcom/avito/android/search/map/view/ItemDataSourceChangeConsumer;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/search/map/view/ItemDataSourceChangeConsumer;", "dataSourceConsumer", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "k", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "h", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "scrollListener", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "publishFloatingViewsProvider", "Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "bottomSheetEventsProvider", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/ui/adapter/GridPositionProvider;Lcom/avito/android/search/map/view/ItemDataSourceChangeConsumer;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class PinAdvertsView implements AdvertsListView {
    public RecyclerView a;
    public View b;
    public final GridLayoutManager c;
    public final BottomSheetBehavior<View> d;
    public final View e;
    public final ScrollChangesObservable f;
    public SearchMapState.PinAdvertsState g;
    public final RecyclerViewScrollHandler h;
    @NotNull
    public final Observable<MapViewAction> i;
    public final View j;
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> k;
    public final GridPositionProvider l;
    public final ItemDataSourceChangeConsumer m;
    public final AppendingRetryListener n;
    public final SerpListResourcesProvider o;

    public static final class a<T, R> implements Function<Unit, MapViewAction.AppendPinAdverts> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.AppendPinAdverts apply(Unit unit) {
            return MapViewAction.AppendPinAdverts.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<Unit, MapViewAction.RetryAppendPinAdverts> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.RetryAppendPinAdverts apply(Unit unit) {
            return MapViewAction.RetryAppendPinAdverts.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<String, MapViewAction.PinAdvertsPanelStateChanged> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.PinAdvertsPanelStateChanged apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            return new MapViewAction.PinAdvertsPanelStateChanged(str2);
        }
    }

    public static final class d<T, R> implements Function<Unit, MapViewAction.PinAdvertsPanelStateChanged> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.PinAdvertsPanelStateChanged apply(Unit unit) {
            return new MapViewAction.PinAdvertsPanelStateChanged(PanelStateKt.PANEL_COLLAPSED);
        }
    }

    public static final class e<T, R> implements Function<Boolean, MapViewAction.PinAdvertsPanelScrollStateChanged> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.PinAdvertsPanelScrollStateChanged apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return new MapViewAction.PinAdvertsPanelScrollStateChanged(bool2.booleanValue());
        }
    }

    public static final class f<T, R> implements Function<Boolean, MapViewAction.ShortcutsVisibility> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ShortcutsVisibility apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return new MapViewAction.ShortcutsVisibility(bool2.booleanValue());
        }
    }

    public PinAdvertsView(@NotNull View view, @NotNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, @NotNull GridPositionProvider gridPositionProvider, @NotNull ItemDataSourceChangeConsumer itemDataSourceChangeConsumer, @NotNull AppendingRetryListener appendingRetryListener, @NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull PublishFloatingViewsProvider publishFloatingViewsProvider, @NotNull BottomSheetBehaviourEventsProvider bottomSheetBehaviourEventsProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(gridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(itemDataSourceChangeConsumer, "dataSourceConsumer");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(publishFloatingViewsProvider, "publishFloatingViewsProvider");
        Intrinsics.checkNotNullParameter(bottomSheetBehaviourEventsProvider, "bottomSheetEventsProvider");
        this.j = view;
        this.k = adapter;
        this.l = gridPositionProvider;
        this.m = itemDataSourceChangeConsumer;
        this.n = appendingRetryListener;
        this.o = serpListResourcesProvider;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), serpListResourcesProvider.getColumnsCountForList());
        this.c = gridLayoutManager;
        View findViewById = view.findViewById(R.id.back_to_map_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById;
        ScrollChangesObservable scrollChangesObservable = new ScrollChangesObservable(null, 1, null);
        this.f = scrollChangesObservable;
        RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(publishFloatingViewsProvider, gridLayoutManager);
        this.h = recyclerViewScrollHandler;
        View findViewById2 = view.findViewById(R.id.pin_items);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.a = recyclerView;
        this.b = recyclerView;
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(recyclerView);
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from(sheet)");
        this.d = from;
        from.setState(5);
        from.setBottomSheetCallback(bottomSheetBehaviourEventsProvider);
        from.setPeekHeight(serpListResourcesProvider.getBottomSheetPeekHeight(false));
        this.a.setItemAnimator(null);
        this.a.setLayoutManager(gridLayoutManager);
        this.a.addOnScrollListener(recyclerViewScrollHandler);
        RecyclerView recyclerView2 = this.a;
        Context context = recyclerView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
        recyclerView2.addItemDecoration(new RichSnippetItemDecorator(context, true));
        RecyclerView recyclerView3 = this.a;
        Context context2 = recyclerView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "recycler.context");
        recyclerView3.addItemDecoration(new SellerPinItemDecorator(context2));
        AdvertsSheetClipper.DefaultImpls.clip$default(new AdvertsSheetClipperImpl(), this.a, null, 2, null);
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        a(false, false);
        Observable<MapViewAction> merge = Observable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Observable[]{appendingRetryListener.appendEvents().map(a.a), appendingRetryListener.retryEvents().map(b.a), bottomSheetBehaviourEventsProvider.panelStateChanges().map(c.a), RxView.clicks(findViewById).map(d.a), scrollChangesObservable.scrollObservable(this.a, gridLayoutManager).map(e.a), publishFloatingViewsProvider.visibilityChanges().map(f.a)}));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(listOf(…lity(it)\n        }\n    ))");
        this.i = merge;
    }

    public final void a(boolean z, boolean z2) {
        int i2;
        if (z) {
            i2 = 0;
        } else {
            Context context = this.e.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "backToMapButton.context");
            i2 = Contexts.getDisplayHeight(context) - this.e.getTop();
        }
        this.e.animate().translationY((float) i2).setDuration(z2 ? 300 : 0).start();
    }

    @NotNull
    public final Observable<MapViewAction> getActions() {
        return this.i;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        this.k.notifyItemChanged(i2);
    }

    public final void render(@NotNull SearchMapState searchMapState) {
        int i2;
        Intrinsics.checkNotNullParameter(searchMapState, "state");
        SearchMapState.PinAdvertsState pinAdvertsState = this.g;
        SearchMapState.PinAdvertsState pinAdvertsState2 = searchMapState.getPinAdvertsState();
        boolean showSimpleMap = searchMapState.getShowSimpleMap();
        LoadState loadState = pinAdvertsState2.getLoadState();
        LoadState loadState2 = LoadState.ERROR;
        boolean z = true;
        if (loadState == loadState2) {
            this.d.setState(5);
        } else {
            if (Intrinsics.areEqual(pinAdvertsState2.getPanelState(), PanelStateKt.PANEL_COLLAPSED)) {
                this.d.setPeekHeight(this.o.getBottomSheetPeekHeight(false));
            }
            if (pinAdvertsState == null || (!Intrinsics.areEqual(pinAdvertsState.getPanelState(), pinAdvertsState2.getPanelState()))) {
                BottomSheetBehavior<View> bottomSheetBehavior = this.d;
                String panelState = pinAdvertsState2.getPanelState();
                int hashCode = panelState.hashCode();
                if (hashCode != -1939100487) {
                    if (hashCode == 1880183383 && panelState.equals(PanelStateKt.PANEL_COLLAPSED)) {
                        if (showSimpleMap) {
                            this.a.setMinimumHeight(this.o.getMinHeightForPinAdverts());
                        }
                        i2 = 4;
                        bottomSheetBehavior.setState(i2);
                    }
                } else if (panelState.equals(PanelStateKt.PANEL_EXPANDED)) {
                    i2 = 3;
                    bottomSheetBehavior.setState(i2);
                }
                if (showSimpleMap) {
                    this.a.setMinimumHeight(this.o.getMinHeightForPinAdverts());
                }
                i2 = this.d.getState();
                bottomSheetBehavior.setState(i2);
            }
        }
        SearchMapState.PinAdvertsState pinAdvertsState3 = searchMapState.getPinAdvertsState();
        if (pinAdvertsState == null || pinAdvertsState.getBackToMapVisible() != pinAdvertsState3.getBackToMapVisible()) {
            a(pinAdvertsState3.getBackToMapVisible(), true);
        }
        SearchMapState.PinAdvertsState pinAdvertsState4 = searchMapState.getPinAdvertsState();
        if (pinAdvertsState == null || pinAdvertsState.getAppendingState() != pinAdvertsState4.getAppendingState() || (!Intrinsics.areEqual(pinAdvertsState.getAdverts(), pinAdvertsState4.getAdverts()))) {
            this.n.setAppendingState(pinAdvertsState4.getAppendingState());
            List<ViewTypeSerpItem> adverts = pinAdvertsState4.getAdverts();
            if (adverts == null) {
                adverts = CollectionsKt__CollectionsKt.emptyList();
            }
            int columnsCountForList = this.o.getColumnsCountForList();
            this.c.setSpanCount(columnsCountForList);
            this.m.dataSourceChanged(new ListDataSource(adverts), columnsCountForList);
            if (adverts.isEmpty() && pinAdvertsState4.getMoveBetweenPins()) {
                if (pinAdvertsState4.getLoadState() == loadState2) {
                    RecyclerView.Adapter adapter = this.a.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
                this.e.setVisibility(4);
                this.g = searchMapState.getPinAdvertsState();
            } else if (this.a.getAdapter() == null) {
                this.a.setAdapter(new GridAppendingRetryAdapter(this.k, new GridAppendingRetryHandler(this.n, this.l), this.n));
            } else {
                RecyclerView.Adapter adapter2 = this.a.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyDataSetChanged();
                }
            }
        }
        boolean z2 = pinAdvertsState == null || (Intrinsics.areEqual(pinAdvertsState.getPanelState(), PanelStateKt.PANEL_COLLAPSED) ^ true);
        RecyclerView.Adapter adapter3 = this.a.getAdapter();
        int itemCount = adapter3 != null ? adapter3.getItemCount() : 0;
        if (!Intrinsics.areEqual(pinAdvertsState4.getPanelState(), PanelStateKt.PANEL_COLLAPSED) || itemCount <= 0) {
            z = false;
        }
        if (z2 && z) {
            this.a.scrollToPosition(0);
        }
        this.e.setVisibility(4);
        this.g = searchMapState.getPinAdvertsState();
    }

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.j, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
