package org.spongycastle.jce.provider;

import java.security.cert.CertPathValidatorSpi;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {
    public final JcaJceHelper a = new BCJcaJceHelper();

    /* JADX WARNING: Removed duplicated region for block: B:195:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0436  */
    @Override // java.security.cert.CertPathValidatorSpi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.CertPathValidatorResult engineValidate(java.security.cert.CertPath r23, java.security.cert.CertPathParameters r24) throws java.security.cert.CertPathValidatorException, java.security.InvalidAlgorithmParameterException {
        /*
        // Method dump skipped, instructions count: 1278
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi.engineValidate(java.security.cert.CertPath, java.security.cert.CertPathParameters):java.security.cert.CertPathValidatorResult");
    }
}
