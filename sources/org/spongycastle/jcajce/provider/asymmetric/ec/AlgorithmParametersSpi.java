package org.spongycastle.jcajce.provider.asymmetric.ec;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    public ECParameterSpec a;
    public String b;

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (ECParameterSpec.class.isAssignableFrom(cls) || cls == AlgorithmParameterSpec.class) {
            return this.a;
        }
        if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
            String str = this.b;
            if (str != null) {
                ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(str);
                if (namedCurveOid != null) {
                    return new ECGenParameterSpec(namedCurveOid.getId());
                }
                return new ECGenParameterSpec(this.b);
            }
            ASN1ObjectIdentifier namedCurveOid2 = ECUtil.getNamedCurveOid(EC5Util.convertSpec(this.a, false));
            if (namedCurveOid2 != null) {
                return new ECGenParameterSpec(namedCurveOid2.getId());
            }
        }
        throw new InvalidParameterSpecException(a.B2(cls, a.L("EC AlgorithmParameters cannot convert to ")));
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
            X9ECParameters A0 = AppCompatDelegateImpl.i.A0(eCGenParameterSpec.getName());
            if (A0 != null) {
                this.b = eCGenParameterSpec.getName();
                this.a = EC5Util.convertToSpec(A0);
                return;
            }
            StringBuilder L = a.L("EC curve name not recognized: ");
            L.append(eCGenParameterSpec.getName());
            throw new InvalidParameterSpecException(L.toString());
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            if (algorithmParameterSpec instanceof ECNamedCurveSpec) {
                this.b = ((ECNamedCurveSpec) algorithmParameterSpec).getName();
            } else {
                this.b = null;
            }
            this.a = (ECParameterSpec) algorithmParameterSpec;
        } else {
            StringBuilder L2 = a.L("AlgorithmParameterSpec class not recognized: ");
            L2.append(algorithmParameterSpec.getClass().getName());
            throw new InvalidParameterSpecException(L2.toString());
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "EC AlgorithmParameters ";
    }

    public boolean isASN1FormatString(String str) {
        return str == null || str.equals("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        X962Parameters x962Parameters;
        if (isASN1FormatString(str)) {
            ECParameterSpec eCParameterSpec = this.a;
            if (eCParameterSpec == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            } else {
                String str2 = this.b;
                if (str2 != null) {
                    x962Parameters = new X962Parameters(ECUtil.getNamedCurveOid(str2));
                } else {
                    org.spongycastle.jce.spec.ECParameterSpec convertSpec = EC5Util.convertSpec(eCParameterSpec, false);
                    x962Parameters = new X962Parameters(new X9ECParameters(convertSpec.getCurve(), convertSpec.getG(), convertSpec.getN(), convertSpec.getH(), convertSpec.getSeed()));
                }
            }
            return x962Parameters.getEncoded();
        }
        throw new IOException(a.c3("Unknown parameters format in AlgorithmParameters object: ", str));
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        engineInit(bArr, "ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (isASN1FormatString(str)) {
            X962Parameters instance = X962Parameters.getInstance(bArr);
            ECCurve curve = EC5Util.getCurve(BouncyCastleProvider.CONFIGURATION, instance);
            if (instance.isNamedCurve()) {
                ASN1ObjectIdentifier instance2 = ASN1ObjectIdentifier.getInstance(instance.getParameters());
                String name = ECNamedCurveTable.getName(instance2);
                this.b = name;
                if (name == null) {
                    this.b = instance2.getId();
                }
            }
            this.a = EC5Util.convertToSpec(instance, curve);
            return;
        }
        throw new IOException(a.c3("Unknown encoded parameters format in AlgorithmParameters object: ", str));
    }
}
