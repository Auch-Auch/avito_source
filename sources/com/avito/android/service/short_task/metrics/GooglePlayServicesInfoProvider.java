package com.avito.android.service.short_task.metrics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GooglePlayServicesInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/service/short_task/metrics/GooglePlayServicesInfoProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "Lcom/avito/android/util/GooglePlayServicesInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/GooglePlayServicesInfo;", "googlePlayServicesInfo", "<init>", "(Lcom/avito/android/util/GooglePlayServicesInfo;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class GooglePlayServicesInfoProvider implements MetricProvider {
    public final GooglePlayServicesInfo a;

    public static final class a<T> implements Predicate<Pair<? extends String, ? extends Object>> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Pair<? extends String, ? extends Object> pair) {
            Pair<? extends String, ? extends Object> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return pair2.getSecond() != null;
        }
    }

    public static final class b<T, R> implements Function<Pair<? extends String, ? extends Object>, Pair<? extends String, ? extends Object>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends String, ? extends Object> apply(Pair<? extends String, ? extends Object> pair) {
            Pair<? extends String, ? extends Object> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return pair2;
        }
    }

    public static final class c<T, R> implements Function<Pair<? extends String, ? extends Object>, Metric> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Metric apply(Pair<? extends String, ? extends Object> pair) {
            Pair<? extends String, ? extends Object> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return new Metric((String) pair2.getFirst(), pair2.getSecond());
        }
    }

    @Inject
    public GooglePlayServicesInfoProvider(@NotNull GooglePlayServicesInfo googlePlayServicesInfo) {
        Intrinsics.checkNotNullParameter(googlePlayServicesInfo, "googlePlayServicesInfo");
        this.a = googlePlayServicesInfo;
    }

    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        Observable<Metric> map = Observable.just(TuplesKt.to("google_play_services_version_code", this.a.getVersionCode()), TuplesKt.to("google_play_services_version_name", this.a.getVersionName()), TuplesKt.to("google_play_services_library_version_code", Integer.valueOf(this.a.getLibraryVersionCode())), TuplesKt.to("google_play_services_compatibility", Boolean.valueOf(this.a.isGooglePlayServicesAvailable()))).filter(a.a).map(b.a).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "Observable.just(\n       …ic(it.first, it.second) }");
        return map;
    }
}
