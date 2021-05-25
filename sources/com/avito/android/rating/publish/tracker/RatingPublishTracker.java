package com.avito.android.rating.publish.tracker;

import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "", "durationMs", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startDraw", "trackDraw", "startNextStepLoading", "trackNextStepLoadingSuccess", "trackNextStepLoadingFail", "startNextStepDraw", "trackNextStepDrawFail", "trackNextStepDrawSuccess", "startSendRatingLoading", "trackSendRatingLoadingSuccess", "trackSendRatingLoadingFail", "startSendRatingDraw", "trackSendRatingDrawSuccess", "trackSendRatingDrawFail", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingPublishTracker {
    void recover(@NotNull ScreenTransfer screenTransfer);

    void startDraw();

    void startInit();

    void startNextStepDraw();

    void startNextStepLoading();

    void startSendRatingDraw();

    void startSendRatingLoading();

    void trackDiInject(long j);

    void trackDraw();

    void trackInit();

    void trackNextStepDrawFail();

    void trackNextStepDrawSuccess();

    void trackNextStepLoadingFail();

    void trackNextStepLoadingSuccess();

    void trackSendRatingDrawFail();

    void trackSendRatingDrawSuccess();

    void trackSendRatingLoadingFail();

    void trackSendRatingLoadingSuccess();
}
