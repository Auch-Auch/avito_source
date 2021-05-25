package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;
public class PSSSignatureSpi extends SignatureSpi {
    public final JcaJceHelper a;
    public AlgorithmParameters b;
    public PSSParameterSpec c;
    public PSSParameterSpec d;
    public AsymmetricBlockCipher e;
    public Digest f;
    public Digest g;
    public int h;
    public byte i;
    public boolean j;
    public PSSSigner k;

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384), 48, 1));
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(SPHINCS256KeyGenParameterSpec.SHA3_256, "MGF1", new MGF1ParameterSpec(SPHINCS256KeyGenParameterSpec.SHA3_256), 32, 1));
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA512, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA512), 64, 1));
        }
    }

    public class a implements Digest {
        public ByteArrayOutputStream a = new ByteArrayOutputStream();
        public Digest b;
        public boolean c = true;

        public a(PSSSignatureSpi pSSSignatureSpi, Digest digest) {
            this.b = digest;
        }

        @Override // org.spongycastle.crypto.Digest
        public int doFinal(byte[] bArr, int i) {
            byte[] byteArray = this.a.toByteArray();
            if (this.c) {
                System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
            } else {
                this.b.update(byteArray, 0, byteArray.length);
                this.b.doFinal(bArr, i);
            }
            reset();
            this.c = !this.c;
            return byteArray.length;
        }

        @Override // org.spongycastle.crypto.Digest
        public String getAlgorithmName() {
            return "NULL";
        }

        @Override // org.spongycastle.crypto.Digest
        public int getDigestSize() {
            return this.b.getDigestSize();
        }

        @Override // org.spongycastle.crypto.Digest
        public void reset() {
            this.a.reset();
            this.b.reset();
        }

        @Override // org.spongycastle.crypto.Digest
        public void update(byte b2) {
            this.a.write(b2);
        }

        @Override // org.spongycastle.crypto.Digest
        public void update(byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new RSABlindedEngine(), null, true);
        }
    }

    public PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec) {
        this(asymmetricBlockCipher, pSSParameterSpec, false);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.b == null && this.c != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.a.createAlgorithmParameters("PSS");
                this.b = createAlgorithmParameters;
                createAlgorithmParameters.init(this.c);
            } catch (Exception e2) {
                throw new RuntimeException(e2.toString());
            }
        }
        return this.b;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            PSSSigner pSSSigner = new PSSSigner(this.e, this.f, this.g, this.h, this.i);
            this.k = pSSSigner;
            pSSSigner.init(true, new ParametersWithRandom(RSAUtil.b((RSAPrivateKey) privateKey), secureRandom));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            PSSSigner pSSSigner = new PSSSigner(this.e, this.f, this.g, this.h, this.i);
            this.k = pSSSigner;
            pSSSigner.init(false, RSAUtil.c((RSAPublicKey) publicKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
            PSSParameterSpec pSSParameterSpec2 = this.d;
            if (pSSParameterSpec2 != null && !DigestFactory.isSameDigest(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                StringBuilder L = a2.b.a.a.a.L("parameter must be using ");
                L.append(this.d.getDigestAlgorithm());
                throw new InvalidAlgorithmParameterException(L.toString());
            } else if (!pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !pSSParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId())) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            } else if (pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                if (DigestFactory.isSameDigest(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    Digest digest = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
                    if (digest != null) {
                        this.b = null;
                        this.c = pSSParameterSpec;
                        this.g = digest;
                        this.h = pSSParameterSpec.getSaltLength();
                        if (this.c.getTrailerField() == 1) {
                            this.i = PSSSigner.TRAILER_IMPLICIT;
                            if (this.j) {
                                this.f = new a(this, this.g);
                            } else {
                                this.f = this.g;
                            }
                        } else {
                            throw new IllegalArgumentException("unknown trailer field");
                        }
                    } else {
                        StringBuilder L2 = a2.b.a.a.a.L("no match on MGF digest algorithm: ");
                        L2.append(mGF1ParameterSpec.getDigestAlgorithm());
                        throw new InvalidAlgorithmParameterException(L2.toString());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
                }
            } else {
                throw new InvalidAlgorithmParameterException("unknown MGF parameters");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
        }
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.k.generateSignature();
        } catch (CryptoException e2) {
            throw new SignatureException(e2.getMessage());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b2) throws SignatureException {
        this.k.update(b2);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.k.verifySignature(bArr);
    }

    public PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec, boolean z) {
        this.a = new BCJcaJceHelper();
        this.e = asymmetricBlockCipher;
        this.d = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.c = PSSParameterSpec.DEFAULT;
        } else {
            this.c = pSSParameterSpec;
        }
        this.g = DigestFactory.getDigest(this.c.getDigestAlgorithm());
        this.h = this.c.getSaltLength();
        if (this.c.getTrailerField() == 1) {
            this.i = PSSSigner.TRAILER_IMPLICIT;
            this.j = z;
            if (z) {
                this.f = new a(this, this.g);
            } else {
                this.f = this.g;
            }
        } else {
            throw new IllegalArgumentException("unknown trailer field");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i2, int i3) throws SignatureException {
        this.k.update(bArr, i2, i3);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            PSSSigner pSSSigner = new PSSSigner(this.e, this.f, this.g, this.h, this.i);
            this.k = pSSSigner;
            pSSSigner.init(true, RSAUtil.b((RSAPrivateKey) privateKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
