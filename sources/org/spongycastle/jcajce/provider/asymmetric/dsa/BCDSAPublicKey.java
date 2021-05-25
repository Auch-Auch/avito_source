package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;
public class BCDSAPublicKey implements DSAPublicKey {
    public static BigInteger d = BigInteger.valueOf(0);
    private static final long serialVersionUID = 1752452449903495175L;
    public BigInteger a;
    public transient DSAPublicKeyParameters b;
    public transient DSAParams c;

    public BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.a = dSAPublicKeySpec.getY();
        this.c = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
        this.b = new DSAPublicKeyParameters(this.a, DSAUtil.b(this.c));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        if (bigInteger.equals(d)) {
            this.c = null;
        } else {
            this.c = new DSAParameterSpec(bigInteger, (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        }
        this.b = new DSAPublicKeyParameters(this.a, DSAUtil.b(this.c));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        DSAParams dSAParams = this.c;
        if (dSAParams == null) {
            objectOutputStream.writeObject(d);
            return;
        }
        objectOutputStream.writeObject(dSAParams.getP());
        objectOutputStream.writeObject(this.c.getQ());
        objectOutputStream.writeObject(this.c.getG());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        if (this.c != null) {
            if (!getY().equals(dSAPublicKey.getY()) || dSAPublicKey.getParams() == null || !getParams().getG().equals(dSAPublicKey.getParams().getG()) || !getParams().getP().equals(dSAPublicKey.getParams().getP()) || !getParams().getQ().equals(dSAPublicKey.getParams().getQ())) {
                return false;
            }
            return true;
        } else if (!getY().equals(dSAPublicKey.getY()) || dSAPublicKey.getParams() != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        DSAParams dSAParams = this.c;
        if (dSAParams == null) {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), new ASN1Integer(this.a));
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(dSAParams.getP(), this.c.getQ(), this.c.getG()).toASN1Primitive()), new ASN1Integer(this.a));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.c;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.c != null) {
            return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
        }
        return getY().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("DSA Public Key [");
        stringBuffer.append(DSAUtil.a(this.a, getParams()));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.a = dSAPublicKey.getY();
        this.c = dSAPublicKey.getParams();
        this.b = new DSAPublicKeyParameters(this.a, DSAUtil.b(this.c));
    }

    public BCDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.a = dSAPublicKeyParameters.getY();
        this.c = new DSAParameterSpec(dSAPublicKeyParameters.getParameters().getP(), dSAPublicKeyParameters.getParameters().getQ(), dSAPublicKeyParameters.getParameters().getG());
        this.b = dSAPublicKeyParameters;
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.a = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            ASN1Encodable parameters = subjectPublicKeyInfo.getAlgorithm().getParameters();
            if (parameters != null && !DERNull.INSTANCE.equals(parameters.toASN1Primitive())) {
                DSAParameter instance = DSAParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.c = new DSAParameterSpec(instance.getP(), instance.getQ(), instance.getG());
            } else {
                this.c = null;
            }
            this.b = new DSAPublicKeyParameters(this.a, DSAUtil.b(this.c));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }
}
