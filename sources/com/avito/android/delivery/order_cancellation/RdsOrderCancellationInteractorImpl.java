package com.avito.android.delivery.order_cancellation;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.OrderCancellationReasons;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJA\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractorImpl;", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "", AnalyticFieldsName.orderId, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/OrderCancellationReasons;", "getReasons", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "reasonId", "title", "reasonText", "", "sendReasonAndCancelOrder", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RdsOrderCancellationInteractorImpl implements RdsOrderCancellationInteractor {
    public final DeliveryApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<OrderCancellationReasons>, LoadingState<? super OrderCancellationReasons>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super OrderCancellationReasons> apply(TypedResult<OrderCancellationReasons> typedResult) {
            TypedResult<OrderCancellationReasons> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super OrderCancellationReasons>> {
        public final /* synthetic */ RdsOrderCancellationInteractorImpl a;

        public b(RdsOrderCancellationInteractorImpl rdsOrderCancellationInteractorImpl) {
            this.a = rdsOrderCancellationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super OrderCancellationReasons> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<Unit>, LoadingState<? super Unit>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
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

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
        public final /* synthetic */ RdsOrderCancellationInteractorImpl a;

        public d(RdsOrderCancellationInteractorImpl rdsOrderCancellationInteractorImpl) {
            this.a = rdsOrderCancellationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public RdsOrderCancellationInteractorImpl(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(deliveryApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = deliveryApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor
    @NotNull
    public Observable<LoadingState<OrderCancellationReasons>> getReasons(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Observable<LoadingState<OrderCancellationReasons>> onErrorReturn = InteropKt.toV2(this.a.getCancellationReasons(str)).subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getCancellationReaso…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor
    @NotNull
    public Observable<LoadingState<Unit>> sendReasonAndCancelOrder(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Observable<LoadingState<Unit>> onErrorReturn = InteropKt.toV2(this.a.sendCancelReason(str, num, str2, str3)).subscribeOn(this.b.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.sendCancelReason(ord…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
