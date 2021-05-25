package org.spongycastle.pqc.crypto.ntru;

import a2.b.a.a.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
public class NTRUSigningParameters implements Cloneable {
    public int B;
    public int N;
    public double a;
    public double b;
    public double betaSq;
    public int c = 6;
    public int d;
    public int d1;
    public int d2;
    public int d3;
    public Digest hashAlg;
    public double normBoundSq;
    public int q;
    public int signFailTolerance = 100;

    public NTRUSigningParameters(int i, int i2, int i3, int i4, double d4, double d5, Digest digest) {
        this.N = i;
        this.q = i2;
        this.d = i3;
        this.B = i4;
        this.a = d4;
        this.b = d5;
        this.hashAlg = digest;
        a();
    }

    public final void a() {
        double d4 = this.a;
        this.betaSq = d4 * d4;
        double d5 = this.b;
        this.normBoundSq = d5 * d5;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningParameters)) {
            return false;
        }
        NTRUSigningParameters nTRUSigningParameters = (NTRUSigningParameters) obj;
        if (this.B != nTRUSigningParameters.B || this.N != nTRUSigningParameters.N || Double.doubleToLongBits(this.a) != Double.doubleToLongBits(nTRUSigningParameters.a) || Double.doubleToLongBits(this.betaSq) != Double.doubleToLongBits(nTRUSigningParameters.betaSq) || this.c != nTRUSigningParameters.c || this.d != nTRUSigningParameters.d || this.d1 != nTRUSigningParameters.d1 || this.d2 != nTRUSigningParameters.d2 || this.d3 != nTRUSigningParameters.d3) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUSigningParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUSigningParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return Double.doubleToLongBits(this.b) == Double.doubleToLongBits(nTRUSigningParameters.b) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningParameters.normBoundSq) && this.q == nTRUSigningParameters.q && this.signFailTolerance == nTRUSigningParameters.signFailTolerance;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = ((this.B + 31) * 31) + this.N;
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31) + this.d1) * 31) + this.d2) * 31) + this.d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode());
        long doubleToLongBits3 = Double.doubleToLongBits(this.b);
        long doubleToLongBits4 = Double.doubleToLongBits(this.normBoundSq);
        return (((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + this.q) * 31) + this.signFailTolerance;
    }

    @Override // java.lang.Object
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder L = a.L("SignatureParameters(N=");
        L.append(this.N);
        L.append(" q=");
        L.append(this.q);
        StringBuilder sb = new StringBuilder(L.toString());
        StringBuilder L2 = a.L(" B=");
        L2.append(this.B);
        L2.append(" beta=");
        L2.append(decimalFormat.format(this.a));
        L2.append(" normBound=");
        L2.append(decimalFormat.format(this.b));
        L2.append(" hashAlg=");
        L2.append(this.hashAlg);
        L2.append(")");
        sb.append(L2.toString());
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
        dataOutputStream.writeDouble(this.a);
        dataOutputStream.writeDouble(this.b);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }

    @Override // java.lang.Object
    public NTRUSigningParameters clone() {
        return new NTRUSigningParameters(this.N, this.q, this.d, this.B, this.a, this.b, this.hashAlg);
    }

    public NTRUSigningParameters(int i, int i2, int i3, int i4, int i5, int i6, double d4, double d5, double d6, Digest digest) {
        this.N = i;
        this.q = i2;
        this.d1 = i3;
        this.d2 = i4;
        this.d3 = i5;
        this.B = i6;
        this.a = d4;
        this.b = d5;
        this.hashAlg = digest;
        a();
    }

    public NTRUSigningParameters(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.N = dataInputStream.readInt();
        this.q = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.d1 = dataInputStream.readInt();
        this.d2 = dataInputStream.readInt();
        this.d3 = dataInputStream.readInt();
        this.B = dataInputStream.readInt();
        this.a = dataInputStream.readDouble();
        this.b = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        String readUTF = dataInputStream.readUTF();
        if (McElieceCCA2KeyGenParameterSpec.SHA512.equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        a();
    }
}
