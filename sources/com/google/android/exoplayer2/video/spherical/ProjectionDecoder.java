package com.google.android.exoplayer2.video.spherical;
public final class ProjectionDecoder {
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c0 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> a(com.google.android.exoplayer2.util.ParsableByteArray r27) {
        /*
        // Method dump skipped, instructions count: 452
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.spherical.ProjectionDecoder.a(com.google.android.exoplayer2.util.ParsableByteArray):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.video.spherical.Projection decode(byte[] r7, int r8) {
        /*
            com.google.android.exoplayer2.util.ParsableByteArray r0 = new com.google.android.exoplayer2.util.ParsableByteArray
            r0.<init>(r7)
            r7 = 4
            r1 = 1
            r2 = 0
            r3 = 0
            r0.skipBytes(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            int r7 = r0.readInt()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            r0.setPosition(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            r4 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r7 != r4) goto L_0x001a
            r7 = 1
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            if (r7 == 0) goto L_0x0052
            r7 = 8
            r0.skipBytes(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            int r7 = r0.getPosition()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            int r4 = r0.limit()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
        L_0x002a:
            if (r7 >= r4) goto L_0x0057
            int r5 = r0.readInt()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            int r5 = r5 + r7
            if (r5 <= r7) goto L_0x0057
            if (r5 <= r4) goto L_0x0036
            goto L_0x0057
        L_0x0036:
            int r7 = r0.readInt()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            r6 = 2037673328(0x79746d70, float:7.9321256E34)
            if (r7 == r6) goto L_0x004a
            r6 = 1836279920(0x6d736870, float:4.7081947E27)
            if (r7 != r6) goto L_0x0045
            goto L_0x004a
        L_0x0045:
            r0.setPosition(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            r7 = r5
            goto L_0x002a
        L_0x004a:
            r0.setLimit(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            java.util.ArrayList r7 = a(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            goto L_0x0058
        L_0x0052:
            java.util.ArrayList r7 = a(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0057 }
            goto L_0x0058
        L_0x0057:
            r7 = r3
        L_0x0058:
            if (r7 != 0) goto L_0x005b
            return r3
        L_0x005b:
            int r0 = r7.size()
            if (r0 == r1) goto L_0x0077
            r4 = 2
            if (r0 == r4) goto L_0x0065
            return r3
        L_0x0065:
            com.google.android.exoplayer2.video.spherical.Projection r0 = new com.google.android.exoplayer2.video.spherical.Projection
            java.lang.Object r2 = r7.get(r2)
            com.google.android.exoplayer2.video.spherical.Projection$Mesh r2 = (com.google.android.exoplayer2.video.spherical.Projection.Mesh) r2
            java.lang.Object r7 = r7.get(r1)
            com.google.android.exoplayer2.video.spherical.Projection$Mesh r7 = (com.google.android.exoplayer2.video.spherical.Projection.Mesh) r7
            r0.<init>(r2, r7, r8)
            return r0
        L_0x0077:
            com.google.android.exoplayer2.video.spherical.Projection r0 = new com.google.android.exoplayer2.video.spherical.Projection
            java.lang.Object r7 = r7.get(r2)
            com.google.android.exoplayer2.video.spherical.Projection$Mesh r7 = (com.google.android.exoplayer2.video.spherical.Projection.Mesh) r7
            r0.<init>(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.spherical.ProjectionDecoder.decode(byte[], int):com.google.android.exoplayer2.video.spherical.Projection");
    }
}
