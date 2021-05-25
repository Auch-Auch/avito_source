package x6.e.b.e;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.tls.TlsProtocol;
public class o extends OutputStream {
    public byte[] a = new byte[1];
    public TlsProtocol b;

    public o(TlsProtocol tlsProtocol) {
        this.b = tlsProtocol;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.b.writeData(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.a;
        bArr[0] = (byte) i;
        this.b.writeData(bArr, 0, 1);
    }
}
