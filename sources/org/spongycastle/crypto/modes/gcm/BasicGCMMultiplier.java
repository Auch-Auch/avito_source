package org.spongycastle.crypto.modes.gcm;
public class BasicGCMMultiplier implements GCMMultiplier {
    public int[] a;

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        this.a = GCMUtil.asInts(bArr);
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        int[] asInts = GCMUtil.asInts(bArr);
        GCMUtil.multiply(asInts, this.a);
        GCMUtil.asBytes(asInts, bArr);
    }
}
