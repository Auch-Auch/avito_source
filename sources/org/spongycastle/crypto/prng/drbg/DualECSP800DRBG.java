package org.spongycastle.crypto.prng.drbg;

import java.math.BigInteger;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import x6.e.b.d.b.a;
public class DualECSP800DRBG implements SP80090DRBG {
    public static final BigInteger l;
    public static final BigInteger m;
    public static final BigInteger n;
    public static final BigInteger o;
    public static final BigInteger p;
    public static final BigInteger q;
    public static final BigInteger r;
    public static final BigInteger s;
    public static final BigInteger t;
    public static final BigInteger u;
    public static final BigInteger v;
    public static final BigInteger w;
    public static final DualECPoints[] x;
    public Digest a;
    public long b;
    public EntropySource c;
    public int d;
    public int e;
    public int f;
    public ECPoint g;
    public ECPoint h;
    public byte[] i;
    public int j;
    public ECMultiplier k;

    static {
        BigInteger bigInteger = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        l = bigInteger;
        BigInteger bigInteger2 = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        m = bigInteger2;
        BigInteger bigInteger3 = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        n = bigInteger3;
        BigInteger bigInteger4 = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        o = bigInteger4;
        BigInteger bigInteger5 = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        p = bigInteger5;
        BigInteger bigInteger6 = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        q = bigInteger6;
        BigInteger bigInteger7 = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        r = bigInteger7;
        BigInteger bigInteger8 = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        s = bigInteger8;
        BigInteger bigInteger9 = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        t = bigInteger9;
        BigInteger bigInteger10 = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        u = bigInteger10;
        BigInteger bigInteger11 = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        v = bigInteger11;
        BigInteger bigInteger12 = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        w = bigInteger12;
        DualECPoints[] dualECPointsArr = new DualECPoints[3];
        x = dualECPointsArr;
        ECCurve.Fp fp = (ECCurve.Fp) NISTNamedCurves.getByName("P-256").getCurve();
        dualECPointsArr[0] = new DualECPoints(128, fp.createPoint(bigInteger, bigInteger2), fp.createPoint(bigInteger3, bigInteger4), 1);
        ECCurve.Fp fp2 = (ECCurve.Fp) NISTNamedCurves.getByName("P-384").getCurve();
        dualECPointsArr[1] = new DualECPoints(192, fp2.createPoint(bigInteger5, bigInteger6), fp2.createPoint(bigInteger7, bigInteger8), 1);
        ECCurve.Fp fp3 = (ECCurve.Fp) NISTNamedCurves.getByName("P-521").getCurve();
        dualECPointsArr[2] = new DualECPoints(256, fp3.createPoint(bigInteger9, bigInteger10), fp3.createPoint(bigInteger11, bigInteger12), 1);
    }

    public DualECSP800DRBG(Digest digest, int i2, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this(x, digest, i2, entropySource, bArr, bArr2);
    }

    public final byte[] a() {
        byte[] entropy = this.c.getEntropy();
        if (entropy.length >= (this.d + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final BigInteger b(ECPoint eCPoint, BigInteger bigInteger) {
        return this.k.multiply(eCPoint, bigInteger).normalize().getAffineXCoord().toBigInteger();
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        BigInteger bigInteger;
        int length = bArr.length * 8;
        int length2 = bArr.length / this.f;
        if (a.b(bArr2, 512)) {
            throw new IllegalArgumentException("Additional input too large");
        } else if (this.b + ((long) length2) > 2147483648L) {
            return -1;
        } else {
            if (z) {
                reseed(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                byte[] a3 = a.a(this.a, bArr2, this.e);
                byte[] bArr3 = this.i;
                int length3 = bArr3.length;
                byte[] bArr4 = new byte[length3];
                for (int i2 = 0; i2 != length3; i2++) {
                    bArr4[i2] = (byte) (bArr3[i2] ^ a3[i2]);
                }
                bigInteger = new BigInteger(1, bArr4);
            } else {
                bigInteger = new BigInteger(1, this.i);
            }
            Arrays.fill(bArr, (byte) 0);
            int i3 = 0;
            for (int i4 = 0; i4 < length2; i4++) {
                bigInteger = b(this.g, bigInteger);
                byte[] byteArray = b(this.h, bigInteger).toByteArray();
                int length4 = byteArray.length;
                int i5 = this.f;
                if (length4 > i5) {
                    System.arraycopy(byteArray, byteArray.length - i5, bArr, i3, i5);
                } else {
                    System.arraycopy(byteArray, 0, bArr, (i5 - byteArray.length) + i3, byteArray.length);
                }
                i3 += this.f;
                this.b++;
            }
            if (i3 < bArr.length) {
                bigInteger = b(this.g, bigInteger);
                byte[] byteArray2 = b(this.h, bigInteger).toByteArray();
                int length5 = bArr.length - i3;
                int length6 = byteArray2.length;
                int i6 = this.f;
                if (length6 > i6) {
                    System.arraycopy(byteArray2, byteArray2.length - i6, bArr, i3, length5);
                } else {
                    System.arraycopy(byteArray2, 0, bArr, (i6 - byteArray2.length) + i3, length5);
                }
                this.b++;
            }
            this.i = BigIntegers.asUnsignedByteArray(this.j, b(this.g, bigInteger));
            return length;
        }
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this.f * 8;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) {
        if (!a.b(bArr, 512)) {
            byte[] a3 = a();
            byte[] bArr2 = this.i;
            int i2 = this.e % 8;
            if (i2 != 0) {
                int i3 = 8 - i2;
                int i4 = 0;
                int length = bArr2.length - 1;
                while (length >= 0) {
                    int i5 = bArr2[length] & 255;
                    bArr2[length] = (byte) ((i4 >> (8 - i3)) | (i5 << i3));
                    length--;
                    i4 = i5;
                }
            }
            this.i = a.a(this.a, Arrays.concatenate(bArr2, a3, bArr), this.e);
            this.b = 0;
            return;
        }
        throw new IllegalArgumentException("Additional input string too large");
    }

    public DualECSP800DRBG(DualECPoints[] dualECPointsArr, Digest digest, int i2, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this.k = new FixedPointCombMultiplier();
        this.a = digest;
        this.c = entropySource;
        this.d = i2;
        if (a.b(bArr, 512)) {
            throw new IllegalArgumentException("Personalization string too large");
        } else if (entropySource.entropySize() < i2 || entropySource.entropySize() > 4096) {
            throw new IllegalArgumentException(a2.b.a.a.a.S2("EntropySource must provide between ", i2, " and ", 4096, " bits"));
        } else {
            byte[] concatenate = Arrays.concatenate(a(), bArr2, bArr);
            int i3 = 0;
            while (true) {
                if (i3 == dualECPointsArr.length) {
                    break;
                } else if (i2 > dualECPointsArr[i3].getSecurityStrength()) {
                    i3++;
                } else if (((Integer) a.a.get(digest.getAlgorithmName())).intValue() >= dualECPointsArr[i3].getSecurityStrength()) {
                    this.e = dualECPointsArr[i3].getSeedLen();
                    this.f = dualECPointsArr[i3].getMaxOutlen() / 8;
                    this.g = dualECPointsArr[i3].getP();
                    this.h = dualECPointsArr[i3].getQ();
                } else {
                    throw new IllegalArgumentException("Requested security strength is not supported by digest");
                }
            }
            if (this.g != null) {
                byte[] a3 = a.a(this.a, concatenate, this.e);
                this.i = a3;
                this.j = a3.length;
                this.b = 0;
                return;
            }
            throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
        }
    }
}
