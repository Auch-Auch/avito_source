package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.RC2Parameters;
import org.spongycastle.crypto.params.RC5Parameters;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jce.provider.BrokenPBE;
import org.spongycastle.util.Strings;
import x6.e.d.a.e;
public class BrokenJCEBlockCipher implements BrokenPBE {
    public Class[] a = {IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
    public BufferedBlockCipher b;
    public ParametersWithIV c;
    public int d = 2;
    public int e = 1;
    public int f;
    public int g;
    public int h = 0;
    public AlgorithmParameters i = null;

    public static class BrokePBEWithMD5AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithMD5AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 64);
        }
    }

    public static class BrokePBEWithSHA1AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithSHA1AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES2Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 3, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndTwofish extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndTwofish() {
            super(new CBCBlockCipher(new TwofishEngine()), 3, 1, 256, 128);
        }
    }

    public BrokenJCEBlockCipher(BlockCipher blockCipher) {
        this.b = new PaddedBufferedBlockCipher(blockCipher);
    }

    public byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[engineGetOutputSize(i3)];
        int processBytes = i3 != 0 ? this.b.processBytes(bArr, i2, i3, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.b.doFinal(bArr2, processBytes);
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e2) {
            throw new IllegalBlockSizeException(e2.getMessage());
        } catch (InvalidCipherTextException e3) {
            throw new BadPaddingException(e3.getMessage());
        }
    }

    public int engineGetBlockSize() {
        return this.b.getBlockSize();
    }

    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.c;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    public int engineGetOutputSize(int i2) {
        return this.b.getOutputSize(i2);
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.i == null && this.c != null) {
            String algorithmName = this.b.getUnderlyingCipher().getAlgorithmName();
            if (algorithmName.indexOf(47) >= 0) {
                algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
            }
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
                this.i = instance;
                instance.init(this.c.getIV());
            } catch (Exception e2) {
                throw new RuntimeException(e2.toString());
            }
        }
        return this.i;
    }

    public void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        PBEParametersGenerator pBEParametersGenerator;
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            int i3 = this.d;
            int i4 = this.e;
            String algorithmName = this.b.getUnderlyingCipher().getAlgorithmName();
            int i5 = this.f;
            int i6 = this.g;
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            if (i3 == 0) {
                if (i4 == 0) {
                    pBEParametersGenerator = new PKCS5S1ParametersGenerator(new MD5Digest());
                } else if (i4 == 1) {
                    pBEParametersGenerator = new PKCS5S1ParametersGenerator(new SHA1Digest());
                } else {
                    throw new IllegalStateException("PKCS5 scheme 1 only supports only MD5 and SHA1.");
                }
            } else if (i3 == 1) {
                pBEParametersGenerator = new PKCS5S2ParametersGenerator();
            } else if (i3 == 3) {
                if (i4 == 0) {
                    pBEParametersGenerator = new e(new MD5Digest());
                } else if (i4 == 1) {
                    pBEParametersGenerator = new e(new SHA1Digest());
                } else if (i4 == 2) {
                    pBEParametersGenerator = new e(new RIPEMD160Digest());
                } else {
                    throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            } else if (i4 == 0) {
                pBEParametersGenerator = new PKCS12ParametersGenerator(new MD5Digest());
            } else if (i4 == 1) {
                pBEParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
            } else if (i4 == 2) {
                pBEParametersGenerator = new PKCS12ParametersGenerator(new RIPEMD160Digest());
            } else {
                throw new IllegalStateException("unknown digest scheme for PBE encryption.");
            }
            byte[] encoded = bCPBEKey.getEncoded();
            pBEParametersGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            if (i6 != 0) {
                cipherParameters = pBEParametersGenerator.generateDerivedParameters(i5, i6);
            } else {
                cipherParameters = pBEParametersGenerator.generateDerivedParameters(i5);
            }
            if (algorithmName.startsWith("DES")) {
                if (cipherParameters instanceof ParametersWithIV) {
                    BrokenPBE.Util.a(((KeyParameter) ((ParametersWithIV) cipherParameters).getParameters()).getKey());
                } else {
                    BrokenPBE.Util.a(((KeyParameter) cipherParameters).getKey());
                }
            }
            for (int i7 = 0; i7 != encoded.length; i7++) {
                encoded[i7] = 0;
            }
            if (this.g != 0) {
                this.c = (ParametersWithIV) cipherParameters;
            }
        } else if (algorithmParameterSpec == null) {
            cipherParameters = new KeyParameter(key.getEncoded());
        } else {
            if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
                if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                    RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                    RC2Parameters rC2Parameters = new RC2Parameters(key.getEncoded(), rC2ParameterSpec.getEffectiveKeyBits());
                    parametersWithIV2 = rC2Parameters;
                    if (rC2ParameterSpec.getIV() != null) {
                        parametersWithIV2 = rC2Parameters;
                        if (this.h != 0) {
                            parametersWithIV = new ParametersWithIV(rC2Parameters, rC2ParameterSpec.getIV());
                            this.c = parametersWithIV;
                        }
                    }
                } else if (algorithmParameterSpec instanceof RC5ParameterSpec) {
                    RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) algorithmParameterSpec;
                    RC5Parameters rC5Parameters = new RC5Parameters(key.getEncoded(), rC5ParameterSpec.getRounds());
                    if (rC5ParameterSpec.getWordSize() == 32) {
                        parametersWithIV2 = rC5Parameters;
                        if (rC5ParameterSpec.getIV() != null) {
                            parametersWithIV2 = rC5Parameters;
                            if (this.h != 0) {
                                parametersWithIV = new ParametersWithIV(rC5Parameters, rC5ParameterSpec.getIV());
                                this.c = parametersWithIV;
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("can only accept RC5 word size 32 (at the moment...)");
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                cipherParameters = parametersWithIV;
            } else if (this.h != 0) {
                ParametersWithIV parametersWithIV3 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                this.c = parametersWithIV3;
                parametersWithIV2 = parametersWithIV3;
            } else {
                cipherParameters = new KeyParameter(key.getEncoded());
            }
            cipherParameters = parametersWithIV2;
        }
        ParametersWithIV parametersWithIV4 = cipherParameters;
        if (this.h != 0) {
            boolean z = cipherParameters instanceof ParametersWithIV;
            parametersWithIV4 = cipherParameters;
            if (!z) {
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                if (i2 == 1 || i2 == 3) {
                    byte[] bArr = new byte[this.h];
                    secureRandom.nextBytes(bArr);
                    ParametersWithIV parametersWithIV5 = new ParametersWithIV(cipherParameters, bArr);
                    this.c = parametersWithIV5;
                    parametersWithIV4 = parametersWithIV5;
                } else {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        System.out.println("eeek!");
                        return;
                    }
                }
            }
            this.b.init(false, parametersWithIV4);
            return;
        }
        this.b.init(true, parametersWithIV4);
    }

    public void engineSetMode(String str) {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("ECB")) {
            this.h = 0;
            this.b = new PaddedBufferedBlockCipher(this.b.getUnderlyingCipher());
        } else if (upperCase.equals("CBC")) {
            this.h = this.b.getUnderlyingCipher().getBlockSize();
            this.b = new PaddedBufferedBlockCipher(new CBCBlockCipher(this.b.getUnderlyingCipher()));
        } else if (upperCase.startsWith("OFB")) {
            this.h = this.b.getUnderlyingCipher().getBlockSize();
            if (upperCase.length() != 3) {
                this.b = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.b.getUnderlyingCipher(), Integer.parseInt(upperCase.substring(3))));
                return;
            }
            this.b = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.b.getUnderlyingCipher(), this.b.getBlockSize() * 8));
        } else if (upperCase.startsWith("CFB")) {
            this.h = this.b.getUnderlyingCipher().getBlockSize();
            if (upperCase.length() != 3) {
                this.b = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.b.getUnderlyingCipher(), Integer.parseInt(upperCase.substring(3))));
                return;
            }
            this.b = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.b.getUnderlyingCipher(), this.b.getBlockSize() * 8));
        } else {
            throw new IllegalArgumentException(a.c3("can't support mode ", str));
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            this.b = new BufferedBlockCipher(this.b.getUnderlyingCipher());
        } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING") || upperCase.equals("ISO10126PADDING")) {
            this.b = new PaddedBufferedBlockCipher(this.b.getUnderlyingCipher());
        } else if (upperCase.equals("WITHCTS")) {
            this.b = new CTSBlockCipher(this.b.getUnderlyingCipher());
        } else {
            throw new NoSuchPaddingException(a.e3("Padding ", str, " unknown."));
        }
    }

    public Key engineUnwrap(byte[] bArr, String str, int i2) throws InvalidKeyException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i2 == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            try {
                KeyFactory instance = KeyFactory.getInstance(str, BouncyCastleProvider.PROVIDER_NAME);
                if (i2 == 1) {
                    return instance.generatePublic(new X509EncodedKeySpec(engineDoFinal));
                }
                if (i2 == 2) {
                    return instance.generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
                }
                throw new InvalidKeyException(a.M2("Unknown key type ", i2));
            } catch (NoSuchProviderException e2) {
                StringBuilder L = a.L("Unknown key type ");
                L.append(e2.getMessage());
                throw new InvalidKeyException(L.toString());
            } catch (NoSuchAlgorithmException e3) {
                StringBuilder L2 = a.L("Unknown key type ");
                L2.append(e3.getMessage());
                throw new InvalidKeyException(L2.toString());
            } catch (InvalidKeySpecException e4) {
                StringBuilder L3 = a.L("Unknown key type ");
                L3.append(e4.getMessage());
                throw new InvalidKeyException(L3.toString());
            }
        } catch (BadPaddingException e5) {
            throw new InvalidKeyException(e5.getMessage());
        } catch (IllegalBlockSizeException e6) {
            throw new InvalidKeyException(e6.getMessage());
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        int updateOutputSize = this.b.getUpdateOutputSize(i3);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            this.b.processBytes(bArr, i2, i3, bArr2, 0);
            return bArr2;
        }
        this.b.processBytes(bArr, i2, i3, null, 0);
        return null;
    }

    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                return engineDoFinal(encoded, 0, encoded.length);
            } catch (BadPaddingException e2) {
                throw new IllegalBlockSizeException(e2.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }

    public int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        return this.b.processBytes(bArr, i2, i3, bArr2, i4);
    }

    public BrokenJCEBlockCipher(BlockCipher blockCipher, int i2, int i3, int i4, int i5) {
        this.b = new PaddedBufferedBlockCipher(blockCipher);
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalBlockSizeException, BadPaddingException {
        int processBytes = i3 != 0 ? this.b.processBytes(bArr, i2, i3, bArr2, i4) : 0;
        try {
            return processBytes + this.b.doFinal(bArr2, i4 + processBytes);
        } catch (DataLengthException e2) {
            throw new IllegalBlockSizeException(e2.getMessage());
        } catch (InvalidCipherTextException e3) {
            throw new BadPaddingException(e3.getMessage());
        }
    }

    public void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i3 = 0;
            while (true) {
                Class[] clsArr = this.a;
                if (i3 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i3]);
                    break;
                } catch (Exception unused) {
                    i3++;
                }
            }
            if (algorithmParameterSpec == null) {
                StringBuilder L = a.L("can't handle parameter ");
                L.append(algorithmParameters.toString());
                throw new InvalidAlgorithmParameterException(L.toString());
            }
        }
        this.i = algorithmParameters;
        engineInit(i2, key, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }
}
