package com.avito.android.analytics.screens.image;

import a2.a.a.i.i.b.b;
import a2.g.r.g;
import android.net.Uri;
import android.os.Handler;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.event.perfomance.ScreenImageServerLoadingEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.tracker.AbstractTracker;
import com.avito.android.analytics.screens.tracker.SessionResolver;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010E\u001a\u00020B¢\u0006\u0004\bH\u0010IJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/avito/android/analytics/screens/image/ImageLoadingTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/AbstractTracker;", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "Landroid/net/Uri;", "source", "", "elapsed", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "trackImageLoading", "(Landroid/net/Uri;JII)V", "", "throwable", "trackImageLoadingFailed", "(Landroid/net/Uri;JLjava/lang/Throwable;)V", "", "contentType", "imageBucket", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Ljava/lang/String;)V", AuthSource.SEND_ABUSE, "(Ljava/lang/String;JLjava/lang/String;)V", "Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;", "h", "Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;", "typeResolver", "Landroid/os/Handler;", "j", "Landroid/os/Handler;", "handler", "", "c", "Ljava/util/Set;", "firstTimes", "Lcom/avito/android/Features;", "k", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/NetworkTypeProvider;", "i", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "e", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", g.a, "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "sessionResolver", "Lcom/avito/android/analytics/screens/Screen;", "f", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "l", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "imageBucketProvider", "Ljava/lang/String;", "screenName", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/Timer;", "timer", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/tracker/SessionResolver;Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;Lcom/avito/android/analytics/NetworkTypeProvider;Landroid/os/Handler;Lcom/avito/android/analytics/screens/Timer;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/image/ImageBucketProvider;Lcom/avito/android/analytics/screens/ScreenTimeProvider;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ImageLoadingTrackerImpl extends AbstractTracker implements ImageLoadingTracker {
    public final String b;
    public Set<String> c = new LinkedHashSet();
    public final Analytics d;
    public final TrackerInfoProvider e;
    public final Screen f;
    public final SessionResolver g;
    public final ImageContentTypeResolver h;
    public final NetworkTypeProvider i;
    public final Handler j;
    public final Features k;
    public final ImageBucketProvider l;
    public final ScreenTimeProvider m;

    public static final class a implements Runnable {
        public final /* synthetic */ ImageLoadingTrackerImpl a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(ImageLoadingTrackerImpl imageLoadingTrackerImpl, long j, String str, String str2) {
            this.a = imageLoadingTrackerImpl;
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long elapsed = this.a.elapsed() - this.b;
            this.a.d.track(new StatsdEvent.TimeEvent(this.a.e.getPrefixStatsd() + ".absolute" + FormatterType.defaultDecimalSeparator + this.a.b + ".image-drawing" + FormatterType.defaultDecimalSeparator + this.c + FormatterType.defaultDecimalSeparator + this.d, Long.valueOf(elapsed)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoadingTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull SessionResolver sessionResolver, @NotNull ImageContentTypeResolver imageContentTypeResolver, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull Handler handler, @NotNull Timer timer, @NotNull Features features, @NotNull ImageBucketProvider imageBucketProvider, @NotNull ScreenTimeProvider screenTimeProvider) {
        super(timer);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(sessionResolver, "sessionResolver");
        Intrinsics.checkNotNullParameter(imageContentTypeResolver, "typeResolver");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(imageBucketProvider, "imageBucketProvider");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        this.d = analytics;
        this.e = trackerInfoProvider;
        this.f = screen;
        this.g = sessionResolver;
        this.h = imageContentTypeResolver;
        this.i = networkTypeProvider;
        this.j = handler;
        this.k = features;
        this.l = imageBucketProvider;
        this.m = screenTimeProvider;
        this.b = screen.getName();
    }

    public static void c(ImageLoadingTrackerImpl imageLoadingTrackerImpl, String str, int i2, int i3, String str2, String str3, boolean z, int i4) {
        boolean z2;
        ImageLoadingTrackerImpl imageLoadingTrackerImpl2;
        int i5 = (i4 & 2) != 0 ? 0 : i2;
        int i6 = (i4 & 4) != 0 ? 0 : i3;
        String str4 = (i4 & 16) != 0 ? null : str3;
        if ((i4 & 32) != 0) {
            z2 = true;
            imageLoadingTrackerImpl2 = imageLoadingTrackerImpl;
        } else {
            imageLoadingTrackerImpl2 = imageLoadingTrackerImpl;
            z2 = z;
        }
        imageLoadingTrackerImpl2.j.post(new a2.a.a.i.i.b.a(imageLoadingTrackerImpl, str, i5, i6, str4, z2, str2));
    }

    public static void d(ImageLoadingTrackerImpl imageLoadingTrackerImpl, String str, String str2, long j2, int i2, int i3, String str3, String str4, boolean z, int i4) {
        int i5 = (i4 & 8) != 0 ? 0 : i2;
        int i6 = (i4 & 16) != 0 ? 0 : i3;
        String str5 = (i4 & 64) != 0 ? null : str4;
        boolean z2 = (i4 & 128) != 0 ? true : z;
        if (imageLoadingTrackerImpl.k.getImageMetricToDwh().invoke().booleanValue() || (imageLoadingTrackerImpl.f.getHasSmallEventsCount() && imageLoadingTrackerImpl.k.getSendSmallMetrics().invoke().booleanValue())) {
            imageLoadingTrackerImpl.d.track(new ScreenImageServerLoadingEvent(imageLoadingTrackerImpl.b, imageLoadingTrackerImpl.i.networkType(), str, i5, i6, j2, str2, str3, str5, z2));
        }
    }

    public final void a(String str, long j2, String str2) {
        String networkType = this.i.networkType();
        if (this.k.getImageStatsdMetrics().invoke().booleanValue()) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.J0(this.e, sb, ".absolute", FormatterType.defaultDecimalSeparator);
            sb.append(this.b);
            sb.append(".image-loading");
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(str);
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(networkType);
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(str2);
            this.d.track(new StatsdEvent.TimeEvent(sb.toString(), Long.valueOf(j2)));
        }
    }

    public final void b(String str, String str2) {
        if (this.k.getImageStatsdMetrics().invoke().booleanValue()) {
            this.j.post(new a(this, elapsed(), str, str2));
        }
    }

    @Override // com.avito.android.analytics.screens.image.ImageLoadingTracker
    public void trackImageLoading(@NotNull Uri uri, long j2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(uri, "source");
        String resolve = this.h.resolve(uri);
        String bucket = this.l.getBucket(i2, i3);
        if (!this.c.contains(resolve)) {
            this.c.add(resolve);
            a(resolve, j2, bucket);
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "source.toString()");
            d(this, resolve, InternalConstsKt.FIRST_IMAGE, j2, i2, i3, uri2, null, false, 192);
            b(resolve, bucket);
            String uri3 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri3, "source.toString()");
            c(this, resolve, i2, i3, uri3, null, false, 48);
            this.j.post(new b(this, resolve, bucket));
            return;
        }
        a(resolve, j2, bucket);
        String uri4 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri4, "source.toString()");
        d(this, resolve, InternalConstsKt.REST_IMAGE, j2, i2, i3, uri4, null, false, 192);
        b(resolve, bucket);
    }

    @Override // com.avito.android.analytics.screens.image.ImageLoadingTracker
    public void trackImageLoadingFailed(@NotNull Uri uri, long j2, @Nullable Throwable th) {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Intrinsics.checkNotNullParameter(uri, "source");
        String resolve = this.h.resolve(uri);
        if (!this.c.contains(resolve)) {
            this.c.add(resolve);
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "source.toString()");
            d(this, resolve, InternalConstsKt.FIRST_IMAGE, j2, 0, 0, uri2, (th == null || (cls3 = th.getClass()) == null) ? null : cls3.getSimpleName(), false, 24);
            String uri3 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri3, "source.toString()");
            c(this, resolve, 0, 0, uri3, (th == null || (cls2 = th.getClass()) == null) ? null : cls2.getSimpleName(), false, 6);
            return;
        }
        String uri4 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri4, "source.toString()");
        d(this, resolve, InternalConstsKt.REST_IMAGE, j2, 0, 0, uri4, (th == null || (cls = th.getClass()) == null) ? null : cls.getSimpleName(), false, 24);
    }
}
