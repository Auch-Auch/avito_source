package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410NamedParameters;
import org.spongycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.jce.interfaces.GOST3410Params;
public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    public GOST3410PublicKeyParameterSetSpec a;
    public String b;
    public String c;
    public String d;

    public GOST3410ParameterSpec(String str, String str2, String str3) {
        GOST3410ParamSetParameters gOST3410ParamSetParameters;
        try {
            gOST3410ParamSetParameters = GOST3410NamedParameters.getByOID(new ASN1ObjectIdentifier(str));
        } catch (IllegalArgumentException unused) {
            ASN1ObjectIdentifier oid = GOST3410NamedParameters.getOID(str);
            if (oid != null) {
                str = oid.getId();
                gOST3410ParamSetParameters = GOST3410NamedParameters.getByOID(oid);
            } else {
                gOST3410ParamSetParameters = null;
            }
        }
        if (gOST3410ParamSetParameters != null) {
            this.a = new GOST3410PublicKeyParameterSetSpec(gOST3410ParamSetParameters.getP(), gOST3410ParamSetParameters.getQ(), gOST3410ParamSetParameters.getA());
            this.b = str;
            this.c = str2;
            this.d = str3;
            return;
        }
        throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
    }

    public static GOST3410ParameterSpec fromPublicKeyAlg(GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters) {
        if (gOST3410PublicKeyAlgParameters.getEncryptionParamSet() != null) {
            return new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().getId(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet().getId());
        }
        return new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().getId());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ParameterSpec)) {
            return false;
        }
        GOST3410ParameterSpec gOST3410ParameterSpec = (GOST3410ParameterSpec) obj;
        if (!this.a.equals(gOST3410ParameterSpec.a) || !this.c.equals(gOST3410ParameterSpec.c)) {
            return false;
        }
        String str = this.d;
        String str2 = gOST3410ParameterSpec.d;
        if (str == str2 || (str != null && str.equals(str2))) {
            return true;
        }
        return false;
    }

    @Override // org.spongycastle.jce.interfaces.GOST3410Params
    public String getDigestParamSetOID() {
        return this.c;
    }

    @Override // org.spongycastle.jce.interfaces.GOST3410Params
    public String getEncryptionParamSetOID() {
        return this.d;
    }

    @Override // org.spongycastle.jce.interfaces.GOST3410Params
    public String getPublicKeyParamSetOID() {
        return this.b;
    }

    @Override // org.spongycastle.jce.interfaces.GOST3410Params
    public GOST3410PublicKeyParameterSetSpec getPublicKeyParameters() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.a.hashCode() ^ this.c.hashCode();
        String str = this.d;
        return hashCode ^ (str != null ? str.hashCode() : 0);
    }

    public GOST3410ParameterSpec(String str, String str2) {
        this(str, str2, null);
    }

    public GOST3410ParameterSpec(String str) {
        this(str, CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId(), null);
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec) {
        this.a = gOST3410PublicKeyParameterSetSpec;
        this.c = CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId();
        this.d = null;
    }
}
