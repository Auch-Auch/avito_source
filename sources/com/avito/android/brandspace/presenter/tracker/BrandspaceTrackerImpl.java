package com.avito.android.brandspace.presenter.tracker;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.analytics.screens.BrandspaceScreen;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006J"}, d2 = {"Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTrackerImpl;", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "", "attach", "()V", "detach", "destroy", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "startLoadingBrandspace", "trackBrandspaceLoaded", "trackBrandspacePrepare", "trackBrandspaceDraw", "trackBrandspaceLoadError", "trackBrandspaceErrorPrepare", "trackBrandspaceErrorDraw", "restart", "stop", "", "result", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "", PublicConstantsKt.FAILURE, AuthSource.BOOKING_ORDER, "(Z)V", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "brandspaceLoadTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "h", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "brandspaceDrawingTracker", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "d", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "imageLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "brandspacePrepareTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceImageContentTypeResolver;", "e", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceImageContentTypeResolver;", "typeResolver", "Lcom/avito/android/performance/ImageLoadingListener;", "i", "Lcom/avito/android/performance/ImageLoadingListener;", "imageLoadingListener", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "j", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceTrackerImpl implements BrandspaceTracker {
    public final ScreenFlowTrackerProvider a;
    public final ScreenDiInjectTracker b;
    public final ScreenInitTracker c;
    public final ImageLoadingTracker d;
    public final BrandspaceImageContentTypeResolver e;
    public ContentLoadingTracker f;
    public ViewDataPreparingTracker g;
    public ContentDrawingTracker h;
    public ImageLoadingListener i = new ImageLoadingListener(this) { // from class: com.avito.android.brandspace.presenter.tracker.BrandspaceTrackerImpl.1
        public final /* synthetic */ BrandspaceTrackerImpl a;

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
    public ScreenMemoryMeasureTracker j;

    @Inject
    public BrandspaceTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        BrandspaceImageContentTypeResolver brandspaceImageContentTypeResolver = new BrandspaceImageContentTypeResolver();
        this.e = brandspaceImageContentTypeResolver;
        BrandspaceScreen brandspaceScreen = BrandspaceScreen.INSTANCE;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(brandspaceScreen, timerFactory);
        this.a = createScreenFlowTrackerProvider;
        this.j = createScreenFlowTrackerProvider.getMemoryMeasureTracker();
        this.d = createScreenFlowTrackerProvider.getImageLoading(brandspaceImageContentTypeResolver);
        this.b = ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, brandspaceScreen, timerFactory, null, 4, null);
        this.c = ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, brandspaceScreen, timerFactory, null, 4, null);
    }

    public final void a(String str) {
        ContentLoadingTracker contentLoadingTracker = this.f;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 4, null);
        }
        this.f = null;
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE);
        viewPreparing.start();
        this.g = viewPreparing;
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void attach() {
        PerformanceImageObserver.INSTANCE.addListener(this.i);
        this.j.resumeTracking();
    }

    public final void b(boolean z) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.g;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, z);
        }
        this.g = null;
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE);
        contentDrawing.start();
        this.h = contentDrawing;
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void destroy() {
        this.j.reportLeast();
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void detach() {
        PerformanceImageObserver.INSTANCE.removeListener(this.i);
        this.j.pauseTracking();
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void restart() {
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void startInit() {
        this.c.start();
        this.j.restart();
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void startLoadingBrandspace() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE);
        contentLoadingFromRemoteStorage.start();
        this.f = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void stop() {
        this.f = null;
        this.g = null;
        this.h = null;
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackBrandspaceDraw() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, false);
        }
        this.h = null;
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackBrandspaceErrorDraw() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, true);
        }
        this.h = null;
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackBrandspaceErrorPrepare() {
        b(true);
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackBrandspaceLoadError() {
        a(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackBrandspaceLoaded() {
        a("success");
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackBrandspacePrepare() {
        b(false);
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackDiInject(long j2) {
        this.b.track(j2);
    }

    @Override // com.avito.android.brandspace.presenter.tracker.BrandspaceTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.c, 0, 1, null);
    }
}
