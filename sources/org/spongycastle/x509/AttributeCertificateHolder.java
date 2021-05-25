package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.Holder;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.asn1.x509.ObjectDigestInfo;
import org.spongycastle.jce.PrincipalUtil;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;
import x6.e.g.e;
public class AttributeCertificateHolder implements CertSelector, Selector {
    public final Holder a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AttributeCertificateHolder(X500Principal x500Principal) {
        this(new X509Principal(x500Principal.getEncoded()));
        Hashtable hashtable = e.a;
        try {
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot convert principal");
        }
    }

    public final Principal[] a(GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        ArrayList arrayList = new ArrayList(names.length);
        for (int i = 0; i != names.length; i++) {
            if (names[i].getTagNo() == 4) {
                try {
                    arrayList.add(new X500Principal(names[i].getName().toASN1Primitive().getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        Object[] array = arrayList.toArray(new Object[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 != array.length; i2++) {
            if (array[i2] instanceof Principal) {
                arrayList2.add(array[i2]);
            }
        }
        return (Principal[]) arrayList2.toArray(new Principal[arrayList2.size()]);
    }

    public final boolean b(X509Principal x509Principal, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4) {
                try {
                    if (new X509Principal(generalName.getName().toASN1Primitive().getEncoded()).equals(x509Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // java.security.cert.CertSelector, java.lang.Object, org.spongycastle.util.Selector
    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.a.toASN1Primitive());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return false;
        }
        return this.a.equals(((AttributeCertificateHolder) obj).a);
    }

    public String getDigestAlgorithm() {
        if (this.a.getObjectDigestInfo() != null) {
            return this.a.getObjectDigestInfo().getDigestAlgorithm().getAlgorithm().getId();
        }
        return null;
    }

    public int getDigestedObjectType() {
        if (this.a.getObjectDigestInfo() != null) {
            return this.a.getObjectDigestInfo().getDigestedObjectType().getValue().intValue();
        }
        return -1;
    }

    public Principal[] getEntityNames() {
        if (this.a.getEntityName() != null) {
            return a(this.a.getEntityName());
        }
        return null;
    }

    public Principal[] getIssuer() {
        if (this.a.getBaseCertificateID() != null) {
            return a(this.a.getBaseCertificateID().getIssuer());
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.a.getObjectDigestInfo() != null) {
            return this.a.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public String getOtherObjectTypeID() {
        if (this.a.getObjectDigestInfo() == null) {
            return null;
        }
        this.a.getObjectDigestInfo().getOtherObjectTypeID().getId();
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.a.getBaseCertificateID() != null) {
            return this.a.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        try {
            if (this.a.getBaseCertificateID() != null) {
                if (!this.a.getBaseCertificateID().getSerial().getValue().equals(x509Certificate.getSerialNumber()) || !b(PrincipalUtil.getIssuerX509Principal(x509Certificate), this.a.getBaseCertificateID().getIssuer())) {
                    return false;
                }
                return true;
            } else if (this.a.getEntityName() != null && b(PrincipalUtil.getSubjectX509Principal(x509Certificate), this.a.getEntityName())) {
                return true;
            } else {
                if (this.a.getObjectDigestInfo() != null) {
                    MessageDigest instance = MessageDigest.getInstance(getDigestAlgorithm(), BouncyCastleProvider.PROVIDER_NAME);
                    int digestedObjectType = getDigestedObjectType();
                    if (digestedObjectType == 0) {
                        instance.update(certificate.getPublicKey().getEncoded());
                    } else if (digestedObjectType == 1) {
                        instance.update(certificate.getEncoded());
                    }
                    if (!Arrays.areEqual(instance.digest(), getObjectDigest())) {
                    }
                }
                return false;
            }
        } catch (CertificateEncodingException unused) {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AttributeCertificateHolder(X500Principal x500Principal, BigInteger bigInteger) {
        this(new X509Principal(x500Principal.getEncoded()), bigInteger);
        Hashtable hashtable = e.a;
        try {
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot convert principal");
        }
    }

    public AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.a = Holder.getInstance(aSN1Sequence);
    }

    public AttributeCertificateHolder(X509Principal x509Principal, BigInteger bigInteger) {
        this.a = new Holder(new IssuerSerial(GeneralNames.getInstance(new DERSequence(new GeneralName(x509Principal))), new ASN1Integer(bigInteger)));
    }

    public AttributeCertificateHolder(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            this.a = new Holder(new IssuerSerial(GeneralNames.getInstance(new DERSequence(new GeneralName(PrincipalUtil.getIssuerX509Principal(x509Certificate)))), new ASN1Integer(x509Certificate.getSerialNumber())));
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    @Override // org.spongycastle.util.Selector
    public boolean match(Object obj) {
        if (!(obj instanceof X509Certificate)) {
            return false;
        }
        return match((Certificate) obj);
    }

    public AttributeCertificateHolder(X509Principal x509Principal) {
        this.a = new Holder(GeneralNames.getInstance(new DERSequence(new GeneralName(x509Principal))));
    }

    public AttributeCertificateHolder(int i, String str, String str2, byte[] bArr) {
        this.a = new Holder(new ObjectDigestInfo(i, new ASN1ObjectIdentifier(str2), new AlgorithmIdentifier(new ASN1ObjectIdentifier(str)), Arrays.clone(bArr)));
    }
}
