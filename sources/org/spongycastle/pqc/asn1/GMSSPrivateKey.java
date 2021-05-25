package org.spongycastle.pqc.asn1;

import a2.b.a.a.a;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.crypto.gmss.GMSSLeaf;
import org.spongycastle.pqc.crypto.gmss.GMSSParameters;
import org.spongycastle.pqc.crypto.gmss.GMSSRootCalc;
import org.spongycastle.pqc.crypto.gmss.GMSSRootSig;
import org.spongycastle.pqc.crypto.gmss.Treehash;
public class GMSSPrivateKey extends ASN1Object {
    public ASN1Primitive a;

    public GMSSPrivateKey(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][][] bArr5, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, AlgorithmIdentifier algorithmIdentifier) {
        AlgorithmIdentifier[] algorithmIdentifierArr = {algorithmIdentifier};
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (int i : iArr) {
            aSN1EncodableVector2.add(new ASN1Integer((long) i));
        }
        ASN1EncodableVector x0 = a.x0(aSN1EncodableVector2, aSN1EncodableVector);
        for (byte[] bArr8 : bArr) {
            x0.add(new DEROctetString(bArr8));
        }
        ASN1EncodableVector x02 = a.x0(x0, aSN1EncodableVector);
        for (byte[] bArr9 : bArr2) {
            x02.add(new DEROctetString(bArr9));
        }
        ASN1EncodableVector x03 = a.x0(x02, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        for (int i2 = 0; i2 < bArr3.length; i2++) {
            for (int i3 = 0; i3 < bArr3[i2].length; i3++) {
                x03.add(new DEROctetString(bArr3[i2][i3]));
            }
            x03 = a.x0(x03, aSN1EncodableVector3);
        }
        ASN1EncodableVector x04 = a.x0(aSN1EncodableVector3, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        for (int i4 = 0; i4 < bArr4.length; i4++) {
            for (int i5 = 0; i5 < bArr4[i4].length; i5++) {
                x04.add(new DEROctetString(bArr4[i4][i5]));
            }
            x04 = a.x0(x04, aSN1EncodableVector4);
        }
        ASN1EncodableVector x05 = a.x0(aSN1EncodableVector4, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
        for (int i6 = 0; i6 < treehashArr.length; i6++) {
            for (int i7 = 0; i7 < treehashArr[i6].length; i7++) {
                aSN1EncodableVector6.add(new DERSequence(algorithmIdentifierArr[0]));
                int i8 = treehashArr[i6][i7].getStatInt()[1];
                aSN1EncodableVector7.add(new DEROctetString(treehashArr[i6][i7].getStatByte()[0]));
                aSN1EncodableVector7.add(new DEROctetString(treehashArr[i6][i7].getStatByte()[1]));
                aSN1EncodableVector7.add(new DEROctetString(treehashArr[i6][i7].getStatByte()[2]));
                for (int i9 = 0; i9 < i8; i9++) {
                    aSN1EncodableVector7.add(new DEROctetString(treehashArr[i6][i7].getStatByte()[i9 + 3]));
                }
                aSN1EncodableVector7 = a.x0(aSN1EncodableVector7, aSN1EncodableVector6);
                aSN1EncodableVector8.add(new ASN1Integer((long) treehashArr[i6][i7].getStatInt()[0]));
                aSN1EncodableVector8.add(new ASN1Integer((long) i8));
                aSN1EncodableVector8.add(new ASN1Integer((long) treehashArr[i6][i7].getStatInt()[2]));
                aSN1EncodableVector8.add(new ASN1Integer((long) treehashArr[i6][i7].getStatInt()[3]));
                aSN1EncodableVector8.add(new ASN1Integer((long) treehashArr[i6][i7].getStatInt()[4]));
                aSN1EncodableVector8.add(new ASN1Integer((long) treehashArr[i6][i7].getStatInt()[5]));
                int i10 = 0;
                while (i10 < i8) {
                    aSN1EncodableVector8.add(new ASN1Integer((long) treehashArr[i6][i7].getStatInt()[i10 + 6]));
                    i10++;
                    i8 = i8;
                }
                aSN1EncodableVector8 = a.x0(aSN1EncodableVector8, aSN1EncodableVector6);
                aSN1EncodableVector6 = a.x0(aSN1EncodableVector6, aSN1EncodableVector5);
            }
            aSN1EncodableVector5 = a.x0(aSN1EncodableVector5, x05);
        }
        ASN1EncodableVector x06 = a.x0(x05, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
        for (int i11 = 0; i11 < treehashArr2.length; i11++) {
            for (int i12 = 0; i12 < treehashArr2[i11].length; i12++) {
                aSN1EncodableVector10.add(new DERSequence(algorithmIdentifierArr[0]));
                int i13 = treehashArr2[i11][i12].getStatInt()[1];
                aSN1EncodableVector11.add(new DEROctetString(treehashArr2[i11][i12].getStatByte()[0]));
                aSN1EncodableVector11.add(new DEROctetString(treehashArr2[i11][i12].getStatByte()[1]));
                aSN1EncodableVector11.add(new DEROctetString(treehashArr2[i11][i12].getStatByte()[2]));
                for (int i14 = 0; i14 < i13; i14++) {
                    aSN1EncodableVector11.add(new DEROctetString(treehashArr2[i11][i12].getStatByte()[i14 + 3]));
                }
                aSN1EncodableVector11 = a.x0(aSN1EncodableVector11, aSN1EncodableVector10);
                aSN1EncodableVector12.add(new ASN1Integer((long) treehashArr2[i11][i12].getStatInt()[0]));
                aSN1EncodableVector12.add(new ASN1Integer((long) i13));
                aSN1EncodableVector12.add(new ASN1Integer((long) treehashArr2[i11][i12].getStatInt()[2]));
                aSN1EncodableVector12.add(new ASN1Integer((long) treehashArr2[i11][i12].getStatInt()[3]));
                aSN1EncodableVector12.add(new ASN1Integer((long) treehashArr2[i11][i12].getStatInt()[4]));
                aSN1EncodableVector12.add(new ASN1Integer((long) treehashArr2[i11][i12].getStatInt()[5]));
                for (int i15 = 0; i15 < i13; i15++) {
                    aSN1EncodableVector12.add(new ASN1Integer((long) treehashArr2[i11][i12].getStatInt()[i15 + 6]));
                }
                aSN1EncodableVector12 = a.x0(aSN1EncodableVector12, aSN1EncodableVector10);
                aSN1EncodableVector10 = a.x0(aSN1EncodableVector10, aSN1EncodableVector9);
            }
            x06.add(new DERSequence(new DERSequence(aSN1EncodableVector9)));
            aSN1EncodableVector9 = new ASN1EncodableVector();
        }
        ASN1EncodableVector x07 = a.x0(x06, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
        for (int i16 = 0; i16 < bArr5.length; i16++) {
            for (int i17 = 0; i17 < bArr5[i16].length; i17++) {
                x07.add(new DEROctetString(bArr5[i16][i17]));
            }
            x07 = a.x0(x07, aSN1EncodableVector13);
        }
        ASN1EncodableVector x08 = a.x0(aSN1EncodableVector13, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
        for (int i18 = 0; i18 < vectorArr.length; i18++) {
            for (int i19 = 0; i19 < vectorArr[i18].size(); i19++) {
                x08.add(new DEROctetString((byte[]) vectorArr[i18].elementAt(i19)));
            }
            x08 = a.x0(x08, aSN1EncodableVector14);
        }
        ASN1EncodableVector x09 = a.x0(aSN1EncodableVector14, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
        for (int i20 = 0; i20 < vectorArr2.length; i20++) {
            for (int i21 = 0; i21 < vectorArr2[i20].size(); i21++) {
                x09.add(new DEROctetString((byte[]) vectorArr2[i20].elementAt(i21)));
            }
            x09 = a.x0(x09, aSN1EncodableVector15);
        }
        ASN1EncodableVector x010 = a.x0(aSN1EncodableVector15, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector16 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector17 = new ASN1EncodableVector();
        for (int i22 = 0; i22 < vectorArr3.length; i22++) {
            for (int i23 = 0; i23 < vectorArr3[i22].length; i23++) {
                for (int i24 = 0; i24 < vectorArr3[i22][i23].size(); i24++) {
                    x010.add(new DEROctetString((byte[]) vectorArr3[i22][i23].elementAt(i24)));
                }
                x010 = a.x0(x010, aSN1EncodableVector16);
            }
            aSN1EncodableVector16 = a.x0(aSN1EncodableVector16, aSN1EncodableVector17);
        }
        ASN1EncodableVector x011 = a.x0(aSN1EncodableVector17, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector18 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector19 = new ASN1EncodableVector();
        for (int i25 = 0; i25 < vectorArr4.length; i25++) {
            for (int i26 = 0; i26 < vectorArr4[i25].length; i26++) {
                for (int i27 = 0; i27 < vectorArr4[i25][i26].size(); i27++) {
                    x011.add(new DEROctetString((byte[]) vectorArr4[i25][i26].elementAt(i27)));
                }
                x011 = a.x0(x011, aSN1EncodableVector18);
            }
            aSN1EncodableVector18 = a.x0(aSN1EncodableVector18, aSN1EncodableVector19);
        }
        ASN1EncodableVector x012 = a.x0(aSN1EncodableVector19, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector20 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector21 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector22 = new ASN1EncodableVector();
        for (int i28 = 0; i28 < gMSSLeafArr.length; i28++) {
            aSN1EncodableVector20.add(new DERSequence(algorithmIdentifierArr[0]));
            byte[][] statByte = gMSSLeafArr[i28].getStatByte();
            aSN1EncodableVector21.add(new DEROctetString(statByte[0]));
            aSN1EncodableVector21.add(new DEROctetString(statByte[1]));
            aSN1EncodableVector21.add(new DEROctetString(statByte[2]));
            aSN1EncodableVector21.add(new DEROctetString(statByte[3]));
            aSN1EncodableVector20.add(new DERSequence(aSN1EncodableVector21));
            aSN1EncodableVector21 = new ASN1EncodableVector();
            int[] statInt = gMSSLeafArr[i28].getStatInt();
            aSN1EncodableVector22.add(new ASN1Integer((long) statInt[0]));
            aSN1EncodableVector22.add(new ASN1Integer((long) statInt[1]));
            aSN1EncodableVector22.add(new ASN1Integer((long) statInt[2]));
            aSN1EncodableVector22.add(new ASN1Integer((long) statInt[3]));
            aSN1EncodableVector20.add(new DERSequence(aSN1EncodableVector22));
            aSN1EncodableVector22 = new ASN1EncodableVector();
            aSN1EncodableVector20 = a.x0(aSN1EncodableVector20, x012);
        }
        ASN1EncodableVector x013 = a.x0(x012, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector23 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector24 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector25 = new ASN1EncodableVector();
        for (int i29 = 0; i29 < gMSSLeafArr2.length; i29++) {
            aSN1EncodableVector23.add(new DERSequence(algorithmIdentifierArr[0]));
            byte[][] statByte2 = gMSSLeafArr2[i29].getStatByte();
            aSN1EncodableVector24.add(new DEROctetString(statByte2[0]));
            aSN1EncodableVector24.add(new DEROctetString(statByte2[1]));
            aSN1EncodableVector24.add(new DEROctetString(statByte2[2]));
            aSN1EncodableVector24.add(new DEROctetString(statByte2[3]));
            aSN1EncodableVector23.add(new DERSequence(aSN1EncodableVector24));
            aSN1EncodableVector24 = new ASN1EncodableVector();
            int[] statInt2 = gMSSLeafArr2[i29].getStatInt();
            aSN1EncodableVector25.add(new ASN1Integer((long) statInt2[0]));
            aSN1EncodableVector25.add(new ASN1Integer((long) statInt2[1]));
            aSN1EncodableVector25.add(new ASN1Integer((long) statInt2[2]));
            aSN1EncodableVector25.add(new ASN1Integer((long) statInt2[3]));
            aSN1EncodableVector23.add(new DERSequence(aSN1EncodableVector25));
            aSN1EncodableVector25 = new ASN1EncodableVector();
            aSN1EncodableVector23 = a.x0(aSN1EncodableVector23, x013);
        }
        ASN1EncodableVector x014 = a.x0(x013, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector26 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector27 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector28 = new ASN1EncodableVector();
        for (int i30 = 0; i30 < gMSSLeafArr3.length; i30++) {
            aSN1EncodableVector26.add(new DERSequence(algorithmIdentifierArr[0]));
            byte[][] statByte3 = gMSSLeafArr3[i30].getStatByte();
            aSN1EncodableVector27.add(new DEROctetString(statByte3[0]));
            aSN1EncodableVector27.add(new DEROctetString(statByte3[1]));
            aSN1EncodableVector27.add(new DEROctetString(statByte3[2]));
            aSN1EncodableVector27.add(new DEROctetString(statByte3[3]));
            aSN1EncodableVector26.add(new DERSequence(aSN1EncodableVector27));
            aSN1EncodableVector27 = new ASN1EncodableVector();
            int[] statInt3 = gMSSLeafArr3[i30].getStatInt();
            aSN1EncodableVector28.add(new ASN1Integer((long) statInt3[0]));
            aSN1EncodableVector28.add(new ASN1Integer((long) statInt3[1]));
            aSN1EncodableVector28.add(new ASN1Integer((long) statInt3[2]));
            aSN1EncodableVector28.add(new ASN1Integer((long) statInt3[3]));
            aSN1EncodableVector26.add(new DERSequence(aSN1EncodableVector28));
            aSN1EncodableVector28 = new ASN1EncodableVector();
            aSN1EncodableVector26 = a.x0(aSN1EncodableVector26, x014);
        }
        ASN1EncodableVector x015 = a.x0(x014, aSN1EncodableVector);
        char c = 1;
        for (int i31 : iArr2) {
            x015.add(new ASN1Integer((long) i31));
        }
        ASN1EncodableVector x016 = a.x0(x015, aSN1EncodableVector);
        for (byte[] bArr10 : bArr6) {
            x016.add(new DEROctetString(bArr10));
        }
        ASN1EncodableVector x017 = a.x0(x016, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector29 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector30 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector31 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector32 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector33 = new ASN1EncodableVector();
        int i32 = 0;
        while (i32 < gMSSRootCalcArr.length) {
            aSN1EncodableVector29.add(new DERSequence(algorithmIdentifierArr[0]));
            new ASN1EncodableVector();
            int i33 = gMSSRootCalcArr[i32].getStatInt()[0];
            int i34 = gMSSRootCalcArr[i32].getStatInt()[7];
            aSN1EncodableVector30.add(new DEROctetString(gMSSRootCalcArr[i32].getStatByte()[0]));
            int i35 = 0;
            while (i35 < i33) {
                i35++;
                aSN1EncodableVector30.add(new DEROctetString(gMSSRootCalcArr[i32].getStatByte()[i35]));
            }
            for (int i36 = 0; i36 < i34; i36++) {
                aSN1EncodableVector30.add(new DEROctetString(gMSSRootCalcArr[i32].getStatByte()[i33 + 1 + i36]));
            }
            ASN1EncodableVector x018 = a.x0(aSN1EncodableVector30, aSN1EncodableVector29);
            aSN1EncodableVector31.add(new ASN1Integer((long) i33));
            aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[c]));
            aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[2]));
            aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[3]));
            aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[4]));
            aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[5]));
            aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[6]));
            aSN1EncodableVector31.add(new ASN1Integer((long) i34));
            int i37 = 0;
            while (i37 < i33) {
                aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[i37 + 8]));
                i37++;
                c = c;
                x018 = x018;
            }
            for (int i38 = 0; i38 < i34; i38++) {
                aSN1EncodableVector31.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getStatInt()[i33 + 8 + i38]));
            }
            ASN1EncodableVector x019 = a.x0(aSN1EncodableVector31, aSN1EncodableVector29);
            ASN1EncodableVector aSN1EncodableVector34 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector35 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector36 = new ASN1EncodableVector();
            if (gMSSRootCalcArr[i32].getTreehash() != null) {
                ASN1EncodableVector aSN1EncodableVector37 = aSN1EncodableVector36;
                int i39 = 0;
                ASN1EncodableVector aSN1EncodableVector38 = aSN1EncodableVector35;
                char c2 = c;
                while (i39 < gMSSRootCalcArr[i32].getTreehash().length) {
                    aSN1EncodableVector34.add(new DERSequence(algorithmIdentifierArr[0]));
                    int i40 = gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[c2];
                    aSN1EncodableVector38.add(new DEROctetString(gMSSRootCalcArr[i32].getTreehash()[i39].getStatByte()[0]));
                    aSN1EncodableVector38.add(new DEROctetString(gMSSRootCalcArr[i32].getTreehash()[i39].getStatByte()[1]));
                    aSN1EncodableVector38.add(new DEROctetString(gMSSRootCalcArr[i32].getTreehash()[i39].getStatByte()[2]));
                    int i41 = 0;
                    while (i41 < i40) {
                        aSN1EncodableVector38.add(new DEROctetString(gMSSRootCalcArr[i32].getTreehash()[i39].getStatByte()[i41 + 3]));
                        i41++;
                        x019 = x019;
                    }
                    aSN1EncodableVector38 = a.x0(aSN1EncodableVector38, aSN1EncodableVector34);
                    aSN1EncodableVector37.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[0]));
                    aSN1EncodableVector37.add(new ASN1Integer((long) i40));
                    aSN1EncodableVector37.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[2]));
                    aSN1EncodableVector37.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[3]));
                    aSN1EncodableVector37.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[4]));
                    aSN1EncodableVector37.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[5]));
                    int i42 = 0;
                    while (i42 < i40) {
                        aSN1EncodableVector37.add(new ASN1Integer((long) gMSSRootCalcArr[i32].getTreehash()[i39].getStatInt()[i42 + 6]));
                        i42++;
                        algorithmIdentifierArr = algorithmIdentifierArr;
                    }
                    aSN1EncodableVector37 = a.x0(aSN1EncodableVector37, aSN1EncodableVector34);
                    aSN1EncodableVector34 = a.x0(aSN1EncodableVector34, aSN1EncodableVector32);
                    i39++;
                    c2 = 1;
                    x019 = x019;
                }
            }
            aSN1EncodableVector32 = a.x0(aSN1EncodableVector32, aSN1EncodableVector29);
            ASN1EncodableVector aSN1EncodableVector39 = new ASN1EncodableVector();
            if (gMSSRootCalcArr[i32].getRetain() != null) {
                for (int i43 = 0; i43 < gMSSRootCalcArr[i32].getRetain().length; i43++) {
                    for (int i44 = 0; i44 < gMSSRootCalcArr[i32].getRetain()[i43].size(); i44++) {
                        aSN1EncodableVector39.add(new DEROctetString((byte[]) gMSSRootCalcArr[i32].getRetain()[i43].elementAt(i44)));
                    }
                    aSN1EncodableVector39 = a.x0(aSN1EncodableVector39, aSN1EncodableVector33);
                }
            }
            aSN1EncodableVector33 = a.x0(aSN1EncodableVector33, aSN1EncodableVector29);
            aSN1EncodableVector29 = a.x0(aSN1EncodableVector29, x017);
            i32++;
            c = 1;
            aSN1EncodableVector31 = x019;
            aSN1EncodableVector30 = x018;
            algorithmIdentifierArr = algorithmIdentifierArr;
        }
        ASN1EncodableVector x020 = a.x0(x017, aSN1EncodableVector);
        for (byte[] bArr11 : bArr7) {
            x020.add(new DEROctetString(bArr11));
        }
        ASN1EncodableVector x021 = a.x0(x020, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector40 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector41 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector42 = new ASN1EncodableVector();
        for (int i45 = 0; i45 < gMSSRootSigArr.length; i45++) {
            aSN1EncodableVector40.add(new DERSequence(algorithmIdentifierArr[0]));
            new ASN1EncodableVector();
            aSN1EncodableVector41.add(new DEROctetString(gMSSRootSigArr[i45].getStatByte()[0]));
            aSN1EncodableVector41.add(new DEROctetString(gMSSRootSigArr[i45].getStatByte()[1]));
            aSN1EncodableVector41.add(new DEROctetString(gMSSRootSigArr[i45].getStatByte()[2]));
            aSN1EncodableVector41.add(new DEROctetString(gMSSRootSigArr[i45].getStatByte()[3]));
            aSN1EncodableVector41.add(new DEROctetString(gMSSRootSigArr[i45].getStatByte()[4]));
            aSN1EncodableVector40.add(new DERSequence(aSN1EncodableVector41));
            aSN1EncodableVector41 = new ASN1EncodableVector();
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[0]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[1]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[2]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[3]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[4]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[5]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[6]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[7]));
            aSN1EncodableVector42.add(new ASN1Integer((long) gMSSRootSigArr[i45].getStatInt()[8]));
            aSN1EncodableVector40.add(new DERSequence(aSN1EncodableVector42));
            aSN1EncodableVector42 = new ASN1EncodableVector();
            aSN1EncodableVector40 = a.x0(aSN1EncodableVector40, x021);
        }
        ASN1EncodableVector x022 = a.x0(x021, aSN1EncodableVector);
        ASN1EncodableVector aSN1EncodableVector43 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector44 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector45 = new ASN1EncodableVector();
        for (int i46 = 0; i46 < gMSSParameters.getHeightOfTrees().length; i46++) {
            aSN1EncodableVector43.add(new ASN1Integer((long) gMSSParameters.getHeightOfTrees()[i46]));
            aSN1EncodableVector44.add(new ASN1Integer((long) gMSSParameters.getWinternitzParameter()[i46]));
            aSN1EncodableVector45.add(new ASN1Integer((long) gMSSParameters.getK()[i46]));
        }
        x022.add(new ASN1Integer((long) gMSSParameters.getNumOfLayers()));
        x022.add(new DERSequence(aSN1EncodableVector43));
        x022.add(new DERSequence(aSN1EncodableVector44));
        x022.add(new DERSequence(aSN1EncodableVector45));
        ASN1EncodableVector x023 = a.x0(x022, aSN1EncodableVector);
        for (int i47 = 0; i47 < 1; i47++) {
            x023.add(algorithmIdentifierArr[i47]);
        }
        aSN1EncodableVector.add(new DERSequence(x023));
        this.a = new DERSequence(aSN1EncodableVector);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }
}
