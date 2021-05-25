package com.avito.android.analytics.screens.fps;

import a2.a.a.i.i.a.a;
import a2.a.a.i.i.a.b;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.fps.FpsState;
import com.avito.android.fps.di.FpsCommunication;
import com.avito.android.fps.di.FpsTrackingThreshold;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsMetricsSupplier;", "Lcom/avito/android/analytics/screens/fps/FpsStateListener;", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface FpsMetricsSupplier extends FpsStateListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u000e\b\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u00101\u001a\u000200\u0012\b\b\u0001\u0010&\u001a\u00020#\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010,R\u0016\u0010/\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010%¨\u00064"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsMetricsSupplier$Impl;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsSupplier;", "Lcom/avito/android/analytics/screens/fps/FpsState;", "state", "", "onStateChanged", "(Lcom/avito/android/analytics/screens/fps/FpsState;)V", AuthSource.BOOKING_ORDER, "()V", "", "", "allFrames", AuthSource.SEND_ABUSE, "(Lcom/avito/android/analytics/screens/fps/FpsState;Ljava/util/List;)V", "", "f", "Ljava/util/Map;", "statesToFrames", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "h", "Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "tracker", "Lio/reactivex/Observable;", g.a, "Lio/reactivex/Observable;", "frameLengthProvider", "Lcom/avito/android/Features;", "j", "Lcom/avito/android/Features;", "features", "c", "Lcom/avito/android/analytics/screens/fps/FpsState;", "", "i", "I", "threshold", "", "d", "Z", "isFirstScroll", "", "Ljava/lang/String;", "screenName", "e", "attempts", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "<init>", "(Lio/reactivex/Observable;Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;Lcom/avito/android/analytics/screens/Screen;ILcom/avito/android/Features;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements FpsMetricsSupplier {
        public final String a;
        public Disposable b;
        public FpsState c = FpsState.Create.INSTANCE;
        public boolean d = true;
        public int e;
        public final Map<FpsState, List<Long>> f = r.mutableMapOf(TuplesKt.to(FpsState.Idle.INSTANCE, new ArrayList()), TuplesKt.to(FpsState.Scroll.INSTANCE, new ArrayList()));
        public final Observable<Long> g;
        public final FpsMetricsTracker h;
        public final int i;
        public final Features j;

        @Inject
        public Impl(@FpsCommunication @NotNull Observable<Long> observable, @NotNull FpsMetricsTracker fpsMetricsTracker, @NotNull Screen screen, @FpsTrackingThreshold int i2, @NotNull Features features) {
            Intrinsics.checkNotNullParameter(observable, "frameLengthProvider");
            Intrinsics.checkNotNullParameter(fpsMetricsTracker, "tracker");
            Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
            Intrinsics.checkNotNullParameter(features, "features");
            this.g = observable;
            this.h = fpsMetricsTracker;
            this.i = i2;
            this.j = features;
            this.a = screen.getName();
        }

        public static final void access$report(Impl impl, long j2) {
            List<Long> list = impl.f.get(impl.c);
            if (list == null) {
                return;
            }
            if (list.size() < 300) {
                list.add(Long.valueOf(j2));
            } else {
                impl.a(impl.c, list);
            }
        }

        public final void a(FpsState fpsState, List<Long> list) {
            boolean z = true;
            int i2 = this.e + 1;
            this.e = i2;
            if (i2 <= this.i) {
                this.f.put(fpsState, new ArrayList());
                FpsMetricsTracker fpsMetricsTracker = this.h;
                if (!Intrinsics.areEqual(fpsState, FpsState.Scroll.INSTANCE) || !this.d) {
                    z = false;
                }
                fpsMetricsTracker.track(new FramesHolder(list, fpsState, z, this.a));
                if (this.e == this.i) {
                    b();
                }
            }
        }

        public final void b() {
            Disposable disposable = this.b;
            if (disposable != null) {
                disposable.dispose();
            }
            this.b = null;
        }

        @Override // com.avito.android.analytics.screens.fps.FpsStateListener
        public void onStateChanged(@NotNull FpsState fpsState) {
            List<Long> list;
            Intrinsics.checkNotNullParameter(fpsState, "state");
            if (!this.j.getStatsdFpsMetrics().invoke().booleanValue()) {
                return;
            }
            if (this.e < this.i) {
                FpsState.Idle idle = FpsState.Idle.INSTANCE;
                if ((Intrinsics.areEqual(fpsState, idle) || Intrinsics.areEqual(fpsState, FpsState.Stop.INSTANCE)) && this.d && Intrinsics.areEqual(this.c, FpsState.Scroll.INSTANCE) && (list = this.f.get(this.c)) != null) {
                    a(this.c, list);
                    this.d = false;
                }
                this.c = fpsState;
                if (Intrinsics.areEqual(fpsState, idle)) {
                    Disposable disposable = this.b;
                    if (disposable == null || disposable.isDisposed()) {
                        this.b = this.g.subscribe(new a(this), b.a);
                    }
                } else if (Intrinsics.areEqual(fpsState, FpsState.Stop.INSTANCE)) {
                    b();
                    for (Map.Entry<FpsState, List<Long>> entry : this.f.entrySet()) {
                        a(entry.getKey(), entry.getValue());
                    }
                }
            } else {
                b();
            }
        }
    }
}
