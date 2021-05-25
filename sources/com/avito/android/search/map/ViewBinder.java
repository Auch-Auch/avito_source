package com.avito.android.search.map;

import a2.g.r.g;
import com.avito.android.di.PerFragment;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.redux.Store;
import com.avito.android.redux.SubscribableStore;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.StartAction;
import com.avito.android.search.map.view.PinAdvertsListViewBinder;
import com.avito.android.search.map.view.PinAdvertsView;
import com.avito.android.search.map.view.SerpListView;
import com.avito.android.search.map.view.SerpListViewBinder;
import com.avito.android.search.map.view.advert.AdvertItemEventListener;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u001c\u0010-\u001a\u0018\u0012\t\u0012\u00070\f¢\u0006\u0002\b*\u0012\t\u0012\u00070\r¢\u0006\u0002\b*0)\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b2\u00103J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R,\u0010-\u001a\u0018\u0012\t\u0012\u00070\f¢\u0006\u0002\b*\u0012\t\u0012\u00070\r¢\u0006\u0002\b*0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/search/map/ViewBinder;", "", "Lcom/avito/android/search/map/SearchMapView;", "view", "Lcom/avito/android/search/map/view/PinAdvertsView;", "pinAdvertsView", "Lcom/avito/android/search/map/view/SerpListView;", "serpListView", "", "bind", "(Lcom/avito/android/search/map/SearchMapView;Lcom/avito/android/search/map/view/PinAdvertsView;Lcom/avito/android/search/map/view/SerpListView;)V", "Lcom/avito/android/redux/Store;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "getStore", "()Lcom/avito/android/redux/Store;", "stop", "()V", "unbind", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "d", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "pinAdvertsBinder", "Lcom/avito/android/search/map/view/SerpListViewBinder;", "e", "Lcom/avito/android/search/map/view/SerpListViewBinder;", "serpListViewBinder", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "f", "Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "eventListener", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/map/view/SerpListView;", "Lcom/avito/android/redux/SubscribableStore;", "Lkotlin/jvm/JvmWildcard;", "c", "Lcom/avito/android/redux/SubscribableStore;", "store", "Lcom/avito/android/location/SavedLocationInteractor;", "h", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "<init>", "(Lcom/avito/android/redux/SubscribableStore;Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;Lcom/avito/android/search/map/view/SerpListViewBinder;Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/location/SavedLocationInteractor;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class ViewBinder {
    public final CompositeDisposable a = new CompositeDisposable();
    public SerpListView b;
    public final SubscribableStore<SearchMapState, ? super MapAction> c;
    public final PinAdvertsListViewBinder d;
    public final SerpListViewBinder e;
    public final AdvertItemEventListener f;
    public final SchedulersFactory3 g;
    public final SavedLocationInteractor h;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error("ViewBinder", "store.stateChanges error", th);
            } else if (i == 1) {
                Logs.error("ViewBinder", "view actions error", th);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<SearchMapState> {
        public final /* synthetic */ ViewBinder a;
        public final /* synthetic */ SearchMapView b;
        public final /* synthetic */ PinAdvertsView c;
        public final /* synthetic */ SerpListView d;

        public b(ViewBinder viewBinder, SearchMapView searchMapView, PinAdvertsView pinAdvertsView, SerpListView serpListView) {
            this.a = viewBinder;
            this.b = searchMapView;
            this.c = pinAdvertsView;
            this.d = serpListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SearchMapState searchMapState) {
            SearchMapState searchMapState2 = searchMapState;
            String locationId = searchMapState2.getSearchParams().getLocationId();
            if (locationId != null && this.a.h.isCorrectLocation(locationId)) {
                SearchMapView searchMapView = this.b;
                Intrinsics.checkNotNullExpressionValue(searchMapState2, "state");
                searchMapView.render(searchMapState2);
                this.c.render(searchMapState2);
                if (!searchMapState2.getShowSimpleMap()) {
                    this.d.render(searchMapState2);
                }
            }
        }
    }

    public static final class c<T> implements Consumer<MapAction> {
        public final /* synthetic */ ViewBinder a;

        public c(ViewBinder viewBinder) {
            this.a = viewBinder;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MapAction mapAction) {
            MapAction mapAction2 = mapAction;
            SubscribableStore subscribableStore = this.a.c;
            Intrinsics.checkNotNullExpressionValue(mapAction2, "it");
            subscribableStore.dispatch(mapAction2);
        }
    }

    @Inject
    public ViewBinder(@NotNull SubscribableStore<SearchMapState, ? super MapAction> subscribableStore, @NotNull PinAdvertsListViewBinder pinAdvertsListViewBinder, @NotNull SerpListViewBinder serpListViewBinder, @NotNull AdvertItemEventListener advertItemEventListener, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SavedLocationInteractor savedLocationInteractor) {
        Intrinsics.checkNotNullParameter(subscribableStore, "store");
        Intrinsics.checkNotNullParameter(pinAdvertsListViewBinder, "pinAdvertsBinder");
        Intrinsics.checkNotNullParameter(serpListViewBinder, "serpListViewBinder");
        Intrinsics.checkNotNullParameter(advertItemEventListener, "eventListener");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        this.c = subscribableStore;
        this.d = pinAdvertsListViewBinder;
        this.e = serpListViewBinder;
        this.f = advertItemEventListener;
        this.g = schedulersFactory3;
        this.h = savedLocationInteractor;
    }

    public final void bind(@NotNull SearchMapView searchMapView, @NotNull PinAdvertsView pinAdvertsView, @NotNull SerpListView serpListView) {
        Intrinsics.checkNotNullParameter(searchMapView, "view");
        Intrinsics.checkNotNullParameter(pinAdvertsView, "pinAdvertsView");
        Intrinsics.checkNotNullParameter(serpListView, "serpListView");
        this.b = serpListView;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.c.stateChanges().observeOn(this.g.mainThread()).subscribe(new b(this, searchMapView, pinAdvertsView, serpListView), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "store.stateChanges()\n   …ror\", err)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = Observable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Observable[]{searchMapView.getActions(), pinAdvertsView.getActions(), serpListView.getActions(), this.f.events()})).subscribe(new c(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "Observable.merge(\n      …s error\", err)\n        })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        DisposableKt.plusAssign(this.a, this.c.subscribe());
        this.d.bind(pinAdvertsView);
        this.e.bind(serpListView);
        this.c.dispatch(new StartAction());
    }

    @NotNull
    public final Store<SearchMapState, MapAction> getStore() {
        return this.c;
    }

    public final void stop() {
        this.a.clear();
    }

    public final void unbind() {
        SerpListView serpListView = this.b;
        if (serpListView != null) {
            serpListView.destroy();
        }
        this.b = null;
        this.a.clear();
        this.d.unbind();
        this.e.unbind();
    }
}
