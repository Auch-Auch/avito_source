package com.avito.android.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/design/widget/ClickableGalleryPager;", "Lcom/avito/android/design/widget/GalleryPager;", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/GestureDetector;", "l0", "Landroid/view/GestureDetector;", "tapGestureDetector", "m0", "Landroid/view/View$OnClickListener;", "clickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AuthSource.BOOKING_ORDER, "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ClickableGalleryPager extends GalleryPager {
    public final GestureDetector l0 = new GestureDetector(getContext(), new b());
    public View.OnClickListener m0;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ ClickableGalleryPager a;

        public a(ClickableGalleryPager clickableGalleryPager) {
            this.a = clickableGalleryPager;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.a.l0.onTouchEvent(motionEvent);
        }
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "e");
            View.OnClickListener onClickListener = ClickableGalleryPager.this.m0;
            if (onClickListener == null) {
                return true;
            }
            onClickListener.onClick(ClickableGalleryPager.this);
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableGalleryPager(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOnTouchListener(new a(this));
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.m0 = onClickListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableGalleryPager(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setOnTouchListener(new a(this));
    }
}
