package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;
    public final b a;
    @Nullable
    public AspectRatioListener b;
    public float c;
    public int d;

    public interface AspectRatioListener {
        void onAspectRatioUpdated(float f, float f2, boolean z);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public final class b implements Runnable {
        public float a;
        public float b;
        public boolean c;
        public boolean d;

        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d = false;
            AspectRatioListener aspectRatioListener = AspectRatioFrameLayout.this.b;
            if (aspectRatioListener != null) {
                aspectRatioListener.onAspectRatioUpdated(this.a, this.b, this.c);
            }
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    @Override // android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            super.onMeasure(r9, r10)
            float r9 = r8.c
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 > 0) goto L_0x000b
            return
        L_0x000b:
            int r9 = r8.getMeasuredWidth()
            int r0 = r8.getMeasuredHeight()
            float r1 = (float) r9
            float r2 = (float) r0
            float r3 = r1 / r2
            float r4 = r8.c
            float r4 = r4 / r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r5
            float r5 = java.lang.Math.abs(r4)
            r6 = 1008981770(0x3c23d70a, float:0.01)
            r7 = 1
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x0040
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout$b r9 = r8.a
            float r10 = r8.c
            r0 = 0
            r9.a = r10
            r9.b = r3
            r9.c = r0
            boolean r10 = r9.d
            if (r10 != 0) goto L_0x003f
            r9.d = r7
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout r10 = com.google.android.exoplayer2.ui.AspectRatioFrameLayout.this
            r10.post(r9)
        L_0x003f:
            return
        L_0x0040:
            int r5 = r8.d
            if (r5 == 0) goto L_0x005d
            if (r5 == r7) goto L_0x005a
            r6 = 2
            if (r5 == r6) goto L_0x0057
            r6 = 4
            if (r5 == r6) goto L_0x004d
            goto L_0x006b
        L_0x004d:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0054
            float r9 = r8.c
            goto L_0x0068
        L_0x0054:
            float r10 = r8.c
            goto L_0x0063
        L_0x0057:
            float r9 = r8.c
            goto L_0x0068
        L_0x005a:
            float r10 = r8.c
            goto L_0x0063
        L_0x005d:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0066
            float r10 = r8.c
        L_0x0063:
            float r1 = r1 / r10
            int r0 = (int) r1
            goto L_0x006b
        L_0x0066:
            float r9 = r8.c
        L_0x0068:
            float r2 = r2 * r9
            int r9 = (int) r2
        L_0x006b:
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout$b r10 = r8.a
            float r1 = r8.c
            r10.a = r1
            r10.b = r3
            r10.c = r7
            boolean r1 = r10.d
            if (r1 != 0) goto L_0x0080
            r10.d = r7
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout r1 = com.google.android.exoplayer2.ui.AspectRatioFrameLayout.this
            r1.post(r10)
        L_0x0080:
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10)
            super.onMeasure(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.AspectRatioFrameLayout.onMeasure(int, int):void");
    }

    public void setAspectRatio(float f) {
        if (this.c != f) {
            this.c = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioListener aspectRatioListener) {
        this.b = aspectRatioListener;
    }

    public void setResizeMode(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.d = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.a = new b(null);
    }
}
