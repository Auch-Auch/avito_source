package com.avito.android.delivery.summary;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.di.qualifier.SearchContext;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UrlResult;
import com.avito.android.remote.model.delivery.CreateOrderResult;
import com.avito.android.remote.model.delivery.DeliverySpecificQuantityState;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b2\u00103J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014JW\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJW\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u00042\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\bR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractorImpl;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "", AnalyticFieldsName.orderId, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "getExistingOrderSummary", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", BookingInfoActivity.EXTRA_ITEM_ID, "fiasGuid", "serviceId", "getOrderSummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "fiasGuidTo", "", FirebaseAnalytics.Param.QUANTITY, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/delivery/DeliverySpecificQuantityState;", "checkQuantity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Single;", "pointId", "", "parametersMap", "Lcom/avito/android/remote/model/delivery/OrderIdResult;", "createDeliveryOrderLegacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "fieldsMap", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/delivery/CreateOrderResult;", "createDeliveryOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Single;", "payOrderId", "Lcom/avito/android/remote/model/UrlResult;", "getPaymentUrl", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "d", "Ljava/lang/String;", "searchContext", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "api", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryInteractorImpl implements DeliveryRdsSummaryInteractor {
    public final DeliveryApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;
    public final String d;

    public static final class a<T, R> implements Function<TypedResult<OrderIdResult>, LoadingState<? super OrderIdResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super OrderIdResult> apply(TypedResult<OrderIdResult> typedResult) {
            TypedResult<OrderIdResult> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super OrderIdResult>> {
        public final /* synthetic */ DeliveryRdsSummaryInteractorImpl a;

        public b(DeliveryRdsSummaryInteractorImpl deliveryRdsSummaryInteractorImpl) {
            this.a = deliveryRdsSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super OrderIdResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<DeliverySummaryRds>, LoadingState<? super DeliverySummaryRds>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliverySummaryRds> apply(TypedResult<DeliverySummaryRds> typedResult) {
            TypedResult<DeliverySummaryRds> typedResult2 = typedResult;
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

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super DeliverySummaryRds>> {
        public final /* synthetic */ DeliveryRdsSummaryInteractorImpl a;

        public d(DeliveryRdsSummaryInteractorImpl deliveryRdsSummaryInteractorImpl) {
            this.a = deliveryRdsSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliverySummaryRds> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class e<T, R> implements Function<TypedResult<DeliverySummaryRds>, LoadingState<? super DeliverySummaryRds>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliverySummaryRds> apply(TypedResult<DeliverySummaryRds> typedResult) {
            TypedResult<DeliverySummaryRds> typedResult2 = typedResult;
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

    public static final class f<T, R> implements Function<Throwable, LoadingState<? super DeliverySummaryRds>> {
        public final /* synthetic */ DeliveryRdsSummaryInteractorImpl a;

        public f(DeliveryRdsSummaryInteractorImpl deliveryRdsSummaryInteractorImpl) {
            this.a = deliveryRdsSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliverySummaryRds> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class g<T, R> implements Function<TypedResult<UrlResult>, LoadingState<? super UrlResult>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super UrlResult> apply(TypedResult<UrlResult> typedResult) {
            TypedResult<UrlResult> typedResult2 = typedResult;
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

    public static final class h<T, R> implements Function<Throwable, LoadingState<? super UrlResult>> {
        public final /* synthetic */ DeliveryRdsSummaryInteractorImpl a;

        public h(DeliveryRdsSummaryInteractorImpl deliveryRdsSummaryInteractorImpl) {
            this.a = deliveryRdsSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super UrlResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public DeliveryRdsSummaryInteractorImpl(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @SearchContext @Nullable String str) {
        Intrinsics.checkNotNullParameter(deliveryApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        this.a = deliveryApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
        this.d = str;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor
    @NotNull
    public Single<DeliverySpecificQuantityState> checkQuantity(@Nullable String str, @Nullable String str2, @Nullable String str3, int i) {
        String str4 = str == null ? "Advert id must not be null" : str2 == null ? "Fias guid must not be null" : str3 == null ? "Service id must not be null" : null;
        if (str4 != null) {
            Single<DeliverySpecificQuantityState> error = Single.error(new IllegalArgumentException(str4));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(IllegalArgumentException(errMsg))");
            return error;
        }
        DeliveryApi deliveryApi = this.a;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(str2);
        Intrinsics.checkNotNull(str3);
        Single<DeliverySpecificQuantityState> flatMap = a2.b.a.a.a.e2(this.b, deliveryApi.checkItemQuantity(str, str2, str3, i), "api.checkItemQuantity(ad…n(schedulersFactory.io())").flatMap(DeliveryRdsSummaryInteractorImpl$checkQuantity$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return flatMap;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor
    @NotNull
    public Single<TypedResult<CreateOrderResult>> createDeliveryOrder(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "fieldsMap");
        String str4 = str2 == null ? "Fias guid must not be null" : str3 == null ? "Service id must not be null" : map.isEmpty() ? "Fields must not be empty" : null;
        if (str4 != null) {
            Single<TypedResult<CreateOrderResult>> error = Single.error(new IllegalArgumentException(str4));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(IllegalArgumentException(errMsg))");
            return error;
        }
        DeliveryApi deliveryApi = this.a;
        Intrinsics.checkNotNull(str2);
        Intrinsics.checkNotNull(str3);
        return a2.b.a.a.a.e2(this.b, deliveryApi.createDeliveryOrder(str, str2, str3, num, this.d, map), "api.createDeliveryOrder(…n(schedulersFactory.io())");
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor
    @NotNull
    public Observable<LoadingState<OrderIdResult>> createDeliveryOrderLegacy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "parametersMap");
        String str4 = str2 == null ? "Fias guid must not be null" : str3 == null ? "Point id must not be null" : map.isEmpty() ? "Parameters must not be empty" : null;
        if (str4 != null) {
            Observable<LoadingState<OrderIdResult>> error = Observable.error(new IllegalArgumentException(str4));
            Intrinsics.checkNotNullExpressionValue(error, "Observable.error(IllegalArgumentException(errMsg))");
            return error;
        }
        DeliveryApi deliveryApi = this.a;
        Intrinsics.checkNotNull(str2);
        Intrinsics.checkNotNull(str3);
        Observable<R> onErrorReturn = deliveryApi.createDeliveryOrderLegacy(str, str2, str3, num, map).subscribeOn(this.b.io()).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.createDeliveryOrderL…rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor
    @NotNull
    public Observable<LoadingState<DeliverySummaryRds>> getExistingOrderSummary(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Observable<R> onErrorReturn = this.a.getDeliveryExistingSummary(str).subscribeOn(this.b.io()).map(c.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getDeliveryExistingS…rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor
    @NotNull
    public Observable<LoadingState<DeliverySummaryRds>> getOrderSummary(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "fiasGuid");
        Intrinsics.checkNotNullParameter(str3, "serviceId");
        Observable<R> onErrorReturn = this.a.getDeliverySummary(str, str2, str3).subscribeOn(this.b.io()).map(e.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new f(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getDeliverySummary(a…rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor
    @NotNull
    public Observable<LoadingState<UrlResult>> getPaymentUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "payOrderId");
        Observable<R> onErrorReturn = this.a.getPaymentUrl(str, this.d).subscribeOn(this.b.io()).map(g.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new h(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getPaymentUrl(payOrd…rConverter.convert(it)) }");
        return onErrorReturn;
    }
}
