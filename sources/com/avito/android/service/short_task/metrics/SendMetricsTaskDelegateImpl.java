package com.avito.android.service.short_task.metrics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.analytics.event.OpenAppEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTask;
import com.avito.android.util.SchedulersFactory;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/service/short_task/metrics/SendMetricsTaskDelegateImpl;", "Lcom/avito/android/service/short_task/metrics/SendMetricsTaskDelegate;", "", "timeToInteract", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "(Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "providers", "<init>", "(Ljava/util/List;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class SendMetricsTaskDelegateImpl implements SendMetricsTaskDelegate {
    public final List<MetricProvider> a;
    public final Analytics b;
    public final SchedulersFactory c;

    public static final class a<T> implements Consumer<Throwable> {
        public final /* synthetic */ MetricProvider a;
        public final /* synthetic */ SendMetricsTaskDelegateImpl b;

        public a(MetricProvider metricProvider, SendMetricsTaskDelegateImpl sendMetricsTaskDelegateImpl) {
            this.a = metricProvider;
            this.b = sendMetricsTaskDelegateImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Analytics analytics = this.b.b;
            StringBuilder L = a2.b.a.a.a.L("Cannot get metric from ");
            L.append(this.a);
            analytics.track(new NonFatalError(L.toString(), th2, null, 4, null));
        }
    }

    public static final class b<T> implements Consumer<List<Metric>> {
        public final /* synthetic */ SendMetricsTaskDelegateImpl a;
        public final /* synthetic */ Map b;

        public b(SendMetricsTaskDelegateImpl sendMetricsTaskDelegateImpl, Map map) {
            this.a = sendMetricsTaskDelegateImpl;
            this.b = map;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<Metric> list) {
            List<Metric> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "metrics");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                arrayList.add(TuplesKt.to(t.getName(), t.getValue()));
            }
            this.a.b.track(new OpenAppEvent(r.plus(r.toMap(arrayList), this.b)));
        }
    }

    public static final class c<T, R> implements Function<List<Metric>, ShortTask.Status> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(List<Metric> list) {
            Intrinsics.checkNotNullParameter(list, "it");
            return ShortTask.Status.SUCCESS;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.service.short_task.metrics.MetricProvider> */
    /* JADX WARN: Multi-variable type inference failed */
    public SendMetricsTaskDelegateImpl(@NotNull List<? extends MetricProvider> list, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(list, "providers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = list;
        this.b = analytics;
        this.c = schedulersFactory;
    }

    @Override // com.avito.android.service.short_task.metrics.SendMetricsTaskDelegate
    @NotNull
    public Single<ShortTask.Status> start(@Nullable String str) {
        List<MetricProvider> list = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(t.getMetricStream().doOnError(new a(t, this)).onErrorResumeNext(Observable.empty()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str != null) {
            linkedHashMap.put("time_to_interact", str);
        }
        Single<ShortTask.Status> map = Observable.merge(arrayList).take(30, TimeUnit.SECONDS, this.c.computation()).toList().doOnSuccess(new b(this, linkedHashMap)).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "Observable.merge(metricS…hortTask.Status.SUCCESS }");
        return map;
    }
}
