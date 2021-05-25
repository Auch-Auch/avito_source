package com.avito.android.user_adverts.items_search.analytics;

import a2.g.r.g;
import com.avito.android.analytics.screens.HomeScreen;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTrackerImpl;", "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startLoadingAdverts", "trackAdvertsLoadingSuccess", "trackAdvertsPrepareSuccess", "startDraw", "trackAdvertsDrawSuccess", "trackAdvertsLoadingError", "trackAdvertsPrepareError", "trackAdvertsDrawError", "attach", "detach", "destroy", "", "result", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "advertsDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "screenMemoryMeasureTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "advertsPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "advertsLoadTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchTrackerImpl implements ProfileItemsSearchTracker {
    public final ScreenFlowTrackerProvider a;
    public final ScreenDiInjectTracker b;
    public final ScreenInitTracker c;
    public ContentLoadingTracker d;
    public ViewDataPreparingTracker e;
    public ContentDrawingTracker f;
    public final ScreenMemoryMeasureTracker g;

    @Inject
    public ProfileItemsSearchTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        HomeScreen homeScreen = HomeScreen.INSTANCE;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(homeScreen, timerFactory);
        this.a = createScreenFlowTrackerProvider;
        this.b = ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, homeScreen, timerFactory, null, 4, null);
        this.c = ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, homeScreen, timerFactory, null, 4, null);
        this.g = createScreenFlowTrackerProvider.getMemoryMeasureTracker();
    }

    public final void a(String str) {
        ContentLoadingTracker contentLoadingTracker = this.d;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, str, 0, 5, null);
        }
        this.d = null;
        ViewDataPreparingTracker viewPreparing = this.a.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        viewPreparing.start();
        this.e = viewPreparing;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void attach() {
        this.g.resumeTracking();
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void destroy() {
        this.g.reportLeast();
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void detach() {
        this.g.pauseTracking();
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void startDraw() {
        ContentDrawingTracker contentDrawing = this.a.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.f = contentDrawing;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void startInit() {
        this.g.restart();
        this.c.start();
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void startLoadingAdverts() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.d = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackAdvertsDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.f;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.f = null;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackAdvertsDrawSuccess() {
        ContentDrawingTracker contentDrawingTracker = this.f;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.f = null;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackAdvertsLoadingError() {
        a(PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackAdvertsLoadingSuccess() {
        a("success");
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackAdvertsPrepareError() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.e;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, true, 1, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackAdvertsPrepareSuccess() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.e;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, false, 1, null);
        }
        this.e = null;
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackDiInject(long j) {
        this.b.track(j);
    }

    @Override // com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.c, 0, 1, null);
    }
}
