package com.avito.android.safedeal.delivery_type;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.safedeal.remote.model.DeliveryTypeResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractorImpl;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/safedeal/remote/model/DeliveryTypeResponse;", "loadDeliveryTypes", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "deliveryTypeData", "Lcom/avito/android/safedeal/remote/SafeDealApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/safedeal/remote/SafeDealApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;Lcom/avito/android/safedeal/remote/SafeDealApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeInteractorImpl implements DeliveryTypeInteractor {
    public final DeliveryTypeData a;
    public final SafeDealApi b;
    public final SchedulersFactory3 c;
    public final TypedErrorThrowableConverter d;

    public static final class a<T, R> implements Function<TypedResult<DeliveryTypeResponse>, LoadingState<? super DeliveryTypeResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliveryTypeResponse> apply(TypedResult<DeliveryTypeResponse> typedResult) {
            TypedResult<DeliveryTypeResponse> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super DeliveryTypeResponse>> {
        public final /* synthetic */ DeliveryTypeInteractorImpl a;

        public b(DeliveryTypeInteractorImpl deliveryTypeInteractorImpl) {
            this.a = deliveryTypeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DeliveryTypeResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.d;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public DeliveryTypeInteractorImpl(@NotNull DeliveryTypeData deliveryTypeData, @NotNull SafeDealApi safeDealApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(deliveryTypeData, "deliveryTypeData");
        Intrinsics.checkNotNullParameter(safeDealApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = deliveryTypeData;
        this.b = safeDealApi;
        this.c = schedulersFactory3;
        this.d = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeInteractor
    @NotNull
    public Observable<LoadingState<DeliveryTypeResponse>> loadDeliveryTypes() {
        return a2.b.a.a.a.a2(this.c, this.b.getDeliveryType(this.a.getItemId(), this.a.getSearchContext()).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this)), "api.getDeliveryType(deli…scribeOn(schedulers.io())");
    }
}
