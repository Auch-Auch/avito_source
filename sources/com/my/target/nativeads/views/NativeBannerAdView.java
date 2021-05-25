package com.my.target.nativeads.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.my.target.R;
import com.my.target.ae;
import com.my.target.common.views.StarsRatingView;
import com.my.target.ft;
import com.my.target.il;
import com.my.target.io;
import com.my.target.nativeads.banners.NativeBanner;
public class NativeBannerAdView extends ViewGroup {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull
    public final IconAdView c;
    @NonNull
    public final TextView d;
    @NonNull
    public final TextView e;
    @NonNull
    public final StarsRatingView f;
    @NonNull
    public final TextView g;
    @NonNull
    public final Button h;
    @NonNull
    public final TextView i;
    @NonNull
    public final LinearLayout j;
    @NonNull
    public final LinearLayout k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;

    public NativeBannerAdView(@NonNull Context context) {
        this(context, null);
    }

    public NativeBannerAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeBannerAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ft ftVar = new ft(context);
        this.a = ftVar;
        TextView textView = new TextView(context);
        this.b = textView;
        IconAdView iconAdView = new IconAdView(context);
        this.c = iconAdView;
        TextView textView2 = new TextView(context);
        this.d = textView2;
        TextView textView3 = new TextView(context);
        this.e = textView3;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.f = starsRatingView;
        TextView textView4 = new TextView(context);
        this.g = textView4;
        TextView textView5 = new TextView(context);
        this.i = textView5;
        Button button = new Button(context);
        this.h = button;
        LinearLayout linearLayout = new LinearLayout(context);
        this.j = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.k = linearLayout2;
        LinearLayout linearLayout3 = new LinearLayout(context);
        io af = io.af(context);
        setId(R.id.nativeads_ad_view);
        ftVar.setId(R.id.nativeads_age_restrictions);
        textView.setId(R.id.nativeads_advertising);
        iconAdView.setId(R.id.nativeads_icon);
        textView2.setId(R.id.nativeads_title);
        textView3.setId(R.id.nativeads_domain);
        starsRatingView.setId(R.id.nativeads_rating);
        textView4.setId(R.id.nativeads_votes);
        textView5.setId(R.id.nativeads_disclaimer);
        button.setId(R.id.nativeads_call_to_action);
        io.a(textView4, "votes_text");
        int L = af.L(4);
        setPadding(L, L, L, L);
        this.m = af.L(2);
        int L2 = af.L(4);
        this.p = L2;
        this.o = af.L(54);
        this.q = af.L(20);
        int L3 = af.L(12);
        int L4 = af.L(10);
        this.l = af.L(40);
        this.n = af.L(4);
        button.setPadding(L4, 0, L4, 0);
        button.setTransformationMethod(null);
        button.setMaxEms(8);
        button.setLines(1);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setTextColor(-16748844);
        button.setTextSize(2, 16.0f);
        io.a(this, -1, -3806472);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        gradientDrawable.setStroke(af.o(1.5f), -16748844);
        gradientDrawable.setCornerRadius((float) af.L(2));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-3806472, -3806472});
        gradientDrawable2.setStroke(af.o(1.5f), -16748844);
        gradientDrawable2.setCornerRadius((float) af.L(2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
        button.setBackground(stateListDrawable);
        setClickable(true);
        ftVar.setTextColor(-6710887);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(1, -13421773);
        int L5 = af.L(2);
        ftVar.setBackgroundDrawable(gradientDrawable3);
        ftVar.setGravity(17);
        ftVar.setPadding(L5, 0, 0, 0);
        ftVar.setBackgroundColor(0);
        ftVar.setMaxEms(10);
        ftVar.setLines(1);
        ftVar.setTextSize(2, 10.0f);
        textView.setTextSize(2, 10.0f);
        textView.setTextColor(-6710887);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(L2, 0, 0, 0);
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(null, 1);
        textView2.setMaxLines(2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextColor(-6710887);
        textView3.setTextSize(2, 14.0f);
        textView3.setLines(1);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setIncludeFontPadding(false);
        textView4.setTextColor(-6710887);
        textView4.setTextSize(2, 12.0f);
        textView4.setLines(1);
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        textView4.setPadding(af.L(4), 0, 0, 0);
        textView5.setTextColor(-6710887);
        textView5.setTextSize(2, 12.0f);
        textView5.setMaxLines(2);
        textView5.setEllipsize(TextUtils.TruncateAt.END);
        starsRatingView.setStarSize(L3);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        addView(iconAdView);
        addView(button);
        addView(linearLayout);
        addView(linearLayout2);
        linearLayout2.addView(ftVar);
        linearLayout2.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(linearLayout3);
        linearLayout.addView(textView5);
        linearLayout3.addView(textView3);
        linearLayout3.addView(starsRatingView);
        linearLayout3.addView(textView4);
        il.fd();
    }

    public final void a(@Nullable String str, @NonNull TextView textView) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    @NonNull
    public TextView getAdvertisingTextView() {
        return this.b;
    }

    @NonNull
    public TextView getAgeRestrictionTextView() {
        return this.a;
    }

    @NonNull
    public Button getCtaButtonView() {
        return this.h;
    }

    @NonNull
    public TextView getDisclaimerTextView() {
        return this.i;
    }

    @NonNull
    public TextView getDomainTextView() {
        return this.e;
    }

    @NonNull
    public IconAdView getIconImageView() {
        return this.c;
    }

    @NonNull
    public StarsRatingView getStarsRatingView() {
        return this.f;
    }

    @NonNull
    public TextView getTitleTextView() {
        return this.d;
    }

    @NonNull
    public TextView getVotesTextView() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        io.b(this.k, paddingTop, paddingLeft);
        int c2 = io.c(this.c.getMeasuredHeight(), this.j.getMeasuredHeight(), this.h.getMeasuredHeight());
        int bottom = this.k.getBottom() + this.n;
        int measuredHeight = this.k.getMeasuredHeight() + ((io.c(this.c.getMeasuredHeight(), this.j.getMeasuredHeight()) - this.h.getMeasuredHeight()) / 2);
        int i6 = this.q;
        if (measuredHeight < i6) {
            bottom = paddingTop + i6;
        }
        io.b(this.c, ((c2 - this.c.getMeasuredHeight()) / 2) + bottom, paddingLeft);
        io.c(this.h, ((c2 - this.h.getMeasuredHeight()) / 2) + bottom, getMeasuredWidth() - getPaddingRight());
        io.b(this.j, ((c2 - this.j.getMeasuredHeight()) / 2) + bottom, io.c(this.c.getRight() + this.n, paddingLeft));
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        io.b(this.k, paddingLeft - this.p, paddingTop, Integer.MIN_VALUE);
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.o, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.o, Integer.MIN_VALUE));
        this.h.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
        io.b(this.j, ((paddingLeft - this.c.getMeasuredWidth()) - this.h.getMeasuredWidth()) - (this.n * 2), (paddingTop - this.k.getMeasuredHeight()) - this.m, Integer.MIN_VALUE);
        int measuredHeight = this.k.getMeasuredHeight() + this.n;
        int measuredHeight2 = this.k.getMeasuredHeight() + ((io.c(this.c.getMeasuredHeight(), this.j.getMeasuredHeight()) - this.h.getMeasuredHeight()) / 2);
        int i4 = this.q;
        if (measuredHeight2 < i4) {
            measuredHeight = i4;
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + io.c(this.j.getMeasuredHeight(), this.c.getMeasuredHeight(), this.h.getMeasuredHeight()) + measuredHeight);
    }

    public void setupView(@Nullable NativeBanner nativeBanner) {
        if (nativeBanner != null) {
            ae.a("Setup banner");
            if (nativeBanner.getIcon() != null) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            if ("web".equals(nativeBanner.getNavigationType())) {
                a(nativeBanner.getDomain(), this.e);
                this.f.setVisibility(8);
                this.g.setVisibility(8);
            } else if ("store".equals(nativeBanner.getNavigationType())) {
                if (nativeBanner.getRating() <= 0.0f || nativeBanner.getRating() > 5.0f) {
                    this.f.setVisibility(8);
                } else {
                    this.f.setRating(nativeBanner.getRating());
                    this.f.setVisibility(0);
                    a(String.valueOf(nativeBanner.getVotes()), this.g);
                    this.e.setVisibility(8);
                    if (nativeBanner.getVotes() > 0) {
                        this.g.setVisibility(0);
                    } else {
                        this.g.setVisibility(8);
                    }
                    io.a(this.g, "votes_text");
                }
            }
            a(nativeBanner.getTitle(), this.d);
            a(nativeBanner.getAdvertisingLabel(), this.b);
            a(nativeBanner.getCtaText(), this.h);
            a(nativeBanner.getAgeRestrictions(), this.a);
            a(nativeBanner.getDisclaimer(), this.i);
        }
    }
}
