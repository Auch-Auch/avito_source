package org.spongycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.NHPublicKey;
import org.spongycastle.util.Arrays;
public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;
    public final NHPublicKeyParameters a;

    public BCNHPublicKey(NHPublicKeyParameters nHPublicKeyParameters) {
        this.a = nHPublicKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCNHPublicKey)) {
            return false;
        }
        return Arrays.areEqual(this.a.getPubData(), ((BCNHPublicKey) obj).a.getPubData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), this.a.getPubData()).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.NHPublicKey
    public byte[] getPublicData() {
        return this.a.getPubData();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(this.a.getPubData());
    }

    public BCNHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.a = new NHPublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getBytes());
    }
}
