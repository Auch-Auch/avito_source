package org.spongycastle.x509;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;
import x6.e.g.e;
public class X509Store implements Store {
    public Provider a;
    public X509StoreSpi b;

    public X509Store(Provider provider, X509StoreSpi x509StoreSpi) {
        this.a = provider;
        this.b = x509StoreSpi;
    }

    public static X509Store getInstance(String str, X509StoreParameters x509StoreParameters) throws NoSuchStoreException {
        try {
            e.a f = e.f("X509Store", str);
            X509StoreSpi x509StoreSpi = (X509StoreSpi) f.a;
            x509StoreSpi.engineInit(x509StoreParameters);
            return new X509Store(f.b, x509StoreSpi);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchStoreException(e.getMessage());
        }
    }

    @Override // org.spongycastle.util.Store
    public Collection getMatches(Selector selector) {
        return this.b.engineGetMatches(selector);
    }

    public Provider getProvider() {
        return this.a;
    }

    public static X509Store getInstance(String str, X509StoreParameters x509StoreParameters, String str2) throws NoSuchStoreException, NoSuchProviderException {
        return getInstance(str, x509StoreParameters, e.h(str2));
    }

    public static X509Store getInstance(String str, X509StoreParameters x509StoreParameters, Provider provider) throws NoSuchStoreException {
        try {
            e.a g = e.g("X509Store", str, provider);
            X509StoreSpi x509StoreSpi = (X509StoreSpi) g.a;
            x509StoreSpi.engineInit(x509StoreParameters);
            return new X509Store(g.b, x509StoreSpi);
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchStoreException(e.getMessage());
        }
    }
}
