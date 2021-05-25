package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.pqc.crypto.xmss.XMSSAddress;
import org.spongycastle.util.Pack;
public final class LTreeAddress extends XMSSAddress {
    public final int e;
    public final int f;
    public final int g;

    public static class Builder extends XMSSAddress.Builder<Builder> {
        public int e = 0;
        public int f = 0;
        public int g = 0;

        public Builder() {
            super(1);
        }

        @Override // org.spongycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public XMSSAddress build() {
            return new LTreeAddress(this, null);
        }

        @Override // org.spongycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public Builder getThis() {
            return this;
        }

        public Builder withLTreeAddress(int i) {
            this.e = i;
            return this;
        }

        public Builder withTreeHeight(int i) {
            this.f = i;
            return this;
        }

        public Builder withTreeIndex(int i) {
            this.g = i;
            return this;
        }
    }

    public LTreeAddress(Builder builder, a aVar) {
        super(builder);
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        Pack.intToBigEndian(this.e, byteArray, 16);
        Pack.intToBigEndian(this.f, byteArray, 20);
        Pack.intToBigEndian(this.g, byteArray, 24);
        return byteArray;
    }
}
