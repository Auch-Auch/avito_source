package com.avito.android.publish.wizard.analytics;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTrackerImpl;", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "", "stop", "()V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "trackInit", "restartSession", "startWizardParamsLoading", "trackWizardParamsLoad", "trackWizardParamsLoadError", "startWizardParamsDraw", "trackWizardParamsDrawError", "trackWizardParamsDraw", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "wizardParamsDrawTracker", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "wizardParamsLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "e", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "d", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesWizardTrackerImpl implements CategoriesWizardTracker {
    public ContentDrawingTracker a;
    public ContentLoadingTracker b;
    public final ScreenDiInjectTracker c;
    public final ScreenInitTracker d;
    public final ScreenFlowTrackerProvider e;

    @Inject
    public CategoriesWizardTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.c = screenDiInjectTracker;
        this.d = screenInitTracker;
        this.e = screenFlowTrackerProvider;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void restartSession() {
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void startInit() {
        this.d.start();
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void startWizardParamsDraw() {
        ContentDrawingTracker contentDrawing = this.e.getContentDrawing(ScreenPublicConstsKt.CONTENT_TYPE_CATEGORIES_WIZARD);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentDrawing;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void startWizardParamsLoading() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.e.getContentLoadingFromRemoteStorage(ScreenPublicConstsKt.CONTENT_TYPE_CATEGORIES_WIZARD);
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void stop() {
        this.b = null;
        this.a = null;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void trackDiInject(long j) {
        this.c.track(j);
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.d, 0, 1, null);
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void trackWizardParamsDraw() {
        ContentDrawingTracker contentDrawingTracker = this.a;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, false, 1, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void trackWizardParamsDrawError() {
        ContentDrawingTracker contentDrawingTracker = this.a;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, true, 1, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void trackWizardParamsLoad() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 5, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.publish.wizard.analytics.CategoriesWizardTracker
    public void trackWizardParamsLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 5, null);
        }
        this.b = null;
    }
}
