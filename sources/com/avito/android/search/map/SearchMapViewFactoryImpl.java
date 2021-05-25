package com.avito.android.search.map;

import a2.g.r.g;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.ab_tests.RealtyNewBackNavigation;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.di.module.SnippetClose;
import com.avito.android.di.module.SnippetVisibility;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.di.PinAdvertsBottomSheetEventsProvider;
import com.avito.android.search.map.di.PinAdvertsList;
import com.avito.android.search.map.di.PublishFloatingViews;
import com.avito.android.search.map.di.SerpBottomSheetEventsProvider;
import com.avito.android.search.map.di.SerpList;
import com.avito.android.search.map.interactor.MapAreaConverter;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import com.avito.android.search.map.view.MapAsyncProviderImpl;
import com.avito.android.search.map.view.MapInteractorImpl;
import com.avito.android.search.map.view.MarkerIconFactory;
import com.avito.android.search.map.view.PinAdvertsListViewBinder;
import com.avito.android.search.map.view.PinAdvertsView;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.SerpListView;
import com.avito.android.search.map.view.SerpListViewBinder;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bø\u0002\b\u0007\u0012\u0007\u0010\u0001\u001a\u00020\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0016\u0012\t\b\u0001\u0010\u0001\u001a\u00020J\u0012\b\b\u0001\u0010<\u001a\u000209\u0012\t\b\u0001\u0010\u0001\u001a\u00020`\u0012\u0006\u0010'\u001a\u00020$\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0001\u0010M\u001a\u00020J\u0012\b\b\u0001\u0010r\u001a\u000209\u0012\b\b\u0001\u0010c\u001a\u00020`\u0012\b\b\u0001\u0010#\u001a\u00020 \u0012\u0006\u0010v\u001a\u00020s\u0012\u0006\u0010g\u001a\u00020d\u0012\u001a\b\u0001\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030100\u0012\u001a\b\u0001\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030100\u0012\u001a\b\u0001\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020E0100\u0012\b\b\u0001\u0010Q\u001a\u00020N\u0012\b\b\u0001\u0010/\u001a\u00020,\u0012\b\b\u0001\u0010I\u001a\u00020,\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010z\u001a\u00020w\u0012\u0006\u0010k\u001a\u00020h\u0012\u0006\u0010Y\u001a\u00020V\u0012\u000e\b\u0001\u0010p\u001a\b\u0012\u0004\u0012\u00020m0l\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0001\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010~\u001a\u00020{¢\u0006\u0006\b\u0001\u0010\u0001J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R(\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR(\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020E01008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u00105R\u0016\u0010I\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010.R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR(\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u00105R\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020m0l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010;R\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0001\u001a\u000208\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010LR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010b¨\u0006\u0001"}, d2 = {"Lcom/avito/android/search/map/SearchMapViewFactoryImpl;", "Lcom/avito/android/search/map/SearchMapViewFactory;", "Landroid/view/View;", "view", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lio/reactivex/rxjava3/core/Observable;", "", "backClickObservable", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/search/map/SearchMapView;", "createView", "(Landroid/view/View;Landroidx/fragment/app/FragmentManager;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/Features;)Lcom/avito/android/search/map/SearchMapView;", "Lcom/avito/android/search/map/view/PinAdvertsView;", "createPinAdvertsView", "(Landroid/view/View;)Lcom/avito/android/search/map/view/PinAdvertsView;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Lcom/avito/android/search/map/view/SerpListView;", "createSerpListView", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)Lcom/avito/android/search/map/view/SerpListView;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "k", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "serpListAdapter", "f", "pinAdvertsAdapter", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "e", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "pinAdvertsListViewBinder", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "o", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "listItemVisibilityTracker", "Lcom/avito/android/search/map/view/SerpListViewBinder;", "j", "Lcom/avito/android/search/map/view/SerpListViewBinder;", "serpListViewBinder", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "y", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", VKApiConst.VERSION, "Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "serpBottomSheetBehaviourProvider", "Lcom/jakewharton/rxrelay3/Relay;", "Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "", "s", "Lcom/jakewharton/rxrelay3/Relay;", "snippetCloseObservable", "D", "Lcom/avito/android/Features;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "h", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "pinGridPositionProvider", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "x", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "mapTracker", "Lcom/avito/android/component/search/SuggestInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/component/search/SuggestInteractor;", "suggestInteractor", "", "t", "snippetVisibilityObservable", "w", "pinAdvertsBottomSheetEventsProvider", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "l", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "serpSpanLookup", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "u", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "publishFloatingViewsProvider", "Lcom/avito/android/search/map/view/MarkerIconFactory;", "c", "Lcom/avito/android/search/map/view/MarkerIconFactory;", "iconFactory", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "B", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchesPresenter", "r", "snippetClickObservable", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "n", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "serpAppendingRetryListener", "Lcom/avito/android/search/map/interactor/MapAreaConverter;", VKApiConst.Q, "Lcom/avito/android/search/map/interactor/MapAreaConverter;", "mapAreaConverter", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "inlineFiltersDialogFactory", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "C", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "backNavigationTestGroup", AuthSource.OPEN_CHANNEL_LIST, "serpGridPositionProvider", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "p", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourcesProvider", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "z", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "inlineFiltersPresenter", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "F", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "snippetScrollDepthTracker", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", g.a, "pinSpanLookup", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "pinAdvertsFavoritePresenter", "i", "pinAppendingRetryListener", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "prefetchTestGroup", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/component/search/SuggestInteractor;Lcom/avito/android/search/map/view/MarkerIconFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/search/map/view/SerpListViewBinder;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Lcom/avito/android/search/map/interactor/MapAreaConverter;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;Lcom/avito/android/search/map/metric/SearchMapTracker;Lcom/avito/android/avito_map/AvitoMapAttachHelper;Lcom/avito/android/inline_filters/InlineFiltersPresenter;Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;Lcom/avito/android/saved_searches/SavedSearchesPresenter;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;Lcom/avito/android/Features;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapViewFactoryImpl implements SearchMapViewFactory {
    public final InlineFilterDialogFactory A;
    public final SavedSearchesPresenter B;
    public final ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> C;
    public final Features D;
    public final FavoriteAdvertsPresenter E;
    public final SnippetScrollDepthTracker F;
    public final SchedulersFactory3 a;
    public final SuggestInteractor b;
    public final MarkerIconFactory c;
    public final Analytics d;
    public final PinAdvertsListViewBinder e;
    public final SimpleRecyclerAdapter f;
    public final GridLayoutManager.SpanSizeLookup g;
    public final SpannedGridPositionProvider h;
    public final AppendingRetryListener i;
    public final SerpListViewBinder j;
    public final SimpleRecyclerAdapter k;
    public final GridLayoutManager.SpanSizeLookup l;
    public final SpannedGridPositionProvider m;
    public final AppendingRetryListener n;
    public final ItemVisibilityTracker o;
    public final SerpListResourcesProvider p;
    public final MapAreaConverter q;
    public final Relay<Pair<SnippetItem, Integer>> r;
    public final Relay<Pair<SnippetItem, Integer>> s;
    public final Relay<Pair<SnippetItem, Boolean>> t;
    public final PublishFloatingViewsProvider u;
    public final BottomSheetBehaviourEventsProvider v;
    public final BottomSheetBehaviourEventsProvider w;
    public final SearchMapTracker x;
    public final AvitoMapAttachHelper y;
    public final InlineFiltersPresenter z;

    @Inject
    public SearchMapViewFactoryImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull SuggestInteractor suggestInteractor, @NotNull MarkerIconFactory markerIconFactory, @NotNull Analytics analytics, @NotNull PinAdvertsListViewBinder pinAdvertsListViewBinder, @PinAdvertsList @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @PinAdvertsList @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @PinAdvertsList @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @PinAdvertsList @NotNull AppendingRetryListener appendingRetryListener, @NotNull SerpListViewBinder serpListViewBinder, @SerpList @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter2, @SerpList @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2, @SerpList @NotNull SpannedGridPositionProvider spannedGridPositionProvider2, @SerpList @NotNull AppendingRetryListener appendingRetryListener2, @SerpList @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull MapAreaConverter mapAreaConverter, @SnippetClick @NotNull Relay<Pair<SnippetItem, Integer>> relay, @SnippetClose @NotNull Relay<Pair<SnippetItem, Integer>> relay2, @SnippetVisibility @NotNull Relay<Pair<SnippetItem, Boolean>> relay3, @PublishFloatingViews @NotNull PublishFloatingViewsProvider publishFloatingViewsProvider, @SerpBottomSheetEventsProvider @NotNull BottomSheetBehaviourEventsProvider bottomSheetBehaviourEventsProvider, @PinAdvertsBottomSheetEventsProvider @NotNull BottomSheetBehaviourEventsProvider bottomSheetBehaviourEventsProvider2, @NotNull SearchMapTracker searchMapTracker, @NotNull AvitoMapAttachHelper avitoMapAttachHelper, @NotNull InlineFiltersPresenter inlineFiltersPresenter, @NotNull InlineFilterDialogFactory inlineFilterDialogFactory, @NotNull SavedSearchesPresenter savedSearchesPresenter, @RealtyNewBackNavigation @NotNull ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup, @NotNull SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup, @NotNull Features features, @PinAdvertsList @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SnippetScrollDepthTracker snippetScrollDepthTracker) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(suggestInteractor, "suggestInteractor");
        Intrinsics.checkNotNullParameter(markerIconFactory, "iconFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(pinAdvertsListViewBinder, "pinAdvertsListViewBinder");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "pinAdvertsAdapter");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "pinSpanLookup");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "pinGridPositionProvider");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "pinAppendingRetryListener");
        Intrinsics.checkNotNullParameter(serpListViewBinder, "serpListViewBinder");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter2, "serpListAdapter");
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "serpSpanLookup");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider2, "serpGridPositionProvider");
        Intrinsics.checkNotNullParameter(appendingRetryListener2, "serpAppendingRetryListener");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "listItemVisibilityTracker");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(mapAreaConverter, "mapAreaConverter");
        Intrinsics.checkNotNullParameter(relay, "snippetClickObservable");
        Intrinsics.checkNotNullParameter(relay2, "snippetCloseObservable");
        Intrinsics.checkNotNullParameter(relay3, "snippetVisibilityObservable");
        Intrinsics.checkNotNullParameter(publishFloatingViewsProvider, "publishFloatingViewsProvider");
        Intrinsics.checkNotNullParameter(bottomSheetBehaviourEventsProvider, "serpBottomSheetBehaviourProvider");
        Intrinsics.checkNotNullParameter(bottomSheetBehaviourEventsProvider2, "pinAdvertsBottomSheetEventsProvider");
        Intrinsics.checkNotNullParameter(searchMapTracker, "mapTracker");
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "mapAttachHelper");
        Intrinsics.checkNotNullParameter(inlineFiltersPresenter, "inlineFiltersPresenter");
        Intrinsics.checkNotNullParameter(inlineFilterDialogFactory, "inlineFiltersDialogFactory");
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "savedSearchesPresenter");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "backNavigationTestGroup");
        Intrinsics.checkNotNullParameter(serpItemsPrefetchTestGroup, "prefetchTestGroup");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "pinAdvertsFavoritePresenter");
        Intrinsics.checkNotNullParameter(snippetScrollDepthTracker, "snippetScrollDepthTracker");
        this.a = schedulersFactory3;
        this.b = suggestInteractor;
        this.c = markerIconFactory;
        this.d = analytics;
        this.e = pinAdvertsListViewBinder;
        this.f = simpleRecyclerAdapter;
        this.g = spanSizeLookup;
        this.h = spannedGridPositionProvider;
        this.i = appendingRetryListener;
        this.j = serpListViewBinder;
        this.k = simpleRecyclerAdapter2;
        this.l = spanSizeLookup2;
        this.m = spannedGridPositionProvider2;
        this.n = appendingRetryListener2;
        this.o = itemVisibilityTracker;
        this.p = serpListResourcesProvider;
        this.q = mapAreaConverter;
        this.r = relay;
        this.s = relay2;
        this.t = relay3;
        this.u = publishFloatingViewsProvider;
        this.v = bottomSheetBehaviourEventsProvider;
        this.w = bottomSheetBehaviourEventsProvider2;
        this.x = searchMapTracker;
        this.y = avitoMapAttachHelper;
        this.z = inlineFiltersPresenter;
        this.A = inlineFilterDialogFactory;
        this.B = savedSearchesPresenter;
        this.C = manuallyExposedAbTestGroup;
        this.D = features;
        this.E = favoriteAdvertsPresenter;
        this.F = snippetScrollDepthTracker;
    }

    @Override // com.avito.android.search.map.SearchMapViewFactory
    @NotNull
    public PinAdvertsView createPinAdvertsView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new PinAdvertsView(view, this.f, this.h, this.e, this.i, this.p, this.g, this.u, this.w);
    }

    @Override // com.avito.android.search.map.SearchMapViewFactory
    @NotNull
    public SerpListView createSerpListView(@NotNull View view, @NotNull RecyclerView.OnScrollListener onScrollListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onScrollListener, "fpsListener");
        return new SerpListView(view, this.k, this.m, this.j, this.n, this.p, this.l, this.r, this.s, this.t, this.u, this.v, this.x, this.o, this.D, onScrollListener, this.F);
    }

    @Override // com.avito.android.search.map.SearchMapViewFactory
    @NotNull
    public SearchMapView createView(@NotNull View view, @NotNull FragmentManager fragmentManager, @NotNull Observable<Unit> observable, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(observable, "backClickObservable");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SearchMapViewImpl(view, new MapInteractorImpl(this.c, this.q, this.x, new MapAsyncProviderImpl(this.y, R.id.map, view, fragmentManager)), observable, this.d, this.a, this.b, this.x, this.o, this.z, this.B, this.E, this.A, this.C, this.p, features);
    }
}
