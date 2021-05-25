package org.spongycastle.jce.provider;

import java.security.cert.CertPathValidatorSpi;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    public final JcaJceHelper a = new BCJcaJceHelper();

    public static void a(X509Certificate x509Certificate) throws AnnotatedException {
        try {
            TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
        } catch (CertificateEncodingException unused) {
            throw new AnnotatedException("unable to process TBSCertificate");
        } catch (IllegalArgumentException e) {
            throw new AnnotatedException(e.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:181:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:609:0x0502 A[EDGE_INSN: B:609:0x0502->B:207:0x0502 ?: BREAK  , SYNTHETIC] */
    @Override // java.security.cert.CertPathValidatorSpi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.CertPathValidatorResult engineValidate(java.security.cert.CertPath r50, java.security.cert.CertPathParameters r51) throws java.security.cert.CertPathValidatorException, java.security.InvalidAlgorithmParameterException {
        /*
        // Method dump skipped, instructions count: 3292
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXCertPathValidatorSpi.engineValidate(java.security.cert.CertPath, java.security.cert.CertPathParameters):java.security.cert.CertPathValidatorResult");
    }
}
