package org.spongycastle.jcajce.provider.asymmetric.dstu;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DSTU4145KeyPairGenerator;
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
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public Object a = null;
    public ECKeyPairGenerator b = new DSTU4145KeyPairGenerator();
    public String c = "DSTU4145";
    public ECKeyGenerationParameters d;
    public boolean e = false;

    public KeyPairGeneratorSpi() {
        super("DSTU4145");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.e) {
            AsymmetricCipherKeyPair generateKeyPair = this.b.generateKeyPair();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) generateKeyPair.getPublic();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) generateKeyPair.getPrivate();
            Object obj = this.a;
            if (obj instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCDSTU4145PublicKey bCDSTU4145PublicKey = new BCDSTU4145PublicKey(this.c, eCPublicKeyParameters, eCParameterSpec);
                return new KeyPair(bCDSTU4145PublicKey, new BCDSTU4145PrivateKey(this.c, eCPrivateKeyParameters, bCDSTU4145PublicKey, eCParameterSpec));
            } else if (obj == null) {
                return new KeyPair(new BCDSTU4145PublicKey(this.c, eCPublicKeyParameters), new BCDSTU4145PrivateKey(this.c, eCPrivateKeyParameters));
            } else {
                java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) obj;
                BCDSTU4145PublicKey bCDSTU4145PublicKey2 = new BCDSTU4145PublicKey(this.c, eCPublicKeyParameters, eCParameterSpec2);
                return new KeyPair(bCDSTU4145PublicKey2, new BCDSTU4145PrivateKey(this.c, eCPrivateKeyParameters, bCDSTU4145PublicKey2, eCParameterSpec2));
            }
        } else {
            throw new IllegalStateException("DSTU Key Pair Generator not initialised");
        }
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        Object obj = this.a;
        if (obj != null) {
            try {
                initialize((ECGenParameterSpec) obj, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        } else {
            throw new InvalidParameterException("unknown key size.");
        }
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String str;
        if (algorithmParameterSpec instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            this.a = algorithmParameterSpec;
            ECKeyGenerationParameters eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH()), secureRandom);
            this.d = eCKeyGenerationParameters;
            this.b.init(eCKeyGenerationParameters);
            this.e = true;
        } else if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
            java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
            this.a = algorithmParameterSpec;
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec2.getCurve());
            ECKeyGenerationParameters eCKeyGenerationParameters2 = new ECKeyGenerationParameters(new ECDomainParameters(convertCurve, EC5Util.convertPoint(convertCurve, eCParameterSpec2.getGenerator(), false), eCParameterSpec2.getOrder(), BigInteger.valueOf((long) eCParameterSpec2.getCofactor())), secureRandom);
            this.d = eCKeyGenerationParameters2;
            this.b.init(eCKeyGenerationParameters2);
            this.e = true;
        } else {
            boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (z || (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                if (z) {
                    str = ((ECGenParameterSpec) algorithmParameterSpec).getName();
                } else {
                    str = ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName();
                }
                ECDomainParameters byOID = DSTU4145NamedCurves.getByOID(new ASN1ObjectIdentifier(str));
                if (byOID != null) {
                    ECNamedCurveSpec eCNamedCurveSpec = new ECNamedCurveSpec(str, byOID.getCurve(), byOID.getG(), byOID.getN(), byOID.getH(), byOID.getSeed());
                    this.a = eCNamedCurveSpec;
                    ECNamedCurveSpec eCNamedCurveSpec2 = eCNamedCurveSpec;
                    ECCurve convertCurve2 = EC5Util.convertCurve(eCNamedCurveSpec2.getCurve());
                    ECKeyGenerationParameters eCKeyGenerationParameters3 = new ECKeyGenerationParameters(new ECDomainParameters(convertCurve2, EC5Util.convertPoint(convertCurve2, eCNamedCurveSpec2.getGenerator(), false), eCNamedCurveSpec2.getOrder(), BigInteger.valueOf((long) eCNamedCurveSpec2.getCofactor())), secureRandom);
                    this.d = eCKeyGenerationParameters3;
                    this.b.init(eCKeyGenerationParameters3);
                    this.e = true;
                    return;
                }
                throw new InvalidAlgorithmParameterException(a.c3("unknown curve name: ", str));
            }
            if (algorithmParameterSpec == null) {
                ProviderConfiguration providerConfiguration = BouncyCastleProvider.CONFIGURATION;
                if (providerConfiguration.getEcImplicitlyCa() != null) {
                    ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
                    this.a = algorithmParameterSpec;
                    ECKeyGenerationParameters eCKeyGenerationParameters4 = new ECKeyGenerationParameters(new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH()), secureRandom);
                    this.d = eCKeyGenerationParameters4;
                    this.b.init(eCKeyGenerationParameters4);
                    this.e = true;
                    return;
                }
            }
            if (algorithmParameterSpec == null && BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            }
            StringBuilder L = a.L("parameter object not a ECParameterSpec: ");
            L.append(algorithmParameterSpec.getClass().getName());
            throw new InvalidAlgorithmParameterException(L.toString());
        }
    }
}
