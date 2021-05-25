package com.avito.android.performance;

import android.net.Uri;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0006R:\u0010\u001c\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u0002 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00190\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/performance/PerformanceImageTracker;", "", "Lcom/avito/android/performance/ImageLoadingListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addListener", "(Lcom/avito/android/performance/ImageLoadingListener;)V", "Landroid/net/Uri;", "source", "reportSubmit", "(Landroid/net/Uri;)V", "", "elapsed", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "reportLoaded", "(Landroid/net/Uri;JII)V", "", "throwable", "reportFailed", "(Landroid/net/Uri;JLjava/lang/Throwable;)V", "removeListener", "", "kotlin.jvm.PlatformType", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", SubscribersReadInteractor.TYPE, "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceImageTracker {
    @NotNull
    public static final PerformanceImageTracker INSTANCE = new PerformanceImageTracker();
    public static final Set<ImageLoadingListener> a = Collections.newSetFromMap(new WeakHashMap());

    public final void addListener(@NotNull ImageLoadingListener imageLoadingListener) {
        Intrinsics.checkNotNullParameter(imageLoadingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a.add(imageLoadingListener);
    }

    public final void removeListener(@NotNull ImageLoadingListener imageLoadingListener) {
        Intrinsics.checkNotNullParameter(imageLoadingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Iterator<ImageLoadingListener> it = a.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), imageLoadingListener)) {
                it.remove();
            }
        }
    }

    public final void reportFailed(@NotNull Uri uri, long j, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(uri, "source");
        for (ImageLoadingListener imageLoadingListener : a) {
            imageLoadingListener.onFailed(uri, j, th);
        }
    }

    public final void reportLoaded(@NotNull Uri uri, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "source");
        for (ImageLoadingListener imageLoadingListener : a) {
            imageLoadingListener.onLoaded(uri, j, i, i2);
        }
    }

    public final void reportSubmit(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "source");
        for (ImageLoadingListener imageLoadingListener : a) {
            imageLoadingListener.onSubmit(uri);
        }
    }
}
