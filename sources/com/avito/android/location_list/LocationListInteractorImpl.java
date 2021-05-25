package com.avito.android.location_list;

import android.os.Bundle;
import androidx.collection.LruCache;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.LocationsNotFoundErrorCase;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationResponse;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Bundles;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\b\u00103\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\b0\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\b0\u00072\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\b0\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J_\u0010\u001e\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u001d*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\b \u001d*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u001d*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\b\u0018\u00010\u00070\u0007\"\b\b\u0000\u0010\u001c*\u00020\u001b*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/avito/android/location_list/LocationListInteractorImpl;", "Lcom/avito/android/location_list/LocationListInteractor;", "Landroid/os/Bundle;", "getState", "()Landroid/os/Bundle;", "", "locationId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/Location;", "getLocation", "(Ljava/lang/String;)Lio/reactivex/Observable;", "lat", MessageBody.Location.LONGITUDE, "getNearestLocation", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "searchQuery", "", "getSearchLocations", "getUsedLocations", "(Ljava/lang/String;)Ljava/util/List;", "parent", "getChildrenLocations", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/Observable;", "getTopLocation", "()Lio/reactivex/Observable;", "getTopLocations", "", "T", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "cache", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/LocationApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/LocationApi;", "api", "Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;", "e", "Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;", "errorCase", "state", "<init>", "(Landroid/os/Bundle;Lcom/avito/android/remote/LocationApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/remote/error/LocationsNotFoundErrorCase;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListInteractorImpl implements LocationListInteractor {
    public LruCache<String, List<Location>> a = new LruCache<>(20);
    public final LocationApi b;
    public final SchedulersFactory c;
    public final TypedErrorThrowableConverter d;
    public final LocationsNotFoundErrorCase e;

    public static final class a<T, R> implements Function<LocationResponse, Location> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Location apply(LocationResponse locationResponse) {
            LocationResponse locationResponse2 = locationResponse;
            Intrinsics.checkNotNullParameter(locationResponse2, "it");
            Location location = locationResponse2.getLocation();
            Objects.requireNonNull(location, "null cannot be cast to non-null type com.avito.android.remote.model.Location");
            return location;
        }
    }

    public static final class b<T, R> implements Function<T, LoadingState<? super T>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return new LoadingState.Loaded(obj);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super T>> {
        public final /* synthetic */ LocationListInteractorImpl a;

        public c(LocationListInteractorImpl locationListInteractorImpl) {
            this.a = locationListInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.d.convertWithSpecialErrorCase(th2, this.a.e));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: androidx.collection.LruCache<java.lang.String, java.util.List<com.avito.android.remote.model.Location>> */
    /* JADX WARN: Multi-variable type inference failed */
    public LocationListInteractorImpl(@Nullable Bundle bundle, @NotNull LocationApi locationApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocationsNotFoundErrorCase locationsNotFoundErrorCase) {
        Intrinsics.checkNotNullParameter(locationApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(locationsNotFoundErrorCase, "errorCase");
        this.b = locationApi;
        this.c = schedulersFactory;
        this.d = typedErrorThrowableConverter;
        this.e = locationsNotFoundErrorCase;
        Map mapOfParcelablesList = bundle != null ? Bundles.getMapOfParcelablesList(bundle, "cache") : null;
        if (mapOfParcelablesList != null) {
            for (Map.Entry entry : mapOfParcelablesList.entrySet()) {
                this.a.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public final <T> Observable<LoadingState<T>> a(Observable<T> observable) {
        return observable.subscribeOn(this.c.io()).map(b.a).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE)).onErrorReturn(new c(this));
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Observable<LoadingState<List<Location>>> getChildrenLocations(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "parent");
        Observable subscribeOn = InteropKt.toV2(this.b.getChildrenLocations(location.getId())).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getChildrenLocations…scribeOn(schedulers.io())");
        Observable<LoadingState<List<Location>>> a3 = a(subscribeOn);
        Intrinsics.checkNotNullExpressionValue(a3, "api.getChildrenLocations…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Observable<LoadingState<Location>> getLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        Observable subscribeOn = InteropKt.toV2(this.b.getLocation(str)).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getLocation(location…scribeOn(schedulers.io())");
        Observable<LoadingState<Location>> a3 = a(subscribeOn);
        Intrinsics.checkNotNullExpressionValue(a3, "api.getLocation(location…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Observable<LoadingState<Location>> getNearestLocation(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, MessageBody.Location.LONGITUDE);
        Observable subscribeOn = InteropKt.toV2(this.b.getNearestLocation(str, str2)).map(a.a).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getNearestLocation(l…scribeOn(schedulers.io())");
        Observable<LoadingState<Location>> a3 = a(subscribeOn);
        Intrinsics.checkNotNullExpressionValue(a3, "api.getNearestLocation(l…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Observable<LoadingState<List<Location>>> getSearchLocations(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        List<Location> list = this.a.get(str);
        StringBuilder R = a2.b.a.a.a.R("search get query: ", str, " ");
        R.append(list != null);
        Logs.debug$default("LocationListInteractor", R.toString(), null, 4, null);
        if (list == null) {
            Observable subscribeOn = InteropKt.toV2(this.b.getSearchLocations(str)).doOnNext(new a2.a.a.m1.a(this, str)).map(a2.a.a.m1.b.a).subscribeOn(this.c.io());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getSearchLocations(s…scribeOn(schedulers.io())");
            Observable<LoadingState<List<Location>>> a3 = a(subscribeOn);
            Intrinsics.checkNotNullExpressionValue(a3, "api.getSearchLocations(s…        .toLoadingState()");
            return a3;
        }
        Observable<LoadingState<List<Location>>> just = Observable.just(new LoadingState.Loaded(list));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Bundle getState() {
        return Bundles.putMapOfParcelablesList(new Bundle(), "cache", this.a.snapshot());
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Observable<LoadingState<Location>> getTopLocation() {
        Observable subscribeOn = InteropKt.toV2(this.b.getTopLocation()).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getTopLocation().toV…scribeOn(schedulers.io())");
        Observable<LoadingState<Location>> a3 = a(subscribeOn);
        Intrinsics.checkNotNullExpressionValue(a3, "api.getTopLocation().toV…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @NotNull
    public Observable<LoadingState<List<Location>>> getTopLocations() {
        Observable subscribeOn = InteropKt.toV2(this.b.getTopLocations()).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getTopLocations().to…scribeOn(schedulers.io())");
        Observable<LoadingState<List<Location>>> a3 = a(subscribeOn);
        Intrinsics.checkNotNullExpressionValue(a3, "api.getTopLocations().to…        .toLoadingState()");
        return a3;
    }

    @Override // com.avito.android.location_list.LocationListInteractor
    @Nullable
    public List<Location> getUsedLocations(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        return this.a.get(str);
    }
}
