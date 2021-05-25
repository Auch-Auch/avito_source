package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class CramerShoupCiphertext {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;

    public CramerShoupCiphertext() {
    }

    public BigInteger getE() {
        return this.c;
    }

    public BigInteger getU1() {
        return this.a;
    }

    public BigInteger getU2() {
        return this.b;
    }

    public BigInteger getV() {
        return this.d;
    }

    public void setE(BigInteger bigInteger) {
        this.c = bigInteger;
    }

    public void setU1(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public void setU2(BigInteger bigInteger) {
        this.b = bigInteger;
    }

    public void setV(BigInteger bigInteger) {
        this.d = bigInteger;
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.a.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.b.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.c.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.d.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[(length + length2 + length3 + length4 + 16)];
        Pack.intToBigEndian(length, bArr, 0);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        int i = length + 4;
        Pack.intToBigEndian(length2, bArr, i);
        int i2 = i + 4;
        System.arraycopy(byteArray2, 0, bArr, i2, length2);
        int i3 = i2 + length2;
        Pack.intToBigEndian(length3, bArr, i3);
        int i4 = i3 + 4;
        System.arraycopy(byteArray3, 0, bArr, i4, length3);
        int i5 = i4 + length3;
        Pack.intToBigEndian(length4, bArr, i5);
        System.arraycopy(byteArray4, 0, bArr, i5 + 4, length4);
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder L = a.L("u1: ");
        L.append(this.a.toString());
        stringBuffer.append(L.toString());
        stringBuffer.append("\nu2: " + this.b.toString());
        stringBuffer.append("\ne: " + this.c.toString());
        stringBuffer.append("\nv: " + this.d.toString());
        return stringBuffer.toString();
    }

    public CramerShoupCiphertext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
        this.d = bigInteger4;
    }

    public CramerShoupCiphertext(byte[] bArr) {
        int bigEndianToInt = Pack.bigEndianToInt(bArr, 0) + 4;
        this.a = new BigInteger(Arrays.copyOfRange(bArr, 4, bigEndianToInt));
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr, bigEndianToInt);
        int i = bigEndianToInt + 4;
        int i2 = bigEndianToInt2 + i;
        this.b = new BigInteger(Arrays.copyOfRange(bArr, i, i2));
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr, i2);
        int i3 = i2 + 4;
        int i4 = bigEndianToInt3 + i3;
        this.c = new BigInteger(Arrays.copyOfRange(bArr, i3, i4));
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr, i4);
        int i5 = i4 + 4;
        this.d = new BigInteger(Arrays.copyOfRange(bArr, i5, bigEndianToInt4 + i5));
    }
}
