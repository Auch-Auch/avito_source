package org.spongycastle.jcajce.provider.asymmetric.ec;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Integers;
public abstract class KeyPairGeneratorSpi extends KeyPairGenerator {

    public static class ECDH extends EC {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDHC extends EC {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDSA extends EC {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECMQV extends EC {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public KeyPairGeneratorSpi(String str) {
        super(str);
    }

    public static class EC extends KeyPairGeneratorSpi {
        public static Hashtable h;
        public ECKeyGenerationParameters a;
        public ECKeyPairGenerator b = new ECKeyPairGenerator();
        public Object c = null;
        public int d = 239;
        public boolean e;
        public String f;
        public ProviderConfiguration g;

        static {
            Hashtable hashtable = new Hashtable();
            h = hashtable;
            hashtable.put(Integers.valueOf(192), new ECGenParameterSpec("prime192v1"));
            h.put(Integers.valueOf(239), new ECGenParameterSpec("prime239v1"));
            h.put(Integers.valueOf(256), new ECGenParameterSpec("prime256v1"));
            h.put(Integers.valueOf(224), new ECGenParameterSpec("P-224"));
            h.put(Integers.valueOf(384), new ECGenParameterSpec("P-384"));
            h.put(Integers.valueOf(521), new ECGenParameterSpec("P-521"));
        }

        public EC() {
            super("EC");
            new SecureRandom();
            this.e = false;
            this.f = "EC";
            this.g = BouncyCastleProvider.CONFIGURATION;
        }

        public ECKeyGenerationParameters createKeyGenParamsBC(ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            return new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH()), secureRandom);
        }

        public ECKeyGenerationParameters createKeyGenParamsJCE(java.security.spec.ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            return new ECKeyGenerationParameters(new ECDomainParameters(convertCurve, EC5Util.convertPoint(convertCurve, eCParameterSpec.getGenerator(), false), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())), secureRandom);
        }

        public ECNamedCurveSpec createNamedCurveSpec(String str) throws InvalidAlgorithmParameterException {
            X9ECParameters A0 = AppCompatDelegateImpl.i.A0(str);
            if (A0 == null) {
                try {
                    A0 = ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(str));
                    if (A0 == null) {
                        A0 = (X9ECParameters) this.g.getAdditionalECParameters().get(new ASN1ObjectIdentifier(str));
                        if (A0 == null) {
                            throw new InvalidAlgorithmParameterException("unknown curve OID: " + str);
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    throw new InvalidAlgorithmParameterException(a.c3("unknown curve name: ", str));
                }
            }
            return new ECNamedCurveSpec(str, A0.getCurve(), A0.getG(), A0.getN(), A0.getH(), null);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            if (!this.e) {
                initialize(this.d, new SecureRandom());
            }
            AsymmetricCipherKeyPair generateKeyPair = this.b.generateKeyPair();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) generateKeyPair.getPublic();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) generateKeyPair.getPrivate();
            Object obj = this.c;
            if (obj instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(this.f, eCPublicKeyParameters, eCParameterSpec, this.g);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.f, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.g));
            } else if (obj == null) {
                return new KeyPair(new BCECPublicKey(this.f, eCPublicKeyParameters, this.g), new BCECPrivateKey(this.f, eCPrivateKeyParameters, this.g));
            } else {
                java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) obj;
                BCECPublicKey bCECPublicKey2 = new BCECPublicKey(this.f, eCPublicKeyParameters, eCParameterSpec2, this.g);
                return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.f, eCPrivateKeyParameters, bCECPublicKey2, eCParameterSpec2, this.g));
            }
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            this.d = i;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) h.get(Integers.valueOf(i));
            if (eCGenParameterSpec != null) {
                try {
                    initialize(eCGenParameterSpec, secureRandom);
                } catch (InvalidAlgorithmParameterException unused) {
                    throw new InvalidParameterException("key size not configurable.");
                }
            } else {
                throw new InvalidParameterException("unknown key size.");
            }
        }

        public void initializeNamedCurve(String str, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            ECNamedCurveSpec createNamedCurveSpec = createNamedCurveSpec(str);
            this.c = createNamedCurveSpec;
            this.a = createKeyGenParamsJCE(createNamedCurveSpec, secureRandom);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec == null) {
                ECParameterSpec ecImplicitlyCa = this.g.getEcImplicitlyCa();
                if (ecImplicitlyCa != null) {
                    this.c = null;
                    this.a = createKeyGenParamsBC(ecImplicitlyCa, secureRandom);
                } else {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
            } else if (algorithmParameterSpec instanceof ECParameterSpec) {
                this.c = algorithmParameterSpec;
                this.a = createKeyGenParamsBC((ECParameterSpec) algorithmParameterSpec, secureRandom);
            } else if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
                this.c = algorithmParameterSpec;
                this.a = createKeyGenParamsJCE((java.security.spec.ECParameterSpec) algorithmParameterSpec, secureRandom);
            } else if (algorithmParameterSpec instanceof ECGenParameterSpec) {
                initializeNamedCurve(((ECGenParameterSpec) algorithmParameterSpec).getName(), secureRandom);
            } else if (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec) {
                initializeNamedCurve(((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName(), secureRandom);
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
            }
            this.b.init(this.a);
            this.e = true;
        }

        public EC(String str, ProviderConfiguration providerConfiguration) {
            super(str);
            new SecureRandom();
            this.e = false;
            this.f = str;
            this.g = providerConfiguration;
        }
    }
}
