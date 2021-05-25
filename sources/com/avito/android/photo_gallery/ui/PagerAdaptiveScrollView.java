package com.avito.android.photo_gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.avito.android.photo_gallery.common.ObservableScrollable;
import com.avito.android.photo_gallery.common.OnScrollChangedListener;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u001e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0017¨\u0006)"}, d2 = {"Lcom/avito/android/photo_gallery/ui/PagerAdaptiveScrollView;", "Landroid/widget/ScrollView;", "Lcom/avito/android/photo_gallery/common/ObservableScrollable;", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "", MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL, "vertical", "oldHorizontal", "oldVertical", "", "onScrollChanged", "(IIII)V", "Lcom/avito/android/photo_gallery/common/OnScrollChangedListener;", "callback", "addOnScrollChangedListener", "(Lcom/avito/android/photo_gallery/common/OnScrollChangedListener;)V", "removeOnScrollChangedListener", "", "d", "F", "lastY", AuthSource.BOOKING_ORDER, "yDistance", AuthSource.SEND_ABUSE, "xDistance", "", "e", "Ljava/util/List;", "scrollChangedListeners", "c", "lastX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PagerAdaptiveScrollView extends ScrollView implements ObservableScrollable {
    public float a;
    public float b;
    public float c;
    public float d;
    public final List<OnScrollChangedListener> e = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerAdaptiveScrollView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.avito.android.photo_gallery.common.ObservableScrollable
    public void addOnScrollChangedListener(@Nullable OnScrollChangedListener onScrollChangedListener) {
        this.e.add(onScrollChangedListener);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = motionEvent.getX();
            this.d = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.a = Math.abs(x - this.c) + this.a;
            float abs = Math.abs(y - this.d) + this.b;
            this.b = abs;
            this.c = x;
            this.d = y;
            if (this.a > abs) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        for (OnScrollChangedListener onScrollChangedListener : this.e) {
            if (onScrollChangedListener != null) {
                onScrollChangedListener.onScroll(i, i2);
            }
        }
    }

    @Override // com.avito.android.photo_gallery.common.ObservableScrollable
    public void removeOnScrollChangedListener(@Nullable OnScrollChangedListener onScrollChangedListener) {
        if (onScrollChangedListener != null) {
            this.e.remove(onScrollChangedListener);
        }
    }
}
