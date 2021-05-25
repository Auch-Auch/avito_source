package org.spongycastle.pqc.asn1;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
public class RainbowPublicKey extends ASN1Object {
    public ASN1Integer a;
    public ASN1ObjectIdentifier b;
    public ASN1Integer c;
    public byte[][] d;
    public byte[][] e;
    public byte[] f;

    public RainbowPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.b = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        }
        this.c = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2));
        this.d = new byte[instance.size()][];
        for (int i = 0; i < instance.size(); i++) {
            this.d[i] = ASN1OctetString.getInstance(instance.getObjectAt(i)).getOctets();
        }
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
        this.e = new byte[aSN1Sequence2.size()][];
        for (int i2 = 0; i2 < aSN1Sequence2.size(); i2++) {
            this.e[i2] = ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(i2)).getOctets();
        }
        this.f = ASN1OctetString.getInstance(((ASN1Sequence) aSN1Sequence.getObjectAt(4)).getObjectAt(0)).getOctets();
    }

    public static RainbowPublicKey getInstance(Object obj) {
        if (obj instanceof RainbowPublicKey) {
            return (RainbowPublicKey) obj;
        }
        if (obj != null) {
            return new RainbowPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public short[][] getCoeffQuadratic() {
        return RainbowUtil.convertArray(this.d);
    }

    public short[] getCoeffScalar() {
        return RainbowUtil.convertArray(this.f);
    }

    public short[][] getCoeffSingular() {
        return RainbowUtil.convertArray(this.e);
    }

    public int getDocLength() {
        return this.c.getValue().intValue();
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        } else {
            aSN1EncodableVector.add(this.b);
        }
        aSN1EncodableVector.add(this.c);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.d;
            if (i2 >= bArr.length) {
                break;
            }
            aSN1EncodableVector2.add(new DEROctetString(bArr[i2]));
            i2++;
        }
        ASN1EncodableVector x0 = a.x0(aSN1EncodableVector2, aSN1EncodableVector);
        while (true) {
            byte[][] bArr2 = this.e;
            if (i < bArr2.length) {
                x0.add(new DEROctetString(bArr2[i]));
                i++;
            } else {
                ASN1EncodableVector x02 = a.x0(x0, aSN1EncodableVector);
                x02.add(new DEROctetString(this.f));
                aSN1EncodableVector.add(new DERSequence(x02));
                return new DERSequence(aSN1EncodableVector);
            }
        }
    }

    public RainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.a = new ASN1Integer(0);
        this.c = new ASN1Integer((long) i);
        this.d = RainbowUtil.convertArray(sArr);
        this.e = RainbowUtil.convertArray(sArr2);
        this.f = RainbowUtil.convertArray(sArr3);
    }
}
