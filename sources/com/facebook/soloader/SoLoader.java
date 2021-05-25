package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.StrictMode;
import android.os.Trace;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class SoLoader {
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    public static final boolean a = true;
    @Nullable
    public static SoFileLoader b;
    public static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static SoSource[] d = null;
    @GuardedBy("sSoSourcesLock")
    public static volatile int e = 0;
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static UnpackingSoSource[] f;
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static ApplicationSoSource g;
    @GuardedBy("SoLoader.class")
    public static final HashSet<String> h = new HashSet<>();
    @GuardedBy("SoLoader.class")
    public static final Map<String, Object> i = new HashMap();
    public static final Set<String> j = Collections.newSetFromMap(new ConcurrentHashMap());
    @Nullable
    public static SystemLoadLibraryWrapper k = null;
    @GuardedBy("sSoSourcesLock")
    public static int l;
    public static boolean m;

    @DoNotOptimize
    @TargetApi(14)
    public static class Api14Utils {
        private Api14Utils() {
        }

        public static String a() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                StringBuilder L = a2.b.a.a.a.L("ClassLoader ");
                L.append(classLoader.getClass().getName());
                L.append(" should be of type BaseDexClassLoader");
                throw new IllegalStateException(L.toString());
            }
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public WrongAbiError(java.lang.Throwable r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "APK was built for a different platform. Supported ABIs: "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                java.lang.String[] r1 = com.facebook.soloader.SysUtil.getSupportedAbis()
                java.lang.String r1 = java.util.Arrays.toString(r1)
                r0.append(r1)
                java.lang.String r1 = " error: "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4)
                r2.initCause(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.WrongAbiError.<init>(java.lang.Throwable, java.lang.String):void");
        }
    }

    public static class a implements SoFileLoader {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Runtime d;
        public final /* synthetic */ Method e;

        public a(boolean z, String str, String str2, Runtime runtime, Method method) {
            this.a = z;
            this.b = str;
            this.c = str2;
            this.d = runtime;
            this.e = method;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
            r7.addSuppressed(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.String r7) {
            /*
                r6 = this;
                java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                r0.<init>(r7)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                java.lang.String r7 = "MD5"
                java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                r1.<init>(r0)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                r0 = 4096(0x1000, float:5.74E-42)
                byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0037 }
            L_0x0014:
                int r2 = r1.read(r0)     // Catch:{ all -> 0x0037 }
                r3 = 0
                if (r2 <= 0) goto L_0x001f
                r7.update(r0, r3, r2)     // Catch:{ all -> 0x0037 }
                goto L_0x0014
            L_0x001f:
                java.lang.String r0 = "%32x"
                r2 = 1
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0037 }
                java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ all -> 0x0037 }
                byte[] r7 = r7.digest()     // Catch:{ all -> 0x0037 }
                r5.<init>(r2, r7)     // Catch:{ all -> 0x0037 }
                r4[r3] = r5     // Catch:{ all -> 0x0037 }
                java.lang.String r7 = java.lang.String.format(r0, r4)     // Catch:{ all -> 0x0037 }
                r1.close()
                goto L_0x0054
            L_0x0037:
                r7 = move-exception
                throw r7     // Catch:{ all -> 0x0039 }
            L_0x0039:
                r0 = move-exception
                r1.close()     // Catch:{ all -> 0x003e }
                goto L_0x0042
            L_0x003e:
                r1 = move-exception
                r7.addSuppressed(r1)
            L_0x0042:
                throw r0
            L_0x0043:
                r7 = move-exception
                java.lang.String r7 = r7.toString()
                goto L_0x0054
            L_0x0049:
                r7 = move-exception
                java.lang.String r7 = r7.toString()
                goto L_0x0054
            L_0x004f:
                r7 = move-exception
                java.lang.String r7 = r7.toString()
            L_0x0054:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.a.a(java.lang.String):java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
            if (r10 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
            a(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
        @Override // com.facebook.soloader.SoFileLoader
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void load(java.lang.String r9, int r10) {
            /*
                r8 = this;
                boolean r0 = r8.a
                if (r0 == 0) goto L_0x007a
                r0 = 4
                r10 = r10 & r0
                r1 = 1
                r2 = 0
                if (r10 != r0) goto L_0x000c
                r10 = 1
                goto L_0x000d
            L_0x000c:
                r10 = 0
            L_0x000d:
                if (r10 == 0) goto L_0x0012
                java.lang.String r10 = r8.b
                goto L_0x0014
            L_0x0012:
                java.lang.String r10 = r8.c
            L_0x0014:
                r0 = 0
                java.lang.Runtime r3 = r8.d     // Catch:{ IllegalAccessException -> 0x0058, IllegalArgumentException -> 0x0056, InvocationTargetException -> 0x0054, all -> 0x004f }
                monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0058, IllegalArgumentException -> 0x0056, InvocationTargetException -> 0x0054, all -> 0x004f }
                java.lang.reflect.Method r4 = r8.e     // Catch:{ all -> 0x0041 }
                java.lang.Runtime r5 = r8.d     // Catch:{ all -> 0x0041 }
                r6 = 3
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0041 }
                r6[r2] = r9     // Catch:{ all -> 0x0041 }
                java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x0041 }
                r6[r1] = r2     // Catch:{ all -> 0x0041 }
                r1 = 2
                r6[r1] = r10     // Catch:{ all -> 0x0041 }
                java.lang.Object r10 = r4.invoke(r5, r6)     // Catch:{ all -> 0x0041 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0041 }
                if (r10 != 0) goto L_0x003b
                monitor-exit(r3)     // Catch:{ all -> 0x004d }
                if (r10 == 0) goto L_0x007d
                r8.a(r9)
                goto L_0x007d
            L_0x003b:
                java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError
                r0.<init>(r10)
                throw r0
            L_0x0041:
                r10 = move-exception
                r7 = r0
                r0 = r10
                r10 = r7
            L_0x0045:
                monitor-exit(r3)
                throw r0     // Catch:{ IllegalAccessException -> 0x004b, IllegalArgumentException -> 0x0049, InvocationTargetException -> 0x0047 }
            L_0x0047:
                r0 = move-exception
                goto L_0x005c
            L_0x0049:
                r0 = move-exception
                goto L_0x005c
            L_0x004b:
                r0 = move-exception
                goto L_0x005c
            L_0x004d:
                r0 = move-exception
                goto L_0x0045
            L_0x004f:
                r10 = move-exception
                r7 = r0
                r0 = r10
                r10 = r7
                goto L_0x0074
            L_0x0054:
                r10 = move-exception
                goto L_0x0059
            L_0x0056:
                r10 = move-exception
                goto L_0x0059
            L_0x0058:
                r10 = move-exception
            L_0x0059:
                r7 = r0
                r0 = r10
                r10 = r7
            L_0x005c:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r1.<init>()     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = "Error: Cannot load "
                r1.append(r2)     // Catch:{ all -> 0x0073 }
                r1.append(r9)     // Catch:{ all -> 0x0073 }
                java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x0073 }
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                r1.<init>(r10, r0)     // Catch:{ all -> 0x0073 }
                throw r1     // Catch:{ all -> 0x0073 }
            L_0x0073:
                r0 = move-exception
            L_0x0074:
                if (r10 == 0) goto L_0x0079
                r8.a(r9)
            L_0x0079:
                throw r0
            L_0x007a:
                java.lang.System.load(r9)
            L_0x007d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.a.load(java.lang.String, int):void");
        }
    }

    public static void a() {
        if (!isInitialized()) {
            throw new RuntimeException("SoLoader.init() not yet called");
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (d != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSource : d) {
                    String[] soSourceAbis = soSource.getSoSourceAbis();
                    for (String str : soSourceAbis) {
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = str.equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            reentrantReadWriteLock = c;
                        }
                    }
                }
                c.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            c.readLock().unlock();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r11, int r12, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r13) throws java.lang.UnsatisfiedLinkError {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.b(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void c(@javax.annotation.Nullable com.facebook.soloader.SoFileLoader r9) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            monitor-enter(r0)
            if (r9 == 0) goto L_0x0009
            com.facebook.soloader.SoLoader.b = r9     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)
            return
        L_0x0009:
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 1
            r4 = 0
            r6 = 0
            if (r1 < r2) goto L_0x0035
            r2 = 27
            if (r1 <= r2) goto L_0x001d
            goto L_0x0035
        L_0x001d:
            java.lang.Class<java.lang.Runtime> r1 = java.lang.Runtime.class
            java.lang.String r2 = "nativeLoad"
            r7 = 3
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            r7[r4] = r9     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            java.lang.Class<java.lang.ClassLoader> r8 = java.lang.ClassLoader.class
            r7[r3] = r8     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            r8 = 2
            r7[r8] = r9     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            java.lang.reflect.Method r9 = r1.getDeclaredMethod(r2, r7)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            r9.setAccessible(r3)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0035 }
            goto L_0x0036
        L_0x0035:
            r9 = r6
        L_0x0036:
            if (r9 == 0) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            if (r2 == 0) goto L_0x0043
            java.lang.String r1 = com.facebook.soloader.SoLoader.Api14Utils.a()
            r3 = r1
            goto L_0x0044
        L_0x0043:
            r3 = r6
        L_0x0044:
            java.lang.String r4 = makeNonZipPath(r3)
            com.facebook.soloader.SoLoader$a r7 = new com.facebook.soloader.SoLoader$a
            r1 = r7
            r6 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            com.facebook.soloader.SoLoader.b = r7
            monitor-exit(r0)
            return
        L_0x0053:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.c(com.facebook.soloader.SoFileLoader):void");
    }

    public static void d(Context context, int i2) throws IOException {
        int i3;
        c.writeLock().lock();
        try {
            if (d == null) {
                l = i2;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = SysUtil.is64Bit() ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    arrayList.add(new DirectorySoSource(new File(str2), 2));
                }
                if (context != null) {
                    if ((i2 & 1) != 0) {
                        f = null;
                        arrayList.add(0, new ExoSoSource(context, "lib-main"));
                    } else {
                        if (m) {
                            i3 = 0;
                        } else {
                            ApplicationSoSource applicationSoSource = new ApplicationSoSource(context, 0);
                            g = applicationSoSource;
                            applicationSoSource.toString();
                            arrayList.add(0, g);
                            i3 = 1;
                        }
                        if ((l & 8) != 0) {
                            f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file, "lib-main", i3);
                            arrayList2.add(apkSoSource);
                            apkSoSource.toString();
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, new File(strArr[i4]), "lib-" + i5, i3);
                                    apkSoSource2.toString();
                                    arrayList2.add(apkSoSource2);
                                    i4++;
                                    i5++;
                                }
                            }
                            f = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int f2 = f();
                int length2 = soSourceArr.length;
                while (true) {
                    int i6 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    String str3 = "Preparing SO source: " + soSourceArr[i6];
                    soSourceArr[i6].prepare(f2);
                    length2 = i6;
                }
                d = soSourceArr;
                e++;
                int length3 = d.length;
            }
        } finally {
            c.writeLock().unlock();
        }
    }

    public static void deinitForTest() {
        AppCompatDelegateImpl.i.U1(null);
    }

    public static boolean e(String str, @Nullable String str2, @Nullable String str3, int i2, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        HashSet<String> hashSet;
        boolean z;
        Object obj;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str2) && j.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            hashSet = h;
            if (!hashSet.contains(str)) {
                z = false;
            } else if (str3 == null) {
                return false;
            } else {
                z = true;
            }
            Map<String, Object> map = i;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                Object obj2 = new Object();
                map.put(str, obj2);
                obj = obj2;
            }
        }
        synchronized (obj) {
            if (!z) {
                synchronized (SoLoader.class) {
                    if (hashSet.contains(str)) {
                        if (str3 == null) {
                            return false;
                        }
                        z = true;
                    }
                }
                if (!z) {
                    try {
                        b(str, i2, threadPolicy);
                        synchronized (SoLoader.class) {
                            hashSet.add(str);
                        }
                    } catch (UnsatisfiedLinkError e2) {
                        String message = e2.getMessage();
                        if (message == null || !message.contains("unexpected e_machine:")) {
                            throw e2;
                        }
                        throw new WrongAbiError(e2, message.substring(message.lastIndexOf("unexpected e_machine:")));
                    }
                }
            }
            if ((i2 & 16) == 0) {
                if (!TextUtils.isEmpty(str2) && j.contains(str2)) {
                    z2 = true;
                }
                if (str3 != null && !z2) {
                    if (a) {
                        Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                    }
                    try {
                        AppCompatDelegateImpl.i.S0(str2);
                        throw null;
                    } catch (UnsatisfiedLinkError e3) {
                        throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e3);
                    } catch (Throwable th) {
                        if (a) {
                            Trace.endSection();
                        }
                        throw th;
                    }
                }
            }
            return !z;
        }
    }

    public static int f() {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i2 = (l & 2) != 0 ? 1 : 0;
            reentrantReadWriteLock.writeLock().unlock();
            return i2;
        } catch (Throwable th) {
            c.writeLock().unlock();
            throw th;
        }
    }

    public static File g(String str) throws IOException {
        c.readLock().lock();
        try {
            for (SoSource soSource : d) {
                File unpackLibrary = soSource.unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
            }
            c.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            c.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        c.readLock().lock();
        try {
            String[] strArr = null;
            if (d != null) {
                int i2 = 0;
                while (strArr == null) {
                    SoSource[] soSourceArr = d;
                    if (i2 >= soSourceArr.length) {
                        break;
                    }
                    strArr = soSourceArr[i2].getLibraryDependencies(str);
                    i2++;
                }
            }
            return strArr;
        } finally {
            c.readLock().unlock();
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        c.readLock().lock();
        try {
            String str2 = null;
            if (d != null) {
                int i2 = 0;
                while (str2 == null) {
                    SoSource[] soSourceArr = d;
                    if (i2 >= soSourceArr.length) {
                        break;
                    }
                    str2 = soSourceArr[i2].getLibraryPath(str);
                    i2++;
                }
            }
            return str2;
        } finally {
            c.readLock().unlock();
        }
    }

    public static int getSoSourcesVersion() {
        return e;
    }

    public static void init(Context context, int i2) throws IOException {
        init(context, i2, null);
    }

    public static boolean isInitialized() {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            boolean z = d != null;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            c.readLock().unlock();
            throw th;
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static String makeLdLibraryPath() {
        c.readLock().lock();
        try {
            a();
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = d;
            if (soSourceArr != null) {
                for (SoSource soSource : soSourceArr) {
                    soSource.addToLdLibraryPath(arrayList);
                }
            }
            return TextUtils.join(":", arrayList);
        } finally {
            c.readLock().unlock();
        }
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            String str = "Prepending to SO sources: " + soSource;
            a();
            soSource.prepare(f());
            SoSource[] soSourceArr = d;
            SoSource[] soSourceArr2 = new SoSource[(soSourceArr.length + 1)];
            soSourceArr2[0] = soSource;
            System.arraycopy(soSourceArr, 0, soSourceArr2, 1, soSourceArr.length);
            d = soSourceArr2;
            e++;
            String str2 = "Prepended to SO sources: " + soSource;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            c.writeLock().unlock();
            throw th;
        }
    }

    public static void setInTestMode() {
        AppCompatDelegateImpl.i.U1(new SoSource[]{new NoopSoSource()});
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        k = systemLoadLibraryWrapper;
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        a();
        try {
            return g(System.mapLibraryName(str));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void init(Context context, int i2, @Nullable SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z = false;
        if ((i2 & 32) == 0 && context != null) {
            try {
                if ((context.getApplicationInfo().flags & 129) != 0) {
                    z = true;
                }
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        }
        m = z;
        c(soFileLoader);
        d(context, i2);
        if (!NativeLoader.isInitialized()) {
            NativeLoader.init(new NativeLoaderToSoLoaderDelegate());
        }
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
    }

    public static boolean loadLibrary(String str, int i2) throws UnsatisfiedLinkError {
        boolean z;
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean z2;
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (d == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    a();
                } else {
                    synchronized (SoLoader.class) {
                        z2 = !h.contains(str);
                        if (z2) {
                            SystemLoadLibraryWrapper systemLoadLibraryWrapper2 = k;
                            if (systemLoadLibraryWrapper2 != null) {
                                systemLoadLibraryWrapper2.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z2;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            if (!m || (systemLoadLibraryWrapper = k) == null) {
                String mapLibraryName = System.mapLibraryName(str);
                boolean z3 = false;
                do {
                    try {
                        z3 = e(mapLibraryName, str, null, i2, null);
                        z = false;
                        continue;
                    } catch (UnsatisfiedLinkError e2) {
                        int i3 = e;
                        c.writeLock().lock();
                        try {
                            if (g == null || !g.checkAndMaybeUpdate()) {
                                z = false;
                            } else {
                                e++;
                                z = true;
                            }
                            c.writeLock().unlock();
                            if (e == i3) {
                                throw e2;
                            }
                        } catch (IOException e3) {
                            throw new RuntimeException(e3);
                        } catch (Throwable th) {
                            c.writeLock().unlock();
                            throw th;
                        }
                    }
                } while (z);
                return z3;
            }
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        } catch (Throwable th2) {
            c.readLock().unlock();
            throw th2;
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
