package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.spongycastle.jcajce.PKIXCertStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import x6.e.d.a.b;
public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi {
    public Exception a;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (x6.e.d.a.b.c(r8, r4, r5) != null) goto L_0x004e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.CertPathBuilderResult build(java.security.cert.X509Certificate r8, org.spongycastle.jcajce.PKIXExtendedBuilderParameters r9, java.util.List r10) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXCertPathBuilderSpi.build(java.security.cert.X509Certificate, org.spongycastle.jcajce.PKIXExtendedBuilderParameters, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters;
        Exception exc;
        PKIXExtendedBuilderParameters.Builder builder;
        if (certPathParameters instanceof PKIXBuilderParameters) {
            PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) certPathParameters;
            PKIXExtendedParameters.Builder builder2 = new PKIXExtendedParameters.Builder(pKIXBuilderParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                for (PKIXCertStore pKIXCertStore : extendedPKIXBuilderParameters.getAdditionalStores()) {
                    builder2.addCertificateStore(pKIXCertStore);
                }
                builder = new PKIXExtendedBuilderParameters.Builder(builder2.build());
                builder.addExcludedCerts(extendedPKIXBuilderParameters.getExcludedCerts());
                builder.setMaxPathLength(extendedPKIXBuilderParameters.getMaxPathLength());
            } else {
                builder = new PKIXExtendedBuilderParameters.Builder(pKIXBuilderParameters);
            }
            pKIXExtendedBuilderParameters = builder.build();
        } else if (certPathParameters instanceof PKIXExtendedBuilderParameters) {
            pKIXExtendedBuilderParameters = (PKIXExtendedBuilderParameters) certPathParameters;
        } else {
            StringBuilder L = a.L("Parameters must be an instance of ");
            L.append(PKIXBuilderParameters.class.getName());
            L.append(" or ");
            L.append(PKIXExtendedBuilderParameters.class.getName());
            L.append(".");
            throw new InvalidAlgorithmParameterException(L.toString());
        }
        ArrayList arrayList = new ArrayList();
        PKIXCertStoreSelector targetConstraints = pKIXExtendedBuilderParameters.getBaseParameters().getTargetConstraints();
        try {
            Collection a3 = b.a(targetConstraints, pKIXExtendedBuilderParameters.getBaseParameters().getCertificateStores());
            a3.addAll(b.a(targetConstraints, pKIXExtendedBuilderParameters.getBaseParameters().getCertStores()));
            if (!a3.isEmpty()) {
                CertPathBuilderResult certPathBuilderResult = null;
                Iterator it = a3.iterator();
                while (it.hasNext() && certPathBuilderResult == null) {
                    certPathBuilderResult = build((X509Certificate) it.next(), pKIXExtendedBuilderParameters, arrayList);
                }
                if (certPathBuilderResult != null || (exc = this.a) == null) {
                    if (!(certPathBuilderResult == null && this.a == null)) {
                        return certPathBuilderResult;
                    }
                    throw new CertPathBuilderException("Unable to find certificate chain.");
                } else if (exc instanceof AnnotatedException) {
                    throw new CertPathBuilderException(this.a.getMessage(), this.a.getCause());
                } else {
                    throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.a);
                }
            } else {
                throw new CertPathBuilderException("No certificate found matching targetContraints.");
            }
        } catch (AnnotatedException e) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", e);
        }
    }
}
