package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
public class DebugOverlayImageOriginListener implements ImageOriginListener {
    public int a = 1;

    public int getImageOrigin() {
        return this.a;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String str, int i, boolean z, String str2) {
        this.a = i;
    }
}
