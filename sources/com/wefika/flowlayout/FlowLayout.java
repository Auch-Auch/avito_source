package com.wefika.flowlayout;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.List;
@TargetApi(14)
public class FlowLayout extends ViewGroup {
    public int a;
    public final List<List<View>> b;
    public final List<Integer> c;
    public final List<Integer> d;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public int getGravity() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        List<View> list;
        int i8;
        int i9;
        int i10;
        FlowLayout flowLayout = this;
        flowLayout.b.clear();
        flowLayout.c.clear();
        flowLayout.d.clear();
        int width = getWidth();
        int height = getHeight();
        int paddingTop = getPaddingTop();
        ArrayList arrayList = new ArrayList();
        int i11 = flowLayout.a & 7;
        float f = i11 != 1 ? i11 != 5 ? 0.0f : 1.0f : 0.5f;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i5 = 8;
            if (i12 >= getChildCount()) {
                break;
            }
            View childAt = flowLayout.getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i14 + measuredWidth > width) {
                    flowLayout.c.add(Integer.valueOf(i13));
                    flowLayout.b.add(arrayList);
                    flowLayout.d.add(Integer.valueOf(getPaddingLeft() + ((int) (((float) (width - i14)) * f))));
                    paddingTop += i13;
                    arrayList = new ArrayList();
                    i13 = 0;
                    i14 = 0;
                }
                i14 += measuredWidth;
                i13 = Math.max(i13, measuredHeight);
                arrayList.add(childAt);
            }
            i12++;
        }
        flowLayout.c.add(Integer.valueOf(i13));
        flowLayout.b.add(arrayList);
        flowLayout.d.add(Integer.valueOf(getPaddingLeft() + ((int) (((float) (width - i14)) * f))));
        int i15 = paddingTop + i13;
        int i16 = flowLayout.a & 112;
        if (i16 != 16) {
            i6 = i16 != 80 ? 0 : height - i15;
        } else {
            i6 = (height - i15) / 2;
        }
        int size = flowLayout.b.size();
        int paddingTop2 = getPaddingTop();
        int i17 = 0;
        while (i17 < size) {
            int intValue = flowLayout.c.get(i17).intValue();
            List<View> list2 = flowLayout.b.get(i17);
            int intValue2 = flowLayout.d.get(i17).intValue();
            int size2 = list2.size();
            int i18 = 0;
            while (i18 < size2) {
                View view = list2.get(i18);
                if (view.getVisibility() == i5) {
                    i8 = size;
                    list = list2;
                    i7 = i14;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -1) {
                        int i19 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
                        if (i19 == -1) {
                            i19 = i14;
                        } else if (i19 < 0) {
                            i10 = Integer.MIN_VALUE;
                            i19 = i14;
                            view.measure(View.MeasureSpec.makeMeasureSpec(i19, i10), View.MeasureSpec.makeMeasureSpec((intValue - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 1073741824));
                        }
                        i10 = 1073741824;
                        view.measure(View.MeasureSpec.makeMeasureSpec(i19, i10), View.MeasureSpec.makeMeasureSpec((intValue - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 1073741824));
                    }
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    if (Gravity.isVertical(layoutParams2.gravity)) {
                        int i20 = layoutParams2.gravity;
                        if (i20 == 16 || i20 == 17) {
                            i9 = (((intValue - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) / 2;
                            int i21 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                            i8 = size;
                            list = list2;
                            int i22 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                            i7 = i14;
                            view.layout(intValue2 + i21, a.G1(paddingTop2, i22, i9, i6), intValue2 + measuredWidth2 + i21, measuredHeight2 + paddingTop2 + i22 + i9 + i6);
                            intValue2 = measuredWidth2 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + intValue2;
                        } else if (i20 == 80) {
                            i9 = ((intValue - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            int i21 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                            i8 = size;
                            list = list2;
                            int i22 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                            i7 = i14;
                            view.layout(intValue2 + i21, a.G1(paddingTop2, i22, i9, i6), intValue2 + measuredWidth2 + i21, measuredHeight2 + paddingTop2 + i22 + i9 + i6);
                            intValue2 = measuredWidth2 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + intValue2;
                        }
                    }
                    i9 = 0;
                    int i21 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    i8 = size;
                    list = list2;
                    int i22 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    i7 = i14;
                    view.layout(intValue2 + i21, a.G1(paddingTop2, i22, i9, i6), intValue2 + measuredWidth2 + i21, measuredHeight2 + paddingTop2 + i22 + i9 + i6);
                    intValue2 = measuredWidth2 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + intValue2;
                }
                i18++;
                i5 = 8;
                size = i8;
                list2 = list;
                i14 = i7;
            }
            paddingTop2 += intValue;
            i17++;
            i5 = 8;
            flowLayout = this;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d9 A[SYNTHETIC] */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r20, int r21) {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wefika.flowlayout.FlowLayout.onMeasure(int, int):void");
    }

    @TargetApi(14)
    public void setGravity(int i) {
        if (this.a != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.a = i;
            requestLayout();
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = BadgeDrawable.TOP_START;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, i, 0);
        try {
            int i2 = obtainStyledAttributes.getInt(R.styleable.FlowLayout_android_gravity, -1);
            if (i2 > 0) {
                setGravity(i2);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity = -1;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_Layout);
            try {
                this.gravity = obtainStyledAttributes.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
