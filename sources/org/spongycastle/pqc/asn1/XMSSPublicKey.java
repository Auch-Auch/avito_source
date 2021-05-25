package org.spongycastle.pqc.asn1;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
public class XMSSPublicKey extends ASN1Object {
    public final byte[] a;
    public final byte[] b;

    public XMSSPublicKey(byte[] bArr, byte[] bArr2) {
        this.a = Arrays.clone(bArr);
        this.b = Arrays.clone(bArr2);
    }

    public static XMSSPublicKey getInstance(Object obj) {
        if (obj instanceof XMSSPublicKey) {
            return (XMSSPublicKey) obj;
        }
        if (obj != null) {
            return new XMSSPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.a);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.b);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(0));
        aSN1EncodableVector.add(new DEROctetString(this.a));
        aSN1EncodableVector.add(new DEROctetString(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSPublicKey(ASN1Sequence aSN1Sequence) {
        if (ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue().equals(BigInteger.valueOf(0))) {
            this.a = a.x1(aSN1Sequence, 1);
            this.b = a.x1(aSN1Sequence, 2);
            return;
        }
        throw new IllegalArgumentException("unknown version of sequence");
    }
}
