package org.spongycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
public final class XMSSMTSignature implements XMSSStoreableObjectInterface {
    public final XMSSMTParameters a;
    public final long b;
    public final byte[] c;
    public final List<XMSSReducedSignature> d;

    public static class Builder {
        public final XMSSMTParameters a;
        public long b = 0;
        public byte[] c = null;
        public List<XMSSReducedSignature> d = null;
        public byte[] e = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.a = xMSSMTParameters;
        }

        public XMSSMTSignature build() {
            return new XMSSMTSignature(this, null);
        }

        public Builder withIndex(long j) {
            this.b = j;
            return this;
        }

        public Builder withRandom(byte[] bArr) {
            this.c = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withReducedSignatures(List<XMSSReducedSignature> list) {
            this.d = list;
            return this;
        }

        public Builder withSignature(byte[] bArr) {
            this.e = bArr;
            return this;
        }
    }

    public XMSSMTSignature(Builder builder, a aVar) {
        XMSSMTParameters xMSSMTParameters = builder.a;
        this.a = xMSSMTParameters;
        Objects.requireNonNull(xMSSMTParameters, "params == null");
        int digestSize = xMSSMTParameters.getDigestSize();
        byte[] bArr = builder.e;
        if (bArr != null) {
            int i = xMSSMTParameters.getWOTSPlus().a.e;
            int ceil = (int) Math.ceil(((double) xMSSMTParameters.getHeight()) / 8.0d);
            int height = ((xMSSMTParameters.getHeight() / xMSSMTParameters.getLayers()) + i) * digestSize;
            if (bArr.length == ceil + digestSize + (xMSSMTParameters.getLayers() * height)) {
                long bytesToXBigEndian = XMSSUtil.bytesToXBigEndian(bArr, 0, ceil);
                this.b = bytesToXBigEndian;
                if (XMSSUtil.isIndexValid(xMSSMTParameters.getHeight(), bytesToXBigEndian)) {
                    int i2 = ceil + 0;
                    this.c = XMSSUtil.extractBytesAtOffset(bArr, i2, digestSize);
                    this.d = new ArrayList();
                    for (int i3 = i2 + digestSize; i3 < bArr.length; i3 += height) {
                        this.d.add(new XMSSReducedSignature.Builder(this.a.getXMSSParameters()).withReducedSignature(XMSSUtil.extractBytesAtOffset(bArr, i3, height)).build());
                    }
                    return;
                }
                throw new IllegalArgumentException("index out of bounds");
            }
            throw new IllegalArgumentException("signature has wrong size");
        }
        this.b = builder.b;
        byte[] bArr2 = builder.c;
        if (bArr2 == null) {
            this.c = new byte[digestSize];
        } else if (bArr2.length == digestSize) {
            this.c = bArr2;
        } else {
            throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
        List<XMSSReducedSignature> list = builder.d;
        if (list != null) {
            this.d = list;
        } else {
            this.d = new ArrayList();
        }
    }

    public long getIndex() {
        return this.b;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.c);
    }

    public List<XMSSReducedSignature> getReducedSignatures() {
        return this.d;
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int digestSize = this.a.getDigestSize();
        int i = this.a.getWOTSPlus().a.e;
        int ceil = (int) Math.ceil(((double) this.a.getHeight()) / 8.0d);
        int height = ((this.a.getHeight() / this.a.getLayers()) + i) * digestSize;
        byte[] bArr = new byte[(ceil + digestSize + (this.a.getLayers() * height))];
        XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.b, ceil), 0);
        int i2 = ceil + 0;
        XMSSUtil.copyBytesAtOffset(bArr, this.c, i2);
        int i3 = i2 + digestSize;
        for (XMSSReducedSignature xMSSReducedSignature : this.d) {
            XMSSUtil.copyBytesAtOffset(bArr, xMSSReducedSignature.toByteArray(), i3);
            i3 += height;
        }
        return bArr;
    }
}
