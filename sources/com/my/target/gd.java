package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
public class gd extends ViewGroup {
    @NonNull
    public final TextView a;
    @NonNull
    public final ft b;
    public final int c;
    public final int d;

    public gd(@NonNull Context context) {
        super(context);
        io af = io.af(context);
        TextView textView = new TextView(context);
        this.a = textView;
        ft ftVar = new ft(context);
        this.b = ftVar;
        ftVar.setLines(1);
        textView.setTextSize(2, 18.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(-1);
        this.c = af.L(4);
        this.d = af.L(2);
        io.a(textView, "title_text");
        io.a(ftVar, "age_bordering");
        addView(textView);
        addView(ftVar);
    }

    @NonNull
    public TextView getLeftText() {
        return this.a;
    }

    @NonNull
    public ft getRightBorderedView() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.a.getMeasuredWidth();
        int measuredHeight = this.a.getMeasuredHeight();
        int measuredWidth2 = this.b.getMeasuredWidth();
        int measuredHeight2 = this.b.getMeasuredHeight();
        int measuredHeight3 = getMeasuredHeight();
        int i5 = (measuredHeight3 - measuredHeight) / 2;
        int i6 = (measuredHeight3 - measuredHeight2) / 2;
        int i7 = this.c + measuredWidth;
        this.a.layout(0, i5, measuredWidth, measuredHeight + i5);
        this.b.layout(i7, i6, measuredWidth2 + i7, measuredHeight2 + i6);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.b.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2 - (this.d * 2), Integer.MIN_VALUE));
        int i3 = size / 2;
        if (this.b.getMeasuredWidth() > i3) {
            this.b.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2 - (this.d * 2), Integer.MIN_VALUE));
        }
        this.a.measure(View.MeasureSpec.makeMeasureSpec((size - this.b.getMeasuredWidth()) - this.c, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2 - (this.d * 2), Integer.MIN_VALUE));
        setMeasuredDimension(this.b.getMeasuredWidth() + this.a.getMeasuredWidth() + this.c, Math.max(this.a.getMeasuredHeight(), this.b.getMeasuredHeight()));
    }
}
