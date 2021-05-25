package org.spongycastle.pqc.crypto.ntru;

import a2.b.a.a.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
public class NTRUSigningKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    public static final NTRUSigningKeyGenerationParameters APR2011_439 = new NTRUSigningKeyGenerationParameters(439, 2048, 146, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_439_PROD = new NTRUSigningKeyGenerationParameters(439, 2048, 9, 8, 5, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_743 = new NTRUSigningKeyGenerationParameters(743, 2048, 248, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, new SHA512Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_743_PROD = new NTRUSigningKeyGenerationParameters(743, 2048, 11, 11, 15, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, new SHA512Digest());
    public static final int BASIS_TYPE_STANDARD = 0;
    public static final int BASIS_TYPE_TRANSPOSE = 1;
    public static final int KEY_GEN_ALG_FLOAT = 1;
    public static final int KEY_GEN_ALG_RESULTANT = 0;
    public static final NTRUSigningKeyGenerationParameters TEST157 = new NTRUSigningKeyGenerationParameters(157, 256, 29, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters TEST157_PROD = new NTRUSigningKeyGenerationParameters(157, 256, 5, 5, 8, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());
    public int B;
    public int N;
    public int basisType;
    public double betaSq;
    public int d;
    public int d1;
    public int d2;
    public int d3;
    public double e;
    public double f;
    public double g;
    public int h = 6;
    public Digest hashAlg;
    public int keyGenAlg;
    public double keyNormBoundSq;
    public double normBoundSq;
    public int polyType;
    public boolean primeCheck;
    public int q;
    public int signFailTolerance = 100;
    public boolean sparse;

    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, double d4, double d5, double d6, boolean z, boolean z2, int i6, Digest digest) {
        super(new SecureRandom(), i);
        this.N = i;
        this.q = i2;
        this.d = i3;
        this.B = i4;
        this.basisType = i5;
        this.e = d4;
        this.f = d5;
        this.g = d6;
        this.primeCheck = z;
        this.sparse = z2;
        this.keyGenAlg = i6;
        this.hashAlg = digest;
        this.polyType = 0;
        a();
    }

    public final void a() {
        double d4 = this.e;
        this.betaSq = d4 * d4;
        double d5 = this.f;
        this.normBoundSq = d5 * d5;
        double d6 = this.g;
        this.keyNormBoundSq = d6 * d6;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningKeyGenerationParameters)) {
            return false;
        }
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = (NTRUSigningKeyGenerationParameters) obj;
        if (this.B != nTRUSigningKeyGenerationParameters.B || this.N != nTRUSigningKeyGenerationParameters.N || this.basisType != nTRUSigningKeyGenerationParameters.basisType || Double.doubleToLongBits(this.e) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.e) || Double.doubleToLongBits(this.betaSq) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.betaSq) || this.h != nTRUSigningKeyGenerationParameters.h || this.d != nTRUSigningKeyGenerationParameters.d || this.d1 != nTRUSigningKeyGenerationParameters.d1 || this.d2 != nTRUSigningKeyGenerationParameters.d2 || this.d3 != nTRUSigningKeyGenerationParameters.d3) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUSigningKeyGenerationParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUSigningKeyGenerationParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return this.keyGenAlg == nTRUSigningKeyGenerationParameters.keyGenAlg && Double.doubleToLongBits(this.g) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.g) && Double.doubleToLongBits(this.keyNormBoundSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.keyNormBoundSq) && Double.doubleToLongBits(this.f) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.normBoundSq) && this.polyType == nTRUSigningKeyGenerationParameters.polyType && this.primeCheck == nTRUSigningKeyGenerationParameters.primeCheck && this.q == nTRUSigningKeyGenerationParameters.q && this.signFailTolerance == nTRUSigningKeyGenerationParameters.signFailTolerance && this.sparse == nTRUSigningKeyGenerationParameters.sparse;
    }

    public NTRUSigningParameters getSigningParameters() {
        return new NTRUSigningParameters(this.N, this.q, this.d, this.B, this.e, this.f, this.hashAlg);
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = ((((this.B + 31) * 31) + this.N) * 31) + this.basisType;
        long doubleToLongBits = Double.doubleToLongBits(this.e);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.h) * 31) + this.d) * 31) + this.d1) * 31) + this.d2) * 31) + this.d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = ((i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + this.keyGenAlg;
        long doubleToLongBits3 = Double.doubleToLongBits(this.g);
        long doubleToLongBits4 = Double.doubleToLongBits(this.keyNormBoundSq);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f);
        long doubleToLongBits6 = Double.doubleToLongBits(this.normBoundSq);
        int i3 = 1231;
        int i4 = ((((((((((((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + this.polyType) * 31) + (this.primeCheck ? 1231 : 1237)) * 31) + this.q) * 31) + this.signFailTolerance) * 31;
        if (!this.sparse) {
            i3 = 1237;
        }
        return i4 + i3;
    }

    @Override // java.lang.Object
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder L = a.L("SignatureParameters(N=");
        L.append(this.N);
        L.append(" q=");
        L.append(this.q);
        StringBuilder sb = new StringBuilder(L.toString());
        if (this.polyType == 0) {
            StringBuilder L2 = a.L(" polyType=SIMPLE d=");
            L2.append(this.d);
            sb.append(L2.toString());
        } else {
            StringBuilder L3 = a.L(" polyType=PRODUCT d1=");
            L3.append(this.d1);
            L3.append(" d2=");
            L3.append(this.d2);
            L3.append(" d3=");
            L3.append(this.d3);
            sb.append(L3.toString());
        }
        StringBuilder L4 = a.L(" B=");
        L4.append(this.B);
        L4.append(" basisType=");
        L4.append(this.basisType);
        L4.append(" beta=");
        L4.append(decimalFormat.format(this.e));
        L4.append(" normBound=");
        L4.append(decimalFormat.format(this.f));
        L4.append(" keyNormBound=");
        L4.append(decimalFormat.format(this.g));
        L4.append(" prime=");
        L4.append(this.primeCheck);
        L4.append(" sparse=");
        L4.append(this.sparse);
        L4.append(" keyGenAlg=");
        L4.append(this.keyGenAlg);
        L4.append(" hashAlg=");
        L4.append(this.hashAlg);
        L4.append(")");
        sb.append(L4.toString());
        return sb.toString();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.N);
        dataOutputStream.writeInt(this.q);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeInt(this.d1);
        dataOutputStream.writeInt(this.d2);
        dataOutputStream.writeInt(this.d3);
        dataOutputStream.writeInt(this.B);
        dataOutputStream.writeInt(this.basisType);
        dataOutputStream.writeDouble(this.e);
        dataOutputStream.writeDouble(this.f);
        dataOutputStream.writeDouble(this.g);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeBoolean(this.primeCheck);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeInt(this.h);
        dataOutputStream.write(this.keyGenAlg);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
        dataOutputStream.write(this.polyType);
    }

    @Override // java.lang.Object
    public NTRUSigningKeyGenerationParameters clone() {
        if (this.polyType == 0) {
            return new NTRUSigningKeyGenerationParameters(this.N, this.q, this.d, this.B, this.basisType, this.e, this.f, this.g, this.primeCheck, this.sparse, this.keyGenAlg, this.hashAlg);
        }
        return new NTRUSigningKeyGenerationParameters(this.N, this.q, this.d1, this.d2, this.d3, this.B, this.basisType, this.e, this.f, this.g, this.primeCheck, this.sparse, this.keyGenAlg, this.hashAlg);
    }

    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, double d4, double d5, double d6, boolean z, boolean z2, int i8, Digest digest) {
        super(new SecureRandom(), i);
        this.N = i;
        this.q = i2;
        this.d1 = i3;
        this.d2 = i4;
        this.d3 = i5;
        this.B = i6;
        this.basisType = i7;
        this.e = d4;
        this.f = d5;
        this.g = d6;
        this.primeCheck = z;
        this.sparse = z2;
        this.keyGenAlg = i8;
        this.hashAlg = digest;
        this.polyType = 1;
        a();
    }

    public NTRUSigningKeyGenerationParameters(InputStream inputStream) throws IOException {
        super(new SecureRandom(), 0);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.N = dataInputStream.readInt();
        this.q = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.d1 = dataInputStream.readInt();
        this.d2 = dataInputStream.readInt();
        this.d3 = dataInputStream.readInt();
        this.B = dataInputStream.readInt();
        this.basisType = dataInputStream.readInt();
        this.e = dataInputStream.readDouble();
        this.f = dataInputStream.readDouble();
        this.g = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.primeCheck = dataInputStream.readBoolean();
        this.sparse = dataInputStream.readBoolean();
        this.h = dataInputStream.readInt();
        this.keyGenAlg = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        if (McElieceCCA2KeyGenParameterSpec.SHA512.equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        this.polyType = dataInputStream.read();
        a();
    }
}
