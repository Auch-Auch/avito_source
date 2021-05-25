package org.spongycastle.jcajce.provider.asymmetric.ec;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
public class BCECPrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    public static final long serialVersionUID = 994553197664784084L;
    public String a = "EC";
    public boolean b;
    public transient BigInteger c;
    public transient ECParameterSpec d;
    public transient ProviderConfiguration e;
    public transient DERBitString f;
    public transient PKCS12BagAttributeCarrierImpl g = new PKCS12BagAttributeCarrierImpl();

    public BCECPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.e = BouncyCastleProvider.CONFIGURATION;
        c(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.g = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.d;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec, this.b);
        }
        return this.e.getEcImplicitlyCa();
    }

    public final DERBitString b(BCECPublicKey bCECPublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCECPublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    public final void c(PrivateKeyInfo privateKeyInfo) throws IOException {
        X962Parameters instance = X962Parameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        this.d = EC5Util.convertToSpec(instance, EC5Util.getCurve(this.e, instance));
        ASN1Encodable parsePrivateKey = privateKeyInfo.parsePrivateKey();
        if (parsePrivateKey instanceof ASN1Integer) {
            this.c = ASN1Integer.getInstance(parsePrivateKey).getValue();
            return;
        }
        org.spongycastle.asn1.sec.ECPrivateKey instance2 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(parsePrivateKey);
        this.c = instance2.getKey();
        this.f = instance2.getPublicKey();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPrivateKey)) {
            return false;
        }
        BCECPrivateKey bCECPrivateKey = (BCECPrivateKey) obj;
        if (!getD().equals(bCECPrivateKey.getD()) || !a().equals(bCECPrivateKey.a())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.a;
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.g.getBagAttribute(aSN1ObjectIdentifier);
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.g.getBagAttributeKeys();
    }

    @Override // org.spongycastle.jce.interfaces.ECPrivateKey
    public BigInteger getD() {
        return this.c;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        int i;
        org.spongycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        X962Parameters z0 = AppCompatDelegateImpl.i.z0(this.d, this.b);
        ECParameterSpec eCParameterSpec = this.d;
        if (eCParameterSpec == null) {
            i = ECUtil.getOrderBitLength(this.e, null, getS());
        } else {
            i = ECUtil.getOrderBitLength(this.e, eCParameterSpec.getOrder(), getS());
        }
        if (this.f != null) {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), this.f, z0);
        } else {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), z0);
        }
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, z0), eCPrivateKey).getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.spongycastle.jce.interfaces.ECKey
    public org.spongycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.d;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.b);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.d;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getD().hashCode() ^ a().hashCode();
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.g.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // org.spongycastle.jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.b = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // java.lang.Object
    public String toString() {
        return ECUtil.privateKeyToString("EC", this.c, a());
    }

    public BCECPrivateKey(ECPrivateKey eCPrivateKey, ProviderConfiguration providerConfiguration) {
        this.c = eCPrivateKey.getS();
        this.a = eCPrivateKey.getAlgorithm();
        this.d = eCPrivateKey.getParams();
        this.e = providerConfiguration;
    }

    public BCECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.a = str;
        this.c = eCPrivateKeySpec.getD();
        if (eCPrivateKeySpec.getParams() != null) {
            this.d = EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams());
        } else {
            this.d = null;
        }
        this.e = providerConfiguration;
    }

    public BCECPrivateKey(String str, java.security.spec.ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.a = str;
        this.c = eCPrivateKeySpec.getS();
        this.d = eCPrivateKeySpec.getParams();
        this.e = providerConfiguration;
    }

    public BCECPrivateKey(String str, BCECPrivateKey bCECPrivateKey) {
        this.a = str;
        this.c = bCECPrivateKey.c;
        this.d = bCECPrivateKey.d;
        this.b = bCECPrivateKey.b;
        this.g = bCECPrivateKey.g;
        this.f = bCECPrivateKey.f;
        this.e = bCECPrivateKey.e;
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.c = eCPrivateKeyParameters.getD();
        this.e = providerConfiguration;
        if (eCParameterSpec == null) {
            this.d = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.d = eCParameterSpec;
        }
        this.f = b(bCECPublicKey);
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.c = eCPrivateKeyParameters.getD();
        this.e = providerConfiguration;
        if (eCParameterSpec == null) {
            this.d = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.d = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        }
        try {
            this.f = b(bCECPublicKey);
        } catch (Exception unused) {
            this.f = null;
        }
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, ProviderConfiguration providerConfiguration) {
        this.a = str;
        this.c = eCPrivateKeyParameters.getD();
        this.d = null;
        this.e = providerConfiguration;
    }

    public BCECPrivateKey(String str, PrivateKeyInfo privateKeyInfo, ProviderConfiguration providerConfiguration) throws IOException {
        this.a = str;
        this.e = providerConfiguration;
        c(privateKeyInfo);
    }
}
