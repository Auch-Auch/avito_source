package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Fn;
import com.facebook.common.internal.Objects;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
public class ImageRequest {
    public static final Fn<ImageRequest, Uri> REQUEST_TO_URI_FN = new a();
    public final CacheChoice a;
    public final Uri b;
    public final int c;
    public File d;
    public final boolean e;
    public final boolean f;
    public final ImageDecodeOptions g;
    @Nullable
    public final ResizeOptions h;
    public final RotationOptions i;
    @Nullable
    public final BytesRange j;
    public final Priority k;
    public final RequestLevel l;
    public final boolean m;
    public final boolean n;
    @Nullable
    public final Boolean o;
    @Nullable
    public final Postprocessor p;
    @Nullable
    public final RequestListener q;
    @Nullable
    public final Boolean r;

    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        public int a;

        /* access modifiers changed from: public */
        RequestLevel(int i) {
            this.a = i;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }

        public int getValue() {
            return this.a;
        }
    }

    public static class a implements Fn<ImageRequest, Uri> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.common.internal.Fn
        @Nullable
        public Uri apply(@Nullable ImageRequest imageRequest) {
            ImageRequest imageRequest2 = imageRequest;
            if (imageRequest2 != null) {
                return imageRequest2.getSourceUri();
            }
            return null;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        RotationOptions rotationOptions;
        this.a = imageRequestBuilder.getCacheChoice();
        Uri sourceUri = imageRequestBuilder.getSourceUri();
        this.b = sourceUri;
        int i2 = -1;
        if (sourceUri != null) {
            if (UriUtil.isNetworkUri(sourceUri)) {
                i2 = 0;
            } else if (UriUtil.isLocalFileUri(sourceUri)) {
                i2 = MediaUtils.isVideo(MediaUtils.extractMime(sourceUri.getPath())) ? 2 : 3;
            } else if (UriUtil.isLocalContentUri(sourceUri)) {
                i2 = 4;
            } else if (UriUtil.isLocalAssetUri(sourceUri)) {
                i2 = 5;
            } else if (UriUtil.isLocalResourceUri(sourceUri)) {
                i2 = 6;
            } else if (UriUtil.isDataUri(sourceUri)) {
                i2 = 7;
            } else if (UriUtil.isQualifiedResourceUri(sourceUri)) {
                i2 = 8;
            }
        }
        this.c = i2;
        this.e = imageRequestBuilder.isProgressiveRenderingEnabled();
        this.f = imageRequestBuilder.isLocalThumbnailPreviewsEnabled();
        this.g = imageRequestBuilder.getImageDecodeOptions();
        this.h = imageRequestBuilder.getResizeOptions();
        if (imageRequestBuilder.getRotationOptions() == null) {
            rotationOptions = RotationOptions.autoRotate();
        } else {
            rotationOptions = imageRequestBuilder.getRotationOptions();
        }
        this.i = rotationOptions;
        this.j = imageRequestBuilder.getBytesRange();
        this.k = imageRequestBuilder.getRequestPriority();
        this.l = imageRequestBuilder.getLowestPermittedRequestLevel();
        this.m = imageRequestBuilder.isDiskCacheEnabled();
        this.n = imageRequestBuilder.isMemoryCacheEnabled();
        this.o = imageRequestBuilder.shouldDecodePrefetches();
        this.p = imageRequestBuilder.getPostprocessor();
        this.q = imageRequestBuilder.getRequestListener();
        this.r = imageRequestBuilder.getResizingAllowedOverride();
    }

    @Nullable
    public static ImageRequest fromFile(@Nullable File file) {
        if (file == null) {
            return null;
        }
        return fromUri(UriUtil.getUriForFile(file));
    }

    @Nullable
    public static ImageRequest fromUri(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.newBuilderWithSource(uri).build();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (this.f != imageRequest.f || this.m != imageRequest.m || this.n != imageRequest.n || !Objects.equal(this.b, imageRequest.b) || !Objects.equal(this.a, imageRequest.a) || !Objects.equal(this.d, imageRequest.d) || !Objects.equal(this.j, imageRequest.j) || !Objects.equal(this.g, imageRequest.g) || !Objects.equal(this.h, imageRequest.h) || !Objects.equal(this.k, imageRequest.k) || !Objects.equal(this.l, imageRequest.l) || !Objects.equal(this.o, imageRequest.o) || !Objects.equal(this.r, imageRequest.r) || !Objects.equal(this.i, imageRequest.i)) {
            return false;
        }
        Postprocessor postprocessor = this.p;
        CacheKey cacheKey = null;
        CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        Postprocessor postprocessor2 = imageRequest.p;
        if (postprocessor2 != null) {
            cacheKey = postprocessor2.getPostprocessorCacheKey();
        }
        return Objects.equal(postprocessorCacheKey, cacheKey);
    }

    @Deprecated
    public boolean getAutoRotateEnabled() {
        return this.i.useImageMetadata();
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.j;
    }

    public CacheChoice getCacheChoice() {
        return this.a;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.g;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        return this.f;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.l;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.p;
    }

    public int getPreferredHeight() {
        ResizeOptions resizeOptions = this.h;
        if (resizeOptions != null) {
            return resizeOptions.height;
        }
        return 2048;
    }

    public int getPreferredWidth() {
        ResizeOptions resizeOptions = this.h;
        if (resizeOptions != null) {
            return resizeOptions.width;
        }
        return 2048;
    }

    public Priority getPriority() {
        return this.k;
    }

    public boolean getProgressiveRenderingEnabled() {
        return this.e;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.q;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.h;
    }

    @Nullable
    public Boolean getResizingAllowedOverride() {
        return this.r;
    }

    public RotationOptions getRotationOptions() {
        return this.i;
    }

    public synchronized File getSourceFile() {
        if (this.d == null) {
            this.d = new File(this.b.getPath());
        }
        return this.d;
    }

    public Uri getSourceUri() {
        return this.b;
    }

    public int getSourceUriType() {
        return this.c;
    }

    public int hashCode() {
        Postprocessor postprocessor = this.p;
        return Objects.hashCode(this.a, this.b, Boolean.valueOf(this.f), this.j, this.k, this.l, Boolean.valueOf(this.m), Boolean.valueOf(this.n), this.g, this.o, this.h, this.i, postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null, this.r);
    }

    public boolean isDiskCacheEnabled() {
        return this.m;
    }

    public boolean isMemoryCacheEnabled() {
        return this.n;
    }

    @Nullable
    public Boolean shouldDecodePrefetches() {
        return this.o;
    }

    public String toString() {
        return Objects.toStringHelper(this).add(ShareConstants.MEDIA_URI, this.b).add("cacheChoice", this.a).add("decodeOptions", this.g).add("postprocessor", this.p).add(Constants.FirelogAnalytics.PARAM_PRIORITY, this.k).add("resizeOptions", this.h).add("rotationOptions", this.i).add("bytesRange", this.j).add("resizingAllowedOverride", this.r).add("progressiveRenderingEnabled", this.e).add("localThumbnailPreviewsEnabled", this.f).add("lowestPermittedRequestLevel", this.l).add("isDiskCacheEnabled", this.m).add("isMemoryCacheEnabled", this.n).add("decodePrefetches", this.o).toString();
    }

    @Nullable
    public static ImageRequest fromUri(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return fromUri(Uri.parse(str));
    }
}
