package com.google.mlkit.vision.common.internal;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.mlkit.vision.common.InputImage;
import java.io.IOException;
import java.io.InputStream;
@KeepForSdk
public class ImageUtils {
    public static final GmsLogger a = new GmsLogger("MLKitImageUtils", "");
    public static ImageUtils b = new ImageUtils();

    public static int a(ContentResolver contentResolver, Uri uri) {
        if (!"content".equals(uri.getScheme()) && !"file".equals(uri.getScheme())) {
            return 0;
        }
        ExifInterface exifInterface = null;
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream != null) {
                try {
                    exifInterface = new ExifInterface(openInputStream);
                } catch (Throwable th) {
                    zzn.zza(th, th);
                }
            }
            if (openInputStream != null) {
                openInputStream.close();
            }
        } catch (IOException e) {
            GmsLogger gmsLogger = a;
            String valueOf = String.valueOf(uri);
            gmsLogger.e("MLKitImageUtils", a.r2(valueOf.length() + 48, "failed to open file to read rotation meta data: ", valueOf), e);
        }
        if (exifInterface == null) {
            return 0;
        }
        return exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        throw th;
    }

    @KeepForSdk
    public static ImageUtils getInstance() {
        return b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e A[Catch:{ FileNotFoundException -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap zza(android.content.ContentResolver r8, android.net.Uri r9) throws java.io.IOException {
        /*
            android.graphics.Bitmap r7 = android.provider.MediaStore.Images.Media.getBitmap(r8, r9)     // Catch:{ FileNotFoundException -> 0x005d }
            int r8 = a(r8, r9)     // Catch:{ FileNotFoundException -> 0x005d }
            android.graphics.Matrix r0 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x005d }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x005d }
            int r3 = r7.getWidth()     // Catch:{ FileNotFoundException -> 0x005d }
            int r4 = r7.getHeight()     // Catch:{ FileNotFoundException -> 0x005d }
            r1 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r2 = 1119092736(0x42b40000, float:90.0)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            switch(r8) {
                case 2: goto L_0x0043;
                case 3: goto L_0x003c;
                case 4: goto L_0x0038;
                case 5: goto L_0x0031;
                case 6: goto L_0x002d;
                case 7: goto L_0x0026;
                case 8: goto L_0x0022;
                default: goto L_0x0020;
            }     // Catch:{ FileNotFoundException -> 0x005d }
        L_0x0020:
            r8 = 0
            goto L_0x004b
        L_0x0022:
            r0.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x005d }
            goto L_0x0041
        L_0x0026:
            r0.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x005d }
            r0.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005d }
            goto L_0x0041
        L_0x002d:
            r0.postRotate(r2)     // Catch:{ FileNotFoundException -> 0x005d }
            goto L_0x0041
        L_0x0031:
            r0.postRotate(r2)     // Catch:{ FileNotFoundException -> 0x005d }
            r0.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005d }
            goto L_0x0041
        L_0x0038:
            r0.postScale(r6, r5)     // Catch:{ FileNotFoundException -> 0x005d }
            goto L_0x0041
        L_0x003c:
            r8 = 1127481344(0x43340000, float:180.0)
            r0.postRotate(r8)     // Catch:{ FileNotFoundException -> 0x005d }
        L_0x0041:
            r5 = r0
            goto L_0x004c
        L_0x0043:
            android.graphics.Matrix r8 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x005d }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x005d }
            r8.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005d }
        L_0x004b:
            r5 = r8
        L_0x004c:
            if (r5 == 0) goto L_0x005c
            r1 = 0
            r2 = 0
            r6 = 1
            r0 = r7
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ FileNotFoundException -> 0x005d }
            if (r7 == r8) goto L_0x005c
            r7.recycle()     // Catch:{ FileNotFoundException -> 0x005d }
            r7 = r8
        L_0x005c:
            return r7
        L_0x005d:
            r8 = move-exception
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.vision.common.internal.ImageUtils.a
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            int r1 = r1 + 21
            java.lang.String r2 = "Could not open file: "
            java.lang.String r9 = a2.b.a.a.a.r2(r1, r2, r9)
            java.lang.String r1 = "MLKitImageUtils"
            r0.e(r1, r9, r8)
            throw r8
            switch-data {2->0x0043, 3->0x003c, 4->0x0038, 5->0x0031, 6->0x002d, 7->0x0026, 8->0x0022, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }

    @KeepForSdk
    public int getMobileVisionImageFormat(@NonNull InputImage inputImage) {
        return inputImage.getFormat();
    }

    @KeepForSdk
    @TargetApi(19)
    public int getMobileVisionImageSize(@NonNull InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return inputImage.getBitmapInternal().getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return inputImage.getByteBuffer().limit();
        }
        if (inputImage.getFormat() == 35) {
            return (inputImage.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        return 0;
    }
}
