package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import com.google.android.gms.internal.ads.zzegp.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class zzegp<MessageType extends zzegp<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeev<MessageType, BuilderType> {
    private static Map<Object, zzegp<?, ?>> zzifq = new ConcurrentHashMap();
    public zzejq zzifo = zzejq.zzbhz();
    private int zzifp = -1;

    public static class zza<T extends zzegp<T, ?>> extends zzeew<T> {
        private final T zzifs;

        public zza(T t) {
            this.zzifs = t;
        }
    }

    public static final class zzc implements zzegk<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final zzeic zza(zzeic zzeic, zzehz zzehz) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final zzeke zzbfe() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final zzekh zzbff() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final boolean zzbfg() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final boolean zzbfh() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final int zzv() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzegk
        public final zzeii zza(zzeii zzeii, zzeii zzeii2) {
            throw new NoSuchMethodError();
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzegp<MessageType, BuilderType> implements zzeib {
        public zzegi<zzc> zzifv = zzegi.zzbfc();

        public final zzegi<zzc> zzbfy() {
            if (this.zzifv.isImmutable()) {
                this.zzifv = (zzegi) this.zzifv.clone();
            }
            return this.zzifv;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zze {
        public static final int zzifw = 1;
        public static final int zzifx = 2;
        public static final int zzify = 3;
        public static final int zzifz = 4;
        public static final int zziga = 5;
        public static final int zzigb = 6;
        public static final int zzigc = 7;
        private static final /* synthetic */ int[] zzigd = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzige = 1;
        public static final int zzigf = 2;
        private static final /* synthetic */ int[] zzigg = {1, 2};
        public static final int zzigh = 1;
        public static final int zzigi = 2;
        private static final /* synthetic */ int[] zzigj = {1, 2};

        public static int[] zzbfz() {
            return (int[]) zzigd.clone();
        }
    }

    public static class zzf<ContainingType extends zzehz, Type> extends zzegd<ContainingType, Type> {
    }

    public static <T extends zzegp<?, ?>> void zza(Class<T> cls, T t) {
        zzifq.put(cls, t);
    }

    public static zzegv zzbfm() {
        return zzegs.zzbga();
    }

    public static zzegx zzbfn() {
        return zzehn.zzbgr();
    }

    public static <E> zzeha<E> zzbfo() {
        return zzein.zzbhf();
    }

    public static <T extends zzegp<?, ?>> T zzd(Class<T> cls) {
        zzegp<?, ?> zzegp = zzifq.get(cls);
        if (zzegp == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzegp = (T) zzifq.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzegp == null) {
            zzegp = (T) ((zzegp) ((zzegp) zzejt.zzj(cls)).zza(zze.zzigb, (Object) null, (Object) null));
            if (zzegp != null) {
                zzifq.put(cls, zzegp);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzegp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzeio.zzbhg().zzaw(this).equals(this, (zzegp) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zziaq;
        if (i != 0) {
            return i;
        }
        int hashCode = zzeio.zzbhg().zzaw(this).hashCode(this);
        this.zziaq = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzeie.zza(this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzehz
    public final void zzb(zzefz zzefz) throws IOException {
        zzeio.zzbhg().zzaw(this).zza(this, zzegb.zza(zzefz));
    }

    @Override // com.google.android.gms.internal.ads.zzeev
    public final int zzbdb() {
        return this.zzifp;
    }

    public final <MessageType extends zzegp<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbfj() {
        return (BuilderType) ((zzb) zza(zze.zziga, (Object) null, (Object) null));
    }

    public final BuilderType zzbfk() {
        BuilderType buildertype = (BuilderType) ((zzb) zza(zze.zziga, (Object) null, (Object) null));
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzehz
    public final int zzbfl() {
        if (this.zzifp == -1) {
            this.zzifp = zzeio.zzbhg().zzaw(this).zzat(this);
        }
        return this.zzifp;
    }

    @Override // com.google.android.gms.internal.ads.zzehz
    public final /* synthetic */ zzeic zzbfp() {
        zzb zzb2 = (zzb) zza(zze.zziga, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzehz
    public final /* synthetic */ zzeic zzbfq() {
        return (zzb) zza(zze.zziga, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzeib
    public final /* synthetic */ zzehz zzbfr() {
        return (zzegp) zza(zze.zzigb, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzeev
    public final void zzfq(int i) {
        this.zzifp = i;
    }

    public static Object zza(zzehz zzehz, String str, Object[] objArr) {
        return new zzeiq(zzehz, str, objArr);
    }

    public static abstract class zzb<MessageType extends zzegp<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeeu<MessageType, BuilderType> {
        private final MessageType zzifs;
        public MessageType zzift;
        public boolean zzifu = false;

        public zzb(MessageType messagetype) {
            this.zzifs = messagetype;
            this.zzift = (MessageType) ((zzegp) messagetype.zza(zze.zzifz, null, null));
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzeio.zzbhg().zzaw(messagetype).zzg(messagetype, messagetype2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.internal.ads.zzegp$zzb */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzeeu, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) this.zzifs.zza(zze.zziga, null, null);
            zzb.zza((zzegp) zzbfw());
            return zzb;
        }

        @Override // com.google.android.gms.internal.ads.zzeib
        public final boolean isInitialized() {
            return zzegp.zza(this.zzift, false);
        }

        /* renamed from: zzb */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            zza(this.zzift, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.ads.zzeeu
        public final /* synthetic */ zzeeu zzbcz() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzeib
        public final /* synthetic */ zzehz zzbfr() {
            return this.zzifs;
        }

        public void zzbft() {
            MessageType messagetype = (MessageType) ((zzegp) this.zzift.zza(zze.zzifz, null, null));
            zza(messagetype, this.zzift);
            this.zzift = messagetype;
        }

        /* renamed from: zzbfu */
        public MessageType zzbfw() {
            if (this.zzifu) {
                return this.zzift;
            }
            MessageType messagetype = this.zzift;
            zzeio.zzbhg().zzaw(messagetype).zzaj(messagetype);
            this.zzifu = true;
            return this.zzift;
        }

        /* renamed from: zzbfv */
        public final MessageType zzbfx() {
            MessageType messagetype = (MessageType) ((zzegp) zzbfw());
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzejo(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.zzeeu
        public final /* synthetic */ zzeeu zza(byte[] bArr, int i, int i2, zzegc zzegc) throws zzegz {
            return zzb(bArr, 0, i2, zzegc);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzegc zzegc) throws zzegz {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            try {
                zzeio.zzbhg().zzaw(this.zzift).zza(this.zzift, bArr, 0, i2 + 0, new zzefa(zzegc));
                return this;
            } catch (zzegz e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzegz.zzbgb();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzefq zzefq, zzegc zzegc) throws IOException {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            try {
                zzeio.zzbhg().zzaw(this.zzift).zza(this.zzift, zzefx.zza(zzefq), zzegc);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
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

    private static <T extends zzegp<T, ?>> T zzb(T t, zzeff zzeff, zzegc zzegc) throws zzegz {
        try {
            zzefq zzbdl = zzeff.zzbdl();
            T t2 = (T) zza(t, zzbdl, zzegc);
            try {
                zzbdl.zzfy(0);
                return t2;
            } catch (zzegz e) {
                throw e.zzl(t2);
            }
        } catch (zzegz e2) {
            throw e2;
        }
    }

    public static final <T extends zzegp<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzifw, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzav = zzeio.zzbhg().zzaw(t).zzav(t);
        if (z) {
            t.zza(zze.zzifx, zzav ? t : null, null);
        }
        return zzav;
    }

    public static zzegv zza(zzegv zzegv) {
        int size = zzegv.size();
        return zzegv.zzhb(size == 0 ? 10 : size << 1);
    }

    public static <E> zzeha<E> zza(zzeha<E> zzeha) {
        int size = zzeha.size();
        return zzeha.zzft(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzegp<T, ?>> T zza(T t, zzefq zzefq, zzegc zzegc) throws zzegz {
        T t2 = (T) ((zzegp) t.zza(zze.zzifz, null, null));
        try {
            zzeiv zzaw = zzeio.zzbhg().zzaw(t2);
            zzaw.zza(t2, zzefx.zza(zzefq), zzegc);
            zzaw.zzaj(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzegz) {
                throw ((zzegz) e.getCause());
            }
            throw new zzegz(e.getMessage()).zzl(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzegz) {
                throw ((zzegz) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzegp<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzegc zzegc) throws zzegz {
        T t2 = (T) ((zzegp) t.zza(zze.zzifz, null, null));
        try {
            zzeiv zzaw = zzeio.zzbhg().zzaw(t2);
            zzaw.zza(t2, bArr, 0, i2, new zzefa(zzegc));
            zzaw.zzaj(t2);
            if (t2.zziaq == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzegz) {
                throw ((zzegz) e.getCause());
            }
            throw new zzegz(e.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzegz.zzbgb().zzl(t2);
        }
    }

    private static <T extends zzegp<T, ?>> T zza(T t) throws zzegz {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzegz(new zzejo(t).getMessage()).zzl(t);
    }

    public static <T extends zzegp<T, ?>> T zza(T t, zzeff zzeff) throws zzegz {
        return (T) zza(zza(zzb(t, zzeff, zzegc.zzbex())));
    }

    public static <T extends zzegp<T, ?>> T zza(T t, zzeff zzeff, zzegc zzegc) throws zzegz {
        return (T) zza(zzb(t, zzeff, zzegc));
    }

    public static <T extends zzegp<T, ?>> T zza(T t, byte[] bArr) throws zzegz {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzegc.zzbex()));
    }

    public static <T extends zzegp<T, ?>> T zza(T t, byte[] bArr, zzegc zzegc) throws zzegz {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzegc));
    }
}
