package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedw;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
public final class zzedt<T_WRAPPER extends zzedw<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzedt.class.getName());
    private static final List<Provider> zzhzl;
    public static final zzedt<zzedv, Cipher> zzhzm = new zzedt<>(new zzedv());
    public static final zzedt<zzedz, Mac> zzhzn = new zzedt<>(new zzedz());
    private static final zzedt<zzeeb, Signature> zzhzo = new zzedt<>(new zzeeb());
    private static final zzedt<zzeec, MessageDigest> zzhzp = new zzedt<>(new zzeec());
    public static final zzedt<zzedy, KeyAgreement> zzhzq = new zzedt<>(new zzedy());
    public static final zzedt<zzeea, KeyPairGenerator> zzhzr = new zzedt<>(new zzeea());
    public static final zzedt<zzedx, KeyFactory> zzhzs = new zzedt<>(new zzedx());
    private T_WRAPPER zzhzt;
    private List<Provider> zzhzu = zzhzl;
    private boolean zzhzv = true;

    static {
        if (zzeek.zzbcx()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzhzl = arrayList;
        } else {
            zzhzl = new ArrayList();
        }
    }

    private zzedt(T_WRAPPER t_wrapper) {
        this.zzhzt = t_wrapper;
    }

    public final T_ENGINE zzhs(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider provider : this.zzhzu) {
            try {
                return (T_ENGINE) this.zzhzt.zza(str, provider);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.zzhzv) {
            return (T_ENGINE) this.zzhzt.zza(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
