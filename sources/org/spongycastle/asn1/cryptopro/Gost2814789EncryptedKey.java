package org.spongycastle.asn1.cryptopro;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;
public class Gost2814789EncryptedKey extends ASN1Object {
    public final byte[] a;
    public final byte[] b;
    public final byte[] c;

    public Gost2814789EncryptedKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = a.x1(aSN1Sequence, 0);
            this.c = a.x1(aSN1Sequence, 1);
            this.b = null;
        } else if (aSN1Sequence.size() == 3) {
            this.a = a.x1(aSN1Sequence, 0);
            this.b = Arrays.clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)), false).getOctets());
            this.c = a.x1(aSN1Sequence, 2);
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("unknown sequence length: ")));
        }
    }

    public static Gost2814789EncryptedKey getInstance(Object obj) {
        if (obj instanceof Gost2814789EncryptedKey) {
            return (Gost2814789EncryptedKey) obj;
        }
        if (obj != null) {
            return new Gost2814789EncryptedKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getEncryptedKey() {
        return this.a;
    }

    public byte[] getMacKey() {
        return this.c;
    }

    public byte[] getMaskKey() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DEROctetString(this.a));
        if (this.b != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, new DEROctetString(this.a)));
        }
        aSN1EncodableVector.add(new DEROctetString(this.c));
        return new DERSequence(aSN1EncodableVector);
    }

    public Gost2814789EncryptedKey(byte[] bArr, byte[] bArr2) {
        this(bArr, null, bArr2);
    }

    public Gost2814789EncryptedKey(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = Arrays.clone(bArr);
        this.b = Arrays.clone(bArr2);
        this.c = Arrays.clone(bArr3);
    }
}
