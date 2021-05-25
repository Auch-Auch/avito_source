package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class zzid<MessageType extends zzid<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzge<MessageType, BuilderType> {
    private static Map<Object, zzid<?, ?>> zzyb = new ConcurrentHashMap();
    public zzkw zzxz = zzkw.zzja();
    private int zzya = -1;

    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzjp {
        public zzb(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.zzid.zza
        public void zzgs() {
            super.zzgs();
            MessageType messagetype = this.zzxx;
            ((zze) messagetype).zzyg = (zzht) ((zze) messagetype).zzyg.clone();
        }

        @Override // com.google.android.gms.internal.vision.zzid.zza
        public /* synthetic */ zzid zzgt() {
            return (zze) zzgv();
        }

        @Override // com.google.android.gms.internal.vision.zzid.zza, com.google.android.gms.internal.vision.zzjm
        public /* synthetic */ zzjn zzgv() {
            if (this.zzxy) {
                return (zze) this.zzxx;
            }
            ((zze) this.zzxx).zzyg.zzej();
            return (zze) super.zzgv();
        }
    }

    public static class zzc<T extends zzid<T, ?>> extends zzgj<T> {
        private final T zzxw;

        public zzc(T t) {
            this.zzxw = t;
        }
    }

    public static final class zzd implements zzhv<zzd> {
        public final int number = 202056002;
        public final zzig<?> zzyc = null;
        public final zzlk zzyd;
        public final boolean zzye;
        public final boolean zzyf;

        public zzd(zzig<?> zzig, int i, zzlk zzlk, boolean z, boolean z2) {
            this.zzyd = zzlk;
            this.zzye = true;
            this.zzyf = false;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzd) obj).number;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.android.gms.internal.vision.zzid$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzhv
        public final zzjm zza(zzjm zzjm, zzjn zzjn) {
            return ((zza) zzjm).zza((zza) ((zzid) zzjn));
        }

        @Override // com.google.android.gms.internal.vision.zzhv
        public final int zzak() {
            return this.number;
        }

        @Override // com.google.android.gms.internal.vision.zzhv
        public final zzlk zzgm() {
            return this.zzyd;
        }

        @Override // com.google.android.gms.internal.vision.zzhv
        public final zzlr zzgn() {
            return this.zzyd.zzjk();
        }

        @Override // com.google.android.gms.internal.vision.zzhv
        public final boolean zzgo() {
            return this.zzye;
        }

        @Override // com.google.android.gms.internal.vision.zzhv
        public final boolean zzgp() {
            return false;
        }

        @Override // com.google.android.gms.internal.vision.zzhv
        public final zzjs zza(zzjs zzjs, zzjs zzjs2) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzid<MessageType, BuilderType> implements zzjp {
        public zzht<zzd> zzyg = zzht.zzgh();

        public final <Type> Type zzc(zzhp<MessageType, Type> zzhp) {
            zzg zza = zzid.zza(zzhp);
            if (zza.zzyp == ((zzid) zzgx())) {
                Type<Object> type = (Type) this.zzyg.zza((zzht<zzd>) zza.zzyr);
                if (type == null) {
                    return zza.zzgk;
                }
                zzd zzd = zza.zzyr;
                if (!zzd.zzye) {
                    return (Type) zza.zzl(type);
                }
                if (zzd.zzyd.zzjk() != zzlr.ENUM) {
                    return type;
                }
                Type type2 = (Type) new ArrayList();
                for (Object obj : type) {
                    type2.add(zza.zzl(obj));
                }
                return type2;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final zzht<zzd> zzhe() {
            if (this.zzyg.isImmutable()) {
                this.zzyg = (zzht) this.zzyg.clone();
            }
            return this.zzyg;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zzf {
        public static final int zzyh = 1;
        public static final int zzyi = 2;
        public static final int zzyj = 3;
        public static final int zzyk = 4;
        public static final int zzyl = 5;
        public static final int zzym = 6;
        public static final int zzyn = 7;
        private static final /* synthetic */ int[] zzyo = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zzhf() {
            return (int[]) zzyo.clone();
        }
    }

    public static class zzg<ContainingType extends zzjn, Type> extends zzhp<ContainingType, Type> {
        public final Type zzgk;
        public final ContainingType zzyp;
        public final zzjn zzyq;
        public final zzd zzyr;

        public zzg(ContainingType containingtype, Type type, zzjn zzjn, zzd zzd, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zzd.zzyd == zzlk.MESSAGE && zzjn == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzyp = containingtype;
                this.zzgk = type;
                this.zzyq = zzjn;
                this.zzyr = zzd;
            }
        }

        public final Object zzl(Object obj) {
            if (this.zzyr.zzyd.zzjk() != zzlr.ENUM) {
                return obj;
            }
            ((Integer) obj).intValue();
            throw null;
        }
    }

    public static <T extends zzid<?, ?>> void zza(Class<T> cls, T t) {
        zzyb.put(cls, t);
    }

    public static <T extends zzid<?, ?>> T zzd(Class<T> cls) {
        zzid<?, ?> zzid = zzyb.get(cls);
        if (zzid == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzid = (T) zzyb.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzid == null) {
            zzid = (T) ((zzid) ((zzid) zzld.zzh(cls)).zza(zzf.zzym, (Object) null, (Object) null));
            if (zzid != null) {
                zzyb.put(cls, zzid);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzid;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzii, com.google.android.gms.internal.vision.zzif] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.vision.zzii zzha() {
        /*
            com.google.android.gms.internal.vision.zzif r0 = com.google.android.gms.internal.vision.zzif.zzhg()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzid.zzha():com.google.android.gms.internal.vision.zzii");
    }

    public static <E> zzik<E> zzhb() {
        return zzka.zzij();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzkb.zzik().zzx(this).equals(this, (zzid) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzte;
        if (i != 0) {
            return i;
        }
        int hashCode = zzkb.zzik().zzx(this).hashCode(this);
        this.zzte = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzjp
    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzjo.zza(this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.vision.zzge
    public final void zzak(int i) {
        this.zzya = i;
    }

    @Override // com.google.android.gms.internal.vision.zzjn
    public final void zzb(zzhl zzhl) throws IOException {
        zzkb.zzik().zzx(this).zza(this, zzhn.zza(zzhl));
    }

    @Override // com.google.android.gms.internal.vision.zzge
    public final int zzef() {
        return this.zzya;
    }

    @Override // com.google.android.gms.internal.vision.zzjp
    public final /* synthetic */ zzjn zzgx() {
        return (zzid) zza(zzf.zzym, (Object) null, (Object) null);
    }

    public final <MessageType extends zzid<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzgy() {
        return (BuilderType) ((zza) zza(zzf.zzyl, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.vision.zzjn
    public final int zzgz() {
        if (this.zzya == -1) {
            this.zzya = zzkb.zzik().zzx(this).zzu(this);
        }
        return this.zzya;
    }

    @Override // com.google.android.gms.internal.vision.zzjn
    public final /* synthetic */ zzjm zzhc() {
        zza zza2 = (zza) zza(zzf.zzyl, (Object) null, (Object) null);
        zza2.zza((zza) this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.vision.zzjn
    public final /* synthetic */ zzjm zzhd() {
        return (zza) zza(zzf.zzyl, (Object) null, (Object) null);
    }

    public static Object zza(zzjn zzjn, String str, Object[] objArr) {
        return new zzkd(zzjn, str, objArr);
    }

    public static <ContainingType extends zzjn, Type> zzg<ContainingType, Type> zza(ContainingType containingtype, zzjn zzjn, zzig<?> zzig, int i, zzlk zzlk, boolean z, Class cls) {
        return new zzg<>(containingtype, Collections.emptyList(), zzjn, new zzd(null, 202056002, zzlk, true, false), cls);
    }

    public static abstract class zza<MessageType extends zzid<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgh<MessageType, BuilderType> {
        private final MessageType zzxw;
        public MessageType zzxx;
        public boolean zzxy = false;

        public zza(MessageType messagetype) {
            this.zzxw = messagetype;
            this.zzxx = (MessageType) ((zzid) messagetype.zza(zzf.zzyk, null, null));
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzho zzho) throws zzin {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            try {
                zzkb.zzik().zzx(this.zzxx).zza(this.zzxx, bArr, 0, i2, new zzgm(zzho));
                return this;
            } catch (zzin e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzin.zzhh();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.internal.vision.zzid$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzgh, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzxw.zza(zzf.zzyl, null, null);
            zza.zza((zza) ((zzid) zzgv()));
            return zza;
        }

        @Override // com.google.android.gms.internal.vision.zzjp
        public final boolean isInitialized() {
            return zzid.zza(this.zzxx, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            zza(this.zzxx, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.vision.zzgh
        public final /* synthetic */ zzgh zzeh() {
            return (zza) clone();
        }

        public void zzgs() {
            MessageType messagetype = (MessageType) ((zzid) this.zzxx.zza(zzf.zzyk, null, null));
            zza(messagetype, this.zzxx);
            this.zzxx = messagetype;
        }

        /* renamed from: zzgt */
        public MessageType zzgv() {
            if (this.zzxy) {
                return this.zzxx;
            }
            MessageType messagetype = this.zzxx;
            zzkb.zzik().zzx(messagetype).zzj(messagetype);
            this.zzxy = true;
            return this.zzxx;
        }

        /* renamed from: zzgu */
        public final MessageType zzgw() {
            MessageType messagetype = (MessageType) ((zzid) zzgv());
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzku(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.zzjp
        public final /* synthetic */ zzjn zzgx() {
            return this.zzxw;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzkb.zzik().zzx(messagetype).zzd(messagetype, messagetype2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.vision.zzid$zza<MessageType extends com.google.android.gms.internal.vision.zzid<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.vision.zzid$zza<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzgh
        public final /* synthetic */ zzgh zza(zzge zzge) {
            return zza((zza<MessageType, BuilderType>) ((zzid) zzge));
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzhe zzhe, zzho zzho) throws IOException {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            try {
                zzkb.zzik().zzx(this.zzxx).zza(this.zzxx, zzhj.zza(zzhe), zzho);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgh
        public final /* synthetic */ zzgh zza(byte[] bArr, int i, int i2, zzho zzho) throws zzin {
            return zzb(bArr, 0, i2, zzho);
        }
    }

    private static <T extends zzid<T, ?>> T zzb(T t) throws zzin {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzin(new zzku(t).getMessage()).zzg(t);
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

    /* access modifiers changed from: private */
    public static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzhp<MessageType, T> zzhp) {
        return (zzg) zzhp;
    }

    public static final <T extends zzid<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzyh, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzw = zzkb.zzik().zzx(t).zzw(t);
        if (z) {
            t.zza(zzf.zzyi, zzw ? t : null, null);
        }
        return zzw;
    }

    public static <E> zzik<E> zza(zzik<E> zzik) {
        int size = zzik.size();
        return zzik.zzan(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzid<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzho zzho) throws zzin {
        T t2 = (T) ((zzid) t.zza(zzf.zzyk, null, null));
        try {
            zzkf zzx = zzkb.zzik().zzx(t2);
            zzx.zza(t2, bArr, 0, i2, new zzgm(zzho));
            zzx.zzj(t2);
            if (t2.zzte == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzin) {
                throw ((zzin) e.getCause());
            }
            throw new zzin(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzin.zzhh().zzg(t2);
        }
    }

    public static <T extends zzid<T, ?>> T zza(T t, byte[] bArr) throws zzin {
        return (T) zzb(zza(t, bArr, 0, bArr.length, zzho.zzgf()));
    }

    public static <T extends zzid<T, ?>> T zza(T t, byte[] bArr, zzho zzho) throws zzin {
        return (T) zzb(zza(t, bArr, 0, bArr.length, zzho));
    }
}
