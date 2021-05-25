package com.avito.android.photo_gallery.tracker;

import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_gallery/tracker/PhotoGalleryTrackerImpl;", "Lcom/avito/android/photo_gallery/tracker/PhotoGalleryTracker;", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryTrackerImpl implements PhotoGalleryTracker {
    public final ScreenDiInjectTracker a;
    public final ScreenInitTracker b;

    @Inject
    public PhotoGalleryTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker, @NotNull ScreenInitTracker screenInitTracker) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        this.a = screenDiInjectTracker;
        this.b = screenInitTracker;
    }

    @Override // com.avito.android.photo_gallery.tracker.PhotoGalleryTracker
    public void startInit() {
        this.b.start();
    }

    @Override // com.avito.android.photo_gallery.tracker.PhotoGalleryTracker
    public void trackDiInject(long j) {
        this.a.track(j);
    }

    @Override // com.avito.android.photo_gallery.tracker.PhotoGalleryTracker
    public void trackInit() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.b, 0, 1, null);
    }
}
