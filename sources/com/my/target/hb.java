package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.my.target.common.models.ImageData;
import com.my.target.gs;
import java.util.HashMap;
import java.util.List;
public class hb extends ViewGroup implements View.OnTouchListener, gs {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final fx d;
    @NonNull
    public final io e;
    @NonNull
    public final gc f;
    @NonNull
    public final ha g;
    @NonNull
    public final HashMap<View, Boolean> h;
    @NonNull
    public final Button i;
    public final int j;
    public final int k;
    public final int l;
    public final boolean m;
    public final double n;
    @Nullable
    public gs.a o;

    public interface a {
        void a(@NonNull cb cbVar);

        void d(@NonNull List<cb> list);
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gs.a aVar = hb.this.o;
            if (aVar != null) {
                aVar.dy();
            }
        }
    }

    public hb(@NonNull Context context) {
        super(context);
        io.a(this, -1, -3806472);
        boolean z = (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        this.m = z;
        this.n = z ? 0.5d : 0.7d;
        fx fxVar = new fx(context);
        this.d = fxVar;
        io af = io.af(context);
        this.e = af;
        TextView textView = new TextView(context);
        this.a = textView;
        TextView textView2 = new TextView(context);
        this.b = textView2;
        TextView textView3 = new TextView(context);
        this.c = textView3;
        gc gcVar = new gc(context);
        this.f = gcVar;
        Button button = new Button(context);
        this.i = button;
        ha haVar = new ha(context);
        this.g = haVar;
        fxVar.setContentDescription("close");
        fxVar.setVisibility(4);
        gcVar.setContentDescription("icon");
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        button.setPadding(af.L(15), af.L(10), af.L(15), af.L(10));
        button.setMinimumWidth(af.L(100));
        button.setMaxEms(12);
        button.setTransformationMethod(null);
        button.setSingleLine();
        button.setTextSize(18.0f);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setElevation((float) af.L(2));
        io.a(button, -16733198, -16746839, af.L(2));
        button.setTextColor(-1);
        haVar.setPadding(0, 0, 0, af.L(8));
        haVar.setSideSlidesMargins(af.L(10));
        if (z) {
            int L = af.L(18);
            this.k = L;
            this.j = L;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            textView.setTextSize((float) af.M(24));
            textView3.setTextSize((float) af.M(20));
            textView2.setTextSize((float) af.M(20));
            this.l = af.L(96);
            textView.setTypeface(null, 1);
        } else {
            this.j = af.L(12);
            this.k = af.L(10);
            textView.setTextSize(22.0f);
            textView3.setTextSize(18.0f);
            textView2.setTextSize(18.0f);
            this.l = af.L(64);
        }
        io.a(this, "ad_view");
        io.a(textView, "title_text");
        io.a(textView3, "description_text");
        io.a(gcVar, ViewHierarchyConstants.ICON_BITMAP);
        io.a(fxVar, "close_button");
        io.a(textView2, "category_text");
        addView(haVar);
        addView(gcVar);
        addView(textView);
        addView(textView2);
        addView(textView3);
        addView(fxVar);
        addView(button);
        this.h = new HashMap<>();
    }

    @Override // com.my.target.gs
    public void ek() {
        this.d.setVisibility(0);
    }

    @Override // com.my.target.gs
    @NonNull
    public View getCloseButton() {
        return this.d;
    }

    @NonNull
    public int[] getNumbersOfCurrentShowingCards() {
        int findFirstVisibleItemPosition = this.g.getCardLayoutManager().findFirstVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = this.g.getCardLayoutManager().findLastCompletelyVisibleItemPosition();
        int i2 = 0;
        if (findFirstVisibleItemPosition == -1 || findLastCompletelyVisibleItemPosition == -1) {
            return new int[0];
        }
        int i3 = (findLastCompletelyVisibleItemPosition - findFirstVisibleItemPosition) + 1;
        int[] iArr = new int[i3];
        while (i2 < i3) {
            iArr[i2] = findFirstVisibleItemPosition;
            i2++;
            findFirstVisibleItemPosition++;
        }
        return iArr;
    }

    @Override // com.my.target.gs
    @NonNull
    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i4 - i2;
        int i8 = i5 - i3;
        fx fxVar = this.d;
        fxVar.layout(i4 - fxVar.getMeasuredWidth(), i3, i4, this.d.getMeasuredHeight() + i3);
        if (i8 > i7 || this.m) {
            int bottom = this.d.getBottom();
            int measuredHeight = this.c.getMeasuredHeight() + Math.max(this.b.getMeasuredHeight() + this.a.getMeasuredHeight(), this.f.getMeasuredHeight()) + this.g.getMeasuredHeight();
            int i9 = this.k;
            int i10 = (i9 * 2) + measuredHeight;
            if (i10 < i8 && (i6 = (i8 - i10) / 2) > bottom) {
                bottom = i6;
            }
            gc gcVar = this.f;
            gcVar.layout(i9 + i2, bottom, gcVar.getMeasuredWidth() + i2 + this.k, this.f.getMeasuredHeight() + i3 + bottom);
            this.a.layout(this.f.getRight(), bottom, this.a.getMeasuredWidth() + this.f.getRight(), this.a.getMeasuredHeight() + bottom);
            this.b.layout(this.f.getRight(), this.a.getBottom(), this.b.getMeasuredWidth() + this.f.getRight(), this.b.getMeasuredHeight() + this.a.getBottom());
            int max = Math.max(Math.max(this.f.getBottom(), this.b.getBottom()), this.a.getBottom());
            TextView textView = this.c;
            int i11 = this.k;
            textView.layout(i2 + i11, max, textView.getMeasuredWidth() + i11 + i2, this.c.getMeasuredHeight() + max);
            int max2 = Math.max(max, this.c.getBottom());
            int i12 = this.k;
            int i13 = max2 + i12;
            ha haVar = this.g;
            haVar.layout(i2 + i12, i13, i4, haVar.getMeasuredHeight() + i13);
            this.g.K(!this.m);
            return;
        }
        this.g.K(false);
        gc gcVar2 = this.f;
        int i14 = this.k;
        gcVar2.layout(i14, (i5 - i14) - gcVar2.getMeasuredHeight(), this.f.getMeasuredWidth() + this.k, i5 - this.k);
        int max3 = ((Math.max(this.f.getMeasuredHeight(), this.i.getMeasuredHeight()) - this.a.getMeasuredHeight()) - this.b.getMeasuredHeight()) / 2;
        if (max3 < 0) {
            max3 = 0;
        }
        this.b.layout(this.f.getRight(), ((i5 - this.k) - max3) - this.b.getMeasuredHeight(), this.b.getMeasuredWidth() + this.f.getRight(), (i5 - this.k) - max3);
        this.a.layout(this.f.getRight(), this.b.getTop() - this.a.getMeasuredHeight(), this.a.getMeasuredWidth() + this.f.getRight(), this.b.getTop());
        int max4 = (Math.max(this.f.getMeasuredHeight(), this.b.getMeasuredHeight() + this.a.getMeasuredHeight()) - this.i.getMeasuredHeight()) / 2;
        if (max4 < 0) {
            max4 = 0;
        }
        Button button = this.i;
        int measuredWidth = (i4 - this.k) - button.getMeasuredWidth();
        int measuredHeight2 = ((i5 - this.k) - max4) - this.i.getMeasuredHeight();
        int i15 = this.k;
        button.layout(measuredWidth, measuredHeight2, i4 - i15, (i5 - i15) - max4);
        ha haVar2 = this.g;
        int i16 = this.k;
        haVar2.layout(i16, i16, i4, haVar2.getMeasuredHeight() + i16);
        this.c.layout(0, 0, 0, 0);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.d.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        this.f.measure(View.MeasureSpec.makeMeasureSpec(this.l, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.l, Integer.MIN_VALUE));
        if (size2 > size || this.m) {
            this.i.setVisibility(8);
            int measuredHeight = this.d.getMeasuredHeight();
            if (this.m) {
                measuredHeight = this.k;
            }
            this.a.measure(View.MeasureSpec.makeMeasureSpec((size - (this.k * 2)) - this.f.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            this.b.measure(View.MeasureSpec.makeMeasureSpec((size - (this.k * 2)) - this.f.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            this.c.measure(View.MeasureSpec.makeMeasureSpec(size - (this.k * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            int max = ((size2 - measuredHeight) - Math.max(this.b.getMeasuredHeight() + this.a.getMeasuredHeight(), this.f.getMeasuredHeight() - (this.k * 2))) - this.c.getMeasuredHeight();
            int i4 = size - this.k;
            if (size2 > size) {
                double d2 = this.n;
                if (((double) (((float) max) / ((float) size2))) > d2) {
                    max = (int) (((double) size2) * d2);
                }
            }
            if (this.m) {
                this.g.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(max - (this.k * 2), Integer.MIN_VALUE));
            } else {
                this.g.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(max - (this.k * 2), 1073741824));
            }
        } else {
            this.i.setVisibility(0);
            this.i.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            int measuredWidth = this.i.getMeasuredWidth();
            int i5 = size / 2;
            int i6 = this.k;
            if (measuredWidth > i5 - (i6 * 2)) {
                this.i.measure(View.MeasureSpec.makeMeasureSpec(i5 - (i6 * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            }
            this.a.measure(View.MeasureSpec.makeMeasureSpec((((size - this.f.getMeasuredWidth()) - measuredWidth) - this.j) - this.k, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            this.b.measure(View.MeasureSpec.makeMeasureSpec((((size - this.f.getMeasuredWidth()) - measuredWidth) - this.j) - this.k, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            this.g.measure(View.MeasureSpec.makeMeasureSpec(size - this.k, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((((size2 - Math.max(this.f.getMeasuredHeight(), Math.max(this.i.getMeasuredHeight(), this.b.getMeasuredHeight() + this.a.getMeasuredHeight()))) - (this.k * 2)) - this.g.getPaddingBottom()) - this.g.getPaddingTop(), Integer.MIN_VALUE));
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.h.containsKey(view)) {
            return false;
        }
        if (!this.h.get(view).booleanValue()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(-3806472);
        } else if (action == 1) {
            setBackgroundColor(-1);
            gs.a aVar = this.o;
            if (aVar != null) {
                aVar.dy();
            }
        } else if (action == 3) {
            setBackgroundColor(-1);
        }
        return true;
    }

    @Override // com.my.target.gs
    public void setBanner(@NonNull ce ceVar) {
        TextView textView;
        ImageData closeIcon = ceVar.getCloseIcon();
        int i2 = 0;
        if (closeIcon == null || closeIcon.getData() == null) {
            Bitmap z = fh.z(this.e.L(28));
            if (z != null) {
                this.d.a(z, false);
            }
        } else {
            this.d.a(closeIcon.getData(), true);
        }
        this.i.setText(ceVar.getCtaText());
        ImageData icon = ceVar.getIcon();
        if (icon != null) {
            this.f.setPlaceholderDimensions(icon.getWidth(), icon.getHeight());
            ia.a(icon, this.f);
        }
        this.a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.a.setText(ceVar.getTitle());
        String category = ceVar.getCategory();
        String subCategory = ceVar.getSubCategory();
        String str = "";
        if (!TextUtils.isEmpty(category)) {
            str = a2.b.a.a.a.c3(str, category);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(subCategory)) {
            str = a2.b.a.a.a.c3(str, ", ");
        }
        if (!TextUtils.isEmpty(subCategory)) {
            str = a2.b.a.a.a.c3(str, subCategory);
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.setText(str);
            textView = this.b;
        } else {
            textView = this.b;
            i2 = 8;
        }
        textView.setVisibility(i2);
        this.c.setText(ceVar.getDescription());
        this.g.e(ceVar.getInterstitialAdCards());
    }

    public void setCarouselListener(@Nullable a aVar) {
        this.g.setCarouselListener(aVar);
    }

    @Override // com.my.target.gs
    @SuppressLint({"ClickableViewAccessibility"})
    public void setClickArea(@NonNull bq bqVar) {
        boolean z = true;
        if (bqVar.dW) {
            setOnClickListener(new b());
            io.a(this, -1, -3806472);
            setClickable(true);
            return;
        }
        this.a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        this.f.setOnTouchListener(this);
        this.c.setOnTouchListener(this);
        this.i.setOnTouchListener(this);
        setOnTouchListener(this);
        this.h.put(this.a, Boolean.valueOf(bqVar.dK));
        this.h.put(this.b, Boolean.valueOf(bqVar.dU));
        this.h.put(this.f, Boolean.valueOf(bqVar.dM));
        this.h.put(this.c, Boolean.valueOf(bqVar.dL));
        HashMap<View, Boolean> hashMap = this.h;
        Button button = this.i;
        if (!bqVar.dV && !bqVar.dQ) {
            z = false;
        }
        hashMap.put(button, Boolean.valueOf(z));
        this.h.put(this, Boolean.valueOf(bqVar.dV));
    }

    @Override // com.my.target.gs
    public void setInterstitialPromoViewListener(@Nullable gs.a aVar) {
        this.o = aVar;
    }
}
