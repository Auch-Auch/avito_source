package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.DHKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.parsers.DHIESPublicKeyParser;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.provider.util.BadBlockException;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Strings;
public class IESCipher extends CipherSpi {
    public final JcaJceHelper a = new BCJcaJceHelper();
    public final int b;
    public IESEngine c;
    public int d = -1;
    public ByteArrayOutputStream e = new ByteArrayOutputStream();
    public AlgorithmParameters f = null;
    public IESParameterSpec g = null;
    public AsymmetricKeyParameter h;
    public SecureRandom i;
    public AsymmetricKeyParameter j = null;

    public static class IES extends IESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1())));
        }
    }

    public static class IESwithAESCBC extends IESCipher {
        public IESwithAESCBC() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1()), new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()))), 16);
        }
    }

    public static class IESwithDESedeCBC extends IESCipher {
        public IESwithDESedeCBC() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1()), new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()))), 8);
        }
    }

    public class a implements KeyEncoder {
        public a(IESCipher iESCipher) {
        }

        @Override // org.spongycastle.crypto.KeyEncoder
        public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
            int bitLength = (((DHKeyParameters) asymmetricKeyParameter).getParameters().getP().bitLength() + 7) / 8;
            byte[] bArr = new byte[bitLength];
            byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(((DHPublicKeyParameters) asymmetricKeyParameter).getY());
            if (asUnsignedByteArray.length <= bitLength) {
                System.arraycopy(asUnsignedByteArray, 0, bArr, bitLength - asUnsignedByteArray.length, asUnsignedByteArray.length);
                return bArr;
            }
            throw new IllegalArgumentException("Senders's public key longer than expected.");
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.c = iESEngine;
        this.b = 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        if (i3 != 0) {
            this.e.write(bArr, i2, i3);
        }
        byte[] byteArray = this.e.toByteArray();
        this.e.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.g.getDerivationV(), this.g.getEncodingV(), this.g.getMacKeySize(), this.g.getCipherKeySize());
        if (this.g.getNonce() != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, this.g.getNonce());
        }
        DHParameters parameters = ((DHKeyParameters) this.h).getParameters();
        AsymmetricKeyParameter asymmetricKeyParameter = this.j;
        if (asymmetricKeyParameter != null) {
            try {
                int i4 = this.d;
                if (i4 != 1) {
                    if (i4 != 3) {
                        this.c.init(false, this.h, asymmetricKeyParameter, iESWithCipherParameters);
                        return this.c.processBlock(byteArray, 0, byteArray.length);
                    }
                }
                this.c.init(true, asymmetricKeyParameter, this.h, iESWithCipherParameters);
                return this.c.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e2) {
                throw new BadBlockException("unable to process block", e2);
            }
        } else {
            int i5 = this.d;
            if (i5 == 1 || i5 == 3) {
                DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
                dHKeyPairGenerator.init(new DHKeyGenerationParameters(this.i, parameters));
                try {
                    this.c.init(this.h, iESWithCipherParameters, new EphemeralKeyPairGenerator(dHKeyPairGenerator, new a(this)));
                    return this.c.processBlock(byteArray, 0, byteArray.length);
                } catch (Exception e3) {
                    throw new BadBlockException("unable to process block", e3);
                }
            } else if (i5 == 2 || i5 == 4) {
                try {
                    IESEngine iESEngine = this.c;
                    AsymmetricKeyParameter asymmetricKeyParameter2 = this.h;
                    iESEngine.init(asymmetricKeyParameter2, iESWithCipherParameters, new DHIESPublicKeyParser(((DHKeyParameters) asymmetricKeyParameter2).getParameters()));
                    return this.c.processBlock(byteArray, 0, byteArray.length);
                } catch (InvalidCipherTextException e4) {
                    throw new BadBlockException("unable to process block", e4);
                }
            } else {
                throw new IllegalStateException("IESCipher not initialised");
            }
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        if (this.c.getCipher() != null) {
            return this.c.getCipher().getBlockSize();
        }
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        IESParameterSpec iESParameterSpec = this.g;
        if (iESParameterSpec != null) {
            return iESParameterSpec.getNonce();
        }
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i2) {
        int size;
        if (this.h != null) {
            int macSize = this.c.getMac().getMacSize();
            int bitLength = this.j == null ? (((((DHKeyParameters) this.h).getParameters().getP().bitLength() + 7) * 2) / 8) + 1 : 0;
            if (this.c.getCipher() != null) {
                int i3 = this.d;
                if (i3 == 1 || i3 == 3) {
                    i2 = this.c.getCipher().getOutputSize(i2);
                } else if (i3 == 2 || i3 == 4) {
                    i2 = this.c.getCipher().getOutputSize((i2 - macSize) - bitLength);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i4 = this.d;
            if (i4 == 1 || i4 == 3) {
                size = this.e.size() + macSize + bitLength;
            } else if (i4 == 2 || i4 == 4) {
                size = (this.e.size() - macSize) - bitLength;
            } else {
                throw new IllegalStateException("IESCipher not initialised");
            }
            return size + i2;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f == null && this.g != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.a.createAlgorithmParameters("IES");
                this.f = createAlgorithmParameters;
                createAlgorithmParameters.init(this.g);
            } catch (Exception e2) {
                throw new RuntimeException(e2.toString());
            }
        }
        return this.f;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e2) {
                throw new InvalidAlgorithmParameterException(a2.b.a.a.a.G2(e2, a2.b.a.a.a.L("cannot recognise parameters: ")));
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.f = algorithmParameters;
        engineInit(i2, key, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NONE") && !upperCase.equals("DHAES")) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("can't support mode ", str));
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NOPADDING") && !upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        this.e.write(bArr, i2, i3);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        this.e.write(bArr, i2, i3);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        if (algorithmParameterSpec == null) {
            byte[] bArr = null;
            int i3 = this.b;
            if (i3 != 0 && i2 == 1) {
                bArr = new byte[i3];
                secureRandom.nextBytes(bArr);
            }
            this.g = IESUtil.guessParameterSpec(this.c.getCipher(), bArr);
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.g = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        byte[] nonce = this.g.getNonce();
        int i4 = this.b;
        if (i4 == 0 || (nonce != null && nonce.length == i4)) {
            if (i2 == 1 || i2 == 3) {
                if (key instanceof DHPublicKey) {
                    this.h = DHUtil.generatePublicKeyParameter((PublicKey) key);
                } else if (key instanceof IESKey) {
                    IESKey iESKey = (IESKey) key;
                    this.h = DHUtil.generatePublicKeyParameter(iESKey.getPublic());
                    this.j = DHUtil.generatePrivateKeyParameter(iESKey.getPrivate());
                } else {
                    throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
                }
            } else if (i2 != 2 && i2 != 4) {
                throw new InvalidKeyException("must be passed EC key");
            } else if (key instanceof DHPrivateKey) {
                this.h = DHUtil.generatePrivateKeyParameter((PrivateKey) key);
            } else if (key instanceof IESKey) {
                IESKey iESKey2 = (IESKey) key;
                this.j = DHUtil.generatePublicKeyParameter(iESKey2.getPublic());
                this.h = DHUtil.generatePrivateKeyParameter(iESKey2.getPrivate());
            } else {
                throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
            }
            this.i = secureRandom;
            this.d = i2;
            this.e.reset();
            return;
        }
        throw new InvalidAlgorithmParameterException(a2.b.a.a.a.j(a2.b.a.a.a.L("NONCE in IES Parameters needs to be "), this.b, " bytes long"));
    }

    public IESCipher(IESEngine iESEngine, int i2) {
        this.c = iESEngine;
        this.b = i2;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i2, i3);
        System.arraycopy(engineDoFinal, 0, bArr2, i4, engineDoFinal.length);
        return engineDoFinal.length;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            StringBuilder L = a2.b.a.a.a.L("cannot handle supplied parameter spec: ");
            L.append(e2.getMessage());
            throw new IllegalArgumentException(L.toString());
        }
    }
}
