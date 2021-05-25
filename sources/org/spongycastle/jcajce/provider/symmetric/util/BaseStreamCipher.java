package org.spongycastle.jcajce.provider.symmetric.util;

import a2.b.a.a.a;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12KeyWithParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
public class BaseStreamCipher extends BaseWrapCipher implements PBE {
    public Class[] e;
    public StreamCipher f;
    public int g;
    public int h;
    public ParametersWithIV i;
    public int j;
    public PBEParameterSpec k;
    public String l;

    public BaseStreamCipher(StreamCipher streamCipher, int i2) {
        this(streamCipher, i2, -1, -1);
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i2, int i3) {
        if (i3 != 0) {
            byte[] engineUpdate = engineUpdate(bArr, i2, i3);
            this.f.reset();
            return engineUpdate;
        }
        this.f.reset();
        return new byte[0];
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.i;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i2) {
        return i2;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        AlgorithmParameters algorithmParameters = this.engineParams;
        if (algorithmParameters != null || this.k == null) {
            return algorithmParameters;
        }
        try {
            AlgorithmParameters createParametersInstance = createParametersInstance(this.l);
            createParametersInstance.init(this.k);
            return createParametersInstance;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        CipherParameters cipherParameters;
        this.k = null;
        this.l = null;
        this.engineParams = null;
        if (key instanceof SecretKey) {
            if (key instanceof PKCS12Key) {
                PKCS12Key pKCS12Key = (PKCS12Key) key;
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.k = pBEParameterSpec;
                if ((pKCS12Key instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                    PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                    this.k = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
                }
                parametersWithIV = PBE.Util.makePBEParameters(pKCS12Key.getEncoded(), 2, this.h, this.g, this.j * 8, this.k, this.f.getAlgorithmName());
            } else {
                if (key instanceof BCPBEKey) {
                    BCPBEKey bCPBEKey = (BCPBEKey) key;
                    if (bCPBEKey.getOID() != null) {
                        this.l = bCPBEKey.getOID().getId();
                    } else {
                        this.l = bCPBEKey.getAlgorithm();
                    }
                    if (bCPBEKey.getParam() != null) {
                        cipherParameters = bCPBEKey.getParam();
                        this.k = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                    } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                        CipherParameters makePBEParameters = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.f.getAlgorithmName());
                        this.k = (PBEParameterSpec) algorithmParameterSpec;
                        cipherParameters = makePBEParameters;
                    } else {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    if (bCPBEKey.getIvSize() != 0) {
                        this.i = (ParametersWithIV) cipherParameters;
                    }
                } else if (algorithmParameterSpec == null) {
                    if (this.h <= 0) {
                        cipherParameters = new KeyParameter(key.getEncoded());
                    } else {
                        throw new InvalidKeyException("Algorithm requires a PBE key");
                    }
                } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                    ParametersWithIV parametersWithIV2 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                    this.i = parametersWithIV2;
                    parametersWithIV = parametersWithIV2;
                } else {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                parametersWithIV = cipherParameters;
            }
            if (this.j != 0 && !(parametersWithIV instanceof ParametersWithIV)) {
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                if (i2 == 1 || i2 == 3) {
                    byte[] bArr = new byte[this.j];
                    secureRandom.nextBytes(bArr);
                    ParametersWithIV parametersWithIV3 = new ParametersWithIV(parametersWithIV, bArr);
                    this.i = parametersWithIV3;
                    parametersWithIV = parametersWithIV3;
                } else {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            try {
                                throw new InvalidParameterException("unknown opmode " + i2 + " passed");
                            } catch (Exception e2) {
                                throw new InvalidKeyException(e2.getMessage());
                            }
                        }
                    }
                }
                this.f.init(false, parametersWithIV);
                return;
            }
            this.f.init(true, parametersWithIV);
            return;
        }
        StringBuilder L = a.L("Key for algorithm ");
        L.append(key.getAlgorithm());
        L.append(" not suitable for symmetric enryption.");
        throw new InvalidKeyException(L.toString());
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (!str.equalsIgnoreCase("ECB")) {
            throw new NoSuchAlgorithmException(a.c3("can't support mode ", str));
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!str.equalsIgnoreCase("NoPadding")) {
            throw new NoSuchPaddingException(a.e3("Padding ", str, " unknown."));
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        this.f.processBytes(bArr, i2, i3, bArr2, 0);
        return bArr2;
    }

    public BaseStreamCipher(StreamCipher streamCipher, int i2, int i3, int i4) {
        this.e = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f = streamCipher;
        this.j = i2;
        this.g = i3;
        this.h = i4;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (i4 + i3 <= bArr2.length) {
            try {
                this.f.processBytes(bArr, i2, i3, bArr2, i4);
                return i3;
            } catch (DataLengthException e2) {
                throw new IllegalStateException(e2.getMessage());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (i4 + i3 <= bArr2.length) {
            if (i3 != 0) {
                this.f.processBytes(bArr, i2, i3, bArr2, i4);
            }
            this.f.reset();
            return i3;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i3 = 0;
            while (true) {
                Class[] clsArr = this.e;
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
        engineInit(i2, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2.getMessage());
        }
    }
}
