package com.facebook.drawee.backends.pipeline.info.internal;

import android.graphics.drawable.Animatable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import javax.annotation.Nullable;
public class ImagePerfControllerListener extends BaseControllerListener<ImageInfo> implements OnDrawControllerListener<ImageInfo> {
    public final MonotonicClock b;
    public final ImagePerfState c;
    public final ImagePerfMonitor d;

    public ImagePerfControllerListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.b = monotonicClock;
        this.c = imagePerfState;
        this.d = imagePerfMonitor;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFailure(String str, Throwable th) {
        long now = this.b.now();
        this.c.setControllerFailureTimeMs(now);
        this.c.setControllerId(str);
        this.c.setErrorThrowable(th);
        this.d.notifyStatusUpdated(this.c, 5);
        this.c.setVisible(false);
        this.c.setInvisibilityEventTimeMs(now);
        this.d.notifyListenersOfVisibilityStateUpdate(this.c, 2);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onRelease(String str) {
        super.onRelease(str);
        long now = this.b.now();
        int imageLoadStatus = this.c.getImageLoadStatus();
        if (!(imageLoadStatus == 3 || imageLoadStatus == 5 || imageLoadStatus == 6)) {
            this.c.setControllerCancelTimeMs(now);
            this.c.setControllerId(str);
            this.d.notifyStatusUpdated(this.c, 4);
        }
        this.c.setVisible(false);
        this.c.setInvisibilityEventTimeMs(now);
        this.d.notifyListenersOfVisibilityStateUpdate(this.c, 2);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        long now = this.b.now();
        this.c.resetPointsTimestamps();
        this.c.setControllerSubmitTimeMs(now);
        this.c.setControllerId(str);
        this.c.setCallerContext(obj);
        this.d.notifyStatusUpdated(this.c, 0);
        reportViewVisible(now);
    }

    @VisibleForTesting
    public void reportViewVisible(long j) {
        this.c.setVisible(true);
        this.c.setVisibilityEventTimeMs(j);
        this.d.notifyListenersOfVisibilityStateUpdate(this.c, 1);
    }

    public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
        long now = this.b.now();
        this.c.setControllerFinalImageSetTimeMs(now);
        this.c.setImageRequestEndTimeMs(now);
        this.c.setControllerId(str);
        this.c.setImageInfo(imageInfo);
        this.d.notifyStatusUpdated(this.c, 3);
    }

    public void onImageDrawn(String str, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        this.c.setImageDrawTimeMs(this.b.now());
        this.c.setDimensionsInfo(dimensionsInfo);
        this.d.notifyStatusUpdated(this.c, 6);
    }

    public void onIntermediateImageSet(String str, @Nullable ImageInfo imageInfo) {
        this.c.setControllerIntermediateImageSetTimeMs(this.b.now());
        this.c.setControllerId(str);
        this.c.setImageInfo(imageInfo);
        this.d.notifyStatusUpdated(this.c, 2);
    }
}
