package com.avito.android.safedeal.delivery_courier.order_update;

import a2.a.a.i2.a.a.f;
import a2.a.a.i2.a.a.g;
import a2.a.a.i2.a.a.h;
import a2.a.a.i2.a.a.i;
import com.avito.android.Features;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParams;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJY\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractorImpl;", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "", AnalyticFieldsName.orderId, "source", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;", "getCourierOrderUpdateParams", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "fields", "submitCourierOrderUpdate", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/validation/LocalPretendInteractor;", "d", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/Features;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderUpdateInteractorImpl implements DeliveryCourierOrderUpdateInteractor {
    public final DeliveryApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;
    public final LocalPretendInteractor d;
    public final Features e;

    public static final class a<T, R> implements Function<TypedResult<DeliveryCourierOrderParams>, LoadingState<? super DeliveryCourierOrderParams>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeliveryCourierOrderParams> apply(TypedResult<DeliveryCourierOrderParams> typedResult) {
            TypedResult<DeliveryCourierOrderParams> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super DeliveryCourierOrderParams>> {
        public final /* synthetic */ DeliveryCourierOrderUpdateInteractorImpl a;

        public b(DeliveryCourierOrderUpdateInteractorImpl deliveryCourierOrderUpdateInteractorImpl) {
            this.a = deliveryCourierOrderUpdateInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeliveryCourierOrderParams> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ DeliveryCourierOrderUpdateInteractorImpl a;

        public c(DeliveryCourierOrderUpdateInteractorImpl deliveryCourierOrderUpdateInteractorImpl) {
            this.a = deliveryCourierOrderUpdateInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Map<String, ? extends String>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public DeliveryCourierOrderUpdateInteractorImpl(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(deliveryApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = deliveryApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
        this.d = localPretendInteractor;
        this.e = features;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractor
    @NotNull
    public Observable<LoadingState<DeliveryCourierOrderParams>> getCourierOrderUpdateParams(@NotNull String str, @NotNull String str2) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(str2, "source");
        if (this.e.getYandexTaxiCourier().invoke().booleanValue()) {
            observable = InteropKt.toV2(this.a.getDeliveryCourierOrderParams(str, str2));
        } else {
            observable = InteropKt.toV2(this.a.getDeliveryCourierOrderParamsV1(str, str2));
        }
        Observable<LoadingState<DeliveryCourierOrderParams>> onErrorReturn = observable.subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "paramsObservable\n       …rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractor
    @NotNull
    public Observable<LoadingState<Map<String, String>>> submitCourierOrderUpdate(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map, @NotNull List<? extends ParametersTree> list) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intrinsics.checkNotNullParameter(list, "fields");
        Observable flatMap = Observable.just(list).flatMap(new g(this)).map(h.a).flatMap(i.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.just(fields)\n…          }\n            }");
        Observable map2 = InteropKt.toV2(this.a.submitCourierOrderUpdate(str, str2, map)).map(f.a);
        Intrinsics.checkNotNullExpressionValue(map2, "api.submitCourierOrderUp…          }\n            }");
        Observable<LoadingState<Map<String, String>>> onErrorReturn = flatMap.switchIfEmpty(map2).subscribeOn(this.b.io()).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "validateFieldsLocally(fi…rConverter.convert(it)) }");
        return onErrorReturn;
    }
}
