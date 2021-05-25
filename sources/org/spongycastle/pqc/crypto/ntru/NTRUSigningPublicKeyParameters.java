package org.spongycastle.pqc.crypto.ntru;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
public class NTRUSigningPublicKeyParameters extends AsymmetricKeyParameter {
    public NTRUSigningParameters b;
    public IntegerPolynomial h;

    public NTRUSigningPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.h = integerPolynomial;
        this.b = nTRUSigningParameters;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = (NTRUSigningPublicKeyParameters) obj;
        IntegerPolynomial integerPolynomial = this.h;
        if (integerPolynomial == null) {
            if (nTRUSigningPublicKeyParameters.h != null) {
                return false;
            }
        } else if (!integerPolynomial.equals(nTRUSigningPublicKeyParameters.h)) {
            return false;
        }
        NTRUSigningParameters nTRUSigningParameters = this.b;
        if (nTRUSigningParameters == null) {
            if (nTRUSigningPublicKeyParameters.b != null) {
                return false;
            }
        } else if (!nTRUSigningParameters.equals(nTRUSigningPublicKeyParameters.b)) {
            return false;
        }
        return true;
    }

    public byte[] getEncoded() {
        return this.h.toBinary(this.b.q);
    }

    public int hashCode() {
        IntegerPolynomial integerPolynomial = this.h;
        int i = 0;
        int hashCode = ((integerPolynomial == null ? 0 : integerPolynomial.hashCode()) + 31) * 31;
        NTRUSigningParameters nTRUSigningParameters = this.b;
        if (nTRUSigningParameters != null) {
            i = nTRUSigningParameters.hashCode();
        }
        return hashCode + i;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPublicKeyParameters(byte[] bArr, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.h = IntegerPolynomial.fromBinary(bArr, nTRUSigningParameters.N, nTRUSigningParameters.q);
        this.b = nTRUSigningParameters;
    }

    public NTRUSigningPublicKeyParameters(InputStream inputStream, NTRUSigningParameters nTRUSigningParameters) throws IOException {
        super(false);
        this.h = IntegerPolynomial.fromBinary(inputStream, nTRUSigningParameters.N, nTRUSigningParameters.q);
        this.b = nTRUSigningParameters;
    }
}
