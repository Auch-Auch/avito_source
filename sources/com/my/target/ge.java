package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import com.my.target.common.views.StarsRatingView;
import com.my.target.nativeads.views.MediaAdView;
public class ge extends ViewGroup {
    public static final int A = io.fh();
    public static final int B = io.fh();
    public static final int C = io.fh();
    public static final int D = io.fh();
    public static final int E = io.fh();
    public static final int F = io.fh();
    public static final int G = io.fh();
    public static final int H = io.fh();
    public static final int I = io.fh();
    public static final int J = io.fh();
    public static final int K = io.fh();
    public static final int L = io.fh();
    public static final int M = io.fh();
    @NonNull
    public final TextView a;
    @NonNull
    public final StarsRatingView b;
    @NonNull
    public final Button c;
    @NonNull
    public final Button d;
    @NonNull
    public final io e;
    @NonNull
    public final LinearLayout f;
    @NonNull
    public final TextView g;
    @NonNull
    public final FrameLayout h;
    @NonNull
    public final MediaAdView i;
    @NonNull
    public final TextView j;
    @NonNull
    public final gg k;
    @NonNull
    public final fx l;
    @NonNull
    public final fq m;
    @NonNull
    public final fw n;
    @NonNull
    public final fw o;
    @NonNull
    public final fw p;
    @NonNull
    public final Runnable q = new c(null);
    @NonNull
    public final e r;
    @NonNull
    public final View.OnClickListener s;
    public final int t;
    @Nullable
    public final Bitmap u;
    @Nullable
    public final Bitmap v;
    public int w;
    public final int x;
    public boolean y;
    @Nullable
    public d z;

    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ge.this.z != null) {
                int id = view.getId();
                if (id == ge.B) {
                    ge.this.z.b(view);
                } else if (id == ge.C) {
                    ge.this.z.F();
                } else if (id == ge.E) {
                    ge.this.z.G();
                } else if (id == ge.D) {
                    ge.this.z.E();
                } else if (id == ge.A) {
                    ge.this.z.H();
                } else if (id == ge.J) {
                    ge.this.z.I();
                }
            }
        }
    }

    public class c implements Runnable {
        public c(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ge geVar = ge.this;
            if (geVar.w == 2) {
                ge.b(geVar);
            }
        }
    }

    public interface d {
        void E();

        void F();

        void G();

        void H();

        void I();

        void b(View view);
    }

    public class e implements View.OnClickListener {
        public e(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ge geVar = ge.this;
            geVar.removeCallbacks(geVar.q);
            ge geVar2 = ge.this;
            int i = geVar2.w;
            if (i == 2) {
                ge.b(geVar2);
                return;
            }
            if (i == 0 && i != 2) {
                geVar2.w = 2;
                geVar2.i.getImageView().setVisibility(8);
                geVar2.i.getProgressBarView().setVisibility(8);
                geVar2.f.setVisibility(8);
                geVar2.o.setVisibility(8);
                geVar2.n.setVisibility(0);
                geVar2.h.setVisibility(8);
            }
            ge geVar3 = ge.this;
            geVar3.postDelayed(geVar3.q, 4000);
        }
    }

    public ge(@NonNull Context context) {
        super(context);
        Button button = new Button(context);
        this.d = button;
        TextView textView = new TextView(context);
        this.a = textView;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.b = starsRatingView;
        Button button2 = new Button(context);
        this.c = button2;
        TextView textView2 = new TextView(context);
        this.g = textView2;
        FrameLayout frameLayout = new FrameLayout(context);
        this.h = frameLayout;
        fw fwVar = new fw(context);
        this.n = fwVar;
        fw fwVar2 = new fw(context);
        this.o = fwVar2;
        fw fwVar3 = new fw(context);
        this.p = fwVar3;
        TextView textView3 = new TextView(context);
        this.j = textView3;
        MediaAdView mediaAdView = new MediaAdView(context);
        this.i = mediaAdView;
        gg ggVar = new gg(context);
        this.k = ggVar;
        fx fxVar = new fx(context);
        this.l = fxVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f = linearLayout;
        io af = io.af(context);
        this.e = af;
        e eVar = new e(null);
        this.r = eVar;
        b bVar = new b(null);
        this.s = bVar;
        fq fqVar = new fq(context);
        this.m = fqVar;
        this.u = fj.A(af.L(28));
        this.v = fj.B(af.L(28));
        io.a(button, "dismiss_button");
        io.a(textView, "title_text");
        io.a(starsRatingView, "stars_view");
        io.a(button2, "cta_button");
        io.a(textView2, "replay_text");
        io.a(frameLayout, "shadow");
        io.a(fwVar, "pause_button");
        io.a(fwVar2, "play_button");
        io.a(fwVar3, "replay_button");
        io.a(textView3, "domain_text");
        io.a(mediaAdView, "media_view");
        io.a(ggVar, "video_progress_wheel");
        io.a(fxVar, "sound_button");
        this.x = af.L(28);
        int L2 = af.L(16);
        this.t = L2;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        fxVar.setId(J);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        mediaAdView.setId(M);
        mediaAdView.setLayoutParams(layoutParams);
        mediaAdView.setId(I);
        mediaAdView.setOnClickListener(eVar);
        mediaAdView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setBackgroundColor(-1728053248);
        frameLayout.setVisibility(8);
        button.setId(A);
        button.setTextSize(2, 16.0f);
        button.setTransformationMethod(null);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setMaxLines(2);
        button.setPadding(L2, L2, L2, L2);
        button.setTextColor(-1);
        io.a(button, -2013265920, -1, -1, af.L(1), af.L(4));
        textView.setId(G);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(-1);
        io.a(button2, -2013265920, -1, -1, af.L(1), af.L(4));
        button2.setId(B);
        button2.setTextColor(-1);
        button2.setTransformationMethod(null);
        button2.setGravity(1);
        button2.setTextSize(2, 16.0f);
        button2.setLines(1);
        button2.setEllipsize(TextUtils.TruncateAt.END);
        button2.setMinimumWidth(af.L(100));
        button2.setPadding(L2, L2, L2, L2);
        textView.setShadowLayer((float) af.L(1), (float) af.L(1), (float) af.L(1), ViewCompat.MEASURED_STATE_MASK);
        textView3.setId(H);
        textView3.setTextColor(-3355444);
        textView3.setMaxEms(10);
        textView3.setShadowLayer((float) af.L(1), (float) af.L(1), (float) af.L(1), ViewCompat.MEASURED_STATE_MASK);
        linearLayout.setId(C);
        linearLayout.setOnClickListener(bVar);
        linearLayout.setGravity(17);
        linearLayout.setVisibility(8);
        linearLayout.setPadding(af.L(8), 0, af.L(8), 0);
        textView2.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTypeface(textView2.getTypeface(), 1);
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = af.L(4);
        fwVar3.setPadding(af.L(16), af.L(16), af.L(16), af.L(16));
        fwVar.setId(E);
        fwVar.setOnClickListener(bVar);
        fwVar.setVisibility(8);
        fwVar.setPadding(af.L(16), af.L(16), af.L(16), af.L(16));
        fwVar2.setId(D);
        fwVar2.setOnClickListener(bVar);
        fwVar2.setVisibility(8);
        fwVar2.setPadding(af.L(16), af.L(16), af.L(16), af.L(16));
        frameLayout.setId(K);
        Bitmap T = fj.T(getContext());
        if (T != null) {
            fwVar2.setImageBitmap(T);
        }
        Bitmap U = fj.U(getContext());
        if (U != null) {
            fwVar.setImageBitmap(U);
        }
        io.a(fwVar, -2013265920, -1, -1, af.L(1), af.L(4));
        io.a(fwVar2, -2013265920, -1, -1, af.L(1), af.L(4));
        io.a(fwVar3, -2013265920, -1, -1, af.L(1), af.L(4));
        starsRatingView.setId(L);
        starsRatingView.setStarSize(af.L(12));
        ggVar.setId(F);
        ggVar.setVisibility(8);
        mediaAdView.addView(fqVar, new ViewGroup.LayoutParams(-1, -1));
        addView(mediaAdView);
        addView(frameLayout);
        addView(fxVar);
        addView(button);
        addView(ggVar);
        addView(linearLayout);
        addView(fwVar);
        addView(fwVar2);
        addView(starsRatingView);
        addView(textView3);
        addView(button2);
        addView(textView);
        linearLayout.addView(fwVar3);
        linearLayout.addView(textView2, layoutParams2);
        button2.setOnClickListener(bVar);
        button.setOnClickListener(bVar);
        fxVar.setOnClickListener(bVar);
    }

    public static void b(ge geVar) {
        if (geVar.w != 0) {
            geVar.w = 0;
            geVar.i.getImageView().setVisibility(8);
            geVar.i.getProgressBarView().setVisibility(8);
            geVar.f.setVisibility(8);
            geVar.o.setVisibility(8);
            geVar.n.setVisibility(8);
            geVar.h.setVisibility(8);
        }
    }

    public void E(boolean z2) {
        fx fxVar;
        String str;
        if (z2) {
            this.l.a(this.v, false);
            fxVar = this.l;
            str = "sound off";
        } else {
            this.l.a(this.u, false);
            fxVar = this.l;
            str = "sound on";
        }
        fxVar.setContentDescription(str);
    }

    public void a(float f2, float f3) {
        if (this.k.getVisibility() != 0) {
            this.k.setVisibility(0);
        }
        this.k.setProgress(f2 / f3);
        this.k.setDigit((int) Math.ceil((double) (f3 - f2)));
    }

    public void a(@NonNull cg cgVar, @NonNull VideoData videoData) {
        cf<VideoData> videoBanner = cgVar.getVideoBanner();
        if (videoBanner != null) {
            this.k.setMax(cgVar.getDuration());
            this.y = videoBanner.isAllowReplay();
            this.c.setText(cgVar.getCtaText());
            this.a.setText(cgVar.getTitle());
            if ("store".equals(cgVar.getNavigationType())) {
                this.j.setVisibility(8);
                if (cgVar.getVotes() == 0 || cgVar.getRating() <= 0.0f) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                    this.b.setRating(cgVar.getRating());
                }
            } else {
                this.b.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(cgVar.getDomain());
            }
            this.d.setText(videoBanner.getCloseActionText());
            this.g.setText(videoBanner.getReplayActionText());
            Bitmap S = fj.S(getContext());
            if (S != null) {
                this.p.setImageBitmap(S);
            }
            this.i.setPlaceHolderDimension(videoData.getWidth(), videoData.getHeight());
            ImageData image = cgVar.getImage();
            if (image != null) {
                this.i.getImageView().setImageBitmap(image.getBitmap());
            }
        }
    }

    public void dX() {
        if (this.w != 4) {
            this.w = 4;
            this.i.getImageView().setVisibility(0);
            this.i.getProgressBarView().setVisibility(8);
            if (this.y) {
                this.f.setVisibility(0);
                this.h.setVisibility(0);
            }
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public void dY() {
        if (this.w != 3) {
            this.w = 3;
            this.i.getProgressBarView().setVisibility(0);
            this.f.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            this.h.setVisibility(8);
        }
    }

    public void dZ() {
        if (this.w != 1) {
            this.w = 1;
            this.i.getImageView().setVisibility(0);
            this.i.getProgressBarView().setVisibility(8);
            this.f.setVisibility(8);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.h.setVisibility(0);
        }
    }

    public void ea() {
        int i2 = this.w;
        if (i2 != 0 && i2 != 2) {
            this.w = 0;
            this.i.getImageView().setVisibility(8);
            this.i.getProgressBarView().setVisibility(8);
            this.f.setVisibility(8);
            this.o.setVisibility(8);
            if (this.w != 2) {
                this.n.setVisibility(8);
            }
        }
    }

    public void eb() {
        this.i.getImageView().setVisibility(0);
    }

    @NonNull
    public fq getAdVideoView() {
        return this.m;
    }

    @NonNull
    public MediaAdView getMediaAdView() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int measuredWidth = this.i.getMeasuredWidth();
        int measuredHeight = this.i.getMeasuredHeight();
        int i8 = (i6 - measuredWidth) >> 1;
        int i9 = (i7 - measuredHeight) >> 1;
        this.i.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        this.h.layout(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
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
        int measuredWidth4 = this.f.getMeasuredWidth();
        int i14 = measuredWidth4 >> 1;
        int measuredHeight4 = this.f.getMeasuredHeight() >> 1;
        this.f.layout(i10 - i14, i12 - measuredHeight4, i10 + i14, i12 + measuredHeight4);
        Button button = this.d;
        int i15 = this.t;
        button.layout(i15, i15, button.getMeasuredWidth() + i15, this.d.getMeasuredHeight() + this.t);
        if (i6 > i7) {
            int max = Math.max(this.c.getMeasuredHeight(), Math.max(this.a.getMeasuredHeight(), this.b.getMeasuredHeight()));
            Button button2 = this.c;
            int measuredWidth5 = (i6 - this.t) - button2.getMeasuredWidth();
            int measuredHeight5 = ((i7 - this.t) - this.c.getMeasuredHeight()) - ((max - this.c.getMeasuredHeight()) >> 1);
            int i16 = this.t;
            button2.layout(measuredWidth5, measuredHeight5, i6 - i16, (i7 - i16) - ((max - this.c.getMeasuredHeight()) >> 1));
            this.l.layout(this.l.getPadding() + (this.c.getRight() - this.l.getMeasuredWidth()), this.l.getPadding() + (((this.i.getBottom() - (this.t << 1)) - this.l.getMeasuredHeight()) - max), this.l.getPadding() + this.c.getRight(), this.l.getPadding() + ((this.i.getBottom() - (this.t << 1)) - max));
            StarsRatingView starsRatingView = this.b;
            int left = (this.c.getLeft() - this.t) - this.b.getMeasuredWidth();
            int measuredHeight6 = ((i7 - this.t) - this.b.getMeasuredHeight()) - ((max - this.b.getMeasuredHeight()) >> 1);
            int left2 = this.c.getLeft();
            int i17 = this.t;
            starsRatingView.layout(left, measuredHeight6, left2 - i17, (i7 - i17) - ((max - this.b.getMeasuredHeight()) >> 1));
            TextView textView = this.j;
            int left3 = (this.c.getLeft() - this.t) - this.j.getMeasuredWidth();
            int measuredHeight7 = ((i7 - this.t) - this.j.getMeasuredHeight()) - ((max - this.j.getMeasuredHeight()) >> 1);
            int left4 = this.c.getLeft();
            int i18 = this.t;
            textView.layout(left3, measuredHeight7, left4 - i18, (i7 - i18) - ((max - this.j.getMeasuredHeight()) >> 1));
            int min = Math.min(this.b.getLeft(), this.j.getLeft());
            TextView textView2 = this.a;
            int measuredWidth6 = (min - this.t) - textView2.getMeasuredWidth();
            int measuredHeight8 = ((i7 - this.t) - this.a.getMeasuredHeight()) - ((max - this.a.getMeasuredHeight()) >> 1);
            int i19 = this.t;
            textView2.layout(measuredWidth6, measuredHeight8, min - i19, (i7 - i19) - ((max - this.a.getMeasuredHeight()) >> 1));
            gg ggVar = this.k;
            int i20 = this.t;
            ggVar.layout(i20, ((i7 - i20) - ggVar.getMeasuredHeight()) - ((max - this.k.getMeasuredHeight()) >> 1), this.k.getMeasuredWidth() + this.t, (i7 - this.t) - ((max - this.k.getMeasuredHeight()) >> 1));
            return;
        }
        this.l.layout(this.l.getPadding() + ((this.i.getRight() - this.t) - this.l.getMeasuredWidth()), this.l.getPadding() + ((this.i.getBottom() - this.t) - this.l.getMeasuredHeight()), this.l.getPadding() + (this.i.getRight() - this.t), this.l.getPadding() + (this.i.getBottom() - this.t));
        TextView textView3 = this.a;
        int i21 = i6 >> 1;
        textView3.layout(i21 - (textView3.getMeasuredWidth() >> 1), this.i.getBottom() + this.t, (this.a.getMeasuredWidth() >> 1) + i21, this.a.getMeasuredHeight() + this.i.getBottom() + this.t);
        StarsRatingView starsRatingView2 = this.b;
        starsRatingView2.layout(i21 - (starsRatingView2.getMeasuredWidth() >> 1), this.a.getBottom() + this.t, (this.b.getMeasuredWidth() >> 1) + i21, this.b.getMeasuredHeight() + this.a.getBottom() + this.t);
        TextView textView4 = this.j;
        textView4.layout(i21 - (textView4.getMeasuredWidth() >> 1), this.a.getBottom() + this.t, (this.j.getMeasuredWidth() >> 1) + i21, this.j.getMeasuredHeight() + this.a.getBottom() + this.t);
        Button button3 = this.c;
        button3.layout(i21 - (button3.getMeasuredWidth() >> 1), this.b.getBottom() + this.t, i21 + (this.c.getMeasuredWidth() >> 1), this.c.getMeasuredHeight() + this.b.getBottom() + this.t);
        this.k.layout(this.t, (this.i.getBottom() - this.t) - this.k.getMeasuredHeight(), this.k.getMeasuredWidth() + this.t, this.i.getBottom() - this.t);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.l.measure(View.MeasureSpec.makeMeasureSpec(this.x, 1073741824), View.MeasureSpec.makeMeasureSpec(this.x, 1073741824));
        this.k.measure(View.MeasureSpec.makeMeasureSpec(this.x, 1073741824), View.MeasureSpec.makeMeasureSpec(this.x, 1073741824));
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.i.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        int i4 = this.t;
        int i5 = size - (i4 << 1);
        int i6 = size2 - (i4 << 1);
        this.d.measure(View.MeasureSpec.makeMeasureSpec(i5 / 2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.n.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.o.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.f.measure(View.MeasureSpec.makeMeasureSpec(i5 - (this.t * 4), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.b.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.h.measure(View.MeasureSpec.makeMeasureSpec(this.i.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.i.getMeasuredHeight(), 1073741824));
        this.c.measure(View.MeasureSpec.makeMeasureSpec(i5 - (this.t * 4), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.a.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        this.j.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
        if (size > size2) {
            int measuredWidth = this.c.getMeasuredWidth();
            int measuredWidth2 = this.a.getMeasuredWidth();
            if ((this.t * 3) + this.k.getMeasuredWidth() + measuredWidth2 + Math.max(this.b.getMeasuredWidth(), this.j.getMeasuredWidth()) + measuredWidth > i5) {
                int measuredWidth3 = (i5 - this.k.getMeasuredWidth()) - (this.t * 3);
                int i7 = measuredWidth3 / 3;
                this.c.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                this.b.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                this.j.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                this.a.measure(View.MeasureSpec.makeMeasureSpec(((measuredWidth3 - this.c.getMeasuredWidth()) - this.j.getMeasuredWidth()) - this.b.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setVideoDialogViewListener(@Nullable d dVar) {
        this.z = dVar;
    }
}
