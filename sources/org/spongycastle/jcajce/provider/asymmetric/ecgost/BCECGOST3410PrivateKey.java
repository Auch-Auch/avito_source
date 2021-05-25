package org.spongycastle.jcajce.provider.asymmetric.ecgost;

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
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.math.ec.ECCurve;
public class BCECGOST3410PrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    public static final long serialVersionUID = 7245981689601667138L;
    public String a = "ECGOST3410";
    public boolean b;
    public transient ASN1Encodable c;
    public transient BigInteger d;
    public transient ECParameterSpec e;
    public transient DERBitString f;
    public transient PKCS12BagAttributeCarrierImpl g = new PKCS12BagAttributeCarrierImpl();

    public BCECGOST3410PrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        c(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.g = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.e;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec, this.b);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public final DERBitString b(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCECGOST3410PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    public final void c(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1Primitive aSN1Primitive = privateKeyInfo.getPrivateKeyAlgorithm().getParameters().toASN1Primitive();
        if (!(aSN1Primitive instanceof ASN1Sequence) || !(ASN1Sequence.getInstance(aSN1Primitive).size() == 2 || ASN1Sequence.getInstance(aSN1Primitive).size() == 3)) {
            X962Parameters instance = X962Parameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
            if (instance.isNamedCurve()) {
                ASN1ObjectIdentifier instance2 = ASN1ObjectIdentifier.getInstance(instance.getParameters());
                X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(instance2);
                if (namedCurveByOid == null) {
                    ECDomainParameters byOID = ECGOST3410NamedCurves.getByOID(instance2);
                    this.e = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(instance2), EC5Util.convertCurve(byOID.getCurve(), byOID.getSeed()), new ECPoint(a.e0(byOID), a.g0(byOID)), byOID.getN(), byOID.getH());
                } else {
                    this.e = new ECNamedCurveSpec(ECUtil.getCurveName(instance2), EC5Util.convertCurve(namedCurveByOid.getCurve(), namedCurveByOid.getSeed()), new ECPoint(namedCurveByOid.getG().getAffineXCoord().toBigInteger(), namedCurveByOid.getG().getAffineYCoord().toBigInteger()), namedCurveByOid.getN(), namedCurveByOid.getH());
                }
            } else if (instance.isImplicitlyCA()) {
                this.e = null;
            } else {
                X9ECParameters instance3 = X9ECParameters.getInstance(instance.getParameters());
                this.e = new ECParameterSpec(EC5Util.convertCurve(instance3.getCurve(), instance3.getSeed()), new ECPoint(instance3.getG().getAffineXCoord().toBigInteger(), instance3.getG().getAffineYCoord().toBigInteger()), instance3.getN(), instance3.getH().intValue());
            }
            ASN1Encodable parsePrivateKey = privateKeyInfo.parsePrivateKey();
            if (parsePrivateKey instanceof ASN1Integer) {
                this.d = ASN1Integer.getInstance(parsePrivateKey).getValue();
                return;
            }
            org.spongycastle.asn1.sec.ECPrivateKey instance4 = org.spongycastle.asn1.sec.ECPrivateKey.getInstance(parsePrivateKey);
            this.d = instance4.getKey();
            this.f = instance4.getPublicKey();
            return;
        }
        GOST3410PublicKeyAlgParameters instance5 = GOST3410PublicKeyAlgParameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        this.c = instance5;
        ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(instance5.getPublicKeyParamSet()));
        this.e = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(instance5.getPublicKeyParamSet()), EC5Util.convertCurve(parameterSpec.getCurve(), parameterSpec.getSeed()), new ECPoint(parameterSpec.getG().getAffineXCoord().toBigInteger(), parameterSpec.getG().getAffineYCoord().toBigInteger()), parameterSpec.getN(), parameterSpec.getH());
        ASN1Encodable parsePrivateKey2 = privateKeyInfo.parsePrivateKey();
        if (parsePrivateKey2 instanceof ASN1Integer) {
            this.d = ASN1Integer.getInstance(parsePrivateKey2).getPositiveValue();
            return;
        }
        byte[] octets = ASN1OctetString.getInstance(parsePrivateKey2).getOctets();
        byte[] bArr = new byte[octets.length];
        for (int i = 0; i != octets.length; i++) {
            bArr[i] = octets[(octets.length - 1) - i];
        }
        this.d = new BigInteger(1, bArr);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        if (!getD().equals(bCECGOST3410PrivateKey.getD()) || !a().equals(bCECGOST3410PrivateKey.a())) {
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
        return this.d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        int i;
        org.spongycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        if (this.c != null) {
            byte[] bArr = new byte[32];
            byte[] byteArray = getS().toByteArray();
            if (byteArray.length < 32) {
                byte[] bArr2 = new byte[32];
                System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
                byteArray = bArr2;
            }
            for (int i2 = 0; i2 != 32; i2++) {
                bArr[0 + i2] = byteArray[(byteArray.length - 1) - i2];
            }
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, this.c), new DEROctetString(bArr)).getEncoded(ASN1Encoding.DER);
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec = this.e;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.e).getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
                i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.e.getOrder(), getS());
            } else if (eCParameterSpec == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
                i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
            } else {
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.e.getGenerator(), this.b), this.e.getOrder(), BigInteger.valueOf((long) this.e.getCofactor()), this.e.getCurve().getSeed()));
                i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.e.getOrder(), getS());
            }
            if (this.f != null) {
                eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), this.f, x962Parameters);
            } else {
                eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), x962Parameters);
            }
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive()).getEncoded(ASN1Encoding.DER);
            } catch (IOException unused2) {
                return null;
            }
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.spongycastle.jce.interfaces.ECKey
    public org.spongycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.e;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.b);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.e;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.d;
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
        return ECUtil.privateKeyToString(this.a, this.d, a());
    }

    public BCECGOST3410PrivateKey(ECPrivateKey eCPrivateKey) {
        this.d = eCPrivateKey.getS();
        this.a = eCPrivateKey.getAlgorithm();
        this.e = eCPrivateKey.getParams();
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.d = eCPrivateKeySpec.getD();
        if (eCPrivateKeySpec.getParams() != null) {
            this.e = EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams());
        } else {
            this.e = null;
        }
    }

    public BCECGOST3410PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.d = eCPrivateKeySpec.getS();
        this.e = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey bCECGOST3410PrivateKey) {
        this.d = bCECGOST3410PrivateKey.d;
        this.e = bCECGOST3410PrivateKey.e;
        this.b = bCECGOST3410PrivateKey.b;
        this.g = bCECGOST3410PrivateKey.g;
        this.f = bCECGOST3410PrivateKey.f;
        this.c = bCECGOST3410PrivateKey.c;
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.e = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.e = eCParameterSpec;
        }
        this.c = bCECGOST3410PublicKey.e;
        this.f = b(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.a = str;
        this.d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.e = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), new ECPoint(a.e0(parameters), a.g0(parameters)), parameters.getN(), parameters.getH().intValue());
        } else {
            this.e = new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        }
        this.c = bCECGOST3410PublicKey.e;
        this.f = b(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.a = str;
        this.d = eCPrivateKeyParameters.getD();
        this.e = null;
    }

    public BCECGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        c(privateKeyInfo);
    }
}
