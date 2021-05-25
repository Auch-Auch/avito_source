package com.google.android.flexbox;

import a2.j.b.c.a;
import a2.j.b.c.b;
import a2.j.b.c.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
public class FlexboxLayout extends ViewGroup implements a {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    @Nullable
    public Drawable g;
    @Nullable
    public Drawable h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int[] m;
    public SparseIntArray n;
    public c o;
    public List<FlexLine> p;
    public c.b q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.p.size();
        for (int i6 = 0; i6 < size; i6++) {
            FlexLine flexLine = this.p.get(i6);
            for (int i7 = 0; i7 < flexLine.h; i7++) {
                int i8 = flexLine.o + i7;
                View reorderedChildAt = getReorderedChildAt(i8);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (e(i8, i7)) {
                        if (z) {
                            i5 = reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            i5 = (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.l;
                        }
                        d(canvas, i5, flexLine.b, flexLine.g);
                    }
                    if (i7 == flexLine.h - 1 && (this.j & 4) > 0) {
                        if (z) {
                            i4 = (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.l;
                        } else {
                            i4 = reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        d(canvas, i4, flexLine.b, flexLine.g);
                    }
                }
            }
            if (f(i6)) {
                if (z2) {
                    i3 = flexLine.d;
                } else {
                    i3 = flexLine.b - this.k;
                }
                c(canvas, paddingLeft, i3, max);
            }
            if (g(i6) && (this.i & 4) > 0) {
                if (z2) {
                    i2 = flexLine.b - this.k;
                } else {
                    i2 = flexLine.d;
                }
                c(canvas, paddingLeft, i2, max);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        c cVar = this.o;
        SparseIntArray sparseIntArray = this.n;
        int flexItemCount = cVar.a.getFlexItemCount();
        List<c.C0040c> f2 = cVar.f(flexItemCount);
        c.C0040c cVar2 = new c.C0040c(null);
        if (view == null || !(layoutParams instanceof b)) {
            cVar2.b = 1;
        } else {
            cVar2.b = ((b) layoutParams).getOrder();
        }
        if (i2 == -1 || i2 == flexItemCount) {
            cVar2.a = flexItemCount;
        } else if (i2 < cVar.a.getFlexItemCount()) {
            cVar2.a = i2;
            for (int i3 = i2; i3 < flexItemCount; i3++) {
                ((c.C0040c) ((ArrayList) f2).get(i3)).a++;
            }
        } else {
            cVar2.a = flexItemCount;
        }
        ((ArrayList) f2).add(cVar2);
        this.m = cVar.x(flexItemCount + 1, f2, sparseIntArray);
        super.addView(view, i2, layoutParams);
    }

    public final void b(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.p.size();
        for (int i6 = 0; i6 < size; i6++) {
            FlexLine flexLine = this.p.get(i6);
            for (int i7 = 0; i7 < flexLine.h; i7++) {
                int i8 = flexLine.o + i7;
                View reorderedChildAt = getReorderedChildAt(i8);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (e(i8, i7)) {
                        if (z2) {
                            i5 = reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            i5 = (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.k;
                        }
                        c(canvas, flexLine.a, i5, flexLine.g);
                    }
                    if (i7 == flexLine.h - 1 && (this.i & 4) > 0) {
                        if (z2) {
                            i4 = (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.k;
                        } else {
                            i4 = reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        c(canvas, flexLine.a, i4, flexLine.g);
                    }
                }
            }
            if (f(i6)) {
                if (z) {
                    i3 = flexLine.c;
                } else {
                    i3 = flexLine.a - this.l;
                }
                d(canvas, i3, paddingTop, max);
            }
            if (g(i6) && (this.j & 4) > 0) {
                if (z) {
                    i2 = flexLine.a - this.l;
                } else {
                    i2 = flexLine.c;
                }
                d(canvas, i2, paddingTop, max);
            }
        }
    }

    public final void c(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(i2, i3, i4 + i2, this.k + i3);
            this.g.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setBounds(i2, i3, this.l + i2, i4 + i3);
            this.h.draw(canvas);
        }
    }

    public final boolean e(int i2, int i3) {
        boolean z;
        int i4 = 1;
        while (true) {
            if (i4 > i3) {
                z = true;
                break;
            }
            View reorderedChildAt = getReorderedChildAt(i2 - i4);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                z = false;
                break;
            }
            i4++;
        }
        if (z) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.j & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.i & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.j & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.i & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean f(int i2) {
        boolean z;
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                z = true;
                break;
            } else if (this.p.get(i3).getItemCountNotGone() > 0) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.i & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.j & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.i & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.j & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean g(int i2) {
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.p.size(); i3++) {
            if (this.p.get(i3).getItemCountNotGone() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal()) {
            if ((this.i & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.j & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override // a2.j.b.c.a
    public int getAlignContent() {
        return this.e;
    }

    @Override // a2.j.b.c.a
    public int getAlignItems() {
        return this.d;
    }

    @Override // a2.j.b.c.a
    public int getChildHeightMeasureSpec(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // a2.j.b.c.a
    public int getChildWidthMeasureSpec(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // a2.j.b.c.a
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // a2.j.b.c.a
    public int getDecorationLengthMainAxis(View view, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (isMainAxisDirectionHorizontal()) {
            if (e(i2, i3)) {
                i5 = 0 + this.l;
            }
            if ((this.j & 4) <= 0) {
                return i5;
            }
            i4 = this.l;
        } else {
            if (e(i2, i3)) {
                i5 = 0 + this.k;
            }
            if ((this.i & 4) <= 0) {
                return i5;
            }
            i4 = this.k;
        }
        return i5 + i4;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.h;
    }

    @Override // a2.j.b.c.a
    public int getFlexDirection() {
        return this.a;
    }

    @Override // a2.j.b.c.a
    public View getFlexItemAt(int i2) {
        return getChildAt(i2);
    }

    @Override // a2.j.b.c.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.p.size());
        for (FlexLine flexLine : this.p) {
            if (flexLine.getItemCountNotGone() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // a2.j.b.c.a
    public List<FlexLine> getFlexLinesInternal() {
        return this.p;
    }

    @Override // a2.j.b.c.a
    public int getFlexWrap() {
        return this.b;
    }

    public int getJustifyContent() {
        return this.c;
    }

    @Override // a2.j.b.c.a
    public int getLargestMainSize() {
        int i2 = Integer.MIN_VALUE;
        for (FlexLine flexLine : this.p) {
            i2 = Math.max(i2, flexLine.e);
        }
        return i2;
    }

    @Override // a2.j.b.c.a
    public int getMaxLine() {
        return this.f;
    }

    public View getReorderedChildAt(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.m;
        if (i2 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i2]);
    }

    @Override // a2.j.b.c.a
    public View getReorderedFlexItemAt(int i2) {
        return getReorderedChildAt(i2);
    }

    public int getShowDividerHorizontal() {
        return this.i;
    }

    public int getShowDividerVertical() {
        return this.j;
    }

    @Override // a2.j.b.c.a
    public int getSumOfCrossSize() {
        int i2;
        int i3;
        int size = this.p.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            FlexLine flexLine = this.p.get(i5);
            if (f(i5)) {
                if (isMainAxisDirectionHorizontal()) {
                    i3 = this.k;
                } else {
                    i3 = this.l;
                }
                i4 += i3;
            }
            if (g(i5)) {
                if (isMainAxisDirectionHorizontal()) {
                    i2 = this.k;
                } else {
                    i2 = this.l;
                }
                i4 += i2;
            }
            i4 += flexLine.g;
        }
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(boolean r26, int r27, int r28, int r29, int r30) {
        /*
        // Method dump skipped, instructions count: 522
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.h(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(boolean r28, boolean r29, int r30, int r31, int r32, int r33) {
        /*
        // Method dump skipped, instructions count: 514
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.i(boolean, boolean, int, int, int, int):void");
    }

    @Override // a2.j.b.c.a
    public boolean isMainAxisDirectionHorizontal() {
        int i2 = this.a;
        return i2 == 0 || i2 == 1;
    }

    public final void j(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            i6 = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            i7 = getLargestMainSize();
        } else if (i2 == 2 || i2 == 3) {
            i6 = getLargestMainSize();
            i7 = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Invalid flex direction: ", i2));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = i7;
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            i8 = View.resolveSizeAndState(i7, i3, i5);
        } else if (mode == 1073741824) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else {
            throw new IllegalStateException(a2.b.a.a.a.M2("Unknown width mode is set: ", mode));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, 256);
            } else {
                size2 = i6;
            }
            i9 = View.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            i9 = View.resolveSizeAndState(i6, i4, i5);
        } else if (mode2 == 1073741824) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            i9 = View.resolveSizeAndState(size2, i4, i5);
        } else {
            throw new IllegalStateException(a2.b.a.a.a.M2("Unknown height mode is set: ", mode2));
        }
        setMeasuredDimension(i8, i9);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.h != null || this.g != null) {
            if (this.i != 0 || this.j != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int i2 = this.a;
                boolean z = false;
                boolean z2 = true;
                if (i2 == 0) {
                    boolean z3 = layoutDirection == 1;
                    if (this.b == 2) {
                        z = true;
                    }
                    a(canvas, z3, z);
                } else if (i2 == 1) {
                    boolean z4 = layoutDirection != 1;
                    if (this.b == 2) {
                        z = true;
                    }
                    a(canvas, z4, z);
                } else if (i2 == 2) {
                    if (layoutDirection != 1) {
                        z2 = false;
                    }
                    if (this.b == 2) {
                        z2 = !z2;
                    }
                    b(canvas, z2, false);
                } else if (i2 == 3) {
                    if (layoutDirection == 1) {
                        z = true;
                    }
                    if (this.b == 2) {
                        z = !z;
                    }
                    b(canvas, z, true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i6 = this.a;
        boolean z2 = false;
        if (i6 == 0) {
            h(layoutDirection == 1, i2, i3, i4, i5);
        } else if (i6 == 1) {
            h(layoutDirection != 1, i2, i3, i4, i5);
        } else if (i6 == 2) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            if (this.b == 2) {
                z2 = !z2;
            }
            i(z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            if (this.b == 2) {
                z2 = !z2;
            }
            i(z2, true, i2, i3, i4, i5);
        } else {
            StringBuilder L = a2.b.a.a.a.L("Invalid flex direction is set: ");
            L.append(this.a);
            throw new IllegalStateException(L.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r15, int r16) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onMeasure(int, int):void");
    }

    @Override // a2.j.b.c.a
    public void onNewFlexItemAdded(View view, int i2, int i3, FlexLine flexLine) {
        if (!e(i2, i3)) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            int i4 = flexLine.e;
            int i5 = this.l;
            flexLine.e = i4 + i5;
            flexLine.f += i5;
            return;
        }
        int i6 = flexLine.e;
        int i7 = this.k;
        flexLine.e = i6 + i7;
        flexLine.f += i7;
    }

    @Override // a2.j.b.c.a
    public void onNewFlexLineAdded(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.j & 4) > 0) {
                int i2 = flexLine.e;
                int i3 = this.l;
                flexLine.e = i2 + i3;
                flexLine.f += i3;
            }
        } else if ((this.i & 4) > 0) {
            int i4 = flexLine.e;
            int i5 = this.k;
            flexLine.e = i4 + i5;
            flexLine.f += i5;
        }
    }

    public void setAlignContent(int i2) {
        if (this.e != i2) {
            this.e = i2;
            requestLayout();
        }
    }

    public void setAlignItems(int i2) {
        if (this.d != i2) {
            this.d = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.g) {
            this.g = drawable;
            if (drawable != null) {
                this.k = drawable.getIntrinsicHeight();
            } else {
                this.k = 0;
            }
            if (this.g == null && this.h == null) {
                setWillNotDraw(true);
            } else {
                setWillNotDraw(false);
            }
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.h) {
            this.h = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
            } else {
                this.l = 0;
            }
            if (this.g == null && this.h == null) {
                setWillNotDraw(true);
            } else {
                setWillNotDraw(false);
            }
            requestLayout();
        }
    }

    public void setFlexDirection(int i2) {
        if (this.a != i2) {
            this.a = i2;
            requestLayout();
        }
    }

    @Override // a2.j.b.c.a
    public void setFlexLines(List<FlexLine> list) {
        this.p = list;
    }

    public void setFlexWrap(int i2) {
        if (this.b != i2) {
            this.b = i2;
            requestLayout();
        }
    }

    public void setJustifyContent(int i2) {
        if (this.c != i2) {
            this.c = i2;
            requestLayout();
        }
    }

    public void setMaxLine(int i2) {
        if (this.f != i2) {
            this.f = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.j) {
            this.j = i2;
            requestLayout();
        }
    }

    @Override // a2.j.b.c.a
    public void updateViewCache(int i2, View view) {
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = -1;
        this.o = new c(this);
        this.p = new ArrayList();
        this.q = new c.b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i2, 0);
        this.a = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.b = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.c = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.d = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.e = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.f = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i3 != 0) {
            this.j = i3;
            this.i = i3;
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i4 != 0) {
            this.j = i4;
        }
        int i5 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i5 != 0) {
            this.i = i5;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements b {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        public int a = 1;
        public float b = 0.0f;
        public float c = 1.0f;
        public int d = -1;
        public float e = -1.0f;
        public int f = -1;
        public int g = -1;
        public int h = ViewCompat.MEASURED_SIZE_MASK;
        public int i = ViewCompat.MEASURED_SIZE_MASK;
        public boolean j;

        public static class a implements Parcelable.Creator<LayoutParams> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.b = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.c = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.d = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.e = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.j = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // a2.j.b.c.b
        public int getAlignSelf() {
            return this.d;
        }

        @Override // a2.j.b.c.b
        public float getFlexBasisPercent() {
            return this.e;
        }

        @Override // a2.j.b.c.b
        public float getFlexGrow() {
            return this.b;
        }

        @Override // a2.j.b.c.b
        public float getFlexShrink() {
            return this.c;
        }

        @Override // a2.j.b.c.b
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // a2.j.b.c.b
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // a2.j.b.c.b
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // a2.j.b.c.b
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // a2.j.b.c.b
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // a2.j.b.c.b
        public int getMaxHeight() {
            return this.i;
        }

        @Override // a2.j.b.c.b
        public int getMaxWidth() {
            return this.h;
        }

        @Override // a2.j.b.c.b
        public int getMinHeight() {
            return this.g;
        }

        @Override // a2.j.b.c.b
        public int getMinWidth() {
            return this.f;
        }

        @Override // a2.j.b.c.b
        public int getOrder() {
            return this.a;
        }

        @Override // a2.j.b.c.b
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // a2.j.b.c.b
        public boolean isWrapBefore() {
            return this.j;
        }

        public void setAlignSelf(int i2) {
            this.d = i2;
        }

        public void setFlexBasisPercent(float f2) {
            this.e = f2;
        }

        public void setFlexGrow(float f2) {
            this.b = f2;
        }

        public void setFlexShrink(float f2) {
            this.c = f2;
        }

        public void setHeight(int i2) {
            ((ViewGroup.MarginLayoutParams) this).height = i2;
        }

        public void setMaxHeight(int i2) {
            this.i = i2;
        }

        public void setMaxWidth(int i2) {
            this.h = i2;
        }

        @Override // a2.j.b.c.b
        public void setMinHeight(int i2) {
            this.g = i2;
        }

        @Override // a2.j.b.c.b
        public void setMinWidth(int i2) {
            this.f = i2;
        }

        public void setOrder(int i2) {
            this.a = i2;
        }

        public void setWidth(int i2) {
            ((ViewGroup.MarginLayoutParams) this).width = i2;
        }

        public void setWrapBefore(boolean z) {
            this.j = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeFloat(this.b);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d);
            parcel.writeFloat(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeByte(this.j ? (byte) 1 : 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.a = layoutParams.a;
            this.b = layoutParams.b;
            this.c = layoutParams.c;
            this.d = layoutParams.d;
            this.e = layoutParams.e;
            this.f = layoutParams.f;
            this.g = layoutParams.g;
            this.h = layoutParams.h;
            this.i = layoutParams.i;
            this.j = layoutParams.j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i2, int i3) {
            super(new ViewGroup.LayoutParams(i2, i3));
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z = false;
            this.a = parcel.readInt();
            this.b = parcel.readFloat();
            this.c = parcel.readFloat();
            this.d = parcel.readInt();
            this.e = parcel.readFloat();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readByte() != 0 ? true : z;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
