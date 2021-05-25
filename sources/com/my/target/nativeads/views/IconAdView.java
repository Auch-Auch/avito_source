package com.my.target.nativeads.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.gc;
import com.my.target.io;
public class IconAdView extends FrameLayout {
    @NonNull
    public final gc a;
    public int b;
    public int c;

    public IconAdView(@NonNull Context context) {
        this(context, null);
    }

    public IconAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        gc gcVar = new gc(context);
        this.a = gcVar;
        io.a(gcVar, "nativeads_icon");
        addView(gcVar);
    }

    @NonNull
    public ImageView getImageView() {
        return this.a;
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

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007d A[SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            int r0 = r11.b
            r1 = 1
            r2 = 0
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L_0x008a
            int r5 = r11.c
            if (r5 != 0) goto L_0x0010
            goto L_0x008a
        L_0x0010:
            float r0 = (float) r0
            float r5 = (float) r5
            float r0 = r0 / r5
            int r5 = android.view.View.MeasureSpec.getSize(r12)
            int r6 = android.view.View.MeasureSpec.getSize(r13)
            int r7 = android.view.View.MeasureSpec.getMode(r12)
            int r8 = android.view.View.MeasureSpec.getMode(r13)
            int r9 = r11.getChildCount()
            if (r7 != 0) goto L_0x0030
            if (r8 != 0) goto L_0x0030
            super.onMeasure(r12, r13)
            goto L_0x00dd
        L_0x0030:
            if (r7 != 0) goto L_0x0037
            float r12 = (float) r6
            float r12 = r12 * r0
            int r5 = (int) r12
            goto L_0x003f
        L_0x0037:
            if (r8 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r8 == r3) goto L_0x003f
        L_0x003c:
            float r12 = (float) r5
            float r12 = r12 / r0
            int r6 = (int) r12
        L_0x003f:
            r12 = 0
            r13 = 0
        L_0x0041:
            if (r12 >= r9) goto L_0x0080
            android.view.View r0 = r11.getChildAt(r12)
            int r7 = r0.getVisibility()
            r8 = 8
            if (r7 != r8) goto L_0x0050
            goto L_0x007d
        L_0x0050:
            android.view.ViewGroup$LayoutParams r7 = r0.getLayoutParams()
            if (r7 == 0) goto L_0x0067
            int r8 = r7.width
            r10 = -1
            if (r8 != r10) goto L_0x005e
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x0060
        L_0x005e:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0060:
            int r7 = r7.height
            if (r7 != r10) goto L_0x0069
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x006b
        L_0x0067:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0069:
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x006b:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r0.measure(r8, r7)
            int r0 = r0.getMeasuredHeight()
            if (r0 <= 0) goto L_0x007d
            r13 = 1
        L_0x007d:
            int r12 = r12 + 1
            goto L_0x0041
        L_0x0080:
            if (r13 == 0) goto L_0x0086
            r11.setMeasuredDimension(r5, r6)
            goto L_0x00dd
        L_0x0086:
            r11.setMeasuredDimension(r2, r2)
            goto L_0x00dd
        L_0x008a:
            int r0 = android.view.View.MeasureSpec.getSize(r12)
            int r5 = android.view.View.MeasureSpec.getSize(r13)
            int r12 = android.view.View.MeasureSpec.getMode(r12)
            int r13 = android.view.View.MeasureSpec.getMode(r13)
            int r6 = r11.getChildCount()
            if (r0 != 0) goto L_0x00a5
            if (r5 != 0) goto L_0x00a5
            r11.setMeasuredDimension(r2, r2)
        L_0x00a5:
            com.my.target.gc r2 = r11.a
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r4)
            r2.measure(r7, r8)
            com.my.target.gc r2 = r11.a
            int r2 = r2.getMeasuredWidth()
            com.my.target.gc r7 = r11.a
            int r7 = r7.getMeasuredHeight()
            if (r13 == r3) goto L_0x00c1
            r5 = r7
        L_0x00c1:
            if (r12 == r3) goto L_0x00c4
            r0 = r2
        L_0x00c4:
            if (r6 <= r1) goto L_0x00da
        L_0x00c6:
            if (r1 >= r6) goto L_0x00da
            android.view.View r12 = r11.getChildAt(r1)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r4)
            r12.measure(r13, r2)
            int r1 = r1 + 1
            goto L_0x00c6
        L_0x00da:
            r11.setMeasuredDimension(r0, r5)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.nativeads.views.IconAdView.onMeasure(int, int):void");
    }

    public void setPlaceHolderDimension(int i, int i2) {
        this.b = i;
        this.c = i2;
        this.a.setPlaceholderDimensions(i, i2);
    }
}
