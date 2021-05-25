package org.spongycastle.jcajce.provider.asymmetric.dstu;

import a2.b.a.a.a;
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
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.math.ec.ECCurve;
public class BCDSTU4145PrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    public static final long serialVersionUID = 7245981689601667138L;
    public String a = "DSTU4145";
    public boolean b;
    public transient BigInteger c;
    public transient ECParameterSpec d;
    public transient DERBitString e;
    public transient PKCS12BagAttributeCarrierImpl f = new PKCS12BagAttributeCarrierImpl();

    public BCDSTU4145PrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        c(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.f = new PKCS12BagAttributeCarrierImpl();
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
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public final DERBitString b(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCDSTU4145PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    public final void c(PrivateKeyInfo privateKeyInfo) throws IOException {
        X962Parameters x962Parameters = new X962Parameters((ASN1Primitive) privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier instance = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
            X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(instance);
            if (namedCurveByOid == null) {
                ECDomainParameters byOID = DSTU4145NamedCurves.getByOID(instance);
                this.d = new ECNamedCurveSpec(instance.getId(), EC5Util.convertCurve(byOID.getCurve(), byOID.getSeed()), new ECPoint(a.e0(byOID), a.g0(byOID)), byOID.getN(), byOID.getH());
            } else {
                this.d = new ECNamedCurveSpec(ECUtil.getCurveName(instance), EC5Util.convertCurve(namedCurveByOid.getCurve(), namedCurveByOid.getSeed()), new ECPoint(namedCurveByOid.getG().getAffineXCoord().toBigInteger(), namedCurveByOid.getG().getAffineYCoord().toBigInteger()), namedCurveByOid.getN(), namedCurveByOid.getH());
            }
        } else if (x962Parameters.isImplicitlyCA()) {
            this.d = null;
        } else {
            X9ECParameters instance2 = X9ECParameters.getInstance(x962Parameters.getParameters());
            this.d = new ECParameterSpec(EC5Util.convertCurve(instance2.getCurve(), instance2.getSeed()), new ECPoint(instance2.getG().getAffineXCoord().toBigInteger(), instance2.getG().getAffineYCoord().toBigInteger()), instance2.getN(), instance2.getH().intValue());
        }
        ASN1Encodable parsePrivateKey = privateKeyInfo.parsePrivateKey();
        if (parsePrivateKey instanceof ASN1Integer) {
            this.c = ASN1Integer.getInstance(parsePrivateKey).getValue();
            return;
        }
        org.spongycastle.asn1.sec.ECPrivateKey instance3 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(parsePrivateKey);
        this.c = instance3.getKey();
        this.e = instance3.getPublicKey();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        if (!getD().equals(bCDSTU4145PrivateKey.getD()) || !a().equals(bCDSTU4145PrivateKey.a())) {
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
        return this.f.getBagAttribute(aSN1ObjectIdentifier);
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.f.getBagAttributeKeys();
    }

    @Override // org.spongycastle.jce.interfaces.ECPrivateKey
    public BigInteger getD() {
        return this.c;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        int i;
        org.spongycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        PrivateKeyInfo privateKeyInfo;
        ECParameterSpec eCParameterSpec = this.d;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).getName());
            if (namedCurveOid == null) {
                namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.d).getName());
            }
            x962Parameters = new X962Parameters(namedCurveOid);
            i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.d.getOrder(), getS());
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
        } else {
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.d.getGenerator(), this.b), this.d.getOrder(), BigInteger.valueOf((long) this.d.getCofactor()), this.d.getCurve().getSeed()));
            i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.d.getOrder(), getS());
        }
        if (this.e != null) {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), this.e, x962Parameters);
        } else {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), x962Parameters);
        }
        try {
            if (this.a.equals("DSTU4145")) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive());
            } else {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive());
            }
            return privateKeyInfo.getEncoded(ASN1Encoding.DER);
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
        this.f.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // org.spongycastle.jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.b = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // java.lang.Object
    public String toString() {
        return ECUtil.privateKeyToString(this.a, this.c, a());
    }

    public BCDSTU4145PrivateKey(ECPrivateKey eCPrivateKey) {
        this.c = eCPrivateKey.getS();
        this.a = eCPrivateKey.getAlgorithm();
        this.d = eCPrivateKey.getParams();
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.c = eCPrivateKeySpec.getD();
        if (eCPrivateKeySpec.getParams() != null) {
            this.d = EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams());
        } else {
            this.d = null;
        }
    }

    public BCDSTU4145PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.c = eCPrivateKeySpec.getS();
        this.d = eCPrivateKeySpec.getParams();
    }

    public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey bCDSTU4145PrivateKey) {
        this.c = bCDSTU4145PrivateKey.c;
        this.d = bCDSTU4145PrivateKey.d;
        this.b = bCDSTU4145PrivateKey.b;
        this.f = bCDSTU4145PrivateKey.f;
        this.e = bCDSTU4145PrivateKey.e;
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.c = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.d = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.d = eCParameterSpec;
        }
        this.e = b(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.c = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.d = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.d = new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        }
        this.e = b(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.a = str;
        this.c = eCPrivateKeyParameters.getD();
        this.d = null;
    }

    public BCDSTU4145PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        c(privateKeyInfo);
    }
}
