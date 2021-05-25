package com.avito.android.location;

import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001bB1\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b3\u00104J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J)\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u001a0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/location/SavedLocationInteractorImpl;", "Lcom/avito/android/location/SavedLocationInteractor;", "Lcom/avito/android/location/LocationSource;", "source", "", "silently", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Location;", "savedLocation", "(Lcom/avito/android/location/LocationSource;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location/SavedLocation;", "fullSavedLocation", "Lcom/avito/android/location/SavedLocationInteractor$AnalyticsInfoLocation;", "wrappedLocation", "getLocationForSearch", "()Lcom/avito/android/remote/model/Location;", "location", "locationForcedByUser", "", "saveLocation", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/location/LocationSource;Z)V", "", "locationId", "checkLocationForSearch", "(Ljava/lang/String;)Z", "isCorrectLocation", "Lkotlin/Pair;", AuthSource.SEND_ABUSE, "(Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location/SavedLocationStorage;", "Lcom/avito/android/location/SavedLocationStorage;", "locationStorage", "Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;", "e", "Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;", "backNavigationLocationInteractor", "Lcom/avito/android/TopLocationInteractor;", "c", "Lcom/avito/android/TopLocationInteractor;", "topLocationInteractor", "Lcom/avito/android/remote/LocationApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/LocationApi;", "locationApi", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "getOnLocationChanged", "()Lio/reactivex/rxjava3/core/Observable;", "onLocationChanged", "<init>", "(Lcom/avito/android/location/SavedLocationStorage;Lcom/avito/android/remote/LocationApi;Lcom/avito/android/TopLocationInteractor;Lcom/avito/android/Features;Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class SavedLocationInteractorImpl implements SavedLocationInteractor {
    public final SavedLocationStorage a;
    public final LocationApi b;
    public final TopLocationInteractor c;
    public final Features d;
    public final BackNavigationLocationInteractor e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LocationSource.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[6] = 2;
        }
    }

    public static final class a implements SavedLocationStorage.OnLocationChangedListener {
        public final Emitter<Unit> a;

        public a(@NotNull Emitter<Unit> emitter) {
            Intrinsics.checkNotNullParameter(emitter, "emitter");
            this.a = emitter;
        }

        @Override // com.avito.android.location.SavedLocationStorage.OnLocationChangedListener
        public void onLocationChanged() {
            this.a.onNext(Unit.INSTANCE);
        }
    }

    public static final class b<T, R> implements Function<Pair<? extends SavedLocation, ? extends LocationSource>, SavedLocation> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SavedLocation apply(Pair<? extends SavedLocation, ? extends LocationSource> pair) {
            return (SavedLocation) pair.getFirst();
        }
    }

    public static final class c<T, R> implements Function<SavedLocation, Pair<? extends SavedLocation, ? extends LocationSource>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Pair<? extends SavedLocation, ? extends LocationSource> apply(SavedLocation savedLocation) {
            return new Pair<>(savedLocation, LocationSource.LOCATION_FROM_LIST);
        }
    }

    public static final class d<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ SavedLocationInteractorImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ d a;
            public final /* synthetic */ a b;

            public a(d dVar, a aVar) {
                this.a = dVar;
                this.b = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.a.removeLocationChangedListener(this.b);
            }
        }

        public d(SavedLocationInteractorImpl savedLocationInteractorImpl) {
            this.a = savedLocationInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            a aVar = new a(observableEmitter);
            this.a.a.addLocationChangedListener(aVar);
            observableEmitter.setCancellable(new a(this, aVar));
        }
    }

    public static final class e<T, R> implements Function<SavedLocation, Location> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Location apply(SavedLocation savedLocation) {
            SavedLocation savedLocation2 = savedLocation;
            return Location.copy$default(savedLocation2.getLocation(), null, null, false, false, false, false, null, savedLocation2.getForcedByUser(), null, null, 895, null);
        }
    }

    public static final class f<T, R> implements Function<Pair<? extends SavedLocation, ? extends LocationSource>, SavedLocationInteractor.AnalyticsInfoLocation> {
        public final /* synthetic */ SavedLocationInteractorImpl a;

        public f(SavedLocationInteractorImpl savedLocationInteractorImpl) {
            this.a = savedLocationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SavedLocationInteractor.AnalyticsInfoLocation apply(Pair<? extends SavedLocation, ? extends LocationSource> pair) {
            Pair<? extends SavedLocation, ? extends LocationSource> pair2 = pair;
            return new SavedLocationInteractor.AnalyticsInfoLocation(this.a.a.getStorageTypesInfo(), (LocationSource) pair2.getSecond(), (SavedLocation) pair2.getFirst());
        }
    }

    @Inject
    public SavedLocationInteractorImpl(@NotNull SavedLocationStorage savedLocationStorage, @NotNull LocationApi locationApi, @NotNull TopLocationInteractor topLocationInteractor, @NotNull Features features, @NotNull BackNavigationLocationInteractor backNavigationLocationInteractor) {
        Intrinsics.checkNotNullParameter(savedLocationStorage, "locationStorage");
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(topLocationInteractor, "topLocationInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(backNavigationLocationInteractor, "backNavigationLocationInteractor");
        this.a = savedLocationStorage;
        this.b = locationApi;
        this.c = topLocationInteractor;
        this.d = features;
        this.e = backNavigationLocationInteractor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r3 != null) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.reactivex.rxjava3.core.Observable<kotlin.Pair<com.avito.android.location.SavedLocation, com.avito.android.location.LocationSource>> a(boolean r3) {
        /*
            r2 = this;
            com.avito.android.location.back_navigation.BackNavigationLocationInteractor r0 = r2.e
            com.avito.android.location.LocationSource r1 = com.avito.android.location.LocationSource.LOCATION_FROM_FILTERS
            java.lang.String r1 = r1.getValue()
            com.avito.android.remote.model.Location r0 = r0.getLocation(r1)
            if (r0 == 0) goto L_0x0015
            com.avito.android.location.SavedLocation r3 = new com.avito.android.location.SavedLocation
            r1 = 1
            r3.<init>(r0, r1, r1)
            goto L_0x001d
        L_0x0015:
            com.avito.android.location.SavedLocationStorage r0 = r2.a
            com.avito.android.location.LocationSource r1 = com.avito.android.location.LocationSource.LOCATION_FROM_LIST
            com.avito.android.location.SavedLocation r3 = r0.getLocation(r1, r3)
        L_0x001d:
            if (r3 == 0) goto L_0x002b
            io.reactivex.rxjava3.core.Observable r3 = io.reactivex.rxjava3.core.Observable.just(r3)
            java.lang.String r0 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            if (r3 == 0) goto L_0x002b
            goto L_0x005e
        L_0x002b:
            com.avito.android.Features r3 = r2.d
            com.avito.android.toggle.Feature r3 = r3.getTopLocationSingleRequest()
            java.lang.Object r3 = r3.invoke()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0044
            com.avito.android.TopLocationInteractor r3 = r2.c
            io.reactivex.rxjava3.core.Observable r3 = r3.getTopLocation()
            goto L_0x004a
        L_0x0044:
            com.avito.android.remote.LocationApi r3 = r2.b
            io.reactivex.rxjava3.core.Observable r3 = r3.getTopLocation()
        L_0x004a:
            a2.a.a.l1.a r0 = new a2.a.a.l1.a
            r0.<init>(r2)
            io.reactivex.rxjava3.core.Observable r3 = r3.doOnNext(r0)
            a2.a.a.l1.b r0 = a2.a.a.l1.b.a
            io.reactivex.rxjava3.core.Observable r3 = r3.map(r0)
            java.lang.String r0 = "getTopLocation()\n       …t.toSavedLocation(true) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
        L_0x005e:
            com.avito.android.location.SavedLocationInteractorImpl$c r0 = com.avito.android.location.SavedLocationInteractorImpl.c.a
            io.reactivex.rxjava3.core.Observable r3 = r3.map(r0)
            java.lang.String r0 = "(location?.toSingletonOb…TION_FROM_LIST)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location.SavedLocationInteractorImpl.a(boolean):io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    public boolean checkLocationForSearch(@NotNull String str) {
        String id;
        Boolean bool;
        String id2;
        Intrinsics.checkNotNullParameter(str, "locationId");
        Location location = this.e.getLocation(LocationSource.LOCATION_FOR_SEARCH.getValue());
        if (location == null || (id = location.getId()) == null) {
            return false;
        }
        Location location2 = this.e.getLocation(LocationSource.LOCATION_FROM_FILTERS.getValue());
        if (location2 == null || (id2 = location2.getId()) == null) {
            bool = null;
        } else {
            boolean z = true;
            if (!(!Intrinsics.areEqual(str, id)) || !Intrinsics.areEqual(id, id2)) {
                z = false;
            }
            bool = Boolean.valueOf(z);
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    @NotNull
    public Observable<SavedLocation> fullSavedLocation(@Nullable LocationSource locationSource, boolean z) {
        Observable<R> map = a(z).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "locationDefault(silently…       it.first\n        }");
        return map;
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    @Nullable
    public Location getLocationForSearch() {
        return this.e.getLocation(LocationSource.LOCATION_FROM_FILTERS.getValue());
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    @NotNull
    public Observable<Unit> getOnLocationChanged() {
        Observable<Unit> create = Observable.create(new d(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…listener) }\n            }");
        return create;
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    public boolean isCorrectLocation(@NotNull String str) {
        String id;
        Intrinsics.checkNotNullParameter(str, "locationId");
        Location location = this.e.getLocation(LocationSource.LOCATION_FOR_SEARCH.getValue());
        if (location == null || (id = location.getId()) == null) {
            return true;
        }
        Location location2 = this.e.getLocation(LocationSource.LOCATION_FROM_FILTERS.getValue());
        if (Intrinsics.areEqual(str, location2 != null ? location2.getId() : null) || Intrinsics.areEqual(str, id)) {
            return true;
        }
        return false;
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    public void saveLocation(@Nullable Location location, @Nullable LocationSource locationSource, boolean z) {
        if (location != null) {
            if ((location.getId().length() > 0) || location.getCoordinates() != null) {
                if (locationSource != null) {
                    int ordinal = locationSource.ordinal();
                    if (ordinal == 2) {
                        this.e.setLocation(LocationSource.LOCATION_FROM_FILTERS.getValue(), location);
                        return;
                    } else if (ordinal == 6) {
                        this.e.setLocation(LocationSource.LOCATION_FOR_SEARCH.getValue(), location);
                        return;
                    }
                }
                this.a.saveLocation(location, locationSource, z);
                return;
            }
        }
        this.a.removeLocation();
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    @NotNull
    public Observable<Location> savedLocation(@Nullable LocationSource locationSource, boolean z) {
        Observable<R> map = fullSavedLocation(locationSource, z).map(e.a);
        Intrinsics.checkNotNullExpressionValue(map, "fullSavedLocation(source… = it.forcedByUser)\n    }");
        return map;
    }

    @Override // com.avito.android.location.SavedLocationInteractor
    @NotNull
    public Observable<SavedLocationInteractor.AnalyticsInfoLocation> wrappedLocation(@Nullable LocationSource locationSource, boolean z) {
        Observable<R> map = a(z).map(new f(this));
        Intrinsics.checkNotNullExpressionValue(map, "locationDefault(silently…d\n            )\n        }");
        return map;
    }
}
