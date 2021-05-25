package com.avito.android.connection_quality;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;", "Lcom/facebook/imagepipeline/listener/BaseRequestListener;", "Lcom/facebook/imagepipeline/request/ImageRequest;", "request", "", "callerContext", "", "requestId", "", "isPrefetch", "", "onRequestStart", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Ljava/lang/String;Z)V", "onRequestCancellation", "(Ljava/lang/String;)V", "", "throwable", "onRequestFailure", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/String;Ljava/lang/Throwable;Z)V", "onRequestSuccess", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/String;Z)V", "Lcom/avito/android/connection_quality/BandwidthSampler;", AuthSource.SEND_ABUSE, "Lcom/avito/android/connection_quality/BandwidthSampler;", "sampler", "<init>", "(Lcom/avito/android/connection_quality/BandwidthSampler;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class BandwidthSamplerRequestListener extends BaseRequestListener {
    public final BandwidthSampler a;

    public BandwidthSamplerRequestListener(@NotNull BandwidthSampler bandwidthSampler) {
        Intrinsics.checkNotNullParameter(bandwidthSampler, "sampler");
        this.a = bandwidthSampler;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        this.a.stopSampling();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(@NotNull ImageRequest imageRequest, @NotNull String str, @Nullable Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(str, "requestId");
        this.a.stopSampling();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(@NotNull ImageRequest imageRequest, @Nullable Object obj, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(str, "requestId");
        this.a.startSampling();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(@NotNull ImageRequest imageRequest, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(str, "requestId");
        this.a.stopSampling();
    }
}
