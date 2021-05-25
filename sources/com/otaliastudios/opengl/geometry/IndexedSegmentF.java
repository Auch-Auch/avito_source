package com.otaliastudios.opengl.geometry;

import a2.g.r.g;
import android.graphics.PointF;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001aJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/otaliastudios/opengl/geometry/IndexedSegmentF;", "Lcom/otaliastudios/opengl/geometry/SegmentF;", "other", "", "intersects", "(Lcom/otaliastudios/opengl/geometry/SegmentF;)Z", "", FirebaseAnalytics.Param.INDEX, "hasIndex", "(I)Z", g.a, "I", "getJ", "()I", "j", "f", "getI", "i", "", "ix", "iy", "jx", "jy", "<init>", "(IIFFFF)V", "Lcom/otaliastudios/opengl/geometry/IndexedPointF;", "(Lcom/otaliastudios/opengl/geometry/IndexedPointF;Lcom/otaliastudios/opengl/geometry/IndexedPointF;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class IndexedSegmentF extends SegmentF {
    public final int f;
    public final int g;

    public IndexedSegmentF(int i, int i2, float f2, float f3, float f4, float f5) {
        super(f2, f3, f4, f5);
        this.f = i;
        this.g = i2;
    }

    public final int getI() {
        return this.f;
    }

    public final int getJ() {
        return this.g;
    }

    public final boolean hasIndex(int i) {
        return i == this.f || i == this.g;
    }

    @Override // com.otaliastudios.opengl.geometry.SegmentF
    public boolean intersects(@NotNull SegmentF segmentF) {
        Intrinsics.checkNotNullParameter(segmentF, "other");
        if (segmentF instanceof IndexedSegmentF) {
            IndexedSegmentF indexedSegmentF = (IndexedSegmentF) segmentF;
            if (indexedSegmentF.hasIndex(this.f) && indexedSegmentF.hasIndex(this.g)) {
                return true;
            }
            if (indexedSegmentF.hasIndex(this.f) || indexedSegmentF.hasIndex(this.g)) {
                return false;
            }
        }
        return super.intersects(segmentF);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IndexedSegmentF(@NotNull IndexedPointF indexedPointF, @NotNull IndexedPointF indexedPointF2) {
        this(indexedPointF.getIndex(), indexedPointF2.getIndex(), ((PointF) indexedPointF).x, ((PointF) indexedPointF).y, ((PointF) indexedPointF2).x, ((PointF) indexedPointF2).y);
        Intrinsics.checkNotNullParameter(indexedPointF, "i");
        Intrinsics.checkNotNullParameter(indexedPointF2, "j");
    }
}
