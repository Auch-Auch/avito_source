package org.spongycastle.pqc.jcajce.provider.xmss;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHAKEDigest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTSigner;
import org.spongycastle.pqc.jcajce.interfaces.StateAwareSignature;
public class XMSSMTSignatureSpi extends Signature implements StateAwareSignature {
    public Digest a;
    public XMSSMTSigner b;
    public ASN1ObjectIdentifier c;
    public SecureRandom d;

    public static class withSha256 extends XMSSMTSignatureSpi {
        public withSha256() {
            super("SHA256withXMSSMT", new SHA256Digest(), new XMSSMTSigner());
        }
    }

    public static class withSha512 extends XMSSMTSignatureSpi {
        public withSha512() {
            super("SHA512withXMSSMT", new SHA512Digest(), new XMSSMTSigner());
        }
    }

    public static class withShake128 extends XMSSMTSignatureSpi {
        public withShake128() {
            super("SHAKE128withXMSSMT", new SHAKEDigest(128), new XMSSMTSigner());
        }
    }

    public static class withShake256 extends XMSSMTSignatureSpi {
        public withShake256() {
            super("SHAKE256withXMSSMT", new SHAKEDigest(256), new XMSSMTSigner());
        }
    }

    public XMSSMTSignatureSpi(String str) {
        super(str);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.d = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCXMSSMTPublicKey) {
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = ((BCXMSSMTPublicKey) publicKey).b;
            this.c = null;
            this.a.reset();
            this.b.init(false, xMSSMTPublicKeyParameters);
            return;
        }
        throw new InvalidKeyException("unknown public key passed to XMSSMT");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.b.generateSignature(AppCompatDelegateImpl.i.y0(this.a));
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage());
            }
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b2) throws SignatureException {
        this.a.update(b2);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.b.verifySignature(AppCompatDelegateImpl.i.y0(this.a), bArr);
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.StateAwareSignature
    public PrivateKey getUpdatedPrivateKey() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.c;
        if (aSN1ObjectIdentifier != null) {
            BCXMSSMTPrivateKey bCXMSSMTPrivateKey = new BCXMSSMTPrivateKey(aSN1ObjectIdentifier, (XMSSMTPrivateKeyParameters) this.b.getUpdatedPrivateKey());
            this.c = null;
            return bCXMSSMTPrivateKey;
        }
        throw new IllegalStateException("signature object not in a signing state");
    }

    public XMSSMTSignatureSpi(String str, Digest digest, XMSSMTSigner xMSSMTSigner) {
        super(str);
        this.a = digest;
        this.b = xMSSMTSigner;
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.a.update(bArr, i, i2);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCXMSSMTPrivateKey) {
            BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) privateKey;
            CipherParameters cipherParameters = bCXMSSMTPrivateKey.b;
            this.c = bCXMSSMTPrivateKey.a;
            SecureRandom secureRandom = this.d;
            if (secureRandom != null) {
                cipherParameters = new ParametersWithRandom(cipherParameters, secureRandom);
            }
            this.a.reset();
            this.b.init(true, cipherParameters);
            return;
        }
        throw new InvalidKeyException("unknown private key passed to XMSSMT");
    }
}
