package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\tH&¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\tH&¢\u0006\u0004\b\u0017\u0010\rJ\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "Lcom/avito/android/publish/details/analytics/AnonymousNumberSlotTracker;", "Lcom/avito/android/publish/details/analytics/MarketPriceSlotTracker;", "Lcom/avito/android/publish/details/analytics/AutoPublishSlotTracker;", "Lcom/avito/android/publish/details/analytics/ContactInfoSlotTracker;", "Lcom/avito/android/publish/details/analytics/InformationWithUserIdSlotTracker;", "Lcom/avito/android/publish/details/analytics/ProfileLoadTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startInitFlowPrepare", "trackInitFlowPrepare", "startInitFlowDraw", "trackInitFlowDraw", "startUpdateFlowPrepare", "trackUpdateFlowPrepare", "startUpdateFlowDraw", "trackUpdateFlowDraw", "stop", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;Lcom/avito/android/analytics/screens/Screen;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDetailsTracker extends AnonymousNumberSlotTracker, MarketPriceSlotTracker, AutoPublishSlotTracker, ContactInfoSlotTracker, InformationWithUserIdSlotTracker, ProfileLoadTracker {
    void recover(@NotNull ScreenTransfer screenTransfer, @NotNull Screen screen);

    void startInit();

    void startInitFlowDraw();

    void startInitFlowPrepare();

    void startUpdateFlowDraw();

    void startUpdateFlowPrepare();

    void stop();

    void trackDiInject(long j);

    void trackInit();

    void trackInitFlowDraw();

    void trackInitFlowPrepare();

    void trackUpdateFlowDraw();

    void trackUpdateFlowPrepare();
}
