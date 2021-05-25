package com.avito.android.grouping_adverts.tracker;

import android.net.Uri;
import com.avito.android.analytics.screens.GroupingAdvertsScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.image.ImageLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.performance.ImageLoadingListener;
import com.avito.android.performance.PerformanceImageObserver;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsTrackerImpl;", "Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsTracker;", "", "attach", "()V", "detach", "Lcom/avito/android/performance/ImageLoadingListener;", "d", "Lcom/avito/android/performance/ImageLoadingListener;", "imageLoadingListener", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "c", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "imageLoadingTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsImageContentTypeResolver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/grouping_adverts/tracker/GroupingAdvertsImageContentTypeResolver;", "typeResolver", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsTrackerImpl implements GroupingAdvertsTracker {
    public final ScreenFlowTrackerProvider a;
    public final GroupingAdvertsImageContentTypeResolver b;
    public final ImageLoadingTracker c;
    public ImageLoadingListener d = new ImageLoadingListener(this) { // from class: com.avito.android.grouping_adverts.tracker.GroupingAdvertsTrackerImpl.1
        public final /* synthetic */ GroupingAdvertsTrackerImpl a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onFailed(@NotNull Uri uri, long j, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(uri, "source");
            this.a.c.trackImageLoadingFailed(uri, j, th);
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onLoaded(@NotNull Uri uri, long j, int i, int i2) {
            Intrinsics.checkNotNullParameter(uri, "source");
            this.a.c.trackImageLoading(uri, j, i, i2);
        }

        @Override // com.avito.android.performance.ImageLoadingListener
        public void onSubmit(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "source");
        }
    };

    @Inject
    public GroupingAdvertsTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        GroupingAdvertsImageContentTypeResolver groupingAdvertsImageContentTypeResolver = new GroupingAdvertsImageContentTypeResolver();
        this.b = groupingAdvertsImageContentTypeResolver;
        ScreenFlowTrackerProvider createScreenFlowTrackerProvider = screenTrackerFactory.createScreenFlowTrackerProvider(GroupingAdvertsScreen.INSTANCE, timerFactory);
        this.a = createScreenFlowTrackerProvider;
        this.c = createScreenFlowTrackerProvider.getImageLoading(groupingAdvertsImageContentTypeResolver);
    }

    @Override // com.avito.android.grouping_adverts.tracker.GroupingAdvertsTracker
    public void attach() {
        PerformanceImageObserver.INSTANCE.addListener(this.d);
    }

    @Override // com.avito.android.grouping_adverts.tracker.GroupingAdvertsTracker
    public void detach() {
        PerformanceImageObserver.INSTANCE.removeListener(this.d);
    }
}
