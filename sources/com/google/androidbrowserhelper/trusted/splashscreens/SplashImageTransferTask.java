package com.google.androidbrowserhelper.trusted.splashscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsSession;
public class SplashImageTransferTask {
    public final Context a;
    public final Bitmap b;
    public final String c;
    public final CustomTabsSession d;
    public final String e;
    @Nullable
    public Callback f;
    @SuppressLint({"StaticFieldLeak"})
    public final AsyncTask<Void, Void, Boolean> g = new a();

    public interface Callback {
        void onFinished(boolean z);
    }

    public class a extends AsyncTask<Void, Void, Boolean> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c1, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c6, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c7, code lost:
            r9.addSuppressed(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
            throw r0;
         */
        @Override // android.os.AsyncTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.Void[] r9) {
            /*
                r8 = this;
                java.lang.Void[] r9 = (java.lang.Void[]) r9
                boolean r9 = r8.isCancelled()
                if (r9 == 0) goto L_0x000c
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                goto L_0x00be
            L_0x000c:
                java.io.File r9 = new java.io.File
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r0 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this
                android.content.Context r0 = r0.a
                java.io.File r0 = r0.getFilesDir()
                java.lang.String r1 = "twa_splash"
                r9.<init>(r0, r1)
                boolean r0 = r9.exists()
                if (r0 != 0) goto L_0x002b
                boolean r0 = r9.mkdir()
                if (r0 != 0) goto L_0x002b
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                goto L_0x00be
            L_0x002b:
                java.io.File r0 = new java.io.File
                java.lang.String r1 = "splash_image.png"
                r0.<init>(r9, r1)
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r9 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this
                android.content.Context r9 = r9.a
                r1 = 0
                java.lang.String r2 = "splashImagePrefs"
                android.content.SharedPreferences r9 = r9.getSharedPreferences(r2, r1)
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r2 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this     // Catch:{ NameNotFoundException -> 0x00d2 }
                android.content.Context r2 = r2.a     // Catch:{ NameNotFoundException -> 0x00d2 }
                android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00d2 }
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r3 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this     // Catch:{ NameNotFoundException -> 0x00d2 }
                android.content.Context r3 = r3.a     // Catch:{ NameNotFoundException -> 0x00d2 }
                java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x00d2 }
                android.content.pm.PackageInfo r1 = r2.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x00d2 }
                long r1 = r1.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x00d2 }
                boolean r3 = r0.exists()
                java.lang.String r4 = "lastUpdateTime"
                if (r3 == 0) goto L_0x0078
                r5 = 0
                long r5 = r9.getLong(r4, r5)
                int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r3 != 0) goto L_0x0078
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r9 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this
                android.content.Context r1 = r9.a
                java.lang.String r2 = r9.c
                java.lang.String r3 = r9.e
                androidx.browser.customtabs.CustomTabsSession r9 = r9.d
                boolean r9 = androidx.browser.customtabs.TrustedWebUtils.transferSplashImage(r1, r0, r2, r3, r9)
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                goto L_0x00be
            L_0x0078:
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cb }
                r3.<init>(r0)     // Catch:{ Exception -> 0x00cb }
                boolean r5 = r8.isCancelled()     // Catch:{ all -> 0x00bf }
                if (r5 == 0) goto L_0x0089
                java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00bf }
            L_0x0085:
                r3.close()
                goto L_0x00be
            L_0x0089:
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r5 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this
                android.graphics.Bitmap r5 = r5.b
                android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.PNG
                r7 = 100
                r5.compress(r6, r7, r3)
                r3.flush()
                android.content.SharedPreferences$Editor r9 = r9.edit()
                android.content.SharedPreferences$Editor r9 = r9.putLong(r4, r1)
                r9.commit()
                boolean r9 = r8.isCancelled()
                if (r9 == 0) goto L_0x00ab
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                goto L_0x0085
            L_0x00ab:
                com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask r9 = com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.this
                android.content.Context r1 = r9.a
                java.lang.String r2 = r9.c
                java.lang.String r4 = r9.e
                androidx.browser.customtabs.CustomTabsSession r9 = r9.d
                boolean r9 = androidx.browser.customtabs.TrustedWebUtils.transferSplashImage(r1, r0, r2, r4, r9)
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                goto L_0x0085
            L_0x00be:
                return r9
            L_0x00bf:
                r9 = move-exception
                throw r9     // Catch:{ all -> 0x00c1 }
            L_0x00c1:
                r0 = move-exception
                r3.close()     // Catch:{ all -> 0x00c6 }
                goto L_0x00ca
            L_0x00c6:
                r1 = move-exception
                r9.addSuppressed(r1)
            L_0x00ca:
                throw r0
            L_0x00cb:
                r9 = move-exception
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r0.<init>(r9)
                throw r0
            L_0x00d2:
                r9 = move-exception
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.a.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            if (SplashImageTransferTask.this.f != null && !isCancelled()) {
                SplashImageTransferTask.this.f.onFinished(bool2.booleanValue());
            }
        }
    }

    public SplashImageTransferTask(Context context, Bitmap bitmap, String str, CustomTabsSession customTabsSession, String str2) {
        this.a = context.getApplicationContext();
        this.b = bitmap;
        this.c = str;
        this.d = customTabsSession;
        this.e = str2;
    }

    public void cancel() {
        this.g.cancel(true);
        this.f = null;
    }

    public void execute(Callback callback) {
        this.f = callback;
        this.g.execute(new Void[0]);
    }
}
