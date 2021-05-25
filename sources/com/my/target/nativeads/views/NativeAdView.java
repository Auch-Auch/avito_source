package com.my.target.nativeads.views;

import a2.l.a.v.a.a;
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
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.banners.NativePromoCard;
import com.my.target.nativeads.factories.NativeViewsFactory;
import com.my.target.nativeads.views.PromoCardRecyclerView;
import java.util.ArrayList;
public class NativeAdView extends ViewGroup {
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
    public final TextView f;
    @NonNull
    public final StarsRatingView g;
    @NonNull
    public final TextView h;
    @NonNull
    public final Button i;
    @NonNull
    public final TextView j;
    @NonNull
    public final LinearLayout k;
    @NonNull
    public final LinearLayout l;
    @NonNull
    public final LinearLayout m;
    @Nullable
    public MediaAdView n;
    @Nullable
    public PromoCardRecyclerView o;
    @Nullable
    public PromoCardRecyclerView.PromoCardAdapter p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final boolean w;

    public NativeAdView(@NonNull Context context) {
        this(context, null);
    }

    public NativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, false);
    }

    public NativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2);
        View view;
        this.w = z;
        ft ftVar = new ft(context);
        this.a = ftVar;
        TextView textView = new TextView(context);
        this.b = textView;
        IconAdView iconAdView = NativeViewsFactory.getIconAdView(context);
        this.c = iconAdView;
        TextView textView2 = new TextView(context);
        this.d = textView2;
        TextView textView3 = new TextView(context);
        this.e = textView3;
        TextView textView4 = new TextView(context);
        this.f = textView4;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.g = starsRatingView;
        TextView textView5 = new TextView(context);
        this.h = textView5;
        TextView textView6 = new TextView(context);
        this.j = textView6;
        Button button = new Button(context);
        this.i = button;
        io af = io.af(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.k = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.l = linearLayout2;
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.m = linearLayout3;
        setId(R.id.nativeads_ad_view);
        textView.setId(R.id.nativeads_advertising);
        textView2.setId(R.id.nativeads_title);
        textView4.setId(R.id.nativeads_description);
        int i3 = R.id.nativeads_rating;
        starsRatingView.setId(i3);
        textView3.setId(R.id.nativeads_domain);
        textView6.setId(R.id.nativeads_disclaimer);
        button.setId(R.id.nativeads_call_to_action);
        iconAdView.setId(R.id.nativeads_icon);
        int i4 = R.id.nativeads_age_restrictions;
        ftVar.setId(i4);
        textView5.setId(R.id.nativeads_votes);
        starsRatingView.setId(i3);
        io.a(textView5, "votes_text");
        int L = af.L(4);
        setPadding(L, L, L, af.L(8));
        this.r = af.L(8);
        int L2 = af.L(9);
        this.t = L2;
        this.s = af.L(54);
        int L3 = af.L(12);
        this.u = L3;
        int L4 = af.L(10);
        this.q = af.L(40);
        int L5 = af.L(4);
        this.v = L5;
        ftVar.setId(i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(1, -13421773);
        int L6 = af.L(2);
        ftVar.setBackgroundDrawable(gradientDrawable);
        ftVar.setGravity(17);
        ftVar.setPadding(L6, 0, 0, 0);
        button.setPadding(L4, 0, L4, 0);
        button.setMaxEms(8);
        button.setLines(1);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setTransformationMethod(null);
        io.a(this, -1, -3806472);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        gradientDrawable2.setStroke(af.o(1.5f), -16748844);
        gradientDrawable2.setCornerRadius((float) af.L(1));
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-3806472, -3806472});
        gradientDrawable3.setStroke(af.o(1.5f), -16748844);
        gradientDrawable3.setCornerRadius((float) af.L(1));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable3);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable2);
        button.setBackgroundDrawable(stateListDrawable);
        setClickable(true);
        Context context2 = getContext();
        if (z) {
            PromoCardRecyclerView promoCardRecyclerView = NativeViewsFactory.getPromoCardRecyclerView(context2);
            this.o = promoCardRecyclerView;
            promoCardRecyclerView.setId(R.id.nativeads_media_view);
            view = this.o;
        } else {
            MediaAdView mediaAdView = NativeViewsFactory.getMediaAdView(context2);
            this.n = mediaAdView;
            mediaAdView.setId(R.id.nativeads_media_view);
            view = this.n;
        }
        addView(view);
        addView(iconAdView);
        addView(button);
        addView(linearLayout);
        addView(linearLayout2);
        linearLayout2.addView(ftVar);
        linearLayout2.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(textView3);
        linearLayout.addView(linearLayout3);
        linearLayout3.addView(starsRatingView);
        linearLayout3.addView(textView5);
        addView(textView4);
        addView(textView6);
        ftVar.setTextColor(-6710887);
        ftVar.setBackgroundColor(0);
        ftVar.setLines(1);
        ftVar.setEllipsize(TextUtils.TruncateAt.END);
        ftVar.setTextSize(2, 10.0f);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(-6710887);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(L2, 0, 0, 0);
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(null, 1);
        textView2.setLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextColor(-6710887);
        textView3.setTextSize(2, 14.0f);
        textView3.setLines(1);
        textView3.setIncludeFontPadding(false);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView4.setTextSize(2, 15.0f);
        textView4.setMaxLines(3);
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        textView5.setTextColor(-6710887);
        textView5.setTextSize(2, 12.0f);
        textView5.setLines(1);
        textView5.setEllipsize(TextUtils.TruncateAt.END);
        textView5.setPadding(L5, 0, 0, 0);
        textView6.setTextColor(-6710887);
        textView6.setTextSize(2, 12.0f);
        textView6.setMaxLines(2);
        textView6.setEllipsize(TextUtils.TruncateAt.END);
        button.setTextColor(-16748844);
        button.setLines(1);
        button.setTextSize(2, 16.0f);
        button.setEllipsize(TextUtils.TruncateAt.END);
        starsRatingView.setStarSize(L3);
        linearLayout.setOrientation(1);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        il.fc();
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
        return this.i;
    }

    @NonNull
    public TextView getDescriptionTextView() {
        return this.f;
    }

    @NonNull
    public TextView getDisclaimerTextView() {
        return this.j;
    }

    @NonNull
    public TextView getDomainOrCategoryTextView() {
        return this.e;
    }

    @NonNull
    public IconAdView getIconImageView() {
        return this.c;
    }

    @Nullable
    public MediaAdView getMediaAdView() {
        return this.n;
    }

    @Nullable
    public PromoCardRecyclerView getPromoCardRecyclerView() {
        return this.o;
    }

    @NonNull
    public StarsRatingView getStarsRatingView() {
        return this.g;
    }

    @NonNull
    public TextView getTitleTextView() {
        return this.d;
    }

    @NonNull
    public TextView getVotesTextView() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        PromoCardRecyclerView promoCardRecyclerView;
        int paddingLeft = getPaddingLeft();
        io.b(this.l, getPaddingTop(), paddingLeft);
        int c2 = io.c(this.c.getMeasuredHeight(), this.k.getMeasuredHeight());
        int bottom = this.l.getBottom() + this.v;
        io.b(this.c, ((c2 - this.c.getMeasuredHeight()) / 2) + bottom, paddingLeft);
        io.b(this.k, ((c2 - this.k.getMeasuredHeight()) / 2) + bottom, io.c(this.c.getRight() + this.v, paddingLeft));
        int i6 = bottom + c2;
        int i7 = this.r + i6;
        if (!this.w || (promoCardRecyclerView = this.o) == null) {
            io.b(this.n, i7, paddingLeft);
            int c3 = io.c(this.f.getMeasuredHeight(), this.i.getMeasuredHeight());
            MediaAdView mediaAdView = this.n;
            if (mediaAdView != null) {
                i7 = mediaAdView.getBottom();
            }
            int paddingBottom = getPaddingBottom() + i7;
            io.b(this.f, ((c3 - this.f.getMeasuredHeight()) / 2) + paddingBottom, paddingLeft);
            io.c(this.i, ((c3 - this.i.getMeasuredHeight()) / 2) + paddingBottom, getMeasuredWidth() - getPaddingRight());
            io.b(this.j, paddingBottom + c3 + this.r, paddingLeft);
            return;
        }
        io.b(promoCardRecyclerView, i6 + this.v, paddingLeft);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        PromoCardRecyclerView promoCardRecyclerView;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        io.b(this.l, paddingLeft - this.t, paddingTop, Integer.MIN_VALUE);
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.s, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.s, Integer.MIN_VALUE));
        io.b(this.k, (paddingLeft - this.c.getMeasuredWidth()) - this.v, (paddingTop - this.l.getMeasuredHeight()) - this.r, Integer.MIN_VALUE);
        int i6 = 0;
        if (!this.w || (promoCardRecyclerView = this.o) == null) {
            MediaAdView mediaAdView = this.n;
            if (mediaAdView != null) {
                mediaAdView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE));
                this.i.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.q, 1073741824));
                io.b(this.f, (paddingLeft - this.i.getMeasuredWidth()) - this.v, paddingTop, Integer.MIN_VALUE);
                io.b(this.j, paddingLeft, paddingTop, Integer.MIN_VALUE);
                size2 = getPaddingBottom() + getPaddingTop() + io.c(this.f.getMeasuredHeight(), this.i.getMeasuredHeight()) + getPaddingBottom() + this.n.getMeasuredHeight() + io.c(this.k.getMeasuredHeight(), this.c.getMeasuredHeight()) + this.l.getMeasuredHeight() + this.v + this.r;
                if (this.j.getVisibility() == 0) {
                    i6 = this.j.getMeasuredHeight();
                }
                if (i6 > 0) {
                    i4 = size2 + i6;
                    i5 = this.r;
                }
            }
            setMeasuredDimension(size, size2);
        }
        promoCardRecyclerView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE));
        i5 = getPaddingTop() + this.o.getMeasuredHeight() + io.c(this.k.getMeasuredHeight(), this.c.getMeasuredHeight()) + this.l.getMeasuredHeight() + this.v;
        i4 = getPaddingBottom();
        size2 = i4 + i5;
        setMeasuredDimension(size, size2);
    }

    public void setupView(@Nullable NativePromoBanner nativePromoBanner) {
        if (nativePromoBanner != null) {
            ae.a("Setup banner");
            if (nativePromoBanner.getIcon() != null) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            if (!this.w || this.o == null) {
                a(nativePromoBanner.getCtaText(), this.i);
            } else {
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                PromoCardRecyclerView promoCardRecyclerView = this.o;
                ArrayList<NativePromoCard> cards = nativePromoBanner.getCards();
                if (this.p == null) {
                    this.p = new a(this);
                }
                this.p.setCards(cards);
                promoCardRecyclerView.setPromoCardAdapter(this.p);
            }
            if ("web".equals(nativePromoBanner.getNavigationType())) {
                if (!this.w) {
                    this.g.setVisibility(8);
                    this.h.setVisibility(8);
                    a(nativePromoBanner.getDomain(), this.e);
                }
            } else if ("store".equals(nativePromoBanner.getNavigationType())) {
                String category = nativePromoBanner.getCategory();
                String subCategory = nativePromoBanner.getSubCategory();
                String str = "";
                if (!TextUtils.isEmpty(category)) {
                    str = a2.b.a.a.a.c3(str, category);
                    if (!TextUtils.isEmpty(subCategory)) {
                        str = a2.b.a.a.a.c3(str, ", ");
                    }
                }
                if (!TextUtils.isEmpty(subCategory)) {
                    str = a2.b.a.a.a.c3(str, subCategory);
                }
                io.a(this.e, "category_text");
                a(str, this.e);
                if (nativePromoBanner.getRating() > 0.0f && nativePromoBanner.getRating() <= 5.0f) {
                    this.g.setVisibility(0);
                    if (nativePromoBanner.getVotes() > 0) {
                        a(String.valueOf(nativePromoBanner.getVotes()), this.h);
                    } else {
                        this.h.setVisibility(8);
                    }
                    this.g.setRating(nativePromoBanner.getRating());
                }
            }
            a(nativePromoBanner.getDisclaimer(), this.j);
            a(nativePromoBanner.getTitle(), this.d);
            a(nativePromoBanner.getDescription(), this.f);
            a(nativePromoBanner.getAdvertisingLabel(), this.b);
            a(nativePromoBanner.getAgeRestrictions(), this.a);
        }
    }
}
