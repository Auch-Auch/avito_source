package com.avito.android.location_picker.view;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.location_picker.MapTransformationsProvider;
import com.avito.android.location_picker.entities.ChangeAdvertsCountUpdate;
import com.avito.android.location_picker.entities.ChangeRadiusUpdate;
import com.avito.android.location_picker.entities.LocationPickerNotification;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.RadiusWidgetUpdate;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/location_picker/view/LocationPickerInputView;", "view", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "stateObservable", "Lcom/avito/android/location_picker/MapTransformationsProvider;", "mapTransformationsProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeInputView", "(Lcom/avito/android/location_picker/view/LocationPickerInputView;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/location_picker/MapTransformationsProvider;)Lio/reactivex/rxjava3/disposables/Disposable;", "location-picker_release"}, k = 2, mv = {1, 4, 2})
public final class LocationPickerViewChangerKt {

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<LocationPickerState> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public static final a f = new a(4);
        public static final a g = new a(5);
        public static final a h = new a(6);
        public static final a i = new a(7);
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public final boolean test(LocationPickerState locationPickerState) {
            switch (this.a) {
                case 0:
                    return !locationPickerState.getSearchHasFocus();
                case 1:
                    if (locationPickerState.getRadiusState().getRadiusId().length() > 0) {
                        return true;
                    }
                    return false;
                case 2:
                    return !locationPickerState.getRadiusState().getRadiusList().isEmpty();
                case 3:
                    LocationPickerState locationPickerState2 = locationPickerState;
                    if (locationPickerState2.getAddressValidationState().getCurrentAddressIsValid()) {
                        return false;
                    }
                    if (locationPickerState2.getAddressValidationState().getError().length() > 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (locationPickerState.getRadiusState().getAdvertsCount() != -1) {
                        return true;
                    }
                    return false;
                case 5:
                    return locationPickerState.getRadiusState().getRadiusSelected();
                case 6:
                    return locationPickerState.getCoordsVerified();
                case 7:
                    return !locationPickerState.getCameraMoving();
                default:
                    throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T1, T2> implements BiPredicate<LocationPickerState, LocationPickerState> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public static final b e = new b(3);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiPredicate
        public final boolean test(LocationPickerState locationPickerState, LocationPickerState locationPickerState2) {
            int i = this.a;
            if (i == 0) {
                LocationPickerState locationPickerState3 = locationPickerState;
                LocationPickerState locationPickerState4 = locationPickerState2;
                if (locationPickerState3.getRadiusState().getDistanceInMeters() != locationPickerState4.getRadiusState().getDistanceInMeters() || !Intrinsics.areEqual(locationPickerState3.getRadiusState().getRadiusId(), locationPickerState4.getRadiusState().getRadiusId())) {
                    return false;
                }
                return true;
            } else if (i == 1) {
                return Intrinsics.areEqual(locationPickerState.getLatLng(), locationPickerState2.getLatLng());
            } else {
                if (i == 2) {
                    LocationPickerState locationPickerState5 = locationPickerState2;
                    if (locationPickerState.getRadiusState().getAdvertsCount() != locationPickerState5.getRadiusState().getAdvertsCount() || !locationPickerState5.getCameraMoving()) {
                        return false;
                    }
                    return true;
                } else if (i == 3) {
                    return Intrinsics.areEqual(locationPickerState.getRadiusState().getMapBounds(), locationPickerState2.getRadiusState().getMapBounds());
                } else {
                    throw null;
                }
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T, R> implements Function<LocationPickerState, String> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public final String apply(LocationPickerState locationPickerState) {
            int i = this.a;
            if (i == 0) {
                return locationPickerState.getAddressString();
            }
            if (i == 1) {
                return locationPickerState.getAddressValidationState().getError();
            }
            throw null;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class d extends Lambda implements Function1<LocationPickerState, Boolean> {
        public static final d b = new d(0);
        public static final d c = new d(1);
        public static final d d = new d(2);
        public static final d e = new d(3);
        public static final d f = new d(4);
        public static final d g = new d(5);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(LocationPickerState locationPickerState) {
            int i = this.a;
            if (i != 0) {
                boolean z = true;
                if (i == 1) {
                    LocationPickerState locationPickerState2 = locationPickerState;
                    Intrinsics.checkNotNullParameter(locationPickerState2, "state");
                    return Boolean.valueOf(locationPickerState2.getRadiusState().getRadiusIsVisible());
                } else if (i == 2) {
                    LocationPickerState locationPickerState3 = locationPickerState;
                    Intrinsics.checkNotNullParameter(locationPickerState3, "state");
                    return Boolean.valueOf(locationPickerState3.getShouldShowLoader());
                } else if (i == 3) {
                    LocationPickerState locationPickerState4 = locationPickerState;
                    Intrinsics.checkNotNullParameter(locationPickerState4, "state");
                    return Boolean.valueOf(locationPickerState4.getSendLocationToJobAssistant());
                } else if (i == 4) {
                    LocationPickerState locationPickerState5 = locationPickerState;
                    Intrinsics.checkNotNullParameter(locationPickerState5, "state");
                    return Boolean.valueOf(locationPickerState5.getSearchHasFocus());
                } else if (i == 5) {
                    LocationPickerState locationPickerState6 = locationPickerState;
                    Intrinsics.checkNotNullParameter(locationPickerState6, "state");
                    if (locationPickerState6.getAddressString().length() != 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                } else {
                    throw null;
                }
            } else {
                LocationPickerState locationPickerState7 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState7, "state");
                return Boolean.valueOf(locationPickerState7.getShouldActivateChooseButton());
            }
        }
    }

    public static final class e extends Lambda implements Function1<LocationPickerState, LocationPickerNotification> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LocationPickerNotification invoke(LocationPickerState locationPickerState) {
            LocationPickerState locationPickerState2 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            return locationPickerState2.getCurrentMessage();
        }
    }

    public static final class f<T, R> implements Function<LocationPickerState, LocationPickerState> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LocationPickerState apply(LocationPickerState locationPickerState) {
            return locationPickerState;
        }
    }

    public static final class g<T, R> implements Function<LocationPickerState, ChangeRadiusUpdate> {
        public final /* synthetic */ MapTransformationsProvider a;

        public g(MapTransformationsProvider mapTransformationsProvider) {
            this.a = mapTransformationsProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ChangeRadiusUpdate apply(LocationPickerState locationPickerState) {
            LocationPickerState locationPickerState2 = locationPickerState;
            return new ChangeRadiusUpdate(locationPickerState2.getRadiusState().getRadiusList(), this.a.mapBoundsByCenterAndMeters(locationPickerState2.getLatLng(), locationPickerState2.getRadiusState().getDistanceInMeters()), Long.valueOf(locationPickerState2.getRadiusState().getDistanceInMeters()));
        }
    }

    public static final class h extends Lambda implements Function1<Function1<? super LocationPickerState, ? extends T>, Observable<T>> {
        public final /* synthetic */ Observable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Observable observable) {
            super(1);
            this.a = observable;
        }

        @NotNull
        /* renamed from: a */
        public final <T> Observable<T> invoke(@NotNull Function1<? super LocationPickerState, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(function1, "mapper");
            Observable<T> distinctUntilChanged = this.a.map(new a2.a.a.n1.x0.a(function1)).distinctUntilChanged();
            Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "stateObservable\n        …  .distinctUntilChanged()");
            return distinctUntilChanged;
        }
    }

    public static final class i<T, R> implements Function<LocationPickerState, ChangeAdvertsCountUpdate> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ChangeAdvertsCountUpdate apply(LocationPickerState locationPickerState) {
            return new ChangeAdvertsCountUpdate(locationPickerState.getRadiusState().getAdvertsCount());
        }
    }

    public static final class j<T, R> implements Function<LocationPickerState, SearchRadius> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SearchRadius apply(LocationPickerState locationPickerState) {
            T t;
            LocationPickerState locationPickerState2 = locationPickerState;
            Iterator<T> it = locationPickerState2.getRadiusState().getRadiusList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.isActive()) {
                    break;
                }
            }
            T t2 = t;
            if (t2 == null) {
                return null;
            }
            t2.setCoordinates(new Coordinates(locationPickerState2.getLatLng().getLatitude(), locationPickerState2.getLatLng().getLongitude()));
            return t2;
        }
    }

    public static final class k<T, R> implements Function<LocationPickerState, RadiusWidgetUpdate> {
        public final /* synthetic */ MapTransformationsProvider a;

        public k(MapTransformationsProvider mapTransformationsProvider) {
            this.a = mapTransformationsProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public RadiusWidgetUpdate apply(LocationPickerState locationPickerState) {
            LocationPickerState locationPickerState2 = locationPickerState;
            long distanceInMeters = locationPickerState2.getRadiusState().getDistanceInMeters();
            MapTransformationsProvider mapTransformationsProvider = this.a;
            AvitoMapBounds mapBounds = locationPickerState2.getRadiusState().getMapBounds();
            AvitoMapPoint avitoMapPoint = null;
            AvitoMapPoint bottomRight = mapBounds != null ? mapBounds.getBottomRight() : null;
            AvitoMapBounds mapBounds2 = locationPickerState2.getRadiusState().getMapBounds();
            if (mapBounds2 != null) {
                avitoMapPoint = mapBounds2.getTopLeft();
            }
            return new RadiusWidgetUpdate(mapTransformationsProvider.distanceBetweenCoordinatesByLongitude(bottomRight, avitoMapPoint), distanceInMeters);
        }
    }

    public static final class l<T, R> implements Function<LocationPickerState, AddressParameter.Value> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressParameter.Value apply(LocationPickerState locationPickerState) {
            LocationPickerState locationPickerState2 = locationPickerState;
            return new AddressParameter.Value(locationPickerState2.getLatLng().getLatitude(), locationPickerState2.getLatLng().getLongitude(), locationPickerState2.getAddressString(), locationPickerState2.getJsonWebToken());
        }
    }

    public static final class m<T, R> implements Function<LocationPickerState, AvitoMapCameraPosition> {
        public static final m a = new m();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AvitoMapCameraPosition apply(LocationPickerState locationPickerState) {
            LocationPickerState locationPickerState2 = locationPickerState;
            return new AvitoMapCameraPosition(locationPickerState2.getLatLng(), locationPickerState2.getZoom(), 0.0f, null, null, 24, null);
        }
    }

    public static final class n extends Lambda implements Function1<LocationPickerState, List<? extends AddressSuggestion>> {
        public static final n a = new n();

        public n() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public List<? extends AddressSuggestion> invoke(LocationPickerState locationPickerState) {
            LocationPickerState locationPickerState2 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            return locationPickerState2.getSuggestionList();
        }
    }

    public static final class o<T> implements Predicate<Boolean> {
        public static final o a = new o();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return bool2.booleanValue();
        }
    }

    public static final class p<T, R> implements Function<Boolean, Unit> {
        public static final p a = new p();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(Boolean bool) {
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Disposable subscribeInputView(@NotNull LocationPickerInputView locationPickerInputView, @NotNull Observable<LocationPickerState> observable, @NotNull MapTransformationsProvider mapTransformationsProvider) {
        Intrinsics.checkNotNullParameter(locationPickerInputView, "view");
        Intrinsics.checkNotNullParameter(observable, "stateObservable");
        Intrinsics.checkNotNullParameter(mapTransformationsProvider, "mapTransformationsProvider");
        h hVar = new h(observable);
        return new CompositeDisposable(hVar.invoke(d.d).subscribe(locationPickerInputView.getChangeProgressVisibility()), observable.filter(a.i).map(m.a).distinctUntilChanged().subscribe(locationPickerInputView.getChangeCameraPosition()), hVar.invoke(n.a).subscribe(locationPickerInputView.getChangeShownSuggestions()), hVar.invoke(d.f).subscribe(locationPickerInputView.getChangeSearchFocus()), hVar.invoke(d.g).filter(o.a).map(p.a).subscribe(locationPickerInputView.getCleanSearchQuery()), hVar.invoke(d.b).subscribe(locationPickerInputView.getChangeChooseButtonIsActive()), observable.filter(a.b).map(c.b).subscribe(locationPickerInputView.getChangeSearchQuery()), hVar.invoke(e.a).subscribe(locationPickerInputView.getChangeNotification()), observable.filter(a.c).filter(a.d).map(f.a).distinctUntilChanged(b.b).map(new g(mapTransformationsProvider)).subscribe(locationPickerInputView.getSelectRadiusBubble()), observable.filter(a.e).distinctUntilChanged(b.c).map(c.c).subscribe(locationPickerInputView.getShowAddressValidationError()), observable.filter(a.f).distinctUntilChanged(b.d).map(i.a).subscribe(locationPickerInputView.getChangeAdvertsCount()), observable.filter(a.g).map(j.a).subscribe(locationPickerInputView.getCloseWithRadiusResults()), observable.distinctUntilChanged(b.e).map(new k(mapTransformationsProvider)).subscribe(locationPickerInputView.getChangeRadiusWidgetSize()), hVar.invoke(d.c).subscribe(locationPickerInputView.getChangeRadiusVisibility()), observable.filter(a.h).map(l.a).subscribe(locationPickerInputView.getCloseWithResults()), hVar.invoke(d.e).subscribe(locationPickerInputView.getLoadingIndicatorOnButton()));
    }
}
