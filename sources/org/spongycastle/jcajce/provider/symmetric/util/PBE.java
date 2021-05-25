package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.util.DigestFactory;
public interface PBE {
    public static final int GOST3411 = 6;
    public static final int MD2 = 5;
    public static final int MD5 = 0;
    public static final int OPENSSL = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S1_UTF8 = 4;
    public static final int PKCS5S2 = 1;
    public static final int PKCS5S2_UTF8 = 5;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;
    public static final int SHA224 = 7;
    public static final int SHA256 = 4;
    public static final int SHA384 = 8;
    public static final int SHA3_224 = 10;
    public static final int SHA3_256 = 11;
    public static final int SHA3_384 = 12;
    public static final int SHA3_512 = 13;
    public static final int SHA512 = 9;
    public static final int TIGER = 3;

    public static class Util {
        public static byte[] a(int i, PBEKeySpec pBEKeySpec) {
            if (i == 2) {
                return PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword());
            }
            if (i == 5 || i == 4) {
                return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(pBEKeySpec.getPassword());
            }
            return PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
        }

        public static PBEParametersGenerator b(int i, int i2) {
            if (i == 0 || i == 4) {
                if (i2 == 0) {
                    return new PKCS5S1ParametersGenerator(DigestFactory.createMD5());
                }
                if (i2 == 1) {
                    return new PKCS5S1ParametersGenerator(DigestFactory.createSHA1());
                }
                if (i2 == 5) {
                    return new PKCS5S1ParametersGenerator(new MD2Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            } else if (i == 1 || i == 5) {
                switch (i2) {
                    case 0:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createMD5());
                    case 1:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA1());
                    case 2:
                        return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS5S2ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA256());
                    case 5:
                        return new PKCS5S2ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS5S2ParametersGenerator(new GOST3411Digest());
                    case 7:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA224());
                    case 8:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA384());
                    case 9:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512());
                    case 10:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_224());
                    case 11:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_256());
                    case 12:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_384());
                    case 13:
                        return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_512());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
                }
            } else if (i != 2) {
                return new OpenSSLPBEParametersGenerator();
            } else {
                switch (i2) {
                    case 0:
                        return new PKCS12ParametersGenerator(DigestFactory.createMD5());
                    case 1:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA1());
                    case 2:
                        return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS12ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA256());
                    case 5:
                        return new PKCS12ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS12ParametersGenerator(new GOST3411Digest());
                    case 7:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA224());
                    case 8:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA384());
                    case 9:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA512());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            }
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator b = b(bCPBEKey.c, bCPBEKey.d);
            b.init(bCPBEKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            return b.generateDerivedMacParameters(bCPBEKey.e);
        }

        public static CipherParameters makePBEParameters(byte[] bArr, int i, int i2, int i3, int i4, AlgorithmParameterSpec algorithmParameterSpec, String str) throws InvalidAlgorithmParameterException {
            CipherParameters cipherParameters;
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator b = b(i, i2);
            b.init(bArr, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            if (i4 != 0) {
                cipherParameters = b.generateDerivedParameters(i3, i4);
            } else {
                cipherParameters = b.generateDerivedParameters(i3);
            }
            if (str.startsWith("DES")) {
                if (cipherParameters instanceof ParametersWithIV) {
                    DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParameters).getParameters()).getKey());
                } else {
                    DESParameters.setOddParity(((KeyParameter) cipherParameters).getKey());
                }
            }
            return cipherParameters;
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            PBEParametersGenerator b = b(i, i2);
            byte[] a = a(i, pBEKeySpec);
            b.init(a, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = b.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != a.length; i4++) {
                a[i4] = 0;
            }
            return generateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            CipherParameters cipherParameters;
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator b = b(bCPBEKey.c, bCPBEKey.d);
            byte[] encoded = bCPBEKey.getEncoded();
            if (bCPBEKey.i) {
                encoded = new byte[2];
            }
            b.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            if (bCPBEKey.getIvSize() != 0) {
                cipherParameters = b.generateDerivedParameters(bCPBEKey.e, bCPBEKey.getIvSize());
            } else {
                cipherParameters = b.generateDerivedParameters(bCPBEKey.e);
            }
            if (str.startsWith("DES")) {
                if (cipherParameters instanceof ParametersWithIV) {
                    DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParameters).getParameters()).getKey());
                } else {
                    DESParameters.setOddParity(((KeyParameter) cipherParameters).getKey());
                }
            }
            return cipherParameters;
        }

        public static CipherParameters makePBEMacParameters(SecretKey secretKey, int i, int i2, int i3, PBEParameterSpec pBEParameterSpec) {
            PBEParametersGenerator b = b(i, i2);
            byte[] encoded = secretKey.getEncoded();
            b.init(secretKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = b.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != encoded.length; i4++) {
                encoded[i4] = 0;
            }
            return generateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            CipherParameters cipherParameters;
            PBEParametersGenerator b = b(i, i2);
            byte[] a = a(i, pBEKeySpec);
            b.init(a, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            if (i4 != 0) {
                cipherParameters = b.generateDerivedParameters(i3, i4);
            } else {
                cipherParameters = b.generateDerivedParameters(i3);
            }
            for (int i5 = 0; i5 != a.length; i5++) {
                a[i5] = 0;
            }
            return cipherParameters;
        }
    }
}
