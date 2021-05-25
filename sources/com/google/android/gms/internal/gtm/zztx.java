package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;
public final class zztx {
    private static final Logger logger = Logger.getLogger(zztx.class.getName());
    private static final Class<?> zzavt = zzpp.zznb();
    private static final boolean zzawt = zzrp();
    private static final Unsafe zzbcx;
    private static final boolean zzbet;
    private static final boolean zzbeu;
    private static final zzd zzbev;
    private static final boolean zzbew = zzrq();
    public static final long zzbex;
    private static final long zzbey = ((long) zzl(boolean[].class));
    private static final long zzbez = ((long) zzm(boolean[].class));
    private static final long zzbfa = ((long) zzl(int[].class));
    private static final long zzbfb = ((long) zzm(int[].class));
    private static final long zzbfc = ((long) zzl(long[].class));
    private static final long zzbfd = ((long) zzm(long[].class));
    private static final long zzbfe = ((long) zzl(float[].class));
    private static final long zzbff = ((long) zzm(float[].class));
    private static final long zzbfg = ((long) zzl(double[].class));
    private static final long zzbfh = ((long) zzm(double[].class));
    private static final long zzbfi = ((long) zzl(Object[].class));
    private static final long zzbfj = ((long) zzm(Object[].class));
    private static final long zzbfk;
    private static final int zzbfl;
    public static final boolean zzbfm = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zztx.zzbfm) {
                zztx.zza(obj, j, b);
            } else {
                zztx.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final boolean zzm(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzs(obj, j);
            }
            return zztx.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final byte zzy(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzq(obj, j);
            }
            return zztx.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zztx.zzbfm) {
                zztx.zzb(obj, j, z);
            } else {
                zztx.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zztx.zzbfm) {
                zztx.zza(obj, j, b);
            } else {
                zztx.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final boolean zzm(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzs(obj, j);
            }
            return zztx.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final byte zzy(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzq(obj, j);
            }
            return zztx.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zztx.zzbfm) {
                zztx.zzb(obj, j, z);
            } else {
                zztx.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(long j, byte b) {
            this.zzbfn.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzbfn.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzbfn.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final float zzn(Object obj, long j) {
            return this.zzbfn.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final double zzo(Object obj, long j) {
            return this.zzbfn.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzbfn.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzbfn.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzbfn.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzbfn.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzbfn.copyMemory(bArr, zztx.zzbex + j, (Object) null, j2, j3);
        }
    }

    public static abstract class zzd {
        public Unsafe zzbfn;

        public zzd(Unsafe unsafe) {
            this.zzbfn = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzbfn.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public final void zzb(Object obj, long j, int i) {
            this.zzbfn.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzbfn.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzbfn.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static {
        Unsafe zzro = zzro();
        zzbcx = zzro;
        boolean zzn = zzn(Long.TYPE);
        zzbet = zzn;
        boolean zzn2 = zzn(Integer.TYPE);
        zzbeu = zzn2;
        zzd zzd2 = null;
        if (zzro != null) {
            if (!zzpp.zzna()) {
                zzd2 = new zzc(zzro);
            } else if (zzn) {
                zzd2 = new zzb(zzro);
            } else if (zzn2) {
                zzd2 = new zza(zzro);
            }
        }
        zzbev = zzd2;
        long zzl = (long) zzl(byte[].class);
        zzbex = zzl;
        Field zzrr = zzrr();
        zzbfk = (zzrr == null || zzd2 == null) ? -1 : zzd2.zzbfn.objectFieldOffset(zzrr);
        zzbfl = (int) (7 & zzl);
    }

    private zztx() {
    }

    public static void zza(Object obj, long j, long j2) {
        zzbev.zza(obj, j, j2);
    }

    public static void zzb(Object obj, long j, int i) {
        zzbev.zzb(obj, j, i);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    public static <T> T zzk(Class<T> cls) {
        try {
            return (T) zzbcx.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzl(Class<?> cls) {
        if (zzawt) {
            return zzbev.zzbfn.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzm(Class<?> cls) {
        if (zzawt) {
            return zzbev.zzbfn.arrayIndexScale(cls);
        }
        return -1;
    }

    public static float zzn(Object obj, long j) {
        return zzbev.zzn(obj, j);
    }

    public static double zzo(Object obj, long j) {
        return zzbev.zzo(obj, j);
    }

    public static Object zzp(Object obj, long j) {
        return zzbev.zzbfn.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    public static boolean zzrm() {
        return zzawt;
    }

    public static boolean zzrn() {
        return zzbew;
    }

    public static Unsafe zzro() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzty());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzrp() {
        Unsafe unsafe = zzbcx;
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
            if (zzpp.zzna()) {
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

    private static boolean zzrq() {
        Unsafe unsafe = zzbcx;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzrr() == null) {
                return false;
            }
            if (zzpp.zzna()) {
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

    private static Field zzrr() {
        Field zzb2;
        if (zzpp.zzna() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
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
        zzbev.zza(obj, j, z);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        return zzbev.zzl(byteBuffer, zzbfk);
    }

    private static boolean zzn(Class<?> cls) {
        if (!zzpp.zzna()) {
            return false;
        }
        try {
            Class<?> cls2 = zzavt;
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

    public static void zza(Object obj, long j, float f) {
        zzbev.zza(obj, j, f);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zzk(Object obj, long j) {
        return zzbev.zzk(obj, j);
    }

    public static long zzl(Object obj, long j) {
        return zzbev.zzl(obj, j);
    }

    public static boolean zzm(Object obj, long j) {
        return zzbev.zzm(obj, j);
    }

    public static void zza(Object obj, long j, double d) {
        zzbev.zza(obj, j, d);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzbev.zzbfn.putObject(obj, j, obj2);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzbev.zzy(bArr, zzbex + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzbev.zze(bArr, zzbex + j, b);
    }

    public static void zza(byte[] bArr, long j, long j2, long j3) {
        zzbev.zza(bArr, j, j2, j3);
    }

    public static void zza(long j, byte b) {
        zzbev.zza(j, b);
    }

    public static int zza(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        if (i < 0 || i2 < 0 || i3 < 0 || i + i3 > bArr.length || i2 + i3 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (zzawt) {
            int i6 = (zzbfl + i) & 7;
            while (i5 < i3 && (i6 & 7) != 0) {
                if (bArr[i + i5] != bArr2[i2 + i5]) {
                    return i5;
                }
                i5++;
                i6++;
            }
            int i7 = ((i3 - i5) & -8) + i5;
            while (i5 < i7) {
                long j = zzbex;
                long j2 = (long) i5;
                long zzl = zzl(bArr, ((long) i) + j + j2);
                long zzl2 = zzl(bArr2, j + ((long) i2) + j2);
                if (zzl != zzl2) {
                    if (zzbfm) {
                        i4 = Long.numberOfLeadingZeros(zzl ^ zzl2);
                    } else {
                        i4 = Long.numberOfTrailingZeros(zzl ^ zzl2);
                    }
                    return i5 + (i4 >> 3);
                }
                i5 += 8;
            }
        }
        while (i5 < i3) {
            if (bArr[i + i5] != bArr2[i2 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }
}
