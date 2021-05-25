package com.my.target;

import a2.l.a.n;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.my.target.common.models.ImageData;
import com.my.target.common.views.StarsRatingView;
import com.my.target.nativeads.views.MediaAdView;
import java.util.ArrayList;
@SuppressLint({"ViewConstructor"})
public class gt extends ViewGroup {
    @NonNull
    public final TextView a;
    @NonNull
    public final gd b;
    @NonNull
    public final TextView c;
    @NonNull
    public final LinearLayout d;
    @NonNull
    public final StarsRatingView e;
    @NonNull
    public final TextView f;
    @NonNull
    public final TextView g;
    @NonNull
    public final Button h;
    @NonNull
    public final gc i;
    @NonNull
    public final io j;
    public final int k;
    public final int l;
    public final int m;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            gt.this.c.setVisibility(8);
            gt.this.a.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public gt(@NonNull Context context, @NonNull io ioVar) {
        super(context);
        this.j = ioVar;
        Button button = new Button(context);
        this.h = button;
        io.a(button, "cta_button");
        gc gcVar = new gc(context);
        this.i = gcVar;
        io.a(gcVar, ViewHierarchyConstants.ICON_BITMAP);
        this.b = new gd(context);
        TextView textView = new TextView(context);
        this.a = textView;
        io.a(textView, "description_text");
        TextView textView2 = new TextView(context);
        this.c = textView2;
        io.a(textView2, "disclaimer_text");
        this.d = new LinearLayout(context);
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.e = starsRatingView;
        io.a(starsRatingView, "stars_view");
        TextView textView3 = new TextView(context);
        this.f = textView3;
        io.a(textView3, "votes_text");
        TextView textView4 = new TextView(context);
        this.g = textView4;
        io.a(textView4, "domain_text");
        this.k = ioVar.L(16);
        this.m = ioVar.L(8);
        this.l = ioVar.L(64);
    }

    public final void a(int i2, @NonNull View... viewArr) {
        int height = this.i.getHeight();
        int height2 = getHeight();
        int width = this.h.getWidth();
        int height3 = this.h.getHeight();
        int width2 = this.i.getWidth();
        this.i.setPivotX(0.0f);
        this.i.setPivotY(((float) height) / 2.0f);
        this.h.setPivotX((float) width);
        this.h.setPivotY(((float) height3) / 2.0f);
        float f2 = ((float) height2) * 0.3f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.h, View.SCALE_X, 0.7f));
        arrayList.add(ObjectAnimator.ofFloat(this.h, View.SCALE_Y, 0.7f));
        arrayList.add(ObjectAnimator.ofFloat(this.i, View.SCALE_X, 0.7f));
        arrayList.add(ObjectAnimator.ofFloat(this.i, View.SCALE_Y, 0.7f));
        arrayList.add(ObjectAnimator.ofFloat(this.a, View.ALPHA, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.c, View.ALPHA, 0.0f));
        if (this.d.isEnabled()) {
            arrayList.add(ObjectAnimator.ofFloat(this.d, View.ALPHA, 1.0f));
        }
        arrayList.add(ObjectAnimator.ofFloat(this, View.ALPHA, 0.6f));
        float f3 = -(((float) width2) * 0.3f);
        arrayList.add(ObjectAnimator.ofFloat(this.b, View.TRANSLATION_X, f3));
        arrayList.add(ObjectAnimator.ofFloat(this.d, View.TRANSLATION_X, f3));
        arrayList.add(ObjectAnimator.ofFloat(this.g, View.TRANSLATION_X, f3));
        arrayList.add(ObjectAnimator.ofFloat(this.a, View.TRANSLATION_X, f3));
        arrayList.add(ObjectAnimator.ofFloat(this.c, View.TRANSLATION_X, f3));
        arrayList.add(ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, f2));
        float f4 = (-f2) / 2.0f;
        arrayList.add(ObjectAnimator.ofFloat(this.h, View.TRANSLATION_Y, f4));
        arrayList.add(ObjectAnimator.ofFloat(this.i, View.TRANSLATION_Y, f4));
        for (View view : viewArr) {
            arrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, f2));
        }
        if (this.d.isEnabled()) {
            this.d.setVisibility(0);
        }
        if (this.g.isEnabled()) {
            this.g.setVisibility(0);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a());
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration((long) i2);
        animatorSet.start();
    }

    public void a(@NonNull bq bqVar, @NonNull View.OnClickListener onClickListener) {
        if (bqVar.dW) {
            setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
            return;
        }
        if (bqVar.dQ) {
            this.h.setOnClickListener(onClickListener);
        } else {
            this.h.setEnabled(false);
        }
        if (bqVar.dV) {
            setOnClickListener(onClickListener);
        } else {
            setOnClickListener(null);
        }
        if (bqVar.dK) {
            this.b.getLeftText().setOnClickListener(onClickListener);
        } else {
            this.b.getLeftText().setOnClickListener(null);
        }
        if (bqVar.dR) {
            this.b.getRightBorderedView().setOnClickListener(onClickListener);
        } else {
            this.b.getRightBorderedView().setOnClickListener(null);
        }
        if (bqVar.dM) {
            this.i.setOnClickListener(onClickListener);
        } else {
            this.i.setOnClickListener(null);
        }
        if (bqVar.dL) {
            this.a.setOnClickListener(onClickListener);
        } else {
            this.a.setOnClickListener(null);
        }
        if (bqVar.dO) {
            this.e.setOnClickListener(onClickListener);
        } else {
            this.e.setOnClickListener(null);
        }
        if (bqVar.dP) {
            this.f.setOnClickListener(onClickListener);
        } else {
            this.f.setOnClickListener(null);
        }
        if (bqVar.dT) {
            this.g.setOnClickListener(onClickListener);
        } else {
            this.g.setOnClickListener(null);
        }
    }

    public void a(View... viewArr) {
        if (getVisibility() == 0) {
            a(0, viewArr);
        }
    }

    public void b(View... viewArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.h, View.SCALE_Y, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.h, View.SCALE_X, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.i, View.SCALE_Y, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.i, View.SCALE_X, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.a, View.ALPHA, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.c, View.ALPHA, 1.0f));
        if (this.d.isEnabled()) {
            arrayList.add(ObjectAnimator.ofFloat(this.d, View.ALPHA, 0.0f));
        }
        arrayList.add(ObjectAnimator.ofFloat(this, View.ALPHA, 1.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.b, View.TRANSLATION_X, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.d, View.TRANSLATION_X, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.g, View.TRANSLATION_X, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.a, View.TRANSLATION_X, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.c, View.TRANSLATION_X, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.h, View.TRANSLATION_Y, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.i, View.TRANSLATION_Y, 0.0f));
        for (View view : viewArr) {
            arrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f));
        }
        if (!TextUtils.isEmpty(this.c.getText().toString())) {
            this.c.setVisibility(0);
        }
        this.a.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new n(this));
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    public void initView() {
        setBackgroundColor(1711276032);
        this.a.setTextColor(-2236963);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setTextColor(-6710887);
        this.g.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(1, -3355444);
        this.c.setPadding(this.j.L(4), this.j.L(4), this.j.L(4), this.j.L(4));
        this.c.setBackgroundDrawable(gradientDrawable);
        this.c.setTextSize(2, 12.0f);
        this.c.setTextColor(-3355444);
        this.c.setVisibility(8);
        this.d.setOrientation(0);
        this.d.setGravity(16);
        this.d.setVisibility(8);
        this.f.setTextColor(-6710887);
        this.f.setGravity(16);
        this.f.setTextSize(2, 14.0f);
        this.h.setPadding(this.j.L(15), 0, this.j.L(15), 0);
        this.h.setMinimumWidth(this.j.L(100));
        this.h.setTransformationMethod(null);
        this.h.setTextSize(2, 22.0f);
        this.h.setMaxEms(10);
        this.h.setSingleLine();
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        ft rightBorderedView = this.b.getRightBorderedView();
        rightBorderedView.e(1, -7829368);
        rightBorderedView.setPadding(this.j.L(2), 0, 0, 0);
        rightBorderedView.setTextColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
        rightBorderedView.a(1, MediaAdView.COLOR_PLACEHOLDER_GRAY, this.j.L(3));
        rightBorderedView.setBackgroundColor(1711276032);
        this.e.setStarSize(this.j.L(12));
        this.d.addView(this.e);
        this.d.addView(this.f);
        this.d.setVisibility(8);
        this.g.setVisibility(8);
        addView(this.b);
        addView(this.d);
        addView(this.g);
        addView(this.a);
        addView(this.c);
        addView(this.i);
        addView(this.h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredHeight2 = this.i.getMeasuredHeight();
        int measuredWidth2 = this.i.getMeasuredWidth();
        int i6 = (measuredHeight - measuredHeight2) / 2;
        gc gcVar = this.i;
        int i7 = this.k;
        gcVar.layout(i7, i6, i7 + measuredWidth2, measuredHeight2 + i6);
        int measuredWidth3 = this.h.getMeasuredWidth();
        int measuredHeight3 = this.h.getMeasuredHeight();
        int i8 = (measuredHeight - measuredHeight3) / 2;
        int i9 = this.k;
        this.h.layout((measuredWidth - measuredWidth3) - i9, i8, measuredWidth - i9, measuredHeight3 + i8);
        int i10 = this.k;
        int i11 = measuredWidth2 + i10 + i10;
        gd gdVar = this.b;
        gdVar.layout(i11, this.m, gdVar.getMeasuredWidth() + i11, this.b.getMeasuredHeight() + this.m);
        this.d.layout(i11, this.b.getBottom(), this.d.getMeasuredWidth() + i11, this.d.getMeasuredHeight() + this.b.getBottom());
        this.g.layout(i11, this.b.getBottom(), this.g.getMeasuredWidth() + i11, this.g.getMeasuredHeight() + this.b.getBottom());
        this.a.layout(i11, this.b.getBottom(), this.a.getMeasuredWidth() + i11, this.a.getMeasuredHeight() + this.b.getBottom());
        this.c.layout(i11, this.a.getBottom(), this.c.getMeasuredWidth() + i11, this.c.getMeasuredHeight() + this.a.getBottom());
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int i4 = size - (this.k * 2);
        int size2 = (View.MeasureSpec.getSize(i3) / 4) - (this.m * 2);
        int min = Math.min(size2, this.l);
        this.i.measure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), View.MeasureSpec.makeMeasureSpec(min, 1073741824));
        this.h.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(min - (this.m * 2), 1073741824));
        int measuredWidth = ((i4 - this.i.getMeasuredWidth()) - this.h.getMeasuredWidth()) - (this.k * 2);
        this.b.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        this.d.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        this.g.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        this.a.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2 - this.b.getMeasuredHeight(), Integer.MIN_VALUE));
        this.c.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        int max = (this.m * 2) + Math.max(this.a.getMeasuredHeight(), this.d.getMeasuredHeight()) + this.b.getMeasuredHeight();
        if (this.c.getVisibility() == 0) {
            max += this.c.getMeasuredHeight();
        }
        setMeasuredDimension(size, (this.m * 2) + Math.max(this.h.getMeasuredHeight(), Math.max(this.i.getMeasuredHeight(), max)));
    }

    public void setBanner(@NonNull ce ceVar) {
        this.b.getLeftText().setText(ceVar.getTitle());
        this.a.setText(ceVar.getDescription());
        String disclaimer = ceVar.getDisclaimer();
        if (!TextUtils.isEmpty(disclaimer)) {
            this.c.setVisibility(0);
            this.c.setText(disclaimer);
        } else {
            this.c.setVisibility(8);
        }
        ImageData icon = ceVar.getIcon();
        if (icon != null) {
            this.i.setVisibility(0);
            this.i.setImageData(icon);
        } else {
            this.i.setVisibility(8);
        }
        this.h.setText(ceVar.getCtaText());
        if (!"".equals(ceVar.getAgeRestrictions())) {
            this.b.getRightBorderedView().setText(ceVar.getAgeRestrictions());
        } else {
            this.b.getRightBorderedView().setVisibility(8);
        }
        io.a(this.h, -16733198, -16746839, this.j.L(2));
        this.h.setTextColor(-1);
        if ("store".equals(ceVar.getNavigationType())) {
            if (ceVar.getVotes() == 0 || ceVar.getRating() <= 0.0f) {
                this.d.setEnabled(false);
                this.d.setVisibility(8);
            } else {
                this.d.setEnabled(true);
                this.e.setRating(ceVar.getRating());
                this.f.setText(String.valueOf(ceVar.getVotes()));
            }
            this.g.setEnabled(false);
        } else {
            String domain = ceVar.getDomain();
            if (!TextUtils.isEmpty(domain)) {
                this.g.setEnabled(true);
                this.g.setText(domain);
            } else {
                this.g.setEnabled(false);
                this.g.setVisibility(8);
            }
            this.d.setEnabled(false);
        }
        if (ceVar.getVideoBanner() == null || !ceVar.getVideoBanner().isAutoPlay()) {
            this.d.setVisibility(8);
            this.g.setVisibility(8);
        }
    }
}
