package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class TlsStreamCipher implements TlsCipher {
    public TlsContext context;
    public StreamCipher decryptCipher;
    public StreamCipher encryptCipher;
    public TlsMac readMac;
    public boolean usesNonce;
    public TlsMac writeMac;

    public TlsStreamCipher(TlsContext tlsContext, StreamCipher streamCipher, StreamCipher streamCipher2, Digest digest, Digest digest2, int i, boolean z) throws IOException {
        boolean isServer = tlsContext.isServer();
        this.context = tlsContext;
        this.usesNonce = z;
        this.encryptCipher = streamCipher;
        this.decryptCipher = streamCipher2;
        int digestSize = digest2.getDigestSize() + digest.getDigestSize() + (i * 2);
        byte[] b = TlsUtils.b(tlsContext, digestSize);
        TlsMac tlsMac = new TlsMac(tlsContext, digest, b, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = new TlsMac(tlsContext, digest2, b, digestSize2, digest2.getDigestSize());
        int digestSize3 = digest2.getDigestSize() + digestSize2;
        CipherParameters keyParameter = new KeyParameter(b, digestSize3, i);
        int i2 = digestSize3 + i;
        CipherParameters keyParameter2 = new KeyParameter(b, i2, i);
        if (i2 + i == digestSize) {
            if (isServer) {
                this.writeMac = tlsMac2;
                this.readMac = tlsMac;
                this.encryptCipher = streamCipher2;
                this.decryptCipher = streamCipher;
                keyParameter2 = keyParameter;
                keyParameter = keyParameter2;
            } else {
                this.writeMac = tlsMac;
                this.readMac = tlsMac2;
                this.encryptCipher = streamCipher;
                this.decryptCipher = streamCipher2;
            }
            if (z) {
                byte[] bArr = new byte[8];
                CipherParameters parametersWithIV = new ParametersWithIV(keyParameter, bArr);
                keyParameter2 = new ParametersWithIV(keyParameter2, bArr);
                keyParameter = parametersWithIV;
            }
            this.encryptCipher.init(true, keyParameter);
            this.decryptCipher.init(false, keyParameter2);
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public void checkMAC(long j, short s, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws IOException {
        if (!Arrays.constantTimeAreEqual(Arrays.copyOfRange(bArr, i, i2), this.readMac.calculateMac(j, s, bArr2, i3, i4))) {
            throw new TlsFatalAlert(20);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        if (this.usesNonce) {
            updateIV(this.decryptCipher, false, j);
        }
        int size = this.readMac.getSize();
        if (i2 >= size) {
            int i3 = i2 - size;
            byte[] bArr2 = new byte[i2];
            this.decryptCipher.processBytes(bArr, i, i2, bArr2, 0);
            checkMAC(j, s, bArr2, i3, i2, bArr2, 0, i3);
            return Arrays.copyOfRange(bArr2, 0, i3);
        }
        throw new TlsFatalAlert(50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j, short s, byte[] bArr, int i, int i2) {
        if (this.usesNonce) {
            updateIV(this.encryptCipher, true, j);
        }
        byte[] bArr2 = new byte[(this.writeMac.getSize() + i2)];
        this.encryptCipher.processBytes(bArr, i, i2, bArr2, 0);
        byte[] calculateMac = this.writeMac.calculateMac(j, s, bArr, i, i2);
        this.encryptCipher.processBytes(calculateMac, 0, calculateMac.length, bArr2, i2);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i) {
        return i - this.writeMac.getSize();
    }

    public void updateIV(StreamCipher streamCipher, boolean z, long j) {
        byte[] bArr = new byte[8];
        TlsUtils.writeUint64(j, bArr, 0);
        streamCipher.init(z, new ParametersWithIV(null, bArr));
    }
}
