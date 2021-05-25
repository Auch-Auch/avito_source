package com.avito.android.tariff.fees_methods.limits_info;

import arrow.core.Option;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepositoryImpl;", "Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepository;", "", "checkoutContext", "Lio/reactivex/rxjava3/core/Single;", "Larrow/core/Option;", "Lcom/avito/android/remote/model/LimitsInfo;", "getLimitsInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/PublishLimitsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishLimitsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/PublishLimitsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PaidPublishLimitsInfoRepositoryImpl implements PaidPublishLimitsInfoRepository {
    public final PublishLimitsApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<LimitsInfo, Option<? extends LimitsInfo>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends LimitsInfo> apply(LimitsInfo limitsInfo) {
            return Option.Companion.just(limitsInfo);
        }
    }

    public static final class b<T, R> implements Function<Throwable, Option<? extends LimitsInfo>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends LimitsInfo> apply(Throwable th) {
            return Option.Companion.empty();
        }
    }

    @Inject
    public PaidPublishLimitsInfoRepositoryImpl(@NotNull PublishLimitsApi publishLimitsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(publishLimitsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = publishLimitsApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepository
    @NotNull
    public Single<Option<LimitsInfo>> getLimitsInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Single<R> flatMap = this.a.getLimitsForUnpaidItem(str).flatMap(PaidPublishLimitsInfoRepositoryImpl$getLimitsInfo$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return a2.b.a.a.a.e2(this.b, flatMap.map(a.a).onErrorReturn(b.a), "api.getLimitsForUnpaidIt…n(schedulersFactory.io())");
    }
}
