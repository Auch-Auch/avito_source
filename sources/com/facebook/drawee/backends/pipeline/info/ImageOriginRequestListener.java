package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import javax.annotation.Nullable;
public class ImageOriginRequestListener extends BaseRequestListener {
    public String a;
    @Nullable
    public final ImageOriginListener b;

    public ImageOriginRequestListener(String str, @Nullable ImageOriginListener imageOriginListener) {
        this.b = imageOriginListener;
        init(str);
    }

    public void init(String str) {
        this.a = str;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String str, String str2, boolean z) {
        ImageOriginListener imageOriginListener = this.b;
        if (imageOriginListener != null) {
            imageOriginListener.onImageLoaded(this.a, ImageOriginUtils.mapProducerNameToImageOrigin(str2), z, str2);
        }
    }
}
