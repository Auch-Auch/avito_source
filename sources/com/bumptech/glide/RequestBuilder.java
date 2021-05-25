package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable {
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA)).priority(Priority.LOW)).skipMemoryCache(true));
    public final Context A;
    public final RequestManager B;
    public final Class<TranscodeType> C;
    public final Glide D;
    public final GlideContext E;
    @NonNull
    public TransitionOptions<?, ? super TranscodeType> F;
    @Nullable
    public Object G;
    @Nullable
    public List<RequestListener<TranscodeType>> H;
    @Nullable
    public RequestBuilder<TranscodeType> I;
    @Nullable
    public RequestBuilder<TranscodeType> J;
    @Nullable
    public Float K;
    public boolean L;
    public boolean M;
    public boolean N;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Priority.values();
            int[] iArr = new int[4];
            b = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        RequestOptions requestOptions;
        this.L = true;
        this.D = glide;
        this.B = requestManager;
        this.C = cls;
        this.A = context;
        this.F = requestManager.glide.d.getDefaultTransitionOptions(cls);
        this.E = glide.d;
        for (RequestListener<Object> requestListener : requestManager.h) {
            addListener(requestListener);
        }
        synchronized (requestManager) {
            requestOptions = requestManager.i;
        }
        apply((BaseRequestOptions<?>) requestOptions);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(requestListener);
        }
        return this;
    }

    @CheckResult
    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(@NonNull Y y) {
        return (Y) getDownloadOnlyRequest().into((RequestBuilder<File>) y);
    }

    @NonNull
    public RequestBuilder<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.J = requestBuilder;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public final Request h(Object obj, Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        ThumbnailRequestCoordinator thumbnailRequestCoordinator;
        Priority priority2;
        if (this.J != null) {
            ErrorRequestCoordinator errorRequestCoordinator3 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator3;
            errorRequestCoordinator2 = errorRequestCoordinator3;
        } else {
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        RequestBuilder<TranscodeType> requestBuilder = this.I;
        if (requestBuilder != null) {
            if (!this.N) {
                TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.L ? transitionOptions : requestBuilder.F;
                if (requestBuilder.isPrioritySet()) {
                    priority2 = this.I.getPriority();
                } else {
                    priority2 = i(priority);
                }
                int overrideWidth = this.I.getOverrideWidth();
                int overrideHeight = this.I.getOverrideHeight();
                if (Util.isValidDimensions(i, i2) && !this.I.isValidOverride()) {
                    overrideWidth = baseRequestOptions.getOverrideWidth();
                    overrideHeight = baseRequestOptions.getOverrideHeight();
                }
                ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, errorRequestCoordinator2);
                ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = thumbnailRequestCoordinator2;
                Request k = k(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2, executor);
                this.N = true;
                RequestBuilder<TranscodeType> requestBuilder2 = this.I;
                Request h = requestBuilder2.h(obj, target, requestListener, thumbnailRequestCoordinator3, transitionOptions2, priority2, overrideWidth, overrideHeight, requestBuilder2, executor);
                this.N = false;
                thumbnailRequestCoordinator3.setRequests(k, h);
                thumbnailRequestCoordinator = thumbnailRequestCoordinator3;
            } else {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
        } else if (this.K != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator4 = new ThumbnailRequestCoordinator(obj, errorRequestCoordinator2);
            thumbnailRequestCoordinator4.setRequests(k(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator4, transitionOptions, priority, i, i2, executor), k(obj, target, requestListener, baseRequestOptions.clone().sizeMultiplier(this.K.floatValue()), thumbnailRequestCoordinator4, transitionOptions, i(priority), i, i2, executor));
            thumbnailRequestCoordinator = thumbnailRequestCoordinator4;
        } else {
            thumbnailRequestCoordinator = k(obj, target, requestListener, baseRequestOptions, errorRequestCoordinator2, transitionOptions, priority, i, i2, executor);
        }
        if (errorRequestCoordinator == null) {
            return thumbnailRequestCoordinator;
        }
        int overrideWidth2 = this.J.getOverrideWidth();
        int overrideHeight2 = this.J.getOverrideHeight();
        if (Util.isValidDimensions(i, i2) && !this.J.isValidOverride()) {
            overrideWidth2 = baseRequestOptions.getOverrideWidth();
            overrideHeight2 = baseRequestOptions.getOverrideHeight();
        }
        RequestBuilder<TranscodeType> requestBuilder3 = this.J;
        errorRequestCoordinator.setRequests(thumbnailRequestCoordinator, requestBuilder3.h(obj, target, requestListener, errorRequestCoordinator, requestBuilder3.F, requestBuilder3.getPriority(), overrideWidth2, overrideHeight2, this.J, executor));
        return errorRequestCoordinator;
    }

    @NonNull
    public final Priority i(@NonNull Priority priority) {
        int ordinal = priority.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return Priority.IMMEDIATE;
        }
        if (ordinal == 2) {
            return Priority.HIGH;
        }
        if (ordinal == 3) {
            return Priority.NORMAL;
        }
        StringBuilder L2 = a2.b.a.a.a.L("unknown priority: ");
        L2.append(getPriority());
        throw new IllegalArgumentException(L2.toString());
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y y) {
        j(y, null, this, Executors.mainThreadExecutor());
        return y;
    }

    public final <Y extends Target<TranscodeType>> Y j(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.checkNotNull(y);
        if (this.M) {
            Request h = h(new Object(), y, requestListener, null, this.F, baseRequestOptions.getPriority(), baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions, executor);
            Request request = y.getRequest();
            if (h.isEquivalentTo(request)) {
                if (!(!baseRequestOptions.isMemoryCacheable() && request.isComplete())) {
                    if (!((Request) Preconditions.checkNotNull(request)).isRunning()) {
                        request.begin();
                    }
                    return y;
                }
            }
            this.B.clear((Target<?>) y);
            y.setRequest(h);
            RequestManager requestManager = this.B;
            synchronized (requestManager) {
                requestManager.d.track(y);
                requestManager.b.runRequest(h);
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public final Request k(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, Executor executor) {
        Context context = this.A;
        GlideContext glideContext = this.E;
        return SingleRequest.obtain(context, glideContext, obj, this.G, this.C, baseRequestOptions, i, i2, priority, target, requestListener, this.H, requestCoordinator, glideContext.getEngine(), transitionOptions.a, executor);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        this.H = null;
        return addListener(requestListener);
    }

    @NonNull
    public Target<TranscodeType> preload(int i, int i2) {
        return into((RequestBuilder<TranscodeType>) PreloadTarget.obtain(this.B, i, i2));
    }

    @NonNull
    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.I = requestBuilder;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.F = (TransitionOptions) Preconditions.checkNotNull(transitionOptions);
        this.L = false;
        return this;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.checkNotNull(baseRequestOptions);
        return (RequestBuilder) super.apply(baseRequestOptions);
    }

    @CheckResult
    @Deprecated
    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    @NonNull
    public FutureTarget<TranscodeType> submit(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        j(requestFutureTarget, requestFutureTarget, this, Executors.directExecutor());
        return requestFutureTarget;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (requestBuilderArr == null || requestBuilderArr.length == 0) {
            return thumbnail((RequestBuilder) null);
        }
        for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
            RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArr[length];
            if (requestBuilder2 != null) {
                if (requestBuilder == null) {
                    requestBuilder = requestBuilder2;
                } else {
                    requestBuilder = requestBuilder2.thumbnail(requestBuilder);
                }
            }
        }
        return thumbnail(requestBuilder);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions, java.lang.Object
    @CheckResult
    public RequestBuilder<TranscodeType> clone() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.F = requestBuilder.F.clone();
        return requestBuilder;
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> into(@NonNull ImageView imageView) {
        BaseRequestOptions<?> baseRequestOptions;
        Util.assertMainThread();
        Preconditions.checkNotNull(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptions = clone().optionalCenterCrop();
                    break;
                case 2:
                    baseRequestOptions = clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptions = clone().optionalFitCenter();
                    break;
                case 6:
                    baseRequestOptions = clone().optionalCenterInside();
                    break;
            }
            ViewTarget<ImageView, TranscodeType> buildImageViewTarget = this.E.buildImageViewTarget(imageView, this.C);
            j(buildImageViewTarget, null, baseRequestOptions, Executors.mainThreadExecutor());
            return buildImageViewTarget;
        }
        baseRequestOptions = this;
        ViewTarget<ImageView, TranscodeType> buildImageViewTarget = this.E.buildImageViewTarget(imageView, this.C);
        j(buildImageViewTarget, null, baseRequestOptions, Executors.mainThreadExecutor());
        return buildImageViewTarget;
    }

    @NonNull
    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.K = Float.valueOf(f);
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Bitmap bitmap) {
        this.G = bitmap;
        this.M = true;
        return apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Drawable drawable) {
        this.G = drawable;
        this.M = true;
        return apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Uri uri) {
        this.G = uri;
        this.M = true;
        return this;
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable File file) {
        this.G = file;
        this.M = true;
        return this;
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.D, requestBuilder.B, cls, requestBuilder.A);
        this.G = requestBuilder.G;
        this.M = requestBuilder.M;
        apply((BaseRequestOptions<?>) requestBuilder);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable @DrawableRes @RawRes Integer num) {
        this.G = num;
        this.M = true;
        return apply((BaseRequestOptions<?>) RequestOptions.signatureOf(AndroidResourceSignature.obtain(this.A)));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Object obj) {
        this.G = obj;
        this.M = true;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable String str) {
        this.G = str;
        this.M = true;
        return this;
    }

    @CheckResult
    @Deprecated
    public RequestBuilder<TranscodeType> load(@Nullable URL url) {
        this.G = url;
        this.M = true;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable byte[] bArr) {
        this.G = bArr;
        this.M = true;
        RequestBuilder<TranscodeType> apply = !isDiskCacheStrategySet() ? apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)) : this;
        return !apply.isSkipMemoryCacheSet() ? apply.apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true)) : apply;
    }
}
