package org.spongycastle.pqc.asn1;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
public class ParSet extends ASN1Object {
    public static final BigInteger e = BigInteger.valueOf(0);
    public int a;
    public int[] b;
    public int[] c;
    public int[] d;

    public ParSet(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 4) {
            this.a = a(((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue());
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
            if (aSN1Sequence2.size() == this.a && aSN1Sequence3.size() == this.a && aSN1Sequence4.size() == this.a) {
                this.b = new int[aSN1Sequence2.size()];
                this.c = new int[aSN1Sequence3.size()];
                this.d = new int[aSN1Sequence4.size()];
                for (int i = 0; i < this.a; i++) {
                    this.b[i] = a(((ASN1Integer) aSN1Sequence2.getObjectAt(i)).getValue());
                    this.c[i] = a(((ASN1Integer) aSN1Sequence3.getObjectAt(i)).getValue());
                    this.d[i] = a(((ASN1Integer) aSN1Sequence4.getObjectAt(i)).getValue());
                }
                return;
            }
            throw new IllegalArgumentException("invalid size of sequences");
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("sie of seqOfParams = ")));
    }

    public static int a(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.valueOf(2147483647L)) <= 0 && bigInteger.compareTo(e) > 0) {
            return bigInteger.intValue();
        }
        StringBuilder L = a.L("BigInteger not in Range: ");
        L.append(bigInteger.toString());
        throw new IllegalArgumentException(L.toString());
    }

    public static ParSet getInstance(Object obj) {
        if (obj instanceof ParSet) {
            return (ParSet) obj;
        }
        if (obj != null) {
            return new ParSet(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int[] getH() {
        return Arrays.clone(this.b);
    }

    public int[] getK() {
        return Arrays.clone(this.d);
    }

    public int getT() {
        return this.a;
    }

    public int[] getW() {
        return Arrays.clone(this.c);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                aSN1EncodableVector.add(new ASN1Integer((long) iArr[i]));
                aSN1EncodableVector2.add(new ASN1Integer((long) this.c[i]));
                aSN1EncodableVector3.add(new ASN1Integer((long) this.d[i]));
                i++;
            } else {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.add(new ASN1Integer((long) this.a));
                aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector));
                aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector2));
                aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector3));
                return new DERSequence(aSN1EncodableVector4);
            }
        }
    }

    public ParSet(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.a = i;
        this.b = iArr;
        this.c = iArr2;
        this.d = iArr3;
    }
}
