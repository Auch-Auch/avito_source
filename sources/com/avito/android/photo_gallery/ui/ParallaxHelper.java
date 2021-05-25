package com.avito.android.photo_gallery.ui;

import android.view.View;
import com.avito.android.photo_gallery.common.ObservableScrollable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_gallery/ui/ParallaxHelper;", "", "Lcom/avito/android/photo_gallery/ui/ParallaxProgressListener;", "parallaxProgressListener", "", "setParallaxProgressListener", "(Lcom/avito/android/photo_gallery/ui/ParallaxProgressListener;)V", "removeListener", "()V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_gallery/ui/ParallaxProgressListener;", "mParallaxProgressListener", "com/avito/android/photo_gallery/ui/ParallaxHelper$mOnScrollChangedListener$1", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_gallery/ui/ParallaxHelper$mOnScrollChangedListener$1;", "mOnScrollChangedListener", "Landroid/view/View;", "d", "Landroid/view/View;", "mParallaxView", "Lcom/avito/android/photo_gallery/common/ObservableScrollable;", "c", "Lcom/avito/android/photo_gallery/common/ObservableScrollable;", "scrollView", "<init>", "(Lcom/avito/android/photo_gallery/common/ObservableScrollable;Landroid/view/View;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class ParallaxHelper {
    public final ParallaxHelper$mOnScrollChangedListener$1 a;
    public ParallaxProgressListener b;
    public final ObservableScrollable c;
    public final View d;

    public ParallaxHelper(@NotNull ObservableScrollable observableScrollable, @NotNull View view) {
        Intrinsics.checkNotNullParameter(observableScrollable, "scrollView");
        Intrinsics.checkNotNullParameter(view, "mParallaxView");
        this.c = observableScrollable;
        this.d = view;
        ParallaxHelper$mOnScrollChangedListener$1 parallaxHelper$mOnScrollChangedListener$1 = new ParallaxHelper$mOnScrollChangedListener$1(this);
        this.a = parallaxHelper$mOnScrollChangedListener$1;
        observableScrollable.addOnScrollChangedListener(parallaxHelper$mOnScrollChangedListener$1);
    }

    public static final void access$onScrollChanged(ParallaxHelper parallaxHelper, int i) {
        float f = (float) i;
        parallaxHelper.d.setTranslationY(f / 2.5f);
        if (parallaxHelper.b != null) {
            float min = Math.min(1.0f, f / ((float) parallaxHelper.d.getHeight()));
            ParallaxProgressListener parallaxProgressListener = parallaxHelper.b;
            if (parallaxProgressListener != null) {
                parallaxProgressListener.onChangeParallax(min);
            }
        }
    }

    public final void removeListener() {
        this.c.removeOnScrollChangedListener(this.a);
    }

    public final void setParallaxProgressListener(@NotNull ParallaxProgressListener parallaxProgressListener) {
        Intrinsics.checkNotNullParameter(parallaxProgressListener, "parallaxProgressListener");
        this.b = parallaxProgressListener;
    }
}
