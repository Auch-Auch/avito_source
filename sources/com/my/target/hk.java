package com.my.target;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.hj;
import com.my.target.nativeads.views.MediaAdView;
@SuppressLint({"ViewConstructor"})
public abstract class hk extends ViewGroup implements View.OnClickListener, hj {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    @Nullable
    public View L;
    public int M;
    public int N;
    public int O;
    public int P;
    @NonNull
    public final fy a;
    @NonNull
    public final ho b;
    @NonNull
    public final fy c;
    @NonNull
    public final View d;
    @NonNull
    public final View e;
    @NonNull
    public final hj.a f;
    @NonNull
    public final gq g;
    @NonNull
    public final Button h;
    @NonNull
    public final gc i;
    @NonNull
    public final gc j;
    @NonNull
    public final fo k;
    @NonNull
    public final ProgressBar l;
    @NonNull
    public final View m;
    @NonNull
    public final View n;
    @NonNull
    public final View o;
    @NonNull
    public final Button p;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView r;
    @NonNull
    public final TextView s;
    @NonNull
    public final ft t;
    @NonNull
    public final gf u;
    @Nullable
    public final Bitmap v;
    @Nullable
    public final Bitmap w;
    @Nullable
    public final Bitmap x;
    @Nullable
    public final Bitmap y;
    @Nullable
    public final Bitmap z;

    public hk(@NonNull View view, @NonNull View view2, @NonNull hj.a aVar, @Nullable View view3, @NonNull ho hoVar, @NonNull Context context) {
        super(context);
        this.f = aVar;
        this.L = view3;
        this.e = view2;
        this.d = view;
        this.b = hoVar;
        fy fyVar = new fy(context);
        this.c = fyVar;
        fyVar.setVisibility(8);
        fyVar.setOnClickListener(this);
        gq gqVar = new gq(context);
        this.g = gqVar;
        gqVar.setVisibility(8);
        gqVar.setOnClickListener(this);
        io.a(gqVar, -2013265920, -1, -1, hoVar.G(ho.nD), hoVar.G(ho.nE));
        Button button = new Button(context);
        this.h = button;
        button.setTextColor(-1);
        button.setLines(hoVar.G(ho.nF));
        button.setTextSize((float) hoVar.G(ho.nG));
        button.setMaxWidth(hoVar.G(ho.nC));
        button.setOnClickListener(this);
        button.setBackgroundColor(0);
        this.A = hoVar.G(ho.nH);
        this.F = hoVar.G(ho.nI);
        this.G = hoVar.G(ho.nJ);
        this.B = hoVar.G(ho.nK);
        this.D = hoVar.G(ho.nL);
        this.E = hoVar.G(ho.nM);
        this.C = hoVar.G(ho.nN);
        this.H = hoVar.G(ho.nO);
        this.O = hoVar.G(ho.nP);
        this.I = hoVar.G(ho.nQ);
        int G2 = hoVar.G(ho.oK);
        this.K = G2;
        this.J = (G2 * 2) + hoVar.G(ho.nR);
        fo foVar = new fo(context);
        this.k = foVar;
        foVar.setFixedHeight(hoVar.G(ho.nS));
        this.x = fi.T(context);
        this.y = fi.S(context);
        this.z = fi.U(context);
        int i2 = ho.nT;
        this.v = fi.A(hoVar.G(i2));
        this.w = fi.B(hoVar.G(i2));
        gc gcVar = new gc(context);
        this.i = gcVar;
        ProgressBar progressBar = new ProgressBar(context, null, 16842874);
        this.l = progressBar;
        progressBar.setVisibility(8);
        View view4 = new View(context);
        this.m = view4;
        view4.setBackgroundColor(-1728053248);
        view4.setVisibility(8);
        View view5 = new View(context);
        this.o = view5;
        View view6 = new View(context);
        this.n = view6;
        TextView textView = new TextView(context);
        this.q = textView;
        textView.setTextSize((float) hoVar.G(ho.nU));
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        textView.setMaxLines(hoVar.G(ho.nV));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        TextView textView2 = new TextView(context);
        this.r = textView2;
        textView2.setTextSize((float) hoVar.G(ho.nW));
        textView2.setTextColor(-1);
        textView2.setMaxLines(hoVar.G(ho.nX));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        TextView textView3 = new TextView(context);
        this.s = textView3;
        textView3.setTextSize((float) hoVar.G(ho.nY));
        textView3.setMaxLines(hoVar.G(ho.nZ));
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setGravity(17);
        Button button2 = new Button(context);
        this.p = button2;
        button2.setLines(hoVar.G(ho.ob));
        button2.setTextSize((float) hoVar.G(ho.oa));
        button2.setEllipsize(TextUtils.TruncateAt.END);
        int G3 = hoVar.G(ho.oc);
        int i3 = G3 * 2;
        button2.setPadding(i3, G3, i3, G3);
        ft ftVar = new ft(context);
        this.t = ftVar;
        ftVar.setPadding(hoVar.G(ho.od), 0, 0, 0);
        ftVar.setTextColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
        ftVar.setMaxLines(hoVar.G(ho.og));
        ftVar.setTextSize((float) hoVar.G(ho.oh));
        ftVar.a(hoVar.G(ho.oe), 1711276032, hoVar.G(ho.of));
        ftVar.setBackgroundColor(1711276032);
        gf gfVar = new gf(context);
        this.u = gfVar;
        int G4 = hoVar.G(ho.oi);
        gfVar.setPadding(G4, G4, G4, G4);
        fy fyVar2 = new fy(context);
        this.a = fyVar2;
        fyVar2.setPadding(0);
        gc gcVar2 = new gc(context);
        this.j = gcVar2;
        int i4 = this.K;
        gcVar2.setPadding(i4, i4, i4, i4);
        io.b(this, "ad_view");
        io.b(textView, "title");
        io.b(textView2, "description");
        io.b(textView3, "disclaimer");
        io.b(gcVar, "image");
        io.b(button2, "cta");
        io.b(this.c, "dismiss");
        io.b(this.g, "play");
        io.b(gcVar2, "ads_logo");
        io.b(view4, "media_dim");
        io.b(view6, "top_dim");
        io.b(view5, "bot_dim");
        io.b(ftVar, "age_bordering");
        io.b(this.k, "ad_choices");
        io.a(fyVar2, "sound_button");
        if (view3 != null) {
            addView(view3);
        }
        addView(gcVar);
        addView(view4);
        addView(view5);
        addView(view6);
        addView(this.d);
        addView(this.c);
        addView(textView);
        addView(textView2);
        addView(button2);
        addView(textView3);
        addView(ftVar);
        addView(gcVar2);
        addView(this.k);
    }

    private void setClickArea(@NonNull bq bqVar) {
        if (bqVar.dW) {
            setOnClickListener(this);
            this.p.setOnClickListener(this);
            return;
        }
        if (bqVar.dQ) {
            this.p.setOnClickListener(this);
        } else {
            this.p.setEnabled(false);
        }
        if (bqVar.dV) {
            setOnClickListener(this);
        } else {
            setOnClickListener(null);
        }
        if (bqVar.dK) {
            this.q.setOnClickListener(this);
        } else {
            this.q.setOnClickListener(null);
        }
        if (bqVar.dR || bqVar.dS) {
            this.t.setOnClickListener(this);
        } else {
            this.t.setOnClickListener(null);
        }
        if (bqVar.dL) {
            this.r.setOnClickListener(this);
        } else {
            this.r.setOnClickListener(null);
        }
        if (bqVar.dN) {
            this.i.setOnClickListener(this);
        } else {
            this.i.setOnClickListener(null);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000e: APUT  (r0v1 int[]), (0 ??[int, short, byte, char]), (r1v1 int) */
    public boolean F(int i2) {
        int[] iArr = new int[2];
        View view = this.L;
        iArr[0] = view != null ? view.getMeasuredWidth() : 0;
        iArr[1] = this.i.getMeasuredWidth();
        return ((double) io.c(iArr)) * 1.6d <= ((double) i2);
    }

    @Override // com.my.target.hj
    public void M(boolean z2) {
        this.i.setVisibility(z2 ? 0 : 4);
    }

    @Override // com.my.target.hj
    public void N(boolean z2) {
        this.l.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.my.target.hj
    public void O(boolean z2) {
        this.m.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.my.target.hj
    public void a(int i2, float f2) {
        this.u.setDigit(i2);
        this.u.setProgress(f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    @Override // com.my.target.hj
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r4, @androidx.annotation.Nullable java.lang.String r5) {
        /*
            r3 = this;
            com.my.target.gq r0 = r3.g
            r1 = 0
            r0.setVisibility(r1)
            r0 = 1
            if (r4 != r0) goto L_0x0013
            com.my.target.gq r4 = r3.g
            android.graphics.Bitmap r2 = r3.z
        L_0x000d:
            r4.setImageBitmap(r2)
            r3.P = r0
            goto L_0x0024
        L_0x0013:
            r0 = 2
            if (r4 != r0) goto L_0x001b
            com.my.target.gq r4 = r3.g
            android.graphics.Bitmap r2 = r3.y
            goto L_0x000d
        L_0x001b:
            com.my.target.gq r4 = r3.g
            android.graphics.Bitmap r0 = r3.x
            r4.setImageBitmap(r0)
            r3.P = r1
        L_0x0024:
            android.widget.Button r4 = r3.h
            if (r5 == 0) goto L_0x0031
            r4.setVisibility(r1)
            android.widget.Button r4 = r3.h
            r4.setText(r5)
            goto L_0x0036
        L_0x0031:
            r5 = 8
            r4.setVisibility(r5)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hk.a(int, java.lang.String):void");
    }

    @Override // com.my.target.hj
    public void dG() {
        this.c.setVisibility(0);
        this.u.setVisibility(8);
    }

    @Override // com.my.target.hj
    @NonNull
    public View eu() {
        return this;
    }

    @Override // com.my.target.hj
    public void ev() {
        this.g.setVisibility(8);
        this.h.setVisibility(8);
    }

    @Override // com.my.target.hj
    public void ew() {
        this.u.setVisibility(8);
    }

    @Override // com.my.target.hj
    public void ex() {
        this.a.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c) {
            this.f.dA();
        } else if (view == this.a) {
            this.f.df();
        } else if (view == this.g || view == this.h) {
            this.f.y(this.P);
        } else if (view == this.L) {
            this.f.dD();
        } else if (view == this.m) {
            this.f.dE();
        } else if (view == this.j) {
            this.f.dB();
        } else if (view == this.k) {
            this.f.dC();
        } else {
            this.f.c(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public abstract void onLayout(boolean z2, int i2, int i3, int i4, int i5);

    @Override // android.view.View
    public abstract void onMeasure(int i2, int i3);

    @Override // com.my.target.hj
    public void setBackgroundImage(@Nullable ImageData imageData) {
        this.i.setImageData(imageData);
    }

    @Override // com.my.target.hj
    public void setBanner(@NonNull ce ceVar) {
        bu promoStyleSettings = ceVar.getPromoStyleSettings();
        setBackgroundColor(promoStyleSettings.getBackgroundColor());
        int textColor = promoStyleSettings.getTextColor();
        this.q.setTextColor(promoStyleSettings.getTitleColor());
        this.r.setTextColor(textColor);
        this.s.setTextColor(textColor);
        if (!TextUtils.isEmpty(ceVar.getAgeRestrictions()) || !TextUtils.isEmpty(ceVar.getAdvertisingLabel())) {
            String advertisingLabel = ceVar.getAdvertisingLabel();
            if (!TextUtils.isEmpty(ceVar.getAgeRestrictions()) && !TextUtils.isEmpty(ceVar.getAdvertisingLabel())) {
                advertisingLabel = a.c3(advertisingLabel, " ");
            }
            StringBuilder L2 = a.L(advertisingLabel);
            L2.append(ceVar.getAgeRestrictions());
            String sb = L2.toString();
            this.t.setVisibility(0);
            this.t.setText(sb);
        } else {
            this.t.setVisibility(8);
        }
        ImageData closeIcon = ceVar.getCloseIcon();
        if (closeIcon == null || closeIcon.getData() == null) {
            Bitmap z2 = fh.z(this.b.G(ho.nT));
            if (z2 != null) {
                this.c.a(z2, false);
            }
        } else {
            this.c.a(closeIcon.getData(), true);
        }
        io.a(this.p, promoStyleSettings.bu(), promoStyleSettings.bv(), this.O);
        this.p.setTextColor(promoStyleSettings.getTextColor());
        this.p.setText(ceVar.getCtaText());
        this.q.setText(ceVar.getTitle());
        this.r.setText(ceVar.getDescription());
        String disclaimer = ceVar.getDisclaimer();
        if (!TextUtils.isEmpty(disclaimer)) {
            this.s.setText(disclaimer);
        } else {
            this.s.setVisibility(8);
        }
        ImageData adIcon = ceVar.getAdIcon();
        if (!(adIcon == null || adIcon.getBitmap() == null)) {
            this.j.setImageData(adIcon);
            this.j.setOnClickListener(this);
        }
        bo adChoices = ceVar.getAdChoices();
        if (adChoices != null) {
            this.k.setImageBitmap(adChoices.getIcon().getBitmap());
            this.k.setOnClickListener(this);
        } else {
            this.k.setVisibility(8);
        }
        setClickArea(ceVar.getClickArea());
    }

    @Override // com.my.target.hj
    public void setPanelColor(int i2) {
        this.o.setBackgroundColor(i2);
        this.n.setBackgroundColor(i2);
    }

    @Override // com.my.target.hj
    public void setSoundState(boolean z2) {
        fy fyVar;
        String str;
        if (z2) {
            this.a.a(this.v, false);
            fyVar = this.a;
            str = "sound_on";
        } else {
            this.a.a(this.w, false);
            fyVar = this.a;
            str = "sound_off";
        }
        fyVar.setContentDescription(str);
    }
}
