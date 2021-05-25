package com.avito.android.analytics.provider.pixel;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Observables;
import com.avito.android.util.RandomizationGenerator;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelEventTrackerImpl;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "", "", "params", "", "trackAdEvent", "(Ljava/util/Map;)V", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "", AuthSource.BOOKING_ORDER, "J", "maxR", "f", "Ljava/lang/String;", "versionName", "Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;", "e", "Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;", "pixelParameterFormatter", AuthSource.SEND_ABUSE, "minR", "Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoder;", "d", "Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoder;", "pixelParameterEncoder", "Lcom/avito/android/analytics/provider/pixel/PixelInteractor;", "h", "Lcom/avito/android/analytics/provider/pixel/PixelInteractor;", "interactor", "Lcom/avito/android/util/RandomizationGenerator;", g.a, "Lcom/avito/android/util/RandomizationGenerator;", "randomizationGenerator", "<init>", "(Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoder;Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;Ljava/lang/String;Lcom/avito/android/util/RandomizationGenerator;Lcom/avito/android/analytics/provider/pixel/PixelInteractor;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class PixelEventTrackerImpl implements PixelEventTracker {
    public final long a = 100000000000000L;
    public final long b = 1000000000000000L;
    public final CompositeDisposable c = new CompositeDisposable();
    public final PixelParameterEncoder d;
    public final PixelParameterFormatter e;
    public final String f;
    public final RandomizationGenerator g;
    public final PixelInteractor h;

    @Inject
    public PixelEventTrackerImpl(@NotNull PixelParameterEncoder pixelParameterEncoder, @NotNull PixelParameterFormatter pixelParameterFormatter, @Named("version_name") @NotNull String str, @NotNull RandomizationGenerator randomizationGenerator, @NotNull PixelInteractor pixelInteractor) {
        Intrinsics.checkNotNullParameter(pixelParameterEncoder, "pixelParameterEncoder");
        Intrinsics.checkNotNullParameter(pixelParameterFormatter, "pixelParameterFormatter");
        Intrinsics.checkNotNullParameter(str, "versionName");
        Intrinsics.checkNotNullParameter(randomizationGenerator, "randomizationGenerator");
        Intrinsics.checkNotNullParameter(pixelInteractor, "interactor");
        this.d = pixelParameterEncoder;
        this.e = pixelParameterFormatter;
        this.f = str;
        this.g = randomizationGenerator;
        this.h = pixelInteractor;
    }

    @Override // com.avito.android.analytics.provider.pixel.PixelEventTracker
    public void trackAdEvent(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        Map<String, String> mutableMap = r.toMutableMap(map);
        mutableMap.put(VKApiConst.VERSION, this.f);
        DisposableKt.plusAssign(this.c, Observables.subscribeIgnoreResult(this.h.sendAd(r.mapOf(TuplesKt.to("k", this.d.encode(this.e.format(mutableMap))), TuplesKt.to("r", String.valueOf(this.g.nextLong(this.a, this.b)))))));
    }
}
