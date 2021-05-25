package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class zzej<MessageType extends zzej<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzda<MessageType, BuilderType> {
    private static Map<Object, zzej<?, ?>> zzd = new ConcurrentHashMap();
    public zzhc zzb = zzhc.zza();
    private int zzc = -1;

    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzft {
        public zzb(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej.zza
        public void zzc() {
            super.zzc();
            MessageType messagetype = this.zza;
            ((zze) messagetype).zzc = (zzeb) ((zze) messagetype).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej.zza
        public /* synthetic */ zzej zze() {
            return (zze) zzg();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej.zza, com.google.android.gms.internal.mlkit_vision_common.zzfu
        public /* synthetic */ zzfr zzg() {
            if (this.zzb) {
                return (zze) this.zza;
            }
            ((zze) this.zza).zzc.zzb();
            return (zze) super.zzg();
        }
    }

    public static class zzc<T extends zzej<T, ?>> extends zzdb<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    public static final class zzd implements zzed<zzd> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final zzhn zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final zzhu zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final zzfu zza(zzfu zzfu, zzfr zzfr) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzed
        public final zzfx zza(zzfx zzfx, zzfx zzfx2) {
            throw new NoSuchMethodError();
        }
    }

    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzej<MessageType, BuilderType> implements zzft {
        public zzeb<zzd> zzc = zzeb.zza();
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
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzek, com.google.android.gms.internal.mlkit_vision_common.zzeq] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.mlkit_vision_common.zzeq zzk() {
        /*
            com.google.android.gms.internal.mlkit_vision_common.zzek r0 = com.google.android.gms.internal.mlkit_vision_common.zzek.zzd()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzej.zzk():com.google.android.gms.internal.mlkit_vision_common.zzeq");
    }

    public static <E> zzes<E> zzl() {
        return zzgf.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzft
    public final boolean a_() {
        return zza(this, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgg.zza().zza((zzgg) this).zza(this, (zzej) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza2 = zzgg.zza().zza((zzgg) this).zza(this);
        this.zza = zza2;
        return zza2;
    }

    public String toString() {
        return zzfw.zza(this, super.toString());
    }

    public final <MessageType extends zzej<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza(messagetype);
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzda
    public final int zzg() {
        return this.zzc;
    }

    public final <MessageType extends zzej<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzft
    public final /* synthetic */ zzfr zzi() {
        return (zzej) zza(zzf.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfr
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzgg.zza().zza((zzgg) this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfr
    public final /* synthetic */ zzfu zzm() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza((zza) this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzda
    public final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfr
    public final void zza(zzdw zzdw) throws IOException {
        zzgg.zza().zza((zzgg) this).zza((zzgh) this, (zzht) zzdy.zza(zzdw));
    }

    public static abstract class zza<MessageType extends zzej<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzcz<MessageType, BuilderType> {
        public MessageType zza;
        public boolean zzb = false;
        private final MessageType zzc;

        public zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) ((zzej) messagetype.zza(zzf.zzd, null, null));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzft
        public final boolean a_() {
            return zzej.zza(this.zza, false);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.internal.mlkit_vision_common.zzej$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzcz, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) this.zzc.zza(zzf.zze, null, null);
            zza2.zza((zza) ((zzej) zzg()));
            return zza2;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzc();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzcz
        public final /* synthetic */ zzcz zzb() {
            return (zza) clone();
        }

        public void zzc() {
            MessageType messagetype = (MessageType) ((zzej) this.zza.zza(zzf.zzd, null, null));
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zze */
        public MessageType zzg() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgg.zza().zza((zzgg) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzf */
        public final MessageType zzh() {
            MessageType messagetype = (MessageType) ((zzej) zzg());
            if (messagetype.a_()) {
                return messagetype;
            }
            throw new zzha(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzft
        public final /* synthetic */ zzfr zzi() {
            return this.zzc;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgg.zza().zza((zzgg) messagetype).zzb(messagetype, messagetype2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.mlkit_vision_common.zzej$zza<MessageType extends com.google.android.gms.internal.mlkit_vision_common.zzej<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.mlkit_vision_common.zzej$zza<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzcz
        public final /* synthetic */ zzcz zza(zzda zzda) {
            return zza((zza<MessageType, BuilderType>) ((zzej) zzda));
        }
    }

    public static <T extends zzej<?, ?>> T zza(Class<T> cls) {
        zzej<?, ?> zzej = zzd.get(cls);
        if (zzej == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzej = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzej == null) {
            zzej = (T) ((zzej) ((zzej) zzhf.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null));
            if (zzej != null) {
                zzd.put(cls, zzej);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzej;
    }

    public static <T extends zzej<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    public static Object zza(zzfr zzfr, String str, Object[] objArr) {
        return new zzgi(zzfr, str, objArr);
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

    public static final <T extends zzej<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzgg.zza().zza((zzgg) t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }
}
