package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
public class NativeImageAdView extends u<bb> {
    private Button a;
    private ImageView b;
    private MediaView c;

    public NativeImageAdView(Context context) {
        super(context);
    }

    public final Button a() {
        return this.a;
    }

    public final ImageView b() {
        return this.b;
    }

    public final MediaView c() {
        return this.c;
    }

    public void setFeedbackView(Button button) {
        this.a = button;
    }

    public void setImageView(ImageView imageView) {
        this.b = imageView;
    }

    public void setMediaView(MediaView mediaView) {
        this.c = mediaView;
    }

    public NativeImageAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeImageAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
