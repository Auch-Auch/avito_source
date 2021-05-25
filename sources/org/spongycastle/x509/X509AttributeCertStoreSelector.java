package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.Target;
import org.spongycastle.asn1.x509.TargetInformation;
import org.spongycastle.asn1.x509.Targets;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.util.Selector;
public class X509AttributeCertStoreSelector implements Selector {
    public AttributeCertificateHolder a;
    public AttributeCertificateIssuer b;
    public BigInteger c;
    public Date d;
    public X509AttributeCertificate e;
    public Collection f = new HashSet();
    public Collection g = new HashSet();

    public final Set a(Collection collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (Object obj : collection) {
            if (obj instanceof GeneralName) {
                hashSet.add(obj);
            } else {
                hashSet.add(GeneralName.getInstance(ASN1Primitive.fromByteArray((byte[]) obj)));
            }
        }
        return hashSet;
    }

    public void addTargetGroup(GeneralName generalName) {
        this.g.add(generalName);
    }

    public void addTargetName(GeneralName generalName) {
        this.f.add(generalName);
    }

    @Override // org.spongycastle.util.Selector, java.lang.Object
    public Object clone() {
        X509AttributeCertStoreSelector x509AttributeCertStoreSelector = new X509AttributeCertStoreSelector();
        x509AttributeCertStoreSelector.e = this.e;
        x509AttributeCertStoreSelector.d = getAttributeCertificateValid();
        x509AttributeCertStoreSelector.a = this.a;
        x509AttributeCertStoreSelector.b = this.b;
        x509AttributeCertStoreSelector.c = this.c;
        x509AttributeCertStoreSelector.g = getTargetGroups();
        x509AttributeCertStoreSelector.f = getTargetNames();
        return x509AttributeCertStoreSelector;
    }

    public X509AttributeCertificate getAttributeCert() {
        return this.e;
    }

    public Date getAttributeCertificateValid() {
        if (this.d != null) {
            return new Date(this.d.getTime());
        }
        return null;
    }

    public AttributeCertificateHolder getHolder() {
        return this.a;
    }

    public AttributeCertificateIssuer getIssuer() {
        return this.b;
    }

    public BigInteger getSerialNumber() {
        return this.c;
    }

    public Collection getTargetGroups() {
        return Collections.unmodifiableCollection(this.g);
    }

    public Collection getTargetNames() {
        return Collections.unmodifiableCollection(this.f);
    }

    @Override // org.spongycastle.util.Selector
    public boolean match(Object obj) {
        byte[] extensionValue;
        if (!(obj instanceof X509AttributeCertificate)) {
            return false;
        }
        X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) obj;
        X509AttributeCertificate x509AttributeCertificate2 = this.e;
        if (!(x509AttributeCertificate2 == null || x509AttributeCertificate2.equals(x509AttributeCertificate))) {
            return false;
        }
        if (!(this.c == null || x509AttributeCertificate.getSerialNumber().equals(this.c))) {
            return false;
        }
        if (!(this.a == null || x509AttributeCertificate.getHolder().equals(this.a))) {
            return false;
        }
        if (!(this.b == null || x509AttributeCertificate.getIssuer().equals(this.b))) {
            return false;
        }
        Date date = this.d;
        if (date != null) {
            try {
                x509AttributeCertificate.checkValidity(date);
            } catch (CertificateExpiredException | CertificateNotYetValidException unused) {
                return false;
            }
        }
        if ((!this.f.isEmpty() || !this.g.isEmpty()) && (extensionValue = x509AttributeCertificate.getExtensionValue(X509Extensions.TargetInformation.getId())) != null) {
            try {
                Targets[] targetsObjects = TargetInformation.getInstance(new ASN1InputStream(((DEROctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()).readObject()).getTargetsObjects();
                if (!this.f.isEmpty()) {
                    boolean z = false;
                    for (Targets targets : targetsObjects) {
                        Target[] targets2 = targets.getTargets();
                        int i = 0;
                        while (true) {
                            if (i >= targets2.length) {
                                break;
                            } else if (this.f.contains(GeneralName.getInstance(targets2[i].getTargetName()))) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
                if (!this.g.isEmpty()) {
                    boolean z2 = false;
                    for (Targets targets3 : targetsObjects) {
                        Target[] targets4 = targets3.getTargets();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= targets4.length) {
                                break;
                            } else if (this.g.contains(GeneralName.getInstance(targets4[i2].getTargetGroup()))) {
                                z2 = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (!z2) {
                        return false;
                    }
                }
            } catch (IOException | IllegalArgumentException unused2) {
            }
        }
        return true;
    }

    public void setAttributeCert(X509AttributeCertificate x509AttributeCertificate) {
        this.e = x509AttributeCertificate;
    }

    public void setAttributeCertificateValid(Date date) {
        if (date != null) {
            this.d = new Date(date.getTime());
        } else {
            this.d = null;
        }
    }

    public void setHolder(AttributeCertificateHolder attributeCertificateHolder) {
        this.a = attributeCertificateHolder;
    }

    public void setIssuer(AttributeCertificateIssuer attributeCertificateIssuer) {
        this.b = attributeCertificateIssuer;
    }

    public void setSerialNumber(BigInteger bigInteger) {
        this.c = bigInteger;
    }

    public void setTargetGroups(Collection collection) throws IOException {
        this.g = a(collection);
    }

    public void setTargetNames(Collection collection) throws IOException {
        this.f = a(collection);
    }

    public void addTargetGroup(byte[] bArr) throws IOException {
        addTargetGroup(GeneralName.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    public void addTargetName(byte[] bArr) throws IOException {
        addTargetName(GeneralName.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }
}
