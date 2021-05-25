package com.otaliastudios.opengl.draw;

import a2.g.r.g;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.geometry.IndexedSegmentF;
import com.otaliastudios.opengl.internal.GlKt;
import com.otaliastudios.opengl.types.BuffersJvmKt;
import com.otaliastudios.opengl.types.BuffersKt;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000eR&\u0010\u0018\u001a\u00060\u0010j\u0002`\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/otaliastudios/opengl/draw/Gl2dMesh;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "points", "", "setPoints", "(Ljava/util/List;)V", "", "x", "y", "(Ljava/util/List;Ljava/util/List;)V", "draw", "()V", "release", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", g.a, "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "Ljava/nio/ByteBuffer;", "Lcom/otaliastudios/opengl/types/ByteBuffer;", "h", "Ljava/nio/ByteBuffer;", "vertexIndices", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class Gl2dMesh extends Gl2dDrawable {
    @NotNull
    public FloatBuffer g = BuffersJvmKt.floatBuffer(6);
    public ByteBuffer h;

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void draw() {
        ByteBuffer byteBuffer = this.h;
        if (byteBuffer != null) {
            Egloo.checkGlError("glDrawElements start");
            GLES20.glDrawElements(GlKt.getGL_TRIANGLES(), byteBuffer.limit(), GlKt.getGL_UNSIGNED_BYTE(), byteBuffer);
            Egloo.checkGlError("glDrawElements end");
        }
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @NotNull
    public FloatBuffer getVertexArray() {
        return this.g;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void release() {
        super.release();
        ByteBuffer byteBuffer = this.h;
        if (byteBuffer != null) {
            BuffersKt.dispose(byteBuffer);
        }
    }

    public final void setPoints(@NotNull List<Float> list, @NotNull List<Float> list2) {
        float f;
        int i;
        float f2;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "x");
        Intrinsics.checkNotNullParameter(list2, "y");
        if (list.size() == list2.size()) {
            int size = list.size();
            int i2 = size * 2;
            if (getVertexArray().capacity() < i2) {
                BuffersKt.dispose(getVertexArray());
                setVertexArray(BuffersJvmKt.floatBuffer(i2));
            } else {
                getVertexArray().clear();
            }
            ArrayList<IndexedSegmentF> arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < size) {
                float floatValue = list.get(i3).floatValue();
                float floatValue2 = list2.get(i3).floatValue();
                getVertexArray().put(floatValue);
                getVertexArray().put(floatValue2);
                int i4 = i3 + 1;
                for (int i5 = i4; i5 < size; i5++) {
                    arrayList.add(new IndexedSegmentF(i3, i5, floatValue, floatValue2, list.get(i5).floatValue(), list2.get(i5).floatValue()));
                }
                i3 = i4;
            }
            getVertexArray().flip();
            notifyVertexArrayChange();
            if (arrayList.size() > 1) {
                t6.n.g.sortWith(arrayList, new Comparator<T>() { // from class: com.otaliastudios.opengl.draw.Gl2dMesh$setPoints$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return a.compareValues(Float.valueOf(t.getLength()), Float.valueOf(t2.getLength()));
                    }
                });
            }
            ArrayList arrayList2 = new ArrayList();
            for (IndexedSegmentF indexedSegmentF : arrayList) {
                if (!arrayList2.isEmpty()) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((IndexedSegmentF) it.next()).intersects(indexedSegmentF)) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    arrayList2.add(indexedSegmentF);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList2.size();
            int i6 = 0;
            while (i6 < size2) {
                IndexedSegmentF indexedSegmentF2 = (IndexedSegmentF) arrayList2.get(i6);
                i6++;
                int size3 = arrayList2.size();
                boolean z2 = false;
                boolean z3 = false;
                for (int i7 = i6; i7 < size3 && (!z2 || !z3); i7++) {
                    IndexedSegmentF indexedSegmentF3 = (IndexedSegmentF) arrayList2.get(i7);
                    if (indexedSegmentF2.hasIndex(indexedSegmentF3.getI())) {
                        i = indexedSegmentF3.getJ();
                        f = indexedSegmentF3.getJx();
                        f2 = indexedSegmentF3.getJy();
                    } else if (indexedSegmentF2.hasIndex(indexedSegmentF3.getJ())) {
                        i = indexedSegmentF3.getI();
                        f = indexedSegmentF3.getIx();
                        f2 = indexedSegmentF3.getIy();
                    }
                    int orientation = indexedSegmentF2.orientation(f, f2);
                    if (orientation != 0 && ((orientation <= 0 || !z2) && (orientation >= 0 || !z3))) {
                        int i8 = i7 + 1;
                        int size4 = arrayList2.size();
                        while (true) {
                            if (i8 >= size4) {
                                break;
                            }
                            IndexedSegmentF indexedSegmentF4 = (IndexedSegmentF) arrayList2.get(i8);
                            if (!indexedSegmentF4.hasIndex(i) || (!indexedSegmentF4.hasIndex(indexedSegmentF2.getI()) && !indexedSegmentF4.hasIndex(indexedSegmentF2.getJ()))) {
                                i8++;
                            }
                        }
                        arrayList3.add(Byte.valueOf((byte) indexedSegmentF2.getI()));
                        arrayList3.add(Byte.valueOf((byte) indexedSegmentF2.getJ()));
                        arrayList3.add(Byte.valueOf((byte) i));
                        if (orientation > 0) {
                            z2 = true;
                        }
                        if (orientation < 0) {
                            z3 = true;
                        }
                    }
                }
            }
            ByteBuffer byteBuffer = this.h;
            if (byteBuffer != null) {
                BuffersKt.dispose(byteBuffer);
            }
            ByteBuffer byteBuffer2 = BuffersJvmKt.byteBuffer(arrayList3.size());
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                byteBuffer2.put(((Number) it2.next()).byteValue());
            }
            byteBuffer2.clear();
            Unit unit = Unit.INSTANCE;
            this.h = byteBuffer2;
            return;
        }
        throw new IllegalArgumentException("x.size != y.size");
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@NotNull FloatBuffer floatBuffer) {
        Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.g = floatBuffer;
    }

    public final void setPoints(@NotNull List<? extends PointF> list) {
        Intrinsics.checkNotNullParameter(list, "points");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((PointF) it.next()).x));
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Float.valueOf(((PointF) it2.next()).y));
        }
        setPoints(arrayList, arrayList2);
    }
}
