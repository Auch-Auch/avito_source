package com.avito.android.search.map.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler;
import com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandlerImpl;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.R;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.interactor.SerpDataSources;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.search.map.view.adapter.AppendingState;
import com.avito.android.search.map.view.adapter.GridAppendingRetryAdapter;
import com.avito.android.search.map.view.adapter.GridAppendingRetryHandler;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetItemDecorator;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.witcher.WitcherItemDecorator;
import com.avito.android.ui.adapter.GridPositionProvider;
import com.avito.android.util.Views;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010^\u001a\u000209\u0012\u000e\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0A\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010j\u001a\u00020g\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010p\u001a\u00020o\u0012\u0018\u0010s\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u00070q0R\u0012\u0018\u0010t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u00070q0R\u0012\u0018\u0010v\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020u0q0R\u0012\u0006\u0010x\u001a\u00020w\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\by\u0010zJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001f\u0010X\u001a\b\u0012\u0004\u0012\u00020S0R8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010;R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020)0c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006{"}, d2 = {"Lcom/avito/android/search/map/view/SerpListView;", "Lcom/avito/android/search/map/view/AdvertsListView;", "Lcom/avito/android/search/map/SearchMapState;", "newState", "", "render", "(Lcom/avito/android/search/map/SearchMapState;)V", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "", "error", "showError", "(Ljava/lang/String;)V", "destroy", "()V", "", "d", "F", "bottomSheetBackgroundGradientEdge", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "n", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/search/map/SearchMapState$SerpState;", "j", "Lcom/avito/android/search/map/SearchMapState$SerpState;", "state", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "h", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "scrollListener", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", VKApiConst.Q, "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourcesProvider", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "w", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "snippetScrollDepthTracker", "Landroid/widget/FrameLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", "serpContainer", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "t", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "s", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "tracker", "Landroidx/recyclerview/widget/GridLayoutManager;", a2.g.r.g.a, "Landroidx/recyclerview/widget/GridLayoutManager;", "gridLayoutManager", "Landroid/view/View;", "c", "Landroid/view/View;", "gradientView", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/avito/android/Features;", "u", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "i", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "itemsScrollListener", "Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "r", "Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "bottomSheetEventsProvider", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapViewAction;", "k", "Lio/reactivex/rxjava3/core/Observable;", "getActions", "()Lio/reactivex/rxjava3/core/Observable;", "actions", "Lcom/avito/android/search/map/view/AdvertsSheetClipper;", "e", "Lcom/avito/android/search/map/view/AdvertsSheetClipper;", "sheetClipper", "l", "view", "Lcom/avito/android/search/map/view/SerpDataSourcesChangeConsumer;", "o", "Lcom/avito/android/search/map/view/SerpDataSourcesChangeConsumer;", "dataSourceConsumer", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "f", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "p", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "snippetClickObservable", "snippetCloseObservable", "", "snippetVisibilityObservable", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "publishFloatingViewsProvider", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/ui/adapter/GridPositionProvider;Lcom/avito/android/search/map/view/SerpDataSourcesChangeConsumer;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;Lcom/avito/android/search/map/metric/SearchMapTracker;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/Features;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpListView implements AdvertsListView {
    public final RecyclerView a;
    public final FrameLayout b;
    public final View c;
    public float d;
    public final AdvertsSheetClipper e;
    public final BottomSheetBehavior<FrameLayout> f;
    public final GridLayoutManager g;
    public final RecyclerViewScrollHandler h;
    public final SnippetScrollDepthRecyclerViewScrollHandlerImpl i;
    public SearchMapState.SerpState j;
    @NotNull
    public final Observable<MapViewAction> k;
    public final View l;
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> m;
    public final GridPositionProvider n;
    public final SerpDataSourcesChangeConsumer o;
    public final AppendingRetryListener p;
    public final SerpListResourcesProvider q;
    public final BottomSheetBehaviourEventsProvider r;
    public final SearchMapTracker s;
    public final ItemVisibilityTracker t;
    public final Features u;
    public final RecyclerView.OnScrollListener v;
    public final SnippetScrollDepthTracker w;

    public static final class a<T, R> implements Function<MapViewAction.SerpPanelScrollStateChanged, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(MapViewAction.SerpPanelScrollStateChanged serpPanelScrollStateChanged) {
            return Boolean.valueOf(serpPanelScrollStateChanged.getCanBeShown());
        }
    }

    public static final class b<T, R> implements Function<Boolean, MapViewAction.ShortcutsVisibility> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ShortcutsVisibility apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return new MapViewAction.ShortcutsVisibility(bool2.booleanValue());
        }
    }

    public static final class c<T, R> implements Function<String, MapViewAction.SerpPanelStateChanged> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.SerpPanelStateChanged apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            return new MapViewAction.SerpPanelStateChanged(str2);
        }
    }

    public static final class d<T, R> implements Function<Float, MapViewAction.GradientVisibilityAction> {
        public final /* synthetic */ SerpListView a;

        public d(SerpListView serpListView) {
            this.a = serpListView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.GradientVisibilityAction apply(Float f) {
            Float f2 = f;
            SerpListView serpListView = this.a;
            Intrinsics.checkNotNullExpressionValue(f2, "it");
            SerpListView.access$renderGradientVisibility(serpListView, f2.floatValue());
            return MapViewAction.GradientVisibilityAction.INSTANCE;
        }
    }

    public static final class e<T, R> implements Function<Unit, MapViewAction.AppendSerp> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.AppendSerp apply(Unit unit) {
            return MapViewAction.AppendSerp.INSTANCE;
        }
    }

    public static final class f<T, R> implements Function<Unit, MapViewAction.RetryAppendSerp> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.RetryAppendSerp apply(Unit unit) {
            return MapViewAction.RetryAppendSerp.INSTANCE;
        }
    }

    public static final class g<T, R> implements Function<Pair<? extends SnippetItem, ? extends Integer>, MapViewAction.Snippet.Click> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.Snippet.Click apply(Pair<? extends SnippetItem, ? extends Integer> pair) {
            Pair<? extends SnippetItem, ? extends Integer> pair2 = pair;
            return new MapViewAction.Snippet.Click(((SnippetItem) pair2.getFirst()).getStringId(), ((SnippetItem) pair2.getFirst()).getAnalytics(), ((SnippetItem) pair2.getFirst()).getAction().getDeepLink(), ((Number) pair2.getSecond()).intValue(), ((SnippetItem) pair2.getFirst()).getAction().getClosesElement());
        }
    }

    public static final class h<T, R> implements Function<Pair<? extends SnippetItem, ? extends Integer>, MapViewAction.Snippet.Close> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.Snippet.Close apply(Pair<? extends SnippetItem, ? extends Integer> pair) {
            Pair<? extends SnippetItem, ? extends Integer> pair2 = pair;
            return new MapViewAction.Snippet.Close(((SnippetItem) pair2.getFirst()).getStringId(), ((SnippetItem) pair2.getFirst()).getAnalytics(), ((Number) pair2.getSecond()).intValue());
        }
    }

    public static final class i<T, R> implements Function<Pair<? extends SnippetItem, ? extends Boolean>, MapViewAction.Snippet.Visibility> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.Snippet.Visibility apply(Pair<? extends SnippetItem, ? extends Boolean> pair) {
            Pair<? extends SnippetItem, ? extends Boolean> pair2 = pair;
            return new MapViewAction.Snippet.Visibility(((SnippetItem) pair2.getFirst()).getStringId(), ((SnippetItem) pair2.getFirst()).getAnalytics(), ((Boolean) pair2.getSecond()).booleanValue());
        }
    }

    public static final class j extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ SerpListView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(SerpListView serpListView) {
            super(0);
            this.a = serpListView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            AppendingState[] appendingStateArr = {AppendingState.NONE, AppendingState.ERROR};
            SearchMapState.SerpState serpState = this.a.j;
            return Boolean.valueOf(!ArraysKt___ArraysKt.contains(appendingStateArr, serpState != null ? serpState.getAppendingState() : null));
        }
    }

    public static final class k<T, R> implements Function<Boolean, MapViewAction.SerpPanelScrollStateChanged> {
        public static final k a = new k();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.SerpPanelScrollStateChanged apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return new MapViewAction.SerpPanelScrollStateChanged(bool2.booleanValue());
        }
    }

    public SerpListView(@NotNull View view, @NotNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, @NotNull GridPositionProvider gridPositionProvider, @NotNull SerpDataSourcesChangeConsumer serpDataSourcesChangeConsumer, @NotNull AppendingRetryListener appendingRetryListener, @NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull Observable<Pair<SnippetItem, Integer>> observable, @NotNull Observable<Pair<SnippetItem, Integer>> observable2, @NotNull Observable<Pair<SnippetItem, Boolean>> observable3, @NotNull PublishFloatingViewsProvider publishFloatingViewsProvider, @NotNull BottomSheetBehaviourEventsProvider bottomSheetBehaviourEventsProvider, @NotNull SearchMapTracker searchMapTracker, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull Features features, @NotNull RecyclerView.OnScrollListener onScrollListener, @NotNull SnippetScrollDepthTracker snippetScrollDepthTracker) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(gridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(serpDataSourcesChangeConsumer, "dataSourceConsumer");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(observable, "snippetClickObservable");
        Intrinsics.checkNotNullParameter(observable2, "snippetCloseObservable");
        Intrinsics.checkNotNullParameter(observable3, "snippetVisibilityObservable");
        Intrinsics.checkNotNullParameter(publishFloatingViewsProvider, "publishFloatingViewsProvider");
        Intrinsics.checkNotNullParameter(bottomSheetBehaviourEventsProvider, "bottomSheetEventsProvider");
        Intrinsics.checkNotNullParameter(searchMapTracker, "tracker");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(onScrollListener, "fpsListener");
        Intrinsics.checkNotNullParameter(snippetScrollDepthTracker, "snippetScrollDepthTracker");
        this.l = view;
        this.m = adapter;
        this.n = gridPositionProvider;
        this.o = serpDataSourcesChangeConsumer;
        this.p = appendingRetryListener;
        this.q = serpListResourcesProvider;
        this.r = bottomSheetBehaviourEventsProvider;
        this.s = searchMapTracker;
        this.t = itemVisibilityTracker;
        this.u = features;
        this.v = onScrollListener;
        this.w = snippetScrollDepthTracker;
        View findViewById = view.findViewById(R.id.serp_items);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.serp_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.b = frameLayout;
        View findViewById3 = view.findViewById(R.id.view_gradient);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        AdvertsSheetClipperImpl advertsSheetClipperImpl = new AdvertsSheetClipperImpl();
        this.e = advertsSheetClipperImpl;
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
        from.setPeekHeight(SerpListResourcesProvider.DefaultImpls.getBottomSheetPeekHeight$default(serpListResourcesProvider, false, 1, null));
        from.setBottomSheetCallback(bottomSheetBehaviourEventsProvider);
        from.setHideable(true);
        Intrinsics.checkNotNullExpressionValue(from, "BottomSheetBehavior.from…Hideable = true\n        }");
        this.f = from;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), serpListResourcesProvider.getColumnsCount());
        this.g = gridLayoutManager;
        RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(publishFloatingViewsProvider, gridLayoutManager);
        this.h = recyclerViewScrollHandler;
        SnippetScrollDepthRecyclerViewScrollHandlerImpl snippetScrollDepthRecyclerViewScrollHandlerImpl = new SnippetScrollDepthRecyclerViewScrollHandlerImpl(new SnippetScrollDepthRecyclerViewScrollHandler.Listener(this) { // from class: com.avito.android.search.map.view.SerpListView$itemsScrollListener$1
            public final /* synthetic */ SerpListView a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler.Listener
            public void onVisibleItemChanged(int i2) {
                this.a.w.onUserScrollToNewItem(i2);
            }
        }, gridLayoutManager);
        this.i = snippetScrollDepthRecyclerViewScrollHandlerImpl;
        from.setState(5);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(recyclerViewScrollHandler);
        recyclerView.addOnScrollListener(onScrollListener);
        if (features.getSnippetScrollDepthListener().invoke().booleanValue()) {
            recyclerView.addOnScrollListener(snippetScrollDepthRecyclerViewScrollHandlerImpl);
        }
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recycler.context");
        recyclerView.addItemDecoration(new RichSnippetItemDecorator(context, true));
        advertsSheetClipperImpl.clip(recyclerView, frameLayout);
        Resources resources = recyclerView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        recyclerView.addItemDecoration(new WitcherItemDecorator(resources));
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        bottomSheetBehaviourEventsProvider.panelSlideOffsetChanges().filter(a2.a.a.k2.b.h.b.a).map(a2.a.a.k2.b.h.c.a).distinctUntilChanged().subscribe(new a2.a.a.k2.b.h.d(this));
        this.d = serpListResourcesProvider.getGradientOffset();
        Observable<MapViewAction> merge = Observable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Observable[]{bottomSheetBehaviourEventsProvider.panelStateChanges().map(c.a), bottomSheetBehaviourEventsProvider.panelSlideOffsetChanges().map(new d(this)), appendingRetryListener.appendEvents().map(e.a), appendingRetryListener.retryEvents().map(f.a), observable.map(g.a), observable2.map(h.a), observable3.map(i.a), new ScrollChangesObservable(new j(this)).scrollObservable(recyclerView, gridLayoutManager).map(k.a).distinctUntilChanged(a.a), publishFloatingViewsProvider.visibilityChanges().map(b.a)}));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(listOf(…lity(it)\n        }\n    ))");
        this.k = merge;
    }

    public static final void access$renderGradientVisibility(SerpListView serpListView, float f2) {
        Views.setVisible(serpListView.c, f2 >= serpListView.d);
    }

    public final void destroy() {
        this.a.removeOnScrollListener(this.v);
        if (this.u.getSnippetScrollDepthListener().invoke().booleanValue()) {
            this.a.removeOnScrollListener(this.i);
        }
    }

    @NotNull
    public final Observable<MapViewAction> getActions() {
        return this.k;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        this.m.notifyItemChanged(i2);
    }

    public final void render(@NotNull SearchMapState searchMapState) {
        RecyclerView.LayoutManager layoutManager;
        int i2;
        Intrinsics.checkNotNullParameter(searchMapState, "newState");
        SearchMapState.SerpState serpState = this.j;
        SearchMapState.SerpState serpState2 = searchMapState.getSerpState();
        if ((serpState != null ? serpState.getDisplayType() : null) != serpState2.getDisplayType() || Intrinsics.areEqual(serpState2.getPanelState(), PanelStateKt.PANEL_HIDDEN) || Intrinsics.areEqual(serpState2.getPanelState(), PanelStateKt.PANEL_EXPANDED)) {
            this.f.setPeekHeight(SerpListResourcesProvider.DefaultImpls.getBottomSheetPeekHeight$default(this.q, false, 1, null));
        }
        if (serpState == null || (!Intrinsics.areEqual(serpState.getPanelState(), serpState2.getPanelState()))) {
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f;
            String panelState = serpState2.getPanelState();
            int hashCode = panelState.hashCode();
            if (hashCode != -1939100487) {
                if (hashCode == 1880183383 && panelState.equals(PanelStateKt.PANEL_COLLAPSED)) {
                    i2 = 4;
                    bottomSheetBehavior.setState(i2);
                }
            } else if (panelState.equals(PanelStateKt.PANEL_EXPANDED)) {
                i2 = 3;
                bottomSheetBehavior.setState(i2);
            }
            i2 = 5;
            bottomSheetBehavior.setState(i2);
        }
        SearchMapState.SerpState serpState3 = searchMapState.getSerpState();
        boolean z = (serpState != null ? serpState.getAppendingState() : null) != serpState3.getAppendingState();
        boolean z2 = !Intrinsics.areEqual(serpState != null ? serpState.getDataSources() : null, serpState3.getDataSources());
        if (z || z2) {
            this.p.setAppendingState(serpState3.getAppendingState());
            SerpDataSources dataSources = serpState3.getDataSources();
            if (dataSources != null) {
                int columnsCount = this.q.getColumnsCount(SerpDisplayTypeKt.orDefault(serpState3.getDisplayType()));
                this.g.setSpanCount(columnsCount);
                this.o.dataSourcesChanged(dataSources.getSpans(), dataSources.getSerpItems(), columnsCount);
                if (this.a.getAdapter() == null) {
                    this.a.setAdapter(new GridAppendingRetryAdapter(this.m, new GridAppendingRetryHandler(this.p, this.n), this.p));
                    if (this.u.getViewVisibilityTrackingInSerp().invoke().booleanValue()) {
                        ItemVisibilityTracker.DefaultImpls.subscribe$default(this.t, this.a, null, 2, null);
                    }
                } else {
                    RecyclerView.Adapter adapter = this.a.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
            this.s.trackSerpDraw();
        }
        if (serpState3.getSerpPaddingTop() != (serpState != null ? serpState.getSerpPaddingTop() : 0)) {
            Views.changePadding$default(this.a, 0, serpState3.getSerpPaddingTop(), 0, 0, 13, null);
            this.e.invalidate();
            if (serpState != null) {
                this.a.scrollToPosition(0);
            }
        }
        if (serpState != null && (!Intrinsics.areEqual(serpState.getPanelState(), serpState3.getPanelState())) && Intrinsics.areEqual(serpState3.getPanelState(), PanelStateKt.PANEL_COLLAPSED) && (layoutManager = this.a.getLayoutManager()) != null) {
            layoutManager.scrollToPosition(0);
        }
        this.j = searchMapState.getSerpState();
    }

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.l, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
