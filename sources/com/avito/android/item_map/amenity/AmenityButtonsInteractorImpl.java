package com.avito.android.item_map.amenity;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.item_map.remote.ItemMapApi;
import com.avito.android.item_map.remote.model.AmenityResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonsInteractorImpl;", "Lcom/avito/android/item_map/amenity/AmenityButtonsInteractor;", "", "developmentsId", "type", "Lcom/avito/android/avito_map/AvitoMapPoint;", "coordinates", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/item_map/remote/model/AmenityResponse;", "getAmenityPins", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/item_map/remote/ItemMapApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_map/remote/ItemMapApi;", "itemMapApi", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/item_map/remote/ItemMapApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityButtonsInteractorImpl implements AmenityButtonsInteractor {
    public final ItemMapApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<TypedResult<AmenityResponse>, LoadingState<? super AmenityResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AmenityResponse> apply(TypedResult<AmenityResponse> typedResult) {
            TypedResult<AmenityResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super AmenityResponse>> {
        public final /* synthetic */ AmenityButtonsInteractorImpl a;

        public b(AmenityButtonsInteractorImpl amenityButtonsInteractorImpl) {
            this.a = amenityButtonsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AmenityResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public AmenityButtonsInteractorImpl(@NotNull ItemMapApi itemMapApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(itemMapApi, "itemMapApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = itemMapApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.item_map.amenity.AmenityButtonsInteractor
    @NotNull
    public Observable<LoadingState<AmenityResponse>> getAmenityPins(@NotNull String str, @NotNull String str2, @NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(str, "developmentsId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(avitoMapPoint, "coordinates");
        return a2.b.a.a.a.a2(this.c, this.a.getAmenity(str, (float) avitoMapPoint.getLatitude(), (float) avitoMapPoint.getLongitude(), str2).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this)), "itemMapApi.getAmenity(\n …scribeOn(schedulers.io())");
    }
}
