package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;
public final class XMSSNode implements Serializable {
    private static final long serialVersionUID = 1;
    public final int a;
    public final byte[] b;

    public XMSSNode(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public int getHeight() {
        return this.a;
    }

    public byte[] getValue() {
        return XMSSUtil.cloneArray(this.b);
    }

    @Override // java.lang.Object
    public XMSSNode clone() {
        return new XMSSNode(getHeight(), getValue());
    }
}
