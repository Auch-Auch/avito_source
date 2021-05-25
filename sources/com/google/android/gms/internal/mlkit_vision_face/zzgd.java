package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class zzgd<MessageType extends zzgd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeu<MessageType, BuilderType> {
    private static Map<Object, zzgd<?, ?>> zzd = new ConcurrentHashMap();
    public zziw zzb = zziw.zza();
    private int zzc = -1;

    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzhn {
        public zzb(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd.zza
        public void zzc() {
            super.zzc();
            MessageType messagetype = this.zza;
            ((zze) messagetype).zzc = (zzfv) ((zze) messagetype).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd.zza
        public /* synthetic */ zzgd zze() {
            return (zze) zzg();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd.zza, com.google.android.gms.internal.mlkit_vision_face.zzho
        public /* synthetic */ zzhl zzg() {
            if (this.zzb) {
                return (zze) this.zza;
            }
            ((zze) this.zza).zzc.zzb();
            return (zze) super.zzg();
        }
    }

    public static class zzc<T extends zzgd<T, ?>> extends zzev<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    public static final class zzd implements zzfx<zzd> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final zzjh zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final zzjo zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final zzho zza(zzho zzho, zzhl zzhl) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzfx
        public final zzhr zza(zzhr zzhr, zzhr zzhr2) {
            throw new NoSuchMethodError();
        }
    }

    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgd<MessageType, BuilderType> implements zzhn {
        public zzfv<zzd> zzc = zzfv.zza();
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

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzgk, com.google.android.gms.internal.mlkit_vision_face.zzge] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.mlkit_vision_face.zzgk zzk() {
        /*
            com.google.android.gms.internal.mlkit_vision_face.zzge r0 = com.google.android.gms.internal.mlkit_vision_face.zzge.zzd()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzgd.zzk():com.google.android.gms.internal.mlkit_vision_face.zzgk");
    }

    public static <E> zzgm<E> zzl() {
        return zzhz.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhn
    public final boolean a_() {
        return zza(this, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzia.zza().zza((zzia) this).zza(this, (zzgd) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza2 = zzia.zza().zza((zzia) this).zza(this);
        this.zza = zza2;
        return zza2;
    }

    public String toString() {
        return zzhq.zza(this, super.toString());
    }

    public final <MessageType extends zzgd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza(messagetype);
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzeu
    public final int zzg() {
        return this.zzc;
    }

    public final <MessageType extends zzgd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhn
    public final /* synthetic */ zzhl zzi() {
        return (zzgd) zza(zzf.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhl
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzia.zza().zza((zzia) this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhl
    public final /* synthetic */ zzho zzm() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza((zza) this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzeu
    public final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhl
    public final void zza(zzfq zzfq) throws IOException {
        zzia.zza().zza((zzia) this).zza((zzib) this, (zzjn) zzfs.zza(zzfq));
    }

    public static abstract class zza<MessageType extends zzgd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzet<MessageType, BuilderType> {
        public MessageType zza;
        public boolean zzb = false;
        private final MessageType zzc;

        public zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) ((zzgd) messagetype.zza(zzf.zzd, null, null));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzhn
        public final boolean a_() {
            return zzgd.zza(this.zza, false);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.internal.mlkit_vision_face.zzgd$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzet, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) this.zzc.zza(zzf.zze, null, null);
            zza2.zza((zza) ((zzgd) zzg()));
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

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzet
        public final /* synthetic */ zzet zzb() {
            return (zza) clone();
        }

        public void zzc() {
            MessageType messagetype = (MessageType) ((zzgd) this.zza.zza(zzf.zzd, null, null));
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zze */
        public MessageType zzg() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzia.zza().zza((zzia) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzf */
        public final MessageType zzh() {
            MessageType messagetype = (MessageType) ((zzgd) zzg());
            if (messagetype.a_()) {
                return messagetype;
            }
            throw new zziu(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_face.zzhn
        public final /* synthetic */ zzhl zzi() {
            return this.zzc;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzia.zza().zza((zzia) messagetype).zzb(messagetype, messagetype2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.mlkit_vision_face.zzgd$zza<MessageType extends com.google.android.gms.internal.mlkit_vision_face.zzgd<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.mlkit_vision_face.zzgd$zza<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzet
        public final /* synthetic */ zzet zza(zzeu zzeu) {
            return zza((zza<MessageType, BuilderType>) ((zzgd) zzeu));
        }
    }

    public static <T extends zzgd<?, ?>> T zza(Class<T> cls) {
        zzgd<?, ?> zzgd = zzd.get(cls);
        if (zzgd == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgd = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgd == null) {
            zzgd = (T) ((zzgd) ((zzgd) zziz.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null));
            if (zzgd != null) {
                zzd.put(cls, zzgd);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzgd;
    }

    public static <T extends zzgd<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    public static Object zza(zzhl zzhl, String str, Object[] objArr) {
        return new zzic(zzhl, str, objArr);
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

    public static final <T extends zzgd<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzia.zza().zza((zzia) t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }
}
