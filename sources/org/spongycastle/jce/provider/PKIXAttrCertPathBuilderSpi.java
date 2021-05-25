package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Principal;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.Certificate;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;
import x6.e.d.a.b;
public class PKIXAttrCertPathBuilderSpi extends CertPathBuilderSpi {
    public Exception a;

    public static Collection findCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof Store) {
                try {
                    hashSet.addAll(((Store) obj).getMatches(x509AttributeCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (x6.e.d.a.b.c(r9, r3, r5) != null) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.CertPathBuilderResult a(org.spongycastle.x509.X509AttributeCertificate r8, java.security.cert.X509Certificate r9, org.spongycastle.jcajce.PKIXExtendedBuilderParameters r10, java.util.List r11) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi.a(org.spongycastle.x509.X509AttributeCertificate, java.security.cert.X509Certificate, org.spongycastle.jcajce.PKIXExtendedBuilderParameters, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters;
        boolean z = certPathParameters instanceof PKIXBuilderParameters;
        if (z || (certPathParameters instanceof ExtendedPKIXBuilderParameters) || (certPathParameters instanceof PKIXExtendedBuilderParameters)) {
            List arrayList = new ArrayList();
            if (z) {
                PKIXExtendedBuilderParameters.Builder builder = new PKIXExtendedBuilderParameters.Builder((PKIXBuilderParameters) certPathParameters);
                if (certPathParameters instanceof ExtendedPKIXParameters) {
                    ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                    builder.addExcludedCerts(extendedPKIXBuilderParameters.getExcludedCerts());
                    builder.setMaxPathLength(extendedPKIXBuilderParameters.getMaxPathLength());
                    arrayList = extendedPKIXBuilderParameters.getStores();
                }
                pKIXExtendedBuilderParameters = builder.build();
            } else {
                pKIXExtendedBuilderParameters = (PKIXExtendedBuilderParameters) certPathParameters;
            }
            ArrayList arrayList2 = new ArrayList();
            PKIXCertStoreSelector targetConstraints = pKIXExtendedBuilderParameters.getBaseParameters().getTargetConstraints();
            if (targetConstraints instanceof X509AttributeCertStoreSelector) {
                try {
                    Collection findCertificates = findCertificates((X509AttributeCertStoreSelector) targetConstraints, arrayList);
                    if (!findCertificates.isEmpty()) {
                        CertPathBuilderResult certPathBuilderResult = null;
                        Iterator it = findCertificates.iterator();
                        while (it.hasNext() && certPathBuilderResult == null) {
                            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) it.next();
                            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
                            Principal[] principals = x509AttributeCertificate.getIssuer().getPrincipals();
                            HashSet hashSet = new HashSet();
                            for (int i = 0; i < principals.length; i++) {
                                try {
                                    if (principals[i] instanceof X500Principal) {
                                        x509CertStoreSelector.setSubject(((X500Principal) principals[i]).getEncoded());
                                    }
                                    PKIXCertStoreSelector<? extends Certificate> build = new PKIXCertStoreSelector.Builder(x509CertStoreSelector).build();
                                    hashSet.addAll(b.a(build, pKIXExtendedBuilderParameters.getBaseParameters().getCertStores()));
                                    hashSet.addAll(b.a(build, pKIXExtendedBuilderParameters.getBaseParameters().getCertificateStores()));
                                } catch (AnnotatedException e) {
                                    throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", e);
                                } catch (IOException e2) {
                                    throw new ExtCertPathBuilderException("cannot encode X500Principal.", e2);
                                }
                            }
                            if (!hashSet.isEmpty()) {
                                Iterator it2 = hashSet.iterator();
                                while (it2.hasNext() && certPathBuilderResult == null) {
                                    certPathBuilderResult = a(x509AttributeCertificate, (X509Certificate) it2.next(), pKIXExtendedBuilderParameters, arrayList2);
                                }
                            } else {
                                throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
                            }
                        }
                        if (certPathBuilderResult == null && this.a != null) {
                            throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", this.a);
                        } else if (certPathBuilderResult != null || this.a != null) {
                            return certPathBuilderResult;
                        } else {
                            throw new CertPathBuilderException("Unable to find certificate chain.");
                        }
                    } else {
                        throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
                    }
                } catch (AnnotatedException e3) {
                    throw new ExtCertPathBuilderException("Error finding target attribute certificate.", e3);
                }
            } else {
                StringBuilder L = a.L("TargetConstraints must be an instance of ");
                L.append(X509AttributeCertStoreSelector.class.getName());
                L.append(" for ");
                L.append(getClass().getName());
                L.append(" class.");
                throw new CertPathBuilderException(L.toString());
            }
        } else {
            StringBuilder L2 = a.L("Parameters must be an instance of ");
            L2.append(PKIXBuilderParameters.class.getName());
            L2.append(" or ");
            L2.append(PKIXExtendedBuilderParameters.class.getName());
            L2.append(".");
            throw new InvalidAlgorithmParameterException(L2.toString());
        }
    }
}
