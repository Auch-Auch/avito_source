package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {
        public final SubMesh[] a;

        public Mesh(SubMesh... subMeshArr) {
            this.a = subMeshArr;
        }

        public SubMesh getSubMesh(int i) {
            return this.a[i];
        }

        public int getSubMeshCount() {
            return this.a.length;
        }
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public Projection(Mesh mesh, int i) {
        this(mesh, mesh, i);
    }

    public static Projection createEquirectangular(int i) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i;
        this.singleMesh = mesh == mesh2;
    }

    public static Projection createEquirectangular(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        float f4;
        float[] fArr;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = i2;
        Assertions.checkArgument(f > 0.0f);
        Assertions.checkArgument(i8 >= 1);
        Assertions.checkArgument(i9 >= 1);
        Assertions.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        Assertions.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians((double) f2);
        float radians2 = (float) Math.toRadians((double) f3);
        float f5 = radians / ((float) i8);
        float f6 = radians2 / ((float) i9);
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[(i11 * 3)];
        float[] fArr3 = new float[(i11 * 2)];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f7 = radians / 2.0f;
            float f8 = (((float) i12) * f5) - f7;
            int i15 = i12 + 1;
            float f9 = (((float) i15) * f5) - f7;
            int i16 = 0;
            while (i16 < i10) {
                int i17 = 0;
                while (i17 < 2) {
                    if (i17 == 0) {
                        f4 = f8;
                        i4 = i10;
                    } else {
                        i4 = i10;
                        f4 = f9;
                    }
                    float f10 = ((float) i16) * f6;
                    int i18 = i13 + 1;
                    double d = (double) f;
                    double d2 = (double) ((f10 + 3.1415927f) - (radians2 / 2.0f));
                    double d3 = (double) f4;
                    fArr2[i13] = -((float) (Math.cos(d3) * Math.sin(d2) * d));
                    int i19 = i18 + 1;
                    fArr2[i18] = (float) (Math.sin(d3) * d);
                    int i20 = i19 + 1;
                    fArr2[i19] = (float) (Math.cos(d3) * Math.cos(d2) * d);
                    int i21 = i14 + 1;
                    fArr3[i14] = f10 / radians2;
                    int i22 = i21 + 1;
                    fArr3[i21] = (((float) (i12 + i17)) * f5) / radians;
                    if (i16 == 0 && i17 == 0) {
                        i7 = i2;
                        i6 = i16;
                        i5 = i17;
                    } else {
                        i7 = i2;
                        i6 = i16;
                        i5 = i17;
                        if (!(i6 == i7 && i5 == 1)) {
                            fArr = fArr3;
                            i14 = i22;
                            i13 = i20;
                            i17 = i5 + 1;
                            i9 = i7;
                            i16 = i6;
                            fArr3 = fArr;
                            i12 = i12;
                            i10 = i4;
                            f6 = f6;
                            f5 = f5;
                            f9 = f9;
                        }
                    }
                    System.arraycopy(fArr2, i20 - 3, fArr2, i20, 3);
                    i20 += 3;
                    fArr = fArr3;
                    System.arraycopy(fArr, i22 - 2, fArr, i22, 2);
                    i22 += 2;
                    i14 = i22;
                    i13 = i20;
                    i17 = i5 + 1;
                    i9 = i7;
                    i16 = i6;
                    fArr3 = fArr;
                    i12 = i12;
                    i10 = i4;
                    f6 = f6;
                    f5 = f5;
                    f9 = f9;
                }
                f8 = f8;
                i15 = i15;
                i10 = i10;
                f6 = f6;
                f5 = f5;
                f9 = f9;
                i9 = i9;
                i16++;
            }
            i8 = i;
            i12 = i15;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr2, fArr3, 1)), i3);
    }
}
