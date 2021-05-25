package com.facebook.drawee.backends.pipeline.info;

import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
public class ImagePerfState {
    @Nullable
    public String A;
    @Nullable
    public DimensionsInfo B;
    @Nullable
    public ControllerListener2.Extras C;
    @Nullable
    public String a;
    @Nullable
    public String b;
    @Nullable
    public ImageRequest c;
    @Nullable
    public Object d;
    @Nullable
    public ImageInfo e;
    @Nullable
    public ImageRequest f;
    @Nullable
    public ImageRequest g;
    @Nullable
    public ImageRequest[] h;
    public long i = -1;
    public long j = -1;
    public long k = -1;
    public long l = -1;
    public long m = -1;
    public long n = -1;
    public long o = -1;
    public int p = 1;
    @Nullable
    public String q;
    public boolean r;
    public int s = -1;
    public int t = -1;
    @Nullable
    public Throwable u;
    public int v = -1;
    public int w = -1;
    public long x = -1;
    public long y = -1;
    public long z = -1;

    @Nullable
    public DimensionsInfo getDimensionsInfo() {
        return this.B;
    }

    @Nullable
    public Object getExtraData() {
        return this.C;
    }

    public long getImageDrawTimeMs() {
        return this.z;
    }

    public int getImageLoadStatus() {
        return this.v;
    }

    public void reset() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.p = 1;
        this.q = null;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = null;
        this.v = -1;
        this.w = -1;
        this.A = null;
        this.B = null;
        this.C = null;
        resetPointsTimestamps();
    }

    public void resetPointsTimestamps() {
        this.n = -1;
        this.o = -1;
        this.i = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
    }

    public void setCallerContext(@Nullable Object obj) {
        this.d = obj;
    }

    public void setComponentTag(@Nullable String str) {
        this.A = str;
    }

    public void setControllerCancelTimeMs(long j2) {
        this.m = j2;
    }

    public void setControllerFailureTimeMs(long j2) {
        this.l = j2;
    }

    public void setControllerFinalImageSetTimeMs(long j2) {
        this.k = j2;
    }

    public void setControllerId(@Nullable String str) {
        this.a = str;
    }

    public void setControllerImageRequests(@Nullable ImageRequest imageRequest, @Nullable ImageRequest imageRequest2, @Nullable ImageRequest[] imageRequestArr) {
        this.f = imageRequest;
        this.g = imageRequest2;
        this.h = imageRequestArr;
    }

    public void setControllerIntermediateImageSetTimeMs(long j2) {
        this.j = j2;
    }

    public void setControllerSubmitTimeMs(long j2) {
        this.i = j2;
    }

    public void setDimensionsInfo(DimensionsInfo dimensionsInfo) {
        this.B = dimensionsInfo;
    }

    public void setErrorThrowable(@Nullable Throwable th) {
        this.u = th;
    }

    public void setExtraData(@Nullable ControllerListener2.Extras extras) {
        this.C = extras;
    }

    public void setImageDrawTimeMs(long j2) {
        this.z = j2;
    }

    public void setImageInfo(@Nullable ImageInfo imageInfo) {
        this.e = imageInfo;
    }

    public void setImageLoadStatus(int i2) {
        this.v = i2;
    }

    public void setImageOrigin(int i2) {
        this.p = i2;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.c = imageRequest;
    }

    public void setImageRequestEndTimeMs(long j2) {
        this.o = j2;
    }

    public void setImageRequestStartTimeMs(long j2) {
        this.n = j2;
    }

    public void setInvisibilityEventTimeMs(long j2) {
        this.y = j2;
    }

    public void setOnScreenHeight(int i2) {
        this.t = i2;
    }

    public void setOnScreenWidth(int i2) {
        this.s = i2;
    }

    public void setPrefetch(boolean z2) {
        this.r = z2;
    }

    public void setRequestId(@Nullable String str) {
        this.b = str;
    }

    public void setUltimateProducerName(@Nullable String str) {
        this.q = str;
    }

    public void setVisibilityEventTimeMs(long j2) {
        this.x = j2;
    }

    public void setVisible(boolean z2) {
        this.w = z2 ? 1 : 2;
    }

    public ImagePerfData snapshot() {
        return new ImagePerfData(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.w, this.x, this.y, this.A, this.z, this.B, this.C);
    }
}
