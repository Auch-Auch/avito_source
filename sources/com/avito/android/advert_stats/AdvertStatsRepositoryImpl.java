package com.avito.android.advert_stats;

import com.avito.android.Features;
import com.avito.android.advert_stats.remote.AdvertStatsApi;
import com.avito.android.advert_stats.remote.model.AdvertStatistics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert_stats/AdvertStatsRepositoryImpl;", "Lcom/avito/android/advert_stats/AdvertStatsRepository;", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/advert_stats/remote/model/AdvertStatistics;", "getAdvertStats", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert_stats/remote/AdvertStatsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_stats/remote/AdvertStatsApi;", "api", "<init>", "(Lcom/avito/android/advert_stats/remote/AdvertStatsApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatsRepositoryImpl implements AdvertStatsRepository {
    public final AdvertStatsApi a;
    public final SchedulersFactory b;
    public final Features c;

    public static final class a<T, R> implements Function<TypedResult<AdvertStatistics>, LoadingState<? super AdvertStatistics>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AdvertStatistics> apply(TypedResult<AdvertStatistics> typedResult) {
            TypedResult<AdvertStatistics> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public AdvertStatsRepositoryImpl(@NotNull AdvertStatsApi advertStatsApi, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertStatsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = advertStatsApi;
        this.b = schedulersFactory;
        this.c = features;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsRepository
    @NotNull
    public Observable<LoadingState<AdvertStatistics>> getAdvertStats(@NotNull String str) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, "itemId");
        if (this.c.getMnzVasUnion().invoke().booleanValue()) {
            observable = InteropKt.toV2(this.a.getAdvertStatisticV4(str));
        } else {
            observable = InteropKt.toV2(this.a.getAdvertStatisticV3(str));
        }
        Observable<LoadingState<AdvertStatistics>> startWith = observable.subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "when {\n            featu…ith(LoadingState.Loading)");
        return startWith;
    }
}
