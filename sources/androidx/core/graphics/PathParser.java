package androidx.core.graphics;

import a2.b.a.a.a;
import android.graphics.Path;
import androidx.annotation.Nullable;
import com.vk.sdk.api.model.VKApiPhotoSize;
public class PathParser {
    public static float[] a(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (!(pathDataNodeArr[i].mType == pathDataNodeArr2[i].mType && pathDataNodeArr[i].mParams.length == pathDataNodeArr2[i].mParams.length)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        if (r13 == false) goto L_0x008d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[Catch:{ NumberFormatException -> 0x00ba }, LOOP:3: B:25:0x006d->B:45:0x0098, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData(java.lang.String r16) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.createNodesFromPathData(java.lang.String):androidx.core.graphics.PathParser$PathDataNode[]");
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(a.c3("Error in parsing ", str), e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        } else if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
            }
            return true;
        } else {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        public static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f;
            double d4 = (double) f2;
            double d5 = (d4 * sin) + (d3 * cos);
            double d6 = d3;
            double d7 = (double) f5;
            double d8 = d5 / d7;
            double d9 = (double) f6;
            double d10 = ((d4 * cos) + (((double) (-f)) * sin)) / d9;
            double d11 = d4;
            double d12 = (double) f4;
            double d13 = ((d12 * sin) + (((double) f3) * cos)) / d7;
            double d14 = ((d12 * cos) + (((double) (-f3)) * sin)) / d9;
            double d15 = d8 - d13;
            double d16 = d10 - d14;
            double d17 = (d8 + d13) / 2.0d;
            double d18 = (d10 + d14) / 2.0d;
            double d19 = (d16 * d16) + (d15 * d15);
            if (d19 != 0.0d) {
                double d20 = (1.0d / d19) - 0.25d;
                if (d20 < 0.0d) {
                    float sqrt = (float) (Math.sqrt(d19) / 1.99999d);
                    a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                    return;
                }
                double sqrt2 = Math.sqrt(d20);
                double d21 = d15 * sqrt2;
                double d22 = sqrt2 * d16;
                if (z == z2) {
                    d2 = d17 - d22;
                    d = d18 + d21;
                } else {
                    d2 = d17 + d22;
                    d = d18 - d21;
                }
                double atan2 = Math.atan2(d10 - d, d8 - d2);
                double atan22 = Math.atan2(d14 - d, d13 - d2) - atan2;
                int i = 0;
                int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                if (z2 != (i2 >= 0)) {
                    atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                }
                double d23 = d2 * d7;
                double d24 = d * d9;
                double d25 = (d23 * cos) - (d24 * sin);
                double d26 = (d24 * cos) + (d23 * sin);
                int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
                double cos2 = Math.cos(radians);
                double sin2 = Math.sin(radians);
                double cos3 = Math.cos(atan2);
                double sin3 = Math.sin(atan2);
                double d27 = -d7;
                double d28 = d27 * cos2;
                double d29 = d9 * sin2;
                double d30 = (d28 * sin3) - (d29 * cos3);
                double d31 = d27 * sin2;
                double d32 = d9 * cos2;
                double d33 = (cos3 * d32) + (sin3 * d31);
                double d34 = atan22 / ((double) ceil);
                double d35 = atan2;
                while (i < ceil) {
                    double d36 = d35 + d34;
                    double sin4 = Math.sin(d36);
                    double cos4 = Math.cos(d36);
                    double d37 = (((d7 * cos2) * cos4) + d25) - (d29 * sin4);
                    double d38 = (d32 * sin4) + (d7 * sin2 * cos4) + d26;
                    double d39 = (d28 * sin4) - (d29 * cos4);
                    double d40 = (cos4 * d32) + (sin4 * d31);
                    double d41 = d36 - d35;
                    double tan = Math.tan(d41 / 2.0d);
                    double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d41)) / 3.0d;
                    path.rLineTo(0.0f, 0.0f);
                    path.cubicTo((float) ((d30 * sqrt3) + d6), (float) ((d33 * sqrt3) + d11), (float) (d37 - (sqrt3 * d39)), (float) (d38 - (sqrt3 * d40)), (float) d37, (float) d38);
                    i++;
                    d32 = d32;
                    d31 = d31;
                    ceil = ceil;
                    cos2 = cos2;
                    d35 = d36;
                    d7 = d7;
                    d33 = d40;
                    d30 = d39;
                    d6 = d37;
                    d11 = d38;
                    d34 = d34;
                    d25 = d25;
                }
            }
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            int i;
            int i2;
            int i3;
            float[] fArr;
            char c;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            PathDataNode[] pathDataNodeArr2 = pathDataNodeArr;
            float[] fArr2 = new float[6];
            char c2 = VKApiPhotoSize.M;
            char c3 = 0;
            char c4 = VKApiPhotoSize.M;
            int i4 = 0;
            while (i4 < pathDataNodeArr2.length) {
                char c5 = pathDataNodeArr2[i4].mType;
                float[] fArr3 = pathDataNodeArr2[i4].mParams;
                float f20 = fArr2[c3];
                float f21 = fArr2[1];
                float f22 = fArr2[2];
                float f23 = fArr2[3];
                float f24 = fArr2[4];
                float f25 = fArr2[5];
                switch (c5) {
                    case 'A':
                    case 'a':
                        i = 7;
                        break;
                    case 'C':
                    case 'c':
                        i = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f24, f25);
                        f20 = f24;
                        f22 = f20;
                        f21 = f25;
                        f23 = f21;
                    default:
                        i = 2;
                        break;
                }
                float f26 = f24;
                float f27 = f25;
                float f28 = f20;
                float f29 = f21;
                int i5 = 0;
                while (i5 < fArr3.length) {
                    if (c5 != 'A') {
                        if (c5 != 'C') {
                            if (c5 == 'H') {
                                i2 = i5;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                int i6 = i2 + 0;
                                path.lineTo(fArr[i6], f29);
                                f28 = fArr[i6];
                            } else if (c5 == 'Q') {
                                i2 = i5;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                int i7 = i2 + 0;
                                int i8 = i2 + 1;
                                int i9 = i2 + 2;
                                int i10 = i2 + 3;
                                path.quadTo(fArr[i7], fArr[i8], fArr[i9], fArr[i10]);
                                f2 = fArr[i7];
                                f = fArr[i8];
                                f28 = fArr[i9];
                                f29 = fArr[i10];
                            } else if (c5 == 'V') {
                                i2 = i5;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                int i11 = i2 + 0;
                                path.lineTo(f28, fArr[i11]);
                                f29 = fArr[i11];
                            } else if (c5 != 'a') {
                                if (c5 != 'c') {
                                    if (c5 == 'h') {
                                        i2 = i5;
                                        int i12 = i2 + 0;
                                        path.rLineTo(fArr3[i12], 0.0f);
                                        f28 += fArr3[i12];
                                    } else if (c5 != 'q') {
                                        if (c5 == 'v') {
                                            i2 = i5;
                                            f10 = f29;
                                            int i13 = i2 + 0;
                                            path.rLineTo(0.0f, fArr3[i13]);
                                            f11 = fArr3[i13];
                                        } else if (c5 != 'L') {
                                            if (c5 == 'M') {
                                                i2 = i5;
                                                int i14 = i2 + 0;
                                                float f30 = fArr3[i14];
                                                int i15 = i2 + 1;
                                                float f31 = fArr3[i15];
                                                if (i2 > 0) {
                                                    path.lineTo(fArr3[i14], fArr3[i15]);
                                                    f28 = f30;
                                                    f29 = f31;
                                                } else {
                                                    path.moveTo(fArr3[i14], fArr3[i15]);
                                                    f28 = f30;
                                                    f29 = f31;
                                                }
                                            } else if (c5 == 'S') {
                                                i2 = i5;
                                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                    f12 = (f29 * 2.0f) - f23;
                                                    f13 = (f28 * 2.0f) - f22;
                                                } else {
                                                    f13 = f28;
                                                    f12 = f29;
                                                }
                                                int i16 = i2 + 0;
                                                int i17 = i2 + 1;
                                                int i18 = i2 + 2;
                                                int i19 = i2 + 3;
                                                path.cubicTo(f13, f12, fArr3[i16], fArr3[i17], fArr3[i18], fArr3[i19]);
                                                float f32 = fArr3[i16];
                                                float f33 = fArr3[i17];
                                                f4 = fArr3[i18];
                                                f3 = fArr3[i19];
                                                f22 = f32;
                                                f23 = f33;
                                                f28 = f4;
                                                f29 = f3;
                                            } else if (c5 == 'T') {
                                                i2 = i5;
                                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                    f14 = (f28 * 2.0f) - f22;
                                                    f15 = (f29 * 2.0f) - f23;
                                                } else {
                                                    f14 = f28;
                                                    f15 = f29;
                                                }
                                                int i20 = i2 + 0;
                                                int i21 = i2 + 1;
                                                path.quadTo(f14, f15, fArr3[i20], fArr3[i21]);
                                                f23 = f15;
                                                f22 = f14;
                                                fArr = fArr3;
                                                c = c5;
                                                i3 = i4;
                                                f28 = fArr3[i20];
                                                f29 = fArr3[i21];
                                            } else if (c5 == 'l') {
                                                i2 = i5;
                                                f10 = f29;
                                                int i22 = i2 + 0;
                                                int i23 = i2 + 1;
                                                path.rLineTo(fArr3[i22], fArr3[i23]);
                                                f28 += fArr3[i22];
                                                f11 = fArr3[i23];
                                            } else if (c5 == c2) {
                                                i2 = i5;
                                                int i24 = i2 + 0;
                                                f28 += fArr3[i24];
                                                int i25 = i2 + 1;
                                                f29 += fArr3[i25];
                                                if (i2 > 0) {
                                                    path.rLineTo(fArr3[i24], fArr3[i25]);
                                                } else {
                                                    path.rMoveTo(fArr3[i24], fArr3[i25]);
                                                }
                                            } else if (c5 != 's') {
                                                if (c5 == 't') {
                                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                        f18 = f28 - f22;
                                                        f19 = f29 - f23;
                                                    } else {
                                                        f19 = 0.0f;
                                                        f18 = 0.0f;
                                                    }
                                                    int i26 = i5 + 0;
                                                    int i27 = i5 + 1;
                                                    path.rQuadTo(f18, f19, fArr3[i26], fArr3[i27]);
                                                    f22 = f18 + f28;
                                                    float f34 = f19 + f29;
                                                    f28 += fArr3[i26];
                                                    f29 += fArr3[i27];
                                                    f23 = f34;
                                                }
                                                i2 = i5;
                                            } else {
                                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                    f16 = f29 - f23;
                                                    f17 = f28 - f22;
                                                } else {
                                                    f17 = 0.0f;
                                                    f16 = 0.0f;
                                                }
                                                int i28 = i5 + 0;
                                                int i29 = i5 + 1;
                                                int i30 = i5 + 2;
                                                int i31 = i5 + 3;
                                                i2 = i5;
                                                f5 = f29;
                                                path.rCubicTo(f17, f16, fArr3[i28], fArr3[i29], fArr3[i30], fArr3[i31]);
                                                f8 = fArr3[i28] + f28;
                                                f7 = fArr3[i29] + f5;
                                                f6 = f28 + fArr3[i30];
                                                f9 = fArr3[i31];
                                            }
                                            f27 = f29;
                                            f26 = f28;
                                        } else {
                                            i2 = i5;
                                            int i32 = i2 + 0;
                                            int i33 = i2 + 1;
                                            path.lineTo(fArr3[i32], fArr3[i33]);
                                            f28 = fArr3[i32];
                                            f29 = fArr3[i33];
                                        }
                                        f29 = f10 + f11;
                                    } else {
                                        i2 = i5;
                                        f5 = f29;
                                        int i34 = i2 + 0;
                                        int i35 = i2 + 1;
                                        int i36 = i2 + 2;
                                        int i37 = i2 + 3;
                                        path.rQuadTo(fArr3[i34], fArr3[i35], fArr3[i36], fArr3[i37]);
                                        f8 = fArr3[i34] + f28;
                                        f7 = fArr3[i35] + f5;
                                        float f35 = f28 + fArr3[i36];
                                        float f36 = fArr3[i37];
                                        f6 = f35;
                                        f9 = f36;
                                    }
                                    fArr = fArr3;
                                    c = c5;
                                    i3 = i4;
                                } else {
                                    i2 = i5;
                                    f5 = f29;
                                    int i38 = i2 + 2;
                                    int i39 = i2 + 3;
                                    int i40 = i2 + 4;
                                    int i41 = i2 + 5;
                                    path.rCubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i38], fArr3[i39], fArr3[i40], fArr3[i41]);
                                    f8 = fArr3[i38] + f28;
                                    f7 = fArr3[i39] + f5;
                                    f6 = f28 + fArr3[i40];
                                    f9 = fArr3[i41];
                                }
                                f3 = f5 + f9;
                                f22 = f8;
                                f23 = f7;
                                f4 = f6;
                                f28 = f4;
                                f29 = f3;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                            } else {
                                i2 = i5;
                                int i42 = i2 + 5;
                                int i43 = i2 + 6;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                a(path, f28, f29, fArr3[i42] + f28, fArr3[i43] + f29, fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                                f28 += fArr[i42];
                                f29 += fArr[i43];
                            }
                            i5 = i2 + i;
                            c4 = c;
                            c5 = c4;
                            fArr3 = fArr;
                            i4 = i3;
                            c2 = VKApiPhotoSize.M;
                        } else {
                            i2 = i5;
                            fArr = fArr3;
                            c = c5;
                            i3 = i4;
                            int i44 = i2 + 2;
                            int i45 = i2 + 3;
                            int i46 = i2 + 4;
                            int i47 = i2 + 5;
                            path.cubicTo(fArr[i2 + 0], fArr[i2 + 1], fArr[i44], fArr[i45], fArr[i46], fArr[i47]);
                            f28 = fArr[i46];
                            f29 = fArr[i47];
                            f2 = fArr[i44];
                            f = fArr[i45];
                        }
                        f22 = f2;
                        f23 = f;
                        i5 = i2 + i;
                        c4 = c;
                        c5 = c4;
                        fArr3 = fArr;
                        i4 = i3;
                        c2 = VKApiPhotoSize.M;
                    } else {
                        i2 = i5;
                        fArr = fArr3;
                        c = c5;
                        i3 = i4;
                        int i48 = i2 + 5;
                        int i49 = i2 + 6;
                        a(path, f28, f29, fArr[i48], fArr[i49], fArr[i2 + 0], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3] != 0.0f, fArr[i2 + 4] != 0.0f);
                        f28 = fArr[i48];
                        f29 = fArr[i49];
                    }
                    f23 = f29;
                    f22 = f28;
                    i5 = i2 + i;
                    c4 = c;
                    c5 = c4;
                    fArr3 = fArr;
                    i4 = i3;
                    c2 = VKApiPhotoSize.M;
                }
                fArr2[0] = f28;
                fArr2[1] = f29;
                fArr2[2] = f22;
                fArr2[3] = f23;
                fArr2[4] = f26;
                fArr2[5] = f27;
                i4++;
                c4 = pathDataNodeArr[i4].mType;
                c2 = VKApiPhotoSize.M;
                c3 = 0;
                pathDataNodeArr2 = pathDataNodeArr;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i < fArr.length) {
                    this.mParams[i] = (pathDataNode2.mParams[i] * f) + ((1.0f - f) * fArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.a(fArr, 0, fArr.length);
        }
    }
}
