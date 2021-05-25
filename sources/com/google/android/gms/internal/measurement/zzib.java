package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzib.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class zzib<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgj<MessageType, BuilderType> {
    private static Map<Object, zzib<?, ?>> zzd = new ConcurrentHashMap();
    public zzkt zzb = zzkt.zza();
    private int zzc = -1;

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzib<MessageType, BuilderType> implements zzjl {
        public zzhr<zze> zzc = zzhr.zza();

        public final zzhr<zze> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzhr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public static class zzc<T extends zzib<T, ?>> extends zzgk<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    public static class zzd<ContainingType extends zzjj, Type> extends zzhm<ContainingType, Type> {
    }

    public static final class zze implements zzht<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzlh zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzlo zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzjm zza(zzjm zzjm, zzjj zzjj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzjs zza(zzjs zzjs, zzjs zzjs2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    public static zzii zzbn() {
        return zzic.zzd();
    }

    public static zzih zzbo() {
        return zzix.zzd();
    }

    public static <E> zzik<E> zzbp() {
        return zzjx.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjy.zza().zza((zzjy) this).zza(this, (zzib) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final boolean g_() {
        return zza(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final /* synthetic */ zzjj h_() {
        return (zzib) zza(zzf.zzf, (Object) null, (Object) null);
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza2 = zzjy.zza().zza((zzjy) this).zza(this);
        this.zza = zza2;
        return zza2;
    }

    public String toString() {
        return zzjo.zza(this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final void zza(zzhi zzhi) throws IOException {
        zzjy.zza().zza((zzjy) this).zza((zzkc) this, (zzln) zzhl.zza(zzhi));
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final int zzbj() {
        return this.zzc;
    }

    public final <MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbk() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null));
    }

    public final BuilderType zzbl() {
        BuilderType buildertype = (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null));
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final int zzbm() {
        if (this.zzc == -1) {
            this.zzc = zzjy.zza().zza((zzjy) this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzjm zzbq() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza((zza) this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzjm zzbr() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final void zzc(int i) {
        this.zzc = i;
    }

    public static abstract class zza<MessageType extends zzib<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgi<MessageType, BuilderType> {
        public MessageType zza;
        public boolean zzb = false;
        private final MessageType zzc;

        public zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) ((zzib) messagetype.zza(zzf.zzd, null, null));
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzjy.zza().zza((zzjy) this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzgo(zzho));
                return this;
            } catch (zzij e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.internal.measurement.zzib$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzgi, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) this.zzc.zza(zzf.zze, null, null);
            zza2.zza((zza) ((zzib) zzu()));
            return zza2;
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final boolean g_() {
            return zzib.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final /* synthetic */ zzjj h_() {
            return this.zzc;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zzp() {
            return (zza) clone();
        }

        public void zzq() {
            MessageType messagetype = (MessageType) ((zzib) this.zza.zza(zzf.zzd, null, null));
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zzs */
        public MessageType zzu() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjy.zza().zza((zzjy) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzt */
        public final MessageType zzv() {
            MessageType messagetype = (MessageType) ((zzib) zzu());
            if (messagetype.g_()) {
                return messagetype;
            }
            throw new zzkr(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjy.zza().zza((zzjy) messagetype).zzb(messagetype, messagetype2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.measurement.zzib$zza<MessageType extends com.google.android.gms.internal.measurement.zzib<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.zzib$zza<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(zzgj zzgj) {
            return zza((zza<MessageType, BuilderType>) ((zzib) zzgj));
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzhf zzhf, zzho zzho) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzjy.zza().zza((zzjy) this.zza).zza(this.zza, zzhg.zza(zzhf), zzho);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2, zzho zzho) throws zzij {
            return zzb(bArr, 0, i2, zzho);
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2) throws zzij {
            return zzb(bArr, 0, i2, zzho.zza());
        }
    }

    public static <T extends zzib<?, ?>> T zza(Class<T> cls) {
        zzib<?, ?> zzib = zzd.get(cls);
        if (zzib == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzib = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzib == null) {
            zzib = (T) ((zzib) ((zzib) zzla.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null));
            if (zzib != null) {
                zzd.put(cls, zzib);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzib;
    }

    public static <T extends zzib<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    public static Object zza(zzjj zzjj, String str, Object[] objArr) {
        return new zzka(zzjj, str, objArr);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static final <T extends zzib<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjy.zza().zza((zzjy) t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    public static zzih zza(zzih zzih) {
        int size = zzih.size();
        return zzih.zzc(size == 0 ? 10 : size << 1);
    }

    public static <E> zzik<E> zza(zzik<E> zzik) {
        int size = zzik.size();
        return zzik.zza(size == 0 ? 10 : size << 1);
    }
}
