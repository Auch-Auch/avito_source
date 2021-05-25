package com.avito.android.analytics.screens.fps;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "", "Lcom/avito/android/analytics/screens/fps/FramesHolder;", "framesHolder", "", "track", "(Lcom/avito/android/analytics/screens/fps/FramesHolder;)V", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface FpsMetricsTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R:\u0010\u000b\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker$Impl;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "Lcom/avito/android/analytics/screens/fps/FramesHolder;", "framesHolder", "", "track", "(Lcom/avito/android/analytics/screens/fps/FramesHolder;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "relay", "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "e", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;", "c", "Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;", "refreshRateProvider", "Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;", "d", "Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;", "calculator", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements FpsMetricsTracker {
        public final PublishRelay<FramesHolder> a;
        public final Disposable b;
        public final RefreshRateProvider c;
        public final FpsMetricsCalculator d;
        public final TrackerInfoProvider e;
        public final Analytics f;
        public final Features g;

        public static final class a<T> implements Consumer<FramesHolder> {
            public final /* synthetic */ Impl a;

            public a(Impl impl) {
                this.a = impl;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(FramesHolder framesHolder) {
                FramesHolder framesHolder2 = framesHolder;
                if (this.a.g.getStatsdFpsMetrics().invoke().booleanValue()) {
                    Impl impl = this.a;
                    Intrinsics.checkNotNullExpressionValue(framesHolder2, "framesHolder");
                    Impl.access$handle(impl, framesHolder2);
                }
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public static final b a = new b();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.error("FpsMetricsTracker", "error", th);
            }
        }

        @Inject
        public Impl(@NotNull SchedulersFactory schedulersFactory, @NotNull RefreshRateProvider refreshRateProvider, @NotNull FpsMetricsCalculator fpsMetricsCalculator, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Analytics analytics, @NotNull Features features) {
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
            Intrinsics.checkNotNullParameter(refreshRateProvider, "refreshRateProvider");
            Intrinsics.checkNotNullParameter(fpsMetricsCalculator, "calculator");
            Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(features, "features");
            this.c = refreshRateProvider;
            this.d = fpsMetricsCalculator;
            this.e = trackerInfoProvider;
            this.f = analytics;
            this.g = features;
            PublishRelay<FramesHolder> create = PublishRelay.create();
            this.a = create;
            Disposable subscribe = create.observeOn(schedulersFactory.computation()).subscribe(new a(this), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "relay.observeOn(schedule…Tracker\", \"error\", it) })");
            this.b = subscribe;
        }

        public static final void access$handle(Impl impl, FramesHolder framesHolder) {
            Objects.requireNonNull(impl);
            String str = framesHolder.getFirstTime() ? ".first" : "";
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.J0(impl.e, sb, ".screen-fps", FormatterType.defaultDecimalSeparator);
            sb.append((long) impl.c.getRefreshRate());
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(framesHolder.getScreenName());
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(framesHolder.getState());
            sb.append(str);
            String sb2 = sb.toString();
            for (Map.Entry<String, Number> entry : impl.d.calculateMetrics(framesHolder.getFrames()).entrySet()) {
                Analytics analytics = impl.f;
                analytics.track(new StatsdEvent.TimeEvent(sb2 + FormatterType.defaultDecimalSeparator + entry.getKey(), entry.getValue()));
            }
        }

        @Override // com.avito.android.analytics.screens.fps.FpsMetricsTracker
        public void track(@NotNull FramesHolder framesHolder) {
            Intrinsics.checkNotNullParameter(framesHolder, "framesHolder");
            this.a.accept(framesHolder);
        }
    }

    void track(@NotNull FramesHolder framesHolder);
}
