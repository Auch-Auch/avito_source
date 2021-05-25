package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
public class BCDHPublicKey implements DHPublicKey {
    public static final long serialVersionUID = -216691575254424324L;
    public BigInteger a;
    public transient DHPublicKeyParameters b;
    public transient DHParameterSpec c;
    public transient SubjectPublicKeyInfo d;

    public BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.a = dHPublicKeySpec.getY();
        this.c = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
        this.b = new DHPublicKeyParameters(this.a, new DHParameters(dHPublicKeySpec.getP(), dHPublicKeySpec.getG()));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.c = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.d = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c.getP());
        objectOutputStream.writeObject(this.c.getG());
        objectOutputStream.writeInt(this.c.getL());
    }

    public DHPublicKeyParameters engineGetKeyParameters() {
        return this.b;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        if (!getY().equals(dHPublicKey.getY()) || !getParams().getG().equals(dHPublicKey.getParams().getG()) || !getParams().getP().equals(dHPublicKey.getParams().getP()) || getParams().getL() != dHPublicKey.getParams().getL()) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.d;
        if (subjectPublicKeyInfo != null) {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.c.getP(), this.c.getG(), this.c.getL()).toASN1Primitive()), new ASN1Integer(this.a));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.c;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.a = dHPublicKey.getY();
        this.c = dHPublicKey.getParams();
        this.b = new DHPublicKeyParameters(this.a, new DHParameters(this.c.getP(), this.c.getG()));
    }

    public BCDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.a = dHPublicKeyParameters.getY();
        this.c = new DHParameterSpec(dHPublicKeyParameters.getParameters().getP(), dHPublicKeyParameters.getParameters().getG(), dHPublicKeyParameters.getParameters().getL());
        this.b = dHPublicKeyParameters;
    }

    public BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.a = bigInteger;
        this.c = dHParameterSpec;
        this.b = new DHPublicKeyParameters(bigInteger, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (org.spongycastle.asn1.ASN1Integer.getInstance(r0.getObjectAt(2)).getValue().compareTo(java.math.BigInteger.valueOf((long) org.spongycastle.asn1.ASN1Integer.getInstance(r0.getObjectAt(0)).getValue().bitLength())) > 0) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BCDHPublicKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r11) {
        /*
        // Method dump skipped, instructions count: 332
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey.<init>(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }
}
