package com.avito.android.tariff.fees_methods.viewmodel;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.Features;
import com.avito.android.remote.TariffApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FeeMethodsResult;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepository;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ5\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepositoryImpl;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/FeeMethodsResult;", "Lcom/avito/android/remote/model/LimitsInfo;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenResponse;", "getFeeMethods", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepository;", "d", "Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepository;", "limitsInfoRepository", "Lcom/avito/android/remote/TariffApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/TariffApi;", "api", "<init>", "(Lcom/avito/android/remote/TariffApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepository;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodsRepositoryImpl implements FeeMethodsRepository {
    public final TariffApi a;
    public final SchedulersFactory3 b;
    public final Features c;
    public final PaidPublishLimitsInfoRepository d;

    public static final class a<T1, T2, R> implements BiFunction<TypedResult<FeeMethodsResult>, Option<? extends LimitsInfo>, TypedResult<Pair<? extends FeeMethodsResult, ? extends LimitsInfo>>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public TypedResult<Pair<? extends FeeMethodsResult, ? extends LimitsInfo>> apply(TypedResult<FeeMethodsResult> typedResult, Option<? extends LimitsInfo> option) {
            TypedResult<FeeMethodsResult> typedResult2 = typedResult;
            Option<? extends LimitsInfo> option2 = option;
            Intrinsics.checkNotNullExpressionValue(option2, "optionalLimits");
            LimitsInfo limitsInfo = (LimitsInfo) OptionKt.getOrElse(option2, a2.a.a.e3.e.f.a.a);
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new TypedResult.OfResult(TuplesKt.to(((TypedResult.OfResult) typedResult2).getResult(), limitsInfo));
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new TypedResult.OfError(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<TypedResult<Pair<? extends FeeMethodsResult, ? extends LimitsInfo>>, LoadingState<? super Pair<? extends FeeMethodsResult, ? extends LimitsInfo>>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Pair<? extends FeeMethodsResult, ? extends LimitsInfo>> apply(TypedResult<Pair<? extends FeeMethodsResult, ? extends LimitsInfo>> typedResult) {
            TypedResult<Pair<? extends FeeMethodsResult, ? extends LimitsInfo>> typedResult2 = typedResult;
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
    public FeeMethodsRepositoryImpl(@NotNull TariffApi tariffApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @NotNull PaidPublishLimitsInfoRepository paidPublishLimitsInfoRepository) {
        Intrinsics.checkNotNullParameter(tariffApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(paidPublishLimitsInfoRepository, "limitsInfoRepository");
        this.a = tariffApi;
        this.b = schedulersFactory3;
        this.c = features;
        this.d = paidPublishLimitsInfoRepository;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsRepository
    @NotNull
    public Observable<LoadingState<Pair<FeeMethodsResult, LimitsInfo>>> getFeeMethods(@NotNull String str) {
        Single<Option<LimitsInfo>> single;
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Single<TypedResult<FeeMethodsResult>> feeMethodsV3 = this.a.getFeeMethodsV3(str);
        if (this.c.getLimitsInfoOnPublish().invoke().booleanValue()) {
            single = this.d.getLimitsInfo(str);
        } else {
            single = Single.just(Option.Companion.empty());
            Intrinsics.checkNotNullExpressionValue(single, "Single.just(Option.empty())");
        }
        io.reactivex.rxjava3.core.Observable<R> subscribeOn = feeMethodsV3.zipWith(single, a.a).toObservable().subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "selectGetFeeMethodBasedO…n(schedulersFactory.io())");
        Observable<LoadingState<Pair<FeeMethodsResult, LimitsInfo>>> startWith = InteropKt.toV2(subscribeOn).map(b.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "selectGetFeeMethodBasedO…ith(LoadingState.Loading)");
        return startWith;
    }
}
