package com.google.android.gms.internal.ads;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
public final class zzg extends zzj {
    private byte[] zzj;

    public zzg(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.zzj = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzj, java.security.cert.Certificate
    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.zzj;
    }
}
