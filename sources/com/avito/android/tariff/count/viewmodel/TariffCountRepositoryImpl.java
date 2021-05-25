package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TariffCountPriceResult;
import com.avito.android.remote.model.TariffCountResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.ShouldRetryException;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/TariffCountRepositoryImpl;", "Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/TariffCountResult;", "getTariffCount", "(Ljava/lang/String;)Lio/reactivex/Observable;", "countId", "Lcom/avito/android/remote/model/DeepLinkResponse;", "selectTariffCount", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TariffCountPriceResult;", "getCountPrice", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/TariffApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/TariffApi;", "api", "<init>", "(Lcom/avito/android/remote/TariffApi;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountRepositoryImpl implements TariffCountRepository {
    public final TariffApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<TariffCountPriceResult>, TypedResult<TariffCountPriceResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public TypedResult<TariffCountPriceResult> apply(TypedResult<TariffCountPriceResult> typedResult) {
            TypedResult<TariffCountPriceResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (!(typedResult2 instanceof TypedResult.OfError)) {
                return typedResult2;
            }
            throw new ShouldRetryException(typedResult2);
        }
    }

    public static final class b<T, R> implements Function<Observable<Throwable>, ObservableSource<?>> {
        public final /* synthetic */ TariffCountRepositoryImpl a;

        public b(TariffCountRepositoryImpl tariffCountRepositoryImpl) {
            this.a = tariffCountRepositoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<?> apply(Observable<Throwable> observable) {
            Observable<Throwable> observable2 = observable;
            Intrinsics.checkNotNullParameter(observable2, "errors");
            return observable2.flatMap(new a2.a.a.e3.b.h.a(this));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<TariffCountPriceResult>, LoadingState<? super TariffCountPriceResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffCountPriceResult> apply(TypedResult<TariffCountPriceResult> typedResult) {
            TypedResult<TariffCountPriceResult> typedResult2 = typedResult;
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

    public static final class d<T, R> implements Function<TypedResult<TariffCountResult>, LoadingState<? super TariffCountResult>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffCountResult> apply(TypedResult<TariffCountResult> typedResult) {
            TypedResult<TariffCountResult> typedResult2 = typedResult;
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

    public static final class e<T, R> implements Function<TypedResult<DeepLinkResponse>, LoadingState<? super DeepLinkResponse>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeepLinkResponse> apply(TypedResult<DeepLinkResponse> typedResult) {
            TypedResult<DeepLinkResponse> typedResult2 = typedResult;
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

    @Inject
    public TariffCountRepositoryImpl(@NotNull TariffApi tariffApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(tariffApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = tariffApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountRepository
    @NotNull
    public Observable<LoadingState<TariffCountPriceResult>> getCountPrice(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "countId");
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Observable<LoadingState<TariffCountPriceResult>> map = InteropKt.toV2(this.a.getTariffCountPrice(str, str2)).subscribeOn(this.b.io()).map(a.a).retryWhen(new b(this)).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getTariffCountPrice(…p { it.toLoadingState() }");
        return map;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountRepository
    @NotNull
    public Observable<LoadingState<TariffCountResult>> getTariffCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Observable<LoadingState<TariffCountResult>> map = InteropKt.toV2(this.a.getTariffCount(str)).subscribeOn(this.b.io()).map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getTariffCount(check…p { it.toLoadingState() }");
        return map;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountRepository
    @NotNull
    public Observable<LoadingState<DeepLinkResponse>> selectTariffCount(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "countId");
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Observable<LoadingState<DeepLinkResponse>> startWith = InteropKt.toV2(this.a.commitTariff(str, str2)).subscribeOn(this.b.io()).map(e.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "selectTariffCountVersion…ith(LoadingState.Loading)");
        return startWith;
    }
}
