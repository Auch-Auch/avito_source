package com.avito.android.home.analytics;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.analytics.screens.HomeScreen;
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
import com.google.android.gms.common.internal.ImagesContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u000eJ\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u000eJ\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\u000eJ\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u000eJ\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u000eJ\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u000eR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010/R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010/R\u0018\u0010N\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010/R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010XR\u0018\u0010[\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u00103R\u0018\u0010]\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010I¨\u0006d"}, d2 = {"Lcom/avito/android/home/analytics/HomeTrackerImpl;", "Lcom/avito/android/home/analytics/HomeTracker;", "", "page", "", "result", "", AuthSource.SEND_ABUSE, "(ILjava/lang/String;)V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoadingLocation", "locationIdForLoad", "trackLocationLoadedFromSave", "(Ljava/lang/String;)V", "trackLocationLoaded", "trackLocationLoadError", "startLoadingAdverts", "trackAdvertsLoaded", "(I)V", "trackAdvertsPrepare", "startAdvertsDraw", "trackAdvertsDraw", "trackAdvertsLoadError", "trackAdvertsErrorPrepare", "trackAdvertsErrorDraw", "", ImagesContract.LOCAL, "startLoadingShortcuts", "(Z)V", "trackShortcutsLoaded", "startShortcutsPrepare", "trackShortcutsPrepare", "trackShortcutsDraw", "stopShortcutsLoad", "trackShortcutsLoadError", "stop", "attach", "detach", "destroy", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "advertsLoadTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "k", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "shortcutsDrawingTracker", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "imageLoadingTracker", "Lcom/avito/android/home/analytics/HomeImageContentTypeResolver;", "l", "Lcom/avito/android/home/analytics/HomeImageContentTypeResolver;", "typeResolver", "d", "locationFromSaveLoadTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "o", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "advertsPrepareTracker", "e", "locationLoadTracker", "i", "shortcutsLoadTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/performance/ImageLoadingListener;", "n", "Lcom/avito/android/performance/ImageLoadingListener;", "imageLoadingListener", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "h", "advertsDrawingTracker", "j", "shortcutsPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeTrackerImpl implements HomeTracker {
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
    public final HomeImageContentTypeResolver l;
    public final ImageLoadingTracker m;
    public ImageLoadingListener n = new ImageLoadingListener(this) { // from class: com.avito.android.home.analytics.HomeTrackerImpl.1
        public final /* synthetic */ HomeTrackerImpl a;

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
    public HomeTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        HomeImageContentTypeResolver homeImageContentTypeResolver = new HomeImageContentTypeResolver();
        this.l = homeImageContentTypeResolver;
        HomeScreen homeScreen = HomeScreen.INSTANCE;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(homeScreen, timerFactory);
        this.a = createScreenFlowTrackerProvider;
        this.b = ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, homeScreen, timerFactory, null, 4, null);
        this.c = ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, homeScreen, timerFactory, null, 4, null);
        this.m = createScreenFlowTrackerProvider.getImageLoading(homeImageContentTypeResolver);
        this.o = createScreenFlowTrackerProvider.getMemoryMeasureTracker();
    }

    public final void a(int i2, String str) {
        ContentLoadingTracker contentLoadingTracker = this.f;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(i2), str, 0, 4, null);
        }
        this.f = null;
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        viewPreparing.start();
        this.g = viewPreparing;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void attach() {
        PerformanceImageObserver.INSTANCE.addListener(this.n);
        this.o.resumeTracking();
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void destroy() {
        this.o.reportLeast();
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void detach() {
        PerformanceImageObserver.INSTANCE.removeListener(this.n);
        this.o.pauseTracking();
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void startAdvertsDraw() {
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentDrawing.start();
        this.h = contentDrawing;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void startInit() {
        this.o.restart();
        this.c.start();
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void startLoadingAdverts() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentLoadingFromRemoteStorage.start();
        this.f = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void startLoadingLocation() {
        ContentLoadingTracker contentLoadingFromLocalStorage = this.a.getContentLoadingFromLocalStorage("restore-saved-location");
        contentLoadingFromLocalStorage.start();
        this.d = contentLoadingFromLocalStorage;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void startLoadingShortcuts(boolean z) {
        ContentLoadingTracker contentLoadingTracker;
        if (z) {
            contentLoadingTracker = this.a.getContentLoadingFromLocalStorage(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        } else {
            contentLoadingTracker = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        }
        contentLoadingTracker.start();
        this.i = contentLoadingTracker;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void startShortcutsPrepare() {
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        viewPreparing.start();
        this.j = viewPreparing;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
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

    @Override // com.avito.android.home.analytics.HomeTracker
    public void stopShortcutsLoad() {
        this.j = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackAdvertsDraw(int i2) {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(i2), false);
        }
        this.h = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackAdvertsErrorDraw(int i2) {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(i2), true);
        }
        this.h = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackAdvertsErrorPrepare(int i2) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.g;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(i2), true);
        }
        this.g = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackAdvertsLoadError(int i2) {
        a(i2, PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackAdvertsLoaded(int i2) {
        a(i2, "success");
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackAdvertsPrepare(int i2) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.g;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(i2), false);
        }
        this.g = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackDiInject(long j2) {
        this.b.track(j2);
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.c, 0, 1, null);
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackLocationLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 4, null);
        }
        this.e = null;
        ContentLoadingTracker contentLoadingTracker2 = this.d;
        if (contentLoadingTracker2 != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker2, null, PublicConstantsKt.FAILURE, 0, 4, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackLocationLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackLocationLoadedFromSave(@Nullable String str) {
        ContentLoadingTracker contentLoadingTracker;
        ContentLoadingTracker contentLoadingTracker2 = this.d;
        if (contentLoadingTracker2 != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker2, null, "success", 0, 4, null);
        }
        this.d = null;
        if (str != null) {
            contentLoadingTracker = this.a.getContentLoadingFromRemoteStorage("load-location");
        } else {
            contentLoadingTracker = this.a.getContentLoadingFromLocalStorage("load-location");
        }
        contentLoadingTracker.start();
        this.e = contentLoadingTracker;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackShortcutsDraw() {
        ContentDrawingTracker contentDrawingTracker = this.k;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(null, false);
        }
        this.k = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackShortcutsLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.i;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 4, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
    public void trackShortcutsLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.i;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.home.analytics.HomeTracker
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
