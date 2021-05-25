package org.spongycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public final class XMSSPrivateKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final XMSSParameters b;
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;
    public final byte[] f;
    public final BDS g;

    public static class Builder {
        public final XMSSParameters a;
        public int b = 0;
        public byte[] c = null;
        public byte[] d = null;
        public byte[] e = null;
        public byte[] f = null;
        public BDS g = null;
        public byte[] h = null;
        public XMSSParameters i = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.a = xMSSParameters;
        }

        public XMSSPrivateKeyParameters build() {
            return new XMSSPrivateKeyParameters(this, null);
        }

        public Builder withBDSState(BDS bds) {
            this.g = bds;
            return this;
        }

        public Builder withIndex(int i2) {
            this.b = i2;
            return this;
        }

        public Builder withPrivateKey(byte[] bArr, XMSSParameters xMSSParameters) {
            this.h = XMSSUtil.cloneArray(bArr);
            this.i = xMSSParameters;
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.e = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.f = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] bArr) {
            this.d = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeySeed(byte[] bArr) {
            this.c = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    public XMSSPrivateKeyParameters(Builder builder, a aVar) {
        super(true);
        XMSSParameters xMSSParameters = builder.a;
        this.b = xMSSParameters;
        Objects.requireNonNull(xMSSParameters, "params == null");
        int digestSize = xMSSParameters.getDigestSize();
        byte[] bArr = builder.h;
        if (bArr != null) {
            Objects.requireNonNull(builder.i, "xmss == null");
            int height = xMSSParameters.getHeight();
            int bigEndianToInt = Pack.bigEndianToInt(bArr, 0);
            if (XMSSUtil.isIndexValid(height, (long) bigEndianToInt)) {
                this.c = XMSSUtil.extractBytesAtOffset(bArr, 4, digestSize);
                int i = digestSize + 4;
                this.d = XMSSUtil.extractBytesAtOffset(bArr, i, digestSize);
                int i2 = i + digestSize;
                this.e = XMSSUtil.extractBytesAtOffset(bArr, i2, digestSize);
                int i3 = i2 + digestSize;
                this.f = XMSSUtil.extractBytesAtOffset(bArr, i3, digestSize);
                int i4 = i3 + digestSize;
                BDS bds = null;
                try {
                    bds = (BDS) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(bArr, i4, bArr.length - i4));
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                }
                bds.setXMSS(builder.i);
                bds.validate();
                if (bds.getIndex() == bigEndianToInt) {
                    this.g = bds;
                    return;
                }
                throw new IllegalStateException("serialized BDS has wrong index");
            }
            throw new IllegalArgumentException("index out of bounds");
        }
        byte[] bArr2 = builder.c;
        if (bArr2 == null) {
            this.c = new byte[digestSize];
        } else if (bArr2.length == digestSize) {
            this.c = bArr2;
        } else {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
        }
        byte[] bArr3 = builder.d;
        if (bArr3 == null) {
            this.d = new byte[digestSize];
        } else if (bArr3.length == digestSize) {
            this.d = bArr3;
        } else {
            throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
        }
        byte[] bArr4 = builder.e;
        if (bArr4 == null) {
            this.e = new byte[digestSize];
        } else if (bArr4.length == digestSize) {
            this.e = bArr4;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
        }
        byte[] bArr5 = builder.f;
        if (bArr5 == null) {
            this.f = new byte[digestSize];
        } else if (bArr5.length == digestSize) {
            this.f = bArr5;
        } else {
            throw new IllegalArgumentException("size of root needs to be equal size of digest");
        }
        BDS bds2 = builder.g;
        if (bds2 != null) {
            this.g = bds2;
        } else if (builder.b >= (1 << xMSSParameters.getHeight()) - 2 || bArr4 == null || bArr2 == null) {
            int i5 = builder.b;
            BDS bds3 = new BDS(xMSSParameters.a, xMSSParameters.getHeight(), xMSSParameters.c);
            bds3.j = i5;
            bds3.k = true;
            this.g = bds3;
        } else {
            OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.Builder().build();
            int i6 = builder.b;
            BDS bds4 = new BDS(xMSSParameters.a, xMSSParameters.getHeight(), xMSSParameters.c);
            bds4.a(bArr4, bArr2, oTSHashAddress);
            while (bds4.j < i6) {
                bds4.b(bArr4, bArr2, oTSHashAddress);
                bds4.k = false;
            }
            this.g = bds4;
        }
    }

    public int getIndex() {
        return this.g.getIndex();
    }

    public XMSSPrivateKeyParameters getNextKey() {
        if (getIndex() < (1 << this.b.getHeight()) - 1) {
            return new Builder(this.b).withSecretKeySeed(this.c).withSecretKeyPRF(this.d).withPublicSeed(this.e).withRoot(this.f).withBDSState(this.g.getNextState(this.e, this.c, (OTSHashAddress) new OTSHashAddress.Builder().build())).build();
        }
        Builder withRoot = new Builder(this.b).withSecretKeySeed(this.c).withSecretKeyPRF(this.d).withPublicSeed(this.e).withRoot(this.f);
        XMSSParameters xMSSParameters = this.b;
        BDS bds = new BDS(xMSSParameters.a, xMSSParameters.getHeight(), xMSSParameters.c);
        bds.j = getIndex() + 1;
        bds.k = true;
        return withRoot.withBDSState(bds).build();
    }

    public XMSSParameters getParameters() {
        return this.b;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.e);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.f);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.d);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.c);
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int digestSize = this.b.getDigestSize();
        byte[] bArr = new byte[(digestSize + 4 + digestSize + digestSize + digestSize)];
        Pack.intToBigEndian(this.g.getIndex(), bArr, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.c, 4);
        int i = 4 + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.d, i);
        int i2 = i + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.e, i2);
        XMSSUtil.copyBytesAtOffset(bArr, this.f, i2 + digestSize);
        try {
            return Arrays.concatenate(bArr, XMSSUtil.serialize(this.g));
        } catch (IOException e2) {
            throw new RuntimeException(a2.b.a.a.a.A2(e2, a2.b.a.a.a.L("error serializing bds state: ")));
        }
    }
}
