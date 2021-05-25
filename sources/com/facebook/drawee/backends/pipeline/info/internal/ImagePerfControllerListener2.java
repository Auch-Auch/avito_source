package com.facebook.drawee.backends.pipeline.info.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.fresco.ui.common.BaseControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import javax.annotation.Nullable;
public class ImagePerfControllerListener2 extends BaseControllerListener2<ImageInfo> implements OnDrawControllerListener<ImageInfo> {
    public final MonotonicClock b;
    public final ImagePerfState c;
    public final ImagePerfNotifier d;
    public final Supplier<Boolean> e;
    @Nullable
    public Handler f;

    public static class a extends Handler {
        public final ImagePerfNotifier a;

        public a(@NonNull Looper looper, @NonNull ImagePerfNotifier imagePerfNotifier) {
            super(looper);
            this.a = imagePerfNotifier;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                this.a.notifyStatusUpdated((ImagePerfState) message.obj, message.arg1);
            } else if (i == 2) {
                this.a.notifyListenersOfVisibilityStateUpdate((ImagePerfState) message.obj, message.arg1);
            }
        }
    }

    public ImagePerfControllerListener2(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfNotifier imagePerfNotifier, Supplier<Boolean> supplier) {
        this.b = monotonicClock;
        this.c = imagePerfState;
        this.d = imagePerfNotifier;
        this.e = supplier;
    }

    public final boolean a() {
        boolean booleanValue = this.e.get().booleanValue();
        if (booleanValue && this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
                    handlerThread.start();
                    this.f = new a(handlerThread.getLooper(), this.d);
                }
            }
        }
        return booleanValue;
    }

    public final void b(int i) {
        if (a()) {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i;
            obtainMessage.obj = this.c;
            this.f.sendMessage(obtainMessage);
            return;
        }
        this.d.notifyStatusUpdated(this.c, i);
    }

    public final void c(int i) {
        if (a()) {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = i;
            obtainMessage.obj = this.c;
            this.f.sendMessage(obtainMessage);
            return;
        }
        this.d.notifyListenersOfVisibilityStateUpdate(this.c, i);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String str, Throwable th, @Nullable ControllerListener2.Extras extras) {
        long now = this.b.now();
        this.c.setExtraData(extras);
        this.c.setControllerFailureTimeMs(now);
        this.c.setControllerId(str);
        this.c.setErrorThrowable(th);
        b(5);
        this.c.setVisible(false);
        this.c.setInvisibilityEventTimeMs(now);
        c(2);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String str, ControllerListener2.Extras extras) {
        long now = this.b.now();
        this.c.setExtraData(extras);
        int imageLoadStatus = this.c.getImageLoadStatus();
        if (!(imageLoadStatus == 3 || imageLoadStatus == 5 || imageLoadStatus == 6)) {
            this.c.setControllerCancelTimeMs(now);
            this.c.setControllerId(str);
            b(4);
        }
        this.c.setVisible(false);
        this.c.setInvisibilityEventTimeMs(now);
        c(2);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String str, @Nullable Object obj, @Nullable ControllerListener2.Extras extras) {
        long now = this.b.now();
        this.c.resetPointsTimestamps();
        this.c.setControllerSubmitTimeMs(now);
        this.c.setControllerId(str);
        this.c.setCallerContext(obj);
        this.c.setExtraData(extras);
        b(0);
        reportViewVisible(now);
    }

    @VisibleForTesting
    public void reportViewVisible(long j) {
        this.c.setVisible(true);
        this.c.setVisibilityEventTimeMs(j);
        c(1);
    }

    public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable ControllerListener2.Extras extras) {
        long now = this.b.now();
        extras.view.size();
        this.c.setExtraData(extras);
        this.c.setControllerFinalImageSetTimeMs(now);
        this.c.setImageRequestEndTimeMs(now);
        this.c.setControllerId(str);
        this.c.setImageInfo(imageInfo);
        b(3);
    }

    public void onImageDrawn(String str, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        this.c.setImageDrawTimeMs(this.b.now());
        this.c.setDimensionsInfo(dimensionsInfo);
        b(6);
    }

    public void onIntermediateImageSet(String str, @Nullable ImageInfo imageInfo) {
        this.c.setControllerIntermediateImageSetTimeMs(this.b.now());
        this.c.setControllerId(str);
        this.c.setImageInfo(imageInfo);
        b(2);
    }
}
