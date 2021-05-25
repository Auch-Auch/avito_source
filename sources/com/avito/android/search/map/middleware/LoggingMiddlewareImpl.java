package com.avito.android.search.map.middleware;

import com.avito.android.analytics.event.ClickPinEvent;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.map.Highlight;
import com.avito.android.remote.model.search.map.MarkersResponse;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.search.map.PinAdverts;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.PhoneDialogAction;
import com.avito.android.search.map.action.ScreenExit;
import com.avito.android.search.map.action.SearchParamsChangedAction;
import com.avito.android.search.map.interactor.ParentType;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.MarkerWithCount;
import com.avito.android.search.map.view.MarkerWithFavorite;
import com.avito.android.search.map.view.MarkerWithHighlight;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.search.map.view.SelectableMarker;
import com.avito.android.search.map.view.ViewableMarker;
import com.avito.android.search.map.view.advert.AdvertItemEvent;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.ObservablesKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/search/map/middleware/LoggingMiddlewareImpl;", "Lcom/avito/android/search/map/middleware/LoggingMiddleware;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapAction;", "actions", "Lcom/avito/android/search/map/SearchMapState;", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/search/map/SearchMapState;)V", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "d", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "commercialBannersAnalyticsInteractor", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "c", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "tracker", "<init>", "(Lcom/avito/android/search/map/metric/SearchMapTracker;Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class LoggingMiddlewareImpl implements LoggingMiddleware {
    public final SearchMapTracker a;
    public final SearchMapAnalyticsInteractor b;
    public final LocationAnalyticsInteractor c;
    public final CommercialBannersAnalyticsInteractor d;

    public static final class a<T, R> implements Function<Pair<? extends MapAction, ? extends SearchMapState>, ObservableSource<? extends MapAction>> {
        public final /* synthetic */ LoggingMiddlewareImpl a;

        public a(LoggingMiddlewareImpl loggingMiddlewareImpl) {
            this.a = loggingMiddlewareImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MapAction> apply(Pair<? extends MapAction, ? extends SearchMapState> pair) {
            Pair<? extends MapAction, ? extends SearchMapState> pair2 = pair;
            MapAction mapAction = (MapAction) pair2.component1();
            SearchMapState searchMapState = (SearchMapState) pair2.component2();
            Logs.info$default("LoggingMiddleware", String.valueOf(mapAction), null, 4, null);
            if (mapAction instanceof LoadAction.LoadSerp) {
                LoadingState<SerpInteractor.Result> state = ((LoadAction.LoadSerp) mapAction).getState();
                if (state instanceof LoadingState.Loaded) {
                    this.a.a.trackSerpLoaded();
                    LoggingMiddlewareImpl.access$sendCloseMap(this.a);
                    this.a.b.sendSerpLoad(searchMapState.getSearchParams(), searchMapState.getSerpState().getCount(), searchMapState.getMapState().getMapBounds(), null, searchMapState.getSerpState().getXHash());
                    this.a.a.startSerpDraw();
                } else if (state instanceof LoadingState.Loading) {
                    this.a.a.startSerpLoading();
                }
            } else if (mapAction instanceof LoadAction.LoadInlineFilters) {
                LoadingState<InlineFilters> state2 = ((LoadAction.LoadInlineFilters) mapAction).getState();
                if (state2 instanceof LoadingState.Loaded) {
                    this.a.a.trackShortcutsLoaded();
                    this.a.a.startShortcutsDraw();
                } else if (state2 instanceof LoadingState.Loading) {
                    this.a.a.startShortcutsLoading();
                }
            } else if (mapAction instanceof MapViewAction.ShowListButtonClicked) {
                if (!searchMapState.getSerpState().isInvalidate()) {
                    LoggingMiddlewareImpl.access$sendCloseMap(this.a);
                    this.a.b.sendSerpLoad(searchMapState.getSearchParams(), searchMapState.getSerpState().getCount(), searchMapState.getMapState().getMapBounds(), null, searchMapState.getSerpState().getXHash());
                }
            } else if (mapAction instanceof MapViewAction.ShortcutClicked) {
                MapViewAction.ShortcutClicked shortcutClicked = (MapViewAction.ShortcutClicked) mapAction;
                this.a.b.sendClickShortcut(searchMapState.getSerpState().getPanelState(), searchMapState.getMapState().getMapBounds(), shortcutClicked.getShortcutItem().getText(), ShortcutNavigationItemKt.extractCategoryId(shortcutClicked.getShortcutItem()));
            } else if (mapAction instanceof MapViewAction.NavigationClicked) {
                this.a.b.sendClickBack(searchMapState.getSearchParams().getCategoryId(), true);
            } else if (mapAction instanceof MapViewAction.AddMyLocation) {
                LoggingMiddlewareImpl.access$sendFindLocation(this.a);
                LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.c, ((MapViewAction.AddMyLocation) mapAction).getMyLocation(), null, 2, null);
            } else if (mapAction instanceof MapViewAction.GoToLocation) {
                LoggingMiddlewareImpl loggingMiddlewareImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                LoggingMiddlewareImpl.access$checkParentMap(loggingMiddlewareImpl, searchMapState);
                this.a.b.sendClickFindMe(searchMapState.getMapState().getMapBounds());
                LoggingMiddlewareImpl.access$sendFindLocation(this.a);
                LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.c, ((MapViewAction.GoToLocation) mapAction).getPosition(), null, 2, null);
            } else if (mapAction instanceof MapViewAction.CheckLocationRationale) {
                LoggingMiddlewareImpl.access$sendFindLocation(this.a);
                this.a.c.trackResolveCoordinates(null, "PERMISSION DENIED");
            } else if (mapAction instanceof MapViewAction.MarkerClicked) {
                LoggingMiddlewareImpl loggingMiddlewareImpl2 = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                LoggingMiddlewareImpl.access$checkParentMap(loggingMiddlewareImpl2, searchMapState);
                MapViewAction.MarkerClicked markerClicked = (MapViewAction.MarkerClicked) mapAction;
                MarkerItem item = markerClicked.getItem();
                if (item instanceof MarkerItem.Pin) {
                    this.a.b.sendClickPin(searchMapState.getSerpState().getPanelState(), searchMapState.getMapState().getMapBounds(), ((MarkerItem.Pin) markerClicked.getItem()).getCount(), searchMapState.getSearchParams().getCategoryId(), searchMapState.getMapState().getZoom(), ((MarkerItem.Pin) markerClicked.getItem()).getPrice() != null ? ClickPinEvent.PinType.PRICE_PIN : ClickPinEvent.PinType.PIN, LoggingMiddlewareImpl.access$getStateForMarkerItem(this.a, markerClicked.getItem()), LoggingMiddlewareImpl.access$getHighLightMarkerItem(this.a, markerClicked.getItem()), ((MarkerItem.Pin) markerClicked.getItem()).getPrice());
                } else if (item instanceof MarkerItem.Rash) {
                    this.a.b.sendClickPin(searchMapState.getSerpState().getPanelState(), searchMapState.getMapState().getMapBounds(), ((MarkerItem.Rash) markerClicked.getItem()).getCount(), searchMapState.getSearchParams().getCategoryId(), searchMapState.getMapState().getZoom(), ClickPinEvent.PinType.RASH, LoggingMiddlewareImpl.access$getStateForMarkerItem(this.a, markerClicked.getItem()), LoggingMiddlewareImpl.access$getHighLightMarkerItem(this.a, markerClicked.getItem()), null);
                }
            } else if (mapAction instanceof MapViewAction.MapGestureMovedEnd) {
                LoggingMiddlewareImpl loggingMiddlewareImpl3 = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                LoggingMiddlewareImpl.access$checkParentMap(loggingMiddlewareImpl3, searchMapState);
                MapViewAction.MapGestureMovedEnd mapGestureMovedEnd = (MapViewAction.MapGestureMovedEnd) mapAction;
                if (!Intrinsics.areEqual(searchMapState.getMapState().getZoom(), mapGestureMovedEnd.getZoom())) {
                    this.a.b.sendMapZoom(mapGestureMovedEnd.getBounds(), searchMapState.getMapState().getZoom());
                } else {
                    this.a.b.sendMapScroll(mapGestureMovedEnd.getBounds(), searchMapState.getMapState().getZoom());
                }
            } else if (mapAction instanceof MapViewAction.SerpPanelStateChanged) {
                if (Intrinsics.areEqual(((MapViewAction.SerpPanelStateChanged) mapAction).getState(), PanelStateKt.PANEL_HIDDEN)) {
                    LoggingMiddlewareImpl loggingMiddlewareImpl4 = this.a;
                    Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                    LoggingMiddlewareImpl.access$checkParentMap(loggingMiddlewareImpl4, searchMapState);
                }
            } else if (mapAction instanceof ScreenExit) {
                this.a.c.trackScreenExitAfterCoordinatesResolve();
            } else if (mapAction instanceof SearchParamsChangedAction) {
                this.a.b.searchParamChange();
            } else if (mapAction instanceof LoadAction.LoadMarkers) {
                LoadingState<MarkersResponse> state3 = ((LoadAction.LoadMarkers) mapAction).getState();
                if (state3 instanceof LoadingState.Loaded) {
                    if (this.a.b.getParentType() == null || this.a.b.getParentType() == ParentType.SEARCH_PARAMS_CHANGE) {
                        LoggingMiddlewareImpl loggingMiddlewareImpl5 = this.a;
                        Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                        loggingMiddlewareImpl5.a(searchMapState);
                    }
                    this.a.a.trackMarkersLoaded();
                    this.a.a.startMarkersDraw();
                } else if (state3 instanceof LoadingState.Loading) {
                    this.a.a.startMarkersLoading();
                }
            } else if (mapAction instanceof PhoneDialogAction.UserMakeCall) {
                this.a.b.sendAdvertXlConfirmedCall(((PhoneDialogAction.UserMakeCall) mapAction).getAdvertId());
            } else {
                if (mapAction instanceof MapViewAction.SearchBySuggest) {
                    MapViewAction.SearchBySuggest searchBySuggest = (MapViewAction.SearchBySuggest) mapAction;
                    if (searchBySuggest.getSuggestAction() instanceof SuggestAnalyticsEvent) {
                        this.a.b.sendClickSearchSuggest((SuggestAnalyticsEvent) searchBySuggest.getSuggestAction());
                    }
                }
                if (mapAction instanceof MapViewAction.SearchByQuery) {
                    this.a.b.sendSearchSubmit();
                } else if (mapAction instanceof AdvertItemEvent.AdBannerOpened) {
                    AdvertItemEvent.AdBannerOpened adBannerOpened = (AdvertItemEvent.AdBannerOpened) mapAction;
                    CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerOpened$default(this.a.d, adBannerOpened.getBannerInfo(), adBannerOpened.getPosition(), searchMapState.getSearchParams().getCategoryId(), searchMapState.getSearchParams().getLocationId(), null, null, 48, null);
                } else {
                    int i = 0;
                    if (mapAction instanceof LoadAction.LoadPinAdverts) {
                        LoadAction.LoadPinAdverts loadPinAdverts = (LoadAction.LoadPinAdverts) mapAction;
                        if (loadPinAdverts.getState() instanceof LoadingState.Loaded) {
                            LoggingMiddlewareImpl.access$sendMarkerItemsLoaded(this.a, (LoadingState.Loaded) loadPinAdverts.getState(), 0);
                        }
                    }
                    if (mapAction instanceof LoadAction.AppendPinAdverts) {
                        LoadAction.AppendPinAdverts appendPinAdverts = (LoadAction.AppendPinAdverts) mapAction;
                        if (appendPinAdverts.getState() instanceof LoadingState.Loaded) {
                            LoggingMiddlewareImpl loggingMiddlewareImpl6 = this.a;
                            LoadingState.Loaded loaded = (LoadingState.Loaded) appendPinAdverts.getState();
                            List<ViewTypeSerpItem> adverts = searchMapState.getPinAdvertsState().getAdverts();
                            if (adverts != null) {
                                i = adverts.size() - ((PinAdverts) ((LoadingState.Loaded) appendPinAdverts.getState()).getData()).getAdverts().size();
                            }
                            LoggingMiddlewareImpl.access$sendMarkerItemsLoaded(loggingMiddlewareImpl6, loaded, i);
                        }
                    }
                    if (mapAction instanceof MapViewAction.ClearGeoFiltersAction) {
                        this.a.b.sendClearGeoFilters(searchMapState.getSearchParams());
                    }
                }
            }
            return Observable.empty();
        }
    }

    @Inject
    public LoggingMiddlewareImpl(@NotNull SearchMapTracker searchMapTracker, @NotNull SearchMapAnalyticsInteractor searchMapAnalyticsInteractor, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(searchMapTracker, "tracker");
        Intrinsics.checkNotNullParameter(searchMapAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialBannersAnalyticsInteractor");
        this.a = searchMapTracker;
        this.b = searchMapAnalyticsInteractor;
        this.c = locationAnalyticsInteractor;
        this.d = commercialBannersAnalyticsInteractor;
    }

    public static final void access$checkParentMap(LoggingMiddlewareImpl loggingMiddlewareImpl, SearchMapState searchMapState) {
        ParentType parentType = loggingMiddlewareImpl.b.getParentType();
        if (parentType != ParentType.MAP) {
            if (parentType != ParentType.ENTRANCE_TO_MAP) {
                loggingMiddlewareImpl.b.sendEntranceToMap();
            }
            loggingMiddlewareImpl.a(searchMapState);
        }
    }

    public static final ClickPinEvent.PinHighlight access$getHighLightMarkerItem(LoggingMiddlewareImpl loggingMiddlewareImpl, MarkerItem markerItem) {
        Objects.requireNonNull(loggingMiddlewareImpl);
        if (!(markerItem instanceof MarkerWithHighlight) || ((MarkerWithHighlight) markerItem).getHighlight() != Highlight.Bright) {
            return ClickPinEvent.PinHighlight.REGULAR;
        }
        return ClickPinEvent.PinHighlight.BRIGHT;
    }

    public static final ClickPinEvent.PinState access$getStateForMarkerItem(LoggingMiddlewareImpl loggingMiddlewareImpl, MarkerItem markerItem) {
        Objects.requireNonNull(loggingMiddlewareImpl);
        if (!(markerItem instanceof SelectableMarker) || !(markerItem instanceof ViewableMarker)) {
            return ClickPinEvent.PinState.UNVIEWED;
        }
        if (((SelectableMarker) markerItem).getSelected()) {
            return ClickPinEvent.PinState.SELECTED;
        }
        if (((ViewableMarker) markerItem).isViewed() && (markerItem instanceof MarkerWithFavorite) && !((MarkerWithFavorite) markerItem).isFavorite()) {
            return ClickPinEvent.PinState.VIEWED;
        }
        if (!(markerItem instanceof MarkerWithFavorite) || !((MarkerWithFavorite) markerItem).isFavorite()) {
            return ClickPinEvent.PinState.UNVIEWED;
        }
        return ClickPinEvent.PinState.FAVORITE;
    }

    public static final void access$sendCloseMap(LoggingMiddlewareImpl loggingMiddlewareImpl) {
        ParentType parentType = loggingMiddlewareImpl.b.getParentType();
        if (parentType == ParentType.MAP || parentType == ParentType.ENTRANCE_TO_MAP) {
            loggingMiddlewareImpl.b.sendExitFromMap();
        }
    }

    public static final void access$sendFindLocation(LoggingMiddlewareImpl loggingMiddlewareImpl) {
        loggingMiddlewareImpl.c.trackFindCoordinates(FindLocationPage.SEARCH_MAP.getValue());
    }

    public static final void access$sendMarkerItemsLoaded(LoggingMiddlewareImpl loggingMiddlewareImpl, LoadingState.Loaded loaded, int i) {
        Objects.requireNonNull(loggingMiddlewareImpl);
        List<ViewTypeSerpItem> adverts = ((PinAdverts) loaded.getData()).getAdverts();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(adverts, 10));
        int i2 = 0;
        for (T t : adverts) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(i2 + i), t.getStringId(), "0", "1"}));
            i2 = i3;
        }
        loggingMiddlewareImpl.b.sendMarkerItemsLoaded(arrayList);
    }

    public final void a(SearchMapState searchMapState) {
        SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.b;
        SearchParams searchParams = searchMapState.getSearchParams();
        List<MarkerItem> markerItems = searchMapState.getMapState().getMarkerItems();
        long j = 0;
        if (markerItems != null) {
            for (MarkerItem markerItem : markerItems) {
                if (markerItem instanceof MarkerWithCount) {
                    j += (long) ((MarkerWithCount) markerItem).getCount();
                }
            }
        }
        searchMapAnalyticsInteractor.sendSearchByMap(searchParams, j, searchMapState.getMapState().getMapBounds(), searchMapState.getMapState().getZoom());
    }

    @Override // com.avito.android.redux.Middleware
    @NotNull
    public Observable<MapAction> create(@NotNull Observable<MapAction> observable, @NotNull Observable<SearchMapState> observable2) {
        Intrinsics.checkNotNullParameter(observable, "actions");
        Intrinsics.checkNotNullParameter(observable2, "state");
        Observable<MapAction> flatMap = ObservablesKt.withLatestFrom(observable, observable2).flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "actions.withLatestFrom(s…apAction>()\n            }");
        return flatMap;
    }
}
