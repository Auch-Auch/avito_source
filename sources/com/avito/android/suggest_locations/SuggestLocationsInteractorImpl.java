package com.avito.android.suggest_locations;

import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationsResponse;
import com.avito.android.remote.model.SuggestLocation;
import com.avito.android.remote.model.SuggestLocationsResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import com.avito.android.suggest_locations.SuggestLocationsResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsInteractorImpl;", "Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;", "", "query", "locationId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "getLocationSuggestions", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "getLegacyLocationSuggestions", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AddressSuggestionResult;", "getAddressSuggestions", "Lcom/avito/android/remote/LocationApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/LocationApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;", "c", "Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;", "converter", "<init>", "(Lcom/avito/android/remote/LocationApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsInteractorImpl implements SuggestLocationsInteractor {
    public final LocationApi a;
    public final SchedulersFactory3 b;
    public final SuggestLocationsItemsConverter c;

    public static final class a<T, R> implements Function<TypedResult<AddressSuggestionResult.Ok>, AddressSuggestionResult> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressSuggestionResult apply(TypedResult<AddressSuggestionResult.Ok> typedResult) {
            TypedResult<AddressSuggestionResult.Ok> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (AddressSuggestionResult) ((TypedResult.OfResult) typedResult2).getResult();
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return new AddressSuggestionResult.NetworkError();
                }
                return new AddressSuggestionResult.Error(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, AddressSuggestionResult> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AddressSuggestionResult apply(Throwable th) {
            return new AddressSuggestionResult.NetworkError();
        }
    }

    public static final class c<T, R> implements Function<LocationsResponse, SuggestLocationsResult> {
        public final /* synthetic */ SuggestLocationsInteractorImpl a;
        public final /* synthetic */ String b;

        public c(SuggestLocationsInteractorImpl suggestLocationsInteractorImpl, String str) {
            this.a = suggestLocationsInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SuggestLocationsResult apply(LocationsResponse locationsResponse) {
            SuggestLocationsItemsConverter suggestLocationsItemsConverter = this.a.c;
            List<Location> locations = locationsResponse.getLocations();
            return suggestLocationsItemsConverter.convert(locations != null ? SuggestLocationsInteractorImpl.access$toSuggestLocations(this.a, locations) : null, this.b);
        }
    }

    public static final class d<T, R> implements Function<Throwable, SuggestLocationsResult> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SuggestLocationsResult apply(Throwable th) {
            return SuggestLocationsResult.SilentError.INSTANCE;
        }
    }

    public static final class e<T, R> implements Function<TypedResult<SuggestLocationsResponse.Ok>, SuggestLocationsResult> {
        public final /* synthetic */ SuggestLocationsInteractorImpl a;
        public final /* synthetic */ String b;

        public e(SuggestLocationsInteractorImpl suggestLocationsInteractorImpl, String str) {
            this.a = suggestLocationsInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SuggestLocationsResult apply(TypedResult<SuggestLocationsResponse.Ok> typedResult) {
            TypedResult<SuggestLocationsResponse.Ok> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return this.a.c.convert((SuggestLocationsResponse) ((TypedResult.OfResult) typedResult2).getResult(), this.b);
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    return SuggestLocationsResult.NetworkError.INSTANCE;
                }
                return new SuggestLocationsResult.Error(ofError.getError().getMessage());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class f<T, R> implements Function<Throwable, SuggestLocationsResult> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SuggestLocationsResult apply(Throwable th) {
            return SuggestLocationsResult.NetworkError.INSTANCE;
        }
    }

    @Inject
    public SuggestLocationsInteractorImpl(@NotNull LocationApi locationApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SuggestLocationsItemsConverter suggestLocationsItemsConverter) {
        Intrinsics.checkNotNullParameter(locationApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(suggestLocationsItemsConverter, "converter");
        this.a = locationApi;
        this.b = schedulersFactory3;
        this.c = suggestLocationsItemsConverter;
    }

    public static final List access$toSuggestLocations(SuggestLocationsInteractorImpl suggestLocationsInteractorImpl, List list) {
        Objects.requireNonNull(suggestLocationsInteractorImpl);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Location location = (Location) it.next();
            arrayList.add(new SuggestLocation(location.getId(), location.getNames(), null, null, null));
        }
        return arrayList;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsInteractor
    @NotNull
    public Single<AddressSuggestionResult> getAddressSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        return a2.b.a.a.a.e2(this.b, LocationApi.DefaultImpls.getAddressSuggestions$default(this.a, str, null, null, null, null, 30, null).firstOrError().map(a.a).onErrorReturn(b.a), "api\n        .getAddressS…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsInteractor
    @NotNull
    public Single<SuggestLocationsResult> getLegacyLocationSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        return a2.b.a.a.a.e2(this.b, this.a.getSearchLocations(str).firstOrError().map(new c(this, str)).onErrorReturn(d.a), "api.getSearchLocations(q…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsInteractor
    @NotNull
    public Single<SuggestLocationsResult> getLocationSuggestions(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        return a2.b.a.a.a.e2(this.b, this.a.getLocationSuggestions(str, str2).firstOrError().map(new e(this, str)).onErrorReturn(f.a), "api.getLocationSuggestio…scribeOn(schedulers.io())");
    }
}
