package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class zzfq<MessageType extends zzfq<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeg<MessageType, BuilderType> {
    private static Map<Object, zzfq<?, ?>> zzd = new ConcurrentHashMap();
    public zzii zzb = zzii.zza();
    private int zzc = -1;

    public static class zza<T extends zzfq<T, ?>> extends zzel<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzfq<MessageType, BuilderType> implements zzhd {
        public zzfl<zzf> zzc = zzfl.zza();
    }

    public static abstract class zzd<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzb<MessageType, BuilderType> implements zzhd {
        public zzd(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfq.zzb
        public void zzc() {
            super.zzc();
            MessageType messagetype = this.zza;
            ((zzc) messagetype).zzc = (zzfl) ((zzc) messagetype).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfq.zzb
        public /* synthetic */ zzfq zzd() {
            return (zzc) zzf();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfq.zzb, com.google.android.gms.internal.mlkit_common.zzha
        public /* synthetic */ zzhb zzf() {
            if (this.zzb) {
                return (zzc) this.zza;
            }
            ((zzc) this.zza).zzc.zzb();
            return (zzc) super.zzf();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    public static final class zzf implements zzfn<zzf> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final zzix zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final zzja zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final zzha zza(zzha zzha, zzhb zzhb) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzfn
        public final zzhh zza(zzhh zzhh, zzhh zzhh2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfw, com.google.android.gms.internal.mlkit_common.zzft] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.mlkit_common.zzfw zzk() {
        /*
            com.google.android.gms.internal.mlkit_common.zzft r0 = com.google.android.gms.internal.mlkit_common.zzft.zzd()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzfq.zzk():com.google.android.gms.internal.mlkit_common.zzfw");
    }

    public static <E> zzfy<E> zzl() {
        return zzhp.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhm.zza().zza((zzhm) this).zza(this, (zzfq) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza2 = zzhm.zza().zza((zzhm) this).zza(this);
        this.zza = zza2;
        return zza2;
    }

    public String toString() {
        return zzhc.zza(this, super.toString());
    }

    public final <MessageType extends zzfq<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza(messagetype);
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_common.zzeg
    public final int zzg() {
        return this.zzc;
    }

    public final <MessageType extends zzfq<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhd
    public final boolean zzi() {
        return zza(this, true);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhb
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzhm.zza().zza((zzhm) this).zzd(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhb
    public final /* synthetic */ zzha zzm() {
        zzb zzb2 = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzb2.zza((zzb) this);
        return zzb2;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhd
    public final /* synthetic */ zzhb zzn() {
        return (zzfq) zza(zze.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeg
    public final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhb
    public final void zza(zzfc zzfc) throws IOException {
        zzhm.zza().zza((zzhm) this).zza((zzhr) this, (zzjd) zzff.zza(zzfc));
    }

    public static abstract class zzb<MessageType extends zzfq<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzej<MessageType, BuilderType> {
        public MessageType zza;
        public boolean zzb = false;
        private final MessageType zzc;

        public zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) ((zzfq) messagetype.zza(zze.zzd, null, null));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.internal.mlkit_common.zzfq$zzb */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_common.zzej, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) this.zzc.zza(zze.zze, null, null);
            zzb2.zza((zzb) ((zzfq) zzf()));
            return zzb2;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzc();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzej
        public final /* synthetic */ zzej zzb() {
            return (zzb) clone();
        }

        public void zzc() {
            MessageType messagetype = (MessageType) ((zzfq) this.zza.zza(zze.zzd, null, null));
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zzd */
        public MessageType zzf() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzhm.zza().zza((zzhm) messagetype).zzb(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zze */
        public final MessageType zzg() {
            MessageType messagetype = (MessageType) ((zzfq) zzf());
            if (messagetype.zzi()) {
                return messagetype;
            }
            throw new zzig(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzhd
        public final boolean zzi() {
            return zzfq.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzhd
        public final /* synthetic */ zzhb zzn() {
            return this.zzc;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhm.zza().zza((zzhm) messagetype).zzb(messagetype, messagetype2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.mlkit_common.zzfq$zzb<MessageType extends com.google.android.gms.internal.mlkit_common.zzfq<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.mlkit_common.zzfq$zzb<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_common.zzej
        public final /* synthetic */ zzej zza(zzeg zzeg) {
            return zza((zzb<MessageType, BuilderType>) ((zzfq) zzeg));
        }
    }

    public static <T extends zzfq<?, ?>> T zza(Class<T> cls) {
        zzfq<?, ?> zzfq = zzd.get(cls);
        if (zzfq == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfq = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfq == null) {
            zzfq = (T) ((zzfq) ((zzfq) zzip.zza(cls)).zza(zze.zzf, (Object) null, (Object) null));
            if (zzfq != null) {
                zzd.put(cls, zzfq);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzfq;
    }

    public static <T extends zzfq<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    public static Object zza(zzhb zzhb, String str, Object[] objArr) {
        return new zzho(zzhb, str, objArr);
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

    public static final <T extends zzfq<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzc2 = zzhm.zza().zza((zzhm) t).zzc(t);
        if (z) {
            t.zza(zze.zzb, zzc2 ? t : null, null);
        }
        return zzc2;
    }
}
