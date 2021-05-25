package com.google.android.gms.internal.mlkit_common;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
public final class zzn {
    private static final Method zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Field zzd;
    private static final Field zze;
    private static final Field zzf;
    private static final Object zzg;
    private static final Throwable zzh;

    static {
        Field field;
        Field field2;
        Method method;
        Method method2;
        Method method3;
        Field field3;
        Object obj;
        Throwable th;
        Throwable th2;
        Throwable th3;
        try {
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Class<?> cls2 = Class.forName("libcore.io.StructStat");
            Class<?> cls3 = Class.forName("libcore.io.OsConstants");
            Class<?> cls4 = Class.forName("libcore.io.ForwardingOs");
            method3 = cls3.getDeclaredMethod("S_ISLNK", Integer.TYPE);
            try {
                method3.setAccessible(true);
                method = cls4.getDeclaredMethod("lstat", String.class);
                try {
                    method2 = cls4.getDeclaredMethod("fstat", FileDescriptor.class);
                } catch (Throwable th4) {
                    th2 = th4;
                    field3 = null;
                    method2 = null;
                    field2 = null;
                    field = field2;
                    th = th2;
                    obj = field;
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = th;
                }
            } catch (Throwable th5) {
                th2 = th5;
                field3 = null;
                method2 = null;
                method = method2;
                field2 = method;
                field = field2;
                th = th2;
                obj = field;
                zza = method3;
                zzb = method;
                zzc = method2;
                zzd = field2;
                zze = field;
                zzf = field3;
                zzg = obj;
                zzh = th;
            }
            try {
                Field declaredField = cls.getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(cls);
            } catch (Throwable th6) {
                th2 = th6;
                field3 = null;
                field2 = null;
                field = field2;
                th = th2;
                obj = field;
                zza = method3;
                zzb = method;
                zzc = method2;
                zzd = field2;
                zze = field;
                zzf = field3;
                zzg = obj;
                zzh = th;
            }
            try {
                field2 = cls2.getField("st_dev");
                try {
                    field = cls2.getField("st_ino");
                    try {
                        field3 = cls2.getField("st_mode");
                    } catch (Throwable th7) {
                        field3 = null;
                        th = th7;
                        zza = method3;
                        zzb = method;
                        zzc = method2;
                        zzd = field2;
                        zze = field;
                        zzf = field3;
                        zzg = obj;
                        zzh = th;
                    }
                } catch (Throwable th8) {
                    th3 = th8;
                    field = null;
                    th = th3;
                    field3 = field;
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = th;
                }
                try {
                    field2.setAccessible(true);
                    field.setAccessible(true);
                    field3.setAccessible(true);
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = null;
                } catch (Throwable th9) {
                    th = th9;
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = th;
                }
            } catch (Throwable th10) {
                th3 = th10;
                field2 = null;
                field = null;
                th = th3;
                field3 = field;
                zza = method3;
                zzb = method;
                zzc = method2;
                zzd = field2;
                zze = field;
                zzf = field3;
                zzg = obj;
                zzh = th;
            }
        } catch (Throwable th11) {
            th2 = th11;
            field3 = null;
            method3 = null;
            method2 = null;
            method = method2;
            field2 = method;
            field = field2;
            th = th2;
            obj = field;
            zza = method3;
            zzb = method;
            zzc = method2;
            zzd = field2;
            zze = field;
            zzf = field3;
            zzg = obj;
            zzh = th;
        }
    }

    public static zzj zza(String str) throws IOException {
        return (zzj) zza((Callable<Object>) new Callable(str) { // from class: com.google.android.gms.internal.mlkit_common.zzm
            private final String zza;

            {
                this.zza = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzn.zzb(this.zza);
            }
        });
    }

    public static zzj zza(FileDescriptor fileDescriptor) throws IOException {
        return (zzj) zza((Callable<Object>) new Callable(fileDescriptor) { // from class: com.google.android.gms.internal.mlkit_common.zzp
            private final FileDescriptor zza;

            {
                this.zza = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzn.zzb(this.zza);
            }
        });
    }

    /* access modifiers changed from: private */
    public static zzj zza(Object obj) throws Exception {
        return new zzj(((Long) zzd.get(obj)).longValue(), ((Long) zze.get(obj)).longValue(), ((Boolean) zza.invoke(null, Integer.valueOf(((Integer) zzf.get(obj)).intValue()))).booleanValue());
    }

    private static <T> T zza(Callable<T> callable) throws IOException {
        try {
            th = zzh;
            if (th == null) {
                return callable.call();
            }
            throw new IOException(th);
        } finally {
            IOException iOException = new IOException(th);
        }
    }
}
