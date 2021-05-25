package com.avito.android.search.map.reducer;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.di.PerFragment;
import com.avito.android.redux.Reducer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.Result;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.LoadState;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.SearchParamsChangedAction;
import com.avito.android.search.map.action.StartAction;
import com.avito.android.search.map.utils.LatLngBoundsKt;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.util.Collections;
import com.avito.android.util.LoadingState;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/map/reducer/LoadReducer;", "Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "state", "action", "reduce", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/action/MapAction;)Lcom/avito/android/search/map/SearchMapState;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", AuthSource.BOOKING_ORDER, "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "shortcutNavigationItemConverter", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/search/map/view/SerpListResourcesProvider;Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class LoadReducer implements Reducer<SearchMapState, MapAction> {
    public final SerpListResourcesProvider a;
    public final ShortcutNavigationItemConverter b;

    @Inject
    public LoadReducer(@NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull ShortcutNavigationItemConverter shortcutNavigationItemConverter) {
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(shortcutNavigationItemConverter, "shortcutNavigationItemConverter");
        this.a = serpListResourcesProvider;
        this.b = shortcutNavigationItemConverter;
    }

    @NotNull
    public SearchMapState reduce(@NotNull SearchMapState searchMapState, @NotNull MapAction mapAction) {
        SearchMapState searchMapState2;
        List<Filter> filters;
        Intrinsics.checkNotNullParameter(searchMapState, "state");
        Intrinsics.checkNotNullParameter(mapAction, "action");
        if ((mapAction instanceof StartAction) || (mapAction instanceof MapViewAction.RefreshClicked)) {
            return ((searchMapState.getMapState().getMarkerItems() == null || searchMapState.getInlineFilters() == null) && Intrinsics.areEqual(searchMapState.getSerpState().getPanelState(), PanelStateKt.PANEL_HIDDEN)) ? SearchMapState.copy$default(searchMapState, null, null, null, null, null, SearchMapState.SerpState.copy$default(searchMapState.getSerpState(), LoadState.LOAD, null, true, null, null, null, PanelStateKt.PANEL_HIDDEN, 0, null, null, false, null, false, 0, 0, false, null, null, null, 524218, null), null, false, false, 479, null) : searchMapState;
        }
        if (mapAction instanceof LoadAction.LoadInlineFilters) {
            LoadAction.LoadInlineFilters loadInlineFilters = (LoadAction.LoadInlineFilters) mapAction;
            if (loadInlineFilters.getState() instanceof LoadingState.Loaded) {
                List<ShortcutNavigationItem> convert = this.b.convert((InlineFilters) ((LoadingState.Loaded) loadInlineFilters.getState()).getData());
                InlineFilters inlineFilters = (InlineFilters) ((LoadingState.Loaded) loadInlineFilters.getState()).getData();
                SearchMapState.SerpState serpState = searchMapState.getSerpState();
                SerpListResourcesProvider serpListResourcesProvider = this.a;
                Result result = ((InlineFilters) ((LoadingState.Loaded) loadInlineFilters.getState()).getData()).getResult();
                return SearchMapState.copy$default(searchMapState, inlineFilters, convert, null, null, null, SearchMapState.SerpState.copy$default(serpState, null, null, false, null, null, null, null, 0, null, null, false, null, false, 0, serpListResourcesProvider.getSerpPaddingTop((result == null || (filters = result.getFilters()) == null || Collections.isNullOrEmpty(filters)) ? false : true), false, null, null, null, 507903, null), null, false, false, 476, null);
            }
        } else if (mapAction instanceof SearchParamsChangedAction) {
            DeepLink deepLink = ((SearchParamsChangedAction) mapAction).getDeepLink();
            if (deepLink instanceof ItemsSearchLink) {
                ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
                if (itemsSearchLink.getShowMap() || itemsSearchLink.getShowSimpleMap()) {
                    String mapSerpState = itemsSearchLink.getMapSerpState();
                    if (mapSerpState == null) {
                        mapSerpState = "none";
                    }
                    boolean z = !Intrinsics.areEqual(mapSerpState, PanelStateKt.PANEL_HIDDEN);
                    Area searchArea = itemsSearchLink.getSearchArea();
                    SearchParams searchParams = itemsSearchLink.getSearchParams();
                    String query = itemsSearchLink.getSearchParams().getQuery();
                    LoadState loadState = z ? LoadState.NONE : LoadState.LOAD;
                    boolean z2 = !z;
                    SerpDisplayType displayType = itemsSearchLink.getSearchParams().getDisplayType();
                    if (displayType == null) {
                        displayType = searchMapState.getSerpState().getDisplayType();
                    }
                    searchMapState2 = new SearchMapState(null, null, searchParams, query, new SearchMapState.MapState(null, searchArea != null ? LatLngBoundsKt.toLatLngBounds(searchArea) : null, null, false, null, null, searchMapState.getMapState().isMapReady(), null, searchMapState.getMapState().getMyLocation(), null, null, false, false, false, null, false, searchMapState.getMapState().isMapVisible(), false, null, 458429, null), new SearchMapState.SerpState(loadState, null, z2, null, displayType, null, mapSerpState, 0, searchArea, null, false, null, false, this.a.getColumnsCount(), 0, false, null, null, null, 515754, null), null, searchMapState.getEnableLocationPermission(), itemsSearchLink.getShowSimpleMap(), 67, null);
                    return searchMapState2;
                }
            }
            searchMapState2 = searchMapState;
            return searchMapState2;
        } else if (!(mapAction instanceof MapViewAction.GoToLocation)) {
            boolean z3 = mapAction instanceof MapViewAction.MapChanges;
        }
        return searchMapState;
    }
}
