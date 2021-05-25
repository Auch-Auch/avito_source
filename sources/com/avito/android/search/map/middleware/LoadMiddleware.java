package com.avito.android.search.map.middleware;

import a2.a.a.k2.b.g.h;
import a2.a.a.k2.b.g.i;
import a2.a.a.k2.b.g.j;
import a2.a.a.k2.b.g.l;
import a2.a.a.k2.b.g.m;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.di.PerFragment;
import com.avito.android.redux.Middleware;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.MarkersResponse;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.SearchParamsChangedAction;
import com.avito.android.search.map.action.StartAction;
import com.avito.android.search.map.di.SerpList;
import com.avito.android.search.map.interactor.SearchMapInteractor;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.interactor.SerpKey;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.adapter.AppendingState;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.Collections;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.ObservablesKt;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\b\u0007\u0012\u0006\u00104\u001a\u000202\u0012\b\b\u0001\u00107\u001a\u000205\u0012\u0006\u0010:\u001a\u000208\u0012\u0006\u00101\u001a\u00020/\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u0010=\u001a\u00020;¢\u0006\u0004\b>\u0010?J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u000fJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u000fJC\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010%J%\u0010*\u001a\u00020\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0&2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010<¨\u0006@"}, d2 = {"Lcom/avito/android/search/map/middleware/LoadMiddleware;", "Lcom/avito/android/redux/Middleware;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "Lio/reactivex/rxjava3/core/Observable;", "actions", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "", "alreadyHasData", "Lcom/avito/android/search/map/action/LoadAction;", "d", "(Lcom/avito/android/search/map/SearchMapState;Z)Lio/reactivex/rxjava3/core/Observable;", "e", "(Lcom/avito/android/search/map/SearchMapState;)Lio/reactivex/rxjava3/core/Observable;", "i", "Lcom/avito/android/remote/model/search/map/Area;", "area", UrlParams.SIMPLE_MAP, "Lcom/avito/android/search/map/action/LoadAction$LoadMarkers;", "c", "(Lcom/avito/android/remote/model/search/map/Area;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/LoadAction$LoadInlineFilters;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", a2.g.r.g.a, "h", "clearGeoFilters", "", "query", "context", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/search/map/action/LoadAction$LoadSearchDeepLink;", "f", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", "", "ids", "", "offset", AuthSource.SEND_ABUSE, "(Ljava/util/List;I)Ljava/lang/String;", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourcesProvider", "Lcom/avito/android/search/map/interactor/SearchMapInteractor;", "Lcom/avito/android/search/map/interactor/SearchMapInteractor;", "interactor", "Lcom/avito/android/serp/SerpItemProcessor;", "Lcom/avito/android/serp/SerpItemProcessor;", "itemProcessor", "Lcom/avito/android/search/map/interactor/SerpInteractor;", "Lcom/avito/android/search/map/interactor/SerpInteractor;", "serpInteractor", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "subscriptionInteractor", "<init>", "(Lcom/avito/android/search/map/interactor/SearchMapInteractor;Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/search/map/interactor/SerpInteractor;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class LoadMiddleware implements Middleware<SearchMapState, MapAction> {
    public final SearchMapInteractor a;
    public final SerpItemProcessor b;
    public final SerpInteractor c;
    public final SerpListResourcesProvider d;
    public final SchedulersFactory3 e;
    public final SubscribeSearchInteractor f;

    public static final class a<T, R> implements Function<Pair<? extends MapAction, ? extends SearchMapState>, ObservableSource<? extends MapAction>> {
        public final /* synthetic */ LoadMiddleware a;

        public a(LoadMiddleware loadMiddleware) {
            this.a = loadMiddleware;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MapAction> apply(Pair<? extends MapAction, ? extends SearchMapState> pair) {
            Pair<? extends MapAction, ? extends SearchMapState> pair2 = pair;
            MapAction mapAction = (MapAction) pair2.component1();
            SearchMapState searchMapState = (SearchMapState) pair2.component2();
            if (mapAction instanceof StartAction) {
                LoadMiddleware loadMiddleware = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                return loadMiddleware.d(searchMapState, true);
            } else if (mapAction instanceof MapViewAction.RefreshClicked) {
                LoadMiddleware loadMiddleware2 = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                return loadMiddleware2.d(searchMapState, false);
            } else if ((mapAction instanceof LoadAction.InitSerp) && (((LoadAction.InitSerp) mapAction).getState() instanceof LoadingState.Loaded)) {
                LoadMiddleware loadMiddleware3 = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                return loadMiddleware3.i(searchMapState);
            } else if ((mapAction instanceof MapViewAction.ShowListButtonClicked) && searchMapState.getSerpState().isInvalidate()) {
                LoadMiddleware loadMiddleware4 = this.a;
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                return LoadMiddleware.access$reloadSerp(loadMiddleware4, searchMapState);
            } else if (mapAction instanceof MapViewAction.MapMoved) {
                return this.a.c(searchMapState.getSerpState().getArea(), searchMapState.getShowSimpleMap());
            } else {
                if (mapAction instanceof MapViewAction.MarkerClicked) {
                    MapViewAction.MarkerClicked markerClicked = (MapViewAction.MarkerClicked) mapAction;
                    if (((markerClicked.getItem() instanceof MarkerItem.Pin) || (markerClicked.getItem() instanceof MarkerItem.Rash)) && LoadMiddleware.access$isEmpty(this.a, searchMapState.getPinAdvertsState())) {
                        return LoadMiddleware.access$loadAdvertsInPin(this.a, searchMapState.getPinAdvertsState().getAdvertIds(), searchMapState.getPinAdvertsState().getFavoriteIds());
                    }
                }
                if (mapAction instanceof MapViewAction.ButtonPanelRetry) {
                    if (searchMapState.getPinAdvertsState().getPinId() != null) {
                        return LoadMiddleware.access$loadAdvertsInPin(this.a, searchMapState.getPinAdvertsState().getAdvertIds(), searchMapState.getPinAdvertsState().getFavoriteIds());
                    }
                    LoadMiddleware loadMiddleware5 = this.a;
                    Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                    return LoadMiddleware.access$reloadSerp(loadMiddleware5, searchMapState);
                } else if ((mapAction instanceof MapViewAction.AppendPinAdverts) && searchMapState.getPinAdvertsState().getAppendingState() == AppendingState.CAN_LOAD && searchMapState.getPinAdvertsState().getPinId() != null) {
                    return LoadMiddleware.access$appendAdvertsInPin(this.a, searchMapState.getPinAdvertsState().getAdvertIds(), searchMapState.getPinAdvertsState().getCurrentlyLoadedCount());
                } else {
                    if ((mapAction instanceof MapViewAction.AppendSerp) && searchMapState.getSerpState().getAppendingState() == AppendingState.CAN_LOAD) {
                        LoadMiddleware loadMiddleware6 = this.a;
                        Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                        return LoadMiddleware.access$appendSerp(loadMiddleware6, searchMapState);
                    } else if (mapAction instanceof MapViewAction.RetryAppendSerp) {
                        LoadMiddleware loadMiddleware7 = this.a;
                        Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                        return LoadMiddleware.access$appendSerp(loadMiddleware7, searchMapState);
                    } else if ((mapAction instanceof MapViewAction.RetryAppendPinAdverts) && searchMapState.getPinAdvertsState().getPinId() != null) {
                        return LoadMiddleware.access$appendAdvertsInPin(this.a, searchMapState.getPinAdvertsState().getAdvertIds(), searchMapState.getPinAdvertsState().getCurrentlyLoadedCount());
                    } else {
                        if (mapAction instanceof SearchParamsChangedAction) {
                            SearchParamsChangedAction searchParamsChangedAction = (SearchParamsChangedAction) mapAction;
                            if ((searchParamsChangedAction.getDeepLink() instanceof ItemsSearchLink) && (((ItemsSearchLink) searchParamsChangedAction.getDeepLink()).getShowMap() || ((ItemsSearchLink) searchParamsChangedAction.getDeepLink()).getShowSimpleMap())) {
                                LoadMiddleware loadMiddleware8 = this.a;
                                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                                return loadMiddleware8.d(searchMapState, false);
                            }
                        }
                        if (mapAction instanceof MapViewAction.SearchByQuery) {
                            return this.a.f(Boolean.FALSE, ((MapViewAction.SearchByQuery) mapAction).getQuery(), searchMapState.getSerpState().getContext(), searchMapState.getSearchParams(), false);
                        }
                        if (mapAction instanceof MapViewAction.UpdateSearchLocation) {
                            LoadMiddleware loadMiddleware9 = this.a;
                            Boolean bool = Boolean.TRUE;
                            String query = searchMapState.getSearchParams().getQuery();
                            if (query == null) {
                                query = "";
                            }
                            return loadMiddleware9.f(bool, query, searchMapState.getSerpState().getContext(), SearchMapState.copy$default(searchMapState, null, null, SearchParams.copy$default(searchMapState.getSearchParams(), null, null, ((MapViewAction.UpdateSearchLocation) mapAction).getLocation().getId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388603, null), null, null, null, null, false, false, 507, null).getSearchParams(), searchMapState.getShowSimpleMap());
                        } else if (mapAction instanceof MapViewAction.MapChanges) {
                            LoadMiddleware loadMiddleware10 = this.a;
                            Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                            return LoadMiddleware.access$updateSearchParams(loadMiddleware10, searchMapState);
                        } else if (mapAction instanceof MapViewAction.GoToLocation) {
                            LoadMiddleware loadMiddleware11 = this.a;
                            Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                            return LoadMiddleware.access$updateSearchParams(loadMiddleware11, searchMapState);
                        } else if (mapAction instanceof MapViewAction.Snippet.Click) {
                            return this.a.c.removeElement(searchMapState.getSerpState().getKey(), ((MapViewAction.Snippet.Click) mapAction).getPosition()).toObservable();
                        } else {
                            if (mapAction instanceof MapViewAction.Snippet.Close) {
                                return this.a.c.removeElement(searchMapState.getSerpState().getKey(), ((MapViewAction.Snippet.Close) mapAction).getPosition()).toObservable();
                            }
                            if (mapAction instanceof MapViewAction.SearchSubscriptionButtonClicked) {
                                return LoadMiddleware.access$loadSavedSearchControlDeeplink(this.a, searchMapState.getSerpState().getSubscriptionId(), SearchParams.copy$default(searchMapState.getSearchParams(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, searchMapState.getSerpState().getArea(), 4194303, null));
                            }
                            return Observable.empty();
                        }
                    }
                }
            }
        }
    }

    public static final class b<V> implements Callable<InlineFilters> {
        public final /* synthetic */ SearchMapState a;

        public b(SearchMapState searchMapState) {
            this.a = searchMapState;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public InlineFilters call() {
            return this.a.getInlineFilters();
        }
    }

    public static final class c<T, R> implements Function<InlineFilters, LoadingState.Loaded<InlineFilters>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState.Loaded<InlineFilters> apply(InlineFilters inlineFilters) {
            return new LoadingState.Loaded<>(inlineFilters);
        }
    }

    public static final class d<T, R> implements Function<LoadingState<? super InlineFilters>, LoadAction.LoadInlineFilters> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadAction.LoadInlineFilters apply(LoadingState<? super InlineFilters> loadingState) {
            LoadingState<? super InlineFilters> loadingState2 = loadingState;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            return new LoadAction.LoadInlineFilters(loadingState2);
        }
    }

    public static final class e<T, R> implements Function<LoadingState<? super MarkersResponse>, LoadAction.LoadMarkers> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadAction.LoadMarkers apply(LoadingState<? super MarkersResponse> loadingState) {
            LoadingState<? super MarkersResponse> loadingState2 = loadingState;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            return new LoadAction.LoadMarkers(loadingState2);
        }
    }

    public static final class f<T, R> implements Function<LoadingState<? super DeepLink>, LoadAction.LoadSearchDeepLink> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadAction.LoadSearchDeepLink apply(LoadingState<? super DeepLink> loadingState) {
            LoadingState<? super DeepLink> loadingState2 = loadingState;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            return new LoadAction.LoadSearchDeepLink(loadingState2);
        }
    }

    public static final class g<V> implements Callable<LoadAction> {
        public final /* synthetic */ LoadMiddleware a;
        public final /* synthetic */ List b;

        public g(LoadMiddleware loadMiddleware, List list) {
            this.a = loadMiddleware;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public LoadAction call() {
            this.a.b.resolveItemsSync(this.b);
            return LoadAction.RestorePinAdverts.INSTANCE;
        }
    }

    @Inject
    public LoadMiddleware(@NotNull SearchMapInteractor searchMapInteractor, @SerpList @NotNull SerpItemProcessor serpItemProcessor, @NotNull SerpInteractor serpInteractor, @NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SubscribeSearchInteractor subscribeSearchInteractor) {
        Intrinsics.checkNotNullParameter(searchMapInteractor, "interactor");
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemProcessor");
        Intrinsics.checkNotNullParameter(serpInteractor, "serpInteractor");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(subscribeSearchInteractor, "subscriptionInteractor");
        this.a = searchMapInteractor;
        this.b = serpItemProcessor;
        this.c = serpInteractor;
        this.d = serpListResourcesProvider;
        this.e = schedulersFactory3;
        this.f = subscribeSearchInteractor;
    }

    public static final Observable access$appendAdvertsInPin(LoadMiddleware loadMiddleware, List list, int i) {
        Observable<R> flatMap = loadMiddleware.a.loadAdvertsInPin(loadMiddleware.a(list, i), 20, false).flatMap(new l(loadMiddleware, null));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap {\n            wh…)\n            }\n        }");
        Observable<R> map = flatMap.map(a2.a.a.k2.b.g.a.a);
        Intrinsics.checkNotNullExpressionValue(map, "interactor.loadAdvertsIn…on.AppendPinAdverts(it) }");
        return map;
    }

    public static final Observable access$appendSerp(LoadMiddleware loadMiddleware, SearchMapState searchMapState) {
        Observable<R> map = loadMiddleware.c.loadSerp(searchMapState.getSerpState().getKey(), true, searchMapState.getSearchParams(), searchMapState.getSerpState().getContext(), searchMapState.getSerpState().getDisplayType(), searchMapState.getSerpState().getArea()).map(a2.a.a.k2.b.g.d.a);
        Intrinsics.checkNotNullExpressionValue(map, "serpInteractor.loadSerp(…adAction.AppendSerp(it) }");
        Observable<R> concatMap = map.concatMap(new a2.a.a.k2.b.g.c(loadMiddleware, searchMapState));
        Intrinsics.checkNotNullExpressionValue(concatMap, "this.concatMap {\n       …)\n            }\n        }");
        return concatMap;
    }

    public static final boolean access$isEmpty(LoadMiddleware loadMiddleware, SearchMapState.PinAdvertsState pinAdvertsState) {
        Objects.requireNonNull(loadMiddleware);
        return Collections.isNullOrEmpty(pinAdvertsState.getAdverts());
    }

    public static final Observable access$loadAdvertsInPin(LoadMiddleware loadMiddleware, List list, List list2) {
        Observable<R> flatMap = loadMiddleware.a.loadAdvertsInPin(loadMiddleware.a(list, 0), 20, true).flatMap(new l(loadMiddleware, list2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap {\n            wh…)\n            }\n        }");
        Observable<R> map = flatMap.map(h.a);
        Intrinsics.checkNotNullExpressionValue(map, "interactor.loadAdvertsIn…tion.LoadPinAdverts(it) }");
        return map;
    }

    public static final Observable access$loadSavedSearchControlDeeplink(LoadMiddleware loadMiddleware, String str, SearchParams searchParams) {
        Observable<R> map = loadMiddleware.f.getSearchSubscriptionControlDeeplink(str, searchParams).map(i.a);
        Intrinsics.checkNotNullExpressionValue(map, "subscriptionInteractor.g…archControlDeeplink(it) }");
        return map;
    }

    public static final Observable access$reloadSerp(LoadMiddleware loadMiddleware, SearchMapState searchMapState) {
        Objects.requireNonNull(loadMiddleware);
        if (searchMapState.getShowSimpleMap()) {
            return loadMiddleware.e(searchMapState);
        }
        Observable<R> map = loadMiddleware.g(searchMapState).map(j.a);
        Intrinsics.checkNotNullExpressionValue(map, "loadSerp(state).map { Lo… as LoadAction.LoadSerp }");
        Observable<R> concatMap = map.concatMap(new a2.a.a.k2.b.g.g(loadMiddleware, searchMapState));
        Intrinsics.checkNotNullExpressionValue(concatMap, "this.concatMap {\n       …)\n            }\n        }");
        return concatMap;
    }

    public static final Observable access$updateSearchParams(LoadMiddleware loadMiddleware, SearchMapState searchMapState) {
        if (loadMiddleware.a.updateSearchParams(searchMapState.getSearchParams())) {
            Observable map = SearchMapInteractor.DefaultImpls.loadInlineFilters$default(loadMiddleware.a, null, searchMapState.getShowSimpleMap(), 1, null).map(m.a);
            Objects.requireNonNull(map, "null cannot be cast to non-null type io.reactivex.rxjava3.core.Observable<com.avito.android.search.map.action.LoadAction>");
            return map;
        }
        Observable empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    public final String a(List<String> list, int i) {
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.take(SequencesKt___SequencesKt.drop(CollectionsKt___CollectionsKt.asSequence(list), i), 20), ",", null, null, 0, null, null, 62, null);
    }

    public final Observable<LoadAction.LoadInlineFilters> b(SearchMapState searchMapState) {
        Observable map = Maybe.fromCallable(new b(searchMapState)).toObservable().map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "Maybe.fromCallable { sta…LoadingState.Loaded(it) }");
        Observable cast = map.cast(LoadingState.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Observable<LoadAction.LoadInlineFilters> map2 = cast.switchIfEmpty(SearchMapInteractor.DefaultImpls.loadInlineFilters$default(this.a, null, searchMapState.getShowSimpleMap(), 1, null)).map(d.a);
        Intrinsics.checkNotNullExpressionValue(map2, "Maybe.fromCallable { sta…n.LoadInlineFilters(it) }");
        return map2;
    }

    public final Observable<LoadAction.LoadMarkers> c(Area area, boolean z) {
        Observable<R> map = this.a.loadMarkers(area, z).map(e.a);
        Intrinsics.checkNotNullExpressionValue(map, "interactor.loadMarkers(a…dAction.LoadMarkers(it) }");
        Observable<R> debounce = map.debounce(800, TimeUnit.MILLISECONDS, this.e.io());
        Intrinsics.checkNotNullExpressionValue(debounce, "interactor.loadMarkers(a…          .withDebounce()");
        return debounce;
    }

    @Override // com.avito.android.redux.Middleware
    @NotNull
    public Observable<MapAction> create(@NotNull Observable<MapAction> observable, @NotNull Observable<SearchMapState> observable2) {
        Intrinsics.checkNotNullParameter(observable, "actions");
        Intrinsics.checkNotNullParameter(observable2, "state");
        Observable<MapAction> flatMap = ObservablesKt.withLatestFrom(observable, observable2).flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "actions.withLatestFrom(s…)\n            }\n        }");
        return flatMap;
    }

    public final Observable<LoadAction> d(SearchMapState searchMapState, boolean z) {
        Observable<LoadAction> observable;
        this.a.updateSearchParams(searchMapState.getSearchParams());
        if (!Intrinsics.areEqual(searchMapState.getSerpState().getPanelState(), PanelStateKt.PANEL_HIDDEN)) {
            if (!searchMapState.getShowSimpleMap()) {
                Observable<R> map = g(searchMapState).map(a2.a.a.k2.b.g.e.a);
                Intrinsics.checkNotNullExpressionValue(map, "loadSerp(state).map { Lo… as LoadAction.LoadSerp }");
                observable = map.concatMap(new a2.a.a.k2.b.g.g(this, searchMapState));
                Intrinsics.checkNotNullExpressionValue(observable, "this.concatMap {\n       …)\n            }\n        }");
            } else {
                observable = i(searchMapState);
            }
            Observable<LoadAction> merge = Observable.merge(observable, b(searchMapState));
            Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …ters(state)\n            )");
            return merge;
        } else if (!z) {
            return e(searchMapState);
        } else {
            if (searchMapState.getInlineFilters() == null) {
                return e(searchMapState);
            }
            return i(searchMapState);
        }
    }

    public final Observable<LoadAction> e(SearchMapState searchMapState) {
        Observable<LoadAction> merge = Observable.merge(c(searchMapState.getSerpState().getArea(), searchMapState.getShowSimpleMap()), b(searchMapState), h(searchMapState));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …tsStatus(state)\n        )");
        return merge;
    }

    public final Observable<LoadAction.LoadSearchDeepLink> f(Boolean bool, String str, String str2, SearchParams searchParams, boolean z) {
        Observable<R> map = this.a.loadSearchDeepLink(bool, str, str2, searchParams, z).map(f.a);
        Intrinsics.checkNotNullExpressionValue(map, "interactor.loadSearchDee….LoadSearchDeepLink(it) }");
        return map;
    }

    public final Observable<LoadingState<SerpInteractor.Result>> g(SearchMapState searchMapState) {
        SerpInteractor serpInteractor = this.c;
        SerpKey key = searchMapState.getSerpState().getKey();
        SearchParams searchParams = searchMapState.getSearchParams();
        String context = searchMapState.getSerpState().getContext();
        SerpDisplayType displayType = searchMapState.getSearchParams().getDisplayType();
        if (displayType == null) {
            displayType = searchMapState.getSerpState().getDisplayType();
        }
        return serpInteractor.loadSerp(key, false, searchParams, context, displayType, searchMapState.getSerpState().getArea());
    }

    public final Observable<LoadAction> h(SearchMapState searchMapState) {
        List<ViewTypeSerpItem> adverts = searchMapState.getPinAdvertsState().getAdverts();
        if (adverts != null) {
            Observable<LoadAction> fromCallable = Observable.fromCallable(new g(this, adverts));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …storePinAdverts\n        }");
            return fromCallable;
        }
        Observable<LoadAction> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    public final Observable<LoadAction> i(SearchMapState searchMapState) {
        Observable<LoadAction> merge = Observable.merge(c(searchMapState.getSerpState().getArea(), searchMapState.getShowSimpleMap()), h(searchMapState));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …tsStatus(state)\n        )");
        return merge;
    }
}
