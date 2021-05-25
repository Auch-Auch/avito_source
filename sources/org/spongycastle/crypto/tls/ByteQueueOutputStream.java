package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
public class ByteQueueOutputStream extends OutputStream {
    public ByteQueue a = new ByteQueue();

    public ByteQueue getBuffer() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.a.addData(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.addData(bArr, i, i2);
    }
}
