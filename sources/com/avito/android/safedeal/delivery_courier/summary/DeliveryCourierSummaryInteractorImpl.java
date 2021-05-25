package com.avito.android.safedeal.delivery_courier.summary;

import com.avito.android.Features;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderPayment;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.util.Collections;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b'\u0010(J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n0\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractorImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;", "getOrderSummary", "(Ljava/lang/String;)Lio/reactivex/Observable;", "providerKey", "", "parametersMap", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderPayment;", "createOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "fields", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/validation/LocalPretendInteractor;", "d", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/Features;)V", "IncorrectField", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryInteractorImpl implements DeliveryCourierSummaryInteractor {
    public final DeliveryApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;
    public final LocalPretendInteractor d;
    public final Features e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractorImpl$IncorrectField;", "Lcom/avito/android/remote/error/TypedError;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "<init>", "(Ljava/util/Map;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncorrectField implements TypedError {
        @NotNull
        public final Map<String, String> a;

        public IncorrectField(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }

        @NotNull
        public final Map<String, String> getMap() {
            return this.a;
        }
    }

    public static final class a<T, R> implements Function<TypedResult<DeliveryCourierOrderPayment>, LoadingState<? super DeliveryCourierOrderPayment>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeliveryCourierOrderPayment> apply(TypedResult<DeliveryCourierOrderPayment> typedResult) {
            TypedResult<DeliveryCourierOrderPayment> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "result");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                ErrorResult error = ((TypedResult.OfError) typedResult2).getError();
                if (error instanceof ErrorResult.IncorrectData) {
                    return new LoadingState.Error(new IncorrectField(((ErrorResult.IncorrectData) error).getMessages()));
                }
                return new LoadingState.Error(error);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super DeliveryCourierOrderPayment>> {
        public final /* synthetic */ DeliveryCourierSummaryInteractorImpl a;

        public b(DeliveryCourierSummaryInteractorImpl deliveryCourierSummaryInteractorImpl) {
            this.a = deliveryCourierSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeliveryCourierOrderPayment> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<DeliveryCourierSummary>, LoadingState<? super DeliveryCourierSummary>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeliveryCourierSummary> apply(TypedResult<DeliveryCourierSummary> typedResult) {
            TypedResult<DeliveryCourierSummary> typedResult2 = typedResult;
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

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super DeliveryCourierSummary>> {
        public final /* synthetic */ DeliveryCourierSummaryInteractorImpl a;

        public d(DeliveryCourierSummaryInteractorImpl deliveryCourierSummaryInteractorImpl) {
            this.a = deliveryCourierSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeliveryCourierSummary> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class e<T, R> implements Function<ParametersTree, ObservableSource<? extends PretendResult>> {
        public final /* synthetic */ DeliveryCourierSummaryInteractorImpl a;

        public e(DeliveryCourierSummaryInteractorImpl deliveryCourierSummaryInteractorImpl) {
            this.a = deliveryCourierSummaryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PretendResult> apply(ParametersTree parametersTree) {
            ParametersTree parametersTree2 = parametersTree;
            Intrinsics.checkNotNullParameter(parametersTree2, "it");
            return InteropKt.toV2(this.a.d.pretend(parametersTree2));
        }
    }

    public static final class f<T, R> implements Function<PretendResult, Map<String, ? extends String>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Map<String, ? extends String> apply(PretendResult pretendResult) {
            PretendResult pretendResult2 = pretendResult;
            Intrinsics.checkNotNullParameter(pretendResult2, "it");
            Map<String, PretendErrorValue> errors = pretendResult2.getErrors();
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(errors.size()));
            for (T t : errors.entrySet()) {
                linkedHashMap.put(t.getKey(), ((PretendErrorValue) t.getValue()).getSingleMessage());
            }
            return Collections.filterValuesNotNull(linkedHashMap);
        }
    }

    public static final class g<T, R> implements Function<Map<String, ? extends String>, LoadingState<? super Map<String, ? extends String>>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Map<String, ? extends String>> apply(Map<String, ? extends String> map) {
            Map<String, ? extends String> map2 = map;
            Intrinsics.checkNotNullParameter(map2, "it");
            return new LoadingState.Loaded(r.toMap(map2));
        }
    }

    public static final class h<T, R> implements Function<Throwable, LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ DeliveryCourierSummaryInteractorImpl a;

        public h(DeliveryCourierSummaryInteractorImpl deliveryCourierSummaryInteractorImpl) {
            this.a = deliveryCourierSummaryInteractorImpl;
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
    public DeliveryCourierSummaryInteractorImpl(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull Features features) {
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

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractor
    @NotNull
    public Observable<LoadingState<DeliveryCourierOrderPayment>> createOrder(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "providerKey");
        Intrinsics.checkNotNullParameter(map, "parametersMap");
        Observable<LoadingState<DeliveryCourierOrderPayment>> onErrorReturn = InteropKt.toV2(this.a.createCourierDeliveryOrder(str, str2, map)).subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.createCourierDeliver…rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractor
    @NotNull
    public Observable<LoadingState<DeliveryCourierSummary>> getOrderSummary(@NotNull String str) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (this.e.getYandexTaxiCourier().invoke().booleanValue()) {
            observable = InteropKt.toV2(this.a.getCourierDeliverySummary(str));
        } else {
            observable = InteropKt.toV2(this.a.getCourierDeliverySummaryV1(str));
        }
        Observable<LoadingState<DeliveryCourierSummary>> onErrorReturn = observable.subscribeOn(this.b.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "summaryObservable\n      …rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractor
    @NotNull
    public Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "fields");
        Observable<LoadingState<Map<String, String>>> onErrorReturn = Observable.just(parametersTree).flatMap(new e(this)).map(f.a).map(g.a).onErrorReturn(new h(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "Observable.just(fields)\n…rConverter.convert(it)) }");
        return onErrorReturn;
    }
}
