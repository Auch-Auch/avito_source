package com.google.android.material.timepicker;

import a2.j.b.d.t.e;
import android.content.res.ColorStateList;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
public class ClockFaceView extends e implements ClockHandView.OnRotateListener {
    public final int A;
    public String[] B;
    public float C;
    public final ColorStateList D;
    public final ClockHandView t;
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public final SparseArray<TextView> w = new SparseArray<>();
    public final AccessibilityDelegateCompat x;
    public final int[] y;
    public final float[] z = {0.0f, 0.9f, 1.0f};

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClockFaceView(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9) {
        /*
            r7 = this;
            int r0 = com.google.android.material.R.attr.materialClockStyle
            r7.<init>(r8, r9, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r7.u = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r7.v = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.w = r1
            r1 = 3
            float[] r2 = new float[r1]
            r2 = {x00b6: FILL_ARRAY_DATA  , data: [0, 1063675494, 1065353216} // fill-array
            r7.z = r2
            int[] r2 = com.google.android.material.R.styleable.ClockFaceView
            int r3 = com.google.android.material.R.style.Widget_MaterialComponents_TimePicker_Clock
            android.content.res.TypedArray r9 = r8.obtainStyledAttributes(r9, r2, r0, r3)
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.google.android.material.R.styleable.ClockFaceView_clockNumberTextColor
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r9, r2)
            r7.D = r2
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r8)
            int r4 = com.google.android.material.R.layout.material_clockface_view
            r5 = 1
            r3.inflate(r4, r7, r5)
            int r3 = com.google.android.material.R.id.material_clock_hand
            android.view.View r3 = r7.findViewById(r3)
            com.google.android.material.timepicker.ClockHandView r3 = (com.google.android.material.timepicker.ClockHandView) r3
            r7.t = r3
            int r4 = com.google.android.material.R.dimen.material_clock_hand_padding
            int r0 = r0.getDimensionPixelSize(r4)
            r7.A = r0
            int[] r0 = new int[r5]
            r4 = 16842913(0x10100a1, float:2.369401E-38)
            r6 = 0
            r0[r6] = r4
            int r4 = r2.getDefaultColor()
            int r0 = r2.getColorForState(r0, r4)
            int[] r1 = new int[r1]
            r1[r6] = r0
            r1[r5] = r0
            int r0 = r2.getDefaultColor()
            r2 = 2
            r1[r2] = r0
            r7.y = r1
            java.util.List<com.google.android.material.timepicker.ClockHandView$OnRotateListener> r0 = r3.g
            r0.add(r7)
            int r0 = com.google.android.material.R.color.material_timepicker_clockface
            android.content.res.ColorStateList r0 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r8, r0)
            int r0 = r0.getDefaultColor()
            int r1 = com.google.android.material.R.styleable.ClockFaceView_clockFaceBackgroundColor
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r9, r1)
            if (r8 != 0) goto L_0x0089
            goto L_0x008d
        L_0x0089:
            int r0 = r8.getDefaultColor()
        L_0x008d:
            r7.setBackgroundColor(r0)
            android.view.ViewTreeObserver r8 = r7.getViewTreeObserver()
            a2.j.b.d.t.b r0 = new a2.j.b.d.t.b
            r0.<init>(r7)
            r8.addOnPreDrawListener(r0)
            r7.setFocusable(r5)
            r9.recycle()
            a2.j.b.d.t.c r8 = new a2.j.b.d.t.c
            r8.<init>(r7)
            r7.x = r8
            r8 = 12
            java.lang.String[] r8 = new java.lang.String[r8]
            java.lang.String r9 = ""
            java.util.Arrays.fill(r8, r9)
            r7.d(r8, r6)
            return
            fill-array 0x00b6: FILL_ARRAY_DATA  , data: [0, 1063675494, 1065353216]
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.ClockFaceView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void c() {
        RadialGradient radialGradient;
        RectF rectF = this.t.k;
        for (int i = 0; i < this.w.size(); i++) {
            TextView textView = this.w.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.u);
                this.u.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.u);
                this.v.set(this.u);
                if (!RectF.intersects(rectF, this.v)) {
                    radialGradient = null;
                } else {
                    radialGradient = new RadialGradient(rectF.centerX() - this.v.left, rectF.centerY() - this.v.top, 0.5f * rectF.width(), this.y, this.z, Shader.TileMode.CLAMP);
                }
                textView.getPaint().setShader(radialGradient);
                textView.invalidate();
            }
        }
    }

    public void d(String[] strArr, @StringRes int i) {
        this.B = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.w.size();
        for (int i2 = 0; i2 < Math.max(this.B.length, size); i2++) {
            TextView textView = this.w.get(i2);
            if (i2 >= this.B.length) {
                removeView(textView);
                this.w.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.w.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.B[i2]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i2));
                ViewCompat.setAccessibilityDelegate(textView, this.x);
                textView.setTextColor(this.D);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.B[i2]));
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.B.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        c();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z2) {
        if (Math.abs(this.C - f) > 0.001f) {
            this.C = f;
            c();
        }
    }
}
