package com.avito.android.fps;

import a2.g.r.g;
import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.fps.di.FpsCommunication;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0007R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/avito/android/fps/FpsReporter;", "", "", Tracker.Events.CREATIVE_START, "()V", "", AuthSource.BOOKING_ORDER, "D", "dropFrameLimit", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "prefix", "Lio/reactivex/Observable;", "", g.a, "Lio/reactivex/Observable;", "frameLengthProvider", "", "La2/a/a/v0/a;", "d", "Ljava/util/List;", "holders", "c", "frameTime", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "<init>", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/analytics/grafana/GraphitePrefix;Lio/reactivex/Observable;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class FpsReporter {
    public final String a;
    public final double b;
    public final double c;
    public final List<a2.a.a.v0.a> d = CollectionsKt__CollectionsKt.listOf((Object[]) new a2.a.a.v0.a[]{new a2.a.a.v0.a("fps-per-sec", new FpsAccumulator(), 1000000000), new a2.a.a.v0.a("fps-per-10sec", new FpsAccumulator(), RealConnection.IDLE_CONNECTION_HEALTHY_NS)});
    public final Analytics e;
    public final Features f;
    public final Observable<Long> g;

    public static final class a<T> implements Consumer<Long> {
        public final /* synthetic */ FpsReporter a;

        public a(FpsReporter fpsReporter) {
            this.a = fpsReporter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            Long l2 = l;
            FpsReporter fpsReporter = this.a;
            Intrinsics.checkNotNullExpressionValue(l2, "frameLength");
            FpsReporter.access$report(fpsReporter, l2.longValue());
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public FpsReporter(@NotNull Application application, @NotNull Analytics analytics, @NotNull Features features, @NotNull GraphitePrefix graphitePrefix, @FpsCommunication @NotNull Observable<Long> observable) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        Intrinsics.checkNotNullParameter(observable, "frameLengthProvider");
        this.e = analytics;
        this.f = features;
        this.g = observable;
        this.a = graphitePrefix.getVersionsPrefix() + ".fps-measure" + FpsReporterKt.getDotPrefixed("");
        double refreshRate = ((double) 1000000000) / FpsReporterKt.refreshRate(application);
        this.c = refreshRate;
        this.b = refreshRate * ((double) Integer.parseInt(features.getFpsDropFactor().invoke()));
    }

    public static final void access$report(FpsReporter fpsReporter, long j) {
        for (a2.a.a.v0.a aVar : fpsReporter.d) {
            aVar.b.addFrameLength(j);
            if (aVar.b.getTotalDelayNs() > aVar.c) {
                Logs.debug$default("FpsReporter", aVar.a + ": " + aVar.b.meanFps(), null, 4, null);
                aVar.b.clear();
            }
        }
        double d2 = fpsReporter.b;
        if (d2 > ((double) 0)) {
            double d3 = (double) j;
            if (d3 > d2) {
                fpsReporter.e.track(new StatsdEvent.TimeEvent(a2.b.a.a.a.t(new StringBuilder(), fpsReporter.a, ".duration.all"), Long.valueOf(FramesListenerKt.toMs(j))));
                fpsReporter.e.track(new StatsdEvent.TimeEvent(a2.b.a.a.a.t(new StringBuilder(), fpsReporter.a, ".drop-rate.all"), Integer.valueOf(c.roundToInt(d3 / fpsReporter.c))));
            }
        }
    }

    public final void start() {
        if (this.f.getReportFps().invoke().booleanValue()) {
            this.g.subscribe(new a(this), b.a);
        }
    }
}
