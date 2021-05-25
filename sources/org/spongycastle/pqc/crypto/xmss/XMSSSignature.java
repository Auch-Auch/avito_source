package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.spongycastle.util.Pack;
public final class XMSSSignature extends XMSSReducedSignature implements XMSSStoreableObjectInterface {
    public final int d;
    public final byte[] e;

    public static class Builder extends XMSSReducedSignature.Builder {
        public final XMSSParameters e;
        public int f = 0;
        public byte[] g = null;

        public Builder(XMSSParameters xMSSParameters) {
            super(xMSSParameters);
            this.e = xMSSParameters;
        }

        public Builder withIndex(int i) {
            this.f = i;
            return this;
        }

        public Builder withRandom(byte[] bArr) {
            this.g = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSignature(byte[] bArr) {
            Objects.requireNonNull(bArr, "signature == null");
            int digestSize = this.e.getDigestSize();
            XMSSParameters xMSSParameters = this.e;
            int i = xMSSParameters.a.a.e;
            this.f = Pack.bigEndianToInt(bArr, 0);
            this.g = XMSSUtil.extractBytesAtOffset(bArr, 4, digestSize);
            withReducedSignature(XMSSUtil.extractBytesAtOffset(bArr, 4 + digestSize, (i * digestSize) + (xMSSParameters.getHeight() * digestSize)));
            return this;
        }

        @Override // org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature.Builder
        public XMSSSignature build() {
            return new XMSSSignature(this, null);
        }
    }

    public XMSSSignature(Builder builder, a aVar) {
        super(builder);
        this.d = builder.f;
        int digestSize = getParams().getDigestSize();
        byte[] bArr = builder.g;
        if (bArr == null) {
            this.e = new byte[digestSize];
        } else if (bArr.length == digestSize) {
            this.e = bArr;
        } else {
            throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
    }

    public int getIndex() {
        return this.d;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.e);
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature, org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        byte[][] a3;
        int digestSize = getParams().getDigestSize();
        byte[] bArr = new byte[a2.b.a.a.a.G1(digestSize, 4, getParams().a.a.e * digestSize, getParams().getHeight() * digestSize)];
        Pack.intToBigEndian(this.d, bArr, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.e, 4);
        int i = 4 + digestSize;
        for (byte[] bArr2 : getWOTSPlusSignature().a()) {
            XMSSUtil.copyBytesAtOffset(bArr, bArr2, i);
            i += digestSize;
        }
        for (int i2 = 0; i2 < getAuthPath().size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, getAuthPath().get(i2).getValue(), i);
            i += digestSize;
        }
        return bArr;
    }
}
