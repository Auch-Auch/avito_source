package com.avito.android.tariff.region.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TariffRegionResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepositoryImpl;", "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/TariffRegionResult;", "getTariffRegions", "(Ljava/lang/String;)Lio/reactivex/Observable;", "regionId", "Lcom/avito/android/remote/model/DeepLinkResponse;", "selectTariffRegionLegacy", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "selectTariffRegion", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/TariffApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/TariffApi;", "api", "<init>", "(Lcom/avito/android/remote/TariffApi;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffRegionRepositoryImpl implements TariffRegionRepository {
    public final TariffApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<TariffRegionResult>, LoadingState<? super TariffRegionResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffRegionResult> apply(TypedResult<TariffRegionResult> typedResult) {
            TypedResult<TariffRegionResult> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<TypedResult<DeepLinkResponse>, LoadingState<? super DeepLinkResponse>> {
        public static final b a = new b();

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

    public static final class c<T, R> implements Function<TypedResult<DeepLinkResponse>, LoadingState<? super DeepLinkResponse>> {
        public static final c a = new c();

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
    public TariffRegionRepositoryImpl(@NotNull TariffApi tariffApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(tariffApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = tariffApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.tariff.region.viewmodel.TariffRegionRepository
    @NotNull
    public Observable<LoadingState<TariffRegionResult>> getTariffRegions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Observable<LoadingState<TariffRegionResult>> map = InteropKt.toV2(this.a.getTariffRegions(str)).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getTariffRegions(che…p { it.toLoadingState() }");
        return map;
    }

    @Override // com.avito.android.tariff.region.viewmodel.TariffRegionRepository
    @NotNull
    public Observable<LoadingState<DeepLinkResponse>> selectTariffRegion(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "regionId");
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Observable<LoadingState<DeepLinkResponse>> startWith = InteropKt.toV2(this.a.commitTariff(str, str2)).subscribeOn(this.b.io()).map(b.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.commitTariff(regionI…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.tariff.region.viewmodel.TariffRegionRepository
    @NotNull
    public Observable<LoadingState<DeepLinkResponse>> selectTariffRegionLegacy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "regionId");
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Observable<LoadingState<DeepLinkResponse>> startWith = InteropKt.toV2(this.a.commitTariffLegacy(str, str2)).subscribeOn(this.b.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.commitTariffLegacy(r…ith(LoadingState.Loading)");
        return startWith;
    }
}
