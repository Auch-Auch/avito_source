package com.avito.android.analytics.screens.image;

import android.net.Uri;
import com.avito.android.analytics.screens.tracker.Tracker;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/Tracker;", "Landroid/net/Uri;", "source", "", "elapsed", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "trackImageLoading", "(Landroid/net/Uri;JII)V", "", "throwable", "trackImageLoadingFailed", "(Landroid/net/Uri;JLjava/lang/Throwable;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ImageLoadingTracker extends Tracker {
    void trackImageLoading(@NotNull Uri uri, long j, int i, int i2);

    void trackImageLoadingFailed(@NotNull Uri uri, long j, @Nullable Throwable th);
}
