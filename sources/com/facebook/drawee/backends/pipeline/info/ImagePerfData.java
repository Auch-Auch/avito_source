package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.internal.Objects;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
public class ImagePerfData {
    public static final int UNSET = -1;
    @Nullable
    public final DimensionsInfo A;
    @Nullable
    public final ControllerListener2.Extras B;
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final Object c;
    @Nullable
    public final ImageRequest d;
    @Nullable
    public final ImageInfo e;
    @Nullable
    public final ImageRequest f;
    @Nullable
    public final ImageRequest g;
    @Nullable
    public final ImageRequest[] h;
    public final long i;
    public final long j;
    public final long k;
    public final long l;
    public final long m;
    public final long n;
    public final long o;
    public final int p;
    @Nullable
    public final String q;
    public final boolean r;
    public final int s;
    public final int t;
    @Nullable
    public final Throwable u;
    public final int v;
    public final long w;
    public final long x;
    @Nullable
    public final String y;
    public final long z;

    public ImagePerfData(@Nullable String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable ImageInfo imageInfo, @Nullable ImageRequest imageRequest2, @Nullable ImageRequest imageRequest3, @Nullable ImageRequest[] imageRequestArr, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i2, @Nullable String str3, boolean z2, int i3, int i4, @Nullable Throwable th, int i5, long j9, long j10, @Nullable String str4, long j11, @Nullable DimensionsInfo dimensionsInfo, @Nullable ControllerListener2.Extras extras) {
        this.a = str;
        this.b = str2;
        this.d = imageRequest;
        this.c = obj;
        this.e = imageInfo;
        this.f = imageRequest2;
        this.g = imageRequest3;
        this.h = imageRequestArr;
        this.i = j2;
        this.j = j3;
        this.k = j4;
        this.l = j5;
        this.m = j6;
        this.n = j7;
        this.o = j8;
        this.p = i2;
        this.q = str3;
        this.r = z2;
        this.s = i3;
        this.t = i4;
        this.u = th;
        this.v = i5;
        this.w = j9;
        this.x = j10;
        this.y = str4;
        this.z = j11;
        this.A = dimensionsInfo;
        this.B = extras;
    }

    public String createDebugString() {
        return Objects.toStringHelper(this).add("controller ID", this.a).add("request ID", this.b).add("controller image request", this.f).add("controller low res image request", this.g).add("controller first available image requests", this.h).add("controller submit", this.i).add("controller final image", this.k).add("controller failure", this.l).add("controller cancel", this.m).add("start time", this.n).add("end time", this.o).add("origin", ImageOriginUtils.toString(this.p)).add("ultimateProducerName", this.q).add("prefetch", this.r).add("caller context", this.c).add("image request", this.d).add("image info", this.e).add("on-screen width", this.s).add("on-screen height", this.t).add("visibility state", this.v).add("component tag", this.y).add("visibility event", this.w).add("invisibility event", this.x).add("image draw event", this.z).add("dimensions info", this.A).add("extra data", this.B).toString();
    }

    @Nullable
    public Object getCallerContext() {
        return this.c;
    }

    @Nullable
    public String getComponentTag() {
        return this.y;
    }

    public long getControllerFailureTimeMs() {
        return this.l;
    }

    public long getControllerFinalImageSetTimeMs() {
        return this.k;
    }

    @Nullable
    public ImageRequest[] getControllerFirstAvailableImageRequests() {
        return this.h;
    }

    @Nullable
    public String getControllerId() {
        return this.a;
    }

    @Nullable
    public ImageRequest getControllerImageRequest() {
        return this.f;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        return this.j;
    }

    @Nullable
    public ImageRequest getControllerLowResImageRequest() {
        return this.g;
    }

    public long getControllerSubmitTimeMs() {
        return this.i;
    }

    @Nullable
    public DimensionsInfo getDimensionsInfo() {
        return this.A;
    }

    @Nullable
    public Throwable getErrorThrowable() {
        return this.u;
    }

    @Nullable
    public ControllerListener2.Extras getExtraData() {
        return this.B;
    }

    public long getFinalImageLoadTimeMs() {
        if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
            return -1;
        }
        return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
    }

    public long getImageDrawTimeMs() {
        return this.z;
    }

    @Nullable
    public ImageInfo getImageInfo() {
        return this.e;
    }

    public int getImageOrigin() {
        return this.p;
    }

    @Nullable
    public ImageRequest getImageRequest() {
        return this.d;
    }

    public long getImageRequestEndTimeMs() {
        return this.o;
    }

    public long getImageRequestStartTimeMs() {
        return this.n;
    }

    public long getIntermediateImageLoadTimeMs() {
        if (getControllerIntermediateImageSetTimeMs() == -1 || getControllerSubmitTimeMs() == -1) {
            return -1;
        }
        return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
    }

    public long getInvisibilityEventTimeMs() {
        return this.x;
    }

    public int getOnScreenHeightPx() {
        return this.t;
    }

    public int getOnScreenWidthPx() {
        return this.s;
    }

    @Nullable
    public String getRequestId() {
        return this.b;
    }

    @Nullable
    public String getUltimateProducerName() {
        return this.q;
    }

    public long getVisibilityEventTimeMs() {
        return this.w;
    }

    public int getVisibilityState() {
        return this.v;
    }

    public boolean isPrefetch() {
        return this.r;
    }
}
