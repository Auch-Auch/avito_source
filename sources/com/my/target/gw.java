package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.my.target.common.models.VideoData;
import com.my.target.common.views.StarsRatingView;
import com.my.target.eg;
import com.my.target.gs;
@SuppressLint({"ViewConstructor"})
public class gw extends ViewGroup implements gr {
    public int A;
    public float B;
    public boolean C;
    public boolean D;
    public final int E;
    @Nullable
    public String F;
    @Nullable
    public String G;
    public boolean H;
    @NonNull
    public final c a;
    @NonNull
    public final TextView b;
    @NonNull
    public final StarsRatingView c;
    @NonNull
    public final Button d;
    @NonNull
    public final TextView e;
    @NonNull
    public final io f;
    @NonNull
    public final LinearLayout g;
    @NonNull
    public final TextView h;
    @NonNull
    public final FrameLayout i;
    @NonNull
    public final gv j;
    @NonNull
    public final TextView k;
    @NonNull
    public final gf l;
    @NonNull
    public final fx m;
    @NonNull
    public final gq n;
    @NonNull
    public final gq o;
    @NonNull
    public final gq p;
    @NonNull
    public final Runnable q = new d(null);
    @NonNull
    public final e r;
    @NonNull
    public final b s;
    public final int t;
    public final int u;
    @Nullable
    public final Bitmap v;
    @Nullable
    public final Bitmap w;
    public float x;
    @Nullable
    public gs.a y;
    @Nullable
    public eg.a z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eg.a aVar = gw.this.z;
            if (aVar != null) {
                aVar.df();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eg.a aVar;
            gw gwVar = gw.this;
            if (view == gwVar.g) {
                eg.a aVar2 = gwVar.z;
                if (aVar2 != null) {
                    aVar2.de();
                }
            } else if (view == gwVar.n) {
                if (gwVar.j.isPlaying() && (aVar = gw.this.z) != null) {
                    aVar.dg();
                    return;
                }
                return;
            } else if (view != gwVar.o) {
                return;
            } else {
                if (gwVar.z != null) {
                    if (gwVar.isPaused()) {
                        gw.this.z.dh();
                    } else {
                        gw.this.z.de();
                    }
                }
            }
            gw.this.c();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gs.a aVar;
            if (view.isEnabled() && (aVar = gw.this.y) != null) {
                aVar.dy();
            }
        }
    }

    public class d implements Runnable {
        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            gw gwVar = gw.this;
            int i = gwVar.A;
            if (i == 2 || i == 0) {
                gwVar.c();
            }
        }
    }

    public class e implements View.OnClickListener {
        public e(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gw gwVar = gw.this;
            gwVar.removeCallbacks(gwVar.q);
            gw gwVar2 = gw.this;
            int i = gwVar2.A;
            if (i == 2) {
                gwVar2.c();
                return;
            }
            if (i == 0 || i == 3) {
                gwVar2.A = 2;
                gwVar2.g.setVisibility(8);
                gwVar2.o.setVisibility(8);
                gwVar2.n.setVisibility(0);
                gwVar2.i.setVisibility(8);
            }
            gw gwVar3 = gw.this;
            gwVar3.postDelayed(gwVar3.q, 4000);
        }
    }

    public gw(@NonNull Context context, boolean z2) {
        super(context);
        TextView textView = new TextView(context);
        this.e = textView;
        TextView textView2 = new TextView(context);
        this.b = textView2;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.c = starsRatingView;
        Button button = new Button(context);
        this.d = button;
        TextView textView3 = new TextView(context);
        this.h = textView3;
        FrameLayout frameLayout = new FrameLayout(context);
        this.i = frameLayout;
        gq gqVar = new gq(context);
        this.n = gqVar;
        gq gqVar2 = new gq(context);
        this.o = gqVar2;
        gq gqVar3 = new gq(context);
        this.p = gqVar3;
        TextView textView4 = new TextView(context);
        this.k = textView4;
        gv gvVar = new gv(context, io.af(context), false, z2);
        this.j = gvVar;
        gf gfVar = new gf(context);
        this.l = gfVar;
        fx fxVar = new fx(context);
        this.m = fxVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        io af = io.af(context);
        this.f = af;
        e eVar = new e(null);
        this.r = eVar;
        b bVar = new b(null);
        this.s = bVar;
        io.a(textView, "dismiss_button");
        io.a(textView2, "title_text");
        io.a(starsRatingView, "stars_view");
        io.a(button, "cta_button");
        io.a(textView3, "replay_text");
        io.a(frameLayout, "shadow");
        io.a(gqVar, "pause_button");
        io.a(gqVar2, "play_button");
        io.a(gqVar3, "replay_button");
        io.a(textView4, "domain_text");
        io.a(gvVar, "media_view");
        io.a(gfVar, "video_progress_wheel");
        io.a(fxVar, "sound_button");
        this.E = af.L(28);
        int L = af.L(16);
        this.t = L;
        this.u = af.L(4);
        this.v = fi.A(af.L(28));
        this.w = fi.B(af.L(28));
        this.a = new c();
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        gvVar.setOnClickListener(eVar);
        gvVar.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        gvVar.initView();
        frameLayout.setBackgroundColor(-1728053248);
        frameLayout.setVisibility(8);
        textView.setTextSize(2, 16.0f);
        textView.setTransformationMethod(null);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setVisibility(8);
        textView.setTextAlignment(4);
        textView.setTextColor(-1);
        io.a(textView, -2013265920, -1, -1, af.L(1), af.L(4));
        textView2.setMaxLines(2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextSize(2, 18.0f);
        textView2.setTextColor(-1);
        io.a(button, -2013265920, -1, -1, af.L(1), af.L(4));
        button.setTextColor(-1);
        button.setTransformationMethod(null);
        button.setGravity(1);
        button.setTextSize(2, 16.0f);
        button.setMinimumWidth(af.L(100));
        button.setPadding(L, L, L, L);
        textView2.setShadowLayer((float) af.L(1), (float) af.L(1), (float) af.L(1), ViewCompat.MEASURED_STATE_MASK);
        textView4.setTextColor(-3355444);
        textView4.setMaxEms(10);
        textView4.setShadowLayer((float) af.L(1), (float) af.L(1), (float) af.L(1), ViewCompat.MEASURED_STATE_MASK);
        linearLayout.setOnClickListener(bVar);
        linearLayout.setGravity(17);
        linearLayout.setVisibility(8);
        linearLayout.setPadding(af.L(8), 0, af.L(8), 0);
        textView3.setSingleLine();
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTypeface(textView3.getTypeface(), 1);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = af.L(4);
        gqVar3.setPadding(af.L(16), af.L(16), af.L(16), af.L(16));
        gqVar.setOnClickListener(bVar);
        gqVar.setVisibility(8);
        gqVar.setPadding(af.L(16), af.L(16), af.L(16), af.L(16));
        gqVar2.setOnClickListener(bVar);
        gqVar2.setVisibility(8);
        gqVar2.setPadding(af.L(16), af.L(16), af.L(16), af.L(16));
        Bitmap T = fi.T(getContext());
        if (T != null) {
            gqVar2.setImageBitmap(T);
        }
        Bitmap U = fi.U(getContext());
        if (U != null) {
            gqVar.setImageBitmap(U);
        }
        io.a(gqVar, -2013265920, -1, -1, af.L(1), af.L(4));
        io.a(gqVar2, -2013265920, -1, -1, af.L(1), af.L(4));
        io.a(gqVar3, -2013265920, -1, -1, af.L(1), af.L(4));
        starsRatingView.setStarSize(af.L(12));
        gfVar.setVisibility(8);
        addView(gvVar);
        addView(frameLayout);
        addView(fxVar);
        addView(textView);
        addView(gfVar);
        addView(linearLayout);
        addView(gqVar);
        addView(gqVar2);
        addView(starsRatingView);
        addView(textView4);
        addView(button);
        addView(textView2);
        linearLayout.addView(gqVar3);
        linearLayout.addView(textView3, layoutParams);
    }

    @Override // com.my.target.gr
    public void D(int i2) {
        this.j.D(i2);
    }

    @Override // com.my.target.gr
    public void G(boolean z2) {
        this.j.b(z2);
        c();
    }

    @Override // com.my.target.gr
    public final void H(boolean z2) {
        String str;
        fx fxVar = this.m;
        if (z2) {
            fxVar.a(this.w, false);
            str = "sound_off";
        } else {
            fxVar.a(this.v, false);
            str = "sound_on";
        }
        fxVar.setContentDescription(str);
    }

    @Override // com.my.target.gr
    public void a(@NonNull ce ceVar) {
        this.j.setOnClickListener(null);
        this.m.setVisibility(8);
        this.j.a(ceVar);
        ek();
        this.A = 4;
        this.g.setVisibility(8);
        this.o.setVisibility(8);
        this.n.setVisibility(8);
        this.i.setVisibility(8);
        this.l.setVisibility(8);
    }

    public final void b() {
        this.A = 1;
        this.g.setVisibility(8);
        this.o.setVisibility(0);
        this.n.setVisibility(8);
        this.i.setVisibility(0);
    }

    public final void c() {
        this.A = 0;
        this.g.setVisibility(8);
        this.o.setVisibility(8);
        this.n.setVisibility(8);
        this.i.setVisibility(8);
    }

    @Override // com.my.target.gr
    public void destroy() {
        this.j.destroy();
    }

    @Override // com.my.target.gr
    public void ej() {
        this.j.ej();
        this.g.setVisibility(8);
        this.o.setVisibility(8);
        if (this.A != 2) {
            this.n.setVisibility(8);
        }
    }

    @Override // com.my.target.gs
    public void ek() {
        this.e.setText(this.F);
        this.e.setTextSize(2, 16.0f);
        this.e.setVisibility(0);
        this.e.setTextColor(-1);
        this.e.setEnabled(true);
        TextView textView = this.e;
        int i2 = this.t;
        textView.setPadding(i2, i2, i2, i2);
        io.a(this.e, -2013265920, -1, -1, this.f.L(1), this.f.L(4));
        this.H = true;
    }

    @Override // com.my.target.gr
    public void finish() {
        this.l.setVisibility(8);
        this.A = 4;
        if (this.D) {
            this.g.setVisibility(0);
            this.i.setVisibility(0);
        }
        this.o.setVisibility(8);
        this.n.setVisibility(8);
    }

    @Override // com.my.target.gs
    @NonNull
    public View getCloseButton() {
        return this.e;
    }

    @Override // com.my.target.gr
    @NonNull
    public gv getPromoMediaView() {
        return this.j;
    }

    @Override // com.my.target.gs
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.my.target.gr
    public boolean isPaused() {
        return this.j.isPaused();
    }

    @Override // com.my.target.gr
    public boolean isPlaying() {
        return this.j.isPlaying();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int i8 = (i6 - measuredWidth) >> 1;
        int i9 = (i7 - measuredHeight) >> 1;
        this.j.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        this.i.layout(this.j.getLeft(), this.j.getTop(), this.j.getRight(), this.j.getBottom());
        int measuredWidth2 = this.o.getMeasuredWidth();
        int i10 = i4 >> 1;
        int i11 = measuredWidth2 >> 1;
        int i12 = i5 >> 1;
        int measuredHeight2 = this.o.getMeasuredHeight() >> 1;
        this.o.layout(i10 - i11, i12 - measuredHeight2, i11 + i10, measuredHeight2 + i12);
        int measuredWidth3 = this.n.getMeasuredWidth();
        int i13 = measuredWidth3 >> 1;
        int measuredHeight3 = this.n.getMeasuredHeight() >> 1;
        this.n.layout(i10 - i13, i12 - measuredHeight3, i13 + i10, measuredHeight3 + i12);
        int measuredWidth4 = this.g.getMeasuredWidth();
        int i14 = measuredWidth4 >> 1;
        int measuredHeight4 = this.g.getMeasuredHeight() >> 1;
        this.g.layout(i10 - i14, i12 - measuredHeight4, i10 + i14, i12 + measuredHeight4);
        TextView textView = this.e;
        int i15 = this.t;
        textView.layout(i15, i15, textView.getMeasuredWidth() + i15, this.e.getMeasuredHeight() + this.t);
        if (i6 > i7) {
            int max = Math.max(this.d.getMeasuredHeight(), Math.max(this.b.getMeasuredHeight(), this.c.getMeasuredHeight()));
            Button button = this.d;
            int measuredWidth5 = (i6 - this.t) - button.getMeasuredWidth();
            int measuredHeight5 = ((i7 - this.t) - this.d.getMeasuredHeight()) - ((max - this.d.getMeasuredHeight()) >> 1);
            int i16 = this.t;
            button.layout(measuredWidth5, measuredHeight5, i6 - i16, (i7 - i16) - ((max - this.d.getMeasuredHeight()) >> 1));
            this.m.layout(this.m.getPadding() + (this.d.getRight() - this.m.getMeasuredWidth()), this.m.getPadding() + (((this.j.getBottom() - (this.t << 1)) - this.m.getMeasuredHeight()) - max), this.m.getPadding() + this.d.getRight(), this.m.getPadding() + ((this.j.getBottom() - (this.t << 1)) - max));
            StarsRatingView starsRatingView = this.c;
            int left = (this.d.getLeft() - this.t) - this.c.getMeasuredWidth();
            int measuredHeight6 = ((i7 - this.t) - this.c.getMeasuredHeight()) - ((max - this.c.getMeasuredHeight()) >> 1);
            int left2 = this.d.getLeft();
            int i17 = this.t;
            starsRatingView.layout(left, measuredHeight6, left2 - i17, (i7 - i17) - ((max - this.c.getMeasuredHeight()) >> 1));
            TextView textView2 = this.k;
            int left3 = (this.d.getLeft() - this.t) - this.k.getMeasuredWidth();
            int measuredHeight7 = ((i7 - this.t) - this.k.getMeasuredHeight()) - ((max - this.k.getMeasuredHeight()) >> 1);
            int left4 = this.d.getLeft();
            int i18 = this.t;
            textView2.layout(left3, measuredHeight7, left4 - i18, (i7 - i18) - ((max - this.k.getMeasuredHeight()) >> 1));
            int min = Math.min(this.c.getLeft(), this.k.getLeft());
            TextView textView3 = this.b;
            int measuredWidth6 = (min - this.t) - textView3.getMeasuredWidth();
            int measuredHeight8 = ((i7 - this.t) - this.b.getMeasuredHeight()) - ((max - this.b.getMeasuredHeight()) >> 1);
            int i19 = this.t;
            textView3.layout(measuredWidth6, measuredHeight8, min - i19, (i7 - i19) - ((max - this.b.getMeasuredHeight()) >> 1));
            gf gfVar = this.l;
            int i20 = this.t;
            gfVar.layout(i20, ((i7 - i20) - gfVar.getMeasuredHeight()) - ((max - this.l.getMeasuredHeight()) >> 1), this.l.getMeasuredWidth() + this.t, (i7 - this.t) - ((max - this.l.getMeasuredHeight()) >> 1));
            return;
        }
        this.m.layout(this.m.getPadding() + ((this.j.getRight() - this.t) - this.m.getMeasuredWidth()), this.m.getPadding() + ((this.j.getBottom() - this.t) - this.m.getMeasuredHeight()), this.m.getPadding() + (this.j.getRight() - this.t), this.m.getPadding() + (this.j.getBottom() - this.t));
        int i21 = this.t;
        int measuredHeight9 = this.d.getMeasuredHeight() + this.k.getMeasuredHeight() + this.c.getMeasuredHeight() + this.b.getMeasuredHeight();
        int bottom = getBottom() - this.j.getBottom();
        if ((i21 * 3) + measuredHeight9 > bottom) {
            i21 = (bottom - measuredHeight9) / 3;
        }
        TextView textView4 = this.b;
        int i22 = i6 >> 1;
        textView4.layout(i22 - (textView4.getMeasuredWidth() >> 1), this.j.getBottom() + i21, (this.b.getMeasuredWidth() >> 1) + i22, this.b.getMeasuredHeight() + this.j.getBottom() + i21);
        StarsRatingView starsRatingView2 = this.c;
        starsRatingView2.layout(i22 - (starsRatingView2.getMeasuredWidth() >> 1), this.b.getBottom() + i21, (this.c.getMeasuredWidth() >> 1) + i22, this.c.getMeasuredHeight() + this.b.getBottom() + i21);
        TextView textView5 = this.k;
        textView5.layout(i22 - (textView5.getMeasuredWidth() >> 1), this.b.getBottom() + i21, (this.k.getMeasuredWidth() >> 1) + i22, this.k.getMeasuredHeight() + this.b.getBottom() + i21);
        Button button2 = this.d;
        button2.layout(i22 - (button2.getMeasuredWidth() >> 1), this.c.getBottom() + i21, i22 + (this.d.getMeasuredWidth() >> 1), this.d.getMeasuredHeight() + this.c.getBottom() + i21);
        this.l.layout(this.t, (this.j.getBottom() - this.t) - this.l.getMeasuredHeight(), this.l.getMeasuredWidth() + this.t, this.j.getBottom() - this.t);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.m.measure(View.MeasureSpec.makeMeasureSpec(this.E, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
        this.l.measure(View.MeasureSpec.makeMeasureSpec(this.E, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.j.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        int i4 = this.t;
        int i5 = size - (i4 << 1);
        int i6 = size2 - (i4 << 1);
        this.e.measure(View.MeasureSpec.makeMeasureSpec(i5 / 2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.n.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.o.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.g.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.c.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.i.measure(View.MeasureSpec.makeMeasureSpec(this.j.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.j.getMeasuredHeight(), 1073741824));
        this.d.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.b.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.k.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        if (size > size2) {
            int measuredWidth = this.d.getMeasuredWidth();
            int measuredWidth2 = this.b.getMeasuredWidth();
            if ((this.t * 3) + this.l.getMeasuredWidth() + measuredWidth2 + Math.max(this.c.getMeasuredWidth(), this.k.getMeasuredWidth()) + measuredWidth > i5) {
                int measuredWidth3 = (i5 - this.l.getMeasuredWidth()) - (this.t * 3);
                int i7 = measuredWidth3 / 3;
                this.d.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                this.c.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                this.k.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                this.b.measure(View.MeasureSpec.makeMeasureSpec(((measuredWidth3 - this.d.getMeasuredWidth()) - this.k.getMeasuredWidth()) - this.c.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
            }
        } else {
            int measuredHeight = this.d.getMeasuredHeight() + this.k.getMeasuredHeight() + this.c.getMeasuredHeight() + this.b.getMeasuredHeight();
            int measuredHeight2 = (size2 - this.j.getMeasuredHeight()) / 2;
            int i8 = this.t;
            if ((i8 * 3) + measuredHeight > measuredHeight2) {
                this.d.setPadding(i8, i8 / 2, i8, i8 / 2);
                this.d.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // com.my.target.gr
    public void pause() {
        int i2 = this.A;
        if (i2 == 0 || i2 == 2) {
            b();
            this.j.pause();
        }
    }

    @Override // com.my.target.gr
    public void resume() {
        this.j.resume();
    }

    @Override // com.my.target.gs
    public void setBanner(@NonNull ce ceVar) {
        String str;
        this.j.a(ceVar, 1);
        cf<VideoData> videoBanner = ceVar.getVideoBanner();
        if (videoBanner != null) {
            this.l.setMax(ceVar.getDuration());
            this.D = videoBanner.isAllowReplay();
            this.C = ceVar.isAllowClose();
            this.d.setText(ceVar.getCtaText());
            this.b.setText(ceVar.getTitle());
            if ("store".equals(ceVar.getNavigationType())) {
                if (ceVar.getRating() > 0.0f) {
                    this.c.setVisibility(0);
                    this.c.setRating(ceVar.getRating());
                } else {
                    this.c.setVisibility(8);
                }
                this.k.setVisibility(8);
            } else {
                this.c.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(ceVar.getDomain());
            }
            this.F = videoBanner.getCloseActionText();
            this.G = videoBanner.getCloseDelayActionText();
            this.e.setText(this.F);
            if (videoBanner.isAllowClose() && videoBanner.isAutoPlay()) {
                if (videoBanner.getAllowCloseDelay() > 0.0f) {
                    this.B = videoBanner.getAllowCloseDelay();
                    this.e.setEnabled(false);
                    this.e.setTextColor(-3355444);
                    TextView textView = this.e;
                    int i2 = this.u;
                    textView.setPadding(i2, i2, i2, i2);
                    io.a(this.e, -2013265920, -2013265920, -3355444, this.f.L(1), this.f.L(4));
                    this.e.setTextSize(2, 12.0f);
                } else {
                    TextView textView2 = this.e;
                    int i3 = this.t;
                    textView2.setPadding(i3, i3, i3, i3);
                    this.e.setVisibility(0);
                }
            }
            this.h.setText(videoBanner.getReplayActionText());
            Bitmap S = fi.S(getContext());
            if (S != null) {
                this.p.setImageBitmap(S);
            }
            if (videoBanner.isAutoPlay()) {
                G(true);
                c();
            } else {
                b();
            }
            this.x = videoBanner.getDuration();
            fx fxVar = this.m;
            fxVar.setOnClickListener(new a());
            if (videoBanner.isAutoMute()) {
                fxVar.a(this.w, false);
                str = "sound_off";
            } else {
                fxVar.a(this.v, false);
                str = "sound_on";
            }
            fxVar.setContentDescription(str);
        }
    }

    @Override // com.my.target.gs
    public void setClickArea(@NonNull bq bqVar) {
        TextView textView;
        StringBuilder L = a2.b.a.a.a.L("Apply click area ");
        L.append(bqVar.bp());
        L.append(" to view");
        ae.a(L.toString());
        if (bqVar.dW) {
            setOnClickListener(this.a);
        }
        c cVar = null;
        if (bqVar.dQ || bqVar.dW) {
            this.d.setOnClickListener(this.a);
        } else {
            this.d.setOnClickListener(null);
            this.d.setEnabled(false);
        }
        if (bqVar.dK || bqVar.dW) {
            this.b.setOnClickListener(this.a);
        } else {
            this.b.setOnClickListener(null);
        }
        if (bqVar.dO || bqVar.dW) {
            this.c.setOnClickListener(this.a);
        } else {
            this.c.setOnClickListener(null);
        }
        if (bqVar.dT || bqVar.dW) {
            textView = this.k;
            cVar = this.a;
        } else {
            textView = this.k;
        }
        textView.setOnClickListener(cVar);
        if (bqVar.dV || bqVar.dW) {
            setOnClickListener(this.a);
        }
    }

    @Override // com.my.target.gs
    public void setInterstitialPromoViewListener(@Nullable gs.a aVar) {
        this.y = aVar;
    }

    @Override // com.my.target.gr
    public void setMediaListener(@Nullable eg.a aVar) {
        this.z = aVar;
        this.j.setInterstitialPromoViewListener(aVar);
    }

    @Override // com.my.target.gr
    public void setTimeChanged(float f2) {
        if (!this.H && this.C) {
            float f3 = this.B;
            if (f3 > 0.0f && f3 >= f2) {
                if (this.e.getVisibility() != 0) {
                    this.e.setVisibility(0);
                }
                if (this.G != null) {
                    int ceil = (int) Math.ceil((double) (this.B - f2));
                    String valueOf = String.valueOf(ceil);
                    if (this.B > 9.0f && ceil <= 9) {
                        valueOf = a2.b.a.a.a.c3("0", valueOf);
                    }
                    this.e.setText(this.G.replace("%d", valueOf));
                }
            }
        }
        if (this.l.getVisibility() != 0) {
            this.l.setVisibility(0);
        }
        this.l.setProgress(f2 / this.x);
        this.l.setDigit((int) Math.ceil((double) (this.x - f2)));
    }

    @Override // com.my.target.gr
    public void stop(boolean z2) {
        this.j.a(true);
    }
}
