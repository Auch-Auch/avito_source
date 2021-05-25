package com.avito.android.search.map.middleware;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SearchSubscriptionsClickEvent;
import com.avito.android.deep_linking.links.SearchSubscriptionControlLink;
import com.avito.android.redux.Middleware;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.SubscriptionAction;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.interactor.SerpKey;
import com.avito.android.serp.SerpSnippetInteractor;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.ObservablesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/search/map/middleware/SubscriptionMiddleware;", "Lcom/avito/android/redux/Middleware;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "Lio/reactivex/rxjava3/core/Observable;", "actions", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/SerpSnippetInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/SerpSnippetInteractor;", "serpSnippetInteractor", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "c", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "serpCacheInteractor", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/SerpSnippetInteractor;Lcom/avito/android/search/map/interactor/SerpCacheInteractor;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionMiddleware implements Middleware<SearchMapState, MapAction> {
    public final Analytics a;
    public final SerpSnippetInteractor b;
    public final SerpCacheInteractor c;

    public static final class a<T, R> implements Function<Pair<? extends MapAction, ? extends SearchMapState>, ObservableSource<? extends MapAction>> {
        public final /* synthetic */ SubscriptionMiddleware a;

        public a(SubscriptionMiddleware subscriptionMiddleware) {
            this.a = subscriptionMiddleware;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MapAction> apply(Pair<? extends MapAction, ? extends SearchMapState> pair) {
            String id;
            String id2;
            Pair<? extends MapAction, ? extends SearchMapState> pair2 = pair;
            MapAction mapAction = (MapAction) pair2.component1();
            SearchMapState searchMapState = (SearchMapState) pair2.component2();
            if (mapAction instanceof LoadAction.LoadSerp) {
                LoadingState<SerpInteractor.Result> state = ((LoadAction.LoadSerp) mapAction).getState();
                if (state instanceof LoadingState.Loading) {
                    Observable just = Observable.just(new SubscriptionAction.ShowSubscriptionAction(false));
                    Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                    return just;
                } else if (state instanceof LoadingState.Loaded) {
                    Observable just2 = Observable.just(new SubscriptionAction.ShowSubscriptionAction(searchMapState.getSerpState().isSubscribed()));
                    Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(this)");
                    return just2;
                } else if (state instanceof LoadingState.Error) {
                    return Observable.empty();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (mapAction instanceof MapViewAction.SearchSubscriptionButtonClicked) {
                this.a.a.track(new SearchSubscriptionsClickEvent());
                return Observable.empty();
            } else if (mapAction instanceof SubscriptionAction.LoadSubscriptionAction) {
                SubscriptionAction.LoadSubscriptionAction loadSubscriptionAction = (SubscriptionAction.LoadSubscriptionAction) mapAction;
                LoadingState<SearchSubscription> state2 = loadSubscriptionAction.getState();
                if (state2 instanceof LoadingState.Loaded) {
                    SerpKey key = searchMapState.getSerpState().getKey();
                    if (!(key == null || (id2 = key.getId()) == null)) {
                        this.a.c.setSubscriptionId(id2, ((SearchSubscription) ((LoadingState.Loaded) loadSubscriptionAction.getState()).getData()).getId());
                    }
                    return Observable.empty();
                } else if (state2 instanceof LoadingState.Error) {
                    return Observable.empty();
                } else {
                    return Observable.empty();
                }
            } else if (mapAction instanceof SubscriptionAction.LoadUnsubscriptionAction) {
                LoadingState<SubscriptionResult> state3 = ((SubscriptionAction.LoadUnsubscriptionAction) mapAction).getState();
                if (state3 instanceof LoadingState.Loaded) {
                    SerpKey key2 = searchMapState.getSerpState().getKey();
                    if (!(key2 == null || (id = key2.getId()) == null)) {
                        this.a.c.setSubscriptionId(id, null);
                    }
                    return Observable.empty();
                } else if (state3 instanceof LoadingState.Error) {
                    return Observable.empty();
                } else {
                    return Observable.empty();
                }
            } else if (mapAction instanceof MapViewAction.Snippet.Click) {
                MapViewAction.Snippet.Click click = (MapViewAction.Snippet.Click) mapAction;
                this.a.b.sendClick(click.getId(), click.getAnalytics());
                if (click.getDeepLink() instanceof SearchSubscriptionControlLink) {
                    Observable just3 = Observable.just(MapViewAction.SearchSubscriptionButtonClicked.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(just3, "Observable.just(this)");
                    return just3;
                }
                Observable just4 = Observable.just(new MapViewAction.FollowDeepLink(click.getDeepLink()));
                Intrinsics.checkNotNullExpressionValue(just4, "Observable.just(this)");
                return just4;
            } else if (mapAction instanceof MapViewAction.Snippet.Close) {
                MapViewAction.Snippet.Close close = (MapViewAction.Snippet.Close) mapAction;
                this.a.b.sendClose(close.getId(), close.getAnalytics());
                return Observable.empty();
            } else if (!(mapAction instanceof MapViewAction.Snippet.Visibility)) {
                return Observable.empty();
            } else {
                MapViewAction.Snippet.Visibility visibility = (MapViewAction.Snippet.Visibility) mapAction;
                if (visibility.isVisible()) {
                    this.a.b.sendShow(visibility.getId(), visibility.getAnalytics());
                } else {
                    this.a.b.sendHide(visibility.getId(), visibility.getAnalytics());
                }
                return Observable.empty();
            }
        }
    }

    @Inject
    public SubscriptionMiddleware(@NotNull Analytics analytics, @NotNull SerpSnippetInteractor serpSnippetInteractor, @NotNull SerpCacheInteractor serpCacheInteractor) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(serpSnippetInteractor, "serpSnippetInteractor");
        Intrinsics.checkNotNullParameter(serpCacheInteractor, "serpCacheInteractor");
        this.a = analytics;
        this.b = serpSnippetInteractor;
        this.c = serpCacheInteractor;
    }

    @Override // com.avito.android.redux.Middleware
    @NotNull
    public Observable<MapAction> create(@NotNull Observable<MapAction> observable, @NotNull Observable<SearchMapState> observable2) {
        Intrinsics.checkNotNullParameter(observable, "actions");
        Intrinsics.checkNotNullParameter(observable2, "state");
        Observable<MapAction> flatMap = ObservablesKt.withLatestFrom(observable, observable2).flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "actions.withLatestFrom(s…          }\n            }");
        return flatMap;
    }
}
