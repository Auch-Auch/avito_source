package com.jaredrummler.android.processes;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.jaredrummler.android.processes.models.AndroidProcess;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class AndroidProcesses {
    public static final String TAG = "AndroidProcesses";
    public static boolean a;

    public static final class ProcessComparator implements Comparator<AndroidProcess> {
        public int compare(AndroidProcess androidProcess, AndroidProcess androidProcess2) {
            return androidProcess.name.compareToIgnoreCase(androidProcess2.name);
        }
    }

    public AndroidProcesses() {
        throw new AssertionError("no instances");
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessInfo(Context context) {
        if (Build.VERSION.SDK_INT < 22) {
            return ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        }
        List<AndroidAppProcess> runningAppProcesses = getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        for (AndroidAppProcess androidAppProcess : runningAppProcesses) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo(androidAppProcess.name, androidAppProcess.pid, null);
            runningAppProcessInfo.uid = androidAppProcess.uid;
            arrayList.add(runningAppProcessInfo);
        }
        return arrayList;
    }

    public static List<AndroidAppProcess> getRunningAppProcesses() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(new AndroidAppProcess(parseInt));
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static List<AndroidAppProcess> getRunningForegroundApps(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        PackageManager packageManager = context.getPackageManager();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        AndroidAppProcess androidAppProcess = new AndroidAppProcess(parseInt);
                        if (androidAppProcess.foreground && (((i = androidAppProcess.uid) < 1000 || i > 9999) && !androidAppProcess.name.contains(":") && packageManager.getLaunchIntentForPackage(androidAppProcess.getPackageName()) != null)) {
                            arrayList.add(androidAppProcess);
                        }
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static List<AndroidProcess> getRunningProcesses() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(new AndroidProcess(parseInt));
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static boolean isLoggingEnabled() {
        return a;
    }

    public static boolean isMyProcessInTheForeground() {
        try {
            return new AndroidAppProcess(Process.myPid()).foreground;
        } catch (Exception e) {
            log(e, "Error finding our own process", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051 A[SYNTHETIC, Splitter:B:28:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isProcessInfoHidden() {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0055, all -> 0x004e }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0055, all -> 0x004e }
            java.lang.String r5 = "/proc/mounts"
            r4.<init>(r5)     // Catch:{ IOException -> 0x0055, all -> 0x004e }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0055, all -> 0x004e }
        L_0x000f:
            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r4 = "\\s+"
            java.lang.String[] r2 = r2.split(r4)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            int r4 = r2.length     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            r5 = 6
            if (r4 != r5) goto L_0x000f
            r4 = r2[r1]     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            java.lang.String r5 = "/proc"
            boolean r4 = r4.equals(r5)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            if (r4 == 0) goto L_0x000f
            r4 = 3
            r5 = r2[r4]     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            java.lang.String r6 = "hidepid=1"
            boolean r5 = r5.contains(r6)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            if (r5 != 0) goto L_0x003e
            r2 = r2[r4]     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            java.lang.String r4 = "hidepid=2"
            boolean r2 = r2.contains(r4)     // Catch:{ IOException -> 0x004c, all -> 0x0049 }
            if (r2 == 0) goto L_0x003f
        L_0x003e:
            r0 = 1
        L_0x003f:
            r3.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            return r0
        L_0x0043:
            r3.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x005a
        L_0x0047:
            goto L_0x005a
        L_0x0049:
            r0 = move-exception
            r2 = r3
            goto L_0x004f
        L_0x004c:
            r2 = r3
            goto L_0x0055
        L_0x004e:
            r0 = move-exception
        L_0x004f:
            if (r2 == 0) goto L_0x0054
            r2.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            throw r0
        L_0x0055:
            if (r2 == 0) goto L_0x005a
            r2.close()
        L_0x005a:
            java.lang.String r2 = "readproc"
            int r2 = android.os.Process.getUidForName(r2)
            r3 = 3009(0xbc1, float:4.217E-42)
            if (r2 != r3) goto L_0x0065
            r0 = 1
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaredrummler.android.processes.AndroidProcesses.isProcessInfoHidden():boolean");
    }

    public static void log(String str, Object... objArr) {
        if (a && objArr.length != 0) {
            String.format(str, objArr);
        }
    }

    public static void setLoggingEnabled(boolean z) {
        a = z;
    }

    public static void log(Throwable th, String str, Object... objArr) {
        if (a && objArr.length != 0) {
            String.format(str, objArr);
        }
    }
}
