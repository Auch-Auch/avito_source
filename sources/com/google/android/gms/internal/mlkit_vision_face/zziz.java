package com.google.android.gms.internal.mlkit_vision_face;

import a2.b.a.a.a;
import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
public final class zziz {
    public static final boolean zza = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Logger zzb = Logger.getLogger(zziz.class.getName());
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzex.zzb();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzd zzg;
    private static final boolean zzh = zze();
    private static final boolean zzi = zzd();
    private static final long zzj;
    private static final long zzk = ((long) zzb(boolean[].class));
    private static final long zzl = ((long) zzc(boolean[].class));
    private static final long zzm = ((long) zzb(int[].class));
    private static final long zzn = ((long) zzc(int[].class));
    private static final long zzo = ((long) zzb(long[].class));
    private static final long zzp = ((long) zzc(long[].class));
    private static final long zzq = ((long) zzb(float[].class));
    private static final long zzr = ((long) zzc(float[].class));
    private static final long zzs = ((long) zzb(double[].class));
    private static final long zzt = ((long) zzc(double[].class));
    private static final long zzu = ((long) zzb(Object[].class));
    private static final long zzv = ((long) zzc(Object[].class));
    private static final long zzw;
    private static final int zzx;

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, byte b) {
            this.zza.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, float f) {
            this.zza.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, double d) {
            this.zza.putDouble(obj, j, d);
        }
    }

    public static abstract class zzd {
        public Unsafe zza;

        public zzd(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }
    }

    static {
        Unsafe zzc2 = zzc();
        zzc = zzc2;
        boolean zzd2 = zzd(Long.TYPE);
        zze = zzd2;
        boolean zzd3 = zzd(Integer.TYPE);
        zzf = zzd3;
        zzd zzd4 = null;
        if (zzc2 != null) {
            if (!zzex.zza()) {
                zzd4 = new zzb(zzc2);
            } else if (zzd2) {
                zzd4 = new zzc(zzc2);
            } else if (zzd3) {
                zzd4 = new zza(zzc2);
            }
        }
        zzg = zzd4;
        long zzb2 = (long) zzb(byte[].class);
        zzj = zzb2;
        Field zzf2 = zzf();
        zzw = (zzf2 == null || zzd4 == null) ? -1 : zzd4.zza.objectFieldOffset(zzf2);
        zzx = (int) (7 & zzb2);
    }

    private zziz() {
    }

    public static boolean zza() {
        return zzi;
    }

    public static boolean zzb() {
        return zzh;
    }

    private static int zzc(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    public static float zzd(Object obj, long j) {
        return zzg.zzc(obj, j);
    }

    public static double zze(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    public static Object zzf(Object obj, long j) {
        return zzg.zza.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }

    public static <T> T zza(Class<T> cls) {
        try {
            return (T) zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzb(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static boolean zzd() {
        Unsafe unsafe = zzc;
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
            if (zzex.zza()) {
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
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", a.r2(valueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", valueOf));
            return false;
        }
    }

    private static boolean zze() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzf() == null) {
                return false;
            }
            if (zzex.zza()) {
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
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", a.r2(valueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", valueOf));
            return false;
        }
    }

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final byte zza(Object obj, long j) {
            if (zziz.zza) {
                return zziz.zzk(obj, j);
            }
            return zziz.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final boolean zzb(Object obj, long j) {
            if (zziz.zza) {
                return zziz.zzm(obj, j);
            }
            return zziz.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, byte b) {
            if (zziz.zza) {
                zziz.zzc(obj, j, b);
            } else {
                zziz.zzd(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zziz.zza) {
                zziz.zzd(obj, j, z);
            } else {
                zziz.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final byte zza(Object obj, long j) {
            if (zziz.zza) {
                return zziz.zzk(obj, j);
            }
            return zziz.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final boolean zzb(Object obj, long j) {
            if (zziz.zza) {
                return zziz.zzm(obj, j);
            }
            return zziz.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, byte b) {
            if (zziz.zza) {
                zziz.zzc(obj, j, b);
            } else {
                zziz.zzd(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zziz.zza) {
                zziz.zzd(obj, j, z);
            } else {
                zziz.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zziz.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static boolean zzc(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    private static Field zzf() {
        Field zza2;
        if (zzex.zza() && (zza2 = zza(Buffer.class, "effectiveDirectAddress")) != null) {
            return zza2;
        }
        Field zza3 = zza(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    public static int zza(Object obj, long j) {
        return zzg.zze(obj, j);
    }

    public static long zzb(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    public static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzjb());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zza(Object obj, long j, int i) {
        zzg.zza(obj, j, i);
    }

    public static void zza(Object obj, long j, long j2) {
        zzg.zza(obj, j, j2);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zza2 = zza(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza2 & (~(255 << i))));
    }

    public static void zza(Object obj, long j, boolean z) {
        zzg.zza(obj, j, z);
    }

    public static void zza(Object obj, long j, float f) {
        zzg.zza(obj, j, f);
    }

    public static void zza(Object obj, long j, double d) {
        zzg.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzg.zza.putObject(obj, j, obj2);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzg.zza(bArr, zzj + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzg.zza((Object) bArr, zzj + j, b);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : 0);
    }

    private static boolean zzd(Class<?> cls) {
        if (!zzex.zza()) {
            return false;
        }
        try {
            Class<?> cls2 = zzd;
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

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : 0);
    }
}
