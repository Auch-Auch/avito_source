package org.spongycastle.crypto.tls;

import java.io.IOException;
import x6.e.b.e.f;
public class DTLSTransport implements DatagramTransport {
    public final f a;

    public DTLSTransport(f fVar) {
        this.a = fVar;
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void close() throws IOException {
        this.a.close();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getReceiveLimit() throws IOException {
        return this.a.getReceiveLimit();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getSendLimit() throws IOException {
        return this.a.getSendLimit();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int receive(byte[] bArr, int i, int i2, int i3) throws IOException {
        try {
            return this.a.receive(bArr, i, i2, i3);
        } catch (TlsFatalAlert e) {
            this.a.b(e.getAlertDescription());
            throw e;
        } catch (IOException e2) {
            this.a.b(80);
            throw e2;
        } catch (RuntimeException e3) {
            this.a.b(80);
            throw new TlsFatalAlert(80, e3);
        }
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void send(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.a.send(bArr, i, i2);
        } catch (TlsFatalAlert e) {
            this.a.b(e.getAlertDescription());
            throw e;
        } catch (IOException e2) {
            this.a.b(80);
            throw e2;
        } catch (RuntimeException e3) {
            this.a.b(80);
            throw new TlsFatalAlert(80, e3);
        }
    }
}
