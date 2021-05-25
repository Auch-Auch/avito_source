package com.avito.android.location_picker.providers;

import androidx.collection.SimpleArrayMap;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import com.avito.android.remote.model.location_picker.AddressCoordinatesByQueryResult;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.remote.model.location_picker.CoordinatesCurrentResult;
import com.avito.android.remote.model.location_picker.CoordinatesVerificationResult;
import com.avito.android.remote.model.location_picker.CurrentCoordinates;
import com.avito.android.util.rx3.Maybies;
import com.google.android.gms.maps.model.LatLngBounds;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0019\u0010'\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/location_picker/providers/AvitoAddressGeoCoder;", "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/CoordinatesCurrentResult;", "getCurrentCoordinates", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "", "itemId", "Lcom/avito/android/remote/model/location_picker/CoordinatesVerificationResult;", "verifyCoordinates", "(Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AddressByCoordinatesResult;", "getAddressByLatLng", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lio/reactivex/rxjava3/core/Single;", "searchQuery", "Lcom/google/android/gms/maps/model/LatLngBounds;", "visibleRegion", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult;", "getSuggestions", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapBounds;)Lio/reactivex/rxjava3/core/Single;", "addressQuery", "Lcom/avito/android/remote/model/location_picker/AddressCoordinatesByQueryResult;", "getCoordinatesByAddress", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Landroidx/collection/SimpleArrayMap;", AuthSource.BOOKING_ORDER, "Landroidx/collection/SimpleArrayMap;", "suggestionsCache", AuthSource.SEND_ABUSE, "addressCache", "Lcom/avito/android/remote/LocationApi;", "c", "Lcom/avito/android/remote/LocationApi;", "getApi", "()Lcom/avito/android/remote/LocationApi;", "api", "<init>", "(Lcom/avito/android/remote/LocationApi;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoAddressGeoCoder implements AddressGeoCoder {
    public final SimpleArrayMap<AvitoMapPoint, AddressByCoordinatesResult> a = new SimpleArrayMap<>();
    public final SimpleArrayMap<String, AddressSuggestionResult> b = new SimpleArrayMap<>();
    @NotNull
    public final LocationApi c;

    public static final class a<T> implements Consumer<AddressByCoordinatesResult> {
        public final /* synthetic */ AvitoAddressGeoCoder a;
        public final /* synthetic */ AvitoMapPoint b;

        public a(AvitoAddressGeoCoder avitoAddressGeoCoder, AvitoMapPoint avitoMapPoint) {
            this.a = avitoAddressGeoCoder;
            this.b = avitoMapPoint;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddressByCoordinatesResult addressByCoordinatesResult) {
            AddressByCoordinatesResult addressByCoordinatesResult2 = addressByCoordinatesResult;
            if (addressByCoordinatesResult2 instanceof AddressByCoordinatesResult.Ok) {
                this.a.a.put(this.b, addressByCoordinatesResult2);
            }
        }
    }

    public static final class b<T, R> implements Function<TypedResult<AddressCoordinatesByQueryResult>, AddressCoordinatesByQueryResult> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressCoordinatesByQueryResult apply(TypedResult<AddressCoordinatesByQueryResult> typedResult) {
            TypedResult<AddressCoordinatesByQueryResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (AddressCoordinatesByQueryResult) ((TypedResult.OfResult) typedResult2).getResult();
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return new AddressCoordinatesByQueryResult.NetworkError();
                }
                return new AddressCoordinatesByQueryResult.NotFoundError(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function<Throwable, AddressCoordinatesByQueryResult> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressCoordinatesByQueryResult apply(Throwable th) {
            return new AddressCoordinatesByQueryResult.NetworkError();
        }
    }

    public static final class d<T, R> implements Function<TypedResult<CurrentCoordinates>, CoordinatesCurrentResult> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CoordinatesCurrentResult apply(TypedResult<CurrentCoordinates> typedResult) {
            TypedResult<CurrentCoordinates> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new CoordinatesCurrentResult.Ok((CurrentCoordinates) ((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return new CoordinatesCurrentResult.NetWorkError();
                }
                return new CoordinatesCurrentResult.UnknownError(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T, R> implements Function<Throwable, CoordinatesCurrentResult> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CoordinatesCurrentResult apply(Throwable th) {
            return new CoordinatesCurrentResult.NetWorkError();
        }
    }

    public static final class f<T> implements Consumer<AddressSuggestionResult> {
        public final /* synthetic */ AvitoAddressGeoCoder a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AvitoMapBounds c;

        public f(AvitoAddressGeoCoder avitoAddressGeoCoder, String str, AvitoMapBounds avitoMapBounds) {
            this.a = avitoAddressGeoCoder;
            this.b = str;
            this.c = avitoMapBounds;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddressSuggestionResult addressSuggestionResult) {
            AddressSuggestionResult addressSuggestionResult2 = addressSuggestionResult;
            if (addressSuggestionResult2 instanceof AddressSuggestionResult.Ok) {
                SimpleArrayMap simpleArrayMap = this.a.b;
                simpleArrayMap.put(this.b + ' ' + this.c, addressSuggestionResult2);
            }
        }
    }

    public static final class g<T, R> implements Function<TypedResult<CoordinatesVerificationResult>, CoordinatesVerificationResult> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CoordinatesVerificationResult apply(TypedResult<CoordinatesVerificationResult> typedResult) {
            TypedResult<CoordinatesVerificationResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (CoordinatesVerificationResult) ((TypedResult.OfResult) typedResult2).getResult();
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return new CoordinatesVerificationResult.NetworkError();
                }
                return new CoordinatesVerificationResult.UnknownError(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class h<T, R> implements Function<Throwable, CoordinatesVerificationResult> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CoordinatesVerificationResult apply(Throwable th) {
            return new CoordinatesVerificationResult.NetworkError();
        }
    }

    @Inject
    public AvitoAddressGeoCoder(@NotNull LocationApi locationApi) {
        Intrinsics.checkNotNullParameter(locationApi, "api");
        this.c = locationApi;
    }

    @Override // com.avito.android.location_picker.providers.AddressGeoCoder
    @NotNull
    public Single<AddressByCoordinatesResult> getAddressByLatLng(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        Maybe maybe = Maybies.toMaybe(this.a.get(avitoMapPoint));
        Single<R> onErrorReturn = this.c.getAddressByCoordinates(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()).firstOrError().map(a2.a.a.n1.w0.b.a).onErrorReturn(a2.a.a.n1.w0.c.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api\n        .getAddressB…esResult.NetworkError() }");
        Single<AddressByCoordinatesResult> single = maybe.switchIfEmpty(onErrorReturn.doOnSuccess(new a(this, avitoMapPoint)).toMaybe()).toSingle();
        Intrinsics.checkNotNullExpressionValue(single, "addressCache[latLng]\n   …)\n            .toSingle()");
        return single;
    }

    @NotNull
    public final LocationApi getApi() {
        return this.c;
    }

    @Override // com.avito.android.location_picker.providers.AddressGeoCoder
    @NotNull
    public Single<AddressCoordinatesByQueryResult> getCoordinatesByAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "addressQuery");
        Single<R> onErrorReturn = this.c.getCoordsByAddress(str).firstOrError().map(b.a).onErrorReturn(c.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api\n        .getCoordsBy…ryResult.NetworkError() }");
        return onErrorReturn;
    }

    @Override // com.avito.android.location_picker.providers.AddressGeoCoder
    @NotNull
    public Single<CoordinatesCurrentResult> getCurrentCoordinates() {
        Single<R> onErrorReturn = this.c.getCurrentCoordinates().firstOrError().map(d.a).onErrorReturn(e.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api\n        .getCurrentC….NetWorkError()\n        }");
        return onErrorReturn;
    }

    @Override // com.avito.android.location_picker.providers.AddressGeoCoder
    @NotNull
    public Single<AddressSuggestionResult> getSuggestions(@NotNull String str, @NotNull LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        Intrinsics.checkNotNullParameter(latLngBounds, "visibleRegion");
        return getSuggestions(str, AvitoMapBounds.CREATOR.fromLatLngBounds(latLngBounds));
    }

    @Override // com.avito.android.location_picker.providers.AddressGeoCoder
    @NotNull
    public Single<CoordinatesVerificationResult> verifyCoordinates(@NotNull AvitoMapPoint avitoMapPoint, @Nullable String str) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        Single<R> onErrorReturn = this.c.verifyCoordinates(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude(), str).firstOrError().map(g.a).onErrorReturn(h.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.verifyCoordinates(la…onResult.NetworkError() }");
        return onErrorReturn;
    }

    @Override // com.avito.android.location_picker.providers.AddressGeoCoder
    @NotNull
    public Single<AddressSuggestionResult> getSuggestions(@NotNull String str, @NotNull AvitoMapBounds avitoMapBounds) {
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        Intrinsics.checkNotNullParameter(avitoMapBounds, "visibleRegion");
        SimpleArrayMap<String, AddressSuggestionResult> simpleArrayMap = this.b;
        Maybe maybe = Maybies.toMaybe(simpleArrayMap.get(str + ' ' + avitoMapBounds));
        Single<R> onErrorReturn = this.c.getAddressSuggestions(str, Double.valueOf(avitoMapBounds.getTopLeft().getLongitude()), Double.valueOf(avitoMapBounds.getBottomRight().getLatitude()), Double.valueOf(avitoMapBounds.getBottomRight().getLongitude()), Double.valueOf(avitoMapBounds.getTopLeft().getLatitude())).firstOrError().map(a2.a.a.n1.w0.d.a).onErrorReturn(a2.a.a.n1.w0.e.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api\n        .getAddressS…onResult.NetworkError() }");
        Single<AddressSuggestionResult> single = maybe.switchIfEmpty(onErrorReturn.doOnSuccess(new f(this, str, avitoMapBounds)).toMaybe()).toSingle();
        Intrinsics.checkNotNullExpressionValue(single, "suggestionsCache[\"$searc…)\n            .toSingle()");
        return single;
    }
}
