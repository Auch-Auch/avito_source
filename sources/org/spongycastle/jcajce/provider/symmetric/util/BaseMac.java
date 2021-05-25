package org.spongycastle.jcajce.provider.symmetric.util;

import a2.b.a.a.a;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.RC2Parameters;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.spec.AEADParameterSpec;
import org.spongycastle.jcajce.spec.SkeinParameterSpec;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
public class BaseMac extends MacSpi implements PBE {
    public static final Class b = ClassUtil.loadClass(BaseMac.class, "javax.crypto.spec.GCMParameterSpec");
    public Mac a;

    public BaseMac(Mac mac) {
        this.a = mac;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.a.doFinal(bArr, 0);
        return bArr;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.a.getMacSize();
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        KeyParameter keyParameter;
        if (key != null) {
            if (key instanceof PKCS12Key) {
                try {
                    SecretKey secretKey = (SecretKey) key;
                    try {
                        PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                        if ((secretKey instanceof PBEKey) && pBEParameterSpec == null) {
                            PBEKey pBEKey = (PBEKey) secretKey;
                            pBEParameterSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                        }
                        int i = 1;
                        int i2 = 256;
                        if (this.a.getAlgorithmName().startsWith("GOST")) {
                            i = 6;
                        } else {
                            Mac mac = this.a;
                            if ((mac instanceof HMac) && !mac.getAlgorithmName().startsWith("SHA-1")) {
                                if (this.a.getAlgorithmName().startsWith(McElieceCCA2KeyGenParameterSpec.SHA224)) {
                                    i = 7;
                                    i2 = 224;
                                } else if (this.a.getAlgorithmName().startsWith("SHA-256")) {
                                    i = 4;
                                } else if (this.a.getAlgorithmName().startsWith(McElieceCCA2KeyGenParameterSpec.SHA384)) {
                                    i = 8;
                                    i2 = 384;
                                } else if (this.a.getAlgorithmName().startsWith(McElieceCCA2KeyGenParameterSpec.SHA512)) {
                                    i = 9;
                                    i2 = 512;
                                } else if (this.a.getAlgorithmName().startsWith("RIPEMD160")) {
                                    i = 2;
                                } else {
                                    StringBuilder L = a.L("no PKCS12 mapping for HMAC: ");
                                    L.append(this.a.getAlgorithmName());
                                    throw new InvalidAlgorithmParameterException(L.toString());
                                }
                            }
                            i2 = 160;
                        }
                        cipherParameters = PBE.Util.makePBEMacParameters(secretKey, 2, i, i2, pBEParameterSpec);
                    } catch (Exception unused) {
                        throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
                    }
                } catch (Exception unused2) {
                    throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
                }
            } else if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                if (bCPBEKey.getParam() != null) {
                    cipherParameters = bCPBEKey.getParam();
                } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                    cipherParameters = PBE.Util.makePBEMacParameters(bCPBEKey, algorithmParameterSpec);
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
            } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                cipherParameters = new KeyParameter(key.getEncoded());
            } else {
                StringBuilder L2 = a.L("inappropriate parameter type: ");
                L2.append(algorithmParameterSpec.getClass().getName());
                throw new InvalidAlgorithmParameterException(L2.toString());
            }
            if (cipherParameters instanceof ParametersWithIV) {
                keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).getParameters();
            } else {
                keyParameter = (KeyParameter) cipherParameters;
            }
            if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                cipherParameters = new AEADParameters(keyParameter, aEADParameterSpec.getMacSizeInBits(), aEADParameterSpec.getNonce(), aEADParameterSpec.getAssociatedData());
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                cipherParameters = new ParametersWithIV(keyParameter, ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                cipherParameters = new ParametersWithIV(new RC2Parameters(keyParameter.getKey(), rC2ParameterSpec.getEffectiveKeyBits()), rC2ParameterSpec.getIV());
            } else if (algorithmParameterSpec instanceof SkeinParameterSpec) {
                Map parameters = ((SkeinParameterSpec) algorithmParameterSpec).getParameters();
                Hashtable hashtable = new Hashtable();
                for (Object obj : parameters.keySet()) {
                    hashtable.put(obj, parameters.get(obj));
                }
                cipherParameters = new SkeinParameters.Builder(hashtable).setKey(keyParameter.getKey()).build();
            } else if (algorithmParameterSpec == null) {
                cipherParameters = new KeyParameter(key.getEncoded());
            } else {
                Class cls = b;
                if (cls != null && cls.isAssignableFrom(algorithmParameterSpec.getClass())) {
                    try {
                        cipherParameters = new AEADParameters(keyParameter, ((Integer) cls.getDeclaredMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue(), (byte[]) cls.getDeclaredMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]));
                    } catch (Exception unused3) {
                        throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
                    }
                } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    StringBuilder L3 = a.L("unknown parameter type: ");
                    L3.append(algorithmParameterSpec.getClass().getName());
                    throw new InvalidAlgorithmParameterException(L3.toString());
                }
            }
            try {
                this.a.init(cipherParameters);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException(a.F2(e, a.L("cannot initialize MAC: ")));
            }
        } else {
            throw new InvalidKeyException("key is null");
        }
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        this.a.reset();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b2) {
        this.a.update(b2);
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }

    public BaseMac(Mac mac, int i, int i2, int i3) {
        this.a = mac;
    }
}
