package com.avito.android.publish.details.analytics;

import a2.g.r.g;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B)\b\u0007\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010H\u001a\u00020E¢\u0006\u0004\b[\u0010\\J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u000eJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\nH\u0001¢\u0006\u0004\b\u001f\u0010\u000eJ\u0010\u0010 \u001a\u00020\nH\u0001¢\u0006\u0004\b \u0010\u000eJ\u0010\u0010!\u001a\u00020\nH\u0001¢\u0006\u0004\b!\u0010\u000eJ\u0010\u0010\"\u001a\u00020\nH\u0001¢\u0006\u0004\b\"\u0010\u000eJ\u0010\u0010#\u001a\u00020\nH\u0001¢\u0006\u0004\b#\u0010\u000eJ\u0010\u0010$\u001a\u00020\nH\u0001¢\u0006\u0004\b$\u0010\u000eJ\u0010\u0010%\u001a\u00020\nH\u0001¢\u0006\u0004\b%\u0010\u000eJ\u0010\u0010&\u001a\u00020\nH\u0001¢\u0006\u0004\b&\u0010\u000eJ\u0010\u0010'\u001a\u00020\nH\u0001¢\u0006\u0004\b'\u0010\u000eJ\u0010\u0010(\u001a\u00020\nH\u0001¢\u0006\u0004\b(\u0010\u000eJ\u0010\u0010)\u001a\u00020\nH\u0001¢\u0006\u0004\b)\u0010\u000eJ\u0010\u0010*\u001a\u00020\nH\u0001¢\u0006\u0004\b*\u0010\u000eJ\u0010\u0010+\u001a\u00020\nH\u0001¢\u0006\u0004\b+\u0010\u000eJ\u0010\u0010,\u001a\u00020\nH\u0001¢\u0006\u0004\b,\u0010\u000eJ\u0010\u0010-\u001a\u00020\nH\u0001¢\u0006\u0004\b-\u0010\u000eJ\u0010\u0010.\u001a\u00020\nH\u0001¢\u0006\u0004\b.\u0010\u000eJ\u0010\u0010/\u001a\u00020\nH\u0001¢\u0006\u0004\b/\u0010\u000eJ\u0010\u00100\u001a\u00020\nH\u0001¢\u0006\u0004\b0\u0010\u000eJ\u0010\u00101\u001a\u00020\nH\u0001¢\u0006\u0004\b1\u0010\u000eJ\u0010\u00102\u001a\u00020\nH\u0001¢\u0006\u0004\b2\u0010\u000eJ\u0010\u00103\u001a\u00020\nH\u0001¢\u0006\u0004\b3\u0010\u000eJ\u0010\u00104\u001a\u00020\nH\u0001¢\u0006\u0004\b4\u0010\u000eJ\u0010\u00105\u001a\u00020\nH\u0001¢\u0006\u0004\b5\u0010\u000eJ\u0010\u00106\u001a\u00020\nH\u0001¢\u0006\u0004\b6\u0010\u000eJ\u0010\u00107\u001a\u00020\nH\u0001¢\u0006\u0004\b7\u0010\u000eJ\u0010\u00108\u001a\u00020\nH\u0001¢\u0006\u0004\b8\u0010\u000eJ\u0010\u00109\u001a\u00020\nH\u0001¢\u0006\u0004\b9\u0010\u000eJ\u0010\u0010:\u001a\u00020\nH\u0001¢\u0006\u0004\b:\u0010\u000eJ\u0010\u0010;\u001a\u00020\nH\u0001¢\u0006\u0004\b;\u0010\u000eJ\u0010\u0010<\u001a\u00020\nH\u0001¢\u0006\u0004\b<\u0010\u000eJ\u0010\u0010=\u001a\u00020\nH\u0001¢\u0006\u0004\b=\u0010\u000eJ\u0010\u0010>\u001a\u00020\nH\u0001¢\u0006\u0004\b>\u0010\u000eR\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010OR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006]"}, d2 = {"Lcom/avito/android/publish/details/analytics/PublishDetailsTrackerImpl;", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "Lcom/avito/android/publish/details/analytics/AnonymousNumberSlotTracker;", "Lcom/avito/android/publish/details/analytics/MarketPriceSlotTracker;", "Lcom/avito/android/publish/details/analytics/AutoPublishSlotTracker;", "Lcom/avito/android/publish/details/analytics/ContactInfoSlotTracker;", "Lcom/avito/android/publish/details/analytics/InformationWithUserIdSlotTracker;", "Lcom/avito/android/publish/details/analytics/ProfileLoadTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startInitFlowPrepare", "trackInitFlowPrepare", "startInitFlowDraw", "trackInitFlowDraw", "startUpdateFlowPrepare", "trackUpdateFlowPrepare", "startUpdateFlowDraw", "trackUpdateFlowDraw", "stop", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;Lcom/avito/android/analytics/screens/Screen;)V", "startAnonymousNumberSlotDraw", "startAnonymousNumberSlotLoading", "startAnonymousNumberSlotPrepare", "trackAnonymousNumberSlotDraw", "trackAnonymousNumberSlotLoadError", "trackAnonymousNumberSlotLoaded", "trackAnonymousNumberSlotPrepare", "startMarketPriceSlotDraw", "startMarketPriceSlotLoading", "startMarketPriceSlotPrepare", "trackMarketPriceSlotDraw", "trackMarketPriceSlotLoadError", "trackMarketPriceSlotLoaded", "trackMarketPriceSlotPrepare", "startAutoPublishSlotDraw", "startAutoPublishSlotLoading", "startAutoPublishSlotPrepare", "trackAutoPublishSlotDraw", "trackAutoPublishSlotLoadError", "trackAutoPublishSlotLoaded", "trackAutoPublishSlotPrepare", "startContactInfoSlotDraw", "startContactInfoSlotPrepare", "trackContactInfoSlotDraw", "trackContactInfoSlotPrepare", "startInformationWithUserIdSlotDraw", "startInformationWithUserIdSlotPrepare", "trackInformationWithUserIdSlotDraw", "trackInformationWithUserIdSlotPrepare", "startProfileLoading", "trackProfileLoadError", "trackProfileLoaded", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "updateFlowPrepareTracker", AuthSource.SEND_ABUSE, "initFlowPrepareTracker", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "h", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "recovery", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "f", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "updateFlowDrawingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", AuthSource.BOOKING_ORDER, "initFlowDrawingTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "e", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "<init>", "(Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenTransferRecovery;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDetailsTrackerImpl implements PublishDetailsTracker, AnonymousNumberSlotTracker, MarketPriceSlotTracker, AutoPublishSlotTracker, ContactInfoSlotTracker, InformationWithUserIdSlotTracker, ProfileLoadTracker {
    public ViewDataPreparingTracker a;
    public ContentDrawingTracker b;
    public ViewDataPreparingTracker c;
    public ContentDrawingTracker d;
    public final ScreenFlowTrackerProvider e;
    public final ScreenDiInjectTracker f;
    public final ScreenInitTracker g;
    public final ScreenTransferRecovery h;
    public final /* synthetic */ AnonymousNumberSlotTrackerImpl i;
    public final /* synthetic */ MarketPriceSlotTrackerImpl j;
    public final /* synthetic */ AutoPublishSlotTrackerImpl k;
    public final /* synthetic */ ContactInfoSlotTrackerImpl l;
    public final /* synthetic */ InformationWithUserIdSlotTrackerImpl m;
    public final /* synthetic */ ProfileLoadTrackerImpl n;

    @Inject
    public PublishDetailsTrackerImpl(@NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider, @NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenTransferRecovery screenTransferRecovery) {
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenTransferRecovery, "recovery");
        this.i = new AnonymousNumberSlotTrackerImpl(screenFlowTrackerProvider);
        this.j = new MarketPriceSlotTrackerImpl(screenFlowTrackerProvider);
        this.k = new AutoPublishSlotTrackerImpl(screenFlowTrackerProvider);
        this.l = new ContactInfoSlotTrackerImpl(screenFlowTrackerProvider);
        this.m = new InformationWithUserIdSlotTrackerImpl(screenFlowTrackerProvider);
        this.n = new ProfileLoadTrackerImpl(screenFlowTrackerProvider);
        this.e = screenFlowTrackerProvider;
        this.f = screenDiInjectTracker;
        this.g = screenInitTracker;
        this.h = screenTransferRecovery;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void recover(@NotNull ScreenTransfer screenTransfer, @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        this.h.recover(screenTransfer, screen, ScreenPublicConstsKt.CONTENT_TYPE_PRELOAD);
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void startAnonymousNumberSlotDraw() {
        this.i.startAnonymousNumberSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void startAnonymousNumberSlotLoading() {
        this.i.startAnonymousNumberSlotLoading();
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void startAnonymousNumberSlotPrepare() {
        this.i.startAnonymousNumberSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void startAutoPublishSlotDraw() {
        this.k.startAutoPublishSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void startAutoPublishSlotLoading() {
        this.k.startAutoPublishSlotLoading();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void startAutoPublishSlotPrepare() {
        this.k.startAutoPublishSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void startContactInfoSlotDraw() {
        this.l.startContactInfoSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void startContactInfoSlotPrepare() {
        this.l.startContactInfoSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.InformationWithUserIdSlotTracker
    public void startInformationWithUserIdSlotDraw() {
        this.m.startInformationWithUserIdSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.InformationWithUserIdSlotTracker
    public void startInformationWithUserIdSlotPrepare() {
        this.m.startInformationWithUserIdSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void startInit() {
        this.g.start();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void startInitFlowDraw() {
        ContentDrawingTracker contentDrawing = this.e.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentDrawing;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void startInitFlowPrepare() {
        ViewDataPreparingTracker viewPreparing = this.e.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.a = viewPreparing;
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void startMarketPriceSlotDraw() {
        this.j.startMarketPriceSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void startMarketPriceSlotLoading() {
        this.j.startMarketPriceSlotLoading();
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void startMarketPriceSlotPrepare() {
        this.j.startMarketPriceSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.ProfileLoadTracker
    public void startProfileLoading() {
        this.n.startProfileLoading();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void startUpdateFlowDraw() {
        ContentDrawingTracker contentDrawing = this.e.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_UPDATE);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.d = contentDrawing;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void startUpdateFlowPrepare() {
        ViewDataPreparingTracker viewPreparing = this.e.getViewPreparing(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_UPDATE);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.c = viewPreparing;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void stop() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void trackAnonymousNumberSlotDraw() {
        this.i.trackAnonymousNumberSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void trackAnonymousNumberSlotLoadError() {
        this.i.trackAnonymousNumberSlotLoadError();
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void trackAnonymousNumberSlotLoaded() {
        this.i.trackAnonymousNumberSlotLoaded();
    }

    @Override // com.avito.android.publish.details.analytics.AnonymousNumberSlotTracker
    public void trackAnonymousNumberSlotPrepare() {
        this.i.trackAnonymousNumberSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotDraw() {
        this.k.trackAutoPublishSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotLoadError() {
        this.k.trackAutoPublishSlotLoadError();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotLoaded() {
        this.k.trackAutoPublishSlotLoaded();
    }

    @Override // com.avito.android.publish.details.analytics.AutoPublishSlotTracker
    public void trackAutoPublishSlotPrepare() {
        this.k.trackAutoPublishSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void trackContactInfoSlotDraw() {
        this.l.trackContactInfoSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.ContactInfoSlotTracker
    public void trackContactInfoSlotPrepare() {
        this.l.trackContactInfoSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void trackDiInject(long j2) {
        this.f.track(j2);
    }

    @Override // com.avito.android.publish.details.analytics.InformationWithUserIdSlotTracker
    public void trackInformationWithUserIdSlotDraw() {
        this.m.trackInformationWithUserIdSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.InformationWithUserIdSlotTracker
    public void trackInformationWithUserIdSlotPrepare() {
        this.m.trackInformationWithUserIdSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.g, 0, 1, null);
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void trackInitFlowDraw() {
        ContentDrawingTracker contentDrawingTracker = this.b;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void trackInitFlowPrepare() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.a;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, false);
        }
        this.a = null;
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void trackMarketPriceSlotDraw() {
        this.j.trackMarketPriceSlotDraw();
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void trackMarketPriceSlotLoadError() {
        this.j.trackMarketPriceSlotLoadError();
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void trackMarketPriceSlotLoaded() {
        this.j.trackMarketPriceSlotLoaded();
    }

    @Override // com.avito.android.publish.details.analytics.MarketPriceSlotTracker
    public void trackMarketPriceSlotPrepare() {
        this.j.trackMarketPriceSlotPrepare();
    }

    @Override // com.avito.android.publish.details.analytics.ProfileLoadTracker
    public void trackProfileLoadError() {
        this.n.trackProfileLoadError();
    }

    @Override // com.avito.android.publish.details.analytics.ProfileLoadTracker
    public void trackProfileLoaded() {
        this.n.trackProfileLoaded();
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void trackUpdateFlowDraw() {
        ContentDrawingTracker contentDrawingTracker = this.d;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.d = null;
    }

    @Override // com.avito.android.publish.details.analytics.PublishDetailsTracker
    public void trackUpdateFlowPrepare() {
        ViewDataPreparingTracker viewDataPreparingTracker = this.c;
        if (viewDataPreparingTracker != null) {
            viewDataPreparingTracker.trackViewDataPreparing(null, false);
        }
        this.c = null;
    }
}
