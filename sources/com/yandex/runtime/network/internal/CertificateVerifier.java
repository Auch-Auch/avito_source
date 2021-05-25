package com.yandex.runtime.network.internal;

import android.net.http.X509TrustManagerExtensions;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
public final class CertificateVerifier {
    private static X509Certificate[] decodeChain(byte[][] bArr) {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            X509Certificate[] x509CertificateArr = new X509Certificate[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                x509CertificateArr[i] = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(bArr[i]));
            }
            return x509CertificateArr;
        } catch (CertificateException unused) {
            return null;
        }
    }

    private static X509TrustManager getTrustManager() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers == null) {
                return null;
            }
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    return (X509TrustManager) trustManagers[i];
                }
            }
            return null;
        } catch (KeyStoreException | NoSuchAlgorithmException unused) {
        }
    }

    public static boolean verify(byte[][] bArr) {
        X509TrustManager trustManager;
        X509Certificate[] decodeChain = decodeChain(bArr);
        if (decodeChain == null || (trustManager = getTrustManager()) == null) {
            return false;
        }
        try {
            new X509TrustManagerExtensions(trustManager).checkServerTrusted(decodeChain, "TLS", "");
            return true;
        } catch (CertificateException e) {
            e.getMessage();
            return false;
        } catch (IllegalArgumentException e2) {
            e2.getMessage();
            return false;
        }
    }
}
