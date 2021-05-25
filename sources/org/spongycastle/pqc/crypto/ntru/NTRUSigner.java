package org.spongycastle.pqc.crypto.ntru;

import a2.b.a.a.a;
import java.nio.ByteBuffer;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
public class NTRUSigner {
    public NTRUSigningParameters a;
    public Digest b;
    public NTRUSigningPrivateKeyParameters c;
    public NTRUSigningPublicKeyParameters d;

    public NTRUSigner(NTRUSigningParameters nTRUSigningParameters) {
        this.a = nTRUSigningParameters;
    }

    public final boolean a(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3) {
        NTRUSigningParameters nTRUSigningParameters = this.a;
        int i = nTRUSigningParameters.q;
        double d2 = nTRUSigningParameters.normBoundSq;
        double d3 = nTRUSigningParameters.betaSq;
        IntegerPolynomial mult = integerPolynomial3.mult(integerPolynomial2, i);
        mult.sub(integerPolynomial);
        return ((double) ((long) ((d3 * ((double) mult.centeredNormSq(i))) + ((double) integerPolynomial2.centeredNormSq(i))))) <= d2;
    }

    public IntegerPolynomial createMsgRep(byte[] bArr, int i) {
        NTRUSigningParameters nTRUSigningParameters = this.a;
        int i2 = nTRUSigningParameters.N;
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(nTRUSigningParameters.q);
        int i3 = (numberOfLeadingZeros + 7) / 8;
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i2);
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
        allocate.put(bArr);
        allocate.putInt(i);
        NTRUSignerPrng nTRUSignerPrng = new NTRUSignerPrng(allocate.array(), this.a.hashAlg);
        for (int i4 = 0; i4 < i2; i4++) {
            ByteBuffer allocate2 = ByteBuffer.allocate(i3);
            while (allocate2.hasRemaining()) {
                ByteBuffer allocate3 = ByteBuffer.allocate(nTRUSignerPrng.b.length + 4);
                allocate3.put(nTRUSignerPrng.b);
                allocate3.putInt(nTRUSignerPrng.a);
                byte[] array = allocate3.array();
                int digestSize = nTRUSignerPrng.c.getDigestSize();
                byte[] bArr2 = new byte[digestSize];
                nTRUSignerPrng.c.update(array, 0, array.length);
                nTRUSignerPrng.c.doFinal(bArr2, 0);
                if (allocate2.remaining() < digestSize) {
                    allocate2.put(bArr2, 0, allocate2.remaining());
                } else {
                    allocate2.put(bArr2);
                }
                nTRUSignerPrng.a++;
            }
            byte[] array2 = allocate2.array();
            int i5 = (i3 * 8) - numberOfLeadingZeros;
            array2[array2.length - 1] = (byte) ((array2[array2.length - 1] >> i5) << i5);
            ByteBuffer allocate4 = ByteBuffer.allocate(4);
            allocate4.put(array2);
            allocate4.rewind();
            integerPolynomial.coeffs[i4] = Integer.reverseBytes(allocate4.getInt());
        }
        return integerPolynomial;
    }

    public byte[] generateSignature() {
        IntegerPolynomial createMsgRep;
        IntegerPolynomial integerPolynomial;
        Digest digest = this.b;
        if (digest == null || this.c == null) {
            throw new IllegalStateException("Call initSign first!");
        }
        byte[] bArr = new byte[digest.getDigestSize()];
        this.b.doFinal(bArr, 0);
        NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters = this.c;
        NTRUSigningPublicKeyParameters publicKey = nTRUSigningPrivateKeyParameters.getPublicKey();
        int i = 0;
        do {
            i++;
            if (i <= this.a.signFailTolerance) {
                createMsgRep = createMsgRep(bArr, i);
                NTRUSigningParameters nTRUSigningParameters = this.a;
                int i2 = nTRUSigningParameters.N;
                int i3 = nTRUSigningParameters.q;
                NTRUSigningPublicKeyParameters publicKey2 = nTRUSigningPrivateKeyParameters.getPublicKey();
                integerPolynomial = new IntegerPolynomial(i2);
                IntegerPolynomial integerPolynomial2 = createMsgRep;
                for (int i4 = nTRUSigningParameters.B; i4 >= 1; i4--) {
                    Polynomial polynomial = nTRUSigningPrivateKeyParameters.getBasis(i4).f;
                    Polynomial polynomial2 = nTRUSigningPrivateKeyParameters.getBasis(i4).fPrime;
                    IntegerPolynomial mult = polynomial.mult(integerPolynomial2);
                    mult.div(i3);
                    IntegerPolynomial mult2 = polynomial2.mult(mult);
                    IntegerPolynomial mult3 = polynomial2.mult(integerPolynomial2);
                    mult3.div(i3);
                    mult2.sub(polynomial.mult(mult3));
                    integerPolynomial.add(mult2);
                    IntegerPolynomial integerPolynomial3 = (IntegerPolynomial) nTRUSigningPrivateKeyParameters.getBasis(i4).h.clone();
                    if (i4 > 1) {
                        integerPolynomial3.sub(nTRUSigningPrivateKeyParameters.getBasis(i4 - 1).h);
                    } else {
                        integerPolynomial3.sub(publicKey2.h);
                    }
                    integerPolynomial2 = mult2.mult(integerPolynomial3, i3);
                }
                Polynomial polynomial3 = nTRUSigningPrivateKeyParameters.getBasis(0).f;
                Polynomial polynomial4 = nTRUSigningPrivateKeyParameters.getBasis(0).fPrime;
                IntegerPolynomial mult4 = polynomial3.mult(integerPolynomial2);
                mult4.div(i3);
                IntegerPolynomial mult5 = polynomial4.mult(mult4);
                IntegerPolynomial mult6 = polynomial4.mult(integerPolynomial2);
                mult6.div(i3);
                mult5.sub(polynomial3.mult(mult6));
                integerPolynomial.add(mult5);
                integerPolynomial.modPositive(i3);
            } else {
                throw new IllegalStateException(a.j(a.L("Signing failed: too many retries (max="), this.a.signFailTolerance, ")"));
            }
        } while (!a(createMsgRep, integerPolynomial, publicKey.h));
        byte[] binary = integerPolynomial.toBinary(this.a.q);
        ByteBuffer allocate = ByteBuffer.allocate(binary.length + 4);
        allocate.put(binary);
        allocate.putInt(i);
        return allocate.array();
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.c = (NTRUSigningPrivateKeyParameters) cipherParameters;
        } else {
            this.d = (NTRUSigningPublicKeyParameters) cipherParameters;
        }
        Digest digest = this.a.hashAlg;
        this.b = digest;
        digest.reset();
    }

    public void update(byte b2) {
        Digest digest = this.b;
        if (digest != null) {
            digest.update(b2);
            return;
        }
        throw new IllegalStateException("Call initSign or initVerify first!");
    }

    public boolean verifySignature(byte[] bArr) {
        Digest digest = this.b;
        if (digest == null || this.d == null) {
            throw new IllegalStateException("Call initVerify first!");
        }
        byte[] bArr2 = new byte[digest.getDigestSize()];
        this.b.doFinal(bArr2, 0);
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = this.d;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr3 = new byte[(bArr.length - 4)];
        wrap.get(bArr3);
        NTRUSigningParameters nTRUSigningParameters = this.a;
        return a(createMsgRep(bArr2, wrap.getInt()), IntegerPolynomial.fromBinary(bArr3, nTRUSigningParameters.N, nTRUSigningParameters.q), nTRUSigningPublicKeyParameters.h);
    }

    public void update(byte[] bArr, int i, int i2) {
        Digest digest = this.b;
        if (digest != null) {
            digest.update(bArr, i, i2);
            return;
        }
        throw new IllegalStateException("Call initSign or initVerify first!");
    }
}
