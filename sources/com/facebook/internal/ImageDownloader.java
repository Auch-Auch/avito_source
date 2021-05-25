package com.facebook.internal;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.LoggingBehavior;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class ImageDownloader {
    public static Handler a;
    public static WorkQueue b = new WorkQueue(8);
    public static WorkQueue c = new WorkQueue(2);
    public static final Map<e, d> d = new HashMap();

    public static class a implements Runnable {
        public final /* synthetic */ ImageRequest a;
        public final /* synthetic */ Exception b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Bitmap d;
        public final /* synthetic */ ImageRequest.Callback e;

        public a(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
            this.a = imageRequest;
            this.b = exc;
            this.c = z;
            this.d = bitmap;
            this.e = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.e.onCompleted(new ImageResponse(this.a, this.b, this.c, this.d));
        }
    }

    public static class b implements Runnable {
        public Context a;
        public e b;
        public boolean c;

        public b(Context context, e eVar, boolean z) {
            this.a = context;
            this.b = eVar;
            this.c = z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
            if (r2 != null) goto L_0x0070;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0067  */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                com.facebook.internal.ImageDownloader$e r0 = r11.b
                android.content.Context r1 = r11.a
                boolean r2 = r11.c
                android.os.Handler r3 = com.facebook.internal.ImageDownloader.a
                r3 = 0
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x006e
                android.net.Uri r2 = r0.a
                java.lang.String r6 = a2.g.r.g.a
                if (r2 != 0) goto L_0x0014
                goto L_0x0064
            L_0x0014:
                java.lang.String r2 = r2.toString()
                com.facebook.internal.FileLruCache r6 = a2.g.r.g.b()     // Catch:{ IOException -> 0x0060, all -> 0x005b }
                r8 = r3
                r7 = 0
            L_0x001e:
                java.lang.String r9 = a2.g.r.g.b     // Catch:{ IOException -> 0x0061, all -> 0x0058 }
                java.io.InputStream r9 = r6.get(r2, r9)     // Catch:{ IOException -> 0x0061, all -> 0x0058 }
                if (r9 == 0) goto L_0x004e
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0061, all -> 0x0058 }
                r2.<init>(r9)     // Catch:{ IOException -> 0x0061, all -> 0x0058 }
                r7 = 128(0x80, float:1.794E-43)
                char[] r8 = new char[r7]     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
                r9.<init>()     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            L_0x0034:
                int r10 = r2.read(r8, r5, r7)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
                if (r10 <= 0) goto L_0x003e
                r9.append(r8, r5, r10)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
                goto L_0x0034
            L_0x003e:
                com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
                java.lang.String r7 = r9.toString()     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
                r8 = r2
                r2 = r7
                r7 = 1
                goto L_0x001e
            L_0x0049:
                r0 = move-exception
                r3 = r2
                goto L_0x005c
            L_0x004c:
                r8 = r2
                goto L_0x0061
            L_0x004e:
                if (r7 == 0) goto L_0x0061
                android.net.Uri r2 = android.net.Uri.parse(r2)
                com.facebook.internal.Utility.closeQuietly(r8)
                goto L_0x0065
            L_0x0058:
                r0 = move-exception
                r3 = r8
                goto L_0x005c
            L_0x005b:
                r0 = move-exception
            L_0x005c:
                com.facebook.internal.Utility.closeQuietly(r3)
                throw r0
            L_0x0060:
                r8 = r3
            L_0x0061:
                com.facebook.internal.Utility.closeQuietly(r8)
            L_0x0064:
                r2 = r3
            L_0x0065:
                if (r2 == 0) goto L_0x006e
                java.io.InputStream r2 = a2.g.r.d.b(r2, r1)
                if (r2 == 0) goto L_0x006f
                goto L_0x0070
            L_0x006e:
                r2 = r3
            L_0x006f:
                r4 = 0
            L_0x0070:
                if (r4 != 0) goto L_0x0078
                android.net.Uri r2 = r0.a
                java.io.InputStream r2 = a2.g.r.d.b(r2, r1)
            L_0x0078:
                if (r2 == 0) goto L_0x0085
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r2)
                com.facebook.internal.Utility.closeQuietly(r2)
                com.facebook.internal.ImageDownloader.b(r0, r3, r1, r4)
                goto L_0x009f
            L_0x0085:
                com.facebook.internal.ImageDownloader$d r1 = com.facebook.internal.ImageDownloader.c(r0)
                if (r1 == 0) goto L_0x009f
                boolean r2 = r1.c
                if (r2 != 0) goto L_0x009f
                com.facebook.internal.ImageRequest r1 = r1.b
                com.facebook.internal.WorkQueue r2 = com.facebook.internal.ImageDownloader.b
                com.facebook.internal.ImageDownloader$c r3 = new com.facebook.internal.ImageDownloader$c
                android.content.Context r4 = r1.getContext()
                r3.<init>(r4, r0)
                com.facebook.internal.ImageDownloader.a(r1, r0, r2, r3)
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.b.run():void");
        }
    }

    public static class c implements Runnable {
        public Context a;
        public e b;

        public c(Context context, e eVar) {
            this.a = context;
            this.b = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b7, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
            r6 = r1;
            r1 = null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x001a] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 213
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.c.run():void");
        }
    }

    public static class d {
        public WorkQueue.WorkItem a;
        public ImageRequest b;
        public boolean c;

        public d() {
        }

        public d(a aVar) {
        }
    }

    public static class e {
        public Uri a;
        public Object b;

        public e(Uri uri, Object obj) {
            this.a = uri;
            this.b = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (eVar.a == this.a && eVar.b == this.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.b.hashCode() + ((this.a.hashCode() + 1073) * 37);
        }
    }

    public static void a(ImageRequest imageRequest, e eVar, WorkQueue workQueue, Runnable runnable) {
        Map<e, d> map = d;
        synchronized (map) {
            d dVar = new d(null);
            dVar.b = imageRequest;
            map.put(eVar, dVar);
            dVar.a = workQueue.addActiveWorkItem(runnable);
        }
    }

    public static void b(e eVar, Exception exc, Bitmap bitmap, boolean z) {
        ImageRequest imageRequest;
        ImageRequest.Callback callback;
        Handler handler;
        d c2 = c(eVar);
        if (c2 != null && !c2.c && (callback = (imageRequest = c2.b).getCallback()) != null) {
            synchronized (ImageDownloader.class) {
                if (a == null) {
                    a = new Handler(Looper.getMainLooper());
                }
                handler = a;
            }
            handler.post(new a(imageRequest, exc, z, bitmap, callback));
        }
    }

    public static d c(e eVar) {
        d remove;
        Map<e, d> map = d;
        synchronized (map) {
            remove = map.remove(eVar);
        }
        return remove;
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        e eVar = new e(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<e, d> map = d;
        synchronized (map) {
            d dVar = map.get(eVar);
            z = true;
            if (dVar == null) {
                z = false;
            } else if (dVar.a.cancel()) {
                map.remove(eVar);
            } else {
                dVar.c = true;
            }
        }
        return z;
    }

    public static void clearCache(Context context) {
        String str = a2.g.r.d.a;
        try {
            a2.g.r.d.a().clearCache();
        } catch (IOException e2) {
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str2 = a2.g.r.d.a;
            StringBuilder L = a2.b.a.a.a.L("clearCache failed ");
            L.append(e2.getMessage());
            Logger.log(loggingBehavior, 5, str2, L.toString());
        }
        String str3 = g.a;
        try {
            g.b().clearCache();
        } catch (IOException e3) {
            LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
            String str4 = g.a;
            StringBuilder L2 = a2.b.a.a.a.L("clearCache failed ");
            L2.append(e3.getMessage());
            Logger.log(loggingBehavior2, 5, str4, L2.toString());
        }
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            e eVar = new e(imageRequest.getImageUri(), imageRequest.getCallerTag());
            Map<e, d> map = d;
            synchronized (map) {
                d dVar = map.get(eVar);
                if (dVar != null) {
                    dVar.b = imageRequest;
                    dVar.c = false;
                    dVar.a.moveToFront();
                } else {
                    a(imageRequest, eVar, c, new b(imageRequest.getContext(), eVar, imageRequest.isCachedRedirectAllowed()));
                }
            }
        }
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        e eVar = new e(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<e, d> map = d;
        synchronized (map) {
            d dVar = map.get(eVar);
            if (dVar != null) {
                dVar.a.moveToFront();
            }
        }
    }
}
