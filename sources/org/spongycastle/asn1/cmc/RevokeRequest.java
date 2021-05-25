package org.spongycastle.asn1.cmc;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CRLReason;
import org.spongycastle.util.Arrays;
public class RevokeRequest extends ASN1Object {
    public final X500Name a;
    public final ASN1Integer b;
    public final CRLReason c;
    public ASN1GeneralizedTime d;
    public ASN1OctetString e;
    public DERUTF8String f;

    public RevokeRequest(X500Name x500Name, ASN1Integer aSN1Integer, CRLReason cRLReason, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1OctetString aSN1OctetString, DERUTF8String dERUTF8String) {
        this.a = x500Name;
        this.b = aSN1Integer;
        this.c = cRLReason;
        this.d = aSN1GeneralizedTime;
        this.e = aSN1OctetString;
        this.f = dERUTF8String;
    }

    public static RevokeRequest getInstance(Object obj) {
        if (obj instanceof RevokeRequest) {
            return (RevokeRequest) obj;
        }
        if (obj != null) {
            return new RevokeRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTF8String getComment() {
        return this.f;
    }

    public ASN1GeneralizedTime getInvalidityDate() {
        return this.d;
    }

    public X500Name getName() {
        return this.a;
    }

    public byte[] getPassPhrase() {
        ASN1OctetString aSN1OctetString = this.e;
        if (aSN1OctetString != null) {
            return Arrays.clone(aSN1OctetString.getOctets());
        }
        return null;
    }

    public ASN1OctetString getPassphrase() {
        return this.e;
    }

    public CRLReason getReason() {
        return this.c;
    }

    public BigInteger getSerialNumber() {
        return this.b.getValue();
    }

    public void setComment(DERUTF8String dERUTF8String) {
        this.f = dERUTF8String;
    }

    public void setInvalidityDate(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.d = aSN1GeneralizedTime;
    }

    public void setPassphrase(ASN1OctetString aSN1OctetString) {
        this.e = aSN1OctetString;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        ASN1GeneralizedTime aSN1GeneralizedTime = this.d;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.add(aSN1GeneralizedTime);
        }
        ASN1OctetString aSN1OctetString = this.e;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        DERUTF8String dERUTF8String = this.f;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RevokeRequest(ASN1Sequence aSN1Sequence) {
        int i = 3;
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 6) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.a = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = CRLReason.getInstance(aSN1Sequence.getObjectAt(2));
        if (aSN1Sequence.size() > 3 && (aSN1Sequence.getObjectAt(3).toASN1Primitive() instanceof ASN1GeneralizedTime)) {
            this.d = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
            i = 4;
        }
        if (aSN1Sequence.size() > i && (aSN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1OctetString)) {
            this.e = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (aSN1Sequence.size() > i && (aSN1Sequence.getObjectAt(i).toASN1Primitive() instanceof DERUTF8String)) {
            this.f = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }
}
