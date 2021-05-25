package com.avito.android.search.map.metric;

import a2.g.r.g;
import android.net.Uri;
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
import com.avito.android.serp.analytics.SerpImageContentTypeResolver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010V\u001a\u00020U¢\u0006\u0004\bW\u0010XJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010!R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010-R\u0018\u0010<\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010!R\u0018\u0010>\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010-R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010!R\u0018\u0010F\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010-R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006Y"}, d2 = {"Lcom/avito/android/search/map/metric/SearchMapTrackerImpl;", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "", "startMapLoading", "()V", "trackMapLoaded", "startMapPreparing", "trackMapPreparing", "startMapDraw", "trackMapDraw", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "startSerpLoading", "trackSerpLoaded", "startSerpDraw", "trackSerpDraw", "startShortcutsLoading", "trackShortcutsLoaded", "startShortcutsDraw", "trackShortcutsDraw", "startMarkersLoading", "trackMarkersLoaded", "startMarkersDraw", "trackMarkersDraw", "attach", "detach", "destroy", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "j", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "markersContentDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "o", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "mapLoadingTracker", "k", "shortcutsContentDrawingTracker", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "imageLoadingTracker", "Lcom/avito/android/serp/analytics/SerpImageContentTypeResolver;", "l", "Lcom/avito/android/serp/analytics/SerpImageContentTypeResolver;", "typeResolver", "f", "shortcutsLoadingTracker", "h", "mapContentDrawingTracker", "e", "markersLoadingTracker", "Lcom/avito/android/performance/ImageLoadingListener;", "n", "Lcom/avito/android/performance/ImageLoadingListener;", "imageLoadingListener", "i", "serpContentDrawingTracker", "d", "serpLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "mapViewDataPreparingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "p", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "<init>", "(Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapTrackerImpl implements SearchMapTracker {
    public final ScreenDiInjectTracker a;
    public final ScreenInitTracker b;
    public ContentLoadingTracker c;
    public ContentLoadingTracker d;
    public ContentLoadingTracker e;
    public ContentLoadingTracker f;
    public ViewDataPreparingTracker g;
    public ContentDrawingTracker h;
    public ContentDrawingTracker i;
    public ContentDrawingTracker j;
    public ContentDrawingTracker k;
    public final SerpImageContentTypeResolver l;
    public final ImageLoadingTracker m;
    public ImageLoadingListener n = new ImageLoadingListener(this) { // from class: com.avito.android.search.map.metric.SearchMapTrackerImpl.1
        public final /* synthetic */ SearchMapTrackerImpl a;

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
    public ScreenFlowTrackerProvider o;
    public final ScreenMemoryMeasureTracker p = this.o.getMemoryMeasureTracker();

    @Inject
    public SearchMapTrackerImpl(@NotNull TimerFactory timerFactory, @NotNull ScreenTrackerFactory screenTrackerFactory) {
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        SearchMapScreen searchMapScreen = SearchMapScreen.INSTANCE;
        this.a = ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, searchMapScreen, timerFactory, null, 4, null);
        this.b = ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, searchMapScreen, timerFactory, null, 4, null);
        SerpImageContentTypeResolver serpImageContentTypeResolver = new SerpImageContentTypeResolver();
        this.l = serpImageContentTypeResolver;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(searchMapScreen, timerFactory);
        this.o = createScreenFlowTrackerProvider;
        this.m = createScreenFlowTrackerProvider.getImageLoading(serpImageContentTypeResolver);
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void attach() {
        PerformanceImageObserver.INSTANCE.addListener(this.n);
        this.p.resumeTracking();
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void destroy() {
        this.p.reportLeast();
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void detach() {
        PerformanceImageObserver.INSTANCE.removeListener(this.n);
        this.p.pauseTracking();
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startInit() {
        this.p.restart();
        this.b.start();
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startMapDraw() {
        ContentDrawingTracker contentDrawing = this.o.getContentDrawing("map");
        contentDrawing.start();
        this.h = contentDrawing;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startMapLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.o.getContentLoadingFromRemoteStorage("map");
        contentLoadingFromRemoteStorage.start();
        this.c = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startMapPreparing() {
        ViewDataPreparingTracker viewPreparing = this.o.getViewPreparing("map");
        viewPreparing.start();
        this.g = viewPreparing;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startMarkersDraw() {
        ContentDrawingTracker contentDrawing = this.o.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        contentDrawing.start();
        this.j = contentDrawing;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startMarkersLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.o.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        contentLoadingFromRemoteStorage.start();
        this.e = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startSerpDraw() {
        ContentDrawingTracker contentDrawing = this.o.getContentDrawing("adverts-list");
        contentDrawing.start();
        this.i = contentDrawing;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startSerpLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.o.getContentLoadingFromRemoteStorage("adverts-list");
        contentLoadingFromRemoteStorage.start();
        this.d = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startShortcutsDraw() {
        ContentDrawingTracker contentDrawing = this.o.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        contentDrawing.start();
        this.k = contentDrawing;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void startShortcutsLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.o.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        contentLoadingFromRemoteStorage.start();
        this.f = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackDiInject(long j2) {
        this.a.track(j2);
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.b, 0, 1, null);
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackMapDraw() {
        ContentDrawingTracker contentDrawingTracker = this.h;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.h = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackMapLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.c;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackMapPreparing() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.g;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.g = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackMarkersDraw() {
        ContentDrawingTracker contentDrawingTracker = this.j;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.j = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackMarkersLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.e;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackSerpDraw() {
        ContentDrawingTracker contentDrawingTracker = this.i;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.i = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackSerpLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackShortcutsDraw() {
        ContentDrawingTracker contentDrawingTracker = this.k;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.k = null;
    }

    @Override // com.avito.android.search.map.metric.SearchMapTracker
    public void trackShortcutsLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.f;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.f = null;
    }
}
