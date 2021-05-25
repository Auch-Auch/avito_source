package com.otaliastudios.opengl.geometry;

import android.graphics.PointF;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/otaliastudios/opengl/geometry/IndexedPointF;", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "", AuthSource.SEND_ABUSE, "I", "getIndex", "()I", FirebaseAnalytics.Param.INDEX, "", "x", "y", "<init>", "(IFF)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class IndexedPointF extends PointF {
    public final int a;

    public IndexedPointF(int i, float f, float f2) {
        super(f, f2);
        this.a = i;
    }

    public final int getIndex() {
        return this.a;
    }
}
