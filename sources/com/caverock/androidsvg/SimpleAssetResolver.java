package com.caverock.androidsvg;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class SimpleAssetResolver extends SVGExternalFileResolver {
    public static final Set<String> b;
    public AssetManager a;

    static {
        HashSet hashSet = new HashSet(8);
        b = hashSet;
        hashSet.add("image/svg+xml");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/pjpeg");
        hashSet.add("image/gif");
        hashSet.add("image/bmp");
        hashSet.add("image/x-windows-bmp");
        hashSet.add("image/webp");
    }

    public SimpleAssetResolver(AssetManager assetManager) {
        this.a = assetManager;
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public boolean isFormatSupported(String str) {
        return b.contains(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r8 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r8 != null) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e A[SYNTHETIC, Splitter:B:16:0x003e] */
    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String resolveCSSStyleSheet(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.res.AssetManager r1 = r7.a     // Catch:{ IOException -> 0x0042, all -> 0x003b }
            java.io.InputStream r8 = r1.open(r8)     // Catch:{ IOException -> 0x0042, all -> 0x003b }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            r1.<init>(r8, r2)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            r2 = 4096(0x1000, float:5.74E-42)
            char[] r2 = new char[r2]     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            r3.<init>()     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
        L_0x001f:
            if (r4 <= 0) goto L_0x002a
            r5 = 0
            r3.append(r2, r5, r4)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            goto L_0x001f
        L_0x002a:
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            if (r8 == 0) goto L_0x0046
        L_0x0030:
            r8.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0046
        L_0x0034:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x003c
        L_0x0039:
            goto L_0x0043
        L_0x003b:
            r8 = move-exception
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            throw r8
        L_0x0042:
            r8 = r0
        L_0x0043:
            if (r8 == 0) goto L_0x0046
            goto L_0x0030
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SimpleAssetResolver.resolveCSSStyleSheet(java.lang.String):java.lang.String");
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Typeface resolveFont(String str, int i, String str2) {
        try {
            AssetManager assetManager = this.a;
            return Typeface.createFromAsset(assetManager, str + ".ttf");
        } catch (RuntimeException unused) {
            try {
                AssetManager assetManager2 = this.a;
                return Typeface.createFromAsset(assetManager2, str + ".otf");
            } catch (RuntimeException unused2) {
                return null;
            }
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Bitmap resolveImage(String str) {
        try {
            return BitmapFactory.decodeStream(this.a.open(str));
        } catch (IOException unused) {
            return null;
        }
    }
}
