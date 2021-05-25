package com.avito.android.ab_tests;

import com.avito.android.remote.ConfigApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.ab_tests.AbTestsConfigResponse;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/ab_tests/AbTestsReloadTask;", "", "Lio/reactivex/rxjava3/core/Completable;", "load", "()Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "e", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "tracker", "Lcom/avito/android/remote/ConfigApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ConfigApi;", "api", "Lcom/avito/android/ab_tests/AbTestsConfigSaver;", "c", "Lcom/avito/android/ab_tests/AbTestsConfigSaver;", "abTestConfig", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/DeviceMetrics;", "d", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Lcom/avito/android/remote/ConfigApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ab_tests/AbTestsConfigSaver;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/ab_tests/ABTestConfigTracker;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class AbTestsReloadTask {
    public final ConfigApi a;
    public final SchedulersFactory3 b;
    public final AbTestsConfigSaver c;
    public final DeviceMetrics d;
    public final ABTestConfigTracker e;

    public static final class a<T, R> implements Function<TypedResult<AbTestsConfigResponse>, CompletableSource> {
        public final /* synthetic */ AbTestsReloadTask a;

        public a(AbTestsReloadTask abTestsReloadTask) {
            this.a = abTestsReloadTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(TypedResult<AbTestsConfigResponse> typedResult) {
            TypedResult<AbTestsConfigResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                return Completable.fromCallable(new a2.a.a.c.a(this, (AbTestsConfigResponse) ((TypedResult.OfResult) typedResult2).getResult()));
            }
            throw new RuntimeException("Failed to load AB tests config with response " + typedResult2);
        }
    }

    public AbTestsReloadTask(@NotNull ConfigApi configApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AbTestsConfigSaver abTestsConfigSaver, @NotNull DeviceMetrics deviceMetrics, @NotNull ABTestConfigTracker aBTestConfigTracker) {
        Intrinsics.checkNotNullParameter(configApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(abTestsConfigSaver, "abTestConfig");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(aBTestConfigTracker, "tracker");
        this.a = configApi;
        this.b = schedulersFactory3;
        this.c = abTestsConfigSaver;
        this.d = deviceMetrics;
        this.e = aBTestConfigTracker;
    }

    @NotNull
    public final Completable load() {
        this.e.trackAbTestConfigStartFetching();
        Completable flatMapCompletable = this.a.fetchABTestsConfig(true, this.d.getDisplayWidthDp(), this.d.getDisplayHeightDp()).subscribeOn(this.b.io()).firstOrError().observeOn(this.b.io()).flatMapCompletable(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "api.fetchABTestsConfig(\n…          }\n            }");
        return flatMapCompletable;
    }
}
