package org.spongycastle.crypto.agreement.kdf;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;
public class ECDHKEKGenerator implements DigestDerivationFunction {
    public DigestDerivationFunction a;
    public ASN1ObjectIdentifier b;
    public int c;
    public byte[] d;

    public ECDHKEKGenerator(Digest digest) {
        this.a = new KDF2BytesGenerator(digest);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new AlgorithmIdentifier(this.b, DERNull.INSTANCE));
        aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.c))));
        try {
            this.a.init(new KDFParameters(this.d, new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER)));
            return this.a.generateBytes(bArr, i, i2);
        } catch (IOException e) {
            throw new IllegalArgumentException(a.A2(e, a.L("unable to initialise kdf: ")));
        }
    }

    @Override // org.spongycastle.crypto.DigestDerivationFunction
    public Digest getDigest() {
        return this.a.getDigest();
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.b = dHKDFParameters.getAlgorithm();
        this.c = dHKDFParameters.getKeySize();
        this.d = dHKDFParameters.getZ();
    }
}
