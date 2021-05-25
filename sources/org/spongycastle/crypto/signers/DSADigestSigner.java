package org.spongycastle.crypto.signers;

import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
public class DSADigestSigner implements Signer {
    public final Digest a;
    public final DSA b;
    public boolean c;

    public DSADigestSigner(DSA dsa, Digest digest) {
        this.a = digest;
        this.b = dsa;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.c) {
            byte[] bArr = new byte[this.a.getDigestSize()];
            this.a.doFinal(bArr, 0);
            BigInteger[] generateSignature = this.b.generateSignature(bArr);
            try {
                BigInteger bigInteger = generateSignature[0];
                BigInteger bigInteger2 = generateSignature[1];
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(new ASN1Integer(bigInteger));
                aSN1EncodableVector.add(new ASN1Integer(bigInteger2));
                return new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
            } catch (IOException unused) {
                throw new IllegalStateException("unable to encode signature");
            }
        } else {
            throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.b.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        if (!this.c) {
            byte[] bArr2 = new byte[this.a.getDigestSize()];
            this.a.doFinal(bArr2, 0);
            try {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.fromByteArray(bArr);
                BigInteger[] bigIntegerArr = {((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue(), ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getValue()};
                return this.b.verifySignature(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
            } catch (IOException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("DSADigestSigner not initialised for verification");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
