package org.spongycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;
public final class MacOutputStream extends OutputStream {
    public Mac a;

    public MacOutputStream(Mac mac) {
        this.a = mac;
    }

    public byte[] getMac() {
        return this.a.doFinal();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.a.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.update(bArr, i, i2);
    }
}
