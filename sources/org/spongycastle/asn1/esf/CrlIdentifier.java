package org.spongycastle.asn1.esf;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
public class CrlIdentifier extends ASN1Object {
    public X500Name a;
    public ASN1UTCTime b;
    public ASN1Integer c;

    public CrlIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
            throw new IllegalArgumentException();
        }
        this.a = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1UTCTime.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.c = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static CrlIdentifier getInstance(Object obj) {
        if (obj instanceof CrlIdentifier) {
            return (CrlIdentifier) obj;
        }
        if (obj != null) {
            return new CrlIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1UTCTime getCrlIssuedTime() {
        return this.b;
    }

    public X500Name getCrlIssuer() {
        return this.a;
    }

    public BigInteger getCrlNumber() {
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a.toASN1Primitive());
        aSN1EncodableVector.add(this.b);
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CrlIdentifier(X500Name x500Name, ASN1UTCTime aSN1UTCTime) {
        this(x500Name, aSN1UTCTime, null);
    }

    public CrlIdentifier(X500Name x500Name, ASN1UTCTime aSN1UTCTime, BigInteger bigInteger) {
        this.a = x500Name;
        this.b = aSN1UTCTime;
        if (bigInteger != null) {
            this.c = new ASN1Integer(bigInteger);
        }
    }
}
