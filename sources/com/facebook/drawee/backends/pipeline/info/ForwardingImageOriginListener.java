package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
public class ForwardingImageOriginListener implements ImageOriginListener {
    public final List<ImageOriginListener> a;

    public ForwardingImageOriginListener(Set<ImageOriginListener> set) {
        this.a = new ArrayList(set);
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        this.a.add(imageOriginListener);
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public synchronized void onImageLoaded(String str, int i, boolean z, String str2) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageOriginListener imageOriginListener = this.a.get(i2);
            if (imageOriginListener != null) {
                try {
                    imageOriginListener.onImageLoaded(str, i, z, str2);
                } catch (Exception e) {
                    FLog.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
                }
            }
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        this.a.remove(imageOriginListener);
    }

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.a = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }
}
