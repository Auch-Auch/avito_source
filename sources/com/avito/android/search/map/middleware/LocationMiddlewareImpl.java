package com.avito.android.search.map.middleware;

import a2.a.a.k2.b.g.n;
import a2.a.a.k2.b.g.o;
import a2.a.a.k2.b.g.p;
import a2.a.a.k2.b.g.q;
import android.app.Activity;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.StartAction;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.ObservablesKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/search/map/middleware/LocationMiddlewareImpl;", "Lcom/avito/android/search/map/middleware/LocationMiddleware;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapAction;", "actions", "Lcom/avito/android/search/map/SearchMapState;", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/permissions/LocationPermissionProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/permissions/LocationPermissionProvider;", "locationPermissionProvider", "Lcom/avito/android/location/find/FindLocationPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", "Landroid/app/Activity;", "c", "Landroid/app/Activity;", "activity", "<init>", "(Lcom/avito/android/permissions/LocationPermissionProvider;Lcom/avito/android/location/find/FindLocationPresenter;Landroid/app/Activity;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class LocationMiddlewareImpl implements LocationMiddleware {
    public final LocationPermissionProvider a;
    public final FindLocationPresenter b;
    public final Activity c;

    public static final class a<T, R> implements Function<Pair<? extends MapAction, ? extends SearchMapState>, ObservableSource<? extends MapAction>> {
        public final /* synthetic */ LocationMiddlewareImpl a;

        public a(LocationMiddlewareImpl locationMiddlewareImpl) {
            this.a = locationMiddlewareImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MapAction> apply(Pair<? extends MapAction, ? extends SearchMapState> pair) {
            MapAction mapAction = (MapAction) pair.component1();
            if (mapAction instanceof StartAction) {
                if (!this.a.a.isPermissionGranted()) {
                    return Observable.empty();
                }
                Observable<R> map = FindLocationPresenter.DefaultImpls.findLocation$default(this.a.b, this.a.c, false, 2, null).map(n.a);
                Intrinsics.checkNotNullExpressionValue(map, "findLocationPresenter.fi…it)\n                    }");
                Observable<R> onErrorResumeWith = map.doOnError(LocationMiddlewareImpl$convertToEmptyOnError$1.INSTANCE).onErrorResumeWith(Observable.empty());
                Intrinsics.checkNotNullExpressionValue(onErrorResumeWith, "doOnError { Logs.error(i…eWith(Observable.empty())");
                return onErrorResumeWith;
            } else if (mapAction instanceof MapViewAction.FindMeButtonClicked) {
                if (!this.a.a.isPermissionGranted()) {
                    return this.a.a.isPermissionsGrantedDialog().toObservable().map(p.a);
                }
                Observable<R> map2 = FindLocationPresenter.DefaultImpls.findLocation$default(this.a.b, this.a.c, false, 2, null).map(o.a);
                Intrinsics.checkNotNullExpressionValue(map2, "findLocationPresenter.fi…it)\n                    }");
                Observable<R> onErrorResumeWith2 = map2.doOnError(LocationMiddlewareImpl$convertToEmptyOnError$1.INSTANCE).onErrorResumeWith(Observable.empty());
                Intrinsics.checkNotNullExpressionValue(onErrorResumeWith2, "doOnError { Logs.error(i…eWith(Observable.empty())");
                return onErrorResumeWith2;
            } else if (mapAction instanceof MapViewAction.CheckLocationRationale) {
                return this.a.a.isRequestRationale().toObservable().map(q.a);
            } else {
                return Observable.empty();
            }
        }
    }

    @Inject
    public LocationMiddlewareImpl(@NotNull LocationPermissionProvider locationPermissionProvider, @NotNull FindLocationPresenter findLocationPresenter, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, "locationPermissionProvider");
        Intrinsics.checkNotNullParameter(findLocationPresenter, "findLocationPresenter");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = locationPermissionProvider;
        this.b = findLocationPresenter;
        this.c = activity;
    }

    public static final /* synthetic */ Observable access$convertToEmptyOnError(LocationMiddlewareImpl locationMiddlewareImpl, Observable observable) {
        Objects.requireNonNull(locationMiddlewareImpl);
        Observable onErrorResumeWith = observable.doOnError(LocationMiddlewareImpl$convertToEmptyOnError$1.INSTANCE).onErrorResumeWith(Observable.empty());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeWith, "doOnError { Logs.error(i…eWith(Observable.empty())");
        return onErrorResumeWith;
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
}
