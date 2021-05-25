package com.yandex.runtime;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Looper;
import com.avito.android.util.preferences.db_preferences.Types;
import com.yandex.runtime.internal.ReLinker;
public class Runtime extends RuntimeBase {
    private static final String TAG = "com.yandex.runtime.Runtime";
    private static boolean allLibrariesLoaded = false;
    private static Context applicationContext;

    public static Context getApplicationContext() {
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("init has not been called");
    }

    public static void init(Context context) {
        if (context == null) {
            throw new RuntimeException("null context passed to init");
        } else if (!isMainProcess(context)) {
            throw new RuntimeException("Runtime could be initialized from the application's main process");
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            if (applicationContext == null) {
                Context applicationContext2 = context.getApplicationContext();
                applicationContext = applicationContext2;
                int identifier = applicationContext2.getResources().getIdentifier("runtime_library_filter", Types.STRING, applicationContext.getPackageName());
                if (identifier != 0) {
                    for (String str : applicationContext.getString(identifier).split(",")) {
                        loadLibrary(context, str);
                    }
                    allLibrariesLoaded = true;
                } else {
                    loadLibrary(context, "c++_shared");
                    loadLibrary(context, BuildConfig.APPLICATION_ID);
                }
            }
            initUiThread();
        } else {
            throw new RuntimeException("Runtime could only be initialized from ui thread");
        }
    }

    private static native void initUiThread();

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A[Catch:{ IOException -> 0x008b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isMainProcess(android.content.Context r6) {
        /*
            java.lang.String r0 = r6.getPackageName()
            java.lang.String r1 = "activity"
            java.lang.Object r6 = r6.getSystemService(r1)
            android.app.ActivityManager r6 = (android.app.ActivityManager) r6
            java.util.List r6 = r6.getRunningAppProcesses()
            if (r6 == 0) goto L_0x0031
            java.util.Iterator r6 = r6.iterator()
        L_0x0016:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r6.next()
            android.app.ActivityManager$RunningAppProcessInfo r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1
            int r2 = android.os.Process.myPid()
            int r3 = r1.pid
            if (r2 != r3) goto L_0x0016
            java.lang.String r6 = r1.processName
            boolean r6 = r0.equals(r6)
            return r6
        L_0x0031:
            r6 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0082 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0082 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r4.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ all -> 0x0082 }
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0082 }
            r4.append(r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0082 }
            r3.<init>(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0082 }
            r1.<init>(r2)     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r6.<init>()     // Catch:{ all -> 0x0080 }
        L_0x0062:
            int r2 = r1.read()     // Catch:{ all -> 0x0080 }
            if (r2 <= 0) goto L_0x006d
            char r2 = (char) r2     // Catch:{ all -> 0x0080 }
            r6.append(r2)     // Catch:{ all -> 0x0080 }
            goto L_0x0062
        L_0x006d:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0080 }
            boolean r6 = r0.equals(r6)     // Catch:{ all -> 0x0080 }
            if (r6 == 0) goto L_0x007c
            r6 = 1
            r1.close()     // Catch:{ IOException -> 0x008b }
            return r6
        L_0x007c:
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008b
        L_0x0080:
            r6 = move-exception
            goto L_0x0085
        L_0x0082:
            r0 = move-exception
            r1 = r6
            r6 = r0
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r1.close()     // Catch:{ IOException -> 0x008b }
        L_0x008a:
            throw r6     // Catch:{ IOException -> 0x008b }
        L_0x008b:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.runtime.Runtime.isMainProcess(android.content.Context):boolean");
    }

    public static void loadLibrary(Context context, String str) {
        if (!allLibrariesLoaded) {
            try {
                ReLinker.loadLibrary(context, str);
            } catch (RuntimeException unused) {
                throw new UnsatisfiedLinkError(a.c3("Couldn't load ", str));
            }
        }
    }
}
