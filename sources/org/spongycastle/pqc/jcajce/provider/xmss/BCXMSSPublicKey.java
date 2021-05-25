package org.spongycastle.pqc.jcajce.provider.xmss;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.XMSSKeyParams;
import org.spongycastle.pqc.asn1.XMSSPublicKey;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.XMSSKey;
import org.spongycastle.util.Arrays;
public class BCXMSSPublicKey implements PublicKey, XMSSKey {
    public final XMSSPublicKeyParameters a;
    public final ASN1ObjectIdentifier b;

    public BCXMSSPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSPublicKeyParameters xMSSPublicKeyParameters) {
        this.b = aSN1ObjectIdentifier;
        this.a = xMSSPublicKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPublicKey)) {
            return false;
        }
        BCXMSSPublicKey bCXMSSPublicKey = (BCXMSSPublicKey) obj;
        if (!this.b.equals(bCXMSSPublicKey.b) || !Arrays.areEqual(this.a.toByteArray(), bCXMSSPublicKey.a.toByteArray())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, new XMSSKeyParams(this.a.getParameters().getHeight(), new AlgorithmIdentifier(this.b))), new XMSSPublicKey(this.a.getPublicSeed(), this.a.getRoot())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSKey
    public int getHeight() {
        return this.a.getParameters().getHeight();
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSKey
    public String getTreeDigest() {
        return AppCompatDelegateImpl.i.J0(this.b);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Arrays.hashCode(this.a.toByteArray()) * 37) + this.b.hashCode();
    }

    public BCXMSSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSKeyParams instance = XMSSKeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
        ASN1ObjectIdentifier algorithm = instance.getTreeDigest().getAlgorithm();
        this.b = algorithm;
        XMSSPublicKey instance2 = XMSSPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
        this.a = new XMSSPublicKeyParameters.Builder(new XMSSParameters(instance.getHeight(), AppCompatDelegateImpl.i.w0(algorithm))).withPublicSeed(instance2.getPublicSeed()).withRoot(instance2.getRoot()).build();
    }
}
