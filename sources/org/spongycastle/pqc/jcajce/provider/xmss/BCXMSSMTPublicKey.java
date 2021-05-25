package org.spongycastle.pqc.jcajce.provider.xmss;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.XMSSMTKeyParams;
import org.spongycastle.pqc.asn1.XMSSPublicKey;
import org.spongycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey;
import org.spongycastle.util.Arrays;
public class BCXMSSMTPublicKey implements PublicKey, XMSSMTKey {
    public final ASN1ObjectIdentifier a;
    public final XMSSMTPublicKeyParameters b;

    public BCXMSSMTPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters) {
        this.a = aSN1ObjectIdentifier;
        this.b = xMSSMTPublicKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPublicKey)) {
            return false;
        }
        BCXMSSMTPublicKey bCXMSSMTPublicKey = (BCXMSSMTPublicKey) obj;
        if (!this.a.equals(bCXMSSMTPublicKey.a) || !Arrays.areEqual(this.b.toByteArray(), bCXMSSMTPublicKey.b.toByteArray())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyParams(this.b.getParameters().getHeight(), this.b.getParameters().getLayers(), new AlgorithmIdentifier(this.a))), new XMSSPublicKey(this.b.getPublicSeed(), this.b.getRoot())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey
    public int getHeight() {
        return this.b.getParameters().getHeight();
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey
    public int getLayers() {
        return this.b.getParameters().getLayers();
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey
    public String getTreeDigest() {
        return AppCompatDelegateImpl.i.J0(this.a);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Arrays.hashCode(this.b.toByteArray()) * 37) + this.a.hashCode();
    }

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSMTKeyParams instance = XMSSMTKeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
        ASN1ObjectIdentifier algorithm = instance.getTreeDigest().getAlgorithm();
        this.a = algorithm;
        XMSSPublicKey instance2 = XMSSPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
        this.b = new XMSSMTPublicKeyParameters.Builder(new XMSSMTParameters(instance.getHeight(), instance.getLayers(), AppCompatDelegateImpl.i.w0(algorithm))).withPublicSeed(instance2.getPublicSeed()).withRoot(instance2.getRoot()).build();
    }
}
