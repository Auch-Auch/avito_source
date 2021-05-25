package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {
    public int a = 100;
    public int b = Integer.MAX_VALUE;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Bitmap.Config g = Bitmap.Config.ARGB_8888;
    @Nullable
    public ImageDecoder h;
    @Nullable
    public BitmapTransformation i;
    @Nullable
    public ColorSpace j;

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }

    public Bitmap.Config getBitmapConfig() {
        return this.g;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.i;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        return this.j;
    }

    @Nullable
    public ImageDecoder getCustomImageDecoder() {
        return this.h;
    }

    public boolean getDecodeAllFrames() {
        return this.e;
    }

    public boolean getDecodePreviewFrame() {
        return this.c;
    }

    public boolean getForceStaticImage() {
        return this.f;
    }

    public int getMaxDimensionPx() {
        return this.b;
    }

    public int getMinDecodeIntervalMs() {
        return this.a;
    }

    public T getThis() {
        return this;
    }

    public boolean getUseLastFrameForPreview() {
        return this.d;
    }

    public T setBitmapConfig(Bitmap.Config config) {
        this.g = config;
        return getThis();
    }

    public T setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        this.i = bitmapTransformation;
        return getThis();
    }

    public T setColorSpace(ColorSpace colorSpace) {
        this.j = colorSpace;
        return getThis();
    }

    public T setCustomImageDecoder(@Nullable ImageDecoder imageDecoder) {
        this.h = imageDecoder;
        return getThis();
    }

    public T setDecodeAllFrames(boolean z) {
        this.e = z;
        return getThis();
    }

    public T setDecodePreviewFrame(boolean z) {
        this.c = z;
        return getThis();
    }

    public T setForceStaticImage(boolean z) {
        this.f = z;
        return getThis();
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        this.a = imageDecodeOptions.minDecodeIntervalMs;
        this.b = imageDecodeOptions.maxDimensionPx;
        this.c = imageDecodeOptions.decodePreviewFrame;
        this.d = imageDecodeOptions.useLastFrameForPreview;
        this.e = imageDecodeOptions.decodeAllFrames;
        this.f = imageDecodeOptions.forceStaticImage;
        this.g = imageDecodeOptions.bitmapConfig;
        this.h = imageDecodeOptions.customImageDecoder;
        this.i = imageDecodeOptions.bitmapTransformation;
        this.j = imageDecodeOptions.colorSpace;
        return getThis();
    }

    public T setMaxDimensionPx(int i2) {
        this.b = i2;
        return getThis();
    }

    public T setMinDecodeIntervalMs(int i2) {
        this.a = i2;
        return getThis();
    }

    public T setUseLastFrameForPreview(boolean z) {
        this.d = z;
        return getThis();
    }
}
