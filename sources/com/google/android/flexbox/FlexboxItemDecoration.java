package com.google.android.flexbox;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public static final int[] c = {16843284};
    public Drawable a;
    public int b;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public final boolean a() {
        return (this.b & 1) > 0;
    }

    public final boolean b() {
        return (this.b & 2) > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            if (a() || b()) {
                FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
                List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
                int flexDirection = flexboxLayoutManager.getFlexDirection();
                int i = flexboxLayoutManager.A.c[childAdapterPosition];
                boolean z = true;
                if ((i == -1 || i >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(i).o != childAdapterPosition) && childAdapterPosition != 0 && (flexLines.size() == 0 || ((FlexLine) a.j2(flexLines, 1)).p != childAdapterPosition - 1)) {
                    z = false;
                }
                if (!z) {
                    if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                        if (!b()) {
                            rect.left = 0;
                            rect.right = 0;
                        } else if (flexboxLayoutManager.x) {
                            rect.right = this.a.getIntrinsicWidth();
                            rect.left = 0;
                        } else {
                            rect.left = this.a.getIntrinsicWidth();
                            rect.right = 0;
                        }
                    } else if (!a()) {
                        rect.top = 0;
                        rect.bottom = 0;
                    } else if (flexDirection == 3) {
                        rect.bottom = this.a.getIntrinsicHeight();
                        rect.top = 0;
                    } else {
                        rect.top = this.a.getIntrinsicHeight();
                        rect.bottom = 0;
                    }
                }
                if (flexLines.size() != 0 && flexboxLayoutManager.A.c[childAdapterPosition] != 0) {
                    if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                        if (!a()) {
                            rect.top = 0;
                            rect.bottom = 0;
                            return;
                        }
                        rect.top = this.a.getIntrinsicHeight();
                        rect.bottom = 0;
                    } else if (b()) {
                        if (flexboxLayoutManager.x) {
                            rect.right = this.a.getIntrinsicWidth();
                            rect.left = 0;
                            return;
                        }
                        rect.left = this.a.getIntrinsicWidth();
                        rect.right = 0;
                    }
                }
            } else {
                rect.set(0, 0, 0, 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (a()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int paddingRight = recyclerView.getPaddingRight() + recyclerView.getRight();
            int childCount = recyclerView.getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = recyclerView.getChildAt(i15);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    i9 = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i8 = this.a.getIntrinsicHeight() + i9;
                } else {
                    i8 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i9 = i8 - this.a.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    i14 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i13 = childAt.getRight();
                    i12 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (flexboxLayoutManager.x) {
                    i11 = Math.min(this.a.getIntrinsicWidth() + childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, paddingRight);
                    i10 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.a.setBounds(i10, i9, i11, i8);
                    this.a.draw(canvas);
                } else {
                    i14 = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.a.getIntrinsicWidth(), left);
                    i13 = childAt.getRight();
                    i12 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i16 = i13 + i12;
                i10 = i14;
                i11 = i16;
                this.a.setBounds(i10, i9, i11, i8);
                this.a.draw(canvas);
            }
        }
        if (b()) {
            FlexboxLayoutManager flexboxLayoutManager2 = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int paddingBottom = recyclerView.getPaddingBottom() + recyclerView.getBottom();
            int childCount2 = recyclerView.getChildCount();
            int flexDirection2 = flexboxLayoutManager2.getFlexDirection();
            for (int i17 = 0; i17 < childCount2; i17++) {
                View childAt2 = recyclerView.getChildAt(i17);
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) childAt2.getLayoutParams();
                if (flexboxLayoutManager2.x) {
                    i2 = childAt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    i = this.a.getIntrinsicWidth() + i2;
                } else {
                    i = childAt2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    i2 = i - this.a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager2.isMainAxisDirectionHorizontal()) {
                    i5 = childAt2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    i7 = childAt2.getBottom();
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                } else if (flexDirection2 == 3) {
                    i3 = Math.min(this.a.getIntrinsicHeight() + childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, paddingBottom);
                    i4 = childAt2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    this.a.setBounds(i2, i4, i, i3);
                    this.a.draw(canvas);
                } else {
                    i5 = Math.max((childAt2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - this.a.getIntrinsicHeight(), top);
                    i7 = childAt2.getBottom();
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                }
                i3 = i7 + i6;
                i4 = i5;
                this.a.setBounds(i2, i4, i, i3);
                this.a.draw(canvas);
            }
        }
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int i) {
        this.b = i;
    }
}
