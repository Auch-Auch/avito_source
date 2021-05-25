package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.hj;
@SuppressLint({"ViewConstructor"})
public class hl extends hk {
    public final int Q;

    public hl(boolean z, @NonNull View view, @NonNull View view2, @NonNull hj.a aVar, @Nullable View view3, @NonNull ho hoVar, @NonNull Context context) {
        super(view, view2, aVar, view3, hoVar, context);
        this.Q = z ? 0 : 1;
    }

    public final void b(int i, int i2) {
        io.d(this.d, i2, i);
        int i3 = 0;
        io.d(this.L, this.d.getTop(), 0);
        this.n.layout(0, 0, 0, 0);
        View view = this.o;
        View view2 = this.L;
        if (view2 != null) {
            i2 = view2.getBottom();
        }
        io.b(view, i2, 0);
        ft ftVar = this.t;
        View view3 = this.L;
        if (view3 != null) {
            i3 = view3.getTop();
        }
        int i4 = this.G;
        io.b(ftVar, i3 + i4, i4);
    }

    @Override // com.my.target.hk, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        if (i5 < i4 - i2) {
            io.b(this.d, i2, i);
            Button button = this.p;
            io.a(button, 0, (i4 - this.A) - button.getMeasuredHeight(), i3, i4 - this.A);
            if (this.Q == 1) {
                io.a(this.L, i, this.d.getBottom(), i3, i4);
            }
            io.a(this.s, 0, (this.p.getTop() - this.A) - this.s.getMeasuredHeight(), i3, this.p.getTop() - this.A);
            int top = (this.s.getVisibility() == 0 ? this.s.getTop() : this.p.getTop()) - this.A;
            TextView textView = this.r;
            io.a(textView, 0, top - textView.getMeasuredHeight(), i3, top);
            int top2 = (this.r.getVisibility() == 0 ? this.r.getTop() : top + this.r.getMeasuredHeight()) - this.A;
            TextView textView2 = this.q;
            io.a(textView2, 0, top2 - textView2.getMeasuredHeight(), i3, top2);
            if (this.Q == 0) {
                io.a(this.L, i, this.d.getBottom(), i3, this.r.getTop());
                View view = this.L;
                if (view != null) {
                    i4 = view.getBottom();
                }
            }
            io.b(this.n, this.d.getTop(), this.d.getLeft());
            io.b(this.o, i4, i);
            ft ftVar = this.t;
            View view2 = this.L;
            int top3 = view2 != null ? view2.getTop() : 0;
            int i6 = this.G;
            io.b(ftVar, top3 + i6, i6);
        } else {
            b(i, i4);
        }
        View view3 = this.c.getVisibility() == 0 ? this.c : this.u;
        int i7 = this.F;
        io.c(view3, i2 + i7, i5 - i7);
        io.c(this.k, io.c(i2 + this.A, this.c.getBottom() + this.A, this.u.getBottom() + this.A), i3 - this.A);
    }

    @Override // com.my.target.hk, android.view.View
    public void onMeasure(int i, int i2) {
        View view;
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size < size2) {
            if (!TextUtils.isEmpty(this.s.getText())) {
                this.s.setVisibility(0);
            }
            this.d.setVisibility(0);
            this.n.setVisibility(0);
            io.b(this.d, size - this.B, size2, Integer.MIN_VALUE);
            io.b(this.n, size, this.d.getMeasuredHeight(), 1073741824);
            if (!TextUtils.isEmpty(this.q.getText())) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.r.getText())) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            if (this.Q == 0) {
                this.p.measure(View.MeasureSpec.makeMeasureSpec((size - (this.A * 2)) - (this.I * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - (this.A * 2), Integer.MIN_VALUE));
                TextView textView = this.q;
                int i3 = this.A * 2;
                io.b(textView, size - i3, size2 - i3, Integer.MIN_VALUE);
                TextView textView2 = this.r;
                int i4 = this.A * 2;
                io.b(textView2, size - i4, size2 - i4, Integer.MIN_VALUE);
                TextView textView3 = this.s;
                int i5 = this.A * 2;
                io.b(textView3, size - i5, size2 - i5, Integer.MIN_VALUE);
                this.o.setVisibility(0);
                io.b(this.o, size, size2, 1073741824);
            } else {
                this.o.setVisibility(8);
            }
            int i6 = this.Q;
            if (i6 == 1) {
                view = this.L;
                measuredHeight = (size2 - this.n.getMeasuredHeight()) - (this.A * 2);
            } else if (i6 == 0) {
                view = this.L;
                measuredHeight = (((((size2 - this.d.getMeasuredHeight()) - this.q.getMeasuredHeight()) - this.s.getMeasuredHeight()) - this.p.getMeasuredHeight()) - this.r.getMeasuredHeight()) - (this.A * 8);
            }
            io.b(view, size, measuredHeight, Integer.MIN_VALUE);
        } else {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.n.setVisibility(8);
            this.d.setVisibility(0);
            this.o.setVisibility(0);
            io.b(this.d, size, size2, Integer.MIN_VALUE);
            io.b(this.o, this.d.getMeasuredWidth(), this.d.getMeasuredHeight(), 1073741824);
            int i7 = this.Q;
            if (i7 == 1 || i7 == 0) {
                io.b(this.L, size, (size2 - this.d.getHeight()) - (this.A * 2), 1073741824);
            }
        }
        fy fyVar = this.c;
        int i8 = this.B;
        io.b(fyVar, i8, i8, 1073741824);
        io.b(this.t, size, size2, Integer.MIN_VALUE);
        io.b(this.k, size, size2, Integer.MIN_VALUE);
        setMeasuredDimension(size, size2);
    }

    @Override // com.my.target.hk, com.my.target.hj
    public void setBanner(@NonNull ce ceVar) {
        super.setBanner(ceVar);
        this.f.y(true);
        View view = this.L;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
