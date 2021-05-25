package org.spongycastle.jcajce.provider.asymmetric.ec;

import androidx.appcompat.app.AppCompatDelegateImpl;
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
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.parsers.ECIESPublicKeyParser;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.provider.util.BadBlockException;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Strings;
public class IESCipher extends CipherSpi {
    public final JcaJceHelper a = new BCJcaJceHelper();
    public int b;
    public IESEngine c;
    public int d = -1;
    public ByteArrayOutputStream e = new ByteArrayOutputStream();
    public AlgorithmParameters f = null;
    public IESParameterSpec g = null;
    public AsymmetricKeyParameter h;
    public SecureRandom i;
    public AsymmetricKeyParameter j = null;

    public static class ECIES extends IESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1())));
        }
    }

    public static class ECIESwithAESCBC extends ECIESwithCipher {
        public ECIESwithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16);
        }
    }

    public static class ECIESwithCipher extends IESCipher {
        public ECIESwithCipher(BlockCipher blockCipher, int i) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1()), new PaddedBufferedBlockCipher(blockCipher)), i);
        }
    }

    public static class ECIESwithDESedeCBC extends ECIESwithCipher {
        public ECIESwithDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8);
        }
    }

    public class a implements KeyEncoder {
        public final /* synthetic */ boolean a;

        public a(IESCipher iESCipher, boolean z) {
            this.a = z;
        }

        @Override // org.spongycastle.crypto.KeyEncoder
        public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
            return ((ECPublicKeyParameters) asymmetricKeyParameter).getQ().getEncoded(this.a);
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
        ECDomainParameters parameters = ((ECKeyParameters) this.h).getParameters();
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
                ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.i));
                try {
                    this.c.init(this.h, iESWithCipherParameters, new EphemeralKeyPairGenerator(eCKeyPairGenerator, new a(this, this.g.getPointCompression())));
                    return this.c.processBlock(byteArray, 0, byteArray.length);
                } catch (Exception e3) {
                    throw new BadBlockException("unable to process block", e3);
                }
            } else if (i5 == 2 || i5 == 4) {
                try {
                    this.c.init(this.h, iESWithCipherParameters, new ECIESPublicKeyParser(parameters));
                    return this.c.processBlock(byteArray, 0, byteArray.length);
                } catch (InvalidCipherTextException e4) {
                    throw new BadBlockException("unable to process block", e4);
                }
            } else {
                throw new IllegalStateException("cipher not initialised");
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
        if (key instanceof ECKey) {
            return ((ECKey) key).getParameters().getCurve().getFieldSize();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i2) {
        int size;
        if (this.h != null) {
            int macSize = this.c.getMac().getMacSize();
            int fieldSize = this.j == null ? ((((ECKeyParameters) this.h).getParameters().getCurve().getFieldSize() + 7) / 8) * 2 : 0;
            if (this.c.getCipher() != null) {
                int i3 = this.d;
                if (i3 == 1 || i3 == 3) {
                    i2 = this.c.getCipher().getOutputSize(i2);
                } else if (i3 == 2 || i3 == 4) {
                    i2 = this.c.getCipher().getOutputSize((i2 - macSize) - fieldSize);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i4 = this.d;
            if (i4 == 1 || i4 == 3) {
                size = this.e.size() + macSize + 1 + fieldSize;
            } else if (i4 == 2 || i4 == 4) {
                size = (this.e.size() - macSize) - fieldSize;
            } else {
                throw new IllegalStateException("cipher not initialised");
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
        byte[] bArr = null;
        this.j = null;
        if (algorithmParameterSpec == null) {
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
                if (key instanceof PublicKey) {
                    this.h = AppCompatDelegateImpl.i.q0((PublicKey) key);
                } else if (key instanceof IESKey) {
                    IESKey iESKey = (IESKey) key;
                    this.h = AppCompatDelegateImpl.i.q0(iESKey.getPublic());
                    this.j = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
                } else {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
            } else if (i2 != 2 && i2 != 4) {
                throw new InvalidKeyException("must be passed EC key");
            } else if (key instanceof PrivateKey) {
                this.h = ECUtil.generatePrivateKeyParameter((PrivateKey) key);
            } else if (key instanceof IESKey) {
                IESKey iESKey2 = (IESKey) key;
                this.j = AppCompatDelegateImpl.i.q0(iESKey2.getPublic());
                this.h = ECUtil.generatePrivateKeyParameter(iESKey2.getPrivate());
            } else {
                throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
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
