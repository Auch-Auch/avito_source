package com.otaliastudios.cameraview;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.engine.mappers.Camera1Mapper;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import java.io.File;
public class CameraUtils {
    public static final CameraLogger a = CameraLogger.create(CameraUtils.class.getSimpleName());

    public static class a implements Runnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ File b;
        public final /* synthetic */ Handler c;
        public final /* synthetic */ FileCallback d;

        /* renamed from: com.otaliastudios.cameraview.CameraUtils$a$a  reason: collision with other inner class name */
        public class RunnableC0307a implements Runnable {
            public final /* synthetic */ File a;

            public RunnableC0307a(File file) {
                this.a = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d.onFileReady(this.a);
            }
        }

        public a(byte[] bArr, File file, Handler handler, FileCallback fileCallback) {
            this.a = bArr;
            this.b = file;
            this.c = handler;
            this.d = fileCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.post(new RunnableC0307a(CameraUtils.writeToFile(this.a, this.b)));
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ BitmapFactory.Options d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Handler f;
        public final /* synthetic */ BitmapCallback g;

        public class a implements Runnable {
            public final /* synthetic */ Bitmap a;

            public a(Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.g.onBitmapReady(this.a);
            }
        }

        public b(byte[] bArr, int i, int i2, BitmapFactory.Options options, int i3, Handler handler, BitmapCallback bitmapCallback) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = options;
            this.e = i3;
            this.f = handler;
            this.g = bitmapCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.post(new a(CameraUtils.a(this.a, this.b, this.c, this.d, this.e)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074 A[SYNTHETIC, Splitter:B:33:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f A[SYNTHETIC, Splitter:B:42:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b0 A[Catch:{ OutOfMemoryError -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b1 A[Catch:{ OutOfMemoryError -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00be A[Catch:{ OutOfMemoryError -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ce A[Catch:{ OutOfMemoryError -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f4 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(@androidx.annotation.NonNull byte[] r21, int r22, int r23, @androidx.annotation.NonNull android.graphics.BitmapFactory.Options r24, int r25) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.CameraUtils.a(byte[], int, int, android.graphics.BitmapFactory$Options, int):android.graphics.Bitmap");
    }

    public static void b(@NonNull byte[] bArr, int i, int i2, @NonNull BitmapFactory.Options options, int i3, @NonNull BitmapCallback bitmapCallback) {
        WorkerHandler.execute(new b(bArr, i, i2, options, i3, new Handler(), bitmapCallback));
    }

    @Nullable
    @WorkerThread
    public static Bitmap decodeBitmap(@NonNull byte[] bArr) {
        return decodeBitmap(bArr, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static boolean hasCameraFacing(@NonNull Context context, @NonNull Facing facing) {
        int mapFacing = Camera1Mapper.get().mapFacing(facing);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == mapFacing) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCameras(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        throw r5;
     */
    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"NewApi"})
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File writeToFile(@androidx.annotation.NonNull byte[] r4, @androidx.annotation.NonNull java.io.File r5) {
        /*
            boolean r0 = r5.exists()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            boolean r0 = r5.delete()
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x002e }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002e }
            r2.<init>(r5)     // Catch:{ IOException -> 0x002e }
            r0.<init>(r2)     // Catch:{ IOException -> 0x002e }
            r0.write(r4)     // Catch:{ all -> 0x0022 }
            r0.flush()     // Catch:{ all -> 0x0022 }
            r0.close()
            return r5
        L_0x0022:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r0 = move-exception
            r4.addSuppressed(r0)
        L_0x002d:
            throw r5
        L_0x002e:
            r4 = move-exception
            com.otaliastudios.cameraview.CameraLogger r5 = com.otaliastudios.cameraview.CameraUtils.a
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            java.lang.String r3 = "writeToFile:"
            r0[r2] = r3
            r2 = 1
            java.lang.String r3 = "could not write file."
            r0[r2] = r3
            r2 = 2
            r0[r2] = r4
            r5.e(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.CameraUtils.writeToFile(byte[], java.io.File):java.io.File");
    }

    public static void decodeBitmap(@NonNull byte[] bArr, @NonNull BitmapCallback bitmapCallback) {
        decodeBitmap(bArr, Integer.MAX_VALUE, Integer.MAX_VALUE, bitmapCallback);
    }

    public static void decodeBitmap(@NonNull byte[] bArr, int i, int i2, @NonNull BitmapCallback bitmapCallback) {
        decodeBitmap(bArr, i, i2, new BitmapFactory.Options(), bitmapCallback);
    }

    public static void decodeBitmap(@NonNull byte[] bArr, int i, int i2, @NonNull BitmapFactory.Options options, @NonNull BitmapCallback bitmapCallback) {
        b(bArr, i, i2, options, -1, bitmapCallback);
    }

    @Nullable
    @WorkerThread
    public static Bitmap decodeBitmap(@NonNull byte[] bArr, int i, int i2) {
        return decodeBitmap(bArr, i, i2, new BitmapFactory.Options());
    }

    @Nullable
    @WorkerThread
    public static Bitmap decodeBitmap(@NonNull byte[] bArr, int i, int i2, @NonNull BitmapFactory.Options options) {
        return a(bArr, i, i2, options, -1);
    }

    public static void writeToFile(@NonNull byte[] bArr, @NonNull File file, @NonNull FileCallback fileCallback) {
        WorkerHandler.execute(new a(bArr, file, new Handler(), fileCallback));
    }
}
