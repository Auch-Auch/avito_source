package ru.sravni.android.bankproduct.utils.svg;

import android.content.res.Resources;
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
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
public final class GlideOptions extends RequestOptions implements Cloneable {
    public static GlideOptions I;
    public static GlideOptions J;
    public static GlideOptions K;
    public static GlideOptions L;
    public static GlideOptions M;
    public static GlideOptions N;

    @NonNull
    @CheckResult
    public static GlideOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        return new GlideOptions().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static GlideOptions centerCropTransform() {
        if (K == null) {
            K = new GlideOptions().centerCrop().autoClone();
        }
        return K;
    }

    @NonNull
    @CheckResult
    public static GlideOptions centerInsideTransform() {
        if (J == null) {
            J = new GlideOptions().centerInside().autoClone();
        }
        return J;
    }

    @NonNull
    @CheckResult
    public static GlideOptions circleCropTransform() {
        if (L == null) {
            L = new GlideOptions().circleCrop().autoClone();
        }
        return L;
    }

    @NonNull
    @CheckResult
    public static GlideOptions decodeTypeOf(@NonNull Class<?> cls) {
        return new GlideOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static GlideOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static GlideOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static GlideOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static GlideOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i) {
        return new GlideOptions().encodeQuality(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions errorOf(@Nullable Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static GlideOptions fitCenterTransform() {
        if (I == null) {
            I = new GlideOptions().fitCenter().autoClone();
        }
        return I;
    }

    @NonNull
    @CheckResult
    public static GlideOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static GlideOptions frameOf(@IntRange(from = 0) long j) {
        return new GlideOptions().frame(j);
    }

    @NonNull
    @CheckResult
    public static GlideOptions noAnimation() {
        if (N == null) {
            N = new GlideOptions().dontAnimate().autoClone();
        }
        return N;
    }

    @NonNull
    @CheckResult
    public static GlideOptions noTransformation() {
        if (M == null) {
            M = new GlideOptions().dontTransform().autoClone();
        }
        return M;
    }

    @NonNull
    @CheckResult
    public static <T> GlideOptions option(@NonNull Option<T> option, @NonNull T t) {
        return new GlideOptions().set((Option<Option<T>>) option, (Option<T>) t);
    }

    @NonNull
    @CheckResult
    public static GlideOptions overrideOf(int i, int i2) {
        return new GlideOptions().override(i, i2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions placeholderOf(@Nullable Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static GlideOptions priorityOf(@NonNull Priority priority) {
        return new GlideOptions().priority(priority);
    }

    @NonNull
    @CheckResult
    public static GlideOptions signatureOf(@NonNull Key key) {
        return new GlideOptions().signature(key);
    }

    @NonNull
    @CheckResult
    public static GlideOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    @NonNull
    @CheckResult
    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    @NonNull
    @CheckResult
    public static GlideOptions timeoutOf(@IntRange(from = 0) int i) {
        return new GlideOptions().timeout(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions errorOf(@DrawableRes int i) {
        return new GlideOptions().error(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions overrideOf(int i) {
        return new GlideOptions().override(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions placeholderOf(@DrawableRes int i) {
        return new GlideOptions().placeholder(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (GlideOptions) super.apply(baseRequestOptions);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    public RequestOptions autoClone() {
        return (GlideOptions) super.autoClone();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions centerCrop() {
        return (GlideOptions) super.centerCrop();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions centerInside() {
        return (GlideOptions) super.centerInside();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions circleCrop() {
        return (GlideOptions) super.circleCrop();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions decode(@NonNull Class<?> cls) {
        return (GlideOptions) super.decode(cls);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions disallowHardwareConfig() {
        return (GlideOptions) super.disallowHardwareConfig();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.diskCacheStrategy(diskCacheStrategy);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions dontAnimate() {
        return (GlideOptions) super.dontAnimate();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions dontTransform() {
        return (GlideOptions) super.dontTransform();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.downsample(downsampleStrategy);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (GlideOptions) super.encodeFormat(compressFormat);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions encodeQuality(@IntRange(from = 0, to = 100) int i) {
        return (GlideOptions) super.encodeQuality(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions fitCenter() {
        return (GlideOptions) super.fitCenter();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions format(@NonNull DecodeFormat decodeFormat) {
        return (GlideOptions) super.format(decodeFormat);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions frame(@IntRange(from = 0) long j) {
        return (GlideOptions) super.frame(j);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    public RequestOptions lock() {
        return (GlideOptions) super.lock();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions onlyRetrieveFromCache(boolean z) {
        return (GlideOptions) super.onlyRetrieveFromCache(z);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions optionalCenterCrop() {
        return (GlideOptions) super.optionalCenterCrop();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions optionalCenterInside() {
        return (GlideOptions) super.optionalCenterInside();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions optionalCircleCrop() {
        return (GlideOptions) super.optionalCircleCrop();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions optionalFitCenter() {
        return (GlideOptions) super.optionalFitCenter();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions priority(@NonNull Priority priority) {
        return (GlideOptions) super.priority(priority);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public <Y> RequestOptions set(@NonNull Option<Y> option, @NonNull Y y) {
        return (GlideOptions) super.set((Option<Option<Y>>) option, (Option<Y>) y);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions signature(@NonNull Key key) {
        return (GlideOptions) super.signature(key);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (GlideOptions) super.sizeMultiplier(f);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions skipMemoryCache(boolean z) {
        return (GlideOptions) super.skipMemoryCache(z);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions theme(@Nullable Resources.Theme theme) {
        return (GlideOptions) super.theme(theme);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions timeout(@IntRange(from = 0) int i) {
        return (GlideOptions) super.timeout(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    public final RequestOptions transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transforms(transformationArr);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions useAnimationPool(boolean z) {
        return (GlideOptions) super.useAnimationPool(z);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideOptions) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions, java.lang.Object
    @CheckResult
    public GlideOptions clone() {
        return (GlideOptions) super.clone();
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions error(@Nullable Drawable drawable) {
        return (GlideOptions) super.error(drawable);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions fallback(@Nullable Drawable drawable) {
        return (GlideOptions) super.fallback(drawable);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (GlideOptions) super.optionalTransform(transformation);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions override(int i, int i2) {
        return (GlideOptions) super.override(i, i2);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions placeholder(@Nullable Drawable drawable) {
        return (GlideOptions) super.placeholder(drawable);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions error(@DrawableRes int i) {
        return (GlideOptions) super.error(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions fallback(@DrawableRes int i) {
        return (GlideOptions) super.fallback(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public <Y> RequestOptions optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (GlideOptions) super.optionalTransform((Class) cls, (Transformation) transformation);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions override(int i) {
        return (GlideOptions) super.override(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions placeholder(@DrawableRes int i) {
        return (GlideOptions) super.placeholder(i);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestOptions transform(@NonNull Transformation<Bitmap> transformation) {
        return (GlideOptions) super.transform(transformation);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    public final RequestOptions transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transform(transformationArr);
    }

    /* Return type fixed from 'ru.sravni.android.bankproduct.utils.svg.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public <Y> RequestOptions transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (GlideOptions) super.transform((Class) cls, (Transformation) transformation);
    }
}
