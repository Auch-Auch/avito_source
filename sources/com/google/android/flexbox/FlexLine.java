package com.google.android.flexbox;

import a2.j.b.c.b;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
public class FlexLine {
    public int a = Integer.MAX_VALUE;
    public int b = Integer.MAX_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public int l;
    public int m;
    public List<Integer> n = new ArrayList();
    public int o;
    public int p;
    public boolean q;
    public boolean r;

    public void a(View view, int i2, int i3, int i4, int i5) {
        b bVar = (b) view.getLayoutParams();
        this.a = Math.min(this.a, (view.getLeft() - bVar.getMarginLeft()) - i2);
        this.b = Math.min(this.b, (view.getTop() - bVar.getMarginTop()) - i3);
        this.c = Math.max(this.c, bVar.getMarginRight() + view.getRight() + i4);
        this.d = Math.max(this.d, bVar.getMarginBottom() + view.getBottom() + i5);
    }

    public int getCrossSize() {
        return this.g;
    }

    public int getFirstIndex() {
        return this.o;
    }

    public int getItemCount() {
        return this.h;
    }

    public int getItemCountNotGone() {
        return this.h - this.i;
    }

    public int getMainSize() {
        return this.e;
    }

    public float getTotalFlexGrow() {
        return this.j;
    }

    public float getTotalFlexShrink() {
        return this.k;
    }
}
