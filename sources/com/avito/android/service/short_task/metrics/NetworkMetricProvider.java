package com.avito.android.service.short_task.metrics;

import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/service/short_task/metrics/NetworkMetricProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "Lcom/avito/android/analytics/NetworkTypeProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "<init>", "(Lcom/avito/android/analytics/NetworkTypeProvider;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public class NetworkMetricProvider implements MetricProvider {
    public final NetworkTypeProvider a;

    public static final class a<V> implements Callable<Metric> {
        public final /* synthetic */ NetworkMetricProvider a;

        public a(NetworkMetricProvider networkMetricProvider) {
            this.a = networkMetricProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Metric call() {
            return new Metric("network_type", this.a.a.networkType());
        }
    }

    @Inject
    public NetworkMetricProvider(@NotNull NetworkTypeProvider networkTypeProvider) {
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        this.a = networkTypeProvider;
    }

    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        Observable<Metric> fromCallable = Observable.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable ….networkType())\n        }");
        return fromCallable;
    }
}
