package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;
public class HeartbeatMessage {
    public int paddingLength;
    public byte[] payload;
    public short type;

    public static class a extends ByteArrayOutputStream {
        public byte[] a(int i) {
            if (((ByteArrayOutputStream) this).count < i + 16) {
                return null;
            }
            return Arrays.copyOf(((ByteArrayOutputStream) this).buf, i);
        }
    }

    public HeartbeatMessage(short s, byte[] bArr, int i) {
        if (!HeartbeatMessageType.isValid(s)) {
            throw new IllegalArgumentException("'type' is not a valid HeartbeatMessageType value");
        } else if (bArr == null || bArr.length >= 65536) {
            throw new IllegalArgumentException("'payload' must have length < 2^16");
        } else if (i >= 16) {
            this.type = s;
            this.payload = bArr;
            this.paddingLength = i;
        } else {
            throw new IllegalArgumentException("'paddingLength' must be at least 16");
        }
    }

    public static HeartbeatMessage parse(InputStream inputStream) throws IOException {
        short readUint8 = TlsUtils.readUint8(inputStream);
        if (HeartbeatMessageType.isValid(readUint8)) {
            int readUint16 = TlsUtils.readUint16(inputStream);
            a aVar = new a();
            Streams.pipeAll(inputStream, aVar);
            byte[] a3 = aVar.a(readUint16);
            if (a3 == null) {
                return null;
            }
            return new HeartbeatMessage(readUint8, a3, aVar.size() - a3.length);
        }
        throw new TlsFatalAlert(47);
    }

    public void encode(TlsContext tlsContext, OutputStream outputStream) throws IOException {
        TlsUtils.writeUint8(this.type, outputStream);
        TlsUtils.checkUint16(this.payload.length);
        TlsUtils.writeUint16(this.payload.length, outputStream);
        outputStream.write(this.payload);
        byte[] bArr = new byte[this.paddingLength];
        tlsContext.getNonceRandomGenerator().nextBytes(bArr);
        outputStream.write(bArr);
    }
}
