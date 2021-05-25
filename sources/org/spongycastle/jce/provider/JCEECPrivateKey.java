package org.spongycastle.jce.provider;

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
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.ECPrivateKeyStructure;
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
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Strings;
public class JCEECPrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    public String a = "EC";
    public BigInteger b;
    public ECParameterSpec c;
    public boolean d;
    public DERBitString e;
    public PKCS12BagAttributeCarrierImpl f = new PKCS12BagAttributeCarrierImpl();

    public JCEECPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        PrivateKeyInfo instance = PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject()));
        X962Parameters x962Parameters = new X962Parameters((ASN1Primitive) instance.getPrivateKeyAlgorithm().getParameters());
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier instance2 = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
            X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(instance2);
            if (namedCurveByOid == null) {
                ECDomainParameters byOID = ECGOST3410NamedCurves.getByOID(instance2);
                this.c = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(instance2), EC5Util.convertCurve(byOID.getCurve(), byOID.getSeed()), new ECPoint(a.e0(byOID), a.g0(byOID)), byOID.getN(), byOID.getH());
            } else {
                this.c = new ECNamedCurveSpec(ECUtil.getCurveName(instance2), EC5Util.convertCurve(namedCurveByOid.getCurve(), namedCurveByOid.getSeed()), new ECPoint(namedCurveByOid.getG().getAffineXCoord().toBigInteger(), namedCurveByOid.getG().getAffineYCoord().toBigInteger()), namedCurveByOid.getN(), namedCurveByOid.getH());
            }
        } else if (x962Parameters.isImplicitlyCA()) {
            this.c = null;
        } else {
            X9ECParameters instance3 = X9ECParameters.getInstance(x962Parameters.getParameters());
            this.c = new ECParameterSpec(EC5Util.convertCurve(instance3.getCurve(), instance3.getSeed()), new ECPoint(instance3.getG().getAffineXCoord().toBigInteger(), instance3.getG().getAffineYCoord().toBigInteger()), instance3.getN(), instance3.getH().intValue());
        }
        ASN1Encodable parsePrivateKey = instance.parsePrivateKey();
        if (parsePrivateKey instanceof ASN1Integer) {
            this.b = ASN1Integer.getInstance(parsePrivateKey).getValue();
        } else {
            ECPrivateKeyStructure eCPrivateKeyStructure = new ECPrivateKeyStructure((ASN1Sequence) parsePrivateKey);
            this.b = eCPrivateKeyStructure.getKey();
            this.e = eCPrivateKeyStructure.getPublicKey();
        }
        this.a = (String) objectInputStream.readObject();
        this.d = objectInputStream.readBoolean();
        PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl = new PKCS12BagAttributeCarrierImpl();
        this.f = pKCS12BagAttributeCarrierImpl;
        pKCS12BagAttributeCarrierImpl.readObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeBoolean(this.d);
        this.f.writeObject(objectOutputStream);
    }

    public org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.c;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec, this.d);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public final DERBitString b(JCEECPublicKey jCEECPublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(jCEECPublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPrivateKey)) {
            return false;
        }
        JCEECPrivateKey jCEECPrivateKey = (JCEECPrivateKey) obj;
        if (!getD().equals(jCEECPrivateKey.getD()) || !a().equals(jCEECPrivateKey.a())) {
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
        return this.b;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        ECPrivateKeyStructure eCPrivateKeyStructure;
        PrivateKeyInfo privateKeyInfo;
        ECParameterSpec eCParameterSpec = this.c;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).getName());
            if (namedCurveOid == null) {
                namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.c).getName());
            }
            x962Parameters = new X962Parameters(namedCurveOid);
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
        } else {
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.c.getGenerator(), this.d), this.c.getOrder(), BigInteger.valueOf((long) this.c.getCofactor()), this.c.getCurve().getSeed()));
        }
        if (this.e != null) {
            eCPrivateKeyStructure = new ECPrivateKeyStructure(getS(), this.e, x962Parameters);
        } else {
            eCPrivateKeyStructure = new ECPrivateKeyStructure(getS(), x962Parameters);
        }
        try {
            if (this.a.equals("ECGOST3410")) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, x962Parameters.toASN1Primitive()), eCPrivateKeyStructure.toASN1Primitive());
            } else {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.toASN1Primitive()), eCPrivateKeyStructure.toASN1Primitive());
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
        ECParameterSpec eCParameterSpec = this.c;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.d);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.c;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.b;
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
        this.d = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.b.toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public JCEECPrivateKey(ECPrivateKey eCPrivateKey) {
        this.b = eCPrivateKey.getS();
        this.a = eCPrivateKey.getAlgorithm();
        this.c = eCPrivateKey.getParams();
    }

    public JCEECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec) {
        this.a = str;
        this.b = eCPrivateKeySpec.getD();
        if (eCPrivateKeySpec.getParams() != null) {
            this.c = EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams());
        } else {
            this.c = null;
        }
    }

    public JCEECPrivateKey(String str, java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.a = str;
        this.b = eCPrivateKeySpec.getS();
        this.c = eCPrivateKeySpec.getParams();
    }

    public JCEECPrivateKey(String str, JCEECPrivateKey jCEECPrivateKey) {
        this.a = str;
        this.b = jCEECPrivateKey.b;
        this.c = jCEECPrivateKey.c;
        this.d = jCEECPrivateKey.d;
        this.f = jCEECPrivateKey.f;
        this.e = jCEECPrivateKey.e;
    }

    public JCEECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, JCEECPublicKey jCEECPublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.b = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.c = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.c = eCParameterSpec;
        }
        this.e = b(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, JCEECPublicKey jCEECPublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.b = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.c = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.c = new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        }
        this.e = b(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.a = str;
        this.b = eCPrivateKeyParameters.getD();
        this.c = null;
    }
}
