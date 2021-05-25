package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.my.target.eg;
import com.my.target.gs;
@SuppressLint({"ViewConstructor"})
public class gu extends RelativeLayout implements gr {
    public static final int s = io.fh();
    @NonNull
    public final d a;
    @NonNull
    public final gc b;
    @NonNull
    public final gx c;
    @NonNull
    public final gv d;
    @NonNull
    public final gt e;
    @NonNull
    public final fx f;
    @NonNull
    public final gf g;
    @NonNull
    public final io h;
    @NonNull
    public final fx i;
    @Nullable
    public final Bitmap j;
    @Nullable
    public final Bitmap k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public float p;
    @Nullable
    public gs.a q;
    @Nullable
    public eg.a r;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gu guVar = gu.this;
            guVar.e.a(guVar.i);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eg.a aVar = gu.this.r;
            if (aVar != null) {
                aVar.df();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gs.a aVar = gu.this.q;
            if (aVar != null) {
                aVar.dy();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gs.a aVar;
            if (view.isEnabled() && (aVar = gu.this.q) != null) {
                aVar.dy();
            }
        }
    }

    public gu(@NonNull Context context, boolean z) {
        super(context);
        boolean z2 = (getContext().getResources().getConfiguration().screenLayout & 15) >= 3;
        io af = io.af(context);
        this.h = af;
        gc gcVar = new gc(context);
        this.b = gcVar;
        gx gxVar = new gx(context, af, z2);
        this.c = gxVar;
        gv gvVar = new gv(context, af, z2, z);
        this.d = gvVar;
        int i2 = s;
        gvVar.setId(i2);
        fx fxVar = new fx(context);
        this.f = fxVar;
        gf gfVar = new gf(context);
        this.g = gfVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, i2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14, -1);
        gt gtVar = new gt(context, af);
        this.e = gtVar;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12, -1);
        gtVar.setLayoutParams(layoutParams3);
        fx fxVar2 = new fx(context);
        this.i = fxVar2;
        this.j = fi.A(af.L(28));
        this.k = fi.B(af.L(28));
        this.a = new d();
        this.l = af.L(64);
        this.m = af.L(20);
        io.a(gcVar, ViewHierarchyConstants.ICON_BITMAP);
        io.a(fxVar2, "sound_button");
        io.a(gxVar, "vertical_view");
        io.a(gvVar, "media_view");
        io.a(gtVar, "panel_view");
        io.a(fxVar, "close_button");
        io.a(gfVar, "progress_wheel");
        addView(gtVar, 0);
        addView(gcVar, 0);
        addView(gxVar, 0, layoutParams);
        addView(gvVar, 0, layoutParams2);
        addView(fxVar2);
        addView(fxVar);
        addView(gfVar);
        this.n = af.L(28);
        this.o = af.L(10);
    }

    @Override // com.my.target.gr
    public void D(int i2) {
        this.d.D(i2);
    }

    @Override // com.my.target.gr
    public void G(boolean z) {
        gt gtVar = this.e;
        View[] viewArr = {this.i};
        if (gtVar.getVisibility() == 0) {
            gtVar.a(300, viewArr);
        }
        this.d.b(z);
    }

    @Override // com.my.target.gr
    public final void H(boolean z) {
        fx fxVar;
        String str;
        if (z) {
            this.i.a(this.k, false);
            fxVar = this.i;
            str = "sound_off";
        } else {
            this.i.a(this.j, false);
            fxVar = this.i;
            str = "sound_on";
        }
        fxVar.setContentDescription(str);
    }

    @Override // com.my.target.gr
    public void a(@NonNull ce ceVar) {
        this.i.setVisibility(8);
        this.f.setVisibility(0);
        stop(false);
        this.d.a(ceVar);
    }

    @Override // com.my.target.gr
    public void destroy() {
        this.d.destroy();
    }

    @Override // com.my.target.gr
    public void ej() {
        this.d.ej();
    }

    @Override // com.my.target.gs
    public void ek() {
        this.f.setVisibility(0);
    }

    @Override // com.my.target.gr
    public void finish() {
    }

    @Override // com.my.target.gs
    @NonNull
    public View getCloseButton() {
        return this.f;
    }

    @Override // com.my.target.gr
    @NonNull
    public gv getPromoMediaView() {
        return this.d;
    }

    @Override // com.my.target.gs
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.my.target.gr
    public boolean isPaused() {
        return this.d.isPaused();
    }

    @Override // com.my.target.gr
    public boolean isPlaying() {
        return this.d.isPlaying();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        fx fxVar = this.f;
        fxVar.layout(i4 - fxVar.getMeasuredWidth(), 0, i4, this.f.getMeasuredHeight());
        gf gfVar = this.g;
        int i6 = this.o;
        gfVar.layout(i6, i6, gfVar.getMeasuredWidth() + this.o, this.g.getMeasuredHeight() + this.o);
        if (i5 > i4) {
            if (this.i.getTranslationY() > 0.0f) {
                this.i.setTranslationY(0.0f);
            }
            setBackgroundColor(-1);
            int measuredWidth = (i4 - this.d.getMeasuredWidth()) / 2;
            gv gvVar = this.d;
            gvVar.layout(measuredWidth, 0, gvVar.getMeasuredWidth() + measuredWidth, this.d.getMeasuredHeight());
            this.c.layout(0, this.d.getBottom(), i4, i5);
            int i7 = this.m;
            if (this.d.getMeasuredHeight() != 0) {
                i7 = this.d.getBottom() - (this.b.getMeasuredHeight() / 2);
            }
            gc gcVar = this.b;
            int i8 = this.m;
            gcVar.layout(i8, i7, gcVar.getMeasuredWidth() + i8, this.b.getMeasuredHeight() + i7);
            this.e.layout(0, 0, 0, 0);
            fx fxVar2 = this.i;
            fxVar2.layout(i4 - fxVar2.getMeasuredWidth(), this.d.getBottom() - this.i.getMeasuredHeight(), i4, this.d.getBottom());
            return;
        }
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        int measuredWidth2 = (i4 - this.d.getMeasuredWidth()) / 2;
        int measuredHeight = (i5 - this.d.getMeasuredHeight()) / 2;
        gv gvVar2 = this.d;
        gvVar2.layout(measuredWidth2, measuredHeight, gvVar2.getMeasuredWidth() + measuredWidth2, this.d.getMeasuredHeight() + measuredHeight);
        this.b.layout(0, 0, 0, 0);
        this.c.layout(0, 0, 0, 0);
        gt gtVar = this.e;
        gtVar.layout(0, i5 - gtVar.getMeasuredHeight(), i4, i5);
        fx fxVar3 = this.i;
        fxVar3.layout(i4 - fxVar3.getMeasuredWidth(), this.e.getTop() - this.i.getMeasuredHeight(), i4, this.e.getTop());
        if (this.d.isPlaying()) {
            this.e.a(this.i);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.i.measure(i2, i3);
        this.f.measure(i2, i3);
        this.g.measure(View.MeasureSpec.makeMeasureSpec(this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.n, 1073741824));
        gt gtVar = this.e;
        if (size2 > size) {
            gtVar.setVisibility(8);
            this.d.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            this.c.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - this.d.getMeasuredHeight(), Integer.MIN_VALUE));
            this.b.measure(View.MeasureSpec.makeMeasureSpec(this.l, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        } else {
            gtVar.setVisibility(0);
            this.d.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            this.e.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
        setMeasuredDimension(i2, i3);
    }

    @Override // com.my.target.gr
    public void pause() {
        this.e.b(this.i);
        this.d.pause();
    }

    @Override // com.my.target.gr
    public void resume() {
        gt gtVar = this.e;
        View[] viewArr = {this.i};
        if (gtVar.getVisibility() == 0) {
            gtVar.a(300, viewArr);
        }
        this.d.resume();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016e  */
    @Override // com.my.target.gs
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setBanner(@androidx.annotation.NonNull com.my.target.ce r11) {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.gu.setBanner(com.my.target.ce):void");
    }

    @Override // com.my.target.gs
    public void setClickArea(@NonNull bq bqVar) {
        StringBuilder L = a2.b.a.a.a.L("Apply click area ");
        L.append(bqVar.bp());
        L.append(" to view");
        ae.a(L.toString());
        if (bqVar.dM || bqVar.dW) {
            this.b.setOnClickListener(this.a);
        } else {
            this.b.setOnClickListener(null);
        }
        this.c.a(bqVar, this.a);
        this.e.a(bqVar, this.a);
        if (bqVar.dN || bqVar.dW) {
            this.d.getClickableLayout().setOnClickListener(new c());
            return;
        }
        this.d.getClickableLayout().setOnClickListener(null);
        this.d.getClickableLayout().setEnabled(false);
    }

    @Override // com.my.target.gs
    public void setInterstitialPromoViewListener(@Nullable gs.a aVar) {
        this.q = aVar;
    }

    @Override // com.my.target.gr
    public void setMediaListener(eg.a aVar) {
        this.r = aVar;
        this.d.setInterstitialPromoViewListener(aVar);
        this.d.el();
    }

    @Override // com.my.target.gr
    public void setTimeChanged(float f2) {
        this.g.setVisibility(0);
        float f3 = this.p;
        if (f3 > 0.0f) {
            this.g.setProgress(f2 / f3);
        }
        this.g.setDigit((int) ((this.p - f2) + 1.0f));
    }

    @Override // com.my.target.gr
    public void stop(boolean z) {
        this.g.setVisibility(8);
        this.e.b(this.i);
        this.d.a(z);
    }
}
