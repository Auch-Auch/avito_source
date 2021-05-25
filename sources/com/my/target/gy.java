package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.my.target.common.views.StarsRatingView;
import java.util.HashMap;
public class gy extends ViewGroup implements View.OnTouchListener {
    @NonNull
    public final gc a;
    @NonNull
    public final TextView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final Button d;
    @NonNull
    public final io e;
    @NonNull
    public final StarsRatingView f;
    @NonNull
    public final TextView g;
    @NonNull
    public final HashMap<View, Boolean> h = new HashMap<>();
    public final boolean i;
    @Nullable
    public View.OnClickListener j;
    public int k;
    public int l;
    public int m;

    public gy(boolean z, @NonNull Context context) {
        super(context);
        this.i = z;
        io af = io.af(context);
        this.e = af;
        gc gcVar = new gc(context);
        this.a = gcVar;
        TextView textView = new TextView(context);
        this.b = textView;
        TextView textView2 = new TextView(context);
        this.c = textView2;
        Button button = new Button(context);
        this.d = button;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.f = starsRatingView;
        TextView textView3 = new TextView(context);
        this.g = textView3;
        io.a(this, 0, 0, -3355444, af.L(1), 0);
        this.l = af.L(2);
        this.m = af.L(12);
        button.setPadding(af.L(15), af.L(10), af.L(15), af.L(10));
        button.setMinimumWidth(af.L(100));
        button.setTransformationMethod(null);
        button.setSingleLine();
        if (z) {
            button.setTextSize(20.0f);
        } else {
            button.setTextSize(18.0f);
        }
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setElevation((float) af.L(2));
        this.k = af.L(12);
        io.a(button, -16733198, -16746839, af.L(2));
        button.setTextColor(-1);
        if (z) {
            textView.setTextSize(20.0f);
        } else {
            textView.setTextSize(18.0f);
        }
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTypeface(null, 1);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(-7829368);
        textView2.setLines(2);
        if (z) {
            textView2.setTextSize(20.0f);
        } else {
            textView2.setTextSize(18.0f);
        }
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        starsRatingView.setStarSize(af.L(z ? 24 : 18));
        starsRatingView.setStarsPadding((float) af.L(4));
        io.a(this, "card_view");
        io.a(textView, "card_title_text");
        io.a(textView2, "card_description_text");
        io.a(textView3, "card_domain_text");
        io.a(button, "card_cta_button");
        io.a(starsRatingView, "card_stars_view");
        io.a(gcVar, "card_image");
        addView(gcVar);
        addView(textView2);
        addView(textView);
        addView(button);
        addView(starsRatingView);
        addView(textView3);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@Nullable View.OnClickListener onClickListener, @Nullable bq bqVar) {
        this.j = onClickListener;
        if (onClickListener == null || bqVar == null) {
            super.setOnClickListener(null);
            this.d.setOnClickListener(null);
            return;
        }
        setOnTouchListener(this);
        this.a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        this.c.setOnTouchListener(this);
        this.f.setOnTouchListener(this);
        this.g.setOnTouchListener(this);
        this.d.setOnTouchListener(this);
        boolean z = false;
        this.h.put(this.a, Boolean.valueOf(bqVar.dN || bqVar.dW));
        this.h.put(this, Boolean.valueOf(bqVar.dV || bqVar.dW));
        this.h.put(this.b, Boolean.valueOf(bqVar.dK || bqVar.dW));
        this.h.put(this.c, Boolean.valueOf(bqVar.dL || bqVar.dW));
        this.h.put(this.f, Boolean.valueOf(bqVar.dO || bqVar.dW));
        this.h.put(this.g, Boolean.valueOf(bqVar.dT || bqVar.dW));
        HashMap<View, Boolean> hashMap = this.h;
        Button button = this.d;
        if (bqVar.dQ || bqVar.dW) {
            z = true;
        }
        hashMap.put(button, Boolean.valueOf(z));
    }

    @NonNull
    public Button getCtaButtonView() {
        return this.d;
    }

    @NonNull
    public TextView getDescriptionTextView() {
        return this.c;
    }

    @NonNull
    public TextView getDomainTextView() {
        return this.g;
    }

    @NonNull
    public StarsRatingView getRatingView() {
        return this.f;
    }

    @NonNull
    public gc getSmartImageView() {
        return this.a;
    }

    @NonNull
    public TextView getTitleTextView() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = (i4 - i2) - (this.l * 2);
        boolean z2 = !this.i && getResources().getConfiguration().orientation == 2;
        gc gcVar = this.a;
        gcVar.layout(0, 0, gcVar.getMeasuredWidth(), this.a.getMeasuredHeight());
        if (z2) {
            this.b.setTypeface(null, 1);
            this.b.layout(0, this.a.getBottom(), i6, this.b.getMeasuredHeight() + this.a.getBottom());
            io.a(this, 0, 0);
            this.c.layout(0, 0, 0, 0);
            this.d.layout(0, 0, 0, 0);
            this.f.layout(0, 0, 0, 0);
            this.g.layout(0, 0, 0, 0);
            return;
        }
        this.b.setTypeface(null, 0);
        io.a(this, 0, 0, -3355444, this.e.L(1), 0);
        this.b.layout(this.l + this.m, this.a.getBottom(), this.b.getMeasuredWidth() + this.l + this.m, this.b.getMeasuredHeight() + this.a.getBottom());
        this.c.layout(this.l + this.m, this.b.getBottom(), this.c.getMeasuredWidth() + this.l + this.m, this.c.getMeasuredHeight() + this.b.getBottom());
        int measuredWidth = (i6 - this.d.getMeasuredWidth()) / 2;
        Button button = this.d;
        button.layout(measuredWidth, (i5 - button.getMeasuredHeight()) - this.m, this.d.getMeasuredWidth() + measuredWidth, i5 - this.m);
        int measuredWidth2 = (i6 - this.f.getMeasuredWidth()) / 2;
        this.f.layout(measuredWidth2, (this.d.getTop() - this.m) - this.f.getMeasuredHeight(), this.f.getMeasuredWidth() + measuredWidth2, this.d.getTop() - this.m);
        int measuredWidth3 = (i6 - this.g.getMeasuredWidth()) / 2;
        this.g.layout(measuredWidth3, (this.d.getTop() - this.g.getMeasuredHeight()) - this.m, this.g.getMeasuredWidth() + measuredWidth3, this.d.getTop() - this.m);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = !this.i && getResources().getConfiguration().orientation == 2;
        int i6 = size == 0 ? 0 : Integer.MIN_VALUE;
        int i7 = this.l * 2;
        int i8 = size2 - i7;
        int i9 = size - i7;
        if (z) {
            this.b.measure(View.MeasureSpec.makeMeasureSpec(size, i6), View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE));
            this.c.measure(0, 0);
            this.f.measure(0, 0);
            this.g.measure(0, 0);
            this.d.measure(0, 0);
        } else {
            this.b.measure(View.MeasureSpec.makeMeasureSpec(i9 - (this.m * 2), i6), View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE));
            this.c.measure(View.MeasureSpec.makeMeasureSpec(i9 - (this.m * 2), i6), View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE));
            this.f.measure(View.MeasureSpec.makeMeasureSpec(i9, i6), View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE));
            this.g.measure(View.MeasureSpec.makeMeasureSpec(i9, i6), View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE));
            this.d.measure(View.MeasureSpec.makeMeasureSpec(i9 - (this.m * 2), i6), View.MeasureSpec.makeMeasureSpec(i8 - (this.m * 2), Integer.MIN_VALUE));
        }
        if (z) {
            i5 = size2 - this.b.getMeasuredHeight();
            i4 = this.l;
        } else {
            i5 = (((size2 - this.d.getMeasuredHeight()) - (this.k * 2)) - Math.max(this.f.getMeasuredHeight(), this.g.getMeasuredHeight())) - this.c.getMeasuredHeight();
            i4 = this.b.getMeasuredHeight();
        }
        int i10 = i5 - i4;
        if (i10 <= size) {
            size = i10;
        }
        this.a.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        setMeasuredDimension(size, size2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r10 == r11) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        com.my.target.io.a(r9, 0, 0, -3355444, r9.e.L(1), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r10 == r11) goto L_0x002c;
     */
    @Override // android.view.View.OnTouchListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            java.util.HashMap<android.view.View, java.lang.Boolean> r0 = r9.h
            boolean r0 = r0.containsKey(r10)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.HashMap<android.view.View, java.lang.Boolean> r0 = r9.h
            java.lang.Object r0 = r0.get(r10)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r10.setClickable(r0)
            int r11 = r11.getAction()
            r2 = 1
            if (r11 == 0) goto L_0x004f
            if (r11 == r2) goto L_0x0041
            r3 = 3
            if (r11 == r3) goto L_0x0026
            goto L_0x005f
        L_0x0026:
            if (r0 == 0) goto L_0x005f
            android.widget.Button r11 = r9.d
            if (r10 != r11) goto L_0x0030
        L_0x002c:
            r11.setPressed(r1)
            goto L_0x005f
        L_0x0030:
            r4 = 0
            r5 = 0
            r6 = -3355444(0xffffffffffcccccc, float:NaN)
            com.my.target.io r10 = r9.e
            int r7 = r10.L(r2)
            r8 = 0
            r3 = r9
            com.my.target.io.a(r3, r4, r5, r6, r7, r8)
            goto L_0x005f
        L_0x0041:
            android.view.View$OnClickListener r11 = r9.j
            if (r11 == 0) goto L_0x0048
            r11.onClick(r10)
        L_0x0048:
            if (r0 == 0) goto L_0x005f
            android.widget.Button r11 = r9.d
            if (r10 != r11) goto L_0x0030
            goto L_0x002c
        L_0x004f:
            if (r0 == 0) goto L_0x005f
            android.widget.Button r11 = r9.d
            if (r10 != r11) goto L_0x0059
            r11.setPressed(r2)
            goto L_0x005f
        L_0x0059:
            r10 = -3806472(0xffffffffffc5eaf8, float:NaN)
            r9.setBackgroundColor(r10)
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.gy.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
