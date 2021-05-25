package com.avito.android.delivery.map.point_info;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.delivery.DeliveryMultiPointDetailInfo;
import com.avito.android.util.LoadingState;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractorImpl;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", "", "fiasId", "itemId", "", "serviceIds", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;", "getDeliveryPointShortInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/DeliveryApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsPointInfoInteractorImpl implements DeliveryRdsPointInfoInteractor {
    public final DeliveryApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<TypedResult<DeliveryMultiPointDetailInfo>, LoadingState<? super DeliveryMultiPointDetailInfo>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliveryMultiPointDetailInfo> apply(TypedResult<DeliveryMultiPointDetailInfo> typedResult) {
            TypedResult<DeliveryMultiPointDetailInfo> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super DeliveryMultiPointDetailInfo>> {
        public final /* synthetic */ DeliveryRdsPointInfoInteractorImpl a;

        public b(DeliveryRdsPointInfoInteractorImpl deliveryRdsPointInfoInteractorImpl) {
            this.a = deliveryRdsPointInfoInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliveryMultiPointDetailInfo> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public DeliveryRdsPointInfoInteractorImpl(@NotNull DeliveryApi deliveryApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(deliveryApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = deliveryApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoInteractor
    @NotNull
    public Observable<LoadingState<DeliveryMultiPointDetailInfo>> getDeliveryPointShortInfo(@NotNull String str, @Nullable String str2, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "fiasId");
        Intrinsics.checkNotNullParameter(list, "serviceIds");
        Observable<R> onErrorReturn = this.a.getDeliveryPointShortInfo(str, str2, RequestUtils.INSTANCE.toArrayQueryParams(CollectionsKt___CollectionsKt.toSet(list), "serviceIds")).subscribeOn(this.c.io()).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getDeliveryPointShor…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
