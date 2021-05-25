package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
public class Extension extends ASN1Object {
    public static final ASN1ObjectIdentifier auditIdentity = a.y0("1.3.6.1.5.5.7.1.4");
    public static final ASN1ObjectIdentifier authorityInfoAccess = a.y0("1.3.6.1.5.5.7.1.1");
    public static final ASN1ObjectIdentifier authorityKeyIdentifier = a.y0("2.5.29.35");
    public static final ASN1ObjectIdentifier basicConstraints = a.y0("2.5.29.19");
    public static final ASN1ObjectIdentifier biometricInfo = a.y0("1.3.6.1.5.5.7.1.2");
    public static final ASN1ObjectIdentifier cRLDistributionPoints = a.y0("2.5.29.31");
    public static final ASN1ObjectIdentifier cRLNumber = a.y0("2.5.29.20");
    public static final ASN1ObjectIdentifier certificateIssuer = a.y0("2.5.29.29");
    public static final ASN1ObjectIdentifier certificatePolicies = a.y0("2.5.29.32");
    public static final ASN1ObjectIdentifier deltaCRLIndicator = a.y0("2.5.29.27");
    public static final ASN1ObjectIdentifier expiredCertsOnCRL = a.y0("2.5.29.60");
    public static final ASN1ObjectIdentifier extendedKeyUsage = a.y0("2.5.29.37");
    public static final ASN1ObjectIdentifier freshestCRL = a.y0("2.5.29.46");
    public static final ASN1ObjectIdentifier inhibitAnyPolicy = a.y0("2.5.29.54");
    public static final ASN1ObjectIdentifier instructionCode = a.y0("2.5.29.23");
    public static final ASN1ObjectIdentifier invalidityDate = a.y0("2.5.29.24");
    public static final ASN1ObjectIdentifier issuerAlternativeName = a.y0("2.5.29.18");
    public static final ASN1ObjectIdentifier issuingDistributionPoint = a.y0("2.5.29.28");
    public static final ASN1ObjectIdentifier keyUsage = a.y0("2.5.29.15");
    public static final ASN1ObjectIdentifier logoType = a.y0("1.3.6.1.5.5.7.1.12");
    public static final ASN1ObjectIdentifier nameConstraints = a.y0("2.5.29.30");
    public static final ASN1ObjectIdentifier noRevAvail = a.y0("2.5.29.56");
    public static final ASN1ObjectIdentifier policyConstraints = a.y0("2.5.29.36");
    public static final ASN1ObjectIdentifier policyMappings = a.y0("2.5.29.33");
    public static final ASN1ObjectIdentifier privateKeyUsagePeriod = a.y0("2.5.29.16");
    public static final ASN1ObjectIdentifier qCStatements = a.y0("1.3.6.1.5.5.7.1.3");
    public static final ASN1ObjectIdentifier reasonCode = a.y0("2.5.29.21");
    public static final ASN1ObjectIdentifier subjectAlternativeName = a.y0("2.5.29.17");
    public static final ASN1ObjectIdentifier subjectDirectoryAttributes = a.y0("2.5.29.9");
    public static final ASN1ObjectIdentifier subjectInfoAccess = a.y0("1.3.6.1.5.5.7.1.11");
    public static final ASN1ObjectIdentifier subjectKeyIdentifier = a.y0("2.5.29.14");
    public static final ASN1ObjectIdentifier targetInformation = a.y0("2.5.29.55");
    public ASN1ObjectIdentifier a;
    public boolean b;
    public ASN1OctetString c;

    public Extension(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Boolean aSN1Boolean, ASN1OctetString aSN1OctetString) {
        this(aSN1ObjectIdentifier, aSN1Boolean.isTrue(), aSN1OctetString);
    }

    public static Extension getInstance(Object obj) {
        if (obj instanceof Extension) {
            return (Extension) obj;
        }
        if (obj != null) {
            return new Extension(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        if (!extension.getExtnId().equals(getExtnId()) || !extension.getExtnValue().equals(getExtnValue()) || extension.isCritical() != isCritical()) {
            return false;
        }
        return true;
    }

    public ASN1ObjectIdentifier getExtnId() {
        return this.a;
    }

    public ASN1OctetString getExtnValue() {
        return this.c;
    }

    public ASN1Encodable getParsedValue() {
        try {
            return ASN1Primitive.fromByteArray(getExtnValue().getOctets());
        } catch (IOException e) {
            throw new IllegalArgumentException(a.Z2("can't convert extension: ", e));
        }
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (isCritical()) {
            return getExtnValue().hashCode() ^ getExtnId().hashCode();
        }
        return ~(getExtnValue().hashCode() ^ getExtnId().hashCode());
    }

    public boolean isCritical() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        if (this.b) {
            aSN1EncodableVector.add(ASN1Boolean.getInstance(true));
        }
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public Extension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this(aSN1ObjectIdentifier, z, new DEROctetString(bArr));
    }

    public Extension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1OctetString aSN1OctetString) {
        this.a = aSN1ObjectIdentifier;
        this.b = z;
        this.c = aSN1OctetString;
    }

    public Extension(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = false;
            this.c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        } else if (aSN1Sequence.size() == 3) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(1)).isTrue();
            this.c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2));
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
    }
}
