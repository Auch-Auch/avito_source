package com.facebook.imagepipeline.request;

import a2.b.a.a.a;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
public class ImageRequestBuilder {
    public Uri a = null;
    public ImageRequest.RequestLevel b = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    public ResizeOptions c = null;
    @Nullable
    public RotationOptions d = null;
    public ImageDecodeOptions e = ImageDecodeOptions.defaults();
    public ImageRequest.CacheChoice f = ImageRequest.CacheChoice.DEFAULT;
    public boolean g = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
    public boolean h = false;
    public Priority i = Priority.HIGH;
    @Nullable
    public Postprocessor j = null;
    public boolean k = true;
    public boolean l = true;
    @Nullable
    public Boolean m = null;
    @Nullable
    public RequestListener n;
    @Nullable
    public BytesRange o = null;
    @Nullable
    public Boolean p = null;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super(a.c3("Invalid request builder: ", str));
        }
    }

    public static ImageRequestBuilder fromRequest(ImageRequest imageRequest) {
        return newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions()).setShouldDecodePrefetches(imageRequest.shouldDecodePrefetches());
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int i2) {
        return newBuilderWithSource(UriUtil.getUriForResourceId(i2));
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        return new ImageRequestBuilder().setSource(uri);
    }

    public ImageRequest build() {
        validate();
        return new ImageRequest(this);
    }

    public ImageRequestBuilder disableDiskCache() {
        this.k = false;
        return this;
    }

    public ImageRequestBuilder disableMemoryCache() {
        this.l = false;
        return this;
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.o;
    }

    public ImageRequest.CacheChoice getCacheChoice() {
        return this.f;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.e;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.b;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.j;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.n;
    }

    public Priority getRequestPriority() {
        return this.i;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.c;
    }

    @Nullable
    public Boolean getResizingAllowedOverride() {
        return this.p;
    }

    @Nullable
    public RotationOptions getRotationOptions() {
        return this.d;
    }

    public Uri getSourceUri() {
        return this.a;
    }

    public boolean isDiskCacheEnabled() {
        return this.k && UriUtil.isNetworkUri(this.a);
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.h;
    }

    public boolean isMemoryCacheEnabled() {
        return this.l;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.g;
    }

    @Deprecated
    public ImageRequestBuilder setAutoRotateEnabled(boolean z) {
        if (z) {
            return setRotationOptions(RotationOptions.autoRotate());
        }
        return setRotationOptions(RotationOptions.disableRotation());
    }

    public ImageRequestBuilder setBytesRange(@Nullable BytesRange bytesRange) {
        this.o = bytesRange;
        return this;
    }

    public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice cacheChoice) {
        this.f = cacheChoice;
        return this;
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions imageDecodeOptions) {
        this.e = imageDecodeOptions;
        return this;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel requestLevel) {
        this.b = requestLevel;
        return this;
    }

    public ImageRequestBuilder setPostprocessor(@Nullable Postprocessor postprocessor) {
        this.j = postprocessor;
        return this;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean z) {
        this.g = z;
        return this;
    }

    public ImageRequestBuilder setRequestListener(RequestListener requestListener) {
        this.n = requestListener;
        return this;
    }

    public ImageRequestBuilder setRequestPriority(Priority priority) {
        this.i = priority;
        return this;
    }

    public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions resizeOptions) {
        this.c = resizeOptions;
        return this;
    }

    public ImageRequestBuilder setResizingAllowedOverride(@Nullable Boolean bool) {
        this.p = bool;
        return this;
    }

    public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions rotationOptions) {
        this.d = rotationOptions;
        return this;
    }

    public ImageRequestBuilder setShouldDecodePrefetches(@Nullable Boolean bool) {
        this.m = bool;
        return this;
    }

    public ImageRequestBuilder setSource(Uri uri) {
        Preconditions.checkNotNull(uri);
        this.a = uri;
        return this;
    }

    @Nullable
    public Boolean shouldDecodePrefetches() {
        return this.m;
    }

    public void validate() {
        Uri uri = this.a;
        if (uri != null) {
            if (UriUtil.isLocalResourceUri(uri)) {
                if (!this.a.isAbsolute()) {
                    throw new BuilderException("Resource URI path must be absolute.");
                } else if (!this.a.getPath().isEmpty()) {
                    try {
                        Integer.parseInt(this.a.getPath().substring(1));
                    } catch (NumberFormatException unused) {
                        throw new BuilderException("Resource URI path must be a resource id.");
                    }
                } else {
                    throw new BuilderException("Resource URI must not be empty");
                }
            }
            if (UriUtil.isLocalAssetUri(this.a) && !this.a.isAbsolute()) {
                throw new BuilderException("Asset URI path must be absolute.");
            }
            return;
        }
        throw new BuilderException("Source must be set!");
    }
}
