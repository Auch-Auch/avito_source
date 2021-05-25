package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
public final class zzld {
    private static final Logger logger = Logger.getLogger(zzld.class.getName());
    private static final Unsafe zzaaj;
    private static final boolean zzacj;
    private static final boolean zzack;
    private static final zzc zzacl;
    private static final boolean zzacm = zzji();
    private static final long zzacn;
    private static final long zzaco = ((long) zzi(boolean[].class));
    private static final long zzacp = ((long) zzj(boolean[].class));
    private static final long zzacq = ((long) zzi(int[].class));
    private static final long zzacr = ((long) zzj(int[].class));
    private static final long zzacs = ((long) zzi(long[].class));
    private static final long zzact = ((long) zzj(long[].class));
    private static final long zzacu = ((long) zzi(float[].class));
    private static final long zzacv = ((long) zzj(float[].class));
    private static final long zzacw = ((long) zzi(double[].class));
    private static final long zzacx = ((long) zzj(double[].class));
    private static final long zzacy = ((long) zzi(Object[].class));
    private static final long zzacz = ((long) zzj(Object[].class));
    private static final long zzada;
    private static final int zzadb;
    public static final boolean zzadc = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Class<?> zzti = zzgl.zzem();
    private static final boolean zzun = zzjh();

    public static abstract class zzc {
        public Unsafe zzadd;

        public zzc(Unsafe unsafe) {
            this.zzadd = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzadd.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zzadd.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzadd.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzadd.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    public static final class zzd extends zzc {
        public zzd(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, boolean z) {
            this.zzadd.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zze(Object obj, long j, byte b) {
            this.zzadd.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final boolean zzm(Object obj, long j) {
            return this.zzadd.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final float zzn(Object obj, long j) {
            return this.zzadd.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final double zzo(Object obj, long j) {
            return this.zzadd.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final byte zzy(Object obj, long j) {
            return this.zzadd.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, float f) {
            this.zzadd.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, double d) {
            this.zzadd.putDouble(obj, j, d);
        }
    }

    static {
        Unsafe zzjg = zzjg();
        zzaaj = zzjg;
        boolean zzk = zzk(Long.TYPE);
        zzacj = zzk;
        boolean zzk2 = zzk(Integer.TYPE);
        zzack = zzk2;
        zzc zzc2 = null;
        if (zzjg != null) {
            if (!zzgl.zzel()) {
                zzc2 = new zzd(zzjg);
            } else if (zzk) {
                zzc2 = new zza(zzjg);
            } else if (zzk2) {
                zzc2 = new zzb(zzjg);
            }
        }
        zzacl = zzc2;
        long zzi = (long) zzi(byte[].class);
        zzacn = zzi;
        Field zzjj = zzjj();
        zzada = (zzjj == null || zzc2 == null) ? -1 : zzc2.zzadd.objectFieldOffset(zzjj);
        zzadb = (int) (7 & zzi);
    }

    private zzld() {
    }

    public static void zza(Object obj, long j, long j2) {
        zzacl.zza(obj, j, j2);
    }

    public static void zzb(Object obj, long j, int i) {
        zzacl.zzb(obj, j, i);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    public static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzaaj.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzun) {
            return zzacl.zzadd.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzun) {
            return zzacl.zzadd.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean zzje() {
        return zzun;
    }

    public static boolean zzjf() {
        return zzacm;
    }

    public static Unsafe zzjg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzlc());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzjh() {
        Unsafe unsafe = zzaaj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (zzgl.zzel()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", a.r2(valueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", valueOf));
            return false;
        }
    }

    private static boolean zzji() {
        Unsafe unsafe = zzaaj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzjj() == null) {
                return false;
            }
            if (zzgl.zzel()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", a.r2(valueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", valueOf));
            return false;
        }
    }

    private static Field zzjj() {
        Field zzb2;
        if (zzgl.zzel() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    public static int zzk(Object obj, long j) {
        return zzacl.zzk(obj, j);
    }

    public static long zzl(Object obj, long j) {
        return zzacl.zzl(obj, j);
    }

    public static boolean zzm(Object obj, long j) {
        return zzacl.zzm(obj, j);
    }

    public static float zzn(Object obj, long j) {
        return zzacl.zzn(obj, j);
    }

    public static double zzo(Object obj, long j) {
        return zzacl.zzo(obj, j);
    }

    public static Object zzp(Object obj, long j) {
        return zzacl.zzadd.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    public static void zza(Object obj, long j, boolean z) {
        zzacl.zza(obj, j, z);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzgl.zzel()) {
            return false;
        }
        try {
            Class<?> cls2 = zzti;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final class zza extends zzc {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzld.zzadc) {
                zzld.zzb(obj, j, z);
            } else {
                zzld.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zze(Object obj, long j, byte b) {
            if (zzld.zzadc) {
                zzld.zza(obj, j, b);
            } else {
                zzld.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final boolean zzm(Object obj, long j) {
            if (zzld.zzadc) {
                return zzld.zzs(obj, j);
            }
            return zzld.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final byte zzy(Object obj, long j) {
            if (zzld.zzadc) {
                return zzld.zzq(obj, j);
            }
            return zzld.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static final class zzb extends zzc {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzld.zzadc) {
                zzld.zzb(obj, j, z);
            } else {
                zzld.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zze(Object obj, long j, byte b) {
            if (zzld.zzadc) {
                zzld.zza(obj, j, b);
            } else {
                zzld.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final boolean zzm(Object obj, long j) {
            if (zzld.zzadc) {
                return zzld.zzs(obj, j);
            }
            return zzld.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final byte zzy(Object obj, long j) {
            if (zzld.zzadc) {
                return zzld.zzq(obj, j);
            }
            return zzld.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.vision.zzld.zzc
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static void zza(Object obj, long j, float f) {
        zzacl.zza(obj, j, f);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    public static void zza(Object obj, long j, double d) {
        zzacl.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzacl.zzadd.putObject(obj, j, obj2);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzacl.zzy(bArr, zzacn + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzacl.zze(bArr, zzacn + j, b);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }
}
