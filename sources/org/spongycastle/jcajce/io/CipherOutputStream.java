package org.spongycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
public class CipherOutputStream extends FilterOutputStream {
    public final Cipher a;
    public final byte[] b = new byte[1];

    public CipherOutputStream(OutputStream outputStream, Cipher cipher) {
        super(outputStream);
        this.a = cipher;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r3 = this;
            javax.crypto.Cipher r0 = r3.a     // Catch:{ GeneralSecurityException -> 0x001c, Exception -> 0x000f }
            byte[] r0 = r0.doFinal()     // Catch:{ GeneralSecurityException -> 0x001c, Exception -> 0x000f }
            if (r0 == 0) goto L_0x000d
            java.io.OutputStream r1 = r3.out     // Catch:{ GeneralSecurityException -> 0x001c, Exception -> 0x000f }
            r1.write(r0)     // Catch:{ GeneralSecurityException -> 0x001c, Exception -> 0x000f }
        L_0x000d:
            r0 = 0
            goto L_0x0025
        L_0x000f:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Error closing stream: "
            java.lang.String r0 = a2.b.a.a.a.a3(r2, r0)
            r1.<init>(r0)
            goto L_0x0024
        L_0x001c:
            r0 = move-exception
            org.spongycastle.crypto.io.InvalidCipherTextIOException r1 = new org.spongycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error during cipher finalisation"
            r1.<init>(r2, r0)
        L_0x0024:
            r0 = r1
        L_0x0025:
            r3.flush()     // Catch:{ IOException -> 0x002e }
            java.io.OutputStream r1 = r3.out     // Catch:{ IOException -> 0x002e }
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r1 = move-exception
            if (r0 != 0) goto L_0x0032
            r0 = r1
        L_0x0032:
            if (r0 != 0) goto L_0x0035
            return
        L_0x0035:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.io.CipherOutputStream.close():void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] update = this.a.update(bArr, i, i2);
        if (update != null) {
            ((FilterOutputStream) this).out.write(update);
        }
    }
}
