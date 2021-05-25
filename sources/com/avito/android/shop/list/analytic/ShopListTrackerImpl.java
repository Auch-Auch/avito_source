package com.avito.android.shop.list.analytic;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/shop/list/analytic/ShopListTrackerImpl;", "Lcom/avito/android/shop/list/analytic/ShopListTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "stop", "startShopsAdverts", "", "offset", "trackShopsLoaded", "(I)V", "startShopsPrepare", "trackShopsPrepare", "trackShopsDraw", "trackShopsLoadError", "trackShopsErrorPrepare", "trackShopsErrorDraw", "startReloadSession", "startLoadMoreShopsSession", "stopLoadShopsSession", "", PublicConstantsKt.FAILURE, "c", "(IZ)V", "", "result", AuthSource.BOOKING_ORDER, "(ILjava/lang/String;)V", AuthSource.SEND_ABUSE, "(I)I", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "shopsPrepareTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "f", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "shopsLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "shopsDrawingTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListTrackerImpl implements ShopListTracker {
    public ContentLoadingTracker a;
    public ViewDataPreparingTracker b;
    public ContentDrawingTracker c;
    public final ScreenDiInjectTracker d;
    public final ScreenInitTracker e;
    public final ScreenFlowTrackerProvider f;

    @Inject
    public ShopListTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.d = screenDiInjectTracker;
        this.e = screenInitTracker;
        this.f = screenFlowTrackerProvider;
    }

    public final int a(int i) {
        boolean z = true;
        if (i <= 0) {
            return 1;
        }
        int i2 = (i / 20) + 1;
        if (i % 20 <= 0) {
            z = false;
        }
        return z ? i2 : i2 + 1;
    }

    public final void b(int i, String str) {
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, Integer.valueOf(a(i)), str, 0, 4, null);
        }
        this.a = null;
    }

    public final void c(int i, boolean z) {
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(Integer.valueOf(a(i)), z);
        }
        this.b = null;
        ContentDrawingTracker contentDrawing = this.f.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void startInit() {
        this.e.start();
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void startLoadMoreShopsSession() {
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void startReloadSession() {
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void startShopsAdverts() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.f.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void startShopsPrepare() {
        ViewDataPreparingTracker viewPreparing = this.f.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
        viewPreparing.start();
        this.b = viewPreparing;
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void stop() {
        this.a = null;
        this.c = null;
        this.b = null;
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void stopLoadShopsSession() {
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackDiInject(long j) {
        this.d.track(j);
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.e, 0, 1, null);
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackShopsDraw(int i) {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(a(i)), false);
        }
        this.c = null;
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackShopsErrorDraw(int i) {
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            contentDrawingTracker.trackContentDrawingTracker(Integer.valueOf(a(i)), true);
        }
        this.c = null;
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackShopsErrorPrepare(int i) {
        c(i, true);
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackShopsLoadError(int i) {
        b(i, PublicConstantsKt.FAILURE);
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackShopsLoaded(int i) {
        b(i, "success");
    }

    @Override // com.avito.android.shop.list.analytic.ShopListTracker
    public void trackShopsPrepare(int i) {
        c(i, false);
    }
}
