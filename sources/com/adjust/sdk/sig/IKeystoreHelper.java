package com.adjust.sdk.sig;

import android.content.Context;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
public interface IKeystoreHelper {
    void deleteKeys(Context context) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException;

    int getApiLevel();

    byte[] getHmac(Context context, byte[] bArr) throws Exception;

    void initKeys(Context context) throws Exception;
}
