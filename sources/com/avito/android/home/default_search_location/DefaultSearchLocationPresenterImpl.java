package com.avito.android.home.default_search_location;

import a2.a.a.a1.c0.c;
import a2.a.a.a1.c0.d;
import a2.a.a.a1.c0.e;
import a2.a.a.a1.c0.f;
import a2.a.a.a1.c0.h;
import a2.a.a.a1.c0.i;
import a2.a.a.a1.c0.j;
import a2.g.r.g;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationKt;
import com.avito.android.server_time.TimeSource;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.stories.StartupBannerLocker;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010L\u001a\u00020I¢\u0006\u0004\bS\u0010TJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\\\u0010)\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 %*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 %*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 %*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010/\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010\u0010R\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006U"}, d2 = {"Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenterImpl;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "Lio/reactivex/rxjava3/core/Observable;", "Lorg/funktionale/option/Option;", "", "permissionStream", "()Lio/reactivex/rxjava3/core/Observable;", "", "sendEventFromFirstRun", "()V", "sendScreenExitAfterCoordinatesResolve", "Lcom/avito/android/remote/model/Location;", "location", "onDefaultLocationChanged", "(Lcom/avito/android/remote/model/Location;)V", "e", "Z", "changeLocation", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;", "l", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;", "analyticsInteractor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/stories/StartupBannerLocker;", "d", "Lcom/avito/android/stories/StartupBannerLocker;", "startupBannerLocker", "f", "isChangeCoordinates", "Lcom/avito/android/server_time/TimeSource;", "p", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "relay", AuthSource.SEND_ABUSE, "getSendingUserCoordinates", "()Z", "setSendingUserCoordinates", "(Z)V", "sendingUserCoordinates", "Lcom/avito/android/location/SavedLocationInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/location/SavedLocationInteractor;", "savedLocationInteractor", "Lcom/avito/android/geo/GeoStorage;", "n", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "", "i", "J", "coordinateResolveTime", g.a, "Lcom/avito/android/remote/model/Location;", "defaultLocation", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "o", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "locationPermissionStorage", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "h", "isInitialized", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", VKApiConst.Q, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "k", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "interactor", "Lcom/avito/android/stories/StartupBannerInteractor;", "startupBannerInteractor", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;Lcom/avito/android/home/default_search_location/DefaultSearchLocationAnalyticsInteractor;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/stories/StartupBannerInteractor;Lcom/avito/android/geo/GeoStorage;Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultSearchLocationPresenterImpl implements DefaultSearchLocationPresenter {
    public boolean a;
    public final BehaviorRelay<Option<Boolean>> b = BehaviorRelay.createDefault(Option.None.INSTANCE);
    public final CompositeDisposable c = new CompositeDisposable();
    public final StartupBannerLocker d;
    public boolean e;
    public boolean f;
    public Location g;
    public boolean h;
    public long i;
    public final SchedulersFactory3 j;
    public final DefaultSearchLocationInteractor k;
    public final DefaultSearchLocationAnalyticsInteractor l;
    public final SavedLocationInteractor m;
    public final GeoStorage n;
    public final DefaultSearchLocationStorage o;
    public final TimeSource p;
    public final LocationPermissionDialogPresenter q;

    public static final class a<T> implements Consumer<Option<? extends Boolean>> {
        public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

        public a(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
            this.a = defaultSearchLocationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Option<? extends Boolean> option) {
            if (!this.a.h) {
                this.a.h = true;
                DefaultSearchLocationPresenterImpl.access$checkPermission(this.a);
            }
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

        public b(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
            this.a = defaultSearchLocationPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.c.clear();
            this.a.h = false;
        }
    }

    public DefaultSearchLocationPresenterImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull DefaultSearchLocationInteractor defaultSearchLocationInteractor, @NotNull DefaultSearchLocationAnalyticsInteractor defaultSearchLocationAnalyticsInteractor, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull StartupBannerInteractor startupBannerInteractor, @NotNull GeoStorage geoStorage, @NotNull DefaultSearchLocationStorage defaultSearchLocationStorage, @NotNull TimeSource timeSource, @NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(defaultSearchLocationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(defaultSearchLocationAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "savedLocationInteractor");
        Intrinsics.checkNotNullParameter(startupBannerInteractor, "startupBannerInteractor");
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        Intrinsics.checkNotNullParameter(defaultSearchLocationStorage, "locationPermissionStorage");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter, "locationPermissionDialogPresenter");
        this.j = schedulersFactory3;
        this.k = defaultSearchLocationInteractor;
        this.l = defaultSearchLocationAnalyticsInteractor;
        this.m = savedLocationInteractor;
        this.n = geoStorage;
        this.o = defaultSearchLocationStorage;
        this.p = timeSource;
        this.q = locationPermissionDialogPresenter;
        this.d = startupBannerInteractor.lockStartupBanner();
        this.f = defaultSearchLocationStorage.isChangeCoordinates();
    }

    public static final void access$checkPermission(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        if (defaultSearchLocationPresenterImpl.f) {
            defaultSearchLocationPresenterImpl.l.sendFindCoordinates(FindLocationPage.OPEN_APP.getValue());
        } else {
            defaultSearchLocationPresenterImpl.l.sendFindCoordinates(FindLocationPage.FIRST_LAUNCH.getValue());
        }
        CompositeDisposable compositeDisposable = defaultSearchLocationPresenterImpl.c;
        Disposable subscribe = defaultSearchLocationPresenterImpl.q.requestLocation().observeOn(defaultSearchLocationPresenterImpl.j.mainThread()).subscribe(new a2.a.a.a1.c0.a(defaultSearchLocationPresenterImpl), new a2.a.a.a1.c0.b(defaultSearchLocationPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "hasPermission()\n        …ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final Location access$createLocationWithCoordinates(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl, Coordinates coordinates) {
        Objects.requireNonNull(defaultSearchLocationPresenterImpl);
        return LocationKt.createLocationWithCoordinates("", "", coordinates);
    }

    public static final Observable access$getDefaultLocation(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        defaultSearchLocationPresenterImpl.i = defaultSearchLocationPresenterImpl.p.now();
        Single<R> map = defaultSearchLocationPresenterImpl.k.defaultLocation().doOnSuccess(new c(defaultSearchLocationPresenterImpl)).doOnError(new d(defaultSearchLocationPresenterImpl)).map(e.a);
        Intrinsics.checkNotNullExpressionValue(map, "interactor.defaultLocati…latitude, it.longitude) }");
        Observable<R> observable = map.doOnSuccess(new f(defaultSearchLocationPresenterImpl)).filter(new a2.a.a.a1.c0.g(defaultSearchLocationPresenterImpl)).map(new h(defaultSearchLocationPresenterImpl)).doOnSuccess(new i(defaultSearchLocationPresenterImpl)).onErrorResumeNext(j.a).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "doOnSuccess { defaultLoc…          .toObservable()");
        return observable;
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider
    public boolean getSendingUserCoordinates() {
        return this.a;
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationPresenter
    public void onDefaultLocationChanged(@Nullable Location location) {
        SavedLocationInteractor.DefaultImpls.saveLocation$default(this.m, location, null, true, 2, null);
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider
    @NotNull
    public Observable<Option<Boolean>> permissionStream() {
        Observable<Option<Boolean>> doOnDispose = this.b.doOnNext(new a(this)).doOnDispose(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "relay\n        .doOnNext …ialized = false\n        }");
        return doOnDispose;
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider
    public void sendEventFromFirstRun() {
        android.location.Location location = this.n.getLocation();
        if (location != null) {
            setSendingUserCoordinates(true);
            this.l.sendUserCoordinates(location, null, FindLocationPage.FIRST_LAUNCH.getValue());
        }
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider
    public void sendScreenExitAfterCoordinatesResolve() {
        this.l.sendScreenExitAfterCoordinatesResolve();
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider
    public void setSendingUserCoordinates(boolean z) {
        this.a = z;
    }
}
