package org.spongycastle.jcajce.provider.asymmetric.dstu;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.ua.DSTU4145BinaryField;
import org.spongycastle.asn1.ua.DSTU4145ECBinary;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.asn1.ua.DSTU4145Params;
import org.spongycastle.asn1.ua.DSTU4145PointEncoder;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
public class BCDSTU4145PublicKey implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    public static final long serialVersionUID = 7026240464295649314L;
    public String a = "DSTU4145";
    public boolean b;
    public transient ECPublicKeyParameters c;
    public transient ECParameterSpec d;
    public transient DSTU4145Params e;

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        this.c = bCDSTU4145PublicKey.c;
        this.d = bCDSTU4145PublicKey.d;
        this.b = bCDSTU4145PublicKey.b;
        this.e = bCDSTU4145PublicKey.e;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        c(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final ECParameterSpec a(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new ECPoint(a.e0(eCDomainParameters), a.g0(eCDomainParameters)), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    public org.spongycastle.jce.spec.ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = this.d;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec, this.b);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public final void c(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec;
        DERBitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
        this.a = "DSTU4145";
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(publicKeyData.getBytes())).getOctets();
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu4145le;
            if (algorithm.equals(aSN1ObjectIdentifier)) {
                d(octets);
            }
            DSTU4145Params instance = DSTU4145Params.getInstance((ASN1Sequence) subjectPublicKeyInfo.getAlgorithm().getParameters());
            this.e = instance;
            if (instance.isNamedCurve()) {
                ASN1ObjectIdentifier namedCurve = this.e.getNamedCurve();
                ECDomainParameters byOID = DSTU4145NamedCurves.getByOID(namedCurve);
                eCParameterSpec = new ECNamedCurveParameterSpec(namedCurve.getId(), byOID.getCurve(), byOID.getG(), byOID.getN(), byOID.getH(), byOID.getSeed());
            } else {
                DSTU4145ECBinary eCBinary = this.e.getECBinary();
                byte[] b2 = eCBinary.getB();
                if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(aSN1ObjectIdentifier)) {
                    d(b2);
                }
                DSTU4145BinaryField field = eCBinary.getField();
                ECCurve.F2m f2m = new ECCurve.F2m(field.getM(), field.getK1(), field.getK2(), field.getK3(), eCBinary.getA(), new BigInteger(1, b2));
                byte[] g = eCBinary.getG();
                if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(aSN1ObjectIdentifier)) {
                    d(g);
                }
                eCParameterSpec = new org.spongycastle.jce.spec.ECParameterSpec(f2m, DSTU4145PointEncoder.decodePoint(f2m, g), eCBinary.getN());
            }
            ECCurve curve = eCParameterSpec.getCurve();
            EllipticCurve convertCurve = EC5Util.convertCurve(curve, eCParameterSpec.getSeed());
            if (this.e.isNamedCurve()) {
                this.d = new ECNamedCurveSpec(this.e.getNamedCurve().getId(), convertCurve, new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH());
            } else {
                this.d = new ECParameterSpec(convertCurve, new ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
            }
            this.c = new ECPublicKeyParameters(DSTU4145PointEncoder.decodePoint(curve, octets), EC5Util.getDomainParameters(null, this.d));
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public final void d(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b2 = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b2;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        if (!this.c.getQ().equals(bCDSTU4145PublicKey.c.getQ()) || !b().equals(bCDSTU4145PublicKey.b())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.a;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Encodable aSN1Encodable = this.e;
        if (aSN1Encodable == null) {
            ECParameterSpec eCParameterSpec = this.d;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                aSN1Encodable = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.d).getName()));
            } else {
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                aSN1Encodable = new X962Parameters(new X9ECParameters(convertCurve, EC5Util.convertPoint(convertCurve, this.d.getGenerator(), this.b), this.d.getOrder(), BigInteger.valueOf((long) this.d.getCofactor()), this.d.getCurve().getSeed()));
            }
        }
        try {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, aSN1Encodable), new DEROctetString(DSTU4145PointEncoder.encodePoint(this.c.getQ()))));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
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

    @Override // org.spongycastle.jce.interfaces.ECPublicKey
    public org.spongycastle.math.ec.ECPoint getQ() {
        org.spongycastle.math.ec.ECPoint q = this.c.getQ();
        return this.d == null ? q.getDetachedPoint() : q;
    }

    public byte[] getSbox() {
        DSTU4145Params dSTU4145Params = this.e;
        if (dSTU4145Params != null) {
            return dSTU4145Params.getDKE();
        }
        return DSTU4145Params.getDefaultDKE();
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        org.spongycastle.math.ec.ECPoint q = this.c.getQ();
        return new ECPoint(q.getAffineXCoord().toBigInteger(), q.getAffineYCoord().toBigInteger());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.c.getQ().hashCode() ^ b().hashCode();
    }

    @Override // org.spongycastle.jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.b = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // java.lang.Object
    public String toString() {
        return ECUtil.publicKeyToString(this.a, this.c.getQ(), b());
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.d = params;
        this.c = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKeySpec.getW(), false), EC5Util.getDomainParameters(null, this.d));
    }

    public BCDSTU4145PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.c = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.d = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
            return;
        }
        this.c = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, null));
        this.d = null;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.a = str;
        this.c = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.d = a(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.d = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.a = str;
        if (eCParameterSpec == null) {
            this.d = a(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.d = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        }
        this.c = eCPublicKeyParameters;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.a = str;
        this.c = eCPublicKeyParameters;
        this.d = null;
    }

    public BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        c(subjectPublicKeyInfo);
    }
}
