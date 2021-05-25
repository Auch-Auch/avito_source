package x6.e.d.a;

import java.security.cert.X509CRL;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.x509.X509AttributeCertificate;
public class h {
    public static final String a = Extension.targetInformation.getId();
    public static final String b = Extension.noRevAvail.getId();
    public static final String c = Extension.cRLDistributionPoints.getId();
    public static final String d = Extension.authorityInfoAccess.getId();

    public static void a(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, c cVar, i iVar, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        Iterator it;
        if (x509AttributeCertificate.getExtensionValue(X509Extensions.NoRevAvail.getId()) == null) {
            Date date2 = new Date(System.currentTimeMillis());
            if (date.getTime() <= date2.getTime()) {
                Iterator it2 = ((HashSet) b.i(distributionPoint, x509AttributeCertificate, date2, pKIXExtendedParameters)).iterator();
                AnnotatedException e = null;
                boolean z = false;
                while (it2.hasNext() && cVar.a == 11 && !iVar.a()) {
                    try {
                        X509CRL x509crl = (X509CRL) it2.next();
                        i p = g.p(x509crl, distributionPoint);
                        int i = p.a;
                        if (!((i | (iVar.a ^ i)) != 0)) {
                            continue;
                        } else {
                            it = it2;
                            try {
                                X509CRL s = pKIXExtendedParameters.isUseDeltasEnabled() ? g.s(b.j(date2, x509crl, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores()), g.r(x509crl, g.q(x509crl, null, null, pKIXExtendedParameters, list, jcaJceHelper))) : null;
                                if (pKIXExtendedParameters.getValidityModel() != 1) {
                                    if (x509AttributeCertificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                                        throw new AnnotatedException("No valid CRL for current time found.");
                                    }
                                }
                                g.m(distributionPoint, x509AttributeCertificate, x509crl);
                                g.n(distributionPoint, x509AttributeCertificate, x509crl);
                                g.o(s, x509crl, pKIXExtendedParameters);
                                String str = g.a;
                                if (pKIXExtendedParameters.isUseDeltasEnabled() && s != null) {
                                    b.h(date, s, x509AttributeCertificate, cVar);
                                }
                                if (cVar.a == 11) {
                                    b.h(date, x509crl, x509AttributeCertificate, cVar);
                                }
                                if (cVar.a == 8) {
                                    cVar.a = 11;
                                }
                                iVar.a |= p.a;
                                it2 = it;
                                z = true;
                            } catch (AnnotatedException e2) {
                                e = e2;
                                it2 = it;
                            }
                        }
                    } catch (AnnotatedException e3) {
                        e = e3;
                        it = it2;
                        it2 = it;
                    }
                }
                if (!z) {
                    throw e;
                }
                return;
            }
            throw new AnnotatedException("Validation time is in future.");
        }
    }
}
