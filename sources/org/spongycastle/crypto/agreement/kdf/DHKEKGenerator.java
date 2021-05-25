package org.spongycastle.crypto.agreement.kdf;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.util.Pack;
public class DHKEKGenerator implements DerivationFunction {
    public final Digest a;
    public ASN1ObjectIdentifier b;
    public int c;
    public byte[] d;
    public byte[] e;

    public DHKEKGenerator(Digest digest) {
        this.a = digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i2 >= i) {
            long j = (long) i2;
            int digestSize = this.a.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.a.getDigestSize()];
                int i4 = 0;
                int i5 = 0;
                int i6 = 1;
                while (i5 < i3) {
                    Digest digest = this.a;
                    byte[] bArr3 = this.d;
                    digest.update(bArr3, i4, bArr3.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.b);
                    aSN1EncodableVector2.add(new DEROctetString(Pack.intToBigEndian(i6)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr4 = this.e;
                    if (bArr4 != null) {
                        aSN1EncodableVector.add(new DERTaggedObject(true, i4, new DEROctetString(bArr4)));
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.c))));
                    try {
                        byte[] encoded = new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
                        this.a.update(encoded, 0, encoded.length);
                        this.a.doFinal(bArr2, 0);
                        if (i2 > digestSize) {
                            System.arraycopy(bArr2, 0, bArr, i, digestSize);
                            i += digestSize;
                            i2 -= digestSize;
                        } else {
                            System.arraycopy(bArr2, 0, bArr, i, i2);
                        }
                        i6++;
                        i5++;
                        i4 = 0;
                    } catch (IOException e2) {
                        throw new IllegalArgumentException(a.A2(e2, a.L("unable to encode parameter info: ")));
                    }
                }
                this.a.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.b = dHKDFParameters.getAlgorithm();
        this.c = dHKDFParameters.getKeySize();
        this.d = dHKDFParameters.getZ();
        this.e = dHKDFParameters.getExtraInfo();
    }
}
