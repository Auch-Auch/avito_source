package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
public class CertTemplate extends ASN1Object {
    public ASN1Sequence a;
    public ASN1Integer b;
    public ASN1Integer c;
    public AlgorithmIdentifier d;
    public X500Name e;
    public OptionalValidity f;
    public X500Name g;
    public SubjectPublicKeyInfo h;
    public DERBitString i;
    public DERBitString j;
    public Extensions k;

    public CertTemplate(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            switch (aSN1TaggedObject.getTagNo()) {
                case 0:
                    this.b = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    break;
                case 1:
                    this.c = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    break;
                case 2:
                    this.d = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
                    break;
                case 3:
                    this.e = X500Name.getInstance(aSN1TaggedObject, true);
                    break;
                case 4:
                    this.f = OptionalValidity.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, false));
                    break;
                case 5:
                    this.g = X500Name.getInstance(aSN1TaggedObject, true);
                    break;
                case 6:
                    this.h = SubjectPublicKeyInfo.getInstance(aSN1TaggedObject, false);
                    break;
                case 7:
                    this.i = DERBitString.getInstance(aSN1TaggedObject, false);
                    break;
                case 8:
                    this.j = DERBitString.getInstance(aSN1TaggedObject, false);
                    break;
                case 9:
                    this.k = Extensions.getInstance(aSN1TaggedObject, false);
                    break;
                default:
                    throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("unknown tag: ")));
            }
        }
    }

    public static CertTemplate getInstance(Object obj) {
        if (obj instanceof CertTemplate) {
            return (CertTemplate) obj;
        }
        if (obj != null) {
            return new CertTemplate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Extensions getExtensions() {
        return this.k;
    }

    public X500Name getIssuer() {
        return this.e;
    }

    public DERBitString getIssuerUID() {
        return this.i;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.h;
    }

    public ASN1Integer getSerialNumber() {
        return this.c;
    }

    public AlgorithmIdentifier getSigningAlg() {
        return this.d;
    }

    public X500Name getSubject() {
        return this.g;
    }

    public DERBitString getSubjectUID() {
        return this.j;
    }

    public OptionalValidity getValidity() {
        return this.f;
    }

    public int getVersion() {
        return this.b.getValue().intValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }
}
