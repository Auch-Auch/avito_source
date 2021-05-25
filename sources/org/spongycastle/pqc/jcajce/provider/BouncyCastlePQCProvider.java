package org.spongycastle.pqc.jcajce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    public static final ProviderConfiguration CONFIGURATION = null;
    public static String PROVIDER_NAME = "BCPQC";
    public static final Map a = new HashMap();
    public static final String[] b = {"Rainbow", "McEliece", "SPHINCS", "NH", "XMSS"};

    public class a implements PrivilegedAction {
        public a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            BouncyCastlePQCProvider bouncyCastlePQCProvider = BouncyCastlePQCProvider.this;
            String str = BouncyCastlePQCProvider.PROVIDER_NAME;
            Objects.requireNonNull(bouncyCastlePQCProvider);
            String[] strArr = BouncyCastlePQCProvider.b;
            int i = 0;
            while (true) {
                Class<?> cls = null;
                if (i == strArr.length) {
                    return null;
                }
                String t = a2.b.a.a.a.t(a2.b.a.a.a.L("org.spongycastle.pqc.jcajce.provider."), strArr[i], "$Mappings");
                try {
                    ClassLoader classLoader = BouncyCastlePQCProvider.class.getClassLoader();
                    if (classLoader != null) {
                        cls = classLoader.loadClass(t);
                    } else {
                        cls = (Class) AccessController.doPrivileged(new x6.e.f.b.a.a(t));
                    }
                } catch (ClassNotFoundException unused) {
                }
                if (cls != null) {
                    try {
                        ((AlgorithmProvider) cls.newInstance()).configure(bouncyCastlePQCProvider);
                    } catch (Exception e) {
                        StringBuilder Q = a2.b.a.a.a.Q("cannot create instance of ", "org.spongycastle.pqc.jcajce.provider.");
                        Q.append(strArr[i]);
                        Q.append("$Mappings : ");
                        Q.append(e);
                        throw new InternalError(Q.toString());
                    }
                }
                i++;
            }
        }
    }

    public BouncyCastlePQCProvider() {
        super(PROVIDER_NAME, 1.58d, "BouncyCastle Post-Quantum Security Provider v1.58");
        AccessController.doPrivileged(new a());
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        Map map = a;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(algorithm);
        }
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePrivate(privateKeyInfo);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        Map map = a;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(algorithm);
        }
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePublic(subjectPublicKeyInfo);
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException(a2.b.a.a.a.e3("duplicate provider key (", str, ") found"));
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addAttributes(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            String e3 = a2.b.a.a.a.e3(str, " ", str2);
            if (!containsKey(e3)) {
                put(e3, map.get(str2));
            } else {
                throw new IllegalStateException(a2.b.a.a.a.e3("duplicate provider attribute key (", e3, ") found"));
            }
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        Map map = a;
        synchronized (map) {
            map.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + "." + str2)) {
            if (!containsKey("Alg.Alias." + str + "." + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void setParameter(String str, Object obj) {
        synchronized (CONFIGURATION) {
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        if (containsKey(str + "." + str2)) {
            addAlgorithm(str + "." + aSN1ObjectIdentifier, str2);
            addAlgorithm(str + ".OID." + aSN1ObjectIdentifier, str2);
            return;
        }
        throw new IllegalStateException(a2.b.a.a.a.f("primary key (", str, ".", str2, ") not found"));
    }
}
