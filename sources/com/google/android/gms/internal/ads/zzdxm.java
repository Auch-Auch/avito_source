package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.internal.ads.zzecb;
import java.security.GeneralSecurityException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class zzdxm {
    private static final Logger logger = Logger.getLogger(zzdxm.class.getName());
    private static final ConcurrentMap<String, zzb> zzhrk = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zza> zzhrl = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzhrm = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdwp<?>> zzhrn = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdxh<?>> zzhro = new ConcurrentHashMap();

    public interface zza {
    }

    public interface zzb {
        Set<Class<?>> zzaxt();

        zzdww<?> zzayd();

        Class<?> zzaye();

        Class<?> zzayf();

        <P> zzdww<P> zzb(Class<P> cls) throws GeneralSecurityException;
    }

    private static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    private static <KeyProtoT extends zzehz> zzb zza(zzdwx<KeyProtoT> zzdwx) {
        return new zzdxo(zzdwx);
    }

    private static <KeyProtoT extends zzehz> zza zzb(zzdwx<KeyProtoT> zzdwx) {
        return new zzdxp(zzdwx);
    }

    private static synchronized zzb zzhm(String str) throws GeneralSecurityException {
        zzb zzb2;
        synchronized (zzdxm.class) {
            ConcurrentMap<String, zzb> concurrentMap = zzhrk;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzb2 = concurrentMap.get(str);
        }
        return zzb2;
    }

    @Deprecated
    public static zzdwp<?> zzhn(String str) throws GeneralSecurityException {
        if (str != null) {
            zzdwp<?> zzdwp = zzhrn.get(str.toLowerCase());
            if (zzdwp != null) {
                return zzdwp;
            }
            String format = String.format("no catalogue found for %s. ", str);
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase().startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static zzdww<?> zzho(String str) throws GeneralSecurityException {
        return zzhm(str).zzayd();
    }

    private static synchronized void zza(String str, Class<?> cls, boolean z) throws GeneralSecurityException {
        synchronized (zzdxm.class) {
            ConcurrentMap<String, zzb> concurrentMap = zzhrk;
            if (concurrentMap.containsKey(str)) {
                zzb zzb2 = concurrentMap.get(str);
                if (!zzb2.zzaye().equals(cls)) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str);
                    logger2.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzb2.zzaye().getName(), cls.getName()));
                } else if (z && !zzhrm.get(str).booleanValue()) {
                    String valueOf2 = String.valueOf(str);
                    throw new GeneralSecurityException(valueOf2.length() != 0 ? "New keys are already disallowed for key type ".concat(valueOf2) : new String("New keys are already disallowed for key type "));
                }
            }
        }
    }

    public static synchronized zzehz zzb(zzebw zzebw) throws GeneralSecurityException {
        zzehz zzn;
        synchronized (zzdxm.class) {
            zzdww<?> zzho = zzho(zzebw.zzbay());
            if (zzhrm.get(zzebw.zzbay()).booleanValue()) {
                zzn = zzho.zzn(zzebw.zzbaz());
            } else {
                String valueOf = String.valueOf(zzebw.zzbay());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    public static synchronized <P> void zza(zzdww<P> zzdww, boolean z) throws GeneralSecurityException {
        synchronized (zzdxm.class) {
            if (zzdww != null) {
                String keyType = zzdww.getKeyType();
                zza(keyType, zzdww.getClass(), z);
                ConcurrentMap<String, zzb> concurrentMap = zzhrk;
                if (!concurrentMap.containsKey(keyType)) {
                    concurrentMap.put(keyType, new zzdxl(zzdww));
                }
                zzhrm.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzehz> void zza(zzdwx<KeyProtoT> zzdwx, boolean z) throws GeneralSecurityException {
        synchronized (zzdxm.class) {
            String keyType = zzdwx.getKeyType();
            zza(keyType, zzdwx.getClass(), true);
            ConcurrentMap<String, zzb> concurrentMap = zzhrk;
            if (!concurrentMap.containsKey(keyType)) {
                concurrentMap.put(keyType, zza(zzdwx));
                zzhrl.put(keyType, zzb(zzdwx));
            }
            zzhrm.put(keyType, Boolean.TRUE);
        }
    }

    public static synchronized <KeyProtoT extends zzehz, PublicKeyProtoT extends zzehz> void zza(zzdxj<KeyProtoT, PublicKeyProtoT> zzdxj, zzdwx<PublicKeyProtoT> zzdwx, boolean z) throws GeneralSecurityException {
        Class<?> zzayf;
        synchronized (zzdxm.class) {
            String keyType = zzdxj.getKeyType();
            String keyType2 = zzdwx.getKeyType();
            zza(keyType, zzdxj.getClass(), true);
            zza(keyType2, zzdwx.getClass(), false);
            if (!keyType.equals(keyType2)) {
                ConcurrentMap<String, zzb> concurrentMap = zzhrk;
                if (concurrentMap.containsKey(keyType) && (zzayf = concurrentMap.get(keyType).zzayf()) != null) {
                    if (!zzayf.equals(zzdwx.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder(keyType.length() + 96 + String.valueOf(keyType2).length());
                        sb.append("Attempted overwrite of a registered key manager for key type ");
                        sb.append(keyType);
                        sb.append(" with inconsistent public key type ");
                        sb.append(keyType2);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzdxj.getClass().getName(), zzayf.getName(), zzdwx.getClass().getName()));
                    }
                }
                if (!concurrentMap.containsKey(keyType) || concurrentMap.get(keyType).zzayf() == null) {
                    concurrentMap.put(keyType, new zzdxn(zzdxj, zzdwx));
                    zzhrl.put(keyType, zzb(zzdxj));
                }
                ConcurrentMap<String, Boolean> concurrentMap2 = zzhrm;
                concurrentMap2.put(keyType, Boolean.TRUE);
                if (!concurrentMap.containsKey(keyType2)) {
                    concurrentMap.put(keyType2, zza(zzdwx));
                }
                concurrentMap2.put(keyType2, Boolean.FALSE);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    public static synchronized <P> void zza(zzdxh<P> zzdxh) throws GeneralSecurityException {
        synchronized (zzdxm.class) {
            if (zzdxh != null) {
                Class<P> zzaxp = zzdxh.zzaxp();
                ConcurrentMap<Class<?>, zzdxh<?>> concurrentMap = zzhro;
                if (concurrentMap.containsKey(zzaxp)) {
                    zzdxh<?> zzdxh2 = concurrentMap.get(zzaxp);
                    if (!zzdxh.getClass().equals(zzdxh2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzaxp.toString());
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzaxp.getName(), zzdxh2.getClass().getName(), zzdxh.getClass().getName()));
                    }
                }
                concurrentMap.put(zzaxp, zzdxh);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static <P> zzdww<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzb zzhm = zzhm(str);
        if (cls == null) {
            return (zzdww<P>) zzhm.zzayd();
        }
        if (zzhm.zzaxt().contains(cls)) {
            return zzhm.zzb(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzhm.zzaye());
        Set<Class<?>> zzaxt = zzhm.zzaxt();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : zzaxt) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        throw new GeneralSecurityException(a.t(a.K(a.q0(sb2, valueOf.length() + name.length() + 77), "Primitive type ", name, " not supported by key manager of type ", valueOf), ", supported primitives: ", sb2));
    }

    public static synchronized zzebt zza(zzebw zzebw) throws GeneralSecurityException {
        zzebt zzo;
        synchronized (zzdxm.class) {
            zzdww<?> zzho = zzho(zzebw.zzbay());
            if (zzhrm.get(zzebw.zzbay()).booleanValue()) {
                zzo = zzho.zzo(zzebw.zzbaz());
            } else {
                String valueOf = String.valueOf(zzebw.zzbay());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static <P> P zza(String str, zzehz zzehz, Class<P> cls) throws GeneralSecurityException {
        return (P) zza(str, (Class) checkNotNull(cls)).zza(zzehz);
    }

    private static <P> P zza(String str, zzeff zzeff, Class<P> cls) throws GeneralSecurityException {
        return (P) zza(str, cls).zzm(zzeff);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) zza(str, zzeff.zzu(bArr), (Class) checkNotNull(cls));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: com.google.android.gms.internal.ads.zzdxf<P> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzdxf<P> zza(zzdxc zzdxc, zzdww<P> zzdww, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) checkNotNull(cls);
        zzdxq.zzc(zzdxc.zzaxx());
        zzdxf<P> zzdxf = (zzdxf<P>) zzdxf.zza(cls2);
        for (zzecb.zzb zzb2 : zzdxc.zzaxx().zzbbm()) {
            if (zzb2.zzaya() == zzebu.ENABLED) {
                zzdxi zza2 = zzdxf.zza(zza(zzb2.zzbbq().zzbay(), zzb2.zzbbq().zzbaz(), cls2), zzb2);
                if (zzb2.zzbbr() == zzdxc.zzaxx().zzbbl()) {
                    zzdxf.zza(zza2);
                }
            }
        }
        return zzdxf;
    }

    public static <P> P zza(zzdxf<P> zzdxf) throws GeneralSecurityException {
        zzdxh<?> zzdxh = zzhro.get(zzdxf.zzaxp());
        if (zzdxh != null) {
            return (P) zzdxh.zza(zzdxf);
        }
        String name = zzdxf.zzaxp().getName();
        throw new GeneralSecurityException(name.length() != 0 ? "No wrapper found for ".concat(name) : new String("No wrapper found for "));
    }
}
