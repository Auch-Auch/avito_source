package com.avito.android.advert_core.delivery;

import com.avito.android.advert_core.di.module.AdvertDeliveryBlockDataObservable;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepositoryImpl;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "getDeliveryData", "()Lio/reactivex/rxjava3/core/Observable;", "", "newValue", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AdvertDeliverySwitchResponse;", "advertItemToggleDelivery", "(Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/DeliveryApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/DeliveryApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "itemId", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/jakewharton/rxrelay3/PublishRelay;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "dataObservable", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliveryBlockRepositoryImpl implements AdvertDeliveryBlockRepository {
    public final String a;
    public final DeliveryApi b;
    public final SchedulersFactory3 c;
    public final TypedErrorThrowableConverter d;
    public final PublishRelay<AdvertDeliveryC2C> e;

    public static final class a<T, R> implements Function<TypedResult<AdvertDeliverySwitchResponse>, LoadingState<? super AdvertDeliverySwitchResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AdvertDeliverySwitchResponse> apply(TypedResult<AdvertDeliverySwitchResponse> typedResult) {
            TypedResult<AdvertDeliverySwitchResponse> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super AdvertDeliverySwitchResponse>> {
        public final /* synthetic */ AdvertDeliveryBlockRepositoryImpl a;

        public b(AdvertDeliveryBlockRepositoryImpl advertDeliveryBlockRepositoryImpl) {
            this.a = advertDeliveryBlockRepositoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super AdvertDeliverySwitchResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.d;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public AdvertDeliveryBlockRepositoryImpl(@AdvertId @NotNull String str, @NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @AdvertDeliveryBlockDataObservable @NotNull PublishRelay<AdvertDeliveryC2C> publishRelay) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(deliveryApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(publishRelay, "dataObservable");
        this.a = str;
        this.b = deliveryApi;
        this.c = schedulersFactory3;
        this.d = typedErrorThrowableConverter;
        this.e = publishRelay;
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepository
    @NotNull
    public Observable<LoadingState<AdvertDeliverySwitchResponse>> advertItemToggleDelivery(boolean z) {
        return a2.b.a.a.a.a2(this.c, this.b.advertItemToggleDelivery(this.a, z).map(a.a).onErrorReturn(new b(this)).startWith(Observable.just(LoadingState.Loading.INSTANCE)), "api.advertItemToggleDeli…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepository
    @NotNull
    public Observable<AdvertDeliveryC2C> getDeliveryData() {
        return this.e;
    }
}
