package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    public int a;
    public float b = 1.0f;
    @NonNull
    public DiskCacheStrategy c = DiskCacheStrategy.AUTOMATIC;
    @NonNull
    public Priority d = Priority.NORMAL;
    @Nullable
    public Drawable e;
    public int f;
    @Nullable
    public Drawable g;
    public int h;
    public boolean i = true;
    public int j = -1;
    public int k = -1;
    @NonNull
    public Key l = EmptySignature.obtain();
    public boolean m;
    public boolean n = true;
    @Nullable
    public Drawable o;
    public int p;
    @NonNull
    public Options q = new Options();
    @NonNull
    public Map<Class<?>, Transformation<?>> r = new CachedHashCodeArrayMap();
    @NonNull
    public Class<?> s = Object.class;
    public boolean t;
    @Nullable
    public Resources.Theme u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public boolean z;

    public static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final boolean a(int i2) {
        return b(this.a, i2);
    }

    @NonNull
    @CheckResult
    public T apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.v) {
            return (T) clone().apply(baseRequestOptions);
        }
        if (b(baseRequestOptions.a, 2)) {
            this.b = baseRequestOptions.b;
        }
        if (b(baseRequestOptions.a, 262144)) {
            this.w = baseRequestOptions.w;
        }
        if (b(baseRequestOptions.a, 1048576)) {
            this.z = baseRequestOptions.z;
        }
        if (b(baseRequestOptions.a, 4)) {
            this.c = baseRequestOptions.c;
        }
        if (b(baseRequestOptions.a, 8)) {
            this.d = baseRequestOptions.d;
        }
        if (b(baseRequestOptions.a, 16)) {
            this.e = baseRequestOptions.e;
            this.f = 0;
            this.a &= -33;
        }
        if (b(baseRequestOptions.a, 32)) {
            this.f = baseRequestOptions.f;
            this.e = null;
            this.a &= -17;
        }
        if (b(baseRequestOptions.a, 64)) {
            this.g = baseRequestOptions.g;
            this.h = 0;
            this.a &= -129;
        }
        if (b(baseRequestOptions.a, 128)) {
            this.h = baseRequestOptions.h;
            this.g = null;
            this.a &= -65;
        }
        if (b(baseRequestOptions.a, 256)) {
            this.i = baseRequestOptions.i;
        }
        if (b(baseRequestOptions.a, 512)) {
            this.k = baseRequestOptions.k;
            this.j = baseRequestOptions.j;
        }
        if (b(baseRequestOptions.a, 1024)) {
            this.l = baseRequestOptions.l;
        }
        if (b(baseRequestOptions.a, 4096)) {
            this.s = baseRequestOptions.s;
        }
        if (b(baseRequestOptions.a, 8192)) {
            this.o = baseRequestOptions.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (b(baseRequestOptions.a, 16384)) {
            this.p = baseRequestOptions.p;
            this.o = null;
            this.a &= -8193;
        }
        if (b(baseRequestOptions.a, 32768)) {
            this.u = baseRequestOptions.u;
        }
        if (b(baseRequestOptions.a, 65536)) {
            this.n = baseRequestOptions.n;
        }
        if (b(baseRequestOptions.a, 131072)) {
            this.m = baseRequestOptions.m;
        }
        if (b(baseRequestOptions.a, 2048)) {
            this.r.putAll(baseRequestOptions.r);
            this.y = baseRequestOptions.y;
        }
        if (b(baseRequestOptions.a, 524288)) {
            this.x = baseRequestOptions.x;
        }
        if (!this.n) {
            this.r.clear();
            int i2 = this.a & -2049;
            this.a = i2;
            this.m = false;
            this.a = i2 & -131073;
            this.y = true;
        }
        this.a |= baseRequestOptions.a;
        this.q.putAll(baseRequestOptions.q);
        d();
        return this;
    }

    @NonNull
    public T autoClone() {
        if (!this.t || this.v) {
            this.v = true;
            return lock();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    @NonNull
    public final T c(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.v) {
            return (T) clone().c(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return e(transformation, false);
    }

    @NonNull
    @CheckResult
    public T centerCrop() {
        return f(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T centerInside() {
        T f2 = f(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
        f2.y = true;
        return f2;
    }

    @NonNull
    @CheckResult
    public T circleCrop() {
        return f(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    @NonNull
    public final T d() {
        if (!this.t) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    @CheckResult
    public T decode(@NonNull Class<?> cls) {
        if (this.v) {
            return (T) clone().decode(cls);
        }
        this.s = (Class) Preconditions.checkNotNull(cls);
        this.a |= 4096;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T disallowHardwareConfig() {
        return set((Option<Y>) Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.v) {
            return (T) clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.c = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.a |= 4;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T dontAnimate() {
        return set((Option<Y>) GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public T dontTransform() {
        if (this.v) {
            return (T) clone().dontTransform();
        }
        this.r.clear();
        int i2 = this.a & -2049;
        this.a = i2;
        this.m = false;
        int i3 = i2 & -131073;
        this.a = i3;
        this.n = false;
        this.a = i3 | 65536;
        this.y = true;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return set((Option<Y>) DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bumptech.glide.load.Transformation<android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T e(@NonNull Transformation<Bitmap> transformation, boolean z2) {
        if (this.v) {
            return (T) clone().e(transformation, z2);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z2);
        g(Bitmap.class, transformation, z2);
        g(Drawable.class, drawableTransformation, z2);
        g(BitmapDrawable.class, (Transformation<Y>) drawableTransformation.asBitmapDrawable(), z2);
        g(GifDrawable.class, new GifDrawableTransformation(transformation), z2);
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return set((Option<Y>) BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    @NonNull
    @CheckResult
    public T encodeQuality(@IntRange(from = 0, to = 100) int i2) {
        return set((Option<Y>) BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i2));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.b, this.b) == 0 && this.f == baseRequestOptions.f && Util.bothNullOrEqual(this.e, baseRequestOptions.e) && this.h == baseRequestOptions.h && Util.bothNullOrEqual(this.g, baseRequestOptions.g) && this.p == baseRequestOptions.p && Util.bothNullOrEqual(this.o, baseRequestOptions.o) && this.i == baseRequestOptions.i && this.j == baseRequestOptions.j && this.k == baseRequestOptions.k && this.m == baseRequestOptions.m && this.n == baseRequestOptions.n && this.w == baseRequestOptions.w && this.x == baseRequestOptions.x && this.c.equals(baseRequestOptions.c) && this.d == baseRequestOptions.d && this.q.equals(baseRequestOptions.q) && this.r.equals(baseRequestOptions.r) && this.s.equals(baseRequestOptions.s) && Util.bothNullOrEqual(this.l, baseRequestOptions.l) && Util.bothNullOrEqual(this.u, baseRequestOptions.u)) {
            return true;
        }
        return false;
    }

    @NonNull
    @CheckResult
    public T error(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().error(drawable);
        }
        this.e = drawable;
        int i2 = this.a | 16;
        this.a = i2;
        this.f = 0;
        this.a = i2 & -33;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public final T f(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.v) {
            return (T) clone().f(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    @NonNull
    @CheckResult
    public T fallback(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().fallback(drawable);
        }
        this.o = drawable;
        int i2 = this.a | 8192;
        this.a = i2;
        this.p = 0;
        this.a = i2 & -16385;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T fitCenter() {
        T f2 = f(DownsampleStrategy.FIT_CENTER, new FitCenter());
        f2.y = true;
        return f2;
    }

    @NonNull
    @CheckResult
    public T format(@NonNull DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return (T) set((Option<Y>) Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    @NonNull
    @CheckResult
    public T frame(@IntRange(from = 0) long j2) {
        return set((Option<Y>) VideoDecoder.TARGET_FRAME, Long.valueOf(j2));
    }

    @NonNull
    public <Y> T g(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation, boolean z2) {
        if (this.v) {
            return (T) clone().g(cls, transformation, z2);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.r.put(cls, transformation);
        int i2 = this.a | 2048;
        this.a = i2;
        this.n = true;
        int i3 = i2 | 65536;
        this.a = i3;
        this.y = false;
        if (z2) {
            this.a = i3 | 131072;
            this.m = true;
        }
        d();
        return this;
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.c;
    }

    public final int getErrorId() {
        return this.f;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.e;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.o;
    }

    public final int getFallbackId() {
        return this.p;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.x;
    }

    @NonNull
    public final Options getOptions() {
        return this.q;
    }

    public final int getOverrideHeight() {
        return this.j;
    }

    public final int getOverrideWidth() {
        return this.k;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.g;
    }

    public final int getPlaceholderId() {
        return this.h;
    }

    @NonNull
    public final Priority getPriority() {
        return this.d;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.s;
    }

    @NonNull
    public final Key getSignature() {
        return this.l;
    }

    public final float getSizeMultiplier() {
        return this.b;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.u;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.r;
    }

    public final boolean getUseAnimationPool() {
        return this.z;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.w;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Util.hashCode(this.u, Util.hashCode(this.l, Util.hashCode(this.s, Util.hashCode(this.r, Util.hashCode(this.q, Util.hashCode(this.d, Util.hashCode(this.c, Util.hashCode(this.x, Util.hashCode(this.w, Util.hashCode(this.n, Util.hashCode(this.m, Util.hashCode(this.k, Util.hashCode(this.j, Util.hashCode(this.i, Util.hashCode(this.o, Util.hashCode(this.p, Util.hashCode(this.g, Util.hashCode(this.h, Util.hashCode(this.e, Util.hashCode(this.f, Util.hashCode(this.b)))))))))))))))))))));
    }

    public boolean isAutoCloneEnabled() {
        return this.v;
    }

    public final boolean isDiskCacheStrategySet() {
        return a(4);
    }

    public final boolean isLocked() {
        return this.t;
    }

    public final boolean isMemoryCacheable() {
        return this.i;
    }

    public final boolean isPrioritySet() {
        return a(8);
    }

    public final boolean isSkipMemoryCacheSet() {
        return a(256);
    }

    public final boolean isTransformationAllowed() {
        return this.n;
    }

    public final boolean isTransformationRequired() {
        return this.m;
    }

    public final boolean isTransformationSet() {
        return a(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.k, this.j);
    }

    @NonNull
    public T lock() {
        this.t = true;
        return this;
    }

    @NonNull
    @CheckResult
    public T onlyRetrieveFromCache(boolean z2) {
        if (this.v) {
            return (T) clone().onlyRetrieveFromCache(z2);
        }
        this.x = z2;
        this.a |= 524288;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T optionalCenterCrop() {
        return c(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T optionalCenterInside() {
        T c2 = c(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
        c2.y = true;
        return c2;
    }

    @NonNull
    @CheckResult
    public T optionalCircleCrop() {
        return c(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public T optionalFitCenter() {
        T c2 = c(DownsampleStrategy.FIT_CENTER, new FitCenter());
        c2.y = true;
        return c2;
    }

    @NonNull
    @CheckResult
    public T optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return e(transformation, false);
    }

    @NonNull
    @CheckResult
    public T override(int i2, int i3) {
        if (this.v) {
            return (T) clone().override(i2, i3);
        }
        this.k = i2;
        this.j = i3;
        this.a |= 512;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T placeholder(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().placeholder(drawable);
        }
        this.g = drawable;
        int i2 = this.a | 64;
        this.a = i2;
        this.h = 0;
        this.a = i2 & -129;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T priority(@NonNull Priority priority) {
        if (this.v) {
            return (T) clone().priority(priority);
        }
        this.d = (Priority) Preconditions.checkNotNull(priority);
        this.a |= 8;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public <Y> T set(@NonNull Option<Y> option, @NonNull Y y2) {
        if (this.v) {
            return (T) clone().set(option, y2);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(y2);
        this.q.set(option, y2);
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T signature(@NonNull Key key) {
        if (this.v) {
            return (T) clone().signature(key);
        }
        this.l = (Key) Preconditions.checkNotNull(key);
        this.a |= 1024;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.v) {
            return (T) clone().sizeMultiplier(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f2;
        this.a |= 2;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T skipMemoryCache(boolean z2) {
        if (this.v) {
            return (T) clone().skipMemoryCache(true);
        }
        this.i = !z2;
        this.a |= 256;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T theme(@Nullable Resources.Theme theme) {
        if (this.v) {
            return (T) clone().theme(theme);
        }
        this.u = theme;
        this.a |= 32768;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T timeout(@IntRange(from = 0) int i2) {
        return set((Option<Y>) HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap> transformation) {
        return e(transformation, true);
    }

    @NonNull
    @Deprecated
    @CheckResult
    public T transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return e(new MultiTransformation(transformationArr), true);
    }

    @NonNull
    @CheckResult
    public T useAnimationPool(boolean z2) {
        if (this.v) {
            return (T) clone().useAnimationPool(z2);
        }
        this.z = z2;
        this.a |= 1048576;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean z2) {
        if (this.v) {
            return (T) clone().useUnlimitedSourceGeneratorsPool(z2);
        }
        this.w = z2;
        this.a |= 262144;
        d();
        return this;
    }

    @Override // java.lang.Object
    @CheckResult
    public T clone() {
        try {
            T t2 = (T) ((BaseRequestOptions) super.clone());
            Options options = new Options();
            t2.q = options;
            options.putAll(this.q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t2.r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.r);
            t2.t = false;
            t2.v = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public <Y> T optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return g(cls, transformation, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return e(new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return transform(transformationArr[0]);
        }
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T override(int i2) {
        return override(i2, i2);
    }

    @NonNull
    @CheckResult
    public <Y> T transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return g(cls, transformation, true);
    }

    @NonNull
    @CheckResult
    public T error(@DrawableRes int i2) {
        if (this.v) {
            return (T) clone().error(i2);
        }
        this.f = i2;
        int i3 = this.a | 32;
        this.a = i3;
        this.e = null;
        this.a = i3 & -17;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T fallback(@DrawableRes int i2) {
        if (this.v) {
            return (T) clone().fallback(i2);
        }
        this.p = i2;
        int i3 = this.a | 16384;
        this.a = i3;
        this.o = null;
        this.a = i3 & -8193;
        d();
        return this;
    }

    @NonNull
    @CheckResult
    public T placeholder(@DrawableRes int i2) {
        if (this.v) {
            return (T) clone().placeholder(i2);
        }
        this.h = i2;
        int i3 = this.a | 128;
        this.a = i3;
        this.g = null;
        this.a = i3 & -65;
        d();
        return this;
    }
}
