package com.avito.android.performance;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.performance.ContentTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/performance/ContentTrackerImpl;", "Lcom/avito/android/performance/ContentTracker;", "", "stop", "()V", "Lcom/avito/android/performance/ContentTracker$StorageType;", "storageType", "loading", "(Lcom/avito/android/performance/ContentTracker$StorageType;)V", "Lcom/avito/android/performance/ContentTracker$State;", "state", "loaded", "(Lcom/avito/android/performance/ContentTracker$State;)V", "preparing", "prepared", "drawing", "drawn", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "viewDataPreparingTracker", "", "d", "Ljava/lang/String;", "contentName", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "c", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "contentDrawingTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "e", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "contentLoadingTracker", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContentTrackerImpl implements ContentTracker {
    public ContentLoadingTracker a;
    public ViewDataPreparingTracker b;
    public ContentDrawingTracker c;
    public final String d;
    public final ScreenFlowTrackerProvider e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ContentTracker.StorageType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
        }
    }

    public ContentTrackerImpl(@NotNull String str, @NotNull ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        Intrinsics.checkNotNullParameter(str, "contentName");
        Intrinsics.checkNotNullParameter(screenFlowTrackerProvider, "flowTrackerProvider");
        this.d = str;
        this.e = screenFlowTrackerProvider;
    }

    @Override // com.avito.android.performance.ContentTracker
    @NotNull
    public <T> T drawing(@NotNull ContentTracker.State state, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function0, "func");
        return (T) ContentTracker.DefaultImpls.drawing(this, state, function0);
    }

    @Override // com.avito.android.performance.ContentTracker
    public void drawn(@NotNull ContentTracker.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ContentDrawingTracker contentDrawingTracker = this.c;
        if (contentDrawingTracker != null) {
            ContentDrawingTracker.DefaultImpls.trackContentDrawingTracker$default(contentDrawingTracker, null, state.getBooleanValue(), 1, null);
        }
        this.c = null;
    }

    @Override // com.avito.android.performance.ContentTracker
    public void loaded(@NotNull ContentTracker.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ContentLoadingTracker contentLoadingTracker = this.a;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, state.getStringValue(), 0, 5, null);
        }
        this.a = null;
    }

    @Override // com.avito.android.performance.ContentTracker
    public void loading(@NotNull ContentTracker.StorageType storageType) {
        ContentLoadingTracker contentLoadingTracker;
        Intrinsics.checkNotNullParameter(storageType, "storageType");
        int ordinal = storageType.ordinal();
        if (ordinal == 0) {
            contentLoadingTracker = this.e.getContentLoadingFromLocalStorage(this.d);
        } else if (ordinal == 1) {
            contentLoadingTracker = this.e.getContentLoadingFromRemoteStorage(this.d);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        contentLoadingTracker.start();
        Unit unit = Unit.INSTANCE;
        this.a = contentLoadingTracker;
    }

    @Override // com.avito.android.performance.ContentTracker
    public void prepared(@NotNull ContentTracker.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ViewDataPreparingTracker viewDataPreparingTracker = this.b;
        if (viewDataPreparingTracker != null) {
            ViewDataPreparingTracker.DefaultImpls.trackViewDataPreparing$default(viewDataPreparingTracker, null, state.getBooleanValue(), 1, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.performance.ContentTracker
    @NotNull
    public <T> T preparing(@NotNull ContentTracker.State state, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function0, "func");
        return (T) ContentTracker.DefaultImpls.preparing(this, state, function0);
    }

    @Override // com.avito.android.performance.ContentTracker
    public void stop() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @Override // com.avito.android.performance.ContentTracker
    public void drawing() {
        ContentDrawingTracker contentDrawing = this.e.getContentDrawing(this.d);
        contentDrawing.start();
        Unit unit = Unit.INSTANCE;
        this.c = contentDrawing;
    }

    @Override // com.avito.android.performance.ContentTracker
    public void preparing() {
        ViewDataPreparingTracker viewPreparing = this.e.getViewPreparing(this.d);
        viewPreparing.start();
        Unit unit = Unit.INSTANCE;
        this.b = viewPreparing;
    }
}
