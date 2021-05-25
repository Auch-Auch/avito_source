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
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
public class RainbowPrivateKey extends ASN1Object {
    public ASN1Integer a;
    public ASN1ObjectIdentifier b;
    public byte[][] c;
    public byte[] d;
    public byte[][] e;
    public byte[] f;
    public byte[] g;
    public Layer[] h;

    public RainbowPrivateKey(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.b = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        }
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
        this.c = new byte[aSN1Sequence2.size()][];
        for (int i2 = 0; i2 < aSN1Sequence2.size(); i2++) {
            this.c[i2] = ((ASN1OctetString) aSN1Sequence2.getObjectAt(i2)).getOctets();
        }
        this.d = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence.getObjectAt(2)).getObjectAt(0)).getOctets();
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
        this.e = new byte[aSN1Sequence3.size()][];
        for (int i3 = 0; i3 < aSN1Sequence3.size(); i3++) {
            this.e[i3] = ((ASN1OctetString) aSN1Sequence3.getObjectAt(i3)).getOctets();
        }
        this.f = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence.getObjectAt(4)).getObjectAt(0)).getOctets();
        this.g = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence.getObjectAt(5)).getObjectAt(0)).getOctets();
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(6);
        byte[][][][] bArr = new byte[aSN1Sequence4.size()][][][];
        byte[][][][] bArr2 = new byte[aSN1Sequence4.size()][][][];
        byte[][][] bArr3 = new byte[aSN1Sequence4.size()][][];
        byte[][] bArr4 = new byte[aSN1Sequence4.size()][];
        int i4 = 0;
        while (i4 < aSN1Sequence4.size()) {
            ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence4.getObjectAt(i4);
            ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.getObjectAt(i);
            bArr[i4] = new byte[aSN1Sequence6.size()][][];
            for (int i5 = 0; i5 < aSN1Sequence6.size(); i5++) {
                ASN1Sequence aSN1Sequence7 = (ASN1Sequence) aSN1Sequence6.getObjectAt(i5);
                bArr[i4][i5] = new byte[aSN1Sequence7.size()][];
                for (int i6 = 0; i6 < aSN1Sequence7.size(); i6++) {
                    bArr[i4][i5][i6] = ((ASN1OctetString) aSN1Sequence7.getObjectAt(i6)).getOctets();
                }
            }
            ASN1Sequence aSN1Sequence8 = (ASN1Sequence) aSN1Sequence5.getObjectAt(1);
            bArr2[i4] = new byte[aSN1Sequence8.size()][][];
            for (int i7 = 0; i7 < aSN1Sequence8.size(); i7++) {
                ASN1Sequence aSN1Sequence9 = (ASN1Sequence) aSN1Sequence8.getObjectAt(i7);
                bArr2[i4][i7] = new byte[aSN1Sequence9.size()][];
                for (int i8 = 0; i8 < aSN1Sequence9.size(); i8++) {
                    bArr2[i4][i7][i8] = ((ASN1OctetString) aSN1Sequence9.getObjectAt(i8)).getOctets();
                }
            }
            ASN1Sequence aSN1Sequence10 = (ASN1Sequence) aSN1Sequence5.getObjectAt(2);
            bArr3[i4] = new byte[aSN1Sequence10.size()][];
            for (int i9 = 0; i9 < aSN1Sequence10.size(); i9++) {
                bArr3[i4][i9] = ((ASN1OctetString) aSN1Sequence10.getObjectAt(i9)).getOctets();
            }
            bArr4[i4] = ((ASN1OctetString) aSN1Sequence5.getObjectAt(3)).getOctets();
            i4++;
            i = 0;
        }
        int length = this.g.length - 1;
        this.h = new Layer[length];
        int i10 = 0;
        while (i10 < length) {
            byte[] bArr5 = this.g;
            int i11 = i10 + 1;
            this.h[i10] = new Layer(bArr5[i10], bArr5[i11], RainbowUtil.convertArray(bArr[i10]), RainbowUtil.convertArray(bArr2[i10]), RainbowUtil.convertArray(bArr3[i10]), RainbowUtil.convertArray(bArr4[i10]));
            i10 = i11;
        }
    }

    public static RainbowPrivateKey getInstance(Object obj) {
        if (obj instanceof RainbowPrivateKey) {
            return (RainbowPrivateKey) obj;
        }
        if (obj != null) {
            return new RainbowPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public short[] getB1() {
        return RainbowUtil.convertArray(this.d);
    }

    public short[] getB2() {
        return RainbowUtil.convertArray(this.f);
    }

    public short[][] getInvA1() {
        return RainbowUtil.convertArray(this.c);
    }

    public short[][] getInvA2() {
        return RainbowUtil.convertArray(this.e);
    }

    public Layer[] getLayers() {
        return this.h;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    public int[] getVi() {
        return RainbowUtil.convertArraytoInt(this.g);
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
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            byte[][] bArr = this.c;
            if (i >= bArr.length) {
                break;
            }
            aSN1EncodableVector2.add(new DEROctetString(bArr[i]));
            i++;
        }
        ASN1EncodableVector x0 = a.x0(aSN1EncodableVector2, aSN1EncodableVector);
        x0.add(new DEROctetString(this.d));
        aSN1EncodableVector.add(new DERSequence(x0));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        int i2 = 0;
        while (true) {
            byte[][] bArr2 = this.e;
            if (i2 >= bArr2.length) {
                break;
            }
            aSN1EncodableVector3.add(new DEROctetString(bArr2[i2]));
            i2++;
        }
        ASN1EncodableVector x02 = a.x0(aSN1EncodableVector3, aSN1EncodableVector);
        x02.add(new DEROctetString(this.f));
        aSN1EncodableVector.add(new DERSequence(x02));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        aSN1EncodableVector4.add(new DEROctetString(this.g));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
        for (int i3 = 0; i3 < this.h.length; i3++) {
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            byte[][][] convertArray = RainbowUtil.convertArray(this.h[i3].getCoeffAlpha());
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            for (int i4 = 0; i4 < convertArray.length; i4++) {
                ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                for (int i5 = 0; i5 < convertArray[i4].length; i5++) {
                    aSN1EncodableVector8.add(new DEROctetString(convertArray[i4][i5]));
                }
                aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector8));
            }
            aSN1EncodableVector6.add(new DERSequence(aSN1EncodableVector7));
            byte[][][] convertArray2 = RainbowUtil.convertArray(this.h[i3].getCoeffBeta());
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            for (int i6 = 0; i6 < convertArray2.length; i6++) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                for (int i7 = 0; i7 < convertArray2[i6].length; i7++) {
                    aSN1EncodableVector10.add(new DEROctetString(convertArray2[i6][i7]));
                }
                aSN1EncodableVector9.add(new DERSequence(aSN1EncodableVector10));
            }
            aSN1EncodableVector6.add(new DERSequence(aSN1EncodableVector9));
            byte[][] convertArray3 = RainbowUtil.convertArray(this.h[i3].getCoeffGamma());
            ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
            for (byte[] bArr3 : convertArray3) {
                aSN1EncodableVector11.add(new DEROctetString(bArr3));
            }
            aSN1EncodableVector6.add(new DERSequence(aSN1EncodableVector11));
            aSN1EncodableVector6.add(new DEROctetString(RainbowUtil.convertArray(this.h[i3].getCoeffEta())));
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector6));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector5));
        return new DERSequence(aSN1EncodableVector);
    }

    public RainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.a = new ASN1Integer(1);
        this.c = RainbowUtil.convertArray(sArr);
        this.d = RainbowUtil.convertArray(sArr2);
        this.e = RainbowUtil.convertArray(sArr3);
        this.f = RainbowUtil.convertArray(sArr4);
        this.g = RainbowUtil.convertIntArray(iArr);
        this.h = layerArr;
    }
}
