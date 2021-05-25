package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
public class ImagePerfRequestListener extends BaseRequestListener {
    public final MonotonicClock a;
    public final ImagePerfState b;

    public ImagePerfRequestListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState) {
        this.a = monotonicClock;
        this.b = imagePerfState;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String str) {
        this.b.setImageRequestEndTimeMs(this.a.now());
        this.b.setRequestId(str);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.b.setImageRequestEndTimeMs(this.a.now());
        this.b.setImageRequest(imageRequest);
        this.b.setRequestId(str);
        this.b.setPrefetch(z);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.b.setImageRequestStartTimeMs(this.a.now());
        this.b.setImageRequest(imageRequest);
        this.b.setCallerContext(obj);
        this.b.setRequestId(str);
        this.b.setPrefetch(z);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        this.b.setImageRequestEndTimeMs(this.a.now());
        this.b.setImageRequest(imageRequest);
        this.b.setRequestId(str);
        this.b.setPrefetch(z);
    }
}
