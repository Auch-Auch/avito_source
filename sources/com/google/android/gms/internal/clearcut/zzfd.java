package com.google.android.gms.internal.clearcut;

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
public final class zzfd {
    private static final Logger logger = Logger.getLogger(zzfd.class.getName());
    private static final Class<?> zzfb = zzaw.zzy();
    private static final boolean zzfy = zzeg();
    private static final Unsafe zzmh;
    private static final boolean zzpg;
    private static final boolean zzph;
    private static final zzd zzpi;
    private static final boolean zzpj = zzeh();
    private static final long zzpk = ((long) zzg(byte[].class));
    private static final long zzpl = ((long) zzg(boolean[].class));
    private static final long zzpm = ((long) zzh(boolean[].class));
    private static final long zzpn = ((long) zzg(int[].class));
    private static final long zzpo = ((long) zzh(int[].class));
    private static final long zzpp = ((long) zzg(long[].class));
    private static final long zzpq = ((long) zzh(long[].class));
    private static final long zzpr = ((long) zzg(float[].class));
    private static final long zzps = ((long) zzh(float[].class));
    private static final long zzpt = ((long) zzg(double[].class));
    private static final long zzpu = ((long) zzh(double[].class));
    private static final long zzpv = ((long) zzg(Object[].class));
    private static final long zzpw = ((long) zzh(Object[].class));
    private static final long zzpx = zzb(zzei());
    private static final long zzpy;
    private static final boolean zzpz = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j, z);
            } else {
                zzfd.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j, b);
            } else {
                zzfd.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final boolean zzl(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzr(obj, j) : zzfd.zzs(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final byte zzx(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzp(obj, j) : zzfd.zzq(obj, j);
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j, z);
            } else {
                zzfd.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j, b);
            } else {
                zzfd.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final boolean zzl(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzr(obj, j) : zzfd.zzs(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final byte zzx(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzp(obj, j) : zzfd.zzq(obj, j);
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(long j, byte b) {
            this.zzqa.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzqa.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzqa.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzqa.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzqa.copyMemory(bArr, zzfd.zzpk + j, (Object) null, j2, j3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzqa.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final boolean zzl(Object obj, long j) {
            return this.zzqa.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final float zzm(Object obj, long j) {
            return this.zzqa.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final double zzn(Object obj, long j) {
            return this.zzqa.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzfd.zzd
        public final byte zzx(Object obj, long j) {
            return this.zzqa.getByte(obj, j);
        }
    }

    public static abstract class zzd {
        public Unsafe zzqa;

        public zzd(Unsafe unsafe) {
            this.zzqa = unsafe;
        }

        public final long zza(Field field) {
            return this.zzqa.objectFieldOffset(field);
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zzqa.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzqa.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public final int zzj(Object obj, long j) {
            return this.zzqa.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzqa.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ec  */
    static {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfd.<clinit>():void");
    }

    private zzfd() {
    }

    public static byte zza(byte[] bArr, long j) {
        return zzpi.zzx(bArr, zzpk + j);
    }

    public static long zza(Field field) {
        return zzpi.zza(field);
    }

    public static void zza(long j, byte b) {
        zzpi.zza(j, b);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzj = zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    public static void zza(Object obj, long j, double d) {
        zzpi.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, float f) {
        zzpi.zza(obj, j, f);
    }

    public static void zza(Object obj, long j, int i) {
        zzpi.zza(obj, j, i);
    }

    public static void zza(Object obj, long j, long j2) {
        zzpi.zza(obj, j, j2);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzpi.zzqa.putObject(obj, j, obj2);
    }

    public static void zza(Object obj, long j, boolean z) {
        zzpi.zza(obj, j, z);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzpi.zze(bArr, zzpk + j, b);
    }

    public static void zza(byte[] bArr, long j, long j2, long j3) {
        zzpi.zza(bArr, j, j2, j3);
    }

    private static long zzb(Field field) {
        zzd zzd2;
        if (field == null || (zzd2 = zzpi) == null) {
            return -1;
        }
        return zzd2.zza(field);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        return zzpi.zzk(byteBuffer, zzpx);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    public static boolean zzed() {
        return zzfy;
    }

    public static boolean zzee() {
        return zzpj;
    }

    public static Unsafe zzef() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfe());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzeg() {
        Unsafe unsafe = zzmh;
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
            if (zzaw.zzx()) {
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

    private static boolean zzeh() {
        Unsafe unsafe = zzmh;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzei() == null) {
                return false;
            }
            if (zzaw.zzx()) {
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

    private static Field zzei() {
        Field zzb2;
        if (zzaw.zzx() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzg(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        if (!zzaw.zzx()) {
            return false;
        }
        try {
            Class<?> cls2 = zzfb;
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

    public static int zzj(Object obj, long j) {
        return zzpi.zzj(obj, j);
    }

    public static long zzk(Object obj, long j) {
        return zzpi.zzk(obj, j);
    }

    public static boolean zzl(Object obj, long j) {
        return zzpi.zzl(obj, j);
    }

    public static float zzm(Object obj, long j) {
        return zzpi.zzm(obj, j);
    }

    public static double zzn(Object obj, long j) {
        return zzpi.zzn(obj, j);
    }

    public static Object zzo(Object obj, long j) {
        return zzpi.zzqa.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }
}
