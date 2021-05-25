package com.avito.android.tariff.edit_info.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.change.TariffAutoProlongResult;
import com.avito.android.remote.model.edit.TariffEditInfoResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepositoryImpl;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/edit/TariffEditInfoResult;", "getTariffInfo", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "autoProlong", "Lcom/avito/android/remote/model/change/TariffAutoProlongResult;", "postTariffAutoprolong", "(Z)Lio/reactivex/Observable;", "", "getApplyChange", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/TariffApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/TariffApi;", "api", "<init>", "(Lcom/avito/android/remote/TariffApi;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoRepositoryImpl implements EditInfoRepository {
    public final TariffApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<Object>, LoadingState<? super Object>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Object> apply(TypedResult<Object> typedResult) {
            TypedResult<Object> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<TypedResult<TariffEditInfoResult>, LoadingState<? super TariffEditInfoResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffEditInfoResult> apply(TypedResult<TariffEditInfoResult> typedResult) {
            TypedResult<TariffEditInfoResult> typedResult2 = typedResult;
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

    public static final class c<T, R> implements Function<TypedResult<TariffAutoProlongResult>, LoadingState<? super TariffAutoProlongResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffAutoProlongResult> apply(TypedResult<TariffAutoProlongResult> typedResult) {
            TypedResult<TariffAutoProlongResult> typedResult2 = typedResult;
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
    public EditInfoRepositoryImpl(@NotNull TariffApi tariffApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(tariffApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = tariffApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoRepository
    @NotNull
    public Observable<LoadingState<Object>> getApplyChange() {
        Observable<LoadingState<Object>> map = InteropKt.toV2(this.a.getApplyChange()).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getApplyChange().toV…p { it.toLoadingState() }");
        return map;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoRepository
    @NotNull
    public Observable<LoadingState<TariffEditInfoResult>> getTariffInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Observable<LoadingState<TariffEditInfoResult>> map = InteropKt.toV2(this.a.getTariffInfo(str)).subscribeOn(this.b.io()).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getTariffInfo(checko…p { it.toLoadingState() }");
        return map;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoRepository
    @NotNull
    public Observable<LoadingState<TariffAutoProlongResult>> postTariffAutoprolong(boolean z) {
        Observable<LoadingState<TariffAutoProlongResult>> map = InteropKt.toV2(this.a.postTariffAutoProlong(z ? "1" : "0")).subscribeOn(this.b.io()).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.postTariffAutoProlon…p { it.toLoadingState() }");
        return map;
    }
}
