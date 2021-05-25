package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public final class DynamiteModule {
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzf();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzh();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzd();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zza();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzc();
    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static Boolean zza = null;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static zzk zzb = null;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static zzm zzc = null;
    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static String zzd = null;
    @GuardedBy("DynamiteModule.class")
    private static int zze = -1;
    private static final ThreadLocal<zza> zzf = new ThreadLocal<>();
    private static final VersionPolicy.zzb zzg = new zzb();
    private static final VersionPolicy zzh = new zzg();
    private final Context zzi;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @RecentlyNullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(String str, zzb zzb) {
            this(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, zzb zzb) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public static class zza {
            public int zza = 0;
            public int zzb = 0;
            public int zzc = 0;
        }

        public interface zzb {
            int zza(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        zza zza(Context context, String str, zzb zzb2) throws LoadingException;
    }

    public static class zza {
        public Cursor zza;

        private zza() {
        }

        public /* synthetic */ zza(zzb zzb) {
            this();
        }
    }

    public static class zzb implements VersionPolicy.zzb {
        private final int zza;
        private final int zzb = 0;

        public zzb(int i, int i2) {
            this.zza = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int zza(Context context, String str) {
            return this.zza;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int zza(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.zzi = (Context) Preconditions.checkNotNull(context);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static int getLocalVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String.valueOf(declaredField.get(null)).length();
            String.valueOf(str).length();
            return 0;
        } catch (ClassNotFoundException unused) {
            String.valueOf(str).length();
            return 0;
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf);
            } else {
                new String("Failed to load module descriptor class: ");
            }
            return 0;
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static int getRemoteVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        return zza(context, str, false);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static DynamiteModule load(@RecentlyNonNull Context context, @RecentlyNonNull VersionPolicy versionPolicy, @RecentlyNonNull String str) throws LoadingException {
        Cursor cursor;
        ThreadLocal<zza> threadLocal = zzf;
        zza zza2 = threadLocal.get();
        zza zza3 = new zza(null);
        threadLocal.set(zza3);
        try {
            VersionPolicy.zza zza4 = versionPolicy.zza(context, str, zzg);
            int i = zza4.zza;
            String.valueOf(str).length();
            String.valueOf(str).length();
            int i2 = zza4.zzc;
            if (i2 == 0 || ((i2 == -1 && zza4.zza == 0) || (i2 == 1 && zza4.zzb == 0))) {
                int i3 = zza4.zza;
                int i4 = zza4.zzb;
                StringBuilder sb = new StringBuilder(91);
                sb.append("No acceptable module found. Local version is ");
                sb.append(i3);
                sb.append(" and remote version is ");
                sb.append(i4);
                sb.append(".");
                throw new LoadingException(sb.toString(), (zzb) null);
            } else if (i2 == -1) {
                DynamiteModule zza5 = zza(context, str);
                Cursor cursor2 = zza3.zza;
                if (cursor2 != null) {
                    cursor2.close();
                }
                threadLocal.set(zza2);
                return zza5;
            } else if (i2 == 1) {
                try {
                    DynamiteModule zza6 = zza(context, str, zza4.zzb);
                    Cursor cursor3 = zza3.zza;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    threadLocal.set(zza2);
                    return zza6;
                } catch (LoadingException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        "Failed to load remote module: ".concat(valueOf);
                    } else {
                        new String("Failed to load remote module: ");
                    }
                    int i5 = zza4.zza;
                    if (i5 == 0 || versionPolicy.zza(context, str, new zzb(i5, 0)).zzc != -1) {
                        throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                    }
                    return zza(context, str);
                }
            } else {
                int i6 = zza4.zzc;
                StringBuilder sb2 = new StringBuilder(47);
                sb2.append("VersionPolicy returned invalid code:");
                sb2.append(i6);
                throw new LoadingException(sb2.toString(), (zzb) null);
            }
        } finally {
            cursor = zza3.zza;
            if (cursor != null) {
                cursor.close();
            }
            zzf.set(zza2);
        }
    }

    @RecentlyNonNull
    public static int zza(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
        Boolean bool;
        ClassLoader classLoader;
        try {
            synchronized (DynamiteModule.class) {
                bool = zza;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader2 = (ClassLoader) declaredField.get(null);
                            if (classLoader2 != null) {
                                if (classLoader2 == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        zza(classLoader2);
                                    } catch (LoadingException unused) {
                                    }
                                    bool = Boolean.TRUE;
                                }
                            } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    int zzc2 = zzc(context, str, z);
                                    String str2 = zzd;
                                    if (str2 != null) {
                                        if (!str2.isEmpty()) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                classLoader = new DelegateLastClassLoader((String) Preconditions.checkNotNull(zzd), ClassLoader.getSystemClassLoader());
                                            } else {
                                                classLoader = new zzi((String) Preconditions.checkNotNull(zzd), ClassLoader.getSystemClassLoader());
                                            }
                                            zza(classLoader);
                                            declaredField.set(null, classLoader);
                                            zza = Boolean.TRUE;
                                            return zzc2;
                                        }
                                    }
                                    return zzc2;
                                } catch (LoadingException unused2) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                }
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        String.valueOf(e).length();
                        bool = Boolean.FALSE;
                    }
                    zza = bool;
                }
            }
            if (!bool.booleanValue()) {
                return zzb(context, str, z);
            }
            try {
                return zzc(context, str, z);
            } catch (LoadingException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to retrieve remote module version: ".concat(valueOf);
                    return 0;
                }
                new String("Failed to retrieve remote module version: ");
                return 0;
            }
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x006f A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0073 A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r5, java.lang.String r6, boolean r7) {
        /*
            com.google.android.gms.dynamite.zzk r0 = zza(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r2 = 0
            int r3 = r0.zzb()     // Catch:{ RemoteException -> 0x005e }
            r4 = 3
            if (r3 < r4) goto L_0x0047
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x005e }
            com.google.android.gms.dynamic.IObjectWrapper r5 = r0.zzc(r5, r6, r7)     // Catch:{ RemoteException -> 0x005e }
            java.lang.Object r5 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5)     // Catch:{ RemoteException -> 0x005e }
            android.database.Cursor r5 = (android.database.Cursor) r5     // Catch:{ RemoteException -> 0x005e }
            if (r5 == 0) goto L_0x0041
            boolean r6 = r5.moveToFirst()     // Catch:{ RemoteException -> 0x003e, all -> 0x003b }
            if (r6 != 0) goto L_0x0027
            goto L_0x0041
        L_0x0027:
            int r6 = r5.getInt(r1)     // Catch:{ RemoteException -> 0x003e, all -> 0x003b }
            if (r6 <= 0) goto L_0x0034
            boolean r7 = zza(r5)     // Catch:{ RemoteException -> 0x003e, all -> 0x003b }
            if (r7 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = r5
        L_0x0035:
            if (r2 == 0) goto L_0x003a
            r2.close()
        L_0x003a:
            return r6
        L_0x003b:
            r6 = move-exception
            r2 = r5
            goto L_0x007e
        L_0x003e:
            r6 = move-exception
            r2 = r5
            goto L_0x005f
        L_0x0041:
            if (r5 == 0) goto L_0x0046
            r5.close()
        L_0x0046:
            return r1
        L_0x0047:
            r4 = 2
            if (r3 != r4) goto L_0x0053
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)
            int r5 = r0.zzb(r5, r6, r7)
            return r5
        L_0x0053:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)
            int r5 = r0.zza(r5, r6, r7)
            return r5
        L_0x005c:
            r6 = move-exception
            goto L_0x007e
        L_0x005e:
            r6 = move-exception
        L_0x005f:
            java.lang.String r5 = "Failed to retrieve remote module version: "
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x005c }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x005c }
            int r7 = r6.length()     // Catch:{ all -> 0x005c }
            if (r7 == 0) goto L_0x0073
            r5.concat(r6)     // Catch:{ all -> 0x005c }
            goto L_0x0078
        L_0x0073:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x005c }
            r6.<init>(r5)     // Catch:{ all -> 0x005c }
        L_0x0078:
            if (r2 == 0) goto L_0x007d
            r2.close()
        L_0x007d:
            return r1
        L_0x007e:
            if (r2 == 0) goto L_0x0083
            r2.close()
        L_0x0083:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        if (zza(r8) != false) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092 A[Catch:{ all -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093 A[Catch:{ all -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            if (r10 == 0) goto L_0x000a
            java.lang.String r8 = "api_force_staging"
            goto L_0x000c
        L_0x000a:
            java.lang.String r8 = "api"
        L_0x000c:
            int r10 = r8.length()     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            int r2 = r2.length()     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            r2.<init>(r10)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            r2.append(r8)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            r2.append(r9)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x008c, all -> 0x008a }
            if (r8 == 0) goto L_0x0082
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x007d, all -> 0x0079 }
            if (r9 == 0) goto L_0x0082
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x007d, all -> 0x0079 }
            if (r9 <= 0) goto L_0x0072
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x007d, all -> 0x0079 }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x006f }
            com.google.android.gms.dynamite.DynamiteModule.zzd = r1     // Catch:{ all -> 0x006f }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x006f }
            if (r1 < 0) goto L_0x0067
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x006f }
            com.google.android.gms.dynamite.DynamiteModule.zze = r1     // Catch:{ all -> 0x006f }
        L_0x0067:
            monitor-exit(r10)     // Catch:{ all -> 0x006f }
            boolean r10 = zza(r8)
            if (r10 == 0) goto L_0x0072
            goto L_0x0073
        L_0x006f:
            r9 = move-exception
            monitor-exit(r10)
            throw r9
        L_0x0072:
            r0 = r8
        L_0x0073:
            if (r0 == 0) goto L_0x0078
            r0.close()
        L_0x0078:
            return r9
        L_0x0079:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x009d
        L_0x007d:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x008e
        L_0x0082:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)
            throw r9
        L_0x008a:
            r8 = move-exception
            goto L_0x009d
        L_0x008c:
            r8 = move-exception
            r9 = r0
        L_0x008e:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x009b }
            if (r10 == 0) goto L_0x0093
            throw r8     // Catch:{ all -> 0x009b }
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x009b }
            throw r10     // Catch:{ all -> 0x009b }
        L_0x009b:
            r8 = move-exception
            r0 = r9
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.close()
        L_0x00a2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Context getModuleContext() {
        return this.zzi;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final IBinder instantiate(@RecentlyNonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzi.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws LoadingException, RemoteException {
        zzm zzm;
        IObjectWrapper iObjectWrapper;
        String.valueOf(str).length();
        synchronized (DynamiteModule.class) {
            zzm = zzc;
        }
        if (zzm != null) {
            zza zza2 = zzf.get();
            if (zza2 == null || zza2.zza == null) {
                throw new LoadingException("No result cursor", (zzb) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = zza2.zza;
            ObjectWrapper.wrap(null);
            if (zza().booleanValue()) {
                iObjectWrapper = zzm.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            } else {
                iObjectWrapper = zzm.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            }
            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (zzb) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzb) null);
    }

    private static boolean zza(Cursor cursor) {
        zza zza2 = zzf.get();
        if (zza2 == null || zza2.zza != null) {
            return false;
        }
        zza2.zza = cursor;
        return true;
    }

    private static DynamiteModule zza(Context context, String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        } else {
            new String("Selected local version of ");
        }
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        try {
            synchronized (DynamiteModule.class) {
                bool = zza;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (zzb) null);
            } else if (bool.booleanValue()) {
                return zzb(context, str, i);
            } else {
                String.valueOf(str).length();
                zzk zza2 = zza(context);
                if (zza2 != null) {
                    int zzb2 = zza2.zzb();
                    if (zzb2 >= 3) {
                        zza zza3 = zzf.get();
                        if (zza3 != null) {
                            iObjectWrapper = zza2.zza(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zza3.zza));
                        } else {
                            throw new LoadingException("No cached result cursor holder", (zzb) null);
                        }
                    } else if (zzb2 == 2) {
                        iObjectWrapper = zza2.zzb(ObjectWrapper.wrap(context), str, i);
                    } else {
                        iObjectWrapper = zza2.zza(ObjectWrapper.wrap(context), str, i);
                    }
                    if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                    }
                    throw new LoadingException("Failed to load remote module.", (zzb) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (zzb) null);
            }
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    @Nullable
    private static zzk zza(Context context) {
        zzk zzk;
        synchronized (DynamiteModule.class) {
            zzk zzk2 = zzb;
            if (zzk2 != null) {
                return zzk2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzk = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzk) {
                        zzk = (zzk) queryLocalInterface;
                    } else {
                        zzk = new zzj(iBinder);
                    }
                }
                if (zzk != null) {
                    zzb = zzk;
                    return zzk;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                } else {
                    new String("Failed to load IDynamiteLoader from GmsCore: ");
                }
            }
            return null;
        }
    }

    private static Boolean zza() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(zze >= 2);
        }
        return valueOf;
    }

    @GuardedBy("DynamiteModule.class")
    private static void zza(ClassLoader classLoader) throws LoadingException {
        zzm zzm;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzm = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzm) {
                    zzm = (zzm) queryLocalInterface;
                } else {
                    zzm = new zzl(iBinder);
                }
            }
            zzc = zzm;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }
}
