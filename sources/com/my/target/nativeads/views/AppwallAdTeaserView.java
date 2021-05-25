package com.my.target.nativeads.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.views.StarsRatingView;
import com.my.target.gc;
import com.my.target.io;
import com.my.target.nativeads.banners.NativeAppwallBanner;
public class AppwallAdTeaserView extends RelativeLayout {
    @NonNull
    public final io a;
    public final int b;
    @NonNull
    public final gc c;
    @NonNull
    public final gc d;
    @NonNull
    public final gc e;
    @NonNull
    public final TextView f;
    @NonNull
    public final LinearLayout g;
    @NonNull
    public final ShapeDrawable h;
    @NonNull
    public final TextView i;
    @NonNull
    public final StarsRatingView j;
    @NonNull
    public final TextView k;
    @NonNull
    public final gc l;
    @NonNull
    public final TextView m;
    @NonNull
    public final gc n;
    @Nullable
    public NativeAppwallBanner o;
    public boolean p = false;

    public AppwallAdTeaserView(Context context) {
        super(context);
        int rgb = Color.rgb(36, 36, 36);
        this.b = rgb;
        gc gcVar = new gc(context);
        this.e = gcVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        TextView textView = new TextView(context);
        this.f = textView;
        gc gcVar2 = new gc(context);
        this.n = gcVar2;
        gc gcVar3 = new gc(context);
        this.d = gcVar3;
        gc gcVar4 = new gc(context);
        this.l = gcVar4;
        TextView textView2 = new TextView(context);
        this.m = textView2;
        TextView textView3 = new TextView(context);
        this.i = textView3;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.j = starsRatingView;
        TextView textView4 = new TextView(context);
        this.k = textView4;
        gc gcVar5 = new gc(context);
        this.c = gcVar5;
        io af = io.af(context);
        this.a = af;
        float L = (float) af.L(6);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{L, L, L, L, L, L, L, L}, null, null));
        this.h = shapeDrawable;
        int L2 = af.L(18);
        int L3 = af.L(14);
        int L4 = af.L(53);
        int fh = io.fh();
        int fh2 = io.fh();
        int fh3 = io.fh();
        setBackgroundColor(-1);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(L4 + L3 + L3, L4 + L2 + L2);
        gcVar.setPadding(L3, L2, L3, L2);
        addView(gcVar, layoutParams);
        int L5 = af.L(20);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(L5, L5);
        layoutParams2.leftMargin = af.L(57);
        layoutParams2.topMargin = af.L(10);
        gcVar5.setLayoutParams(layoutParams2);
        addView(gcVar5);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(L4, L4);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = L3;
        layoutParams3.topMargin = L2;
        linearLayout.setBackgroundDrawable(shapeDrawable);
        linearLayout.setOrientation(1);
        addView(linearLayout, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        textView.setTypeface(Typeface.SANS_SERIF);
        textView.setPadding(0, af.L(10), 0, af.L(2));
        textView.setTextSize(2, 13.0f);
        textView.setGravity(49);
        linearLayout.addView(textView, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(af.L(20), af.L(20));
        layoutParams5.gravity = 1;
        linearLayout.addView(gcVar2, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(af.L(19), -2);
        layoutParams6.addRule(15);
        layoutParams6.addRule(11);
        layoutParams6.rightMargin = af.L(30);
        addView(gcVar3, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(L4, L4);
        layoutParams7.addRule(10);
        layoutParams7.addRule(11);
        addView(gcVar4, layoutParams7);
        textView2.setTypeface(Typeface.SANS_SERIF);
        textView2.setTextSize(2, 18.0f);
        textView2.setTextColor(rgb);
        textView2.setPadding(0, 0, af.L(67), 0);
        textView2.setId(fh3);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams8.leftMargin = af.L(91);
        layoutParams8.rightMargin = af.L(15);
        layoutParams8.topMargin = af.L(13);
        textView2.setLayoutParams(layoutParams8);
        addView(textView2);
        textView3.setTypeface(Typeface.SANS_SERIF);
        textView3.setTextSize(2, 13.0f);
        textView3.setTextColor(rgb);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams9.leftMargin = af.L(91);
        layoutParams9.addRule(3, fh3);
        textView3.setId(fh);
        textView3.setLayoutParams(layoutParams9);
        addView(textView3);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(3, fh);
        layoutParams10.leftMargin = af.L(91);
        layoutParams10.topMargin = af.L(5);
        starsRatingView.setPadding(0, 0, 0, af.L(20));
        starsRatingView.setStarsPadding((float) af.L(2));
        starsRatingView.setStarSize(af.L(12));
        starsRatingView.setId(fh2);
        addView(starsRatingView, layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(1, fh2);
        layoutParams11.addRule(3, fh);
        layoutParams11.leftMargin = af.L(9);
        textView4.setTypeface(Typeface.SANS_SERIF);
        textView4.setPadding(0, af.L(2), 0, 0);
        textView4.setTextSize(2, 13.0f);
        textView4.setTextColor(rgb);
        textView4.setGravity(16);
        addView(textView4, layoutParams11);
    }

    @Nullable
    public NativeAppwallBanner getBanner() {
        return this.o;
    }

    @NonNull
    public ImageView getBannerIconImageView() {
        return this.e;
    }

    @NonNull
    public TextView getCoinsCountTextView() {
        return this.f;
    }

    @NonNull
    public ImageView getCoinsIconImageView() {
        return this.n;
    }

    @NonNull
    public TextView getDescriptionTextView() {
        return this.i;
    }

    @NonNull
    public ImageView getNotificationImageView() {
        return this.c;
    }

    @NonNull
    public ImageView getOpenImageView() {
        return this.d;
    }

    @NonNull
    public StarsRatingView getStarsRatingView() {
        return this.j;
    }

    @NonNull
    public ImageView getStatusIconImageView() {
        return this.l;
    }

    @NonNull
    public TextView getTitleTextView() {
        return this.m;
    }

    @NonNull
    public TextView getVotesCountTextView() {
        return this.k;
    }

    public boolean isViewed() {
        return this.p;
    }

    public void removeNotification() {
        removeView(this.c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNativeAppwallBanner(com.my.target.nativeads.banners.NativeAppwallBanner r9) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.nativeads.views.AppwallAdTeaserView.setNativeAppwallBanner(com.my.target.nativeads.banners.NativeAppwallBanner):void");
    }

    public void setViewed(boolean z) {
        this.p = z;
    }
}
