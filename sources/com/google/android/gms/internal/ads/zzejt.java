package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
public final class zzejt {
    private static final Logger logger = Logger.getLogger(zzejt.class.getName());
    private static final Unsafe zzhop;
    private static final Class<?> zziau = zzeey.zzbde();
    private static final boolean zzicg = zzbif();
    private static final boolean zzikl;
    private static final boolean zzikm;
    private static final zzd zzikn;
    private static final boolean zziko = zzbig();
    private static final long zzikp;
    private static final long zzikq = ((long) zzk(boolean[].class));
    private static final long zzikr = ((long) zzl(boolean[].class));
    private static final long zziks = ((long) zzk(int[].class));
    private static final long zzikt = ((long) zzl(int[].class));
    private static final long zziku = ((long) zzk(long[].class));
    private static final long zzikv = ((long) zzl(long[].class));
    private static final long zzikw = ((long) zzk(float[].class));
    private static final long zzikx = ((long) zzl(float[].class));
    private static final long zziky = ((long) zzk(double[].class));
    private static final long zzikz = ((long) zzl(double[].class));
    private static final long zzila = ((long) zzk(Object[].class));
    private static final long zzilb = ((long) zzl(Object[].class));
    private static final long zzilc;
    private static final int zzild;
    public static final boolean zzile = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzilh.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzilh.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzilh.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final float zzn(Object obj, long j) {
            return this.zzilh.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final double zzo(Object obj, long j) {
            return this.zzilh.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzilh.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzilh.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzilh.putDouble(obj, j, d);
        }
    }

    public static abstract class zzd {
        public Unsafe zzilh;

        public zzd(Unsafe unsafe) {
            this.zzilh = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzilh.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zzilh.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzilh.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzilh.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static {
        Unsafe zzbie = zzbie();
        zzhop = zzbie;
        boolean zzm = zzm(Long.TYPE);
        zzikl = zzm;
        boolean zzm2 = zzm(Integer.TYPE);
        zzikm = zzm2;
        zzd zzd2 = null;
        if (zzbie != null) {
            if (!zzeey.zzbdd()) {
                zzd2 = new zzb(zzbie);
            } else if (zzm) {
                zzd2 = new zzc(zzbie);
            } else if (zzm2) {
                zzd2 = new zza(zzbie);
            }
        }
        zzikn = zzd2;
        long zzk = (long) zzk(byte[].class);
        zzikp = zzk;
        Field zzbih = zzbih();
        zzilc = (zzbih == null || zzd2 == null) ? -1 : zzd2.zzilh.objectFieldOffset(zzbih);
        zzild = (int) (7 & zzk);
    }

    private zzejt() {
    }

    public static void zza(Object obj, long j, long j2) {
        zzikn.zza(obj, j, j2);
    }

    public static void zzb(Object obj, long j, int i) {
        zzikn.zzb(obj, j, i);
    }

    public static boolean zzbic() {
        return zzicg;
    }

    public static boolean zzbid() {
        return zziko;
    }

    public static Unsafe zzbie() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzejv());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbif() {
        Unsafe unsafe = zzhop;
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
            if (zzeey.zzbdd()) {
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

    private static boolean zzbig() {
        Unsafe unsafe = zzhop;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzbih() == null) {
                return false;
            }
            if (zzeey.zzbdd()) {
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

    private static Field zzbih() {
        Field zzb2;
        if (zzeey.zzbdd() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    public static <T> T zzj(Class<T> cls) {
        try {
            return (T) zzhop.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zzicg) {
            return zzikn.zzilh.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zzicg) {
            return zzikn.zzilh.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean zzm(Object obj, long j) {
        return zzikn.zzm(obj, j);
    }

    public static float zzn(Object obj, long j) {
        return zzikn.zzn(obj, j);
    }

    public static double zzo(Object obj, long j) {
        return zzikn.zzo(obj, j);
    }

    public static Object zzp(Object obj, long j) {
        return zzikn.zzilh.getObject(obj, j);
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
        zzikn.zza(obj, j, z);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzeey.zzbdd()) {
            return false;
        }
        try {
            Class<?> cls2 = zziau;
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

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzejt.zzile) {
                zzejt.zzb(obj, j, z);
            } else {
                zzejt.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzejt.zzile) {
                zzejt.zza(obj, j, b);
            } else {
                zzejt.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzejt.zzile) {
                return zzejt.zzs(obj, j);
            }
            return zzejt.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final byte zzy(Object obj, long j) {
            if (zzejt.zzile) {
                return zzejt.zzq(obj, j);
            }
            return zzejt.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzejt.zzile) {
                zzejt.zzb(obj, j, z);
            } else {
                zzejt.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzejt.zzile) {
                zzejt.zza(obj, j, b);
            } else {
                zzejt.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzejt.zzile) {
                return zzejt.zzs(obj, j);
            }
            return zzejt.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final byte zzy(Object obj, long j) {
            if (zzejt.zzile) {
                return zzejt.zzq(obj, j);
            }
            return zzejt.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzejt.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static void zza(Object obj, long j, float f) {
        zzikn.zza(obj, j, f);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    public static int zzk(Object obj, long j) {
        return zzikn.zzk(obj, j);
    }

    public static long zzl(Object obj, long j) {
        return zzikn.zzl(obj, j);
    }

    public static void zza(Object obj, long j, double d) {
        zzikn.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzikn.zzilh.putObject(obj, j, obj2);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzikn.zzy(bArr, zzikp + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzikn.zze(bArr, zzikp + j, b);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }
}
