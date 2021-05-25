package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.pqc.crypto.xmss.XMSSAddress;
import org.spongycastle.util.Pack;
public final class HashTreeAddress extends XMSSAddress {
    public final int e;
    public final int f;

    public static class Builder extends XMSSAddress.Builder<Builder> {
        public int e = 0;
        public int f = 0;

        public Builder() {
            super(2);
        }

        @Override // org.spongycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public XMSSAddress build() {
            return new HashTreeAddress(this, null);
        }

        @Override // org.spongycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public Builder getThis() {
            return this;
        }

        public Builder withTreeHeight(int i) {
            this.e = i;
            return this;
        }

        public Builder withTreeIndex(int i) {
            this.f = i;
            return this;
        }
    }

    public HashTreeAddress(Builder builder, a aVar) {
        super(builder);
        this.e = builder.e;
        this.f = builder.f;
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        Pack.intToBigEndian(0, byteArray, 16);
        Pack.intToBigEndian(this.e, byteArray, 20);
        Pack.intToBigEndian(this.f, byteArray, 24);
        return byteArray;
    }
}
