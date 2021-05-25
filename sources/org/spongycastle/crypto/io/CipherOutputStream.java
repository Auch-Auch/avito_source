package org.spongycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.modes.AEADBlockCipher;
public class CipherOutputStream extends FilterOutputStream {
    public BufferedBlockCipher a;
    public StreamCipher b;
    public AEADBlockCipher c;
    public final byte[] d;
    public byte[] e;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(outputStream);
        this.d = new byte[1];
        this.a = bufferedBlockCipher;
    }

    public final void a(int i, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher = this.a;
            if (bufferedBlockCipher != null) {
                i = bufferedBlockCipher.getOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher = this.c;
                if (aEADBlockCipher != null) {
                    i = aEADBlockCipher.getOutputSize(i);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher2 = this.a;
            if (bufferedBlockCipher2 != null) {
                i = bufferedBlockCipher2.getUpdateOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.c;
                if (aEADBlockCipher2 != null) {
                    i = aEADBlockCipher2.getUpdateOutputSize(i);
                }
            }
        }
        byte[] bArr = this.e;
        if (bArr == null || bArr.length < i) {
            this.e = new byte[i];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            r4.a(r0, r1)
            org.spongycastle.crypto.BufferedBlockCipher r1 = r4.a     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0019
            byte[] r2 = r4.e     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            int r1 = r1.doFinal(r2, r0)     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0034
            java.io.OutputStream r2 = r4.out     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            byte[] r3 = r4.e     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            r2.write(r3, r0, r1)     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            goto L_0x0034
        L_0x0019:
            org.spongycastle.crypto.modes.AEADBlockCipher r1 = r4.c     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            if (r1 == 0) goto L_0x002d
            byte[] r2 = r4.e     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            int r1 = r1.doFinal(r2, r0)     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0034
            java.io.OutputStream r2 = r4.out     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            byte[] r3 = r4.e     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            r2.write(r3, r0, r1)     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            goto L_0x0034
        L_0x002d:
            org.spongycastle.crypto.StreamCipher r0 = r4.b     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            r0.reset()     // Catch:{ InvalidCipherTextException -> 0x003f, Exception -> 0x0036 }
        L_0x0034:
            r0 = 0
            goto L_0x0048
        L_0x0036:
            r0 = move-exception
            org.spongycastle.crypto.io.CipherIOException r1 = new org.spongycastle.crypto.io.CipherIOException
            java.lang.String r2 = "Error closing stream: "
            r1.<init>(r2, r0)
            goto L_0x0047
        L_0x003f:
            r0 = move-exception
            org.spongycastle.crypto.io.InvalidCipherTextIOException r1 = new org.spongycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error finalising cipher data"
            r1.<init>(r2, r0)
        L_0x0047:
            r0 = r1
        L_0x0048:
            r4.flush()     // Catch:{ IOException -> 0x0051 }
            java.io.OutputStream r1 = r4.out     // Catch:{ IOException -> 0x0051 }
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r1 = move-exception
            if (r0 != 0) goto L_0x0055
            r0 = r1
        L_0x0055:
            if (r0 != 0) goto L_0x0058
            return
        L_0x0058:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.io.CipherOutputStream.close():void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.d;
        byte b2 = (byte) i;
        bArr[0] = b2;
        StreamCipher streamCipher = this.b;
        if (streamCipher != null) {
            ((FilterOutputStream) this).out.write(streamCipher.returnByte(b2));
        } else {
            write(bArr, 0, 1);
        }
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher) {
        super(outputStream);
        this.d = new byte[1];
        this.b = streamCipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        a(i2, false);
        BufferedBlockCipher bufferedBlockCipher = this.a;
        if (bufferedBlockCipher != null) {
            int processBytes = bufferedBlockCipher.processBytes(bArr, i, i2, this.e, 0);
            if (processBytes != 0) {
                ((FilterOutputStream) this).out.write(this.e, 0, processBytes);
                return;
            }
            return;
        }
        AEADBlockCipher aEADBlockCipher = this.c;
        if (aEADBlockCipher != null) {
            int processBytes2 = aEADBlockCipher.processBytes(bArr, i, i2, this.e, 0);
            if (processBytes2 != 0) {
                ((FilterOutputStream) this).out.write(this.e, 0, processBytes2);
                return;
            }
            return;
        }
        this.b.processBytes(bArr, i, i2, this.e, 0);
        ((FilterOutputStream) this).out.write(this.e, 0, i2);
    }

    public CipherOutputStream(OutputStream outputStream, AEADBlockCipher aEADBlockCipher) {
        super(outputStream);
        this.d = new byte[1];
        this.c = aEADBlockCipher;
    }
}
