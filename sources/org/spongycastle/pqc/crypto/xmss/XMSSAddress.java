package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.util.Pack;
public abstract class XMSSAddress {
    public final int a;
    public final long b;
    public final int c;
    public final int d;

    public static abstract class Builder<T extends Builder> {
        public final int a;
        public int b = 0;
        public long c = 0;
        public int d = 0;

        public Builder(int i) {
            this.a = i;
        }

        public abstract XMSSAddress build();

        public abstract T getThis();

        public T withKeyAndMask(int i) {
            this.d = i;
            return getThis();
        }

        public T withLayerAddress(int i) {
            this.b = i;
            return getThis();
        }

        public T withTreeAddress(long j) {
            this.c = j;
            return getThis();
        }
    }

    public XMSSAddress(Builder builder) {
        this.a = builder.b;
        this.b = builder.c;
        this.c = builder.a;
        this.d = builder.d;
    }

    public final int getKeyAndMask() {
        return this.d;
    }

    public final int getLayerAddress() {
        return this.a;
    }

    public final long getTreeAddress() {
        return this.b;
    }

    public final int getType() {
        return this.c;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[32];
        Pack.intToBigEndian(this.a, bArr, 0);
        Pack.longToBigEndian(this.b, bArr, 4);
        Pack.intToBigEndian(this.c, bArr, 12);
        Pack.intToBigEndian(this.d, bArr, 28);
        return bArr;
    }
}
