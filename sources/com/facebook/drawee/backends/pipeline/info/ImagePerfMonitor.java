package com.facebook.drawee.backends.pipeline.info;

import android.graphics.Rect;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener2;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
public class ImagePerfMonitor implements ImagePerfNotifier {
    public final PipelineDraweeController a;
    public final MonotonicClock b;
    public final ImagePerfState c = new ImagePerfState();
    public final Supplier<Boolean> d;
    @Nullable
    public ImageOriginRequestListener e;
    @Nullable
    public ImageOriginListener f;
    @Nullable
    public ImagePerfRequestListener g;
    @Nullable
    public ImagePerfControllerListener2 h;
    @Nullable
    public ForwardingRequestListener i;
    @Nullable
    public List<ImagePerfDataListener> j;
    public boolean k;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController, Supplier<Boolean> supplier) {
        this.b = monotonicClock;
        this.a = pipelineDraweeController;
        this.d = supplier;
    }

    public void addImagePerfDataListener(@Nullable ImagePerfDataListener imagePerfDataListener) {
        if (imagePerfDataListener != null) {
            if (this.j == null) {
                this.j = new CopyOnWriteArrayList();
            }
            this.j.add(imagePerfDataListener);
        }
    }

    public void addViewportData() {
        DraweeHierarchy hierarchy = this.a.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.c.setOnScreenWidth(bounds.width());
            this.c.setOnScreenHeight(bounds.height());
        }
    }

    public void clearImagePerfDataListeners() {
        List<ImagePerfDataListener> list = this.j;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier
    public void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i2) {
        List<ImagePerfDataListener> list;
        if (!(!this.k || (list = this.j) == null || list.isEmpty())) {
            ImagePerfData snapshot = imagePerfState.snapshot();
            for (ImagePerfDataListener imagePerfDataListener : this.j) {
                imagePerfDataListener.onImageVisibilityUpdated(snapshot, i2);
            }
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier
    public void notifyStatusUpdated(ImagePerfState imagePerfState, int i2) {
        List<ImagePerfDataListener> list;
        imagePerfState.setImageLoadStatus(i2);
        if (!(!this.k || (list = this.j) == null || list.isEmpty())) {
            if (i2 == 3) {
                addViewportData();
            }
            ImagePerfData snapshot = imagePerfState.snapshot();
            for (ImagePerfDataListener imagePerfDataListener : this.j) {
                imagePerfDataListener.onImageLoadStatusUpdated(snapshot, i2);
            }
        }
    }

    public void removeImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        List<ImagePerfDataListener> list = this.j;
        if (list != null) {
            list.remove(imagePerfDataListener);
        }
    }

    public void reset() {
        clearImagePerfDataListeners();
        setEnabled(false);
        this.c.reset();
    }

    public void setEnabled(boolean z) {
        this.k = z;
        if (z) {
            if (this.h == null) {
                this.h = new ImagePerfControllerListener2(this.b, this.c, this, this.d);
            }
            if (this.g == null) {
                this.g = new ImagePerfRequestListener(this.b, this.c);
            }
            if (this.f == null) {
                this.f = new ImagePerfImageOriginListener(this.c, this);
            }
            ImageOriginRequestListener imageOriginRequestListener = this.e;
            if (imageOriginRequestListener == null) {
                this.e = new ImageOriginRequestListener(this.a.getId(), this.f);
            } else {
                imageOriginRequestListener.init(this.a.getId());
            }
            if (this.i == null) {
                this.i = new ForwardingRequestListener(this.g, this.e);
            }
            ImageOriginListener imageOriginListener = this.f;
            if (imageOriginListener != null) {
                this.a.addImageOriginListener(imageOriginListener);
            }
            ImagePerfControllerListener2 imagePerfControllerListener2 = this.h;
            if (imagePerfControllerListener2 != null) {
                this.a.addControllerListener2(imagePerfControllerListener2);
            }
            ForwardingRequestListener forwardingRequestListener = this.i;
            if (forwardingRequestListener != null) {
                this.a.addRequestListener(forwardingRequestListener);
                return;
            }
            return;
        }
        ImageOriginListener imageOriginListener2 = this.f;
        if (imageOriginListener2 != null) {
            this.a.removeImageOriginListener(imageOriginListener2);
        }
        ImagePerfControllerListener2 imagePerfControllerListener22 = this.h;
        if (imagePerfControllerListener22 != null) {
            this.a.removeControllerListener2(imagePerfControllerListener22);
        }
        ForwardingRequestListener forwardingRequestListener2 = this.i;
        if (forwardingRequestListener2 != null) {
            this.a.removeRequestListener(forwardingRequestListener2);
        }
    }

    public void updateImageRequestData(AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder) {
        this.c.setControllerImageRequests(abstractDraweeControllerBuilder.getImageRequest(), abstractDraweeControllerBuilder.getLowResImageRequest(), abstractDraweeControllerBuilder.getFirstAvailableImageRequests());
    }
}
