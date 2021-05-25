package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public final class XMSSPublicKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final XMSSParameters b;
    public final byte[] c;
    public final byte[] d;

    public static class Builder {
        public final XMSSParameters a;
        public byte[] b = null;
        public byte[] c = null;
        public byte[] d = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.a = xMSSParameters;
        }

        public XMSSPublicKeyParameters build() {
            return new XMSSPublicKeyParameters(this, null);
        }

        public Builder withPublicKey(byte[] bArr) {
            this.d = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.c = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.b = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    public XMSSPublicKeyParameters(Builder builder, a aVar) {
        super(false);
        XMSSParameters xMSSParameters = builder.a;
        this.b = xMSSParameters;
        Objects.requireNonNull(xMSSParameters, "params == null");
        int digestSize = xMSSParameters.getDigestSize();
        byte[] bArr = builder.d;
        if (bArr != null) {
            if (bArr.length == digestSize + digestSize) {
                this.c = XMSSUtil.extractBytesAtOffset(bArr, 0, digestSize);
                this.d = XMSSUtil.extractBytesAtOffset(bArr, digestSize + 0, digestSize);
                return;
            }
            throw new IllegalArgumentException("public key has wrong size");
        }
        byte[] bArr2 = builder.b;
        if (bArr2 == null) {
            this.c = new byte[digestSize];
        } else if (bArr2.length == digestSize) {
            this.c = bArr2;
        } else {
            throw new IllegalArgumentException("length of root must be equal to length of digest");
        }
        byte[] bArr3 = builder.c;
        if (bArr3 == null) {
            this.d = new byte[digestSize];
        } else if (bArr3.length == digestSize) {
            this.d = bArr3;
        } else {
            throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
        }
    }

    public XMSSParameters getParameters() {
        return this.b;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.d);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.c);
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int digestSize = this.b.getDigestSize();
        byte[] bArr = new byte[(digestSize + digestSize)];
        XMSSUtil.copyBytesAtOffset(bArr, this.c, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.d, digestSize + 0);
        return bArr;
    }
}
