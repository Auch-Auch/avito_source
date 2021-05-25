package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public final class NativeAppInstallAdView extends u<aq> {
    private TextView a;
    private TextView b;
    private Button c;
    private TextView d;
    private Button e;
    private ImageView f;
    private ImageView g;
    private MediaView h;
    private TextView i;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;

    public NativeAppInstallAdView(Context context) {
        super(context);
    }

    public final TextView a() {
        return this.a;
    }

    public final TextView b() {
        return this.b;
    }

    public final Button c() {
        return this.c;
    }

    public final TextView d() {
        return this.d;
    }

    public final Button e() {
        return this.e;
    }

    public final ImageView f() {
        return this.f;
    }

    public final ImageView g() {
        return this.g;
    }

    public final MediaView h() {
        return this.h;
    }

    public final TextView i() {
        return this.i;
    }

    public final View j() {
        return this.j;
    }

    public final TextView k() {
        return this.k;
    }

    public final TextView l() {
        return this.l;
    }

    public final TextView m() {
        return this.m;
    }

    public final TextView n() {
        return this.n;
    }

    public final void setAgeView(TextView textView) {
        this.a = textView;
    }

    public final void setBodyView(TextView textView) {
        this.b = textView;
    }

    public final void setCallToActionView(Button button) {
        this.c = button;
    }

    public final void setDomainView(TextView textView) {
        this.d = textView;
    }

    public final void setFeedbackView(Button button) {
        this.e = button;
    }

    public final void setIconView(ImageView imageView) {
        this.f = imageView;
    }

    public final void setImageView(ImageView imageView) {
        this.g = imageView;
    }

    public final void setMediaView(MediaView mediaView) {
        this.h = mediaView;
    }

    public final void setPriceView(TextView textView) {
        this.i = textView;
    }

    public final <T extends View & Rating> void setRatingView(T t) {
        this.j = t;
    }

    public final void setReviewCountView(TextView textView) {
        this.k = textView;
    }

    public final void setSponsoredView(TextView textView) {
        this.l = textView;
    }

    public final void setTitleView(TextView textView) {
        this.m = textView;
    }

    public final void setWarningView(TextView textView) {
        this.n = textView;
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.yandex.mobile.ads.nativeads.u
    public final aq getNativeAd() {
        return (aq) super.getNativeAd();
    }

    public NativeAppInstallAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
