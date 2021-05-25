package com.facebook.drawee.backends.pipeline.info;

import java.util.Collection;
public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    public final Collection<ImagePerfDataListener> a;

    public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> collection) {
        this.a = collection;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener
    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, int i) {
        for (ImagePerfDataListener imagePerfDataListener : this.a) {
            imagePerfDataListener.onImageLoadStatusUpdated(imagePerfData, i);
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener
    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, int i) {
        for (ImagePerfDataListener imagePerfDataListener : this.a) {
            imagePerfDataListener.onImageVisibilityUpdated(imagePerfData, i);
        }
    }
}
