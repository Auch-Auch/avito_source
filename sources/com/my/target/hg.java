package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.my.target.common.models.ImageData;
import com.my.target.hf;
@SuppressLint({"ViewConstructor"})
public class hg extends ViewGroup implements View.OnClickListener, hf {
    @NonNull
    public final gc a;
    @NonNull
    public final gc b;
    @NonNull
    public final gb c;
    @NonNull
    public final TextView d;
    @NonNull
    public final TextView e;
    @NonNull
    public final TextView f;
    @NonNull
    public final TextView g;
    @NonNull
    public final TextView h;
    @NonNull
    public final Button i;
    @NonNull
    public final hf.a j;
    @NonNull
    public final gc k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    @NonNull
    public final ho u;
    public final int v;
    @NonNull
    public b w = b.PORTRAIT;
    public boolean x;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            b.values();
            int[] iArr = new int[3];
            a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        PORTRAIT,
        LANDSCAPE,
        SQUARE
    }

    public hg(@NonNull ho hoVar, @NonNull Context context, @NonNull hf.a aVar) {
        super(context);
        this.j = aVar;
        this.u = hoVar;
        this.l = hoVar.G(ho.ol);
        this.q = hoVar.G(ho.om);
        this.m = hoVar.G(ho.on);
        this.n = hoVar.G(ho.oo);
        this.o = hoVar.G(ho.op);
        this.p = hoVar.G(ho.nP);
        this.t = hoVar.G(ho.nM);
        gc gcVar = new gc(context);
        this.k = gcVar;
        int G = hoVar.G(ho.oK);
        this.v = G;
        this.r = (G * 2) + hoVar.G(ho.nR);
        this.s = (G * 2) + hoVar.G(ho.oq);
        gcVar.setPadding(G, G, G, G);
        gc gcVar2 = new gc(context);
        this.a = gcVar2;
        gc gcVar3 = new gc(context);
        this.b = gcVar3;
        gb gbVar = new gb(context);
        this.c = gbVar;
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setMaxLines(hoVar.G(ho.or));
        textView.setTextSize((float) hoVar.G(ho.os));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(textView.getTypeface(), 1);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        textView2.setTextSize((float) hoVar.G(ho.ou));
        textView2.setMaxLines(hoVar.G(ho.ov));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView3 = new TextView(context);
        this.f = textView3;
        textView3.setTextSize((float) hoVar.G(ho.ow));
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView4 = new TextView(context);
        this.g = textView4;
        textView4.setTextSize((float) hoVar.G(ho.ox));
        textView4.setMaxWidth(hoVar.G(ho.oy));
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        textView4.setLines(1);
        TextView textView5 = new TextView(context);
        this.h = textView5;
        textView5.setTextSize((float) hoVar.G(ho.oz));
        Button button = new Button(context);
        this.i = button;
        button.setLines(1);
        button.setTextSize((float) hoVar.G(ho.oA));
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setMinimumWidth(hoVar.G(ho.oJ));
        int G2 = hoVar.G(ho.oc);
        int i2 = G2 * 4;
        button.setPadding(i2, G2, i2, G2);
        io.b(gcVar2, "panel_icon");
        io.b(gcVar3, "panel_image");
        io.b(textView, "panel_title");
        io.b(textView2, "panel_description");
        io.b(textView3, "panel_disclaimer");
        io.b(textView4, "panel_domain");
        io.b(textView5, "panel_rating");
        io.b(button, "panel_cta");
        io.b(gcVar, "panel_ads_logo");
        addView(gcVar2);
        addView(gcVar3);
        addView(gbVar);
        addView(textView);
        addView(textView2);
        addView(textView4);
        addView(textView5);
        addView(button);
        addView(textView3);
        addView(gcVar);
    }

    private void setClickArea(@NonNull bq bqVar) {
        if (bqVar.dW) {
            setOnClickListener(this);
            this.i.setOnClickListener(this);
            return;
        }
        if (bqVar.dQ) {
            this.i.setOnClickListener(this);
        } else {
            this.i.setEnabled(false);
        }
        if (bqVar.dV) {
            setOnClickListener(this);
        } else {
            setOnClickListener(null);
        }
        if (bqVar.dK) {
            this.d.setOnClickListener(this);
        } else {
            this.d.setOnClickListener(null);
        }
        if (bqVar.dM) {
            this.a.setOnClickListener(this);
        } else {
            this.a.setOnClickListener(null);
        }
        if (bqVar.dL) {
            this.e.setOnClickListener(this);
        } else {
            this.e.setOnClickListener(null);
        }
        if (bqVar.dO) {
            this.h.setOnClickListener(this);
            this.c.setOnClickListener(this);
        } else {
            this.h.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }
        if (bqVar.dT) {
            this.g.setOnClickListener(this);
        } else {
            this.g.setOnClickListener(null);
        }
    }

    @Override // com.my.target.hf
    public View eu() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            this.j.dB();
        } else {
            this.j.c(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int measuredHeight = this.g.getMeasuredHeight();
        int measuredHeight2 = this.c.getMeasuredHeight();
        int measuredHeight3 = this.b.getMeasuredHeight();
        int i10 = a.a[this.w.ordinal()];
        if (i10 == 1) {
            int measuredHeight4 = this.a.getMeasuredHeight();
            if (measuredHeight4 > 0) {
                i7 = measuredHeight4 + 0;
                i6 = 1;
            } else {
                i7 = 0;
                i6 = 0;
            }
            int measuredHeight5 = this.d.getMeasuredHeight();
            if (measuredHeight5 > 0) {
                i6++;
                i7 += measuredHeight5;
            }
            int measuredHeight6 = this.e.getMeasuredHeight();
            if (measuredHeight6 > 0) {
                i6++;
                i7 += measuredHeight6;
            }
            int measuredHeight7 = this.f.getMeasuredHeight();
            if (measuredHeight7 > 0) {
                i6++;
                i7 += measuredHeight7;
            }
            int max = Math.max(this.c.getMeasuredHeight(), this.g.getMeasuredHeight());
            if (max > 0) {
                i6++;
                i7 += max;
            }
            int measuredHeight8 = this.b.getMeasuredHeight();
            if (measuredHeight8 > 0) {
                i6++;
                i7 += measuredHeight8;
            }
            int measuredHeight9 = this.i.getMeasuredHeight();
            if (measuredHeight9 > 0) {
                i6++;
                i7 += measuredHeight9;
            }
            int i11 = i5 - i3;
            int i12 = i11 - i7;
            int e2 = io.e(this.n, this.m, i12 / i6);
            int n2 = a2.b.a.a.a.n2(i6, e2, i12, 2);
            int i13 = i4 - i2;
            io.a(this.a, 0, n2, i13, measuredHeight4 + n2);
            int c2 = io.c(n2, this.a.getBottom() + e2);
            io.a(this.d, 0, c2, i13, measuredHeight5 + c2);
            int c3 = io.c(c2, this.d.getBottom() + e2);
            io.a(this.e, 0, c3, i13, measuredHeight6 + c3);
            int c4 = io.c(c3, this.e.getBottom() + e2);
            io.a(this.f, 0, c4, i13, measuredHeight7 + c4);
            int c5 = io.c(c4, this.f.getBottom() + e2);
            int measuredWidth = ((i13 - this.h.getMeasuredWidth()) - this.c.getMeasuredWidth()) - this.g.getMeasuredWidth();
            int i14 = this.n;
            io.a(c5, a2.b.a.a.a.n2(i14, 2, measuredWidth, 2), max + c5, i14, this.h, this.c, this.g);
            int c6 = io.c(c5, this.g.getBottom(), this.c.getBottom()) + e2;
            io.a(this.b, 0, c6, i13, measuredHeight8 + c6);
            int c7 = io.c(c6, this.b.getBottom() + e2);
            io.a(this.i, 0, c7, i13, measuredHeight9 + c7);
            if (this.x) {
                i11 -= this.t;
            }
            gc gcVar = this.k;
            int i15 = this.v;
            io.e(gcVar, i11 + i15, i13 + i15);
        } else if (i10 != 3) {
            gc gcVar2 = this.a;
            int i16 = this.m;
            io.b(gcVar2, i16, i16);
            int right = this.a.getRight() + this.m;
            int c8 = io.c(this.h.getMeasuredHeight(), measuredHeight2, measuredHeight, measuredHeight3);
            int c9 = io.c(i3 + this.m, this.a.getTop());
            if (this.a.getMeasuredHeight() > 0) {
                c9 += (((this.a.getMeasuredHeight() - this.d.getMeasuredHeight()) - this.n) - c8) / 2;
            }
            TextView textView = this.d;
            textView.layout(right, c9, textView.getMeasuredWidth() + right, this.d.getMeasuredHeight() + c9);
            this.e.layout(0, 0, 0, 0);
            io.a(this.d.getBottom() + this.n, right, this.d.getBottom() + this.n + c8, this.m / 2, this.h, this.c, this.g, this.b);
        } else {
            TextView textView2 = this.f;
            int i17 = i5 - i3;
            int i18 = this.m / 2;
            io.d(textView2, i17 - i18, i18);
            if (this.f.getVisibility() == 0) {
                int top = this.f.getTop();
                i8 = this.n;
                i9 = top - (i8 / 2);
            } else {
                i9 = i17 - (this.m / 2);
                i8 = this.n;
            }
            int i19 = i9 - i8;
            gc gcVar3 = this.a;
            int i20 = this.m;
            io.a(gcVar3, i20, i20 / 2, gcVar3.getMeasuredWidth() + i20, i19);
            int i21 = i4 - i2;
            io.a(this.i, ((i21 - this.m) - this.k.getMeasuredWidth()) - this.i.getMeasuredWidth(), 0, (i21 - this.m) - this.k.getMeasuredWidth(), i17);
            int right2 = this.a.getRight() + this.m;
            int c10 = io.c(this.h.getMeasuredHeight(), measuredHeight2, measuredHeight, measuredHeight3);
            int measuredHeight10 = ((((this.a.getMeasuredHeight() - this.d.getMeasuredHeight()) - this.n) - c10) / 2) + io.c(this.a.getTop(), this.n);
            TextView textView3 = this.d;
            textView3.layout(right2, measuredHeight10, textView3.getMeasuredWidth() + right2, this.d.getMeasuredHeight() + measuredHeight10);
            io.a(this.d.getBottom() + this.n, right2, this.d.getBottom() + this.n + c10, this.m / 2, this.h, this.c, this.g, this.b);
            if (this.x) {
                i17 -= this.t;
            }
            gc gcVar4 = this.k;
            int i22 = this.v;
            io.e(gcVar4, i17 + i22, i21 + i22);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        gc gcVar;
        int i5;
        b bVar = b.LANDSCAPE;
        b bVar2 = b.SQUARE;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i6 = this.m;
        int i7 = size - (i6 * 2);
        int i8 = size2 - (i6 * 2);
        if (i7 == i8) {
            this.w = bVar2;
        } else if (i7 > i8) {
            this.w = bVar;
        } else {
            this.w = b.PORTRAIT;
        }
        if (this.w == bVar2) {
            gcVar = this.a;
            i4 = this.q;
        } else {
            gcVar = this.a;
            i4 = this.l;
        }
        io.b(gcVar, i4, i4, 1073741824);
        if (this.h.getText() == null || TextUtils.isEmpty(this.h.getText())) {
            i5 = 0;
        } else {
            io.b(this.h, (i7 - this.a.getMeasuredWidth()) - this.n, i8, Integer.MIN_VALUE);
            i5 = this.h.getMeasuredHeight();
            io.b(this.c, i5, i5, 1073741824);
        }
        if (this.g.getText() != null && this.g.getText().length() > 0) {
            io.b(this.g, (((i7 - this.a.getMeasuredWidth()) - (this.m * 2)) - (this.n * 2)) - this.c.getMeasuredWidth(), i8, Integer.MIN_VALUE);
        }
        b bVar3 = this.w;
        if (bVar3 == bVar2) {
            int i9 = this.o / 4;
            this.d.setGravity(1);
            this.e.setGravity(1);
            this.f.setGravity(1);
            this.e.setVisibility(0);
            this.i.setVisibility(0);
            this.d.setTextSize((float) this.u.G(ho.ot));
            this.k.setVisibility(0);
            io.b(this.k, this.s, this.r, Integer.MIN_VALUE);
            if (!TextUtils.isEmpty(this.f.getText())) {
                this.f.setMaxLines(2);
                this.f.setVisibility(0);
            }
            this.d.setMaxLines(this.u.G(ho.oB));
            this.e.setMaxLines(3);
            this.i.measure(View.MeasureSpec.makeMeasureSpec((i7 - (this.k.getMeasuredWidth() * 2)) - this.m, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
            io.b(this.b, this.o, i9, Integer.MIN_VALUE);
            io.b(this.d, i7, i7, Integer.MIN_VALUE);
            io.b(this.e, i7, i7, Integer.MIN_VALUE);
            io.b(this.f, i7, i7, Integer.MIN_VALUE);
            setMeasuredDimension(size, size);
        } else if (bVar3 == bVar) {
            this.d.setGravity(GravityCompat.START);
            this.e.setVisibility(8);
            this.k.setVisibility(0);
            this.i.setVisibility(0);
            this.f.setMaxLines(1);
            this.d.setMaxLines(this.u.G(ho.or));
            this.d.setTextSize((float) this.u.G(ho.ot));
            io.b(this.k, this.s, this.r, Integer.MIN_VALUE);
            if (!TextUtils.isEmpty(this.f.getText())) {
                this.f.setVisibility(0);
            }
            io.b(this.i, i7 / 3, i8 - (this.m * 2), Integer.MIN_VALUE);
            int measuredWidth = i7 - (this.k.getMeasuredWidth() + ((this.m * 2) + (this.i.getMeasuredWidth() + this.a.getMeasuredWidth())));
            io.b(this.d, measuredWidth, i8, Integer.MIN_VALUE);
            io.b(this.g, measuredWidth, i8, Integer.MIN_VALUE);
            io.b(this.b, (((measuredWidth - this.c.getMeasuredWidth()) - this.h.getMeasuredWidth()) - this.g.getMeasuredWidth()) - (this.n * 3), Math.max(this.c.getMeasuredHeight(), this.g.getMeasuredHeight()), Integer.MIN_VALUE);
            io.b(this.f, (i7 - this.i.getMeasuredWidth()) - this.k.getMeasuredWidth(), i8, Integer.MIN_VALUE);
            int measuredHeight = this.f.getMeasuredHeight() + (this.m / 2) + io.c(this.l, io.c(this.g.getMeasuredHeight(), this.c.getMeasuredHeight(), this.b.getMeasuredHeight()) + this.d.getMeasuredHeight() + this.n, this.i.getMeasuredHeight()) + this.n;
            if (this.x) {
                measuredHeight += this.t;
            }
            setMeasuredDimension(size, measuredHeight);
        } else {
            this.d.setGravity(GravityCompat.START);
            this.e.setGravity(GravityCompat.START);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            this.k.setVisibility(8);
            this.i.setVisibility(8);
            this.d.setMaxLines(this.u.G(ho.oC));
            this.d.setTextSize((float) this.u.G(ho.os));
            this.e.setMaxLines(2);
            io.b(this.e, 0, 0, 1073741824);
            io.b(this.d, (i7 - this.a.getMeasuredWidth()) - this.n, this.a.getMeasuredHeight() - (this.n * 2), Integer.MIN_VALUE);
            int measuredWidth2 = (((((i7 - (this.m * 2)) - this.a.getMeasuredWidth()) - this.h.getMeasuredWidth()) - i5) - this.g.getMeasuredWidth()) - this.n;
            gc gcVar2 = this.b;
            if (measuredWidth2 > 0) {
                io.b(gcVar2, measuredWidth2, Math.max(i5, this.g.getMeasuredHeight()), Integer.MIN_VALUE);
            } else {
                io.b(gcVar2, 0, 0, 1073741824);
            }
            setMeasuredDimension(size, io.c((this.m * 2) + this.a.getMeasuredHeight(), io.c(i5, this.b.getMeasuredHeight(), this.g.getMeasuredHeight()) + this.d.getMeasuredHeight() + this.m));
        }
    }

    @Override // com.my.target.hf
    public void setBanner(@NonNull ce ceVar) {
        bu promoStyleSettings = ceVar.getPromoStyleSettings();
        int textColor = promoStyleSettings.getTextColor();
        this.d.setTextColor(promoStyleSettings.getTitleColor());
        this.e.setTextColor(textColor);
        this.f.setTextColor(textColor);
        this.g.setTextColor(textColor);
        this.h.setTextColor(textColor);
        this.c.setColor(textColor);
        this.x = ceVar.getVideoBanner() != null;
        ImageData bt = promoStyleSettings.bt();
        if (!"store".equals(ceVar.getNavigationType()) || bt == null) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setImageData(bt);
        }
        this.a.setImageData(ceVar.getIcon());
        this.d.setText(ceVar.getTitle());
        this.e.setText(ceVar.getDescription());
        String disclaimer = ceVar.getDisclaimer();
        if (!TextUtils.isEmpty(disclaimer)) {
            this.f.setVisibility(0);
            this.f.setText(disclaimer);
        } else {
            this.f.setVisibility(8);
        }
        if (ceVar.getNavigationType().equals("store")) {
            this.g.setText(ceVar.getPaidType());
            if (ceVar.getRating() > 0.0f) {
                String valueOf = String.valueOf(ceVar.getRating());
                if (valueOf.length() > 3) {
                    valueOf = valueOf.substring(0, 3);
                }
                this.h.setText(valueOf);
            }
        } else {
            this.g.setText(ceVar.getDomain());
            this.g.setTextColor(promoStyleSettings.bA());
        }
        this.i.setText(ceVar.getCtaText());
        io.a(this.i, promoStyleSettings.bu(), promoStyleSettings.bv(), this.p);
        this.i.setTextColor(promoStyleSettings.getTextColor());
        ImageData adIcon = ceVar.getAdIcon();
        if (!(adIcon == null || adIcon.getBitmap() == null)) {
            this.k.setImageData(adIcon);
            this.k.setOnClickListener(this);
        }
        setClickArea(ceVar.getClickArea());
    }
}
