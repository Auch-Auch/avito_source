package x6.e.b.e;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.tls.ProtocolVersion;
import org.spongycastle.crypto.tls.TlsCipher;
import org.spongycastle.crypto.tls.TlsCompression;
import org.spongycastle.crypto.tls.TlsContext;
import org.spongycastle.crypto.tls.TlsFatalAlert;
import org.spongycastle.crypto.tls.TlsHandshakeHash;
import org.spongycastle.crypto.tls.TlsNullCipher;
import org.spongycastle.crypto.tls.TlsNullCompression;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.crypto.tls.TlsUtils;
import org.spongycastle.util.io.SimpleOutputStream;
public class k {
    public TlsProtocol a;
    public InputStream b;
    public OutputStream c;
    public TlsCompression d = null;
    public TlsCompression e = null;
    public TlsCompression f = null;
    public TlsCipher g = null;
    public TlsCipher h = null;
    public TlsCipher i = null;
    public b j = new b(null);
    public b k = new b(null);
    public ByteArrayOutputStream l = new ByteArrayOutputStream();
    public TlsHandshakeHash m = null;
    public SimpleOutputStream n = new a();
    public ProtocolVersion o = null;
    public ProtocolVersion p = null;
    public boolean q = true;
    public int r;
    public int s;
    public int t;

    public class a extends SimpleOutputStream {
        public a() {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            k.this.m.update(bArr, i, i2);
        }
    }

    public static class b {
        public long a = 0;
        public boolean b = false;

        public b(a aVar) {
        }

        public synchronized long a(short s) throws TlsFatalAlert {
            long j;
            if (!this.b) {
                j = this.a;
                long j2 = 1 + j;
                this.a = j2;
                if (j2 == 0) {
                    this.b = true;
                }
            } else {
                throw new TlsFatalAlert(s);
            }
            return j;
        }
    }

    public k(TlsProtocol tlsProtocol, InputStream inputStream, OutputStream outputStream) {
        this.a = tlsProtocol;
        this.b = inputStream;
        this.c = outputStream;
        TlsNullCompression tlsNullCompression = new TlsNullCompression();
        this.e = tlsNullCompression;
        this.f = tlsNullCompression;
    }

    public static void a(int i2, int i3, short s2) throws IOException {
        if (i2 > i3) {
            throw new TlsFatalAlert(s2);
        }
    }

    public static void c(short s2, short s3) throws IOException {
        switch (s2) {
            case 20:
            case 21:
            case 22:
            case 23:
                return;
            default:
                throw new TlsFatalAlert(s3);
        }
    }

    public void b(byte[] bArr) throws IOException {
        c(TlsUtils.readUint8(bArr, 0), 10);
        if (this.q) {
            ProtocolVersion readVersion = TlsUtils.readVersion(bArr, 1);
            ProtocolVersion protocolVersion = this.o;
            if (protocolVersion != null && !readVersion.equals(protocolVersion)) {
                throw new TlsFatalAlert(47);
            }
        } else if ((TlsUtils.readVersionRaw(bArr, 1) & InputDeviceCompat.SOURCE_ANY) != 768) {
            throw new TlsFatalAlert(47);
        }
        a(TlsUtils.readUint16(bArr, 3), this.t, 22);
    }

    public void d(TlsContext tlsContext) {
        TlsNullCipher tlsNullCipher = new TlsNullCipher(tlsContext);
        this.h = tlsNullCipher;
        this.i = tlsNullCipher;
        i iVar = new i();
        this.m = iVar;
        iVar.a = tlsContext;
        this.r = 16384;
        this.s = 17408;
        this.t = 18432;
    }

    public boolean e() throws IOException {
        byte[] readAllOrNothing = TlsUtils.readAllOrNothing(5, this.b);
        if (readAllOrNothing == null) {
            return false;
        }
        short readUint8 = TlsUtils.readUint8(readAllOrNothing, 0);
        c(readUint8, 10);
        if (this.q) {
            ProtocolVersion readVersion = TlsUtils.readVersion(readAllOrNothing, 1);
            ProtocolVersion protocolVersion = this.o;
            if (protocolVersion == null) {
                this.o = readVersion;
            } else if (!readVersion.equals(protocolVersion)) {
                throw new TlsFatalAlert(47);
            }
        } else if ((TlsUtils.readVersionRaw(readAllOrNothing, 1) & InputDeviceCompat.SOURCE_ANY) != 768) {
            throw new TlsFatalAlert(47);
        }
        int readUint16 = TlsUtils.readUint16(readAllOrNothing, 3);
        a(readUint16, this.t, 22);
        byte[] readFully = TlsUtils.readFully(readUint16, this.b);
        byte[] decodeCiphertext = this.h.decodeCiphertext(this.j.a(10), readUint8, readFully, 0, readFully.length);
        a(decodeCiphertext.length, this.s, 22);
        OutputStream decompress = this.e.decompress(this.l);
        if (decompress != this.l) {
            decompress.write(decodeCiphertext, 0, decodeCiphertext.length);
            decompress.flush();
            decodeCiphertext = this.l.toByteArray();
            this.l.reset();
        }
        a(decodeCiphertext.length, this.r, 30);
        if (decodeCiphertext.length >= 1 || readUint8 == 23) {
            this.a.processRecord(readUint8, decodeCiphertext, 0, decodeCiphertext.length);
            return true;
        }
        throw new TlsFatalAlert(47);
    }

    public void f(short s2, byte[] bArr, int i2, int i3) throws IOException {
        byte[] bArr2;
        if (this.p != null) {
            c(s2, 80);
            a(i3, this.r, 80);
            if (i3 >= 1 || s2 == 23) {
                OutputStream compress = this.f.compress(this.l);
                long a3 = this.k.a(80);
                if (compress == this.l) {
                    bArr2 = this.i.encodePlaintext(a3, s2, bArr, i2, i3);
                } else {
                    compress.write(bArr, i2, i3);
                    compress.flush();
                    byte[] byteArray = this.l.toByteArray();
                    this.l.reset();
                    a(byteArray.length, i3 + 1024, 80);
                    bArr2 = this.i.encodePlaintext(a3, s2, byteArray, 0, byteArray.length);
                }
                a(bArr2.length, this.t, 80);
                byte[] bArr3 = new byte[(bArr2.length + 5)];
                TlsUtils.writeUint8(s2, bArr3, 0);
                TlsUtils.writeVersion(this.p, bArr3, 1);
                TlsUtils.writeUint16(bArr2.length, bArr3, 3);
                System.arraycopy(bArr2, 0, bArr3, 5, bArr2.length);
                this.c.write(bArr3);
                this.c.flush();
                return;
            }
            throw new TlsFatalAlert(80);
        }
    }
}
