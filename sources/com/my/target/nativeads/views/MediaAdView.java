package com.my.target.nativeads.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.fj;
import com.my.target.fx;
import com.my.target.gc;
import com.my.target.io;
public class MediaAdView extends FrameLayout {
    public static final int COLOR_PLACEHOLDER_GRAY = -1118482;
    @NonNull
    public final gc a;
    @NonNull
    public final ProgressBar b;
    @NonNull
    public final fx c;
    public int d;
    public int e;
    public float f;

    public MediaAdView(@NonNull Context context) {
        super(context);
        this.a = new gc(context);
        this.c = new fx(context);
        this.b = new ProgressBar(context, null, 16842871);
        a(context);
    }

    public MediaAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new gc(context);
        this.c = new fx(context);
        this.b = new ProgressBar(context, null, 16842871);
        a(context);
    }

    public MediaAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new gc(context);
        this.c = new fx(context);
        this.b = new ProgressBar(context, null, 16842871);
        a(context);
    }

    public final void a(@NonNull Context context) {
        io.a(this.a, "media_image");
        io.a(this.b, "progress_bar");
        io.a(this.c, "play_button");
        setBackgroundColor(COLOR_PLACEHOLDER_GRAY);
        this.b.setVisibility(8);
        Drawable indeterminateDrawable = this.b.getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setColorFilter(-16733198, PorterDuff.Mode.SRC_ATOP);
        }
        this.c.a(fj.C(io.af(context).L(80)), false);
        this.c.setVisibility(8);
        addView(this.a);
        addView(this.c, new FrameLayout.LayoutParams(-2, -2));
        addView(this.b, new FrameLayout.LayoutParams(-2, -2));
    }

    @NonNull
    public ImageView getImageView() {
        return this.a;
    }

    public float getMediaAspectRatio() {
        return this.f;
    }

    @NonNull
    public View getPlayButtonView() {
        return this.c;
    }

    @NonNull
    public ProgressBar getProgressBarView() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0)) {
                    int i6 = ((i3 - i) - measuredWidth) / 2;
                    int i7 = ((i4 - i2) - measuredHeight) / 2;
                    childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b A[SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            int r0 = android.view.View.MeasureSpec.getSize(r11)
            int r1 = android.view.View.MeasureSpec.getSize(r12)
            int r2 = android.view.View.MeasureSpec.getMode(r11)
            int r3 = android.view.View.MeasureSpec.getMode(r12)
            int r4 = r10.d
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            if (r4 == 0) goto L_0x0088
            int r7 = r10.e
            if (r7 != 0) goto L_0x001d
            goto L_0x0088
        L_0x001d:
            float r4 = (float) r4
            float r7 = (float) r7
            float r4 = r4 / r7
            if (r2 != 0) goto L_0x0028
            if (r3 != 0) goto L_0x0028
            super.onMeasure(r11, r12)
            return
        L_0x0028:
            if (r2 != 0) goto L_0x002f
            float r11 = (float) r1
            float r11 = r11 * r4
            int r0 = (int) r11
            goto L_0x0038
        L_0x002f:
            if (r3 != 0) goto L_0x0035
        L_0x0031:
            float r11 = (float) r0
            float r11 = r11 / r4
            int r1 = (int) r11
            goto L_0x0038
        L_0x0035:
            if (r3 == r5) goto L_0x0038
            goto L_0x0031
        L_0x0038:
            int r11 = r10.getChildCount()
            r12 = 0
            r2 = 0
        L_0x003e:
            if (r12 >= r11) goto L_0x007e
            android.view.View r3 = r10.getChildAt(r12)
            int r4 = r3.getVisibility()
            r7 = 8
            if (r4 != r7) goto L_0x004d
            goto L_0x007b
        L_0x004d:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == 0) goto L_0x0067
            int r8 = r4.width
            r9 = -1
            if (r8 != r9) goto L_0x005d
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x005f
        L_0x005d:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x005f:
            int r4 = r4.height
            r7 = r8
            if (r4 != r9) goto L_0x0067
            r4 = 1073741824(0x40000000, float:2.0)
            goto L_0x0069
        L_0x0067:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0069:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r7)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r4)
            r3.measure(r7, r4)
            int r3 = r3.getMeasuredHeight()
            if (r3 <= 0) goto L_0x007b
            r2 = 1
        L_0x007b:
            int r12 = r12 + 1
            goto L_0x003e
        L_0x007e:
            if (r2 == 0) goto L_0x0084
            r10.setMeasuredDimension(r0, r1)
            goto L_0x0087
        L_0x0084:
            r10.setMeasuredDimension(r6, r6)
        L_0x0087:
            return
        L_0x0088:
            if (r2 == r5) goto L_0x008b
            r0 = 0
        L_0x008b:
            if (r3 == r5) goto L_0x008e
            r1 = 0
        L_0x008e:
            r10.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.nativeads.views.MediaAdView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
    }

    public void setPlaceHolderDimension(int i, int i2) {
        this.d = i;
        this.e = i2;
        this.a.setPlaceholderDimensions(i, i2);
        float f2 = (float) i2;
        float f3 = 0.0f;
        if (f2 != 0.0f) {
            f3 = ((float) i) / f2;
        }
        this.f = f3;
    }
}
