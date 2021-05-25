package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
public class ImagePerfImageOriginListener implements ImageOriginListener {
    public final ImagePerfState a;
    public final ImagePerfMonitor b;

    public ImagePerfImageOriginListener(ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.a = imagePerfState;
        this.b = imagePerfMonitor;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String str, int i, boolean z, String str2) {
        this.a.setImageOrigin(i);
        this.a.setUltimateProducerName(str2);
        this.b.notifyStatusUpdated(this.a, 1);
    }
}
