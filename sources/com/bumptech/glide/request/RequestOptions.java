package com.bumptech.glide.request;

import android.graphics.Bitmap;
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
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    @Nullable
    public static RequestOptions A;
    @Nullable
    public static RequestOptions B;
    @Nullable
    public static RequestOptions C;
    @Nullable
    public static RequestOptions D;
    @Nullable
    public static RequestOptions E;
    @Nullable
    public static RequestOptions F;
    @Nullable
    public static RequestOptions G;
    @Nullable
    public static RequestOptions H;

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        return (RequestOptions) new RequestOptions().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerCropTransform() {
        if (E == null) {
            E = (RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).autoClone();
        }
        return E;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerInsideTransform() {
        if (D == null) {
            D = (RequestOptions) ((RequestOptions) new RequestOptions().centerInside()).autoClone();
        }
        return D;
    }

    @NonNull
    @CheckResult
    public static RequestOptions circleCropTransform() {
        if (F == null) {
            F = (RequestOptions) ((RequestOptions) new RequestOptions().circleCrop()).autoClone();
        }
        return F;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        return (RequestOptions) new RequestOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return (RequestOptions) new RequestOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return (RequestOptions) new RequestOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i) {
        return (RequestOptions) new RequestOptions().encodeQuality(i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        return (RequestOptions) new RequestOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions fitCenterTransform() {
        if (C == null) {
            C = (RequestOptions) ((RequestOptions) new RequestOptions().fitCenter()).autoClone();
        }
        return C;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return (RequestOptions) new RequestOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long j) {
        return (RequestOptions) new RequestOptions().frame(j);
    }

    @NonNull
    @CheckResult
    public static RequestOptions noAnimation() {
        if (H == null) {
            H = (RequestOptions) ((RequestOptions) new RequestOptions().dontAnimate()).autoClone();
        }
        return H;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noTransformation() {
        if (G == null) {
            G = (RequestOptions) ((RequestOptions) new RequestOptions().dontTransform()).autoClone();
        }
        return G;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t) {
        return (RequestOptions) new RequestOptions().set(option, t);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(int i, int i2) {
        return (RequestOptions) new RequestOptions().override(i, i2);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        return (RequestOptions) new RequestOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        return (RequestOptions) new RequestOptions().priority(priority);
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key key) {
        return (RequestOptions) new RequestOptions().signature(key);
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (RequestOptions) new RequestOptions().sizeMultiplier(f);
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (A == null) {
                A = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(true)).autoClone();
            }
            return A;
        }
        if (B == null) {
            B = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(false)).autoClone();
        }
        return B;
    }

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i) {
        return (RequestOptions) new RequestOptions().timeout(i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int i) {
        return (RequestOptions) new RequestOptions().error(i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int i) {
        return (RequestOptions) new RequestOptions().placeholder(i);
    }
}
