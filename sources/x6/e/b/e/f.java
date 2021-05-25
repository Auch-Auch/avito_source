package x6.e.b.e;

import java.io.IOException;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.tls.ByteQueue;
import org.spongycastle.crypto.tls.DatagramTransport;
import org.spongycastle.crypto.tls.ProtocolVersion;
import org.spongycastle.crypto.tls.TlsCipher;
import org.spongycastle.crypto.tls.TlsContext;
import org.spongycastle.crypto.tls.TlsFatalAlert;
import org.spongycastle.crypto.tls.TlsNullCipher;
import org.spongycastle.crypto.tls.TlsPeer;
import org.spongycastle.crypto.tls.TlsUtils;
public class f implements DatagramTransport {
    public final DatagramTransport a;
    public final TlsContext b;
    public final TlsPeer c;
    public final ByteQueue d = new ByteQueue();
    public volatile boolean e = false;
    public volatile boolean f = false;
    public volatile ProtocolVersion g = null;
    public volatile ProtocolVersion h = null;
    public volatile boolean i;
    public volatile int j;
    public c k;
    public c l;
    public c m;
    public c n;
    public d o = null;
    public c p = null;
    public long q = 0;

    public f(DatagramTransport datagramTransport, TlsContext tlsContext, TlsPeer tlsPeer) {
        this.a = datagramTransport;
        this.b = tlsContext;
        this.c = tlsPeer;
        this.i = true;
        c cVar = new c(0, new TlsNullCipher(tlsContext));
        this.k = cVar;
        this.l = null;
        this.m = cVar;
        this.n = cVar;
        this.j = 16384;
    }

    public final void a() {
        if (!this.e) {
            try {
                if (!this.f) {
                    d(1, 0, null, null);
                }
                this.a.close();
            } catch (Exception unused) {
            }
            this.e = true;
        }
    }

    public void b(short s) {
        if (!this.e) {
            try {
                d(2, s, null, null);
            } catch (Exception unused) {
            }
            this.f = true;
            a();
        }
    }

    public void c(TlsCipher tlsCipher) {
        if (this.l == null) {
            this.l = new c(this.n.b + 1, tlsCipher);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void close() throws IOException {
        if (!this.e) {
            if (this.i) {
                d(1, 90, "User canceled handshake", null);
            }
            a();
        }
    }

    public final void d(short s, short s2, String str, Throwable th) throws IOException {
        this.c.notifyAlertRaised(s, s2, str, null);
        f(21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    public final int e(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int readUint16;
        int i5;
        if (this.d.available() > 0) {
            if (this.d.available() >= 13) {
                byte[] bArr2 = new byte[2];
                this.d.read(bArr2, 0, 2, 11);
                i5 = TlsUtils.readUint16(bArr2, 0);
            } else {
                i5 = 0;
            }
            int min = Math.min(this.d.available(), i5 + 13);
            this.d.removeData(bArr, i2, min, 0);
            return min;
        }
        int receive = this.a.receive(bArr, i2, i3, i4);
        if (receive < 13 || receive <= (readUint16 = TlsUtils.readUint16(bArr, i2 + 11) + 13)) {
            return receive;
        }
        this.d.addData(bArr, i2 + readUint16, receive - readUint16);
        return readUint16;
    }

    public final void f(short s, byte[] bArr, int i2, int i3) throws IOException {
        if (this.h != null) {
            if (i3 > this.j) {
                throw new TlsFatalAlert(80);
            } else if (i3 >= 1 || s == 23) {
                c cVar = this.n;
                int i4 = cVar.b;
                long j2 = cVar.d;
                cVar.d = 1 + j2;
                byte[] encodePlaintext = cVar.c.encodePlaintext(((((long) i4) & BodyPartID.bodyIdMax) << 48) | j2, s, bArr, i2, i3);
                int length = encodePlaintext.length + 13;
                byte[] bArr2 = new byte[length];
                TlsUtils.writeUint8(s, bArr2, 0);
                TlsUtils.writeVersion(this.h, bArr2, 1);
                TlsUtils.writeUint16(i4, bArr2, 3);
                TlsUtils.writeUint48(j2, bArr2, 5);
                TlsUtils.writeUint16(encodePlaintext.length, bArr2, 11);
                System.arraycopy(encodePlaintext, 0, bArr2, 13, encodePlaintext.length);
                this.a.send(bArr2, 0, length);
            } else {
                throw new TlsFatalAlert(80);
            }
        }
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getReceiveLimit() throws IOException {
        return Math.min(this.j, this.m.c.getPlaintextLimit(this.a.getReceiveLimit() - 13));
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getSendLimit() throws IOException {
        return Math.min(this.j, this.n.c.getPlaintextLimit(this.a.getSendLimit() - 13));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:126:0x01b2 */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [x6.e.b.e.d, x6.e.b.e.c] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009f, code lost:
        if ((r3.b & (1 << ((int) r7))) != 0) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e A[Catch:{ IOException -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f A[Catch:{ IOException -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6 A[Catch:{ IOException -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a7 A[Catch:{ IOException -> 0x01ae }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.spongycastle.crypto.tls.DatagramTransport
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int receive(byte[] r23, int r24, int r25, int r26) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 468
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.e.b.e.f.receive(byte[], int, int, int):int");
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void send(byte[] bArr, int i2, int i3) throws IOException {
        short s;
        if (this.i || this.n == this.p) {
            s = 22;
            if (TlsUtils.readUint8(bArr, i2) == 20) {
                c cVar = null;
                if (this.i) {
                    cVar = this.l;
                } else if (this.n == this.p) {
                    cVar = this.k;
                }
                if (cVar != null) {
                    f(20, new byte[]{1}, 0, 1);
                    this.n = cVar;
                } else {
                    throw new IllegalStateException();
                }
            }
        } else {
            s = 23;
        }
        f(s, bArr, i2, i3);
    }
}
