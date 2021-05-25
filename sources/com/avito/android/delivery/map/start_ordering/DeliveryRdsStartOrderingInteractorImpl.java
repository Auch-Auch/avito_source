package com.avito.android.delivery.map.start_ordering;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.delivery.DeliveryPointsRectResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJQ\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractorImpl;", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/avito_map/AvitoMapPoint;", "topLeft", "bottomRight", "", "clusterRadius", "userCoords", "", "useOrderHistory", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliveryPointsRectResult;", "getDeliveryPoints", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/Float;Lcom/avito/android/avito_map/AvitoMapPoint;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingInteractorImpl implements DeliveryRdsStartOrderingInteractor {
    public final DeliveryApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<TypedResult<DeliveryPointsRectResult>, LoadingState<? super DeliveryPointsRectResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliveryPointsRectResult> apply(TypedResult<DeliveryPointsRectResult> typedResult) {
            TypedResult<DeliveryPointsRectResult> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super DeliveryPointsRectResult>> {
        public final /* synthetic */ DeliveryRdsStartOrderingInteractorImpl a;

        public b(DeliveryRdsStartOrderingInteractorImpl deliveryRdsStartOrderingInteractorImpl) {
            this.a = deliveryRdsStartOrderingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliveryPointsRectResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public DeliveryRdsStartOrderingInteractorImpl(@NotNull DeliveryApi deliveryApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(deliveryApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = deliveryApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingInteractor
    @NotNull
    public Observable<LoadingState<DeliveryPointsRectResult>> getDeliveryPoints(@Nullable String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2, @Nullable Float f, @Nullable AvitoMapPoint avitoMapPoint3, boolean z) {
        Map<String, Double> map;
        Intrinsics.checkNotNullParameter(avitoMapPoint, "topLeft");
        Intrinsics.checkNotNullParameter(avitoMapPoint2, "bottomRight");
        DeliveryApi deliveryApi = this.a;
        Map<String, Double> mapOf = r.mapOf(TuplesKt.to("topLeft[latitude]", Double.valueOf(avitoMapPoint.getLatitude())), TuplesKt.to("topLeft[longitude]", Double.valueOf(avitoMapPoint.getLongitude())));
        Map<String, Double> mapOf2 = r.mapOf(TuplesKt.to("bottomRight[latitude]", Double.valueOf(avitoMapPoint2.getLatitude())), TuplesKt.to("bottomRight[longitude]", Double.valueOf(avitoMapPoint2.getLongitude())));
        if (avitoMapPoint3 == null || (map = r.mapOf(TuplesKt.to("userCoords[latitude]", Double.valueOf(avitoMapPoint3.getLatitude())), TuplesKt.to("userCoords[longitude]", Double.valueOf(avitoMapPoint3.getLongitude())))) == null) {
            map = r.emptyMap();
        }
        Observable<R> onErrorReturn = deliveryApi.getDeliveryPointsRect(str, mapOf, mapOf2, f, map, Boolean.valueOf(z)).subscribeOn(this.c.io()).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getDeliveryPointsRec…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
