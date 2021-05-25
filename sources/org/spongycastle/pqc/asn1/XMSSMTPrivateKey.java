package org.spongycastle.pqc.asn1;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;
public class XMSSMTPrivateKey extends ASN1Object {
    public final int a;
    public final byte[] b;
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;
    public final byte[] f;

    public XMSSMTPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.a = i;
        this.b = Arrays.clone(bArr);
        this.c = Arrays.clone(bArr2);
        this.d = Arrays.clone(bArr3);
        this.e = Arrays.clone(bArr4);
        this.f = Arrays.clone(bArr5);
    }

    public static XMSSMTPrivateKey getInstance(Object obj) {
        if (obj instanceof XMSSMTPrivateKey) {
            return (XMSSMTPrivateKey) obj;
        }
        if (obj != null) {
            return new XMSSMTPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getBdsState() {
        return Arrays.clone(this.f);
    }

    public int getIndex() {
        return this.a;
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.d);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.e);
    }

    public byte[] getSecretKeyPRF() {
        return Arrays.clone(this.c);
    }

    public byte[] getSecretKeySeed() {
        return Arrays.clone(this.b);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(0));
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new ASN1Integer((long) this.a));
        aSN1EncodableVector2.add(new DEROctetString(this.b));
        aSN1EncodableVector2.add(new DEROctetString(this.c));
        aSN1EncodableVector2.add(new DEROctetString(this.d));
        aSN1EncodableVector2.add(new DEROctetString(this.e));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.add(new DERTaggedObject(true, 0, new DEROctetString(this.f)));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSMTPrivateKey(ASN1Sequence aSN1Sequence) {
        if (!ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue().equals(BigInteger.valueOf(0))) {
            throw new IllegalArgumentException("unknown version of sequence");
        } else if (aSN1Sequence.size() == 2 || aSN1Sequence.size() == 3) {
            ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.a = ASN1Integer.getInstance(instance.getObjectAt(0)).getValue().intValue();
            this.b = a.x1(instance, 1);
            this.c = a.x1(instance, 2);
            this.d = a.x1(instance, 3);
            this.e = a.x1(instance, 4);
            if (aSN1Sequence.size() == 3) {
                this.f = Arrays.clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)), true).getOctets());
            } else {
                this.f = null;
            }
        } else {
            throw new IllegalArgumentException("key sequence wrong size");
        }
    }
}
