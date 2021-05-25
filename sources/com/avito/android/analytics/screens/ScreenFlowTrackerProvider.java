package com.avito.android.analytics.screens;

import com.avito.android.analytics.screens.image.ImageContentTypeResolver;
import com.avito.android.analytics.screens.image.ImageLoadingTracker;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", "", "contentType", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "getContentDrawing", "(Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;", "typeResolver", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "getImageLoading", "(Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;)Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "getMemoryMeasureTracker", "()Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "getViewPreparing", "(Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "getContentLoadingFromRemoteStorage", "(Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "getContentLoadingFromLocalStorage", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ScreenFlowTrackerProvider {
    @NotNull
    ContentDrawingTracker getContentDrawing(@NotNull String str);

    @NotNull
    ContentLoadingTracker getContentLoadingFromLocalStorage(@NotNull String str);

    @NotNull
    ContentLoadingTracker getContentLoadingFromRemoteStorage(@NotNull String str);

    @NotNull
    ImageLoadingTracker getImageLoading(@NotNull ImageContentTypeResolver imageContentTypeResolver);

    @NotNull
    ScreenMemoryMeasureTracker getMemoryMeasureTracker();

    @NotNull
    ViewDataPreparingTracker getViewPreparing(@NotNull String str);
}
