package com.avito.android.tariff.change.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.change.TariffChangeResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepositoryImpl;", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepository;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/change/TariffChangeResult;", "getTariffChangeInfo", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/TariffApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/TariffApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/remote/TariffApi;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangeRepositoryImpl implements TariffChangeRepository {
    public final TariffApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<TariffChangeResult>, LoadingState<? super TariffChangeResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffChangeResult> apply(TypedResult<TariffChangeResult> typedResult) {
            TypedResult<TariffChangeResult> typedResult2 = typedResult;
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
    public TariffChangeRepositoryImpl(@NotNull TariffApi tariffApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(tariffApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = tariffApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.tariff.change.viewmodel.TariffChangeRepository
    @NotNull
    public Observable<LoadingState<TariffChangeResult>> getTariffChangeInfo() {
        Observable<LoadingState<TariffChangeResult>> map = InteropKt.toV2(this.a.getTariffChangeInfo()).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getTariffChangeInfo(…p { it.toLoadingState() }");
        return map;
    }
}
