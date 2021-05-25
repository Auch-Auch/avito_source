package org.spongycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;
public final class XMSSMTPrivateKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final XMSSMTParameters b;
    public final long c;
    public final byte[] d;
    public final byte[] e;
    public final byte[] f;
    public final byte[] g;
    public final BDSStateMap i;

    public static class Builder {
        public final XMSSMTParameters a;
        public long b = 0;
        public byte[] c = null;
        public byte[] d = null;
        public byte[] e = null;
        public byte[] f = null;
        public BDSStateMap g = null;
        public byte[] h = null;
        public XMSSParameters i = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.a = xMSSMTParameters;
        }

        public XMSSMTPrivateKeyParameters build() {
            return new XMSSMTPrivateKeyParameters(this, null);
        }

        public Builder withBDSState(BDSStateMap bDSStateMap) {
            this.g = bDSStateMap;
            return this;
        }

        public Builder withIndex(long j) {
            this.b = j;
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

    public XMSSMTPrivateKeyParameters(Builder builder, a aVar) {
        super(true);
        XMSSMTParameters xMSSMTParameters = builder.a;
        this.b = xMSSMTParameters;
        Objects.requireNonNull(xMSSMTParameters, "params == null");
        int digestSize = xMSSMTParameters.getDigestSize();
        byte[] bArr = builder.h;
        if (bArr != null) {
            Objects.requireNonNull(builder.i, "xmss == null");
            int height = xMSSMTParameters.getHeight();
            int i2 = (height + 7) / 8;
            long bytesToXBigEndian = XMSSUtil.bytesToXBigEndian(bArr, 0, i2);
            this.c = bytesToXBigEndian;
            if (XMSSUtil.isIndexValid(height, bytesToXBigEndian)) {
                int i3 = i2 + 0;
                this.d = XMSSUtil.extractBytesAtOffset(bArr, i3, digestSize);
                int i4 = i3 + digestSize;
                this.e = XMSSUtil.extractBytesAtOffset(bArr, i4, digestSize);
                int i5 = i4 + digestSize;
                this.f = XMSSUtil.extractBytesAtOffset(bArr, i5, digestSize);
                int i6 = i5 + digestSize;
                this.g = XMSSUtil.extractBytesAtOffset(bArr, i6, digestSize);
                int i7 = i6 + digestSize;
                byte[] extractBytesAtOffset = XMSSUtil.extractBytesAtOffset(bArr, i7, bArr.length - i7);
                BDSStateMap bDSStateMap = null;
                try {
                    bDSStateMap = (BDSStateMap) XMSSUtil.deserialize(extractBytesAtOffset);
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                }
                XMSSParameters xMSSParameters = builder.i;
                for (Integer num : bDSStateMap.a.keySet()) {
                    BDS bds = bDSStateMap.a.get(num);
                    bds.setXMSS(xMSSParameters);
                    bds.validate();
                }
                this.i = bDSStateMap;
                return;
            }
            throw new IllegalArgumentException("index out of bounds");
        }
        long j = builder.b;
        this.c = j;
        byte[] bArr2 = builder.c;
        if (bArr2 == null) {
            this.d = new byte[digestSize];
        } else if (bArr2.length == digestSize) {
            this.d = bArr2;
        } else {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
        }
        byte[] bArr3 = builder.d;
        if (bArr3 == null) {
            this.e = new byte[digestSize];
        } else if (bArr3.length == digestSize) {
            this.e = bArr3;
        } else {
            throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
        }
        byte[] bArr4 = builder.e;
        if (bArr4 == null) {
            this.f = new byte[digestSize];
        } else if (bArr4.length == digestSize) {
            this.f = bArr4;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
        }
        byte[] bArr5 = builder.f;
        if (bArr5 == null) {
            this.g = new byte[digestSize];
        } else if (bArr5.length == digestSize) {
            this.g = bArr5;
        } else {
            throw new IllegalArgumentException("size of root needs to be equal size of digest");
        }
        BDSStateMap bDSStateMap2 = builder.g;
        if (bDSStateMap2 != null) {
            this.i = bDSStateMap2;
        } else if (!XMSSUtil.isIndexValid(xMSSMTParameters.getHeight(), j) || bArr4 == null || bArr2 == null) {
            this.i = new BDSStateMap();
        } else {
            this.i = new BDSStateMap(xMSSMTParameters, builder.b, bArr4, bArr2);
        }
    }

    public long getIndex() {
        return this.c;
    }

    public XMSSMTPrivateKeyParameters getNextKey() {
        return new Builder(this.b).withIndex(this.c + 1).withSecretKeySeed(this.d).withSecretKeyPRF(this.e).withPublicSeed(this.f).withRoot(this.g).withBDSState(new BDSStateMap(this.i, this.b, getIndex(), this.f, this.d)).build();
    }

    public XMSSMTParameters getParameters() {
        return this.b;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.f);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.g);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.e);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.d);
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int digestSize = this.b.getDigestSize();
        int height = (this.b.getHeight() + 7) / 8;
        byte[] bArr = new byte[(height + digestSize + digestSize + digestSize + digestSize)];
        XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.c, height), 0);
        int i2 = height + 0;
        XMSSUtil.copyBytesAtOffset(bArr, this.d, i2);
        int i3 = i2 + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.e, i3);
        int i4 = i3 + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.f, i4);
        XMSSUtil.copyBytesAtOffset(bArr, this.g, i4 + digestSize);
        try {
            return Arrays.concatenate(bArr, XMSSUtil.serialize(this.i));
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new RuntimeException("error serializing bds state");
        }
    }
}
