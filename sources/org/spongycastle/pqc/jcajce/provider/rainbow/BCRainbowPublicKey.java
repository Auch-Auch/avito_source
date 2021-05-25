package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.provider.util.KeyUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.spongycastle.util.Arrays;
public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    public short[][] a;
    public short[][] b;
    public short[] c;
    public int d;

    public BCRainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.d = i;
        this.a = sArr;
        this.b = sArr2;
        this.c = sArr3;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCRainbowPublicKey)) {
            return false;
        }
        BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) obj;
        if (this.d != bCRainbowPublicKey.getDocLength() || !RainbowUtil.equals(this.a, bCRainbowPublicKey.getCoeffQuadratic()) || !RainbowUtil.equals(this.b, bCRainbowPublicKey.getCoeffSingular()) || !RainbowUtil.equals(this.c, bCRainbowPublicKey.getCoeffScalar())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffQuadratic() {
        return this.a;
    }

    public short[] getCoeffScalar() {
        return Arrays.clone(this.c);
    }

    public short[][] getCoeffSingular() {
        short[][] sArr = new short[this.b.length][];
        int i = 0;
        while (true) {
            short[][] sArr2 = this.b;
            if (i == sArr2.length) {
                return sArr;
            }
            sArr[i] = Arrays.clone(sArr2[i]);
            i++;
        }
    }

    public int getDocLength() {
        return this.d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), new RainbowPublicKey(this.d, this.a, this.b, this.c));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = Arrays.hashCode(this.a);
        int hashCode2 = Arrays.hashCode(this.b);
        return Arrays.hashCode(this.c) + ((hashCode2 + ((hashCode + (this.d * 37)) * 37)) * 37);
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec rainbowPublicKeySpec) {
        this(rainbowPublicKeySpec.getDocLength(), rainbowPublicKeySpec.getCoeffQuadratic(), rainbowPublicKeySpec.getCoeffSingular(), rainbowPublicKeySpec.getCoeffScalar());
    }

    public BCRainbowPublicKey(RainbowPublicKeyParameters rainbowPublicKeyParameters) {
        this(rainbowPublicKeyParameters.getDocLength(), rainbowPublicKeyParameters.getCoeffQuadratic(), rainbowPublicKeyParameters.getCoeffSingular(), rainbowPublicKeyParameters.getCoeffScalar());
    }
}
