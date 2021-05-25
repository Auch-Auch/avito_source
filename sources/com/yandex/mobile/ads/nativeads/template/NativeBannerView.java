package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.yandex.mobile.ads.impl.aa;
import com.yandex.mobile.ads.impl.dv;
import com.yandex.mobile.ads.impl.eg;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdException;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdImageLoadingListener;
import com.yandex.mobile.ads.nativeads.NativeAdMedia;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.ba;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;
import com.yandex.mobile.ads.nativeads.template.a;
import com.yandex.mobile.ads.nativeads.template.appearance.NativeTemplateAppearance;
import com.yandex.mobile.ads.nativeads.u;
import com.yandex.mobile.ads.nativeads.y;
import java.util.Arrays;
public final class NativeBannerView extends u<ba> {
    private NativeAdAssets A;
    private e B;
    private d C;
    private NativeGenericAd D;
    private b E;
    private final NativeAdImageLoadingListener F = new NativeAdImageLoadingListener() { // from class: com.yandex.mobile.ads.nativeads.template.NativeBannerView.1
        @Override // com.yandex.mobile.ads.nativeads.NativeAdImageLoadingListener
        public final void onFinishLoadingImages() {
            if (NativeBannerView.this.D != null) {
                NativeBannerView.this.D.removeImageLoadingListener(this);
            }
            NativeBannerView.this.E.a();
        }
    };
    private NativeTemplateAppearance a;
    private TextView b;
    private TextView c;
    private Button d;
    private TextView e;
    private ImageView f;
    private g g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private f k;
    private TextView l;
    private ImageView m;
    private ImageView n;
    private LinearLayout o;
    private final int p = dv.a(getContext(), 4.0f);
    private final int q = dv.a(getContext(), 8.0f);
    private final int r = dv.a(getContext(), 12.0f);
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private ImageView v;
    private LinearLayout w;
    private MediaView x;
    private LinearLayout y;
    private NativeAdType z;

    /* renamed from: com.yandex.mobile.ads.nativeads.template.NativeBannerView$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            SizeConstraint.SizeConstraintType.values();
            int[] iArr = new int[3];
            a = iArr;
            try {
                SizeConstraint.SizeConstraintType sizeConstraintType = SizeConstraint.SizeConstraintType.FIXED;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                SizeConstraint.SizeConstraintType sizeConstraintType2 = SizeConstraint.SizeConstraintType.FIXED_RATIO;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                SizeConstraint.SizeConstraintType sizeConstraintType3 = SizeConstraint.SizeConstraintType.PREFERRED_RATIO;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NativeBannerView(Context context) {
        super(context);
        n();
    }

    private TextView A() {
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setGravity(GravityCompat.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = this.p;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View B() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.t = linearLayout;
        linearLayout.setOrientation(0);
        this.t.setBaselineAligned(false);
        View D2 = D();
        View G = G();
        this.t.addView(D2);
        this.t.addView(G);
        return this.t;
    }

    private View C() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.u = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.q;
        this.u.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        f fVar = new f(getContext());
        fVar.setNumStars(5);
        fVar.setStepSize(0.5f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = this.q;
        fVar.setLayoutParams(layoutParams2);
        this.k = fVar;
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.l = textView;
        linearLayout2.addView(this.k);
        linearLayout2.addView(this.l);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(5);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Button button = new Button(getContext(), null, 16843563);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setMaxLines(1);
        button.setTransformationMethod(null);
        int a3 = dv.a(getContext(), 26.0f);
        button.setMinimumHeight(a3);
        button.setMinHeight(a3);
        button.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.d = button;
        linearLayout3.addView(button);
        this.u.addView(linearLayout2);
        this.u.addView(linearLayout3);
        return this.u;
    }

    private View D() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.p;
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(layoutParams);
        this.j = F();
        this.f = F();
        this.m = E();
        frameLayout.addView(this.j);
        frameLayout.addView(this.f);
        frameLayout.addView(this.m);
        return frameLayout;
    }

    private ImageView E() {
        ImageView imageView = new ImageView(getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    private ImageView F() {
        ImageView imageView = new ImageView(getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    private View G() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.h = H();
        this.c = I();
        this.e = J();
        linearLayout.addView(this.h);
        linearLayout.addView(this.c);
        linearLayout.addView(this.e);
        linearLayout.addView(C());
        return linearLayout;
    }

    private TextView H() {
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(2);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    private TextView I() {
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(3);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    private TextView J() {
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    private View K() {
        TextView L = L();
        this.i = L;
        return L;
    }

    private TextView L() {
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private void M() {
        N();
        O();
        Q();
        R();
        invalidate();
        requestLayout();
    }

    private void N() {
        Z();
        aa();
        ab();
        ac();
    }

    private void O() {
        this.d.setTextColor(this.a.getCallToActionAppearance().getTextAppearance().getTextColor());
        this.d.setTextSize(this.a.getCallToActionAppearance().getTextAppearance().getTextSize());
        this.d.setTypeface(Typeface.create(this.a.getCallToActionAppearance().getTextAppearance().getFontFamilyName(), this.a.getCallToActionAppearance().getTextAppearance().getFontStyle()));
        P();
    }

    private void P() {
        float[] fArr = new float[8];
        Arrays.fill(fArr, (float) dv.a(getContext(), 5.0f));
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, fArr);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(this.a.getCallToActionAppearance().getPressedColor());
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(roundRectShape);
        shapeDrawable2.getPaint().setColor(this.a.getCallToActionAppearance().getNormalColor());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, shapeDrawable);
        stateListDrawable.addState(new int[]{16842919}, shapeDrawable);
        stateListDrawable.addState(new int[0], shapeDrawable2);
        int a3 = dv.a(getContext(), this.a.getCallToActionAppearance().getBorderWidth());
        ShapeDrawable shapeDrawable3 = new ShapeDrawable();
        shapeDrawable3.setShape(roundRectShape);
        Paint paint = shapeDrawable3.getPaint();
        paint.setColor(this.a.getCallToActionAppearance().getBorderColor());
        paint.setStrokeWidth((float) a3);
        paint.setStyle(Paint.Style.STROKE);
        this.d.setBackground(new LayerDrawable(new Drawable[]{stateListDrawable, shapeDrawable3}));
    }

    private void Q() {
        LayerDrawable layerDrawable = (LayerDrawable) this.k.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(this.a.getRatingAppearance().getProgressStarColor(), PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(1).setColorFilter(this.a.getRatingAppearance().getBackgroundStarColor(), PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(0).setColorFilter(this.a.getRatingAppearance().getBackgroundStarColor(), PorterDuff.Mode.SRC_ATOP);
    }

    private void R() {
        S();
        T();
        U();
        V();
        W();
        X();
        Y();
    }

    private void S() {
        this.b.setTypeface(Typeface.create(this.a.getAgeAppearance().getFontFamilyName(), this.a.getAgeAppearance().getFontStyle()));
        this.b.setTextColor(this.a.getAgeAppearance().getTextColor());
        this.b.setTextSize(2, this.a.getAgeAppearance().getTextSize());
    }

    private void T() {
        this.c.setTypeface(Typeface.create(this.a.getBodyAppearance().getFontFamilyName(), this.a.getBodyAppearance().getFontStyle()));
        this.c.setTextColor(this.a.getBodyAppearance().getTextColor());
        this.c.setTextSize(2, this.a.getBodyAppearance().getTextSize());
    }

    private void U() {
        this.e.setTypeface(Typeface.create(this.a.getDomainAppearance().getFontFamilyName(), this.a.getDomainAppearance().getFontStyle()));
        this.e.setTextColor(this.a.getDomainAppearance().getTextColor());
        this.e.setTextSize(2, this.a.getDomainAppearance().getTextSize());
    }

    private void V() {
        this.l.setTypeface(Typeface.create(this.a.getReviewCountAppearance().getFontFamilyName(), this.a.getReviewCountAppearance().getFontStyle()));
        this.l.setTextColor(this.a.getReviewCountAppearance().getTextColor());
        this.l.setTextSize(2, this.a.getReviewCountAppearance().getTextSize());
    }

    private void W() {
        this.g.setTypeface(Typeface.create(this.a.getSponsoredAppearance().getFontFamilyName(), this.a.getSponsoredAppearance().getFontStyle()));
        this.g.setTextColor(this.a.getSponsoredAppearance().getTextColor());
        this.g.setTextSize(2, this.a.getSponsoredAppearance().getTextSize());
    }

    private void X() {
        this.h.setTypeface(Typeface.create(this.a.getTitleAppearance().getFontFamilyName(), this.a.getTitleAppearance().getFontStyle()));
        this.h.setTextColor(this.a.getTitleAppearance().getTextColor());
        this.h.setTextSize(2, this.a.getTitleAppearance().getTextSize());
    }

    private void Y() {
        this.i.setTypeface(Typeface.create(this.a.getWarningAppearance().getFontFamilyName(), this.a.getWarningAppearance().getFontStyle()));
        this.i.setTextColor(this.a.getWarningAppearance().getTextColor());
        this.i.setTextSize(2, this.a.getWarningAppearance().getTextSize());
    }

    private void Z() {
        int a3 = dv.a(getContext(), this.a.getBannerAppearance().getBorderWidth());
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.a.getBannerAppearance().getBackgroundColor());
        paint.setStyle(Paint.Style.FILL);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setShape(new RectShape());
        Paint paint2 = shapeDrawable2.getPaint();
        paint2.setColor(this.a.getBannerAppearance().getBorderColor());
        paint2.setStrokeWidth(((float) a3) * 2.0f);
        paint2.setStyle(Paint.Style.STROKE);
        setBackground(new LayerDrawable(new Drawable[]{shapeDrawable, shapeDrawable2}));
        setPadding(a3, a3, a3, a3);
    }

    private void aa() {
        int a3 = dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getLeft());
        int a4 = dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getRight());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a3, this.q, a4, this.p);
        this.s.setLayoutParams(layoutParams);
        this.s.invalidate();
    }

    private void ab() {
        int a3 = dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getLeft());
        int a4 = dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getRight());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = a3;
        layoutParams.rightMargin = a4;
        layoutParams.bottomMargin = this.p;
        this.t.setLayoutParams(layoutParams);
        this.t.invalidate();
    }

    private void ac() {
        int a3 = dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getLeft());
        int a4 = dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getRight());
        TextView textView = this.i;
        int i2 = this.p;
        textView.setPadding(a3, i2, a4, i2);
        this.i.invalidate();
    }

    private void n() {
        this.a = new NativeTemplateAppearance.Builder().build();
        this.n = F();
        this.o = p();
        addView(this.n, new ViewGroup.LayoutParams(-1, -2));
        addView(this.o, new ViewGroup.LayoutParams(-1, -1));
        o();
        this.E = new b(this.m, this.j, this.f, this.v, this.n);
        M();
    }

    @VisibleForTesting
    private void o() {
        this.n.setVisibility(8);
        this.o.setVisibility(8);
    }

    private LinearLayout p() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View v2 = v();
        View B2 = B();
        View q2 = q();
        View r2 = r();
        View K = K();
        linearLayout.addView(v2);
        linearLayout.addView(B2);
        linearLayout.addView(q2);
        linearLayout.addView(r2);
        linearLayout.addView(K);
        return linearLayout;
    }

    private View q() {
        this.w = s();
        ImageView t2 = t();
        this.v = t2;
        this.w.addView(t2);
        return this.w;
    }

    private View r() {
        this.y = s();
        MediaView u2 = u();
        this.x = u2;
        this.y.addView(u2);
        return this.y;
    }

    private LinearLayout s() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    private ImageView t() {
        ImageView imageView = new ImageView(getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private MediaView u() {
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return mediaView;
    }

    private View v() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.s = linearLayout;
        linearLayout.setOrientation(0);
        this.s.setGravity(17);
        this.s.setWeightSum(4.0f);
        View w2 = w();
        View x2 = x();
        View z2 = z();
        this.s.addView(w2);
        this.s.addView(x2);
        this.s.addView(z2);
        return this.s;
    }

    private View w() {
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        return view;
    }

    private View x() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 2.0f));
        g y2 = y();
        this.g = y2;
        linearLayout.addView(y2);
        return linearLayout;
    }

    private g y() {
        g gVar = new g(getContext());
        gVar.setEllipsize(TextUtils.TruncateAt.END);
        gVar.setMaxLines(1);
        gVar.setGravity(17);
        gVar.setPadding(0, 0, 0, dv.a(getContext(), 4.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        gVar.setLayoutParams(layoutParams);
        return gVar;
    }

    private View z() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView A2 = A();
        this.b = A2;
        linearLayout.addView(A2);
        return linearLayout;
    }

    public final void applyAppearance(@Nullable NativeTemplateAppearance nativeTemplateAppearance) {
        if (nativeTemplateAppearance != null && !nativeTemplateAppearance.equals(this.a)) {
            this.a = nativeTemplateAppearance;
            M();
        }
    }

    public final Button c() {
        return this.d;
    }

    public final TextView d() {
        return this.e;
    }

    public final ImageView e() {
        NativeAdImage image;
        ImageView imageView = this.f;
        if (this.C == null || (image = this.A.getImage()) == null) {
            return imageView;
        }
        if (d.b(image)) {
            return this.n;
        }
        return d.a(image) ? this.v : imageView;
    }

    public final MediaView f() {
        return this.x;
    }

    public final TextView g() {
        return this.g;
    }

    public final TextView h() {
        return this.h;
    }

    public final TextView i() {
        return this.i;
    }

    public final ImageView j() {
        return this.j;
    }

    public final View k() {
        return this.k;
    }

    public final TextView l() {
        return this.l;
    }

    public final ImageView m() {
        return this.m;
    }

    @Override // com.yandex.mobile.ads.nativeads.u, android.view.View, android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        NativeGenericAd nativeGenericAd = this.D;
        if (nativeGenericAd != null) {
            nativeGenericAd.addImageLoadingListener(this.F);
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.u, android.view.View, android.view.ViewGroup
    public final void onDetachedFromWindow() {
        NativeGenericAd nativeGenericAd = this.D;
        if (nativeGenericAd != null) {
            nativeGenericAd.removeImageLoadingListener(this.F);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams;
        int i4;
        int i5;
        if (this.C != null) {
            int size = View.MeasureSpec.getSize(i2);
            d dVar = this.C;
            Context context = getContext();
            int a3 = dv.a(context, this.a.getBannerAppearance().getContentPadding().getLeft());
            int a4 = dv.a(context, this.a.getBannerAppearance().getContentPadding().getRight());
            if (dVar.a() || dVar.b() || dVar.c()) {
                int round = Math.round((float) ((size - a3) - a4));
                int a5 = dv.a(context, (float) a3) + dv.a(getContext(), this.a.getBannerAppearance().getImageMargins().getLeft());
                int a6 = dv.a(getContext(), this.a.getBannerAppearance().getImageMargins().getRight());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, 0);
                if (dVar.a()) {
                    NativeAdImage favicon = this.A.getFavicon();
                    a.d a8 = a(this.a.getFaviconAppearance().getWidthConstraint()).a(getContext(), round, favicon.getWidth(), favicon.getHeight());
                    int a9 = dv.a(getContext(), 5.0f);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a8.a(), a8.b());
                    layoutParams3.leftMargin = a5;
                    layoutParams3.rightMargin = a9;
                    layoutParams2 = layoutParams3;
                }
                this.m.setLayoutParams(layoutParams2);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(0, 0);
                if (dVar.b()) {
                    layoutParams4 = a(this.A.getIcon(), round, a5, a6);
                }
                this.j.setLayoutParams(layoutParams4);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(0, 0);
                if (dVar.c()) {
                    layoutParams5 = a(this.A.getImage(), round, a5, a6);
                }
                this.f.setLayoutParams(layoutParams5);
                a(0);
            } else {
                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(0, 0);
                this.m.setLayoutParams(layoutParams6);
                this.j.setLayoutParams(layoutParams6);
                this.f.setLayoutParams(layoutParams6);
                a(a3);
            }
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, 0);
            if (dVar.d()) {
                NativeAdImage image = this.A.getImage();
                int width = image.getWidth();
                int height = image.getHeight();
                float width2 = (float) image.getWidth();
                float height2 = (float) image.getHeight();
                if (height2 != 0.0f && width2 / height2 < 1.0f) {
                    i4 = Math.round((float) ((size * 3) / 4));
                    i5 = Math.round((((float) i4) / ((float) height)) * ((float) width));
                } else {
                    i4 = a(size, width, height);
                    i5 = size;
                }
                float width3 = (float) image.getWidth();
                float height3 = (float) image.getHeight();
                if (!(height3 != 0.0f && width3 / height3 > 1.5f)) {
                    i4 = Math.round(((float) i4) * 0.8f);
                }
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(i5, i4);
                layoutParams8.topMargin = this.p;
                layoutParams8.gravity = 1;
                layoutParams7 = layoutParams8;
            }
            this.w.setLayoutParams(layoutParams7);
            d dVar2 = this.C;
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, 0);
            NativeAdMedia media = this.A.getMedia();
            if (media != null && dVar2.f()) {
                layoutParams9 = new LinearLayout.LayoutParams(size, new aa(media.getAspectRatio()).b(size));
            }
            this.y.setLayoutParams(layoutParams9);
            if (this.B.c()) {
                if (this.B.b()) {
                    ((ViewManager) this.u.getParent()).removeView(this.u);
                    LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
                    if (this.B.a()) {
                        layoutParams10.topMargin = this.r;
                    } else {
                        layoutParams10.topMargin = this.p;
                    }
                    layoutParams10.bottomMargin = this.q;
                    this.u.setLayoutParams(layoutParams10);
                    this.u.setPadding(dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getLeft()), 0, dv.a(getContext(), this.a.getBannerAppearance().getContentPadding().getRight()), 0);
                    LinearLayout linearLayout = this.o;
                    linearLayout.addView(this.u, linearLayout.getChildCount() - 1);
                } else {
                    ((ViewManager) this.u.getParent()).removeView(this.u);
                    this.u.setPadding(0, 0, 0, 0);
                    LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
                    int i6 = this.q;
                    layoutParams11.topMargin = i6;
                    layoutParams11.bottomMargin = i6;
                    ((ViewManager) this.e.getParent()).addView(this.u, layoutParams11);
                }
                if (this.B.d()) {
                    layoutParams = new LinearLayout.LayoutParams(-1, -2);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                this.d.setLayoutParams(layoutParams);
            } else {
                this.u.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
            int round2 = Math.round(((float) size) * 0.4f);
            this.d.setMinWidth(round2);
            this.d.setMinimumWidth(round2);
            if (this.B.f()) {
                TextView textView = this.i;
                if (this.B.e()) {
                    textView.setBackgroundColor(0);
                } else {
                    textView.setBackgroundColor(eg.a(textView.getCurrentTextColor(), 92.0f));
                }
                this.i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
        }
        super.onMeasure(i2, i3);
    }

    public final void setAd(NativeGenericAd nativeGenericAd) {
        NativeAdImage image;
        NativeGenericAd nativeGenericAd2 = this.D;
        if (nativeGenericAd2 != nativeGenericAd) {
            if (nativeGenericAd2 != null) {
                try {
                    nativeGenericAd2.removeImageLoadingListener(this.F);
                } catch (NativeAdException unused) {
                    return;
                }
            }
            nativeGenericAd.addImageLoadingListener(this.F);
            this.z = nativeGenericAd.getAdType();
            NativeAdAssets adAssets = nativeGenericAd.getAdAssets();
            this.A = adAssets;
            this.B = new e(adAssets, this.z);
            this.C = new d(this.A, this.z);
            ((y) nativeGenericAd).a(this);
            int i2 = 0;
            if (!(this.C == null || (image = this.A.getImage()) == null || !d.b(image))) {
                this.n.setVisibility(0);
                i2 = 8;
            }
            this.o.setVisibility(i2);
            this.D = nativeGenericAd;
        }
    }

    private static a a(SizeConstraint sizeConstraint) {
        int i2 = AnonymousClass2.a[sizeConstraint.getSizeConstraintType().ordinal()];
        if (i2 == 1) {
            return new a.C0367a(sizeConstraint.getValue());
        }
        if (i2 == 2) {
            return new a.b(sizeConstraint.getValue());
        }
        if (i2 != 3) {
            return new a.c(sizeConstraint.getValue());
        }
        return new a.c(sizeConstraint.getValue());
    }

    public final TextView b() {
        return this.c;
    }

    private void a(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams.leftMargin = i2;
        this.t.setLayoutParams(layoutParams);
    }

    private FrameLayout.LayoutParams a(NativeAdImage nativeAdImage, int i2, int i3, int i4) {
        a.d a3 = a(this.a.getImageAppearance().getWidthConstraint()).a(getContext(), i2, nativeAdImage.getWidth(), nativeAdImage.getHeight());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a3.a(), a3.b());
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i4;
        return layoutParams;
    }

    public NativeBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 == 0) {
            return i4;
        }
        return Math.round(((float) i4) * (((float) i2) / ((float) i3)));
    }

    public final TextView a() {
        return this.b;
    }

    public NativeBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        n();
    }
}
