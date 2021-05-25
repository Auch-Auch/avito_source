package com.avito.android.advert.tracker;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.AdvertScreen;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.TrackerInfoProvider;
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
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010d\u001a\u00020c¢\u0006\u0004\be\u0010fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u000eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u000eJ\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u000eJ\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u000eJ\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0016H\u0016¢\u0006\u0004\b$\u0010\u0019J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u000eJ\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u000eJ\u000f\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u000eJ\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u000eJ\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u000eJ\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u000eR\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010=R\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u00109¨\u0006g"}, d2 = {"Lcom/avito/android/advert/tracker/AdvertDetailsTrackerImpl;", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "", "result", "", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "", PublicConstantsKt.FAILURE, AuthSource.BOOKING_ORDER, "(Z)V", "c", "d", "attach", "()V", "detach", "destroy", "", "Landroid/net/Uri;", "mainUris", "registerAdvertUris", "(Ljava/util/Set;)V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "startLoadingAdvert", "trackAdvertLoaded", "trackAdvertPrepare", "trackAdvertDraw", "trackAdvertLoadError", "trackAdvertErrorPrepare", "trackAdvertErrorDraw", "clickTime", "trackClickToDrawing", "startComplementaryLoading", "trackComplementaryLoaded", "startComplementaryPrepare", "trackComplementaryPrepare", "trackComplementaryDraw", "trackComplementaryLoadError", "trackComplementaryErrorPrepare", "trackComplementaryErrorDraw", "restart", "stop", "Lcom/avito/android/advert/tracker/AdvertDetailsImageContentTypeResolver;", "e", "Lcom/avito/android/advert/tracker/AdvertDetailsImageContentTypeResolver;", "typeResolver", "Lcom/avito/android/advert/tracker/ScreenClickToDrawingTracker;", "i", "Lcom/avito/android/advert/tracker/ScreenClickToDrawingTracker;", "clickToDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "l", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "complementaryDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "j", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "complementaryLoadTracker", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "imageLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/performance/ImageLoadingListener;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/performance/ImageLoadingListener;", "imageLoadingListener", "f", "advertLoadTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "advertPrepareTracker", "k", "complementaryPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "n", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "h", "advertDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/Analytics;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsTrackerImpl implements AdvertDetailsTracker {
    public final ScreenFlowTrackerProvider a;
    public final ScreenDiInjectTracker b;
    public final ScreenInitTracker c;
    public final ImageLoadingTracker d;
    public final AdvertDetailsImageContentTypeResolver e;
    public ContentLoadingTracker f;
    public ViewDataPreparingTracker g;
    public ContentDrawingTracker h;
    public ScreenClickToDrawingTracker i;
    public ContentLoadingTracker j;
    public ViewDataPreparingTracker k;
    public ContentDrawingTracker l;
    public ImageLoadingListener m = new ImageLoadingListener(this) { // from class: com.avito.android.advert.tracker.AdvertDetailsTrackerImpl.1
        public final /* synthetic */ AdvertDetailsTrackerImpl a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onFailed(@NotNull Uri uri, long j2, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(uri, "source");
            this.a.d.trackImageLoadingFailed(uri, j2, th);
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onLoaded(@NotNull Uri uri, long j2, int i2, int i3) {
            Intrinsics.checkNotNullParameter(uri, "source");
            this.a.d.trackImageLoading(uri, j2, i2, i3);
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onSubmit(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "source");
        }
    };
    public ScreenMemoryMeasureTracker n;

    @Inject
    public AdvertDetailsTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        AdvertDetailsImageContentTypeResolver advertDetailsImageContentTypeResolver = new AdvertDetailsImageContentTypeResolver();
        this.e = advertDetailsImageContentTypeResolver;
        AdvertScreen advertScreen = AdvertScreen.INSTANCE;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(advertScreen, timerFactory);
        this.a = createScreenFlowTrackerProvider;
        this.n = createScreenFlowTrackerProvider.getMemoryMeasureTracker();
        this.d = createScreenFlowTrackerProvider.getImageLoading(advertDetailsImageContentTypeResolver);
        this.b = ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, advertScreen, timerFactory, null, 4, null);
        this.c = ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, advertScreen, timerFactory, null, 4, null);
        this.i = new ScreenClickToDrawingTrackerImpl(analytics, trackerInfoProvider, advertScreen.getName());
    }

    public final void a(String str) {
        ContentLoadingTracker contentLoadingTracker = this.f;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 4, null);
        }
        this.f = null;
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT);
        viewPreparing.start();
        this.g = viewPreparing;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void attach() {
        PerformanceImageObserver.INSTANCE.addListener(this.m);
        this.n.resumeTracking();
    }

    public final void b(boolean z) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.g;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, z);
        }
        this.g = null;
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT);
        contentDrawing.start();
        this.h = contentDrawing;
    }

    public final void c(String str) {
        ContentLoadingTracker contentLoadingTracker = this.j;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 4, null);
        }
        this.j = null;
    }

    public final void d(boolean z) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.k;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, z);
        }
        this.k = null;
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_COMPLEMENTARY_ITEMS);
        contentDrawing.start();
        this.l = contentDrawing;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void destroy() {
        this.n.reportLeast();
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void detach() {
        PerformanceImageObserver.INSTANCE.removeListener(this.m);
        this.n.pauseTracking();
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void registerAdvertUris(@NotNull Set<? extends Uri> set) {
        Intrinsics.checkNotNullParameter(set, "mainUris");
        this.e.registerMainUris(set);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void restart() {
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void startComplementaryLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_COMPLEMENTARY_ITEMS);
        contentLoadingFromRemoteStorage.start();
        this.j = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void startComplementaryPrepare() {
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_COMPLEMENTARY_ITEMS);
        viewPreparing.start();
        this.k = viewPreparing;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void startInit() {
        this.c.start();
        this.n.restart();
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void startLoadingAdvert() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT);
        contentLoadingFromRemoteStorage.start();
        this.f = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void stop() {
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackAdvertDraw() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, false);
        }
        this.h = null;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackAdvertErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, true);
        }
        this.h = null;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackAdvertErrorPrepare() {
        b(true);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackAdvertLoadError() {
        a(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackAdvertLoaded() {
        a("success");
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackAdvertPrepare() {
        b(false);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackClickToDrawing(long j2) {
        ScreenClickToDrawingTracker screenClickToDrawingTracker = this.i;
        if (screenClickToDrawingTracker != null) {
            screenClickToDrawingTracker.trackDrawingContent(j2);
        }
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackComplementaryDraw() {
        ContentDrawingTracker contentDrawingTracker = this.l;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, false);
        }
        this.l = null;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackComplementaryErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.l;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, true);
        }
        this.l = null;
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackComplementaryErrorPrepare() {
        d(true);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackComplementaryLoadError() {
        c(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackComplementaryLoaded() {
        c("success");
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackComplementaryPrepare() {
        d(false);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackDiInject(long j2) {
        this.b.track(j2);
    }

    @Override // com.avito.android.advert.tracker.AdvertDetailsTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.c, 0, 1, null);
    }
}
