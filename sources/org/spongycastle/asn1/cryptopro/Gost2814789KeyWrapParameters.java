package org.spongycastle.asn1.cryptopro;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
public class Gost2814789KeyWrapParameters extends ASN1Object {
    public final ASN1ObjectIdentifier a;
    public final byte[] b;

    public Gost2814789KeyWrapParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
        } else if (aSN1Sequence.size() == 1) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = null;
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("unknown sequence length: ")));
        }
    }

    public static Gost2814789KeyWrapParameters getInstance(Object obj) {
        if (obj instanceof Gost2814789KeyWrapParameters) {
            return (Gost2814789KeyWrapParameters) obj;
        }
        if (obj != null) {
            return new Gost2814789KeyWrapParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.a;
    }

    public byte[] getUkm() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        byte[] bArr = this.b;
        if (bArr != null) {
            aSN1EncodableVector.add(new DEROctetString(bArr));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public Gost2814789KeyWrapParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, null);
    }

    public Gost2814789KeyWrapParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.a = aSN1ObjectIdentifier;
        this.b = Arrays.clone(bArr);
    }
}
