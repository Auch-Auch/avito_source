package x6.e.b.e;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.tls.TlsContext;
import org.spongycastle.crypto.tls.TlsFatalAlert;
import org.spongycastle.crypto.tls.TlsHandshakeHash;
import org.spongycastle.crypto.tls.TlsUtils;
import org.spongycastle.util.Integers;
import x6.e.b.e.e;
public class g {
    public f a;
    public TlsHandshakeHash b;
    public Hashtable c = new Hashtable();
    public Hashtable d = null;
    public Vector e = new Vector();
    public boolean f = true;
    public int g = 0;
    public int h = 0;

    public class a implements d {
        public a() {
        }
    }

    public static class b {
        public final int a;
        public final short b;
        public final byte[] c;

        public b(int i, short s, byte[] bArr, a aVar) {
            this.a = i;
            this.b = s;
            this.c = bArr;
        }
    }

    public static class c extends ByteArrayOutputStream {
        public c(int i) {
            super(i);
        }

        public void a(f fVar) throws IOException {
            fVar.send(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
            ((ByteArrayOutputStream) this).buf = null;
        }
    }

    public g(TlsContext tlsContext, f fVar) {
        this.a = fVar;
        i iVar = new i();
        this.b = iVar;
        iVar.a = tlsContext;
    }

    public static void h(Hashtable hashtable) {
        Enumeration elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            e eVar = (e) elements.nextElement();
            eVar.c.removeAllElements();
            eVar.c.addElement(new e.a(0, eVar.b.length));
        }
    }

    public final void a() {
        Enumeration keys = this.c.keys();
        while (keys.hasMoreElements()) {
            ((Integer) keys.nextElement()).intValue();
        }
    }

    public void b() {
        a aVar;
        c cVar;
        c cVar2;
        if (!this.f) {
            a();
        } else {
            h(this.c);
            Hashtable hashtable = this.c;
            this.d = hashtable;
            this.c = null;
            if (hashtable != null) {
                aVar = new a();
                f fVar = this.a;
                cVar = fVar.m;
                cVar2 = fVar.k;
                if (cVar != cVar2 || fVar.n == cVar2) {
                    throw new IllegalStateException();
                }
                if (aVar != null) {
                    fVar.o = aVar;
                    fVar.p = cVar2;
                    fVar.q = System.currentTimeMillis() + 240000;
                }
                fVar.i = false;
                fVar.k = fVar.l;
                fVar.l = null;
                return;
            }
        }
        aVar = null;
        f fVar = this.a;
        cVar = fVar.m;
        cVar2 = fVar.k;
        if (cVar != cVar2) {
        }
        throw new IllegalStateException();
    }

    public final b c() throws IOException {
        e eVar = (e) this.c.get(Integers.valueOf(this.h));
        if (eVar != null) {
            byte[] bArr = eVar.c.isEmpty() ? eVar.b : null;
            if (bArr != null) {
                this.d = null;
                int i = this.h;
                this.h = i + 1;
                b bVar = new b(i, eVar.a, bArr, null);
                j(bVar);
                return bVar;
            }
        }
        return null;
    }

    public final boolean d(int i, int i2, byte[] bArr, int i3, int i4) throws IOException {
        boolean z;
        byte[] bArr2;
        int readUint24;
        int readUint242;
        e eVar;
        boolean z2 = false;
        int i5 = i3;
        int i6 = i4;
        boolean z3 = false;
        while (i6 >= 12 && i6 >= (readUint242 = (readUint24 = TlsUtils.readUint24(bArr, i5 + 9)) + 12)) {
            int readUint243 = TlsUtils.readUint24(bArr, i5 + 1);
            int readUint244 = TlsUtils.readUint24(bArr, i5 + 6);
            if (readUint244 + readUint24 > readUint243) {
                break;
            }
            short readUint8 = TlsUtils.readUint8(bArr, i5 + 0);
            if (i2 != (readUint8 == 20 ? 1 : 0)) {
                break;
            }
            int readUint16 = TlsUtils.readUint16(bArr, i5 + 4);
            int i7 = this.h;
            if (readUint16 < i7 + i) {
                if (readUint16 >= i7) {
                    e eVar2 = (e) this.c.get(Integers.valueOf(readUint16));
                    if (eVar2 == null) {
                        eVar2 = new e(readUint8, readUint243);
                        this.c.put(Integers.valueOf(readUint16), eVar2);
                    }
                    eVar2.a(readUint8, readUint243, bArr, i5 + 12, readUint244, readUint24);
                } else {
                    Hashtable hashtable = this.d;
                    if (!(hashtable == null || (eVar = (e) hashtable.get(Integers.valueOf(readUint16))) == null)) {
                        eVar.a(readUint8, readUint243, bArr, i5 + 12, readUint244, readUint24);
                        z3 = true;
                    }
                }
            }
            i5 += readUint242;
            i6 -= readUint242;
        }
        if (z3) {
            Enumeration elements = this.d.elements();
            while (true) {
                if (!elements.hasMoreElements()) {
                    z = true;
                    break;
                }
                e eVar3 = (e) elements.nextElement();
                if (eVar3.c.isEmpty()) {
                    bArr2 = eVar3.b;
                    continue;
                } else {
                    bArr2 = null;
                    continue;
                }
                if (bArr2 == null) {
                    z = false;
                    break;
                }
            }
            if (z) {
                z2 = true;
            }
        }
        if (z2) {
            g();
            h(this.d);
        }
        return z2;
    }

    public b e() throws IOException {
        if (this.f) {
            this.f = false;
            Hashtable hashtable = new Hashtable();
            h(this.c);
            this.d = this.c;
            this.c = hashtable;
        }
        byte[] bArr = null;
        int i = 1000;
        while (true) {
            try {
                b c2 = c();
                if (c2 != null) {
                    return c2;
                }
                int receiveLimit = this.a.getReceiveLimit();
                if (bArr == null || bArr.length < receiveLimit) {
                    bArr = new byte[receiveLimit];
                }
                int receive = this.a.receive(bArr, 0, receiveLimit, i);
                if (receive < 0) {
                    g();
                    i = Math.min(i * 2, 60000);
                } else if (d(16, this.a.m.b, bArr, 0, receive)) {
                    i = Math.min(i * 2, 60000);
                }
            } catch (IOException unused) {
            }
        }
    }

    public byte[] f(short s) throws IOException {
        b e2 = e();
        if (e2.b == s) {
            return e2.c;
        }
        throw new TlsFatalAlert(10);
    }

    public final void g() throws IOException {
        f fVar = this.a;
        c cVar = fVar.p;
        if (cVar != null) {
            fVar.n = cVar;
        } else {
            fVar.n = fVar.k;
        }
        for (int i = 0; i < this.e.size(); i++) {
            k((b) this.e.elementAt(i));
        }
    }

    public void i(short s, byte[] bArr) throws IOException {
        TlsUtils.checkUint24(bArr.length);
        if (!this.f) {
            a();
            this.f = true;
            this.e.removeAllElements();
        }
        int i = this.g;
        this.g = i + 1;
        b bVar = new b(i, s, bArr, null);
        this.e.addElement(bVar);
        k(bVar);
        j(bVar);
    }

    public final b j(b bVar) throws IOException {
        short s = bVar.b;
        if (s != 0) {
            byte[] bArr = bVar.c;
            byte[] bArr2 = new byte[12];
            TlsUtils.writeUint8(s, bArr2, 0);
            TlsUtils.writeUint24(bArr.length, bArr2, 1);
            TlsUtils.writeUint16(bVar.a, bArr2, 4);
            TlsUtils.writeUint24(0, bArr2, 6);
            TlsUtils.writeUint24(bArr.length, bArr2, 9);
            this.b.update(bArr2, 0, 12);
            this.b.update(bArr, 0, bArr.length);
        }
        return bVar;
    }

    public final void k(b bVar) throws IOException {
        int sendLimit = this.a.getSendLimit() - 12;
        if (sendLimit >= 1) {
            int length = bVar.c.length;
            int i = 0;
            do {
                int min = Math.min(length - i, sendLimit);
                c cVar = new c(min + 12);
                TlsUtils.writeUint8(bVar.b, (OutputStream) cVar);
                TlsUtils.writeUint24(bVar.c.length, cVar);
                TlsUtils.writeUint16(bVar.a, cVar);
                TlsUtils.writeUint24(i, cVar);
                TlsUtils.writeUint24(min, cVar);
                cVar.write(bVar.c, i, min);
                cVar.a(this.a);
                i += min;
            } while (i < length);
            return;
        }
        throw new TlsFatalAlert(80);
    }
}
