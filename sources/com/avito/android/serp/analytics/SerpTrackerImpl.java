package com.avito.android.serp.analytics;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.SerpScreen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.image.ImageLoadingTracker;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.performance.ImageLoadingListener;
import com.avito.android.performance.PerformanceImageObserver;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u001dJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u001dJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u001dJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\u001dJ\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0014J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0014J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0014J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0014J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u0014J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0014J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0014J\u000f\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u0014J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u0014J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0014J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0014R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u00101R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010@R\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010@R\u0018\u0010S\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010@R\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010H¨\u0006d"}, d2 = {"Lcom/avito/android/serp/analytics/SerpTrackerImpl;", "Lcom/avito/android/serp/analytics/SerpTracker;", "", "result", "", "c", "(Ljava/lang/String;)V", "", "page", AuthSource.SEND_ABUSE, "(ILjava/lang/String;)V", "", PublicConstantsKt.FAILURE, AuthSource.BOOKING_ORDER, "(IZ)V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoadingParamsBySubscriptionId", "startLoadingParamsTransitFromMemory", "trackParamsLoaded", "trackParamsLoadError", "startLoadingAdverts", "startLocalLoadingAdverts", "startAdLoading", "(I)V", "trackAdvertsLoaded", "trackAdvertsPrepare", "trackAdvertsDraw", "trackAdvertsLoadError", "trackAdvertsErrorPrepare", "trackAdvertsErrorDraw", "startLoadingShortcuts", "trackShortcutsLoaded", "startShortcutsPrepare", "trackShortcutsPrepare", "trackShortcutsDraw", "stopShortcutsLoad", "trackShortcutsLoadError", "stop", "attach", "detach", "destroy", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "advertsPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "j", "shortcutsPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "loadParamsTracker", "Lcom/avito/android/serp/analytics/SerpImageContentTypeResolver;", "l", "Lcom/avito/android/serp/analytics/SerpImageContentTypeResolver;", "typeResolver", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "h", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "advertsDrawingTracker", "e", "advertsLoadTracker", "Lcom/avito/android/performance/ImageLoadingListener;", "n", "Lcom/avito/android/performance/ImageLoadingListener;", "imageLoadingListener", "f", "adLoadTracker", "i", "shortcutsLoadTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "o", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "imageLoadingTracker", "k", "shortcutsDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpTrackerImpl implements SerpTracker {
    public final ScreenFlowTrackerProvider a;
    public final ScreenDiInjectTracker b;
    public final ScreenInitTracker c;
    public ContentLoadingTracker d;
    public ContentLoadingTracker e;
    public ContentLoadingTracker f;
    public ViewDataPreparingTracker g;
    public ContentDrawingTracker h;
    public ContentLoadingTracker i;
    public ViewDataPreparingTracker j;
    public ContentDrawingTracker k;
    public final SerpImageContentTypeResolver l;
    public final ImageLoadingTracker m;
    public ImageLoadingListener n = new ImageLoadingListener(this) { // from class: com.avito.android.serp.analytics.SerpTrackerImpl.1
        public final /* synthetic */ SerpTrackerImpl a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onFailed(@NotNull Uri uri, long j2, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(uri, "source");
            this.a.m.trackImageLoadingFailed(uri, j2, th);
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onLoaded(@NotNull Uri uri, long j2, int i2, int i3) {
            Intrinsics.checkNotNullParameter(uri, "source");
            this.a.m.trackImageLoading(uri, j2, i2, i3);
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onSubmit(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "source");
        }
    };
    public final ScreenMemoryMeasureTracker o;

    @Inject
    public SerpTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        SerpImageContentTypeResolver serpImageContentTypeResolver = new SerpImageContentTypeResolver();
        this.l = serpImageContentTypeResolver;
        SerpScreen serpScreen = SerpScreen.INSTANCE;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(serpScreen, timerFactory);
        this.a = createScreenFlowTrackerProvider;
        this.b = ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, serpScreen, timerFactory, null, 4, null);
        this.c = ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, serpScreen, timerFactory, null, 4, null);
        this.m = createScreenFlowTrackerProvider.getImageLoading(serpImageContentTypeResolver);
        this.o = createScreenFlowTrackerProvider.getMemoryMeasureTracker();
    }

    public final void a(int i2, String str) {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(i2), str, 0, 4, null);
        }
        this.e = null;
        ContentLoadingTracker contentLoadingTracker2 = this.f;
        if (contentLoadingTracker2 != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker2, Integer.valueOf(i2), str, 0, 4, null);
        }
        this.f = null;
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        viewPreparing.start();
        this.g = viewPreparing;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void attach() {
        PerformanceImageObserver.INSTANCE.addListener(this.n);
        this.o.resumeTracking();
    }

    public final void b(int i2, boolean z) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.g;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(i2), z);
        }
        this.g = null;
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentDrawing.start();
        this.h = contentDrawing;
    }

    public final void c(String str) {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 4, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void destroy() {
        this.o.reportLeast();
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void detach() {
        PerformanceImageObserver.INSTANCE.removeListener(this.n);
        this.o.pauseTracking();
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startAdLoading(int i2) {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(i2), "success", 0, 4, null);
        }
        this.e = null;
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage("ad");
        contentLoadingFromRemoteStorage.start();
        this.f = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startInit() {
        this.o.restart();
        this.c.start();
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startLoadingAdverts() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentLoadingFromRemoteStorage.start();
        this.e = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startLoadingParamsBySubscriptionId() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage("subscription-params");
        contentLoadingFromRemoteStorage.start();
        this.d = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startLoadingParamsTransitFromMemory() {
        ContentLoadingTracker contentLoadingFromLocalStorage = this.a.getContentLoadingFromLocalStorage("search-params");
        contentLoadingFromLocalStorage.start();
        this.d = contentLoadingFromLocalStorage;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startLoadingShortcuts() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        contentLoadingFromRemoteStorage.start();
        this.i = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startLocalLoadingAdverts() {
        ContentLoadingTracker contentLoadingFromLocalStorage = this.a.getContentLoadingFromLocalStorage(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentLoadingFromLocalStorage.start();
        this.e = contentLoadingFromLocalStorage;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void startShortcutsPrepare() {
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        viewPreparing.start();
        this.j = viewPreparing;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void stop() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void stopShortcutsLoad() {
        this.j = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackAdvertsDraw(int i2) {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(i2), false);
        }
        this.h = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackAdvertsErrorDraw(int i2) {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(i2), true);
        }
        this.h = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackAdvertsErrorPrepare(int i2) {
        b(i2, true);
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackAdvertsLoadError(int i2) {
        a(i2, PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackAdvertsLoaded(int i2) {
        a(i2, "success");
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackAdvertsPrepare(int i2) {
        b(i2, false);
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackDiInject(long j2) {
        this.b.track(j2);
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.c, 0, 1, null);
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackParamsLoadError() {
        c(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackParamsLoaded() {
        c("success");
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackShortcutsDraw() {
        ContentDrawingTracker contentDrawingTracker = this.k;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, false);
        }
        this.k = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackShortcutsLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.i;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 4, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackShortcutsLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.i;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.serp.analytics.SerpTracker
    public void trackShortcutsPrepare() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.j;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, false);
        }
        this.j = null;
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        contentDrawing.start();
        this.k = contentDrawing;
    }
}
