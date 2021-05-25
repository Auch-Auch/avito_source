package x6.e.b.e;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.crypto.tls.TlsProtocol;
public class n extends InputStream {
    public byte[] a = new byte[1];
    public TlsProtocol b = null;

    public n(TlsProtocol tlsProtocol) {
        this.b = tlsProtocol;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.b.applicationDataAvailable();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.b.readApplicationData(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.a) < 0) {
            return -1;
        }
        return this.a[0] & 255;
    }
}
