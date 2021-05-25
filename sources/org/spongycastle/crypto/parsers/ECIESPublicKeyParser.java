package org.spongycastle.crypto.parsers;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.util.io.Streams;
public class ECIESPublicKeyParser implements KeyParser {
    public ECDomainParameters a;

    public ECIESPublicKeyParser(ECDomainParameters eCDomainParameters) {
        this.a = eCDomainParameters;
    }

    @Override // org.spongycastle.crypto.KeyParser
    public AsymmetricKeyParameter readKey(InputStream inputStream) throws IOException {
        byte[] bArr;
        int read = inputStream.read();
        if (read != 0) {
            if (read == 2 || read == 3) {
                bArr = new byte[(((this.a.getCurve().getFieldSize() + 7) / 8) + 1)];
            } else if (read == 4 || read == 6 || read == 7) {
                bArr = new byte[((((this.a.getCurve().getFieldSize() + 7) / 8) * 2) + 1)];
            } else {
                StringBuilder L = a.L("Sender's public key has invalid point encoding 0x");
                L.append(Integer.toString(read, 16));
                throw new IOException(L.toString());
            }
            bArr[0] = (byte) read;
            Streams.readFully(inputStream, bArr, 1, bArr.length - 1);
            return new ECPublicKeyParameters(this.a.getCurve().decodePoint(bArr), this.a);
        }
        throw new IOException("Sender's public key invalid.");
    }
}
